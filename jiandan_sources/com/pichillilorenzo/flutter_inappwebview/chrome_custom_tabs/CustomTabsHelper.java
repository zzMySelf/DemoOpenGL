package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import java.util.List;

public class CustomTabsHelper {
    public static final String BETA_PACKAGE = "com.chrome.beta";
    public static final String DEV_PACKAGE = "com.chrome.dev";
    public static final String EXTRA_CUSTOM_TABS_KEEP_ALIVE = "android.support.customtabs.extra.KEEP_ALIVE";
    public static final String LOCAL_PACKAGE = "com.google.android.apps.chrome";
    public static final String STABLE_PACKAGE = "com.android.chrome";
    public static final String TAG = "CustomTabsHelper";
    public static String sPackageNameToUse;

    public static void addKeepAliveExtra(Context context, Intent intent) {
        intent.putExtra(EXTRA_CUSTOM_TABS_KEEP_ALIVE, new Intent().setClassName(context.getPackageName(), KeepAliveService.class.getCanonicalName()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (r6.contains(r10) != false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPackageNameToUse(android.content.Context r10) {
        /*
            java.lang.String r0 = sPackageNameToUse
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.content.pm.PackageManager r0 = r10.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "http://www.example.com"
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r3 = "android.intent.action.VIEW"
            r1.<init>(r3, r2)
            r2 = 0
            android.content.pm.ResolveInfo r3 = r0.resolveActivity(r1, r2)
            r4 = 0
            if (r3 == 0) goto L_0x0023
            android.content.pm.ActivityInfo r3 = r3.activityInfo
            java.lang.String r3 = r3.packageName
            goto L_0x0024
        L_0x0023:
            r3 = r4
        L_0x0024:
            java.util.List r5 = r0.queryIntentActivities(r1, r2)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0031:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x005c
            java.lang.Object r7 = r5.next()
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            java.lang.String r9 = "android.support.customtabs.action.CustomTabsService"
            r8.setAction(r9)
            android.content.pm.ActivityInfo r9 = r7.activityInfo
            java.lang.String r9 = r9.packageName
            r8.setPackage(r9)
            android.content.pm.ResolveInfo r8 = r0.resolveService(r8, r2)
            if (r8 == 0) goto L_0x0031
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            java.lang.String r7 = r7.packageName
            r6.add(r7)
            goto L_0x0031
        L_0x005c:
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0065
            sPackageNameToUse = r4
            goto L_0x00ae
        L_0x0065:
            int r0 = r6.size()
            r4 = 1
            if (r0 != r4) goto L_0x0075
            java.lang.Object r10 = r6.get(r2)
            java.lang.String r10 = (java.lang.String) r10
        L_0x0072:
            sPackageNameToUse = r10
            goto L_0x00ae
        L_0x0075:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x008a
            boolean r10 = hasSpecializedHandlerIntents(r10, r1)
            if (r10 != 0) goto L_0x008a
            boolean r10 = r6.contains(r3)
            if (r10 == 0) goto L_0x008a
            sPackageNameToUse = r3
            goto L_0x00ae
        L_0x008a:
            java.lang.String r10 = "com.android.chrome"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L_0x0093
        L_0x0092:
            goto L_0x0072
        L_0x0093:
            java.lang.String r10 = "com.chrome.beta"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L_0x009c
            goto L_0x0092
        L_0x009c:
            java.lang.String r10 = "com.chrome.dev"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L_0x00a5
            goto L_0x0092
        L_0x00a5:
            java.lang.String r10 = "com.google.android.apps.chrome"
            boolean r0 = r6.contains(r10)
            if (r0 == 0) goto L_0x00ae
            goto L_0x0092
        L_0x00ae:
            java.lang.String r10 = sPackageNameToUse
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.CustomTabsHelper.getPackageNameToUse(android.content.Context):java.lang.String");
    }

    public static String[] getPackages() {
        return new String[]{"", STABLE_PACKAGE, BETA_PACKAGE, DEV_PACKAGE, LOCAL_PACKAGE};
    }

    public static boolean hasSpecializedHandlerIntents(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() != 0) {
                    for (ResolveInfo next : queryIntentActivities) {
                        IntentFilter intentFilter = next.filter;
                        if (intentFilter != null) {
                            if (intentFilter.countDataAuthorities() == 0) {
                                continue;
                            } else if (intentFilter.countDataPaths() != 0) {
                                if (next.activityInfo != null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (RuntimeException unused) {
        }
        return false;
    }
}
