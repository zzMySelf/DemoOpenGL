package com.baidu.browser.components.toolbar.impl.newItem;

import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.browser.framework.BdWindowStatistic;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/newItem/HomeBtnClickManager;", "Lcom/baidu/browser/components/toolbar/impl/newItem/BaseBtnClickManager;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "(Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;)V", "onClick", "", "context", "Lcom/baidu/searchbox/unifiedtoolbar/base/BarElementClickContext;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBtnClickManager.kt */
public final class HomeBtnClickManager extends BaseBtnClickManager {
    public HomeBtnClickManager(ISearchBoxToolbarContext toolbarContext) {
        super(toolbarContext);
    }

    public boolean onClick(BarElementClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getElementId() != BottomBarElementID.ELEMENT_ID_HOME) {
            return false;
        }
        ISearchBoxToolbarContext $this$onClick_u24lambda_u2d0 = getToolbarContext();
        if ($this$onClick_u24lambda_u2d0 == null) {
            return true;
        }
        $this$onClick_u24lambda_u2d0.frameContextGoHome();
        $this$onClick_u24lambda_u2d0.setSearchSpeedUbcManagerBackType("3");
        $this$onClick_u24lambda_u2d0.setSearchBoxSessionExtraInfoCollectorWebViewState(BdWindowStatistic.WEBVIEW_STATUS_GOHOME);
        return true;
    }
}
