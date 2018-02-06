package lib.lhh.fiv.library;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by Linhh on 16/3/2.
 */
public interface FrescoController {

    String HTTP_PERFIX = "http://";
    String HTTPS_PERFIX = "https://";
    String FILE_PERFIX = "file://";

    /**
     * 加载网络图片
     * @param lowUrl 低分辨率图片
     * @param url 网络图片
     * @param defaultResID 默认图
     */
    void loadView(String lowUrl, String url, int defaultResID);

    /**
     * 加载网络图片
     * @param url 网络图片
     * @param defaultResID 默认图
     */
    void loadView(String url, int defaultResID);

    /**
     * 加载本地图片
     * @param path 图片路劲
     * @param defaultRes 默认图
     */
    void loadLocalImage(String path, int defaultRes);

    /**
     * 将该Fresco处理为圆形
     */
    void asCircle();

    /**
     * 用一种颜色来遮挡View以实现圆形，在一些内存较低的机器上推荐使用
     * @param overlay_color
     */
    void setCircle(int overlay_color);

    /**
     * 设置圆角
     * @param radius
     */
    void setCornerRadius(float radius);

    /**
     * 用一种颜色来遮挡View以实现圆角，在一些内存较低的机器上推荐使用
     * @param radius
     * @param overlay_color
     */
    void setCornerRadius(float radius, int overlay_color);

    /**
     * 设置边框
     * @param color
     * @param width
     */
    void setBorder(int color, float width);

    /**
     * 清除所使用的RoundingParams
     */
    void clearRoundingParams();

    /**
     * 设置RoundingParams
     * @param roundingParmas
     */
    void setRoundingParmas(RoundingParams roundingParmas);

    /**
     * 设置下载监听器
     * @param controllerListener
     */
    void setControllerListener(ControllerListener controllerListener);


    /**
     * 设置后处理
     * @param postProcessor
     */
    void setPostProcessor(Postprocessor postProcessor);


    /**
     * 是否开启动画
     * @param anim
     */
    void setAnim(boolean anim);

    /**
     * 是否可以点击重试
     * @param tapToRetryEnabled
     */
    void setTapToRetryEnabled(boolean tapToRetryEnabled);

    /**
     * 是否自动旋转
     * @param autoRotateEnabled
     */
    void setAutoRotateEnabled(boolean autoRotateEnabled);

    /**
     * 设置图片缩放type
     * @param scaleType
     */
    void setActualImageScaleType(ScalingUtils.ScaleType scaleType);

    /**
     * 设置图片切换动时间
     * @param time
     * */
    void setFadeTime(int time);

}
