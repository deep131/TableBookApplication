package com.example.tablebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {

    private static final String TAG = "Restaurent Activity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.skydine);
        mNames.add("Skydine-9898989898");

        mImageUrls.add(R.drawable.kathiyavadi);
        mNames.add("Khadki 989898989");

        mImageUrls.add(R.drawable.girnar);
        mNames.add("Hotel Girnar 8898989898");

        mImageUrls.add(R.drawable.taj);
        mNames.add("Hotel Taj 989898998");


        mImageUrls.add(R.drawable.nandos);
        mNames.add("Hotel Brewberry 987987987");

        mImageUrls.add(R.drawable.kismat);
        mNames.add("Frozen Lake");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MySecondAdapter adapter = new MySecondAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}