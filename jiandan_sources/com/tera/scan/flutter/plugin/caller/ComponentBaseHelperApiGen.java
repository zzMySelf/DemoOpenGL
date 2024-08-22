package com.tera.scan.flutter.plugin.caller;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface ComponentBaseHelperApiGen {
    String appendCommonParams(String str);

    String getCUID(Context context);

    String getCid();

    String getCookie();

    String getDeviceId();

    String getIMEI();

    String getMacAddress();

    String getSkinTheme(Context context);

    String getUserAgent();

    String getZid();

    boolean isDefaultSkinTheme(Context context);

    String methodRC4Coding(String str, int i2);

    void reportErrorToXray(String str, String str2);

    boolean showToast(String str, int i2);
}
