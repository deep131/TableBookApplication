package com.example.tablebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
 //   TextView tex1,tex2,tex3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile,container,false);
     /*   tex1=v.findViewById(R.id.tex1);
        tex2=v.findViewById(R.id.tex2);
        tex3=v.findViewById(R.id.tex3);

        Bundle b3=getArguments();
        String name=b3.getString("name");
        String phone=b3.getString("phone");
        String time=b3.getString("time");
        tex1.setText(name);
        tex2.setText(phone);
        tex3.setText(time);*/

        return v;

    }

}
