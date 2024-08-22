package com.tera.scan.ui.view.widget.toast;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import fe.mmm.qw.f.de.de.ad.qw;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tera/scan/ui/view/widget/toast/UISafeToast;", "Landroid/widget/Toast;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tag", "", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UISafeToast extends Toast {
    @NotNull
    public final String tag = "UISafeToast";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UISafeToast(@NotNull Context context) {
        super(context);
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (24 <= i2 && i2 < 26) {
            z = true;
        }
        if (z) {
            try {
                Result.Companion companion = Result.Companion;
                Field declaredField = Toast.class.getDeclaredField("mTN");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(this);
                Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                Object obj3 = declaredField2.get(obj2);
                if (obj3 != null) {
                    declaredField2.set(obj2, new qw((Handler) obj3));
                    obj = Result.m1155constructorimpl(Unit.INSTANCE);
                    Throwable r5 = Result.m1158exceptionOrNullimpl(obj);
                    if (r5 != null) {
                        fe.mmm.qw.f.ad.de.qw qwVar = fe.mmm.qw.f.ad.de.qw.qw;
                        String str = this.tag;
                        qwVar.ad(str, "failed replace handler " + r5.getMessage(), r5);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }
}
