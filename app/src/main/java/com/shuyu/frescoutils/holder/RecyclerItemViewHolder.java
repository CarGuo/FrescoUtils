package com.shuyu.frescoutils.holder;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shuyu.frescoutil.FrescoHelper;
import com.shuyu.frescoutils.R;
import com.shuyu.frescoutils.model.RecyclerDataModel;

import lib.lhh.fiv.library.FrescoImageView;

/**
 * Created by GUO on 2015/12/3.
 */
public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

    protected Context context = null;

    protected FrescoImageView frescoImageView;

    public RecyclerItemViewHolder(Context context, View v) {
        super(v);
        this.context = context;
    }

    public void creatView(View view) {
        frescoImageView = (FrescoImageView) view.findViewById(R.id.image_item);
    }

    public void bind(RecyclerDataModel recyclerDataModel) {
        FrescoHelper.loadFrescoImage(frescoImageView, recyclerDataModel.getUrl(), R.mipmap.ic_launcher, 2, false,  recyclerDataModel.getSize());
    }
}





