package com.baidu.wallet.core.domain;

import androidx.annotation.NonNull;

public interface a {
    public static final String a = "life_host";
    public static final String b = "xinyongka_host";
    public static final String c = "nfc_host";
    public static final String d = "app_host";
    public static final String e = "dxm_host";
    public static final String f = "zhifu_host";
    public static final String g = "comet_host";
    public static final String h = "my_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f3552i = "init_host";
    public static final String j = "sensors_host";
    public static final String k = "hawking_host";
    public static final String l = "net_check_host";
    public static final String m = "rtc_host";
    public static final String n = "record_host";

    String getAppHost(@NonNull Boolean[] boolArr);

    String getAppPayHost(@NonNull Boolean[] boolArr);

    String getCOHost(@NonNull Boolean[] boolArr);

    String getCometHost(@NonNull Boolean[] boolArr);

    String getCreditCardHost(@NonNull Boolean[] boolArr);

    String getHawkinghost(@NonNull Boolean[] boolArr);

    String getInitHost(int i2, @NonNull Boolean[] boolArr);

    String getLifeHost(@NonNull Boolean[] boolArr);

    String getMHost(@NonNull Boolean[] boolArr);

    String getMyHost(@NonNull Boolean[] boolArr);

    String getNetcheckhost(@NonNull Boolean[] boolArr);

    String getNfcHost(@NonNull Boolean[] boolArr);

    String getQianbaoHost(@NonNull Boolean[] boolArr);

    String getRecordHost(@NonNull Boolean[] boolArr);

    String getRtcHost(@NonNull Boolean[] boolArr);

    String getSensorhost(@NonNull Boolean[] boolArr);

    String getWebCacheHost(@NonNull Boolean[] boolArr);

    String getZhiFuHost(@NonNull Boolean[] boolArr);

    void setDomainConfig(String str);

    void setRtcConfig(String str);
}
