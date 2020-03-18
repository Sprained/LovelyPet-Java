package com.bubbledev.lovelypet.lovelypet.eventos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bubbledev.lovelypet.lovelypet.R;
import java.util.ArrayList;
import java.util.List;


public class ActivityEventos extends AppCompatActivity {

    List<ItemEventosAdapter> lstItemEventosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Eventos");

        lstItemEventosAdapter = new ArrayList<>();
        lstItemEventosAdapter.add(new ItemEventosAdapter("Dog Party","Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Sapien in monti palavris qui num significa nadis i pareci latim. Delegadis gente finis, bibendum egestas augue arcu ut est.","lá" ,R.mipmap.evento));
        lstItemEventosAdapter.add(new ItemEventosAdapter("Tomorowlambe","Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Sapien in monti palavris qui num significa nadis i pareci latim. Delegadis gente finis, bibendum egestas augue arcu ut est.","lá" ,R.mipmap.evento1));
        lstItemEventosAdapter.add(new ItemEventosAdapter("Lolapabicho","Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Sapien in monti palavris qui num significa nadis i pareci latim. Delegadis gente finis, bibendum egestas augue arcu ut est.","lá" , R.mipmap.evento2));
        lstItemEventosAdapter.add(new ItemEventosAdapter("Rock in mia","Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Sapien in monti palavris qui num significa nadis i pareci latim. Delegadis gente finis, bibendum egestas augue arcu ut est.","lá" , R.mipmap.evento3));
        lstItemEventosAdapter.add(new ItemEventosAdapter("Chevrolet rawr","Mé faiz elementum girarzis, nisi eros vermeio. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Sapien in monti palavris qui num significa nadis i pareci latim. Delegadis gente finis, bibendum egestas augue arcu ut est.","lá" , R.mipmap.evento4));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerv_view_eventos);
        EventosAdapter ViewHoldereventos = new EventosAdapter ( this, lstItemEventosAdapter);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(ViewHoldereventos);
    }
}
