package fe.mmm.qw.qw;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.account.OnLoginCallBack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("account_tag")
public final class qw {
    @NotNull
    public static final qw qw = new qw();

    /* renamed from: switch  reason: not valid java name */
    public static /* synthetic */ void m1000switch(qw qwVar, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        qwVar.m1001if(function1);
    }

    public static /* synthetic */ void xxx(qw qwVar, LifecycleOwner lifecycleOwner, String str, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        qwVar.vvv(lifecycleOwner, str, z, function1);
    }

    @NotNull
    public final LiveData<fe.mmm.qw.qw.rg.qw> ad() {
        return de.f8249fe.ad();
    }

    public final void de(@NotNull OnLoginCallBack onLoginCallBack) {
        Intrinsics.checkNotNullParameter(onLoginCallBack, "callBack");
        de.f8249fe.de(onLoginCallBack);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.rg();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fe() {
        /*
            r1 = this;
            fe.mmm.qw.qw.rg.qw r0 = r1.qw()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.rg()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.qw.qw.fe():java.lang.String");
    }

    public final void ggg(@NotNull OnLoginCallBack onLoginCallBack) {
        Intrinsics.checkNotNullParameter(onLoginCallBack, "callBack");
        de.f8249fe.m998if(onLoginCallBack);
    }

    public final void i() {
        de.f8249fe.xxx();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1001if(@Nullable Function1<? super Boolean, Unit> function1) {
        de.f8249fe.th(function1);
    }

    public final void o(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        de.f8249fe.ddd(context);
    }

    public final boolean pf() {
        return de.f8249fe.rg();
    }

    public final void ppp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        de.f8249fe.pf(context);
    }

    @Nullable
    public final fe.mmm.qw.qw.rg.qw qw() {
        return de.f8249fe.qw();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.th();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String rg() {
        /*
            r1 = this;
            fe.mmm.qw.qw.rg.qw r0 = r1.qw()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.th()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.qw.qw.rg():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.yj();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String th() {
        /*
            r1 = this;
            fe.mmm.qw.qw.rg.qw r0 = r1.qw()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.yj()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.qw.qw.th():java.lang.String");
    }

    public final long uk() {
        Long i2;
        fe.mmm.qw.qw.rg.qw qw2 = qw();
        if (qw2 == null || (i2 = qw2.i()) == null) {
            return 0;
        }
        return i2.longValue();
    }

    public final void vvv(@NotNull LifecycleOwner lifecycleOwner, @NotNull String str, boolean z, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(str, "loginFromStat");
        de.f8249fe.a(lifecycleOwner, str, z, function1);
    }

    public final void when() {
        de.f8249fe.aaa();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.uk();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String yj() {
        /*
            r1 = this;
            fe.mmm.qw.qw.rg.qw r0 = r1.qw()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.uk()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.qw.qw.yj():java.lang.String");
    }
}
