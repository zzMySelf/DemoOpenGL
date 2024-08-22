package com.baidu.searchbox.reactnative.views.pulltorefresh.events;

import com.baidu.talos.core.data.Arguments;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.events.Event;
import com.baidu.talos.core.render.events.IUIEventEmitter;

public class RNSearchBoxPullReleaseEvent extends Event<RNSearchBoxPullReleaseEvent> {
    public static final String EVENT_NAME = "pullRelease";
    private int mEventOffset;

    public String getEventName() {
        return EVENT_NAME;
    }

    public void dispatch(IUIEventEmitter rctEventEmitter) {
        if (rctEventEmitter != null) {
            rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
        }
    }

    public void setEventStatus(int offset) {
        this.mEventOffset = offset;
    }

    private ParamMap serializeEventData() {
        ParamMap eventData = Arguments.createMap();
        eventData.putInteger("pullReleaseOffset", Integer.valueOf(this.mEventOffset));
        return eventData;
    }
}
