package com.baidu.searchbox.home.persuade;

import com.baidu.searchbox.home.persuade.callback.ITaskExitPersuadeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TaskPersuadeManager$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ ITaskExitPersuadeCallback f$0;

    public /* synthetic */ TaskPersuadeManager$$ExternalSyntheticLambda4(ITaskExitPersuadeCallback iTaskExitPersuadeCallback) {
        this.f$0 = iTaskExitPersuadeCallback;
    }

    public final void run() {
        TaskPersuadeManager.m20148showDialogIfAllowed$lambda6$lambda4(this.f$0);
    }
}
