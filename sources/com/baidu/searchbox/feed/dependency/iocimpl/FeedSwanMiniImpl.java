package com.baidu.searchbox.feed.dependency.iocimpl;

import android.app.Activity;
import com.baidu.searchbox.feed.ioc.IFeedSwanMini;
import com.baidu.searchbox.feed.swanmini.SwanMiniPageManager;
import com.baidu.searchbox.feed.swanmini.page.ISwanMiniPageStatus;
import com.baidu.searchbox.feed.widget.feedflow.IPagerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/dependency/iocimpl/FeedSwanMiniImpl;", "Lcom/baidu/searchbox/feed/ioc/IFeedSwanMini;", "()V", "isPageValid", "", "pageView", "Lcom/baidu/searchbox/feed/widget/feedflow/IPagerView;", "obtainSMPagerViewImpl", "hostActivity", "Landroid/app/Activity;", "scheme", "", "channelID", "isContainerPreCreating", "lib-feed-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedSwanMiniImpl.kt */
public final class FeedSwanMiniImpl implements IFeedSwanMini {
    public IPagerView obtainSMPagerViewImpl(Activity hostActivity, String scheme, String channelID, boolean isContainerPreCreating) {
        if (hostActivity == null) {
            return null;
        }
        return SwanMiniPageManager.createSwanMiniPage(hostActivity, scheme, channelID, isContainerPreCreating);
    }

    public boolean isPageValid(IPagerView pageView) {
        ISwanMiniPageStatus iSwanMiniPageStatus = pageView instanceof ISwanMiniPageStatus ? (ISwanMiniPageStatus) pageView : null;
        if (iSwanMiniPageStatus != null) {
            return iSwanMiniPageStatus.isPageValid();
        }
        return true;
    }
}
