package com.baidu.searchbox.account.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a8\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"toRoundCorner", "Landroid/graphics/Bitmap;", "bitmap", "corner", "", "topLeftCorner", "", "topRightCorner", "bottomLeftCorner", "bottomRightCorner", "lib-account_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BitmapUtils.kt */
public final class BitmapUtilsKt {
    public static final Bitmap toRoundCorner(Bitmap bitmap, float corner, boolean topLeftCorner, boolean topRightCorner, boolean bottomLeftCorner, boolean bottomRightCorner) {
        RectF rectf;
        Rect rect;
        Paint paint;
        Paint paint2;
        Rect rect2;
        RectF rectf2;
        Paint paint3;
        Rect rect3;
        Bitmap bitmap2 = bitmap;
        float f2 = corner;
        Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        Bitmap output = createBitmap;
        Canvas canvas = new Canvas(output);
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        Rect rect4 = new Rect(0, 0, output.getWidth(), output.getHeight());
        RectF rectf3 = new RectF(rect4);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectf3, f2, f2, paint4);
        if (!topLeftCorner) {
            canvas.drawRect(0.0f, rectf3.top, corner, rectf3.top - f2, paint4);
        }
        if (!topRightCorner) {
            rectf = rectf3;
            rect = rect4;
            paint = paint4;
            canvas.drawRect(rectf3.right - f2, rectf3.top, rectf3.right, rectf3.top - f2, paint4);
        } else {
            rectf = rectf3;
            rect = rect4;
            paint = paint4;
        }
        if (!bottomLeftCorner) {
            paint2 = paint;
            rect2 = rect;
            rectf2 = rectf;
            canvas.drawRect(0.0f, rectf.bottom - f2, corner, rectf.bottom, paint2);
        } else {
            paint2 = paint;
            rect2 = rect;
            rectf2 = rectf;
        }
        if (!bottomRightCorner) {
            float f3 = rectf2.right - f2;
            float f4 = rectf2.bottom - f2;
            float f5 = rectf2.right;
            float f6 = rectf2.bottom;
            RectF rectF = rectf2;
            float f7 = f5;
            rect3 = rect2;
            float f8 = f6;
            paint3 = paint2;
            canvas.drawRect(f3, f4, f7, f8, paint2);
        } else {
            rect3 = rect2;
            paint3 = paint2;
        }
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap2, rect3, rect3, paint3);
        return output;
    }
}
