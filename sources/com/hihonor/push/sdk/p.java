package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.j;
import com.hihonor.push.sdk.l;

public class p implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f4743e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final RemoteServiceBean f4744a;

    /* renamed from: b  reason: collision with root package name */
    public a f4745b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f4746c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4747d = false;

    public interface a {
    }

    public p(RemoteServiceBean remoteServiceBean) {
        this.f4744a = remoteServiceBean;
    }

    public final void a(int i2) {
        a aVar = this.f4745b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f4737a.f4738a.set(i2 == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            mVar.f4737a.a(i2);
            mVar.f4737a.f4739b = null;
        }
    }

    public void b() {
        try {
            Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
            d.f4684e.a().unbindService(this);
        } catch (Exception e2) {
            "on unBind service exception:" + e2.getMessage();
        }
    }

    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        if (this.f4747d) {
            this.f4747d = false;
            return;
        }
        b();
        a();
        a aVar = this.f4745b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f4737a.f4738a.set(1);
            mVar.f4737a.a(HonorPushErrorCode.ERROR_SERVICE_NULL_BINDING);
            mVar.f4737a.f4739b = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        a aVar = this.f4745b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f4737a.f4739b = IPushInvoke.Stub.asInterface(iBinder);
            if (mVar.f4737a.f4739b == null) {
                mVar.f4737a.f4741d.b();
                mVar.f4737a.f4738a.set(1);
                mVar.f4737a.a(HonorPushErrorCode.ERROR_BIND_SERVICE);
                return;
            }
            mVar.f4737a.f4738a.set(3);
            l.a aVar2 = mVar.f4737a.f4740c;
            if (aVar2 != null) {
                j.a aVar3 = (j.a) aVar2;
                if (Looper.myLooper() == j.this.f4716a.getLooper()) {
                    aVar3.b();
                } else {
                    j.this.f4716a.post(new h(aVar3));
                }
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a aVar = this.f4745b;
        if (aVar != null) {
            m mVar = (m) aVar;
            mVar.f4737a.f4738a.set(1);
            mVar.f4737a.a(HonorPushErrorCode.ERROR_SERVICE_DISCONNECTED);
            mVar.f4737a.f4739b = null;
        }
    }

    public final void a() {
        synchronized (f4743e) {
            Handler handler = this.f4746c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f4746c = null;
            }
        }
    }
}
