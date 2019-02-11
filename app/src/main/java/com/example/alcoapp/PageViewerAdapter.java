package com.example.alcoapp;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alcoapp.Fragments.Fragment_favourite;
import com.example.alcoapp.Fragments.Fragment_mostly_liked;
import com.example.alcoapp.Fragments.Fragment_new;

public class PageViewerAdapter extends FragmentStatePagerAdapter {
    public PageViewerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 2:
                fragment = new Fragment_favourite();
                break;
            case 1:
                fragment = new Fragment_mostly_liked();
                break;
            case 0:
                fragment = new Fragment_new();
                break;

        }
        return fragment;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
