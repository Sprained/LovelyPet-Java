package com.bubbledev.lovelypet.lovelypet.dog;


import android.content.Intent;

import com.bubbledev.lovelypet.lovelypet.cat.ImageAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.cat.CatDashboard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ActivityDogs extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterDogs mAdapter;

    private ProgressBar progressBar;

    private DatabaseReference mDatabaseRef;
    private List<Dog> mDogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        mRecyclerView = findViewById(R.id.recycler_view_dogs);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progress_circular_dog);

        //Fab button dashboard dogs
        FloatingActionButton fabdogs = findViewById(R.id.fabdosdogs);
        fabdogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListaDog();
            }
        });

        //Upload dog
        mDogs = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("dogs");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    Dog dog = postSnapshot.getValue(Dog.class);
                    mDogs.add(dog);
                }

                mAdapter = new AdapterDogs(ActivityDogs.this, mDogs);
                mRecyclerView.setAdapter(mAdapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityDogs.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        //Manter tema escuro
        SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
        Toast.makeText(this, "Passou Null!", Toast.LENGTH_SHORT).show();
        if( variavelGuardar.contains("ARQUIVO_CONF")) {
            String recuperarTema = variavelGuardar.getString("ARQUIVO_CONF", "escuro");
            Toast.makeText(this, "Tema recuperado!", Toast.LENGTH_LONG).show();
            corEscolhida(recuperarTema);
        }
    }

    private void abrirListaDog() {
        Intent intent = new Intent(this, DogDashboard.class);
        startActivity(intent);
        ActivityDogs.this.finish();
    }

    private void corEscolhida(String x){
        if(x.equals("claro")){

        }else if(x.equals("escuro")){

        }
    }
}
