package com.baidu.searchbox.download.center.clearcache.view.funison.download.linear;

import com.baidu.searchbox.download.center.clearcache.view.funison.download.DownloadFileInfoWrapper;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "downloadFileInfoWrapper", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/DownloadFileInfoWrapper;", "invoke", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/DownloadFileInfoWrapper;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheDownloadLinearAdapter.kt */
final class ClearCacheDownloadLinearAdapter$deleteDownloadFilesList$1 extends Lambda implements Function1<DownloadFileInfoWrapper, Boolean> {
    final /* synthetic */ HashSet<Long> $downloadIdsSet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheDownloadLinearAdapter$deleteDownloadFilesList$1(HashSet<Long> hashSet) {
        super(1);
        this.$downloadIdsSet = hashSet;
    }

    public final Boolean invoke(DownloadFileInfoWrapper downloadFileInfoWrapper) {
        Intrinsics.checkNotNullParameter(downloadFileInfoWrapper, "downloadFileInfoWrapper");
        return Boolean.valueOf(this.$downloadIdsSet.contains(Long.valueOf(downloadFileInfoWrapper.getData().getDownloadId())));
    }
}
