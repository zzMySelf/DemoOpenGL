package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feedback.receiver.UFOEventType;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.List;
import java.util.concurrent.Callable;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4692a;

    /* renamed from: b  reason: collision with root package name */
    public k f4693b = new k();

    public e(Context context) {
        this.f4692a = context;
    }

    /* access modifiers changed from: private */
    public Boolean d() throws Exception {
        this.f4693b.getClass();
        try {
            m0 m0Var = new m0(UpMsgType.QUERY_PUSH_STATUS, (IMessageEntity) null);
            m0Var.f4752e = a.a();
            return Boolean.valueOf(((BooleanResult) a.a(j.f4715c.a(m0Var))).getStatus());
        } catch (Exception e2) {
            throw a.a(e2);
        }
    }

    public void a(HonorPushCallback<String> honorPushCallback, boolean z) {
        a(new e$$ExternalSyntheticLambda0(this, z), honorPushCallback);
    }

    public void b(HonorPushCallback<Void> honorPushCallback) {
        a(new e$$ExternalSyntheticLambda8(this), honorPushCallback);
    }

    public void c(HonorPushCallback<Void> honorPushCallback) {
        a(new e$$ExternalSyntheticLambda3(this), honorPushCallback);
    }

    public void e(HonorPushCallback<Boolean> honorPushCallback) {
        a(new e$$ExternalSyntheticLambda2(this), honorPushCallback);
    }

    /* access modifiers changed from: private */
    public String a(boolean z) throws Exception {
        this.f4693b.getClass();
        try {
            o0 o0Var = new o0(UpMsgType.REQUEST_PUSH_TOKEN, (IMessageEntity) null);
            o0Var.f4752e = a.a();
            String pushToken = ((PushTokenResult) a.a(j.f4715c.a(o0Var))).getPushToken();
            if (z && !TextUtils.isEmpty(pushToken)) {
                Bundle bundle = new Bundle();
                bundle.putString(UFOEventType.EVENT_TYPE_KEY, DownMsgType.RECEIVE_TOKEN);
                bundle.putString("push_token", pushToken);
                q qVar = new q();
                Context context = this.f4692a;
                Log.i("MessengerSrvConnection", "start bind service.");
                try {
                    Intent intent = new Intent();
                    intent.setPackage(context.getPackageName());
                    intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                    Context applicationContext = context.getApplicationContext();
                    qVar.f4756c = applicationContext;
                    qVar.f4755b = bundle;
                    if (applicationContext.bindService(intent, qVar, 1)) {
                        Log.i("MessengerSrvConnection", "bind service succeeded.");
                    }
                } catch (Exception e2) {
                    "bind service failed." + e2.getMessage();
                }
            }
            return pushToken;
        } catch (Exception e3) {
            throw a.a(e3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void b() throws Exception {
        this.f4693b.a(false);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void c() throws Exception {
        this.f4693b.a(true);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Callable callable, HonorPushCallback honorPushCallback) {
        try {
            a(honorPushCallback, callable.call());
        } catch (ApiException e2) {
            a(honorPushCallback, e2.getErrorCode(), e2.getMessage());
        } catch (Exception e3) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_INTERNAL_ERROR;
            a(honorPushCallback, honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void d(HonorPushCallback<List<HonorPushDataMsg>> honorPushCallback) {
        if (honorPushCallback != null) {
            j0 a2 = a.a(new z(this.f4692a));
            e$$ExternalSyntheticLambda7 e__externalsyntheticlambda7 = new e$$ExternalSyntheticLambda7(this, honorPushCallback);
            a2.getClass();
            a2.a(new d0(y.f4761c.f4762a, e__externalsyntheticlambda7));
        }
    }

    public static /* synthetic */ void b(HonorPushCallback honorPushCallback, Object obj) {
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(obj);
        }
    }

    public static /* synthetic */ void b(HonorPushCallback honorPushCallback, int i2, String str) {
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(i2, str);
        }
    }

    public void a(HonorPushCallback<Void> honorPushCallback) {
        a(new e$$ExternalSyntheticLambda5(this), honorPushCallback);
    }

    /* access modifiers changed from: private */
    public Void a() throws Exception {
        k kVar = this.f4693b;
        Context context = this.f4692a;
        kVar.getClass();
        try {
            n0 n0Var = new n0(UpMsgType.UNREGISTER_PUSH_TOKEN, (IMessageEntity) null);
            n0Var.f4752e = a.a();
            a.a(j.f4715c.a(n0Var));
            c.f4681b.a(context, (String) null);
            return null;
        } catch (Exception e2) {
            throw a.a(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(HonorPushCallback honorPushCallback, j0 j0Var) {
        if (j0Var.e()) {
            a(honorPushCallback, (List) j0Var.c());
        } else {
            a(honorPushCallback, -1, j0Var.b().toString());
        }
    }

    public final <T> void a(Callable<T> callable, HonorPushCallback<T> honorPushCallback) {
        e$$ExternalSyntheticLambda1 e__externalsyntheticlambda1 = new e$$ExternalSyntheticLambda1(this, callable, honorPushCallback);
        k0 k0Var = k0.f4730f;
        if (k0Var.f4734d == null) {
            synchronized (k0Var.f4735e) {
                if (k0Var.f4734d == null) {
                    k0Var.f4734d = k0Var.b();
                }
            }
        }
        k0Var.f4734d.execute(e__externalsyntheticlambda1);
    }

    public final <T> void a(HonorPushCallback<T> honorPushCallback, T t) {
        k0.a(new e$$ExternalSyntheticLambda4(honorPushCallback, t));
    }

    public final void a(HonorPushCallback<?> honorPushCallback, int i2, String str) {
        k0.a(new e$$ExternalSyntheticLambda6(honorPushCallback, i2, str));
    }
}
