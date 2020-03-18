package com.bubbledev.lovelypet.lovelypet.cat;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubbledev.lovelypet.lovelypet.R;
import com.bumptech.glide.Glide;

public class PopupCat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_cat);
        getIncomingIntent();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

    }

    private void getIncomingIntent(){


        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("image_sub")){


            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageSub = getIntent().getStringExtra("image_sub");

            setImage(imageUrl, imageName, imageSub);
        }
    }


    private void setImage(String imageUrl, String imageName, String imageSub){


        TextView sub = findViewById(R.id.descricao_popup_cats);
        sub.setText(imageSub);

        TextView name = findViewById(R.id.titulo_popup_cats);
        name.setText(imageName);

        ImageView foto = findViewById(R.id.image_popup_cats);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(foto);
    }

}
