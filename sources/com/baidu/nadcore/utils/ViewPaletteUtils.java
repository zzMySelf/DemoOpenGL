package com.baidu.nadcore.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nJ\u0014\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/nadcore/utils/ViewPaletteUtils;", "", "()V", "TAG", "", "asyncGenerateMainColor", "", "bitmap", "Landroid/graphics/Bitmap;", "callback", "Lcom/baidu/nadcore/utils/ViewPaletteUtils$GenerateMainColorCallback;", "view", "Landroid/view/View;", "buildDrawingCache", "generateMainColor", "", "GenerateMainColorCallback", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewPaletteUtils.kt */
public final class ViewPaletteUtils {
    public static final ViewPaletteUtils INSTANCE = new ViewPaletteUtils();
    private static final String TAG = "ViewPaletteUtils";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/nadcore/utils/ViewPaletteUtils$GenerateMainColorCallback;", "", "onGenerated", "", "color", "", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ViewPaletteUtils.kt */
    public interface GenerateMainColorCallback {
        void onGenerated(int i2);
    }

    private ViewPaletteUtils() {
    }

    public final int generateMainColor(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Bitmap bitmap = buildDrawingCache(view2);
        if (bitmap != null) {
            Palette.Swatch swatch = new Palette.Builder(bitmap).generate().getVibrantSwatch();
            if (swatch != null) {
                bitmap.recycle();
                return swatch.getRgb();
            }
            ViewPaletteUtils viewPaletteUtils = INSTANCE;
            bitmap.recycle();
            return -1;
        }
        ViewPaletteUtils viewPaletteUtils2 = this;
        return -1;
    }

    public final void asyncGenerateMainColor(View view2, GenerateMainColorCallback callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view2, "view");
        Bitmap it = buildDrawingCache(view2);
        if (it != null) {
            INSTANCE.asyncGenerateMainColor(it, callback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ViewPaletteUtils viewPaletteUtils = this;
        }
    }

    public final void asyncGenerateMainColor(Bitmap bitmap, GenerateMainColorCallback callback) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        new Palette.Builder(bitmap).generate(new ViewPaletteUtils$$ExternalSyntheticLambda0(callback, bitmap));
    }

    /* access modifiers changed from: private */
    /* renamed from: asyncGenerateMainColor$lambda-8  reason: not valid java name */
    public static final void m14264asyncGenerateMainColor$lambda8(GenerateMainColorCallback $callback, Bitmap $bitmap, Palette palette) {
        Unit unit;
        Palette.Swatch it;
        Intrinsics.checkNotNullParameter($bitmap, "$bitmap");
        if (palette == null || (it = palette.getVibrantSwatch()) == null) {
            unit = null;
        } else {
            if ($callback != null) {
                $callback.onGenerated(it.getRgb());
            }
            $bitmap.recycle();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ViewPaletteUtils viewPaletteUtils = INSTANCE;
            $bitmap.recycle();
        }
    }

    private final Bitmap buildDrawingCache(View view2) {
        try {
            Bitmap bitmap = Bitmap.createBitmap(view2.getMeasuredWidth(), view2.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            if (bitmap != null) {
                Bitmap it = bitmap;
                Canvas canvas = new Canvas(it);
                canvas.drawBitmap(it, 0.0f, (float) view2.getMeasuredHeight(), new Paint());
                view2.draw(canvas);
            }
            return bitmap;
        } catch (OutOfMemoryError e2) {
            return null;
        } catch (Exception e3) {
            return null;
        }
    }
}
