package com.bubbledev.lovelypet.lovelypet.eventos;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;


public class ItemEventosActivity extends AppCompatActivity {
    private TextView tvtitleeventos,tvdescriptioneventos, tvloceventos;
    private ImageView imgeventos;
    private LinearLayout cor_fundo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_eventos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        cor_fundo = (LinearLayout)findViewById(R.id.linearColor);

        tvtitleeventos = (TextView)findViewById(R.id.txttitleeventos);
        tvdescriptioneventos = (TextView)findViewById(R.id.txtdesceventos);
        tvloceventos = (TextView)findViewById(R.id.txtloceventos);
        imgeventos = (ImageView)findViewById(R.id.eventosthumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Loc = intent.getExtras().getString("Locals");
        int image = intent.getExtras().getInt("Thumbnail") ;

        tvtitleeventos.setText(Title);
        tvdescriptioneventos.setText(Description);
        tvloceventos.setText(Loc);
        imgeventos.setImageResource(image);

        SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
        Toast.makeText(this, "Passou Null!", Toast.LENGTH_SHORT).show();
        if( variavelGuardar.contains("ARQUIVO_CONF")) {
            String recuperarTema = variavelGuardar.getString("ARQUIVO_CONF", "escuro");
            Toast.makeText(this, "Tema recuperado!", Toast.LENGTH_LONG).show();
            corEscolhida(recuperarTema);}

    }
    private void corEscolhida(String x){
        if(x.equals("claro")){

            cor_fundo.setBackgroundColor(Color.parseColor("#fafafa"));



        }else if(x.equals("escuro")){

            cor_fundo.setBackgroundColor(Color.parseColor("#363636"));

        }
    }

    private void carregarTema(String x){


    }
}
