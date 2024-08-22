package com.baidu.searchbox.bigimage.comp.page.image.menu;

import android.util.Log;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.ioc.IImageEdit;
import com.baidu.searchbox.bigimage.ioc.IImageRouter;
import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/bigimage/comp/page/image/menu/ImageEditMenu$editCallback$1", "Lcom/baidu/searchbox/bigimage/ioc/IImageEdit$EditCallback;", "onFailed", "", "code", "", "msg", "", "onSuccess", "base64", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageEditMenu.kt */
public final class ImageEditMenu$editCallback$1 implements IImageEdit.EditCallback {
    final /* synthetic */ ImageEditMenu this$0;

    ImageEditMenu$editCallback$1(ImageEditMenu $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess(String base64) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        ImagePageParams it = this.this$0.getParams();
        if (it != null) {
            IImageRouter.Companion.getImpl().startEditResultPage(base64, it, it.getExtra843());
        }
    }

    public void onFailed(int code, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (BigImageRuntime.GLOBAL_DEBUG) {
            Log.w("ImageEditMenu", "调起编辑插件失败： code: " + code + ", msg: " + msg);
        }
    }
}
