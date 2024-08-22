package com.meizu.b0;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.meizu.z.a;

public class c extends a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void a(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.f5398a.getPackageName(), com.meizu.d0.c.g(this.f5398a));
            remoteViews.setTextViewText(com.meizu.d0.c.f(this.f5398a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.d0.c.c(this.f5398a), messageV3.getContent());
            remoteViews.setLong(com.meizu.d0.c.d(this.f5398a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            remoteViews.setViewVisibility(com.meizu.d0.c.b(this.f5398a), 8);
            remoteViews.setViewVisibility(com.meizu.d0.c.a(this.f5398a), 8);
            notification.contentView = remoteViews;
        }
    }

    /* access modifiers changed from: protected */
    public void a(RemoteViews remoteViews, MessageV3 messageV3) {
        Bitmap a2;
        if (messageV3.getAppIconSetting() == null || a() || messageV3.getAppIconSetting().isDefaultLargeIcon() || (a2 = a(messageV3.getAppIconSetting().getLargeIconUrl())) == null) {
            remoteViews.setImageViewBitmap(com.meizu.d0.c.e(this.f5398a), a(this.f5398a, messageV3.getUploadDataPackageName()));
        } else {
            remoteViews.setImageViewBitmap(com.meizu.d0.c.e(this.f5398a), a2);
        }
    }
}
