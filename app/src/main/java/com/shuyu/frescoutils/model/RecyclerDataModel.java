package com.shuyu.frescoutils.model;

import android.graphics.Point;

import java.io.Serializable;

public class RecyclerDataModel implements Serializable {

    private String url;

    private Point size;

    public RecyclerDataModel() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }
}
