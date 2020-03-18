package com.bubbledev.lovelypet.lovelypet.tutorial;

import android.content.Intent;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.telas_principais.MainActivity;

public class ActivityTutorial extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mItenslayout;
    private TextView[] mItens;
    private ImageButton proximo;
    private ImageButton voltar;

    private TutorialAdapter tutorialAdapter;
    private int mPaginAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        proximo = (ImageButton) findViewById(R.id.proximo);
        //voltar = (ImageButton) findViewById(R.id.voltar);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mPaginAtual + 1);
            }
        });

        /*voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mPaginAtual - 1);
            }
        });*/

        mViewPager = (ViewPager) findViewById(R.id.tutorialViewPager);
        mItenslayout = (LinearLayout) findViewById(R.id.itensTutorial);

        tutorialAdapter = new TutorialAdapter(this);
        mViewPager.setAdapter(tutorialAdapter);

        addItensIndicador(0);
        mViewPager.addOnPageChangeListener(viewlistener);
    }

    public void addItensIndicador(int posicao) {
        mItens = new TextView[4];
        mItenslayout.removeAllViews();

        for (int i = 0; i < mItens.length; i++) {
            mItens[i] = new TextView(this);
            mItens[i].setText(Html.fromHtml("&#8226;"));
            mItens[i].setTextSize(35);
            mItens[i].setTextSize(getResources().getColor(R.color.colorPrimaryDark));
            mItenslayout.addView(mItens[i]);
        }
        if (mItens.length > 0){
            mItens[posicao].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addItensIndicador(i);

            mPaginAtual = i;

            if (mItens.length <= 3 ){
                proximo.setEnabled(false);
                proximo.setVisibility(View.INVISIBLE);
                //voltar.setEnabled(false);
                //voltar.setVisibility(View.INVISIBLE);

            } else if (i == mItens.length - 1){
                proximo.setEnabled(true);
                proximo.setVisibility(View.VISIBLE);
                //voltar.setEnabled(true);
                //voltar.setVisibility(View.VISIBLE);


                proximo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        abrirActivityMain();
                        Toast.makeText(ActivityTutorial.this,"Tutorial disponível no Menu Lateral" , Toast.LENGTH_LONG).show();
                    }
                });
            }

            else {
                proximo.setEnabled(true);
                proximo.setVisibility(View.VISIBLE);
                //voltar.setEnabled(true);
                //voltar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    public void abrirActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
