package com.baidu.searchbox.player.iocimpl;

import android.os.Handler;
import android.os.Message;
import com.baidu.apsaras.scheduler.Particle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CyberMsgHandler$$ExternalSyntheticLambda1 implements Particle {
    public final /* synthetic */ Handler f$0;
    public final /* synthetic */ Message f$1;

    public /* synthetic */ CyberMsgHandler$$ExternalSyntheticLambda1(Handler handler, Message message) {
        this.f$0 = handler;
        this.f$1 = message;
    }

    public final void invoke() {
        CyberMsgHandler.m2333sendMessage$lambda0(this.f$0, this.f$1);
    }
}
