package com.baidu.wallet.lightapp.business;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.dxmpay.wallet.core.Domains;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.CustomTabsHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public Context a;
    public JSONObject b;
    public final byte[] c;
    public long d;
    public String e;
    public String[] f;
    public String[] g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    public class AnonymousClass1 implements IBeanResponseCallback {
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a a;

        public void onBeanExecFailure(int i2, int i3, String str) {
            this.a.destroyBean();
        }

        public void onBeanExecSuccess(int i2, Object obj, String str) {
            this.a.destroyBean();
        }
    }

    public static final class a {
        public static final b a = new b((AnonymousClass1) null);
    }

    public /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private void b() {
        synchronized (this.c) {
            String[] strArr = {Domains.BAIDU, ".baifubao.com", Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f = strArr;
            this.g = new String[]{"com.android.fileexplorer", "com.android.browser", CustomTabsHelper.STABLE_PACKAGE, "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.d = 1800000;
            this.e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.g);
            JSONObject jSONObject = new JSONObject();
            this.b = jSONObject;
            try {
                jSONObject.put("domains", this.f);
                this.b.put("packages", this.g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String c() {
        StringBuilder sb = new StringBuilder(StringUtil.ARRAY_START);
        sb.append("\"");
        sb.append("domains");
        sb.append("\":[");
        for (String append : this.f) {
            sb.append("\"");
            sb.append(append);
            sb.append("\",");
        }
        if (this.f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String append2 : this.g) {
            sb.append("\"");
            sb.append(append2);
            sb.append("\",");
        }
        if (this.g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.a == null && context != null) {
            this.a = DxmApplicationContextImpl.getApplicationContext(context);
        }
        return this.a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        com.baidu.apollon.utils.SharedPreferencesUtils.setParam(r5.a, "langbridge", "config", c());
        com.baidu.apollon.utils.SharedPreferencesUtils.setParam(r5.a, "langbridge", "lbc_update_timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6, com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg r7) {
        /*
            r5 = this;
            boolean r6 = r5.a(r6)
            if (r6 == 0) goto L_0x008a
            boolean r6 = r7.checkResponseValidity()
            if (r6 != 0) goto L_0x000e
            goto L_0x008a
        L_0x000e:
            byte[] r6 = r5.c
            monitor-enter(r6)
            com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg$LbConfig r7 = r7.lbconfig     // Catch:{ all -> 0x0087 }
            java.lang.String r0 = r5.e     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r7.fingerprint     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x001f
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            return
        L_0x001f:
            java.lang.String[] r0 = r7.domains     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 == 0) goto L_0x0035
            java.lang.String[] r0 = r7.domains     // Catch:{ all -> 0x0087 }
            java.lang.String[] r2 = r7.domains     // Catch:{ all -> 0x0087 }
            int r2 = r2.length     // Catch:{ all -> 0x0087 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)     // Catch:{ all -> 0x0087 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x0087 }
            r5.f = r0     // Catch:{ all -> 0x0087 }
            java.util.Arrays.sort(r0)     // Catch:{ all -> 0x0087 }
            goto L_0x0039
        L_0x0035:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x0087 }
            r5.f = r0     // Catch:{ all -> 0x0087 }
        L_0x0039:
            java.lang.String[] r0 = r7.packages     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x004e
            java.lang.String[] r0 = r7.packages     // Catch:{ all -> 0x0087 }
            java.lang.String[] r1 = r7.packages     // Catch:{ all -> 0x0087 }
            int r1 = r1.length     // Catch:{ all -> 0x0087 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ all -> 0x0087 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x0087 }
            r5.g = r0     // Catch:{ all -> 0x0087 }
            java.util.Arrays.sort(r0)     // Catch:{ all -> 0x0087 }
            goto L_0x0052
        L_0x004e:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x0087 }
            r5.g = r0     // Catch:{ all -> 0x0087 }
        L_0x0052:
            java.lang.String r0 = r7.fingerprint     // Catch:{ all -> 0x0087 }
            r5.e = r0     // Catch:{ all -> 0x0087 }
            r0 = 0
            long r2 = r7.interval     // Catch:{ all -> 0x0087 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0067
            long r0 = r7.interval     // Catch:{ all -> 0x0087 }
            r2 = 60000(0xea60, double:2.9644E-319)
            long r0 = r0 * r2
            r5.d = r0     // Catch:{ all -> 0x0087 }
        L_0x0067:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            android.content.Context r6 = r5.a
            java.lang.String r7 = "langbridge"
            java.lang.String r0 = "config"
            java.lang.String r1 = r5.c()
            com.baidu.apollon.utils.SharedPreferencesUtils.setParam(r6, r7, r0, r1)
            android.content.Context r6 = r5.a
            java.lang.String r7 = "langbridge"
            java.lang.String r0 = "lbc_update_timestamp"
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            com.baidu.apollon.utils.SharedPreferencesUtils.setParam(r6, r7, r0, r1)
            return
        L_0x0087:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            throw r7
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.b.a(android.content.Context, com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg):void");
    }
}
