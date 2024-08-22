package com.baidu.searchbox.ugc.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import com.baidu.searchbox.picture.component.HugePhotoDraweeView;
import com.baidu.searchbox.picture.component.HugePhotoUtils;
import com.baidu.searchbox.picture.component.ImageSource;
import com.baidu.searchbox.ugc.adapter.LocalAlbumPreviewView;
import com.baidu.searchbox.ugc.utils.LogUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/ugc/adapter/LocalAlbumPreviewView$getControllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "onSubmit", "callerContext", "", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalAlbumPreviewView.kt */
public final class LocalAlbumPreviewView$getControllerListener$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ HugePhotoDraweeView $draweeView;
    final /* synthetic */ LocalAlbumPreviewView this$0;

    LocalAlbumPreviewView$getControllerListener$1(LocalAlbumPreviewView $receiver, HugePhotoDraweeView $draweeView2) {
        this.this$0 = $receiver;
        this.$draweeView = $draweeView2;
    }

    public void onSubmit(String id, Object callerContext) {
        Intrinsics.checkNotNullParameter(id, "id");
        super.onSubmit(id, callerContext);
    }

    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        super.onFinalImageSet(id, imageInfo, animatable);
        CloseableReference access$getCloseableReference$p = this.this$0.closeableReference;
        Bitmap bitmap = null;
        CloseableImage mCloseableImage = access$getCloseableReference$p != null ? (CloseableImage) access$getCloseableReference$p.get() : null;
        if (mCloseableImage != null) {
            try {
                if (mCloseableImage instanceof CloseableStaticBitmap) {
                    this.$draweeView.setIsDynamicBitmap(false);
                    this.$draweeView.setZoomEnabled(true);
                    CloseableStaticBitmap closeableStaticBitmap = mCloseableImage instanceof CloseableStaticBitmap ? (CloseableStaticBitmap) mCloseableImage : null;
                    if (closeableStaticBitmap != null) {
                        bitmap = closeableStaticBitmap.getUnderlyingBitmap();
                    }
                    if (bitmap != null) {
                        LocalAlbumPreviewView.Companion companion = LocalAlbumPreviewView.Companion;
                        int[] maxTextureSize = HugePhotoUtils.getMaxTextureSize();
                        Intrinsics.checkNotNullExpressionValue(maxTextureSize, "getMaxTextureSize()");
                        LocalAlbumPreviewView.maxTextureSize = maxTextureSize;
                        ImageSource imageSource = ImageSource.cachedBitmap(bitmap);
                        if (bitmap.getWidth() < LocalAlbumPreviewView.maxTextureSize[0]) {
                            if (bitmap.getHeight() < LocalAlbumPreviewView.maxTextureSize[0]) {
                                imageSource.tilingDisabled();
                                this.$draweeView.setImage(imageSource);
                                this.this$0.longPicDisplayMode(this.$draweeView, bitmap);
                            }
                        }
                        imageSource.tilingEnabled();
                        this.$draweeView.setImage(imageSource);
                        this.this$0.longPicDisplayMode(this.$draweeView, bitmap);
                    }
                } else if (mCloseableImage instanceof CloseableAnimatedImage) {
                    this.$draweeView.setIsDynamicBitmap(true);
                    this.$draweeView.setZoomEnabled(false);
                    ((GenericDraweeHierarchy) this.$draweeView.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                }
            } catch (Throwable e2) {
                LogUtil.e(e2);
            }
        }
    }

    public void onFailure(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        super.onFailure(id, throwable);
        LogUtil.e(throwable);
    }
}
