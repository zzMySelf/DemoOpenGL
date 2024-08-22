package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import com.pichillilorenzo.flutter_inappwebview.Options;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChromeCustomTabsOptions implements Options<ChromeCustomTabsActivity> {
    public static final String LOG_TAG = "ChromeCustomTabsOptions";
    @Deprecated
    public Boolean addDefaultShareMenuItem;
    public List<String> additionalTrustedOrigins;
    public TrustedWebActivityDisplayMode displayMode;
    public Boolean enableUrlBarHiding;
    public Boolean instantAppsEnabled;
    public Boolean isSingleInstance;
    public Boolean isTrustedWebActivity;
    public Boolean keepAliveEnabled;
    public Boolean noHistory;
    public String packageName;
    public Integer screenOrientation;
    public Integer shareState = 0;
    public Boolean showTitle = Boolean.TRUE;
    @Nullable
    public String toolbarBackgroundColor;

    public ChromeCustomTabsOptions() {
        Boolean bool = Boolean.FALSE;
        this.enableUrlBarHiding = bool;
        this.instantAppsEnabled = bool;
        this.keepAliveEnabled = bool;
        this.isSingleInstance = bool;
        this.noHistory = bool;
        this.isTrustedWebActivity = bool;
        this.additionalTrustedOrigins = new ArrayList();
        this.displayMode = null;
        this.screenOrientation = 0;
    }

    public Map<String, Object> getRealOptions(ChromeCustomTabsActivity chromeCustomTabsActivity) {
        Intent intent;
        Map<String, Object> map = toMap();
        if (!(chromeCustomTabsActivity == null || (intent = chromeCustomTabsActivity.getIntent()) == null)) {
            map.put("packageName", intent.getPackage());
            map.put("keepAliveEnabled", Boolean.valueOf(intent.hasExtra(CustomTabsHelper.EXTRA_CUSTOM_TABS_KEEP_ALIVE)));
        }
        return map;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        if (r1.equals("IMMERSIVE_MODE") != false) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ChromeCustomTabsOptions parse(java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r7 = this;
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0008:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0174
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0021
            goto L_0x0008
        L_0x0021:
            int r2 = r1.hashCode()
            r3 = 0
            r4 = -1
            r5 = 1
            switch(r2) {
                case -2112880751: goto L_0x00b9;
                case -1913803429: goto L_0x00af;
                case -1799055374: goto L_0x00a5;
                case -632275769: goto L_0x009a;
                case -227713574: goto L_0x0090;
                case 137483238: goto L_0x0086;
                case 227582404: goto L_0x007b;
                case 390710230: goto L_0x0070;
                case 472764366: goto L_0x0066;
                case 908759025: goto L_0x005c;
                case 1518510995: goto L_0x0050;
                case 1578203421: goto L_0x0044;
                case 1714132357: goto L_0x0038;
                case 2126240217: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x00c3
        L_0x002d:
            java.lang.String r2 = "keepAliveEnabled"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 7
            goto L_0x00c4
        L_0x0038:
            java.lang.String r2 = "displayMode"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 12
            goto L_0x00c4
        L_0x0044:
            java.lang.String r2 = "additionalTrustedOrigins"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 11
            goto L_0x00c4
        L_0x0050:
            java.lang.String r2 = "noHistory"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 9
            goto L_0x00c4
        L_0x005c:
            java.lang.String r2 = "packageName"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 6
            goto L_0x00c4
        L_0x0066:
            java.lang.String r2 = "instantAppsEnabled"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 5
            goto L_0x00c4
        L_0x0070:
            java.lang.String r2 = "isTrustedWebActivity"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 10
            goto L_0x00c4
        L_0x007b:
            java.lang.String r2 = "screenOrientation"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 13
            goto L_0x00c4
        L_0x0086:
            java.lang.String r2 = "enableUrlBarHiding"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 4
            goto L_0x00c4
        L_0x0090:
            java.lang.String r2 = "toolbarBackgroundColor"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 3
            goto L_0x00c4
        L_0x009a:
            java.lang.String r2 = "isSingleInstance"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 8
            goto L_0x00c4
        L_0x00a5:
            java.lang.String r2 = "shareState"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 1
            goto L_0x00c4
        L_0x00af:
            java.lang.String r2 = "showTitle"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 2
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r2 = "addDefaultShareMenuItem"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c3
            r1 = 0
            goto L_0x00c4
        L_0x00c3:
            r1 = -1
        L_0x00c4:
            switch(r1) {
                case 0: goto L_0x016e;
                case 1: goto L_0x0168;
                case 2: goto L_0x0162;
                case 3: goto L_0x015c;
                case 4: goto L_0x0156;
                case 5: goto L_0x0150;
                case 6: goto L_0x014a;
                case 7: goto L_0x0144;
                case 8: goto L_0x013e;
                case 9: goto L_0x0138;
                case 10: goto L_0x0132;
                case 11: goto L_0x012c;
                case 12: goto L_0x00cf;
                case 13: goto L_0x00c9;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            goto L_0x0008
        L_0x00c9:
            java.lang.Integer r0 = (java.lang.Integer) r0
            r7.screenOrientation = r0
            goto L_0x0008
        L_0x00cf:
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "type"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0008
            int r2 = r1.hashCode()
            r6 = -920938297(0xffffffffc91b98c7, float:-637324.44)
            if (r2 == r6) goto L_0x00f4
            r3 = 1696380161(0x651cb501, float:4.6251757E22)
            if (r2 == r3) goto L_0x00ea
            goto L_0x00fd
        L_0x00ea:
            java.lang.String r2 = "DEFAULT_MODE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00fd
            r3 = 1
            goto L_0x00fe
        L_0x00f4:
            java.lang.String r2 = "IMMERSIVE_MODE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r3 = -1
        L_0x00fe:
            if (r3 == 0) goto L_0x0104
            if (r3 == r5) goto L_0x0123
            goto L_0x0008
        L_0x0104:
            java.lang.String r1 = "isSticky"
            java.lang.Object r1 = r0.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r2 = "layoutInDisplayCutoutMode"
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            androidx.browser.trusted.TrustedWebActivityDisplayMode$ImmersiveMode r2 = new androidx.browser.trusted.TrustedWebActivityDisplayMode$ImmersiveMode
            r2.<init>(r1, r0)
            r7.displayMode = r2
        L_0x0123:
            androidx.browser.trusted.TrustedWebActivityDisplayMode$DefaultMode r0 = new androidx.browser.trusted.TrustedWebActivityDisplayMode$DefaultMode
            r0.<init>()
            r7.displayMode = r0
            goto L_0x0008
        L_0x012c:
            java.util.List r0 = (java.util.List) r0
            r7.additionalTrustedOrigins = r0
            goto L_0x0008
        L_0x0132:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.isTrustedWebActivity = r0
            goto L_0x0008
        L_0x0138:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.noHistory = r0
            goto L_0x0008
        L_0x013e:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.isSingleInstance = r0
            goto L_0x0008
        L_0x0144:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.keepAliveEnabled = r0
            goto L_0x0008
        L_0x014a:
            java.lang.String r0 = (java.lang.String) r0
            r7.packageName = r0
            goto L_0x0008
        L_0x0150:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.instantAppsEnabled = r0
            goto L_0x0008
        L_0x0156:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.enableUrlBarHiding = r0
            goto L_0x0008
        L_0x015c:
            java.lang.String r0 = (java.lang.String) r0
            r7.toolbarBackgroundColor = r0
            goto L_0x0008
        L_0x0162:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.showTitle = r0
            goto L_0x0008
        L_0x0168:
            java.lang.Integer r0 = (java.lang.Integer) r0
            r7.shareState = r0
            goto L_0x0008
        L_0x016e:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r7.addDefaultShareMenuItem = r0
            goto L_0x0008
        L_0x0174:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ChromeCustomTabsOptions.parse(java.util.Map):com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ChromeCustomTabsOptions");
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("addDefaultShareMenuItem", this.addDefaultShareMenuItem);
        hashMap.put("showTitle", this.showTitle);
        hashMap.put("toolbarBackgroundColor", this.toolbarBackgroundColor);
        hashMap.put("enableUrlBarHiding", this.enableUrlBarHiding);
        hashMap.put("instantAppsEnabled", this.instantAppsEnabled);
        hashMap.put("packageName", this.packageName);
        hashMap.put("keepAliveEnabled", this.keepAliveEnabled);
        hashMap.put("isSingleInstance", this.isSingleInstance);
        hashMap.put("noHistory", this.noHistory);
        hashMap.put("isTrustedWebActivity", this.isTrustedWebActivity);
        hashMap.put("additionalTrustedOrigins", this.additionalTrustedOrigins);
        hashMap.put("screenOrientation", this.screenOrientation);
        return hashMap;
    }
}
