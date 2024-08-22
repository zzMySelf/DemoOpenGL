package com.baidu.searchbox.live.pms;

import com.baidu.searchbox.live.interfaces.pms.ILiveDownloadStatusPmsCallback;
import com.baidu.searchbox.live.interfaces.pms.LivePmsDownloadStatus;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LivePMSOptManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ILiveDownloadStatusPmsCallback f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ LivePmsDownloadStatus f$2;

    public /* synthetic */ LivePMSOptManager$$ExternalSyntheticLambda0(ILiveDownloadStatusPmsCallback iLiveDownloadStatusPmsCallback, String str, LivePmsDownloadStatus livePmsDownloadStatus) {
        this.f$0 = iLiveDownloadStatusPmsCallback;
        this.f$1 = str;
        this.f$2 = livePmsDownloadStatus;
    }

    public final void run() {
        LivePMSOptManager.m212postDownloadCallBack$lambda8(this.f$0, this.f$1, this.f$2);
    }
}
