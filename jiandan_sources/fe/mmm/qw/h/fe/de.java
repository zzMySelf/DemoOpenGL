package fe.mmm.qw.h.fe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.mars.kotlin.extension.LoggerKt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    public final List<ad> ad(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (T next : list) {
            if (new File((String) next).exists()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            arrayList2.add(new ad(str, options, options.outHeight, options.outWidth, 0, 0));
        }
        return arrayList2;
    }

    @Nullable
    public final String de(@NotNull List<String> list, @NotNull String str) {
        Bitmap createBitmap;
        Object obj;
        String str2 = str;
        Intrinsics.checkNotNullParameter(list, "images");
        Intrinsics.checkNotNullParameter(str2, "destFile");
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (new File((String) next).exists()) {
                arrayList.add(next);
            }
        }
        List<ad> ad2 = ad(list);
        int i2 = 0;
        for (ad rg2 : ad2) {
            i2 = RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(i2, rg2.rg()), 1000);
        }
        int i3 = 0;
        for (ad next2 : ad2) {
            if (next2.rg() != 0) {
                next2.th((next2.fe() * i2) / ((int) (((double) next2.rg()) * 1.0d)));
                i3 += next2.ad();
                next2.yj(i2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("merge_image >> 初步计算宽=");
        sb.append(i2);
        sb.append(" 高=");
        sb.append(i3);
        sb.append(" 占用内存:");
        int i4 = i2 * i3 * 2;
        sb.append(i4);
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        if (i4 > 52428800) {
            double d = ((double) i4) * 1.0d;
            if (!(d == 0.0d)) {
                double sqrt = Math.sqrt(((double) 52428800) / d);
                i2 = (int) (((double) i2) * sqrt);
                i3 = (int) (sqrt * ((double) i3));
                LoggerKt.d$default("merge_image >> 初步计算宽=" + i2 + " 高=" + i3 + " 内存大于MAX:52428800，调整后 width=" + i2 + "，高=" + i3, (Object) null, 1, (Object) null);
                for (ad next3 : ad2) {
                    if (next3.rg() != 0) {
                        next3.th((next3.fe() * i2) / ((int) (((double) next3.rg()) * 1.0d)));
                        next3.yj(i2);
                    }
                }
            }
        }
        if (i2 <= 0 || i3 <= 0 || (createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565)) == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        try {
            Result.Companion companion = Result.Companion;
            int i5 = 0;
            for (ad adVar : ad2) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = qw(options, adVar.de(), adVar.ad());
                Bitmap decodeFile = BitmapFactory.decodeFile(adVar.qw(), options);
                canvas.drawBitmap(decodeFile, (Rect) null, new Rect(0, i5, i2, adVar.ad() + i5), (Paint) null);
                decodeFile.recycle();
                i5 += adVar.ad();
            }
            obj = Result.m1155constructorimpl(ad2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
        if (r0 != null) {
            LoggerKt.d$default("merge_image >> 合并图片失败，目标宽度=" + i2 + "，目标高度=" + i3 + ", 图片数量:" + ad2.size() + " 异常信息：" + r0.getClass() + " - " + r0.getMessage() + 65292, (Object) null, 1, (Object) null);
        }
        String fe2 = fe(createBitmap, str2);
        LoggerKt.d$default("merge_image >> 合并图片结果 " + fe2, (Object) null, 1, (Object) null);
        return fe2;
    }

    public final String fe(Bitmap bitmap, String str) {
        Object obj;
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        String str2 = null;
        try {
            Result.Companion companion = Result.Companion;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            bitmap.recycle();
            LoggerKt.d$default("merge_image >> 已保存到本地 " + str, (Object) null, 1, (Object) null);
            obj = Result.m1155constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r7 = Result.m1158exceptionOrNullimpl(obj);
        if (r7 != null) {
            LoggerKt.d$default("merge_image >> 保存到本地失败：" + r7.getClass() + " - " + r7.getMessage(), (Object) null, 1, (Object) null);
            fileOutputStream.close();
        }
        if (Result.m1162isSuccessimpl(obj)) {
            String str3 = (String) obj;
            fileOutputStream.close();
        }
        if (!Result.m1161isFailureimpl(obj)) {
            str2 = obj;
        }
        return str2;
    }

    public final int qw(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }
}
