package com.example.appdoctruyen.fragment;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdoctruyen.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Sreach_Fragment extends Fragment {
    @Nullable
    PDFView pdfView ;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.sreach_fragment, container, false);
        pdfView = view.findViewById(R.id.pdfview);
        new RetrievePDFStream().execute("https://databaseserverquan.000webhostapp.com/databook/K%E1%BA%BB%20%C4%91i%C3%AAn%20b%C3%AAn%20tr%C3%A1i%20thi%C3%AAn%20t%C3%A0i%20b%C3%AAn%20ph%E1%BA%A3i.pdf");
        return view;
    }
    class RetrievePDFStream extends AsyncTask<String, Void, InputStream>
    {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try
            {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode() == 200)
                {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e)
            {
                return null;
            }
            return inputStream;
        }

        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream)
                    .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    // allows to draw something on all pages, separately for every page. Called only for visible pages
                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                    // spacing between pages in dp. To define spacing color, set view background
                    .spacing(0)
                    .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                    .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                    .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                    .pageSnap(false) // snap pages to screen boundaries
                    .pageFling(false) // make a fling change only a single page like ViewPager
                    .nightMode(false) // toggle night mode
                    .load();;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        new RetrievePDFStream().execute("https://databaseserverquan.000webhostapp.com/databook/K%E1%BA%BB%20%C4%91i%C3%AAn%20b%C3%AAn%20tr%C3%A1i%20thi%C3%AAn%20t%C3%A0i%20b%C3%AAn%20ph%E1%BA%A3i.pdf");
    }
}