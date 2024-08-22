package com.baidu.searchbox.discovery.picture.widget.elements;

import android.view.ViewTreeObserver;
import com.baidu.searchbox.ui.view.BadgeView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UgcBottomStateIconItem$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ UgcBottomStateIconItem f$0;
    public final /* synthetic */ BadgeView f$1;

    public /* synthetic */ UgcBottomStateIconItem$$ExternalSyntheticLambda0(UgcBottomStateIconItem ugcBottomStateIconItem, BadgeView badgeView) {
        this.f$0 = ugcBottomStateIconItem;
        this.f$1 = badgeView;
    }

    public final void onGlobalLayout() {
        UgcBottomStateIconItem.m17024initBadgeViewInBottomBar$lambda4(this.f$0, this.f$1);
    }
}
