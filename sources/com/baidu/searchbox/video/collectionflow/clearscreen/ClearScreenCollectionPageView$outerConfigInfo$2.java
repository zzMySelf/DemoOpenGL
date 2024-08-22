package com.baidu.searchbox.video.collectionflow.clearscreen;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.video.feedflow.flow.datainter.DataInterWorkingConfig;
import com.baidu.searchbox.video.feedflow.flow.datainter.service.IDataInterWorkingService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/flow/datainter/DataInterWorkingConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionPageView.kt */
final class ClearScreenCollectionPageView$outerConfigInfo$2 extends Lambda implements Function0<DataInterWorkingConfig> {
    final /* synthetic */ ComponentArchManager $parentManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearScreenCollectionPageView$outerConfigInfo$2(ComponentArchManager componentArchManager) {
        super(0);
        this.$parentManager = componentArchManager;
    }

    public final DataInterWorkingConfig invoke() {
        IDataInterWorkingService iDataInterWorkingService = (IDataInterWorkingService) this.$parentManager.getService(IDataInterWorkingService.class);
        if (iDataInterWorkingService != null) {
            return iDataInterWorkingService.getCurPageConfig();
        }
        return null;
    }
}
