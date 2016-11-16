package com.shuyu.frescoutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.shuyu.frescoutils.adapter.ImageViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    Button viewPager;
    @BindView(R.id.list)
    Button list;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.viewPager, R.id.list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewPager:
                Intent intent = new Intent(MainActivity.this, ImageViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.list:
                break;
        }
    }
}
