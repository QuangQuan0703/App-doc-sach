package com.example.appdoctruyen.model;

import android.widget.ImageButton;

import java.io.Serializable;

public class Item_Book_Recycler implements Serializable {
    String name_book;
    String cover_Book;
    String rate;
    String data_Book;
    String author;

    public Item_Book_Recycler(String name_book, String cover_Book, String rate, String data_Book, String author) {
        this.name_book = name_book;
        this.cover_Book = cover_Book;
        this.rate = Double.toString(Double.parseDouble(rate)/10);
        this.data_Book = data_Book;
        this.author = author;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getCover_Book() {
        return cover_Book;
    }

    public void setCover_Book(String cover_Book) {
        this.cover_Book = cover_Book;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getData_Book() {
        return data_Book;
    }

    public void setData_Book(String data_Book) {
        this.data_Book = data_Book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
