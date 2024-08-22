package com.baidu.searchbox.feed.tts.ui;

import com.baidu.android.util.concurrent.UiThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/feed/tts/ui/TtsIconView2$createAnimListener$1", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "changeViewStatus", "", "currentAnimView", "Lorg/libpag/PAGImageView;", "onAnimationCancel", "p0", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TtsIconView2.kt */
public final class TtsIconView2$createAnimListener$1 implements PAGImageView.PAGImageViewListener {
    final /* synthetic */ TtsIconView2 this$0;

    TtsIconView2$createAnimListener$1(TtsIconView2 $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(PAGImageView p0) {
    }

    public void onAnimationEnd(PAGImageView p0) {
        changeViewStatus(p0);
    }

    public void onAnimationCancel(PAGImageView p0) {
        changeViewStatus(p0);
    }

    public void onAnimationRepeat(PAGImageView p0) {
    }

    public void onAnimationUpdate(PAGImageView p0) {
        if (this.this$0.getTtsAnimPlay().getVisibility() == 0 && this.this$0.getTtsIconNormal().getVisibility() == 0) {
            UiThreadUtils.runOnUiThread(new TtsIconView2$createAnimListener$1$$ExternalSyntheticLambda1(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationUpdate$lambda-0  reason: not valid java name */
    public static final void m19660onAnimationUpdate$lambda0(TtsIconView2 this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        if (this$02.getTtsAnimPlay().getVisibility() == 0 && this$02.getTtsIconNormal().getVisibility() == 0) {
            this$02.getTtsIconNormal().setVisibility(8);
        }
    }

    private final void changeViewStatus(PAGImageView currentAnimView) {
        UiThreadUtils.runOnUiThread(new TtsIconView2$createAnimListener$1$$ExternalSyntheticLambda0(this.this$0, currentAnimView));
    }

    /* access modifiers changed from: private */
    /* renamed from: changeViewStatus$lambda-1  reason: not valid java name */
    public static final void m19659changeViewStatus$lambda1(TtsIconView2 this$02, PAGImageView $currentAnimView) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        this$02.getTtsIconNormal().setVisibility(0);
        if ($currentAnimView != null) {
            $currentAnimView.setVisibility(8);
        }
    }
}
