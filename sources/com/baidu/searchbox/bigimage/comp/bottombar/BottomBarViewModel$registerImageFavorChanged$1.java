package com.baidu.searchbox.bigimage.comp.bottombar;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.root.favor.ImageFavorChangedEvent;
import com.baidu.searchbox.bigimage.comp.root.favor.ImageFavorManagerKt;
import com.baidu.searchbox.bigimage.model.BigImageAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bigimage/comp/bottombar/BottomBarViewModel$registerImageFavorChanged$1", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/bigimage/comp/root/favor/ImageFavorChangedEvent;", "call", "", "type", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarViewModel.kt */
public final class BottomBarViewModel$registerImageFavorChanged$1 implements Action<ImageFavorChangedEvent> {
    final /* synthetic */ BottomBarViewModel this$0;

    BottomBarViewModel$registerImageFavorChanged$1(BottomBarViewModel $receiver) {
        this.this$0 = $receiver;
    }

    public void call(ImageFavorChangedEvent type) {
        BigImageAsset $this$call_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(type, "type");
        ImagePageParams access$getParams$p = this.this$0.params;
        if (access$getParams$p != null && ($this$call_u24lambda_u2d0 = access$getParams$p.getImageInfo()) != null) {
            BottomBarViewModel bottomBarViewModel = this.this$0;
            if (ImageFavorManagerKt.sameLike(type.getInfo(), $this$call_u24lambda_u2d0)) {
                bottomBarViewModel.isFavor$lib_search_bigimage_release().setValue(Boolean.valueOf($this$call_u24lambda_u2d0.isCollected() == 1));
            }
            if (Intrinsics.areEqual((Object) bottomBarViewModel.isFavor$lib_search_bigimage_release().getValue(), (Object) true) && Intrinsics.areEqual((Object) type.getInfo(), (Object) $this$call_u24lambda_u2d0)) {
                bottomBarViewModel.isShowFavorTip$lib_search_bigimage_release().setValue(true);
            }
        }
    }
}
