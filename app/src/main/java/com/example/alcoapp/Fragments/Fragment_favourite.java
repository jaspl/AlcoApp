package com.example.alcoapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alcoapp.Activities.DrinkActivity;
import com.example.alcoapp.Activities.MainActivity;
import com.example.alcoapp.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_favourite extends Fragment {

    private List<String> namesOfDrinks = new ArrayList();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_drink_tab, container, false);
        namesOfDrinks.add(MainActivity.nameMalibu +";malibu, mleko, slomka");
        namesOfDrinks.add("mojito;limonka, szklanka, alkochol, slomka");
        CustomAdapter customAdapter = new CustomAdapter();
        ListView listView = v.findViewById(R.id.list);
        listView.setAdapter(customAdapter);
        return v;
    }

    class CustomAdapter extends BaseAdapter {


        int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

        @Override
        public int getCount() {
            return images.length;
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
            View view = getLayoutInflater().inflate(R.layout.single_drink_layout, null);
            String[] drinkinfo = splitSrting(namesOfDrinks.get(position));
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView name = view.findViewById(R.id.name);
            TextView ingredient = view.findViewById(R.id.ingredients);
            name.setText(drinkinfo[0]);
            ingredient.setText(drinkinfo[1]);
            imageView.setImageResource(R.drawable.ic_launcher_background);
            imageView.getLayoutParams().width=150;
            imageView.getLayoutParams().height=150;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext().getApplicationContext(), R.string.fawourite_tab_name + "" + position, Toast.LENGTH_LONG).show();
                    Intent drinkActivity = new Intent(getContext(), DrinkActivity.class);
                    getContext().startActivity(drinkActivity);
                    //TODO post data to a serwer

                }
            });

            return view;
        }
    }
    private String[] splitSrting(String drinkInfo) {
        return drinkInfo.split(";");
    }
}
