package com.baidu.searchbox.config;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import com.baidu.searchbox.config.utils.DisplayUtilsKt;
import com.baidu.searchbox.config.utils.FontSizeSharedPrefs;
import com.baidu.searchbox.config.utils.ReflectionUtil;
import com.baidu.searchbox.config.utils.ResUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@StableApi
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002lmB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u0004H\u0007J\\\u0010 \u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u0001H!2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u001e\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0004H\u0007J\b\u0010'\u001a\u00020\u0004H\u0007J8\u0010(\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\"\u001a\u0002H!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0004H\b¢\u0006\u0002\u0010,J)\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ1\u00100\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ&\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J5\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\bJ.\u0010:\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J7\u0010;\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\bJ.\u0010<\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J&\u0010=\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J.\u0010>\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J7\u0010?\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\bJ5\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\bJ&\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010B\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J$\u0010C\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J.\u0010E\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J-\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ\u0010\u0010I\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0019\u0010I\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ\u001b\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0007J\"\u0010L\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J\"\u0010M\u001a\u00020N2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J \u0010Q\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\b\u0010R\u001a\u00020\u0007H\u0007J)\u0010S\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ\u001a\u0010T\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H\u0007J$\u0010T\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J \u0010U\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0004H\u0007JD\u0010V\u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u0001H!2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\b¢\u0006\u0002\u0010WJ\t\u0010X\u001a\u00020\u0004H\bJ%\u0010Y\u001a\u0004\u0018\u0001052\b\u00109\u001a\u0004\u0018\u0001052\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050[H\bJ%\u0010Y\u001a\u0004\u0018\u00010\u001e2\b\u00109\u001a\u0004\u0018\u00010\u001e2\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0[H\bJ)\u0010\\\u001a\u00020D2\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0014\u0010Z\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020D0]H\bJ\t\u0010^\u001a\u00020\u0019H\bJ\b\u0010_\u001a\u00020\u0019H\u0007J\u0011\u0010`\u001a\u0002052\u0006\u00109\u001a\u00020\u001eH\bJ\b\u0010a\u001a\u00020NH\u0007J)\u0010b\u001a\u00020N2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010c\u001a\u00020d2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\bJ6\u0010e\u001a\u00020f2\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0h2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020P0h2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J\u000e\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0012j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper;", "", "()V", "FONT_SIZE_TYPE_OFFSET", "", "SCALED_RATIO_CONTENT", "", "", "[Ljava/lang/Float;", "SCALED_RATIO_DEFAULT", "SCALED_RATIO_FRAMEWORK", "SCALED_RATIO_H", "SCALED_RATIO_NONE", "SCALED_RATIO_T", "TAG", "", "mCustomerRatioIndex", "mCustomerRatios", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTargetLevel", "addCustomerRatio", "array", "([Ljava/lang/Float;)I", "checkScaledRequired", "", "type", "baseFontSize", "targetFontSize", "getDrawableByResId", "Landroid/graphics/drawable/Drawable;", "resId", "getDrawableWithScaledOperation", "T", "srcDrawable", "scaledOperation", "Lkotlin/Function3;", "(ILandroid/graphics/drawable/Drawable;IILkotlin/jvm/functions/Function3;)Landroid/graphics/drawable/Drawable;", "getFontSizeType", "getIOSFontSizeType", "getMListDrawable", "dstWidth", "dstHeight", "numRoundPolicy", "(Landroid/graphics/drawable/Drawable;FFI)Landroid/graphics/drawable/Drawable;", "getScaled1DSizeInfo", "Lcom/baidu/searchbox/config/FontSizeHelper$Scaled1DSizeInfo;", "size", "getScaled2DSizeInfo", "Lcom/baidu/searchbox/config/FontSizeHelper$Scaled2DSizeInfo;", "width", "height", "getScaledBitmap", "Landroid/graphics/Bitmap;", "bitmap", "getScaledBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "drawable", "getScaledBitmapForTargetFontSize", "getScaledBitmapInner", "getScaledBitmapWithBaseFontSize", "getScaledDrawable", "getScaledDrawableForTargetFontSize", "getScaledDrawableInner", "getScaledDrawableNotSafe", "getScaledDrawableRes", "drawableId", "getScaledDrawableSize", "Lcom/baidu/searchbox/config/FontScaledSize;", "getScaledDrawableWithBaseFontSize", "getScaledNinePatchDrawable", "Landroid/graphics/drawable/NinePatchDrawable;", "ninePatchDrawable", "getScaledRatio", "getScaledRatioArray", "(I)[Ljava/lang/Float;", "getScaledSize", "getScaledSizeArray", "", "sizeArray", "", "getScaledSizeForTargetFontSize", "getScaledSizeH", "getScaledSizeInner", "getScaledSizeRes", "getScaledSizeWithBaseFontSize", "getScaledStateListDrawable", "(ILandroid/graphics/drawable/Drawable;III)Landroid/graphics/drawable/Drawable;", "getTargetLevel", "handleErrorException", "block", "Lkotlin/Function0;", "handleException", "Lkotlin/Function1;", "isDebug", "isFontSizeBigger", "parseDrawableToBitmap", "reloadTargetLevelFromSp", "scaledGradientDrawable", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setScaledStateListDrawable", "Landroid/graphics/drawable/StateListDrawable;", "drawableList", "", "statesList", "setTargetLevel", "level", "Scaled1DSizeInfo", "Scaled2DSizeInfo", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeHelper.kt */
public final class FontSizeHelper {
    private static final int FONT_SIZE_TYPE_OFFSET = 1;
    public static final FontSizeHelper INSTANCE = new FontSizeHelper();
    /* access modifiers changed from: private */
    public static final Float[] SCALED_RATIO_CONTENT;
    private static final float SCALED_RATIO_DEFAULT = 1.0f;
    /* access modifiers changed from: private */
    public static final Float[] SCALED_RATIO_FRAMEWORK;
    /* access modifiers changed from: private */
    public static final Float[] SCALED_RATIO_H;
    private static final Float[] SCALED_RATIO_NONE;
    /* access modifiers changed from: private */
    public static final Float[] SCALED_RATIO_T;
    private static final String TAG = "FontSizeHelper";
    private static int mCustomerRatioIndex = 10;
    /* access modifiers changed from: private */
    public static final HashMap<Integer, Float[]> mCustomerRatios = new HashMap<>();
    private static int mTargetLevel;

    @JvmStatic
    @PluginAccessible
    public static final Bitmap getScaledBitmap(int i2, Bitmap bitmap) {
        return getScaledBitmap$default(i2, bitmap, 0, 4, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final Bitmap getScaledBitmapForTargetFontSize(int i2, Bitmap bitmap, int i3) {
        return getScaledBitmapForTargetFontSize$default(i2, bitmap, i3, 0, 8, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final Bitmap getScaledBitmapWithBaseFontSize(int i2, Bitmap bitmap, int i3) {
        return getScaledBitmapWithBaseFontSize$default(i2, bitmap, i3, 0, 8, (Object) null);
    }

    @JvmStatic
    @Deprecated(message = "此方法为耗时方法，使用时务必确保该场景对性能要求不高，可能耗时数毫秒")
    @PluginAccessible
    public static final Drawable getScaledDrawable(int i2, Drawable drawable) {
        return getScaledDrawable$default(i2, drawable, 0, 4, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final Drawable getScaledDrawableForTargetFontSize(int i2, Drawable drawable, int i3) {
        return getScaledDrawableForTargetFontSize$default(i2, drawable, i3, 0, 8, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final Drawable getScaledDrawableRes(int i2, int i3) {
        return getScaledDrawableRes$default(i2, i3, 0, 4, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final FontScaledSize getScaledDrawableSize(int i2, Drawable drawable) {
        return getScaledDrawableSize$default(i2, drawable, 0, 4, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final Drawable getScaledDrawableWithBaseFontSize(int i2, Drawable drawable, int i3) {
        return getScaledDrawableWithBaseFontSize$default(i2, drawable, i3, 0, 8, (Object) null);
    }

    @JvmStatic
    @PluginAccessible
    public static final StateListDrawable setScaledStateListDrawable(int i2, List<? extends Drawable> list, List<int[]> list2) {
        Intrinsics.checkNotNullParameter(list, "drawableList");
        Intrinsics.checkNotNullParameter(list2, "statesList");
        return setScaledStateListDrawable$default(i2, list, list2, 0, 8, (Object) null);
    }

    private FontSizeHelper() {
    }

    static {
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(1.16f);
        Float valueOf3 = Float.valueOf(1.41f);
        SCALED_RATIO_FRAMEWORK = new Float[]{valueOf, valueOf, valueOf2, valueOf3, valueOf3};
        Float valueOf4 = Float.valueOf(0.88f);
        SCALED_RATIO_CONTENT = new Float[]{valueOf4, valueOf, valueOf2, valueOf3, Float.valueOf(1.66f)};
        Float valueOf5 = Float.valueOf(1.21f);
        SCALED_RATIO_H = new Float[]{Float.valueOf(0.86f), valueOf, Float.valueOf(1.06f), valueOf5, valueOf5};
        SCALED_RATIO_T = new Float[]{valueOf4, valueOf, valueOf2, valueOf3, valueOf3};
        SCALED_RATIO_NONE = new Float[]{valueOf, valueOf, valueOf, valueOf, valueOf};
        mTargetLevel = 1;
        mTargetLevel = FontSizeSharedPrefs.INSTANCE.getInt("key_text_size", 1);
    }

    @JvmStatic
    @PluginAccessible
    public static final float getScaledSize(int type, float size) {
        int i2;
        FontSizeHelper this_$iv$iv$iv;
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        FontSizeHelper this_$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int targetFontSize$iv = i2;
        FontSizeHelper this_$iv$iv = this_$iv;
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            this_$iv$iv$iv = null;
        } else if (type == 0 && targetFontSize$iv == 0) {
            this_$iv$iv$iv = null;
        } else {
            if (((targetFontSize$iv < 0 || targetFontSize$iv >= 5) ? 0 : 1) == 0) {
                this_$iv$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv$iv = null;
            } else {
                this_$iv$iv$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv$iv$iv == null) {
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(false, 1.0f, size);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            switch (type) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f2;
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(true, ratio$iv$iv, size * ratio$iv$iv);
        }
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            return size;
        }
        return $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
    }

    @JvmStatic
    @PluginAccessible
    public static final float getScaledSizeRes(int type, int resId) {
        int i2;
        FontSizeHelper this_$iv$iv$iv;
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        FontSizeHelper this_$iv = INSTANCE;
        float size$iv = ResUtil.getDimenByResId(resId);
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int targetFontSize$iv = i2;
        FontSizeHelper this_$iv$iv = this_$iv;
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            this_$iv$iv$iv = null;
        } else if (type == 0 && targetFontSize$iv == 0) {
            this_$iv$iv$iv = null;
        } else {
            if (((targetFontSize$iv < 0 || targetFontSize$iv >= 5) ? 0 : 1) == 0) {
                this_$iv$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv$iv = null;
            } else {
                this_$iv$iv$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv$iv$iv == null) {
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(false, 1.0f, size$iv);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            switch (type) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f2;
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(true, ratio$iv$iv, size$iv * ratio$iv$iv);
        }
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            return size$iv;
        }
        return $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
    }

    public static /* synthetic */ int getScaledSize$default(int i2, float f2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledSize(i2, f2, i3);
    }

    @JvmStatic
    @PluginAccessible
    public static final int getScaledSize(int type, float size, int numRoundPolicy) {
        int i2;
        FontSizeHelper this_$iv$iv$iv;
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv;
        float f2;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        FontSizeHelper this_$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int targetFontSize$iv = i2;
        FontSizeHelper this_$iv$iv = this_$iv;
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            this_$iv$iv$iv = null;
        } else if (type == 0 && targetFontSize$iv == 0) {
            this_$iv$iv$iv = null;
        } else {
            if (((targetFontSize$iv < 0 || targetFontSize$iv >= 5) ? 0 : 1) == 0) {
                this_$iv$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv$iv = null;
            } else {
                this_$iv$iv$iv = 1;
            }
        }
        float f3 = 1.0f;
        if (this_$iv$iv$iv == null) {
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(false, 1.0f, size);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            switch (type) {
                case 0:
                    f3 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f3 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f3 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f3 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f3 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f3;
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(true, ratio$iv$iv, size * ratio$iv$iv);
        }
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            f2 = size;
        } else {
            f2 = $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
        }
        float $this$roundByPolicy$iv = f2;
        switch (numRoundPolicy) {
            case 0:
                return (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
            case 1:
                return (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
            case 2:
                return MathKt.roundToInt($this$roundByPolicy$iv);
            default:
                return MathKt.roundToInt($this$roundByPolicy$iv);
        }
    }

    public static /* synthetic */ int getScaledSizeRes$default(int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 2;
        }
        return getScaledSizeRes(i2, i3, i4);
    }

    @JvmStatic
    @PluginAccessible
    public static final int getScaledSizeRes(int type, int resId, int numRoundPolicy) {
        int i2;
        FontSizeHelper this_$iv$iv$iv;
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv;
        float f2;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        FontSizeHelper this_$iv = INSTANCE;
        float size$iv = ResUtil.getDimenByResId(resId);
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int targetFontSize$iv = i2;
        FontSizeHelper this_$iv$iv = this_$iv;
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            this_$iv$iv$iv = null;
        } else if (type == 0 && targetFontSize$iv == 0) {
            this_$iv$iv$iv = null;
        } else {
            if (((targetFontSize$iv < 0 || targetFontSize$iv >= 5) ? 0 : 1) == 0) {
                this_$iv$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv$iv = null;
            } else {
                this_$iv$iv$iv = 1;
            }
        }
        float f3 = 1.0f;
        if (this_$iv$iv$iv == null) {
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(false, 1.0f, size$iv);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            switch (type) {
                case 0:
                    f3 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f3 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f3 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f3 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f3 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f3;
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(true, ratio$iv$iv, size$iv * ratio$iv$iv);
        }
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            f2 = size$iv;
        } else {
            f2 = $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
        }
        float $this$roundByPolicy$iv = f2;
        switch (numRoundPolicy) {
            case 0:
                return (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
            case 1:
                return (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
            case 2:
                return MathKt.roundToInt($this$roundByPolicy$iv);
            default:
                return MathKt.roundToInt($this$roundByPolicy$iv);
        }
    }

    public static /* synthetic */ void getScaledSizeArray$default(int i2, int[] iArr, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        getScaledSizeArray(i2, iArr, i3);
    }

    @JvmStatic
    @PluginAccessible
    public static final void getScaledSizeArray(int type, int[] sizeArray, int numRoundPolicy) {
        int i2;
        int[] iArr = sizeArray;
        Intrinsics.checkNotNullParameter(iArr, "sizeArray");
        float ratio = getScaledRatio(type);
        int i3 = 0;
        if (!(ratio == 1.0f)) {
            int[] $this$forEachIndexed$iv = sizeArray;
            int index$iv = 0;
            int length = $this$forEachIndexed$iv.length;
            while (i3 < length) {
                int index$iv2 = index$iv + 1;
                float $this$roundByPolicy$iv = ((float) $this$forEachIndexed$iv[i3]) * ratio;
                switch (numRoundPolicy) {
                    case 0:
                        i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
                        break;
                    case 1:
                        i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
                        break;
                    case 2:
                        i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                        break;
                    default:
                        i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                        break;
                }
                iArr[index$iv] = i2;
                i3++;
                index$iv = index$iv2;
            }
        }
    }

    @JvmStatic
    @PluginAccessible
    public static final float getScaledSizeH() {
        return SCALED_RATIO_H[getFontSizeType()].floatValue();
    }

    @JvmStatic
    @PluginAccessible
    public static final int getFontSizeType() {
        int i2;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int type = i2;
        if (type >= 0 && type < 5) {
            return type;
        }
        return 1;
    }

    @JvmStatic
    @PluginAccessible
    public static final int getIOSFontSizeType() {
        return getFontSizeType() + 1;
    }

    @JvmStatic
    @PluginAccessible
    public static final boolean isFontSizeBigger() {
        return getFontSizeType() > 1;
    }

    @JvmStatic
    @Deprecated(message = "使用此方法仅适用于矩阵产品")
    @PluginAccessible
    public static final float getScaledSizeWithBaseFontSize(int type, float size, int baseFontSize) {
        int i2;
        boolean z;
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv;
        float f2;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv;
        float f3;
        if (((baseFontSize < 0 || baseFontSize >= 5) ? 0 : 1) == 0) {
            return size;
        }
        FontSizeHelper this_$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            i2 = 1;
        } else {
            i2 = mTargetLevel;
        }
        int targetFontSize$iv = i2;
        FontSizeHelper this_$iv$iv = this_$iv;
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            z = false;
        } else if (type == 0 && targetFontSize$iv == 0) {
            z = false;
        } else {
            if (!(targetFontSize$iv >= 0 && targetFontSize$iv < 5)) {
                z = false;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                z = false;
            } else {
                z = true;
            }
        }
        float f4 = 1.0f;
        if (!z) {
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(false, 1.0f, size);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            switch (type) {
                case 0:
                    f3 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f3 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f3 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f3 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (!mCustomerRatios.containsKey(Integer.valueOf(type))) {
                        f3 = 1.0f;
                        break;
                    } else {
                        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type));
                        if ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv == null) {
                            f3 = 1.0f;
                            break;
                        } else {
                            f3 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                            break;
                        }
                    }
            }
            float ratio$iv$iv = f3;
            $this$getScaledSizeInner_u24lambda_u2d7$iv = new Scaled1DSizeInfo(true, ratio$iv$iv, size * ratio$iv$iv);
        }
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            f2 = size;
        } else {
            f2 = $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
        }
        FontSizeHelper this_$iv2 = INSTANCE;
        switch (type) {
            case 0:
                f4 = SCALED_RATIO_FRAMEWORK[baseFontSize].floatValue();
                break;
            case 1:
                f4 = SCALED_RATIO_CONTENT[baseFontSize].floatValue();
                break;
            case 2:
                f4 = SCALED_RATIO_H[baseFontSize].floatValue();
                break;
            case 3:
                f4 = SCALED_RATIO_T[baseFontSize].floatValue();
                break;
            default:
                if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                    f4 = $this$getScaledRatio_u24lambda_u2d28$iv[baseFontSize].floatValue();
                    break;
                }
        }
        return f2 / f4;
    }

    @JvmStatic
    @PluginAccessible
    public static final float getScaledSizeForTargetFontSize(int type, float size, int targetFontSize) {
        FontSizeHelper this_$iv$iv$iv;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        FontSizeHelper this_$iv$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = this_$iv$iv;
        if (targetFontSize == 1) {
            this_$iv$iv$iv = null;
        } else if (type == 0 && targetFontSize == 0) {
            this_$iv$iv$iv = null;
        } else {
            if (((targetFontSize < 0 || targetFontSize >= 5) ? 0 : 1) == 0) {
                this_$iv$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv$iv = null;
            } else {
                this_$iv$iv$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv$iv$iv == null) {
            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, size);
        } else {
            FontSizeHelper fontSizeHelper2 = this_$iv$iv;
            switch (type) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f2;
            scaled1DSizeInfo = new Scaled1DSizeInfo(true, ratio$iv$iv, size * ratio$iv$iv);
        }
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv = scaled1DSizeInfo;
        if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
            return size;
        }
        return $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
    }

    public static /* synthetic */ Bitmap getScaledBitmap$default(int i2, Bitmap bitmap, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledBitmap(i2, bitmap, i3);
    }

    @JvmStatic
    @PluginAccessible
    public static final Bitmap getScaledBitmap(int type, Bitmap bitmap, int numRoundPolicy) {
        int targetFontSize$iv;
        boolean z;
        Scaled2DSizeInfo $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv;
        int i2;
        int i3;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        int i4 = type;
        FontSizeHelper this_$iv$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            targetFontSize$iv = 1;
        } else {
            targetFontSize$iv = mTargetLevel;
        }
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (bitmap == null) {
            return null;
        }
        Bitmap it$iv = bitmap;
        float width$iv$iv = (float) it$iv.getWidth();
        float height$iv$iv = (float) it$iv.getHeight();
        FontSizeHelper fontSizeHelper3 = this_$iv$iv;
        if (targetFontSize$iv == 1) {
            z = false;
        } else if (i4 == 0 && targetFontSize$iv == 0) {
            z = false;
        } else {
            if (!(targetFontSize$iv >= 0 && targetFontSize$iv < 5)) {
                z = false;
            } else if ((i4 <= -1 || i4 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv = new Scaled2DSizeInfo(false, width$iv$iv, height$iv$iv);
        } else {
            FontSizeHelper fontSizeHelper4 = this_$iv$iv;
            float f2 = 1.0f;
            switch (i4) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f2;
            $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv = new Scaled2DSizeInfo(true, width$iv$iv * ratio$iv$iv, height$iv$iv * ratio$iv$iv);
        }
        if (!$this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.isScaledRequired()) {
            return it$iv;
        }
        FontSizeHelper this_$iv$iv2 = INSTANCE;
        try {
            float $this$roundByPolicy$iv$iv = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.getScaledWidth();
            switch (numRoundPolicy) {
                case 0:
                    i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv$iv));
                    break;
                case 1:
                    i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv$iv));
                    break;
                case 2:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv$iv);
                    break;
                default:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv$iv);
                    break;
            }
            float $this$roundByPolicy$iv$iv2 = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.getScaledHeight();
            switch (numRoundPolicy) {
                case 0:
                    i3 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv$iv2));
                    break;
                case 1:
                    i3 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv$iv2));
                    break;
                case 2:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv$iv2);
                    break;
                default:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv$iv2);
                    break;
            }
            return Bitmap.createScaledBitmap(it$iv, i2, i3, true);
        } catch (Error e$iv$iv) {
            FontSizeHelper fontSizeHelper5 = this_$iv$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv$iv.printStackTrace();
            }
            return it$iv;
        } catch (Exception e$iv$iv2) {
            FontSizeHelper fontSizeHelper6 = this_$iv$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv$iv2.printStackTrace();
            }
            return it$iv;
        }
    }

    public static /* synthetic */ Bitmap getScaledBitmapWithBaseFontSize$default(int i2, Bitmap bitmap, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        return getScaledBitmapWithBaseFontSize(i2, bitmap, i3, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0132, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        return android.graphics.Bitmap.createScaledBitmap(r6, r14, r5, true);
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0162  */
    @kotlin.jvm.JvmStatic
    @com.baidu.pyramid.annotation.nps.PluginAccessible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap getScaledBitmapWithBaseFontSize(int r17, android.graphics.Bitmap r18, int r19, int r20) {
        /*
            r1 = r17
            com.baidu.searchbox.config.FontSizeHelper r0 = INSTANCE
            com.baidu.searchbox.config.FontSizeHelper r2 = INSTANCE
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBizFun r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBizFun()
            boolean r4 = r4.isSupportFontSize()
            r5 = 1
            if (r4 != 0) goto L_0x0014
            r4 = r5
            goto L_0x0016
        L_0x0014:
            int r4 = mTargetLevel
        L_0x0016:
            r2 = r0
            r3 = r4
            r4 = 0
            if (r18 == 0) goto L_0x016b
            r6 = r18
            r7 = 0
            int r8 = r6.getWidth()
            float r8 = (float) r8
            int r9 = r6.getHeight()
            float r9 = (float) r9
            r10 = 0
            r11 = r0
            r12 = 0
            r13 = 0
            if (r3 != r5) goto L_0x0032
            r11 = r13
            goto L_0x005c
        L_0x0032:
            if (r1 != 0) goto L_0x0038
            if (r3 != 0) goto L_0x0038
            r11 = r13
            goto L_0x005c
        L_0x0038:
            r14 = 0
            if (r3 < 0) goto L_0x0040
            r15 = 5
            if (r3 >= r15) goto L_0x0040
            r14 = r5
            goto L_0x0041
        L_0x0040:
            r14 = r13
        L_0x0041:
            if (r14 != 0) goto L_0x0045
            r11 = r13
            goto L_0x005c
        L_0x0045:
            r14 = -1
            if (r1 <= r14) goto L_0x004b
            r14 = 4
            if (r1 < r14) goto L_0x005b
        L_0x004b:
            java.util.HashMap r14 = mCustomerRatios
            java.lang.Integer r15 = java.lang.Integer.valueOf(r17)
            boolean r14 = r14.containsKey(r15)
            if (r14 != 0) goto L_0x005b
            r11 = r13
            goto L_0x005c
        L_0x005b:
            r11 = r5
        L_0x005c:
            if (r11 != 0) goto L_0x0065
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo
            r11.<init>(r13, r8, r9)
            goto L_0x00cd
        L_0x0065:
            r11 = r0
            r12 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            switch(r1) {
                case 0: goto L_0x00b4;
                case 1: goto L_0x00a9;
                case 2: goto L_0x009e;
                case 3: goto L_0x0093;
                default: goto L_0x006c;
            }
        L_0x006c:
            java.util.HashMap r14 = mCustomerRatios
            java.lang.Integer r15 = java.lang.Integer.valueOf(r17)
            boolean r14 = r14.containsKey(r15)
            if (r14 == 0) goto L_0x00c0
            java.util.HashMap r14 = mCustomerRatios
            java.lang.Integer r15 = java.lang.Integer.valueOf(r17)
            java.lang.Object r14 = r14.get(r15)
            java.lang.Float[] r14 = (java.lang.Float[]) r14
            if (r14 == 0) goto L_0x00bf
            r13 = r14
            r14 = 0
            r15 = r13[r3]
            float r13 = r15.floatValue()
            goto L_0x00c1
        L_0x0093:
            java.lang.Float[] r13 = SCALED_RATIO_T
            r13 = r13[r3]
            float r13 = r13.floatValue()
            goto L_0x00c1
        L_0x009e:
            java.lang.Float[] r13 = SCALED_RATIO_H
            r13 = r13[r3]
            float r13 = r13.floatValue()
            goto L_0x00c1
        L_0x00a9:
            java.lang.Float[] r13 = SCALED_RATIO_CONTENT
            r13 = r13[r3]
            float r13 = r13.floatValue()
            goto L_0x00c1
        L_0x00b4:
            java.lang.Float[] r13 = SCALED_RATIO_FRAMEWORK
            r13 = r13[r3]
            float r13 = r13.floatValue()
            goto L_0x00c1
        L_0x00bf:
            goto L_0x00c1
        L_0x00c0:
        L_0x00c1:
            r11 = r13
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo
            float r13 = r8 * r11
            float r14 = r9 * r11
            r12.<init>(r5, r13, r14)
            r11 = r12
        L_0x00cd:
            r8 = r11
            r9 = 0
            boolean r0 = r8.isScaledRequired()
            if (r0 != 0) goto L_0x00d8
            r5 = r6
            goto L_0x0168
        L_0x00d8:
            com.baidu.searchbox.config.FontSizeHelper r10 = INSTANCE
            r11 = 0
            r0 = 0
            float r12 = r8.getScaledWidth()     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            r13 = 0
            switch(r20) {
                case 0: goto L_0x00f7;
                case 1: goto L_0x00ef;
                case 2: goto L_0x00ea;
                default: goto L_0x00e5;
            }     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
        L_0x00e5:
            int r14 = kotlin.math.MathKt.roundToInt((float) r12)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            goto L_0x00fe
        L_0x00ea:
            int r14 = kotlin.math.MathKt.roundToInt((float) r12)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            goto L_0x00fe
        L_0x00ef:
            double r14 = (double) r12     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            goto L_0x00fe
        L_0x00f7:
            double r14 = (double) r12     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
        L_0x00fe:
            float r12 = r8.getScaledHeight()     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            r13 = 0
            switch(r20) {
                case 0: goto L_0x0120;
                case 1: goto L_0x0116;
                case 2: goto L_0x010e;
                default: goto L_0x0107;
            }
        L_0x0107:
            r16 = r6
            int r5 = kotlin.math.MathKt.roundToInt((float) r12)     // Catch:{ Error -> 0x0140, Exception -> 0x013c }
            goto L_0x0132
        L_0x010e:
            int r15 = kotlin.math.MathKt.roundToInt((float) r12)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            r16 = r6
            r5 = r15
            goto L_0x0132
        L_0x0116:
            r16 = r6
            double r5 = (double) r12
            double r5 = java.lang.Math.floor(r5)     // Catch:{ Error -> 0x012e, Exception -> 0x012a }
            float r5 = (float) r5     // Catch:{ Error -> 0x012e, Exception -> 0x012a }
            int r5 = (int) r5     // Catch:{ Error -> 0x012e, Exception -> 0x012a }
            goto L_0x0132
        L_0x0120:
            r16 = r6
            double r5 = (double) r12     // Catch:{ Error -> 0x012e, Exception -> 0x012a }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ Error -> 0x012e, Exception -> 0x012a }
            float r5 = (float) r5
            int r5 = (int) r5
            goto L_0x0132
        L_0x012a:
            r0 = move-exception
            r6 = r16
            goto L_0x0145
        L_0x012e:
            r0 = move-exception
            r6 = r16
            goto L_0x0156
        L_0x0132:
            r6 = r16
            r12 = 1
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createScaledBitmap(r6, r14, r5, r12)     // Catch:{ Error -> 0x0155, Exception -> 0x0144 }
            goto L_0x0167
        L_0x013c:
            r0 = move-exception
            r6 = r16
            goto L_0x0145
        L_0x0140:
            r0 = move-exception
            r6 = r16
            goto L_0x0156
        L_0x0144:
            r0 = move-exception
        L_0x0145:
            r5 = r10
            r12 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r13 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r5 = r13.isDebug()
            if (r5 == 0) goto L_0x0154
            r0.printStackTrace()
        L_0x0154:
            goto L_0x0166
        L_0x0155:
            r0 = move-exception
        L_0x0156:
            r5 = r10
            r12 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r13 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r5 = r13.isDebug()
            if (r5 == 0) goto L_0x0165
            r0.printStackTrace()
        L_0x0165:
        L_0x0166:
            r5 = r6
        L_0x0167:
        L_0x0168:
            goto L_0x016c
        L_0x016b:
            r5 = 0
        L_0x016c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledBitmapWithBaseFontSize(int, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    public static /* synthetic */ Bitmap getScaledBitmapForTargetFontSize$default(int i2, Bitmap bitmap, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        return getScaledBitmapForTargetFontSize(i2, bitmap, i3, i4);
    }

    @JvmStatic
    @PluginAccessible
    public static final Bitmap getScaledBitmapForTargetFontSize(int type, Bitmap bitmap, int targetFontSize, int numRoundPolicy) {
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        int i2;
        int i3;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        int i4 = type;
        int i5 = targetFontSize;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (bitmap == null) {
            return null;
        }
        Bitmap it$iv = bitmap;
        FontSizeHelper this_$iv$iv = INSTANCE;
        float width$iv$iv = (float) it$iv.getWidth();
        float height$iv$iv = (float) it$iv.getHeight();
        FontSizeHelper fontSizeHelper2 = this_$iv$iv;
        if (i5 == 1) {
            z = false;
        } else if (i4 == 0 && i5 == 0) {
            z = false;
        } else {
            if (!(i5 >= 0 && i5 < 5)) {
                z = false;
            } else if ((i4 <= -1 || i4 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv$iv, height$iv$iv);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv$iv;
            float f2 = 1.0f;
            switch (i4) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[i5].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[i5].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[i5].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[i5].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[i5].floatValue();
                        break;
                    }
            }
            float ratio$iv$iv = f2;
            scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv$iv * ratio$iv$iv, height$iv$iv * ratio$iv$iv);
        }
        Scaled2DSizeInfo $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv = scaled2DSizeInfo;
        if (!$this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.isScaledRequired()) {
            return it$iv;
        }
        FontSizeHelper this_$iv$iv2 = INSTANCE;
        try {
            float $this$roundByPolicy$iv$iv = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.getScaledWidth();
            switch (numRoundPolicy) {
                case 0:
                    i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv$iv));
                    break;
                case 1:
                    i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv$iv));
                    break;
                case 2:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv$iv);
                    break;
                default:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv$iv);
                    break;
            }
            float $this$roundByPolicy$iv$iv2 = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9$iv.getScaledHeight();
            switch (numRoundPolicy) {
                case 0:
                    i3 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv$iv2));
                    break;
                case 1:
                    i3 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv$iv2));
                    break;
                case 2:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv$iv2);
                    break;
                default:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv$iv2);
                    break;
            }
            return Bitmap.createScaledBitmap(it$iv, i2, i3, true);
        } catch (Error e$iv$iv) {
            FontSizeHelper fontSizeHelper4 = this_$iv$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv$iv.printStackTrace();
            }
            return it$iv;
        } catch (Exception e$iv$iv2) {
            FontSizeHelper fontSizeHelper5 = this_$iv$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv$iv2.printStackTrace();
            }
            return it$iv;
        }
    }

    public static /* synthetic */ Drawable getScaledDrawable$default(int i2, Drawable drawable, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledDrawable(i2, drawable, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v23, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v87, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v16, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v2, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v17, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f6, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f9, code lost:
        switch(r64) {
            case 0: goto L_0x021c;
            case 1: goto L_0x0210;
            case 2: goto L_0x0205;
            default: goto L_0x01fc;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0209, code lost:
        r12 = kotlin.math.MathKt.roundToInt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r12 = (int) ((float) java.lang.Math.floor((double) r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x021c, code lost:
        r12 = (int) ((float) java.lang.Math.ceil((double) r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0228, code lost:
        r12 = kotlin.math.MathKt.roundToInt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x022a, code lost:
        r2 = android.graphics.Bitmap.createScaledBitmap(r2, r7, r12, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "createScaledBitmap(\n    …licy), true\n            )");
        r8 = (android.graphics.drawable.Drawable) new android.graphics.drawable.BitmapDrawable(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext().getResources(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02b7, code lost:
        r1 = r0;
        r48 = r9;
        r39 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02c1, code lost:
        r1 = r0;
        r48 = r9;
        r39 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x065c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x065d, code lost:
        r2 = r0;
        r44 = r6;
        r47 = r10;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06b1, code lost:
        r2 = r0;
        r47 = r10;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x06d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x06d9, code lost:
        r2 = r0;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06de, code lost:
        r9 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x06e1, code lost:
        switch(r64) {
            case 0: goto L_0x0704;
            case 1: goto L_0x06f8;
            case 2: goto L_0x06ed;
            default: goto L_0x06e4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e4, code lost:
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        r11 = kotlin.math.MathKt.roundToInt(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x06f1, code lost:
        r11 = kotlin.math.MathKt.roundToInt(r9);
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x06f8, code lost:
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        r11 = (int) ((float) java.lang.Math.floor((double) r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0704, code lost:
        r49 = r12;
        r11 = (int) ((float) java.lang.Math.ceil((double) r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x070f, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r3, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r6, r10, r11, true));
        r52 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0728, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x0729, code lost:
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0750, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0751, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x078f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0790, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x0795, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0796, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0813, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x0814, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x08aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x08ab, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:453:0x08af, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:454:0x08b0, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x08f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x08f3, code lost:
        r47 = r10;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:466:0x0906, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x0907, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x0912, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x0913, code lost:
        r44 = r6;
        r47 = r10;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x091b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x091c, code lost:
        r44 = r6;
        r47 = r10;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:?, code lost:
        r3 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x0932, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0934;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0934, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x0950, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0951, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:552:0x0a58, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x0a59, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:561:0x0a9f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:562:0x0aa0, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:577:0x0af6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:578:0x0af7, code lost:
        r23 = r6;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:583:0x0b08, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:586:0x0b2e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:587:0x0b2f, code lost:
        r1 = r0;
        r48 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:588:0x0b34, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:589:0x0b35, code lost:
        r1 = r0;
        r48 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:633:0x0ba3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:634:0x0ba4, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:645:0x0bed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:646:0x0bee, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:671:0x0c8a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:672:0x0c8b, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:673:0x0c8d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:674:0x0c8e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:675:0x0c92, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:676:0x0c93, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:677:0x0c99, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:678:0x0c9a, code lost:
        r17 = r6;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:680:?, code lost:
        r4 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:681:0x0cac, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0cae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:682:0x0cae, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:785:0x0eb4, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:314:0x063a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:317:0x0643] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:320:0x0657] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:333:0x0680] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:340:0x069a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:342:0x069f] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:348:0x06c1] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:357:0x06e8] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:373:0x0741] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:377:0x0747] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:385:0x076e] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:388:0x0779] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:395:0x079f] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:302:0x05fc, B:421:0x07f0] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:618:0x0b80] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:621:0x0b86] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:627:0x0b95] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:630:0x0b9c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:637:0x0bb4] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:499:0x0993, B:662:0x0c27] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0354 A[Catch:{ Error -> 0x096e, Exception -> 0x0964 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0358 A[Catch:{ Error -> 0x096e, Exception -> 0x0964 }] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x07e2  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x07e6  */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0934 A[Catch:{ Error -> 0x0950, Exception -> 0x094c }] */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0950 A[ExcHandler: Error (r0v18 'e' java.lang.Error A[CUSTOM_DECLARE]), PHI: r39 
      PHI: (r39v7 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper) = (r39v6 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper) binds: [B:752:0x0dd8, B:314:0x063a, B:473:0x0927, B:317:0x0643, B:318:?, B:328:0x066d, B:333:0x0680, B:373:0x0741, B:456:0x08b7, B:374:?, B:395:0x079f, B:421:0x07f0, B:385:0x076e, B:388:0x0779, B:389:?, B:381:0x0758, B:377:0x0747, B:363:0x06fd, B:359:0x06ed, B:357:0x06e8, B:348:0x06c1, B:342:0x069f, B:340:0x069a, B:320:0x0657, B:321:?, B:221:0x044b, B:302:0x05fc] A[DONT_GENERATE, DONT_INLINE], Splitter:B:302:0x05fc] */
    /* JADX WARNING: Removed duplicated region for block: B:536:0x0a27  */
    /* JADX WARNING: Removed duplicated region for block: B:537:0x0a2b  */
    /* JADX WARNING: Removed duplicated region for block: B:583:0x0b08 A[Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }] */
    /* JADX WARNING: Removed duplicated region for block: B:588:0x0b34 A[ExcHandler: Error (r0v12 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:499:0x0993] */
    /* JADX WARNING: Removed duplicated region for block: B:612:0x0b72  */
    /* JADX WARNING: Removed duplicated region for block: B:613:0x0b76  */
    /* JADX WARNING: Removed duplicated region for block: B:682:0x0cae A[Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }] */
    /* JADX WARNING: Removed duplicated region for block: B:705:0x0d04 A[Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:706:0x0d08 A[Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:780:0x0e93  */
    /* JADX WARNING: Removed duplicated region for block: B:785:0x0eb4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:421:0x07f0=Splitter:B:421:0x07f0, B:473:0x0927=Splitter:B:473:0x0927, B:302:0x05fc=Splitter:B:302:0x05fc, B:395:0x079f=Splitter:B:395:0x079f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:473:0x0927=Splitter:B:473:0x0927, B:302:0x05fc=Splitter:B:302:0x05fc} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:618:0x0b80=Splitter:B:618:0x0b80, B:679:0x0ca1=Splitter:B:679:0x0ca1, B:516:0x09e5=Splitter:B:516:0x09e5, B:542:0x0a35=Splitter:B:542:0x0a35} */
    @kotlin.jvm.JvmStatic
    @kotlin.Deprecated(message = "此方法为耗时方法，使用时务必确保该场景对性能要求不高，可能耗时数毫秒")
    @com.baidu.pyramid.annotation.nps.PluginAccessible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.drawable.Drawable getScaledDrawable(int r62, android.graphics.drawable.Drawable r63, int r64) {
        /*
            r1 = r62
            com.baidu.searchbox.config.FontSizeHelper r2 = INSTANCE
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBizFun r5 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBizFun()
            boolean r5 = r5.isSupportFontSize()
            r6 = 1
            if (r5 != 0) goto L_0x0015
            r5 = r6
            goto L_0x0017
        L_0x0015:
            int r5 = mTargetLevel
        L_0x0017:
            r3 = r6
            r4 = r2
            r7 = 0
            if (r63 == 0) goto L_0x0ebd
            r9 = r63
            r10 = 0
            com.baidu.searchbox.config.FontSizeHelper r11 = INSTANCE
            r12 = 0
            r13 = 0
            boolean r14 = r9 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0e97, Exception -> 0x0e76 }
            if (r14 == 0) goto L_0x02ee
            r14 = r9
            android.graphics.drawable.BitmapDrawable r14 = (android.graphics.drawable.BitmapDrawable) r14     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            r20 = r2
            r21 = 0
            r22 = r20
            r23 = 0
            r24 = r14
            android.graphics.drawable.Drawable r24 = (android.graphics.drawable.Drawable) r24     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            if (r24 == 0) goto L_0x029e
            r16 = r24
            r24 = 0
            r25 = r14
            android.graphics.drawable.Drawable r25 = (android.graphics.drawable.Drawable) r25     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            int r15 = r25.getIntrinsicWidth()     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            float r15 = (float) r15     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            float r15 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r15)     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            r25 = r14
            android.graphics.drawable.Drawable r25 = (android.graphics.drawable.Drawable) r25     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            int r8 = r25.getIntrinsicHeight()     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            float r8 = (float) r8     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            float r8 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r8)     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            r25 = 0
            r28 = r2
            r29 = 0
            if (r5 != r6) goto L_0x0068
            r30 = r3
            r3 = 0
            goto L_0x009d
        L_0x0068:
            if (r1 != 0) goto L_0x0070
            if (r5 != 0) goto L_0x0070
            r30 = r3
            r3 = 0
            goto L_0x009d
        L_0x0070:
            r30 = 0
            if (r5 < 0) goto L_0x0079
            r6 = 5
            if (r5 >= r6) goto L_0x0079
            r6 = 1
            goto L_0x007a
        L_0x0079:
            r6 = 0
        L_0x007a:
            if (r6 != 0) goto L_0x0080
            r30 = r3
            r3 = 0
            goto L_0x009d
        L_0x0080:
            r6 = -1
            if (r1 <= r6) goto L_0x008a
            r6 = 4
            if (r1 < r6) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            r30 = r3
            goto L_0x009c
        L_0x008a:
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Error -> 0x02dc, Exception -> 0x02ca }
            r30 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            boolean r3 = r6.containsKey(r3)     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            if (r3 != 0) goto L_0x009c
            r3 = 0
            goto L_0x009d
        L_0x009c:
            r3 = 1
        L_0x009d:
            if (r3 != 0) goto L_0x00c9
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r3 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r6 = 0
            r3.<init>(r6, r15, r8)     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r28 = r4
            goto L_0x0153
        L_0x00a9:
            r0 = move-exception
            r1 = r0
            r28 = r4
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0e86
        L_0x00b9:
            r0 = move-exception
            r1 = r0
            r28 = r4
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0ea7
        L_0x00c9:
            r3 = r2
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0108;
                case 1: goto L_0x00f7;
                case 2: goto L_0x00e6;
                case 3: goto L_0x00d5;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            r17 = r2
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            goto L_0x0119
        L_0x00d5:
            java.lang.Float[] r17 = SCALED_RATIO_T     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r17 = r17[r5]     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r18 = r3
            r19 = r17
            r17 = r2
            goto L_0x0142
        L_0x00e6:
            java.lang.Float[] r17 = SCALED_RATIO_H     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r17 = r17[r5]     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r18 = r3
            r19 = r17
            r17 = r2
            goto L_0x0142
        L_0x00f7:
            java.lang.Float[] r17 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r17 = r17[r5]     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r18 = r3
            r19 = r17
            r17 = r2
            goto L_0x0142
        L_0x0108:
            java.lang.Float[] r17 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r17 = r17[r5]     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            r18 = r3
            r19 = r17
            r17 = r2
            goto L_0x0142
        L_0x0119:
            r18 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            boolean r2 = r2.containsKey(r3)     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            if (r2 == 0) goto L_0x0140
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            java.lang.Float[] r2 = (java.lang.Float[]) r2     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            if (r2 == 0) goto L_0x013d
            r3 = 0
            r19 = r2[r5]     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            float r19 = r19.floatValue()     // Catch:{ Error -> 0x00b9, Exception -> 0x00a9 }
            goto L_0x0142
        L_0x013d:
            r19 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0142
        L_0x0140:
            r19 = 1065353216(0x3f800000, float:1.0)
        L_0x0142:
            r2 = r19
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r3 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x028e, Exception -> 0x027e }
            float r6 = r15 * r2
            r28 = r4
            float r4 = r8 * r2
            r18 = r2
            r2 = 1
            r3.<init>(r2, r6, r4)     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
        L_0x0153:
            r2 = r3
            r3 = 0
            boolean r4 = r2.isScaledRequired()     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            if (r4 != 0) goto L_0x0187
            r4 = r14
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ Error -> 0x0179, Exception -> 0x016b }
            r17 = r2
            r25 = r3
            r8 = r4
            r29 = r7
            r31 = r12
            r32 = r13
            goto L_0x0246
        L_0x016b:
            r0 = move-exception
            r1 = r0
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0e86
        L_0x0179:
            r0 = move-exception
            r1 = r0
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0ea7
        L_0x0187:
            float r4 = r2.getScaledWidth()     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            float r6 = r2.getScaledHeight()     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            r8 = r14
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            android.graphics.drawable.BitmapDrawable r8 = (android.graphics.drawable.BitmapDrawable) r8     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            r15 = 0
            r17 = r2
            android.graphics.Bitmap r2 = r8.getBitmap()     // Catch:{ Error -> 0x0270, Exception -> 0x0262 }
            r18 = r4
            r19 = 0
            switch(r64) {
                case 0: goto L_0x01ce;
                case 1: goto L_0x01be;
                case 2: goto L_0x01af;
                default: goto L_0x01a2;
            }
        L_0x01a2:
            r25 = r3
            r29 = r7
            r3 = r18
            r18 = r8
            int r7 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x0256, Exception -> 0x024a }
            goto L_0x01f6
        L_0x01af:
            int r25 = kotlin.math.MathKt.roundToInt((float) r18)     // Catch:{ Error -> 0x0179, Exception -> 0x016b }
            r29 = r7
            r7 = r25
            r25 = r3
            r3 = r18
            r18 = r8
            goto L_0x01f6
        L_0x01be:
            r25 = r3
            r29 = r7
            r3 = r18
            r18 = r8
            double r7 = (double) r3
            double r7 = java.lang.Math.floor(r7)     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            float r7 = (float) r7     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            int r7 = (int) r7     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            goto L_0x01f6
        L_0x01ce:
            r25 = r3
            r29 = r7
            r3 = r18
            r18 = r8
            double r7 = (double) r3     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            float r7 = (float) r7
            int r7 = (int) r7
            goto L_0x01f6
        L_0x01de:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0e86
        L_0x01ea:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            goto L_0x0ea7
        L_0x01f6:
            r3 = r6
            r8 = 0
            switch(r64) {
                case 0: goto L_0x021c;
                case 1: goto L_0x0210;
                case 2: goto L_0x0205;
                default: goto L_0x01fc;
            }
        L_0x01fc:
            r31 = r12
            r32 = r13
            int r19 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            goto L_0x0228
        L_0x0205:
            int r19 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x01ea, Exception -> 0x01de }
            r31 = r12
            r32 = r13
            r12 = r19
            goto L_0x022a
        L_0x0210:
            r31 = r12
            r32 = r13
            double r12 = (double) r3
            double r12 = java.lang.Math.floor(r12)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            float r12 = (float) r12     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            int r12 = (int) r12     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            goto L_0x022a
        L_0x021c:
            r31 = r12
            r32 = r13
            double r12 = (double) r3     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            float r12 = (float) r12     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            int r12 = (int) r12     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            goto L_0x022a
        L_0x0228:
            r12 = r19
        L_0x022a:
            r3 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r7, r12, r3)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            java.lang.String r3 = "createScaledBitmap(\n    …licy), true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            r3.<init>(r7, r2)     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            r8 = r3
        L_0x0246:
            goto L_0x02a9
        L_0x024a:
            r0 = move-exception
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e86
        L_0x0256:
            r0 = move-exception
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0ea7
        L_0x0262:
            r0 = move-exception
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e86
        L_0x0270:
            r0 = move-exception
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0ea7
        L_0x027e:
            r0 = move-exception
            r28 = r4
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e86
        L_0x028e:
            r0 = move-exception
            r28 = r4
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0ea7
        L_0x029e:
            r30 = r3
            r28 = r4
            r29 = r7
            r31 = r12
            r32 = r13
            r8 = 0
        L_0x02a9:
            android.graphics.drawable.BitmapDrawable r8 = (android.graphics.drawable.BitmapDrawable) r8     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x02c0, Exception -> 0x02b6 }
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e57
        L_0x02b6:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e86
        L_0x02c0:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0ea7
        L_0x02ca:
            r0 = move-exception
            r30 = r3
            r28 = r4
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0e86
        L_0x02dc:
            r0 = move-exception
            r30 = r3
            r28 = r4
            r29 = r7
            r31 = r12
            r1 = r0
            r48 = r9
            r38 = r10
            r39 = r11
            goto L_0x0ea7
        L_0x02ee:
            r30 = r3
            r28 = r4
            r29 = r7
            r31 = r12
            r32 = r13
            boolean r3 = r9 instanceof android.graphics.drawable.StateListDrawable     // Catch:{ Error -> 0x0e6d, Exception -> 0x0e64 }
            if (r3 == 0) goto L_0x02fe
            r3 = 1
            goto L_0x0300
        L_0x02fe:
            boolean r3 = r9 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0e6d, Exception -> 0x0e64 }
        L_0x0300:
            java.lang.String r4 = ", OriginalRadius is :"
            java.lang.String r7 = ", GradientDrawable ReflectionUtil Error"
            java.lang.String r8 = "mRadius"
            java.lang.String r13 = "Version: "
            java.lang.String r14 = "FontSizeHelper"
            if (r3 == 0) goto L_0x0986
            r3 = r2
            r15 = 0
            r20 = r3
            r21 = 0
            if (r9 == 0) goto L_0x0978
            r22 = r9
            r23 = 0
            int r6 = r9.getIntrinsicWidth()     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            float r6 = (float) r6     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            float r6 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r6)     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            int r12 = r9.getIntrinsicHeight()     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            float r12 = (float) r12     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            r33 = r2
            r34 = 0
            r35 = r33
            r36 = 0
            r37 = r3
            r3 = 1
            if (r5 != r3) goto L_0x033d
            r38 = r10
            r3 = 0
            goto L_0x0375
        L_0x033d:
            if (r1 != 0) goto L_0x0345
            if (r5 != 0) goto L_0x0345
            r38 = r10
            r3 = 0
            goto L_0x0375
        L_0x0345:
            r3 = 0
            if (r5 < 0) goto L_0x034f
            r38 = r3
            r3 = 5
            if (r5 >= r3) goto L_0x0351
            r3 = 1
            goto L_0x0352
        L_0x034f:
            r38 = r3
        L_0x0351:
            r3 = 0
        L_0x0352:
            if (r3 != 0) goto L_0x0358
            r38 = r10
            r3 = 0
            goto L_0x0375
        L_0x0358:
            r3 = -1
            if (r1 <= r3) goto L_0x0362
            r3 = 4
            if (r1 < r3) goto L_0x035f
            goto L_0x0362
        L_0x035f:
            r38 = r10
            goto L_0x0374
        L_0x0362:
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Error -> 0x096e, Exception -> 0x0964 }
            r38 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            boolean r3 = r3.containsKey(r10)     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            if (r3 != 0) goto L_0x0374
            r3 = 0
            goto L_0x0375
        L_0x0374:
            r3 = 1
        L_0x0375:
            if (r3 != 0) goto L_0x0391
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r3 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r10 = 0
            r3.<init>(r10, r6, r12)     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r35 = r15
            goto L_0x041f
        L_0x0381:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r39 = r11
            goto L_0x0e86
        L_0x0389:
            r0 = move-exception
            r1 = r0
            r48 = r9
            r39 = r11
            goto L_0x0ea7
        L_0x0391:
            r3 = r33
            r10 = 0
            switch(r1) {
                case 0: goto L_0x03d1;
                case 1: goto L_0x03c0;
                case 2: goto L_0x03af;
                case 3: goto L_0x039e;
                default: goto L_0x0397;
            }
        L_0x0397:
            r35 = r3
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            goto L_0x03e2
        L_0x039e:
            java.lang.Float[] r35 = SCALED_RATIO_T     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r35 = r35[r5]     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r36 = r10
            r39 = r35
            r35 = r3
            goto L_0x040b
        L_0x03af:
            java.lang.Float[] r35 = SCALED_RATIO_H     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r35 = r35[r5]     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r36 = r10
            r39 = r35
            r35 = r3
            goto L_0x040b
        L_0x03c0:
            java.lang.Float[] r35 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r35 = r35[r5]     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r36 = r10
            r39 = r35
            r35 = r3
            goto L_0x040b
        L_0x03d1:
            java.lang.Float[] r35 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r35 = r35[r5]     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            r36 = r10
            r39 = r35
            r35 = r3
            goto L_0x040b
        L_0x03e2:
            r36 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            boolean r3 = r3.containsKey(r10)     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            if (r3 == 0) goto L_0x0409
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            java.lang.Float[] r3 = (java.lang.Float[]) r3     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            if (r3 == 0) goto L_0x0406
            r10 = 0
            r39 = r3[r5]     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            float r39 = r39.floatValue()     // Catch:{ Error -> 0x0389, Exception -> 0x0381 }
            goto L_0x040b
        L_0x0406:
            r39 = 1065353216(0x3f800000, float:1.0)
            goto L_0x040b
        L_0x0409:
            r39 = 1065353216(0x3f800000, float:1.0)
        L_0x040b:
            r3 = r39
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r10 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            r35 = r15
            float r15 = r6 * r3
            r36 = r6
            float r6 = r12 * r3
            r39 = r3
            r3 = 1
            r10.<init>(r3, r15, r6)     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            r3 = r10
        L_0x041f:
            r6 = 0
            boolean r10 = r3.isScaledRequired()     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            if (r10 != 0) goto L_0x0432
            r34 = r3
            r36 = r6
            r8 = r9
            r48 = r8
            r39 = r11
            goto L_0x0949
        L_0x0432:
            float r10 = r3.getScaledWidth()     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            float r12 = r3.getScaledHeight()     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            r15 = r9
            r33 = 0
            r34 = r3
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x095c, Exception -> 0x0954 }
            r36 = r6
            r6 = 23
            r39 = r11
            java.lang.String r11 = "getChildren"
            if (r3 > r6) goto L_0x062c
            boolean r3 = r9 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0626, Exception -> 0x0620 }
            if (r3 == 0) goto L_0x062c
            r3 = r9
            r4 = 0
            android.graphics.drawable.LevelListDrawable r6 = new android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0626, Exception -> 0x0620 }
            r6.<init>()     // Catch:{ Error -> 0x0626, Exception -> 0x0620 }
            r7 = r3
            r8 = 0
            android.graphics.drawable.Drawable$ConstantState r13 = r7.getConstantState()     // Catch:{ Error -> 0x0626, Exception -> 0x0620 }
            if (r13 == 0) goto L_0x060b
            r14 = 0
            kotlin.Result$Companion r17 = kotlin.Result.Companion     // Catch:{ all -> 0x05ea }
            r17 = r7
            r18 = 0
            r19 = r2
            java.lang.Class r2 = r13.getClass()     // Catch:{ all -> 0x05d9 }
            r24 = r3
            r25 = r4
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x05cc }
            java.lang.reflect.Method r2 = r2.getMethod(r11, r4)     // Catch:{ all -> 0x05cc }
            r4 = 1
            r2.setAccessible(r4)     // Catch:{ all -> 0x05cc }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x05cc }
            java.lang.Object r3 = r2.invoke(r13, r4)     // Catch:{ all -> 0x05cc }
            boolean r4 = r3 instanceof java.lang.Object[]     // Catch:{ all -> 0x05cc }
            if (r4 == 0) goto L_0x0495
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x0487 }
            goto L_0x0496
        L_0x0487:
            r0 = move-exception
            r2 = r0
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            goto L_0x05fc
        L_0x0495:
            r3 = 0
        L_0x0496:
            if (r3 == 0) goto L_0x05b8
            r4 = 0
            r11 = 0
            r27 = r2
            int r2 = r3.length     // Catch:{ all -> 0x05cc }
            r16 = r4
            r4 = 0
        L_0x04a0:
            if (r4 >= r2) goto L_0x05a9
            r26 = r3[r4]     // Catch:{ all -> 0x05cc }
            int r40 = r11 + 1
            r41 = r26
            r42 = 0
            r43 = r2
            r2 = r41
            r41 = r3
            boolean r3 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x05cc }
            if (r3 == 0) goto L_0x0588
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x05cc }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x05cc }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ all -> 0x05cc }
            int r3 = r3.densityDpi     // Catch:{ all -> 0x05cc }
            r44 = 160(0xa0, float:2.24E-43)
            int r45 = r3 / r44
            r46 = r45
            r45 = r2
            android.graphics.drawable.BitmapDrawable r45 = (android.graphics.drawable.BitmapDrawable) r45     // Catch:{ all -> 0x05cc }
            r47 = r2
            android.graphics.Bitmap r2 = r45.getBitmap()     // Catch:{ all -> 0x05cc }
            r45 = r3
            r3 = r46
            r46 = r7
            float r7 = (float) r3
            float r7 = r7 * r10
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x057c }
            r48 = 0
            switch(r64) {
                case 0: goto L_0x0511;
                case 1: goto L_0x0505;
                case 2: goto L_0x04ec;
                default: goto L_0x04e3;
            }
        L_0x04e3:
            r49 = r13
            r50 = r14
            int r13 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x0574 }
            goto L_0x0525
        L_0x04ec:
            int r49 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x04f9 }
            r50 = r14
            r61 = r49
            r49 = r13
            r13 = r61
            goto L_0x0525
        L_0x04f9:
            r0 = move-exception
            r2 = r0
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            goto L_0x05fc
        L_0x0505:
            r49 = r13
            r50 = r14
            double r13 = (double) r7
            double r13 = java.lang.Math.floor(r13)     // Catch:{ all -> 0x051d }
            float r13 = (float) r13     // Catch:{ all -> 0x051d }
            int r13 = (int) r13     // Catch:{ all -> 0x051d }
            goto L_0x0525
        L_0x0511:
            r49 = r13
            r50 = r14
            double r13 = (double) r7     // Catch:{ all -> 0x051d }
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x051d }
            float r13 = (float) r13
            int r13 = (int) r13
            goto L_0x0525
        L_0x051d:
            r0 = move-exception
            r2 = r0
            r51 = r8
            r48 = r9
            goto L_0x05fc
        L_0x0525:
            float r7 = (float) r3
            float r7 = r7 * r12
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x0574 }
            r14 = 0
            switch(r64) {
                case 0: goto L_0x0550;
                case 1: goto L_0x0544;
                case 2: goto L_0x0539;
                default: goto L_0x0530;
            }
        L_0x0530:
            r51 = r8
            r48 = r9
            int r8 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x05c9 }
            goto L_0x055b
        L_0x0539:
            int r48 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x051d }
            r51 = r8
            r8 = r48
            r48 = r9
            goto L_0x055b
        L_0x0544:
            r51 = r8
            r48 = r9
            double r8 = (double) r7
            double r8 = java.lang.Math.floor(r8)     // Catch:{ all -> 0x05c9 }
            float r8 = (float) r8     // Catch:{ all -> 0x05c9 }
            int r8 = (int) r8     // Catch:{ all -> 0x05c9 }
            goto L_0x055b
        L_0x0550:
            r51 = r8
            r48 = r9
            double r8 = (double) r7     // Catch:{ all -> 0x05c9 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x05c9 }
            float r8 = (float) r8     // Catch:{ all -> 0x05c9 }
            int r8 = (int) r8     // Catch:{ all -> 0x05c9 }
        L_0x055b:
            r7 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r13, r8, r7)     // Catch:{ all -> 0x05c9 }
            java.lang.String r7 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ all -> 0x05c9 }
            android.graphics.drawable.BitmapDrawable r7 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x05c9 }
            r7.<init>(r2)     // Catch:{ all -> 0x05c9 }
            r8 = r7
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ all -> 0x05c9 }
            r6.addLevel(r11, r11, r8)     // Catch:{ all -> 0x05c9 }
            goto L_0x0594
        L_0x0574:
            r0 = move-exception
            r51 = r8
            r48 = r9
            r2 = r0
            goto L_0x05fc
        L_0x057c:
            r0 = move-exception
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05fc
        L_0x0588:
            r47 = r2
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
        L_0x0594:
            int r4 = r4 + 1
            r11 = r40
            r3 = r41
            r2 = r43
            r7 = r46
            r9 = r48
            r13 = r49
            r14 = r50
            r8 = r51
            goto L_0x04a0
        L_0x05a9:
            r41 = r3
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x05c9 }
            goto L_0x05c5
        L_0x05b8:
            r27 = r2
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            r8 = 0
        L_0x05c5:
            kotlin.Result.m8971constructorimpl(r8)     // Catch:{ all -> 0x05c9 }
            goto L_0x0605
        L_0x05c9:
            r0 = move-exception
            r2 = r0
            goto L_0x05fc
        L_0x05cc:
            r0 = move-exception
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05fc
        L_0x05d9:
            r0 = move-exception
            r24 = r3
            r25 = r4
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05fc
        L_0x05ea:
            r0 = move-exception
            r19 = r2
            r24 = r3
            r25 = r4
            r46 = r7
            r51 = r8
            r48 = r9
            r49 = r13
            r50 = r14
            r2 = r0
        L_0x05fc:
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            kotlin.Result.m8971constructorimpl(r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0605:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0617
        L_0x060b:
            r19 = r2
            r24 = r3
            r25 = r4
            r46 = r7
            r51 = r8
            r48 = r9
        L_0x0617:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r8 = r6
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e57
        L_0x0620:
            r0 = move-exception
            r1 = r0
            r48 = r9
            goto L_0x0e86
        L_0x0626:
            r0 = move-exception
            r1 = r0
            r48 = r9
            goto L_0x0ea7
        L_0x062c:
            r48 = r9
            r2 = r15
            r3 = 0
            android.graphics.drawable.Drawable$ConstantState r6 = r2.getConstantState()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            if (r6 == 0) goto L_0x093d
            r9 = 0
            r40 = r2
            java.lang.Class r2 = r6.getClass()     // Catch:{ Exception -> 0x091b, Error -> 0x0950 }
            r41 = r3
            r42 = r9
            r3 = 0
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            java.lang.reflect.Method r2 = r2.getMethod(r11, r9)     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            r9 = 1
            r2.setAccessible(r9)     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            java.lang.Object r3 = r2.invoke(r6, r9)     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            boolean r9 = r3 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            if (r9 == 0) goto L_0x0666
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ Exception -> 0x065c, Error -> 0x0950 }
            r16 = r3
            goto L_0x0668
        L_0x065c:
            r0 = move-exception
            r2 = r0
            r44 = r6
            r47 = r10
            r49 = r12
            goto L_0x0927
        L_0x0666:
            r16 = 0
        L_0x0668:
            if (r16 == 0) goto L_0x0909
            r3 = r16
            r9 = 0
            int r11 = r3.length     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            r43 = r2
            r2 = 0
        L_0x0671:
            if (r2 >= r11) goto L_0x08f9
            r16 = r3[r2]     // Catch:{ Exception -> 0x0912, Error -> 0x0950 }
            r44 = r16
            r45 = 0
            r46 = r3
            r3 = r44
            r44 = r6
            boolean r6 = r3 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x08f2, Error -> 0x0950 }
            if (r6 == 0) goto L_0x072e
            r6 = r3
            android.graphics.drawable.BitmapDrawable r6 = (android.graphics.drawable.BitmapDrawable) r6     // Catch:{ Exception -> 0x08f2, Error -> 0x0950 }
            android.graphics.Bitmap r6 = r6.getBitmap()     // Catch:{ Exception -> 0x08f2, Error -> 0x0950 }
            r47 = r10
            r49 = 0
            switch(r64) {
                case 0: goto L_0x06c8;
                case 1: goto L_0x06b8;
                case 2: goto L_0x069f;
                default: goto L_0x0692;
            }
        L_0x0692:
            r50 = r9
            r51 = r11
            r9 = r47
            r47 = r10
            int r10 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x0728, Error -> 0x0950 }
            goto L_0x06de
        L_0x069f:
            int r50 = kotlin.math.MathKt.roundToInt((float) r47)     // Catch:{ Exception -> 0x06b0, Error -> 0x0950 }
            r51 = r11
            r61 = r50
            r50 = r9
            r9 = r47
            r47 = r10
            r10 = r61
            goto L_0x06de
        L_0x06b0:
            r0 = move-exception
            r2 = r0
            r47 = r10
            r49 = r12
            goto L_0x0927
        L_0x06b8:
            r50 = r9
            r51 = r11
            r9 = r47
            r47 = r10
            double r10 = (double) r9
            double r10 = java.lang.Math.floor(r10)     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            float r10 = (float) r10     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            int r10 = (int) r10     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            goto L_0x06de
        L_0x06c8:
            r50 = r9
            r51 = r11
            r9 = r47
            r47 = r10
            double r10 = (double) r9     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            float r10 = (float) r10
            int r10 = (int) r10
            goto L_0x06de
        L_0x06d8:
            r0 = move-exception
            r2 = r0
            r49 = r12
            goto L_0x0927
        L_0x06de:
            r9 = r12
            r11 = 0
            switch(r64) {
                case 0: goto L_0x0704;
                case 1: goto L_0x06f8;
                case 2: goto L_0x06ed;
                default: goto L_0x06e4;
            }
        L_0x06e4:
            r52 = r11
            r49 = r12
            int r11 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            goto L_0x070f
        L_0x06ed:
            int r49 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x06d8, Error -> 0x0950 }
            r52 = r11
            r11 = r49
            r49 = r12
            goto L_0x070f
        L_0x06f8:
            r52 = r11
            r49 = r12
            double r11 = (double) r9
            double r11 = java.lang.Math.floor(r11)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            goto L_0x070f
        L_0x0704:
            r52 = r11
            r49 = r12
            double r11 = (double) r9     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
        L_0x070f:
            r9 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r10, r11, r9)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r10 = 0
            java.lang.String r11 = "setBitmap"
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r9 = 0
            r12[r9] = r6     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r3, r11, r12)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r52 = r3
            goto L_0x08e1
        L_0x0728:
            r0 = move-exception
            r49 = r12
            r2 = r0
            goto L_0x0927
        L_0x072e:
            r50 = r9
            r47 = r10
            r51 = r11
            r49 = r12
            boolean r6 = r3 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            if (r6 == 0) goto L_0x08df
            com.baidu.searchbox.config.FontSizeHelper r6 = INSTANCE     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r9 = r3
            android.graphics.drawable.GradientDrawable r9 = (android.graphics.drawable.GradientDrawable) r9     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r10 = 0
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x08af, Error -> 0x0950 }
            r12 = 24
            if (r11 < r12) goto L_0x0758
            float r11 = r9.getCornerRadius()     // Catch:{ Exception -> 0x0750, Error -> 0x0950 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x0750, Error -> 0x0950 }
            goto L_0x0760
        L_0x0750:
            r0 = move-exception
            r52 = r3
            r58 = r10
            r3 = r0
            goto L_0x08b5
        L_0x0758:
            android.graphics.drawable.Drawable$ConstantState r11 = r9.getConstantState()     // Catch:{ Exception -> 0x08af, Error -> 0x0950 }
            java.lang.Object r11 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r11, r8)     // Catch:{ Exception -> 0x08af, Error -> 0x0950 }
        L_0x0760:
            r12 = r6
            r52 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r53 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x08af, Error -> 0x0950 }
            boolean r53 = r53.isDebug()     // Catch:{ Exception -> 0x08af, Error -> 0x0950 }
            if (r53 == 0) goto L_0x079d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0795, Error -> 0x0950 }
            r12.<init>()     // Catch:{ Exception -> 0x0795, Error -> 0x0950 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x0795, Error -> 0x0950 }
            r52 = r3
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            java.lang.StringBuilder r3 = r12.append(r3)     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            android.util.Log.d(r14, r3)     // Catch:{ Exception -> 0x078f, Error -> 0x0950 }
            goto L_0x079f
        L_0x078f:
            r0 = move-exception
            r3 = r0
            r58 = r10
            goto L_0x08b5
        L_0x0795:
            r0 = move-exception
            r52 = r3
            r3 = r0
            r58 = r10
            goto L_0x08b5
        L_0x079d:
            r52 = r3
        L_0x079f:
            boolean r3 = r11 instanceof java.lang.Float     // Catch:{ Exception -> 0x08aa, Error -> 0x0950 }
            if (r3 == 0) goto L_0x08a5
            r3 = r11
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x08aa, Error -> 0x0950 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x08aa, Error -> 0x0950 }
            r12 = 0
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x08a5
            r3 = r11
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x08aa, Error -> 0x0950 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x08aa, Error -> 0x0950 }
            r12 = r6
            r53 = 0
            r54 = r12
            r55 = 0
            r56 = r54
            r57 = 0
            r58 = r10
            r10 = 1
            if (r5 != r10) goto L_0x07cb
            r59 = r11
            r10 = 0
            goto L_0x0803
        L_0x07cb:
            if (r1 != 0) goto L_0x07d3
            if (r5 != 0) goto L_0x07d3
            r59 = r11
            r10 = 0
            goto L_0x0803
        L_0x07d3:
            r10 = 0
            if (r5 < 0) goto L_0x07dd
            r59 = r10
            r10 = 5
            if (r5 >= r10) goto L_0x07df
            r10 = 1
            goto L_0x07e0
        L_0x07dd:
            r59 = r10
        L_0x07df:
            r10 = 0
        L_0x07e0:
            if (r10 != 0) goto L_0x07e6
            r59 = r11
            r10 = 0
            goto L_0x0803
        L_0x07e6:
            r10 = -1
            if (r1 <= r10) goto L_0x07f0
            r10 = 4
            if (r1 < r10) goto L_0x07ed
            goto L_0x07f0
        L_0x07ed:
            r59 = r11
            goto L_0x0802
        L_0x07f0:
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r59 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            if (r10 != 0) goto L_0x0802
            r10 = 0
            goto L_0x0803
        L_0x0802:
            r10 = 1
        L_0x0803:
            if (r10 != 0) goto L_0x0817
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r10 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r56 = r12
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r10.<init>(r12, r11, r3)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r57 = r3
            goto L_0x0890
        L_0x0813:
            r0 = move-exception
            r3 = r0
            goto L_0x08b5
        L_0x0817:
            r56 = r12
            r10 = r54
            r11 = 0
            switch(r1) {
                case 0: goto L_0x084b;
                case 1: goto L_0x083e;
                case 2: goto L_0x0831;
                case 3: goto L_0x0824;
                default: goto L_0x081f;
            }     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
        L_0x081f:
            java.util.HashMap r12 = mCustomerRatios     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            goto L_0x0858
        L_0x0824:
            java.lang.Float[] r12 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r12 = r12[r5]     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r57 = r10
            goto L_0x0883
        L_0x0831:
            java.lang.Float[] r12 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r12 = r12[r5]     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r57 = r10
            goto L_0x0883
        L_0x083e:
            java.lang.Float[] r12 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r12 = r12[r5]     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r57 = r10
            goto L_0x0883
        L_0x084b:
            java.lang.Float[] r12 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r12 = r12[r5]     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r57 = r10
            goto L_0x0883
        L_0x0858:
            r57 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            boolean r10 = r12.containsKey(r10)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            if (r10 == 0) goto L_0x0881
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            java.lang.Object r10 = r10.get(r12)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            java.lang.Float[] r10 = (java.lang.Float[]) r10     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            if (r10 == 0) goto L_0x087e
            r12 = 0
            r60 = r10[r5]     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r60 = r60.floatValue()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r12 = r60
            goto L_0x0883
        L_0x087e:
            r12 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0883
        L_0x0881:
            r12 = 1065353216(0x3f800000, float:1.0)
        L_0x0883:
            r10 = r12
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            float r12 = r3 * r10
            r57 = r3
            r3 = 1
            r11.<init>(r3, r10, r12)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            r10 = r11
        L_0x0890:
            r3 = r10
            r10 = 0
            boolean r11 = r3.isScaledRequired()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            if (r11 != 0) goto L_0x089b
            r11 = r57
            goto L_0x089f
        L_0x089b:
            float r11 = r3.getScaledSize()     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
        L_0x089f:
            r9.setCornerRadius(r11)     // Catch:{ Exception -> 0x0813, Error -> 0x0950 }
            goto L_0x08de
        L_0x08a5:
            r58 = r10
            r59 = r11
            goto L_0x08de
        L_0x08aa:
            r0 = move-exception
            r58 = r10
            r3 = r0
            goto L_0x08b5
        L_0x08af:
            r0 = move-exception
            r52 = r3
            r58 = r10
            r3 = r0
        L_0x08b5:
            r10 = r6
            r11 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r12 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            boolean r12 = r12.isDebug()     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            if (r12 == 0) goto L_0x08de
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r10.<init>()     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            java.lang.StringBuilder r10 = r10.append(r13)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            java.lang.StringBuilder r10 = r10.append(r7)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            android.util.Log.d(r14, r10)     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            r3.printStackTrace()     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
        L_0x08de:
            goto L_0x08e1
        L_0x08df:
            r52 = r3
        L_0x08e1:
            int r2 = r2 + 1
            r6 = r44
            r3 = r46
            r10 = r47
            r12 = r49
            r9 = r50
            r11 = r51
            goto L_0x0671
        L_0x08f2:
            r0 = move-exception
            r47 = r10
            r49 = r12
            r2 = r0
            goto L_0x0927
        L_0x08f9:
            r46 = r3
            r44 = r6
            r50 = r9
            r47 = r10
            r49 = r12
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0906, Error -> 0x0950 }
            goto L_0x0911
        L_0x0906:
            r0 = move-exception
            r2 = r0
            goto L_0x0927
        L_0x0909:
            r43 = r2
            r44 = r6
            r47 = r10
            r49 = r12
        L_0x0911:
            goto L_0x0937
        L_0x0912:
            r0 = move-exception
            r44 = r6
            r47 = r10
            r49 = r12
            r2 = r0
            goto L_0x0927
        L_0x091b:
            r0 = move-exception
            r41 = r3
            r44 = r6
            r42 = r9
            r47 = r10
            r49 = r12
            r2 = r0
        L_0x0927:
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r6 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            boolean r6 = r6.isDebug()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            if (r6 == 0) goto L_0x0937
            r2.printStackTrace()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0937:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0945
        L_0x093d:
            r40 = r2
            r41 = r3
            r47 = r10
            r49 = r12
        L_0x0945:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r8 = r15
        L_0x0949:
            goto L_0x0983
        L_0x094c:
            r0 = move-exception
            r1 = r0
            goto L_0x0e86
        L_0x0950:
            r0 = move-exception
            r1 = r0
            goto L_0x0ea7
        L_0x0954:
            r0 = move-exception
            r39 = r11
            r1 = r0
            r48 = r9
            goto L_0x0e86
        L_0x095c:
            r0 = move-exception
            r39 = r11
            r1 = r0
            r48 = r9
            goto L_0x0ea7
        L_0x0964:
            r0 = move-exception
            r38 = r10
            r39 = r11
            r1 = r0
            r48 = r9
            goto L_0x0e6c
        L_0x096e:
            r0 = move-exception
            r38 = r10
            r39 = r11
            r1 = r0
            r48 = r9
            goto L_0x0e75
        L_0x0978:
            r37 = r3
            r48 = r9
            r38 = r10
            r39 = r11
            r35 = r15
            r8 = 0
        L_0x0983:
            goto L_0x0e57
        L_0x0986:
            r48 = r9
            r38 = r10
            r39 = r11
            r3 = r48
            boolean r6 = r3 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            if (r6 == 0) goto L_0x0b3a
            r6 = r3
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r9 = 0
            r10 = r3
            android.graphics.drawable.GradientDrawable r10 = (android.graphics.drawable.GradientDrawable) r10     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r11 = 0
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            r15 = 24
            if (r12 < r15) goto L_0x09b2
            float r8 = r10.getCornerRadius()     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            goto L_0x09ba
        L_0x09aa:
            r0 = move-exception
            r4 = r0
            r23 = r6
            r18 = r9
            goto L_0x0afc
        L_0x09b2:
            android.graphics.drawable.Drawable$ConstantState r12 = r10.getConstantState()     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            java.lang.Object r8 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r12, r8)     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
        L_0x09ba:
            r12 = r2
            r15 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r16 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            boolean r16 = r16.isDebug()     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            if (r16 == 0) goto L_0x09e5
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            r12.<init>()     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            int r15 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.StringBuilder r12 = r12.append(r15)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.StringBuilder r4 = r12.append(r4)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
            android.util.Log.d(r14, r4)     // Catch:{ Exception -> 0x09aa, Error -> 0x0b34 }
        L_0x09e5:
            boolean r4 = r8 instanceof java.lang.Float     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            if (r4 == 0) goto L_0x0aef
            r4 = r8
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            r12 = 0
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0aef
            r4 = r8
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0af6, Error -> 0x0b34 }
            r12 = r2
            r15 = 0
            r16 = r12
            r20 = 0
            r21 = r16
            r22 = 0
            r23 = r6
            r6 = 1
            if (r5 != r6) goto L_0x0a10
            r17 = r8
            r6 = 0
            goto L_0x0a48
        L_0x0a10:
            if (r1 != 0) goto L_0x0a18
            if (r5 != 0) goto L_0x0a18
            r17 = r8
            r6 = 0
            goto L_0x0a48
        L_0x0a18:
            r6 = 0
            if (r5 < 0) goto L_0x0a22
            r24 = r6
            r6 = 5
            if (r5 >= r6) goto L_0x0a24
            r6 = 1
            goto L_0x0a25
        L_0x0a22:
            r24 = r6
        L_0x0a24:
            r6 = 0
        L_0x0a25:
            if (r6 != 0) goto L_0x0a2b
            r17 = r8
            r6 = 0
            goto L_0x0a48
        L_0x0a2b:
            r6 = -1
            if (r1 <= r6) goto L_0x0a35
            r6 = 4
            if (r1 < r6) goto L_0x0a32
            goto L_0x0a35
        L_0x0a32:
            r17 = r8
            goto L_0x0a47
        L_0x0a35:
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0a58, Error -> 0x0b34 }
            r17 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a58, Error -> 0x0b34 }
            boolean r6 = r6.containsKey(r8)     // Catch:{ Exception -> 0x0a58, Error -> 0x0b34 }
            if (r6 != 0) goto L_0x0a47
            r6 = 0
            goto L_0x0a48
        L_0x0a47:
            r6 = 1
        L_0x0a48:
            if (r6 != 0) goto L_0x0a5e
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a58, Error -> 0x0b34 }
            r18 = r9
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r6.<init>(r9, r8, r4)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r21 = r4
            goto L_0x0ada
        L_0x0a58:
            r0 = move-exception
            r18 = r9
            r4 = r0
            goto L_0x0afc
        L_0x0a5e:
            r18 = r9
            r6 = r16
            r8 = 0
            switch(r1) {
                case 0: goto L_0x0a92;
                case 1: goto L_0x0a85;
                case 2: goto L_0x0a78;
                case 3: goto L_0x0a6b;
                default: goto L_0x0a66;
            }     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
        L_0x0a66:
            java.util.HashMap r9 = mCustomerRatios     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            goto L_0x0aa2
        L_0x0a6b:
            java.lang.Float[] r9 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r9 = r9[r5]     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r9 = r9.floatValue()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r21 = r6
            goto L_0x0acd
        L_0x0a78:
            java.lang.Float[] r9 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r9 = r9[r5]     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r9 = r9.floatValue()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r21 = r6
            goto L_0x0acd
        L_0x0a85:
            java.lang.Float[] r9 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r9 = r9[r5]     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r9 = r9.floatValue()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r21 = r6
            goto L_0x0acd
        L_0x0a92:
            java.lang.Float[] r9 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r9 = r9[r5]     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r9 = r9.floatValue()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r21 = r6
            goto L_0x0acd
        L_0x0a9f:
            r0 = move-exception
            r4 = r0
            goto L_0x0afc
        L_0x0aa2:
            r21 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            boolean r6 = r9.containsKey(r6)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            if (r6 == 0) goto L_0x0acb
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            java.lang.Float[] r6 = (java.lang.Float[]) r6     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            if (r6 == 0) goto L_0x0ac8
            r9 = 0
            r19 = r6[r5]     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r9 = r19
            goto L_0x0acd
        L_0x0ac8:
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0acd
        L_0x0acb:
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x0acd:
            r6 = r9
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            float r9 = r4 * r6
            r21 = r4
            r4 = 1
            r8.<init>(r4, r6, r9)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            r6 = r8
        L_0x0ada:
            r4 = r6
            r6 = 0
            boolean r8 = r4.isScaledRequired()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            if (r8 != 0) goto L_0x0ae5
            r8 = r21
            goto L_0x0ae9
        L_0x0ae5:
            float r8 = r4.getScaledSize()     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
        L_0x0ae9:
            r10.setCornerRadius(r8)     // Catch:{ Exception -> 0x0a9f, Error -> 0x0b34 }
            goto L_0x0b25
        L_0x0aef:
            r23 = r6
            r17 = r8
            r18 = r9
            goto L_0x0b25
        L_0x0af6:
            r0 = move-exception
            r23 = r6
            r18 = r9
            r4 = r0
        L_0x0afc:
            r6 = r2
            r8 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r9 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            boolean r9 = r9.isDebug()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            if (r9 == 0) goto L_0x0b25
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r6.<init>()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.StringBuilder r6 = r6.append(r13)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.StringBuilder r6 = r6.append(r8)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.String r6 = r6.toString()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            android.util.Log.d(r14, r6)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r4.printStackTrace()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
        L_0x0b25:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r8 = r3
            r48 = r8
            goto L_0x0e57
        L_0x0b2e:
            r0 = move-exception
            r1 = r0
            r48 = r3
            goto L_0x0e86
        L_0x0b34:
            r0 = move-exception
            r1 = r0
            r48 = r3
            goto L_0x0ea7
        L_0x0b3a:
            boolean r4 = r3 instanceof android.graphics.drawable.NinePatchDrawable     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            if (r4 == 0) goto L_0x0cc4
            r4 = r3
            android.graphics.drawable.NinePatchDrawable r4 = (android.graphics.drawable.NinePatchDrawable) r4     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r6 = r2
            r7 = 0
            if (r4 == 0) goto L_0x0cb7
            r8 = r4
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = r2
            r12 = 0
            r13 = r11
            r15 = 0
            r16 = r13
            r20 = 0
            r21 = r4
            r4 = 1
            if (r5 != r4) goto L_0x0b5b
            r17 = r6
            r4 = 0
            goto L_0x0b93
        L_0x0b5b:
            if (r1 != 0) goto L_0x0b63
            if (r5 != 0) goto L_0x0b63
            r17 = r6
            r4 = 0
            goto L_0x0b93
        L_0x0b63:
            r4 = 0
            if (r5 < 0) goto L_0x0b6d
            r22 = r4
            r4 = 5
            if (r5 >= r4) goto L_0x0b6f
            r4 = 1
            goto L_0x0b70
        L_0x0b6d:
            r22 = r4
        L_0x0b6f:
            r4 = 0
        L_0x0b70:
            if (r4 != 0) goto L_0x0b76
            r17 = r6
            r4 = 0
            goto L_0x0b93
        L_0x0b76:
            r4 = -1
            if (r1 <= r4) goto L_0x0b80
            r4 = 4
            if (r1 < r4) goto L_0x0b7d
            goto L_0x0b80
        L_0x0b7d:
            r17 = r6
            goto L_0x0b92
        L_0x0b80:
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Exception -> 0x0c99, Error -> 0x0b34 }
            r17 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c92, Error -> 0x0b34 }
            boolean r4 = r4.containsKey(r6)     // Catch:{ Exception -> 0x0c92, Error -> 0x0b34 }
            if (r4 != 0) goto L_0x0b92
            r4 = 0
            goto L_0x0b93
        L_0x0b92:
            r4 = 1
        L_0x0b93:
            if (r4 != 0) goto L_0x0bab
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0ba3, Error -> 0x0b34 }
            r18 = r7
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r4.<init>(r7, r6, r10)     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r16 = r9
            goto L_0x0c2b
        L_0x0ba3:
            r0 = move-exception
            r18 = r7
            r2 = r0
            r16 = r9
            goto L_0x0ca1
        L_0x0bab:
            r18 = r7
            r6 = 1065353216(0x3f800000, float:1.0)
            r4 = r13
            r7 = 0
            switch(r1) {
                case 0: goto L_0x0be0;
                case 1: goto L_0x0bd3;
                case 2: goto L_0x0bc6;
                case 3: goto L_0x0bb9;
                default: goto L_0x0bb4;
            }
        L_0x0bb4:
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0c8d, Error -> 0x0b34 }
            goto L_0x0bf3
        L_0x0bb9:
            java.lang.Float[] r6 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r6 = r6[r5]     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r16 = r4
            goto L_0x0c1e
        L_0x0bc6:
            java.lang.Float[] r6 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r6 = r6[r5]     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r16 = r4
            goto L_0x0c1e
        L_0x0bd3:
            java.lang.Float[] r6 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r6 = r6[r5]     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r16 = r4
            goto L_0x0c1e
        L_0x0be0:
            java.lang.Float[] r6 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r6 = r6[r5]     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r16 = r4
            goto L_0x0c1e
        L_0x0bed:
            r0 = move-exception
            r2 = r0
            r16 = r9
            goto L_0x0ca1
        L_0x0bf3:
            r16 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c8d, Error -> 0x0b34 }
            boolean r4 = r6.containsKey(r4)     // Catch:{ Exception -> 0x0c8d, Error -> 0x0b34 }
            if (r4 == 0) goto L_0x0c1c
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            java.lang.Float[] r4 = (java.lang.Float[]) r4     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            if (r4 == 0) goto L_0x0c19
            r6 = 0
            r19 = r4[r5]     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x0bed, Error -> 0x0b34 }
            r6 = r19
            goto L_0x0c1e
        L_0x0c19:
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0c1e
        L_0x0c1c:
            r6 = 1065353216(0x3f800000, float:1.0)
        L_0x0c1e:
            r4 = r6
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0c8d, Error -> 0x0b34 }
            float r7 = r10 * r4
            r16 = r9
            r9 = 1
            r6.<init>(r9, r4, r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            r4 = r6
        L_0x0c2b:
            r6 = 0
            boolean r7 = r4.isScaledRequired()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            if (r7 != 0) goto L_0x0c35
            r7 = r10
            goto L_0x0c39
        L_0x0c35:
            float r7 = r4.getScaledSize()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
        L_0x0c39:
            r4 = r7
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            int r6 = r6.densityDpi     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            float r7 = (float) r6     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            float r7 = r7 * r4
            int r7 = (int) r7     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            r8.setTargetDensity(r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            r7 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r9 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            boolean r9 = r9.isDebug()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            if (r9 == 0) goto L_0x0cb1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            r2.<init>()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.String r7 = "scaled: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.String r7 = ", displayMetrics: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.String r7 = ", result: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            float r7 = (float) r6     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            float r7 = r7 * r4
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            android.util.Log.d(r14, r2)     // Catch:{ Exception -> 0x0c8a, Error -> 0x0b34 }
            goto L_0x0cb1
        L_0x0c8a:
            r0 = move-exception
            r2 = r0
            goto L_0x0ca1
        L_0x0c8d:
            r0 = move-exception
            r16 = r9
            r2 = r0
            goto L_0x0ca1
        L_0x0c92:
            r0 = move-exception
            r18 = r7
            r16 = r9
            r2 = r0
            goto L_0x0ca1
        L_0x0c99:
            r0 = move-exception
            r17 = r6
            r18 = r7
            r16 = r9
            r2 = r0
        L_0x0ca1:
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r6 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r7 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            boolean r7 = r7.isDebug()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            if (r7 == 0) goto L_0x0cb1
            r2.printStackTrace()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
        L_0x0cb1:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r8 = r21
            goto L_0x0cbe
        L_0x0cb7:
            r21 = r4
            r17 = r6
            r18 = r7
            r8 = 0
        L_0x0cbe:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r48 = r3
            goto L_0x0e57
        L_0x0cc4:
            r4 = r2
            r6 = 0
            r7 = r4
            r8 = 0
            if (r3 == 0) goto L_0x0e4f
            r9 = r3
            r10 = 0
            int r11 = r3.getIntrinsicWidth()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r11 = (float) r11     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r11 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r11)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            int r12 = r3.getIntrinsicHeight()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r12 = (float) r12     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            r13 = r2
            r14 = 0
            r15 = r13
            r16 = 0
            r20 = r4
            r4 = 1
            if (r5 != r4) goto L_0x0ced
            r17 = r6
            r4 = 0
            goto L_0x0d25
        L_0x0ced:
            if (r1 != 0) goto L_0x0cf5
            if (r5 != 0) goto L_0x0cf5
            r17 = r6
            r4 = 0
            goto L_0x0d25
        L_0x0cf5:
            r4 = 0
            if (r5 < 0) goto L_0x0cff
            r21 = r4
            r4 = 5
            if (r5 >= r4) goto L_0x0d01
            r4 = 1
            goto L_0x0d02
        L_0x0cff:
            r21 = r4
        L_0x0d01:
            r4 = 0
        L_0x0d02:
            if (r4 != 0) goto L_0x0d08
            r17 = r6
            r4 = 0
            goto L_0x0d25
        L_0x0d08:
            r4 = -1
            if (r1 <= r4) goto L_0x0d12
            r4 = 4
            if (r1 < r4) goto L_0x0d0f
            goto L_0x0d12
        L_0x0d0f:
            r17 = r6
            goto L_0x0d24
        L_0x0d12:
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            r17 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            boolean r4 = r4.containsKey(r6)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            if (r4 != 0) goto L_0x0d24
            r4 = 0
            goto L_0x0d25
        L_0x0d24:
            r4 = 1
        L_0x0d25:
            if (r4 != 0) goto L_0x0d2f
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r6 = 0
            r4.<init>(r6, r11, r12)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0d9c
        L_0x0d2f:
            r4 = r13
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0d5a;
                case 1: goto L_0x0d4f;
                case 2: goto L_0x0d44;
                case 3: goto L_0x0d39;
                default: goto L_0x0d34;
            }
        L_0x0d34:
            java.util.HashMap r15 = mCustomerRatios     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            goto L_0x0d65
        L_0x0d39:
            java.lang.Float[] r15 = SCALED_RATIO_T     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r15 = r15[r5]     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0d8e
        L_0x0d44:
            java.lang.Float[] r15 = SCALED_RATIO_H     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r15 = r15[r5]     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0d8e
        L_0x0d4f:
            java.lang.Float[] r15 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r15 = r15[r5]     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0d8e
        L_0x0d5a:
            java.lang.Float[] r15 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r15 = r15[r5]     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0d8e
        L_0x0d65:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            boolean r1 = r15.containsKey(r1)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            if (r1 == 0) goto L_0x0d8c
            java.util.HashMap r1 = mCustomerRatios     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            java.lang.Float[] r1 = (java.lang.Float[]) r1     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            if (r1 == 0) goto L_0x0d89
            r15 = 0
            r16 = r1[r5]     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            r15 = r16
            goto L_0x0d8e
        L_0x0d89:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0d8e
        L_0x0d8c:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x0d8e:
            r1 = r15
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r6 = r11 * r1
            float r15 = r12 * r1
            r16 = r1
            r1 = 1
            r4.<init>(r1, r6, r15)     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
        L_0x0d9c:
            r1 = r4
            r4 = 0
            boolean r6 = r1.isScaledRequired()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            if (r6 != 0) goto L_0x0dad
            r16 = r1
            r2 = r3
            r48 = r2
            r19 = r4
            goto L_0x0e4b
        L_0x0dad:
            float r6 = r1.getScaledWidth()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            float r11 = r1.getScaledHeight()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            r12 = r3
            r13 = 0
            r14 = 0
            int r15 = r12.getIntrinsicWidth()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            int r16 = r12.getIntrinsicHeight()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            r19 = r16
            r16 = r1
            int r1 = r12.getOpacity()     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
            r21 = r2
            r2 = -1
            if (r1 == r2) goto L_0x0dd1
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Error -> 0x0b34, Exception -> 0x0b2e }
            goto L_0x0dd3
        L_0x0dd1:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error -> 0x0e5f, Exception -> 0x0e5a }
        L_0x0dd3:
            r48 = r3
            r2 = r19
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r15, r2, r1)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r18 = r1
            java.lang.String r1 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r1 = r3
            android.graphics.Canvas r3 = new android.graphics.Canvas     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r3.<init>(r1)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r19 = r4
            r4 = 0
            r12.setBounds(r4, r4, r15, r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r12.draw(r3)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r2 = r6
            r3 = 0
            switch(r64) {
                case 0: goto L_0x0e0a;
                case 1: goto L_0x0e02;
                case 2: goto L_0x0dfd;
                default: goto L_0x0df8;
            }     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0df8:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e11
        L_0x0dfd:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e11
        L_0x0e02:
            double r14 = (double) r2     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            float r4 = (float) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            int r4 = (int) r4     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e11
        L_0x0e0a:
            double r14 = (double) r2     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            float r4 = (float) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            int r4 = (int) r4     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0e11:
            r2 = r11
            r3 = 0
            switch(r64) {
                case 0: goto L_0x0e29;
                case 1: goto L_0x0e21;
                case 2: goto L_0x0e1c;
                default: goto L_0x0e17;
            }     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0e17:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e30
        L_0x0e1c:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e30
        L_0x0e21:
            double r14 = (double) r2     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            float r14 = (float) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            int r14 = (int) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            goto L_0x0e30
        L_0x0e29:
            double r14 = (double) r2     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            float r14 = (float) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            int r14 = (int) r14     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0e30:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r4, r14, r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            java.lang.String r2 = "createScaledBitmap(\n    …       true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            r2.<init>(r3, r1)     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Error -> 0x0950, Exception -> 0x094c }
        L_0x0e4b:
            r8 = r2
            goto L_0x0e56
        L_0x0e4f:
            r48 = r3
            r20 = r4
            r17 = r6
            r8 = 0
        L_0x0e56:
        L_0x0e57:
            goto L_0x0eba
        L_0x0e5a:
            r0 = move-exception
            r48 = r3
            r1 = r0
            goto L_0x0e86
        L_0x0e5f:
            r0 = move-exception
            r48 = r3
            r1 = r0
            goto L_0x0ea7
        L_0x0e64:
            r0 = move-exception
            r48 = r9
            r38 = r10
            r39 = r11
            r1 = r0
        L_0x0e6c:
            goto L_0x0e86
        L_0x0e6d:
            r0 = move-exception
            r48 = r9
            r38 = r10
            r39 = r11
            r1 = r0
        L_0x0e75:
            goto L_0x0ea7
        L_0x0e76:
            r0 = move-exception
            r30 = r3
            r28 = r4
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            r1 = r0
        L_0x0e86:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0e96
            r1.printStackTrace()
        L_0x0e96:
            goto L_0x0eb8
        L_0x0e97:
            r0 = move-exception
            r30 = r3
            r28 = r4
            r29 = r7
            r48 = r9
            r38 = r10
            r39 = r11
            r31 = r12
            r1 = r0
        L_0x0ea7:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0eb7
            r1.printStackTrace()
        L_0x0eb7:
        L_0x0eb8:
            r8 = r63
        L_0x0eba:
            goto L_0x0ec4
        L_0x0ebd:
            r30 = r3
            r28 = r4
            r29 = r7
            r8 = 0
        L_0x0ec4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledDrawable(int, android.graphics.drawable.Drawable, int):android.graphics.drawable.Drawable");
    }

    public static /* synthetic */ FontScaledSize getScaledDrawableSize$default(int i2, Drawable drawable, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledDrawableSize(i2, drawable, i3);
    }

    @JvmStatic
    @PluginAccessible
    public static final FontScaledSize getScaledDrawableSize(int type, Drawable drawable, int numRoundPolicy) {
        int i2;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        int i3 = type;
        if (drawable == null) {
            return new FontScaledSize(false, 0.0f, 0.0f);
        }
        FontSizeHelper fontSizeHelper = INSTANCE;
        Drawable it = drawable;
        try {
            if (!(it instanceof BitmapDrawable)) {
                if (!(it instanceof StateListDrawable)) {
                    return new FontScaledSize(false, 0.0f, 0.0f);
                }
            }
            FontSizeHelper this_$iv = INSTANCE;
            float width$iv = DisplayUtilsKt.toStandardScreen((float) it.getIntrinsicWidth());
            float height$iv = DisplayUtilsKt.toStandardScreen((float) it.getIntrinsicHeight());
            FontSizeHelper fontSizeHelper2 = this_$iv;
            if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
                i2 = 1;
            } else {
                i2 = mTargetLevel;
            }
            int targetFontSize$iv = i2;
            FontSizeHelper fontSizeHelper3 = this_$iv;
            if (targetFontSize$iv == 1) {
                z = false;
            } else if (i3 == 0 && targetFontSize$iv == 0) {
                z = false;
            } else {
                if (!(targetFontSize$iv >= 0 && targetFontSize$iv < 5)) {
                    z = false;
                } else if ((i3 <= -1 || i3 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv, height$iv);
                Drawable drawable2 = it;
            } else {
                FontSizeHelper fontSizeHelper4 = this_$iv;
                float f2 = 1.0f;
                switch (i3) {
                    case 0:
                        f2 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                        Drawable drawable3 = it;
                        break;
                    case 1:
                        f2 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                        Drawable drawable4 = it;
                        break;
                    case 2:
                        f2 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                        Drawable drawable5 = it;
                        break;
                    case 3:
                        f2 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                        Drawable drawable6 = it;
                        break;
                    default:
                        Drawable drawable7 = it;
                        if (mCustomerRatios.containsKey(Integer.valueOf(type))) {
                            Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type));
                            if ($this$getScaledRatio_u24lambda_u2d28$iv$iv == null) {
                                break;
                            } else {
                                f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[targetFontSize$iv].floatValue();
                                break;
                            }
                        }
                        break;
                }
                float ratio$iv = f2;
                float f3 = ratio$iv;
                scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv * ratio$iv, height$iv * ratio$iv);
            }
            Scaled2DSizeInfo $this$getScaledDrawableSize_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = scaled2DSizeInfo;
            return new FontScaledSize($this$getScaledDrawableSize_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.isScaledRequired(), $this$getScaledDrawableSize_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getScaledWidth(), $this$getScaledDrawableSize_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getScaledHeight());
        } catch (Exception e2) {
            return new FontScaledSize(false, 0.0f, 0.0f);
        }
    }

    public static /* synthetic */ Drawable getScaledDrawableRes$default(int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 2;
        }
        return getScaledDrawableRes(i2, i3, i4);
    }

    @JvmStatic
    @PluginAccessible
    public static final Drawable getScaledDrawableRes(int type, int drawableId, int numRoundPolicy) {
        return getScaledDrawable(type, ResUtil.getDrawableByResId(drawableId), numRoundPolicy);
    }

    public static /* synthetic */ Drawable getScaledDrawableWithBaseFontSize$default(int i2, Drawable drawable, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        return getScaledDrawableWithBaseFontSize(i2, drawable, i3, i4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v23, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v55, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v16, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v2, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v17, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0613, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0614, code lost:
        r2 = r0;
        r44 = r8;
        r47 = r11;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0665, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x0666, code lost:
        r2 = r0;
        r47 = r11;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x068d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x068e, code lost:
        r2 = r0;
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0693, code lost:
        r9 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0696, code lost:
        switch(r65) {
            case 0: goto L_0x06b9;
            case 1: goto L_0x06ad;
            case 2: goto L_0x06a2;
            default: goto L_0x0699;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0699, code lost:
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:?, code lost:
        r11 = kotlin.math.MathKt.roundToInt(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x06a6, code lost:
        r11 = kotlin.math.MathKt.roundToInt(r9);
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x06ad, code lost:
        r49 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:?, code lost:
        r11 = (int) ((float) java.lang.Math.floor((double) r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x06b9, code lost:
        r49 = r12;
        r11 = (int) ((float) java.lang.Math.ceil((double) r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x06c4, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r3, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r8, r10, r11, true));
        r52 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x06dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x06de, code lost:
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0705, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0706, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0744, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0745, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x074a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x074b, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x07c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x07c9, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x085f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0860, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0864, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x0865, code lost:
        r52 = r3;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:436:0x08a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x08a8, code lost:
        r47 = r11;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:439:0x08bb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x08bc, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x08c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:443:0x08c8, code lost:
        r44 = r8;
        r47 = r11;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:444:0x08d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x08d1, code lost:
        r44 = r8;
        r47 = r11;
        r49 = r12;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:?, code lost:
        r3 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x08e7, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x08e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x08e9, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x0908, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:457:0x0909, code lost:
        r1 = r0;
        r21 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x098f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x0990, code lost:
        r5 = r0;
        r22 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:533:0x0a3f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:534:0x0a40, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:542:0x0a86, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:543:0x0a87, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:560:0x0ae5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:561:0x0ae6, code lost:
        r22 = r8;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:566:0x0af9, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:569:0x0b21, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:570:0x0b22, code lost:
        r1 = r0;
        r48 = r3;
        r21 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:571:0x0b29, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:572:0x0b2a, code lost:
        r1 = r0;
        r48 = r3;
        r21 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:616:0x0b9a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:617:0x0b9b, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:628:0x0be4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:629:0x0be5, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:654:0x0c81, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:655:0x0c82, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:656:0x0c84, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:657:0x0c85, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:658:0x0c89, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:659:0x0c8a, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:660:0x0c90, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:661:0x0c91, code lost:
        r17 = r6;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:663:?, code lost:
        r5 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:664:0x0ca3, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0ca5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:665:0x0ca5, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:779:0x0ece, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:287:0x05f1] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:290:0x05fa] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:293:0x060e] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:306:0x0637] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:313:0x0651] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:315:0x0656] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:321:0x0676] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:330:0x069d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:346:0x06f6] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:350:0x06fc] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:358:0x0723] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:361:0x072e] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:368:0x0754] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:275:0x05ad, B:394:0x07a5] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:601:0x0b77] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:604:0x0b7d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:610:0x0b8c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:613:0x0b93] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:620:0x0bab] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:477:0x0978, B:645:0x0c1e] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0797  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x079b  */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x08e9 A[Catch:{ Error -> 0x0908, Exception -> 0x0902 }] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0908 A[ExcHandler: Error (r0v27 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:275:0x05ad] */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x0a0e  */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0a12  */
    /* JADX WARNING: Removed duplicated region for block: B:566:0x0af9 A[Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }] */
    /* JADX WARNING: Removed duplicated region for block: B:571:0x0b29 A[ExcHandler: Error (r0v16 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:477:0x0978] */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x0b69  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0b6d  */
    /* JADX WARNING: Removed duplicated region for block: B:665:0x0ca5 A[Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }] */
    /* JADX WARNING: Removed duplicated region for block: B:688:0x0cfd A[Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }] */
    /* JADX WARNING: Removed duplicated region for block: B:689:0x0d01 A[Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }] */
    /* JADX WARNING: Removed duplicated region for block: B:774:0x0ead  */
    /* JADX WARNING: Removed duplicated region for block: B:779:0x0ece  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:368:0x0754=Splitter:B:368:0x0754, B:394:0x07a5=Splitter:B:394:0x07a5, B:446:0x08dc=Splitter:B:446:0x08dc, B:275:0x05ad=Splitter:B:275:0x05ad} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:446:0x08dc=Splitter:B:446:0x08dc, B:275:0x05ad=Splitter:B:275:0x05ad} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:601:0x0b77=Splitter:B:601:0x0b77, B:662:0x0c98=Splitter:B:662:0x0c98, B:494:0x09cc=Splitter:B:494:0x09cc, B:520:0x0a1c=Splitter:B:520:0x0a1c} */
    @kotlin.jvm.JvmStatic
    @com.baidu.pyramid.annotation.nps.PluginAccessible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.drawable.Drawable getScaledDrawableWithBaseFontSize(int r62, android.graphics.drawable.Drawable r63, int r64, int r65) {
        /*
            r1 = r62
            com.baidu.searchbox.config.FontSizeHelper r2 = INSTANCE
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBizFun r5 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBizFun()
            boolean r5 = r5.isSupportFontSize()
            r6 = 1
            if (r5 != 0) goto L_0x0014
            r5 = r6
            goto L_0x0016
        L_0x0014:
            int r5 = mTargetLevel
        L_0x0016:
            r3 = r2
            r4 = r5
            r5 = 0
            if (r63 == 0) goto L_0x0ed7
            r8 = r63
            r9 = 0
            com.baidu.searchbox.config.FontSizeHelper r10 = INSTANCE
            r11 = 0
            r12 = 0
            boolean r13 = r8 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0eb1, Exception -> 0x0e90 }
            r15 = 5
            if (r13 == 0) goto L_0x029c
            r13 = r8
            android.graphics.drawable.BitmapDrawable r13 = (android.graphics.drawable.BitmapDrawable) r13     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            r19 = r2
            r20 = 0
            r21 = r19
            r22 = 0
            r23 = r13
            android.graphics.drawable.Drawable r23 = (android.graphics.drawable.Drawable) r23     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            if (r23 == 0) goto L_0x0244
            r16 = r23
            r23 = 0
            r24 = r13
            android.graphics.drawable.Drawable r24 = (android.graphics.drawable.Drawable) r24     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            int r14 = r24.getIntrinsicWidth()     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            float r14 = (float) r14     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            float r14 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r14)     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            r24 = r13
            android.graphics.drawable.Drawable r24 = (android.graphics.drawable.Drawable) r24     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            int r7 = r24.getIntrinsicHeight()     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            float r7 = (float) r7     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            r24 = 0
            r27 = r2
            r28 = 0
            if (r4 != r6) goto L_0x0066
            r6 = 0
            goto L_0x0090
        L_0x0066:
            if (r1 != 0) goto L_0x006c
            if (r4 != 0) goto L_0x006c
            r6 = 0
            goto L_0x0090
        L_0x006c:
            r29 = 0
            if (r4 < 0) goto L_0x0074
            if (r4 >= r15) goto L_0x0074
            r15 = r6
            goto L_0x0075
        L_0x0074:
            r15 = 0
        L_0x0075:
            if (r15 != 0) goto L_0x0079
            r6 = 0
            goto L_0x0090
        L_0x0079:
            r15 = -1
            if (r1 <= r15) goto L_0x007f
            r15 = 4
            if (r1 < r15) goto L_0x008f
        L_0x007f:
            java.util.HashMap r15 = mCustomerRatios     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            boolean r6 = r15.containsKey(r6)     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            if (r6 != 0) goto L_0x008f
            r6 = 0
            goto L_0x0090
        L_0x008f:
            r6 = 1
        L_0x0090:
            if (r6 != 0) goto L_0x00c0
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r15 = 0
            r6.<init>(r15, r14, r7)     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r27 = r3
            goto L_0x016a
        L_0x009c:
            r0 = move-exception
            r1 = r0
            r27 = r3
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ea0
        L_0x00ae:
            r0 = move-exception
            r1 = r0
            r27 = r3
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ec1
        L_0x00c0:
            r6 = r2
            r15 = 0
            switch(r1) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00f0;
                case 2: goto L_0x00de;
                case 3: goto L_0x00cc;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            r17 = r2
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x028a, Exception -> 0x0278 }
            goto L_0x0112
        L_0x00cc:
            java.lang.Float[] r17 = SCALED_RATIO_T     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r17 = r17[r4]     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r27 = r3
            r18 = r17
            r17 = r2
            goto L_0x015b
        L_0x00de:
            java.lang.Float[] r17 = SCALED_RATIO_H     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r17 = r17[r4]     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r27 = r3
            r18 = r17
            r17 = r2
            goto L_0x015b
        L_0x00f0:
            java.lang.Float[] r17 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r17 = r17[r4]     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r27 = r3
            r18 = r17
            r17 = r2
            goto L_0x015b
        L_0x0101:
            java.lang.Float[] r17 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r17 = r17[r4]     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00ae, Exception -> 0x009c }
            r27 = r3
            r18 = r17
            r17 = r2
            goto L_0x015b
        L_0x0112:
            r27 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            if (r2 == 0) goto L_0x0159
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            java.lang.Float[] r2 = (java.lang.Float[]) r2     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            if (r2 == 0) goto L_0x0136
            r3 = 0
            r18 = r2[r4]     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            float r18 = r18.floatValue()     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            goto L_0x015b
        L_0x0136:
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L_0x015b
        L_0x0139:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ea0
        L_0x0149:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ec1
        L_0x0159:
            r18 = 1065353216(0x3f800000, float:1.0)
        L_0x015b:
            r2 = r18
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            float r3 = r14 * r2
            float r15 = r7 * r2
            r18 = r2
            r2 = 1
            r6.<init>(r2, r3, r15)     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
        L_0x016a:
            r2 = r6
            r3 = 0
            boolean r6 = r2.isScaledRequired()     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            if (r6 != 0) goto L_0x017e
            r6 = r13
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            r17 = r2
            r25 = r3
            r28 = r5
            r7 = r6
            goto L_0x0221
        L_0x017e:
            float r6 = r2.getScaledWidth()     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            float r7 = r2.getScaledHeight()     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            r14 = r13
            android.graphics.drawable.Drawable r14 = (android.graphics.drawable.Drawable) r14     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            android.graphics.drawable.BitmapDrawable r14 = (android.graphics.drawable.BitmapDrawable) r14     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            r15 = 0
            r17 = r2
            android.graphics.Bitmap r2 = r14.getBitmap()     // Catch:{ Error -> 0x0234, Exception -> 0x0224 }
            r18 = r6
            r24 = 0
            switch(r65) {
                case 0: goto L_0x01c5;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                default: goto L_0x0199;
            }
        L_0x0199:
            r25 = r3
            r28 = r5
            r3 = r18
            r18 = r6
            int r5 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            goto L_0x01d4
        L_0x01a6:
            int r25 = kotlin.math.MathKt.roundToInt((float) r18)     // Catch:{ Error -> 0x0149, Exception -> 0x0139 }
            r28 = r5
            r5 = r25
            r25 = r3
            r3 = r18
            r18 = r6
            goto L_0x01d4
        L_0x01b5:
            r25 = r3
            r28 = r5
            r3 = r18
            r18 = r6
            double r5 = (double) r3
            double r5 = java.lang.Math.floor(r5)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            float r5 = (float) r5     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            int r5 = (int) r5     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            goto L_0x01d4
        L_0x01c5:
            r25 = r3
            r28 = r5
            r3 = r18
            r18 = r6
            double r5 = (double) r3     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            float r5 = (float) r5     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            int r5 = (int) r5     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
        L_0x01d4:
            r3 = r7
            r6 = 0
            switch(r65) {
                case 0: goto L_0x01fa;
                case 1: goto L_0x01ee;
                case 2: goto L_0x01e3;
                default: goto L_0x01da;
            }     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
        L_0x01da:
            r26 = r6
            r24 = r7
            int r6 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            goto L_0x0205
        L_0x01e3:
            int r24 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            r26 = r6
            r6 = r24
            r24 = r7
            goto L_0x0205
        L_0x01ee:
            r26 = r6
            r24 = r7
            double r6 = (double) r3     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            double r6 = java.lang.Math.floor(r6)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            float r6 = (float) r6     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            int r6 = (int) r6     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            goto L_0x0205
        L_0x01fa:
            r26 = r6
            r24 = r7
            double r6 = (double) r3     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            double r6 = java.lang.Math.ceil(r6)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            float r6 = (float) r6     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            int r6 = (int) r6     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
        L_0x0205:
            r3 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r5, r6, r3)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            java.lang.String r3 = "createScaledBitmap(\n    …licy), true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            r3.<init>(r5, r2)     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            r7 = r3
        L_0x0221:
            goto L_0x0249
        L_0x0224:
            r0 = move-exception
            r28 = r5
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ea0
        L_0x0234:
            r0 = move-exception
            r28 = r5
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ec1
        L_0x0244:
            r27 = r3
            r28 = r5
            r7 = 0
        L_0x0249:
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7     // Catch:{ Error -> 0x026a, Exception -> 0x025c }
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r35 = r12
            goto L_0x0e65
        L_0x025c:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ea0
        L_0x026a:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ec1
        L_0x0278:
            r0 = move-exception
            r27 = r3
            r28 = r5
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ea0
        L_0x028a:
            r0 = move-exception
            r27 = r3
            r28 = r5
            r1 = r0
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            goto L_0x0ec1
        L_0x029c:
            r27 = r3
            r28 = r5
            boolean r3 = r8 instanceof android.graphics.drawable.StateListDrawable     // Catch:{ Error -> 0x0e83, Exception -> 0x0e76 }
            if (r3 == 0) goto L_0x02a6
            r3 = 1
            goto L_0x02a8
        L_0x02a6:
            boolean r3 = r8 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0e83, Exception -> 0x0e76 }
        L_0x02a8:
            java.lang.String r5 = ", OriginalRadius is :"
            java.lang.String r7 = ", GradientDrawable ReflectionUtil Error"
            java.lang.String r13 = "mRadius"
            java.lang.String r6 = "Version: "
            java.lang.String r14 = "FontSizeHelper"
            if (r3 == 0) goto L_0x0967
            r3 = r2
            r21 = 0
            r22 = r3
            r23 = 0
            if (r8 == 0) goto L_0x0956
            r24 = r8
            r30 = 0
            int r15 = r8.getIntrinsicWidth()     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            float r15 = (float) r15     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            float r15 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r15)     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            r32 = r3
            int r3 = r8.getIntrinsicHeight()     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            float r3 = (float) r3     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            float r3 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r3)     // Catch:{ Error -> 0x0948, Exception -> 0x093a }
            r33 = r2
            r34 = 0
            r35 = r33
            r36 = 0
            r37 = r9
            r9 = 1
            if (r4 != r9) goto L_0x02e8
            r38 = r11
            r9 = 0
            goto L_0x0320
        L_0x02e8:
            if (r1 != 0) goto L_0x02f0
            if (r4 != 0) goto L_0x02f0
            r38 = r11
            r9 = 0
            goto L_0x0320
        L_0x02f0:
            r9 = 0
            if (r4 < 0) goto L_0x02fa
            r38 = r9
            r9 = 5
            if (r4 >= r9) goto L_0x02fc
            r9 = 1
            goto L_0x02fd
        L_0x02fa:
            r38 = r9
        L_0x02fc:
            r9 = 0
        L_0x02fd:
            if (r9 != 0) goto L_0x0303
            r38 = r11
            r9 = 0
            goto L_0x0320
        L_0x0303:
            r9 = -1
            if (r1 <= r9) goto L_0x030d
            r9 = 4
            if (r1 < r9) goto L_0x030a
            goto L_0x030d
        L_0x030a:
            r38 = r11
            goto L_0x031f
        L_0x030d:
            java.util.HashMap r9 = mCustomerRatios     // Catch:{ Error -> 0x092e, Exception -> 0x0922 }
            r38 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            boolean r9 = r9.containsKey(r11)     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            if (r9 != 0) goto L_0x031f
            r9 = 0
            goto L_0x0320
        L_0x031f:
            r9 = 1
        L_0x0320:
            if (r9 != 0) goto L_0x0340
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r9 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r11 = 0
            r9.<init>(r11, r15, r3)     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r35 = r12
            goto L_0x03ce
        L_0x032c:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            r39 = r10
            goto L_0x0ea0
        L_0x0336:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            r39 = r10
            goto L_0x0ec1
        L_0x0340:
            r9 = r33
            r11 = 0
            switch(r1) {
                case 0: goto L_0x0380;
                case 1: goto L_0x036f;
                case 2: goto L_0x035e;
                case 3: goto L_0x034d;
                default: goto L_0x0346;
            }
        L_0x0346:
            r35 = r9
            java.util.HashMap r9 = mCustomerRatios     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            goto L_0x0391
        L_0x034d:
            java.lang.Float[] r35 = SCALED_RATIO_T     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r35 = r35[r4]     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r36 = r11
            r39 = r35
            r35 = r9
            goto L_0x03ba
        L_0x035e:
            java.lang.Float[] r35 = SCALED_RATIO_H     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r35 = r35[r4]     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r36 = r11
            r39 = r35
            r35 = r9
            goto L_0x03ba
        L_0x036f:
            java.lang.Float[] r35 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r35 = r35[r4]     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r36 = r11
            r39 = r35
            r35 = r9
            goto L_0x03ba
        L_0x0380:
            java.lang.Float[] r35 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r35 = r35[r4]     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            r36 = r11
            r39 = r35
            r35 = r9
            goto L_0x03ba
        L_0x0391:
            r36 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            boolean r9 = r9.containsKey(r11)     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            if (r9 == 0) goto L_0x03b8
            java.util.HashMap r9 = mCustomerRatios     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            java.lang.Object r9 = r9.get(r11)     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            java.lang.Float[] r9 = (java.lang.Float[]) r9     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            if (r9 == 0) goto L_0x03b5
            r11 = 0
            r39 = r9[r4]     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            float r39 = r39.floatValue()     // Catch:{ Error -> 0x0336, Exception -> 0x032c }
            goto L_0x03ba
        L_0x03b5:
            r39 = 1065353216(0x3f800000, float:1.0)
            goto L_0x03ba
        L_0x03b8:
            r39 = 1065353216(0x3f800000, float:1.0)
        L_0x03ba:
            r9 = r39
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            r35 = r12
            float r12 = r15 * r9
            r36 = r15
            float r15 = r3 * r9
            r39 = r3
            r3 = 1
            r11.<init>(r3, r12, r15)     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            r9 = r11
        L_0x03ce:
            r3 = r9
            r9 = 0
            boolean r11 = r3.isScaledRequired()     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            if (r11 != 0) goto L_0x03e1
            r34 = r3
            r7 = r8
            r48 = r7
            r36 = r9
            r39 = r10
            goto L_0x08fe
        L_0x03e1:
            float r11 = r3.getScaledWidth()     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            float r12 = r3.getScaledHeight()     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            r15 = r8
            r33 = 0
            r34 = r3
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0918, Exception -> 0x090e }
            r36 = r9
            r9 = 23
            r39 = r10
            java.lang.String r10 = "getChildren"
            if (r3 > r9) goto L_0x05e3
            boolean r3 = r8 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x05db, Exception -> 0x05d3 }
            if (r3 == 0) goto L_0x05e3
            r3 = r8
            r5 = 0
            android.graphics.drawable.LevelListDrawable r6 = new android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x05db, Exception -> 0x05d3 }
            r6.<init>()     // Catch:{ Error -> 0x05db, Exception -> 0x05d3 }
            r7 = r3
            r9 = 0
            android.graphics.drawable.Drawable$ConstantState r13 = r7.getConstantState()     // Catch:{ Error -> 0x05db, Exception -> 0x05d3 }
            if (r13 == 0) goto L_0x05bc
            r14 = 0
            kotlin.Result$Companion r17 = kotlin.Result.Companion     // Catch:{ all -> 0x059b }
            r17 = r7
            r18 = 0
            r19 = r2
            java.lang.Class r2 = r13.getClass()     // Catch:{ all -> 0x058a }
            r20 = r3
            r26 = r5
            r3 = 0
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x057d }
            java.lang.reflect.Method r2 = r2.getMethod(r10, r5)     // Catch:{ all -> 0x057d }
            r5 = 1
            r2.setAccessible(r5)     // Catch:{ all -> 0x057d }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x057d }
            java.lang.Object r3 = r2.invoke(r13, r5)     // Catch:{ all -> 0x057d }
            boolean r5 = r3 instanceof java.lang.Object[]     // Catch:{ all -> 0x057d }
            if (r5 == 0) goto L_0x0444
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x0436 }
            goto L_0x0445
        L_0x0436:
            r0 = move-exception
            r2 = r0
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            goto L_0x05ad
        L_0x0444:
            r3 = 0
        L_0x0445:
            if (r3 == 0) goto L_0x0569
            r5 = 0
            r10 = 0
            r31 = r2
            int r2 = r3.length     // Catch:{ all -> 0x057d }
            r16 = r5
            r5 = 0
        L_0x044f:
            if (r5 >= r2) goto L_0x055a
            r25 = r3[r5]     // Catch:{ all -> 0x057d }
            int r40 = r10 + 1
            r41 = r25
            r42 = 0
            r43 = r2
            r2 = r41
            r41 = r3
            boolean r3 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x057d }
            if (r3 == 0) goto L_0x0539
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x057d }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x057d }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ all -> 0x057d }
            int r3 = r3.densityDpi     // Catch:{ all -> 0x057d }
            r44 = 160(0xa0, float:2.24E-43)
            int r45 = r3 / r44
            r46 = r45
            r45 = r2
            android.graphics.drawable.BitmapDrawable r45 = (android.graphics.drawable.BitmapDrawable) r45     // Catch:{ all -> 0x057d }
            r47 = r2
            android.graphics.Bitmap r2 = r45.getBitmap()     // Catch:{ all -> 0x057d }
            r45 = r3
            r3 = r46
            r46 = r7
            float r7 = (float) r3
            float r7 = r7 * r11
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x052d }
            r48 = 0
            switch(r65) {
                case 0: goto L_0x04c0;
                case 1: goto L_0x04b4;
                case 2: goto L_0x049b;
                default: goto L_0x0492;
            }
        L_0x0492:
            r49 = r13
            r50 = r14
            int r13 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x0525 }
            goto L_0x04d4
        L_0x049b:
            int r49 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x04a8 }
            r50 = r14
            r61 = r49
            r49 = r13
            r13 = r61
            goto L_0x04d4
        L_0x04a8:
            r0 = move-exception
            r2 = r0
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            goto L_0x05ad
        L_0x04b4:
            r49 = r13
            r50 = r14
            double r13 = (double) r7
            double r13 = java.lang.Math.floor(r13)     // Catch:{ all -> 0x04cc }
            float r13 = (float) r13     // Catch:{ all -> 0x04cc }
            int r13 = (int) r13     // Catch:{ all -> 0x04cc }
            goto L_0x04d4
        L_0x04c0:
            r49 = r13
            r50 = r14
            double r13 = (double) r7     // Catch:{ all -> 0x04cc }
            double r13 = java.lang.Math.ceil(r13)     // Catch:{ all -> 0x04cc }
            float r13 = (float) r13
            int r13 = (int) r13
            goto L_0x04d4
        L_0x04cc:
            r0 = move-exception
            r2 = r0
            r48 = r8
            r51 = r9
            goto L_0x05ad
        L_0x04d4:
            float r7 = (float) r3
            float r7 = r7 * r12
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x0525 }
            r14 = 0
            switch(r65) {
                case 0: goto L_0x0501;
                case 1: goto L_0x04f5;
                case 2: goto L_0x04e8;
                default: goto L_0x04df;
            }
        L_0x04df:
            r48 = r8
            r51 = r9
            int r8 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x057a }
            goto L_0x050c
        L_0x04e8:
            int r48 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x04cc }
            r51 = r9
            r61 = r48
            r48 = r8
            r8 = r61
            goto L_0x050c
        L_0x04f5:
            r48 = r8
            r51 = r9
            double r8 = (double) r7
            double r8 = java.lang.Math.floor(r8)     // Catch:{ all -> 0x057a }
            float r8 = (float) r8     // Catch:{ all -> 0x057a }
            int r8 = (int) r8     // Catch:{ all -> 0x057a }
            goto L_0x050c
        L_0x0501:
            r48 = r8
            r51 = r9
            double r8 = (double) r7     // Catch:{ all -> 0x057a }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x057a }
            float r8 = (float) r8     // Catch:{ all -> 0x057a }
            int r8 = (int) r8     // Catch:{ all -> 0x057a }
        L_0x050c:
            r7 = 1
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r13, r8, r7)     // Catch:{ all -> 0x057a }
            java.lang.String r7 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ all -> 0x057a }
            android.graphics.drawable.BitmapDrawable r7 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x057a }
            r7.<init>(r2)     // Catch:{ all -> 0x057a }
            r8 = r7
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ all -> 0x057a }
            r6.addLevel(r10, r10, r8)     // Catch:{ all -> 0x057a }
            goto L_0x0545
        L_0x0525:
            r0 = move-exception
            r48 = r8
            r51 = r9
            r2 = r0
            goto L_0x05ad
        L_0x052d:
            r0 = move-exception
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05ad
        L_0x0539:
            r47 = r2
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
        L_0x0545:
            int r5 = r5 + 1
            r10 = r40
            r3 = r41
            r2 = r43
            r7 = r46
            r8 = r48
            r13 = r49
            r14 = r50
            r9 = r51
            goto L_0x044f
        L_0x055a:
            r41 = r3
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x057a }
            goto L_0x0576
        L_0x0569:
            r31 = r2
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            r7 = 0
        L_0x0576:
            kotlin.Result.m8971constructorimpl(r7)     // Catch:{ all -> 0x057a }
            goto L_0x05b6
        L_0x057a:
            r0 = move-exception
            r2 = r0
            goto L_0x05ad
        L_0x057d:
            r0 = move-exception
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05ad
        L_0x058a:
            r0 = move-exception
            r20 = r3
            r26 = r5
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            r2 = r0
            goto L_0x05ad
        L_0x059b:
            r0 = move-exception
            r19 = r2
            r20 = r3
            r26 = r5
            r46 = r7
            r48 = r8
            r51 = r9
            r49 = r13
            r50 = r14
            r2 = r0
        L_0x05ad:
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            kotlin.Result.m8971constructorimpl(r2)     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
        L_0x05b6:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            goto L_0x05c8
        L_0x05bc:
            r19 = r2
            r20 = r3
            r26 = r5
            r46 = r7
            r48 = r8
            r51 = r9
        L_0x05c8:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            r7 = r6
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            r21 = r4
            goto L_0x0e65
        L_0x05d3:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ea0
        L_0x05db:
            r0 = move-exception
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ec1
        L_0x05e3:
            r48 = r8
            r2 = r15
            r3 = 0
            android.graphics.drawable.Drawable$ConstantState r8 = r2.getConstantState()     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            if (r8 == 0) goto L_0x08f2
            r9 = 0
            r40 = r2
            java.lang.Class r2 = r8.getClass()     // Catch:{ Exception -> 0x08d0, Error -> 0x0908 }
            r41 = r3
            r42 = r9
            r3 = 0
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            java.lang.reflect.Method r2 = r2.getMethod(r10, r9)     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            r9 = 1
            r2.setAccessible(r9)     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            java.lang.Object r3 = r2.invoke(r8, r9)     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            boolean r9 = r3 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            if (r9 == 0) goto L_0x061d
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ Exception -> 0x0613, Error -> 0x0908 }
            r16 = r3
            goto L_0x061f
        L_0x0613:
            r0 = move-exception
            r2 = r0
            r44 = r8
            r47 = r11
            r49 = r12
            goto L_0x08dc
        L_0x061d:
            r16 = 0
        L_0x061f:
            if (r16 == 0) goto L_0x08be
            r3 = r16
            r9 = 0
            int r10 = r3.length     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            r43 = r2
            r2 = 0
        L_0x0628:
            if (r2 >= r10) goto L_0x08ae
            r16 = r3[r2]     // Catch:{ Exception -> 0x08c7, Error -> 0x0908 }
            r44 = r16
            r45 = 0
            r46 = r3
            r3 = r44
            r44 = r8
            boolean r8 = r3 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x08a7, Error -> 0x0908 }
            if (r8 == 0) goto L_0x06e3
            r8 = r3
            android.graphics.drawable.BitmapDrawable r8 = (android.graphics.drawable.BitmapDrawable) r8     // Catch:{ Exception -> 0x08a7, Error -> 0x0908 }
            android.graphics.Bitmap r8 = r8.getBitmap()     // Catch:{ Exception -> 0x08a7, Error -> 0x0908 }
            r47 = r11
            r49 = 0
            switch(r65) {
                case 0: goto L_0x067d;
                case 1: goto L_0x066d;
                case 2: goto L_0x0656;
                default: goto L_0x0649;
            }
        L_0x0649:
            r50 = r9
            r51 = r10
            r9 = r47
            r47 = r11
            int r10 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x06dd, Error -> 0x0908 }
            goto L_0x0693
        L_0x0656:
            int r50 = kotlin.math.MathKt.roundToInt((float) r47)     // Catch:{ Exception -> 0x0665, Error -> 0x0908 }
            r51 = r10
            r10 = r50
            r50 = r9
            r9 = r47
            r47 = r11
            goto L_0x0693
        L_0x0665:
            r0 = move-exception
            r2 = r0
            r47 = r11
            r49 = r12
            goto L_0x08dc
        L_0x066d:
            r50 = r9
            r51 = r10
            r9 = r47
            r47 = r11
            double r10 = (double) r9
            double r10 = java.lang.Math.floor(r10)     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            float r10 = (float) r10     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            int r10 = (int) r10     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            goto L_0x0693
        L_0x067d:
            r50 = r9
            r51 = r10
            r9 = r47
            r47 = r11
            double r10 = (double) r9     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            float r10 = (float) r10
            int r10 = (int) r10
            goto L_0x0693
        L_0x068d:
            r0 = move-exception
            r2 = r0
            r49 = r12
            goto L_0x08dc
        L_0x0693:
            r9 = r12
            r11 = 0
            switch(r65) {
                case 0: goto L_0x06b9;
                case 1: goto L_0x06ad;
                case 2: goto L_0x06a2;
                default: goto L_0x0699;
            }
        L_0x0699:
            r52 = r11
            r49 = r12
            int r11 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            goto L_0x06c4
        L_0x06a2:
            int r49 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ Exception -> 0x068d, Error -> 0x0908 }
            r52 = r11
            r11 = r49
            r49 = r12
            goto L_0x06c4
        L_0x06ad:
            r52 = r11
            r49 = r12
            double r11 = (double) r9
            double r11 = java.lang.Math.floor(r11)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            goto L_0x06c4
        L_0x06b9:
            r52 = r11
            r49 = r12
            double r11 = (double) r9     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
        L_0x06c4:
            r9 = 1
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createScaledBitmap(r8, r10, r11, r9)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r10 = 0
            java.lang.String r11 = "setBitmap"
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r9 = 0
            r12[r9] = r8     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r3, r11, r12)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r52 = r3
            goto L_0x0896
        L_0x06dd:
            r0 = move-exception
            r49 = r12
            r2 = r0
            goto L_0x08dc
        L_0x06e3:
            r50 = r9
            r51 = r10
            r47 = r11
            r49 = r12
            boolean r8 = r3 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            if (r8 == 0) goto L_0x0894
            com.baidu.searchbox.config.FontSizeHelper r8 = INSTANCE     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r9 = r3
            android.graphics.drawable.GradientDrawable r9 = (android.graphics.drawable.GradientDrawable) r9     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r10 = 0
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0864, Error -> 0x0908 }
            r12 = 24
            if (r11 < r12) goto L_0x070d
            float r11 = r9.getCornerRadius()     // Catch:{ Exception -> 0x0705, Error -> 0x0908 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x0705, Error -> 0x0908 }
            goto L_0x0715
        L_0x0705:
            r0 = move-exception
            r52 = r3
            r58 = r10
            r3 = r0
            goto L_0x086a
        L_0x070d:
            android.graphics.drawable.Drawable$ConstantState r11 = r9.getConstantState()     // Catch:{ Exception -> 0x0864, Error -> 0x0908 }
            java.lang.Object r11 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r11, r13)     // Catch:{ Exception -> 0x0864, Error -> 0x0908 }
        L_0x0715:
            r12 = r8
            r52 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r53 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0864, Error -> 0x0908 }
            boolean r53 = r53.isDebug()     // Catch:{ Exception -> 0x0864, Error -> 0x0908 }
            if (r53 == 0) goto L_0x0752
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x074a, Error -> 0x0908 }
            r12.<init>()     // Catch:{ Exception -> 0x074a, Error -> 0x0908 }
            java.lang.StringBuilder r12 = r12.append(r6)     // Catch:{ Exception -> 0x074a, Error -> 0x0908 }
            r52 = r3
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            java.lang.StringBuilder r3 = r12.append(r3)     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            android.util.Log.d(r14, r3)     // Catch:{ Exception -> 0x0744, Error -> 0x0908 }
            goto L_0x0754
        L_0x0744:
            r0 = move-exception
            r3 = r0
            r58 = r10
            goto L_0x086a
        L_0x074a:
            r0 = move-exception
            r52 = r3
            r3 = r0
            r58 = r10
            goto L_0x086a
        L_0x0752:
            r52 = r3
        L_0x0754:
            boolean r3 = r11 instanceof java.lang.Float     // Catch:{ Exception -> 0x085f, Error -> 0x0908 }
            if (r3 == 0) goto L_0x085a
            r3 = r11
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x085f, Error -> 0x0908 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x085f, Error -> 0x0908 }
            r12 = 0
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x085a
            r3 = r11
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x085f, Error -> 0x0908 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x085f, Error -> 0x0908 }
            r12 = r8
            r53 = 0
            r54 = r12
            r55 = 0
            r56 = r54
            r57 = 0
            r58 = r10
            r10 = 1
            if (r4 != r10) goto L_0x0780
            r59 = r11
            r10 = 0
            goto L_0x07b8
        L_0x0780:
            if (r1 != 0) goto L_0x0788
            if (r4 != 0) goto L_0x0788
            r59 = r11
            r10 = 0
            goto L_0x07b8
        L_0x0788:
            r10 = 0
            if (r4 < 0) goto L_0x0792
            r59 = r10
            r10 = 5
            if (r4 >= r10) goto L_0x0794
            r10 = 1
            goto L_0x0795
        L_0x0792:
            r59 = r10
        L_0x0794:
            r10 = 0
        L_0x0795:
            if (r10 != 0) goto L_0x079b
            r59 = r11
            r10 = 0
            goto L_0x07b8
        L_0x079b:
            r10 = -1
            if (r1 <= r10) goto L_0x07a5
            r10 = 4
            if (r1 < r10) goto L_0x07a2
            goto L_0x07a5
        L_0x07a2:
            r59 = r11
            goto L_0x07b7
        L_0x07a5:
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r59 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            if (r10 != 0) goto L_0x07b7
            r10 = 0
            goto L_0x07b8
        L_0x07b7:
            r10 = 1
        L_0x07b8:
            if (r10 != 0) goto L_0x07cc
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r10 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r56 = r12
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            r10.<init>(r12, r11, r3)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r57 = r3
            goto L_0x0845
        L_0x07c8:
            r0 = move-exception
            r3 = r0
            goto L_0x086a
        L_0x07cc:
            r56 = r12
            r10 = r54
            r11 = 0
            switch(r1) {
                case 0: goto L_0x0800;
                case 1: goto L_0x07f3;
                case 2: goto L_0x07e6;
                case 3: goto L_0x07d9;
                default: goto L_0x07d4;
            }     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
        L_0x07d4:
            java.util.HashMap r12 = mCustomerRatios     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            goto L_0x080d
        L_0x07d9:
            java.lang.Float[] r12 = SCALED_RATIO_T     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r12 = r12[r4]     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r57 = r10
            goto L_0x0838
        L_0x07e6:
            java.lang.Float[] r12 = SCALED_RATIO_H     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r12 = r12[r4]     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r57 = r10
            goto L_0x0838
        L_0x07f3:
            java.lang.Float[] r12 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r12 = r12[r4]     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r57 = r10
            goto L_0x0838
        L_0x0800:
            java.lang.Float[] r12 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r12 = r12[r4]     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r57 = r10
            goto L_0x0838
        L_0x080d:
            r57 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            boolean r10 = r12.containsKey(r10)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            if (r10 == 0) goto L_0x0836
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            java.lang.Object r10 = r10.get(r12)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            java.lang.Float[] r10 = (java.lang.Float[]) r10     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            if (r10 == 0) goto L_0x0833
            r12 = 0
            r60 = r10[r4]     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r60 = r60.floatValue()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r12 = r60
            goto L_0x0838
        L_0x0833:
            r12 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0838
        L_0x0836:
            r12 = 1065353216(0x3f800000, float:1.0)
        L_0x0838:
            r10 = r12
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            float r12 = r3 * r10
            r57 = r3
            r3 = 1
            r11.<init>(r3, r10, r12)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            r10 = r11
        L_0x0845:
            r3 = r10
            r10 = 0
            boolean r11 = r3.isScaledRequired()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            if (r11 != 0) goto L_0x0850
            r11 = r57
            goto L_0x0854
        L_0x0850:
            float r11 = r3.getScaledSize()     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
        L_0x0854:
            r9.setCornerRadius(r11)     // Catch:{ Exception -> 0x07c8, Error -> 0x0908 }
            goto L_0x0893
        L_0x085a:
            r58 = r10
            r59 = r11
            goto L_0x0893
        L_0x085f:
            r0 = move-exception
            r58 = r10
            r3 = r0
            goto L_0x086a
        L_0x0864:
            r0 = move-exception
            r52 = r3
            r58 = r10
            r3 = r0
        L_0x086a:
            r10 = r8
            r11 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r12 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            boolean r12 = r12.isDebug()     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            if (r12 == 0) goto L_0x0893
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r10.<init>()     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            java.lang.StringBuilder r10 = r10.append(r6)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            java.lang.StringBuilder r10 = r10.append(r7)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            android.util.Log.d(r14, r10)     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            r3.printStackTrace()     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
        L_0x0893:
            goto L_0x0896
        L_0x0894:
            r52 = r3
        L_0x0896:
            int r2 = r2 + 1
            r8 = r44
            r3 = r46
            r11 = r47
            r12 = r49
            r9 = r50
            r10 = r51
            goto L_0x0628
        L_0x08a7:
            r0 = move-exception
            r47 = r11
            r49 = r12
            r2 = r0
            goto L_0x08dc
        L_0x08ae:
            r46 = r3
            r44 = r8
            r50 = r9
            r47 = r11
            r49 = r12
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x08bb, Error -> 0x0908 }
            goto L_0x08c6
        L_0x08bb:
            r0 = move-exception
            r2 = r0
            goto L_0x08dc
        L_0x08be:
            r43 = r2
            r44 = r8
            r47 = r11
            r49 = r12
        L_0x08c6:
            goto L_0x08ec
        L_0x08c7:
            r0 = move-exception
            r44 = r8
            r47 = r11
            r49 = r12
            r2 = r0
            goto L_0x08dc
        L_0x08d0:
            r0 = move-exception
            r41 = r3
            r44 = r8
            r42 = r9
            r47 = r11
            r49 = r12
            r2 = r0
        L_0x08dc:
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            r5 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r6 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            boolean r6 = r6.isDebug()     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            if (r6 == 0) goto L_0x08ec
            r2.printStackTrace()     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
        L_0x08ec:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            goto L_0x08fa
        L_0x08f2:
            r40 = r2
            r41 = r3
            r47 = r11
            r49 = r12
        L_0x08fa:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0908, Exception -> 0x0902 }
            r7 = r15
        L_0x08fe:
            goto L_0x0963
        L_0x0902:
            r0 = move-exception
            r1 = r0
            r21 = r4
            goto L_0x0ea0
        L_0x0908:
            r0 = move-exception
            r1 = r0
            r21 = r4
            goto L_0x0ec1
        L_0x090e:
            r0 = move-exception
            r39 = r10
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ea0
        L_0x0918:
            r0 = move-exception
            r39 = r10
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ec1
        L_0x0922:
            r0 = move-exception
            r39 = r10
            r38 = r11
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ea0
        L_0x092e:
            r0 = move-exception
            r39 = r10
            r38 = r11
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ec1
        L_0x093a:
            r0 = move-exception
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ea0
        L_0x0948:
            r0 = move-exception
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
            r21 = r4
            r48 = r8
            goto L_0x0ec1
        L_0x0956:
            r32 = r3
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r35 = r12
            r7 = 0
        L_0x0963:
            r21 = r4
            goto L_0x0e65
        L_0x0967:
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r35 = r12
            r3 = r48
            boolean r8 = r3 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            if (r8 == 0) goto L_0x0b31
            r8 = r3
            android.graphics.drawable.GradientDrawable r8 = (android.graphics.drawable.GradientDrawable) r8     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r9 = 0
            r10 = r3
            android.graphics.drawable.GradientDrawable r10 = (android.graphics.drawable.GradientDrawable) r10     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r11 = 0
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            r15 = 24
            if (r12 < r15) goto L_0x0999
            float r12 = r10.getCornerRadius()     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            goto L_0x09a1
        L_0x098f:
            r0 = move-exception
            r5 = r0
            r22 = r8
            r17 = r9
            r20 = r11
            goto L_0x0aed
        L_0x0999:
            android.graphics.drawable.Drawable$ConstantState r12 = r10.getConstantState()     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            java.lang.Object r12 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r12, r13)     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
        L_0x09a1:
            r13 = r2
            r15 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r16 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            boolean r16 = r16.isDebug()     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            if (r16 == 0) goto L_0x09cc
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            r13.<init>()     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.StringBuilder r13 = r13.append(r6)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            int r15 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.StringBuilder r5 = r13.append(r5)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
            android.util.Log.d(r14, r5)     // Catch:{ Exception -> 0x098f, Error -> 0x0b29 }
        L_0x09cc:
            boolean r5 = r12 instanceof java.lang.Float     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            if (r5 == 0) goto L_0x0ade
            r5 = r12
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            r13 = 0
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0ade
            r5 = r12
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0ae5, Error -> 0x0b29 }
            r13 = r2
            r15 = 0
            r16 = r13
            r19 = 0
            r20 = r16
            r21 = 0
            r22 = r8
            r8 = 1
            if (r4 != r8) goto L_0x09f7
            r17 = r9
            r8 = 0
            goto L_0x0a2f
        L_0x09f7:
            if (r1 != 0) goto L_0x09ff
            if (r4 != 0) goto L_0x09ff
            r17 = r9
            r8 = 0
            goto L_0x0a2f
        L_0x09ff:
            r8 = 0
            if (r4 < 0) goto L_0x0a09
            r23 = r8
            r8 = 5
            if (r4 >= r8) goto L_0x0a0b
            r8 = 1
            goto L_0x0a0c
        L_0x0a09:
            r23 = r8
        L_0x0a0b:
            r8 = 0
        L_0x0a0c:
            if (r8 != 0) goto L_0x0a12
            r17 = r9
            r8 = 0
            goto L_0x0a2f
        L_0x0a12:
            r8 = -1
            if (r1 <= r8) goto L_0x0a1c
            r8 = 4
            if (r1 < r8) goto L_0x0a19
            goto L_0x0a1c
        L_0x0a19:
            r17 = r9
            goto L_0x0a2e
        L_0x0a1c:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0ad7, Error -> 0x0b29 }
            r17 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a3f, Error -> 0x0b29 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ Exception -> 0x0a3f, Error -> 0x0b29 }
            if (r8 != 0) goto L_0x0a2e
            r8 = 0
            goto L_0x0a2f
        L_0x0a2e:
            r8 = 1
        L_0x0a2f:
            if (r8 != 0) goto L_0x0a45
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a3f, Error -> 0x0b29 }
            r20 = r11
            r9 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r8.<init>(r11, r9, r5)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r21 = r5
            goto L_0x0ac2
        L_0x0a3f:
            r0 = move-exception
            r20 = r11
            r5 = r0
            goto L_0x0aed
        L_0x0a45:
            r20 = r11
            r8 = r16
            r9 = 0
            switch(r1) {
                case 0: goto L_0x0a79;
                case 1: goto L_0x0a6c;
                case 2: goto L_0x0a5f;
                case 3: goto L_0x0a52;
                default: goto L_0x0a4d;
            }     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
        L_0x0a4d:
            java.util.HashMap r11 = mCustomerRatios     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            goto L_0x0a8a
        L_0x0a52:
            java.lang.Float[] r11 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r21 = r8
            goto L_0x0ab5
        L_0x0a5f:
            java.lang.Float[] r11 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r21 = r8
            goto L_0x0ab5
        L_0x0a6c:
            java.lang.Float[] r11 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r21 = r8
            goto L_0x0ab5
        L_0x0a79:
            java.lang.Float[] r11 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r21 = r8
            goto L_0x0ab5
        L_0x0a86:
            r0 = move-exception
            r5 = r0
            goto L_0x0aed
        L_0x0a8a:
            r21 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            boolean r8 = r11.containsKey(r8)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            if (r8 == 0) goto L_0x0ab3
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            java.lang.Object r8 = r8.get(r11)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            java.lang.Float[] r8 = (java.lang.Float[]) r8     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            if (r8 == 0) goto L_0x0ab0
            r11 = 0
            r18 = r8[r4]     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r18 = r18.floatValue()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r11 = r18
            goto L_0x0ab5
        L_0x0ab0:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0ab5
        L_0x0ab3:
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x0ab5:
            r8 = r11
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r9 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            float r11 = r5 * r8
            r21 = r5
            r5 = 1
            r9.<init>(r5, r8, r11)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            r8 = r9
        L_0x0ac2:
            r5 = r8
            r8 = 0
            boolean r9 = r5.isScaledRequired()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            if (r9 != 0) goto L_0x0acd
            r9 = r21
            goto L_0x0ad1
        L_0x0acd:
            float r9 = r5.getScaledSize()     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
        L_0x0ad1:
            r10.setCornerRadius(r9)     // Catch:{ Exception -> 0x0a86, Error -> 0x0b29 }
            goto L_0x0b16
        L_0x0ad7:
            r0 = move-exception
            r17 = r9
            r20 = r11
            r5 = r0
            goto L_0x0aed
        L_0x0ade:
            r22 = r8
            r17 = r9
            r20 = r11
            goto L_0x0b16
        L_0x0ae5:
            r0 = move-exception
            r22 = r8
            r17 = r9
            r20 = r11
            r5 = r0
        L_0x0aed:
            r8 = r2
            r9 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r11 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            boolean r11 = r11.isDebug()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            if (r11 == 0) goto L_0x0b16
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r8.<init>()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.StringBuilder r6 = r6.append(r8)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.String r6 = r6.toString()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            android.util.Log.d(r14, r6)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r5.printStackTrace()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
        L_0x0b16:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r7 = r3
            r48 = r7
            r21 = r4
            goto L_0x0e65
        L_0x0b21:
            r0 = move-exception
            r1 = r0
            r48 = r3
            r21 = r4
            goto L_0x0ea0
        L_0x0b29:
            r0 = move-exception
            r1 = r0
            r48 = r3
            r21 = r4
            goto L_0x0ec1
        L_0x0b31:
            boolean r5 = r3 instanceof android.graphics.drawable.NinePatchDrawable     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            if (r5 == 0) goto L_0x0cbd
            r5 = r3
            android.graphics.drawable.NinePatchDrawable r5 = (android.graphics.drawable.NinePatchDrawable) r5     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r6 = r2
            r7 = 0
            if (r5 == 0) goto L_0x0cae
            r8 = r5
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = r2
            r12 = 0
            r13 = r11
            r15 = 0
            r16 = r13
            r19 = 0
            r20 = r5
            r5 = 1
            if (r4 != r5) goto L_0x0b52
            r17 = r6
            r5 = 0
            goto L_0x0b8a
        L_0x0b52:
            if (r1 != 0) goto L_0x0b5a
            if (r4 != 0) goto L_0x0b5a
            r17 = r6
            r5 = 0
            goto L_0x0b8a
        L_0x0b5a:
            r5 = 0
            if (r4 < 0) goto L_0x0b64
            r21 = r5
            r5 = 5
            if (r4 >= r5) goto L_0x0b66
            r5 = 1
            goto L_0x0b67
        L_0x0b64:
            r21 = r5
        L_0x0b66:
            r5 = 0
        L_0x0b67:
            if (r5 != 0) goto L_0x0b6d
            r17 = r6
            r5 = 0
            goto L_0x0b8a
        L_0x0b6d:
            r5 = -1
            if (r1 <= r5) goto L_0x0b77
            r5 = 4
            if (r1 < r5) goto L_0x0b74
            goto L_0x0b77
        L_0x0b74:
            r17 = r6
            goto L_0x0b89
        L_0x0b77:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Exception -> 0x0c90, Error -> 0x0b29 }
            r17 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c89, Error -> 0x0b29 }
            boolean r5 = r5.containsKey(r6)     // Catch:{ Exception -> 0x0c89, Error -> 0x0b29 }
            if (r5 != 0) goto L_0x0b89
            r5 = 0
            goto L_0x0b8a
        L_0x0b89:
            r5 = 1
        L_0x0b8a:
            if (r5 != 0) goto L_0x0ba2
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b9a, Error -> 0x0b29 }
            r18 = r7
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r5.<init>(r7, r6, r10)     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r16 = r9
            goto L_0x0c22
        L_0x0b9a:
            r0 = move-exception
            r18 = r7
            r2 = r0
            r16 = r9
            goto L_0x0c98
        L_0x0ba2:
            r18 = r7
            r6 = 1065353216(0x3f800000, float:1.0)
            r5 = r13
            r7 = 0
            switch(r1) {
                case 0: goto L_0x0bd7;
                case 1: goto L_0x0bca;
                case 2: goto L_0x0bbd;
                case 3: goto L_0x0bb0;
                default: goto L_0x0bab;
            }
        L_0x0bab:
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0c84, Error -> 0x0b29 }
            goto L_0x0bea
        L_0x0bb0:
            java.lang.Float[] r6 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r6 = r6[r4]     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r16 = r5
            goto L_0x0c15
        L_0x0bbd:
            java.lang.Float[] r6 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r6 = r6[r4]     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r16 = r5
            goto L_0x0c15
        L_0x0bca:
            java.lang.Float[] r6 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r6 = r6[r4]     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r16 = r5
            goto L_0x0c15
        L_0x0bd7:
            java.lang.Float[] r6 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r6 = r6[r4]     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r16 = r5
            goto L_0x0c15
        L_0x0be4:
            r0 = move-exception
            r2 = r0
            r16 = r9
            goto L_0x0c98
        L_0x0bea:
            r16 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c84, Error -> 0x0b29 }
            boolean r5 = r6.containsKey(r5)     // Catch:{ Exception -> 0x0c84, Error -> 0x0b29 }
            if (r5 == 0) goto L_0x0c13
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            java.lang.Float[] r5 = (java.lang.Float[]) r5     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            if (r5 == 0) goto L_0x0c10
            r6 = 0
            r19 = r5[r4]     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x0be4, Error -> 0x0b29 }
            r6 = r19
            goto L_0x0c15
        L_0x0c10:
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0c15
        L_0x0c13:
            r6 = 1065353216(0x3f800000, float:1.0)
        L_0x0c15:
            r5 = r6
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0c84, Error -> 0x0b29 }
            float r7 = r10 * r5
            r16 = r9
            r9 = 1
            r6.<init>(r9, r5, r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            r5 = r6
        L_0x0c22:
            r6 = 0
            boolean r7 = r5.isScaledRequired()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            if (r7 != 0) goto L_0x0c2c
            r7 = r10
            goto L_0x0c30
        L_0x0c2c:
            float r7 = r5.getScaledSize()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
        L_0x0c30:
            r5 = r7
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            int r6 = r6.densityDpi     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            float r7 = (float) r6     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            float r7 = r7 * r5
            int r7 = (int) r7     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            r8.setTargetDensity(r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            r7 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r9 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            boolean r9 = r9.isDebug()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            if (r9 == 0) goto L_0x0ca8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            r2.<init>()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.String r7 = "scaled: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.String r7 = ", displayMetrics: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.String r7 = ", result: "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            float r7 = (float) r6     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            float r7 = r7 * r5
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            android.util.Log.d(r14, r2)     // Catch:{ Exception -> 0x0c81, Error -> 0x0b29 }
            goto L_0x0ca8
        L_0x0c81:
            r0 = move-exception
            r2 = r0
            goto L_0x0c98
        L_0x0c84:
            r0 = move-exception
            r16 = r9
            r2 = r0
            goto L_0x0c98
        L_0x0c89:
            r0 = move-exception
            r18 = r7
            r16 = r9
            r2 = r0
            goto L_0x0c98
        L_0x0c90:
            r0 = move-exception
            r17 = r6
            r18 = r7
            r16 = r9
            r2 = r0
        L_0x0c98:
            com.baidu.searchbox.config.FontSizeHelper r5 = INSTANCE     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r6 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r7 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            boolean r7 = r7.isDebug()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            if (r7 == 0) goto L_0x0ca8
            r2.printStackTrace()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
        L_0x0ca8:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r7 = r20
            goto L_0x0cb5
        L_0x0cae:
            r20 = r5
            r17 = r6
            r18 = r7
            r7 = 0
        L_0x0cb5:
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r48 = r3
            r21 = r4
            goto L_0x0e65
        L_0x0cbd:
            r5 = r2
            r6 = 0
            r7 = r5
            r8 = 0
            if (r3 == 0) goto L_0x0e5b
            r9 = r3
            r10 = 0
            int r11 = r3.getIntrinsicWidth()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r11 = (float) r11     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r11 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r11)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            int r12 = r3.getIntrinsicHeight()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r12 = (float) r12     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            r13 = r2
            r14 = 0
            r15 = r13
            r16 = 0
            r18 = r5
            r5 = 1
            if (r4 != r5) goto L_0x0ce6
            r17 = r6
            r5 = 0
            goto L_0x0d1e
        L_0x0ce6:
            if (r1 != 0) goto L_0x0cee
            if (r4 != 0) goto L_0x0cee
            r17 = r6
            r5 = 0
            goto L_0x0d1e
        L_0x0cee:
            r5 = 0
            if (r4 < 0) goto L_0x0cf8
            r20 = r5
            r5 = 5
            if (r4 >= r5) goto L_0x0cfa
            r5 = 1
            goto L_0x0cfb
        L_0x0cf8:
            r20 = r5
        L_0x0cfa:
            r5 = 0
        L_0x0cfb:
            if (r5 != 0) goto L_0x0d01
            r17 = r6
            r5 = 0
            goto L_0x0d1e
        L_0x0d01:
            r5 = -1
            if (r1 <= r5) goto L_0x0d0b
            r5 = 4
            if (r1 < r5) goto L_0x0d08
            goto L_0x0d0b
        L_0x0d08:
            r17 = r6
            goto L_0x0d1d
        L_0x0d0b:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            r17 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            boolean r5 = r5.containsKey(r6)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            if (r5 != 0) goto L_0x0d1d
            r5 = 0
            goto L_0x0d1e
        L_0x0d1d:
            r5 = 1
        L_0x0d1e:
            if (r5 != 0) goto L_0x0d28
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r6 = 0
            r5.<init>(r6, r11, r12)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0d95
        L_0x0d28:
            r5 = r13
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0d53;
                case 1: goto L_0x0d48;
                case 2: goto L_0x0d3d;
                case 3: goto L_0x0d32;
                default: goto L_0x0d2d;
            }
        L_0x0d2d:
            java.util.HashMap r15 = mCustomerRatios     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            goto L_0x0d5e
        L_0x0d32:
            java.lang.Float[] r15 = SCALED_RATIO_T     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r15 = r15[r4]     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0d87
        L_0x0d3d:
            java.lang.Float[] r15 = SCALED_RATIO_H     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r15 = r15[r4]     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0d87
        L_0x0d48:
            java.lang.Float[] r15 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r15 = r15[r4]     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0d87
        L_0x0d53:
            java.lang.Float[] r15 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r15 = r15[r4]     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0d87
        L_0x0d5e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            boolean r1 = r15.containsKey(r1)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            if (r1 == 0) goto L_0x0d85
            java.util.HashMap r1 = mCustomerRatios     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            java.lang.Float[] r1 = (java.lang.Float[]) r1     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            if (r1 == 0) goto L_0x0d82
            r15 = 0
            r16 = r1[r4]     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            r15 = r16
            goto L_0x0d87
        L_0x0d82:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0d87
        L_0x0d85:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x0d87:
            r1 = r15
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r6 = r11 * r1
            float r15 = r12 * r1
            r16 = r1
            r1 = 1
            r5.<init>(r1, r6, r15)     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
        L_0x0d95:
            r1 = r5
            r5 = 0
            boolean r6 = r1.isScaledRequired()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            if (r6 != 0) goto L_0x0da6
            r16 = r1
            r2 = r3
            r48 = r2
            r21 = r4
            goto L_0x0e44
        L_0x0da6:
            float r6 = r1.getScaledWidth()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            float r11 = r1.getScaledHeight()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            r12 = r3
            r13 = 0
            r14 = 0
            int r15 = r12.getIntrinsicWidth()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            int r16 = r12.getIntrinsicHeight()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            r19 = r16
            r16 = r1
            int r1 = r12.getOpacity()     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
            r20 = r2
            r2 = -1
            if (r1 == r2) goto L_0x0dca
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Error -> 0x0b29, Exception -> 0x0b21 }
            goto L_0x0dcc
        L_0x0dca:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error -> 0x0e6f, Exception -> 0x0e68 }
        L_0x0dcc:
            r48 = r3
            r2 = r19
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r15, r2, r1)     // Catch:{ Error -> 0x0e55, Exception -> 0x0e50 }
            r19 = r1
            java.lang.String r1 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ Error -> 0x0e55, Exception -> 0x0e50 }
            r1 = r3
            android.graphics.Canvas r3 = new android.graphics.Canvas     // Catch:{ Error -> 0x0e55, Exception -> 0x0e50 }
            r3.<init>(r1)     // Catch:{ Error -> 0x0e55, Exception -> 0x0e50 }
            r21 = r4
            r4 = 0
            r12.setBounds(r4, r4, r15, r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            r12.draw(r3)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            r2 = r6
            r3 = 0
            switch(r65) {
                case 0: goto L_0x0e03;
                case 1: goto L_0x0dfb;
                case 2: goto L_0x0df6;
                default: goto L_0x0df1;
            }     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
        L_0x0df1:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e0a
        L_0x0df6:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e0a
        L_0x0dfb:
            double r14 = (double) r2     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            float r4 = (float) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            int r4 = (int) r4     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e0a
        L_0x0e03:
            double r14 = (double) r2     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            float r4 = (float) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            int r4 = (int) r4     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
        L_0x0e0a:
            r2 = r11
            r3 = 0
            switch(r65) {
                case 0: goto L_0x0e22;
                case 1: goto L_0x0e1a;
                case 2: goto L_0x0e15;
                default: goto L_0x0e10;
            }     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
        L_0x0e10:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e29
        L_0x0e15:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e29
        L_0x0e1a:
            double r14 = (double) r2     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            goto L_0x0e29
        L_0x0e22:
            double r14 = (double) r2     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
        L_0x0e29:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r4, r14, r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            java.lang.String r2 = "createScaledBitmap(\n    …       true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            r2.<init>(r3, r1)     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Error -> 0x0e4c, Exception -> 0x0e48 }
        L_0x0e44:
            r7 = r2
            goto L_0x0e64
        L_0x0e48:
            r0 = move-exception
            r1 = r0
            goto L_0x0ea0
        L_0x0e4c:
            r0 = move-exception
            r1 = r0
            goto L_0x0ec1
        L_0x0e50:
            r0 = move-exception
            r21 = r4
            r1 = r0
            goto L_0x0ea0
        L_0x0e55:
            r0 = move-exception
            r21 = r4
            r1 = r0
            goto L_0x0ec1
        L_0x0e5b:
            r48 = r3
            r21 = r4
            r18 = r5
            r17 = r6
            r7 = 0
        L_0x0e64:
        L_0x0e65:
            goto L_0x0ed4
        L_0x0e68:
            r0 = move-exception
            r48 = r3
            r21 = r4
            r1 = r0
            goto L_0x0ea0
        L_0x0e6f:
            r0 = move-exception
            r48 = r3
            r21 = r4
            r1 = r0
            goto L_0x0ec1
        L_0x0e76:
            r0 = move-exception
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
            goto L_0x0ea0
        L_0x0e83:
            r0 = move-exception
            r21 = r4
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
            goto L_0x0ec1
        L_0x0e90:
            r0 = move-exception
            r27 = r3
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
        L_0x0ea0:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0eb0
            r1.printStackTrace()
        L_0x0eb0:
            goto L_0x0ed2
        L_0x0eb1:
            r0 = move-exception
            r27 = r3
            r21 = r4
            r28 = r5
            r48 = r8
            r37 = r9
            r39 = r10
            r38 = r11
            r1 = r0
        L_0x0ec1:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0ed1
            r1.printStackTrace()
        L_0x0ed1:
        L_0x0ed2:
            r7 = r63
        L_0x0ed4:
            goto L_0x0ede
        L_0x0ed7:
            r27 = r3
            r21 = r4
            r28 = r5
            r7 = 0
        L_0x0ede:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledDrawableWithBaseFontSize(int, android.graphics.drawable.Drawable, int, int):android.graphics.drawable.Drawable");
    }

    public static /* synthetic */ Drawable getScaledDrawableForTargetFontSize$default(int i2, Drawable drawable, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        return getScaledDrawableForTargetFontSize(i2, drawable, i3, i4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v23, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v25, resolved type: android.graphics.drawable.GradientDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v16, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r45v2, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v17, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x05ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0600, code lost:
        r3 = r0;
        r44 = r9;
        r47 = r12;
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0651, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0652, code lost:
        r3 = r0;
        r47 = r12;
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0679, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x067a, code lost:
        r3 = r0;
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x067f, code lost:
        r10 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0682, code lost:
        switch(r65) {
            case 0: goto L_0x06a5;
            case 1: goto L_0x0699;
            case 2: goto L_0x068e;
            default: goto L_0x0685;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0685, code lost:
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:?, code lost:
        r12 = kotlin.math.MathKt.roundToInt(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0692, code lost:
        r12 = kotlin.math.MathKt.roundToInt(r10);
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x0699, code lost:
        r48 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:?, code lost:
        r12 = (int) ((float) java.lang.Math.floor((double) r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06a5, code lost:
        r48 = r13;
        r12 = (int) ((float) java.lang.Math.ceil((double) r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x06b0, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r4, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r9, r11, r12, true));
        r52 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x06c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x06ca, code lost:
        r48 = r13;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x06f2, code lost:
        r52 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0730, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0731, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0736, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0737, code lost:
        r52 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x07b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x07b5, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x084b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x084c, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:434:0x0850, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x0851, code lost:
        r52 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:444:0x0893, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x0894, code lost:
        r47 = r12;
        r48 = r13;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:0x08a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x08a8, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x08b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x08b4, code lost:
        r44 = r9;
        r47 = r12;
        r48 = r13;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x08bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:453:0x08bd, code lost:
        r44 = r9;
        r47 = r12;
        r48 = r13;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:455:?, code lost:
        r4 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x08d3, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x08d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:457:0x08d5, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x08f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:0x08f3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:493:0x096a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x096b, code lost:
        r5 = r0;
        r17 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:539:0x0a18, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:540:0x0a19, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:564:0x0ab6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:565:0x0ab7, code lost:
        r17 = r9;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:570:0x0ac8, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:573:0x0aee, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:574:0x0aef, code lost:
        r1 = r0;
        r49 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:575:0x0af4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:576:0x0af5, code lost:
        r1 = r0;
        r49 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:620:0x0b63, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:621:0x0b64, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:632:0x0bad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:633:0x0bae, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:658:0x0c4a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:659:0x0c4b, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:660:0x0c4d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:661:0x0c4e, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:662:0x0c52, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:663:0x0c53, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:664:0x0c59, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:665:0x0c5a, code lost:
        r17 = r7;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:667:?, code lost:
        r5 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:668:0x0c6c, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0c6e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:669:0x0c6e, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:773:0x0e74, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:295:0x05dd] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:298:0x05e6] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:301:0x05fa] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:314:0x0623] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:321:0x063d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:323:0x0642] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:329:0x0662] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:338:0x0689] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:354:0x06e2] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:358:0x06e8] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:366:0x070f] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:369:0x071a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:376:0x0740] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:283:0x059f, B:402:0x0791] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:605:0x0b40] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:608:0x0b46] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:614:0x0b55] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:617:0x0b5c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:624:0x0b74] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:484:0x0953, B:649:0x0be7] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0783  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0787  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x08d5 A[Catch:{ Error -> 0x08f2, Exception -> 0x08ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x08f2 A[ExcHandler: Error (r0v18 'e' java.lang.Error A[CUSTOM_DECLARE]), PHI: r39 
      PHI: (r39v7 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper) = (r39v6 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper), (r39v14 'this_$iv$iv' com.baidu.searchbox.config.FontSizeHelper) binds: [B:740:0x0da8, B:295:0x05dd, B:454:0x08c8, B:298:0x05e6, B:299:?, B:309:0x0610, B:314:0x0623, B:354:0x06e2, B:437:0x0858, B:355:?, B:376:0x0740, B:402:0x0791, B:366:0x070f, B:369:0x071a, B:370:?, B:362:0x06f9, B:358:0x06e8, B:344:0x069e, B:340:0x068e, B:338:0x0689, B:329:0x0662, B:323:0x0642, B:321:0x063d, B:301:0x05fa, B:302:?, B:202:0x0408, B:283:0x059f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:283:0x059f] */
    /* JADX WARNING: Removed duplicated region for block: B:520:0x09e7 A[Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:521:0x09eb A[Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:570:0x0ac8 A[Catch:{ Error -> 0x0af4, Exception -> 0x0aee }] */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x0af4 A[ExcHandler: Error (r0v12 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:484:0x0953] */
    /* JADX WARNING: Removed duplicated region for block: B:599:0x0b32  */
    /* JADX WARNING: Removed duplicated region for block: B:600:0x0b36  */
    /* JADX WARNING: Removed duplicated region for block: B:669:0x0c6e A[Catch:{ Error -> 0x0af4, Exception -> 0x0aee }] */
    /* JADX WARNING: Removed duplicated region for block: B:692:0x0cc4 A[Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }] */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0cc8 A[Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }] */
    /* JADX WARNING: Removed duplicated region for block: B:768:0x0e53  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x0e74  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:376:0x0740=Splitter:B:376:0x0740, B:402:0x0791=Splitter:B:402:0x0791, B:454:0x08c8=Splitter:B:454:0x08c8, B:283:0x059f=Splitter:B:283:0x059f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:454:0x08c8=Splitter:B:454:0x08c8, B:283:0x059f=Splitter:B:283:0x059f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:605:0x0b40=Splitter:B:605:0x0b40, B:666:0x0c61=Splitter:B:666:0x0c61, B:501:0x09a5=Splitter:B:501:0x09a5} */
    @kotlin.jvm.JvmStatic
    @com.baidu.pyramid.annotation.nps.PluginAccessible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.drawable.Drawable getScaledDrawableForTargetFontSize(int r62, android.graphics.drawable.Drawable r63, int r64, int r65) {
        /*
            r1 = r62
            r2 = r64
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE
            r4 = r3
            r5 = 1
            r6 = r5
            r7 = 0
            if (r63 == 0) goto L_0x0e7d
            r9 = r63
            r10 = 0
            com.baidu.searchbox.config.FontSizeHelper r11 = INSTANCE
            r12 = 0
            r13 = 0
            boolean r14 = r9 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0e57, Exception -> 0x0e36 }
            if (r14 == 0) goto L_0x02ac
            r14 = r9
            android.graphics.drawable.BitmapDrawable r14 = (android.graphics.drawable.BitmapDrawable) r14     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            r20 = r3
            r21 = 0
            r22 = r20
            r23 = 0
            r24 = r14
            android.graphics.drawable.Drawable r24 = (android.graphics.drawable.Drawable) r24     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            if (r24 == 0) goto L_0x0258
            r16 = r24
            r24 = 0
            r25 = r14
            android.graphics.drawable.Drawable r25 = (android.graphics.drawable.Drawable) r25     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            int r15 = r25.getIntrinsicWidth()     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            float r15 = (float) r15     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            float r15 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r15)     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            r25 = r14
            android.graphics.drawable.Drawable r25 = (android.graphics.drawable.Drawable) r25     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            int r8 = r25.getIntrinsicHeight()     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            float r8 = (float) r8     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            float r8 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r8)     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            r25 = 0
            r28 = r3
            r29 = 0
            if (r2 != r5) goto L_0x0059
            r30 = r4
            r4 = 0
            goto L_0x008e
        L_0x0059:
            if (r1 != 0) goto L_0x0061
            if (r2 != 0) goto L_0x0061
            r30 = r4
            r4 = 0
            goto L_0x008e
        L_0x0061:
            r30 = 0
            if (r2 < 0) goto L_0x006a
            r5 = 5
            if (r2 >= r5) goto L_0x006a
            r5 = 1
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            if (r5 != 0) goto L_0x0071
            r30 = r4
            r4 = 0
            goto L_0x008e
        L_0x0071:
            r5 = -1
            if (r1 <= r5) goto L_0x007b
            r5 = 4
            if (r1 < r5) goto L_0x0078
            goto L_0x007b
        L_0x0078:
            r30 = r4
            goto L_0x008d
        L_0x007b:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x029a, Exception -> 0x0288 }
            r30 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            boolean r4 = r5.containsKey(r4)     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            if (r4 != 0) goto L_0x008d
            r4 = 0
            goto L_0x008e
        L_0x008d:
            r4 = 1
        L_0x008e:
            if (r4 != 0) goto L_0x00ba
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r5 = 0
            r4.<init>(r5, r15, r8)     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r28 = r6
            goto L_0x0144
        L_0x009a:
            r0 = move-exception
            r1 = r0
            r28 = r6
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x00aa:
            r0 = move-exception
            r1 = r0
            r28 = r6
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x00ba:
            r4 = r3
            r5 = 0
            switch(r1) {
                case 0: goto L_0x00f9;
                case 1: goto L_0x00e8;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00c6;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            r17 = r3
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            goto L_0x010a
        L_0x00c6:
            java.lang.Float[] r17 = SCALED_RATIO_T     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r17 = r17[r2]     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r18 = r4
            r19 = r17
            r17 = r3
            goto L_0x0133
        L_0x00d7:
            java.lang.Float[] r17 = SCALED_RATIO_H     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r17 = r17[r2]     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r18 = r4
            r19 = r17
            r17 = r3
            goto L_0x0133
        L_0x00e8:
            java.lang.Float[] r17 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r17 = r17[r2]     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r18 = r4
            r19 = r17
            r17 = r3
            goto L_0x0133
        L_0x00f9:
            java.lang.Float[] r17 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r17 = r17[r2]     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            r18 = r4
            r19 = r17
            r17 = r3
            goto L_0x0133
        L_0x010a:
            r18 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            if (r3 == 0) goto L_0x0131
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            java.lang.Float[] r3 = (java.lang.Float[]) r3     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            if (r3 == 0) goto L_0x012e
            r4 = 0
            r19 = r3[r2]     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            float r19 = r19.floatValue()     // Catch:{ Error -> 0x00aa, Exception -> 0x009a }
            goto L_0x0133
        L_0x012e:
            r19 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0133
        L_0x0131:
            r19 = 1065353216(0x3f800000, float:1.0)
        L_0x0133:
            r3 = r19
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0248, Exception -> 0x0238 }
            float r5 = r15 * r3
            r28 = r6
            float r6 = r8 * r3
            r18 = r3
            r3 = 1
            r4.<init>(r3, r5, r6)     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
        L_0x0144:
            r3 = r4
            r4 = 0
            boolean r5 = r3.isScaledRequired()     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            if (r5 != 0) goto L_0x0174
            r5 = r14
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch:{ Error -> 0x0166, Exception -> 0x0158 }
            r17 = r3
            r25 = r4
            r8 = r5
            r29 = r7
            goto L_0x0219
        L_0x0158:
            r0 = move-exception
            r1 = r0
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x0166:
            r0 = move-exception
            r1 = r0
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x0174:
            float r5 = r3.getScaledWidth()     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            float r6 = r3.getScaledHeight()     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            r8 = r14
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            android.graphics.drawable.BitmapDrawable r8 = (android.graphics.drawable.BitmapDrawable) r8     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            r15 = 0
            r17 = r3
            android.graphics.Bitmap r3 = r8.getBitmap()     // Catch:{ Error -> 0x022a, Exception -> 0x021c }
            r18 = r5
            r19 = 0
            switch(r65) {
                case 0: goto L_0x01bb;
                case 1: goto L_0x01ab;
                case 2: goto L_0x019c;
                default: goto L_0x018f;
            }
        L_0x018f:
            r25 = r4
            r29 = r7
            r4 = r18
            r18 = r8
            int r7 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            goto L_0x01ca
        L_0x019c:
            int r25 = kotlin.math.MathKt.roundToInt((float) r18)     // Catch:{ Error -> 0x0166, Exception -> 0x0158 }
            r29 = r7
            r7 = r25
            r25 = r4
            r4 = r18
            r18 = r8
            goto L_0x01ca
        L_0x01ab:
            r25 = r4
            r29 = r7
            r4 = r18
            r18 = r8
            double r7 = (double) r4
            double r7 = java.lang.Math.floor(r7)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            float r7 = (float) r7     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            int r7 = (int) r7     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            goto L_0x01ca
        L_0x01bb:
            r25 = r4
            r29 = r7
            r4 = r18
            r18 = r8
            double r7 = (double) r4     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            float r7 = (float) r7     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            int r7 = (int) r7     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
        L_0x01ca:
            r4 = r6
            r8 = 0
            switch(r65) {
                case 0: goto L_0x01f2;
                case 1: goto L_0x01e6;
                case 2: goto L_0x01d9;
                default: goto L_0x01d0;
            }     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
        L_0x01d0:
            r19 = r5
            r26 = r6
            int r5 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            goto L_0x01fd
        L_0x01d9:
            int r19 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            r26 = r6
            r61 = r19
            r19 = r5
            r5 = r61
            goto L_0x01fd
        L_0x01e6:
            r19 = r5
            r26 = r6
            double r5 = (double) r4     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            double r5 = java.lang.Math.floor(r5)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            float r5 = (float) r5     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            int r5 = (int) r5     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            goto L_0x01fd
        L_0x01f2:
            r19 = r5
            r26 = r6
            double r5 = (double) r4     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            float r5 = (float) r5     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            int r5 = (int) r5     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
        L_0x01fd:
            r4 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r7, r5, r4)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            java.lang.String r4 = "createScaledBitmap(\n    …licy), true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            r4.<init>(r5, r3)     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            r8 = r4
        L_0x0219:
            goto L_0x025f
        L_0x021c:
            r0 = move-exception
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x022a:
            r0 = move-exception
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x0238:
            r0 = move-exception
            r28 = r6
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x0248:
            r0 = move-exception
            r28 = r6
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x0258:
            r30 = r4
            r28 = r6
            r29 = r7
            r8 = 0
        L_0x025f:
            android.graphics.drawable.BitmapDrawable r8 = (android.graphics.drawable.BitmapDrawable) r8     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x027c, Exception -> 0x0270 }
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r35 = r13
            goto L_0x0e13
        L_0x0270:
            r0 = move-exception
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x027c:
            r0 = move-exception
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x0288:
            r0 = move-exception
            r30 = r4
            r28 = r6
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e46
        L_0x029a:
            r0 = move-exception
            r30 = r4
            r28 = r6
            r29 = r7
            r1 = r0
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            goto L_0x0e67
        L_0x02ac:
            r30 = r4
            r28 = r6
            r29 = r7
            boolean r4 = r9 instanceof android.graphics.drawable.StateListDrawable     // Catch:{ Error -> 0x0e2b, Exception -> 0x0e20 }
            if (r4 == 0) goto L_0x02b8
            r4 = 1
            goto L_0x02ba
        L_0x02b8:
            boolean r4 = r9 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0e2b, Exception -> 0x0e20 }
        L_0x02ba:
            java.lang.String r5 = ", OriginalRadius is :"
            java.lang.String r7 = ", GradientDrawable ReflectionUtil Error"
            java.lang.String r8 = "mRadius"
            java.lang.String r15 = "Version: "
            java.lang.String r6 = "FontSizeHelper"
            if (r4 == 0) goto L_0x0942
            r4 = r3
            r21 = 0
            r22 = r4
            r23 = 0
            if (r9 == 0) goto L_0x0932
            r24 = r9
            r25 = 0
            int r14 = r9.getIntrinsicWidth()     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            float r14 = (float) r14     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            float r14 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r14)     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            r32 = r4
            int r4 = r9.getIntrinsicHeight()     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            float r4 = (float) r4     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            float r4 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r4)     // Catch:{ Error -> 0x0926, Exception -> 0x091a }
            r33 = r3
            r34 = 0
            r35 = r33
            r36 = 0
            r37 = r10
            r10 = 1
            if (r2 != r10) goto L_0x02fa
            r38 = r12
            r10 = 0
            goto L_0x0332
        L_0x02fa:
            if (r1 != 0) goto L_0x0302
            if (r2 != 0) goto L_0x0302
            r38 = r12
            r10 = 0
            goto L_0x0332
        L_0x0302:
            r10 = 0
            if (r2 < 0) goto L_0x030c
            r38 = r10
            r10 = 5
            if (r2 >= r10) goto L_0x030e
            r10 = 1
            goto L_0x030f
        L_0x030c:
            r38 = r10
        L_0x030e:
            r10 = 0
        L_0x030f:
            if (r10 != 0) goto L_0x0315
            r38 = r12
            r10 = 0
            goto L_0x0332
        L_0x0315:
            r10 = -1
            if (r1 <= r10) goto L_0x031f
            r10 = 4
            if (r1 < r10) goto L_0x031c
            goto L_0x031f
        L_0x031c:
            r38 = r12
            goto L_0x0331
        L_0x031f:
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Error -> 0x0910, Exception -> 0x0906 }
            r38 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            boolean r10 = r10.containsKey(r12)     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            if (r10 != 0) goto L_0x0331
            r10 = 0
            goto L_0x0332
        L_0x0331:
            r10 = 1
        L_0x0332:
            if (r10 != 0) goto L_0x034e
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r10 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r12 = 0
            r10.<init>(r12, r14, r4)     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r35 = r13
            goto L_0x03dc
        L_0x033e:
            r0 = move-exception
            r1 = r0
            r49 = r9
            r39 = r11
            goto L_0x0e46
        L_0x0346:
            r0 = move-exception
            r1 = r0
            r49 = r9
            r39 = r11
            goto L_0x0e67
        L_0x034e:
            r10 = r33
            r12 = 0
            switch(r1) {
                case 0: goto L_0x038e;
                case 1: goto L_0x037d;
                case 2: goto L_0x036c;
                case 3: goto L_0x035b;
                default: goto L_0x0354;
            }
        L_0x0354:
            r35 = r10
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            goto L_0x039f
        L_0x035b:
            java.lang.Float[] r35 = SCALED_RATIO_T     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r35 = r35[r2]     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r36 = r12
            r39 = r35
            r35 = r10
            goto L_0x03c8
        L_0x036c:
            java.lang.Float[] r35 = SCALED_RATIO_H     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r35 = r35[r2]     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r36 = r12
            r39 = r35
            r35 = r10
            goto L_0x03c8
        L_0x037d:
            java.lang.Float[] r35 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r35 = r35[r2]     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r36 = r12
            r39 = r35
            r35 = r10
            goto L_0x03c8
        L_0x038e:
            java.lang.Float[] r35 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r35 = r35[r2]     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            float r35 = r35.floatValue()     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            r36 = r12
            r39 = r35
            r35 = r10
            goto L_0x03c8
        L_0x039f:
            r36 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            boolean r10 = r10.containsKey(r12)     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            if (r10 == 0) goto L_0x03c6
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            java.lang.Object r10 = r10.get(r12)     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            java.lang.Float[] r10 = (java.lang.Float[]) r10     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            if (r10 == 0) goto L_0x03c3
            r12 = 0
            r39 = r10[r2]     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            float r39 = r39.floatValue()     // Catch:{ Error -> 0x0346, Exception -> 0x033e }
            goto L_0x03c8
        L_0x03c3:
            r39 = 1065353216(0x3f800000, float:1.0)
            goto L_0x03c8
        L_0x03c6:
            r39 = 1065353216(0x3f800000, float:1.0)
        L_0x03c8:
            r10 = r39
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            r35 = r13
            float r13 = r14 * r10
            r36 = r14
            float r14 = r4 * r10
            r39 = r4
            r4 = 1
            r12.<init>(r4, r13, r14)     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            r10 = r12
        L_0x03dc:
            r4 = r10
            r10 = 0
            boolean r12 = r4.isScaledRequired()     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            if (r12 != 0) goto L_0x03ef
            r34 = r4
            r8 = r9
            r49 = r8
            r36 = r10
            r39 = r11
            goto L_0x08ea
        L_0x03ef:
            float r12 = r4.getScaledWidth()     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            float r13 = r4.getScaledHeight()     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            r14 = r9
            r33 = 0
            r34 = r4
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x08fe, Exception -> 0x08f6 }
            r36 = r10
            r10 = 23
            r39 = r11
            java.lang.String r11 = "getChildren"
            if (r4 > r10) goto L_0x05cf
            boolean r4 = r9 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x05c9, Exception -> 0x05c3 }
            if (r4 == 0) goto L_0x05cf
            r4 = r9
            r5 = 0
            android.graphics.drawable.LevelListDrawable r6 = new android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x05c9, Exception -> 0x05c3 }
            r6.<init>()     // Catch:{ Error -> 0x05c9, Exception -> 0x05c3 }
            r7 = r4
            r8 = 0
            android.graphics.drawable.Drawable$ConstantState r10 = r7.getConstantState()     // Catch:{ Error -> 0x05c9, Exception -> 0x05c3 }
            if (r10 == 0) goto L_0x05ae
            r15 = 0
            kotlin.Result$Companion r17 = kotlin.Result.Companion     // Catch:{ all -> 0x058f }
            r17 = r7
            r18 = 0
            r19 = r3
            java.lang.Class r3 = r10.getClass()     // Catch:{ all -> 0x0580 }
            r20 = r4
            r27 = r5
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0575 }
            java.lang.reflect.Method r3 = r3.getMethod(r11, r5)     // Catch:{ all -> 0x0575 }
            r5 = 1
            r3.setAccessible(r5)     // Catch:{ all -> 0x0575 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0575 }
            java.lang.Object r4 = r3.invoke(r10, r5)     // Catch:{ all -> 0x0575 }
            boolean r5 = r4 instanceof java.lang.Object[]     // Catch:{ all -> 0x0575 }
            if (r5 == 0) goto L_0x0450
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ all -> 0x0444 }
            goto L_0x0451
        L_0x0444:
            r0 = move-exception
            r3 = r0
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            goto L_0x059f
        L_0x0450:
            r4 = 0
        L_0x0451:
            if (r4 == 0) goto L_0x0563
            r5 = 0
            r11 = 0
            r31 = r3
            int r3 = r4.length     // Catch:{ all -> 0x0575 }
            r16 = r5
            r5 = 0
        L_0x045b:
            if (r5 >= r3) goto L_0x0556
            r26 = r4[r5]     // Catch:{ all -> 0x0575 }
            int r40 = r11 + 1
            r41 = r26
            r42 = 0
            r43 = r3
            r3 = r41
            r41 = r4
            boolean r4 = r3 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0575 }
            if (r4 == 0) goto L_0x0539
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0575 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0575 }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ all -> 0x0575 }
            int r4 = r4.densityDpi     // Catch:{ all -> 0x0575 }
            r44 = 160(0xa0, float:2.24E-43)
            int r45 = r4 / r44
            r46 = r45
            r45 = r3
            android.graphics.drawable.BitmapDrawable r45 = (android.graphics.drawable.BitmapDrawable) r45     // Catch:{ all -> 0x0575 }
            r47 = r3
            android.graphics.Bitmap r3 = r45.getBitmap()     // Catch:{ all -> 0x0575 }
            r45 = r4
            r4 = r46
            r46 = r7
            float r7 = (float) r4
            float r7 = r7 * r12
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x052f }
            r48 = 0
            switch(r65) {
                case 0: goto L_0x04c8;
                case 1: goto L_0x04bc;
                case 2: goto L_0x04a7;
                default: goto L_0x049e;
            }
        L_0x049e:
            r50 = r8
            r49 = r9
            int r8 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x0529 }
            goto L_0x04da
        L_0x04a7:
            int r49 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x04b2 }
            r50 = r8
            r8 = r49
            r49 = r9
            goto L_0x04da
        L_0x04b2:
            r0 = move-exception
            r3 = r0
            r50 = r8
            r49 = r9
            r48 = r10
            goto L_0x059f
        L_0x04bc:
            r50 = r8
            r49 = r9
            double r8 = (double) r7
            double r8 = java.lang.Math.floor(r8)     // Catch:{ all -> 0x04d4 }
            float r8 = (float) r8     // Catch:{ all -> 0x04d4 }
            int r8 = (int) r8     // Catch:{ all -> 0x04d4 }
            goto L_0x04da
        L_0x04c8:
            r50 = r8
            r49 = r9
            double r8 = (double) r7     // Catch:{ all -> 0x04d4 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x04d4 }
            float r8 = (float) r8
            int r8 = (int) r8
            goto L_0x04da
        L_0x04d4:
            r0 = move-exception
            r3 = r0
            r48 = r10
            goto L_0x059f
        L_0x04da:
            float r7 = (float) r4
            float r7 = r7 * r13
            float r7 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r7)     // Catch:{ all -> 0x0529 }
            r9 = 0
            switch(r65) {
                case 0: goto L_0x0505;
                case 1: goto L_0x04f9;
                case 2: goto L_0x04ee;
                default: goto L_0x04e5;
            }
        L_0x04e5:
            r51 = r9
            r48 = r10
            int r9 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x0572 }
            goto L_0x0510
        L_0x04ee:
            int r48 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ all -> 0x04d4 }
            r51 = r9
            r9 = r48
            r48 = r10
            goto L_0x0510
        L_0x04f9:
            r51 = r9
            r48 = r10
            double r9 = (double) r7
            double r9 = java.lang.Math.floor(r9)     // Catch:{ all -> 0x0572 }
            float r9 = (float) r9     // Catch:{ all -> 0x0572 }
            int r9 = (int) r9     // Catch:{ all -> 0x0572 }
            goto L_0x0510
        L_0x0505:
            r51 = r9
            r48 = r10
            double r9 = (double) r7     // Catch:{ all -> 0x0572 }
            double r9 = java.lang.Math.ceil(r9)     // Catch:{ all -> 0x0572 }
            float r9 = (float) r9     // Catch:{ all -> 0x0572 }
            int r9 = (int) r9     // Catch:{ all -> 0x0572 }
        L_0x0510:
            r7 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r8, r9, r7)     // Catch:{ all -> 0x0572 }
            java.lang.String r7 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)     // Catch:{ all -> 0x0572 }
            android.graphics.drawable.BitmapDrawable r7 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0572 }
            r7.<init>(r3)     // Catch:{ all -> 0x0572 }
            r8 = r7
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ all -> 0x0572 }
            r6.addLevel(r11, r11, r8)     // Catch:{ all -> 0x0572 }
            goto L_0x0543
        L_0x0529:
            r0 = move-exception
            r48 = r10
            r3 = r0
            goto L_0x059f
        L_0x052f:
            r0 = move-exception
            r50 = r8
            r49 = r9
            r48 = r10
            r3 = r0
            goto L_0x059f
        L_0x0539:
            r47 = r3
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
        L_0x0543:
            int r5 = r5 + 1
            r11 = r40
            r4 = r41
            r3 = r43
            r7 = r46
            r10 = r48
            r9 = r49
            r8 = r50
            goto L_0x045b
        L_0x0556:
            r41 = r4
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0572 }
            goto L_0x056e
        L_0x0563:
            r31 = r3
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            r8 = 0
        L_0x056e:
            kotlin.Result.m8971constructorimpl(r8)     // Catch:{ all -> 0x0572 }
            goto L_0x05a8
        L_0x0572:
            r0 = move-exception
            r3 = r0
            goto L_0x059f
        L_0x0575:
            r0 = move-exception
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            r3 = r0
            goto L_0x059f
        L_0x0580:
            r0 = move-exception
            r20 = r4
            r27 = r5
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            r3 = r0
            goto L_0x059f
        L_0x058f:
            r0 = move-exception
            r19 = r3
            r20 = r4
            r27 = r5
            r46 = r7
            r50 = r8
            r49 = r9
            r48 = r10
            r3 = r0
        L_0x059f:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            kotlin.Result.m8971constructorimpl(r3)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x05a8:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x05ba
        L_0x05ae:
            r19 = r3
            r20 = r4
            r27 = r5
            r46 = r7
            r50 = r8
            r49 = r9
        L_0x05ba:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r8 = r6
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0e13
        L_0x05c3:
            r0 = move-exception
            r1 = r0
            r49 = r9
            goto L_0x0e46
        L_0x05c9:
            r0 = move-exception
            r1 = r0
            r49 = r9
            goto L_0x0e67
        L_0x05cf:
            r49 = r9
            r3 = r14
            r4 = 0
            android.graphics.drawable.Drawable$ConstantState r9 = r3.getConstantState()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            if (r9 == 0) goto L_0x08de
            r10 = 0
            r40 = r3
            java.lang.Class r3 = r9.getClass()     // Catch:{ Exception -> 0x08bc, Error -> 0x08f2 }
            r41 = r4
            r42 = r10
            r4 = 0
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            java.lang.reflect.Method r3 = r3.getMethod(r11, r10)     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            r10 = 1
            r3.setAccessible(r10)     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            java.lang.Object r4 = r3.invoke(r9, r10)     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            boolean r10 = r4 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            if (r10 == 0) goto L_0x0609
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ Exception -> 0x05ff, Error -> 0x08f2 }
            r16 = r4
            goto L_0x060b
        L_0x05ff:
            r0 = move-exception
            r3 = r0
            r44 = r9
            r47 = r12
            r48 = r13
            goto L_0x08c8
        L_0x0609:
            r16 = 0
        L_0x060b:
            if (r16 == 0) goto L_0x08aa
            r4 = r16
            r10 = 0
            int r11 = r4.length     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            r43 = r3
            r3 = 0
        L_0x0614:
            if (r3 >= r11) goto L_0x089a
            r16 = r4[r3]     // Catch:{ Exception -> 0x08b3, Error -> 0x08f2 }
            r44 = r16
            r45 = 0
            r46 = r4
            r4 = r44
            r44 = r9
            boolean r9 = r4 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x0893, Error -> 0x08f2 }
            if (r9 == 0) goto L_0x06cf
            r9 = r4
            android.graphics.drawable.BitmapDrawable r9 = (android.graphics.drawable.BitmapDrawable) r9     // Catch:{ Exception -> 0x0893, Error -> 0x08f2 }
            android.graphics.Bitmap r9 = r9.getBitmap()     // Catch:{ Exception -> 0x0893, Error -> 0x08f2 }
            r47 = r12
            r48 = 0
            switch(r65) {
                case 0: goto L_0x0669;
                case 1: goto L_0x0659;
                case 2: goto L_0x0642;
                default: goto L_0x0635;
            }
        L_0x0635:
            r50 = r10
            r51 = r11
            r10 = r47
            r47 = r12
            int r11 = kotlin.math.MathKt.roundToInt((float) r10)     // Catch:{ Exception -> 0x06c9, Error -> 0x08f2 }
            goto L_0x067f
        L_0x0642:
            int r50 = kotlin.math.MathKt.roundToInt((float) r47)     // Catch:{ Exception -> 0x0651, Error -> 0x08f2 }
            r51 = r11
            r11 = r50
            r50 = r10
            r10 = r47
            r47 = r12
            goto L_0x067f
        L_0x0651:
            r0 = move-exception
            r3 = r0
            r47 = r12
            r48 = r13
            goto L_0x08c8
        L_0x0659:
            r50 = r10
            r51 = r11
            r10 = r47
            r47 = r12
            double r11 = (double) r10
            double r11 = java.lang.Math.floor(r11)     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            float r11 = (float) r11     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            goto L_0x067f
        L_0x0669:
            r50 = r10
            r51 = r11
            r10 = r47
            r47 = r12
            double r11 = (double) r10     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            float r11 = (float) r11
            int r11 = (int) r11
            goto L_0x067f
        L_0x0679:
            r0 = move-exception
            r3 = r0
            r48 = r13
            goto L_0x08c8
        L_0x067f:
            r10 = r13
            r12 = 0
            switch(r65) {
                case 0: goto L_0x06a5;
                case 1: goto L_0x0699;
                case 2: goto L_0x068e;
                default: goto L_0x0685;
            }
        L_0x0685:
            r52 = r12
            r48 = r13
            int r12 = kotlin.math.MathKt.roundToInt((float) r10)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            goto L_0x06b0
        L_0x068e:
            int r48 = kotlin.math.MathKt.roundToInt((float) r10)     // Catch:{ Exception -> 0x0679, Error -> 0x08f2 }
            r52 = r12
            r12 = r48
            r48 = r13
            goto L_0x06b0
        L_0x0699:
            r52 = r12
            r48 = r13
            double r12 = (double) r10
            double r12 = java.lang.Math.floor(r12)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            float r12 = (float) r12     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            int r12 = (int) r12     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            goto L_0x06b0
        L_0x06a5:
            r52 = r12
            r48 = r13
            double r12 = (double) r10     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            float r12 = (float) r12     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            int r12 = (int) r12     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
        L_0x06b0:
            r10 = 1
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createScaledBitmap(r9, r11, r12, r10)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r11 = 0
            java.lang.String r12 = "setBitmap"
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r10 = 0
            r13[r10] = r9     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r4, r12, r13)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r52 = r4
            goto L_0x0882
        L_0x06c9:
            r0 = move-exception
            r48 = r13
            r3 = r0
            goto L_0x08c8
        L_0x06cf:
            r50 = r10
            r51 = r11
            r47 = r12
            r48 = r13
            boolean r9 = r4 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            if (r9 == 0) goto L_0x0880
            com.baidu.searchbox.config.FontSizeHelper r9 = INSTANCE     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r10 = r4
            android.graphics.drawable.GradientDrawable r10 = (android.graphics.drawable.GradientDrawable) r10     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r11 = 0
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0850, Error -> 0x08f2 }
            r13 = 24
            if (r12 < r13) goto L_0x06f9
            float r12 = r10.getCornerRadius()     // Catch:{ Exception -> 0x06f1, Error -> 0x08f2 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ Exception -> 0x06f1, Error -> 0x08f2 }
            goto L_0x0701
        L_0x06f1:
            r0 = move-exception
            r52 = r4
            r58 = r11
            r4 = r0
            goto L_0x0856
        L_0x06f9:
            android.graphics.drawable.Drawable$ConstantState r12 = r10.getConstantState()     // Catch:{ Exception -> 0x0850, Error -> 0x08f2 }
            java.lang.Object r12 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r12, r8)     // Catch:{ Exception -> 0x0850, Error -> 0x08f2 }
        L_0x0701:
            r13 = r9
            r52 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r53 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0850, Error -> 0x08f2 }
            boolean r53 = r53.isDebug()     // Catch:{ Exception -> 0x0850, Error -> 0x08f2 }
            if (r53 == 0) goto L_0x073e
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0736, Error -> 0x08f2 }
            r13.<init>()     // Catch:{ Exception -> 0x0736, Error -> 0x08f2 }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ Exception -> 0x0736, Error -> 0x08f2 }
            r52 = r4
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            java.lang.StringBuilder r4 = r13.append(r4)     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            java.lang.StringBuilder r4 = r4.append(r12)     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            android.util.Log.d(r6, r4)     // Catch:{ Exception -> 0x0730, Error -> 0x08f2 }
            goto L_0x0740
        L_0x0730:
            r0 = move-exception
            r4 = r0
            r58 = r11
            goto L_0x0856
        L_0x0736:
            r0 = move-exception
            r52 = r4
            r4 = r0
            r58 = r11
            goto L_0x0856
        L_0x073e:
            r52 = r4
        L_0x0740:
            boolean r4 = r12 instanceof java.lang.Float     // Catch:{ Exception -> 0x084b, Error -> 0x08f2 }
            if (r4 == 0) goto L_0x0846
            r4 = r12
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x084b, Error -> 0x08f2 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x084b, Error -> 0x08f2 }
            r13 = 0
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0846
            r4 = r12
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x084b, Error -> 0x08f2 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x084b, Error -> 0x08f2 }
            r13 = r9
            r53 = 0
            r54 = r13
            r55 = 0
            r56 = r54
            r57 = 0
            r58 = r11
            r11 = 1
            if (r2 != r11) goto L_0x076c
            r59 = r12
            r11 = 0
            goto L_0x07a4
        L_0x076c:
            if (r1 != 0) goto L_0x0774
            if (r2 != 0) goto L_0x0774
            r59 = r12
            r11 = 0
            goto L_0x07a4
        L_0x0774:
            r11 = 0
            if (r2 < 0) goto L_0x077e
            r59 = r11
            r11 = 5
            if (r2 >= r11) goto L_0x0780
            r11 = 1
            goto L_0x0781
        L_0x077e:
            r59 = r11
        L_0x0780:
            r11 = 0
        L_0x0781:
            if (r11 != 0) goto L_0x0787
            r59 = r12
            r11 = 0
            goto L_0x07a4
        L_0x0787:
            r11 = -1
            if (r1 <= r11) goto L_0x0791
            r11 = 4
            if (r1 < r11) goto L_0x078e
            goto L_0x0791
        L_0x078e:
            r59 = r12
            goto L_0x07a3
        L_0x0791:
            java.util.HashMap r11 = mCustomerRatios     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r59 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            boolean r11 = r11.containsKey(r12)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            if (r11 != 0) goto L_0x07a3
            r11 = 0
            goto L_0x07a4
        L_0x07a3:
            r11 = 1
        L_0x07a4:
            if (r11 != 0) goto L_0x07b8
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r56 = r13
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r11.<init>(r13, r12, r4)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r57 = r4
            goto L_0x0831
        L_0x07b4:
            r0 = move-exception
            r4 = r0
            goto L_0x0856
        L_0x07b8:
            r56 = r13
            r11 = r54
            r12 = 0
            switch(r1) {
                case 0: goto L_0x07ec;
                case 1: goto L_0x07df;
                case 2: goto L_0x07d2;
                case 3: goto L_0x07c5;
                default: goto L_0x07c0;
            }     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
        L_0x07c0:
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            goto L_0x07f9
        L_0x07c5:
            java.lang.Float[] r13 = SCALED_RATIO_T     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r57 = r11
            goto L_0x0824
        L_0x07d2:
            java.lang.Float[] r13 = SCALED_RATIO_H     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r57 = r11
            goto L_0x0824
        L_0x07df:
            java.lang.Float[] r13 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r57 = r11
            goto L_0x0824
        L_0x07ec:
            java.lang.Float[] r13 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r57 = r11
            goto L_0x0824
        L_0x07f9:
            r57 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            boolean r11 = r13.containsKey(r11)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            if (r11 == 0) goto L_0x0822
            java.util.HashMap r11 = mCustomerRatios     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            java.lang.Object r11 = r11.get(r13)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            java.lang.Float[] r11 = (java.lang.Float[]) r11     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            if (r11 == 0) goto L_0x081f
            r13 = 0
            r60 = r11[r2]     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r60 = r60.floatValue()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r13 = r60
            goto L_0x0824
        L_0x081f:
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0824
        L_0x0822:
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x0824:
            r11 = r13
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            float r13 = r4 * r11
            r57 = r4
            r4 = 1
            r12.<init>(r4, r11, r13)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            r11 = r12
        L_0x0831:
            r4 = r11
            r11 = 0
            boolean r12 = r4.isScaledRequired()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            if (r12 != 0) goto L_0x083c
            r12 = r57
            goto L_0x0840
        L_0x083c:
            float r12 = r4.getScaledSize()     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
        L_0x0840:
            r10.setCornerRadius(r12)     // Catch:{ Exception -> 0x07b4, Error -> 0x08f2 }
            goto L_0x087f
        L_0x0846:
            r58 = r11
            r59 = r12
            goto L_0x087f
        L_0x084b:
            r0 = move-exception
            r58 = r11
            r4 = r0
            goto L_0x0856
        L_0x0850:
            r0 = move-exception
            r52 = r4
            r58 = r11
            r4 = r0
        L_0x0856:
            r11 = r9
            r12 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r13 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            boolean r13 = r13.isDebug()     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            if (r13 == 0) goto L_0x087f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r11.<init>()     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            java.lang.StringBuilder r11 = r11.append(r15)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            java.lang.StringBuilder r11 = r11.append(r7)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            android.util.Log.d(r6, r11)     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            r4.printStackTrace()     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
        L_0x087f:
            goto L_0x0882
        L_0x0880:
            r52 = r4
        L_0x0882:
            int r3 = r3 + 1
            r9 = r44
            r4 = r46
            r12 = r47
            r13 = r48
            r10 = r50
            r11 = r51
            goto L_0x0614
        L_0x0893:
            r0 = move-exception
            r47 = r12
            r48 = r13
            r3 = r0
            goto L_0x08c8
        L_0x089a:
            r46 = r4
            r44 = r9
            r50 = r10
            r47 = r12
            r48 = r13
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x08a7, Error -> 0x08f2 }
            goto L_0x08b2
        L_0x08a7:
            r0 = move-exception
            r3 = r0
            goto L_0x08c8
        L_0x08aa:
            r43 = r3
            r44 = r9
            r47 = r12
            r48 = r13
        L_0x08b2:
            goto L_0x08d8
        L_0x08b3:
            r0 = move-exception
            r44 = r9
            r47 = r12
            r48 = r13
            r3 = r0
            goto L_0x08c8
        L_0x08bc:
            r0 = move-exception
            r41 = r4
            r44 = r9
            r42 = r10
            r47 = r12
            r48 = r13
            r3 = r0
        L_0x08c8:
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r5 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r6 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            boolean r6 = r6.isDebug()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            if (r6 == 0) goto L_0x08d8
            r3.printStackTrace()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x08d8:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x08e6
        L_0x08de:
            r40 = r3
            r41 = r4
            r47 = r12
            r48 = r13
        L_0x08e6:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r8 = r14
        L_0x08ea:
            goto L_0x093f
        L_0x08ee:
            r0 = move-exception
            r1 = r0
            goto L_0x0e46
        L_0x08f2:
            r0 = move-exception
            r1 = r0
            goto L_0x0e67
        L_0x08f6:
            r0 = move-exception
            r39 = r11
            r1 = r0
            r49 = r9
            goto L_0x0e46
        L_0x08fe:
            r0 = move-exception
            r39 = r11
            r1 = r0
            r49 = r9
            goto L_0x0e67
        L_0x0906:
            r0 = move-exception
            r39 = r11
            r38 = r12
            r1 = r0
            r49 = r9
            goto L_0x0e46
        L_0x0910:
            r0 = move-exception
            r39 = r11
            r38 = r12
            r1 = r0
            r49 = r9
            goto L_0x0e67
        L_0x091a:
            r0 = move-exception
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
            r49 = r9
            goto L_0x0e2a
        L_0x0926:
            r0 = move-exception
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
            r49 = r9
            goto L_0x0e35
        L_0x0932:
            r32 = r4
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r35 = r13
            r8 = 0
        L_0x093f:
            goto L_0x0e13
        L_0x0942:
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r35 = r13
            r4 = r49
            boolean r9 = r4 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            if (r9 == 0) goto L_0x0afa
            r9 = r4
            android.graphics.drawable.GradientDrawable r9 = (android.graphics.drawable.GradientDrawable) r9     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r10 = 0
            r11 = r4
            android.graphics.drawable.GradientDrawable r11 = (android.graphics.drawable.GradientDrawable) r11     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r12 = 0
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            r14 = 24
            if (r13 < r14) goto L_0x0972
            float r8 = r11.getCornerRadius()     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            goto L_0x097a
        L_0x096a:
            r0 = move-exception
            r5 = r0
            r17 = r9
            r18 = r10
            goto L_0x0abc
        L_0x0972:
            android.graphics.drawable.Drawable$ConstantState r13 = r11.getConstantState()     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            java.lang.Object r8 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r13, r8)     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
        L_0x097a:
            r13 = r3
            r14 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r16 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            boolean r16 = r16.isDebug()     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            if (r16 == 0) goto L_0x09a5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            r13.<init>()     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.StringBuilder r5 = r13.append(r5)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
            android.util.Log.d(r6, r5)     // Catch:{ Exception -> 0x096a, Error -> 0x0af4 }
        L_0x09a5:
            boolean r5 = r8 instanceof java.lang.Float     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            if (r5 == 0) goto L_0x0aaf
            r5 = r8
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            r13 = 0
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0aaf
            r5 = r8
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            r13 = r3
            r14 = 0
            r16 = r13
            r20 = 0
            r21 = r16
            r22 = 0
            r23 = r8
            r8 = 1
            if (r2 != r8) goto L_0x09d0
            r17 = r9
            r8 = 0
            goto L_0x0a08
        L_0x09d0:
            if (r1 != 0) goto L_0x09d8
            if (r2 != 0) goto L_0x09d8
            r17 = r9
            r8 = 0
            goto L_0x0a08
        L_0x09d8:
            r8 = 0
            if (r2 < 0) goto L_0x09e2
            r24 = r8
            r8 = 5
            if (r2 >= r8) goto L_0x09e4
            r8 = 1
            goto L_0x09e5
        L_0x09e2:
            r24 = r8
        L_0x09e4:
            r8 = 0
        L_0x09e5:
            if (r8 != 0) goto L_0x09eb
            r17 = r9
            r8 = 0
            goto L_0x0a08
        L_0x09eb:
            r8 = -1
            if (r1 <= r8) goto L_0x09f5
            r8 = 4
            if (r1 < r8) goto L_0x09f2
            goto L_0x09f5
        L_0x09f2:
            r17 = r9
            goto L_0x0a07
        L_0x09f5:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0ab6, Error -> 0x0af4 }
            r17 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a18, Error -> 0x0af4 }
            boolean r8 = r8.containsKey(r9)     // Catch:{ Exception -> 0x0a18, Error -> 0x0af4 }
            if (r8 != 0) goto L_0x0a07
            r8 = 0
            goto L_0x0a08
        L_0x0a07:
            r8 = 1
        L_0x0a08:
            if (r8 != 0) goto L_0x0a1e
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a18, Error -> 0x0af4 }
            r18 = r10
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r8.<init>(r10, r9, r5)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r21 = r5
            goto L_0x0a9a
        L_0x0a18:
            r0 = move-exception
            r18 = r10
            r5 = r0
            goto L_0x0abc
        L_0x0a1e:
            r18 = r10
            r8 = r16
            r9 = 0
            switch(r1) {
                case 0: goto L_0x0a52;
                case 1: goto L_0x0a45;
                case 2: goto L_0x0a38;
                case 3: goto L_0x0a2b;
                default: goto L_0x0a26;
            }     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
        L_0x0a26:
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            goto L_0x0a62
        L_0x0a2b:
            java.lang.Float[] r10 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r21 = r8
            goto L_0x0a8d
        L_0x0a38:
            java.lang.Float[] r10 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r21 = r8
            goto L_0x0a8d
        L_0x0a45:
            java.lang.Float[] r10 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r21 = r8
            goto L_0x0a8d
        L_0x0a52:
            java.lang.Float[] r10 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r10 = r10[r2]     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r21 = r8
            goto L_0x0a8d
        L_0x0a5f:
            r0 = move-exception
            r5 = r0
            goto L_0x0abc
        L_0x0a62:
            r21 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            boolean r8 = r10.containsKey(r8)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            if (r8 == 0) goto L_0x0a8b
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            java.lang.Object r8 = r8.get(r10)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            java.lang.Float[] r8 = (java.lang.Float[]) r8     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            if (r8 == 0) goto L_0x0a88
            r10 = 0
            r19 = r8[r2]     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r10 = r19
            goto L_0x0a8d
        L_0x0a88:
            r10 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0a8d
        L_0x0a8b:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0a8d:
            r8 = r10
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r9 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            float r10 = r5 * r8
            r21 = r5
            r5 = 1
            r9.<init>(r5, r8, r10)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            r8 = r9
        L_0x0a9a:
            r5 = r8
            r8 = 0
            boolean r9 = r5.isScaledRequired()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            if (r9 != 0) goto L_0x0aa5
            r9 = r21
            goto L_0x0aa9
        L_0x0aa5:
            float r9 = r5.getScaledSize()     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
        L_0x0aa9:
            r11.setCornerRadius(r9)     // Catch:{ Exception -> 0x0a5f, Error -> 0x0af4 }
            goto L_0x0ae5
        L_0x0aaf:
            r23 = r8
            r17 = r9
            r18 = r10
            goto L_0x0ae5
        L_0x0ab6:
            r0 = move-exception
            r17 = r9
            r18 = r10
            r5 = r0
        L_0x0abc:
            r8 = r3
            r9 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r10 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            boolean r10 = r10.isDebug()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            if (r10 == 0) goto L_0x0ae5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r8.<init>()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.StringBuilder r8 = r8.append(r15)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.String r7 = r7.toString()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            android.util.Log.d(r6, r7)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r5.printStackTrace()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
        L_0x0ae5:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r8 = r4
            r49 = r8
            goto L_0x0e13
        L_0x0aee:
            r0 = move-exception
            r1 = r0
            r49 = r4
            goto L_0x0e46
        L_0x0af4:
            r0 = move-exception
            r1 = r0
            r49 = r4
            goto L_0x0e67
        L_0x0afa:
            boolean r5 = r4 instanceof android.graphics.drawable.NinePatchDrawable     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            if (r5 == 0) goto L_0x0c84
            r5 = r4
            android.graphics.drawable.NinePatchDrawable r5 = (android.graphics.drawable.NinePatchDrawable) r5     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r7 = r3
            r8 = 0
            if (r5 == 0) goto L_0x0c77
            r9 = r5
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = r3
            r13 = 0
            r14 = r12
            r15 = 0
            r16 = r14
            r20 = 0
            r21 = r5
            r5 = 1
            if (r2 != r5) goto L_0x0b1b
            r17 = r7
            r5 = 0
            goto L_0x0b53
        L_0x0b1b:
            if (r1 != 0) goto L_0x0b23
            if (r2 != 0) goto L_0x0b23
            r17 = r7
            r5 = 0
            goto L_0x0b53
        L_0x0b23:
            r5 = 0
            if (r2 < 0) goto L_0x0b2d
            r22 = r5
            r5 = 5
            if (r2 >= r5) goto L_0x0b2f
            r5 = 1
            goto L_0x0b30
        L_0x0b2d:
            r22 = r5
        L_0x0b2f:
            r5 = 0
        L_0x0b30:
            if (r5 != 0) goto L_0x0b36
            r17 = r7
            r5 = 0
            goto L_0x0b53
        L_0x0b36:
            r5 = -1
            if (r1 <= r5) goto L_0x0b40
            r5 = 4
            if (r1 < r5) goto L_0x0b3d
            goto L_0x0b40
        L_0x0b3d:
            r17 = r7
            goto L_0x0b52
        L_0x0b40:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Exception -> 0x0c59, Error -> 0x0af4 }
            r17 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c52, Error -> 0x0af4 }
            boolean r5 = r5.containsKey(r7)     // Catch:{ Exception -> 0x0c52, Error -> 0x0af4 }
            if (r5 != 0) goto L_0x0b52
            r5 = 0
            goto L_0x0b53
        L_0x0b52:
            r5 = 1
        L_0x0b53:
            if (r5 != 0) goto L_0x0b6b
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b63, Error -> 0x0af4 }
            r18 = r8
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r5.<init>(r8, r7, r11)     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r16 = r10
            goto L_0x0beb
        L_0x0b63:
            r0 = move-exception
            r18 = r8
            r3 = r0
            r16 = r10
            goto L_0x0c61
        L_0x0b6b:
            r18 = r8
            r7 = 1065353216(0x3f800000, float:1.0)
            r5 = r14
            r8 = 0
            switch(r1) {
                case 0: goto L_0x0ba0;
                case 1: goto L_0x0b93;
                case 2: goto L_0x0b86;
                case 3: goto L_0x0b79;
                default: goto L_0x0b74;
            }
        L_0x0b74:
            java.util.HashMap r7 = mCustomerRatios     // Catch:{ Exception -> 0x0c4d, Error -> 0x0af4 }
            goto L_0x0bb3
        L_0x0b79:
            java.lang.Float[] r7 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r7 = r7[r2]     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            float r7 = r7.floatValue()     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r16 = r5
            goto L_0x0bde
        L_0x0b86:
            java.lang.Float[] r7 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r7 = r7[r2]     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            float r7 = r7.floatValue()     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r16 = r5
            goto L_0x0bde
        L_0x0b93:
            java.lang.Float[] r7 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r7 = r7[r2]     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            float r7 = r7.floatValue()     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r16 = r5
            goto L_0x0bde
        L_0x0ba0:
            java.lang.Float[] r7 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r7 = r7[r2]     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            float r7 = r7.floatValue()     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r16 = r5
            goto L_0x0bde
        L_0x0bad:
            r0 = move-exception
            r3 = r0
            r16 = r10
            goto L_0x0c61
        L_0x0bb3:
            r16 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0c4d, Error -> 0x0af4 }
            boolean r5 = r7.containsKey(r5)     // Catch:{ Exception -> 0x0c4d, Error -> 0x0af4 }
            if (r5 == 0) goto L_0x0bdc
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            java.lang.Object r5 = r5.get(r7)     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            java.lang.Float[] r5 = (java.lang.Float[]) r5     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            if (r5 == 0) goto L_0x0bd9
            r7 = 0
            r19 = r5[r2]     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x0bad, Error -> 0x0af4 }
            r7 = r19
            goto L_0x0bde
        L_0x0bd9:
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0bde
        L_0x0bdc:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x0bde:
            r5 = r7
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r7 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0c4d, Error -> 0x0af4 }
            float r8 = r11 * r5
            r16 = r10
            r10 = 1
            r7.<init>(r10, r5, r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            r5 = r7
        L_0x0beb:
            r7 = 0
            boolean r8 = r5.isScaledRequired()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            if (r8 != 0) goto L_0x0bf5
            r8 = r11
            goto L_0x0bf9
        L_0x0bf5:
            float r8 = r5.getScaledSize()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
        L_0x0bf9:
            r5 = r8
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            int r7 = r7.densityDpi     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            float r8 = (float) r7     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            float r8 = r8 * r5
            int r8 = (int) r8     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            r9.setTargetDensity(r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            r8 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r10 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            boolean r10 = r10.isDebug()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            if (r10 == 0) goto L_0x0c71
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            r3.<init>()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.String r8 = "scaled: "
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.String r8 = ", displayMetrics: "
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.String r8 = ", result: "
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            float r8 = (float) r7     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            float r8 = r8 * r5
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            android.util.Log.d(r6, r3)     // Catch:{ Exception -> 0x0c4a, Error -> 0x0af4 }
            goto L_0x0c71
        L_0x0c4a:
            r0 = move-exception
            r3 = r0
            goto L_0x0c61
        L_0x0c4d:
            r0 = move-exception
            r16 = r10
            r3 = r0
            goto L_0x0c61
        L_0x0c52:
            r0 = move-exception
            r18 = r8
            r16 = r10
            r3 = r0
            goto L_0x0c61
        L_0x0c59:
            r0 = move-exception
            r17 = r7
            r18 = r8
            r16 = r10
            r3 = r0
        L_0x0c61:
            com.baidu.searchbox.config.FontSizeHelper r5 = INSTANCE     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r6 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r7 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            boolean r7 = r7.isDebug()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            if (r7 == 0) goto L_0x0c71
            r3.printStackTrace()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
        L_0x0c71:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r8 = r21
            goto L_0x0c7e
        L_0x0c77:
            r21 = r5
            r17 = r7
            r18 = r8
            r8 = 0
        L_0x0c7e:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r49 = r4
            goto L_0x0e13
        L_0x0c84:
            r5 = r3
            r6 = 0
            r7 = r5
            r8 = 0
            if (r4 == 0) goto L_0x0e0b
            r9 = r4
            r10 = 0
            int r11 = r4.getIntrinsicWidth()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r11 = (float) r11     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r11 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r11)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            int r12 = r4.getIntrinsicHeight()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r12 = (float) r12     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r13 = r3
            r14 = 0
            r15 = r13
            r16 = 0
            r20 = r5
            r5 = 1
            if (r2 != r5) goto L_0x0cad
            r17 = r6
            r5 = 0
            goto L_0x0ce5
        L_0x0cad:
            if (r1 != 0) goto L_0x0cb5
            if (r2 != 0) goto L_0x0cb5
            r17 = r6
            r5 = 0
            goto L_0x0ce5
        L_0x0cb5:
            r5 = 0
            if (r2 < 0) goto L_0x0cbf
            r21 = r5
            r5 = 5
            if (r2 >= r5) goto L_0x0cc1
            r5 = 1
            goto L_0x0cc2
        L_0x0cbf:
            r21 = r5
        L_0x0cc1:
            r5 = 0
        L_0x0cc2:
            if (r5 != 0) goto L_0x0cc8
            r17 = r6
            r5 = 0
            goto L_0x0ce5
        L_0x0cc8:
            r5 = -1
            if (r1 <= r5) goto L_0x0cd2
            r5 = 4
            if (r1 < r5) goto L_0x0ccf
            goto L_0x0cd2
        L_0x0ccf:
            r17 = r6
            goto L_0x0ce4
        L_0x0cd2:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r17 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            boolean r5 = r5.containsKey(r6)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            if (r5 != 0) goto L_0x0ce4
            r5 = 0
            goto L_0x0ce5
        L_0x0ce4:
            r5 = 1
        L_0x0ce5:
            if (r5 != 0) goto L_0x0cef
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r6 = 0
            r5.<init>(r6, r11, r12)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d5c
        L_0x0cef:
            r5 = r13
            r6 = 0
            switch(r1) {
                case 0: goto L_0x0d1a;
                case 1: goto L_0x0d0f;
                case 2: goto L_0x0d04;
                case 3: goto L_0x0cf9;
                default: goto L_0x0cf4;
            }
        L_0x0cf4:
            java.util.HashMap r15 = mCustomerRatios     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            goto L_0x0d25
        L_0x0cf9:
            java.lang.Float[] r15 = SCALED_RATIO_T     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r15 = r15[r2]     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d4e
        L_0x0d04:
            java.lang.Float[] r15 = SCALED_RATIO_H     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r15 = r15[r2]     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d4e
        L_0x0d0f:
            java.lang.Float[] r15 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r15 = r15[r2]     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d4e
        L_0x0d1a:
            java.lang.Float[] r15 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r15 = r15[r2]     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d4e
        L_0x0d25:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            boolean r1 = r15.containsKey(r1)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            if (r1 == 0) goto L_0x0d4c
            java.util.HashMap r1 = mCustomerRatios     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.Object r1 = r1.get(r15)     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            java.lang.Float[] r1 = (java.lang.Float[]) r1     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            if (r1 == 0) goto L_0x0d49
            r15 = 0
            r16 = r1[r2]     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            r15 = r16
            goto L_0x0d4e
        L_0x0d49:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0d4e
        L_0x0d4c:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x0d4e:
            r1 = r15
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r6 = r11 * r1
            float r15 = r12 * r1
            r16 = r1
            r1 = 1
            r5.<init>(r1, r6, r15)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
        L_0x0d5c:
            r1 = r5
            r5 = 0
            boolean r6 = r1.isScaledRequired()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            if (r6 != 0) goto L_0x0d6b
            r16 = r1
            r2 = r4
            r49 = r2
            goto L_0x0e07
        L_0x0d6b:
            float r6 = r1.getScaledWidth()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            float r11 = r1.getScaledHeight()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r12 = r4
            r13 = 0
            r14 = 0
            int r15 = r12.getIntrinsicWidth()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            int r16 = r12.getIntrinsicHeight()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r19 = r16
            r16 = r1
            int r1 = r12.getOpacity()     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r2 = -1
            if (r1 == r2) goto L_0x0d8d
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Error -> 0x0af4, Exception -> 0x0aee }
            goto L_0x0d8f
        L_0x0d8d:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
        L_0x0d8f:
            r18 = r3
            r2 = r19
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r15, r2, r1)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r19 = r1
            java.lang.String r1 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r1 = r3
            android.graphics.Canvas r3 = new android.graphics.Canvas     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r3.<init>(r1)     // Catch:{ Error -> 0x0e1b, Exception -> 0x0e16 }
            r49 = r4
            r4 = 0
            r12.setBounds(r4, r4, r15, r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r12.draw(r3)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r2 = r6
            r3 = 0
            switch(r65) {
                case 0: goto L_0x0dc6;
                case 1: goto L_0x0dbe;
                case 2: goto L_0x0db9;
                default: goto L_0x0db4;
            }     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x0db4:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dcd
        L_0x0db9:
            int r4 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dcd
        L_0x0dbe:
            double r14 = (double) r2     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            float r4 = (float) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            int r4 = (int) r4     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dcd
        L_0x0dc6:
            double r14 = (double) r2     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            float r4 = (float) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            int r4 = (int) r4     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x0dcd:
            r2 = r11
            r3 = 0
            switch(r65) {
                case 0: goto L_0x0de5;
                case 1: goto L_0x0ddd;
                case 2: goto L_0x0dd8;
                default: goto L_0x0dd3;
            }     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x0dd3:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dec
        L_0x0dd8:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dec
        L_0x0ddd:
            double r14 = (double) r2     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            float r14 = (float) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            int r14 = (int) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            goto L_0x0dec
        L_0x0de5:
            double r14 = (double) r2     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            float r14 = (float) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            int r14 = (int) r14     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x0dec:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r4, r14, r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            java.lang.String r2 = "createScaledBitmap(\n    …       true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            r2.<init>(r3, r1)     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Error -> 0x08f2, Exception -> 0x08ee }
        L_0x0e07:
            r8 = r2
            goto L_0x0e12
        L_0x0e0b:
            r49 = r4
            r20 = r5
            r17 = r6
            r8 = 0
        L_0x0e12:
        L_0x0e13:
            goto L_0x0e7a
        L_0x0e16:
            r0 = move-exception
            r49 = r4
            r1 = r0
            goto L_0x0e46
        L_0x0e1b:
            r0 = move-exception
            r49 = r4
            r1 = r0
            goto L_0x0e67
        L_0x0e20:
            r0 = move-exception
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
        L_0x0e2a:
            goto L_0x0e46
        L_0x0e2b:
            r0 = move-exception
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
        L_0x0e35:
            goto L_0x0e67
        L_0x0e36:
            r0 = move-exception
            r30 = r4
            r28 = r6
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
        L_0x0e46:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0e56
            r1.printStackTrace()
        L_0x0e56:
            goto L_0x0e78
        L_0x0e57:
            r0 = move-exception
            r30 = r4
            r28 = r6
            r29 = r7
            r49 = r9
            r37 = r10
            r39 = r11
            r38 = r12
            r1 = r0
        L_0x0e67:
            r2 = r39
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0e77
            r1.printStackTrace()
        L_0x0e77:
        L_0x0e78:
            r8 = r63
        L_0x0e7a:
            goto L_0x0e84
        L_0x0e7d:
            r30 = r4
            r28 = r6
            r29 = r7
            r8 = 0
        L_0x0e84:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledDrawableForTargetFontSize(int, android.graphics.drawable.Drawable, int, int):android.graphics.drawable.Drawable");
    }

    public static /* synthetic */ StateListDrawable setScaledStateListDrawable$default(int i2, List list, List list2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return setScaledStateListDrawable(i2, list, list2, i3);
    }

    @JvmStatic
    @PluginAccessible
    public static final StateListDrawable setScaledStateListDrawable(int type, List<? extends Drawable> drawableList, List<int[]> statesList, int numRoundPolicy) {
        Intrinsics.checkNotNullParameter(drawableList, "drawableList");
        Intrinsics.checkNotNullParameter(statesList, "statesList");
        StateListDrawable stateListDrawable = new StateListDrawable();
        StateListDrawable $this$setScaledStateListDrawable_u24lambda_u2d5 = stateListDrawable;
        int i2 = 0;
        int size = drawableList.size();
        while (i2 < size) {
            $this$setScaledStateListDrawable_u24lambda_u2d5.addState(i2 < statesList.size() ? statesList.get(i2) : new int[0], getScaledDrawable(type, (Drawable) drawableList.get(i2), numRoundPolicy));
            i2++;
        }
        return stateListDrawable;
    }

    @JvmStatic
    @PluginAccessible
    public static final Drawable getDrawableByResId(int resId) {
        return ResUtil.getDrawableByResId(resId);
    }

    @JvmStatic
    @PluginAccessible
    public static final int addCustomerRatio(Float[] array) {
        Intrinsics.checkNotNullParameter(array, b.f11693j);
        if (array.length < 5) {
            return -1;
        }
        int i2 = mCustomerRatioIndex + 1;
        mCustomerRatioIndex = i2;
        mCustomerRatios.put(Integer.valueOf(i2), array);
        return mCustomerRatioIndex;
    }

    @JvmStatic
    @PluginAccessible
    public static final float getScaledRatio(int type) {
        int targetFontSize$iv;
        FontSizeHelper this_$iv$iv;
        Scaled1DSizeInfo sizeInfo;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv;
        FontSizeHelper this_$iv = INSTANCE;
        FontSizeHelper fontSizeHelper = INSTANCE;
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            targetFontSize$iv = 1;
        } else {
            targetFontSize$iv = mTargetLevel;
        }
        FontSizeHelper fontSizeHelper2 = this_$iv;
        if (targetFontSize$iv == 1) {
            this_$iv$iv = null;
        } else if (type == 0 && targetFontSize$iv == 0) {
            this_$iv$iv = null;
        } else {
            if (((targetFontSize$iv < 0 || targetFontSize$iv >= 5) ? 0 : 1) == 0) {
                this_$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv = null;
            } else {
                this_$iv$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv$iv == null) {
            sizeInfo = new Scaled1DSizeInfo(false, 1.0f, 0.0f);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv;
            switch (type) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize$iv].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize$iv].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize$iv].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize$iv].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[targetFontSize$iv].floatValue();
                        break;
                    }
            }
            float ratio$iv = f2;
            sizeInfo = new Scaled1DSizeInfo(true, ratio$iv, 0.0f * ratio$iv);
        }
        return sizeInfo.getRatio();
    }

    @JvmStatic
    @PluginAccessible
    public static final Float[] getScaledRatioArray(int type) {
        Float[] fArr;
        switch (type) {
            case 0:
                return SCALED_RATIO_FRAMEWORK;
            case 1:
                return SCALED_RATIO_CONTENT;
            case 2:
                return SCALED_RATIO_H;
            case 3:
                return SCALED_RATIO_T;
            default:
                HashMap<Integer, Float[]> hashMap = mCustomerRatios;
                if (hashMap.containsKey(Integer.valueOf(type))) {
                    fArr = hashMap.get(Integer.valueOf(type));
                    if (fArr == null) {
                        fArr = SCALED_RATIO_NONE;
                    }
                } else {
                    fArr = SCALED_RATIO_NONE;
                }
                Intrinsics.checkNotNullExpressionValue(fArr, "{\n                if (mC…          }\n            }");
                return fArr;
        }
    }

    private final float getScaledSizeInner(int type, float size, int baseFontSize, int targetFontSize) {
        FontSizeHelper this_$iv$iv;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv;
        if (targetFontSize == 1) {
            this_$iv$iv = null;
        } else if (type == 0 && targetFontSize == 0) {
            this_$iv$iv = null;
        } else {
            if (((targetFontSize < 0 || targetFontSize >= 5) ? 0 : 1) == 0) {
                this_$iv$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv = null;
            } else {
                this_$iv$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv$iv == null) {
            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, size);
        } else {
            switch (type) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[targetFontSize].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[targetFontSize].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[targetFontSize].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[targetFontSize].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[targetFontSize].floatValue();
                        break;
                    }
            }
            float ratio$iv = f2;
            scaled1DSizeInfo = new Scaled1DSizeInfo(true, ratio$iv, size * ratio$iv);
        }
        Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7 = scaled1DSizeInfo;
        if (!$this$getScaledSizeInner_u24lambda_u2d7.isScaledRequired()) {
            return size;
        }
        return $this$getScaledSizeInner_u24lambda_u2d7.getScaledSize();
    }

    static /* synthetic */ Bitmap getScaledBitmapInner$default(FontSizeHelper fontSizeHelper, int type, Bitmap bitmap, int baseFontSize, int targetFontSize, int numRoundPolicy, int i2, Object obj) {
        int numRoundPolicy2;
        FontSizeHelper this_$iv$iv;
        Scaled2DSizeInfo scaled2DSizeInfo;
        int i3;
        int i4;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv;
        int i5 = type;
        int i6 = targetFontSize;
        if ((i2 & 16) != 0) {
            numRoundPolicy2 = 2;
        } else {
            numRoundPolicy2 = numRoundPolicy;
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap it = bitmap;
        FontSizeHelper this_$iv = INSTANCE;
        float width$iv = (float) it.getWidth();
        float height$iv = (float) it.getHeight();
        FontSizeHelper fontSizeHelper2 = this_$iv;
        if (i6 == 1) {
            this_$iv$iv = null;
        } else if (i5 == 0 && i6 == 0) {
            this_$iv$iv = null;
        } else {
            if (((i6 < 0 || i6 >= 5) ? 0 : 1) == 0) {
                this_$iv$iv = null;
            } else if ((i5 <= -1 || i5 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv = null;
            } else {
                this_$iv$iv = 1;
            }
        }
        if (this_$iv$iv == null) {
            scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv, height$iv);
        } else {
            FontSizeHelper fontSizeHelper3 = this_$iv;
            float f2 = 1.0f;
            switch (i5) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[i6].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[i6].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[i6].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[i6].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[i6].floatValue();
                        break;
                    }
            }
            float ratio$iv = f2;
            scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv * ratio$iv, height$iv * ratio$iv);
        }
        Scaled2DSizeInfo $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9 = scaled2DSizeInfo;
        if (!$this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.isScaledRequired()) {
            return it;
        }
        FontSizeHelper this_$iv2 = INSTANCE;
        try {
            float $this$roundByPolicy$iv = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.getScaledWidth();
            switch (numRoundPolicy2) {
                case 0:
                    i3 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
                    break;
                case 1:
                    i3 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
                    break;
                case 2:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
                default:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
            }
            float $this$roundByPolicy$iv2 = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.getScaledHeight();
            switch (numRoundPolicy2) {
                case 0:
                    i4 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv2));
                    break;
                case 1:
                    i4 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv2));
                    break;
                case 2:
                    i4 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
                default:
                    i4 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
            }
            return Bitmap.createScaledBitmap(it, i3, i4, true);
        } catch (Error e$iv) {
            FontSizeHelper fontSizeHelper4 = this_$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv.printStackTrace();
            }
            return it;
        } catch (Exception e$iv2) {
            FontSizeHelper fontSizeHelper5 = this_$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv2.printStackTrace();
            }
            return it;
        }
    }

    private final Bitmap getScaledBitmapInner(int type, Bitmap bitmap, int baseFontSize, int targetFontSize, int numRoundPolicy) {
        FontSizeHelper this_$iv$iv;
        Scaled2DSizeInfo scaled2DSizeInfo;
        int i2;
        int i3;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv;
        int i4 = type;
        int i5 = targetFontSize;
        if (bitmap == null) {
            return null;
        }
        Bitmap it = bitmap;
        FontSizeHelper this_$iv = INSTANCE;
        float width$iv = (float) it.getWidth();
        float height$iv = (float) it.getHeight();
        FontSizeHelper fontSizeHelper = this_$iv;
        if (i5 == 1) {
            this_$iv$iv = null;
        } else if (i4 == 0 && i5 == 0) {
            this_$iv$iv = null;
        } else {
            if (((i5 < 0 || i5 >= 5) ? 0 : 1) == 0) {
                this_$iv$iv = null;
            } else if ((i4 <= -1 || i4 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv$iv = null;
            } else {
                this_$iv$iv = 1;
            }
        }
        if (this_$iv$iv == null) {
            scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv, height$iv);
        } else {
            FontSizeHelper fontSizeHelper2 = this_$iv;
            float f2 = 1.0f;
            switch (i4) {
                case 0:
                    f2 = SCALED_RATIO_FRAMEWORK[i5].floatValue();
                    break;
                case 1:
                    f2 = SCALED_RATIO_CONTENT[i5].floatValue();
                    break;
                case 2:
                    f2 = SCALED_RATIO_H[i5].floatValue();
                    break;
                case 3:
                    f2 = SCALED_RATIO_T[i5].floatValue();
                    break;
                default:
                    if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                        f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[i5].floatValue();
                        break;
                    }
            }
            float ratio$iv = f2;
            scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv * ratio$iv, height$iv * ratio$iv);
        }
        Scaled2DSizeInfo $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9 = scaled2DSizeInfo;
        if (!$this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.isScaledRequired()) {
            return it;
        }
        FontSizeHelper this_$iv2 = INSTANCE;
        try {
            float $this$roundByPolicy$iv = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.getScaledWidth();
            switch (numRoundPolicy) {
                case 0:
                    i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
                    break;
                case 1:
                    i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
                    break;
                case 2:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
                default:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
            }
            float $this$roundByPolicy$iv2 = $this$getScaledBitmapInner_u24lambda_u2d10_u24lambda_u2d9.getScaledHeight();
            switch (numRoundPolicy) {
                case 0:
                    i3 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv2));
                    break;
                case 1:
                    i3 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv2));
                    break;
                case 2:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
                default:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
            }
            return Bitmap.createScaledBitmap(it, i2, i3, true);
        } catch (Error e$iv) {
            FontSizeHelper fontSizeHelper3 = this_$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv.printStackTrace();
            }
            return it;
        } catch (Exception e$iv2) {
            FontSizeHelper fontSizeHelper4 = this_$iv2;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e$iv2.printStackTrace();
            }
            return it;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v72, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r66v11, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v84, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v16, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v21, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v17, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
        r2 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(((float) r5) * r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x045e, code lost:
        switch(r3) {
            case 0: goto L_0x0481;
            case 1: goto L_0x0475;
            case 2: goto L_0x046a;
            default: goto L_0x0461;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0461, code lost:
        r47 = r5;
        r46 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:?, code lost:
        r5 = kotlin.math.MathKt.roundToInt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x046e, code lost:
        r47 = r5;
        r5 = kotlin.math.MathKt.roundToInt(r2);
        r46 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0475, code lost:
        r47 = r5;
        r46 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        r5 = (int) ((float) java.lang.Math.floor((double) r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0481, code lost:
        r47 = r5;
        r46 = r6;
        r5 = (int) ((float) java.lang.Math.ceil((double) r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x048c, code lost:
        r1 = android.graphics.Bitmap.createScaledBitmap(r4, r1, r5, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "createScaledBitmap(\n    …                        )");
        r8.addLevel(r10, r10, new android.graphics.drawable.BitmapDrawable(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x054a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x054b, code lost:
        r7 = r60;
        r1 = r0;
        r42 = r4;
        r43 = r12;
        r47 = r13;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x05a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x05a4, code lost:
        r7 = r60;
        r2 = r63;
        r1 = r0;
        r44 = r6;
        r43 = r12;
        r47 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x05d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x05d2, code lost:
        r7 = r60;
        r2 = r63;
        r1 = r0;
        r43 = r12;
        r47 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x05dd, code lost:
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x05e0, code lost:
        switch(r3) {
            case 0: goto L_0x0605;
            case 1: goto L_0x05f9;
            case 2: goto L_0x05ec;
            default: goto L_0x05e3;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x05e3, code lost:
        r43 = r12;
        r47 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:?, code lost:
        r12 = kotlin.math.MathKt.roundToInt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x05f0, code lost:
        r47 = r13;
        r43 = r12;
        r12 = kotlin.math.MathKt.roundToInt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x05f9, code lost:
        r43 = r12;
        r47 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:?, code lost:
        r12 = (int) ((float) java.lang.Math.floor((double) r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0605, code lost:
        r43 = r12;
        r47 = r13;
        r12 = (int) ((float) java.lang.Math.ceil((double) r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0610, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r2, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r4, r7, r12, true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0625, code lost:
        r7 = r60;
        r53 = r2;
        r55 = r10;
        r12 = r36;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0631, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0632, code lost:
        r43 = r12;
        r47 = r13;
        r7 = r60;
        r2 = r63;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x063d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x063e, code lost:
        r44 = r6;
        r43 = r12;
        r47 = r13;
        r7 = r60;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x066e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x066f, code lost:
        r8 = r0;
        r53 = r2;
        r55 = r10;
        r7 = r60;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0730, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0731, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x07c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x07c5, code lost:
        r55 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x07f0, code lost:
        r12 = r36;
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + r12);
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0810, code lost:
        r12 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x0834, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0835, code lost:
        r7 = r60;
        r2 = r63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x083a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x083b, code lost:
        r7 = r60;
        r2 = r63;
        r44 = r6;
        r43 = r12;
        r47 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0845, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x085c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x085d, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x0870, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x0871, code lost:
        r7 = r60;
        r42 = r4;
        r43 = r12;
        r47 = r13;
        r2 = r63;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x0881, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:434:0x0882, code lost:
        r7 = r60;
        r37 = r1;
        r42 = r4;
        r43 = r12;
        r47 = r13;
        r2 = r63;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:436:?, code lost:
        r4 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x089e, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x08a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x08a0, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x08c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x08c4, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:447:0x08c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x08c8, code lost:
        r7 = r60;
        r2 = r63;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x08cf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x08d0, code lost:
        r7 = r60;
        r2 = r63;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:479:0x0937, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x0938, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x09e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:523:0x09e4, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:545:0x0a7a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:546:0x0a7b, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:547:0x0a7f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x0a80, code lost:
        r64 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x0a85, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:552:0x0a8f, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0a91;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x0a91, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + r12);
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:558:0x0abd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:559:0x0abe, code lost:
        r46 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:598:0x0b2d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:599:0x0b2e, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:607:0x0b75, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:608:0x0b76, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:624:0x0c11, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:625:0x0c12, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:627:?, code lost:
        r6 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:628:0x0c22, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0c24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:629:0x0c24, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:728:0x0e30, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a6, code lost:
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a9, code lost:
        switch(r3) {
            case 0: goto L_0x01cc;
            case 1: goto L_0x01c0;
            case 2: goto L_0x01b5;
            default: goto L_0x01ac;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ac, code lost:
        r64 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b5, code lost:
        r64 = r11;
        r10 = kotlin.math.MathKt.roundToInt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c0, code lost:
        r64 = r11;
        r10 = (int) ((float) java.lang.Math.floor((double) r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cc, code lost:
        r64 = r11;
        r10 = (int) ((float) java.lang.Math.ceil((double) r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d8, code lost:
        r10 = kotlin.math.MathKt.roundToInt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01da, code lost:
        r4 = android.graphics.Bitmap.createScaledBitmap(r15, r9, r10, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "createScaledBitmap(\n    …licy), true\n            )");
        r11 = new android.graphics.drawable.BitmapDrawable(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext().getResources(), r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:275:0x0547] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:291:0x0578] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:296:0x058d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:298:0x0592] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:304:0x05ba] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:313:0x05e7] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:338:0x0665] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:375:0x070d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:378:0x0713] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:257:0x04f8, B:414:0x07e6] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:470:0x091c, B:585:0x0b0a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:470:0x091c, B:588:0x0b10] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:470:0x091c, B:596:0x0b26] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x06ff  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0703  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x07f0 A[Catch:{ Exception -> 0x085c, Error -> 0x08c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0810 A[Catch:{ Exception -> 0x085c, Error -> 0x08c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x08a0 A[Catch:{ Error -> 0x08c3, Exception -> 0x08bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x08c3 A[ExcHandler: Error (r0v15 'e' java.lang.Error A[CUSTOM_DECLARE]), PHI: r32 
      PHI: (r32v7 'this_$iv' com.baidu.searchbox.config.FontSizeHelper) = (r32v6 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r32v16 'this_$iv' com.baidu.searchbox.config.FontSizeHelper) binds: [B:690:0x0d50, B:435:0x0893, B:287:0x0573, B:414:0x07e6, B:375:0x070d, B:378:0x0713, B:346:0x0691, B:347:?, B:338:0x0665, B:291:0x0578, B:319:0x05fe, B:315:0x05ec, B:313:0x05e7, B:304:0x05ba, B:298:0x0592, B:296:0x058d, B:275:0x0547, B:276:?, B:257:0x04f8] A[DONT_GENERATE, DONT_INLINE], Splitter:B:257:0x04f8] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x08cf A[ExcHandler: Error (r0v23 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:265:0x0524] */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x09b2 A[Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }] */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x09b6 A[Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }] */
    /* JADX WARNING: Removed duplicated region for block: B:553:0x0a91 A[Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:558:0x0abd A[ExcHandler: Error (r0v9 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:470:0x091c] */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x0afc  */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x0b00  */
    /* JADX WARNING: Removed duplicated region for block: B:629:0x0c24 A[Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:647:0x0c74 A[Catch:{ Error -> 0x0de3, Exception -> 0x0dde }] */
    /* JADX WARNING: Removed duplicated region for block: B:648:0x0c78 A[Catch:{ Error -> 0x0de3, Exception -> 0x0dde }] */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0e13  */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0e30  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:435:0x0893=Splitter:B:435:0x0893, B:257:0x04f8=Splitter:B:257:0x04f8, B:375:0x070d=Splitter:B:375:0x070d} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:435:0x0893=Splitter:B:435:0x0893, B:257:0x04f8=Splitter:B:257:0x04f8} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:487:0x0970=Splitter:B:487:0x0970, B:626:0x0c17=Splitter:B:626:0x0c17, B:585:0x0b0a=Splitter:B:585:0x0b0a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ android.graphics.drawable.Drawable getScaledDrawableInner$default(com.baidu.searchbox.config.FontSizeHelper r59, int r60, android.graphics.drawable.Drawable r61, int r62, int r63, int r64, int r65, java.lang.Object r66) {
        /*
            r1 = r60
            r2 = r63
            r3 = r65 & 16
            if (r3 == 0) goto L_0x000a
            r3 = 2
            goto L_0x000c
        L_0x000a:
            r3 = r64
        L_0x000c:
            r4 = 0
            if (r61 == 0) goto L_0x0e39
            r6 = r61
            r7 = 0
            com.baidu.searchbox.config.FontSizeHelper r8 = INSTANCE
            r9 = 0
            r10 = 0
            boolean r11 = r6 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0e17, Exception -> 0x0dfa }
            r13 = 5
            r14 = -1
            r5 = 1
            if (r11 == 0) goto L_0x024e
            com.baidu.searchbox.config.FontSizeHelper r11 = INSTANCE     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            r16 = r6
            android.graphics.drawable.BitmapDrawable r16 = (android.graphics.drawable.BitmapDrawable) r16     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            r17 = r11
            r18 = 0
            r19 = r17
            r20 = 0
            r21 = r16
            android.graphics.drawable.Drawable r21 = (android.graphics.drawable.Drawable) r21     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            r22 = 0
            r23 = r16
            android.graphics.drawable.Drawable r23 = (android.graphics.drawable.Drawable) r23     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            int r15 = r23.getIntrinsicWidth()     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            float r15 = (float) r15     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            float r15 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r15)     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            r23 = r16
            android.graphics.drawable.Drawable r23 = (android.graphics.drawable.Drawable) r23     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            int r12 = r23.getIntrinsicHeight()     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            float r12 = (float) r12     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            r23 = 0
            r25 = r11
            r26 = 0
            if (r2 != r5) goto L_0x005a
            r13 = 0
            goto L_0x0083
        L_0x005a:
            if (r1 != 0) goto L_0x0060
            if (r2 != 0) goto L_0x0060
            r13 = 0
            goto L_0x0083
        L_0x0060:
            r27 = 0
            if (r2 < 0) goto L_0x0068
            if (r2 >= r13) goto L_0x0068
            r13 = r5
            goto L_0x0069
        L_0x0068:
            r13 = 0
        L_0x0069:
            if (r13 != 0) goto L_0x006d
            r13 = 0
            goto L_0x0083
        L_0x006d:
            if (r1 <= r14) goto L_0x0072
            r13 = 4
            if (r1 < r13) goto L_0x0082
        L_0x0072:
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            boolean r13 = r13.containsKey(r14)     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            if (r13 != 0) goto L_0x0082
            r13 = 0
            goto L_0x0083
        L_0x0082:
            r13 = r5
        L_0x0083:
            if (r13 != 0) goto L_0x00ab
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r13 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r14 = 0
            r13.<init>(r14, r15, r12)     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r26 = r4
            goto L_0x013a
        L_0x008f:
            r0 = move-exception
            r1 = r0
            r26 = r4
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            goto L_0x0e06
        L_0x009d:
            r0 = move-exception
            r1 = r0
            r26 = r4
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            goto L_0x0e23
        L_0x00ab:
            r13 = r11
            r14 = 0
            switch(r1) {
                case 0: goto L_0x00dd;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00b5;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0240, Exception -> 0x0232 }
            goto L_0x00ea
        L_0x00b5:
            java.lang.Float[] r24 = SCALED_RATIO_T     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r24 = r24[r2]     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r26 = r4
            goto L_0x012b
        L_0x00c3:
            java.lang.Float[] r24 = SCALED_RATIO_H     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r24 = r24[r2]     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r26 = r4
            goto L_0x012b
        L_0x00d0:
            java.lang.Float[] r24 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r24 = r24[r2]     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r26 = r4
            goto L_0x012b
        L_0x00dd:
            java.lang.Float[] r24 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r24 = r24[r2]     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x009d, Exception -> 0x008f }
            r26 = r4
            goto L_0x012b
        L_0x00ea:
            r26 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            boolean r4 = r5.containsKey(r4)     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            if (r4 == 0) goto L_0x0129
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            java.lang.Float[] r4 = (java.lang.Float[]) r4     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            if (r4 == 0) goto L_0x010e
            r5 = 0
            r24 = r4[r2]     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            goto L_0x012b
        L_0x010e:
            r24 = 1065353216(0x3f800000, float:1.0)
            goto L_0x012b
        L_0x0111:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            goto L_0x0e06
        L_0x011d:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            goto L_0x0e23
        L_0x0129:
            r24 = 1065353216(0x3f800000, float:1.0)
        L_0x012b:
            r4 = r24
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r13 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            float r5 = r15 * r4
            float r14 = r12 * r4
            r64 = r4
            r4 = 1
            r13.<init>(r4, r5, r14)     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
        L_0x013a:
            r4 = r13
            r5 = 0
            boolean r11 = r4.isScaledRequired()     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            if (r11 != 0) goto L_0x014e
            r11 = r16
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            r65 = r4
            r27 = r9
            r28 = r10
            goto L_0x01f6
        L_0x014e:
            float r11 = r4.getScaledWidth()     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            float r12 = r4.getScaledHeight()     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            r13 = r16
            android.graphics.drawable.Drawable r13 = (android.graphics.drawable.Drawable) r13     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            android.graphics.drawable.BitmapDrawable r13 = (android.graphics.drawable.BitmapDrawable) r13     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            r14 = 0
            android.graphics.Bitmap r15 = r13.getBitmap()     // Catch:{ Error -> 0x0226, Exception -> 0x021a }
            r64 = r11
            r23 = 0
            switch(r3) {
                case 0: goto L_0x0194;
                case 1: goto L_0x0184;
                case 2: goto L_0x0175;
                default: goto L_0x0168;
            }
        L_0x0168:
            r65 = r4
            r27 = r9
            r28 = r10
            r4 = r64
            int r24 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01a4
        L_0x0175:
            int r24 = kotlin.math.MathKt.roundToInt((float) r64)     // Catch:{ Error -> 0x011d, Exception -> 0x0111 }
            r65 = r4
            r27 = r9
            r28 = r10
            r9 = r24
            r4 = r64
            goto L_0x01a6
        L_0x0184:
            r65 = r4
            r27 = r9
            r28 = r10
            r4 = r64
            double r9 = (double) r4
            double r9 = java.lang.Math.floor(r9)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            float r9 = (float) r9     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            int r9 = (int) r9     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01a6
        L_0x0194:
            r65 = r4
            r27 = r9
            r28 = r10
            r4 = r64
            double r9 = (double) r4     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            double r9 = java.lang.Math.ceil(r9)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            float r9 = (float) r9     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            int r9 = (int) r9     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01a6
        L_0x01a4:
            r9 = r24
        L_0x01a6:
            r4 = r12
            r10 = 0
            switch(r3) {
                case 0: goto L_0x01cc;
                case 1: goto L_0x01c0;
                case 2: goto L_0x01b5;
                default: goto L_0x01ac;
            }     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
        L_0x01ac:
            r66 = r10
            r64 = r11
            int r23 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01d8
        L_0x01b5:
            int r23 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            r66 = r10
            r64 = r11
            r10 = r23
            goto L_0x01da
        L_0x01c0:
            r66 = r10
            r64 = r11
            double r10 = (double) r4     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            double r10 = java.lang.Math.floor(r10)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            float r10 = (float) r10     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            int r10 = (int) r10     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01da
        L_0x01cc:
            r66 = r10
            r64 = r11
            double r10 = (double) r4     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            float r10 = (float) r10     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            int r10 = (int) r10     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            goto L_0x01da
        L_0x01d8:
            r10 = r23
        L_0x01da:
            r4 = 1
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createScaledBitmap(r15, r9, r10, r4)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            java.lang.String r9 = "createScaledBitmap(\n    …licy), true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            android.graphics.drawable.BitmapDrawable r9 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            android.content.Context r10 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            r9.<init>(r10, r4)     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            r11 = r9
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
        L_0x01f6:
            android.graphics.drawable.BitmapDrawable r11 = (android.graphics.drawable.BitmapDrawable) r11     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ Error -> 0x0210, Exception -> 0x0206 }
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0ddb
        L_0x0206:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e06
        L_0x0210:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e23
        L_0x021a:
            r0 = move-exception
            r27 = r9
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e06
        L_0x0226:
            r0 = move-exception
            r27 = r9
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e23
        L_0x0232:
            r0 = move-exception
            r26 = r4
            r27 = r9
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e06
        L_0x0240:
            r0 = move-exception
            r26 = r4
            r27 = r9
            r1 = r0
            r46 = r6
            r35 = r7
            r32 = r8
            goto L_0x0e23
        L_0x024e:
            r26 = r4
            r27 = r9
            r28 = r10
            boolean r4 = r6 instanceof android.graphics.drawable.StateListDrawable     // Catch:{ Error -> 0x0df1, Exception -> 0x0de8 }
            if (r4 == 0) goto L_0x025a
            r4 = 1
            goto L_0x025c
        L_0x025a:
            boolean r4 = r6 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0df1, Exception -> 0x0de8 }
        L_0x025c:
            java.lang.String r5 = ", OriginalRadius is :"
            java.lang.String r10 = ", GradientDrawable ReflectionUtil Error"
            java.lang.String r11 = "mRadius"
            java.lang.String r15 = "Version: "
            java.lang.String r9 = "FontSizeHelper"
            if (r4 == 0) goto L_0x090d
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            r17 = r4
            r18 = 0
            r19 = r17
            r20 = 0
            r21 = r6
            r22 = 0
            int r12 = r6.getIntrinsicWidth()     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            float r12 = (float) r12     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            int r14 = r6.getIntrinsicHeight()     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            float r14 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r14)     // Catch:{ Error -> 0x0902, Exception -> 0x08f7 }
            r30 = r4
            r31 = 0
            r32 = r30
            r33 = 0
            r13 = 1
            if (r2 != r13) goto L_0x029a
            r35 = r7
            r7 = 0
            goto L_0x02ca
        L_0x029a:
            if (r1 != 0) goto L_0x02a2
            if (r2 != 0) goto L_0x02a2
            r35 = r7
            r7 = 0
            goto L_0x02ca
        L_0x02a2:
            r13 = 0
            if (r2 < 0) goto L_0x02ac
            r35 = r7
            r7 = 5
            if (r2 >= r7) goto L_0x02ae
            r7 = 1
            goto L_0x02af
        L_0x02ac:
            r35 = r7
        L_0x02ae:
            r7 = 0
        L_0x02af:
            if (r7 != 0) goto L_0x02b3
            r7 = 0
            goto L_0x02ca
        L_0x02b3:
            r7 = -1
            if (r1 <= r7) goto L_0x02b9
            r7 = 4
            if (r1 < r7) goto L_0x02c9
        L_0x02b9:
            java.util.HashMap r7 = mCustomerRatios     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            boolean r7 = r7.containsKey(r13)     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            if (r7 != 0) goto L_0x02c9
            r7 = 0
            goto L_0x02ca
        L_0x02c9:
            r7 = 1
        L_0x02ca:
            if (r7 != 0) goto L_0x02e6
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r7 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r13 = 0
            r7.<init>(r13, r12, r14)     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r32 = r8
            goto L_0x0374
        L_0x02d6:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r32 = r8
            goto L_0x0e06
        L_0x02de:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r32 = r8
            goto L_0x0e23
        L_0x02e6:
            r7 = r30
            r13 = 0
            switch(r1) {
                case 0: goto L_0x0326;
                case 1: goto L_0x0315;
                case 2: goto L_0x0304;
                case 3: goto L_0x02f3;
                default: goto L_0x02ec;
            }
        L_0x02ec:
            r32 = r7
            java.util.HashMap r7 = mCustomerRatios     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            goto L_0x0337
        L_0x02f3:
            java.lang.Float[] r32 = SCALED_RATIO_T     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r32 = r32[r2]     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            float r32 = r32.floatValue()     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r33 = r13
            r36 = r32
            r32 = r7
            goto L_0x0360
        L_0x0304:
            java.lang.Float[] r32 = SCALED_RATIO_H     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r32 = r32[r2]     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            float r32 = r32.floatValue()     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r33 = r13
            r36 = r32
            r32 = r7
            goto L_0x0360
        L_0x0315:
            java.lang.Float[] r32 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r32 = r32[r2]     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            float r32 = r32.floatValue()     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r33 = r13
            r36 = r32
            r32 = r7
            goto L_0x0360
        L_0x0326:
            java.lang.Float[] r32 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r32 = r32[r2]     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            float r32 = r32.floatValue()     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            r33 = r13
            r36 = r32
            r32 = r7
            goto L_0x0360
        L_0x0337:
            r33 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            boolean r7 = r7.containsKey(r13)     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            if (r7 == 0) goto L_0x035e
            java.util.HashMap r7 = mCustomerRatios     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            java.lang.Object r7 = r7.get(r13)     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            java.lang.Float[] r7 = (java.lang.Float[]) r7     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            if (r7 == 0) goto L_0x035b
            r13 = 0
            r36 = r7[r2]     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            float r36 = r36.floatValue()     // Catch:{ Error -> 0x02de, Exception -> 0x02d6 }
            goto L_0x0360
        L_0x035b:
            r36 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0360
        L_0x035e:
            r36 = 1065353216(0x3f800000, float:1.0)
        L_0x0360:
            r7 = r36
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r13 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x08ee, Exception -> 0x08e5 }
            r32 = r8
            float r8 = r12 * r7
            r33 = r12
            float r12 = r14 * r7
            r36 = r7
            r7 = 1
            r13.<init>(r7, r8, r12)     // Catch:{ Error -> 0x08de, Exception -> 0x08d7 }
            r7 = r13
        L_0x0374:
            r8 = 0
            boolean r12 = r7.isScaledRequired()     // Catch:{ Error -> 0x08de, Exception -> 0x08d7 }
            if (r12 != 0) goto L_0x0386
            r11 = r6
            r46 = r11
            r31 = r7
            r33 = r8
            r7 = r1
            goto L_0x08b9
        L_0x0386:
            float r12 = r7.getScaledWidth()     // Catch:{ Error -> 0x08de, Exception -> 0x08d7 }
            float r13 = r7.getScaledHeight()     // Catch:{ Error -> 0x08de, Exception -> 0x08d7 }
            r14 = r6
            r30 = 0
            r31 = r7
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x08de, Exception -> 0x08d7 }
            r33 = r8
            r8 = 23
            r36 = r10
            java.lang.String r10 = "getChildren"
            if (r7 > r8) goto L_0x0520
            boolean r7 = r6 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x051d, Exception -> 0x051a }
            if (r7 == 0) goto L_0x0520
            r5 = r6
            r7 = 0
            android.graphics.drawable.LevelListDrawable r8 = new android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x051d, Exception -> 0x051a }
            r8.<init>()     // Catch:{ Error -> 0x051d, Exception -> 0x051a }
            r9 = r5
            r11 = 0
            android.graphics.drawable.Drawable$ConstantState r15 = r9.getConstantState()     // Catch:{ Error -> 0x051d, Exception -> 0x051a }
            if (r15 == 0) goto L_0x0507
            r16 = 0
            kotlin.Result$Companion r23 = kotlin.Result.Companion     // Catch:{ all -> 0x04ec }
            r23 = r9
            r24 = 0
            r65 = r4
            java.lang.Class r4 = r15.getClass()     // Catch:{ all -> 0x04e1 }
            r29 = r5
            r34 = r7
            r5 = 0
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x04da }
            java.lang.reflect.Method r4 = r4.getMethod(r10, r7)     // Catch:{ all -> 0x04da }
            r7 = 1
            r4.setAccessible(r7)     // Catch:{ all -> 0x04da }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x04da }
            java.lang.Object r5 = r4.invoke(r15, r7)     // Catch:{ all -> 0x04da }
            boolean r7 = r5 instanceof java.lang.Object[]     // Catch:{ all -> 0x04da }
            if (r7 == 0) goto L_0x03e4
            java.lang.Object[] r5 = (java.lang.Object[]) r5     // Catch:{ all -> 0x03dc }
            goto L_0x03e5
        L_0x03dc:
            r0 = move-exception
            r1 = r0
            r46 = r6
            r45 = r9
            goto L_0x04f8
        L_0x03e4:
            r5 = 0
        L_0x03e5:
            if (r5 == 0) goto L_0x04cc
            r7 = 0
            r10 = 0
            r36 = r4
            int r4 = r5.length     // Catch:{ all -> 0x04da }
            r64 = r7
            r7 = 0
        L_0x03ef:
            if (r7 >= r4) goto L_0x04c3
            r37 = r5[r7]     // Catch:{ all -> 0x04da }
            int r38 = r10 + 1
            r66 = r37
            r39 = 0
            r40 = r4
            r41 = r5
            r4 = r66
            boolean r5 = r4 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x04da }
            if (r5 == 0) goto L_0x04aa
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x04da }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ all -> 0x04da }
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()     // Catch:{ all -> 0x04da }
            int r5 = r5.densityDpi     // Catch:{ all -> 0x04da }
            r42 = 160(0xa0, float:2.24E-43)
            int r43 = r5 / r42
            r66 = r43
            r43 = r4
            android.graphics.drawable.BitmapDrawable r43 = (android.graphics.drawable.BitmapDrawable) r43     // Catch:{ all -> 0x04da }
            r44 = r4
            android.graphics.Bitmap r4 = r43.getBitmap()     // Catch:{ all -> 0x04da }
            r43 = r5
            r45 = r9
            r5 = r66
            float r9 = (float) r5
            float r9 = r9 * r12
            float r9 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r9)     // Catch:{ all -> 0x04a5 }
            r46 = 0
            switch(r3) {
                case 0: goto L_0x0446;
                case 1: goto L_0x043e;
                case 2: goto L_0x0437;
                default: goto L_0x0432;
            }     // Catch:{ all -> 0x04a5 }
        L_0x0432:
            int r47 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ all -> 0x04a5 }
            goto L_0x0454
        L_0x0437:
            int r47 = kotlin.math.MathKt.roundToInt((float) r9)     // Catch:{ all -> 0x044e }
            r1 = r47
            goto L_0x0456
        L_0x043e:
            double r1 = (double) r9     // Catch:{ all -> 0x044e }
            double r1 = java.lang.Math.floor(r1)     // Catch:{ all -> 0x044e }
            float r1 = (float) r1     // Catch:{ all -> 0x044e }
            int r1 = (int) r1     // Catch:{ all -> 0x044e }
            goto L_0x0456
        L_0x0446:
            double r1 = (double) r9     // Catch:{ all -> 0x044e }
            double r1 = java.lang.Math.ceil(r1)     // Catch:{ all -> 0x044e }
            float r1 = (float) r1
            int r1 = (int) r1
            goto L_0x0456
        L_0x044e:
            r0 = move-exception
            r1 = r0
            r46 = r6
            goto L_0x04f8
        L_0x0454:
            r1 = r47
        L_0x0456:
            float r2 = (float) r5
            float r2 = r2 * r13
            float r2 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r2)     // Catch:{ all -> 0x04a5 }
            r9 = 0
            switch(r3) {
                case 0: goto L_0x0481;
                case 1: goto L_0x0475;
                case 2: goto L_0x046a;
                default: goto L_0x0461;
            }
        L_0x0461:
            r47 = r5
            r46 = r6
            int r5 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ all -> 0x04d7 }
            goto L_0x048c
        L_0x046a:
            int r46 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ all -> 0x044e }
            r47 = r5
            r5 = r46
            r46 = r6
            goto L_0x048c
        L_0x0475:
            r47 = r5
            r46 = r6
            double r5 = (double) r2
            double r5 = java.lang.Math.floor(r5)     // Catch:{ all -> 0x04d7 }
            float r5 = (float) r5     // Catch:{ all -> 0x04d7 }
            int r5 = (int) r5     // Catch:{ all -> 0x04d7 }
            goto L_0x048c
        L_0x0481:
            r47 = r5
            r46 = r6
            double r5 = (double) r2     // Catch:{ all -> 0x04d7 }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ all -> 0x04d7 }
            float r5 = (float) r5     // Catch:{ all -> 0x04d7 }
            int r5 = (int) r5     // Catch:{ all -> 0x04d7 }
        L_0x048c:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r4, r1, r5, r2)     // Catch:{ all -> 0x04d7 }
            java.lang.String r2 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x04d7 }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x04d7 }
            r2.<init>(r1)     // Catch:{ all -> 0x04d7 }
            r4 = r2
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ all -> 0x04d7 }
            r8.addLevel(r10, r10, r4)     // Catch:{ all -> 0x04d7 }
            goto L_0x04b0
        L_0x04a5:
            r0 = move-exception
            r46 = r6
            r1 = r0
            goto L_0x04f8
        L_0x04aa:
            r44 = r4
            r46 = r6
            r45 = r9
        L_0x04b0:
            int r7 = r7 + 1
            r1 = r60
            r2 = r63
            r10 = r38
            r4 = r40
            r5 = r41
            r9 = r45
            r6 = r46
            goto L_0x03ef
        L_0x04c3:
            r41 = r5
            r46 = r6
            r45 = r9
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x04d7 }
            goto L_0x04d3
        L_0x04cc:
            r36 = r4
            r46 = r6
            r45 = r9
            r5 = 0
        L_0x04d3:
            kotlin.Result.m8971constructorimpl(r5)     // Catch:{ all -> 0x04d7 }
            goto L_0x0501
        L_0x04d7:
            r0 = move-exception
            r1 = r0
            goto L_0x04f8
        L_0x04da:
            r0 = move-exception
            r46 = r6
            r45 = r9
            r1 = r0
            goto L_0x04f8
        L_0x04e1:
            r0 = move-exception
            r29 = r5
            r46 = r6
            r34 = r7
            r45 = r9
            r1 = r0
            goto L_0x04f8
        L_0x04ec:
            r0 = move-exception
            r65 = r4
            r29 = r5
            r46 = r6
            r34 = r7
            r45 = r9
            r1 = r0
        L_0x04f8:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            kotlin.Result.m8971constructorimpl(r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0501:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0511
        L_0x0507:
            r65 = r4
            r29 = r5
            r46 = r6
            r34 = r7
            r45 = r9
        L_0x0511:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r11 = r8
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0ddb
        L_0x051a:
            r0 = move-exception
            goto L_0x08d9
        L_0x051d:
            r0 = move-exception
            goto L_0x08e0
        L_0x0520:
            r46 = r6
            r1 = r14
            r2 = 0
            android.graphics.drawable.Drawable$ConstantState r4 = r1.getConstantState()     // Catch:{ Error -> 0x08cf, Exception -> 0x08c7 }
            if (r4 == 0) goto L_0x08a9
            r6 = 0
            java.lang.Class r7 = r4.getClass()     // Catch:{ Exception -> 0x0881, Error -> 0x08cf }
            r37 = r1
            r8 = 0
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            java.lang.reflect.Method r1 = r7.getMethod(r10, r1)     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            r7 = 1
            r1.setAccessible(r7)     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            java.lang.Object r7 = r1.invoke(r4, r7)     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            boolean r8 = r7 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            if (r8 == 0) goto L_0x055c
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ Exception -> 0x054a, Error -> 0x08c3 }
            goto L_0x055d
        L_0x054a:
            r0 = move-exception
            r7 = r60
            r1 = r0
            r41 = r2
            r42 = r4
            r44 = r6
            r43 = r12
            r47 = r13
            r2 = r63
            goto L_0x0893
        L_0x055c:
            r7 = 0
        L_0x055d:
            if (r7 == 0) goto L_0x085f
            r8 = 0
            int r10 = r7.length     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            r38 = r1
            r1 = 0
        L_0x0564:
            if (r1 >= r10) goto L_0x0847
            r39 = r7[r1]     // Catch:{ Exception -> 0x0870, Error -> 0x08cf }
            r64 = r39
            r40 = 0
            r41 = r2
            r42 = r4
            r2 = r64
            boolean r4 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x083a, Error -> 0x08cf }
            if (r4 == 0) goto L_0x064a
            r4 = r2
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4     // Catch:{ Exception -> 0x063d, Error -> 0x08c3 }
            android.graphics.Bitmap r4 = r4.getBitmap()     // Catch:{ Exception -> 0x063d, Error -> 0x08c3 }
            r64 = r12
            r43 = 0
            switch(r3) {
                case 0: goto L_0x05c1;
                case 1: goto L_0x05b1;
                case 2: goto L_0x0592;
                default: goto L_0x0585;
            }
        L_0x0585:
            r44 = r6
            r45 = r8
            r6 = r64
            r64 = r7
            int r7 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ Exception -> 0x0631, Error -> 0x08c3 }
            goto L_0x05dd
        L_0x0592:
            int r44 = kotlin.math.MathKt.roundToInt((float) r64)     // Catch:{ Exception -> 0x05a3, Error -> 0x08c3 }
            r45 = r8
            r58 = r6
            r6 = r64
            r64 = r7
            r7 = r44
            r44 = r58
            goto L_0x05dd
        L_0x05a3:
            r0 = move-exception
            r7 = r60
            r2 = r63
            r1 = r0
            r44 = r6
            r43 = r12
            r47 = r13
            goto L_0x0893
        L_0x05b1:
            r44 = r6
            r45 = r8
            r6 = r64
            r64 = r7
            double r7 = (double) r6
            double r7 = java.lang.Math.floor(r7)     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            float r7 = (float) r7     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            int r7 = (int) r7     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            goto L_0x05dd
        L_0x05c1:
            r44 = r6
            r45 = r8
            r6 = r64
            r64 = r7
            double r7 = (double) r6     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            float r7 = (float) r7
            int r7 = (int) r7
            goto L_0x05dd
        L_0x05d1:
            r0 = move-exception
            r7 = r60
            r2 = r63
            r1 = r0
            r43 = r12
            r47 = r13
            goto L_0x0893
        L_0x05dd:
            r6 = r13
            r8 = 0
            switch(r3) {
                case 0: goto L_0x0605;
                case 1: goto L_0x05f9;
                case 2: goto L_0x05ec;
                default: goto L_0x05e3;
            }
        L_0x05e3:
            r43 = r12
            r47 = r13
            int r12 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            goto L_0x0610
        L_0x05ec:
            int r43 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ Exception -> 0x05d1, Error -> 0x08c3 }
            r47 = r13
            r58 = r43
            r43 = r12
            r12 = r58
            goto L_0x0610
        L_0x05f9:
            r43 = r12
            r47 = r13
            double r12 = (double) r6
            double r12 = java.lang.Math.floor(r12)     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            float r12 = (float) r12     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            int r12 = (int) r12     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            goto L_0x0610
        L_0x0605:
            r43 = r12
            r47 = r13
            double r12 = (double) r6     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            float r12 = (float) r12     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            int r12 = (int) r12     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
        L_0x0610:
            r6 = 1
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createScaledBitmap(r4, r7, r12, r6)     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            r7 = 0
            java.lang.String r8 = "setBitmap"
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            r6 = 0
            r12[r6] = r4     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r2, r8, r12)     // Catch:{ Exception -> 0x0834, Error -> 0x08c3 }
            r7 = r60
            r53 = r2
            r55 = r10
            r12 = r36
            r2 = r63
            goto L_0x081d
        L_0x0631:
            r0 = move-exception
            r43 = r12
            r47 = r13
            r7 = r60
            r2 = r63
            r1 = r0
            goto L_0x0893
        L_0x063d:
            r0 = move-exception
            r44 = r6
            r43 = r12
            r47 = r13
            r7 = r60
            r2 = r63
            goto L_0x0845
        L_0x064a:
            r44 = r6
            r64 = r7
            r45 = r8
            r43 = r12
            r47 = r13
            boolean r4 = r2 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x0834, Error -> 0x08cf }
            if (r4 == 0) goto L_0x0813
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Exception -> 0x0834, Error -> 0x08cf }
            r6 = r2
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6     // Catch:{ Exception -> 0x0834, Error -> 0x08cf }
            r7 = 0
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            r12 = 24
            if (r8 < r12) goto L_0x067c
            float r8 = r6.getCornerRadius()     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            goto L_0x0684
        L_0x066e:
            r0 = move-exception
            r8 = r0
            r53 = r2
            r54 = r7
            r55 = r10
            r7 = r60
            r2 = r63
            goto L_0x07e4
        L_0x067c:
            android.graphics.drawable.Drawable$ConstantState r8 = r6.getConstantState()     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            java.lang.Object r8 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r8, r11)     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
        L_0x0684:
            r12 = r4
            r13 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r48 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            boolean r48 = r48.isDebug()     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            if (r48 == 0) goto L_0x06af
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            r12.<init>()     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.StringBuilder r12 = r12.append(r15)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.StringBuilder r12 = r12.append(r5)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.StringBuilder r12 = r12.append(r8)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
            android.util.Log.d(r9, r12)     // Catch:{ Exception -> 0x066e, Error -> 0x08c3 }
        L_0x06af:
            boolean r12 = r8 instanceof java.lang.Float     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            if (r12 == 0) goto L_0x07c9
            r12 = r8
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            r13 = 0
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x07c9
            r12 = r8
            java.lang.Number r12 = (java.lang.Number) r12     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x07d8, Error -> 0x08cf }
            r13 = r4
            r48 = 0
            r49 = r13
            r50 = 0
            r51 = r49
            r52 = 0
            r53 = r2
            r54 = r7
            r7 = 1
            r2 = r63
            if (r2 != r7) goto L_0x06e3
            r7 = r60
            r56 = r8
            r55 = r10
            r8 = 0
            goto L_0x0720
        L_0x06e3:
            r7 = r60
            if (r7 != 0) goto L_0x06ef
            if (r2 != 0) goto L_0x06ef
            r56 = r8
            r55 = r10
            r8 = 0
            goto L_0x0720
        L_0x06ef:
            r55 = 0
            if (r2 < 0) goto L_0x06fa
            r56 = r8
            r8 = 5
            if (r2 >= r8) goto L_0x06fc
            r8 = 1
            goto L_0x06fd
        L_0x06fa:
            r56 = r8
        L_0x06fc:
            r8 = 0
        L_0x06fd:
            if (r8 != 0) goto L_0x0703
            r55 = r10
            r8 = 0
            goto L_0x0720
        L_0x0703:
            r8 = -1
            if (r7 <= r8) goto L_0x070d
            r8 = 4
            if (r7 < r8) goto L_0x070a
            goto L_0x070d
        L_0x070a:
            r55 = r10
            goto L_0x071f
        L_0x070d:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x07c4, Error -> 0x08c3 }
            r55 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            boolean r8 = r8.containsKey(r10)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            if (r8 != 0) goto L_0x071f
            r8 = 0
            goto L_0x0720
        L_0x071f:
            r8 = 1
        L_0x0720:
            if (r8 != 0) goto L_0x0734
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r51 = r13
            r10 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r8.<init>(r13, r10, r12)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r52 = r12
            goto L_0x07ad
        L_0x0730:
            r0 = move-exception
        L_0x0731:
            r8 = r0
            goto L_0x07e4
        L_0x0734:
            r51 = r13
            r8 = r49
            r10 = 0
            switch(r7) {
                case 0: goto L_0x0768;
                case 1: goto L_0x075b;
                case 2: goto L_0x074e;
                case 3: goto L_0x0741;
                default: goto L_0x073c;
            }     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
        L_0x073c:
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            goto L_0x0775
        L_0x0741:
            java.lang.Float[] r13 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r52 = r8
            goto L_0x07a0
        L_0x074e:
            java.lang.Float[] r13 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r52 = r8
            goto L_0x07a0
        L_0x075b:
            java.lang.Float[] r13 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r52 = r8
            goto L_0x07a0
        L_0x0768:
            java.lang.Float[] r13 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r13 = r13[r2]     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r13 = r13.floatValue()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r52 = r8
            goto L_0x07a0
        L_0x0775:
            r52 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            boolean r8 = r13.containsKey(r8)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            if (r8 == 0) goto L_0x079e
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            java.lang.Object r8 = r8.get(r13)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            java.lang.Float[] r8 = (java.lang.Float[]) r8     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            if (r8 == 0) goto L_0x079b
            r13 = 0
            r57 = r8[r2]     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r57 = r57.floatValue()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r13 = r57
            goto L_0x07a0
        L_0x079b:
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x07a0
        L_0x079e:
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x07a0:
            r8 = r13
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r10 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            float r13 = r12 * r8
            r52 = r12
            r12 = 1
            r10.<init>(r12, r8, r13)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r8 = r10
        L_0x07ad:
            r10 = 0
            boolean r12 = r8.isScaledRequired()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            if (r12 != 0) goto L_0x07b8
            r12 = r52
            goto L_0x07bc
        L_0x07b8:
            float r12 = r8.getScaledSize()     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
        L_0x07bc:
            r6.setCornerRadius(r12)     // Catch:{ Exception -> 0x0730, Error -> 0x08c3 }
            r12 = r36
            goto L_0x0812
        L_0x07c4:
            r0 = move-exception
            r55 = r10
            goto L_0x0731
        L_0x07c9:
            r53 = r2
            r54 = r7
            r56 = r8
            r55 = r10
            r7 = r60
            r2 = r63
            r12 = r36
            goto L_0x0812
        L_0x07d8:
            r0 = move-exception
            r53 = r2
            r54 = r7
            r55 = r10
            r7 = r60
            r2 = r63
            r8 = r0
        L_0x07e4:
            r10 = r4
            r12 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r13 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            boolean r13 = r13.isDebug()     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            if (r13 == 0) goto L_0x0810
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            r10.<init>()     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            r12 = r36
            java.lang.StringBuilder r10 = r10.append(r12)     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            android.util.Log.d(r9, r10)     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            r8.printStackTrace()     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            goto L_0x0812
        L_0x0810:
            r12 = r36
        L_0x0812:
            goto L_0x081d
        L_0x0813:
            r7 = r60
            r53 = r2
            r55 = r10
            r12 = r36
            r2 = r63
        L_0x081d:
            int r1 = r1 + 1
            r7 = r64
            r36 = r12
            r2 = r41
            r4 = r42
            r12 = r43
            r6 = r44
            r8 = r45
            r13 = r47
            r10 = r55
            goto L_0x0564
        L_0x0834:
            r0 = move-exception
            r7 = r60
            r2 = r63
            goto L_0x085d
        L_0x083a:
            r0 = move-exception
            r7 = r60
            r2 = r63
            r44 = r6
            r43 = r12
            r47 = r13
        L_0x0845:
            r1 = r0
            goto L_0x0893
        L_0x0847:
            r41 = r2
            r42 = r4
            r44 = r6
            r64 = r7
            r45 = r8
            r43 = r12
            r47 = r13
            r7 = r60
            r2 = r63
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x085c, Error -> 0x08c3 }
            goto L_0x086f
        L_0x085c:
            r0 = move-exception
        L_0x085d:
            r1 = r0
            goto L_0x0893
        L_0x085f:
            r7 = r60
            r38 = r1
            r41 = r2
            r42 = r4
            r44 = r6
            r43 = r12
            r47 = r13
            r2 = r63
        L_0x086f:
            goto L_0x08a3
        L_0x0870:
            r0 = move-exception
            r7 = r60
            r41 = r2
            r42 = r4
            r44 = r6
            r43 = r12
            r47 = r13
            r2 = r63
            r1 = r0
            goto L_0x0893
        L_0x0881:
            r0 = move-exception
            r7 = r60
            r37 = r1
            r41 = r2
            r42 = r4
            r44 = r6
            r43 = r12
            r47 = r13
            r2 = r63
            r1 = r0
        L_0x0893:
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r5 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r6 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            boolean r6 = r6.isDebug()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            if (r6 == 0) goto L_0x08a3
            r1.printStackTrace()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x08a3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x08b5
        L_0x08a9:
            r7 = r60
            r37 = r1
            r41 = r2
            r43 = r12
            r47 = r13
            r2 = r63
        L_0x08b5:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r11 = r14
        L_0x08b9:
            goto L_0x0ddb
        L_0x08bf:
            r0 = move-exception
            r1 = r0
            goto L_0x0e06
        L_0x08c3:
            r0 = move-exception
            r1 = r0
            goto L_0x0e23
        L_0x08c7:
            r0 = move-exception
            r7 = r60
            r2 = r63
            r1 = r0
            goto L_0x0e06
        L_0x08cf:
            r0 = move-exception
            r7 = r60
            r2 = r63
            r1 = r0
            goto L_0x0e23
        L_0x08d7:
            r0 = move-exception
            r7 = r1
        L_0x08d9:
            r1 = r0
            r46 = r6
            goto L_0x0e06
        L_0x08de:
            r0 = move-exception
            r7 = r1
        L_0x08e0:
            r1 = r0
            r46 = r6
            goto L_0x0e23
        L_0x08e5:
            r0 = move-exception
            r7 = r1
            r32 = r8
            r1 = r0
            r46 = r6
            goto L_0x0e06
        L_0x08ee:
            r0 = move-exception
            r7 = r1
            r32 = r8
            r1 = r0
            r46 = r6
            goto L_0x0e23
        L_0x08f7:
            r0 = move-exception
            r35 = r7
            r32 = r8
            r7 = r1
            r1 = r0
            r46 = r6
            goto L_0x0df0
        L_0x0902:
            r0 = move-exception
            r35 = r7
            r32 = r8
            r7 = r1
            r1 = r0
            r46 = r6
            goto L_0x0df9
        L_0x090d:
            r46 = r6
            r35 = r7
            r32 = r8
            r12 = r10
            r7 = r1
            r1 = r46
            boolean r4 = r1 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            if (r4 == 0) goto L_0x0ac3
            r4 = r1
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r6 = 0
            com.baidu.searchbox.config.FontSizeHelper r8 = INSTANCE     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r10 = r1
            android.graphics.drawable.GradientDrawable r10 = (android.graphics.drawable.GradientDrawable) r10     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r13 = 0
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0a7f, Error -> 0x0abd }
            r64 = r4
            r4 = 24
            if (r14 < r4) goto L_0x093d
            float r4 = r10.getCornerRadius()     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            goto L_0x0945
        L_0x0937:
            r0 = move-exception
            r4 = r0
            r21 = r6
            goto L_0x0a85
        L_0x093d:
            android.graphics.drawable.Drawable$ConstantState r4 = r10.getConstantState()     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            java.lang.Object r4 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r4, r11)     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
        L_0x0945:
            r11 = r8
            r14 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r17 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            boolean r17 = r17.isDebug()     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            if (r17 == 0) goto L_0x0970
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            r11.<init>()     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.StringBuilder r11 = r11.append(r15)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.StringBuilder r11 = r11.append(r14)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.StringBuilder r5 = r11.append(r5)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.StringBuilder r5 = r5.append(r4)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
            android.util.Log.d(r9, r5)     // Catch:{ Exception -> 0x0937, Error -> 0x0abd }
        L_0x0970:
            boolean r5 = r4 instanceof java.lang.Float     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            if (r5 == 0) goto L_0x0a75
            r5 = r4
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            r11 = 0
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x0a75
            r5 = r4
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            float r5 = r5.floatValue()     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            r11 = r8
            r14 = 0
            r16 = r11
            r17 = 0
            r18 = r16
            r19 = 0
            r20 = r4
            r4 = 1
            if (r2 != r4) goto L_0x099b
            r21 = r6
            r4 = 0
            goto L_0x09d3
        L_0x099b:
            if (r7 != 0) goto L_0x09a3
            if (r2 != 0) goto L_0x09a3
            r21 = r6
            r4 = 0
            goto L_0x09d3
        L_0x09a3:
            r4 = 0
            if (r2 < 0) goto L_0x09ad
            r21 = r4
            r4 = 5
            if (r2 >= r4) goto L_0x09af
            r4 = 1
            goto L_0x09b0
        L_0x09ad:
            r21 = r4
        L_0x09af:
            r4 = 0
        L_0x09b0:
            if (r4 != 0) goto L_0x09b6
            r21 = r6
            r4 = 0
            goto L_0x09d3
        L_0x09b6:
            r4 = -1
            if (r7 <= r4) goto L_0x09c0
            r4 = 4
            if (r7 < r4) goto L_0x09bd
            goto L_0x09c0
        L_0x09bd:
            r21 = r6
            goto L_0x09d2
        L_0x09c0:
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Exception -> 0x0a7a, Error -> 0x0abd }
            r21 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            boolean r4 = r4.containsKey(r6)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            if (r4 != 0) goto L_0x09d2
            r4 = 0
            goto L_0x09d3
        L_0x09d2:
            r4 = 1
        L_0x09d3:
            if (r4 != 0) goto L_0x09e7
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r66 = r11
            r6 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r4.<init>(r11, r6, r5)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r18 = r5
            goto L_0x0a60
        L_0x09e3:
            r0 = move-exception
            r4 = r0
            goto L_0x0a85
        L_0x09e7:
            r66 = r11
            r4 = r16
            r6 = 0
            switch(r7) {
                case 0: goto L_0x0a1b;
                case 1: goto L_0x0a0e;
                case 2: goto L_0x0a01;
                case 3: goto L_0x09f4;
                default: goto L_0x09ef;
            }     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
        L_0x09ef:
            java.util.HashMap r11 = mCustomerRatios     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            goto L_0x0a28
        L_0x09f4:
            java.lang.Float[] r11 = SCALED_RATIO_T     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r11 = r11[r2]     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r18 = r4
            goto L_0x0a53
        L_0x0a01:
            java.lang.Float[] r11 = SCALED_RATIO_H     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r11 = r11[r2]     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r18 = r4
            goto L_0x0a53
        L_0x0a0e:
            java.lang.Float[] r11 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r11 = r11[r2]     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r18 = r4
            goto L_0x0a53
        L_0x0a1b:
            java.lang.Float[] r11 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r11 = r11[r2]     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r11 = r11.floatValue()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r18 = r4
            goto L_0x0a53
        L_0x0a28:
            r18 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            boolean r4 = r11.containsKey(r4)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            if (r4 == 0) goto L_0x0a51
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            java.lang.Object r4 = r4.get(r11)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            java.lang.Float[] r4 = (java.lang.Float[]) r4     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            if (r4 == 0) goto L_0x0a4e
            r11 = 0
            r19 = r4[r2]     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r19 = r19.floatValue()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r11 = r19
            goto L_0x0a53
        L_0x0a4e:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0a53
        L_0x0a51:
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x0a53:
            r4 = r11
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            float r11 = r5 * r4
            r18 = r5
            r5 = 1
            r6.<init>(r5, r4, r11)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            r4 = r6
        L_0x0a60:
            r5 = 0
            boolean r6 = r4.isScaledRequired()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            if (r6 != 0) goto L_0x0a6b
            r6 = r18
            goto L_0x0a6f
        L_0x0a6b:
            float r6 = r4.getScaledSize()     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
        L_0x0a6f:
            r10.setCornerRadius(r6)     // Catch:{ Exception -> 0x09e3, Error -> 0x0abd }
            goto L_0x0aae
        L_0x0a75:
            r20 = r4
            r21 = r6
            goto L_0x0aae
        L_0x0a7a:
            r0 = move-exception
            r21 = r6
            r4 = r0
            goto L_0x0a85
        L_0x0a7f:
            r0 = move-exception
            r64 = r4
            r21 = r6
            r4 = r0
        L_0x0a85:
            r5 = r8
            r6 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r11 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            boolean r11 = r11.isDebug()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            if (r11 == 0) goto L_0x0aae
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r5.<init>()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.StringBuilder r5 = r5.append(r15)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.String r5 = r5.toString()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            android.util.Log.d(r9, r5)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r4.printStackTrace()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
        L_0x0aae:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r11 = r1
            r46 = r11
            goto L_0x0ddb
        L_0x0ab7:
            r0 = move-exception
            r46 = r1
            r1 = r0
            goto L_0x0e06
        L_0x0abd:
            r0 = move-exception
            r46 = r1
            r1 = r0
            goto L_0x0e23
        L_0x0ac3:
            boolean r4 = r1 instanceof android.graphics.drawable.NinePatchDrawable     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            if (r4 == 0) goto L_0x0c32
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r5 = r1
            android.graphics.drawable.NinePatchDrawable r5 = (android.graphics.drawable.NinePatchDrawable) r5     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r6 = r4
            r8 = 0
            r10 = r5
            r11 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = r4
            r14 = 0
            r15 = r13
            r16 = 0
            r17 = r15
            r18 = 0
            r64 = r6
            r6 = 1
            if (r2 != r6) goto L_0x0ae5
            r19 = r8
            r6 = 0
            goto L_0x0b1d
        L_0x0ae5:
            if (r7 != 0) goto L_0x0aed
            if (r2 != 0) goto L_0x0aed
            r19 = r8
            r6 = 0
            goto L_0x0b1d
        L_0x0aed:
            r6 = 0
            if (r2 < 0) goto L_0x0af7
            r19 = r6
            r6 = 5
            if (r2 >= r6) goto L_0x0af9
            r6 = 1
            goto L_0x0afa
        L_0x0af7:
            r19 = r6
        L_0x0af9:
            r6 = 0
        L_0x0afa:
            if (r6 != 0) goto L_0x0b00
            r19 = r8
            r6 = 0
            goto L_0x0b1d
        L_0x0b00:
            r6 = -1
            if (r7 <= r6) goto L_0x0b0a
            r6 = 4
            if (r7 < r6) goto L_0x0b07
            goto L_0x0b0a
        L_0x0b07:
            r19 = r8
            goto L_0x0b1c
        L_0x0b0a:
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0c11, Error -> 0x0abd }
            r19 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0b2d, Error -> 0x0abd }
            boolean r6 = r6.containsKey(r8)     // Catch:{ Exception -> 0x0b2d, Error -> 0x0abd }
            if (r6 != 0) goto L_0x0b1c
            r6 = 0
            goto L_0x0b1d
        L_0x0b1c:
            r6 = 1
        L_0x0b1d:
            if (r6 != 0) goto L_0x0b33
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b2d, Error -> 0x0abd }
            r65 = r11
            r8 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r6.<init>(r11, r8, r12)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r66 = r12
            goto L_0x0bb1
        L_0x0b2d:
            r0 = move-exception
            r65 = r11
            r4 = r0
            goto L_0x0c17
        L_0x0b33:
            r65 = r11
            r8 = 1065353216(0x3f800000, float:1.0)
            r6 = r15
            r11 = 0
            switch(r7) {
                case 0: goto L_0x0b68;
                case 1: goto L_0x0b5b;
                case 2: goto L_0x0b4e;
                case 3: goto L_0x0b41;
                default: goto L_0x0b3c;
            }     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
        L_0x0b3c:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            goto L_0x0b79
        L_0x0b41:
            java.lang.Float[] r8 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r8 = r8[r2]     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r66 = r6
            goto L_0x0ba4
        L_0x0b4e:
            java.lang.Float[] r8 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r8 = r8[r2]     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r66 = r6
            goto L_0x0ba4
        L_0x0b5b:
            java.lang.Float[] r8 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r8 = r8[r2]     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r66 = r6
            goto L_0x0ba4
        L_0x0b68:
            java.lang.Float[] r8 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r8 = r8[r2]     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r66 = r6
            goto L_0x0ba4
        L_0x0b75:
            r0 = move-exception
            r4 = r0
            goto L_0x0c17
        L_0x0b79:
            r66 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            boolean r6 = r8.containsKey(r6)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            if (r6 == 0) goto L_0x0ba2
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r60)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.Object r6 = r6.get(r8)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.Float[] r6 = (java.lang.Float[]) r6     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            if (r6 == 0) goto L_0x0b9f
            r8 = 0
            r17 = r6[r2]     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r17 = r17.floatValue()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r8 = r17
            goto L_0x0ba4
        L_0x0b9f:
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0ba4
        L_0x0ba2:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0ba4:
            r6 = r8
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r11 = r12 * r6
            r66 = r12
            r12 = 1
            r8.<init>(r12, r6, r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r6 = r8
        L_0x0bb1:
            r8 = 0
            boolean r11 = r6.isScaledRequired()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            if (r11 != 0) goto L_0x0bbc
            r11 = r66
            goto L_0x0bc0
        L_0x0bbc:
            float r11 = r6.getScaledSize()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
        L_0x0bc0:
            r6 = r11
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            android.util.DisplayMetrics r8 = r8.getDisplayMetrics()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            int r8 = r8.densityDpi     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r11 = (float) r8     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r11 = r11 * r6
            int r11 = (int) r11     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r10.setTargetDensity(r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r11 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r12 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            boolean r12 = r12.isDebug()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            if (r12 == 0) goto L_0x0c27
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            r4.<init>()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.String r11 = "scaled: "
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.String r11 = ", displayMetrics: "
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.String r11 = ", result: "
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r11 = (float) r8     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            float r11 = r11 * r6
            java.lang.StringBuilder r4 = r4.append(r11)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            android.util.Log.d(r9, r4)     // Catch:{ Exception -> 0x0b75, Error -> 0x0abd }
            goto L_0x0c27
        L_0x0c11:
            r0 = move-exception
            r19 = r8
            r65 = r11
            r4 = r0
        L_0x0c17:
            com.baidu.searchbox.config.FontSizeHelper r6 = INSTANCE     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r8 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r9 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            boolean r9 = r9.isDebug()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            if (r9 == 0) goto L_0x0c27
            r4.printStackTrace()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
        L_0x0c27:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r11 = r5
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r46 = r1
            goto L_0x0ddb
        L_0x0c32:
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r5 = r4
            r6 = 0
            r8 = r5
            r9 = 0
            r10 = r1
            r11 = 0
            int r12 = r1.getIntrinsicWidth()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r12 = (float) r12     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            int r13 = r1.getIntrinsicHeight()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r13 = (float) r13     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r13 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r13)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r14 = r4
            r15 = 0
            r16 = r14
            r18 = 0
            r64 = r5
            r5 = 1
            if (r2 != r5) goto L_0x0c5d
            r65 = r6
            r5 = 0
            goto L_0x0c95
        L_0x0c5d:
            if (r7 != 0) goto L_0x0c65
            if (r2 != 0) goto L_0x0c65
            r65 = r6
            r5 = 0
            goto L_0x0c95
        L_0x0c65:
            r5 = 0
            if (r2 < 0) goto L_0x0c6f
            r65 = r5
            r5 = 5
            if (r2 >= r5) goto L_0x0c71
            r5 = 1
            goto L_0x0c72
        L_0x0c6f:
            r65 = r5
        L_0x0c71:
            r5 = 0
        L_0x0c72:
            if (r5 != 0) goto L_0x0c78
            r65 = r6
            r5 = 0
            goto L_0x0c95
        L_0x0c78:
            r5 = -1
            if (r7 <= r5) goto L_0x0c82
            r5 = 4
            if (r7 < r5) goto L_0x0c7f
            goto L_0x0c82
        L_0x0c7f:
            r65 = r6
            goto L_0x0c94
        L_0x0c82:
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r65 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            boolean r5 = r5.containsKey(r6)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            if (r5 != 0) goto L_0x0c94
            r5 = 0
            goto L_0x0c95
        L_0x0c94:
            r5 = 1
        L_0x0c95:
            if (r5 != 0) goto L_0x0c9f
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r5 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r6 = 0
            r5.<init>(r6, r12, r13)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            goto L_0x0d28
        L_0x0c9f:
            r5 = r14
            r6 = 0
            switch(r7) {
                case 0: goto L_0x0cde;
                case 1: goto L_0x0ccd;
                case 2: goto L_0x0cbc;
                case 3: goto L_0x0cab;
                default: goto L_0x0ca4;
            }
        L_0x0ca4:
            r16 = r5
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            goto L_0x0cef
        L_0x0cab:
            java.lang.Float[] r16 = SCALED_RATIO_T     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r16 = r16[r2]     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r18 = r6
            r17 = r16
            r16 = r5
            goto L_0x0d18
        L_0x0cbc:
            java.lang.Float[] r16 = SCALED_RATIO_H     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r16 = r16[r2]     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r18 = r6
            r17 = r16
            r16 = r5
            goto L_0x0d18
        L_0x0ccd:
            java.lang.Float[] r16 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r16 = r16[r2]     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r18 = r6
            r17 = r16
            r16 = r5
            goto L_0x0d18
        L_0x0cde:
            java.lang.Float[] r16 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r16 = r16[r2]     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            float r16 = r16.floatValue()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            r18 = r6
            r17 = r16
            r16 = r5
            goto L_0x0d18
        L_0x0cef:
            r18 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            boolean r5 = r5.containsKey(r6)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            if (r5 == 0) goto L_0x0d16
            java.util.HashMap r5 = mCustomerRatios     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r60)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            java.lang.Float[] r5 = (java.lang.Float[]) r5     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            if (r5 == 0) goto L_0x0d13
            r6 = 0
            r17 = r5[r2]     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            float r17 = r17.floatValue()     // Catch:{ Error -> 0x0abd, Exception -> 0x0ab7 }
            goto L_0x0d18
        L_0x0d13:
            r17 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0d18
        L_0x0d16:
            r17 = 1065353216(0x3f800000, float:1.0)
        L_0x0d18:
            r5 = r17
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r2 = r12 * r5
            float r7 = r13 * r5
            r16 = r5
            r5 = 1
            r6.<init>(r5, r2, r7)     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r5 = r6
        L_0x0d28:
            r2 = r5
            r5 = 0
            boolean r6 = r2.isScaledRequired()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            if (r6 != 0) goto L_0x0d38
            r46 = r1
            r16 = r2
            r19 = r5
            goto L_0x0dd7
        L_0x0d38:
            float r6 = r2.getScaledWidth()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            float r7 = r2.getScaledHeight()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r12 = r1
            r13 = 0
            r14 = 0
            int r15 = r12.getIntrinsicWidth()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            int r16 = r12.getIntrinsicHeight()     // Catch:{ Error -> 0x0de3, Exception -> 0x0dde }
            r17 = r16
            r46 = r1
            int r1 = r12.getOpacity()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r16 = r2
            r2 = -1
            if (r1 == r2) goto L_0x0d5c
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0d5e
        L_0x0d5c:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0d5e:
            r2 = r17
            r17 = r4
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r15, r2, r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r18 = r1
            java.lang.String r1 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r1 = r4
            android.graphics.Canvas r4 = new android.graphics.Canvas     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r4.<init>(r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r19 = r5
            r5 = 0
            r12.setBounds(r5, r5, r15, r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r12.draw(r4)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r2 = r6
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0d95;
                case 1: goto L_0x0d8d;
                case 2: goto L_0x0d88;
                default: goto L_0x0d83;
            }     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0d83:
            int r5 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0d9c
        L_0x0d88:
            int r5 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0d9c
        L_0x0d8d:
            double r14 = (double) r2     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            float r5 = (float) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            int r5 = (int) r5     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0d9c
        L_0x0d95:
            double r14 = (double) r2     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            float r5 = (float) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            int r5 = (int) r5     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0d9c:
            r2 = r7
            r4 = 0
            switch(r3) {
                case 0: goto L_0x0db4;
                case 1: goto L_0x0dac;
                case 2: goto L_0x0da7;
                default: goto L_0x0da2;
            }     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0da2:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0dbb
        L_0x0da7:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0dbb
        L_0x0dac:
            double r14 = (double) r2     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            float r14 = (float) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            int r14 = (int) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            goto L_0x0dbb
        L_0x0db4:
            double r14 = (double) r2     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            float r14 = (float) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            int r14 = (int) r14     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
        L_0x0dbb:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r5, r14, r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            java.lang.String r2 = "createScaledBitmap(\n    …       true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r2.<init>(r4, r1)     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Error -> 0x08c3, Exception -> 0x08bf }
            r1 = r2
        L_0x0dd7:
            r11 = r1
        L_0x0ddb:
            r5 = r11
            goto L_0x0e36
        L_0x0dde:
            r0 = move-exception
            r46 = r1
            r1 = r0
            goto L_0x0e06
        L_0x0de3:
            r0 = move-exception
            r46 = r1
            r1 = r0
            goto L_0x0e23
        L_0x0de8:
            r0 = move-exception
            r46 = r6
            r35 = r7
            r32 = r8
            r1 = r0
        L_0x0df0:
            goto L_0x0e06
        L_0x0df1:
            r0 = move-exception
            r46 = r6
            r35 = r7
            r32 = r8
            r1 = r0
        L_0x0df9:
            goto L_0x0e23
        L_0x0dfa:
            r0 = move-exception
            r26 = r4
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            r1 = r0
        L_0x0e06:
            r2 = r32
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r5 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r5.isDebug()
            if (r2 == 0) goto L_0x0e16
            r1.printStackTrace()
        L_0x0e16:
            goto L_0x0e34
        L_0x0e17:
            r0 = move-exception
            r26 = r4
            r46 = r6
            r35 = r7
            r32 = r8
            r27 = r9
            r1 = r0
        L_0x0e23:
            r2 = r32
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r5 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r5.isDebug()
            if (r2 == 0) goto L_0x0e33
            r1.printStackTrace()
        L_0x0e33:
        L_0x0e34:
            r5 = r61
        L_0x0e36:
            goto L_0x0e3c
        L_0x0e39:
            r26 = r4
            r5 = 0
        L_0x0e3c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledDrawableInner$default(com.baidu.searchbox.config.FontSizeHelper, int, android.graphics.drawable.Drawable, int, int, int, int, java.lang.Object):android.graphics.drawable.Drawable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r53v7, resolved type: com.baidu.searchbox.config.FontSizeHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v67, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r40v3, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v2, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v3, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: type inference failed for: r53v8 */
    /* JADX WARNING: type inference failed for: r6v38, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r53v19 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0350, code lost:
        r6 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        r35 = r14;
        r38 = r6;
        r12 = new com.baidu.searchbox.config.FontSizeHelper.Scaled2DSizeInfo(true, r14 * r6, r11 * r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0534, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0535, code lost:
        r11 = r1;
        r7 = r2;
        r24 = r5;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x053c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x053d, code lost:
        r11 = r1;
        r7 = r2;
        r24 = r5;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0615, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0616, code lost:
        r11 = r62;
        r7 = r65;
        r1 = r0;
        r57 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x061f, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r6, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r7, r1, r11, true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x0634, code lost:
        r11 = r62;
        r7 = r65;
        r48 = r6;
        r57 = r13;
        r53 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0640, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0641, code lost:
        r47 = r12;
        r11 = r62;
        r7 = r65;
        r1 = r0;
        r57 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x064c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x064d, code lost:
        r49 = r11;
        r47 = r12;
        r11 = r62;
        r7 = r65;
        r1 = r0;
        r57 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0678, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0679, code lost:
        r11 = r62;
        r48 = r6;
        r57 = r13;
        r53 = r14;
        r7 = r65;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x06bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x06c0, code lost:
        r11 = r62;
        r6 = r0;
        r57 = r13;
        r53 = r14;
        r7 = r65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06ce, code lost:
        r48 = r6;
        r11 = r62;
        r6 = r0;
        r57 = r13;
        r53 = r14;
        r7 = r65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x07a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x07a8, code lost:
        r6 = r0;
        r53 = r53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x07f8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x07f9, code lost:
        r57 = r13;
        r53 = r14;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x080c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x080d, code lost:
        r11 = r62;
        r57 = r13;
        r53 = r14;
        r7 = r65;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0819, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x081a, code lost:
        r11 = r62;
        r48 = r6;
        r57 = r13;
        r53 = r14;
        r7 = r65;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0833, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x086e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x086f, code lost:
        r11 = r62;
        r7 = r65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x0875, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0876, code lost:
        r11 = r62;
        r7 = r65;
        r57 = r13;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x088d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x088e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x089b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:436:0x089c, code lost:
        r7 = r2;
        r49 = r11;
        r47 = r12;
        r57 = r13;
        r11 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x08a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x08a7, code lost:
        r7 = r2;
        r49 = r11;
        r47 = r12;
        r57 = r13;
        r42 = r14;
        r11 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x08c1, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x08e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x08e8, code lost:
        r11 = r1;
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x093c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x093d, code lost:
        r20 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x09ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x09eb, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:540:0x0a7c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:541:0x0a7d, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:543:0x0a88, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:544:0x0a89, code lost:
        r20 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:545:0x0a8e, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x0a98, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0a9a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x0a9a, code lost:
        android.util.Log.d(TAG, "Version: " + android.os.Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:552:0x0ac0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:554:0x0ac6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:555:0x0ac7, code lost:
        r1 = r0;
        r24 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:594:0x0b35, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:595:0x0b36, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:603:0x0b7d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:604:0x0b7e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:620:0x0c19, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:621:0x0c1a, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:623:?, code lost:
        r3 = INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:624:0x0c2a, code lost:
        if (com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness().isDebug() != false) goto L_0x0c2c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:625:0x0c2c, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:731:0x0e39, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:468:0x092d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:472:0x0933] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:508:0x09c7] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:511:0x09cd] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:581:0x0b12] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:584:0x0b18] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:375:0x073d, B:592:0x0b2e] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x053c A[ExcHandler: Error (r0v43 'e' java.lang.Error A[CUSTOM_DECLARE]), PHI: r1 r2 
      PHI: (r1v106 int) = (r1v81 int), (r1v0 int), (r1v0 int), (r1v0 int), (r1v0 int) binds: [B:290:0x05b4, B:269:0x056e, B:270:?, B:174:0x038d, B:248:0x050e] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v64 int) = (r2v56 int), (r2v0 int), (r2v0 int), (r2v0 int), (r2v0 int) binds: [B:290:0x05b4, B:269:0x056e, B:270:?, B:174:0x038d, B:248:0x050e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:174:0x038d] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x072f  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0733  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0833 A[Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x086e A[Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }, ExcHandler: Error (e java.lang.Error), Splitter:B:283:0x059e] */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x08c1 A[Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x08e7 A[ExcHandler: Error (e java.lang.Error), Splitter:B:259:0x0546] */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x09b9  */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x09bd  */
    /* JADX WARNING: Removed duplicated region for block: B:549:0x0a9a A[Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0ac6 A[ExcHandler: Error (e java.lang.Error), PHI: r38 
      PHI: (r38v9 'this_$iv' com.baidu.searchbox.config.FontSizeHelper) = (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v12 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper), (r38v15 'this_$iv' com.baidu.searchbox.config.FontSizeHelper) binds: [B:688:0x0d53, B:689:?, B:662:0x0cb1, B:672:0x0cf1, B:655:0x0c9d, B:656:?, B:559:0x0ad0, B:560:?, B:622:0x0c1f, B:592:0x0b2e, B:581:0x0b12, B:584:0x0b18, B:465:0x0923, B:466:?, B:468:0x092d, B:546:0x0a90, B:469:?, B:482:0x0977, B:508:0x09c7, B:511:0x09cd, B:480:0x0959, B:481:?, B:476:0x0944, B:472:0x0933, B:439:0x08b4, B:321:0x065e, B:420:0x0829, B:386:0x0759, B:375:0x073d, B:378:0x0743, B:283:0x059e] A[DONT_GENERATE, DONT_INLINE], Splitter:B:375:0x073d] */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x0b04  */
    /* JADX WARNING: Removed duplicated region for block: B:576:0x0b08  */
    /* JADX WARNING: Removed duplicated region for block: B:625:0x0c2c A[Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:643:0x0c7a A[Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }] */
    /* JADX WARNING: Removed duplicated region for block: B:644:0x0c7e A[Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }] */
    /* JADX WARNING: Removed duplicated region for block: B:726:0x0e1a  */
    /* JADX WARNING: Removed duplicated region for block: B:731:0x0e39  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:439:0x08b4=Splitter:B:439:0x08b4, B:622:0x0c1f=Splitter:B:622:0x0c1f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:581:0x0b12=Splitter:B:581:0x0b12, B:439:0x08b4=Splitter:B:439:0x08b4, B:482:0x0977=Splitter:B:482:0x0977, B:508:0x09c7=Splitter:B:508:0x09c7, B:375:0x073d=Splitter:B:375:0x073d, B:622:0x0c1f=Splitter:B:622:0x0c1f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.drawable.Drawable getScaledDrawableInner(int r62, android.graphics.drawable.Drawable r63, int r64, int r65, int r66) {
        /*
            r61 = this;
            r1 = r62
            r2 = r65
            r3 = 0
            if (r63 == 0) goto L_0x0e42
            r5 = r63
            r6 = 0
            com.baidu.searchbox.config.FontSizeHelper r7 = INSTANCE
            r8 = 0
            r9 = 0
            boolean r10 = r5 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0e1e, Exception -> 0x0dff }
            r11 = 4
            r12 = 5
            r13 = -1
            r15 = 1
            if (r10 == 0) goto L_0x022a
            com.baidu.searchbox.config.FontSizeHelper r10 = INSTANCE     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            r16 = r5
            android.graphics.drawable.BitmapDrawable r16 = (android.graphics.drawable.BitmapDrawable) r16     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            r17 = r10
            r18 = 0
            r19 = r17
            r20 = 0
            r21 = r16
            android.graphics.drawable.Drawable r21 = (android.graphics.drawable.Drawable) r21     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            r22 = 0
            r23 = r16
            android.graphics.drawable.Drawable r23 = (android.graphics.drawable.Drawable) r23     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            int r14 = r23.getIntrinsicWidth()     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            float r14 = (float) r14     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            float r14 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r14)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            r23 = r16
            android.graphics.drawable.Drawable r23 = (android.graphics.drawable.Drawable) r23     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            int r4 = r23.getIntrinsicHeight()     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            float r4 = (float) r4     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            float r4 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r4)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            r23 = 0
            r26 = r10
            r27 = 0
            if (r2 != r15) goto L_0x0053
            r11 = 0
            goto L_0x007b
        L_0x0053:
            if (r1 != 0) goto L_0x0059
            if (r2 != 0) goto L_0x0059
            r11 = 0
            goto L_0x007b
        L_0x0059:
            r28 = 0
            if (r2 < 0) goto L_0x0061
            if (r2 >= r12) goto L_0x0061
            r12 = r15
            goto L_0x0062
        L_0x0061:
            r12 = 0
        L_0x0062:
            if (r12 != 0) goto L_0x0066
            r11 = 0
            goto L_0x007b
        L_0x0066:
            if (r1 <= r13) goto L_0x006a
            if (r1 < r11) goto L_0x007a
        L_0x006a:
            java.util.HashMap r11 = mCustomerRatios     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            boolean r11 = r11.containsKey(r12)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            if (r11 != 0) goto L_0x007a
            r11 = 0
            goto L_0x007b
        L_0x007a:
            r11 = r15
        L_0x007b:
            if (r11 != 0) goto L_0x00a7
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r11 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r12 = 0
            r11.<init>(r12, r14, r4)     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r27 = r3
            goto L_0x0115
        L_0x0087:
            r0 = move-exception
            r11 = r1
            r27 = r3
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x0097:
            r0 = move-exception
            r11 = r1
            r27 = r3
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x00a7:
            r11 = r10
            r12 = 0
            switch(r1) {
                case 0: goto L_0x00d2;
                case 1: goto L_0x00c7;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00b1;
                default: goto L_0x00ac;
            }
        L_0x00ac:
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            goto L_0x00dd
        L_0x00b1:
            java.lang.Float[] r13 = SCALED_RATIO_T     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r13 = r13[r2]     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            float r13 = r13.floatValue()     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            goto L_0x0106
        L_0x00bc:
            java.lang.Float[] r13 = SCALED_RATIO_H     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r13 = r13[r2]     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            float r13 = r13.floatValue()     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            goto L_0x0106
        L_0x00c7:
            java.lang.Float[] r13 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r13 = r13[r2]     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            float r13 = r13.floatValue()     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            goto L_0x0106
        L_0x00d2:
            java.lang.Float[] r13 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r13 = r13[r2]     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            float r13 = r13.floatValue()     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            goto L_0x0106
        L_0x00dd:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            boolean r13 = r13.containsKey(r15)     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            if (r13 == 0) goto L_0x0104
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            java.lang.Object r13 = r13.get(r15)     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            java.lang.Float[] r13 = (java.lang.Float[]) r13     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            if (r13 == 0) goto L_0x0101
            r15 = 0
            r24 = r13[r2]     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            float r24 = r24.floatValue()     // Catch:{ Error -> 0x0097, Exception -> 0x0087 }
            r13 = r24
            goto L_0x0106
        L_0x0101:
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0106
        L_0x0104:
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x0106:
            r11 = r13
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x021a, Exception -> 0x020a }
            float r13 = r14 * r11
            float r15 = r4 * r11
            r27 = r3
            r3 = 1
            r12.<init>(r3, r13, r15)     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            r11 = r12
        L_0x0115:
            r3 = r11
            r4 = 0
            boolean r10 = r3.isScaledRequired()     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            if (r10 != 0) goto L_0x0147
            r10 = r16
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            r24 = r3
            r25 = r4
            r23 = r8
            r28 = r9
            goto L_0x01dc
        L_0x012b:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x0139:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x0147:
            float r10 = r3.getScaledWidth()     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            float r11 = r3.getScaledHeight()     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            r12 = r16
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            android.graphics.drawable.BitmapDrawable r12 = (android.graphics.drawable.BitmapDrawable) r12     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            r13 = 0
            android.graphics.Bitmap r14 = r12.getBitmap()     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            r15 = r10
            r23 = 0
            switch(r66) {
                case 0: goto L_0x0182;
                case 1: goto L_0x0176;
                case 2: goto L_0x0169;
                default: goto L_0x0160;
            }     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
        L_0x0160:
            r24 = r3
            r25 = r4
            int r3 = kotlin.math.MathKt.roundToInt((float) r15)     // Catch:{ Error -> 0x01fc, Exception -> 0x01ee }
            goto L_0x018d
        L_0x0169:
            int r24 = kotlin.math.MathKt.roundToInt((float) r15)     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            r25 = r4
            r60 = r24
            r24 = r3
            r3 = r60
            goto L_0x018d
        L_0x0176:
            r24 = r3
            r25 = r4
            double r3 = (double) r15     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            float r3 = (float) r3     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            int r3 = (int) r3     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            goto L_0x018d
        L_0x0182:
            r24 = r3
            r25 = r4
            double r3 = (double) r15     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            double r3 = java.lang.Math.ceil(r3)     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            float r3 = (float) r3
            int r3 = (int) r3
        L_0x018d:
            r4 = r11
            r15 = 0
            switch(r66) {
                case 0: goto L_0x01b5;
                case 1: goto L_0x01a9;
                case 2: goto L_0x019c;
                default: goto L_0x0193;
            }
        L_0x0193:
            r23 = r8
            r28 = r9
            int r8 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            goto L_0x01c0
        L_0x019c:
            int r23 = kotlin.math.MathKt.roundToInt((float) r4)     // Catch:{ Error -> 0x0139, Exception -> 0x012b }
            r28 = r9
            r60 = r23
            r23 = r8
            r8 = r60
            goto L_0x01c0
        L_0x01a9:
            r23 = r8
            r28 = r9
            double r8 = (double) r4
            double r8 = java.lang.Math.floor(r8)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r8 = (float) r8     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            int r8 = (int) r8     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            goto L_0x01c0
        L_0x01b5:
            r23 = r8
            r28 = r9
            double r8 = (double) r4     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r8 = (float) r8     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            int r8 = (int) r8     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
        L_0x01c0:
            r4 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r14, r3, r8, r4)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            java.lang.String r4 = "createScaledBitmap(\n    …licy), true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            android.content.Context r8 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r4.<init>(r8, r3)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r10 = r4
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
        L_0x01dc:
            android.graphics.drawable.BitmapDrawable r10 = (android.graphics.drawable.BitmapDrawable) r10     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r7 = r2
            goto L_0x0dd5
        L_0x01ee:
            r0 = move-exception
            r23 = r8
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x01fc:
            r0 = move-exception
            r23 = r8
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x020a:
            r0 = move-exception
            r27 = r3
            r23 = r8
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x021a:
            r0 = move-exception
            r27 = r3
            r23 = r8
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x022a:
            r27 = r3
            r23 = r8
            r28 = r9
            boolean r3 = r5 instanceof android.graphics.drawable.StateListDrawable     // Catch:{ Error -> 0x0df4, Exception -> 0x0de9 }
            if (r3 == 0) goto L_0x0236
            r3 = 1
            goto L_0x0238
        L_0x0236:
            boolean r3 = r5 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x0df4, Exception -> 0x0de9 }
        L_0x0238:
            java.lang.String r4 = ", OriginalRadius is :"
            java.lang.String r9 = ", GradientDrawable ReflectionUtil Error"
            java.lang.String r10 = "mRadius"
            java.lang.String r15 = "Version: "
            java.lang.String r8 = "FontSizeHelper"
            if (r3 == 0) goto L_0x0918
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            r18 = r3
            r19 = 0
            r20 = r18
            r21 = 0
            r22 = r5
            r29 = 0
            int r14 = r5.getIntrinsicWidth()     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            float r14 = (float) r14     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            float r14 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r14)     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            int r11 = r5.getIntrinsicHeight()     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            float r11 = (float) r11     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            float r11 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r11)     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            r32 = r3
            r33 = 0
            r34 = r32
            r35 = 0
            r13 = 1
            if (r2 != r13) goto L_0x0273
            r12 = 0
            goto L_0x029c
        L_0x0273:
            if (r1 != 0) goto L_0x0279
            if (r2 != 0) goto L_0x0279
            r12 = 0
            goto L_0x029c
        L_0x0279:
            r13 = 0
            if (r2 < 0) goto L_0x0280
            if (r2 >= r12) goto L_0x0280
            r13 = 1
            goto L_0x0281
        L_0x0280:
            r13 = 0
        L_0x0281:
            if (r13 != 0) goto L_0x0285
            r12 = 0
            goto L_0x029c
        L_0x0285:
            r13 = -1
            if (r1 <= r13) goto L_0x028b
            r13 = 4
            if (r1 < r13) goto L_0x029b
        L_0x028b:
            java.util.HashMap r13 = mCustomerRatios     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            boolean r12 = r13.containsKey(r12)     // Catch:{ Error -> 0x090c, Exception -> 0x0900 }
            if (r12 != 0) goto L_0x029b
            r12 = 0
            goto L_0x029c
        L_0x029b:
            r12 = 1
        L_0x029c:
            if (r12 != 0) goto L_0x02c0
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r13 = 0
            r12.<init>(r13, r14, r11)     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r34 = r6
            goto L_0x0361
        L_0x02a8:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x02b4:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x02c0:
            r12 = r32
            r13 = 0
            switch(r1) {
                case 0: goto L_0x0302;
                case 1: goto L_0x02f1;
                case 2: goto L_0x02df;
                case 3: goto L_0x02cd;
                default: goto L_0x02c6;
            }
        L_0x02c6:
            r34 = r6
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            goto L_0x0313
        L_0x02cd:
            java.lang.Float[] r34 = SCALED_RATIO_T     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r34 = r34[r2]     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r34 = r34.floatValue()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r35 = r12
            r38 = r34
            r34 = r6
            goto L_0x0350
        L_0x02df:
            java.lang.Float[] r34 = SCALED_RATIO_H     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r34 = r34[r2]     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r34 = r34.floatValue()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r35 = r12
            r38 = r34
            r34 = r6
            goto L_0x0350
        L_0x02f1:
            java.lang.Float[] r34 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r34 = r34[r2]     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r34 = r34.floatValue()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r35 = r12
            r38 = r34
            r34 = r6
            goto L_0x0350
        L_0x0302:
            java.lang.Float[] r34 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r34 = r34[r2]     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            float r34 = r34.floatValue()     // Catch:{ Error -> 0x02b4, Exception -> 0x02a8 }
            r35 = r12
            r38 = r34
            r34 = r6
            goto L_0x0350
        L_0x0313:
            r35 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            boolean r6 = r6.containsKey(r12)     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            if (r6 == 0) goto L_0x034e
            java.util.HashMap r6 = mCustomerRatios     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            java.lang.Float[] r6 = (java.lang.Float[]) r6     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            if (r6 == 0) goto L_0x0337
            r12 = 0
            r38 = r6[r2]     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            float r38 = r38.floatValue()     // Catch:{ Error -> 0x0344, Exception -> 0x033a }
            goto L_0x0350
        L_0x0337:
            r38 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0350
        L_0x033a:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e0d
        L_0x0344:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r38 = r7
            r1 = r0
            r7 = r2
            goto L_0x0e2c
        L_0x034e:
            r38 = 1065353216(0x3f800000, float:1.0)
        L_0x0350:
            r6 = r38
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            float r13 = r14 * r6
            r35 = r14
            float r14 = r11 * r6
            r38 = r6
            r6 = 1
            r12.<init>(r6, r13, r14)     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
        L_0x0361:
            r6 = r12
            r11 = 0
            boolean r12 = r6.isScaledRequired()     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            if (r12 != 0) goto L_0x0374
            r10 = r5
            r33 = r6
            r38 = r7
            r35 = r11
            r11 = r1
            r7 = r2
            goto L_0x08db
        L_0x0374:
            float r12 = r6.getScaledWidth()     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            float r13 = r6.getScaledHeight()     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            r14 = r5
            r32 = 0
            r33 = r6
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x08f6, Exception -> 0x08ec }
            r35 = r11
            r11 = 23
            r38 = r7
            java.lang.String r7 = "getChildren"
            if (r6 > r11) goto L_0x0544
            boolean r6 = r5 instanceof android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            if (r6 == 0) goto L_0x0544
            r4 = r5
            r6 = 0
            android.graphics.drawable.LevelListDrawable r8 = new android.graphics.drawable.LevelListDrawable     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            r8.<init>()     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            r9 = r4
            r10 = 0
            android.graphics.drawable.Drawable$ConstantState r11 = r9.getConstantState()     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            if (r11 == 0) goto L_0x051d
            r15 = 0
            kotlin.Result$Companion r17 = kotlin.Result.Companion     // Catch:{ all -> 0x0500 }
            r17 = r9
            r24 = 0
            r30 = r3
            java.lang.Class r3 = r11.getClass()     // Catch:{ all -> 0x04f3 }
            r31 = r4
            r36 = r6
            r4 = 0
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x04ea }
            java.lang.reflect.Method r3 = r3.getMethod(r7, r6)     // Catch:{ all -> 0x04ea }
            r6 = 1
            r3.setAccessible(r6)     // Catch:{ all -> 0x04ea }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x04ea }
            java.lang.Object r4 = r3.invoke(r11, r6)     // Catch:{ all -> 0x04ea }
            boolean r6 = r4 instanceof java.lang.Object[]     // Catch:{ all -> 0x04ea }
            if (r6 == 0) goto L_0x03d3
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ all -> 0x03c9 }
            goto L_0x03d4
        L_0x03c9:
            r0 = move-exception
            r3 = r0
            r48 = r9
            r49 = r10
            r47 = r11
            goto L_0x050e
        L_0x03d3:
            r4 = 0
        L_0x03d4:
            if (r4 == 0) goto L_0x04da
            r6 = 0
            r7 = 0
            r37 = r3
            int r3 = r4.length     // Catch:{ all -> 0x04ea }
            r16 = r7
            r7 = 0
        L_0x03de:
            if (r7 >= r3) goto L_0x04cd
            r25 = r4[r7]     // Catch:{ all -> 0x04ea }
            int r39 = r16 + 1
            r40 = r25
            r41 = r16
            r16 = 0
            r42 = r3
            r3 = r40
            r40 = r4
            boolean r4 = r3 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x04ea }
            if (r4 == 0) goto L_0x04ae
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x04ea }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x04ea }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ all -> 0x04ea }
            int r4 = r4.densityDpi     // Catch:{ all -> 0x04ea }
            r43 = 160(0xa0, float:2.24E-43)
            int r44 = r4 / r43
            r45 = r44
            r44 = r3
            android.graphics.drawable.BitmapDrawable r44 = (android.graphics.drawable.BitmapDrawable) r44     // Catch:{ all -> 0x04ea }
            r46 = r3
            android.graphics.Bitmap r3 = r44.getBitmap()     // Catch:{ all -> 0x04ea }
            r44 = r4
            r4 = r45
            r45 = r6
            float r6 = (float) r4     // Catch:{ all -> 0x04ea }
            float r6 = r6 * r12
            float r6 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r6)     // Catch:{ all -> 0x04ea }
            r47 = 0
            switch(r66) {
                case 0: goto L_0x0445;
                case 1: goto L_0x0439;
                case 2: goto L_0x042c;
                default: goto L_0x0423;
            }
        L_0x0423:
            r48 = r9
            r49 = r10
            int r9 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ all -> 0x04a8 }
            goto L_0x0457
        L_0x042c:
            int r48 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ all -> 0x03c9 }
            r49 = r10
            r60 = r48
            r48 = r9
            r9 = r60
            goto L_0x0457
        L_0x0439:
            r48 = r9
            r49 = r10
            double r9 = (double) r6
            double r9 = java.lang.Math.floor(r9)     // Catch:{ all -> 0x0451 }
            float r9 = (float) r9     // Catch:{ all -> 0x0451 }
            int r9 = (int) r9     // Catch:{ all -> 0x0451 }
            goto L_0x0457
        L_0x0445:
            r48 = r9
            r49 = r10
            double r9 = (double) r6     // Catch:{ all -> 0x0451 }
            double r9 = java.lang.Math.ceil(r9)     // Catch:{ all -> 0x0451 }
            float r9 = (float) r9
            int r9 = (int) r9
            goto L_0x0457
        L_0x0451:
            r0 = move-exception
            r3 = r0
            r47 = r11
            goto L_0x050e
        L_0x0457:
            float r6 = (float) r4
            float r6 = r6 * r13
            float r6 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r6)     // Catch:{ all -> 0x04a8 }
            r10 = 0
            switch(r66) {
                case 0: goto L_0x0482;
                case 1: goto L_0x0476;
                case 2: goto L_0x046b;
                default: goto L_0x0462;
            }
        L_0x0462:
            r50 = r10
            r47 = r11
            int r10 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ all -> 0x04e7 }
            goto L_0x048d
        L_0x046b:
            int r47 = kotlin.math.MathKt.roundToInt((float) r6)     // Catch:{ all -> 0x0451 }
            r50 = r10
            r10 = r47
            r47 = r11
            goto L_0x048d
        L_0x0476:
            r50 = r10
            r47 = r11
            double r10 = (double) r6
            double r10 = java.lang.Math.floor(r10)     // Catch:{ all -> 0x04e7 }
            float r10 = (float) r10     // Catch:{ all -> 0x04e7 }
            int r10 = (int) r10     // Catch:{ all -> 0x04e7 }
            goto L_0x048d
        L_0x0482:
            r50 = r10
            r47 = r11
            double r10 = (double) r6     // Catch:{ all -> 0x04e7 }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ all -> 0x04e7 }
            float r10 = (float) r10     // Catch:{ all -> 0x04e7 }
            int r10 = (int) r10     // Catch:{ all -> 0x04e7 }
        L_0x048d:
            r6 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r9, r10, r6)     // Catch:{ all -> 0x04e7 }
            java.lang.String r6 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch:{ all -> 0x04e7 }
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x04e7 }
            r6.<init>(r3)     // Catch:{ all -> 0x04e7 }
            r9 = r6
            android.graphics.drawable.Drawable r9 = (android.graphics.drawable.Drawable) r9     // Catch:{ all -> 0x04e7 }
            r10 = r41
            r8.addLevel(r10, r10, r9)     // Catch:{ all -> 0x04e7 }
            goto L_0x04ba
        L_0x04a8:
            r0 = move-exception
            r47 = r11
            r3 = r0
            goto L_0x050e
        L_0x04ae:
            r46 = r3
            r45 = r6
            r48 = r9
            r49 = r10
            r47 = r11
            r10 = r41
        L_0x04ba:
            int r7 = r7 + 1
            r16 = r39
            r4 = r40
            r3 = r42
            r6 = r45
            r11 = r47
            r9 = r48
            r10 = r49
            goto L_0x03de
        L_0x04cd:
            r40 = r4
            r45 = r6
            r48 = r9
            r49 = r10
            r47 = r11
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x04e7 }
            goto L_0x04e3
        L_0x04da:
            r37 = r3
            r48 = r9
            r49 = r10
            r47 = r11
            r4 = 0
        L_0x04e3:
            kotlin.Result.m8971constructorimpl(r4)     // Catch:{ all -> 0x04e7 }
            goto L_0x0517
        L_0x04e7:
            r0 = move-exception
            r3 = r0
            goto L_0x050e
        L_0x04ea:
            r0 = move-exception
            r48 = r9
            r49 = r10
            r47 = r11
            r3 = r0
            goto L_0x050e
        L_0x04f3:
            r0 = move-exception
            r31 = r4
            r36 = r6
            r48 = r9
            r49 = r10
            r47 = r11
            r3 = r0
            goto L_0x050e
        L_0x0500:
            r0 = move-exception
            r30 = r3
            r31 = r4
            r36 = r6
            r48 = r9
            r49 = r10
            r47 = r11
            r3 = r0
        L_0x050e:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            kotlin.Result.m8971constructorimpl(r3)     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
        L_0x0517:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            goto L_0x0527
        L_0x051d:
            r30 = r3
            r31 = r4
            r36 = r6
            r48 = r9
            r49 = r10
        L_0x0527:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            r10 = r8
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Error -> 0x053c, Exception -> 0x0534 }
            r11 = r1
            r7 = r2
            r24 = r5
            goto L_0x0dd5
        L_0x0534:
            r0 = move-exception
            r11 = r1
            r7 = r2
            r24 = r5
            r1 = r0
            goto L_0x0e0d
        L_0x053c:
            r0 = move-exception
            r11 = r1
            r7 = r2
            r24 = r5
            r1 = r0
            goto L_0x0e2c
        L_0x0544:
            r3 = r14
            r6 = 0
            android.graphics.drawable.Drawable$ConstantState r11 = r3.getConstantState()     // Catch:{ Error -> 0x08e7, Exception -> 0x08e2 }
            if (r11 == 0) goto L_0x08ca
            r39 = 0
            r40 = r3
            java.lang.Class r3 = r11.getClass()     // Catch:{ Exception -> 0x08a6, Error -> 0x08e7 }
            r41 = r6
            r42 = r14
            r6 = 0
            java.lang.Class[] r14 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            java.lang.reflect.Method r3 = r3.getMethod(r7, r14)     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            r7 = 1
            r3.setAccessible(r7)     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            java.lang.Object r6 = r3.invoke(r11, r7)     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            boolean r7 = r6 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            if (r7 == 0) goto L_0x057f
            java.lang.Object[] r6 = (java.lang.Object[]) r6     // Catch:{ Exception -> 0x0573, Error -> 0x053c }
            r16 = r6
            goto L_0x0581
        L_0x0573:
            r0 = move-exception
            r7 = r2
            r49 = r11
            r47 = r12
            r57 = r13
            r11 = r1
            r1 = r0
            goto L_0x08b4
        L_0x057f:
            r16 = 0
        L_0x0581:
            if (r16 == 0) goto L_0x0890
            r6 = r16
            r7 = 0
            int r14 = r6.length     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            r43 = r3
            r3 = 0
        L_0x058a:
            if (r3 >= r14) goto L_0x087e
            r16 = r6[r3]     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            r44 = r16
            r45 = 0
            r46 = r6
            r6 = r44
            r44 = r7
            boolean r7 = r6 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x089b, Error -> 0x08e7 }
            if (r7 == 0) goto L_0x065a
            r7 = r6
            android.graphics.drawable.BitmapDrawable r7 = (android.graphics.drawable.BitmapDrawable) r7     // Catch:{ Exception -> 0x064c, Error -> 0x086e }
            android.graphics.Bitmap r7 = r7.getBitmap()     // Catch:{ Exception -> 0x064c, Error -> 0x086e }
            r47 = r12
            r48 = 0
            switch(r66) {
                case 0: goto L_0x05cb;
                case 1: goto L_0x05bf;
                case 2: goto L_0x05b4;
                default: goto L_0x05ab;
            }
        L_0x05ab:
            r49 = r11
            r11 = r47
            int r1 = kotlin.math.MathKt.roundToInt((float) r11)     // Catch:{ Exception -> 0x0640, Error -> 0x086e }
            goto L_0x05e3
        L_0x05b4:
            int r49 = kotlin.math.MathKt.roundToInt((float) r47)     // Catch:{ Exception -> 0x0573, Error -> 0x053c }
            r1 = r49
            r49 = r11
            r11 = r47
            goto L_0x05e3
        L_0x05bf:
            r49 = r11
            r11 = r47
            double r1 = (double) r11
            double r1 = java.lang.Math.floor(r1)     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            float r1 = (float) r1     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            int r1 = (int) r1     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            goto L_0x05e3
        L_0x05cb:
            r49 = r11
            r11 = r47
            double r1 = (double) r11     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            double r1 = java.lang.Math.ceil(r1)     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            float r1 = (float) r1
            int r1 = (int) r1
            goto L_0x05e3
        L_0x05d7:
            r0 = move-exception
            r11 = r62
            r7 = r65
            r1 = r0
            r47 = r12
            r57 = r13
            goto L_0x08b4
        L_0x05e3:
            r2 = r13
            r11 = 0
            switch(r66) {
                case 0: goto L_0x0609;
                case 1: goto L_0x05fd;
                case 2: goto L_0x05f2;
                default: goto L_0x05e9;
            }
        L_0x05e9:
            r48 = r11
            r47 = r12
            int r11 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            goto L_0x061f
        L_0x05f2:
            int r47 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Exception -> 0x05d7, Error -> 0x086e }
            r48 = r11
            r11 = r47
            r47 = r12
            goto L_0x061f
        L_0x05fd:
            r48 = r11
            r47 = r12
            double r11 = (double) r2
            double r11 = java.lang.Math.floor(r11)     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            float r11 = (float) r11     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            goto L_0x061f
        L_0x0609:
            r48 = r11
            r47 = r12
            double r11 = (double) r2     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            float r11 = (float) r11     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            goto L_0x061f
        L_0x0615:
            r0 = move-exception
            r11 = r62
            r7 = r65
            r1 = r0
            r57 = r13
            goto L_0x08b4
        L_0x061f:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r7, r1, r11, r2)     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            r7 = 0
            java.lang.String r11 = "setBitmap"
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            r2 = 0
            r12[r2] = r1     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r6, r11, r12)     // Catch:{ Exception -> 0x0615, Error -> 0x086e }
            r11 = r62
            r7 = r65
            r48 = r6
            r57 = r13
            r53 = r14
            goto L_0x085b
        L_0x0640:
            r0 = move-exception
            r47 = r12
            r11 = r62
            r7 = r65
            r1 = r0
            r57 = r13
            goto L_0x08b4
        L_0x064c:
            r0 = move-exception
            r49 = r11
            r47 = r12
            r11 = r62
            r7 = r65
            r1 = r0
            r57 = r13
            goto L_0x08b4
        L_0x065a:
            r49 = r11
            r47 = r12
            boolean r1 = r6 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x0875, Error -> 0x086e }
            if (r1 == 0) goto L_0x0851
            com.baidu.searchbox.config.FontSizeHelper r1 = INSTANCE     // Catch:{ Exception -> 0x0875, Error -> 0x086e }
            r2 = r6
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2     // Catch:{ Exception -> 0x0875, Error -> 0x086e }
            r7 = 0
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0819, Error -> 0x086e }
            r12 = 24
            if (r11 < r12) goto L_0x0688
            float r11 = r2.getCornerRadius()     // Catch:{ Exception -> 0x0678, Error -> 0x086e }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x0678, Error -> 0x086e }
            goto L_0x0690
        L_0x0678:
            r0 = move-exception
            r11 = r62
            r48 = r6
            r55 = r7
            r57 = r13
            r53 = r14
            r7 = r65
            r6 = r0
            goto L_0x0827
        L_0x0688:
            android.graphics.drawable.Drawable$ConstantState r11 = r2.getConstantState()     // Catch:{ Exception -> 0x0819, Error -> 0x086e }
            java.lang.Object r11 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r11, r10)     // Catch:{ Exception -> 0x0819, Error -> 0x086e }
        L_0x0690:
            r12 = r1
            r48 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r50 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0819, Error -> 0x086e }
            boolean r50 = r50.isDebug()     // Catch:{ Exception -> 0x0819, Error -> 0x086e }
            if (r50 == 0) goto L_0x06dd
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06cd, Error -> 0x086e }
            r12.<init>()     // Catch:{ Exception -> 0x06cd, Error -> 0x086e }
            java.lang.StringBuilder r12 = r12.append(r15)     // Catch:{ Exception -> 0x06cd, Error -> 0x086e }
            r48 = r6
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            java.lang.StringBuilder r6 = r12.append(r6)     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            java.lang.StringBuilder r6 = r6.append(r4)     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            java.lang.StringBuilder r6 = r6.append(r11)     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            android.util.Log.d(r8, r6)     // Catch:{ Exception -> 0x06bf, Error -> 0x086e }
            goto L_0x06df
        L_0x06bf:
            r0 = move-exception
            r11 = r62
            r6 = r0
            r55 = r7
            r57 = r13
            r53 = r14
            r7 = r65
            goto L_0x0827
        L_0x06cd:
            r0 = move-exception
            r48 = r6
            r11 = r62
            r6 = r0
            r55 = r7
            r57 = r13
            r53 = r14
            r7 = r65
            goto L_0x0827
        L_0x06dd:
            r48 = r6
        L_0x06df:
            boolean r6 = r11 instanceof java.lang.Float     // Catch:{ Exception -> 0x080c, Error -> 0x086e }
            if (r6 == 0) goto L_0x07ff
            r6 = r11
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ Exception -> 0x080c, Error -> 0x086e }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x080c, Error -> 0x086e }
            r12 = 0
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 <= 0) goto L_0x07ff
            r6 = r11
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ Exception -> 0x080c, Error -> 0x086e }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x080c, Error -> 0x086e }
            r12 = r1
            r50 = 0
            r51 = r12
            r52 = 0
            r53 = r51
            r54 = 0
            r55 = r7
            r56 = r11
            r11 = 1
            r7 = r65
            if (r7 != r11) goto L_0x0713
            r11 = r62
            r58 = r12
            r57 = r13
            r12 = 0
            goto L_0x0750
        L_0x0713:
            r11 = r62
            if (r11 != 0) goto L_0x071f
            if (r7 != 0) goto L_0x071f
            r58 = r12
            r57 = r13
            r12 = 0
            goto L_0x0750
        L_0x071f:
            r57 = 0
            if (r7 < 0) goto L_0x072a
            r58 = r12
            r12 = 5
            if (r7 >= r12) goto L_0x072c
            r12 = 1
            goto L_0x072d
        L_0x072a:
            r58 = r12
        L_0x072c:
            r12 = 0
        L_0x072d:
            if (r12 != 0) goto L_0x0733
            r57 = r13
            r12 = 0
            goto L_0x0750
        L_0x0733:
            r12 = -1
            if (r11 <= r12) goto L_0x073d
            r12 = 4
            if (r11 < r12) goto L_0x073a
            goto L_0x073d
        L_0x073a:
            r57 = r13
            goto L_0x074f
        L_0x073d:
            java.util.HashMap r12 = mCustomerRatios     // Catch:{ Exception -> 0x07f8, Error -> 0x0ac6 }
            r57 = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0760, Error -> 0x0ac6 }
            boolean r12 = r12.containsKey(r13)     // Catch:{ Exception -> 0x0760, Error -> 0x0ac6 }
            if (r12 != 0) goto L_0x074f
            r12 = 0
            goto L_0x0750
        L_0x074f:
            r12 = 1
        L_0x0750:
            if (r12 != 0) goto L_0x0766
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r12 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0760, Error -> 0x0ac6 }
            r53 = r14
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 0
            r12.<init>(r14, r13, r6)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r54 = r6
            goto L_0x07e3
        L_0x0760:
            r0 = move-exception
            r53 = r14
            r6 = r0
            goto L_0x0827
        L_0x0766:
            r53 = r14
            r12 = r51
            r13 = 0
            switch(r11) {
                case 0: goto L_0x079a;
                case 1: goto L_0x078d;
                case 2: goto L_0x0780;
                case 3: goto L_0x0773;
                default: goto L_0x076e;
            }     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
        L_0x076e:
            java.util.HashMap r14 = mCustomerRatios     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            goto L_0x07ab
        L_0x0773:
            java.lang.Float[] r14 = SCALED_RATIO_T     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r14 = r14[r7]     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r14 = r14.floatValue()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r54 = r12
            goto L_0x07d6
        L_0x0780:
            java.lang.Float[] r14 = SCALED_RATIO_H     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r14 = r14[r7]     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r14 = r14.floatValue()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r54 = r12
            goto L_0x07d6
        L_0x078d:
            java.lang.Float[] r14 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r14 = r14[r7]     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r14 = r14.floatValue()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r54 = r12
            goto L_0x07d6
        L_0x079a:
            java.lang.Float[] r14 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r14 = r14[r7]     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r14 = r14.floatValue()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r54 = r12
            goto L_0x07d6
        L_0x07a7:
            r0 = move-exception
            r6 = r0
            goto L_0x0827
        L_0x07ab:
            r54 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            boolean r12 = r14.containsKey(r12)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            if (r12 == 0) goto L_0x07d4
            java.util.HashMap r12 = mCustomerRatios     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            java.lang.Object r12 = r12.get(r14)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            java.lang.Float[] r12 = (java.lang.Float[]) r12     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            if (r12 == 0) goto L_0x07d1
            r14 = 0
            r59 = r12[r7]     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r59 = r59.floatValue()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r14 = r59
            goto L_0x07d6
        L_0x07d1:
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x07d6
        L_0x07d4:
            r14 = 1065353216(0x3f800000, float:1.0)
        L_0x07d6:
            r12 = r14
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r13 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            float r14 = r6 * r12
            r54 = r6
            r6 = 1
            r13.<init>(r6, r12, r14)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            r12 = r13
        L_0x07e3:
            r6 = r12
            r12 = 0
            boolean r13 = r6.isScaledRequired()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            if (r13 != 0) goto L_0x07ee
            r13 = r54
            goto L_0x07f2
        L_0x07ee:
            float r13 = r6.getScaledSize()     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
        L_0x07f2:
            r2.setCornerRadius(r13)     // Catch:{ Exception -> 0x07a7, Error -> 0x0ac6 }
            goto L_0x0850
        L_0x07f8:
            r0 = move-exception
            r57 = r13
            r53 = r14
            r6 = r0
            goto L_0x0827
        L_0x07ff:
            r55 = r7
            r56 = r11
            r57 = r13
            r53 = r14
            r11 = r62
            r7 = r65
            goto L_0x0850
        L_0x080c:
            r0 = move-exception
            r11 = r62
            r55 = r7
            r57 = r13
            r53 = r14
            r7 = r65
            r6 = r0
            goto L_0x0827
        L_0x0819:
            r0 = move-exception
            r11 = r62
            r48 = r6
            r55 = r7
            r57 = r13
            r53 = r14
            r7 = r65
            r6 = r0
        L_0x0827:
            r12 = r1
            r13 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r14 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            boolean r14 = r14.isDebug()     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            if (r14 == 0) goto L_0x0850
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            r12.<init>()     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            java.lang.StringBuilder r12 = r12.append(r15)     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            java.lang.StringBuilder r12 = r12.append(r9)     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            android.util.Log.d(r8, r12)     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            r6.printStackTrace()     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
        L_0x0850:
            goto L_0x085b
        L_0x0851:
            r11 = r62
            r7 = r65
            r48 = r6
            r57 = r13
            r53 = r14
        L_0x085b:
            int r3 = r3 + 1
            r2 = r7
            r1 = r11
            r7 = r44
            r6 = r46
            r12 = r47
            r11 = r49
            r14 = r53
            r13 = r57
            goto L_0x058a
        L_0x086e:
            r0 = move-exception
            r11 = r62
            r7 = r65
            goto L_0x0ac7
        L_0x0875:
            r0 = move-exception
            r11 = r62
            r7 = r65
            r57 = r13
            r1 = r0
            goto L_0x08b4
        L_0x087e:
            r46 = r6
            r44 = r7
            r49 = r11
            r47 = r12
            r57 = r13
            r11 = r1
            r7 = r2
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x088d, Error -> 0x0ac6 }
            goto L_0x089a
        L_0x088d:
            r0 = move-exception
            r1 = r0
            goto L_0x08b4
        L_0x0890:
            r7 = r2
            r43 = r3
            r49 = r11
            r47 = r12
            r57 = r13
            r11 = r1
        L_0x089a:
            goto L_0x08c4
        L_0x089b:
            r0 = move-exception
            r7 = r2
            r49 = r11
            r47 = r12
            r57 = r13
            r11 = r1
            r1 = r0
            goto L_0x08b4
        L_0x08a6:
            r0 = move-exception
            r7 = r2
            r41 = r6
            r49 = r11
            r47 = r12
            r57 = r13
            r42 = r14
            r11 = r1
            r1 = r0
        L_0x08b4:
            com.baidu.searchbox.config.FontSizeHelper r2 = INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            boolean r4 = r4.isDebug()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            if (r4 == 0) goto L_0x08c4
            r1.printStackTrace()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
        L_0x08c4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            goto L_0x08d6
        L_0x08ca:
            r11 = r1
            r7 = r2
            r40 = r3
            r41 = r6
            r47 = r12
            r57 = r13
            r42 = r14
        L_0x08d6:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r10 = r42
        L_0x08db:
            r24 = r5
            goto L_0x0dd5
        L_0x08e2:
            r0 = move-exception
            r11 = r1
            r7 = r2
            goto L_0x0ac1
        L_0x08e7:
            r0 = move-exception
            r11 = r1
            r7 = r2
            goto L_0x0ac7
        L_0x08ec:
            r0 = move-exception
            r11 = r1
            r38 = r7
            r7 = r2
            r1 = r0
            r24 = r5
            goto L_0x0e0d
        L_0x08f6:
            r0 = move-exception
            r11 = r1
            r38 = r7
            r7 = r2
            r1 = r0
            r24 = r5
            goto L_0x0e2c
        L_0x0900:
            r0 = move-exception
            r11 = r1
            r34 = r6
            r38 = r7
            r7 = r2
            r1 = r0
            r24 = r5
            goto L_0x0e0d
        L_0x090c:
            r0 = move-exception
            r11 = r1
            r34 = r6
            r38 = r7
            r7 = r2
            r1 = r0
            r24 = r5
            goto L_0x0e2c
        L_0x0918:
            r11 = r1
            r34 = r6
            r38 = r7
            r7 = r2
            boolean r1 = r5 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            if (r1 == 0) goto L_0x0acc
            r1 = r5
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r2 = 0
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r6 = r5
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r12 = 0
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            r14 = 24
            if (r13 < r14) goto L_0x0944
            float r10 = r6.getCornerRadius()     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.Float r10 = java.lang.Float.valueOf(r10)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            goto L_0x094c
        L_0x093c:
            r0 = move-exception
            r20 = r1
            r21 = r2
            r1 = r0
            goto L_0x0a8e
        L_0x0944:
            android.graphics.drawable.Drawable$ConstantState r13 = r6.getConstantState()     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            java.lang.Object r10 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r13, r10)     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
        L_0x094c:
            r13 = r3
            r14 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r16 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            boolean r16 = r16.isDebug()     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            if (r16 == 0) goto L_0x0977
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            r13.<init>()     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.StringBuilder r4 = r13.append(r4)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.StringBuilder r4 = r4.append(r10)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
            android.util.Log.d(r8, r4)     // Catch:{ Exception -> 0x093c, Error -> 0x0ac6 }
        L_0x0977:
            boolean r4 = r10 instanceof java.lang.Float     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            if (r4 == 0) goto L_0x0a81
            r4 = r10
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            r13 = 0
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0a81
            r4 = r10
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0a88, Error -> 0x0ac6 }
            r13 = r3
            r14 = 0
            r16 = r13
            r17 = 0
            r18 = r16
            r19 = 0
            r20 = r1
            r1 = 1
            if (r7 != r1) goto L_0x09a2
            r21 = r2
            r1 = 0
            goto L_0x09da
        L_0x09a2:
            if (r11 != 0) goto L_0x09aa
            if (r7 != 0) goto L_0x09aa
            r21 = r2
            r1 = 0
            goto L_0x09da
        L_0x09aa:
            r1 = 0
            if (r7 < 0) goto L_0x09b4
            r21 = r1
            r1 = 5
            if (r7 >= r1) goto L_0x09b6
            r1 = 1
            goto L_0x09b7
        L_0x09b4:
            r21 = r1
        L_0x09b6:
            r1 = 0
        L_0x09b7:
            if (r1 != 0) goto L_0x09bd
            r21 = r2
            r1 = 0
            goto L_0x09da
        L_0x09bd:
            r1 = -1
            if (r11 <= r1) goto L_0x09c7
            r1 = 4
            if (r11 < r1) goto L_0x09c4
            goto L_0x09c7
        L_0x09c4:
            r21 = r2
            goto L_0x09d9
        L_0x09c7:
            java.util.HashMap r1 = mCustomerRatios     // Catch:{ Exception -> 0x0a7c, Error -> 0x0ac6 }
            r21 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            if (r1 != 0) goto L_0x09d9
            r1 = 0
            goto L_0x09da
        L_0x09d9:
            r1 = 1
        L_0x09da:
            if (r1 != 0) goto L_0x09ee
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r1 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r18 = r10
            r2 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r1.<init>(r10, r2, r4)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r19 = r4
            goto L_0x0a67
        L_0x09ea:
            r0 = move-exception
            r1 = r0
            goto L_0x0a8e
        L_0x09ee:
            r18 = r10
            r1 = r16
            r2 = 0
            switch(r11) {
                case 0: goto L_0x0a22;
                case 1: goto L_0x0a15;
                case 2: goto L_0x0a08;
                case 3: goto L_0x09fb;
                default: goto L_0x09f6;
            }     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
        L_0x09f6:
            java.util.HashMap r10 = mCustomerRatios     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            goto L_0x0a2f
        L_0x09fb:
            java.lang.Float[] r10 = SCALED_RATIO_T     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r10 = r10[r7]     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r19 = r1
            goto L_0x0a5a
        L_0x0a08:
            java.lang.Float[] r10 = SCALED_RATIO_H     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r10 = r10[r7]     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r19 = r1
            goto L_0x0a5a
        L_0x0a15:
            java.lang.Float[] r10 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r10 = r10[r7]     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r19 = r1
            goto L_0x0a5a
        L_0x0a22:
            java.lang.Float[] r10 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r10 = r10[r7]     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r19 = r1
            goto L_0x0a5a
        L_0x0a2f:
            r19 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            boolean r1 = r10.containsKey(r1)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            if (r1 == 0) goto L_0x0a58
            java.util.HashMap r1 = mCustomerRatios     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            java.lang.Float[] r1 = (java.lang.Float[]) r1     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            if (r1 == 0) goto L_0x0a55
            r10 = 0
            r22 = r1[r7]     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r22 = r22.floatValue()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r10 = r22
            goto L_0x0a5a
        L_0x0a55:
            r10 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0a5a
        L_0x0a58:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0a5a:
            r1 = r10
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r2 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            float r10 = r4 * r1
            r19 = r4
            r4 = 1
            r2.<init>(r4, r1, r10)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            r1 = r2
        L_0x0a67:
            r2 = 0
            boolean r4 = r1.isScaledRequired()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            if (r4 != 0) goto L_0x0a72
            r4 = r19
            goto L_0x0a76
        L_0x0a72:
            float r4 = r1.getScaledSize()     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
        L_0x0a76:
            r6.setCornerRadius(r4)     // Catch:{ Exception -> 0x09ea, Error -> 0x0ac6 }
            goto L_0x0ab7
        L_0x0a7c:
            r0 = move-exception
            r21 = r2
            r1 = r0
            goto L_0x0a8e
        L_0x0a81:
            r20 = r1
            r21 = r2
            r18 = r10
            goto L_0x0ab7
        L_0x0a88:
            r0 = move-exception
            r20 = r1
            r21 = r2
            r1 = r0
        L_0x0a8e:
            r2 = r3
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r10 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            boolean r10 = r10.isDebug()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            if (r10 == 0) goto L_0x0ab7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r2.<init>()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.StringBuilder r2 = r2.append(r15)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            android.util.Log.d(r8, r2)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r1.printStackTrace()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
        L_0x0ab7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r10 = r5
            r24 = r10
            goto L_0x0dd5
        L_0x0ac0:
            r0 = move-exception
        L_0x0ac1:
            r1 = r0
            r24 = r5
            goto L_0x0e0d
        L_0x0ac6:
            r0 = move-exception
        L_0x0ac7:
            r1 = r0
            r24 = r5
            goto L_0x0e2c
        L_0x0acc:
            boolean r1 = r5 instanceof android.graphics.drawable.NinePatchDrawable     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            if (r1 == 0) goto L_0x0c3a
            com.baidu.searchbox.config.FontSizeHelper r1 = INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r2 = r5
            android.graphics.drawable.NinePatchDrawable r2 = (android.graphics.drawable.NinePatchDrawable) r2     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r3 = r1
            r4 = 0
            r6 = r2
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r12 = r1
            r13 = 0
            r14 = r12
            r15 = 0
            r16 = r14
            r17 = 0
            r18 = r3
            r3 = 1
            if (r7 != r3) goto L_0x0aed
            r19 = r4
            r3 = 0
            goto L_0x0b25
        L_0x0aed:
            if (r11 != 0) goto L_0x0af5
            if (r7 != 0) goto L_0x0af5
            r19 = r4
            r3 = 0
            goto L_0x0b25
        L_0x0af5:
            r3 = 0
            if (r7 < 0) goto L_0x0aff
            r19 = r3
            r3 = 5
            if (r7 >= r3) goto L_0x0b01
            r3 = 1
            goto L_0x0b02
        L_0x0aff:
            r19 = r3
        L_0x0b01:
            r3 = 0
        L_0x0b02:
            if (r3 != 0) goto L_0x0b08
            r19 = r4
            r3 = 0
            goto L_0x0b25
        L_0x0b08:
            r3 = -1
            if (r11 <= r3) goto L_0x0b12
            r3 = 4
            if (r11 < r3) goto L_0x0b0f
            goto L_0x0b12
        L_0x0b0f:
            r19 = r4
            goto L_0x0b24
        L_0x0b12:
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Exception -> 0x0c19, Error -> 0x0ac6 }
            r19 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0b35, Error -> 0x0ac6 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ Exception -> 0x0b35, Error -> 0x0ac6 }
            if (r3 != 0) goto L_0x0b24
            r3 = 0
            goto L_0x0b25
        L_0x0b24:
            r3 = 1
        L_0x0b25:
            if (r3 != 0) goto L_0x0b3b
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r3 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b35, Error -> 0x0ac6 }
            r16 = r9
            r4 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r3.<init>(r9, r4, r10)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r17 = r10
            goto L_0x0bb9
        L_0x0b35:
            r0 = move-exception
            r16 = r9
            r1 = r0
            goto L_0x0c1f
        L_0x0b3b:
            r16 = r9
            r4 = 1065353216(0x3f800000, float:1.0)
            r3 = r14
            r9 = 0
            switch(r11) {
                case 0: goto L_0x0b70;
                case 1: goto L_0x0b63;
                case 2: goto L_0x0b56;
                case 3: goto L_0x0b49;
                default: goto L_0x0b44;
            }     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
        L_0x0b44:
            java.util.HashMap r4 = mCustomerRatios     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            goto L_0x0b81
        L_0x0b49:
            java.lang.Float[] r4 = SCALED_RATIO_T     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r4 = r4[r7]     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r17 = r3
            goto L_0x0bac
        L_0x0b56:
            java.lang.Float[] r4 = SCALED_RATIO_H     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r4 = r4[r7]     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r17 = r3
            goto L_0x0bac
        L_0x0b63:
            java.lang.Float[] r4 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r4 = r4[r7]     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r17 = r3
            goto L_0x0bac
        L_0x0b70:
            java.lang.Float[] r4 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r4 = r4[r7]     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r4 = r4.floatValue()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r17 = r3
            goto L_0x0bac
        L_0x0b7d:
            r0 = move-exception
            r1 = r0
            goto L_0x0c1f
        L_0x0b81:
            r17 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            boolean r3 = r4.containsKey(r3)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            if (r3 == 0) goto L_0x0baa
            java.util.HashMap r3 = mCustomerRatios     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r62)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.Float[] r3 = (java.lang.Float[]) r3     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            if (r3 == 0) goto L_0x0ba7
            r4 = 0
            r20 = r3[r7]     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r20 = r20.floatValue()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r4 = r20
            goto L_0x0bac
        L_0x0ba7:
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0bac
        L_0x0baa:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x0bac:
            r3 = r4
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r4 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r9 = r10 * r3
            r17 = r10
            r10 = 1
            r4.<init>(r10, r3, r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r3 = r4
        L_0x0bb9:
            r4 = 0
            boolean r9 = r3.isScaledRequired()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            if (r9 != 0) goto L_0x0bc4
            r9 = r17
            goto L_0x0bc8
        L_0x0bc4:
            float r9 = r3.getScaledSize()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
        L_0x0bc8:
            r3 = r9
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            int r4 = r4.densityDpi     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r9 = (float) r4     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r9 = r9 * r3
            int r9 = (int) r9     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r6.setTargetDensity(r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r9 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r10 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            boolean r10 = r10.isDebug()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            if (r10 == 0) goto L_0x0c2f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            r1.<init>()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.String r9 = "scaled: "
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.String r9 = ", displayMetrics: "
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.String r9 = ", result: "
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r9 = (float) r4     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            float r9 = r9 * r3
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            android.util.Log.d(r8, r1)     // Catch:{ Exception -> 0x0b7d, Error -> 0x0ac6 }
            goto L_0x0c2f
        L_0x0c19:
            r0 = move-exception
            r19 = r4
            r16 = r9
            r1 = r0
        L_0x0c1f:
            com.baidu.searchbox.config.FontSizeHelper r3 = INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r4 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r8 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            boolean r8 = r8.isDebug()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            if (r8 == 0) goto L_0x0c2f
            r1.printStackTrace()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
        L_0x0c2f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r10 = r2
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r24 = r5
            goto L_0x0dd5
        L_0x0c3a:
            com.baidu.searchbox.config.FontSizeHelper r1 = INSTANCE     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r2 = r1
            r3 = 0
            r4 = r2
            r6 = 0
            r8 = r5
            r9 = 0
            int r10 = r5.getIntrinsicWidth()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r10 = (float) r10     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r10 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r10)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            int r12 = r5.getIntrinsicHeight()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r12 = (float) r12     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r13 = r1
            r14 = 0
            r15 = r13
            r16 = 0
            r17 = r2
            r2 = 1
            if (r7 != r2) goto L_0x0c63
            r18 = r3
            r2 = 0
            goto L_0x0c9b
        L_0x0c63:
            if (r11 != 0) goto L_0x0c6b
            if (r7 != 0) goto L_0x0c6b
            r18 = r3
            r2 = 0
            goto L_0x0c9b
        L_0x0c6b:
            r2 = 0
            if (r7 < 0) goto L_0x0c75
            r18 = r2
            r2 = 5
            if (r7 >= r2) goto L_0x0c77
            r2 = 1
            goto L_0x0c78
        L_0x0c75:
            r18 = r2
        L_0x0c77:
            r2 = 0
        L_0x0c78:
            if (r2 != 0) goto L_0x0c7e
            r18 = r3
            r2 = 0
            goto L_0x0c9b
        L_0x0c7e:
            r2 = -1
            if (r11 <= r2) goto L_0x0c88
            r2 = 4
            if (r11 < r2) goto L_0x0c85
            goto L_0x0c88
        L_0x0c85:
            r18 = r3
            goto L_0x0c9a
        L_0x0c88:
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r18 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            boolean r2 = r2.containsKey(r3)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            if (r2 != 0) goto L_0x0c9a
            r2 = 0
            goto L_0x0c9b
        L_0x0c9a:
            r2 = 1
        L_0x0c9b:
            if (r2 != 0) goto L_0x0ca7
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r2 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r3 = 0
            r2.<init>(r3, r10, r12)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r16 = r4
            goto L_0x0d21
        L_0x0ca7:
            r2 = r13
            r3 = 0
            switch(r11) {
                case 0: goto L_0x0cd8;
                case 1: goto L_0x0ccb;
                case 2: goto L_0x0cbe;
                case 3: goto L_0x0cb1;
                default: goto L_0x0cac;
            }
        L_0x0cac:
            java.util.HashMap r15 = mCustomerRatios     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            goto L_0x0ce5
        L_0x0cb1:
            java.lang.Float[] r15 = SCALED_RATIO_T     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r15 = r15[r7]     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r16 = r2
            goto L_0x0d10
        L_0x0cbe:
            java.lang.Float[] r15 = SCALED_RATIO_H     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r15 = r15[r7]     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r16 = r2
            goto L_0x0d10
        L_0x0ccb:
            java.lang.Float[] r15 = SCALED_RATIO_CONTENT     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r15 = r15[r7]     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r16 = r2
            goto L_0x0d10
        L_0x0cd8:
            java.lang.Float[] r15 = SCALED_RATIO_FRAMEWORK     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r15 = r15[r7]     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            float r15 = r15.floatValue()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r16 = r2
            goto L_0x0d10
        L_0x0ce5:
            r16 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            boolean r2 = r15.containsKey(r2)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            if (r2 == 0) goto L_0x0d0e
            java.util.HashMap r2 = mCustomerRatios     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r62)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.Object r2 = r2.get(r15)     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            java.lang.Float[] r2 = (java.lang.Float[]) r2     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            if (r2 == 0) goto L_0x0d0b
            r15 = 0
            r19 = r2[r7]     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            float r19 = r19.floatValue()     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            r15 = r19
            goto L_0x0d10
        L_0x0d0b:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0d10
        L_0x0d0e:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x0d10:
            r2 = r15
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r3 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r15 = r10 * r2
            r16 = r4
            float r4 = r12 * r2
            r19 = r2
            r2 = 1
            r3.<init>(r2, r15, r4)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r2 = r3
        L_0x0d21:
            r3 = 0
            boolean r4 = r2.isScaledRequired()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            if (r4 != 0) goto L_0x0d32
            r21 = r2
            r20 = r3
            r10 = r5
            r24 = r10
            goto L_0x0dd1
        L_0x0d32:
            float r4 = r2.getScaledWidth()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            float r10 = r2.getScaledHeight()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r12 = r5
            r13 = 0
            r14 = 0
            int r15 = r12.getIntrinsicWidth()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            int r19 = r12.getIntrinsicHeight()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r20 = r19
            r19 = r1
            int r1 = r12.getOpacity()     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r21 = r2
            r2 = -1
            if (r1 == r2) goto L_0x0d56
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Error -> 0x0ac6, Exception -> 0x0ac0 }
            goto L_0x0d58
        L_0x0d56:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
        L_0x0d58:
            r2 = r20
            r20 = r3
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r15, r2, r1)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r22 = r1
            java.lang.String r1 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r1 = r3
            android.graphics.Canvas r3 = new android.graphics.Canvas     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r3.<init>(r1)     // Catch:{ Error -> 0x0de4, Exception -> 0x0ddf }
            r24 = r5
            r5 = 0
            r12.setBounds(r5, r5, r15, r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            r12.draw(r3)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            r2 = r4
            r3 = 0
            switch(r66) {
                case 0: goto L_0x0d8f;
                case 1: goto L_0x0d87;
                case 2: goto L_0x0d82;
                default: goto L_0x0d7d;
            }     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
        L_0x0d7d:
            int r5 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0d96
        L_0x0d82:
            int r5 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0d96
        L_0x0d87:
            double r14 = (double) r2     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            float r5 = (float) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            int r5 = (int) r5     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0d96
        L_0x0d8f:
            double r14 = (double) r2     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            float r5 = (float) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            int r5 = (int) r5     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
        L_0x0d96:
            r2 = r10
            r3 = 0
            switch(r66) {
                case 0: goto L_0x0dae;
                case 1: goto L_0x0da6;
                case 2: goto L_0x0da1;
                default: goto L_0x0d9c;
            }     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
        L_0x0d9c:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0db5
        L_0x0da1:
            int r14 = kotlin.math.MathKt.roundToInt((float) r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0db5
        L_0x0da6:
            double r14 = (double) r2     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            double r14 = java.lang.Math.floor(r14)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            goto L_0x0db5
        L_0x0dae:
            double r14 = (double) r2     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            double r14 = java.lang.Math.ceil(r14)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            float r14 = (float) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            int r14 = (int) r14     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
        L_0x0db5:
            r2 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r5, r14, r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            java.lang.String r2 = "createScaledBitmap(\n    …       true\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            r2.<init>(r3, r1)     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2     // Catch:{ Error -> 0x0ddb, Exception -> 0x0dd8 }
            r10 = r2
        L_0x0dd1:
        L_0x0dd5:
            r4 = r10
            goto L_0x0e3f
        L_0x0dd8:
            r0 = move-exception
            r1 = r0
            goto L_0x0e0d
        L_0x0ddb:
            r0 = move-exception
            r1 = r0
            goto L_0x0e2c
        L_0x0ddf:
            r0 = move-exception
            r24 = r5
            r1 = r0
            goto L_0x0e0d
        L_0x0de4:
            r0 = move-exception
            r24 = r5
            r1 = r0
            goto L_0x0e2c
        L_0x0de9:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r7 = r2
            r1 = r0
            goto L_0x0e0d
        L_0x0df4:
            r0 = move-exception
            r11 = r1
            r24 = r5
            r34 = r6
            r38 = r7
            r7 = r2
            r1 = r0
            goto L_0x0e2c
        L_0x0dff:
            r0 = move-exception
            r11 = r1
            r27 = r3
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r7 = r2
            r1 = r0
        L_0x0e0d:
            r2 = r38
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0e1d
            r1.printStackTrace()
        L_0x0e1d:
            goto L_0x0e3d
        L_0x0e1e:
            r0 = move-exception
            r11 = r1
            r27 = r3
            r24 = r5
            r34 = r6
            r38 = r7
            r23 = r8
            r7 = r2
            r1 = r0
        L_0x0e2c:
            r2 = r38
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0e3c
            r1.printStackTrace()
        L_0x0e3c:
        L_0x0e3d:
            r4 = r63
        L_0x0e3f:
            goto L_0x0e47
        L_0x0e42:
            r11 = r1
            r7 = r2
            r27 = r3
            r4 = 0
        L_0x0e47:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledDrawableInner(int, android.graphics.drawable.Drawable, int, int, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.drawable.Drawable handleErrorException(android.graphics.drawable.Drawable r6, kotlin.jvm.functions.Function0<? extends android.graphics.drawable.Drawable> r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Object r1 = r7.invoke()     // Catch:{ Error -> 0x001a, Exception -> 0x0009 }
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1     // Catch:{ Error -> 0x001a, Exception -> 0x0009 }
            goto L_0x002c
        L_0x0009:
            r1 = move-exception
            r2 = r5
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0019
            r1.printStackTrace()
        L_0x0019:
            goto L_0x002b
        L_0x001a:
            r1 = move-exception
            r2 = r5
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x002a
            r1.printStackTrace()
        L_0x002a:
        L_0x002b:
            r1 = r6
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.handleErrorException(android.graphics.drawable.Drawable, kotlin.jvm.functions.Function0):android.graphics.drawable.Drawable");
    }

    private final FontScaledSize handleException(Drawable drawable, Function1<? super Drawable, FontScaledSize> block) {
        try {
            return block.invoke(drawable);
        } catch (Exception e2) {
            return new FontScaledSize(false, 0.0f, 0.0f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.Bitmap handleErrorException(android.graphics.Bitmap r6, kotlin.jvm.functions.Function0<android.graphics.Bitmap> r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Object r1 = r7.invoke()     // Catch:{ Error -> 0x001a, Exception -> 0x0009 }
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ Error -> 0x001a, Exception -> 0x0009 }
            goto L_0x002c
        L_0x0009:
            r1 = move-exception
            r2 = r5
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x0019
            r1.printStackTrace()
        L_0x0019:
            goto L_0x002b
        L_0x001a:
            r1 = move-exception
            r2 = r5
            r3 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r2 = r4.isDebug()
            if (r2 == 0) goto L_0x002a
            r1.printStackTrace()
        L_0x002a:
        L_0x002b:
            r1 = r6
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.handleErrorException(android.graphics.Bitmap, kotlin.jvm.functions.Function0):android.graphics.Bitmap");
    }

    private final BitmapDrawable getScaledBitmapDrawable(int type, BitmapDrawable drawable, int baseFontSize, int targetFontSize, int numRoundPolicy) {
        Drawable drawable2;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        int i2;
        int $i$f$getScaledBitmapDrawable;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv;
        int i3 = type;
        int i4 = targetFontSize;
        if (drawable != null) {
            FontSizeHelper this_$iv$iv = INSTANCE;
            float width$iv$iv = DisplayUtilsKt.toStandardScreen((float) drawable.getIntrinsicWidth());
            float height$iv$iv = DisplayUtilsKt.toStandardScreen((float) drawable.getIntrinsicHeight());
            FontSizeHelper fontSizeHelper = this_$iv$iv;
            if (i4 == 1) {
                z = false;
            } else if (i3 == 0 && i4 == 0) {
                z = false;
            } else {
                if (!(i4 >= 0 && i4 < 5)) {
                    z = false;
                } else if ((i3 <= -1 || i3 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv$iv, height$iv$iv);
            } else {
                FontSizeHelper fontSizeHelper2 = this_$iv$iv;
                float f2 = 1.0f;
                switch (i3) {
                    case 0:
                        f2 = SCALED_RATIO_FRAMEWORK[i4].floatValue();
                        break;
                    case 1:
                        f2 = SCALED_RATIO_CONTENT[i4].floatValue();
                        break;
                    case 2:
                        f2 = SCALED_RATIO_H[i4].floatValue();
                        break;
                    case 3:
                        f2 = SCALED_RATIO_T[i4].floatValue();
                        break;
                    default:
                        if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                            f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[i4].floatValue();
                            break;
                        }
                }
                float ratio$iv$iv = f2;
                scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv$iv * ratio$iv$iv, height$iv$iv * ratio$iv$iv);
            }
            Scaled2DSizeInfo $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv = scaled2DSizeInfo;
            if (!$this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.isScaledRequired()) {
                drawable2 = drawable;
            } else {
                float dstWidth = $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.getScaledWidth();
                float dstHeight = $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.getScaledHeight();
                Bitmap bitmap = drawable.getBitmap();
                float $this$roundByPolicy$iv = dstWidth;
                switch (numRoundPolicy) {
                    case 0:
                        i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
                        break;
                    case 1:
                        i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
                        break;
                    case 2:
                        i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                        break;
                    default:
                        i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                        break;
                }
                float $this$roundByPolicy$iv2 = dstHeight;
                switch (numRoundPolicy) {
                    case 0:
                        $i$f$getScaledBitmapDrawable = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv2));
                        break;
                    case 1:
                        $i$f$getScaledBitmapDrawable = (int) ((float) Math.floor((double) $this$roundByPolicy$iv2));
                        break;
                    case 2:
                        $i$f$getScaledBitmapDrawable = MathKt.roundToInt($this$roundByPolicy$iv2);
                        break;
                    default:
                        $i$f$getScaledBitmapDrawable = MathKt.roundToInt($this$roundByPolicy$iv2);
                        break;
                }
                Bitmap dstBitmap = Bitmap.createScaledBitmap(bitmap, i2, $i$f$getScaledBitmapDrawable, true);
                Intrinsics.checkNotNullExpressionValue(dstBitmap, "createScaledBitmap(\n    …licy), true\n            )");
                drawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), dstBitmap);
            }
        } else {
            drawable2 = null;
        }
        return (BitmapDrawable) drawable2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v17, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v87, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v13, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v2, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v14, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r0 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r9, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "createScaledBitmap(\n    …                        )");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0243, code lost:
        r7 = r16;
        r9 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r7.addLevel(r9, r9, new android.graphics.drawable.BitmapDrawable(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x040c, code lost:
        com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r2, "setBitmap", android.graphics.Bitmap.createScaledBitmap(r0, r9, r10, true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0421, code lost:
        r33 = r2;
        r43 = r8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0501  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05f0 A[Catch:{ Exception -> 0x0643 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0678  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T extends android.graphics.drawable.Drawable> T getScaledStateListDrawable(int r48, T r49, int r50, int r51, int r52) {
        /*
            r47 = this;
            r1 = r48
            r2 = r49
            r3 = r51
            java.lang.String r4 = "Version: "
            java.lang.String r5 = "FontSizeHelper"
            r6 = 0
            r7 = r47
            r8 = 0
            if (r2 == 0) goto L_0x0691
            r9 = r49
            r10 = 0
            com.baidu.searchbox.config.FontSizeHelper r11 = INSTANCE
            int r12 = r49.getIntrinsicWidth()
            float r12 = (float) r12
            float r12 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r12)
            int r13 = r49.getIntrinsicHeight()
            float r13 = (float) r13
            float r13 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r13)
            r14 = 0
            r15 = r11
            r16 = 0
            r17 = r6
            r6 = 1
            r21 = r7
            r7 = 0
            if (r3 != r6) goto L_0x0036
            r0 = r7
            goto L_0x0061
        L_0x0036:
            if (r1 != 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            r0 = r7
            goto L_0x0061
        L_0x003c:
            r22 = 0
            if (r3 < 0) goto L_0x0045
            r6 = 5
            if (r3 >= r6) goto L_0x0045
            r6 = 1
            goto L_0x0046
        L_0x0045:
            r6 = r7
        L_0x0046:
            if (r6 != 0) goto L_0x004a
            r0 = r7
            goto L_0x0061
        L_0x004a:
            r6 = -1
            if (r1 <= r6) goto L_0x0050
            r6 = 4
            if (r1 < r6) goto L_0x0060
        L_0x0050:
            java.util.HashMap r6 = mCustomerRatios
            java.lang.Integer r0 = java.lang.Integer.valueOf(r48)
            boolean r0 = r6.containsKey(r0)
            if (r0 != 0) goto L_0x0060
            r0 = r7
            goto L_0x0061
        L_0x0060:
            r0 = 1
        L_0x0061:
            if (r0 != 0) goto L_0x006c
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r0 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo
            r0.<init>(r7, r12, r13)
            r24 = r8
            goto L_0x00df
        L_0x006c:
            r0 = r11
            r15 = 0
            switch(r1) {
                case 0: goto L_0x00be;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0097;
                default: goto L_0x0071;
            }
        L_0x0071:
            java.util.HashMap r6 = mCustomerRatios
            java.lang.Integer r7 = java.lang.Integer.valueOf(r48)
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x00ce
            java.util.HashMap r6 = mCustomerRatios
            java.lang.Integer r7 = java.lang.Integer.valueOf(r48)
            java.lang.Object r6 = r6.get(r7)
            java.lang.Float[] r6 = (java.lang.Float[]) r6
            if (r6 == 0) goto L_0x00cb
            r7 = 0
            r24 = r6[r3]
            float r6 = r24.floatValue()
            goto L_0x00d0
        L_0x0097:
            java.lang.Float[] r16 = SCALED_RATIO_T
            r16 = r16[r3]
            float r16 = r16.floatValue()
            r6 = r16
            goto L_0x00d0
        L_0x00a4:
            java.lang.Float[] r16 = SCALED_RATIO_H
            r16 = r16[r3]
            float r16 = r16.floatValue()
            r6 = r16
            goto L_0x00d0
        L_0x00b1:
            java.lang.Float[] r16 = SCALED_RATIO_CONTENT
            r16 = r16[r3]
            float r16 = r16.floatValue()
            r6 = r16
            goto L_0x00d0
        L_0x00be:
            java.lang.Float[] r16 = SCALED_RATIO_FRAMEWORK
            r16 = r16[r3]
            float r16 = r16.floatValue()
            r6 = r16
            goto L_0x00d0
        L_0x00cb:
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00d0
        L_0x00ce:
            r6 = 1065353216(0x3f800000, float:1.0)
        L_0x00d0:
            r0 = r6
            com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo r6 = new com.baidu.searchbox.config.FontSizeHelper$Scaled2DSizeInfo
            float r7 = r12 * r0
            float r15 = r13 * r0
            r24 = r8
            r8 = 1
            r6.<init>(r8, r7, r15)
            r0 = r6
        L_0x00df:
            r6 = r0
            r7 = 0
            boolean r0 = r6.isScaledRequired()
            if (r0 != 0) goto L_0x00f2
            r0 = r2
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            goto L_0x068e
        L_0x00f2:
            float r0 = r6.getScaledWidth()
            float r8 = r6.getScaledHeight()
            r11 = r49
            r12 = r0
            r13 = 0
            int r0 = android.os.Build.VERSION.SDK_INT
            r14 = 23
            java.lang.String r15 = "getChildren"
            if (r0 > r14) goto L_0x031a
            boolean r0 = r2 instanceof android.graphics.drawable.LevelListDrawable
            if (r0 == 0) goto L_0x031a
            com.baidu.searchbox.config.FontSizeHelper r4 = INSTANCE
            r5 = r49
            r14 = 0
            android.graphics.drawable.LevelListDrawable r0 = new android.graphics.drawable.LevelListDrawable
            r0.<init>()
            r16 = r0
            r18 = r5
            r19 = 0
            android.graphics.drawable.Drawable$ConstantState r0 = r18.getConstantState()
            if (r0 == 0) goto L_0x0304
            r20 = r0
            r25 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x02e4 }
            r0 = r18
            r26 = 0
            r27 = r0
            java.lang.Class r0 = r20.getClass()     // Catch:{ all -> 0x02e4 }
            r28 = r4
            r2 = 0
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x02d4 }
            java.lang.reflect.Method r0 = r0.getMethod(r15, r4)     // Catch:{ all -> 0x02d4 }
            r4 = 1
            r0.setAccessible(r4)     // Catch:{ all -> 0x02d4 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x02d4 }
            r2 = r20
            java.lang.Object r4 = r0.invoke(r2, r4)     // Catch:{ all -> 0x02c4 }
            boolean r15 = r4 instanceof java.lang.Object[]     // Catch:{ all -> 0x02c4 }
            if (r15 == 0) goto L_0x015d
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ all -> 0x014c }
            goto L_0x015e
        L_0x014c:
            r0 = move-exception
            r30 = r2
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x015d:
            r4 = 0
        L_0x015e:
            if (r4 == 0) goto L_0x02ad
            r15 = 0
            r20 = 0
            r29 = r0
            int r0 = r4.length     // Catch:{ all -> 0x02c4 }
            r30 = r2
            r2 = 0
        L_0x0169:
            if (r2 >= r0) goto L_0x029c
            r22 = r4[r2]     // Catch:{ all -> 0x028d }
            int r23 = r20 + 1
            r31 = r22
            r32 = 0
            r33 = r0
            r0 = r31
            r31 = r4
            boolean r4 = r0 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x028d }
            if (r4 == 0) goto L_0x0266
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x028d }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x028d }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ all -> 0x028d }
            int r4 = r4.densityDpi     // Catch:{ all -> 0x028d }
            r34 = 160(0xa0, float:2.24E-43)
            int r35 = r4 / r34
            r36 = r35
            r35 = r0
            android.graphics.drawable.BitmapDrawable r35 = (android.graphics.drawable.BitmapDrawable) r35     // Catch:{ all -> 0x028d }
            r37 = r0
            android.graphics.Bitmap r0 = r35.getBitmap()     // Catch:{ all -> 0x028d }
            r35 = r4
            r4 = r36
            r36 = r5
            float r5 = (float) r4
            float r5 = r5 * r12
            float r5 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r5)     // Catch:{ all -> 0x0259 }
            r38 = 0
            switch(r52) {
                case 0: goto L_0x01db;
                case 1: goto L_0x01cf;
                case 2: goto L_0x01b5;
                default: goto L_0x01ac;
            }
        L_0x01ac:
            r39 = r6
            r40 = r7
            int r6 = kotlin.math.MathKt.roundToInt((float) r5)     // Catch:{ all -> 0x0250 }
            goto L_0x01f0
        L_0x01b5:
            int r39 = kotlin.math.MathKt.roundToInt((float) r5)     // Catch:{ all -> 0x01c2 }
            r40 = r7
            r46 = r39
            r39 = r6
            r6 = r46
            goto L_0x01f0
        L_0x01c2:
            r0 = move-exception
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x01cf:
            r39 = r6
            r40 = r7
            double r6 = (double) r5
            double r6 = java.lang.Math.floor(r6)     // Catch:{ all -> 0x01e7 }
            float r6 = (float) r6     // Catch:{ all -> 0x01e7 }
            int r6 = (int) r6     // Catch:{ all -> 0x01e7 }
            goto L_0x01f0
        L_0x01db:
            r39 = r6
            r40 = r7
            double r6 = (double) r5     // Catch:{ all -> 0x01e7 }
            double r6 = java.lang.Math.ceil(r6)     // Catch:{ all -> 0x01e7 }
            float r6 = (float) r6
            int r6 = (int) r6
            goto L_0x01f0
        L_0x01e7:
            r0 = move-exception
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x01f0:
            float r5 = (float) r4
            float r5 = r5 * r8
            float r5 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r5)     // Catch:{ all -> 0x0250 }
            r7 = 0
            switch(r52) {
                case 0: goto L_0x021d;
                case 1: goto L_0x0211;
                case 2: goto L_0x0204;
                default: goto L_0x01fb;
            }
        L_0x01fb:
            r38 = r9
            r41 = r10
            int r9 = kotlin.math.MathKt.roundToInt((float) r5)     // Catch:{ all -> 0x024b }
            goto L_0x022e
        L_0x0204:
            int r38 = kotlin.math.MathKt.roundToInt((float) r5)     // Catch:{ all -> 0x01e7 }
            r41 = r10
            r46 = r38
            r38 = r9
            r9 = r46
            goto L_0x022e
        L_0x0211:
            r38 = r9
            r41 = r10
            double r9 = (double) r5
            double r9 = java.lang.Math.floor(r9)     // Catch:{ all -> 0x0229 }
            float r9 = (float) r9     // Catch:{ all -> 0x0229 }
            int r9 = (int) r9     // Catch:{ all -> 0x0229 }
            goto L_0x022e
        L_0x021d:
            r38 = r9
            r41 = r10
            double r9 = (double) r5     // Catch:{ all -> 0x0229 }
            double r9 = java.lang.Math.ceil(r9)     // Catch:{ all -> 0x0229 }
            float r9 = (float) r9
            int r9 = (int) r9
            goto L_0x022e
        L_0x0229:
            r0 = move-exception
            r7 = r16
            goto L_0x02f5
        L_0x022e:
            r5 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r9, r5)     // Catch:{ all -> 0x024b }
            java.lang.String r5 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ all -> 0x024b }
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x024b }
            r5.<init>(r0)     // Catch:{ all -> 0x024b }
            r6 = r5
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6     // Catch:{ all -> 0x024b }
            r7 = r16
            r9 = r20
            r7.addLevel(r9, r9, r6)     // Catch:{ all -> 0x02c2 }
            goto L_0x0276
        L_0x024b:
            r0 = move-exception
            r7 = r16
            goto L_0x02f5
        L_0x0250:
            r0 = move-exception
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x0259:
            r0 = move-exception
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x0266:
            r37 = r0
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            r9 = r20
        L_0x0276:
            int r2 = r2 + 1
            r16 = r7
            r20 = r23
            r4 = r31
            r0 = r33
            r5 = r36
            r9 = r38
            r6 = r39
            r7 = r40
            r10 = r41
            goto L_0x0169
        L_0x028d:
            r0 = move-exception
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x029c:
            r31 = r4
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02c2 }
            goto L_0x02be
        L_0x02ad:
            r29 = r0
            r30 = r2
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            r0 = 0
        L_0x02be:
            kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x02c2 }
            goto L_0x02fe
        L_0x02c2:
            r0 = move-exception
            goto L_0x02f5
        L_0x02c4:
            r0 = move-exception
            r30 = r2
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            goto L_0x02f5
        L_0x02d4:
            r0 = move-exception
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            r30 = r20
            goto L_0x02f5
        L_0x02e4:
            r0 = move-exception
            r28 = r4
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
            r30 = r20
        L_0x02f5:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x02fe:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0312
        L_0x0304:
            r28 = r4
            r36 = r5
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r7 = r16
        L_0x0312:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r7
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            return r0
        L_0x031a:
            r39 = r6
            r40 = r7
            r38 = r9
            r41 = r10
            r2 = r11
            r6 = 0
            android.graphics.drawable.Drawable$ConstantState r0 = r2.getConstantState()
            if (r0 == 0) goto L_0x0681
            r7 = r0
            r9 = 0
            java.lang.Class r0 = r7.getClass()     // Catch:{ Exception -> 0x065e }
            r10 = 0
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x065e }
            java.lang.reflect.Method r0 = r0.getMethod(r15, r14)     // Catch:{ Exception -> 0x065e }
            r14 = r0
            r15 = 1
            r14.setAccessible(r15)     // Catch:{ Exception -> 0x065e }
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x065e }
            java.lang.Object r0 = r14.invoke(r7, r0)     // Catch:{ Exception -> 0x065e }
            boolean r10 = r0 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x065e }
            if (r10 == 0) goto L_0x0359
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ Exception -> 0x034a }
            goto L_0x035a
        L_0x034a:
            r0 = move-exception
            r25 = r2
            r26 = r6
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
            goto L_0x066b
        L_0x0359:
            r0 = 0
        L_0x035a:
            if (r0 == 0) goto L_0x0651
            r10 = r0
            r15 = 0
            r25 = r2
            int r2 = r10.length     // Catch:{ Exception -> 0x0645 }
            r26 = r6
            r6 = 0
        L_0x0364:
            if (r6 >= r2) goto L_0x0636
            r0 = r10[r6]     // Catch:{ Exception -> 0x062c }
            r22 = r0
            r27 = r22
            r28 = 0
            r29 = r2
            r2 = r27
            boolean r0 = r2 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x062c }
            if (r0 == 0) goto L_0x043a
            r0 = r2
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0     // Catch:{ Exception -> 0x042f }
            android.graphics.Bitmap r0 = r0.getBitmap()     // Catch:{ Exception -> 0x042f }
            r27 = r12
            r30 = 0
            switch(r52) {
                case 0: goto L_0x03be;
                case 1: goto L_0x03ae;
                case 2: goto L_0x0392;
                default: goto L_0x0385;
            }
        L_0x0385:
            r31 = r7
            r32 = r10
            r7 = r27
            r27 = r9
            int r9 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ Exception -> 0x0428 }
            goto L_0x03d5
        L_0x0392:
            int r31 = kotlin.math.MathKt.roundToInt((float) r27)     // Catch:{ Exception -> 0x03a3 }
            r32 = r10
            r46 = r31
            r31 = r7
            r7 = r27
            r27 = r9
            r9 = r46
            goto L_0x03d5
        L_0x03a3:
            r0 = move-exception
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
            goto L_0x066b
        L_0x03ae:
            r31 = r7
            r32 = r10
            r7 = r27
            r27 = r9
            double r9 = (double) r7
            double r9 = java.lang.Math.floor(r9)     // Catch:{ Exception -> 0x03ce }
            float r9 = (float) r9     // Catch:{ Exception -> 0x03ce }
            int r9 = (int) r9     // Catch:{ Exception -> 0x03ce }
            goto L_0x03d5
        L_0x03be:
            r31 = r7
            r32 = r10
            r7 = r27
            r27 = r9
            double r9 = (double) r7     // Catch:{ Exception -> 0x03ce }
            double r9 = java.lang.Math.ceil(r9)     // Catch:{ Exception -> 0x03ce }
            float r9 = (float) r9
            int r9 = (int) r9
            goto L_0x03d5
        L_0x03ce:
            r0 = move-exception
            r43 = r8
            r30 = r11
            goto L_0x066b
        L_0x03d5:
            r7 = r8
            r10 = 0
            switch(r52) {
                case 0: goto L_0x03fb;
                case 1: goto L_0x03ef;
                case 2: goto L_0x03e4;
                default: goto L_0x03db;
            }
        L_0x03db:
            r33 = r10
            r30 = r11
            int r10 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ Exception -> 0x0407 }
            goto L_0x040c
        L_0x03e4:
            int r30 = kotlin.math.MathKt.roundToInt((float) r7)     // Catch:{ Exception -> 0x03ce }
            r33 = r10
            r10 = r30
            r30 = r11
            goto L_0x040c
        L_0x03ef:
            r33 = r10
            r30 = r11
            double r10 = (double) r7
            double r10 = java.lang.Math.floor(r10)     // Catch:{ Exception -> 0x0407 }
            float r10 = (float) r10     // Catch:{ Exception -> 0x0407 }
            int r10 = (int) r10     // Catch:{ Exception -> 0x0407 }
            goto L_0x040c
        L_0x03fb:
            r33 = r10
            r30 = r11
            double r10 = (double) r7     // Catch:{ Exception -> 0x0407 }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ Exception -> 0x0407 }
            float r10 = (float) r10     // Catch:{ Exception -> 0x0407 }
            int r10 = (int) r10     // Catch:{ Exception -> 0x0407 }
            goto L_0x040c
        L_0x0407:
            r0 = move-exception
            r43 = r8
            goto L_0x066b
        L_0x040c:
            r7 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r9, r10, r7)     // Catch:{ Exception -> 0x0407 }
            r9 = 0
            java.lang.String r10 = "setBitmap"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0407 }
            r7 = 0
            r11[r7] = r0     // Catch:{ Exception -> 0x0407 }
            com.baidu.searchbox.config.utils.ReflectionUtil.invokeMethod(r2, r10, r11)     // Catch:{ Exception -> 0x0407 }
            r33 = r2
            r43 = r8
            r1 = 1
            goto L_0x0615
        L_0x0428:
            r0 = move-exception
            r30 = r11
            r43 = r8
            goto L_0x066b
        L_0x042f:
            r0 = move-exception
            r31 = r7
            r27 = r9
            r30 = r11
            r43 = r8
            goto L_0x066b
        L_0x043a:
            r31 = r7
            r27 = r9
            r32 = r10
            r30 = r11
            boolean r0 = r2 instanceof android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x0628 }
            if (r0 == 0) goto L_0x0610
            com.baidu.searchbox.config.FontSizeHelper r0 = INSTANCE     // Catch:{ Exception -> 0x0628 }
            r7 = r2
            android.graphics.drawable.GradientDrawable r7 = (android.graphics.drawable.GradientDrawable) r7     // Catch:{ Exception -> 0x0628 }
            r9 = r0
            r10 = 0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05dc }
            r11 = 24
            if (r0 < r11) goto L_0x0467
            float r0 = r7.getCornerRadius()     // Catch:{ Exception -> 0x045d }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x045d }
            goto L_0x0472
        L_0x045d:
            r0 = move-exception
            r33 = r2
            r43 = r8
            r16 = r10
            r1 = 1
            goto L_0x05e4
        L_0x0467:
            android.graphics.drawable.Drawable$ConstantState r0 = r7.getConstantState()     // Catch:{ Exception -> 0x05dc }
            java.lang.String r11 = "mRadius"
            java.lang.Object r0 = com.baidu.searchbox.config.utils.ReflectionUtil.getFieldValue(r0, r11)     // Catch:{ Exception -> 0x05dc }
        L_0x0472:
            r11 = r9
            r33 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r34 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x05dc }
            boolean r34 = r34.isDebug()     // Catch:{ Exception -> 0x05dc }
            if (r34 == 0) goto L_0x04b5
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ab }
            r11.<init>()     // Catch:{ Exception -> 0x04ab }
            java.lang.StringBuilder r11 = r11.append(r4)     // Catch:{ Exception -> 0x04ab }
            r33 = r2
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04a3 }
            java.lang.StringBuilder r2 = r11.append(r2)     // Catch:{ Exception -> 0x04a3 }
            java.lang.String r11 = ", OriginalRadius is :"
            java.lang.StringBuilder r2 = r2.append(r11)     // Catch:{ Exception -> 0x04a3 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ Exception -> 0x04a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04a3 }
            android.util.Log.d(r5, r2)     // Catch:{ Exception -> 0x04a3 }
            goto L_0x04b7
        L_0x04a3:
            r0 = move-exception
            r43 = r8
            r16 = r10
            r1 = 1
            goto L_0x05e4
        L_0x04ab:
            r0 = move-exception
            r33 = r2
            r43 = r8
            r16 = r10
            r1 = 1
            goto L_0x05e4
        L_0x04b5:
            r33 = r2
        L_0x04b7:
            boolean r2 = r0 instanceof java.lang.Float     // Catch:{ Exception -> 0x05d5 }
            if (r2 == 0) goto L_0x05cd
            r2 = r0
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Exception -> 0x05d5 }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x05d5 }
            r11 = 0
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x05cd
            r2 = r0
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Exception -> 0x05d5 }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x05d5 }
            r11 = r9
            r34 = 0
            r35 = r11
            r36 = 0
            r37 = r35
            r42 = 0
            r43 = r8
            r8 = 1
            if (r3 != r8) goto L_0x04e3
            r44 = r0
            r8 = 0
            goto L_0x051f
        L_0x04e3:
            if (r1 != 0) goto L_0x04eb
            if (r3 != 0) goto L_0x04eb
            r44 = r0
            r8 = 0
            goto L_0x051f
        L_0x04eb:
            r8 = 0
            if (r3 < 0) goto L_0x04f6
            r44 = r8
            r8 = 5
            if (r3 >= r8) goto L_0x04f9
            r20 = 1
            goto L_0x04fb
        L_0x04f6:
            r44 = r8
            r8 = 5
        L_0x04f9:
            r20 = 0
        L_0x04fb:
            if (r20 != 0) goto L_0x0501
            r44 = r0
            r8 = 0
            goto L_0x051f
        L_0x0501:
            r8 = -1
            if (r1 <= r8) goto L_0x050b
            r8 = 4
            if (r1 < r8) goto L_0x0508
            goto L_0x050c
        L_0x0508:
            r44 = r0
            goto L_0x051e
        L_0x050b:
            r8 = 4
        L_0x050c:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x05c8 }
            r44 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r48)     // Catch:{ Exception -> 0x05c8 }
            boolean r0 = r8.containsKey(r0)     // Catch:{ Exception -> 0x05c8 }
            if (r0 != 0) goto L_0x051e
            r8 = 0
            goto L_0x051f
        L_0x051e:
            r8 = 1
        L_0x051f:
            if (r8 != 0) goto L_0x0536
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r0 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x052e }
            r16 = r10
            r8 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r0.<init>(r10, r8, r2)     // Catch:{ Exception -> 0x057b }
            r1 = 1
            goto L_0x05b2
        L_0x052e:
            r0 = move-exception
            r16 = r10
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0533:
            r1 = 1
            goto L_0x05e4
        L_0x0536:
            r16 = r10
            r8 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r0 = r35
            r23 = 0
            switch(r1) {
                case 0: goto L_0x056e;
                case 1: goto L_0x0561;
                case 2: goto L_0x0554;
                case 3: goto L_0x0547;
                default: goto L_0x0542;
            }     // Catch:{ Exception -> 0x057b }
        L_0x0542:
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x057b }
            goto L_0x057f
        L_0x0547:
            java.lang.Float[] r37 = SCALED_RATIO_T     // Catch:{ Exception -> 0x057b }
            r37 = r37[r3]     // Catch:{ Exception -> 0x057b }
            float r37 = r37.floatValue()     // Catch:{ Exception -> 0x057b }
            r45 = r37
            goto L_0x05a6
        L_0x0554:
            java.lang.Float[] r37 = SCALED_RATIO_H     // Catch:{ Exception -> 0x057b }
            r37 = r37[r3]     // Catch:{ Exception -> 0x057b }
            float r37 = r37.floatValue()     // Catch:{ Exception -> 0x057b }
            r45 = r37
            goto L_0x05a6
        L_0x0561:
            java.lang.Float[] r37 = SCALED_RATIO_CONTENT     // Catch:{ Exception -> 0x057b }
            r37 = r37[r3]     // Catch:{ Exception -> 0x057b }
            float r37 = r37.floatValue()     // Catch:{ Exception -> 0x057b }
            r45 = r37
            goto L_0x05a6
        L_0x056e:
            java.lang.Float[] r37 = SCALED_RATIO_FRAMEWORK     // Catch:{ Exception -> 0x057b }
            r37 = r37[r3]     // Catch:{ Exception -> 0x057b }
            float r37 = r37.floatValue()     // Catch:{ Exception -> 0x057b }
            r45 = r37
            goto L_0x05a6
        L_0x057b:
            r0 = move-exception
            r1 = 1
            goto L_0x05e4
        L_0x057f:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r48)     // Catch:{ Exception -> 0x057b }
            boolean r8 = r8.containsKey(r10)     // Catch:{ Exception -> 0x057b }
            if (r8 == 0) goto L_0x05a4
            java.util.HashMap r8 = mCustomerRatios     // Catch:{ Exception -> 0x057b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r48)     // Catch:{ Exception -> 0x057b }
            java.lang.Object r8 = r8.get(r10)     // Catch:{ Exception -> 0x057b }
            java.lang.Float[] r8 = (java.lang.Float[]) r8     // Catch:{ Exception -> 0x057b }
            if (r8 == 0) goto L_0x05a1
            r10 = 0
            r45 = r8[r3]     // Catch:{ Exception -> 0x057b }
            float r45 = r45.floatValue()     // Catch:{ Exception -> 0x057b }
            goto L_0x05a6
        L_0x05a1:
            r45 = 1065353216(0x3f800000, float:1.0)
            goto L_0x05a6
        L_0x05a4:
            r45 = 1065353216(0x3f800000, float:1.0)
        L_0x05a6:
            r0 = r45
            com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo r8 = new com.baidu.searchbox.config.FontSizeHelper$Scaled1DSizeInfo     // Catch:{ Exception -> 0x057b }
            float r10 = r2 * r0
            r1 = 1
            r8.<init>(r1, r0, r10)     // Catch:{ Exception -> 0x05c6 }
            r0 = r8
        L_0x05b2:
            r8 = 0
            boolean r10 = r0.isScaledRequired()     // Catch:{ Exception -> 0x05c6 }
            if (r10 != 0) goto L_0x05bc
            r10 = r2
            goto L_0x05c0
        L_0x05bc:
            float r10 = r0.getScaledSize()     // Catch:{ Exception -> 0x05c6 }
        L_0x05c0:
            r7.setCornerRadius(r10)     // Catch:{ Exception -> 0x05c6 }
            goto L_0x060f
        L_0x05c6:
            r0 = move-exception
            goto L_0x05e4
        L_0x05c8:
            r0 = move-exception
            r16 = r10
            goto L_0x0533
        L_0x05cd:
            r44 = r0
            r43 = r8
            r16 = r10
            r1 = 1
            goto L_0x060f
        L_0x05d5:
            r0 = move-exception
            r43 = r8
            r16 = r10
            r1 = 1
            goto L_0x05e4
        L_0x05dc:
            r0 = move-exception
            r33 = r2
            r43 = r8
            r16 = r10
            r1 = 1
        L_0x05e4:
            r2 = r9
            r8 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r10 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()     // Catch:{ Exception -> 0x0643 }
            boolean r10 = r10.isDebug()     // Catch:{ Exception -> 0x0643 }
            if (r10 == 0) goto L_0x060f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0643 }
            r2.<init>()     // Catch:{ Exception -> 0x0643 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x0643 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0643 }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x0643 }
            java.lang.String r8 = ", GradientDrawable ReflectionUtil Error"
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ Exception -> 0x0643 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0643 }
            android.util.Log.d(r5, r2)     // Catch:{ Exception -> 0x0643 }
            r0.printStackTrace()     // Catch:{ Exception -> 0x0643 }
        L_0x060f:
            goto L_0x0615
        L_0x0610:
            r33 = r2
            r43 = r8
            r1 = 1
        L_0x0615:
            int r6 = r6 + 1
            r1 = r48
            r9 = r27
            r2 = r29
            r11 = r30
            r7 = r31
            r10 = r32
            r8 = r43
            goto L_0x0364
        L_0x0628:
            r0 = move-exception
            r43 = r8
            goto L_0x066b
        L_0x062c:
            r0 = move-exception
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
            goto L_0x066b
        L_0x0636:
            r31 = r7
            r43 = r8
            r27 = r9
            r32 = r10
            r30 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0643 }
            goto L_0x065d
        L_0x0643:
            r0 = move-exception
            goto L_0x066b
        L_0x0645:
            r0 = move-exception
            r26 = r6
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
            goto L_0x066b
        L_0x0651:
            r25 = r2
            r26 = r6
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
        L_0x065d:
            goto L_0x067b
        L_0x065e:
            r0 = move-exception
            r25 = r2
            r26 = r6
            r31 = r7
            r43 = r8
            r27 = r9
            r30 = r11
        L_0x066b:
            com.baidu.searchbox.config.FontSizeHelper r1 = INSTANCE
            r2 = 0
            com.baidu.searchbox.config.impl.IFontSizeBusiness r4 = com.baidu.searchbox.config.impl.FontSizeRuntime.getFontSizeBusiness()
            boolean r1 = r4.isDebug()
            if (r1 == 0) goto L_0x067b
            r0.printStackTrace()
        L_0x067b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0689
        L_0x0681:
            r25 = r2
            r26 = r6
            r43 = r8
            r30 = r11
        L_0x0689:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r30
        L_0x068e:
            goto L_0x0698
        L_0x0691:
            r17 = r6
            r21 = r7
            r24 = r8
            r0 = 0
        L_0x0698:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getScaledStateListDrawable(int, android.graphics.drawable.Drawable, int, int, int):android.graphics.drawable.Drawable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: android.graphics.drawable.BitmapDrawable[]} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T extends android.graphics.drawable.Drawable> T getMListDrawable(T r29, float r30, float r31, int r32) {
        /*
            r28 = this;
            r1 = 0
            android.graphics.drawable.LevelListDrawable r0 = new android.graphics.drawable.LevelListDrawable
            r0.<init>()
            r2 = r0
            r3 = r29
            r4 = 0
            android.graphics.drawable.Drawable$ConstantState r0 = r3.getConstantState()
            if (r0 == 0) goto L_0x0179
            r5 = r0
            r6 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0163 }
            r0 = r3
            r7 = 0
            java.lang.Class r8 = r5.getClass()     // Catch:{ all -> 0x0163 }
            java.lang.String r9 = "getChildren"
            r10 = 0
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x0163 }
            java.lang.reflect.Method r8 = r8.getMethod(r9, r11)     // Catch:{ all -> 0x0163 }
            r9 = 1
            r8.setAccessible(r9)     // Catch:{ all -> 0x0163 }
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x0163 }
            java.lang.Object r11 = r8.invoke(r5, r11)     // Catch:{ all -> 0x0163 }
            boolean r12 = r11 instanceof java.lang.Object[]     // Catch:{ all -> 0x0163 }
            r13 = 0
            if (r12 == 0) goto L_0x0042
            java.lang.Object[] r11 = (java.lang.Object[]) r11     // Catch:{ all -> 0x0035 }
            goto L_0x0043
        L_0x0035:
            r0 = move-exception
            r20 = r1
            r21 = r3
            r24 = r4
            r25 = r5
            r23 = r6
            goto L_0x016e
        L_0x0042:
            r11 = r13
        L_0x0043:
            if (r11 == 0) goto L_0x0151
            r12 = 0
            r13 = 0
            int r14 = r11.length     // Catch:{ all -> 0x0163 }
        L_0x0048:
            if (r10 >= r14) goto L_0x0142
            r15 = r11[r10]     // Catch:{ all -> 0x0163 }
            int r16 = r13 + 1
            r17 = r15
            r18 = 0
            r9 = r17
            r17 = r0
            boolean r0 = r9 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0163 }
            if (r0 == 0) goto L_0x0123
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ all -> 0x0163 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0163 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x0163 }
            int r0 = r0.densityDpi     // Catch:{ all -> 0x0163 }
            r19 = 160(0xa0, float:2.24E-43)
            int r20 = r0 / r19
            r21 = r20
            r20 = r9
            android.graphics.drawable.BitmapDrawable r20 = (android.graphics.drawable.BitmapDrawable) r20     // Catch:{ all -> 0x0163 }
            r22 = r0
            android.graphics.Bitmap r0 = r20.getBitmap()     // Catch:{ all -> 0x0163 }
            r20 = r1
            r1 = r21
            r21 = r3
            float r3 = (float) r1
            float r3 = r3 * r30
            float r3 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r3)     // Catch:{ all -> 0x011b }
            r23 = 0
            switch(r32) {
                case 0: goto L_0x00b5;
                case 1: goto L_0x00a9;
                case 2: goto L_0x0093;
                default: goto L_0x008a;
            }
        L_0x008a:
            r24 = r4
            r25 = r5
            int r4 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ all -> 0x0116 }
            goto L_0x00c6
        L_0x0093:
            int r24 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ all -> 0x00a0 }
            r25 = r5
            r27 = r24
            r24 = r4
            r4 = r27
            goto L_0x00c6
        L_0x00a0:
            r0 = move-exception
            r24 = r4
            r25 = r5
            r23 = r6
            goto L_0x016e
        L_0x00a9:
            r24 = r4
            r25 = r5
            double r4 = (double) r3
            double r4 = java.lang.Math.floor(r4)     // Catch:{ all -> 0x00c1 }
            float r4 = (float) r4     // Catch:{ all -> 0x00c1 }
            int r4 = (int) r4     // Catch:{ all -> 0x00c1 }
            goto L_0x00c6
        L_0x00b5:
            r24 = r4
            r25 = r5
            double r4 = (double) r3     // Catch:{ all -> 0x00c1 }
            double r4 = java.lang.Math.ceil(r4)     // Catch:{ all -> 0x00c1 }
            float r4 = (float) r4
            int r4 = (int) r4
            goto L_0x00c6
        L_0x00c1:
            r0 = move-exception
            r23 = r6
            goto L_0x016e
        L_0x00c6:
            float r3 = (float) r1
            float r3 = r3 * r31
            float r3 = com.baidu.searchbox.config.utils.DisplayUtilsKt.toStandardScreen(r3)     // Catch:{ all -> 0x0116 }
            r5 = 0
            switch(r32) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00e6;
                case 2: goto L_0x00db;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            r26 = r5
            r23 = r6
            int r5 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ all -> 0x0161 }
            goto L_0x00fd
        L_0x00db:
            int r23 = kotlin.math.MathKt.roundToInt((float) r3)     // Catch:{ all -> 0x00c1 }
            r26 = r5
            r5 = r23
            r23 = r6
            goto L_0x00fd
        L_0x00e6:
            r26 = r5
            r23 = r6
            double r5 = (double) r3
            double r5 = java.lang.Math.floor(r5)     // Catch:{ all -> 0x0161 }
            float r5 = (float) r5     // Catch:{ all -> 0x0161 }
            int r5 = (int) r5     // Catch:{ all -> 0x0161 }
            goto L_0x00fd
        L_0x00f2:
            r26 = r5
            r23 = r6
            double r5 = (double) r3     // Catch:{ all -> 0x0161 }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ all -> 0x0161 }
            float r5 = (float) r5     // Catch:{ all -> 0x0161 }
            int r5 = (int) r5     // Catch:{ all -> 0x0161 }
        L_0x00fd:
            r3 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r4, r5, r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "createScaledBitmap(\n    …                        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ all -> 0x0161 }
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0161 }
            r4.<init>(r0)     // Catch:{ all -> 0x0161 }
            r5 = r4
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch:{ all -> 0x0161 }
            r2.addLevel(r13, r13, r5)     // Catch:{ all -> 0x0161 }
            goto L_0x012e
        L_0x0116:
            r0 = move-exception
            r23 = r6
            goto L_0x016e
        L_0x011b:
            r0 = move-exception
            r24 = r4
            r25 = r5
            r23 = r6
            goto L_0x016e
        L_0x0123:
            r20 = r1
            r21 = r3
            r24 = r4
            r25 = r5
            r23 = r6
            r3 = 1
        L_0x012e:
            int r10 = r10 + 1
            r9 = r3
            r13 = r16
            r0 = r17
            r1 = r20
            r3 = r21
            r6 = r23
            r4 = r24
            r5 = r25
            goto L_0x0048
        L_0x0142:
            r17 = r0
            r20 = r1
            r21 = r3
            r24 = r4
            r25 = r5
            r23 = r6
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0161 }
            goto L_0x015d
        L_0x0151:
            r17 = r0
            r20 = r1
            r21 = r3
            r24 = r4
            r25 = r5
            r23 = r6
        L_0x015d:
            kotlin.Result.m8971constructorimpl(r13)     // Catch:{ all -> 0x0161 }
            goto L_0x0177
        L_0x0161:
            r0 = move-exception
            goto L_0x016e
        L_0x0163:
            r0 = move-exception
            r20 = r1
            r21 = r3
            r24 = r4
            r25 = r5
            r23 = r6
        L_0x016e:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x0177:
            goto L_0x017f
        L_0x0179:
            r20 = r1
            r21 = r3
            r24 = r4
        L_0x017f:
            r0 = r2
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.config.FontSizeHelper.getMListDrawable(android.graphics.drawable.Drawable, float, float, int):android.graphics.drawable.Drawable");
    }

    private final void scaledGradientDrawable(int type, GradientDrawable gradientDrawable, int baseFontSize, int targetFontSize) {
        Object originalRadius;
        boolean z;
        Scaled1DSizeInfo scaled1DSizeInfo;
        float f2;
        int i2 = type;
        int i3 = targetFontSize;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                originalRadius = Float.valueOf(gradientDrawable.getCornerRadius());
            } else {
                originalRadius = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
            }
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + originalRadius);
            }
            if (!(originalRadius instanceof Float) || ((Number) originalRadius).floatValue() <= 0.0f) {
                GradientDrawable gradientDrawable2 = gradientDrawable;
                return;
            }
            float size$iv = ((Number) originalRadius).floatValue();
            if (i3 == 1) {
                z = false;
            } else if (i2 == 0 && i3 == 0) {
                z = false;
            } else {
                if (!(i3 >= 0 && i3 < 5)) {
                    z = false;
                } else if ((i2 <= -1 || i2 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            float f3 = 1.0f;
            if (!z) {
                scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, size$iv);
            } else {
                switch (i2) {
                    case 0:
                        f3 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        break;
                    case 1:
                        f3 = SCALED_RATIO_CONTENT[i3].floatValue();
                        break;
                    case 2:
                        f3 = SCALED_RATIO_H[i3].floatValue();
                        break;
                    case 3:
                        f3 = SCALED_RATIO_T[i3].floatValue();
                        break;
                    default:
                        if (mCustomerRatios.containsKey(Integer.valueOf(type))) {
                            Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type));
                            if ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv == null) {
                                break;
                            } else {
                                f3 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[i3].floatValue();
                                break;
                            }
                        }
                        break;
                }
                float ratio$iv$iv = f3;
                scaled1DSizeInfo = new Scaled1DSizeInfo(true, ratio$iv$iv, size$iv * ratio$iv$iv);
            }
            Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv = scaled1DSizeInfo;
            if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
                f2 = size$iv;
            } else {
                f2 = $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
            }
            try {
                gradientDrawable.setCornerRadius(f2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                e.printStackTrace();
            }
        }
    }

    private final NinePatchDrawable getScaledNinePatchDrawable(int type, NinePatchDrawable ninePatchDrawable, int baseFontSize, int targetFontSize) {
        boolean z;
        Scaled1DSizeInfo scaled1DSizeInfo;
        float f2;
        int i2 = type;
        int i3 = targetFontSize;
        if (ninePatchDrawable == null) {
            return null;
        }
        NinePatchDrawable $this$getScaledNinePatchDrawable_u24lambda_u2d24 = ninePatchDrawable;
        try {
            FontSizeHelper this_$iv$iv = INSTANCE;
            FontSizeHelper fontSizeHelper = this_$iv$iv;
            if (i3 == 1) {
                z = false;
            } else if (i2 == 0 && i3 == 0) {
                z = false;
            } else {
                if (!(i3 >= 0 && i3 < 5)) {
                    z = false;
                } else if ((i2 <= -1 || i2 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            float f3 = 1.0f;
            if (!z) {
                scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
            } else {
                FontSizeHelper fontSizeHelper2 = this_$iv$iv;
                switch (i2) {
                    case 0:
                        f3 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        break;
                    case 1:
                        f3 = SCALED_RATIO_CONTENT[i3].floatValue();
                        break;
                    case 2:
                        f3 = SCALED_RATIO_H[i3].floatValue();
                        break;
                    case 3:
                        f3 = SCALED_RATIO_T[i3].floatValue();
                        break;
                    default:
                        if (mCustomerRatios.containsKey(Integer.valueOf(type))) {
                            Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type));
                            if ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv == null) {
                                break;
                            } else {
                                f3 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[i3].floatValue();
                                break;
                            }
                        }
                        break;
                }
                float ratio$iv$iv = f3;
                scaled1DSizeInfo = new Scaled1DSizeInfo(true, ratio$iv$iv, 1.0f * ratio$iv$iv);
            }
            Scaled1DSizeInfo $this$getScaledSizeInner_u24lambda_u2d7$iv = scaled1DSizeInfo;
            if (!$this$getScaledSizeInner_u24lambda_u2d7$iv.isScaledRequired()) {
                f2 = 1.0f;
            } else {
                f2 = $this$getScaledSizeInner_u24lambda_u2d7$iv.getScaledSize();
            }
            float scaled = f2;
            int displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
            $this$getScaledNinePatchDrawable_u24lambda_u2d24.setTargetDensity((int) (((float) displayMetrics) * scaled));
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                Log.d(TAG, "scaled: " + scaled + ", displayMetrics: " + displayMetrics + ", result: " + (((float) displayMetrics) * scaled));
            }
        } catch (Exception e2) {
            FontSizeHelper fontSizeHelper3 = INSTANCE;
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e2.printStackTrace();
            }
        }
        return ninePatchDrawable;
    }

    private final Drawable getScaledDrawableNotSafe(int type, Drawable drawable, int baseFontSize, int targetFontSize, int numRoundPolicy) throws Exception {
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Bitmap.Config config$iv;
        int i2;
        int i3;
        float f2;
        int i4 = type;
        int i5 = targetFontSize;
        if (drawable != null) {
            Drawable drawable2 = drawable;
            FontSizeHelper this_$iv$iv = INSTANCE;
            float width$iv$iv = DisplayUtilsKt.toStandardScreen((float) drawable.getIntrinsicWidth());
            float height$iv$iv = DisplayUtilsKt.toStandardScreen((float) drawable.getIntrinsicHeight());
            FontSizeHelper fontSizeHelper = this_$iv$iv;
            if (i5 == 1) {
                z = false;
            } else if (i4 == 0 && i5 == 0) {
                z = false;
            } else {
                if (!(i5 >= 0 && i5 < 5)) {
                    z = false;
                } else if ((i4 <= -1 || i4 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv$iv, height$iv$iv);
            } else {
                FontSizeHelper fontSizeHelper2 = this_$iv$iv;
                switch (i4) {
                    case 0:
                        f2 = SCALED_RATIO_FRAMEWORK[i5].floatValue();
                        break;
                    case 1:
                        f2 = SCALED_RATIO_CONTENT[i5].floatValue();
                        break;
                    case 2:
                        f2 = SCALED_RATIO_H[i5].floatValue();
                        break;
                    case 3:
                        f2 = SCALED_RATIO_T[i5].floatValue();
                        break;
                    default:
                        if (!mCustomerRatios.containsKey(Integer.valueOf(type))) {
                            f2 = 1.0f;
                            break;
                        } else {
                            Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type));
                            if ($this$getScaledRatio_u24lambda_u2d28$iv$iv$iv == null) {
                                f2 = 1.0f;
                                break;
                            } else {
                                f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv$iv[i5].floatValue();
                                break;
                            }
                        }
                }
                float ratio$iv$iv = f2;
                scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv$iv * ratio$iv$iv, height$iv$iv * ratio$iv$iv);
            }
            Scaled2DSizeInfo $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv = scaled2DSizeInfo;
            if (!$this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.isScaledRequired()) {
                return drawable;
            }
            float dstWidth = $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.getScaledWidth();
            float dstHeight = $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26$iv.getScaledHeight();
            Drawable srcDrawable = drawable;
            FontSizeHelper fontSizeHelper3 = INSTANCE;
            int width$iv = srcDrawable.getIntrinsicWidth();
            int height$iv = srcDrawable.getIntrinsicHeight();
            if (srcDrawable.getOpacity() != -1) {
                config$iv = Bitmap.Config.ARGB_8888;
            } else {
                config$iv = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width$iv, height$iv, config$iv);
            Bitmap.Config config = config$iv;
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
            Bitmap bitmap$iv = createBitmap;
            Canvas canvas$iv = new Canvas(bitmap$iv);
            srcDrawable.setBounds(0, 0, width$iv, height$iv);
            srcDrawable.draw(canvas$iv);
            float $this$roundByPolicy$iv = dstWidth;
            switch (numRoundPolicy) {
                case 0:
                    i2 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv));
                    break;
                case 1:
                    i2 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv));
                    break;
                case 2:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
                default:
                    i2 = MathKt.roundToInt($this$roundByPolicy$iv);
                    break;
            }
            float $this$roundByPolicy$iv2 = dstHeight;
            switch (numRoundPolicy) {
                case 0:
                    i3 = (int) ((float) Math.ceil((double) $this$roundByPolicy$iv2));
                    break;
                case 1:
                    i3 = (int) ((float) Math.floor((double) $this$roundByPolicy$iv2));
                    break;
                case 2:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
                default:
                    i3 = MathKt.roundToInt($this$roundByPolicy$iv2);
                    break;
            }
            Bitmap dstBitmap = Bitmap.createScaledBitmap(bitmap$iv, i2, i3, true);
            Intrinsics.checkNotNullExpressionValue(dstBitmap, "createScaledBitmap(\n    …       true\n            )");
            return new BitmapDrawable(AppRuntime.getAppContext().getResources(), dstBitmap);
        }
        return null;
    }

    private final <T extends Drawable> T getDrawableWithScaledOperation(int type, T srcDrawable, int baseFontSize, int targetFontSize, Function3<? super Float, ? super Float, ? super T, ? extends T> scaledOperation) {
        FontSizeHelper this_$iv$iv;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv$iv;
        int i2 = type;
        T t = srcDrawable;
        int i3 = targetFontSize;
        if (t != null) {
            T t2 = srcDrawable;
            FontSizeHelper this_$iv = INSTANCE;
            float width$iv = DisplayUtilsKt.toStandardScreen((float) srcDrawable.getIntrinsicWidth());
            float height$iv = DisplayUtilsKt.toStandardScreen((float) srcDrawable.getIntrinsicHeight());
            FontSizeHelper fontSizeHelper = this_$iv;
            if (i3 == 1) {
                this_$iv$iv = null;
            } else if (i2 == 0 && i3 == 0) {
                this_$iv$iv = null;
            } else {
                if (((i3 < 0 || i3 >= 5) ? 0 : 1) == 0) {
                    this_$iv$iv = null;
                } else if ((i2 <= -1 || i2 >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                    this_$iv$iv = null;
                } else {
                    this_$iv$iv = 1;
                }
            }
            if (this_$iv$iv == null) {
                scaled2DSizeInfo = new Scaled2DSizeInfo(false, width$iv, height$iv);
            } else {
                FontSizeHelper fontSizeHelper2 = this_$iv;
                float f2 = 1.0f;
                switch (i2) {
                    case 0:
                        f2 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        break;
                    case 1:
                        f2 = SCALED_RATIO_CONTENT[i3].floatValue();
                        break;
                    case 2:
                        f2 = SCALED_RATIO_H[i3].floatValue();
                        break;
                    case 3:
                        f2 = SCALED_RATIO_T[i3].floatValue();
                        break;
                    default:
                        if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                            f2 = $this$getScaledRatio_u24lambda_u2d28$iv$iv[i3].floatValue();
                            break;
                        }
                }
                float ratio$iv = f2;
                scaled2DSizeInfo = new Scaled2DSizeInfo(true, width$iv * ratio$iv, height$iv * ratio$iv);
            }
            Scaled2DSizeInfo $this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26 = scaled2DSizeInfo;
            if (!$this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26.isScaledRequired()) {
                Function3<? super Float, ? super Float, ? super T, ? extends T> function3 = scaledOperation;
                return t;
            }
            return (Drawable) scaledOperation.invoke(Float.valueOf($this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26.getScaledWidth()), Float.valueOf($this$getDrawableWithScaledOperation_u24lambda_u2d27_u24lambda_u2d26.getScaledHeight()), t);
        }
        Function3<? super Float, ? super Float, ? super T, ? extends T> function32 = scaledOperation;
        return null;
    }

    private final Bitmap parseDrawableToBitmap(Drawable drawable) throws Exception {
        Bitmap.Config config;
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    private final Scaled1DSizeInfo getScaled1DSizeInfo(int type, float size, int baseFontSize, int targetFontSize) {
        FontSizeHelper this_$iv;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv;
        if (targetFontSize == 1) {
            this_$iv = null;
        } else if (type == 0 && targetFontSize == 0) {
            this_$iv = null;
        } else {
            if (((targetFontSize < 0 || targetFontSize >= 5) ? 0 : 1) == 0) {
                this_$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv = null;
            } else {
                this_$iv = 1;
            }
        }
        float f2 = 1.0f;
        if (this_$iv == null) {
            return new Scaled1DSizeInfo(false, 1.0f, size);
        }
        switch (type) {
            case 0:
                f2 = SCALED_RATIO_FRAMEWORK[targetFontSize].floatValue();
                break;
            case 1:
                f2 = SCALED_RATIO_CONTENT[targetFontSize].floatValue();
                break;
            case 2:
                f2 = SCALED_RATIO_H[targetFontSize].floatValue();
                break;
            case 3:
                f2 = SCALED_RATIO_T[targetFontSize].floatValue();
                break;
            default:
                if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                    f2 = $this$getScaledRatio_u24lambda_u2d28$iv[targetFontSize].floatValue();
                    break;
                }
        }
        float ratio = f2;
        return new Scaled1DSizeInfo(true, ratio, size * ratio);
    }

    private final Scaled2DSizeInfo getScaled2DSizeInfo(int type, float width, float height, int baseFontSize, int targetFontSize) {
        FontSizeHelper this_$iv;
        Float[] $this$getScaledRatio_u24lambda_u2d28$iv;
        if (targetFontSize == 1) {
            this_$iv = null;
        } else if (type == 0 && targetFontSize == 0) {
            this_$iv = null;
        } else {
            if (((targetFontSize < 0 || targetFontSize >= 5) ? 0 : 1) == 0) {
                this_$iv = null;
            } else if ((type <= -1 || type >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(type))) {
                this_$iv = null;
            } else {
                this_$iv = 1;
            }
        }
        if (this_$iv == null) {
            return new Scaled2DSizeInfo(false, width, height);
        }
        float f2 = 1.0f;
        switch (type) {
            case 0:
                f2 = SCALED_RATIO_FRAMEWORK[targetFontSize].floatValue();
                break;
            case 1:
                f2 = SCALED_RATIO_CONTENT[targetFontSize].floatValue();
                break;
            case 2:
                f2 = SCALED_RATIO_H[targetFontSize].floatValue();
                break;
            case 3:
                f2 = SCALED_RATIO_T[targetFontSize].floatValue();
                break;
            default:
                if (mCustomerRatios.containsKey(Integer.valueOf(type)) && ($this$getScaledRatio_u24lambda_u2d28$iv = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) != null) {
                    f2 = $this$getScaledRatio_u24lambda_u2d28$iv[targetFontSize].floatValue();
                    break;
                }
        }
        float ratio = f2;
        return new Scaled2DSizeInfo(true, width * ratio, height * ratio);
    }

    private final float getScaledRatio(int type, int targetFontSize) {
        Float[] $this$getScaledRatio_u24lambda_u2d28;
        switch (type) {
            case 0:
                return SCALED_RATIO_FRAMEWORK[targetFontSize].floatValue();
            case 1:
                return SCALED_RATIO_CONTENT[targetFontSize].floatValue();
            case 2:
                return SCALED_RATIO_H[targetFontSize].floatValue();
            case 3:
                return SCALED_RATIO_T[targetFontSize].floatValue();
            default:
                if (!mCustomerRatios.containsKey(Integer.valueOf(type)) || ($this$getScaledRatio_u24lambda_u2d28 = (Float[]) mCustomerRatios.get(Integer.valueOf(type))) == null) {
                    return 1.0f;
                }
                return $this$getScaledRatio_u24lambda_u2d28[targetFontSize].floatValue();
        }
    }

    private final boolean checkScaledRequired(int type, int baseFontSize, int targetFontSize) {
        if (targetFontSize == 1) {
            return false;
        }
        if (type == 0 && targetFontSize == 0) {
            return false;
        }
        if (((targetFontSize < 0 || targetFontSize >= 5) ? 0 : 1) == 0) {
            return false;
        }
        return (type > -1 && type < 4) || mCustomerRatios.containsKey(Integer.valueOf(type));
    }

    private final int getTargetLevel() {
        if (!FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            return 1;
        }
        return mTargetLevel;
    }

    public final void setTargetLevel(int level) {
        mTargetLevel = level;
    }

    @JvmStatic
    public static final void reloadTargetLevelFromSp() {
        mTargetLevel = FontSizeSharedPrefs.INSTANCE.getInt("key_text_size", 1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper$Scaled1DSizeInfo;", "", "isScaledRequired", "", "ratio", "", "scaledSize", "(ZFF)V", "()Z", "getRatio", "()F", "getScaledSize", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FontSizeHelper.kt */
    private static final class Scaled1DSizeInfo {
        private final boolean isScaledRequired;
        private final float ratio;
        private final float scaledSize;

        public static /* synthetic */ Scaled1DSizeInfo copy$default(Scaled1DSizeInfo scaled1DSizeInfo, boolean z, float f2, float f3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = scaled1DSizeInfo.isScaledRequired;
            }
            if ((i2 & 2) != 0) {
                f2 = scaled1DSizeInfo.ratio;
            }
            if ((i2 & 4) != 0) {
                f3 = scaled1DSizeInfo.scaledSize;
            }
            return scaled1DSizeInfo.copy(z, f2, f3);
        }

        public final boolean component1() {
            return this.isScaledRequired;
        }

        public final float component2() {
            return this.ratio;
        }

        public final float component3() {
            return this.scaledSize;
        }

        public final Scaled1DSizeInfo copy(boolean z, float f2, float f3) {
            return new Scaled1DSizeInfo(z, f2, f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Scaled1DSizeInfo)) {
                return false;
            }
            Scaled1DSizeInfo scaled1DSizeInfo = (Scaled1DSizeInfo) obj;
            return this.isScaledRequired == scaled1DSizeInfo.isScaledRequired && Intrinsics.areEqual((Object) Float.valueOf(this.ratio), (Object) Float.valueOf(scaled1DSizeInfo.ratio)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaledSize), (Object) Float.valueOf(scaled1DSizeInfo.scaledSize));
        }

        public int hashCode() {
            boolean z = this.isScaledRequired;
            if (z) {
                z = true;
            }
            return ((((z ? 1 : 0) * true) + Float.hashCode(this.ratio)) * 31) + Float.hashCode(this.scaledSize);
        }

        public String toString() {
            return "Scaled1DSizeInfo(isScaledRequired=" + this.isScaledRequired + ", ratio=" + this.ratio + ", scaledSize=" + this.scaledSize + ')';
        }

        public Scaled1DSizeInfo(boolean isScaledRequired2, float ratio2, float scaledSize2) {
            this.isScaledRequired = isScaledRequired2;
            this.ratio = ratio2;
            this.scaledSize = scaledSize2;
        }

        public final float getRatio() {
            return this.ratio;
        }

        public final float getScaledSize() {
            return this.scaledSize;
        }

        public final boolean isScaledRequired() {
            return this.isScaledRequired;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper$Scaled2DSizeInfo;", "", "isScaledRequired", "", "scaledWidth", "", "scaledHeight", "(ZFF)V", "()Z", "getScaledHeight", "()F", "getScaledWidth", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FontSizeHelper.kt */
    private static final class Scaled2DSizeInfo {
        private final boolean isScaledRequired;
        private final float scaledHeight;
        private final float scaledWidth;

        public static /* synthetic */ Scaled2DSizeInfo copy$default(Scaled2DSizeInfo scaled2DSizeInfo, boolean z, float f2, float f3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = scaled2DSizeInfo.isScaledRequired;
            }
            if ((i2 & 2) != 0) {
                f2 = scaled2DSizeInfo.scaledWidth;
            }
            if ((i2 & 4) != 0) {
                f3 = scaled2DSizeInfo.scaledHeight;
            }
            return scaled2DSizeInfo.copy(z, f2, f3);
        }

        public final boolean component1() {
            return this.isScaledRequired;
        }

        public final float component2() {
            return this.scaledWidth;
        }

        public final float component3() {
            return this.scaledHeight;
        }

        public final Scaled2DSizeInfo copy(boolean z, float f2, float f3) {
            return new Scaled2DSizeInfo(z, f2, f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Scaled2DSizeInfo)) {
                return false;
            }
            Scaled2DSizeInfo scaled2DSizeInfo = (Scaled2DSizeInfo) obj;
            return this.isScaledRequired == scaled2DSizeInfo.isScaledRequired && Intrinsics.areEqual((Object) Float.valueOf(this.scaledWidth), (Object) Float.valueOf(scaled2DSizeInfo.scaledWidth)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaledHeight), (Object) Float.valueOf(scaled2DSizeInfo.scaledHeight));
        }

        public int hashCode() {
            boolean z = this.isScaledRequired;
            if (z) {
                z = true;
            }
            return ((((z ? 1 : 0) * true) + Float.hashCode(this.scaledWidth)) * 31) + Float.hashCode(this.scaledHeight);
        }

        public String toString() {
            return "Scaled2DSizeInfo(isScaledRequired=" + this.isScaledRequired + ", scaledWidth=" + this.scaledWidth + ", scaledHeight=" + this.scaledHeight + ')';
        }

        public Scaled2DSizeInfo(boolean isScaledRequired2, float scaledWidth2, float scaledHeight2) {
            this.isScaledRequired = isScaledRequired2;
            this.scaledWidth = scaledWidth2;
            this.scaledHeight = scaledHeight2;
        }

        public final boolean isScaledRequired() {
            return this.isScaledRequired;
        }

        public final float getScaledWidth() {
            return this.scaledWidth;
        }

        public final float getScaledHeight() {
            return this.scaledHeight;
        }
    }

    private final boolean isDebug() {
        return FontSizeRuntime.getFontSizeBusiness().isDebug();
    }
}
