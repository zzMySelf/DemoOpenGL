package com.tera.scan.component.base.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J'\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tera/scan/component/base/base/WeakReferenceResultReceiver;", "T", "Landroid/os/ResultReceiver;", "reference", "handler", "Landroid/os/Handler;", "(Ljava/lang/Object;Landroid/os/Handler;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "onResult", "(Ljava/lang/Object;ILandroid/os/Bundle;)V", "component-base_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WeakReferenceResultReceiver<T> extends ResultReceiver {
    @NotNull
    public final WeakReference<T> weakReference;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeakReferenceResultReceiver(T t, @NotNull Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.weakReference = new WeakReference<>(t);
    }

    public void onReceiveResult(int i2, @Nullable Bundle bundle) {
        Object obj = this.weakReference.get();
        if (obj != null) {
            onResult(obj, i2, bundle);
        }
    }

    public abstract void onResult(T t, int i2, @Nullable Bundle bundle);
}
