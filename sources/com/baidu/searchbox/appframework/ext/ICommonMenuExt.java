package com.baidu.searchbox.appframework.ext;

import android.view.View;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuConfig;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.pyramid.annotation.tekes.StableApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005H&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/appframework/ext/ICommonMenuExt;", "Lcom/baidu/searchbox/appframework/ext/ICommonMenuExtObject;", "getCommonMenuConfig", "Lcom/baidu/android/common/menu/CommonMenuConfig;", "getStaticMenuItemLists", "", "Lcom/baidu/android/common/menu/CommonMenuItem;", "handleJsMenuConfig", "", "handleMenuItemLists", "onCommonMenuItemClick", "", "view", "Landroid/view/View;", "menuItem", "onCommonMenuStateChanged", "menu", "Lcom/baidu/android/common/menu/CommonMenu;", "isShown", "lib-appframework-commonmenuext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuExt.kt */
public interface ICommonMenuExt extends ICommonMenuExtObject {
    CommonMenuConfig getCommonMenuConfig();

    List<List<CommonMenuItem>> getStaticMenuItemLists();

    void handleJsMenuConfig();

    List<List<CommonMenuItem>> handleMenuItemLists();

    boolean onCommonMenuItemClick(View view2, CommonMenuItem commonMenuItem);

    void onCommonMenuStateChanged(CommonMenu commonMenu, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommonMenuExt.kt */
    public static final class DefaultImpls {
        public static CommonMenuConfig getCommonMenuConfig(ICommonMenuExt iCommonMenuExt) {
            return new CommonMenuConfig();
        }

        public static void onCommonMenuStateChanged(ICommonMenuExt iCommonMenuExt, CommonMenu menu, boolean isShown) {
            Intrinsics.checkNotNullParameter(menu, "menu");
        }

        public static void handleJsMenuConfig(ICommonMenuExt iCommonMenuExt) {
        }
    }
}
