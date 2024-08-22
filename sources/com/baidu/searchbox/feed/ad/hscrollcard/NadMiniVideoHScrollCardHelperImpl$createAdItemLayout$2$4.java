package com.baidu.searchbox.feed.ad.hscrollcard;

import android.text.TextUtils;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.layout.GenTextView;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/layout/GenTextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMiniVideoHScrollCardHelperImpl.kt */
final class NadMiniVideoHScrollCardHelperImpl$createAdItemLayout$2$4 extends Lambda implements Function1<GenTextView, Unit> {
    final /* synthetic */ NadMiniVideoHScrollCardHelperImpl$createAdItemLayout$1 $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadMiniVideoHScrollCardHelperImpl$createAdItemLayout$2$4(NadMiniVideoHScrollCardHelperImpl$createAdItemLayout$1 nadMiniVideoHScrollCardHelperImpl$createAdItemLayout$1) {
        super(1);
        this.$this_apply = nadMiniVideoHScrollCardHelperImpl$createAdItemLayout$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GenTextView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GenTextView $this$textView) {
        Intrinsics.checkNotNullParameter($this$textView, "$this$textView");
        $this$textView.setId(R.id.feed_tpl_mini_video_title);
        $this$textView.setLineHeightWithoutLineSpace(true);
        $this$textView.setEllipsize(TextUtils.TruncateAt.END);
        $this$textView.setIncludeFontPadding(false);
        $this$textView.setMaxLines(2);
        $this$textView.setTextColor(CtxResEasyUtils.asResColor(com.baidu.searchbox.feed.styles.R.color.FC37));
        $this$textView.setTextSizePx(CtxResEasyUtils.asResDimen(com.baidu.searchbox.feed.styles.R.dimen.F_T_X004));
        this.$this_apply.lparams($this$textView, AnonymousClass1.INSTANCE);
    }
}
