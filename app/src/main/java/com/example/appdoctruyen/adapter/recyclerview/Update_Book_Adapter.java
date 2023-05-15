package com.example.appdoctruyen.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Update_Book_Adapter extends RecyclerView.Adapter<Update_Book_Adapter.ViewHolderUpdate> {
    private final Recycler_View_Interface recycler_view_interface;
    Context context;
    ArrayList<Item_Book_Recycler> itemsRecycler;

    public Update_Book_Adapter(ArrayList<Item_Book_Recycler> itemsRecycler, Recycler_View_Interface recycler_view_interface) {
        this.itemsRecycler = itemsRecycler;
        this.recycler_view_interface = recycler_view_interface;
    }

    @NonNull
    @Override
    public ViewHolderUpdate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_recyclerview, parent, false);
        return new ViewHolderUpdate(view, recycler_view_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUpdate holder, int position) {
        holder.textView.setText(itemsRecycler.get(position).getRate());
        Picasso.get().load(itemsRecycler.get(position).getCover_Book()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemsRecycler.size();
    }

    public static class ViewHolderUpdate extends RecyclerView.ViewHolder{
        ImageButton imageView;
        TextView textView;

        public ViewHolderUpdate(@NonNull View itemView,  Recycler_View_Interface recycler_view_interface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_book_recycler);
            textView = itemView.findViewById(R.id.rate_text_book_recycler);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycler_view_interface != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recycler_view_interface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
