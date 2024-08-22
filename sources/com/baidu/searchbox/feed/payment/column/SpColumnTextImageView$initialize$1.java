package com.baidu.searchbox.feed.payment.column;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnListViewModel;
import com.baidu.searchbox.feed.payment.model.PayStats1076;
import com.baidu.searchbox.feed.payment.utils.SerialClickListener;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/feed/payment/utils/SerialClickListener;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnTextImageView.kt */
final class SpColumnTextImageView$initialize$1 extends Lambda implements Function2<SerialClickListener, View, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SpColumnTextImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnTextImageView$initialize$1(SpColumnTextImageView spColumnTextImageView, Context context) {
        super(2);
        this.this$0 = spColumnTextImageView;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((SerialClickListener) p1, (View) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(SerialClickListener $this$$receiver, View it) {
        PayStats1076 it2;
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        FeedTemplateImpl feedTemplateImpl = this.this$0.mFeedTemplateImplBase;
        FeedBaseModel model = feedTemplateImpl != null ? feedTemplateImpl.getFeedModel() : null;
        if (model != null) {
            SpColumnListViewModel access$getListViewModel$p = this.this$0.listViewModel;
            Context context = this.$context;
            final SpColumnTextImageView spColumnTextImageView = this.this$0;
            SpColumnTextImageViewKt.doTextImageItemClick(model, access$getListViewModel$p, context, "item-click", (Function1<? super String, Unit>) null, new Function1<FeedBaseModel, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((FeedBaseModel) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(FeedBaseModel it) {
                    Context context = spColumnTextImageView.getContext();
                    TextView access$getMTitle$p = spColumnTextImageView.mTitle;
                    TextView textView = null;
                    if (access$getMTitle$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                        access$getMTitle$p = null;
                    }
                    SpColumnTextImageViewKt.processText(context, access$getMTitle$p, it, false);
                    TextView access$getMSeqNumber$p = spColumnTextImageView.mSeqNumber;
                    if (access$getMSeqNumber$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeqNumber");
                        access$getMSeqNumber$p = null;
                    }
                    TextView access$getMTitle$p2 = spColumnTextImageView.mTitle;
                    if (access$getMTitle$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                    } else {
                        textView = access$getMTitle$p2;
                    }
                    access$getMSeqNumber$p.setTextColor(textView.getTextColors());
                }
            });
            SpColumnListViewModel access$getListViewModel$p2 = this.this$0.listViewModel;
            if (!(access$getListViewModel$p2 == null || (it2 = access$getListViewModel$p2.getPayStats()) == null)) {
                if (Intrinsics.areEqual((Object) model.state, (Object) "3")) {
                    it2.recordClickColumnItemFree(model.id);
                } else {
                    it2.recordClickColumnItemNormal(model.id);
                }
            }
            $this$$receiver.postDelayedMarkDone(1000);
        }
    }
}
