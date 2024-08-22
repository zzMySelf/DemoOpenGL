package com.baidu.searchbox.introduction.ui;

import android.content.DialogInterface;
import com.baidu.searchbox.introduction.processor.BaseIntroductionProcessor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IntroductionMaskDialog$$ExternalSyntheticLambda3 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ IntroductionMaskDialog f$0;
    public final /* synthetic */ BaseIntroductionProcessor.IntroductionListener f$1;

    public /* synthetic */ IntroductionMaskDialog$$ExternalSyntheticLambda3(IntroductionMaskDialog introductionMaskDialog, BaseIntroductionProcessor.IntroductionListener introductionListener) {
        this.f$0 = introductionMaskDialog;
        this.f$1 = introductionListener;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        IntroductionMaskDialog.m20538showMaskDialog$lambda1(this.f$0, this.f$1, dialogInterface);
    }
}
