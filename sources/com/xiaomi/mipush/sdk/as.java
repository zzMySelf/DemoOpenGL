package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

class as implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f6647a;

    as(ao aoVar) {
        this.f6647a = aoVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6647a) {
            Messenger unused = this.f6647a.f92a = new Messenger(iBinder);
            boolean unused2 = this.f6647a.f6642c = false;
            for (Message send : ao.a(this.f6647a)) {
                try {
                    ao.a(this.f6647a).send(send);
                } catch (RemoteException e2) {
                    b.a((Throwable) e2);
                }
            }
            ao.a(this.f6647a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f6647a.f92a = null;
        boolean unused2 = this.f6647a.f6642c = false;
    }
}
