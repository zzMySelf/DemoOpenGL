package com.baidu.nadcore.dazzle.card.five;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/baidu/nadcore/dazzle/card/five/NadDazzleTextCardView$interruptTextPro$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDazzleTextCardView.kt */
public final class NadDazzleTextCardView$interruptTextPro$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ TextView $gradientView;
    final /* synthetic */ TextView $moreTextView;
    final /* synthetic */ TextView $textView;

    NadDazzleTextCardView$interruptTextPro$1(TextView $textView2, TextView $moreTextView2, TextView $gradientView2) {
        this.$textView = $textView2;
        this.$moreTextView = $moreTextView2;
        this.$gradientView = $gradientView2;
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        this.$textView.removeOnLayoutChangeListener(this);
        if (this.$textView.getLayout() == null || this.$textView.getLayout().getEllipsisCount(this.$textView.getLineCount() - 1) <= 0) {
            this.$moreTextView.setVisibility(8);
            this.$gradientView.setVisibility(8);
            return;
        }
        this.$moreTextView.setVisibility(0);
        this.$gradientView.setVisibility(0);
    }
}
