package com.shuyu.frescoutils;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.WindowManager;


import com.shuyu.frescoutils.adapter.RecyclerBaseAdapter;
import com.shuyu.frescoutils.itemDecoration.AlphaDividerItemDecoration;
import com.shuyu.frescoutils.model.RecyclerDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    List<RecyclerDataModel> recyclerDataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        addData();

        RecyclerBaseAdapter recyclerBaseAdapter = new RecyclerBaseAdapter(this, recyclerDataModels);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new AlphaDividerItemDecoration(dip2px(this, 5), AlphaDividerItemDecoration.LIST));
        recycler.setAdapter(recyclerBaseAdapter);

    }

    /**
     * dip转为PX
     */
    private int dip2px(Context context, float dipValue) {
        float fontScale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * fontScale + 0.5f);
    }


    private void addData() {
        recyclerDataModels = new ArrayList<>();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();// 创建了一张白纸
        windowManager.getDefaultDisplay().getMetrics(outMetrics);// 给白纸设置宽高

        Point point = new Point();
        point.set(outMetrics.widthPixels, dip2px(this, 200));
        RecyclerDataModel recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://img4.imgtn.bdimg.com/it/u=1420363952,1374463682&fm=21&gp=0.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://c.hiphotos.baidu.com/zhidao/pic/item/77094b36acaf2eddb990270a8f1001e9380193eb.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=a418fbfeb8014a90813e46b599763971/a8ec8a13632762d04d0ce0f3a1ec08fa513dc648.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://imgsrc.baidu.com/forum/pic/item/64380cd7912397dd704437ee5982b2b7d0a2871f.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://d.hiphotos.baidu.com/zhidao/pic/item/4ec2d5628535e5dd5c955af875c6a7efce1b6258.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://img.hb.aicdn.com/d2024a8a998c8d3e4ba842e40223c23dfe1026c8bbf3-OudiPA_fw580");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://imgsrc.baidu.com/baike/pic/item/509b9fcb7bf335ab52664fdb.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://imgsrc.baidu.com/baike/pic/item/0b3a1c0854fdd5b762d986d5.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://h.hiphotos.baidu.com/zhidao/pic/item/00e93901213fb80ee49e8af337d12f2eb9389443.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://h.hiphotos.baidu.com/zhidao/pic/item/d439b6003af33a87aee02645c55c10385243b5db.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://d.hiphotos.baidu.com/zhidao/pic/item/3b87e950352ac65c1b6a0042f9f2b21193138a97.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://f.hiphotos.baidu.com/zhidao/pic/item/4b90f603738da9772cc45c28b351f8198718e3ce.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://b.hiphotos.baidu.com/zhidao/pic/item/77c6a7efce1b9d16249b0023f5deb48f8c546410.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://f.hiphotos.baidu.com/lvpics/h=800/sign=fc26b1af912bd4075dc7defd4b889e9c/b21c8701a18b87d6d27d8498010828381f30fd7e.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://h.hiphotos.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=cc4a1869f9198618554ae7d62b844516/63d9f2d3572c11dfd6bd222b622762d0f703c24e.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1308/15/c3/24512095_24512095_1376555548484_mthumb.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://www.tumukeji.com/images/upload/imageArticle/1299182493.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://www.lbx777.com/z_ql/js/pic/qljs005.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://img1.ph.126.net/2UGwN3gh9VXIVX1nRKzx1A==/6597705284378749708.jpg");
        recyclerDataModels.add(recyclerDataModel);
        recyclerDataModel = new RecyclerDataModel();
        recyclerDataModel.setSize(point);
        recyclerDataModel.setUrl("http://img1.ph.126.net/NvXTE34MBq70oys5hBPA4Q==/2622783833007028444.jpg");
        recyclerDataModels.add(recyclerDataModel);

    }
}
