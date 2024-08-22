package com.baidu.searchbox.bookmark.favor.playlet;

import com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FavorPlayletView$$ExternalSyntheticLambda3 implements Action1 {
    public final /* synthetic */ FavorPlayletView f$0;
    public final /* synthetic */ IUserAssetsContainer f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ FavorPlayletView$$ExternalSyntheticLambda3(FavorPlayletView favorPlayletView, IUserAssetsContainer iUserAssetsContainer, boolean z) {
        this.f$0 = favorPlayletView;
        this.f$1 = iUserAssetsContainer;
        this.f$2 = z;
    }

    public final void call(Object obj) {
        FavorPlayletView.m16642deleteBookMarksAsync$lambda10(this.f$0, this.f$1, this.f$2, (Boolean) obj);
    }
}
