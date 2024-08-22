package com.baidu.wallet.paysdk.setting;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;

public class a {
    public boolean a;

    /* renamed from: com.baidu.wallet.paysdk.setting.a$a  reason: collision with other inner class name */
    public interface C0168a {
        void a(Boolean bool, String str);
    }

    public static class b {
        public static final a a = new a();
    }

    public static a a() {
        return b.a;
    }

    public boolean b() {
        return this.a;
    }

    public a() {
        this.a = false;
    }

    public boolean a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.dxmpay.wallet.preferences_settings", 0).edit();
        edit.putString("big_word_mode", str);
        return edit.commit();
    }

    public String a(Context context) {
        return context.getSharedPreferences("com.dxmpay.wallet.preferences_settings", 0).getString("big_word_mode", "0");
    }

    public void a(Context context, String str, C0168a aVar) {
        String str2 = "0";
        String str3 = null;
        try {
            str3 = new JSONObject(str).optString("bigWordEnable");
            ArrayList arrayList = new ArrayList();
            arrayList.add(str3);
            arrayList.add(str2);
            StatisticManager.onEventWithValues(PayStatServiceEvent.SET_BIG_WORD, arrayList);
            if ("1".equals(str3)) {
                str2 = str3;
            }
            aVar.a(Boolean.valueOf(a(context, str2)), str2);
        } catch (JSONException e) {
            LogUtil.e("SettingManager", e.getMessage(), e);
            aVar.a(Boolean.FALSE, str3);
        }
    }

    public void a(boolean z) {
        this.a = z;
    }
}
