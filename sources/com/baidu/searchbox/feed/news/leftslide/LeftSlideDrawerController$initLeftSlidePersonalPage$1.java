package com.baidu.searchbox.feed.news.leftslide;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/feed/news/leftslide/LeftSlideDrawerController$initLeftSlidePersonalPage$1", "Lcom/baidu/searchbox/feed/news/leftslide/ILeftSlideDrawerCallback;", "addLeftSlideDrawerContent", "", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "closeLeftSlideDrawer", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlideDrawerController.kt */
public final class LeftSlideDrawerController$initLeftSlidePersonalPage$1 implements ILeftSlideDrawerCallback {
    final /* synthetic */ LeftSlideDrawerController this$0;

    LeftSlideDrawerController$initLeftSlidePersonalPage$1(LeftSlideDrawerController $receiver) {
        this.this$0 = $receiver;
    }

    public void addLeftSlideDrawerContent(View view2, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.this$0.addDrawerContent(view2, layoutParams);
    }

    public void closeLeftSlideDrawer() {
        this.this$0.closeDrawer();
    }
}
