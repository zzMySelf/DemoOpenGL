package com.baidu.searchbox.ugc.mount;

import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"loadMountServerData", "", "taskId", "", "callBack", "Lcom/baidu/searchbox/ugc/mount/MountDataCaaBack;", "lib-ugc-core_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcMountRepos.kt */
public final class UgcMountReposKt {
    public static final void loadMountServerData(String taskId, MountDataCaaBack callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        String url = UgcServerApiUtils.processCommonParams(UgcServerApiUtils.getMountUrl());
        Object newCookieManagerInstance = UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false);
        if (newCookieManagerInstance != null) {
            ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).addUrlParam("task_id", taskId)).addUrlParam(SuggestAddrField.KEY_PAGE_SIZE, "50")).addUrlParam("page_no", "1")).cookieManager((CookieManager) newCookieManagerInstance)).build().executeAsyncOnUIBack(new UgcMountReposKt$loadMountServerData$1(callBack));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.http.cookie.CookieManager");
    }
}
