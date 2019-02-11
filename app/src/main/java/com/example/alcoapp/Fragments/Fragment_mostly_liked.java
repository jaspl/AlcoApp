package com.example.alcoapp.Fragments;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alcoapp.Activities.DrinkActivity;
import com.example.alcoapp.R;
import com.example.alcoapp.Singletone.MultiuseMethods;

import java.util.ArrayList;
import java.util.List;

public class Fragment_mostly_liked extends Fragment {
    private List<String> namesOfDrinks = new ArrayList();
    MultiuseMethods multiuseMethods;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        multiuseMethods = new MultiuseMethods();
        View view = inflater.inflate(R.layout.new_drink_tab, null);
        namesOfDrinks.add(" najlepsze malibu z mlekiem;malibu, mleko, slomka;1");
        namesOfDrinks.add("najlepsze mojito;limonka, szklanka, alkochol, slomka;0");
        ListView mostlyLikedDrinks = view.findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter();
        mostlyLikedDrinks.setAdapter(adapter);
        return view;
    }

    class ListAdapter extends BaseAdapter {

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
                    multiuseMethods.executeLikeButtonAndChangeBackgroung(likeButton);
                }
            });


            return view;
        }
    }

}
