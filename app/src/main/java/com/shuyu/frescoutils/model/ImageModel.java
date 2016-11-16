package com.shuyu.frescoutils.model;

import java.io.Serializable;

/**
 * Created by shuyu on 2016/11/16.
 */

public class ImageModel implements Serializable {


    private int postion;

    private String uri;

    private int width;

    private int height;

    public ImageModel(){

    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
