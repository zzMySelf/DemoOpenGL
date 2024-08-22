package com.baidu.searchbox.feed.payment.utils;

import android.view.View;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\t\u001a\u0006\u0010\u0012\u001a\u00020\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"BUBBLE_DEFAULT_CLOSE_TIME", "", "COMMENT_BUBBLE_SHOW_COUNTS", "", "COMMENT_BUBBLE_SHOW_TIME", "COMMENT_TIPS_MAX_SHOW_TIMES", "makeBubble", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "anchorView", "Landroid/view/View;", "showText", "interval", "needShowBubble", "", "purchasedTime", "", "showBubble", "bubbleText", "updateBubbleSpInfo", "", "lib-feed-spcolumn_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleUtils.kt */
public final class BubbleUtilsKt {
    private static final int BUBBLE_DEFAULT_CLOSE_TIME = 5000;
    public static final String COMMENT_BUBBLE_SHOW_COUNTS = "feed_spcolumn_comment_bubble_count";
    public static final String COMMENT_BUBBLE_SHOW_TIME = "feed_spcolumn_comment_bubble_last_show_time";
    public static final int COMMENT_TIPS_MAX_SHOW_TIMES = 5;

    public static final boolean needShowBubble(long purchasedTime) {
        int showCounts = FeedPreferenceUtils.getInt(COMMENT_BUBBLE_SHOW_COUNTS, 0);
        long lastShowTime = FeedPreferenceUtils.getLong(COMMENT_BUBBLE_SHOW_TIME, 0);
        if (purchasedTime == 0 || !FeedUtil.isExceedOneDay(1000 * purchasedTime) || showCounts >= 5 || !FeedUtil.isExceedOneDay(lastShowTime)) {
            return false;
        }
        return true;
    }

    public static final BubbleTextManager showBubble(String bubbleText, View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Ref.ObjectRef bubbleManager = new Ref.ObjectRef();
        if (bubbleText != null) {
            String $this$isNotNullAndBlank_u24default$iv = bubbleText;
            if (!StringsKt.isBlank($this$isNotNullAndBlank_u24default$iv)) {
                BubbleTextManager $this$showBubble_u24lambda_u2d1_u24lambda_u2d0 = makeBubble$default(anchorView, $this$isNotNullAndBlank_u24default$iv, 0, 4, (Object) null);
                $this$showBubble_u24lambda_u2d1_u24lambda_u2d0.showBubble();
                updateBubbleSpInfo();
                bubbleManager.element = $this$showBubble_u24lambda_u2d1_u24lambda_u2d0;
            }
        }
        return (BubbleTextManager) bubbleManager.element;
    }

    public static final void updateBubbleSpInfo() {
        FeedPreferenceUtils.putInt(COMMENT_BUBBLE_SHOW_COUNTS, FeedPreferenceUtils.getInt(COMMENT_BUBBLE_SHOW_COUNTS, 0) + 1);
        FeedPreferenceUtils.putLong(COMMENT_BUBBLE_SHOW_TIME, System.currentTimeMillis());
    }

    public static /* synthetic */ BubbleTextManager makeBubble$default(View view2, String str, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 5000;
        }
        return makeBubble(view2, str, i2);
    }

    public static final BubbleTextManager makeBubble(View anchorView, String showText, int interval) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(showText, "showText");
        BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setAnchorView(anchorView).setAutoDismissInterval(interval).setText(showText).enableClkDismiss(true).enableBgClk(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder(BubbleTextBui…rue)\n            .build()");
        return build;
    }
}
