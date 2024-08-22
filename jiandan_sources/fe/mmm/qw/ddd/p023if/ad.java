package fe.mmm.qw.ddd.p023if;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.ddd.if.ad  reason: invalid package */
public final class ad {
    public final void ad(@Nullable File file, @NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (file != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                Result.Companion companion = Result.Companion;
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

    @NotNull
    public final String qw(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = File.separator;
        Intrinsics.checkNotNullExpressionValue(str2, "separator");
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return "";
        }
        String substring = str.substring(0, lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
