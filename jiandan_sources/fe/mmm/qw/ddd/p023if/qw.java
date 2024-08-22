package fe.mmm.qw.ddd.p023if;

import android.media.ExifInterface;
import kotlin.Result;
import kotlin.ResultKt;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.ddd.if.qw  reason: invalid package */
public final class qw {
    public final int qw(@Nullable String str) {
        Object obj;
        int attributeInt;
        if (str == null) {
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(new ExifInterface(str));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        ExifInterface exifInterface = (ExifInterface) obj;
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) == -1) {
            return 0;
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return 270;
    }
}
