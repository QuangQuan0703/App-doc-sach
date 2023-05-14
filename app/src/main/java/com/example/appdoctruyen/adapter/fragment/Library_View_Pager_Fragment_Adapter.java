package com.example.appdoctruyen.adapter.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appdoctruyen.fragment.Favorite_Library_Fragment;
import com.example.appdoctruyen.fragment.Home_Fragment;
import com.example.appdoctruyen.fragment.Offline_Library_Fragment;
import com.example.appdoctruyen.fragment.Sreach_Fragment;

public class Library_View_Pager_Fragment_Adapter extends FragmentStateAdapter {

    public Library_View_Pager_Fragment_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Favorite_Library_Fragment();
            case 1:
                return new Offline_Library_Fragment();
            default:
                return new Favorite_Library_Fragment();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
