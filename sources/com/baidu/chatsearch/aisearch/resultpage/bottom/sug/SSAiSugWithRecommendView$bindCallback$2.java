package com.baidu.chatsearch.aisearch.resultpage.bottom.sug;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "word", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSugWithRecommendView.kt */
final class SSAiSugWithRecommendView$bindCallback$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ SSAiSugWithRecommendView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiSugWithRecommendView$bindCallback$2(SSAiSugWithRecommendView sSAiSugWithRecommendView) {
        super(1);
        this.this$0 = sSAiSugWithRecommendView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String word) {
        Function1<String, Unit> itemBtnCallback;
        if (word != null) {
            SSAiSugWithRecommendView sSAiSugWithRecommendView = this.this$0;
            String it = word;
            String showType = sSAiSugWithRecommendView.getShowType();
            if (Intrinsics.areEqual((Object) showType, (Object) SSAiSugWithRecommendViewKt.SUG_SHOW_STATUS)) {
                Function1<String, Unit> sugItemBtnCallback = sSAiSugWithRecommendView.getSugItemBtnCallback();
                if (sugItemBtnCallback != null) {
                    sugItemBtnCallback.invoke(it);
                }
            } else if (Intrinsics.areEqual((Object) showType, (Object) SSAiSugWithRecommendViewKt.RECOMMEND_SHOW_STATUS) && (itemBtnCallback = sSAiSugWithRecommendView.getItemBtnCallback()) != null) {
                itemBtnCallback.invoke(it);
            }
        }
    }
}
