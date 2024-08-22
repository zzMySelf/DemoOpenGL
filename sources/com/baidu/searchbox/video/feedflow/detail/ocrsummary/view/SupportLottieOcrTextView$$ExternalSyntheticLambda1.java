package com.baidu.searchbox.video.feedflow.detail.ocrsummary.view;

import android.text.SpannableStringBuilder;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SupportLottieOcrTextView$$ExternalSyntheticLambda1 implements LottieListener {
    public final /* synthetic */ SupportLottieOcrTextView f$0;
    public final /* synthetic */ SpannableStringBuilder f$1;

    public /* synthetic */ SupportLottieOcrTextView$$ExternalSyntheticLambda1(SupportLottieOcrTextView supportLottieOcrTextView, SpannableStringBuilder spannableStringBuilder) {
        this.f$0 = supportLottieOcrTextView;
        this.f$1 = spannableStringBuilder;
    }

    public final void onResult(Object obj) {
        SupportLottieOcrTextView.m11876setLottie$lambda3(this.f$0, this.f$1, (LottieComposition) obj);
    }
}
