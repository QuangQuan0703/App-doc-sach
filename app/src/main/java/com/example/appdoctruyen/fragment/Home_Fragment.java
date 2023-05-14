package com.example.appdoctruyen.fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.recyclerview.Favorite_Book_Adapter;
import com.example.appdoctruyen.adapter.recyclerview.Maybe_Like_Book_Adaper;
import com.example.appdoctruyen.adapter.recyclerview.Top_Download_Book_Adapter;
import com.example.appdoctruyen.adapter.recyclerview.Update_Book_Adapter;
import com.example.appdoctruyen.model.Item_Book_Recycler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
    private final String URL = "https://android-kotlin-fun-mars-server.appspot.com/photos?hl=vi";
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
        JsonArrayRequest request;
        request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject a = response.getJSONObject(i);
                                update_item_book_recyclers.add(new Item_Book_Recycler(a.getString("img_src"), a.getString("id").substring(1)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        update_book_adapter = new Update_Book_Adapter(update_item_book_recyclers);
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
        JsonArrayRequest request;
        request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject a = response.getJSONObject(i);
                                favorite_item_book_recyclers.add(new Item_Book_Recycler(a.getString("img_src"), a.getString("id").substring(1)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        favorite_book_adapter = new Favorite_Book_Adapter(favorite_item_book_recyclers);
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
        JsonArrayRequest request;
        request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject a = response.getJSONObject(i);
                                top_download_item_book_recyclers.add(new Item_Book_Recycler(a.getString("img_src"), a.getString("id").substring(1)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        top_download_book_adapter = new Top_Download_Book_Adapter(top_download_item_book_recyclers);
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
        JsonArrayRequest request;
        request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }
                        for (int i = 0; i <= response.length(); i++) {
                            try {
                                JSONObject a = response.getJSONObject(i);
                                maybe_like_item_book_recyclers.add(new Item_Book_Recycler(a.getString("img_src"), a.getString("id").substring(1)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        maybe_like_book_adaper = new Maybe_Like_Book_Adaper(maybe_like_item_book_recyclers);
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
}
