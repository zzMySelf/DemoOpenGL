package com.baidu.searchbox.feed.dynamicdetail.silex.processors;

import com.baidu.searchbox.feed.dynamicdetail.DynamicPublishDisplay;
import com.baidu.searchbox.feed.dynamicdetail.utils.DynamicUtilsKt;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nid", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicPublishProcessor.kt */
final class DynamicPublishProcessor$onCreateView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ DynamicPublishProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamicPublishProcessor$onCreateView$1(DynamicPublishProcessor dynamicPublishProcessor) {
        super(1);
        this.this$0 = dynamicPublishProcessor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String nid) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        DynamicPublishDisplay $this$invoke_u24lambda_u2d0 = new DynamicPublishDisplay(DynamicUtilsKt.getListAssignId(this.this$0.getSourceFrom(), nid, this.this$0.getStrategyType()));
        $this$invoke_u24lambda_u2d0.setOriginalNid(nid);
        String access$getAuthorId = this.this$0.getAuthorId();
        String fromValueBySource = DynamicUtilsKt.getFromValueBySource(this.this$0.getSourceFrom());
        String access$getExtRequest = this.this$0.getExtRequest();
        final DynamicPublishProcessor dynamicPublishProcessor = this.this$0;
        $this$invoke_u24lambda_u2d0.fetchDisplayData(access$getAuthorId, fromValueBySource, access$getExtRequest, new Function1<List<? extends FeedBaseModel>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((List<? extends FeedBaseModel>) (List) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends FeedBaseModel> it) {
                dynamicPublishProcessor.doShowPublishDisplay(it);
            }
        });
    }
}
