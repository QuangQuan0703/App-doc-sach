package com.example.appdoctruyen.model;

import android.widget.ImageButton;

import java.io.Serializable;

public class Item_Book_Recycler implements Serializable {
    String name_book;
    String cover_book;
    String id_book;
    String data_book;
    String author_book;

    public Item_Book_Recycler() {
    }

    public Item_Book_Recycler(String name_book, String cover_Book, String rate, String data_Book, String author) {
        this.name_book = name_book;
        this.cover_book = cover_Book;
        this.id_book = Double.toString(Double.parseDouble(rate)/10);
        this.data_book= data_Book;
        this.author_book = author;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getCover_Book() {
        return cover_book;
    }

    public void setCover_Book(String cover_Book) {
        this.cover_book = cover_Book;
    }

    public String getRate() {
        return id_book;
    }

    public void setRate(String rate) {
        this.id_book = rate;
    }

    public String getData_Book() {
        return data_book;
    }

    public void setData_Book(String data_Book) {
        this.data_book = data_Book;
    }

    public String getAuthor() {
        return author_book;
    }

    public void setAuthor(String author) {
        this.author_book = author;
    }
}
