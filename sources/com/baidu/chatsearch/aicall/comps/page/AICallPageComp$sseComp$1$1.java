package com.baidu.chatsearch.aicall.comps.page;

import com.baidu.chatsearch.aicall.comps.sse.models.SSETtsResultModel;
import com.baidu.chatsearch.aicall.event.ErrorPage;
import com.baidu.chatsearch.aicall.event.StartAnswer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/chatsearch/aicall/comps/sse/models/SSETtsResultModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallPageComp.kt */
final class AICallPageComp$sseComp$1$1 extends Lambda implements Function1<SSETtsResultModel, Unit> {
    final /* synthetic */ AICallPageComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AICallPageComp$sseComp$1$1(AICallPageComp aICallPageComp) {
        super(1);
        this.this$0 = aICallPageComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SSETtsResultModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SSETtsResultModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getErrorType().length() > 0) {
            this.this$0.getFsm().handleMessage(ErrorPage.Companion.create(it.getErrorType(), ""));
        } else {
            this.this$0.getFsm().handleMessage(StartAnswer.Companion.create(it.toJSONObject()));
        }
    }
}
