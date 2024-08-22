package com.baidu.searchbox.video.feedflow.detail.bottombannerplaceholder;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/bottombannerplaceholder/BottomBannerPHComponent$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/bottombannerplaceholder/BottomBannerPHComponent$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBannerPHComponent.kt */
final class BottomBannerPHComponent$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ BottomBannerPHComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomBannerPHComponent$groupControlListener$2(BottomBannerPHComponent bottomBannerPHComponent) {
        super(0);
        this.this$0 = bottomBannerPHComponent;
    }

    public final AnonymousClass1 invoke() {
        final BottomBannerPHComponent bottomBannerPHComponent = this.this$0;
        return new IGroupControlListener() {
            public void tryShowGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store $this$select$iv = bottomBannerPHComponent.getStore();
                MutableLiveData<Boolean> mutableLiveData = null;
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    BottomBannerPHState bottomBannerPHState = (BottomBannerPHState) (commonState != null ? commonState.select(BottomBannerPHState.class) : null);
                    if (bottomBannerPHState != null) {
                        mutableLiveData = bottomBannerPHState.isShowOrHideAnim();
                    }
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(true);
                }
            }

            public void tryHideGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store $this$select$iv = bottomBannerPHComponent.getStore();
                MutableLiveData<Boolean> mutableLiveData = null;
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    BottomBannerPHState bottomBannerPHState = (BottomBannerPHState) (commonState != null ? commonState.select(BottomBannerPHState.class) : null);
                    if (bottomBannerPHState != null) {
                        mutableLiveData = bottomBannerPHState.isShowOrHideAnim();
                    }
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(false);
                }
            }
        };
    }
}
