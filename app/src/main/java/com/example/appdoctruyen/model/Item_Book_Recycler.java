package com.example.appdoctruyen.model;

import android.widget.ImageButton;

public class Item_Book_Recycler {
    String ImageView;
    String Rate;
    String dataBook;

    public Item_Book_Recycler(String imageView, String rate) {
        ImageView = imageView;
        Rate = rate;
    }

    public String getImageView() {
        return ImageView;
    }

    public void setImageView(String imageView) {
        ImageView = imageView;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }
}
