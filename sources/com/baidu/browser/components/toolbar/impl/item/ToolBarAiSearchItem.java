package com.baidu.browser.components.toolbar.impl.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.browser.components.toolbar.ToolbarItemEvent;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.browser.components.toolbar.core.SearchBoxToolbarItem;
import com.baidu.searchbox.aisearch.interfaces.AISearchEnterCallback;
import com.baidu.searchbox.common.toolbar.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/item/ToolBarAiSearchItem;", "Lcom/baidu/browser/components/toolbar/core/SearchBoxToolbarItem;", "Lcom/baidu/searchbox/aisearch/interfaces/AISearchEnterCallback;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "(Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;)V", "aiSearchBtn", "Landroid/view/View;", "createCustomView", "destroy", "", "getLid", "", "getResultQuery", "initAiSearchEntry", "onItemClick", "", "onItemEvent", "event", "Lcom/baidu/browser/components/toolbar/ToolbarItemEvent;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolBarAiSearchItem.kt */
public class ToolBarAiSearchItem extends SearchBoxToolbarItem implements AISearchEnterCallback {
    private View aiSearchBtn;

    public ToolBarAiSearchItem(ISearchBoxToolbarContext toolbarContext) {
        super(toolbarContext, 4);
    }

    /* access modifiers changed from: protected */
    public View createCustomView() {
        Context context;
        ISearchBoxToolbarContext toolbarContext = getToolbarContext();
        if (toolbarContext == null || (context = toolbarContext.getContext()) == null) {
            return null;
        }
        int voiceSidePadding = context.getResources().getDimensionPixelOffset(R.dimen.search_tool_bar_voice_side_padding);
        LinearLayout voiceView = new LinearLayout(context);
        voiceView.setOrientation(1);
        voiceView.setGravity(17);
        voiceView.setPadding(voiceSidePadding, 0, voiceSidePadding, 0);
        voiceView.setLayoutParams(new LinearLayout.LayoutParams(voiceSidePadding * 2, -1, 1.0f));
        return voiceView;
    }

    public boolean onItemClick() {
        ISearchBoxToolbarContext $this$onItemClick_u24lambda_u2d0 = getToolbarContext();
        if ($this$onItemClick_u24lambda_u2d0 == null) {
            return true;
        }
        $this$onItemClick_u24lambda_u2d0.dismissBrowserMenu();
        $this$onItemClick_u24lambda_u2d0.frameContextHideAddHomeScreenBanner();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getToolbar();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initAiSearchEntry() {
        /*
            r5 = this;
            com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext r0 = r5.getToolbarContext()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            com.baidu.searchbox.toolbar.CommonToolBar r0 = r0.getToolbar()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getTag()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = "search"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 != 0) goto L_0x002a
            return
        L_0x002a:
            com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext r2 = r5.getToolbarContext()
            if (r2 == 0) goto L_0x0065
            android.content.Context r2 = r2.getContext()
            if (r2 != 0) goto L_0x0037
            goto L_0x0065
        L_0x0037:
            com.baidu.searchbox.aisearch.AISearchEnterManager$Companion r3 = com.baidu.searchbox.aisearch.AISearchEnterManager.Companion
            com.baidu.searchbox.aisearch.AISearchEnterManager r3 = r3.getOrNull()
            if (r3 == 0) goto L_0x0049
            r1 = r5
            com.baidu.searchbox.aisearch.interfaces.AISearchEnterCallback r1 = (com.baidu.searchbox.aisearch.interfaces.AISearchEnterCallback) r1
            java.lang.String r4 = "searchResult"
            android.view.View r1 = r3.getEnterView(r2, r4, r1)
        L_0x0049:
            r5.aiSearchBtn = r1
            com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext r1 = r5.getToolbarContext()
            if (r1 == 0) goto L_0x0063
            com.baidu.searchbox.toolbar.CommonToolBar r1 = r1.getToolbar()
            if (r1 == 0) goto L_0x0063
            r3 = 0
            android.view.View r4 = r5.aiSearchBtn
            com.baidu.browser.core.util.BdViewUtils.removeFromParent(r4)
            android.view.View r4 = r5.aiSearchBtn
            r1.addVoiceEnter(r4)
        L_0x0063:
            return
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.components.toolbar.impl.item.ToolBarAiSearchItem.initAiSearchEntry():void");
    }

    public boolean onItemEvent(ToolbarItemEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType() != 102) {
            return super.onItemEvent(event);
        }
        initAiSearchEntry();
        return true;
    }

    public String getResultQuery() {
        ISearchBoxToolbarContext toolbarContext = getToolbarContext();
        if (toolbarContext != null) {
            return toolbarContext.getCurrentQuery();
        }
        return null;
    }

    public String getLid() {
        ISearchBoxToolbarContext toolbarContext = getToolbarContext();
        if (toolbarContext != null) {
            return toolbarContext.getCurrentLid();
        }
        return null;
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
