package com.baidu.searchbox.comment.input.aiimage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.guide.CommentBubbleHelper;
import com.baidu.searchbox.comment.guide.IMutualExclusionPriorityGuide;
import com.baidu.searchbox.comment.sp.CommentSpWrapper;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/comment/input/aiimage/AiGeneratePicModule$showGuideBubble$1", "Lcom/baidu/searchbox/comment/guide/IMutualExclusionPriorityGuide;", "getPriority", "", "onShow", "", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiGeneratePicModule.kt */
public final class AiGeneratePicModule$showGuideBubble$1 implements IMutualExclusionPriorityGuide {
    final /* synthetic */ AiGeneratePicModule this$0;

    AiGeneratePicModule$showGuideBubble$1(AiGeneratePicModule $receiver) {
        this.this$0 = $receiver;
    }

    public int getPriority() {
        return -1;
    }

    public boolean onShow() {
        this.this$0.hasShowGuide = true;
        CommentSpWrapper.setCommentAiGtPicGuideShow(true);
        View it = this.this$0.getAnchorView();
        if (it != null) {
            return CommentBubbleHelper.showTextBubbleTip$default(CommentRuntime.getAppContext().getString(R.string.comment_ai_panel_bubble_guide_text), it, (ViewGroup) null, (BubblePosition) null, 0, false, (Integer) null, (Integer) null, (Float) null, 0.0f, (BubbleManager.OnBubbleEventListener) null, 2040, (Object) null);
        }
        return false;
    }
}
