package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

class bv implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ServiceClient f7638a;

    bv(ServiceClient serviceClient) {
        this.f7638a = serviceClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7638a) {
            Messenger unused = this.f7638a.f911b = new Messenger(iBinder);
            boolean unused2 = this.f7638a.f912b = false;
            for (Message send : ServiceClient.a(this.f7638a)) {
                try {
                    ServiceClient.a(this.f7638a).send(send);
                } catch (RemoteException e2) {
                    b.a((Throwable) e2);
                }
            }
            ServiceClient.a(this.f7638a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Messenger unused = this.f7638a.f911b = null;
        boolean unused2 = this.f7638a.f912b = false;
    }
}
