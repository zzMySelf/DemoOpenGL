package com.baidu.searchbox.introduction.ui;

import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TaskGuideDialog$$ExternalSyntheticLambda4 implements ILoginResultListener {
    public final /* synthetic */ TaskGuideDialog f$0;
    public final /* synthetic */ BoxAccountManager f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ TaskGuideDialog$$ExternalSyntheticLambda4(TaskGuideDialog taskGuideDialog, BoxAccountManager boxAccountManager, int i2) {
        this.f$0 = taskGuideDialog;
        this.f$1 = boxAccountManager;
        this.f$2 = i2;
    }

    public final void onResult(int i2) {
        TaskGuideDialog.m20555handleGuideClick$lambda0(this.f$0, this.f$1, this.f$2, i2);
    }
}
