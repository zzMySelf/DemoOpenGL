package com.baidu.searchbox.praise.emoji;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/praise/emoji/EmojiFloatView$showPanelAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiFloatView.kt */
public final class EmojiFloatView$showPanelAnimation$1 extends AnimatorListenerAdapter {
    final /* synthetic */ int $count;
    final /* synthetic */ EmojiFloatView this$0;

    EmojiFloatView$showPanelAnimation$1(EmojiFloatView $receiver, int $count2) {
        this.this$0 = $receiver;
        this.$count = $count2;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        if ((!this.this$0.emojiViewList.isEmpty()) && this.$count < 3) {
            for (AnimationEmojiView view2 : this.this$0.emojiViewList) {
                view2.startAnimation();
            }
        }
    }
}
