package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.List;

public class MyAdapter extends ArrayAdapter {
    private final int resourceId;

    public MyAdapter(FragmentActivity context, int textViewResourceId, List<meet> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        meet meet1= (meet) getItem(position); // 获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView name =  view.findViewById(R.id.name);//获取该布局内的文本视图
        TextView zht = view.findViewById(R.id.zht);
        TextView meet = view.findViewById(R.id.meet);
        TextView next =  view.findViewById(R.id.next);
        name.setText(meet1.getName());//为文本视图设置文本内容
        zht.setText(meet1.getZht());
        meet.setText(meet1.getMeet());
        next.setText(meet1.getNext());
        return view;
    }
}
