package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.u;
import java.util.HashSet;
import java.util.Set;

public class ClientConfigManagerImpl implements d {
    private static final String TAG = "ClientConfigManager";
    private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    private a mAppConfigSettings = new a(this.mContext);
    private Context mContext;
    private e mPushConfigSettings = new e(this.mContext);

    private ClientConfigManagerImpl(Context context) {
        this.mContext = ContextDelegate.getContext(context);
    }

    public static synchronized ClientConfigManagerImpl getInstance(Context context) {
        ClientConfigManagerImpl clientConfigManagerImpl;
        synchronized (ClientConfigManagerImpl.class) {
            if (sClientConfigManagerImpl == null) {
                sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
            }
            clientConfigManagerImpl = sClientConfigManagerImpl;
        }
        return clientConfigManagerImpl;
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        a c2 = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c2 != null) {
            return "1".equals(c2.b());
        }
        return true;
    }

    private void prepareAppConfig() {
        a aVar = this.mAppConfigSettings;
        if (aVar == null) {
            this.mAppConfigSettings = new a(this.mContext);
        } else {
            aVar.c();
        }
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public boolean isInBlackList(long pushVersion) {
        String c2 = preparePushConfigSettings().c("BL");
        if (!TextUtils.isEmpty(c2)) {
            for (String str : c2.split(",")) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == pushVersion) {
                        return true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isCancleBroadcastReceiver() {
        /*
            r3 = this;
            com.vivo.push.cache.e r0 = r3.preparePushConfigSettings()
            java.lang.String r1 = "PSM"
            java.lang.String r0 = r0.c(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L_0x001b
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0017 }
            goto L_0x001c
        L_0x0017:
            r0 = move-exception
            r0.printStackTrace()
        L_0x001b:
            r0 = r2
        L_0x001c:
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0022
            r0 = 1
            return r0
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.cache.ClientConfigManagerImpl.isCancleBroadcastReceiver():boolean");
    }

    private e preparePushConfigSettings() {
        e eVar = this.mPushConfigSettings;
        if (eVar == null) {
            this.mPushConfigSettings = new e(this.mContext);
        } else {
            eVar.c();
        }
        return this.mPushConfigSettings;
    }

    public String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return a.a(this.mAppConfigSettings.b());
    }

    public boolean isDebug(int mode) {
        return a.a(mode);
    }

    public String getValueByKey(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        this.mPushConfigSettings.c();
        return this.mPushConfigSettings.c(key);
    }

    public Set<Long> getWhiteLogList() {
        HashSet hashSet = new HashSet();
        String valueByKey = getValueByKey("WLL");
        if (!TextUtils.isEmpty(valueByKey)) {
            for (String parseLong : valueByKey.split(",")) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
                } catch (Exception e2) {
                }
            }
        }
        u.d(TAG, " initWhiteLogList ".concat(String.valueOf(hashSet)));
        return hashSet;
    }

    public Set<String> getBlackEventList() {
        return null;
    }
}
