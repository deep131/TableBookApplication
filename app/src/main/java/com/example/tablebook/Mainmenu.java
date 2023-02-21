package com.example.tablebook;

import androidx.annotation.NonNull;
import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class Mainmenu extends AppCompatActivity implements  RecyclerViewInterface{
    RecyclerView recyclerview;

    String s1[];
    int images[]={R.drawable.indian,R.drawable.chinese,R.drawable.bbq,R.drawable.cafe,R.drawable.bar,R.drawable.italian,R.drawable.south,R.drawable.bakery};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        recyclerview=findViewById(R.id.recyclerview);

        s1=getResources().getStringArray(R.array.dishes);

        MyAdapter myAdapter=new MyAdapter(this,s1,images,this);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    public void onItemClick(int position) {
        Intent intent= new Intent(Mainmenu.this,Restaurant.class);
        startActivity(intent);

    }

}