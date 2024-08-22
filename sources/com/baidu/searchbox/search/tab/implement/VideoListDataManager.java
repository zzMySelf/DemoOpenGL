package com.baidu.searchbox.search.tab.implement;

import com.baidu.searchbox.search.tab.core.manager.DataManager;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.core.manager.IDataManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016J8\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/VideoListDataManager;", "Lcom/baidu/searchbox/search/tab/core/manager/DataManager;", "()V", "callback", "Lcom/baidu/searchbox/search/tab/core/manager/IDataManager$Callback;", "getCallback", "()Lcom/baidu/searchbox/search/tab/core/manager/IDataManager$Callback;", "setCallback", "(Lcom/baidu/searchbox/search/tab/core/manager/IDataManager$Callback;)V", "mComponentManager", "Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "getMComponentManager", "()Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "setMComponentManager", "(Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;)V", "bindCallback", "", "injectManager", "componentManager", "requestUrl", "requestType", "", "url", "", "urlParams", "", "isShowLoading", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoListDataManager.kt */
public class VideoListDataManager extends DataManager {
    private IDataManager.Callback callback;
    private IComponentManager mComponentManager;

    public final IDataManager.Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(IDataManager.Callback callback2) {
        this.callback = callback2;
    }

    public final IComponentManager getMComponentManager() {
        return this.mComponentManager;
    }

    public final void setMComponentManager(IComponentManager iComponentManager) {
        this.mComponentManager = iComponentManager;
    }

    public void bindCallback(IDataManager.Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public void injectManager(IComponentManager componentManager) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
        this.mComponentManager = componentManager;
    }

    public void requestUrl(int requestType, String url, Map<String, String> urlParams, boolean isShowLoading) {
    }
}
