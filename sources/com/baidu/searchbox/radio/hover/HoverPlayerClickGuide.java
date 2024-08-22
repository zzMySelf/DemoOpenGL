package com.baidu.searchbox.radio.hover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.bdmediacore.R;
import com.baidu.searchbox.bdmediacore.widgets.VoiceBarWaveView;
import com.baidu.searchbox.feed.tts.utils.FeedTTSPreferenceUtil;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/radio/hover/HoverPlayerClickGuide;", "", "voiceWaveView", "Lcom/baidu/searchbox/bdmediacore/widgets/VoiceBarWaveView;", "rootView", "Landroid/view/ViewGroup;", "lottieView", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "clickStaticView", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "(Lcom/baidu/searchbox/bdmediacore/widgets/VoiceBarWaveView;Landroid/view/ViewGroup;Lcom/baidu/searchbox/ui/BdBaseLottieView;Lcom/baidu/searchbox/ui/BdBaseImageView;)V", "bubbleManager", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "getClickStaticView", "()Lcom/baidu/searchbox/ui/BdBaseImageView;", "getLottieView", "()Lcom/baidu/searchbox/ui/BdBaseLottieView;", "getRootView", "()Landroid/view/ViewGroup;", "getVoiceWaveView", "()Lcom/baidu/searchbox/bdmediacore/widgets/VoiceBarWaveView;", "hide", "", "hideGuideBubble", "shouldShowBubble", "", "shouldShowLottie", "isOnTap", "show", "showClickLottieTips", "showGuideBubble", "switchFocusToWave", "switchWaveToFocus", "lib-bdmedia-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HoverPlayerClickGuide.kt */
public final class HoverPlayerClickGuide {
    /* access modifiers changed from: private */
    public BubbleTextManager bubbleManager;
    private final BdBaseImageView clickStaticView;
    private final BdBaseLottieView lottieView;
    private final ViewGroup rootView;
    private final VoiceBarWaveView voiceWaveView;

    public HoverPlayerClickGuide(VoiceBarWaveView voiceWaveView2, ViewGroup rootView2, BdBaseLottieView lottieView2, BdBaseImageView clickStaticView2) {
        Intrinsics.checkNotNullParameter(voiceWaveView2, "voiceWaveView");
        Intrinsics.checkNotNullParameter(rootView2, "rootView");
        Intrinsics.checkNotNullParameter(lottieView2, "lottieView");
        Intrinsics.checkNotNullParameter(clickStaticView2, "clickStaticView");
        this.voiceWaveView = voiceWaveView2;
        this.rootView = rootView2;
        this.lottieView = lottieView2;
        this.clickStaticView = clickStaticView2;
    }

    public final VoiceBarWaveView getVoiceWaveView() {
        return this.voiceWaveView;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final BdBaseLottieView getLottieView() {
        return this.lottieView;
    }

    public final BdBaseImageView getClickStaticView() {
        return this.clickStaticView;
    }

    public final void show(boolean isOnTap) {
        if (shouldShowLottie(isOnTap)) {
            showClickLottieTips();
        } else {
            switchWaveToFocus();
        }
    }

    public final void hide() {
        switchFocusToWave();
    }

    private final boolean shouldShowLottie(boolean isOnTap) {
        long lastLottieTimestamp = FeedTTSPreferenceUtil.getLong("tts_floating_button_lottie_tips_timestamp", 0);
        if (FeedTTSPreferenceUtil.getInt("tts_floating_button_lottie_tips_count", 0) >= 3 || !isOnTap || System.currentTimeMillis() - lastLottieTimestamp <= 86400000) {
            return false;
        }
        return true;
    }

    private final void showClickLottieTips() {
        this.lottieView.setAnimation("lottie/tts_floating_button_tips.json");
        this.voiceWaveView.setVisibility(8);
        this.lottieView.setVisibility(0);
        this.lottieView.setOnClickListener(new HoverPlayerClickGuide$$ExternalSyntheticLambda0(this));
        this.lottieView.playAnimation();
        FeedTTSPreferenceUtil.putLong("tts_floating_button_lottie_tips_timestamp", System.currentTimeMillis());
        FeedTTSPreferenceUtil.putInt("tts_floating_button_lottie_tips_count", FeedTTSPreferenceUtil.getInt("tts_floating_button_lottie_tips_count", 0) + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: showClickLottieTips$lambda-0  reason: not valid java name */
    public static final void m1686showClickLottieTips$lambda0(HoverPlayerClickGuide this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lottieView.cancelAnimation();
    }

    public final void showGuideBubble(boolean isOnTap) {
        VoiceBarWaveView anchorView = this.voiceWaveView;
        if (shouldShowBubble() && isOnTap) {
            BubbleTextManager build = ((BubbleTextBuilder) BubbleManager.newBuilder(BubbleTextBuilder.class)).setAnchorAndRootView((View) anchorView, this.rootView).setPaddingBetweenAnchor(5.0f).setAutoDismissInterval(3000).setText(anchorView.getResources().getString(R.string.floating_button_click_tips)).enableClkDismiss(true).enableBgClk(true).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new HoverPlayerClickGuide$showGuideBubble$1(this)).build();
            this.bubbleManager = build;
            if (build != null) {
                build.showBubble();
            }
        }
    }

    public final void hideGuideBubble() {
        BubbleTextManager bubbleTextManager = this.bubbleManager;
        if (bubbleTextManager != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    private final boolean shouldShowBubble() {
        return FeedTTSPreferenceUtil.getBoolean("show_tts_floating_button_bubble_tips", true);
    }

    private final void switchWaveToFocus() {
        ObjectAnimator waveHideAnimator = ObjectAnimator.ofFloat(this.voiceWaveView, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator focusShowAnimator = ObjectAnimator.ofFloat(this.clickStaticView, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet $this$switchWaveToFocus_u24lambda_u2d1 = new AnimatorSet();
        $this$switchWaveToFocus_u24lambda_u2d1.playTogether(new Animator[]{waveHideAnimator, focusShowAnimator});
        $this$switchWaveToFocus_u24lambda_u2d1.setDuration(120);
        $this$switchWaveToFocus_u24lambda_u2d1.addListener(new HoverPlayerClickGuide$switchWaveToFocus$1$1(this));
        $this$switchWaveToFocus_u24lambda_u2d1.start();
    }

    private final void switchFocusToWave() {
        ObjectAnimator waveShowAnimator = ObjectAnimator.ofFloat(this.voiceWaveView, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator focusHideAnimator = ObjectAnimator.ofFloat(this.clickStaticView, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet $this$switchFocusToWave_u24lambda_u2d2 = new AnimatorSet();
        $this$switchFocusToWave_u24lambda_u2d2.playTogether(new Animator[]{waveShowAnimator, focusHideAnimator});
        $this$switchFocusToWave_u24lambda_u2d2.setDuration(120);
        $this$switchFocusToWave_u24lambda_u2d2.addListener(new HoverPlayerClickGuide$switchFocusToWave$1$1(this));
        $this$switchFocusToWave_u24lambda_u2d2.start();
    }
}
