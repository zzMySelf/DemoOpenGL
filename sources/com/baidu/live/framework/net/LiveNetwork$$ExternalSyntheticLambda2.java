package com.baidu.live.framework.net;

import com.baidu.live.framework.net.LiveNetwork;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveNetwork$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LiveNetCallback f$0;
    public final /* synthetic */ LiveNetwork.Response f$1;
    public final /* synthetic */ Map f$2;

    public /* synthetic */ LiveNetwork$$ExternalSyntheticLambda2(LiveNetCallback liveNetCallback, LiveNetwork.Response response, Map map) {
        this.f$0 = liveNetCallback;
        this.f$1 = response;
        this.f$2 = map;
    }

    public final void run() {
        LiveNetwork.m13938get$lambda3$lambda2(this.f$0, this.f$1, this.f$2);
    }
}
