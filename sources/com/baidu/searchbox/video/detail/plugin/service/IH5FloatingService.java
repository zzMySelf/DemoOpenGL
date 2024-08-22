package com.baidu.searchbox.video.detail.plugin.service;

import com.baidu.searchbox.video.detail.service.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/service/IH5FloatingService;", "Lcom/baidu/searchbox/video/detail/service/IService;", "showFloatingView", "", "url", "", "isShowFirstPage", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IH5FloatingService.kt */
public interface IH5FloatingService extends IService {
    void showFloatingView(String str, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IH5FloatingService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showFloatingView$default(IH5FloatingService iH5FloatingService, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                iH5FloatingService.showFloatingView(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFloatingView");
        }
    }
}
