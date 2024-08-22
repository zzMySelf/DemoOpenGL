package com.baidu.searchbox.reactnative.views.nativeanimation;

import com.baidu.talos.core.data.Arguments;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.events.Event;
import com.baidu.talos.core.render.events.IUIEventEmitter;

public class RNSearchBoxAnimationChangeEvent extends Event<RNSearchBoxAnimationChangeEvent> {
    public static final String EVENT_NAME = "topAnimationChange";
    private String mAnimId;
    private String mType;

    public RNSearchBoxAnimationChangeEvent(long viewTag, String animId, String type) {
        super(viewTag);
        this.mAnimId = animId;
        this.mType = type;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public void dispatch(IUIEventEmitter rctEventEmitter) {
        ParamMap event = Arguments.createMap();
        event.putString("animId", this.mAnimId);
        event.putString("type", this.mType);
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), event);
    }
}
