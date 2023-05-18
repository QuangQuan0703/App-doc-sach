package com.example.appdoctruyen.fragment;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.recyclerview.Search_Book_Adapter;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PrimitiveIterator;

public class Sreach_Fragment extends Fragment {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private Search_Book_Adapter adapter;
    private ArrayList<Item_Book_Recycler> bookRecyclerArrayList;
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sreach_fragment, container, false);
        searchView = view.findViewById(R.id.search_search_book);
        recyclerView = view.findViewById(R.id.sreach_recycler_sreach_book);
        bookRecyclerArrayList = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance("https://app-doc-sach-35b4c-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("/App_doc_truyen/Book_Storage");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item:snapshot.getChildren()){
                    Item_Book_Recycler item_book_recycler;
                    item_book_recycler = item.getValue(Item_Book_Recycler.class);
                    bookRecyclerArrayList.add(item_book_recycler);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });
        adapter = new Search_Book_Adapter(bookRecyclerArrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void searchList(String newText) {
        ArrayList<Item_Book_Recycler> arrayList = new ArrayList<>();
        for(Item_Book_Recycler item: bookRecyclerArrayList){
            if(item.getName_book().toLowerCase().contains(newText.toLowerCase())){
                arrayList.add(item);
            }
        }
        adapter.setItem_book_recyclers(arrayList);
    }
}