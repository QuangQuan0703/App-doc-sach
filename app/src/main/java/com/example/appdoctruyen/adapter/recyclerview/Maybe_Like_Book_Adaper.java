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
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Maybe_Like_Book_Adaper extends RecyclerView.Adapter<Maybe_Like_Book_Adaper.ViewHolder> {
    ArrayList<Item_Book_Recycler> itemsRecycler;

    public Maybe_Like_Book_Adaper(ArrayList<Item_Book_Recycler> itemsRecycler) {
        this.itemsRecycler = itemsRecycler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(itemsRecycler.get(position).getRate());
        Picasso.get().load(itemsRecycler.get(position).getImageView()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemsRecycler.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_book_recycler);
            textView = itemView.findViewById(R.id.rate_text_book_recycler);
        }
    }
}
