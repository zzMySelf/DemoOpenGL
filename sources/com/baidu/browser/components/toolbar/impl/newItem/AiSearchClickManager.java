package com.baidu.browser.components.toolbar.impl.newItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.browser.components.toolbar.ToolbarItemEvent;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.browser.core.util.BdViewUtils;
import com.baidu.searchbox.aisearch.AISearchEnterManager;
import com.baidu.searchbox.aisearch.interfaces.AISearchEnterCallback;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/newItem/AiSearchClickManager;", "Lcom/baidu/browser/components/toolbar/impl/newItem/BaseBtnClickManager;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "(Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;)V", "aiSearchBtn", "Landroid/view/View;", "destroy", "", "initAiSearchEntry", "onClick", "", "context", "Lcom/baidu/searchbox/unifiedtoolbar/base/BarElementClickContext;", "onItemEvent", "event", "Lcom/baidu/browser/components/toolbar/ToolbarItemEvent;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiSearchClickManager.kt */
public final class AiSearchClickManager extends BaseBtnClickManager {
    private View aiSearchBtn;

    public AiSearchClickManager(ISearchBoxToolbarContext toolbarContext) {
        super(toolbarContext);
    }

    public boolean onClick(BarElementClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getElementId() != BottomBarElementID.ELEMENT_ID_AI_SEARCH) {
            return false;
        }
        ISearchBoxToolbarContext $this$onClick_u24lambda_u2d0 = getToolbarContext();
        if ($this$onClick_u24lambda_u2d0 == null) {
            return true;
        }
        $this$onClick_u24lambda_u2d0.dismissBrowserMenu();
        $this$onClick_u24lambda_u2d0.frameContextHideAddHomeScreenBanner();
        return true;
    }

    public boolean onItemEvent(ToolbarItemEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType() != 102) {
            return super.onItemEvent(event);
        }
        initAiSearchEntry();
        return true;
    }

    private final void initAiSearchEntry() {
        Context context;
        UnifiedBottomBar newToolbar;
        ISearchBoxToolbarContext toolbarContext = getToolbarContext();
        if (toolbarContext != null && (context = toolbarContext.getContext()) != null) {
            AISearchEnterManager orNull = AISearchEnterManager.Companion.getOrNull();
            View view2 = null;
            if (orNull != null) {
                view2 = orNull.getEnterView(context, "landing", (AISearchEnterCallback) null);
            }
            this.aiSearchBtn = view2;
            if (view2 != null) {
                View it = view2;
                BdViewUtils.removeFromParent(it);
                ISearchBoxToolbarContext toolbarContext2 = getToolbarContext();
                if (toolbarContext2 != null && (newToolbar = toolbarContext2.getNewToolbar()) != null) {
                    newToolbar.addAiSearchIcon(it);
                }
            }
        }
    }

    public void destroy() {
        View view2 = this.aiSearchBtn;
        ViewParent parent = view2 != null ? view2.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.aiSearchBtn);
        }
        this.aiSearchBtn = null;
        super.destroy();
    }
}
