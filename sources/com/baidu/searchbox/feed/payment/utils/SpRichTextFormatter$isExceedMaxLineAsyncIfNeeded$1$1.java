package com.baidu.searchbox.feed.payment.utils;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.searchbox.feed.payment.utils.SpRichTextFormatter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/payment/utils/SpRichTextFormatter$isExceedMaxLineAsyncIfNeeded$1$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpRichTextFormatter.kt */
public final class SpRichTextFormatter$isExceedMaxLineAsyncIfNeeded$1$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ SpRichTextFormatter.IsExceedMaxLineCallback $callback;
    final /* synthetic */ CharSequence $content;
    final /* synthetic */ TextView $it;
    final /* synthetic */ int $maxLine;
    final /* synthetic */ int[] $outArr;
    final /* synthetic */ SpRichTextFormatter this$0;

    SpRichTextFormatter$isExceedMaxLineAsyncIfNeeded$1$1(TextView $it2, SpRichTextFormatter $receiver, CharSequence $content2, int $maxLine2, int[] $outArr2, SpRichTextFormatter.IsExceedMaxLineCallback $callback2) {
        this.$it = $it2;
        this.this$0 = $receiver;
        this.$content = $content2;
        this.$maxLine = $maxLine2;
        this.$outArr = $outArr2;
        this.$callback = $callback2;
    }

    public boolean onPreDraw() {
        this.$it.getViewTreeObserver().removeOnPreDrawListener(this);
        this.$callback.expansionListener(this.this$0.isExceedMaxLine(this.$it, this.$content, this.$maxLine, this.$outArr), this.$outArr);
        return true;
    }
}
