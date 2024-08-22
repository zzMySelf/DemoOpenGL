package com.baidu.searchbox.video.feedflow.detail.exitretention;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.exitretention.switcher.ExitRetentionConfigData;
import com.baidu.searchbox.video.feedflow.detail.exitretention.switcher.ExitRetentionSwitcherConfigKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/exitretention/switcher/ExitRetentionConfigData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExitRetentionPlugin.kt */
final class ExitRetentionPlugin$config$2 extends Lambda implements Function0<ExitRetentionConfigData> {
    final /* synthetic */ ExitRetentionPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExitRetentionPlugin$config$2(ExitRetentionPlugin exitRetentionPlugin) {
        super(0);
        this.this$0 = exitRetentionPlugin;
    }

    public final ExitRetentionConfigData invoke() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            return ExitRetentionSwitcherConfigKt.getExitRetentionConfig(access$getStore);
        }
        return null;
    }
}
