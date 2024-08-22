package com.tera.scan.main.startup.task;

import android.app.Application;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.c.th;
import fe.mmm.qw.e.de;
import fe.mmm.qw.e.fe;
import fe.mmm.qw.e.qw;
import fe.mmm.qw.xxx.o.de.uk;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tera/scan/main/startup/task/UBCStartupTask;", "Lcom/tera/scan/startup/StartupTask;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "dependencies", "", "Ljava/lang/Class;", "getRunType", "", "getTaskName", "", "initUbc", "", "run", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UBCStartupTask extends th {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Application f6989yj;

    public UBCStartupTask(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.f6989yj = application;
    }

    public final void eee() {
        LoggerKt.d("initUbc", "TeraScanApplication");
        qw.qw.ad(UBCStartupTask$initUbc$1.INSTANCE);
        de.rg();
        de.qw();
        de.th(RequestCommonParams.rg());
        de.i(fe.mmm.qw.p030switch.rg.qw.qw().getUid());
        de.ad(this.f6989yj);
        de.de(this.f6989yj);
        fe.rg();
        fe.fe(this.f6989yj);
    }

    public int i() {
        return 1;
    }

    @Nullable
    public String o() {
        return "UBCStartupTask";
    }

    public void xxx() {
        eee();
    }

    @Nullable
    public List<Class<? extends th>> yj() {
        return CollectionsKt__CollectionsKt.mutableListOf(uk.class);
    }
}
