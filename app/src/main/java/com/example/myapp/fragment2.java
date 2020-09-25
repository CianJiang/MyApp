package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {
    TextView t1,t2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2, container,false);
        t1=view.findViewById(R.id.wsu);
        t2=view.findViewById(R.id.ysu);
        t1.setSelected(true);
       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               t2.setSelected(false);
               t1.setSelected(true);
           }
       });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setSelected(false);
                t2.setSelected(true);
            }
        });
        return view;
    }
}
