package com.example.alcoapp.Activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alcoapp.Fragments.Fragment_favourite;
import com.example.alcoapp.PageViewerAdapter;
import com.example.alcoapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView favourite, neew, best;
    ViewPager viewPager;
    PageViewerAdapter pageViewerAdapter;
    public static String nameMalibu = "malibu z mlekiem";

    @Override
    protected void onResume() {
        super.onResume();
        if (!(pageViewerAdapter == null)) {
            pageViewerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.fragment_container);
        neew = findViewById(R.id.neew);
        favourite = findViewById(R.id.favourite);
        best = findViewById(R.id.best);
        pageViewerAdapter = new PageViewerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageViewerAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    favourite.setTextSize(20);
                    best.setTextSize(20);
                    neew.setTextSize(25);
                    favourite.setTextColor(getResources().getColor(R.color.notSelectedTab));
                    neew.setTextColor(getResources().getColor(R.color.selectedTab));
                    best.setTextColor(getResources().getColor(R.color.notSelectedTab));
                    MainActivity.nameMalibu = "lol";
                } else if (i == 2) {
                    neew.setTextSize(20);
                    best.setTextSize(20);
                    favourite.setTextSize(25);
                    favourite.setTextColor(getResources().getColor(R.color.selectedTab));
                    neew.setTextColor(getResources().getColor(R.color.notSelectedTab));
                    best.setTextColor(getResources().getColor(R.color.notSelectedTab));
                } else if (i == 1) {
                    neew.setTextSize(20);
                    favourite.setTextSize(20);
                    best.setTextSize(25);
                    best.setTextColor(getResources().getColor(R.color.selectedTab));
                    neew.setTextColor(getResources().getColor(R.color.notSelectedTab));
                    favourite.setTextColor(getResources().getColor(R.color.notSelectedTab));
                }
                viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
