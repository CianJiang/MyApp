package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView list, user_bk, meeting,book;
    //private ImageView menu_add;

    private fragment1 fragment1;
    private fragment2 fragment2;
    private fragment3 fragment3;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*//在onCreate()方法中开始倒计时
        Chronometer chronometer = findViewById(R.id.chronometer);
       *//* long startTime = SystemClock.elapsedRealtime();
        //每次onCreate()方法都会重新设置base
        chronometer.setBase(startTime);
        chronometer.start();*//*

        // 创建或者直接返回一个已经存在的ViewModel
        ChronometerViewModel chronometerViewModel = ViewModelProviders.of(this)
                .get(ChronometerViewModel.class);
        if (chronometerViewModel.getStartTime() == null) {
            //chronometerViewModel如果没设置过开始时间，那么说明这个新的ViewModel,
            //所以给它设置开始时间
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            //否则ViewModel已经在上个Activity的onCreate()方法中创建过了，屏幕旋转以后，
            //ViewModel会被保存,我们直接获取ViewModel里持有的时间
            chronometer.setBase(chronometerViewModel.getStartTime());
        }
        chronometer.start();*/
        list = findViewById(R.id.list);
        user_bk = findViewById(R.id.user_bk);
        meeting = findViewById(R.id.meeting);
        //menu_add  = findViewById(R.id.menu_add);
        book =findViewById(R.id.fast_book);
        list.setOnClickListener(this);
        user_bk.setOnClickListener(this);
        meeting.setOnClickListener(this);
        book.setOnClickListener(this);

        fManager = getSupportFragmentManager();

        list.performClick();//模拟一次点击，既进去后选择消息界面


    }

    //重置所有文本的选中状态
    private void setSelected(){
        list.setSelected(false);
        user_bk.setSelected(false);
        meeting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction transaction){
        if(fragment1 != null) transaction.hide(fragment1);
        if(fragment2 != null) transaction.hide(fragment2);
        if(fragment3 != null) transaction.hide(fragment3);
    }

    @Override
    public void onClick(View v) {
        //FragmentTransaction只能使用一次
        //每次使用都要调用FragmentManager的beginTransaction()方法获得FragmentTransaction事务对象
        FragmentTransaction transaction = fManager.beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()){
            case R.id.list:
                setSelected();
                list.setSelected(true);
                if(fragment1 == null){
                    fragment1 = new fragment1();
                    transaction.add(R.id.fr, fragment1);
                }else {
                    transaction.show(fragment1);
                }
                break;
            case R.id.user_bk:
                setSelected();
                user_bk.setSelected(true);
                if(fragment2 == null){
                    fragment2 = new fragment2();
                    transaction.add(R.id.fr, fragment2);
                }else {
                    transaction.show(fragment2);
                }
                break;
            case R.id.meeting:
                setSelected();
                meeting.setSelected(true);
                if(fragment3 == null){
                    fragment3 = new fragment3();
                    transaction.add(R.id.fr, fragment3);
                }else {
                    transaction.show(fragment3);
                }
                break;
            case R.id.fast_book:
                Intent intent=new Intent(this,FastActivity.class);
                startActivity(intent);
        }
        //把newsFragment添加到Activity中的指定位置,最后调用commit()或者commitAllowingStateLoss()
        transaction.commitAllowingStateLoss();



    }
}