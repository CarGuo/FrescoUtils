package com.shuyu.frescoutils.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.shuyu.frescoutil.FrescoHelper;
import com.shuyu.frescoutil.listener.LoadFrescoListener;
import com.shuyu.frescoutils.R;
import com.shuyu.frescoutils.model.ImageModel;

import java.io.File;
import java.util.List;

import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;


/**
 * Created by shuyu on 2016/11/16.
 */
public class ImageAdapter extends PagerAdapter {

    private Context context;

    private final List<ImageModel> images;

    private int screenHeight;

    private final Handler handler = new Handler();

    public ImageAdapter(Context context, List<ImageModel> images) {
        this.images = images;
        this.context  = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();// 创建了一张白纸
        windowManager.getDefaultDisplay().getMetrics(outMetrics);// 给白纸设置宽高
        screenHeight = outMetrics.heightPixels;
    }

    @Override
    public int getCount() {
        return images.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        context = container.getContext();
        ImageModel photoItemModel = images.get(position);
        if (photoItemModel.getHeight() > 0 && photoItemModel.getWidth() > 0) {
            float ph = (float) photoItemModel.getHeight() / photoItemModel.getWidth();
            if (photoItemModel.getHeight() > 2 * screenHeight && ph >= 2.3) {
                return ShowBigImg(container, position);
            } else {
                return showNormalImage(container, position);
            }
        } else {
            return showNormalImage(container, position);
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    private View showNormalImage(ViewGroup container, final int position) {

        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.normal_img_layout, container, false);
        PhotoDraweeView imageView = (PhotoDraweeView) layout.findViewById(R.id.image_item);

        String imageUri = images.get(position).getUri();
        Uri show = Uri.parse((imageUri.startsWith("http")) ? imageUri : (imageUri.startsWith("file://")) ? imageUri : "file://" + imageUri);
        imageView.setPhotoUri(show);
        imageView.setOnViewTapListener(new OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                Toast.makeText(context, "点击可以退出", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(layout);

        return layout;
    }

    private View ShowBigImg(final ViewGroup container, final int position) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.big_img_layout, container, false);

        final SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) layout.findViewById(R.id.image_item);
        final String imageUri = images.get(position).getUri();
        final Uri uri = Uri.parse((imageUri.startsWith("http")) ? imageUri : (imageUri.startsWith("file://")) ? imageUri : "file://" + imageUri);

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

                    }
                });
            }
        } else {
            imageView.setImage(ImageSource.uri(imageUri.replace("file://", "")));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击可以退出", Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(layout);
        return layout;
    }

}
