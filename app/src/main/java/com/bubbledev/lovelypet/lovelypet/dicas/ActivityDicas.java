package com.bubbledev.lovelypet.lovelypet.dicas;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bubbledev.lovelypet.lovelypet.R;

public class ActivityDicas extends AppCompatActivity {

    //Cor fundo
    private ScrollView cor_fundo;
    private LinearLayout cor_linear1;
    private LinearLayout cor_linear2;

    //Cor fundo cards
    private LinearLayout card1;
    private LinearLayout card2;
    private LinearLayout card3;
    private LinearLayout card4;
    private LinearLayout card5;
    private LinearLayout card6;
    private LinearLayout card7;
    private LinearLayout card8;
    private LinearLayout card9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);

        cor_fundo = findViewById(R.id.ScrollId);
        cor_linear1 = findViewById(R.id.linearColor1);
        cor_linear2 = findViewById(R.id.linearColor2);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);

        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);

        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        card9 = findViewById(R.id.card9);


        SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
        Toast.makeText(this, "Passou Null!", Toast.LENGTH_SHORT).show();
        if( variavelGuardar.contains("ARQUIVO_CONF")) {
            String recuperarTema = variavelGuardar.getString("ARQUIVO_CONF", "escuro");
            Toast.makeText(this, "Tema recuperado!", Toast.LENGTH_LONG).show();
            corEscolhida(recuperarTema);
        }

    }

    //Aplicar cor fundo
    private void corEscolhida(String x){
            if (x.equals("claro")) {

                cor_fundo.setBackgroundColor(Color.parseColor("#fafafa"));
                cor_linear1.setBackgroundColor(Color.parseColor("#ffffff"));
                cor_linear2.setBackgroundColor(Color.parseColor("#fafafa"));

                card1.setBackgroundColor(Color.parseColor("#ffffff"));
                card2.setBackgroundColor(Color.parseColor("#ffffff"));
                card3.setBackgroundColor(Color.parseColor("#ffffff"));

                card4.setBackgroundColor(Color.parseColor("#ffffff"));
                card5.setBackgroundColor(Color.parseColor("#ffffff"));
                card6.setBackgroundColor(Color.parseColor("#ffffff"));

                card7.setBackgroundColor(Color.parseColor("#ffffff"));
                card8.setBackgroundColor(Color.parseColor("#ffffff"));
                card9.setBackgroundColor(Color.parseColor("#ffffff"));



            } else if (x.equals("escuro")) {

                cor_fundo.setBackgroundColor(Color.parseColor("#363636"));
                cor_linear1.setBackgroundColor(Color.parseColor("#515151"));
                cor_linear2.setBackgroundColor(Color.parseColor("#363636"));

                card1.setBackgroundColor(Color.parseColor("#515151"));
                card2.setBackgroundColor(Color.parseColor("#515151"));
                card3.setBackgroundColor(Color.parseColor("#515151"));

                card4.setBackgroundColor(Color.parseColor("#515151"));
                card5.setBackgroundColor(Color.parseColor("#515151"));
                card6.setBackgroundColor(Color.parseColor("#515151"));

                card7.setBackgroundColor(Color.parseColor("#515151"));
                card8.setBackgroundColor(Color.parseColor("#515151"));
                card9.setBackgroundColor(Color.parseColor("#515151"));

            }
        }
    }
