package com.example.appdoctruyen.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.recyclerview.Inteface.Recycler_View_Interface;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Top_Download_Book_Adapter extends RecyclerView.Adapter<Top_Download_Book_Adapter.ViewHolder> {
    @NonNull
    private final Recycler_View_Interface recycler_view_interface;
    private ArrayList<Item_Book_Recycler> itemsRecycler;

    public Top_Download_Book_Adapter(ArrayList<Item_Book_Recycler> itemsRecycler, Recycler_View_Interface recycler_view) {
        this.itemsRecycler = itemsRecycler;
        this.recycler_view_interface = recycler_view;
    }

    @NonNull
    @Override
    public Top_Download_Book_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_recyclerview, parent, false);
        return new Top_Download_Book_Adapter.ViewHolder (view, recycler_view_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull Top_Download_Book_Adapter.ViewHolder holder, int position) {
        holder.textView.setText(itemsRecycler.get(position).getRate());
        Picasso.get().load(itemsRecycler.get(position).getCover_Book()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item_Book_Recycler  book = itemsRecycler.get(holder.getAbsoluteAdapterPosition());
                recycler_view_interface.onItemClick(book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsRecycler.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView,  Recycler_View_Interface recycler_view_interface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_book_recycler);
            textView = itemView.findViewById(R.id.rate_text_book_recycler);

        }
    }
}
