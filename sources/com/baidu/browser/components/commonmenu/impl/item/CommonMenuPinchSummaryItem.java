package com.baidu.browser.components.commonmenu.impl.item;

import com.baidu.browser.components.commonmenu.core.ICommonMenuContext;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItem;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItemKt;
import com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/browser/components/commonmenu/impl/item/CommonMenuPinchSummaryItem;", "Lcom/baidu/browser/components/commonmenu/core/SearchCommonMenuItem;", "commonMenuContext", "Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;", "(Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;)V", "onItemClick", "", "view", "Landroid/view/View;", "onShow", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuPinchSummaryItem.kt */
public final class CommonMenuPinchSummaryItem extends SearchCommonMenuItem {
    public CommonMenuPinchSummaryItem(ICommonMenuContext commonMenuContext) {
        super(commonMenuContext, SearchCommonMenuItemKt.makeItem(66));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = (r0 = r0.getComponentManager()).getPageViewContext();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onItemClick(android.view.View r9) {
        /*
            r8 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.baidu.browser.components.commonmenu.core.ICommonMenuContext r0 = r8.getCommonMenuContext()
            if (r0 == 0) goto L_0x001d
            com.baidu.browser.arch.component.IBrowserComponentManager r0 = r0.getComponentManager()
            if (r0 == 0) goto L_0x001d
            com.baidu.browser.arch.callback.IBrowserPageViewContext r0 = r0.getPageViewContext()
            if (r0 == 0) goto L_0x001d
            android.content.Context r0 = r0.getContext()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            boolean r1 = r0 instanceof com.baidu.searchbox.appframework.BaseActivity
            if (r1 == 0) goto L_0x002e
            r1 = r0
            com.baidu.searchbox.appframework.BaseActivity r1 = (com.baidu.searchbox.appframework.BaseActivity) r1
            com.baidu.searchbox.pinchsummary.controller.PinchSummaryController r1 = r1.getPinchSummaryController()
            if (r1 == 0) goto L_0x002e
            r1.invokeSummary()
        L_0x002e:
            com.baidu.browser.components.commonmenu.core.ICommonMenuContext r3 = r8.getCommonMenuContext()
            com.baidu.android.common.menu.MenuNewType r1 = r8.getNewTip()
            java.lang.String r2 = r8.getTip()
            java.lang.String r4 = com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt.getDotNum(r1, r2)
            r5 = 0
            r6 = 8
            r7 = 0
            java.lang.String r2 = "summary"
            com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt.menuBtnClickUBC$default(r2, r3, r4, r5, r6, r7)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.components.commonmenu.impl.item.CommonMenuPinchSummaryItem.onItemClick(android.view.View):boolean");
    }

    public void onShow() {
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        NewMenuUbcHelperKt.oldMenuShowUBC(commonMenuContext != null ? commonMenuContext.getBrowserPageViewContext() : null, "summary");
    }
}
