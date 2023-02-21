package com.example.tablebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
GoogleMap maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        maps=googleMap;

        LatLng Skydine=new LatLng(22.284013, 73.164858);
        maps.addMarker(new MarkerOptions().position(Skydine).title("skydine"));
        LatLng Kismat=new LatLng(22.3276562,73.2069219);
        maps.addMarker(new MarkerOptions().position(Kismat).title("Kismat"));
        LatLng Taj=new LatLng(22.2935961,73.172196);
        maps.addMarker(new MarkerOptions().position(Taj).title("Taj"));
        LatLng Nando=new LatLng(23.1105734,55.5520776);
        maps.addMarker(new MarkerOptions().position(Nando).title("Nando"));
        LatLng Kath=new LatLng(22.3033585,73.1990927);
        maps.addMarker(new MarkerOptions().position(Kath).title("Khadki"));
        LatLng Gir=new LatLng(22.2439295,73.2131446);
        maps.addMarker(new MarkerOptions().position(Gir).title("Girnar"));
       // maps.moveCamera(CamaraUpdateFactory.newLatLng(Skydine));
    }
}