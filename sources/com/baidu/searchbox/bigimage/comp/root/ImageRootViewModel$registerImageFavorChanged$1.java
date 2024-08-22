package com.baidu.searchbox.bigimage.comp.root;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bigimage.comp.root.favor.ImageFavorChangedEvent;
import com.baidu.searchbox.bigimage.comp.root.favor.ImageFavorManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bigimage/comp/root/ImageRootViewModel$registerImageFavorChanged$1", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/bigimage/comp/root/favor/ImageFavorChangedEvent;", "call", "", "type", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRootViewModel.kt */
public final class ImageRootViewModel$registerImageFavorChanged$1 implements Action<ImageFavorChangedEvent> {
    final /* synthetic */ ImageRootViewModel this$0;

    ImageRootViewModel$registerImageFavorChanged$1(ImageRootViewModel $receiver) {
        this.this$0 = $receiver;
    }

    public void call(ImageFavorChangedEvent type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Map changed = ImageFavorManager.INSTANCE.updateImageFavorStatus(type.getInfo(), this.this$0.imageInfos);
        if (!Intrinsics.areEqual((Object) type.getToken(), (Object) this.this$0.getToken$lib_search_bigimage_release())) {
            ImageInvokeParams params$lib_search_bigimage_release = this.this$0.getParams$lib_search_bigimage_release();
            boolean z = false;
            if (params$lib_search_bigimage_release != null && !params$lib_search_bigimage_release.isFromRelated()) {
                z = true;
            }
            if (z) {
                this.this$0.changedCollect.putAll(changed);
            }
        }
    }
}
