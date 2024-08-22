package com.baidu.searchbox.video.feedflow.flow.lagfluency;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FpsPlugin.kt */
final class FpsPlugin$from$2 extends Lambda implements Function0<String> {
    final /* synthetic */ FpsPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FpsPlugin$from$2(FpsPlugin fpsPlugin) {
        super(0);
        this.this$0 = fpsPlugin;
    }

    public final String invoke() {
        Store $this$select$iv = this.this$0.getStore();
        String str = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
            if (intentData != null) {
                str = intentData.from;
            }
        }
        return str == null ? "flowvideo" : str;
    }
}
