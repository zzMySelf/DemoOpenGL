package com.baidu.searchbox.home.persuade;

import com.baidu.searchbox.home.persuade.callback.ITaskExitPersuadeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TaskPersuadeManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ITaskExitPersuadeCallback f$0;

    public /* synthetic */ TaskPersuadeManager$$ExternalSyntheticLambda2(ITaskExitPersuadeCallback iTaskExitPersuadeCallback) {
        this.f$0 = iTaskExitPersuadeCallback;
    }

    public final void run() {
        TaskPersuadeManager.m20146showDialogIfAllowed$lambda6$lambda2(this.f$0);
    }
}
