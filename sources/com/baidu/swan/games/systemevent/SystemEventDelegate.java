package com.baidu.swan.games.systemevent;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.games.audio.player.AudioPlayerManager;

public class SystemEventDelegate {
    public static void onAudioInterruptionBeginEvent(AiBaseV8Engine v8Engine) {
        if (v8Engine != null && v8Engine.getGlobalObject().hasEventListener(SystemEventName.AUDIO_INTERRUPTION_BEGIN) && AudioPlayerManager.getInstance().isAudioPlay()) {
            v8Engine.dispatchEvent(new JSEvent(SystemEventName.AUDIO_INTERRUPTION_BEGIN));
        }
    }

    public static void onAudioInterruptionEndEvent(AiBaseV8Engine v8Engine) {
        if (v8Engine != null && v8Engine.getGlobalObject().hasEventListener(SystemEventName.AUDIO_INTERRUPTION_END)) {
            v8Engine.dispatchEvent(new JSEvent(SystemEventName.AUDIO_INTERRUPTION_END));
        }
    }

    public static void onErrorEvent(AiBaseV8Engine v8Engine, JSEvent jsEvent) {
        if (v8Engine != null && jsEvent != null && v8Engine.getGlobalObject().hasEventListener("error")) {
            v8Engine.dispatchEvent(jsEvent);
        }
    }
}
