package com.baidu.swan.apps.media.image;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.baidu.swan.apps.util.SwanAppImageUtils;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class ImageShowHelper {
    private static final float LONG_PIC_DISTINGUISH_RATE = 1.6f;
    public static final float MAX_BITMAP_SIZE = 8192.0f;

    /* access modifiers changed from: private */
    public static void setImageView(HugePhotoDraweeView imageView, Bitmap bitmap) {
        int[] maxTextureSize = SwanAppImageUtils.getMaxTextureSize();
        ImageSource imageSource = ImageSource.cachedBitmap(bitmap);
        if (imageSource != null) {
            if (bitmap.getWidth() >= maxTextureSize[0] || bitmap.getHeight() >= maxTextureSize[0]) {
                imageSource.tilingEnabled();
            } else {
                imageSource.tilingDisabled();
            }
            imageView.setImage(imageSource);
            longPicDisplayMode(imageView, bitmap);
        }
    }

    private static void longPicDisplayMode(HugePhotoDraweeView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            int mScreenWidth = SwanAppUIUtils.getDisplayWidth(imageView.getContext());
            int mScreenHeight = SwanAppUIUtils.getDisplayHeight(imageView.getContext());
            float rate = bitmap.getWidth() == 0 ? 1.0f : ((float) mScreenWidth) / ((float) bitmap.getWidth());
            if (((float) ((int) (((float) bitmap.getHeight()) * rate))) >= ((float) mScreenHeight) * 1.6f) {
                imageView.setDoubleTapZoomScale(rate);
                imageView.setScaleAndCenter(rate, new PointF((float) (mScreenWidth / 2), 0.0f));
            }
        }
    }

    public static void loadImage(final HugePhotoDraweeView imageView, PipelineDraweeControllerBuilder controllerBuilder) {
        imageView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) controllerBuilder.setOldController(imageView.getController())).setControllerListener(new BaseControllerListener() {
            public void onSubmit(String id, Object callerContext) {
                super.onSubmit(id, callerContext);
            }

            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo instanceof CloseableStaticBitmap) {
                    HugePhotoDraweeView.this.setIsDynamicBitmap(false);
                    HugePhotoDraweeView.this.setZoomEnabled(true);
                    Bitmap bitmap = ((CloseableStaticBitmap) imageInfo).getUnderlyingBitmap();
                    if (bitmap != null) {
                        ImageShowHelper.setImageView(HugePhotoDraweeView.this, bitmap);
                    }
                } else if (imageInfo instanceof CloseableAnimatedImage) {
                    HugePhotoDraweeView.this.setIsDynamicBitmap(true);
                    HugePhotoDraweeView.this.setZoomEnabled(false);
                    ((GenericDraweeHierarchy) HugePhotoDraweeView.this.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                }
            }

            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
            }
        })).build());
    }

    public static boolean isHugePhotoView(ImageView imageView) {
        return imageView instanceof HugePhotoDraweeView;
    }
}
