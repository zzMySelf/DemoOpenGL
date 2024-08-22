package com.baidu.searchbox.feed.news.view;

import android.view.View;
import com.baidu.searchbox.lightbrowser.container.ITopBarCenterView;
import com.baidu.searchbox.lightbrowser.container.model.TopBarButtonType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/news/view/DynamicUserView$handleClickEvent$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicUserView.kt */
public final class DynamicUserView$handleClickEvent$3 implements View.OnClickListener {
    final /* synthetic */ DynamicUserView this$0;

    DynamicUserView$handleClickEvent$3(DynamicUserView $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View v) {
        ITopBarCenterView.TopBarClickCallback access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onTopBarClick(TopBarButtonType.AUTHOR, false);
        }
    }
}
