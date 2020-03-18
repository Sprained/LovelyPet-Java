package com.bubbledev.lovelypet.lovelypet.sobre_a_equipe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.bubbledev.lovelypet.lovelypet.R;

public class MissaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missao);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Sobre o aplicativo");
    }
}
