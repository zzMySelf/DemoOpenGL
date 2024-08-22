package com.baidu.searchbox.video.feedflow.flow.privacypopup;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrivacyPopupPlugin.kt */
final class PrivacyPopupPlugin$registerGuide$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ PrivacyPopupPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrivacyPopupPlugin$registerGuide$1(PrivacyPopupPlugin privacyPopupPlugin) {
        super(0);
        this.this$0 = privacyPopupPlugin;
    }

    public final Boolean invoke() {
        Store $this$select$iv = this.this$0.getStore();
        Boolean bool = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            PrivacyPopupState privacyPopupState = (PrivacyPopupState) (commonState != null ? commonState.select(PrivacyPopupState.class) : null);
            if (privacyPopupState != null) {
                bool = Boolean.valueOf(privacyPopupState.isShowing());
            }
        }
        return Boolean.valueOf(BdPlayerUtils.orFalse(bool));
    }
}
