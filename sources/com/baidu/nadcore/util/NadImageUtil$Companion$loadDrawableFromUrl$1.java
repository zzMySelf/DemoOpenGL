package com.baidu.nadcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.nadcore.load.IImageLoadCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/nadcore/util/NadImageUtil$Companion$loadDrawableFromUrl$1", "Lcom/baidu/nadcore/load/IImageLoadCallback;", "onLoadError", "", "onLoadSuccess", "bitmap", "Landroid/graphics/Bitmap;", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadImageUtil.kt */
public final class NadImageUtil$Companion$loadDrawableFromUrl$1 implements IImageLoadCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<Drawable> $result;

    NadImageUtil$Companion$loadDrawableFromUrl$1(Ref.ObjectRef<Drawable> $result2, Context $context2) {
        this.$result = $result2;
        this.$context = $context2;
    }

    public void onLoadSuccess(Bitmap bitmap) {
        this.$result.element = new BitmapDrawable(this.$context.getResources(), bitmap);
    }

    public void onLoadError() {
    }
}
