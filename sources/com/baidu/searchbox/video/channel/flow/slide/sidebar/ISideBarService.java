package com.baidu.searchbox.video.channel.flow.slide.sidebar;

import android.view.View;
import com.baidu.searchbox.feed.detail.arch.api.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/slide/sidebar/ISideBarService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "getEnterView", "Landroid/view/View;", "isRedDotShowing", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISideBarService.kt */
public interface ISideBarService extends IService {
    View getEnterView();

    boolean isRedDotShowing();
}
