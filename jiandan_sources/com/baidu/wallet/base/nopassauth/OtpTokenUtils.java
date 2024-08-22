package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public final class OtpTokenUtils {
    public static final String a = "OtpTokenUtils";
    public static final String b = "key_later_server_time";
    public static long c = 0;
    public static int d = 10;

    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static String getEncryptTOtpCode(Context context, int i2, String str, int i3) {
        return !TextUtils.isEmpty(str) ? new c(str, i2, 0, i3).a(context) : "";
    }

    public static String getSN(String str) {
        String[] split;
        String decryptProxy = SafePay.getInstance().decryptProxy(str);
        if (!TextUtils.isEmpty(decryptProxy) && (split = decryptProxy.split("\\|")) != null && split.length == 9) {
            return split[2];
        }
        return null;
    }

    public static String getSafeSavedData(String str, Context context) {
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        String str2 = SafePay.getInstance().tokenDecrypt(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            if (bytes.length < 1) {
                return "";
            }
            byte[] bArr = new byte[(bytes.length - 1)];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
            if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(passUid)) {
                bArr = xorArrayRepeat(bArr, passUid.getBytes("UTF-8"));
            }
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSafeSavedDataByUnionId(String str, Context context) {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        String str2 = SafePay.getInstance().tokenDecrypt(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            if (bytes.length < 1) {
                return "";
            }
            byte[] bArr = new byte[(bytes.length - 1)];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
            if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(unionId)) {
                bArr = xorArrayRepeat(bArr, unionId.getBytes("UTF-8"));
            }
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static long getmSyncWithServerTime(Context context) {
        return ((Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, b, 0L)).longValue();
    }

    public static void setmSyncWithServerTime(Context context, long j) {
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, b, Long.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[SYNTHETIC, Splitter:B:25:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[SYNTHETIC, Splitter:B:34:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long syncTime(long r5) {
        /*
            r0 = 0
            r2 = 0
            c = r0     // Catch:{ Exception -> 0x005e }
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x005e }
            java.lang.String r1 = "https://www.baidu.com/"
            r0.<init>(r1)     // Catch:{ Exception -> 0x005e }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x005e }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x005e }
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r1 = 0
            r0.setUseCaches(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            int r1 = d     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            int r1 = r1 * 1000
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            com.baidu.wallet.base.nopassauth.OtpTokenUtils$1 r1 = new com.baidu.wallet.base.nopassauth.OtpTokenUtils$1     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r1.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r0.connect()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            long r1 = r0.getDate()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            c = r1     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r0 == 0) goto L_0x004d
            java.io.InputStream r5 = a(r0)     // Catch:{ Exception -> 0x0046 }
            if (r5 == 0) goto L_0x004a
            r5.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004a:
            r0.disconnect()
        L_0x004d:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 / r3
            long r0 = c
            long r5 = r5 - r0
            return r5
        L_0x0056:
            r5 = move-exception
            r2 = r0
            goto L_0x0076
        L_0x0059:
            r1 = move-exception
            r2 = r0
            goto L_0x005f
        L_0x005c:
            r5 = move-exception
            goto L_0x0076
        L_0x005e:
            r1 = move-exception
        L_0x005f:
            r1.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0075
            java.io.InputStream r0 = a(r2)     // Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0072
            r0.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            r2.disconnect()
        L_0x0075:
            return r5
        L_0x0076:
            if (r2 == 0) goto L_0x0089
            java.io.InputStream r6 = a(r2)     // Catch:{ Exception -> 0x0082 }
            if (r6 == 0) goto L_0x0086
            r6.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0086:
            r2.disconnect()
        L_0x0089:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.nopassauth.OtpTokenUtils.syncTime(long):long");
    }

    public static String toSafeSavedData(String str, Context context) {
        byte[] bArr;
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(passUid)) {
                    bArr = a(str.getBytes("UTF-8"), false);
                } else {
                    bArr = a(xorArrayRepeat(str.getBytes("UTF-8"), passUid.getBytes("UTF-8")), true);
                }
                return SafePay.getInstance().tokenEncrypt(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String toSafeSavedDataByUnionId(String str, Context context) {
        byte[] bArr;
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(unionId)) {
                    bArr = a(str.getBytes("UTF-8"), false);
                } else {
                    bArr = a(xorArrayRepeat(str.getBytes("UTF-8"), unionId.getBytes("UTF-8")), true);
                }
                return SafePay.getInstance().tokenEncrypt(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static byte[] xorArrayRepeat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            bArr3[i3] = (byte) (bArr[i2] ^ bArr2[i3 % bArr2.length]);
            i2++;
            i3++;
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[(bArr.length + 1)];
        int i2 = 0;
        for (byte b2 : bArr) {
            bArr2[i2] = b2;
            i2++;
        }
        bArr2[bArr.length] = z ? (byte) 1 : 0;
        return bArr2;
    }
}
