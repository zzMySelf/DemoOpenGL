package com.baidu.searchbox.trafficmode;

import android.content.Context;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;

public class SaveTrafficSettingsModeUtil {
    public static final int ENUM_ZEUS_BIG_IMG_VALUE = 0;
    public static final int ENUM_ZEUS_IMAGE_COMPRESS_VALUE = 1;
    public static final int ENUM_ZEUS_NO_IMG_VALUE = 2;
    public static int KEY_RESULT_FROM_SAVE_TRAFFIC = 999;
    public static final String PREFS_TRAFFIC_MODE_KEY = "prefs_traffic_mode_key";
    public static final String PREFS_ZEUS_BIG_IMG_VALUE = "prefs_big_image_setting";
    public static final String PREFS_ZEUS_IMAGE_COMPRESS_VALUE = "prefs_image_compress_setting";
    public static final String PREFS_ZEUS_NO_IMG_VALUE = "prefs_no_image_setting";

    public static void saveTrafficMode(Context context, int index) {
        int lastModeIndex = getCurrentTrafficIndex();
        String trafficMode = "";
        switch (index) {
            case 0:
                trafficMode = "prefs_big_image_setting";
                SaveTrafficSettingsModeUBC.enter("large_image");
                break;
            case 1:
                trafficMode = "prefs_image_compress_setting";
                SaveTrafficSettingsModeUBC.enter("small_image");
                break;
            case 2:
                trafficMode = "prefs_no_image_setting";
                SaveTrafficSettingsModeUBC.enter("no_image");
                break;
        }
        judgeChangeMode(lastModeIndex, index);
        new SharedPrefsWrapper("").putString("prefs_traffic_mode_key", trafficMode);
        setSaveTrafficMode(context, index);
    }

    private static void setSaveTrafficMode(Context context, int index) {
        if (NetWorkUtils.isWifiNetworkConnected(context)) {
            NgWebViewUtils.setFrugalMode(context, false);
            NgWebViewUtils.setNoImageMode(context, false);
            return;
        }
        switch (index) {
            case 0:
                NgWebViewUtils.setFrugalMode(context, false);
                NgWebViewUtils.setNoImageMode(context, false);
                return;
            case 1:
                NgWebViewUtils.setFrugalMode(context, true);
                NgWebViewUtils.setNoImageMode(context, false);
                return;
            case 2:
                NgWebViewUtils.setFrugalMode(context, false);
                NgWebViewUtils.setNoImageMode(context, true);
                return;
            default:
                return;
        }
    }

    private static void judgeChangeMode(int lastModeIndex, int currentModeIndex) {
        if (lastModeIndex != currentModeIndex) {
            if (lastModeIndex == 0 && currentModeIndex == 1) {
                SaveTrafficSettingsModeUBC.enter("large_small");
            } else if (lastModeIndex == 0 && currentModeIndex == 2) {
                SaveTrafficSettingsModeUBC.enter("large_no");
            } else if (lastModeIndex == 1 && currentModeIndex == 0) {
                SaveTrafficSettingsModeUBC.enter("small_large");
            } else if (lastModeIndex == 1 && currentModeIndex == 2) {
                SaveTrafficSettingsModeUBC.enter("small_no");
            } else if (lastModeIndex == 2 && currentModeIndex == 0) {
                SaveTrafficSettingsModeUBC.enter("no_large");
            } else if (lastModeIndex == 2 && currentModeIndex == 1) {
                SaveTrafficSettingsModeUBC.enter("no_small");
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurrentTrafficMode(boolean r6) {
        /*
            java.lang.String r0 = ""
            com.baidu.android.util.sp.SharedPrefsWrapper r1 = new com.baidu.android.util.sp.SharedPrefsWrapper
            java.lang.String r2 = ""
            r1.<init>((java.lang.String) r2)
            java.lang.String r2 = "prefs_traffic_mode_key"
            java.lang.String r3 = "prefs_big_image_setting"
            java.lang.String r1 = r1.getString(r2, r3)
            int r2 = r1.hashCode()
            java.lang.String r4 = "prefs_no_image_setting"
            java.lang.String r5 = "prefs_image_compress_setting"
            switch(r2) {
                case -1531600226: goto L_0x0031;
                case -882667706: goto L_0x0029;
                case 210731805: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0039
        L_0x0021:
            boolean r2 = r1.equals(r4)
            if (r2 == 0) goto L_0x0020
            r2 = 2
            goto L_0x003a
        L_0x0029:
            boolean r2 = r1.equals(r5)
            if (r2 == 0) goto L_0x0020
            r2 = 1
            goto L_0x003a
        L_0x0031:
            boolean r2 = r1.equals(r3)
            if (r2 == 0) goto L_0x0020
            r2 = 0
            goto L_0x003a
        L_0x0039:
            r2 = -1
        L_0x003a:
            switch(r2) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0052;
                case 2: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x007a
        L_0x003e:
            if (r6 == 0) goto L_0x004f
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.baidu.android.common.ui.style.R.string.traffic_short_title_noimage
            java.lang.String r4 = r2.getString(r3)
            goto L_0x0050
        L_0x004f:
        L_0x0050:
            r0 = r4
            goto L_0x007a
        L_0x0052:
            if (r6 == 0) goto L_0x0063
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.baidu.android.common.ui.style.R.string.traffic_short_title_smallimage
            java.lang.String r5 = r2.getString(r3)
            goto L_0x0064
        L_0x0063:
        L_0x0064:
            r0 = r5
            goto L_0x007a
        L_0x0066:
            if (r6 == 0) goto L_0x0077
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.baidu.android.common.ui.style.R.string.traffic_short_title_bigimage
            java.lang.String r3 = r2.getString(r3)
            goto L_0x0078
        L_0x0077:
        L_0x0078:
            r0 = r3
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.trafficmode.SaveTrafficSettingsModeUtil.getCurrentTrafficMode(boolean):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurrentTrafficToastTitle() {
        /*
            java.lang.String r0 = ""
            com.baidu.android.util.sp.SharedPrefsWrapper r1 = new com.baidu.android.util.sp.SharedPrefsWrapper
            java.lang.String r2 = ""
            r1.<init>((java.lang.String) r2)
            java.lang.String r2 = "prefs_traffic_mode_key"
            java.lang.String r3 = "prefs_big_image_setting"
            java.lang.String r1 = r1.getString(r2, r3)
            android.content.Context r2 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            boolean r2 = com.baidu.android.util.devices.NetWorkUtils.isWifiNetworkConnected(r2)
            int r4 = r1.hashCode()
            switch(r4) {
                case -1531600226: goto L_0x0039;
                case -882667706: goto L_0x002e;
                case 210731805: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0041
        L_0x0023:
            java.lang.String r3 = "prefs_no_image_setting"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0022
            r3 = 2
            goto L_0x0042
        L_0x002e:
            java.lang.String r3 = "prefs_image_compress_setting"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0022
            r3 = 1
            goto L_0x0042
        L_0x0039:
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0022
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = -1
        L_0x0042:
            switch(r3) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0067;
                case 2: goto L_0x0046;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0097
        L_0x0046:
            if (r2 == 0) goto L_0x0057
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.string.traffic_short_title_noimage_toast_wifi_title
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0065
        L_0x0057:
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.string.traffic_short_title_noimage_toast_title
            java.lang.String r3 = r3.getString(r4)
        L_0x0065:
            r0 = r3
            goto L_0x0097
        L_0x0067:
            if (r2 == 0) goto L_0x0078
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.string.traffic_short_title_smallimage_toast_wifi_title
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0086
        L_0x0078:
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.string.traffic_short_title_smallimage_toast_title
            java.lang.String r3 = r3.getString(r4)
        L_0x0086:
            r0 = r3
            goto L_0x0097
        L_0x0088:
            android.content.Context r3 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.baidu.android.common.ui.style.R.string.traffic_short_title_bigimage_toast_title
            java.lang.String r0 = r3.getString(r4)
        L_0x0097:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.trafficmode.SaveTrafficSettingsModeUtil.getCurrentTrafficToastTitle():java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCurrentTrafficIndex() {
        /*
            r0 = 0
            com.baidu.android.util.sp.SharedPrefsWrapper r1 = new com.baidu.android.util.sp.SharedPrefsWrapper
            java.lang.String r2 = ""
            r1.<init>((java.lang.String) r2)
            java.lang.String r2 = "prefs_traffic_mode_key"
            java.lang.String r3 = "prefs_big_image_setting"
            java.lang.String r1 = r1.getString(r2, r3)
            int r2 = r1.hashCode()
            switch(r2) {
                case -1531600226: goto L_0x0030;
                case -882667706: goto L_0x0025;
                case 210731805: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0038
        L_0x001a:
            java.lang.String r2 = "prefs_no_image_setting"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 2
            goto L_0x0039
        L_0x0025:
            java.lang.String r2 = "prefs_image_compress_setting"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x0039
        L_0x0030:
            boolean r2 = r1.equals(r3)
            if (r2 == 0) goto L_0x0019
            r2 = 0
            goto L_0x0039
        L_0x0038:
            r2 = -1
        L_0x0039:
            switch(r2) {
                case 0: goto L_0x0041;
                case 1: goto L_0x003f;
                case 2: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0043
        L_0x003d:
            r0 = 2
            goto L_0x0043
        L_0x003f:
            r0 = 1
            goto L_0x0043
        L_0x0041:
            r0 = 0
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.trafficmode.SaveTrafficSettingsModeUtil.getCurrentTrafficIndex():int");
    }
}
