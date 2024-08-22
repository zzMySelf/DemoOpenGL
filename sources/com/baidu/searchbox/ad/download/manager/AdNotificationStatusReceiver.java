package com.baidu.searchbox.ad.download.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.ad.download.utils.AdDownloadUtils;
import com.baidu.searchbox.ad.util.AdRouter;
import com.baidu.searchbox.feed.ad.AdCKInfoProvider;
import com.baidu.searchbox.feed.ad.Als;
import java.lang.reflect.Method;

public class AdNotificationStatusReceiver extends BroadcastReceiver {
    public static final String RECEIVER_ACTION_CLICK_BUTTON = "CLICK_BUTTON";
    public static final String RECEIVER_ACTION_CLICK_ITEM = "CLICK_ITEM";
    public static final String RECEIVER_ACTION_REMOVE_ITEM = "REMOVE_ITEM";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r18, android.content.Intent r19) {
        /*
            r17 = this;
            r0 = r19
            java.lang.String r1 = r19.getAction()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r2 = "ext"
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r3 = "uri"
            android.os.Parcelable r3 = r0.getParcelableExtra(r3)
            r11 = r3
            android.net.Uri r11 = (android.net.Uri) r11
            java.lang.String r3 = "notificationId"
            r12 = -1
            int r13 = r0.getIntExtra(r3, r12)
            java.lang.String r3 = "pkgName"
            java.lang.String r14 = r0.getStringExtra(r3)
            java.lang.String r3 = "notifyType"
            java.lang.String r15 = r0.getStringExtra(r3)
            java.lang.String r3 = "deeplink"
            java.lang.String r16 = r0.getStringExtra(r3)
            int r3 = r1.hashCode()
            switch(r3) {
                case -262570102: goto L_0x0055;
                case 874178025: goto L_0x004b;
                case 1888645614: goto L_0x0041;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x005f
        L_0x0041:
            java.lang.String r3 = "REMOVE_ITEM"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0040
            r3 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r3 = "CLICK_BUTTON"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0040
            r3 = 1
            goto L_0x0060
        L_0x0055:
            java.lang.String r3 = "CLICK_ITEM"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0040
            r3 = 0
            goto L_0x0060
        L_0x005f:
            r3 = r12
        L_0x0060:
            switch(r3) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0074;
                case 2: goto L_0x0066;
                default: goto L_0x0063;
            }
        L_0x0063:
            r12 = r18
            goto L_0x00ae
        L_0x0066:
            com.baidu.searchbox.feed.ad.Als$LogType r3 = com.baidu.searchbox.feed.ad.Als.LogType.FREE_Click
            java.lang.String r3 = r3.type
            com.baidu.searchbox.feed.ad.Als$Area r4 = com.baidu.searchbox.feed.ad.Als.Area.AD_NOTIFICATION_REMOVE
            java.lang.String r4 = r4.value
            com.baidu.searchbox.ad.download.manager.AdNotificationManager.reportAls(r3, r4, r2, r15)
            r12 = r18
            goto L_0x00ae
        L_0x0074:
            com.baidu.searchbox.feed.ad.Als$Area r3 = com.baidu.searchbox.feed.ad.Als.Area.AD_NOTIFICATION_BTN_CLICK
            java.lang.String r10 = r3.value
            r3 = r17
            r4 = r18
            r5 = r15
            r6 = r14
            r7 = r11
            r8 = r16
            r9 = r2
            r3.onNotificationClick(r4, r5, r6, r7, r8, r9, r10)
            if (r13 == r12) goto L_0x0097
            java.lang.String r3 = "notification"
            r12 = r18
            java.lang.Object r3 = r12.getSystemService(r3)
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3
            r3.cancel(r13)
            goto L_0x00ae
        L_0x0097:
            r12 = r18
            goto L_0x00ae
        L_0x009a:
            r12 = r18
            com.baidu.searchbox.feed.ad.Als$Area r3 = com.baidu.searchbox.feed.ad.Als.Area.AD_NOTIFICATION_ITEM_CLICK
            java.lang.String r10 = r3.value
            r3 = r17
            r4 = r18
            r5 = r15
            r6 = r14
            r7 = r11
            r8 = r16
            r9 = r2
            r3.onNotificationClick(r4, r5, r6, r7, r8, r9, r10)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ad.download.manager.AdNotificationStatusReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void onNotificationClick(Context context, String notifyType, String pkgName, Uri uri, String deeplink, String extraParams, String alsArea) {
        String alsType;
        boolean result;
        if (TextUtils.equals(notifyType, AdNotificationManager.NOTIFY_TYPE_NOTINSTALL)) {
            result = AdDownloadUtils.checkAndInstallApk(context, pkgName, uri);
            alsType = Als.LogType.DOWNLOAD_INSTALL.type;
        } else {
            if (!TextUtils.isEmpty(deeplink)) {
                result = AdRouter.invoke((AdCKInfoProvider) null, context, deeplink);
            } else {
                result = AdDownloadUtils.openApp(context, pkgName, false);
            }
            alsType = Als.LogType.CLICK.type;
        }
        collapseStatusBar(context);
        if (result) {
            AdNotificationManager.reportAls(alsType, alsArea, extraParams, notifyType);
        }
    }

    private void collapseStatusBar(Context context) {
        Method collapse;
        try {
            Object statusBarManager = context.getSystemService("notification");
            if (Build.VERSION.SDK_INT <= 16) {
                collapse = statusBarManager.getClass().getMethod("collapse", new Class[0]);
            } else {
                collapse = statusBarManager.getClass().getMethod("collapsePanels", new Class[0]);
            }
            collapse.invoke(statusBarManager, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
