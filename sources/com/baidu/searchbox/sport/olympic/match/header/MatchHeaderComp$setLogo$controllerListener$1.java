package com.baidu.searchbox.sport.olympic.match.header;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/sport/olympic/match/header/MatchHeaderComp$setLogo$controllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFinalImageSet", "", "id", "", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MatchHeaderComp.kt */
public final class MatchHeaderComp$setLogo$controllerListener$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ SimpleDraweeView $iconView;

    MatchHeaderComp$setLogo$controllerListener$1(SimpleDraweeView $iconView2) {
        this.$iconView = $iconView2;
    }

    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        if (imageInfo != null) {
            float ratio = ((float) imageInfo.getWidth()) / ((float) imageInfo.getHeight());
            this.$iconView.getLayoutParams().width = (int) (((float) this.$iconView.getLayoutParams().height) * ratio);
            this.$iconView.setAspectRatio(ratio);
        }
    }
}
