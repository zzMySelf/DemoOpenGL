package com.baidu.searchbox.paywall.view.tips;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ui.viewpager.BdPagerTab;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/paywall/view/tips/PaywallTabAdapter;", "Lcom/baidu/searchbox/ui/viewpager/BdPagerTabBar$NewTipsTabAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onConfigConvertView", "", "position", "", "convertView", "Landroid/view/View;", "onCreateView", "parent", "Landroid/view/ViewGroup;", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallTabAdapter.kt */
public final class PaywallTabAdapter extends BdPagerTabBar.NewTipsTabAdapter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaywallTabAdapter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public View onCreateView(Context context, ViewGroup parent) {
        return new PaywallTipsTabItem(context);
    }

    /* access modifiers changed from: protected */
    public void onConfigConvertView(Context context, int position, View convertView) {
        if (convertView != null) {
            PaywallTipsTabItem paywallTipsTabItem = (PaywallTipsTabItem) convertView;
            Object item = getItem(position);
            if (item != null) {
                paywallTipsTabItem.setBdPagerTab((BdPagerTab) item);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.ui.viewpager.BdPagerTab");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.paywall.view.tips.PaywallTipsTabItem");
    }
}
