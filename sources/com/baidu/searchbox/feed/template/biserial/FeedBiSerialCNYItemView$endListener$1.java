package com.baidu.searchbox.feed.template.biserial;

import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.listener.VideoAfxListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/template/biserial/FeedBiSerialCNYItemView$endListener$1", "Lcom/baidu/searchbox/feed/widget/operationfloat/taskfloat/listener/VideoAfxListener;", "onVideoEnded", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBiSerialCNYItemView.kt */
public final class FeedBiSerialCNYItemView$endListener$1 extends VideoAfxListener {
    final /* synthetic */ FeedBiSerialCNYItemView this$0;

    FeedBiSerialCNYItemView$endListener$1(FeedBiSerialCNYItemView $receiver) {
        this.this$0 = $receiver;
    }

    public void onVideoEnded() {
        OnLineLogs.getBiSerialCNYLogger().i("CNYItemView, videoEnd");
        super.onVideoEnded();
        FeedBiSerialCNYItemView feedBiSerialCNYItemView = this.this$0;
        feedBiSerialCNYItemView.post(new FeedBiSerialCNYItemView$endListener$1$$ExternalSyntheticLambda0(feedBiSerialCNYItemView));
    }

    /* access modifiers changed from: private */
    /* renamed from: onVideoEnded$lambda-0  reason: not valid java name */
    public static final void m19528onVideoEnded$lambda0(FeedBiSerialCNYItemView this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.notifyVideoPlayEnd();
    }
}
