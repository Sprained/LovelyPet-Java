package com.bubbledev.lovelypet.lovelypet.tutorial;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bubbledev.lovelypet.lovelypet.R;

public class TutorialAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public TutorialAdapter (Context context){
        this.context = context;
    }
    //array
    public int[] imageTutorials = {
            R.mipmap.ico_bone,
            R.mipmap.ico_novelo,
            R.mipmap.ico_clinica,
            R.mipmap.ico_tips
    };
    public String[] headTutorials = {
            "CÃES",
            "GATOS",
            "CUIDADOS",
            "DICAS"
    };
    public String[] subTutorials = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dignissim felis non ligula efficitur sodales. Nullam nisi quam, tincidunt sed congue in, egestas quis ex.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dignissim felis non ligula efficitur sodales. Nullam nisi quam, tincidunt sed congue in, egestas quis ex.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dignissim felis non ligula efficitur sodales. Nullam nisi quam, tincidunt sed congue in, egestas quis ex.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus dignissim felis non ligula efficitur sodales. Nullam nisi quam, tincidunt sed congue in, egestas quis ex."
    };

    @Override
    public int getCount() {
        return headTutorials.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService (context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.tutorial_layout, container, false);

        ImageView imageTutorial = (ImageView) view.findViewById(R.id.imageTutorial);
        TextView headTutorial = (TextView) view.findViewById(R.id.headTutorial);
        TextView subTutorial = (TextView) view.findViewById(R.id.subTutorial);

        imageTutorial.setImageResource(imageTutorials[position]);
        headTutorial.setText(headTutorials[position]);
        subTutorial.setText(subTutorials[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
