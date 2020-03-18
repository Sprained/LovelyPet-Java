package com.bubbledev.lovelypet.lovelypet.dog;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.cat.Upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class DogDashboard extends AppCompatActivity {
    private static final int CHOOSE_IMAGE = 1;

    public ImageButton imgPreview;
    private Button btnUploadImage, chooseImage, cancelarCadastro;
    private EditText imgDescription, dogDescription, dogRaca, dogIdade;
    private ProgressBar uploadProgress;

    private Uri imgUrl;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_dashboard);

        //ids tela
        uploadProgress = findViewById(R.id.barraDogs);
        cancelarCadastro = findViewById(R.id.btnCancelarCadastroDogs);
        chooseImage = findViewById(R.id.btn_galeria_dogs);
        dogRaca = findViewById(R.id.editTextRacaDog);
        dogIdade = findViewById(R.id.editTextIdadeDog);
        dogDescription = findViewById(R.id.editTextDescDog);
        btnUploadImage = findViewById(R.id.btnAddCadastroDogs);
        imgDescription = findViewById(R.id.editTextNomeCaes);
        imgPreview = findViewById(R.id.imgCadastrarDogs);

        mStorageRef = FirebaseStorage.getInstance().getReference("dogs");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("dogs");

        cancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DogDashboard.this, ActivityDogs.class);
                startActivity(intent);
            }
        });

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(DogDashboard.this, "Upload in progress", Toast.LENGTH_LONG).show();
                }
                else{
                    uploadDog();
                }
            }
        });

        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChoose();
            }
        });
    }

    private void showFileChoose(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, CHOOSE_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
            imgUrl = data.getData();

            Picasso.get().load(imgUrl).into(imgPreview);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getMimeTypeFromExtension(contentResolver.getType(uri));
    }

    private void uploadDog(){
        if(imgUrl != null){
            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(imgUrl));

            mUploadTask = fileReference.putFile(imgUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            uploadProgress.setProgress(0);
                        }
                    }, 500);
                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Dog dog = new Dog(
                                    imgDescription.getText().toString().trim(),
                                    uri.toString(),
                                    dogDescription.getText().toString().trim(),
                                    dogRaca.getText().toString().trim(),
                                    dogIdade.getText().toString().trim()
                            );

                            String dogID = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(dogID).setValue(dog);
                            Toast.makeText(DogDashboard.this, "Upload successfully", Toast.LENGTH_LONG).show();
                            imgPreview.setImageResource(R.drawable.imagepreview);
                            imgDescription.setText("");
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DogDashboard.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    uploadProgress.setProgress((int) progress);
                }
            });

            //resete tela anterior
        }
        else{
            Toast.makeText(DogDashboard.this,"No file selected", Toast.LENGTH_LONG).show();
        }
    }
}
