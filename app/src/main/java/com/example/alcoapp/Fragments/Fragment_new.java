package com.example.alcoapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alcoapp.Activities.DrinkActivity;
import com.example.alcoapp.R;
import com.example.alcoapp.Singletone.MultiuseMethods;

import java.util.ArrayList;
import java.util.List;

public class Fragment_new extends Fragment {
    private List<String> namesOfDrinks = new ArrayList();
MultiuseMethods multiuseMethods = new MultiuseMethods();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_drink_tab, container, false);
        CustomAdapter customAdapter = new CustomAdapter();
        namesOfDrinks.add("malibu z mlekiem;malibu, mleko, slomka;1");
        namesOfDrinks.add("mojito;limonka, szklanka, alkochol, slomka;0");

        //TODO dll from server and add to list
        ListView listView = v.findViewById(R.id.list);
        listView.setAdapter(customAdapter);
        return v;
    }


    public class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return namesOfDrinks.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.single_new_drink_layout, null);
            String[] drinkinfo = multiuseMethods.splitSrting(namesOfDrinks.get(position));
            ImageView image = view.findViewById(R.id.imageView);
            TextView name = view.findViewById(R.id.name);
            TextView ingredients = view.findViewById(R.id.ingredients);
            name.setText(drinkinfo[0]);
            ingredients.setText(drinkinfo[1]);
            final ImageButton likeButton = view.findViewById(R.id.likeButton);
            multiuseMethods.setLikeButtImage(drinkinfo[2], likeButton);


            image.setImageResource(R.drawable.ic_launcher_background);
            image.getLayoutParams().height = 150;
            image.getLayoutParams().width = 150;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.fawourite_tab_name + "" + position, Toast.LENGTH_LONG).show();
                    Intent drinkActivity = new Intent(getContext(), DrinkActivity.class);
                    getContext().startActivity(drinkActivity);
                    //TODO post data to serwer
                }
            });
            likeButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext().getApplicationContext(), "u liked it" + position, Toast.LENGTH_SHORT).show();
                    executeLikeButtonAndChangeBackgroung(likeButton);
                }
            });

            return view;
        }
    }

    private String[] splitSrting(String drinkInfo) {
        return drinkInfo.split(";");
    }

    private void executeLikeButtonAndChangeBackgroung(ImageButton likeButton) {
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

    private void setLikeButtImage(String drinks, ImageButton likeButton) {
        if (drinks .equals("1")) {
            likeButton.setTag(1);
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow_filled);
        } else if (drinks.equals("0")) {
            likeButton.setTag(0);
            likeButton.setBackgroundResource(R.drawable.heart_icon_red_hollow);
        }
    }
}

