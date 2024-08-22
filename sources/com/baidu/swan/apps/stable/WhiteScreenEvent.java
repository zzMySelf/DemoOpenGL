package com.baidu.swan.apps.stable;

import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import java.util.Map;

public final class WhiteScreenEvent {
    private static final String EVENT_WHITE_SCREEN = "CollectTraceError";

    public static SwanAppCommonMessage createWhiteScreenMessage(WhiteScreenEvent event) {
        return new SwanAppCommonMessage(EVENT_WHITE_SCREEN, (Map<String, String>) null);
    }
}
