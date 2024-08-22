package com.baidu.searchbox.search.tab.core.manager;

import com.baidu.searchbox.search.tab.core.manager.IDataManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J8\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/search/tab/core/manager/DataManager;", "Lcom/baidu/searchbox/search/tab/core/manager/IDataManager;", "()V", "bindCallback", "", "callback", "Lcom/baidu/searchbox/search/tab/core/manager/IDataManager$Callback;", "injectManager", "componentManager", "Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "requestUrl", "requestType", "", "url", "", "urlParams", "", "isShowLoading", "", "search_video_framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataManager.kt */
public class DataManager implements IDataManager {
    public void bindCallback(IDataManager.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public void injectManager(IComponentManager componentManager) {
        Intrinsics.checkNotNullParameter(componentManager, "componentManager");
    }

    public void requestUrl(int requestType, String url, Map<String, String> urlParams, boolean isShowLoading) {
    }
}
