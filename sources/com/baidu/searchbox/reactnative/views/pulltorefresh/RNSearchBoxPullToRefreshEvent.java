package com.baidu.searchbox.reactnative.views.pulltorefresh;

import com.baidu.talos.core.data.Arguments;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.events.Event;
import com.baidu.talos.core.render.events.IUIEventEmitter;

public class RNSearchBoxPullToRefreshEvent extends Event<RNSearchBoxPullToRefreshEvent> {
    public static final String EVENT_NAME = "pullDownToRefresh";
    private boolean mEventStatus = false;

    public RNSearchBoxPullToRefreshEvent(long viewId) {
        super(viewId);
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public void dispatch(IUIEventEmitter rctEventEmitter) {
        if (rctEventEmitter != null) {
            rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
        }
    }

    public void setEventStatus(boolean status) {
        this.mEventStatus = status;
    }

    private ParamMap serializeEventData() {
        ParamMap eventData = Arguments.createMap();
        eventData.putBoolean("pullDownToRefreshStart", this.mEventStatus);
        return eventData;
    }
}
