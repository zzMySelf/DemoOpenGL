package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.lollipop.json.JSONArray;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e implements h.b {
    public JSONArray a;
    public Long b;

    public static class a {
        public static e a = new e();
    }

    public static e a() {
        return a.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.wallet.core.lollipop.json.JSONArray b(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "com.baidu.wallet.preferences_name"
            java.lang.String r1 = "langbridge_behaviour_book"
            java.lang.String r2 = ""
            java.lang.Object r0 = com.baidu.apollon.utils.SharedPreferencesUtils.getParam(r9, r0, r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            com.baidu.wallet.core.lollipop.json.JSONArray r1 = new com.baidu.wallet.core.lollipop.json.JSONArray     // Catch:{ Exception -> 0x0018 }
            r1.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x0020
            com.baidu.wallet.core.lollipop.json.JSONArray r1 = new com.baidu.wallet.core.lollipop.json.JSONArray
            r1.<init>()
        L_0x0020:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r2 = 0
        L_0x0029:
            int r3 = r1.length()
            if (r2 >= r3) goto L_0x004f
            long r3 = r1.optLong(r2)
            com.baidu.wallet.lightapp.multipage.h r5 = com.baidu.wallet.lightapp.multipage.h.a()
            com.baidu.wallet.lightapp.multipage.LangbridgeSettings r5 = r5.a((android.content.Context) r9)
            int r5 = r5.MW_BHM_RECORD_TIME
            int r5 = r5 * 1000
            long r5 = (long) r5
            long r3 = r3 + r5
            long r5 = r0.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x004c
            r1.remove(r2)
        L_0x004c:
            int r2 = r2 + 1
            goto L_0x0029
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.e.b(android.content.Context):com.baidu.wallet.core.lollipop.json.JSONArray");
    }

    private void c(Context context) {
        JSONArray jSONArray = new JSONArray();
        this.a = jSONArray;
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", jSONArray.toString());
    }

    private int d(Context context) {
        JSONArray a2 = a(context);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        int i2 = 0;
        for (int i3 = 0; i3 < a2.length(); i3++) {
            i2 += a2.optLong(i3) + ((long) (h.a().a(context).MW_BHM_RECORD_TIME * 1000)) >= valueOf.longValue() ? 1 : 0;
        }
        return i2;
    }

    private void e(Context context) {
        LogUtil.d("LangbridgeBehaviourMonitor", "coldDown");
        DXMSdkSAUtils.onEvent("#MW_BHM_ColdDown");
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.b = valueOf;
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", valueOf);
        h.a().c(context);
    }

    public LangbridgeSettings convertSetting(Context context, LangbridgeSettings langbridgeSettings) {
        if (!langbridgeSettings.MW_BHM_ON || !b(context, langbridgeSettings.MW_BHM_COLD_TIME)) {
            return langbridgeSettings;
        }
        LangbridgeSettings clone = langbridgeSettings.clone();
        clone.MW_ON = false;
        clone.MW_USE_OLD = true;
        LogUtil.d("LangbridgeSettings", "");
        return clone;
    }

    public e() {
        this.b = -1L;
    }

    public void a(@NonNull Context context, int i2, @NonNull String str, List<String> list) {
        LangbridgeSettings a2 = h.a().a(context);
        if (a2.MW_BHM_ON && !b(context, a2.MW_BHM_COLD_TIME)) {
            ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{str, "" + i2}));
            arrayList.addAll(list);
            LogUtil.i("LangbridgeBehaviourMonitor", "behaviourRecord" + str + "  " + i2 + " " + arrayList.toString());
            DXMSdkSAUtils.onEventWithValues("#MW_BHM_BadBehaviour", arrayList);
            if (i2 >= 1) {
                int i3 = a2.MW_BHM_LIMIT;
                if (i2 > i3) {
                    i2 = i3;
                }
                a(context, i2);
                if (d(context) >= i3) {
                    e(context);
                    c(context);
                }
            }
        }
    }

    private boolean b(Context context, int i2) {
        if (this.b.longValue() == -1) {
            this.b = (Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", 0L);
        }
        return System.currentTimeMillis() < this.b.longValue() + ((long) (i2 * 1000));
    }

    private JSONArray a(Context context) {
        if (this.a == null) {
            this.a = b(context);
        }
        return this.a;
    }

    private void a(Context context, int i2) {
        JSONArray a2 = a(context);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        for (int i3 = 0; i3 < i2; i3++) {
            a2.put((Object) valueOf);
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", a2.toString());
    }
}
