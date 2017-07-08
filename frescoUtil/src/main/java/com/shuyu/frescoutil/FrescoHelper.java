package com.shuyu.frescoutil;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.shuyu.frescoutil.listener.LoadFrescoListener;

import java.io.File;
import java.net.URI;

import lib.lhh.fiv.library.FrescoImageView;


/**
 * 加载工具
 * Created by shuyu on 2016/11/16.
 */

public class FrescoHelper {


    /**
     * @param imageView  图片加载控件
     * @param loadOption 加载配置构造器
     */
    public static void loadFrescoImage(FrescoImageView imageView, LoadOption loadOption) {

        loadFrescoImage(imageView, loadOption.uri, loadOption.defaultImg,
                loadOption.cornerRadius, loadOption.isCircle, loadOption.loadLocalPath, loadOption.isAnima,
                loadOption.size, loadOption.postprocessor);
    }


    /**
     * @param imageView     图片加载控件
     * @param uri           路径或者URL
     * @param defaultImg    默认图片
     * @param cornerRadius  弧形角度
     * @param isCircle      是否为圆
     * @param loadLocalPath 是否本地资源,如果显示R.drawable.xxx,Path可以为null,前提isCircle为true
     * @param isAnima       是否显示GIF动画
     * @param size          是否再编码
     * @param postprocessor 图像显示处理
     */
    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg,
                                       int cornerRadius, boolean isCircle, boolean loadLocalPath, boolean isAnima,
                                       Point size, Postprocessor postprocessor) {
        init(imageView, cornerRadius, isCircle, isAnima, size, postprocessor);
        if (loadLocalPath) {
            imageView.loadLocalImage(uri, defaultImg);
        } else {
            imageView.loadView(uri, defaultImg);
        }
    }


    /**
     * 超大图片的就接口
     *
     * @param context   上下玩
     * @param imageView 图片加载控件
     * @param imageUri  图片地址
     * @param defaultId 默认失败图片
     */
    public static void loadBigImage(final Context context, final SubsamplingScaleImageView imageView, String imageUri, final int defaultId) {
        final Uri uri = Uri.parse((imageUri.startsWith("http")) ? imageUri : (imageUri.startsWith("file://")) ? imageUri : "file://" + imageUri);
        final Handler handler = new Handler();
        if (imageUri.startsWith("http")) {
            File file = FrescoHelper.getCache(context, uri);
            if (file != null && file.exists()) {
                imageView.setImage(ImageSource.uri(file.getAbsolutePath()));
            } else {
                FrescoHelper.getFrescoImg(context, imageUri, 0, 0, new LoadFrescoListener() {
                    @Override
                    public void onSuccess(Bitmap bitmap) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                File file = FrescoHelper.getCache(context, uri);
                                if (file != null && file.exists()) {
                                    imageView.setImage(ImageSource.uri(file.getAbsolutePath()));
                                }
                            }
                        });
                    }

                    @Override
                    public void onFail() {
                        imageView.setImage(ImageSource.resource(defaultId));
                    }
                });
            }
        } else {
            imageView.setImage(ImageSource.uri(imageUri.replace("file://", "")));
        }
    }

    private static void init(FrescoImageView imageView, int cornerRadius, boolean isCircle, boolean isAnima,
                             Point size, Postprocessor postprocessor) {
        imageView.setAnim(isAnima);
        imageView.setCornerRadius(cornerRadius);
        imageView.setFadeTime(300);
        if (isCircle)
            imageView.asCircle();
        if (postprocessor != null)
            imageView.setPostProcessor(postprocessor);
        if (size != null) {
            imageView.setResize(size);
        }
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, boolean loadLocalPath) {
        loadFrescoImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, null, null);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, boolean loadLocalPath, Point size) {
        loadFrescoImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, size, null);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, int cornerRadius, boolean loadLocalPath, Point size) {
        loadFrescoImage(imageView, uri, defaultImg, cornerRadius, false, loadLocalPath, true, size, null);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, boolean loadLocalPath, Postprocessor postprocessor) {
        loadFrescoImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, null, postprocessor);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, boolean loadLocalPath, Point point, Postprocessor postprocessor) {
        loadFrescoImage(imageView, uri, defaultImg, 0, false, loadLocalPath, true, point, postprocessor);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, int radius, boolean loadLocalPath, Point point, Postprocessor postprocessor) {
        loadFrescoImage(imageView, uri, defaultImg, radius, false, loadLocalPath, true, point, postprocessor);
    }

    public static void loadFrescoImage(FrescoImageView imageView, String uri, int defaultImg, int cornerRadius, boolean loadLocalPath) {
        loadFrescoImage(imageView, uri, defaultImg, cornerRadius, false, loadLocalPath, true, null, null);
    }

    public static void loadFrescoImageCircle(FrescoImageView imageView, String uri, int defaultImg, boolean loadLocalPath) {
        loadFrescoImage(imageView, uri, defaultImg, 0, true, loadLocalPath, true, null, null);
    }


    /**
     * 图片是否已经存在了
     */
    public static boolean isCached(Context context, Uri uri) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<Boolean> dataSource = imagePipeline.isInDiskCache(uri);
        if (dataSource == null) {
            return false;
        }
        ImageRequest imageRequest = ImageRequest.fromUri(uri);
        CacheKey cacheKey = DefaultCacheKeyFactory.getInstance()
                .getEncodedCacheKey(imageRequest, context);
        BinaryResource resource = ImagePipelineFactory.getInstance()
                .getMainFileCache().getResource(cacheKey);
        return resource != null && dataSource.getResult() != null && dataSource.getResult();
    }

    /**
     * 本地缓存文件
     */
    public static File getCache(Context context, Uri uri) {
        if (!isCached(context, uri))
            return null;
        ImageRequest imageRequest = ImageRequest.fromUri(uri);
        CacheKey cacheKey = DefaultCacheKeyFactory.getInstance()
                .getEncodedCacheKey(imageRequest, context);
        BinaryResource resource = ImagePipelineFactory.getInstance()
                .getMainFileCache().getResource(cacheKey);
        File file = ((FileBinaryResource) resource).getFile();
        return file;
    }

    /**
     * 返回bitmap,也可以用来监听下载，bitmap会被fresco自动回收
     *
     * @param context  上下文
     * @param url      网络地址
     * @param width    宽度 可以为0
     * @param height   高度 可以为0
     * @param listener 回调
     */
    public static void getFrescoImg(Context context, String url, int width, int height, final LoadFrescoListener listener) {
        getFrescoImgProcessor(context, url, width, height, null, listener);
    }

    /**
     * 返回bitmap,也可以用来监听下载，bitmap会被fresco自动回收
     *
     * @param context   上下文
     * @param url       网络地址
     * @param width     宽度
     * @param height    高度
     * @param processor 处理图片
     * @param listener  回调
     */
    public static void getFrescoImgProcessor(Context context, final String url, final int width, final int height,
                                             BasePostprocessor processor, final LoadFrescoListener listener) {

        ResizeOptions resizeOptions = null;
        if (width != 0 && height != 0) {
            resizeOptions = new ResizeOptions(width, height);
        }
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(false)
                .setPostprocessor(processor)
                .setResizeOptions(resizeOptions)
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, context);
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(Bitmap bitmap) {
                //图片不能是GIF
                listener.onSuccess(bitmap);
            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                listener.onFail();
            }
        }, CallerThreadExecutor.getInstance());

    }

}
