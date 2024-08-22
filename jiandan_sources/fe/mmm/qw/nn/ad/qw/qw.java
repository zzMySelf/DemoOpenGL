package fe.mmm.qw.nn.ad.qw;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.network.network.NetworkDetailException;
import com.tera.scan.network.network.NetworkSpaceType;
import com.tera.scan.network.network.exception.RemoteException;
import fe.mmm.qw.nn.de.o.de;
import fe.mmm.qw.nn.qw.qw.yj;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Tag("LibNetworkMgr")
public final class qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static Function0<String> f8082ad;
    @Nullable
    public static Function4<? super Context, ? super String, ? super String, ? super String, String> ddd;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static Function0<Boolean> f8083de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public static Function2<? super NetworkSpaceType, ? super de, Unit> f8084fe;
    @Nullable
    public static Function1<? super yj, Unit> ggg;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public static Function0<Boolean> f8085i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public static Function2<? super String, ? super String, Unit> f338if;
    @Nullable
    public static Function0<Boolean> mmm;
    @Nullable
    public static Function0<Boolean> nn;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public static Function0<? extends fe.mmm.qw.nn.qw.qw.de> f8086o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public static Function1<? super String, Unit> f8087pf;
    @Nullable
    public static Function5<? super String, ? super String, ? super String, ? super String, ? super String, Unit> ppp;
    @NotNull
    public static final qw qw = new qw();
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public static Function1<? super String, Boolean> f8088rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public static Function3<? super String, ? super String, ? super String, Unit> f339switch;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public static Function1<? super HttpUrl.Builder, String> f8089th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public static Function0<String> f8090uk;
    @Nullable
    public static Function1<? super Integer, Boolean> vvv;
    @Nullable
    public static Function4<? super String, ? super String, ? super String, ? super String, Unit> when;
    @Nullable
    public static Function1<? super Integer, Unit> xxx;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public static Function2<? super de, ? super Boolean, ? extends de> f8091yj;

    public final void a(@Nullable Function0<String> function0) {
    }

    public final void aaa(@Nullable Function4<? super Context, ? super String, ? super String, ? super String, String> function4) {
        ddd = function4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r0.invoke(r2);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ad(@org.jetbrains.annotations.NotNull okhttp3.HttpUrl.Builder r2) {
        /*
            r1 = this;
            java.lang.String r0 = "authorizedUrlBuilder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.functions.Function1<? super okhttp3.HttpUrl$Builder, java.lang.String> r0 = f8089th
            if (r0 == 0) goto L_0x0011
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0013
        L_0x0011:
            java.lang.String r2 = ""
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.ad.qw.qw.ad(okhttp3.HttpUrl$Builder):java.lang.String");
    }

    public final void b(@Nullable Function0<String> function0) {
        LoggerKt.d$default("mGetUIDInvoke set", (Object) null, 1, (Object) null);
        f8082ad = function0;
    }

    public final void c(@Nullable Function1<? super String, String> function1) {
    }

    public final void d(@Nullable Function2<? super de, ? super Boolean, ? extends de> function2) {
        f8091yj = function2;
    }

    @Nullable
    public final Unit ddd(@Nullable NetworkSpaceType networkSpaceType, @Nullable de deVar) {
        Function2<? super NetworkSpaceType, ? super de, Unit> function2 = f8084fe;
        if (function2 == null) {
            return null;
        }
        function2.invoke(networkSpaceType, deVar);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Boolean de(@Nullable String str) {
        Function1<? super String, Boolean> function1 = f8088rg;
        return function1 != null ? Boolean.valueOf(function1.invoke(str).booleanValue()) : Boolean.TRUE;
    }

    public final void e(@Nullable Function0<Boolean> function0) {
        LoggerKt.d$default("mIsEnterpriseSpaceInvoke set", (Object) null, 1, (Object) null);
        f8083de = function0;
    }

    public final void eee(@Nullable Function0<? extends fe.mmm.qw.nn.qw.qw.de> function0) {
        f8086o = function0;
    }

    public final void f(@Nullable Function0<Boolean> function0) {
        f8085i = function0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fe() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<java.lang.String> r0 = f8090uk
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.ad.qw.qw.fe():java.lang.String");
    }

    public final void g(@Nullable Function4<? super String, ? super String, ? super String, ? super String, Unit> function4) {
        when = function4;
    }

    public final void ggg(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "op");
        Intrinsics.checkNotNullParameter(str2, "argOne");
        Function2<? super String, ? super String, Unit> function2 = f338if;
        if (function2 != null) {
            function2.invoke(str, str2);
        }
    }

    public final void h(@Nullable Function1<? super String, Unit> function1) {
        f8087pf = function1;
    }

    @Nullable
    public final Function1<HttpUrl.Builder, String> i() {
        return f8089th;
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m987if() {
        Function0<Boolean> function0 = mmm;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public final void j(@Nullable Function3<? super String, ? super String, ? super String, Unit> function3) {
        f339switch = function3;
    }

    public final void k(@Nullable Function2<? super String, ? super String, Unit> function2) {
        f338if = function2;
    }

    public final void l(@Nullable Function2<? super NetworkSpaceType, ? super de, Unit> function2) {
        f8084fe = function2;
    }

    public final void m(@Nullable Function1<? super HttpUrl.Builder, String> function1) {
        f8089th = function1;
    }

    public final void mmm(@Nullable Function0<? extends Context> function0) {
    }

    public final void n(@Nullable Function5<? super String, ? super String, ? super String, ? super String, ? super String, Unit> function5) {
        ppp = function5;
    }

    public final void nn(@NotNull yj yjVar) {
        Intrinsics.checkNotNullParameter(yjVar, "info");
        Function1<? super yj, Unit> function1 = ggg;
        if (function1 != null) {
            function1.invoke(yjVar);
        }
    }

    @Nullable
    public final Function1<Integer, Unit> o() {
        return xxx;
    }

    public final void p(@Nullable Function1<? super Integer, Unit> function1) {
        xxx = function1;
    }

    public final boolean pf() {
        Function0<Boolean> function0 = nn;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public final void ppp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "op");
        Function1<? super String, Unit> function1 = f8087pf;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void q(@Nullable Function2<? super Boolean, ? super ResultReceiver, Unit> function2) {
    }

    public final void qqq(@Nullable Function1<? super String, Boolean> function1) {
        f8088rg = function1;
    }

    @Nullable
    public final de qw(@Nullable de deVar, boolean z) throws JSONException {
        Function2<? super de, ? super Boolean, ? extends de> function2 = f8091yj;
        if (function2 != null) {
            return (de) function2.invoke(deVar, Boolean.valueOf(z));
        }
        return null;
    }

    public final void r(@Nullable Function2<? super NetworkDetailException, ? super ResultReceiver, Unit> function2) {
    }

    @Nullable
    public final String rg() {
        Function0<String> function0 = f8082ad;
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    public final void rrr(@Nullable Function0<String> function0) {
        f8090uk = function0;
    }

    public final void s(@Nullable Function3<? super RemoteException, ? super ResultReceiver, ? super Bundle, Unit> function3) {
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m988switch() {
        Function0<Boolean> function0 = f8085i;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public final void t(@Nullable Function3<? super fe.mmm.qw.nn.de.pf.de, ? super ResultReceiver, ? super Bundle, Unit> function3) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (fe.mmm.qw.nn.qw.qw.de) r0.invoke();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.mmm.qw.nn.qw.qw.de th() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<? extends fe.mmm.qw.nn.qw.qw.de> r0 = f8086o
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            fe.mmm.qw.nn.qw.qw.de r0 = (fe.mmm.qw.nn.qw.qw.de) r0
            if (r0 != 0) goto L_0x0011
        L_0x000c:
            fe.mmm.qw.nn.qw.qw.de r0 = new fe.mmm.qw.nn.qw.qw.de
            r0.<init>()
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.ad.qw.qw.th():fe.mmm.qw.nn.qw.qw.de");
    }

    public final void tt(@Nullable Function0<String> function0) {
    }

    public final void u(@Nullable Function1<? super Integer, Boolean> function1) {
        vvv = function1;
    }

    @Nullable
    public final Boolean uk() {
        Function0<Boolean> function0 = f8083de;
        return function0 != null ? Boolean.valueOf(function0.invoke().booleanValue()) : Boolean.FALSE;
    }

    public final void v(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "logId");
        Intrinsics.checkNotNullParameter(str2, "space");
        Intrinsics.checkNotNullParameter(str3, "mouduleId");
        Intrinsics.checkNotNullParameter(str4, BindVerifyActivity.c);
        Intrinsics.checkNotNullParameter(str5, "message");
        Function5<? super String, ? super String, ? super String, ? super String, ? super String, Unit> function5 = ppp;
        if (function5 != null) {
            function5.invoke(str, str2, str3, str4, str5);
        }
    }

    public final void vvv(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "op");
        Intrinsics.checkNotNullParameter(str2, "argOne");
        Intrinsics.checkNotNullParameter(str3, "argTwo");
        Function3<? super String, ? super String, ? super String, Unit> function3 = f339switch;
        if (function3 != null) {
            function3.invoke(str, str2, str3);
        }
    }

    @Nullable
    public final Function1<Integer, Boolean> when() {
        return vvv;
    }

    public final void xxx(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "op");
        Intrinsics.checkNotNullParameter(str2, "argOne");
        Intrinsics.checkNotNullParameter(str3, "argTwo");
        Intrinsics.checkNotNullParameter(str4, "argThree");
        Function4<? super String, ? super String, ? super String, ? super String, Unit> function4 = when;
        if (function4 != null) {
            function4.invoke(str, str2, str3, str4);
        }
    }

    @Nullable
    public final Function4<Context, String, String, String, String> yj() {
        return ddd;
    }
}
