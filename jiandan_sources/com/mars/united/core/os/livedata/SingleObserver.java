package com.mars.united.core.os.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import fe.ggg.ad.qw.de.th.qw;
import fe.ggg.ad.qw.de.th.rg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u000f\u001a\u00020\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mars/united/core/os/livedata/SingleObserver;", "T", "", "()V", "curLiveData", "Landroidx/lifecycle/LiveData;", "observer", "Landroidx/lifecycle/Observer;", "result", "Lkotlin/Function1;", "", "setSource", "liveData", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "stopObserver", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleObserver<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<T> f6618ad = new qw(this);
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public LiveData<T> f6619de;
    @NotNull
    public Function1<? super T, Unit> qw = SingleObserver$result$1.INSTANCE;

    public static final void qw(SingleObserver singleObserver, Object obj) {
        Intrinsics.checkNotNullParameter(singleObserver, "this$0");
        singleObserver.qw.invoke(obj);
        singleObserver.de();
    }

    public final void ad(@NotNull LiveData<T> liveData, @Nullable LifecycleOwner lifecycleOwner, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(function1, "result");
        de();
        this.qw = function1;
        this.f6619de = liveData;
        if (lifecycleOwner == null) {
            if (liveData != null) {
                rg.qw(liveData, this.f6618ad);
            }
        } else if (liveData != null) {
            liveData.observe(lifecycleOwner, this.f6618ad);
        }
    }

    public final synchronized void de() {
        LiveData<T> liveData = this.f6619de;
        if (liveData != null) {
            liveData.removeObserver(this.f6618ad);
        }
        this.f6619de = null;
    }
}
