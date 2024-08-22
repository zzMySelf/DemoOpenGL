package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.nadcore.load.IImageLoadCallback;
import com.baidu.nadcore.utils.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/baidu/nadcore/utils/ExtensionsKt$loadDrawableFromUrl$2", "Lcom/baidu/nadcore/load/IImageLoadCallback;", "onLoadError", "", "onLoadSuccess", "bitmap", "Landroid/graphics/Bitmap;", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Extensions.kt */
public final class NadRewardVideoDialog$buildButton$$inlined$loadDrawableFromUrl$default$1 implements IImageLoadCallback {
    final /* synthetic */ TextView $button$inlined;
    final /* synthetic */ Context $localContext$inlined;
    final /* synthetic */ Context $this_loadDrawableFromUrl;

    public NadRewardVideoDialog$buildButton$$inlined$loadDrawableFromUrl$default$1(Context $receiver, Context context, TextView textView) {
        this.$this_loadDrawableFromUrl = $receiver;
        this.$localContext$inlined = context;
        this.$button$inlined = textView;
    }

    public void onLoadSuccess(Bitmap bitmap) {
        Unit unit = null;
        if (bitmap != null) {
            Bitmap bitmap2 = bitmap;
            Drawable it = new BitmapDrawable(this.$this_loadDrawableFromUrl.getResources(), bitmap);
            it.setBounds(0, 0, ExtensionsKt.px(10, this.$localContext$inlined), ExtensionsKt.px(10, this.$localContext$inlined));
            this.$button$inlined.setCompoundDrawables((Drawable) null, (Drawable) null, it, (Drawable) null);
            this.$button$inlined.setCompoundDrawablePadding(ExtensionsKt.px(2, this.$localContext$inlined));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            onLoadError();
        }
    }

    public void onLoadError() {
    }
}
