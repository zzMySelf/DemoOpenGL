package com.baidu.searchbox.video.feedflow.common;

import com.baidu.searchbox.feed.detail.arch.api.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/IPageScaleService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "disallowInterceptFinish", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPageScaleService.kt */
public interface IPageScaleService extends IService {
    void disallowInterceptFinish();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IPageScaleService.kt */
    public static final class DefaultImpls {
        public static void disallowInterceptFinish(IPageScaleService iPageScaleService) {
        }
    }
}
