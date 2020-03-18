package com.bubbledev.lovelypet.lovelypet.eventos;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bubbledev.lovelypet.lovelypet.R;


import java.util.List;


public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.ViewHolderEventos> {
    private Context nContext ;
    private List<ItemEventosAdapter> nData ;

    public EventosAdapter(Context mContext, List<ItemEventosAdapter> mData) {
        this.nContext = mContext;
        this.nData = mData;

    }
    @NonNull
    @Override
    public EventosAdapter.ViewHolderEventos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(nContext);
        view = mInflater.inflate(R.layout.item_cardview_eventos,parent,false);
        return new EventosAdapter.ViewHolderEventos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EventosAdapter.ViewHolderEventos holder, final int position) {

        holder.tv_book_title_evento.setText(nData.get(position).getTitle());
        holder.img_book_thumbnail_evento.setImageResource(nData.get(position).getThumbnail());
        holder.tv_book_loc.setText(nData.get(position).getLocals());
        holder.cardView_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(nContext,ItemEventosActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",nData.get(position).getTitle());
                intent.putExtra("Description",nData.get(position).getDescription());
                intent.putExtra("Locals",nData.get(position).getLocals());
                intent.putExtra("Thumbnail",nData.get(position).getThumbnail());
                // start the activity
                nContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nData.size();
    }

    public class ViewHolderEventos extends RecyclerView.ViewHolder{
        TextView tv_book_title_evento;
        TextView tv_book_loc;
        ImageView img_book_thumbnail_evento;
        CardView cardView_evento ;
        public ViewHolderEventos(@NonNull View itemView) {
            super(itemView);
            tv_book_title_evento = (TextView) itemView.findViewById(R.id.tituloEvento) ;
            img_book_thumbnail_evento = (ImageView) itemView.findViewById(R.id.imageEvento);
            tv_book_loc = (TextView) itemView.findViewById(R.id.locEvento);
            cardView_evento = (CardView) itemView.findViewById(R.id.cardLayoutEventos);


        }
    }
}
