package com.baidu.searchbox.launch.restore;

import com.baidu.searchbox.launch.restore.ColdLaunchRestoreManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ColdLaunchRestoreManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ColdLaunchRestoreManager.RestoreResultCallback f$0;

    public /* synthetic */ ColdLaunchRestoreManager$$ExternalSyntheticLambda2(ColdLaunchRestoreManager.RestoreResultCallback restoreResultCallback) {
        this.f$0 = restoreResultCallback;
    }

    public final void run() {
        ColdLaunchRestoreManager.m20676registerRestoredPageListener$lambda1(this.f$0);
    }
}
