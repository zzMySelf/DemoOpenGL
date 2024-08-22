package com.baidu.nadcore.carousel.vertical;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/nadcore/carousel/vertical/NadCardVerticalLayoutManager$mOnFlingListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "onFling", "", "velocityX", "", "velocityY", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCardVerticalLayoutManager.kt */
public final class NadCardVerticalLayoutManager$mOnFlingListener$1 extends RecyclerView.OnFlingListener {
    final /* synthetic */ NadCardVerticalLayoutManager this$0;

    NadCardVerticalLayoutManager$mOnFlingListener$1(NadCardVerticalLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onFling(int velocityX, int velocityY) {
        int scroll;
        this.this$0.removeCardScrollMessage();
        if (this.this$0.itemWidth > 0) {
            int overScroll = this.this$0.totalOffset % this.this$0.itemWidth;
            if (this.this$0.totalOffset >= 0) {
                if (velocityX > 0) {
                    scroll = this.this$0.itemWidth - overScroll;
                } else {
                    scroll = -overScroll;
                }
            } else if (velocityX < 0) {
                scroll = (-this.this$0.itemWidth) - overScroll;
            } else {
                scroll = -overScroll;
            }
            this.this$0.brewAndStartAnimator(300, scroll, 2);
        }
        this.this$0.setScrollStateIdle();
        this.this$0.sendAutoScrollMessage(2);
        return true;
    }
}
