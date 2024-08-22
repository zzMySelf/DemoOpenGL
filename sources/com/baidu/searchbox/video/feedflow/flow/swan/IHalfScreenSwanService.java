package com.baidu.searchbox.video.feedflow.flow.swan;

import com.baidu.searchbox.feed.detail.arch.api.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/swan/IHalfScreenSwanService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "addListener", "", "listener", "Lcom/baidu/searchbox/video/feedflow/flow/swan/IHalfSwanSwanPullListener;", "removeListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IHalfScreenSwanService.kt */
public interface IHalfScreenSwanService extends IService {
    void addListener(IHalfSwanSwanPullListener iHalfSwanSwanPullListener);

    void removeListener(IHalfSwanSwanPullListener iHalfSwanSwanPullListener);
}
