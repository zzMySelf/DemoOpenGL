package com.baidu.searchbox.bigimage.comp.page.image.header;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import com.baidu.searchbox.bigimage.comp.page.image.LoaderCallBack;
import com.baidu.searchbox.bigimage.stat.BigImageBeeRenderStatKt;
import com.baidu.searchbox.nacomp.extension.util.Size;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J$\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/bigimage/comp/page/image/header/PicHeaderComp$imgLoaderCallback$1", "Lcom/baidu/searchbox/bigimage/comp/page/image/LoaderCallBack;", "isLoadSucceed", "", "onBitmapFetchFinish", "", "bitmap", "Landroid/graphics/Bitmap;", "onFailed", "onSucceed", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "animatable", "Landroid/graphics/drawable/Animatable;", "imageUrl", "", "onThumbSucceed", "thumbUrl", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PicHeaderComp.kt */
public final class PicHeaderComp$imgLoaderCallback$1 implements LoaderCallBack {
    private boolean isLoadSucceed;
    final /* synthetic */ PicHeaderComp this$0;

    PicHeaderComp$imgLoaderCallback$1(PicHeaderComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onSucceed(ImageInfo imageInfo, Animatable animatable, String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.isLoadSucceed = true;
        Function1<Boolean, Unit> onImgLoadFinish = this.this$0.getOnImgLoadFinish();
        if (onImgLoadFinish != null) {
            onImgLoadFinish.invoke(true);
        }
        this.this$0.setCurImageUrl(imageUrl);
        if (this.this$0.getParams().getEnterAnim()) {
            BigImageBeeRenderStatKt.beeRenderMonitorImageLoadEnd(this.this$0.getToken(), true);
        }
        this.this$0.imgAnimatable = animatable;
        PicHeaderComp picHeaderComp = this.this$0;
        int i2 = 0;
        int width = imageInfo != null ? imageInfo.getWidth() : 0;
        if (imageInfo != null) {
            i2 = imageInfo.getHeight();
        }
        picHeaderComp.onImgLoadSucceed(new Size(width, i2));
        this.this$0.syncAnimatableStatus();
    }

    public void onBitmapFetchFinish(Bitmap bitmap) {
    }

    public void onFailed() {
        Function1<Boolean, Unit> onImgLoadFinish = this.this$0.getOnImgLoadFinish();
        if (onImgLoadFinish != null) {
            onImgLoadFinish.invoke(false);
        }
        if (!((PicHeaderViewModel) this.this$0.getViewModel()).hasSetValidHolder$lib_search_bigimage_release()) {
            this.this$0.onImgLoadFailed();
        }
        if (this.this$0.getParams().getEnterAnim()) {
            BigImageBeeRenderStatKt.beeRenderMonitorImageLoadEnd(this.this$0.getToken(), false);
        }
    }

    public void onThumbSucceed(ImageInfo imageInfo, String thumbUrl) {
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        if (!this.isLoadSucceed) {
            this.this$0.setCurImageUrl(thumbUrl);
            PicHeaderComp picHeaderComp = this.this$0;
            int i2 = 0;
            int width = imageInfo != null ? imageInfo.getWidth() : 0;
            if (imageInfo != null) {
                i2 = imageInfo.getHeight();
            }
            picHeaderComp.onImgLoadSucceed(new Size(width, i2));
        }
    }
}
