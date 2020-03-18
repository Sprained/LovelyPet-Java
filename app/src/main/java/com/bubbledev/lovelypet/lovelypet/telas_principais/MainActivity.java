package com.bubbledev.lovelypet.lovelypet.telas_principais;

import android.content.Intent;
import androidx.annotation.NonNull;

import com.bubbledev.lovelypet.lovelypet.cat.ViewImageActivity;
import com.facebook.login.LoginManager;
import com.google.android.material.navigation.NavigationView;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bubbledev.lovelypet.lovelypet.card_desaparecidos.ActivityDesaparecidos;
import com.bubbledev.lovelypet.lovelypet.dog.ActivityDogs;
import com.bubbledev.lovelypet.lovelypet.eventos.ActivityEventos;
import com.bubbledev.lovelypet.lovelypet.sobre_a_equipe.MissaoActivity;
import com.bubbledev.lovelypet.lovelypet.tutorial.ActivityTutorial;
import com.google.firebase.auth.FirebaseAuth;
import com.bubbledev.lovelypet.lovelypet.dicas.ActivityDicas;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Array do Slider
    private int[] mImages = new int[]{
            R.mipmap.foto1, R.mipmap.foto2,
    };
    private String[] mImagesTitle = new String[]{
            "Obrigado Por Baixar =)", "Salve"
    };

    //Array Patrocinadores
    private int[] PImages = new int[]{
            R.mipmap.slide_one, R.mipmap.slidermenor2, R.mipmap.slidermenor3,
    };

    private String[] PImagesTitle = new String[]{
            "Promova seu negócio", "Entre em contato","Ajude manter o aplicativo"
    };

    //Salvar cor escolhida
    private static final String ARQUIVO_CONF = "";


    //Cores de fundo
    private LinearLayout cor_fundo;
    private LinearLayout cor_fundo2;
    private HorizontalScrollView hScroll;
    private TextView arrastarColor;
    private NavigationView nav_view;

    //Cores dos cards
    private LinearLayout card1;
    private LinearLayout card2;
    private LinearLayout card3;
    private LinearLayout card4;
    private LinearLayout card5;
    private LinearLayout card6;
    private LinearLayout card7;
    private LinearLayout card8;
    private LinearLayout card9;


    //drawer
    private DrawerLayout drawer;

    //CardViews
    private CardView btn_dog;
    private CardView btn_cat;
    private CardView btn_desap;
    private CardView btn_eventos;
    private CardView btn_dicas;

    //ImageButtons
    private ImageButton btn_cat_secondary;
    private ImageButton btn_dog_secondary;
    private ImageButton btn_desap_secondary;
    private ImageButton btn_eventos_secondary;
    private ImageButton btn_care_secondary;

    //ImageViews
    private ImageView banner_anuncio;
    private ImageView banner_doar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //CoresCards ----------------------------------------------------------------------------------------------------
        card1 = (LinearLayout) findViewById(R.id.card1);
        card2 = (LinearLayout) findViewById(R.id.card2);
        card3 = (LinearLayout) findViewById(R.id.card3);
        card4 = (LinearLayout) findViewById(R.id.card4);
        card5 = (LinearLayout) findViewById(R.id.card5);
        card6 = (LinearLayout) findViewById(R.id.card6);
        card7 = (LinearLayout) findViewById(R.id.card7);
        card8 = (LinearLayout) findViewById(R.id.card8);
        card9 = (LinearLayout) findViewById(R.id.card9);

        //Cores fundo ----------------------------------------------------------------------------------------------------
        nav_view = (NavigationView) findViewById(R.id.nav_viewId);
        cor_fundo = (LinearLayout) findViewById(R.id.linearColor);
        cor_fundo2 = (LinearLayout) findViewById(R.id.linearColor2);
        hScroll = (HorizontalScrollView) findViewById(R.id.hScrollId);
        arrastarColor = (TextView) findViewById(R.id.arrastarId);



        //CardViews ----------------------------------------------------------------------------------------------------
        btn_cat = (CardView) findViewById(R.id.btn_gatos);
        btn_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityGatos();
            }
        });

        btn_dog = (CardView) findViewById(R.id.btn_dogs);
        btn_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityRecycler();
            }
        });

        btn_desap = (CardView) findViewById(R.id.btn_desaparecidos);
        btn_desap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDesapa();
            }
        });

        btn_eventos = (CardView) findViewById(R.id.btn_eventos);
        btn_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityEventos();
            }
        });

        btn_dicas = (CardView) findViewById(R.id.btn_care);
        btn_dicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityDicas();
            }
        });


        //ImageButtons --------------------------------------------------------------------------------------------------
        btn_cat_secondary = (ImageButton) findViewById(R.id.btn_gatos_secondary);
        btn_cat_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityGatos();
            }
        });

        btn_dog_secondary = (ImageButton) findViewById(R.id.btn_dogs_secondary);
        btn_dog_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityRecycler();
            }
        });

        btn_desap_secondary = (ImageButton) findViewById(R.id.btn_desaparecidos_secondary);
        btn_desap_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDesapa();
            }
        });

        btn_eventos_secondary = (ImageButton) findViewById(R.id.btn_eventos_secondary);
        btn_eventos_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityEventos();
            }
        });

        btn_care_secondary = (ImageButton) findViewById(R.id.btn_dicas_secondary);
        btn_care_secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityDicas();
            }
        });


        //ImageViews -----------------------------------------------------------------------------------------------------
        banner_anuncio = (ImageView) findViewById(R.id.banner_doacao_animais);
        banner_anuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Doe para casas de adoção!", Toast.LENGTH_LONG).show();
            }
        });

        banner_doar = (ImageView) findViewById(R.id.banner_doar);
        banner_doar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corEscolhida("escuro");
                Toast.makeText(MainActivity.this, "Nos ajude a melhorar!", Toast.LENGTH_LONG).show();
            }
        });

//Slider 1
        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, mImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

//Menu Lateral
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawerId);
        NavigationView navigationView = findViewById(R.id.nav_viewId);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
        if (savedInstanceState == null) {
            Toast.makeText(this, "Passou Null!", Toast.LENGTH_SHORT).show();
            if( variavelGuardar.contains("ARQUIVO_CONF")) {
                String recuperarTema = variavelGuardar.getString("ARQUIVO_CONF", "escuro");
                Toast.makeText(this, "Tema recuperado!", Toast.LENGTH_LONG).show();
                corEscolhida(recuperarTema);}
        }
    }



    //btn-------------------------------------------------------------------


        private void abrirActivityGatos () {
            Intent intent = new Intent(this, ViewImageActivity.class);
            startActivity(intent);
        }

        private void abrirDesapa () {
            Intent intent = new Intent(this, ActivityDesaparecidos.class);
            startActivity(intent);
        }

        public void abrirActivityRecycler () {
            Intent intent = new Intent(this, ActivityDogs.class);
            startActivity(intent);
        }
        public void abrirActivityEventos () {
            Intent intent = new Intent(this, ActivityEventos.class);
            startActivity(intent);
        }

        public void abrirActivityDicas(){
            Intent intent = new Intent(this, ActivityDicas.class);
            startActivity(intent);
        }


    //continuação do menu-------------------------------------------------------------------
    @Override //falta criar as fragments
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mudarCorClaro:

                mudarSalvar("claro");

                break;

            case R.id.mudarCorEscuro:

                mudarSalvar("escuro");

                break;

            case R.id.profile:
                Intent perfil = new Intent(this, Perfil.class);
                startActivity(perfil);
                break;

            case R.id.info:
                Intent intent = new Intent(this, MissaoActivity.class);
                startActivity(intent);
                break;

            case R.id.termos_uso:
                Intent uso = new Intent(this, ActivityTutorial.class);
                startActivity(uso);
                break;

            case R.id.termos_privacidade:
                Intent privado = new Intent(this, ActivityTutorial.class);
                startActivity(privado);
                break;

            case R.id.tutorial:
                Intent tuto = new Intent(this, ActivityTutorial.class);
                startActivity(tuto);
                break;

            case R.id.compartilhe:
                Intent shareintent = new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String sharebody = "Teste de compartilhamento";
                String sharesub = "Compartilhado Pelo LovelyPet";
                shareintent.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                shareintent.putExtra(Intent.EXTRA_TEXT,sharesub);
                startActivity(Intent.createChooser(shareintent, "Compartilhar Usando:"));
                break;

            case R.id.doacao:
                Toast.makeText(this, "Doação", Toast.LENGTH_SHORT).show();
                break;

            case R.id.exit_session:
                logOut();
                Intent exit = new Intent(this, ActivityLogin.class);
                startActivity(exit);
                break;

            case R.id.loja:
                Toast.makeText(this, "Disponível em breve", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void logOut(){
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        onDestroy();
    }


    private void corEscolhida(String x){
        if((x == "claro") || (x.equals("claro"))){

            cor_fundo.setBackgroundColor(Color.parseColor("#fafafa"));
            hScroll.setBackgroundColor(Color.parseColor("#fafafa"));
            cor_fundo2.setBackgroundColor(Color.parseColor("#fafafa"));
            arrastarColor.setBackgroundColor(Color.parseColor("#fafafa"));
            nav_view.setBackgroundColor(Color.parseColor("#fafafa"));


            card1.setBackgroundColor(Color.parseColor("#ffffff"));
            card2.setBackgroundColor(Color.parseColor("#ffffff"));
            card3.setBackgroundColor(Color.parseColor("#ffffff"));
            card4.setBackgroundColor(Color.parseColor("#ffffff"));
            card5.setBackgroundColor(Color.parseColor("#ffffff"));
            card6.setBackgroundColor(Color.parseColor("#ffffff"));
            card7.setBackgroundColor(Color.parseColor("#ffffff"));
            card8.setBackgroundColor(Color.parseColor("#ffffff"));
            card9.setBackgroundColor(Color.parseColor("#ffffff"));

            Toast.makeText(this,"Tema claro aplicado!", Toast.LENGTH_SHORT).show();

            Menu menu = nav_view.getMenu();
            menu.findItem(R.id.mudarCorClaro).setVisible(false);
            menu.findItem(R.id.mudarCorEscuro).setVisible(true);



        }else if((x == "escuro") || (x.equals("escuro"))){

            cor_fundo.setBackgroundColor(Color.parseColor("#363636"));
            hScroll.setBackgroundColor(Color.parseColor("#363636"));
            cor_fundo2.setBackgroundColor(Color.parseColor("#363636"));
            arrastarColor.setBackgroundColor(Color.parseColor("#363636"));
            nav_view.setBackgroundColor(Color.parseColor("#363636"));


            card1.setBackgroundColor(Color.parseColor("#515151"));
            card2.setBackgroundColor(Color.parseColor("#515151"));
            card3.setBackgroundColor(Color.parseColor("#515151"));
            card4.setBackgroundColor(Color.parseColor("#515151"));
            card5.setBackgroundColor(Color.parseColor("#515151"));
            card6.setBackgroundColor(Color.parseColor("#515151"));
            card7.setBackgroundColor(Color.parseColor("#515151"));
            card8.setBackgroundColor(Color.parseColor("#515151"));
            card9.setBackgroundColor(Color.parseColor("#515151"));

            Toast.makeText(this,"Tema escuro aplicado!", Toast.LENGTH_SHORT).show();

            Menu menu = nav_view.getMenu();
            menu.findItem(R.id.mudarCorEscuro).setVisible(false);
            menu.findItem(R.id.mudarCorClaro).setVisible(true);

        }

    }

    private void mudar(){
        Menu menu = nav_view.getMenu();
        menu.findItem(R.id.mudarCorEscuro).setVisible(false);
    }

    private void mudarSalvar(String y){
        if (y == "claro"){
            SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
            SharedPreferences.Editor variavelEditor = variavelGuardar.edit();
            String corEscolhida =  "claro";
            variavelEditor.putString("ARQUIVO_CONF", corEscolhida);
            variavelEditor.commit();
            Toast.makeText(this, "Tema claro salvo!", Toast.LENGTH_SHORT).show();
            corEscolhida("claro");

        }else if(y == "escuro"){
            SharedPreferences variavelGuardar = getSharedPreferences("ARQUIVO_CONF", 0);
            SharedPreferences.Editor variavelEditor = variavelGuardar.edit();
            String corEscolhida =  "escuro";
            variavelEditor.putString("ARQUIVO_CONF", corEscolhida);
            variavelEditor.commit();
            Toast.makeText(this, "Tema escuro salvo!", Toast.LENGTH_SHORT).show();
            corEscolhida("escuro");

        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
