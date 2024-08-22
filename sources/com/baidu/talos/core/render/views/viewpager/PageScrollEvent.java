package com.baidu.talos.core.render.views.viewpager;

import com.baidu.talos.core.data.Arguments;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.events.Event;
import com.baidu.talos.core.render.events.IUIEventEmitter;

class PageScrollEvent extends Event<PageScrollEvent> {
    public static final String EVENT_NAME = "topPageScroll";
    private final float mOffset;
    private final int mPosition;

    protected PageScrollEvent(long viewTag, int position, float offset) {
        super(viewTag);
        this.mPosition = position;
        this.mOffset = (Float.isInfinite(offset) || Float.isNaN(offset)) ? 0.0f : offset;
    }

    public String getEventName() {
        return "topPageScroll";
    }

    public void dispatch(IUIEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private ParamMap serializeEventData() {
        ParamMap eventData = Arguments.createMap();
        eventData.putInteger("position", Integer.valueOf(this.mPosition));
        eventData.putDouble("offset", Double.valueOf((double) this.mOffset));
        return eventData;
    }
}
