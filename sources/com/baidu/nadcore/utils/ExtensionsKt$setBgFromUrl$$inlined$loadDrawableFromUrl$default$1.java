package com.baidu.nadcore.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.baidu.nadcore.load.IImageLoadCallback;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/baidu/nadcore/utils/ExtensionsKt$loadDrawableFromUrl$2", "Lcom/baidu/nadcore/load/IImageLoadCallback;", "onLoadError", "", "onLoadSuccess", "bitmap", "Landroid/graphics/Bitmap;", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* compiled from: Extensions.kt */
public final class ExtensionsKt$setBgFromUrl$$inlined$loadDrawableFromUrl$default$1 implements IImageLoadCallback {
    final /* synthetic */ Context $this_loadDrawableFromUrl;
    final /* synthetic */ View $this_setBgFromUrl$inlined;

    public ExtensionsKt$setBgFromUrl$$inlined$loadDrawableFromUrl$default$1(Context $receiver, View view2) {
        this.$this_loadDrawableFromUrl = $receiver;
        this.$this_setBgFromUrl$inlined = view2;
    }

    public void onLoadSuccess(Bitmap bitmap) {
        Unit unit;
        if (bitmap != null) {
            Bitmap bitmap2 = bitmap;
            this.$this_setBgFromUrl$inlined.setBackground(new BitmapDrawable(this.$this_loadDrawableFromUrl.getResources(), bitmap));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            onLoadError();
        }
    }

    public void onLoadError() {
    }
}
