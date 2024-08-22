package com.baidu.searchbox.feed.template;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/template/FeedInterestView$afterBindViewHolder$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedInterestView.kt */
public final class FeedInterestView$afterBindViewHolder$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ FeedInterestView this$0;

    FeedInterestView$afterBindViewHolder$1(FeedInterestView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onPreDraw() {
        ViewGroup access$getRootView$p = this.this$0.rootView;
        if (access$getRootView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            access$getRootView$p = null;
        }
        ViewTreeObserver obs = access$getRootView$p.getViewTreeObserver();
        if (obs != null && obs.isAlive()) {
            obs.removeOnPreDrawListener(this);
            this.this$0.interestData.setDisplayed(true);
            this.this$0.mFeedTemplateImplBase.markSelf();
            FeedStatisticCenter.ubcInterestTpl("display", this.this$0.interestData.getUserProperty(), (JSONObject) null);
        }
        return true;
    }
}
