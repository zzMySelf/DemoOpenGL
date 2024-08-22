package com.baidu.swan.apps.impl.ai.tts.ipc;

import android.os.Bundle;
import com.baidu.swan.apps.impl.ai.tts.action.SwanBgMusicHoverController;
import com.baidu.swan.apps.impl.ai.tts.utils.SwanHoverUtils;
import com.baidu.swan.apps.process.delegate.delegation.SwanAppMessengerDelegation;

public class SwanMusicHoverClientDelegation extends SwanAppMessengerDelegation {
    public void execCall(Bundle params) {
        if (!params.getBoolean(SwanMusicHoverServerDelegation.KEY_HOVER_STATUS_CHANGED)) {
            return;
        }
        if (SwanHoverUtils.isDisplay(SwanBgMusicHoverController.getInstance().isShowHoverInSelfProcess())) {
            SwanBgMusicHoverController.getInstance().showHover();
        } else {
            SwanBgMusicHoverController.getInstance().hideHover();
        }
    }
}
