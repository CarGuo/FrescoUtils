package lib.lhh.fiv.library;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by Linhh on 16/3/2.
 */
public interface FrescoController {

    public final static String HTTP_PERFIX = "http://";
    public final static String HTTPS_PERFIX = "https://";
    public final static String FILE_PERFIX = "file://";

    /**
     * 加载网络图片
     * @param lowUrl 低分辨率图片
     * @param url 网络图片
     * @param defaultResID 默认图
     */
    public void loadView(String lowUrl, String url, int defaultResID);

    /**
     * 加载网络图片
     * @param url 网络图片
     * @param defaultResID 默认图
     */
    public void loadView(String url, int defaultResID);

    /**
     * 加载本地图片
     * @param path 图片路劲
     * @param defaultRes 默认图
     */
    public void loadLocalImage(String path, int defaultRes);

    /**
     * 将该Fresco处理为圆形
     */
    public void asCircle();

    /**
     * 用一种颜色来遮挡View以实现圆形，在一些内存较低的机器上推荐使用
     * @param overlay_color
     */
    public void setCircle(int overlay_color);

    /**
     * 设置圆角
     * @param radius
     */
    public void setCornerRadius(float radius);

    /**
     * 用一种颜色来遮挡View以实现圆角，在一些内存较低的机器上推荐使用
     * @param radius
     * @param overlay_color
     */
    public void setCornerRadius(float radius, int overlay_color);

    /**
     * 设置边框
     * @param color
     * @param width
     */
    public void setBorder(int color, float width);

    /**
     * 清除所使用的RoundingParams
     */
    public void clearRoundingParams();

    /**
     * 设置RoundingParams
     * @param roundingParmas
     */
    public void setRoundingParmas(RoundingParams roundingParmas);

    /**
     * 设置下载监听器
     * @param controllerListener
     */
    public void setControllerListener(ControllerListener controllerListener);


    /**
     * 设置后处理
     * @param postProcessor
     */
    public void setPostProcessor(Postprocessor postProcessor);


    /**
     * 是否开启动画
     * @param anim
     */
    public void setAnim(boolean anim);

    /**
     * 是否可以点击重试
     * @param tapToRetryEnabled
     */
    public void setTapToRetryEnabled(boolean tapToRetryEnabled);

    /**
     * 是否自动旋转
     * @param autoRotateEnabled
     */
    public void setAutoRotateEnabled(boolean autoRotateEnabled);

    /**
     * 设置图片缩放type
     * @param scaleType
     */
    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType);

    /**
     * 设置图片切换动时间
     * @param time
     * */
    public void setFadeTime(int time);

}
