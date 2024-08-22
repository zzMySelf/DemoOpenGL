package com.baidu.searchbox.ad.lp.reward.view;

import android.content.Context;
import com.baidu.searchbox.player.H5ProxyPlayer;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.webkit.sdk.VideoPlayer;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/ad/lp/reward/view/RewardWebViewContainer$mPlayerFactoryOnBrowser$1", "Lcom/baidu/webkit/sdk/VideoPlayerFactory;", "create", "Lcom/baidu/webkit/sdk/VideoPlayer;", "context", "Landroid/content/Context;", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RewardWebViewContainer.kt */
public final class RewardWebViewContainer$mPlayerFactoryOnBrowser$1 extends VideoPlayerFactory {
    final /* synthetic */ RewardWebViewContainer this$0;

    RewardWebViewContainer$mPlayerFactoryOnBrowser$1(RewardWebViewContainer $receiver) {
        this.this$0 = $receiver;
    }

    public VideoPlayer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.this$0.mProxyPlayer = new H5ProxyPlayer(context, AbsVideoKernel.CYBER_PLAYER);
        H5ProxyPlayer access$getMProxyPlayer$p = this.this$0.mProxyPlayer;
        Intrinsics.checkNotNull(access$getMProxyPlayer$p);
        return access$getMProxyPlayer$p;
    }
}
