package com.example.tablebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class MiddleActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    Button btn;
    TextView tex1,tex2,tex3,tex4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        tex1=findViewById(R.id.tex1);
        tex2=findViewById(R.id.tex2);
        tex3=findViewById(R.id.tex3);
        btn=findViewById(R.id.btn);
        tex4=findViewById(R.id.tex4);

        String name=getIntent().getStringExtra("keyname");
        String phone=getIntent().getStringExtra("keyphone");
        String time=getIntent().getStringExtra("keytime");
        String persons=getIntent().getStringExtra("keyperson");
        tex1.setText(name);
        tex2.setText(phone);
        tex3.setText(time);
        tex4.setText(persons);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MiddleActivity.this,Mainmenu.class);
                startActivity(intent);

            }
        });

       Toolbar toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      /*  int id= item.getItemId();
        if (id == R.id.share){
            ApplicationInfo api=getApplicationContext().getApplicationInfo();
            String apkpath=api.sourceDir;
            Intent intent=new Intent(Intent.ACTION_SEND) ;
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(intent.createChooser(intent,"share"));
        }
        return true;*/
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String Body="Download this app";
        String Sub="http://play.google.com";
        intent.putExtra(Intent.EXTRA_TEXT,Body);
        intent.putExtra(Intent.EXTRA_TEXT,Sub);
        startActivity(Intent.createChooser(intent,"share"));
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
          /*  case R.id.nav_msg:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Msgfragment()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ChatFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;*/
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}