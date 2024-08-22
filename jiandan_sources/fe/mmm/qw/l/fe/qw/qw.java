package fe.mmm.qw.l.fe.qw;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import fe.mmm.qw.m.ggg.fe.ad;
import java.util.Set;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("HybridActionClientInfo")
public final class qw extends fe.mmm.qw.m.ggg.qw.qw {
    public qw(@Nullable IBaseView iBaseView) {
        super(iBaseView);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject ad(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "time"
            java.lang.String r1 = "rand"
            java.lang.String r4 = "hybird://client/info?"
            com.tera.scan.framework.framework.FrameworkAccount r2 = fe.mmm.qw.p030switch.rg.qw.qw()
            java.lang.String r5 = r2.getBduss()
            com.tera.scan.framework.framework.FrameworkAccount r2 = fe.mmm.qw.p030switch.rg.qw.qw()
            java.lang.String r8 = r2.getUid()
            r9 = 1
            r10 = 0
            java.lang.String r2 = fe.mmm.qw.nn.qw.qw.i.ad(r4, r5, r8)     // Catch:{ all -> 0x005c }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x005c }
            java.lang.String r11 = r2.getQueryParameter(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r12 = r2.getQueryParameter(r0)     // Catch:{ all -> 0x0058 }
            r2 = r13
            r3 = r14
            r6 = r8
            r7 = r12
            java.lang.String r2 = r2.qw(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0055 }
            android.net.Uri r3 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = r3.getQueryParameter(r1)     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r4.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = "rand2Url "
            r4.append(r5)     // Catch:{ all -> 0x0053 }
            r4.append(r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0053 }
            java.lang.Object r2 = com.mars.kotlin.extension.LoggerKt.d$default(r2, r10, r9, r10)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0053 }
            com.mars.kotlin.extension.ExpectKt.success(r2)     // Catch:{ all -> 0x0053 }
            goto L_0x0066
        L_0x0053:
            r2 = move-exception
            goto L_0x0060
        L_0x0055:
            r2 = move-exception
            r3 = r10
            goto L_0x0060
        L_0x0058:
            r2 = move-exception
            r3 = r10
            r12 = r3
            goto L_0x0060
        L_0x005c:
            r2 = move-exception
            r3 = r10
            r11 = r3
            r12 = r11
        L_0x0060:
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r10, r9, r10)
            com.mars.kotlin.extension.ExpectKt.failure(r2)
        L_0x0066:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0100 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0100 }
            r2.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "z"
            java.lang.String r5 = com.baidu.sofire.ac.FH.gz(r14)     // Catch:{ all -> 0x0100 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "clienttype"
            java.lang.String r5 = "Android"
            r2.put(r4, r5)     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "sdkClientType"
            java.lang.String r5 = com.tera.scan.network.network.request.RequestCommonParams.rg()     // Catch:{ all -> 0x0100 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0100 }
            java.lang.String r4 = "channel"
            java.lang.String r5 = com.tera.scan.network.network.request.RequestCommonParams.fe()     // Catch:{ all -> 0x0100 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0100 }
            r2.put(r1, r11)     // Catch:{ all -> 0x0100 }
            java.lang.String r1 = "rand2"
            r2.put(r1, r3)     // Catch:{ all -> 0x0100 }
            r2.put(r0, r12)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "cuid"
            java.lang.String r1 = com.baidu.android.common.util.CommonParam.getCUID(r14)     // Catch:{ all -> 0x0100 }
            r2.put(r0, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "devuid"
            java.lang.String r1 = fe.mmm.qw.de.ad.qw.qw.f7750o     // Catch:{ all -> 0x0100 }
            r2.put(r0, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "version"
            java.lang.String r1 = fe.mmm.qw.de.ad.qw.qw.f7746ad     // Catch:{ all -> 0x0100 }
            r2.put(r0, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "versioncode"
            int r1 = fe.mmm.qw.de.ad.qw.qw.f7747de     // Catch:{ all -> 0x0100 }
            r2.put(r0, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "offlinepackage"
            java.lang.String r1 = ""
            r2.put(r0, r1)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "themeinfo"
            int r14 = r13.de(r14)     // Catch:{ all -> 0x0100 }
            r2.put(r0, r14)     // Catch:{ all -> 0x0100 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0100 }
            r14.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "1e34f40405355a992583c9d7b166cd39"
            r14.append(r0)     // Catch:{ all -> 0x0100 }
            r14.append(r8)     // Catch:{ all -> 0x0100 }
            r14.append(r12)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = com.tera.scan.network.network.request.RequestCommonParams.fe()     // Catch:{ all -> 0x0100 }
            r14.append(r0)     // Catch:{ all -> 0x0100 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "rchannel"
            java.lang.String r14 = fe.mmm.qw.j.vvv.de.rg(r14)     // Catch:{ all -> 0x0100 }
            r2.put(r0, r14)     // Catch:{ all -> 0x0100 }
            java.lang.String r14 = "app"
            java.lang.String r0 = "android"
            r2.put(r14, r0)     // Catch:{ all -> 0x0100 }
            java.lang.String r14 = "json"
            java.lang.Object r14 = com.mars.kotlin.extension.LoggerKt.d(r2, r14)     // Catch:{ all -> 0x0100 }
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ all -> 0x0100 }
            java.lang.Object r14 = kotlin.Result.m1155constructorimpl(r14)     // Catch:{ all -> 0x0100 }
            goto L_0x010b
        L_0x0100:
            r14 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m1155constructorimpl(r14)
        L_0x010b:
            java.lang.Throwable r0 = kotlin.Result.m1158exceptionOrNullimpl(r14)
            if (r0 != 0) goto L_0x0114
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            return r14
        L_0x0114:
            java.lang.String r14 = "param error"
            com.mars.kotlin.extension.LoggerKt.e(r0, r14)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.l.fe.qw.qw.ad(android.content.Context):org.json.JSONObject");
    }

    public final int de(Context context) {
        return fe.mmm.qw.d.qw.rg(context) ^ true ? 1 : 0;
    }

    public final void fe() {
        FragmentActivity activity = this.mBaseView.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "mBaseView.getActivity()");
        JSONObject ad2 = ad(activity);
        if (ad2 != null) {
            handleHybridCallback(this.mHybridParam, 1, "", ad2);
        } else {
            handleHybridCallback(this.mHybridParam, 0, "get info error", new JSONObject());
        }
    }

    public void onAction(@Nullable ad adVar) {
        if (!isDestroy()) {
            this.mHybridParam = adVar;
            if (Intrinsics.areEqual((Object) "getClientInfo", (Object) adVar != null ? adVar.f8046de : null)) {
                fe();
            } else {
                handleRecognizeSchemeError(adVar);
            }
        }
    }

    public final String qw(Context context, String str, String str2, String str3, String str4) {
        Uri.Builder builder;
        Uri build;
        String uri;
        boolean z = false;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return str;
        }
        if (!(str3 == null || StringsKt__StringsJVMKt.isBlank(str3))) {
            if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                z = true;
            }
            if (!z) {
                Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
                if (queryParameterNames.contains("rand")) {
                    LoggerKt.d$default("添加过rand", (Object) null, 1, (Object) null);
                    return str;
                }
                boolean contains = queryParameterNames.contains("time");
                boolean contains2 = queryParameterNames.contains("version");
                if (!contains2 || !contains) {
                    builder = Uri.parse(str).buildUpon();
                } else {
                    builder = null;
                }
                if (!contains2 && builder != null) {
                    builder.appendQueryParameter("version", fe.mmm.qw.de.ad.qw.qw.f7746ad);
                }
                if (!contains && builder != null) {
                    builder.appendQueryParameter("time", str4);
                }
                if (!(builder == null || (build = builder.build()) == null || (uri = build.toString()) == null)) {
                    str = uri;
                }
                if (TextUtils.isEmpty(fe.mmm.qw.nn.fe.qw.qw())) {
                    LoggerKt.d$default("sk empty", (Object) null, 1, (Object) null);
                }
                Function4<Context, String, String, String, String> yj2 = fe.mmm.qw.nn.ad.qw.qw.qw.yj();
                if (yj2 != null) {
                    return yj2.invoke(context, str, str2, str3);
                }
                return null;
            }
        }
        LoggerKt.d$default("uid或bduss为空", (Object) null, 1, (Object) null);
        return str;
    }
}
