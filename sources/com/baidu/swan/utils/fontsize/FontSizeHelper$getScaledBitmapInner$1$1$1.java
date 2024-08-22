package com.baidu.swan.utils.fontsize;

import android.graphics.Bitmap;
import com.baidu.swan.utils.fontsize.FontSizeHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeHelper.kt */
final class FontSizeHelper$getScaledBitmapInner$1$1$1 extends Lambda implements Function0<Bitmap> {
    final /* synthetic */ Bitmap $it;
    final /* synthetic */ FontSizeHelper.Scaled2DSizeInfo $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontSizeHelper$getScaledBitmapInner$1$1$1(Bitmap bitmap, FontSizeHelper.Scaled2DSizeInfo scaled2DSizeInfo) {
        super(0);
        this.$it = bitmap;
        this.$this_run = scaled2DSizeInfo;
    }

    public final Bitmap invoke() {
        return Bitmap.createScaledBitmap(this.$it, MathKt.roundToInt(this.$this_run.getScaledWidth()), MathKt.roundToInt(this.$this_run.getScaledHeight()), true);
    }
}
