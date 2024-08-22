package com.baidu.searchbox.video.feedflow.detail.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "netErrorImage", "Landroid/widget/ImageView;", "netErrorText", "Landroid/widget/TextView;", "retryAction", "Lkotlin/Function0;", "", "getRetryAction", "()Lkotlin/jvm/functions/Function0;", "setRetryAction", "(Lkotlin/jvm/functions/Function0;)V", "retryButton", "onClick", "v", "Landroid/view/View;", "setFontAndPictureSize", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetErrorView.kt */
public final class NetErrorView extends FrameLayout implements View.OnClickListener {
    private final ImageView netErrorImage;
    private final TextView netErrorText;
    private Function0<Unit> retryAction;
    private final TextView retryButton;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NetErrorView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NetErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetErrorView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.video_flow_net_error_layout, this, true);
        View findViewById = findViewById(R.id.retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.retry_button)");
        TextView textView = (TextView) findViewById;
        this.retryButton = textView;
        View findViewById2 = findViewById(R.id.iv_net_error);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_net_error)");
        this.netErrorImage = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_net_error);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_net_error)");
        this.netErrorText = (TextView) findViewById3;
        setFontAndPictureSize();
        textView.setOnClickListener(this);
    }

    public final Function0<Unit> getRetryAction() {
        return this.retryAction;
    }

    public final void setRetryAction(Function0<Unit> function0) {
        this.retryAction = function0;
    }

    public final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.netErrorImage, R.dimen.video_flow_dimens_78dp, R.dimen.video_flow_dimens_78dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.netErrorText, com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X131, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.retryButton, com.baidu.searchbox.feed.styles.R.dimen.F_T_X042, 0, 0, 6, (Object) null);
    }

    public void onClick(View v) {
        Function0<Unit> function0;
        if (Intrinsics.areEqual((Object) v, (Object) this.retryButton) && (function0 = this.retryAction) != null) {
            function0.invoke();
        }
    }
}
