package com.baidu.searchbox.download;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: P2pNetDiskRapidDownloadCallback.kt */
final class P2pNetDiskRapidDownloadCallback$onTaskCreate$8 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef<String> $transferFileName;
    final /* synthetic */ Ref.ObjectRef<String> $transferFilePath;
    final /* synthetic */ Ref.ObjectRef<String> $transferMimeType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    P2pNetDiskRapidDownloadCallback$onTaskCreate$8(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3) {
        super(0);
        this.$transferFileName = objectRef;
        this.$transferMimeType = objectRef2;
        this.$transferFilePath = objectRef3;
    }

    public final String invoke() {
        return "P2pNetDiskRapidDownloadCallback.onTaskCreate: updateFile transferFileName " + ((String) this.$transferFileName.element) + " transferMimeType " + ((String) this.$transferMimeType.element) + " transferFilePath " + ((String) this.$transferFilePath.element);
    }
}
