package com.baidu.searchbox.aisearch.camera;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.baidu.searchbox.aisearch.camera.gallery.GalleryPicSelectCallback;
import com.baidu.searchbox.aisearch.camera.uitls.ImageUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/aisearch/camera/CameraActivity$startGallery$galleryView$1", "Lcom/baidu/searchbox/aisearch/camera/gallery/GalleryPicSelectCallback;", "onExitGallery", "", "onGalleryPicSelect", "uriString", "", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CameraActivity.kt */
public final class CameraActivity$startGallery$galleryView$1 implements GalleryPicSelectCallback {
    final /* synthetic */ CameraActivity this$0;

    CameraActivity$startGallery$galleryView$1(CameraActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onGalleryPicSelect(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        ExecutorUtilsExt.postOnElastic(new CameraActivity$startGallery$galleryView$1$$ExternalSyntheticLambda1(this.this$0, uriString), "AISearchCameraActivity", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onGalleryPicSelect$lambda-1  reason: not valid java name */
    public static final void m15104onGalleryPicSelect$lambda1(CameraActivity this$02, String $uriString) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($uriString, "$uriString");
        this$02.runOnUiThread(new CameraActivity$startGallery$galleryView$1$$ExternalSyntheticLambda0(this$02, ImageUtils.INSTANCE.decodeBitmapFromUri(this$02, $uriString, this$02.size)));
    }

    /* access modifiers changed from: private */
    /* renamed from: onGalleryPicSelect$lambda-1$lambda-0  reason: not valid java name */
    public static final void m15105onGalleryPicSelect$lambda1$lambda0(CameraActivity this$02, Bitmap $bitmap) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.showConfirmPage($bitmap);
    }

    public void onExitGallery() {
        FrameLayout container = (FrameLayout) this.this$0.findViewById(R.id.gallery_container);
        container.removeAllViews();
        container.setBackground((Drawable) null);
    }
}
