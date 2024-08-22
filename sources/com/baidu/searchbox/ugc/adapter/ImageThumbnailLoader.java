package com.baidu.searchbox.ugc.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.searchbox.ugc.album.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0003J2\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J4\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/ugc/adapter/ImageThumbnailLoader;", "", "()V", "asyncLoadThumbnail", "", "context", "Landroid/content/Context;", "imageViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageUri", "Landroid/net/Uri;", "width", "", "height", "loadByFresco", "loadThumbnail", "", "imageView", "preloadByFresco", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageThumbnailLoader.kt */
public final class ImageThumbnailLoader {
    public final boolean loadThumbnail(Context context, SimpleDraweeView imageView, Uri imageUri, int width, int height) {
        if (context == null || imageView == null || imageUri == null || Build.VERSION.SDK_INT < 29) {
            return false;
        }
        Object tag = imageView.getTag(R.id.use_load_thumbnail_key);
        if ((tag instanceof Integer ? (Integer) tag : null) != null) {
            return false;
        }
        imageView.setTag(R.id.use_load_thumbnail_key, 1);
        asyncLoadThumbnail(context.getApplicationContext(), new WeakReference(imageView), imageUri, width, height);
        return true;
    }

    private final void asyncLoadThumbnail(Context context, WeakReference<SimpleDraweeView> imageViewRef, Uri imageUri, int width, int height) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new ImageThumbnailLoader$asyncLoadThumbnail$1(context, imageUri, width, height, this, imageViewRef, (Continuation<? super ImageThumbnailLoader$asyncLoadThumbnail$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void loadByFresco(WeakReference<SimpleDraweeView> imageViewRef, Uri imageUri, int width, int height) {
        if (imageViewRef != null && imageUri != null) {
            ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(imageUri);
            builder.setResizeOptions(new ResizeOptions((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f), 0.0f, 0.0f, 12, (DefaultConstructorMarker) null));
            builder.setLocalThumbnailPreviewsEnabled(true);
            builder.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            SimpleDraweeView it = (SimpleDraweeView) imageViewRef.get();
            if (it != null) {
                AbstractDraweeController controller = ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(builder.build())).setAutoPlayAnimations(false)).setOldController(it.getController())).build();
                Intrinsics.checkNotNullExpressionValue(controller, "newDraweeControllerBuild…\n                .build()");
                it.setController(controller);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void preloadByFresco(Uri imageUri) {
        ImageRequest request;
        if (imageUri != null && (request = ImageRequest.fromUri(imageUri)) != null) {
            Fresco.getImagePipeline().prefetchToBitmapCache(request, (Object) null);
        }
    }
}
