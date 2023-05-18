package com.example.appdoctruyen.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Favorite_Library_Fragment extends Fragment {
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_fragment_library, container, false);
        textView = view.findViewById(R.id.text_favorite);
        firebaseDatabase = FirebaseDatabase.getInstance("https://app-doc-sach-35b4c-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("/App_doc_truyen/Book_Storage");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String a = null;
                for (DataSnapshot item:snapshot.getChildren()){
                    Item_Book_Recycler item_book_recycler;
                    item_book_recycler = item.getValue(Item_Book_Recycler.class);
                    a += item_book_recycler.getName_book();
                }
                textView.setText(a);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;

    }
}
