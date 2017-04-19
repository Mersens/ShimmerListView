package com.mersens.shimmerlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mersens.shimmer.ShimmerListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ShimmerListView mShimmerListView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mShimmerListView=(ShimmerListView)findViewById(R.id.shimmerListView);
        mShimmerListView.showShimmer();
        mShimmerListView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadDatas();

            }
        },5000);

    }

    private void loadDatas() {
        List<String> list=new ArrayList<>();
        for(int i=0;i<15;i++){
            list.add("Item "+i);
        }
        adapter=new MyAdapter(this,list);
        mShimmerListView.setAdapter(adapter);
        mShimmerListView.hideShimmer();
    }
}
