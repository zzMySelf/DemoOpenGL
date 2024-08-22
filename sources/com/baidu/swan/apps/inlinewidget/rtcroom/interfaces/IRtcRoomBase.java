package com.baidu.swan.apps.inlinewidget.rtcroom.interfaces;

import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.IInlineWidget;
import com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcStatus;

public interface IRtcRoomBase extends IInlineWidget {
    public static final int INVALID_USER_ID = -1;

    RtcStatus getAuthorizeType();

    boolean isReleased();

    void onRelease();

    void startRender(long j2, Surface surface, boolean z);

    void stopRender(long j2, Surface surface, boolean z);
}
