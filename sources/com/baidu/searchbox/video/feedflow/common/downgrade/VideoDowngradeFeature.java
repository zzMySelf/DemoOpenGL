package com.baidu.searchbox.video.feedflow.common.downgrade;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/downgrade/VideoDowngradeFeature;", "", "processExtraFeature", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "processPrimaryFeature", "processSecondaryFeature", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDowngradeFeature.kt */
public interface VideoDowngradeFeature {
    void processExtraFeature(CommonState commonState, Action action);

    void processPrimaryFeature(CommonState commonState, Action action);

    void processSecondaryFeature(CommonState commonState, Action action);
}
