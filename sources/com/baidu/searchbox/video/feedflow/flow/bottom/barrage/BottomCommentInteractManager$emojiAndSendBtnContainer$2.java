package com.baidu.searchbox.video.feedflow.flow.bottom.barrage;

import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomCommentInteractManager.kt */
final class BottomCommentInteractManager$emojiAndSendBtnContainer$2 extends Lambda implements Function0<RelativeLayout> {
    final /* synthetic */ BottomCommentInteractManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomCommentInteractManager$emojiAndSendBtnContainer$2(BottomCommentInteractManager bottomCommentInteractManager) {
        super(0);
        this.this$0 = bottomCommentInteractManager;
    }

    public final RelativeLayout invoke() {
        return this.this$0.createInteractRootContainer();
    }
}
