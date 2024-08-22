package com.baidu.searchbox.video.feedflow.flow.bottom.barrage;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomCommentInteractManager.kt */
final class BottomCommentInteractManager$sendButtonDelegate$1 extends Lambda implements Function0<TextView> {
    final /* synthetic */ BottomCommentInteractManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomCommentInteractManager$sendButtonDelegate$1(BottomCommentInteractManager bottomCommentInteractManager) {
        super(0);
        this.this$0 = bottomCommentInteractManager;
    }

    public final TextView invoke() {
        TextView $this$invoke_u24lambda_u2d1 = this.this$0.createSendButton();
        $this$invoke_u24lambda_u2d1.setOnClickListener(new BottomCommentInteractManager$sendButtonDelegate$1$$ExternalSyntheticLambda0(this.this$0));
        return $this$invoke_u24lambda_u2d1;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
    public static final void m6112invoke$lambda1$lambda0(BottomCommentInteractManager this$02, View it) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.sendBarrage();
    }
}
