package com.example.appdoctruyen;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class read_activity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    NestedScrollView nestedScrollView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readbook_activity);
        floatingActionButton = findViewById(R.id.buttom_readbook);
        nestedScrollView = findViewById(R.id.nested_read_book);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY + 12 && floatingActionButton.isShown()) {
                    floatingActionButton.hide();
                }

                // the delay of the extension of the FAB is set for 12 items
                if (scrollY < oldScrollY - 12 && !floatingActionButton.isShown()) {
                    floatingActionButton.show();
                }

                // if the nestedScrollView is at the first item of the list then the
                // floating action should be in show state
                if (scrollY == 0) {
                    floatingActionButton.show();
                }
            }
        });
    }
}
