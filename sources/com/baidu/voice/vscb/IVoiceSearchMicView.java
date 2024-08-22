package com.baidu.voice.vscb;

import android.content.res.Configuration;

public interface IVoiceSearchMicView {
    void notifyBoxPressDown();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onOrientationChanged(Configuration configuration);

    void onVisibilityChange(int i2);

    void pressDown();

    void pressDownFrom(String str);

    void pressMoveToHideCancelView();

    void pressMoveToShowCancelView();

    void pressUpToCancel();

    void pressUpToQuery();

    void quickSlide();

    void setNeedAutoListeningAfterOnResume(boolean z);

    void shortPress();
}
