package com.shuyu.frescoutils;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.shuyu.frescoutils.adapter.ImageAdapter;
import com.shuyu.frescoutils.adapter.ImageViewPager;
import com.shuyu.frescoutils.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewPagerActivity extends Activity {

    @BindView(R.id.imageViewPager)
    ImageViewPager imageViewPager;
    @BindView(R.id.activity_image_view_pager)
    RelativeLayout activityImageViewPager;

    List<ImageModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_pager);
        ButterKnife.bind(this);

        resolveData();

        ImageAdapter galleyAdapter = new ImageAdapter(this, list);

        imageViewPager.setAdapter(galleyAdapter);
        imageViewPager.setCurrentItem(0);
        imageViewPager.setOffscreenPageLimit(2);

    }

    private void resolveData() {

        list = new ArrayList<>();
        ImageModel imageModel = new ImageModel();
        imageModel.setUri("http://tupian.enterdesk.com/2016/dqd/03/1401/11.jpg");
        imageModel.setHeight(885);
        imageModel.setWidth(1416);
        list.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setUri("http://img2.3lian.com/2014/f6/192/d/112.jpg");
        imageModel.setHeight(885);
        imageModel.setWidth(1573);
        list.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setUri("http://img5q.duitang.com/uploads/item/201402/24/20140224212510_eQRG5.thumb.700_0.jpeg");
        imageModel.setHeight(7633);
        imageModel.setWidth(700);
        list.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setUri("http://dasouji.com/wp-content/uploads/2015/07/%E9%95%BF%E8%8A%B1%E5%9B%BE-1.jpg");
        imageModel.setHeight(1437);
        imageModel.setWidth(500);
        list.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setUri("http://i3.sinaimg.cn/cj/roll/20081102/38082dbe379d1c04d0e7f0dc28134657.jpg");
        imageModel.setHeight(1240);
        imageModel.setWidth(776);
        list.add(imageModel);
    }
}
