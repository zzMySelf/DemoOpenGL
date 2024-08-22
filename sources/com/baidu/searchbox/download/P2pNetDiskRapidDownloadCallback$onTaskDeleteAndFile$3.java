package com.baidu.searchbox.download;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: P2pNetDiskRapidDownloadCallback.kt */
final class P2pNetDiskRapidDownloadCallback$onTaskDeleteAndFile$3 extends Lambda implements Function0<String> {
    final /* synthetic */ P2pNetDiskRapidDownloadCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    P2pNetDiskRapidDownloadCallback$onTaskDeleteAndFile$3(P2pNetDiskRapidDownloadCallback p2pNetDiskRapidDownloadCallback) {
        super(0);
        this.this$0 = p2pNetDiskRapidDownloadCallback;
    }

    public final String invoke() {
        return "P2pNetDiskRapidDownloadCallback.onTaskDeleteAndFile: removeP2pDownloadCallback createId " + this.this$0.createId;
    }
}
