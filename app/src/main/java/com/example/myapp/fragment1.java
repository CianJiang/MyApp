package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class fragment1 extends Fragment {
     List lists=new ArrayList();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1, container,false);
        initMeet();
        MyAdapter adapter=new MyAdapter(getActivity(),R.layout.items,lists);
        ListView listView = view.findViewById(R.id.fr_1);
        listView.setAdapter(adapter);
        return view;
    }
    private void initMeet() {
        meet meet1 = new meet("A101","会议中","客户接待","2020/09/26 10:00-2020/09/26 12:00");
        meet meet2 = new meet("A102","会议中","外部客户接待","");
        lists.add(meet1);
        lists.add(meet2);
    }
}
