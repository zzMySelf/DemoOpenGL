package com.baidu.searchbox.video.feedflow.flow.bottom.aiComment;

import com.baidu.searchbox.video.feedflow.utils.CountDownClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/utils/CountDownClock;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomAICommentInteractManager.kt */
final class BottomAICommentInteractManager$countDownClock$2 extends Lambda implements Function0<CountDownClock> {
    final /* synthetic */ BottomAICommentInteractManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomAICommentInteractManager$countDownClock$2(BottomAICommentInteractManager bottomAICommentInteractManager) {
        super(0);
        this.this$0 = bottomAICommentInteractManager;
    }

    public final CountDownClock invoke() {
        CountDownClock $this$invoke_u24lambda_u2d0 = new CountDownClock(20);
        $this$invoke_u24lambda_u2d0.setCountDownCallback(new BottomAICommentInteractManager$countDownClock$2$1$1(this.this$0));
        return $this$invoke_u24lambda_u2d0;
    }
}
