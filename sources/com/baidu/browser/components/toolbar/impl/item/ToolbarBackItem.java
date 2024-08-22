package com.baidu.browser.components.toolbar.impl.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.browser.components.backjs.IBackHandlerService;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.browser.components.toolbar.core.SearchBoxToolbarItem;
import com.baidu.searchbox.common.toolbar.R;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.toolbar.RedTipImageView;
import com.baidu.searchbox.util.MemoryCacheUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/item/ToolbarBackItem;", "Lcom/baidu/browser/components/toolbar/core/SearchBoxToolbarItem;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "view", "Landroid/view/View;", "(Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;Landroid/view/View;)V", "sidePadding", "", "getSidePadding", "()I", "onFontSizeChange", "", "onItemClick", "", "setIsResponseFontSize", "isResponseFontSize", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolbarBackItem.kt */
public class ToolbarBackItem extends SearchBoxToolbarItem {
    private final int sidePadding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ToolbarBackItem(ISearchBoxToolbarContext iSearchBoxToolbarContext, View view2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSearchBoxToolbarContext, (i2 & 2) != 0 ? null : view2);
    }

    public ToolbarBackItem(ISearchBoxToolbarContext toolbarContext, View view2) {
        super(toolbarContext, 1, view2);
        int i2;
        Context context;
        Resources resources;
        if (toolbarContext == null || (context = toolbarContext.getContext()) == null || (resources = context.getResources()) == null) {
            i2 = 0;
        } else {
            i2 = resources.getDimensionPixelOffset(R.dimen.search_tool_bar_side_padding);
        }
        this.sidePadding = i2;
    }

    public final int getSidePadding() {
        return this.sidePadding;
    }

    public boolean onItemClick() {
        ISearchBoxToolbarContext $this$onItemClick_u24lambda_u2d1 = getToolbarContext();
        if ($this$onItemClick_u24lambda_u2d1 != null) {
            IBackHandlerService backHandlerService = (IBackHandlerService) $this$onItemClick_u24lambda_u2d1.getComponentService(IBackHandlerService.class);
            if (backHandlerService == null || !backHandlerService.hasBackJS()) {
                $this$onItemClick_u24lambda_u2d1.setSearchSpeedUbcManagerBackType("0");
                MemoryCacheUtil.setValue("home_sug_key", false);
                $this$onItemClick_u24lambda_u2d1.dismissBrowserMenu();
                $this$onItemClick_u24lambda_u2d1.frameContextHideAddHomeScreenBanner();
                $this$onItemClick_u24lambda_u2d1.frameContextGoBack();
                $this$onItemClick_u24lambda_u2d1.setSearchBoxSessionExtraInfoCollectorWebViewState("goBack");
            } else {
                backHandlerService.doBackHandlerJs();
                return true;
            }
        }
        return true;
    }

    public void setIsResponseFontSize(boolean isResponseFontSize) {
        super.setIsResponseFontSize(isResponseFontSize);
        View itemView = getItemView();
        RedTipImageView redTipImageView = itemView instanceof RedTipImageView ? (RedTipImageView) itemView : null;
        if (redTipImageView != null) {
            redTipImageView.setIsResponseFontSize(isResponseFontSize);
        }
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        View itemView = getItemView();
        RedTipImageView it = itemView instanceof RedTipImageView ? (RedTipImageView) itemView : null;
        if (it == null) {
            return;
        }
        if (!isResponseFontSize()) {
            it.setPadding(this.sidePadding, 0, 0, 0);
        } else {
            it.setPadding((int) (((float) this.sidePadding) - ((FontSizeHelper.getScaledSize(0, 57.0f) - 57.0f) / ((float) 2))), 0, 0, 0);
        }
    }
}
