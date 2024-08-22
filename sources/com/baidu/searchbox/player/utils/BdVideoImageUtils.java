package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"fetchBlurBitmap", "", "url", "", "blurRadius", "", "needResize", "", "resizeWidth", "resizeHeight", "callbackRef", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/searchbox/player/utils/FetchBitmapCallback;", "lib-player-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdVideoImageUtils.kt */
public final class BdVideoImageUtils {
    public static final void fetchBlurBitmap(String url, int blurRadius, boolean needResize, int resizeWidth, int resizeHeight, WeakReference<FetchBitmapCallback> callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        if (TextUtils.isEmpty(url)) {
            FetchBitmapCallback fetchBitmapCallback = (FetchBitmapCallback) callbackRef.get();
            if (fetchBitmapCallback != null) {
                fetchBitmapCallback.onFetch((Bitmap) null);
                return;
            }
            return;
        }
        ImageRequestBuilder requestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url));
        if (needResize && resizeWidth > 0 && resizeHeight > 0) {
            requestBuilder.setResizeOptions(new ResizeOptions(resizeWidth, resizeHeight, 0.0f, 0.0f, 12, (DefaultConstructorMarker) null));
        }
        if (blurRadius > 0 && blurRadius <= 25) {
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
            requestBuilder.setPostprocessor(new BlurPostProcessor(blurRadius, appContext, 0, 4, (DefaultConstructorMarker) null));
        }
        Fresco.getImagePipeline().fetchDecodedImage(requestBuilder.build(), (Object) null).subscribe(new BdVideoImageUtils$fetchBlurBitmap$1(callbackRef), UiThreadImmediateExecutorService.getInstance());
    }
}
