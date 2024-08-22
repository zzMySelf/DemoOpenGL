package com.baidu.searchbox.video.detail.plugin.component.title;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.model.PaymentSpecialColumnModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/title/VideoPaymentTitleContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "paymentTitle", "Landroid/widget/TextView;", "prefixBuyLabelSpan", "Lcom/baidu/searchbox/video/detail/plugin/component/title/VideoPaymentTitlePrefixSpan;", "getTitlePrefixSpan", "prefix", "", "updateData", "", "model", "Lcom/baidu/searchbox/video/detail/model/PaymentSpecialColumnModel;", "updateUI", "Companion", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPaymentTitleContainer.kt */
public final class VideoPaymentTitleContainer extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_TITLE_PREFIX = "prefix";
    public static final int VALUE_TITLE_PREFIX_LENGTH = 6;
    private final TextView paymentTitle;
    private VideoPaymentTitlePrefixSpan prefixBuyLabelSpan;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/detail/plugin/component/title/VideoPaymentTitleContainer$Companion;", "", "()V", "KEY_TITLE_PREFIX", "", "VALUE_TITLE_PREFIX_LENGTH", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoPaymentTitleContainer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public VideoPaymentTitleContainer(Context context) {
        super(context);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.video_payment_title_container, this);
        View findViewById = findViewById(R.id.video_payment_title_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_payment_title_view)");
        this.paymentTitle = (TextView) findViewById;
        updateUI();
    }

    public final void updateData(PaymentSpecialColumnModel model) {
        if (model == null) {
            setVisibility(8);
        } else if (model.hasAllBuy()) {
            String string = getContext().getResources().getString(R.string.video_payment_buy_label);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr….video_payment_buy_label)");
            this.prefixBuyLabelSpan = getTitlePrefixSpan(string);
            SpannableString spannableString = new SpannableString("prefix" + model.mName);
            spannableString.setSpan(this.prefixBuyLabelSpan, 0, 6, 17);
            this.paymentTitle.setText(spannableString);
        } else {
            this.paymentTitle.setText(model.mName);
        }
    }

    public final void updateUI() {
        this.paymentTitle.setTextColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        VideoPaymentTitlePrefixSpan videoPaymentTitlePrefixSpan = this.prefixBuyLabelSpan;
        if (videoPaymentTitlePrefixSpan != null) {
            videoPaymentTitlePrefixSpan.updateNightMode();
        }
    }

    private final VideoPaymentTitlePrefixSpan getTitlePrefixSpan(String prefix) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new VideoPaymentTitlePrefixSpan(context, prefix, 10.0f, 17.0f);
    }
}
