package com.bubbledev.lovelypet.lovelypet.card_desaparecidos;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bubbledev.lovelypet.lovelypet.R;

import java.util.List;


public class DesaparecidosAdapter extends RecyclerView.Adapter<DesaparecidosAdapter.ViewHolderDesap> {



    private Context mContext ;
    private List<ItemAdapter> mData ;


    public DesaparecidosAdapter(Context mContext, List<ItemAdapter> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolderDesap onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_cardview_desaparecidos,parent,false);
        return new ViewHolderDesap(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDesap holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ItemActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                intent.putExtra("Characteristics", mData.get(position).getSubChar());
                // start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolderDesap extends RecyclerView.ViewHolder{

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;
        TextView sub_char;

        public ViewHolderDesap (View itemView) {
            super(itemView);
            tv_book_title = (TextView) itemView.findViewById(R.id.tituloDesap);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.imageDesap);
            cardView = (CardView) itemView.findViewById(R.id.cardLayout);
            sub_char = (TextView) itemView.findViewById(R.id.txtDescChar);
        }
    }


}
