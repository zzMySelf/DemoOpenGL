package com.baidu.searchbox.appframework.ext;

import android.view.View;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.searchbox.appframework.ext.IActionBarExt;
import com.baidu.searchbox.appframework.ext.IToolBarExt;
import com.baidu.searchbox.toolbar.CommonToolBar;
import com.baidu.searchbox.ui.BdActionBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/appframework/ext/IActionToolBarExt;", "Lcom/baidu/searchbox/appframework/ext/IActionBarExt;", "Lcom/baidu/searchbox/appframework/ext/IToolBarExt;", "lib-appframework-actiontoolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionToolBarExt.kt */
public interface IActionToolBarExt extends IActionBarExt, IToolBarExt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionToolBarExt.kt */
    public static final class DefaultImpls {
        public static CommonToolBar.ToolbarMode getToolBarMode(IActionToolBarExt iActionToolBarExt) {
            return IToolBarExt.DefaultImpls.getToolBarMode(iActionToolBarExt);
        }

        public static void onActionBarBackPressed(IActionToolBarExt iActionToolBarExt) {
            IActionBarExt.DefaultImpls.onActionBarBackPressed(iActionToolBarExt);
        }

        public static void onActionBarDoubleClick(IActionToolBarExt iActionToolBarExt) {
            IActionBarExt.DefaultImpls.onActionBarDoubleClick(iActionToolBarExt);
        }

        public static void onContextActionBarVisibleChanged(IActionToolBarExt iActionToolBarExt, boolean visible) {
            IActionBarExt.DefaultImpls.onContextActionBarVisibleChanged(iActionToolBarExt, visible);
        }

        public static View onCreateContextActionBar(IActionToolBarExt iActionToolBarExt) {
            return IActionBarExt.DefaultImpls.onCreateContextActionBar(iActionToolBarExt);
        }

        public static void onCreateOptionsMenuItems(IActionToolBarExt iActionToolBarExt, BdActionBar actionBar) {
            Intrinsics.checkNotNullParameter(actionBar, "actionBar");
            IActionBarExt.DefaultImpls.onCreateOptionsMenuItems(iActionToolBarExt, actionBar);
        }

        public static void onOptionsMenuItemSelected(IActionToolBarExt iActionToolBarExt, BdMenuItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            IActionBarExt.DefaultImpls.onOptionsMenuItemSelected(iActionToolBarExt, item);
        }

        public static void onUpdateOptionsMenuItems(IActionToolBarExt iActionToolBarExt, List<? extends BdMenuItem> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            IActionBarExt.DefaultImpls.onUpdateOptionsMenuItems(iActionToolBarExt, items);
        }
    }
}
