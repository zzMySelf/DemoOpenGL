package fe.mmm.qw.f.de.de.ad;

import android.os.Handler;
import android.os.Message;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw extends Handler {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final String f7774ad = "UISafeHandler";
    @NotNull
    public final Handler qw;

    public qw(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.qw = handler;
    }

    public void handleMessage(@NotNull Message message) {
        Object obj;
        Intrinsics.checkNotNullParameter(message, "msg");
        try {
            Result.Companion companion = Result.Companion;
            this.qw.handleMessage(message);
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r5 = Result.m1158exceptionOrNullimpl(obj);
        if (r5 != null) {
            fe.mmm.qw.f.ad.de.qw qwVar = fe.mmm.qw.f.ad.de.qw.qw;
            String str = this.f7774ad;
            qwVar.qw(str, "ignore " + r5.getMessage());
        }
    }
}
