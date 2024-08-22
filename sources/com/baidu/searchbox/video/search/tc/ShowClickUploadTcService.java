package com.baidu.searchbox.video.search.tc;

import com.baidu.searchbox.video.feedflow.flow.showclick.IShowClickUploadTcService;
import com.baidu.searchbox.video.feedflow.flow.showclick.ShowClickUploadTcSelectedData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J$\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/search/tc/ShowClickUploadTcService;", "Lcom/baidu/searchbox/video/feedflow/flow/showclick/IShowClickUploadTcService;", "()V", "getVideoTcSelectedData", "Lcom/baidu/searchbox/video/feedflow/flow/showclick/ShowClickUploadTcSelectedData;", "tcId", "", "isDistribute", "", "tcJson", "uploadTcSelected", "", "isCyc", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShowClickUploadTcService.kt */
public final class ShowClickUploadTcService implements IShowClickUploadTcService {
    public void uploadTcSelected(String tcId, boolean isCyc, String tcJson) {
        CharSequence charSequence = tcId;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = tcJson;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                if (isCyc) {
                    SearchShowClickUploadByTcManager.INSTANCE.uploadTcSelectedLog(tcId, tcJson);
                }
                FlowTcStatisticValueUtils.INSTANCE.uploadTcSelectedLog(tcId, isCyc, tcJson);
            }
        }
    }

    public ShowClickUploadTcSelectedData getVideoTcSelectedData(String tcId, boolean isDistribute, String tcJson) {
        Intrinsics.checkNotNullParameter(tcId, "tcId");
        Intrinsics.checkNotNullParameter(tcJson, "tcJson");
        return new ShowClickUploadTcSelectedData(tcId, isDistribute, tcJson);
    }
}
