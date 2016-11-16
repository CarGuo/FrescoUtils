package lib.lhh.fiv.library;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import static android.R.attr.height;

/**
 * Created by Linhh on 16/3/2.
 */
public class FrescoFactory {

    public static DraweeController buildDraweeController(BaseFrescoImageView fresco){
        return Fresco.newDraweeControllerBuilder()
                .setImageRequest(fresco.getImageRequest())
                .setAutoPlayAnimations(fresco.isAnim())
                .setTapToRetryEnabled(fresco.getTapToRetryEnabled())
                .setLowResImageRequest(fresco.getLowImageRequest())
                .setControllerListener(fresco.getControllerListener())
                .setOldController(fresco.getDraweeController())
                .build();
    }

    public static ImageRequest buildImageRequestWithResource(BaseFrescoImageView fresco){
        return  ImageRequestBuilder.newBuilderWithResourceId(fresco.getDefaultResID())
                .setPostprocessor(fresco.getPostProcessor())
                .setAutoRotateEnabled(fresco.getAutoRotateEnabled())
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
    }

    public static ImageRequest buildImageRequestWithResource(BaseFrescoImageView fresco, Point size){
        return  ImageRequestBuilder.newBuilderWithResourceId(fresco.getDefaultResID())
                .setPostprocessor(fresco.getPostProcessor())
                .setAutoRotateEnabled(fresco.getAutoRotateEnabled())
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(size.x, size.y))
                .build();
    }

    public static ImageRequest buildImageRequestWithSource(BaseFrescoImageView fresco){
        String thumbnail = null;
        if(TextUtils.isEmpty(fresco.getThumbnailUrl())){
            thumbnail = fresco.getThumbnailPath();
        }else{
            thumbnail = fresco.getThumbnailUrl();
        }
        Uri uri = Uri.parse(thumbnail);
        return  ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(fresco.getPostProcessor())
                .setAutoRotateEnabled(fresco.getAutoRotateEnabled())
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
    }

    public static ImageRequest buildImageRequestWithSource(BaseFrescoImageView fresco, Point size){
        String thumbnail = null;
        if(TextUtils.isEmpty(fresco.getThumbnailUrl())){
            thumbnail = fresco.getThumbnailPath();
        }else{
            thumbnail = fresco.getThumbnailUrl();
        }
        Uri uri = Uri.parse(thumbnail);
        return  ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(fresco.getPostProcessor())
                .setAutoRotateEnabled(fresco.getAutoRotateEnabled())
                .setResizeOptions(new ResizeOptions(size.x, size.y))
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
    }


    public static ImageRequest buildLowImageRequest(BaseFrescoImageView fresco){
        String lowThumbnail = null;
        if(TextUtils.isEmpty(fresco.getLowThumbnailUrl())){
            return null;
        }
        lowThumbnail = fresco.getLowThumbnailUrl();
        Uri uri = Uri.parse(lowThumbnail);
        return ImageRequest.fromUri(uri);
    }
}
