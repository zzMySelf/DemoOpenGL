package com.baidu.android.common.util;

import android.content.Context;
import com.baidu.cesium.h;

public class InternalDeviceIdApis {

    public static class TargetPackageCuidV270Info {
        public String iscChannelCuid;
        public String upcChannelCuid;
    }

    public static h a(Context context) {
        DeviceId.getCUID(context);
        return DeviceId.a(context).a();
    }

    public static String getSelfC270Ids(Context context) {
        h.a qw = a(context).qw();
        if (qw != null) {
            return qw.a();
        }
        return null;
    }

    public static TargetPackageCuidV270Info getTargetPackageCuid270Info(Context context, String str) {
        h a = a(context);
        TargetPackageCuidV270Info targetPackageCuidV270Info = new TargetPackageCuidV270Info();
        h.a fe2 = a.fe(str, "upc");
        if (fe2 != null) {
            targetPackageCuidV270Info.upcChannelCuid = fe2.a();
        }
        h.a fe3 = a.fe(str, "isc");
        if (fe3 != null) {
            targetPackageCuidV270Info.iscChannelCuid = fe3.a();
        }
        return targetPackageCuidV270Info;
    }
}
