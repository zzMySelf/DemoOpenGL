package com.baidu.browser.menu.longpress;

import com.baidu.browser.menu.longpress.login.ItemModeHelper;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH&¨\u0006\u0014"}, d2 = {"Lcom/baidu/browser/menu/longpress/ILongPressMenuHelper;", "", "getCommonMenuList", "", "Lcom/baidu/browser/menu/longpress/LongPressMenuItem;", "getCustomCommonMenuList", "getMenuContext", "Lcom/baidu/browser/menu/longpress/LongPressMenuContext;", "isMenuShowing", "", "reloadMenuList", "", "modeHelper", "Lcom/baidu/browser/menu/longpress/login/ItemModeHelper;", "updateItem", "id", "", "title", "", "enable", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressMenuHelper.kt */
public interface ILongPressMenuHelper {
    List<LongPressMenuItem> getCommonMenuList();

    List<LongPressMenuItem> getCustomCommonMenuList();

    LongPressMenuContext getMenuContext();

    boolean isMenuShowing();

    void reloadMenuList(ItemModeHelper itemModeHelper);

    void updateItem(int i2, String str, boolean z);
}
