package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
import java.util.List;

public class NaMethodStatUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static String[] f4371ad;
    public static HashMap<String, Long> qw = new HashMap<>();

    public static boolean isFastDoubleClick(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = qw.get(str);
        if (l == null) {
            l = 0L;
        }
        long longValue = currentTimeMillis - l.longValue();
        LogUtil.logd("timeD=" + longValue);
        if (0 < longValue && longValue < 800) {
            return true;
        }
        qw.put(str, Long.valueOf(currentTimeMillis));
        return false;
    }

    public static boolean qw(String str) {
        if (f4371ad == null) {
            f4371ad = SdkInitResponse.getInstance().getNaMethodStatBlackList();
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f4371ad;
            if (i2 >= strArr.length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i2++;
        }
    }

    public static void statEnter(String str, HashMap hashMap) {
        statEnter(str, hashMap == null ? "" : hashMap.toString());
    }

    public static void statResult(String str, int i2, String str2) {
        statResult(str, i2 + "", str2);
    }

    public static void statEnter(String str, String str2) {
        List<String> list;
        if (!qw(str)) {
            if (TextUtils.isEmpty(str2)) {
                list = StatHelper.collectData(str, new String[0]);
            } else {
                list = StatHelper.collectData(str, str2);
            }
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_ENTER, list);
        }
    }

    public static void statResult(String str, String str2, String str3) {
        List<String> list;
        if (!qw(str)) {
            if (TextUtils.isEmpty(str3)) {
                list = StatHelper.collectData(str, str2);
            } else {
                list = StatHelper.collectData(str, str2, str3);
            }
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, list);
        }
    }
}
