package com.baidu.live.framework.net;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveNetwork$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ LiveNetwork f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ LiveNetDownloadCallback f$3;

    public /* synthetic */ LiveNetwork$$ExternalSyntheticLambda4(LiveNetwork liveNetwork, Object obj, String str, LiveNetDownloadCallback liveNetDownloadCallback) {
        this.f$0 = liveNetwork;
        this.f$1 = obj;
        this.f$2 = str;
        this.f$3 = liveNetDownloadCallback;
    }

    public final void run() {
        LiveNetwork.m13935download$lambda4(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
