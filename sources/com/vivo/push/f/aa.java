package com.vivo.push.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.github.moduth.blockcanary.internal.BlockInfo;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.o;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.ab;
import com.vivo.push.util.u;
import java.security.PublicKey;

/* compiled from: OnReceiveTask */
public abstract class aa extends l {

    /* renamed from: b  reason: collision with root package name */
    protected PushMessageCallback f6420b;

    /* renamed from: c  reason: collision with root package name */
    private int f6421c = 0;

    aa(o oVar) {
        super(oVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.f6420b = pushMessageCallback;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!e.a().d()) {
            u.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        } else if (publicKey == null) {
            u.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            u.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                u.d("OnVerifyCallBackCommand", str.hashCode() + BlockInfo.KV + str2);
                if (ab.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    u.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                u.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
                u.c(this.f6478a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                u.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        } else {
            u.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) this.f6478a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (Build.VERSION.SDK_INT < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel == null || notificationChannel.getImportance() != 0) {
                return 0;
            }
            return 2121;
        } catch (Exception e2) {
            u.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    public final int a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            u.b("OnVerifyCallBackCommand", "pkg name : " + this.f6478a.getPackageName() + " 应用到达回调返回值为空，不做处理");
            u.b(this.f6478a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
            return 2163;
        } else if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        } else {
            u.b("OnVerifyCallBackCommand", "pkg name : " + this.f6478a.getPackageName() + " 应用主动拦截通知");
            u.b(this.f6478a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            return 2120;
        }
    }

    public final int c() {
        return this.f6421c;
    }

    public final void a(int i2) {
        this.f6421c = i2;
    }
}
