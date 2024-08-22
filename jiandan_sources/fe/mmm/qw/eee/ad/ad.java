package fe.mmm.qw.eee.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    public static final void qw(@NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(Uri.parse("package:" + context.getPackageName()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        intent.setData((Uri) obj);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 5000);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
