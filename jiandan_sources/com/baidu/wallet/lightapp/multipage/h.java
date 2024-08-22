package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class h {
    public String a;
    public LangbridgeSettings b;
    public b c;
    public b d;
    public Set<WeakReference<a>> e;

    public interface a {
        void onSettingUpdated(LangbridgeSettings langbridgeSettings);
    }

    public interface b {
        LangbridgeSettings convertSetting(Context context, LangbridgeSettings langbridgeSettings);
    }

    public static class c {
        public static h a = new h();
    }

    public static h a() {
        return c.a;
    }

    private LangbridgeSettings d(Context context) {
        b bVar = this.c;
        LangbridgeSettings convertSetting = bVar != null ? bVar.convertSetting(context, this.b) : this.b;
        b bVar2 = this.d;
        return bVar2 != null ? bVar2.convertSetting(context, convertSetting) : convertSetting;
    }

    public LangbridgeSettings b(@NonNull Context context) {
        if (this.b == null) {
            this.b = a(this.a);
        }
        if (this.b == null) {
            this.b = new LangbridgeSettings();
        }
        LogUtil.d("LangbridgeSettings", "");
        return this.b;
    }

    public void c(@NonNull Context context) {
        if (this.b != null) {
            LogUtil.d("LangbridgeSettings", "");
            for (WeakReference next : this.e) {
                if (!(next == null || next.get() == null)) {
                    ((a) next.get()).onSettingUpdated(d(context));
                }
            }
        }
    }

    public h() {
        this.e = new CopyOnWriteArraySet();
        this.c = e.a();
        this.d = LangbridgeFeatureSwitch.getInstance();
    }

    public LangbridgeSettings a(@NonNull Context context) {
        if (this.b == null) {
            this.b = a(this.a);
        }
        if (this.b == null) {
            this.b = new LangbridgeSettings();
        }
        LogUtil.d("LangbridgeSettings", "");
        return d(context);
    }

    public void a(@NonNull Context context, String str) {
        if (this.b == null) {
            this.b = new LangbridgeSettings();
        }
        if (TextUtils.isEmpty(str)) {
            this.b = new LangbridgeSettings();
            if (!TextUtils.isEmpty(this.a)) {
                this.a = JsonUtils.toJson(this.b);
            }
            LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "updateSettings CLEAR mSettings = " + this.b.toString());
            return;
        }
        LangbridgeSettings a2 = a(str);
        StringBuilder sb = new StringBuilder();
        sb.append("updateSettings oldSettings = ");
        LangbridgeSettings langbridgeSettings = this.b;
        Object obj = langbridgeSettings;
        if (langbridgeSettings != null) {
            obj = langbridgeSettings.toString();
        }
        sb.append(obj);
        sb.append("\nnewSettings = ");
        sb.append(a2 != null ? a2.toString() : a2);
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, sb.toString());
        if (a2 != null && !a2.MW_USE_OLD && a2.MW_ON && !TextUtils.isEmpty(this.a)) {
            LangbridgeSettings langbridgeSettings2 = this.b;
            if (langbridgeSettings2.MW_USE_OLD || !langbridgeSettings2.MW_ON) {
                LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "updateSettings CANCEL mSettings = " + this.b.toString());
                return;
            }
        }
        if (a2 != null) {
            this.b = a2;
            LogUtil.d("LangbridgeSettings", "");
            this.a = str;
            for (WeakReference next : this.e) {
                if (!(next == null || next.get() == null)) {
                    ((a) next.get()).onSettingUpdated(d(context));
                }
            }
        }
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "updateSettings SUCCESS mSettings = " + this.b.toString());
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.e.add(new WeakReference(aVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.wallet.lightapp.multipage.LangbridgeSettings a(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 != 0) goto L_0x0014
            java.lang.Class<com.baidu.wallet.lightapp.multipage.LangbridgeSettings> r0 = com.baidu.wallet.lightapp.multipage.LangbridgeSettings.class
            java.lang.Object r3 = com.baidu.apollon.utils.JsonUtils.fromJson(r3, r0)     // Catch:{ JSONException -> 0x0010 }
            com.baidu.wallet.lightapp.multipage.LangbridgeSettings r3 = (com.baidu.wallet.lightapp.multipage.LangbridgeSettings) r3     // Catch:{ JSONException -> 0x0010 }
            goto L_0x0015
        L_0x0010:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0014:
            r3 = r1
        L_0x0015:
            if (r3 == 0) goto L_0x001f
            boolean r0 = r3.isValid()
            if (r0 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            return r3
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.h.a(java.lang.String):com.baidu.wallet.lightapp.multipage.LangbridgeSettings");
    }

    public String a(String str, String str2) {
        String a2 = com.baidu.wallet.lightapp.business.a.a(str);
        if (!TextUtils.isEmpty(a2)) {
            str2 = a2;
        }
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "LangbridgeSettingManager获取注入js文件：" + str2);
        return str2;
    }
}
