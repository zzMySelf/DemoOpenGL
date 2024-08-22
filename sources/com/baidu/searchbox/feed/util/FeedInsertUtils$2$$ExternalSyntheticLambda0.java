package com.baidu.searchbox.feed.util;

import androidx.recyclerview.widget.SimpleItemAnimator;
import com.baidu.searchbox.feed.flow.RefreshablePage;
import com.baidu.searchbox.feed.util.FeedInsertUtils;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedInsertUtils$2$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ RefreshablePage f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ SimpleItemAnimator f$4;

    public /* synthetic */ FeedInsertUtils$2$$ExternalSyntheticLambda0(boolean z, RefreshablePage refreshablePage, int i2, List list, SimpleItemAnimator simpleItemAnimator) {
        this.f$0 = z;
        this.f$1 = refreshablePage;
        this.f$2 = i2;
        this.f$3 = list;
        this.f$4 = simpleItemAnimator;
    }

    public final void run() {
        FeedInsertUtils.AnonymousClass2.lambda$onExecute$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
