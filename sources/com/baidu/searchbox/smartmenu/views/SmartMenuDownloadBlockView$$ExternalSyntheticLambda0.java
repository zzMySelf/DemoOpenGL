package com.baidu.searchbox.smartmenu.views;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SmartMenuDownloadBlockView$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ SmartMenuDownloadBlockView f$0;

    public /* synthetic */ SmartMenuDownloadBlockView$$ExternalSyntheticLambda0(SmartMenuDownloadBlockView smartMenuDownloadBlockView) {
        this.f$0 = smartMenuDownloadBlockView;
    }

    public final void call(Object obj) {
        SmartMenuDownloadBlockView.m3187subscribeFontSizeChangeEvent$lambda8(this.f$0, (FontSizeChangeMessage) obj);
    }
}
