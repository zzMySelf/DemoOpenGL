package com.baidu.searchbox.mvp.aicard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.mvp.common.MvpCommonPageExtKt;
import com.baidu.searchbox.mvp.edit.AiEditComponentKt;
import com.baidu.searchbox.mvp.entity.Card;
import com.baidu.searchbox.mvp.entity.Idea;
import com.baidu.searchbox.mvp.widget.aicard.AiCardViewPointView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mark", "", "idea", "Lcom/baidu/searchbox/mvp/entity/Idea;", "card", "Lcom/baidu/searchbox/mvp/entity/Card;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCardHelper.kt */
final class AiCardHelper$getCardView$3$1 extends Lambda implements Function3<String, Idea, Card, Unit> {
    final /* synthetic */ FrameLayout $aiCardContainer;
    final /* synthetic */ Store<AbsState> $store;
    final /* synthetic */ AiCardViewPointView $this_apply;
    final /* synthetic */ AiCardHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiCardHelper$getCardView$3$1(AiCardHelper aiCardHelper, FrameLayout frameLayout, Store<AbsState> store, AiCardViewPointView aiCardViewPointView) {
        super(3);
        this.this$0 = aiCardHelper;
        this.$aiCardContainer = frameLayout;
        this.$store = store;
        this.$this_apply = aiCardViewPointView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((String) p1, (Idea) p2, (Card) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(String mark, Idea idea, Card card) {
        Function3<Card, String, String, Unit> clkReportAction = this.this$0.getClkReportAction();
        if (clkReportAction != null) {
            String str = null;
            String title = idea != null ? idea.getTitle() : null;
            if (idea != null) {
                str = idea.getType();
            }
            clkReportAction.invoke(card, title, str);
        }
        AiCardHelper aiCardHelper = this.this$0;
        FrameLayout frameLayout = this.$aiCardContainer;
        Store<AbsState> store = this.$store;
        final AiCardHelper aiCardHelper2 = this.this$0;
        final Store<AbsState> store2 = this.$store;
        final AiCardViewPointView aiCardViewPointView = this.$this_apply;
        final Idea idea2 = idea;
        final Card card2 = card;
        aiCardHelper.isFastLogin(frameLayout, store, new Function0<Unit>() {
            public final void invoke() {
                Idea idea = idea2;
                String str = null;
                if (Intrinsics.areEqual((Object) idea != null ? idea.getType() : null, (Object) AiCardViewPointView.Companion.getDefaultType())) {
                    Intent intent = new Intent();
                    intent.putExtra("data", card2);
                    intent.putExtra("sourceFrom", AiEditComponentKt.SOURCE_FROM_UPSTREAM_NEWS);
                    intent.putExtra("card_id", aiCardHelper2.cardId);
                    intent.putExtra("trace_id", aiCardHelper2.traceId);
                    Store<AbsState> store = store2;
                    if (store != null) {
                        str = MvpCommonPageExtKt.getSourceFrom(store);
                    }
                    intent.putExtra("source", str);
                    intent.putExtra("from", aiCardHelper2.from);
                    intent.setClassName(aiCardViewPointView.getContext(), UgcConstant.EDITOR_PUBLISH_CLASS_NAME);
                    Context context = aiCardViewPointView.getContext();
                    if (context != null) {
                        ((Activity) context).startActivityForResult(intent, AiCardComponentKt.UGC_REQUEST_CODE_EDIT_TEXT_NEWS);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                Function2<Card, String, Unit> tagsItemAction = aiCardHelper2.getTagsItemAction();
                if (tagsItemAction != null) {
                    Card card = card2;
                    Idea idea2 = idea2;
                    if (idea2 != null) {
                        str = idea2.getTitle();
                    }
                    tagsItemAction.invoke(card, str);
                }
            }
        });
    }
}
