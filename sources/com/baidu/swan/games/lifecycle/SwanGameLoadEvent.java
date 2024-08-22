package com.baidu.swan.games.lifecycle;

import com.baidu.searchbox.v8engine.event.JSEvent;

public class SwanGameLoadEvent extends JSEvent {
    private static final String EVENT_TYPE_NAME = "appLoad";

    public SwanGameLoadEvent() {
        super(EVENT_TYPE_NAME);
    }
}
