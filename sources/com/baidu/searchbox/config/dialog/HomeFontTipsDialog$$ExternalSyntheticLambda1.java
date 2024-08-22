package com.baidu.searchbox.config.dialog;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeFontTipsDialog$$ExternalSyntheticLambda1 implements Action {
    public final /* synthetic */ HomeFontTipsDialog f$0;

    public /* synthetic */ HomeFontTipsDialog$$ExternalSyntheticLambda1(HomeFontTipsDialog homeFontTipsDialog) {
        this.f$0 = homeFontTipsDialog;
    }

    public final void call(Object obj) {
        HomeFontTipsDialog.m16927subscribeFontSizeChangeEvent$lambda7(this.f$0, (FontSizeChangeMessage) obj);
    }
}
