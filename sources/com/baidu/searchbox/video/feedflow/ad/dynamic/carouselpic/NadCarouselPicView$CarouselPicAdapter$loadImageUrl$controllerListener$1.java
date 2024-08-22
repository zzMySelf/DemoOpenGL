package com.baidu.searchbox.video.feedflow.ad.dynamic.carouselpic;

import android.graphics.drawable.Animatable;
import com.baidu.searchbox.video.feedflow.ad.dynamic.CarouselPicModel;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/video/feedflow/ad/dynamic/carouselpic/NadCarouselPicView$CarouselPicAdapter$loadImageUrl$controllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCarouselPicView.kt */
public final class NadCarouselPicView$CarouselPicAdapter$loadImageUrl$controllerListener$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ CarouselPicModel $imageModel;
    final /* synthetic */ NadCarouselPicView this$0;

    NadCarouselPicView$CarouselPicAdapter$loadImageUrl$controllerListener$1(CarouselPicModel $imageModel2, NadCarouselPicView $receiver) {
        this.$imageModel = $imageModel2;
        this.this$0 = $receiver;
    }

    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        super.onFinalImageSet(id, imageInfo, animatable);
        this.$imageModel.setLoadSuccess(true);
        Function2<CarouselPicModel, Boolean, Unit> onCarouselPicLoadResult = this.this$0.getOnCarouselPicLoadResult();
        if (onCarouselPicLoadResult != null) {
            onCarouselPicLoadResult.invoke(this.$imageModel, true);
        }
    }

    public void onFailure(String id, Throwable throwable) {
        super.onFailure(id, throwable);
        this.$imageModel.setLoadSuccess(false);
        Function2<CarouselPicModel, Boolean, Unit> onCarouselPicLoadResult = this.this$0.getOnCarouselPicLoadResult();
        if (onCarouselPicLoadResult != null) {
            onCarouselPicLoadResult.invoke(this.$imageModel, false);
        }
    }
}
