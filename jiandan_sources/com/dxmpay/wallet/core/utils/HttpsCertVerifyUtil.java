package com.dxmpay.wallet.core.utils;

import android.net.http.SslError;
import android.text.TextUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Pattern;

public class HttpsCertVerifyUtil {
    public static boolean isWhiteListVerificationPassed(SslError sslError) {
        if (sslError == null) {
            return false;
        }
        int primaryError = sslError.getPrimaryError();
        if (qw(primaryError)) {
            String str = SdkInitResponse.getInstance().hostWhiteList;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(sslError.getUrl())) {
                try {
                    URL url = new URL(sslError.getUrl());
                    Pattern compile = Pattern.compile(str);
                    if (!TextUtils.isEmpty(url.getHost()) && compile.matcher(url.getHost()).matches()) {
                        StatisticManager.onEventWithValues("#certificate_white_list_passed", Arrays.asList(new String[]{primaryError + "", sslError.getUrl()}));
                        return true;
                    }
                } catch (MalformedURLException e) {
                    e.getMessage();
                }
                StatisticManager.onEventWithValues("#certificate_white_list_failed", Arrays.asList(new String[]{primaryError + "", sslError.getUrl()}));
            }
        }
        return false;
    }

    public static boolean qw(int i2) {
        return 3 == i2 || 4 == i2 || 5 == i2;
    }
}
