package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.base.CanceVoiceBaseView;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.speechbundle.R;

public class VoiceImmersiveCancelVoiceView extends CanceVoiceBaseView {
    private LottieAnimationView cancelLottie;

    public VoiceImmersiveCancelVoiceView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int getRootId() {
        return R.layout.voice_immersive_half_screen_cancel;
    }

    public void init(Context context) {
        super.init(context);
        this.cancelLottie = (LottieAnimationView) findViewById(R.id.half_screen_cancel_lottie);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0 || this.cancelLottie == null) {
            this.cancelLottie.cancelAnimation();
            return;
        }
        if (SkinManager.getInstance().isNightMode()) {
            this.cancelLottie.setAnimation("immersive_cancel_night.json");
        } else {
            this.cancelLottie.setAnimation("immersive_cancel.json");
        }
        this.cancelLottie.loop(false);
        this.cancelLottie.playAnimation();
    }

    public void changeSkin() {
        if (this.mTextView != null && getContext() != null) {
            if (SkinManager.getInstance().isNightMode()) {
                this.mTextView.setTextColor(getContext().getResources().getColor(R.color.voice_immersive_text_tips_color_night));
            } else {
                this.mTextView.setTextColor(getContext().getResources().getColor(R.color.voice_immersive_text_tips_color));
            }
            this.mTextView.setText(getContext().getResources().getString(R.string.mms_voice_upscreen_voice_cancel_input_hint));
        }
    }
}
