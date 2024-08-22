package com.dxmpay.wallet.base.nopassauth;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import fe.i.ad.qw.qw.ad;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class OtpTokenUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static int f4137ad = 10;
    public static long qw;

    public static class qw implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return "www.baidu.com".equals(str) || "m.baidu.com".equals(str);
        }
    }

    public static byte[] ad(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[(bArr.length + 1)];
        int i2 = 0;
        for (byte b : bArr) {
            bArr2[i2] = b;
            i2++;
        }
        bArr2[bArr.length] = z ? (byte) 1 : 0;
        return bArr2;
    }

    public static String getEncryptTOtpCode(Context context, int i2, String str, int i3) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_ENCRYPT_OTP_ENTER);
        if (!TextUtils.isEmpty(str)) {
            String a = new ad(str, i2, 0, i3).a(context);
            if (TextUtils.isEmpty(a)) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_ENCRYPT_OTP_IS_NULL);
            } else {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_ENCRYPT_OTP_SUCCESS);
            }
            return a;
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_ENCRYPT_OTP_FAIL);
        return "";
    }

    public static String getSN(String str) {
        String[] split;
        String decryptProxy = SecurePay.getInstance().decryptProxy(str);
        if (!TextUtils.isEmpty(decryptProxy) && (split = decryptProxy.split("\\|")) != null && split.length == 9) {
            return split[2];
        }
        return null;
    }

    public static String getSafeSavedData(String str, Context context) {
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        String str2 = SecurePay.getInstance().tokenDecrypt(str);
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
            LogUtil.e(com.baidu.wallet.base.nopassauth.OtpTokenUtils.a, e.getMessage(), e);
            return "";
        }
    }

    public static String getSafeSavedDataByUnionId(String str, Context context) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SAVE_DATE_ENTER);
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        if (TextUtils.isEmpty(unionId)) {
            unionId = PayUtils.getDxmDid(context);
        }
        String str2 = SecurePay.getInstance().tokenDecrypt(str);
        if (!TextUtils.isEmpty(str2)) {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (bytes.length >= 1) {
                    byte[] bArr = new byte[(bytes.length - 1)];
                    System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
                    if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(unionId)) {
                        bArr = xorArrayRepeat(bArr, unionId.getBytes("UTF-8"));
                    }
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SAVE_DATE_SUCCESS);
                    return new String(bArr, "UTF-8");
                }
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SAVE_DATE_FAIL);
            } catch (UnsupportedEncodingException e) {
                LogUtil.e(com.baidu.wallet.base.nopassauth.OtpTokenUtils.a, e.getMessage(), e);
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_FP_GET_SAVE_DATE_EXCEPTION, e.toString());
            }
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SAVE_DATE_IS_NULL);
        return "";
    }

    public static long getmSyncWithServerTime(Context context) {
        return ((Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.base.nopassauth.OtpTokenUtils.b, 0L)).longValue();
    }

    public static InputStream qw(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static void setmSyncWithServerTime(Context context, long j) {
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.base.nopassauth.OtpTokenUtils.b, Long.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[SYNTHETIC, Splitter:B:25:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long syncTime(long r6) {
        /*
            java.lang.String r0 = "OtpTokenUtils"
            r1 = 0
            r3 = 0
            qw = r1     // Catch:{ Exception -> 0x0064 }
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = "https://www.baidu.com/"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0064 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0064 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x0064 }
            r2 = 1
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r2 = 0
            r1.setUseCaches(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            int r2 = f4137ad     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            int r2 = r2 * 1000
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            com.dxmpay.wallet.base.nopassauth.OtpTokenUtils$qw r2 = new com.dxmpay.wallet.base.nopassauth.OtpTokenUtils$qw     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r2.<init>()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r1.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r1.connect()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            long r2 = r1.getDate()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            qw = r2     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r1 == 0) goto L_0x0053
            java.io.InputStream r6 = qw(r1)     // Catch:{ Exception -> 0x0048 }
            if (r6 == 0) goto L_0x0050
            r6.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0050
        L_0x0048:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r7, r6)
        L_0x0050:
            r1.disconnect()
        L_0x0053:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 / r4
            long r0 = qw
            long r6 = r6 - r0
            return r6
        L_0x005c:
            r6 = move-exception
            r3 = r1
            goto L_0x0084
        L_0x005f:
            r2 = move-exception
            r3 = r1
            goto L_0x0065
        L_0x0062:
            r6 = move-exception
            goto L_0x0084
        L_0x0064:
            r2 = move-exception
        L_0x0065:
            java.lang.String r1 = r2.getMessage()     // Catch:{ all -> 0x0062 }
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r1, r2)     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x0083
            java.io.InputStream r1 = qw(r3)     // Catch:{ Exception -> 0x0078 }
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r2, r1)
        L_0x0080:
            r3.disconnect()
        L_0x0083:
            return r6
        L_0x0084:
            if (r3 == 0) goto L_0x009b
            java.io.InputStream r7 = qw(r3)     // Catch:{ Exception -> 0x0090 }
            if (r7 == 0) goto L_0x0098
            r7.close()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0098
        L_0x0090:
            r7 = move-exception
            java.lang.String r1 = r7.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r0, r1, r7)
        L_0x0098:
            r3.disconnect()
        L_0x009b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.base.nopassauth.OtpTokenUtils.syncTime(long):long");
    }

    public static String toSafeSavedData(String str, Context context) {
        byte[] bArr;
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(passUid)) {
                    bArr = ad(str.getBytes("UTF-8"), false);
                } else {
                    bArr = ad(xorArrayRepeat(str.getBytes("UTF-8"), passUid.getBytes("UTF-8")), true);
                }
                return SecurePay.getInstance().tokenEncrypt(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LogUtil.e(com.baidu.wallet.base.nopassauth.OtpTokenUtils.a, e.getMessage(), e);
            }
        }
        return str;
    }

    public static String toSafeSavedDataByUnionId(String str, Context context) {
        byte[] bArr;
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        if (TextUtils.isEmpty(unionId)) {
            unionId = PayUtils.getDxmDid(context);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(unionId)) {
                    bArr = ad(str.getBytes("UTF-8"), false);
                } else {
                    bArr = ad(xorArrayRepeat(str.getBytes("UTF-8"), unionId.getBytes("UTF-8")), true);
                }
                return SecurePay.getInstance().tokenEncrypt(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LogUtil.e(com.baidu.wallet.base.nopassauth.OtpTokenUtils.a, e.getMessage(), e);
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
}
