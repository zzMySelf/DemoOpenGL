package com.baidu.searchbox.video.feedflow.detail.toptitle.image;

import com.baidu.searchbox.feed.detail.arch.api.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/toptitle/image/ITopImageTitleService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "getPlayerContainerBackgroundUrl", "", "setVisible", "", "visible", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITopImageTitleService.kt */
public interface ITopImageTitleService extends IService {
    String getPlayerContainerBackgroundUrl();

    void setVisible(boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITopImageTitleService.kt */
    public static final class DefaultImpls {
        public static String getPlayerContainerBackgroundUrl(ITopImageTitleService iTopImageTitleService) {
            return "";
        }

        public static void setVisible(ITopImageTitleService iTopImageTitleService, boolean visible) {
        }
    }
}
