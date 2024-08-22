package fe.mmm.qw.ppp.ad.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class de {
    public final boolean qw(@NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(connectivityManager.getActiveNetworkInfo());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m1161isFailureimpl(obj)) {
            networkInfo = obj;
        }
        NetworkInfo networkInfo2 = networkInfo;
        if (networkInfo2 == null || networkInfo2.getType() != 1 || !networkInfo2.isConnected()) {
            return false;
        }
        return true;
    }
}
