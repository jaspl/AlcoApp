package com.example.alcoapp.Singletone;

import android.widget.ImageButton;

import com.example.alcoapp.R;

public class MultiuseMethods {

    public static MultiuseMethods instance;

    public static void MultiuseMethods() {

    }

    public static MultiuseMethods getInstance() {
        if (instance==null){
            instance =new MultiuseMethods();

        }
        return instance;
    }
    public String[] splitSrting(String drinkInfo) {
        return drinkInfo.split(";");
    }

    public void executeLikeButtonAndChangeBackgroung(ImageButton likeButton) {
        if ((Integer) likeButton.getTag() == 0) {
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow_filled);
            //TODO post to serwer info about with update database
            likeButton.setTag(1);
        } else if ((Integer) likeButton.getTag() == 1) {
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow);
            likeButton.setTag(0);
        }
        //TODO adding to list whitch are favoirites

    }

    public void setLikeButtImage(String drinks, ImageButton likeButton) {
        if (drinks .equals("1")) {
            likeButton.setTag(1);
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow_filled);
        } else if (drinks.equals("0")) {
            likeButton.setTag(0);
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow);
        }
    }
}
