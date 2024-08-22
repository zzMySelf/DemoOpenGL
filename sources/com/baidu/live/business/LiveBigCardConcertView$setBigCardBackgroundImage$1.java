package com.baidu.live.business;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.baidu.live.business.util.CommonUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/live/business/LiveBigCardConcertView$setBigCardBackgroundImage$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBigCardConcertView.kt */
public final class LiveBigCardConcertView$setBigCardBackgroundImage$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ String $backgroundImage;
    final /* synthetic */ LiveBigCardConcertView this$0;

    LiveBigCardConcertView$setBigCardBackgroundImage$1(LiveBigCardConcertView $receiver, String $backgroundImage2) {
        this.this$0 = $receiver;
        this.$backgroundImage = $backgroundImage2;
    }

    public void onGlobalLayout() {
        ViewTreeObserver viewTreeObserver;
        int screenWidth = CommonUtil.getScreenWidth(this.this$0.getContext());
        LinearLayout access$getBigCardContentLayout$p = this.this$0.bigCardContentLayout;
        int contentHeight = access$getBigCardContentLayout$p != null ? access$getBigCardContentLayout$p.getHeight() : 0;
        LiveBigCardPlayerView access$getBigCardPlayerView$p = this.this$0.bigCardPlayerView;
        int playerHeight = access$getBigCardPlayerView$p != null ? access$getBigCardPlayerView$p.getHeight() : 0;
        LinearLayout access$getBigCardContentLayout$p2 = this.this$0.bigCardContentLayout;
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = access$getBigCardContentLayout$p2 != null ? access$getBigCardContentLayout$p2.getLayoutParams() : null;
        if (layoutParams2 != null) {
            int marginTop = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            int imageBackgroundHeight = contentHeight + marginTop;
            int maskHeight = contentHeight - (playerHeight / 2);
            SimpleDraweeView access$getBigCardLayoutBgIv$p = this.this$0.bigCardLayoutBgIv;
            ViewGroup.LayoutParams layoutParams3 = access$getBigCardLayoutBgIv$p != null ? access$getBigCardLayoutBgIv$p.getLayoutParams() : null;
            if (layoutParams3 != null) {
                layoutParams3.height = imageBackgroundHeight;
            }
            SimpleDraweeView access$getBigCardLayoutBgIv$p2 = this.this$0.bigCardLayoutBgIv;
            if (access$getBigCardLayoutBgIv$p2 != null) {
                access$getBigCardLayoutBgIv$p2.requestLayout();
            }
            LiveBigCardConcertView liveBigCardConcertView = this.this$0;
            liveBigCardConcertView.showFrescoImg(liveBigCardConcertView.bigCardLayoutBgIv, this.$backgroundImage, screenWidth, imageBackgroundHeight);
            View access$getBigCardLayoutBgMask$p = this.this$0.bigCardLayoutBgMask;
            ViewGroup.LayoutParams layoutParams4 = access$getBigCardLayoutBgMask$p != null ? access$getBigCardLayoutBgMask$p.getLayoutParams() : null;
            if (layoutParams4 != null) {
                layoutParams4.height = maskHeight;
            }
            View access$getBigCardLayoutBgMask$p2 = this.this$0.bigCardLayoutBgMask;
            if (access$getBigCardLayoutBgMask$p2 != null) {
                layoutParams = access$getBigCardLayoutBgMask$p2.getLayoutParams();
            }
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (playerHeight / 2) + marginTop;
                if (Intrinsics.areEqual((Object) "video_bar", (Object) this.this$0.scene)) {
                    View access$getBigCardLayoutBgMask$p3 = this.this$0.bigCardLayoutBgMask;
                    if (access$getBigCardLayoutBgMask$p3 != null) {
                        access$getBigCardLayoutBgMask$p3.setVisibility(0);
                    }
                } else {
                    View access$getBigCardLayoutBgMask$p4 = this.this$0.bigCardLayoutBgMask;
                    if (access$getBigCardLayoutBgMask$p4 != null) {
                        access$getBigCardLayoutBgMask$p4.setVisibility(8);
                    }
                }
                LinearLayout access$getBigCardContentLayout$p3 = this.this$0.bigCardContentLayout;
                if (access$getBigCardContentLayout$p3 != null && (viewTreeObserver = access$getBigCardContentLayout$p3.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
