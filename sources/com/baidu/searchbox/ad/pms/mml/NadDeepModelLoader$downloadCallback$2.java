package com.baidu.searchbox.ad.pms.mml;

import com.baidu.searchbox.ad.pms.mml.NadDeepModelLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ad/pms/mml/NadDeepModelLoader$MMLDownloadCallback;", "Lcom/baidu/searchbox/ad/pms/mml/NadDeepModelLoader;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDeepModelLoader.kt */
final class NadDeepModelLoader$downloadCallback$2 extends Lambda implements Function0<NadDeepModelLoader.MMLDownloadCallback> {
    final /* synthetic */ NadDeepModelLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadDeepModelLoader$downloadCallback$2(NadDeepModelLoader nadDeepModelLoader) {
        super(0);
        this.this$0 = nadDeepModelLoader;
    }

    public final NadDeepModelLoader.MMLDownloadCallback invoke() {
        return new NadDeepModelLoader.MMLDownloadCallback();
    }
}
