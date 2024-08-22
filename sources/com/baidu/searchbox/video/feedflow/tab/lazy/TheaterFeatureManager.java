package com.baidu.searchbox.video.feedflow.tab.lazy;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.common.downgrade.CloudDowngradeFeatureParser;
import com.baidu.searchbox.video.feedflow.common.downgrade.DowngradeFeatureManager;
import com.baidu.searchbox.video.feedflow.common.downgrade.DowngradeFeatureWrap;
import com.baidu.searchbox.video.feedflow.tab.lazy.features.FlowLoadingFeature;
import com.baidu.searchbox.video.feedflow.tab.lazy.features.FlowNetErrorFeature;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/lazy/TheaterFeatureManager;", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/DowngradeFeatureManager;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "(Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;)V", "getState", "()Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "createCloudDowngradeFeaturesParser", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/CloudDowngradeFeatureParser;", "createDowngradeFeature", "", "", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/DowngradeFeatureWrap;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterFeatureManager.kt */
public final class TheaterFeatureManager extends DowngradeFeatureManager {
    private final CommonState state;

    public TheaterFeatureManager(CommonState state2) {
        Intrinsics.checkNotNullParameter(state2, "state");
        this.state = state2;
    }

    public final CommonState getState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public Map<String, DowngradeFeatureWrap> createDowngradeFeature() {
        Map linkedHashMap = new LinkedHashMap();
        Map $this$createDowngradeFeature_u24lambda_u2d0 = linkedHashMap;
        $this$createDowngradeFeature_u24lambda_u2d0.put("flow_net_error", new FlowNetErrorFeature());
        $this$createDowngradeFeature_u24lambda_u2d0.put("flow_loading", new FlowLoadingFeature());
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    public CloudDowngradeFeatureParser createCloudDowngradeFeaturesParser() {
        return new TheaterDowngradeFeatureProvider(this.state);
    }
}
