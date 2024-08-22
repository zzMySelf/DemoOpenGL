package com.baidu.swan.utils.fontsize;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/BitmapDrawable;", "dstWidth", "", "dstHeight", "srcDrawable", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeHelper.kt */
final class FontSizeHelper$getScaledBitmapDrawable$1 extends Lambda implements Function3<Float, Float, BitmapDrawable, BitmapDrawable> {
    public static final FontSizeHelper$getScaledBitmapDrawable$1 INSTANCE = new FontSizeHelper$getScaledBitmapDrawable$1();

    FontSizeHelper$getScaledBitmapDrawable$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke(((Number) p1).floatValue(), ((Number) p2).floatValue(), (BitmapDrawable) p3);
    }

    public final BitmapDrawable invoke(float dstWidth, float dstHeight, BitmapDrawable srcDrawable) {
        Intrinsics.checkNotNullParameter(srcDrawable, "srcDrawable");
        Bitmap dstBitmap = Bitmap.createScaledBitmap(srcDrawable.getBitmap(), MathKt.roundToInt(dstWidth), MathKt.roundToInt(dstHeight), true);
        Intrinsics.checkNotNullExpressionValue(dstBitmap, "createScaledBitmap(\n    …Int(), true\n            )");
        return new BitmapDrawable(ResUtil.getGlobalContext().getResources(), dstBitmap);
    }
}
