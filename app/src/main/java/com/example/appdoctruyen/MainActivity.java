package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.appdoctruyen.adapter.fragment.Activity_View_Pager_Fragment_Adapter;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.chip_botoom);
        viewPager2 = findViewById(R.id.view_page_root);

        Activity_View_Pager_Fragment_Adapter viewPagerRoot = new Activity_View_Pager_Fragment_Adapter(this);
        viewPager2.setAdapter(viewPagerRoot);

        chipNavigationBar.setItemSelected(R.id.home_button, true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home_button:
                        viewPager2.setCurrentItem(0);
                        chipNavigationBar.setItemSelected(R.id.home_button, true);
                        break;
                    case R.id.sreach_button:
                        viewPager2.setCurrentItem(1);
                        chipNavigationBar.setItemSelected(R.id.sreach_button, true);
                        break;
                    case R.id.library_button:
                        viewPager2.setCurrentItem(2);
                        chipNavigationBar.setItemSelected(R.id.library_button, true);
                        break;
                    case R.id.user_button:
                        viewPager2.setCurrentItem(3);
                        chipNavigationBar.setItemSelected(R.id.user_button, true);
                        break;
                }
            }
        });


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        chipNavigationBar.setItemSelected(R.id.home_button, true);
                        break;
                    case 1:
                        chipNavigationBar.setItemSelected(R.id.sreach_button, true);
                        break;
                    case 2:
                        chipNavigationBar.setItemSelected(R.id.library_button, true);
                        break;
                    case 3:
                        chipNavigationBar.setItemSelected(R.id.user_button, true);
                        break;
                }
            }
        });
    }
}