package com.baidu.searchbox.video.feedflow.flow.offlinecache;

import com.baidu.searchbox.video.feedflow.cache.utils.FlowVideoOfflineInsertCacheHelper;
import com.baidu.searchbox.video.feedflow.cache.utils.InsertType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOfflineCachePlugin.kt */
final class FlowOfflineCachePlugin$bufferRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ FlowOfflineCachePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowOfflineCachePlugin$bufferRunnable$2(FlowOfflineCachePlugin flowOfflineCachePlugin) {
        super(0);
        this.this$0 = flowOfflineCachePlugin;
    }

    public final Runnable invoke() {
        return new FlowOfflineCachePlugin$bufferRunnable$2$$ExternalSyntheticLambda0(this.this$0);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m6540invoke$lambda0(FlowOfflineCachePlugin this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.sendBufferBlockAction();
        FlowVideoOfflineInsertCacheHelper access$getInsertCacheHelper = this$02.getInsertCacheHelper();
        if (access$getInsertCacheHelper != null) {
            access$getInsertCacheHelper.insertCache(InsertType.DEFAULT);
        }
    }
}
