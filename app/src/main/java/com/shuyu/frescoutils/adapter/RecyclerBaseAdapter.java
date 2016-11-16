package com.shuyu.frescoutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuyu.frescoutils.R;
import com.shuyu.frescoutils.holder.RecyclerItemViewHolder;
import com.shuyu.frescoutils.model.RecyclerDataModel;

import java.util.List;

/**
 * Created by GUO on 2016/11/16.
 */
public class RecyclerBaseAdapter extends RecyclerView.Adapter {

    private final static String TAG = "RecyclerBaseAdapter";

    private List<RecyclerDataModel> itemDataList = null;
    private Context context = null;

    public RecyclerBaseAdapter(Context context, List<RecyclerDataModel> itemDataList) {
        this.itemDataList = itemDataList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        final RecyclerItemViewHolder holder = new RecyclerItemViewHolder(context, v);
        holder.createView(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        RecyclerItemViewHolder recyclerItemViewHolder = (RecyclerItemViewHolder) holder;
        recyclerItemViewHolder.bind(itemDataList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    public void setListData(List<RecyclerDataModel> data) {
        itemDataList = data;
        notifyDataSetChanged();
    }

}
