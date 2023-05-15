package com.example.appdoctruyen.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.recyclerview.Favorite_Book_Adapter;
import com.example.appdoctruyen.adapter.recyclerview.Inteface.Recycler_View_Interface;
import com.example.appdoctruyen.adapter.recyclerview.Maybe_Like_Book_Adaper;
import com.example.appdoctruyen.adapter.recyclerview.Top_Download_Book_Adapter;
import com.example.appdoctruyen.adapter.recyclerview.Update_Book_Adapter;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.example.appdoctruyen.Introduction_Read_Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home_Fragment extends Fragment implements Recycler_View_Interface {
    private final ArrayList<String> LIST_URL = new ArrayList<>();
    RecyclerView recyclerViewUpdate, recyclerViewFavorite, recyclerViewTopDownload, recyclerViewMaybeLike;
    Update_Book_Adapter update_book_adapter;
    Favorite_Book_Adapter favorite_book_adapter;
    Top_Download_Book_Adapter top_download_book_adapter;
    Maybe_Like_Book_Adaper maybe_like_book_adaper;
    ArrayList<Item_Book_Recycler> update_item_book_recyclers = new ArrayList<>();
    ArrayList<Item_Book_Recycler> favorite_item_book_recyclers = new ArrayList<>();
    ArrayList<Item_Book_Recycler> top_download_item_book_recyclers = new ArrayList<>();
    ArrayList<Item_Book_Recycler> maybe_like_item_book_recyclers = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        //link get update book
        LIST_URL.add("https://databaseserverquan.000webhostapp.com/server/get_book_update.php");
        //link get favorite book
        LIST_URL.add("https://databaseserverquan.000webhostapp.com/server/get_book_favorit.php");
        //link get maybe like book
        LIST_URL.add("https://databaseserverquan.000webhostapp.com/server/get_book_maybelike.php");
        //link get downloads book
        LIST_URL.add("https://databaseserverquan.000webhostapp.com/server/get_book_dowloads.php");
        recyclerViewUpdate = (RecyclerView) view.findViewById(R.id.update_book_recycler);
        recyclerViewFavorite = (RecyclerView) view.findViewById(R.id.like_book_recycler);
        recyclerViewTopDownload = (RecyclerView) view.findViewById(R.id.dowload_book_recycler);
        recyclerViewMaybeLike = (RecyclerView) view.findViewById(R.id.maybe_like_book_recycler);
        updateRecyclerBook(view.getContext());
        favoriteRecyclerBook(view.getContext());
        topDownloadRecycler(view.getContext());
        maybeLikeRecycler(view.getContext());

        return view;
    }

    private void updateRecyclerBook  (Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request;
        request = new JsonObjectRequest(LIST_URL.get(0), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response == null){
                    Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                for (int i =0; i < response.length(); i++){
                    String nameObject = Integer.toString(i);
                    try {
                        JSONObject jsonObject = response.getJSONObject(nameObject);
                        update_item_book_recyclers.add(new Item_Book_Recycler(
                                jsonObject.getString("name_book")
                                ,jsonObject.getString("cover_book")
                                ,jsonObject.getString("id_book")
                                ,jsonObject.getString("data_book")
                                ,jsonObject.getString("author_book")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                update_book_adapter= new Update_Book_Adapter(update_item_book_recyclers, Home_Fragment.this);
                recyclerViewUpdate.setAdapter(update_book_adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(String.valueOf(error), error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
    private void favoriteRecyclerBook  (Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request;
        request = new JsonObjectRequest(LIST_URL.get(1), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response == null){
                    Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                for (int i =0; i < response.length(); i++){
                    String nameObject = Integer.toString(i);
                    try {
                        JSONObject jsonObject = response.getJSONObject(nameObject);
                        favorite_item_book_recyclers.add(new Item_Book_Recycler(
                                jsonObject.getString("name_book")
                                ,jsonObject.getString("cover_book")
                                ,jsonObject.getString("id_book")
                                ,jsonObject.getString("data_book")
                                ,jsonObject.getString("author_book")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                favorite_book_adapter = new Favorite_Book_Adapter(favorite_item_book_recyclers, Home_Fragment.this);
                recyclerViewFavorite.setAdapter(favorite_book_adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(String.valueOf(error), error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
    private void topDownloadRecycler  (Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request;
        request = new JsonObjectRequest(LIST_URL.get(2), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response == null){
                    Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                for (int i =0; i < response.length(); i++){
                    String nameObject = Integer.toString(i);
                    try {
                        JSONObject jsonObject = response.getJSONObject(nameObject);
                        top_download_item_book_recyclers.add(new Item_Book_Recycler(
                                jsonObject.getString("name_book")
                                ,jsonObject.getString("cover_book")
                                ,jsonObject.getString("id_book")
                                ,jsonObject.getString("data_book")
                                ,jsonObject.getString("author_book")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                top_download_book_adapter = new Top_Download_Book_Adapter(top_download_item_book_recyclers, Home_Fragment.this);
                recyclerViewTopDownload.setAdapter(top_download_book_adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(String.valueOf(error), error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
    private void maybeLikeRecycler  (Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request;
        request = new JsonObjectRequest(LIST_URL.get(3), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response == null){
                    Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                for (int i =0; i < response.length(); i++){
                    String nameObject = Integer.toString(i);
                    try {
                        JSONObject jsonObject = response.getJSONObject(nameObject);
                        maybe_like_item_book_recyclers.add(new Item_Book_Recycler(
                                jsonObject.getString("name_book")
                                ,jsonObject.getString("cover_book")
                                ,jsonObject.getString("id_book")
                                ,jsonObject.getString("data_book")
                                ,jsonObject.getString("author_book")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                maybe_like_book_adaper = new Maybe_Like_Book_Adaper(maybe_like_item_book_recyclers, Home_Fragment.this);
                recyclerViewMaybeLike.setAdapter(maybe_like_book_adaper);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(String.valueOf(error), error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void onItemClick(Item_Book_Recycler position) {
        Intent intent_Read_Book = new Intent(this.getActivity(), Introduction_Read_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", position);
        intent_Read_Book.putExtras(bundle);
        startActivity(intent_Read_Book);
    }
}
