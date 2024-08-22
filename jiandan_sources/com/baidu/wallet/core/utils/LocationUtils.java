package com.baidu.wallet.core.utils;

import android.content.Context;
import com.baidu.apollon.NoProguard;

public class LocationUtils implements NoProguard {

    public interface ILocationInfo extends NoProguard {
        void callback(String str, String str2);
    }

    public static void getLocationIp(Context context, ILocationInfo iLocationInfo) {
    }
}
