package com.example.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.squareup.picasso.Picasso;

public class Introduction_Read_Activity extends AppCompatActivity {
    private NestedScrollView nestedScrollView;
    private ImageView image_Book_Cover, image_Read_Book;
    private String URL_DATA_BOOK;
    Intent intent;
    Intent intent_Read_Book;
    private TextView text_Name_Book, text_Name_Author, text_Rate_Book;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction_readbook_activity);
        nestedScrollView = findViewById(R.id.nested_read_book);
        image_Book_Cover = findViewById(R.id.image_cover_book_read_book);
        text_Name_Book = findViewById(R.id.name_book_read_book);
        text_Name_Author = findViewById(R.id.name_author_book_read_book);
        text_Rate_Book = findViewById(R.id.rate_book_read_book);
        image_Read_Book = findViewById(R.id.image_buttom_read_book);
        setData();

    }
    public void setData(){
        intent = getIntent();
        Item_Book_Recycler book =(Item_Book_Recycler) intent.getExtras().get("book");
        Picasso.get().load(book.getCover_Book()).into(image_Book_Cover);
        text_Rate_Book.setText(book.getRate());
        text_Name_Book.setText(book.getName_book());
        text_Name_Author.setText(book.getAuthor());
        URL_DATA_BOOK = book.getData_Book();
        image_Read_Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_Read_Book = new Intent(getApplicationContext(), Read_Book.class);
                Bundle bundle = new Bundle();
                bundle.putString("book_data", URL_DATA_BOOK);
                intent_Read_Book.putExtras(bundle);
                startActivity(intent_Read_Book);
            }
        });
    }
}
