package com.baidu.searchbox.video.feedflow.flow.list;

import android.view.View;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowComponent.kt */
final class FlowComponent$tryPostCoreAction$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Class<? extends NestedAction> $actionClazz;
    final /* synthetic */ View $itemView;
    final /* synthetic */ FlowComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowComponent$tryPostCoreAction$1(FlowComponent flowComponent, View view2, Class<? extends NestedAction> cls) {
        super(0);
        this.this$0 = flowComponent;
        this.$itemView = view2;
        this.$actionClazz = cls;
    }

    public final Boolean invoke() {
        Store access$getStore = this.this$0.getStore();
        CommonState commonState = null;
        State state = access$getStore != null ? (AbsState) access$getStore.getState() : null;
        if (state instanceof CommonState) {
            commonState = (CommonState) state;
        }
        return Boolean.valueOf(CommonStateExtKt.isPostCoreAction(commonState, this.this$0.findItemModelByView(this.$itemView), this.$actionClazz));
    }
}
