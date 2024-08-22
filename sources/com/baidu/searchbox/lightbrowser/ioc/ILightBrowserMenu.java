package com.baidu.searchbox.lightbrowser.ioc;

import android.view.View;
import com.baidu.android.common.menu.CommonMenuConfig;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.searchbox.lightbrowser.LightBrowserRuntime;
import com.baidu.searchbox.lightbrowser.container.LightBrowserContainer;
import com.baidu.searchbox.lightbrowser.container.presenter.MenuPresenter;
import java.util.List;

public interface ILightBrowserMenu {
    public static final ILightBrowserMenu EMPTY = new ILightBrowserMenu() {
        public List<List<CommonMenuItem>> getStaticMenuItemLists(LightBrowserContainer container) {
            return null;
        }

        public List<List<CommonMenuItem>> getStaticMenuItemLists() {
            return null;
        }

        public List<List<CommonMenuItem>> handleMenuItemLists(MenuPresenter menuPresenter) {
            return null;
        }

        public boolean onCommonMenuItemClick(LightBrowserContainer container, View view2, CommonMenuItem menuItem) {
            return false;
        }

        public CommonMenuConfig getCommonMenuConfig() {
            return null;
        }

        public boolean isTeenagerMode() {
            return false;
        }

        public void onShareShow(MenuPresenter menuPresenter, boolean isNewMenu) {
        }
    };

    CommonMenuConfig getCommonMenuConfig();

    List<List<CommonMenuItem>> getStaticMenuItemLists();

    List<List<CommonMenuItem>> getStaticMenuItemLists(LightBrowserContainer lightBrowserContainer);

    List<List<CommonMenuItem>> handleMenuItemLists(MenuPresenter menuPresenter);

    boolean isTeenagerMode();

    boolean onCommonMenuItemClick(LightBrowserContainer lightBrowserContainer, View view2, CommonMenuItem commonMenuItem);

    void onShareShow(MenuPresenter menuPresenter, boolean z);

    public static final class Impl {
        private static ILightBrowserMenu sMenu = LightBrowserRuntime.getLightBrowserMenu();

        private Impl() {
        }

        public static ILightBrowserMenu get() {
            if (sMenu == null) {
                sMenu = ILightBrowserMenu.EMPTY;
            }
            return sMenu;
        }
    }
}
