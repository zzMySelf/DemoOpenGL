package com.baidu.ar.npc;

import android.os.Handler;
import android.os.Message;
import com.baidu.ar.npc.ArBridge;

/* compiled from: ArBridge */
class k implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f10047a;

    k(ArBridge arBridge) {
        this.f10047a = arBridge;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        this.f10047a.processIncomingMessage((ArBridge.b) message.obj);
        return false;
    }
}
