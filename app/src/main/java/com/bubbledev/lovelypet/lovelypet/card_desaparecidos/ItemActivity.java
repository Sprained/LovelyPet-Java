package com.bubbledev.lovelypet.lovelypet.card_desaparecidos;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubbledev.lovelypet.lovelypet.R;

public class ItemActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription;
    private ImageView img;
    private TextView tvSubChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_desaparecidos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Desaparecidos");



        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        img = (ImageView) findViewById(R.id.bookthumbnail);
        tvSubChar = (TextView) findViewById(R.id.txtDescChar);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;
        String SubChar = intent.getExtras().getString("Characteristics");


        // Setting values
        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
        tvSubChar.setText(SubChar);
    }
}
