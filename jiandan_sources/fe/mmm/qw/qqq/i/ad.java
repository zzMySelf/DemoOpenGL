package fe.mmm.qw.qqq.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import fe.mmm.qw.i.qw;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    @Nullable
    public final Bitmap ad(@NotNull String str, double d, double d2, double d3, @NotNull String str2, int i2, int i3) {
        Bitmap bitmap;
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "watermarkText");
        Intrinsics.checkNotNullParameter(str4, "watermarkTextColor");
        if (!fe(str4)) {
            str4 = "000000";
        }
        float f = (float) (d * d2);
        float max = Math.max(0.56f * f, 56.0f) * 1.1f;
        float f2 = 3.5f * f;
        int max2 = (int) (((float) Math.max(i2, i3)) * 1.414f);
        Paint paint = new Paint(1);
        Rect rect = new Rect();
        paint.setTextSize(f);
        paint.setLetterSpacing(0.002f);
        paint.getTextBounds(str3, 0, str.length(), rect);
        int width = rect.width();
        try {
            bitmap = Bitmap.createBitmap(max2, max2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(0);
                paint.setColor(Color.parseColor('#' + str4));
                paint.setAlpha((int) (((double) 255.0f) * d3));
                paint.setDither(true);
                paint.setFilterBitmap(true);
                float f3 = ((float) max2) / 2.0f;
                canvas.translate(-(f3 - (((float) i2) / 2.0f)), -(f3 - (((float) i3) / 2.0f)));
                canvas.rotate(-45.0f, f3, f3);
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                for (int i4 = 0; i4 <= max2; i4 = (int) (((float) (i4 + width)) + max)) {
                    int i5 = -(fontMetricsInt.bottom + fontMetricsInt.top);
                    int i6 = 0;
                    while (i5 <= max2) {
                        if (i6 % 2 == 0) {
                            canvas.drawText(str3, (float) i4, (float) i5, paint);
                        } else {
                            canvas.drawText(str3, (float) ((width / 2) + i4), (float) i5, paint);
                        }
                        i5 = (int) (((float) i5) + f2);
                        i6++;
                    }
                }
                canvas.save();
            } catch (OutOfMemoryError unused) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    return null;
                }
                return bitmap;
            }
        } catch (OutOfMemoryError unused2) {
            bitmap = null;
            bitmap.recycle();
            return null;
        }
        return bitmap;
    }

    @Nullable
    public final String de(@Nullable String str) {
        int lastIndexOf$default;
        if ((str == null || str.length() == 0) || (lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null)) <= -1 || lastIndexOf$default >= str.length()) {
            return str;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final boolean fe(String str) {
        if (str == null) {
            return false;
        }
        return new Regex("^[0-9a-fA-F]{6}$").matches(str);
    }

    @NotNull
    public final List<String> qw(@NotNull List<String> list, @NotNull String str, double d, double d2, double d3, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "images");
        Intrinsics.checkNotNullParameter(str, "watermarkText");
        Intrinsics.checkNotNullParameter(str2, "watermarkTextColor");
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str3);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt…B_8888) ?: return@forEach");
                Canvas canvas = new Canvas(createBitmap);
                Rect rect = new Rect(0, 0, width, height);
                canvas.drawBitmap(decodeFile, (Rect) null, rect, (Paint) null);
                Rect rect2 = rect;
                Bitmap bitmap = createBitmap;
                Canvas canvas2 = canvas;
                Bitmap bitmap2 = decodeFile;
                Bitmap ad2 = qw.ad(str, d, d2, d3, str2, width, height);
                if (ad2 != null) {
                    canvas2.drawBitmap(ad2, rect2, rect2, (Paint) null);
                    ad2.recycle();
                }
                Bitmap bitmap3 = bitmap;
                String rg2 = qw.rg(bitmap3, str3);
                if (rg2 != null) {
                    arrayList.add(rg2);
                    bitmap3.recycle();
                }
                bitmap2.recycle();
                String str4 = str;
                String str5 = str2;
            }
        }
        return arrayList;
    }

    @Nullable
    public final String rg(@NotNull Bitmap bitmap, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.close();
            return str;
        } catch (Exception e) {
            qw.th("", e.toString(), e);
            return null;
        }
    }
}
