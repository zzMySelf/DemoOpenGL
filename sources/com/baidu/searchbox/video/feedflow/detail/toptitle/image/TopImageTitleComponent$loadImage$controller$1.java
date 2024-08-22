package com.baidu.searchbox.video.feedflow.detail.toptitle.image;

import android.graphics.drawable.Animatable;
import com.baidu.searchbox.flowvideo.toptitle.TitleImageModel;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/toptitle/image/TopImageTitleComponent$loadImage$controller$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopImageTitleComponent.kt */
public final class TopImageTitleComponent$loadImage$controller$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ TitleImageModel $titleImageModel;
    final /* synthetic */ TopImageTitleComponent this$0;

    TopImageTitleComponent$loadImage$controller$1(TopImageTitleComponent $receiver, TitleImageModel $titleImageModel2) {
        this.this$0 = $receiver;
        this.$titleImageModel = $titleImageModel2;
    }

    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.this$0.onImageLoadSuccess(this.$titleImageModel, imageInfo);
    }

    public void onFailure(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.this$0.onImageLoadFailed();
    }
}
