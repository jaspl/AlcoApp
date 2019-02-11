package com.example.alcoapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alcoapp.R;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {
    List<String> ingreedients =new ArrayList();
    ListView listView;
    LinearLayout ingredientsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        ingreedients.add("skadnik1");
        ingreedients.add("skadnik2");
        ingreedients.add("skadnik3");
        ingreedients.add("skadnik4");
        ingredientsList = findViewById(R.id.ingredients_list);
        for (int i = 0;i<ingreedients.size();i++){
            View view = getLayoutInflater().inflate(R.layout.single_ingredient_layout,null);
            TextView ingredient= view.findViewById(R.id.ingredient);
            ingredient.setText("-"+ingreedients.get(i));
            ingredientsList.addView(view);
        }
    }
}
