package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.e;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.aa;
import com.vivo.push.util.u;
import java.util.List;

public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback {
    public static final String TAG = "PushMessageReceiver";

    public final void onReceive(Context base, Intent intent) {
        Context base2 = ContextDelegate.getContext(base);
        e.a().a(base2);
        u.d("PushMessageReceiver", "PushMessageReceiver " + base2.getPackageName() + " ; requestId = " + intent.getStringExtra("req_id"));
        try {
            e.a().a(intent, (PushMessageCallback) this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onLog(Context context, String str, int i2, boolean z) {
    }

    public void onListTags(Context context, int i2, List<String> list, String str) {
    }

    public void onPublish(Context context, int i2, String str) {
    }

    public void onBind(Context context, int i2, String str) {
    }

    public void onUnBind(Context context, int i2, String str) {
    }

    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    public void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    public void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
    }

    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    public boolean isAllowNet(Context context) {
        if (context == null) {
            u.a("PushMessageReceiver", "isAllowNet sContext is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            u.a("PushMessageReceiver", "isAllowNet pkgName is null");
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(packageName);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            return aa.a(context, packageName);
        }
        u.a("PushMessageReceiver", "this is client sdk");
        return true;
    }
}
