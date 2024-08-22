package com.baidu.bdptask.resource;

import com.baidu.searchbox.pms.bean.PackageInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TimerResDownloadCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PackageInfo f$0;

    public /* synthetic */ TimerResDownloadCallback$$ExternalSyntheticLambda0(PackageInfo packageInfo) {
        this.f$0 = packageInfo;
    }

    public final void run() {
        TimerResDownloadCallback.m12600onDownloadSuccess$lambda0(this.f$0);
    }
}
