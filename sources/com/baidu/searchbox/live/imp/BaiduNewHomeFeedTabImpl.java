package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.feed.tab.service.INewHomeFeedTabApi;
import com.baidu.searchbox.live.imp.BaiduNewHomeFeedTabImpl$mScrollListener$2;
import com.baidu.searchbox.live.interfaces.callback.IBaiduHomeTabScrollListener;
import com.baidu.searchbox.live.interfaces.service.bd.IBaiduNewHomeFeedTabInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/imp/BaiduNewHomeFeedTabImpl;", "Lcom/baidu/searchbox/live/interfaces/service/bd/IBaiduNewHomeFeedTabInterface;", "()V", "homeFeedTabApi", "Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi;", "kotlin.jvm.PlatformType", "getHomeFeedTabApi", "()Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi;", "homeFeedTabApi$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/baidu/searchbox/live/interfaces/callback/IBaiduHomeTabScrollListener;", "mScrollListener", "com/baidu/searchbox/live/imp/BaiduNewHomeFeedTabImpl$mScrollListener$2$1", "getMScrollListener", "()Lcom/baidu/searchbox/live/imp/BaiduNewHomeFeedTabImpl$mScrollListener$2$1;", "mScrollListener$delegate", "addScrollableHeightListener", "", "listener", "getFeedTabHeight", "", "removeScrollableHeightListener", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaiduNewHomeFeedTabImpl.kt */
public final class BaiduNewHomeFeedTabImpl implements IBaiduNewHomeFeedTabInterface {
    private final Lazy homeFeedTabApi$delegate = LazyKt.lazy(BaiduNewHomeFeedTabImpl$homeFeedTabApi$2.INSTANCE);
    /* access modifiers changed from: private */
    public IBaiduHomeTabScrollListener mListener;
    private final Lazy mScrollListener$delegate = LazyKt.lazy(new BaiduNewHomeFeedTabImpl$mScrollListener$2(this));

    private final INewHomeFeedTabApi getHomeFeedTabApi() {
        return (INewHomeFeedTabApi) this.homeFeedTabApi$delegate.getValue();
    }

    private final BaiduNewHomeFeedTabImpl$mScrollListener$2.AnonymousClass1 getMScrollListener() {
        return (BaiduNewHomeFeedTabImpl$mScrollListener$2.AnonymousClass1) this.mScrollListener$delegate.getValue();
    }

    public int getFeedTabHeight() {
        INewHomeFeedTabApi homeFeedTabApi = getHomeFeedTabApi();
        if (homeFeedTabApi != null) {
            return homeFeedTabApi.getFeedTabHeight();
        }
        return 0;
    }

    public void addScrollableHeightListener(IBaiduHomeTabScrollListener listener) {
        this.mListener = listener;
        INewHomeFeedTabApi homeFeedTabApi = getHomeFeedTabApi();
        if (homeFeedTabApi != null) {
            homeFeedTabApi.addFeedTabScrollListener(getMScrollListener());
        }
    }

    public void removeScrollableHeightListener() {
        INewHomeFeedTabApi homeFeedTabApi = getHomeFeedTabApi();
        if (homeFeedTabApi != null) {
            homeFeedTabApi.removeListener(getMScrollListener());
        }
        this.mListener = null;
    }
}
