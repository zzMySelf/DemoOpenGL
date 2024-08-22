package com.baidu.searchbox.panorama.event;

public final class DirectionEvent {
    public final float angleX;
    public final float angleY;
    public final String viewId;

    public DirectionEvent(String viewId2, float angleX2, float angleY2) {
        this.viewId = viewId2;
        this.angleX = angleX2;
        this.angleY = angleY2;
    }
}
