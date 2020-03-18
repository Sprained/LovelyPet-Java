package com.bubbledev.lovelypet.lovelypet.card_desaparecidos;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.dashboard.DesapDashboard;

import java.util.ArrayList;
import java.util.List;

public class ActivityDesaparecidos extends AppCompatActivity {

    private RelativeLayout cor_fundo;

    //vars

    List<ItemAdapter> lstItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desaparecidos);

        cor_fundo = findViewById(R.id.relativeLayoutId);

        FloatingActionButton fabgatos = findViewById(R.id.fabdosgatos);
        fabgatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListaDesap();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Desaparecidos");

        lstItemAdapter = new ArrayList<>();
        lstItemAdapter.add(new ItemAdapter("Margarida","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor. ",R.drawable.desapa1, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));

        lstItemAdapter.add(new ItemAdapter("Belinha","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor. ",R.drawable.desapa2, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));

        lstItemAdapter.add(new ItemAdapter("Fifi","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor.",R.drawable.desapa6, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));

        lstItemAdapter.add(new ItemAdapter("Bolinho","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor.",R.drawable.desapa4, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));

        lstItemAdapter.add(new ItemAdapter("Mortadela","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor.",R.drawable.desapa5, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));

        lstItemAdapter.add(new ItemAdapter("Big","Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta. Mauris nec dolor in eros commodo tempor.",R.drawable.desapa3, "Posuere libero varius. Nullam a nisl ut ante blandit hendrerit."));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerv_view_desaparecidos);
        DesaparecidosAdapter ViewHolderDesap = new DesaparecidosAdapter ( this, lstItemAdapter);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(ViewHolderDesap);

        SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
        Toast.makeText(this, "Passou Null!", Toast.LENGTH_SHORT).show();
        if( variavelGuardar.contains("ARQUIVO_CONF")) {
            String recuperarTema = variavelGuardar.getString("ARQUIVO_CONF", "escuro");
            Toast.makeText(this, "Tema recuperado!", Toast.LENGTH_LONG).show();
            corEscolhida(recuperarTema);
        }


    }

    private void abrirListaDesap() {
        Intent intent = new Intent(this, DesapDashboard.class);
        startActivity(intent);
    }
    //Aplicar cor fundo
    private void corEscolhida(String x){
        if (x.equals("claro")) {

            cor_fundo.setBackgroundColor(Color.parseColor("#fafafa"));


        } else if (x.equals("escuro")) {

            cor_fundo.setBackgroundColor(Color.parseColor("#363636"));

        }
    }
}
