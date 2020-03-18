package com.bubbledev.lovelypet.lovelypet.dog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bubbledev.lovelypet.lovelypet.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDogs extends RecyclerView.Adapter<AdapterDogs.ViewHolder>{
    private Context mContext;
    private List<Dog> mDogs;

    public AdapterDogs(Context context, List<Dog> dogs){
        mContext = context;
        mDogs = dogs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(mContext).inflate(R.layout.adocao_dog, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Dog dogCur = mDogs.get(i);
        viewHolder.img_description_dogs.setText(dogCur.getImgName());
        Picasso.get()
                .load(dogCur.getImgUrl())
                .placeholder(R.drawable.imagepreview)
                .resize(600, 400)
                .centerCrop()
                .into(viewHolder.image_view_dogs);
    }

    @Override
    public int getItemCount() {
        return mDogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView img_description_dogs;
        public ImageView image_view_dogs;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            img_description_dogs = itemView.findViewById(R.id.img_description_dogs);
            image_view_dogs = itemView.findViewById(R.id.image_view_dogs);
        }
    }
}
