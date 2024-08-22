package com.baidu.searchbox.video.feedflow.detail.collectionpayment;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButtonComponent$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButtonComponent$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPayButtonComponent.kt */
final class CollectionPayButtonComponent$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ CollectionPayButtonComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionPayButtonComponent$groupControlListener$2(CollectionPayButtonComponent collectionPayButtonComponent) {
        super(0);
        this.this$0 = collectionPayButtonComponent;
    }

    public final AnonymousClass1 invoke() {
        final CollectionPayButtonComponent collectionPayButtonComponent = this.this$0;
        return new IGroupControlListener() {
            public void tryShowGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store $this$select$iv = collectionPayButtonComponent.getStore();
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    Object obj = null;
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    if (commonState != null) {
                        obj = commonState.select(CollectionColumnPayState.class);
                    }
                    CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
                    if (collectionColumnPayState != null) {
                        collectionColumnPayState.setPayButtonVisible(true);
                    }
                }
            }

            public void tryHideGroup(GroupControlArea group) {
                Intrinsics.checkNotNullParameter(group, "group");
                Store $this$select$iv = collectionPayButtonComponent.getStore();
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    Object obj = null;
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    if (commonState != null) {
                        obj = commonState.select(CollectionColumnPayState.class);
                    }
                    CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
                    if (collectionColumnPayState != null) {
                        collectionColumnPayState.setPayButtonVisible(false);
                    }
                }
            }
        };
    }
}
