package com.baidu.browser.components.commonmenu.impl.item;

import android.view.View;
import com.baidu.browser.components.commonmenu.core.ICommonMenuContext;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItem;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItemKt;
import com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/browser/components/commonmenu/impl/item/CommonMenuFontItem;", "Lcom/baidu/browser/components/commonmenu/core/SearchCommonMenuItem;", "commonMenuContext", "Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;", "(Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;)V", "onItemClick", "", "view", "Landroid/view/View;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuFontItem.kt */
public final class CommonMenuFontItem extends SearchCommonMenuItem {
    public CommonMenuFontItem(ICommonMenuContext commonMenuContext) {
        super(commonMenuContext, SearchCommonMenuItemKt.makeItem(6));
    }

    public boolean onItemClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        if (commonMenuContext != null) {
            commonMenuContext.popUpFontSizeSettingWindow();
        }
        NewMenuUbcHelperKt.menuBtnClickUBC$default("font", getCommonMenuContext(), NewMenuUbcHelperKt.getDotNum(getNewTip(), getTip()), (String) null, 8, (Object) null);
        return true;
    }
}
