package rg.qw;

import android.content.Context;
import dxm.sasdk.util.SensorsDataUtils;

public class ad {
    public static boolean qw(Context context) {
        return SensorsDataUtils.qw(context, "android.permission.INTERNET");
    }
}
