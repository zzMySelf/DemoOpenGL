package com.huawei.hms.ads.identifier;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class AdvertisingIdClient {
    @Keep
    public static final String SETTINGS_AD_ID = "pps_oaid";
    @Keep
    public static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    public static final class Info {
        @Keep
        public final String advertisingId;
        @Keep
        public final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public native String getId();

        @Keep
        public native boolean isLimitAdTrackingEnabled();
    }

    @Keep
    public static native Info getAdvertisingIdInfo(Context context);

    @Keep
    public static native boolean isAdvertisingIdAvailable(Context context);

    @Keep
    public static native Info requestAdvertisingIdInfo(Context context);

    @Keep
    public static native void updateAdvertisingIdInfo(Context context);

    @Keep
    public static native boolean verifyAdId(Context context, String str, boolean z);
}
