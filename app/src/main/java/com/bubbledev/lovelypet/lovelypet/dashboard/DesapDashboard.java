package com.bubbledev.lovelypet.lovelypet.dashboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.bubbledev.lovelypet.lovelypet.R;

public class DesapDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desap_dashboard);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastrar Animal Desaparecido");
    }
}
