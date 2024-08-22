package com.baidu.searchbox.video.feedflow.detail.shareenhance;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryAntionManifestKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/shareenhance/ShareEnhanceComponent$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/shareenhance/ShareEnhanceComponent$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareEnhanceComponent.kt */
final class ShareEnhanceComponent$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ ShareEnhanceComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareEnhanceComponent$groupControlListener$2(ShareEnhanceComponent shareEnhanceComponent) {
        super(0);
        this.this$0 = shareEnhanceComponent;
    }

    public final AnonymousClass1 invoke() {
        final ShareEnhanceComponent shareEnhanceComponent = this.this$0;
        return new IGroupControlListener() {
            public void tryShowGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store access$getStore = shareEnhanceComponent.getStore();
                MutableLiveData<Boolean> mutableLiveData = null;
                AbsState absState = access$getStore != null ? (AbsState) access$getStore.getState() : null;
                CommonState commonState = absState instanceof CommonState ? (CommonState) absState : null;
                boolean z = false;
                if (commonState != null && VideoSummaryAntionManifestKt.isVideoSummaryUnfold(commonState)) {
                    z = true;
                }
                if (!z) {
                    Store $this$select$iv = shareEnhanceComponent.getStore();
                    if ($this$select$iv != null) {
                        State state = $this$select$iv.getState();
                        CommonState commonState2 = state instanceof CommonState ? (CommonState) state : null;
                        ShareEnhanceState shareEnhanceState = (ShareEnhanceState) (commonState2 != null ? commonState2.select(ShareEnhanceState.class) : null);
                        if (shareEnhanceState != null) {
                            mutableLiveData = shareEnhanceState.getVisible();
                        }
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(true);
                    }
                }
            }

            public void tryHideGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store $this$select$iv = shareEnhanceComponent.getStore();
                MutableLiveData<Boolean> mutableLiveData = null;
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    ShareEnhanceState shareEnhanceState = (ShareEnhanceState) (commonState != null ? commonState.select(ShareEnhanceState.class) : null);
                    if (shareEnhanceState != null) {
                        mutableLiveData = shareEnhanceState.getVisible();
                    }
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(false);
                }
            }
        };
    }
}
