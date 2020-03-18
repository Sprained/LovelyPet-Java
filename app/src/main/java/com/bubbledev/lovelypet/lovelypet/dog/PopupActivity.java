package com.bubbledev.lovelypet.lovelypet.dog;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bumptech.glide.Glide;

public class PopupActivity extends AppCompatActivity {

    private static final String TAG = "PopupActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        Log.d(TAG, "onCreate: inicio.");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checando intents");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("image_sub")){
            Log.d(TAG, "getIncomingIntent: encontrando intents");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageSub = getIntent().getStringExtra("image_sub");

            setImage(imageUrl, imageName, imageSub);
        }
    }


    private void setImage(String imageUrl, String imageName, String imageSub){
        Log.d(TAG, "setImage: setando imagens e nomes");

        TextView sub = findViewById(R.id.descricao_popup);
        sub.setText(imageSub);

        TextView name = findViewById(R.id.titulo_popup);
        name.setText(imageName);

        ImageView foto = findViewById(R.id.image_popup);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(foto);
    }

}