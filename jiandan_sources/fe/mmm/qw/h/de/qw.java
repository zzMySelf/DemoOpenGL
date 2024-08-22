package fe.mmm.qw.h.de;

import android.content.Context;
import android.os.Environment;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    public static /* synthetic */ String rg(qw qwVar, long j, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "yyyyMMdd_HHmmss";
        }
        return qwVar.fe(j, str);
    }

    @Nullable
    public final String ad(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DocumentViewerActivity.KEY_SUFFIX);
        String de2 = ArraysKt___ArraysKt.contains((T[]) new String[]{"png", "JPG"}, str) ? de(context) : qw(context);
        if (de2 == null) {
            return null;
        }
        String str2 = "TeraScan_" + rg(this, System.currentTimeMillis(), (String) null, 2, (Object) null);
        String str3 = de2 + '/' + str2 + '.' + str;
        int i2 = 0;
        while (new File(str3).exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(de2);
            sb.append('/');
            sb.append(str2);
            sb.append('(');
            i2++;
            sb.append(i2);
            sb.append(").");
            sb.append(str);
            str3 = sb.toString();
        }
        return str3;
    }

    @Nullable
    public final String de(@NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String str = null;
        String path = externalFilesDir != null ? externalFilesDir.getPath() : null;
        if (path == null) {
            return null;
        }
        String str2 = path + "/export";
        try {
            Result.Companion companion = Result.Companion;
            if (!new File(str2).exists()) {
                new File(str2).mkdirs();
            }
            obj = Result.m1155constructorimpl(str2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m1161isFailureimpl(obj)) {
            str = obj;
        }
        return str;
    }

    public final String fe(long j, String str) {
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(date)");
        return format;
    }

    @Nullable
    public final String qw(@NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        String str = null;
        String path = externalFilesDir != null ? externalFilesDir.getPath() : null;
        if (path == null) {
            return null;
        }
        String str2 = path + "/export";
        try {
            Result.Companion companion = Result.Companion;
            if (!new File(str2).exists()) {
                new File(str2).mkdirs();
            }
            obj = Result.m1155constructorimpl(str2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m1161isFailureimpl(obj)) {
            str = obj;
        }
        return str;
    }

    @NotNull
    public final String th(@NotNull String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "parentDir");
        String fe2 = fe(System.currentTimeMillis(), "yyyyMMddHHmmssSSS");
        String str2 = fe2 + i2 + ".jpg";
        int i3 = 0;
        while (new File(str, str2).exists()) {
            i3++;
            str2 = fe2 + i2 + i3 + ".jpg";
        }
        String absolutePath = new File(str, str2).getAbsolutePath();
        LoggerKt.d$default("缓存路径 >> 扫描图片压缩路径 " + absolutePath, (Object) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(absolutePath, "path");
        return absolutePath;
    }

    @Nullable
    public final String yj(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            return null;
        }
        File file = new File(externalCacheDir.getPath(), "scan/source");
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
