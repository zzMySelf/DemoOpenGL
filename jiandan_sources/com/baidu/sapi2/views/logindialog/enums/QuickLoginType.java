package com.baidu.sapi2.views.logindialog.enums;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.wallet.api.IWalletLoginListener;

public enum QuickLoginType {
    HISTORY(0, "history"),
    SHARE(1, "share"),
    ONEKEY(2, "onekey"),
    SMS(3, IWalletLoginListener.LOGIN_TYPE_SMS),
    QQ(4, "qq"),
    WECHAT(5, "wechat"),
    YY(6, FastLoginFeature.SSOLoginType.YY),
    SINA(7, "sina"),
    HUAWEI(8, RomUtils.MANUFACTURER_HUAWEI),
    HONOR(9, "honor"),
    XIAOMI(10, RomUtils.MANUFACTURER_XIAOMI),
    MEIZU(11, "meizu"),
    FULL_SCREEN(12, "full_screen"),
    REGISTER(13, "register"),
    DINGDING(14, "dingding"),
    OPPO(15, RomUtils.MANUFACTURER_OPPO);
    
    public final int a;
    public final String b;

    /* access modifiers changed from: public */
    QuickLoginType(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.sapi2.views.logindialog.enums.QuickLoginType getViewLoginTypeByValue(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 2
            r3 = -1012429255(0xffffffffc3a78e39, float:-335.1111)
            if (r0 == r3) goto L_0x002a
            r3 = 109400031(0x6854fdf, float:5.01464E-35)
            if (r0 == r3) goto L_0x0020
            r3 = 926934164(0x373fe494, float:1.1437707E-5)
            if (r0 == r3) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "history"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "share"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "onekey"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r1) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.baidu.sapi2.views.logindialog.enums.QuickLoginType r4 = SMS
            return r4
        L_0x003e:
            com.baidu.sapi2.views.logindialog.enums.QuickLoginType r4 = ONEKEY
            return r4
        L_0x0041:
            com.baidu.sapi2.views.logindialog.enums.QuickLoginType r4 = SHARE
            return r4
        L_0x0044:
            com.baidu.sapi2.views.logindialog.enums.QuickLoginType r4 = HISTORY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.logindialog.enums.QuickLoginType.getViewLoginTypeByValue(java.lang.String):com.baidu.sapi2.views.logindialog.enums.QuickLoginType");
    }

    public int getIndex() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }
}
