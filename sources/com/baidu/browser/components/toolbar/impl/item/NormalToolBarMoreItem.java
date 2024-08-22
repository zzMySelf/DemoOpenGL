package com.baidu.browser.components.toolbar.impl.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.searchbox.common.toolbar.R;
import com.baidu.searchbox.toolbar.CommonToolBar;
import com.baidu.searchbox.toolbar.SelectorImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/item/NormalToolBarMoreItem;", "Lcom/baidu/browser/components/toolbar/impl/item/ToolBarMoreItem;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "(Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;)V", "createCustomView", "Landroid/view/View;", "onFontSizeChange", "", "setIsResponseFontSize", "isResponseFontSize", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NormalToolBarMoreItem.kt */
public class NormalToolBarMoreItem extends ToolBarMoreItem {
    public NormalToolBarMoreItem(ISearchBoxToolbarContext toolbarContext) {
        super(toolbarContext, (View) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public View createCustomView() {
        Context context;
        ISearchBoxToolbarContext toolbarContext = getToolbarContext();
        if (toolbarContext == null || (context = toolbarContext.getContext()) == null) {
            return null;
        }
        SelectorImageView moreView = new SelectorImageView(context);
        moreView.setIsResponseFontSize(isResponseFontSize());
        moreView.setScaleType(ImageView.ScaleType.CENTER);
        moreView.setImageResource(R.drawable.common_tool_bar_item_more_normal);
        moreView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        return moreView;
    }

    public void setIsResponseFontSize(boolean isResponseFontSize) {
        super.setIsResponseFontSize(isResponseFontSize);
        View itemView = getItemView();
        SelectorImageView selectorImageView = itemView instanceof SelectorImageView ? (SelectorImageView) itemView : null;
        if (selectorImageView != null) {
            selectorImageView.setIsResponseFontSize(isResponseFontSize);
        }
    }

    public void onFontSizeChange() {
        View itemView;
        super.onFontSizeChange();
        if (isTipsShow() && (itemView = getItemView()) != null) {
            itemView.post(new NormalToolBarMoreItem$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFontSizeChange$lambda-0  reason: not valid java name */
    public static final void m12741onFontSizeChange$lambda0(NormalToolBarMoreItem this$0) {
        CommonToolBar toolbar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISearchBoxToolbarContext toolbarContext = this$0.getToolbarContext();
        if (toolbarContext != null && (toolbar = toolbarContext.getToolbar()) != null) {
            toolbar.configMenuTips(2, true, 1);
        }
    }
}
