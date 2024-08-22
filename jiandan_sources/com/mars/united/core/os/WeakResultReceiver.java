package com.mars.united.core.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.Logger;
import com.mars.united.core.debug.DevelopException;
import fe.ggg.ad.qw.ad.qw;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00018\u00008\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mars/united/core/os/WeakResultReceiver;", "T", "Landroid/os/ResultReceiver;", "target", "(Ljava/lang/Object;)V", "targetRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "handleResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;Ljava/lang/Object;)V", "onReceiveResult", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class WeakResultReceiver<T> extends ResultReceiver {
    @NotNull
    public final WeakReference<T> targetRef;

    public WeakResultReceiver(T t) {
        super(new Handler(Looper.getMainLooper()));
        this.targetRef = new WeakReference<>(t);
    }

    public abstract void handleResult(int i2, @Nullable Bundle bundle, T t);

    public void onReceiveResult(int i2, @Nullable Bundle bundle) {
        Object obj = this.targetRef.get();
        if (obj != null) {
            if (bundle != null) {
                bundle.setClassLoader(WeakResultReceiver.class.getClassLoader());
            }
            try {
                handleResult(i2, bundle, obj);
            } catch (ClassNotFoundException e) {
                if (Logger.INSTANCE.getEnable() && qw.qw.ad()) {
                    throw new DevelopException((Throwable) e);
                }
            }
        }
    }
}
