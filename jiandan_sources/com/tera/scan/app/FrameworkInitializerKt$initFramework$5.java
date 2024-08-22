package com.tera.scan.app;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tera.scan.framework.framework.FrameworkAccount;
import fe.mmm.qw.qw.rg.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/tera/scan/framework/framework/FrameworkAccount;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FrameworkInitializerKt$initFramework$5 extends Lambda implements Function0<LiveData<FrameworkAccount>> {
    public static final FrameworkInitializerKt$initFramework$5 INSTANCE = new FrameworkInitializerKt$initFramework$5();

    public FrameworkInitializerKt$initFramework$5() {
        super(0);
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m724invoke$lambda0(MutableLiveData mutableLiveData, qw qwVar) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$liveData");
        mutableLiveData.postValue(fe.mmm.qw.p030switch.rg.qw.qw());
    }

    @NotNull
    public final LiveData<FrameworkAccount> invoke() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        fe.mmm.qw.qw.qw.qw.ad().observeForever(new fe.mmm.qw.ad.qw(mutableLiveData));
        return mutableLiveData;
    }
}
