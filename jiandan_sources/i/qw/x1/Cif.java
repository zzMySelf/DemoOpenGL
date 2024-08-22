package i.qw.x1;

import kotlin.Result;
import kotlin.ResultKt;

/* renamed from: i.qw.x1.if  reason: invalid class name */
public final class Cif {
    public static final boolean qw;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        qw = Result.m1162isSuccessimpl(obj);
    }

    public static final boolean qw() {
        return qw;
    }
}
