package com.shuyu.frescoutil;

import android.graphics.Point;

import com.facebook.imagepipeline.request.Postprocessor;


/**
 * Created by guoshuyu on 2017/7/8.
 * 加载配置
 */

public class LoadOption {

    //默认图片
    int defaultImg;
    
    //圆角
    int cornerRadius;
    
    //是否圆形
    boolean isCircle;
    
    //是否本地路径
    boolean loadLocalPath;
    
    //是否gif
    boolean isAnima;
    
    //大小
    Point size;
    
    //图片地址
    String uri;
    
    //处理器
    Postprocessor postprocessor;


    public LoadOption setDefaultImg(int defaultImg) {
        this.defaultImg = defaultImg;
        return this;
    }

    public LoadOption setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public LoadOption setCircle(boolean circle) {
        isCircle = circle;
        return this;
    }

    public LoadOption setLoadLocalPath(boolean loadLocalPath) {
        this.loadLocalPath = loadLocalPath;
        return this;
    }

    public LoadOption setAnima(boolean anima) {
        isAnima = anima;
        return this;
    }

    public LoadOption setSize(Point size) {
        this.size = size;
        return this;
    }

    public LoadOption setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public LoadOption setPostprocessor(Postprocessor postprocessor) {
        this.postprocessor = postprocessor;
        return this;
    }
}
