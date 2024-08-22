package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.TextManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.base.TitleTextBaseView;
import com.baidu.mms.voicesearch.voice.utils.SkinManager;
import com.baidu.speechbundle.R;
import com.baidu.voicesearch.component.utils.StatisticConstants;
import com.baidu.voicesearch.component.utils.VoiceParamManager;
import com.baidu.voicesearch.component.vglog.VgLogManager;

public class VoiceImmersiveTitleTextView extends TitleTextBaseView {
    public VoiceImmersiveTitleTextView(Context context) {
        super(context);
    }

    public VoiceImmersiveTitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VoiceImmersiveTitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setTitleTextViewTextColor() {
        if (SkinManager.getInstance().isNightMode()) {
            setTextColor(getResources().getColor(R.color.voice_immersive_text_color_night));
        } else {
            setTextColor(getResources().getColor(R.color.voice_immersive_text_color));
        }
    }

    public void setTitleTextListening() {
        setText(TextManager.Companion.getInstance().getListeningText());
    }

    public void setTitleTextListeningColor() {
        setTitleTextViewTextColor();
    }

    public void setTitleTextContinue() {
        setText(TextManager.Companion.getInstance().getListeningText());
        VgLogManager.getInstance().addLog("0033", StatisticConstants.KEY_CONTINUE_LISTENING_SHOW, VoiceParamManager.getInstance().getImeCommonParams());
    }

    public void setTitleTextGuideWords() {
        setText(TextManager.Companion.getInstance().getNoHearClearText());
    }

    public void setTitleTextGuideWakeUpWords() {
        setText(TextManager.Companion.getInstance().getNoHearClearText());
    }

    public void setTitleTextGuideWordsColor() {
        setTitleTextViewTextColor();
    }

    public String getTitleTextGuideErrorWakeUpWordsContent() {
        return TextManager.Companion.getInstance().getNoHearClearText();
    }

    public void setTitleTextGuideErrorWords() {
        setText(TextManager.Companion.getInstance().getNoHearClearText());
    }

    public void setTitleTextGuideErrorWordsColor() {
        setTitleTextViewTextColor();
    }

    public void setTitleTextToWaiting() {
        setText(TextManager.Companion.getInstance().getWaitText());
        setTitleTextViewTextColor();
    }

    public void changeSkin() {
        setTitleTextViewTextColor();
    }
}
