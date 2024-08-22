package com.baidu.searchbox.video.feedflow.detail.praise;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.praise.praiseeffect.interfaces.PraiseEffectListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/praise/PraiseComponent$triplePraiseListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseComponent$triplePraiseListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseComponent.kt */
final class PraiseComponent$triplePraiseListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ PraiseComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PraiseComponent$triplePraiseListener$2(PraiseComponent praiseComponent) {
        super(0);
        this.this$0 = praiseComponent;
    }

    public final AnonymousClass1 invoke() {
        final PraiseComponent praiseComponent = this.this$0;
        return new PraiseEffectListenerAdapter() {
            public boolean onLongClickStart() {
                Store access$getStore;
                if (!praiseComponent.canTriggerLongClick() || (access$getStore = praiseComponent.getStore()) == null) {
                    return true;
                }
                access$getStore.dispatch(new PraiseLongPressStart(praiseComponent.getTriplePraisePopPositions()));
                return true;
            }

            public void onLongClickEnd() {
                Store access$getStore;
                if (praiseComponent.canTriggerLongClick() && (access$getStore = praiseComponent.getStore()) != null) {
                    access$getStore.dispatch(new PraiseLongPressCancel());
                }
            }
        };
    }
}
