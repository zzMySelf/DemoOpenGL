package com.baidu.searchbox.video.feedflow.slide;

import androidx.fragment.app.FragmentActivity;
import com.baidu.searchbox.account.userinfo.activity.IUpdateStatusBarStyle;
import com.baidu.searchbox.video.detail.utils.VideoImmersionUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/slide/LeftSlidePersonPagePlugin$addFragment$1$2", "Lcom/baidu/searchbox/account/userinfo/activity/IUpdateStatusBarStyle;", "style", "", "lightStatusBar", "", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlidePersonPagePlugin.kt */
public final class LeftSlidePersonPagePlugin$addFragment$1$2 implements IUpdateStatusBarStyle {
    final /* synthetic */ FragmentActivity $it;

    LeftSlidePersonPagePlugin$addFragment$1$2(FragmentActivity $it2) {
        this.$it = $it2;
    }

    public void style(boolean lightStatusBar) {
        VideoImmersionUtils.changeStatusBarIconAndTextColor(!lightStatusBar, this.$it);
    }
}
