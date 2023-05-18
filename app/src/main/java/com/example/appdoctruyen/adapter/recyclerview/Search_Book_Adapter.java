package com.example.appdoctruyen.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Search_Book_Adapter extends RecyclerView.Adapter<Search_Book_Adapter.ViewHolder> {
    ArrayList<Item_Book_Recycler> item_book_recyclers;

    public Search_Book_Adapter(ArrayList<Item_Book_Recycler> item_book_recyclers) {
        this.item_book_recyclers = item_book_recyclers;
    }
    public void setItem_book_recyclers(ArrayList<Item_Book_Recycler> arrayList){
        this.item_book_recyclers = arrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sreach_book, parent, false);
        Search_Book_Adapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(item_book_recyclers.get(position).getCover_Book()).into(holder.image_Book_Cover);
        holder.text_Name_Book.setText(item_book_recyclers.get(position).getName_book());
        holder.text_Name_Author.setText(item_book_recyclers.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return item_book_recyclers.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image_Book_Cover;
        TextView text_Name_Book, text_Name_Author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_Book_Cover = itemView.findViewById(R.id.image_book_cover_item_search);
            text_Name_Author = itemView.findViewById(R.id.text_name_author_item_search);
            text_Name_Book = itemView.findViewById(R.id.text_name_book_item_search);
            cardView = itemView.findViewById(R.id.card_view_item_search);
        }
    }
}
