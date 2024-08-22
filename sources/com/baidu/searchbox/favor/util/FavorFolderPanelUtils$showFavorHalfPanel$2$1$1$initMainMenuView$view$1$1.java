package com.baidu.searchbox.favor.util;

import com.baidu.android.common.menu.BaseMenuPopupWindow;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.favor.view.FavorFolderPanelView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/favor/util/FavorFolderPanelUtils$showFavorHalfPanel$2$1$1$initMainMenuView$view$1$1", "Lcom/baidu/searchbox/favor/view/FavorFolderPanelView$PanelEventListener;", "onCancelClick", "", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorFolderPanelUtils.kt */
public final class FavorFolderPanelUtils$showFavorHalfPanel$2$1$1$initMainMenuView$view$1$1 implements FavorFolderPanelView.PanelEventListener {
    FavorFolderPanelUtils$showFavorHalfPanel$2$1$1$initMainMenuView$view$1$1() {
    }

    public void onCancelClick() {
        UiThreadUtils.runOnUiThread(new FavorFolderPanelUtils$showFavorHalfPanel$2$1$1$initMainMenuView$view$1$1$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCancelClick$lambda-0  reason: not valid java name */
    public static final void m18374onCancelClick$lambda0() {
        FavorFolderPanelUtils favorFolderPanelUtils = FavorFolderPanelUtils.INSTANCE;
        FavorFolderPanelUtils.isActiveClose = true;
        BaseMenuPopupWindow access$getFavorPanel$p = FavorFolderPanelUtils.favorPanel;
        if (access$getFavorPanel$p != null) {
            access$getFavorPanel$p.dismiss();
        }
    }
}
