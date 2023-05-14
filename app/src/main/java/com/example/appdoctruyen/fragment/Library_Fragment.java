package com.example.appdoctruyen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.fragment.Library_View_Pager_Fragment_Adapter;
import com.google.android.material.tabs.TabLayout;

public class Library_Fragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_fragment,container,false);
        tabLayout = view.findViewById(R.id.library_tablayout);
        viewPager2 = view.findViewById(R.id.library_viewpager);
        tabLayout.addTab(tabLayout.newTab().setText("Favorite").setIcon(R.drawable.heart_shape_outline), 0);
        tabLayout.addTab(tabLayout.newTab().setText("Offline").setIcon(R.drawable.no_wifi),1);
        Library_View_Pager_Fragment_Adapter fragment_adapter = new Library_View_Pager_Fragment_Adapter(this.getActivity());
        viewPager2.setAdapter(fragment_adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        return view;
    }
}
