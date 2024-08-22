package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu;

import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressNewGuidePlugin.kt */
final class LongPressNewGuidePlugin$isPadStyle$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ LongPressNewGuidePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongPressNewGuidePlugin$isPadStyle$2(LongPressNewGuidePlugin longPressNewGuidePlugin) {
        super(0);
        this.this$0 = longPressNewGuidePlugin;
    }

    public final Boolean invoke() {
        boolean z;
        if (DIFactory.INSTANCE.isPadStyle()) {
            Store access$getStore = this.this$0.getStore();
            if (VideoBizUtilsKt.isFromChannelFlow(UBCManifestKt.getPage(access$getStore != null ? (AbsState) access$getStore.getState() : null))) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
