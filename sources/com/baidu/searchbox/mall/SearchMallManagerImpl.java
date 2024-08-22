package com.baidu.searchbox.mall;

import android.content.Context;
import com.baidu.searchbox.mall.comp.root.MallRootParams;
import com.baidu.searchbox.mall.runtime.MallRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/mall/SearchMallManagerImpl;", "Lcom/baidu/searchbox/mall/SearchMallManager;", "()V", "getMallIncognitoManager", "Lcom/baidu/searchbox/mall/SearchMallIncognitoManager;", "openSearchResult", "", "context", "Landroid/content/Context;", "params", "Lcom/baidu/searchbox/mall/SearchResultParams;", "startSearchFlow", "Lcom/baidu/searchbox/mall/SearchFlowParams;", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchMallManagerImpl.kt */
public final class SearchMallManagerImpl implements SearchMallManager {
    public boolean startSearchFlow(Context context, SearchFlowParams params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        return MallRuntime.INSTANCE.getRouter().startMallSearch(context, MallRootParams.Companion.ofStartSearchFlow(params));
    }

    public boolean openSearchResult(Context context, SearchResultParams params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        return MallRuntime.INSTANCE.getRouter().startMallSearch(context, MallRootParams.Companion.ofOpenSearchResult(params));
    }

    public SearchMallIncognitoManager getMallIncognitoManager() {
        return MallIncognitoImpl.INSTANCE;
    }
}
