package com.bubbledev.lovelypet.lovelypet.telas_principais;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.bubbledev.lovelypet.lovelypet.R;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar linearBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //Função para carregar a navbar
        linearBar = (ProgressBar) findViewById(R.id.linearBar);

        //Atributos da barra de loading
        linearBar.setProgress(0);
        linearBar.setMax(100);
        linearBar.setVisibility(View.GONE);

        //Chamando e executando a função da barra de Loading
        new AsyncLinear().execute();

        //Função para deixar a tela em Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Função do tempo da tela de splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), ActivityLogin.class));
                finish();
            }
        }, 5000);

    }


    //Funcão da barra de loading
    public class AsyncLinear extends AsyncTask<Void, Integer, Void>{

        //Função que excuta antes da função principal para settar valores
        @Override
        protected void onPreExecute() {
            linearBar.setVisibility(View.VISIBLE);
        }

        //Função que é executada em background para atribuir valor para a barra de loading
        @Override
        protected Void doInBackground(Void... voids) {

            for(int i = 0; i< 100; i++){

                try{
                    publishProgress(i + 20);
                    Thread.sleep(50);
                }

                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

            return null;
        }


        //Função que é frequentemente executada para atualizar a barra de progresso
        @Override
        protected void onProgressUpdate(Integer... values) {
            linearBar.setProgress(values[0]);
            linearBar.setSecondaryProgress(values[0] + 60);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            linearBar.setProgress(View.GONE);
        }
    }
}
