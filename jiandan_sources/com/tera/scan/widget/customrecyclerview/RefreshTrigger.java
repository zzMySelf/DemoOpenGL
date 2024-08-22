package com.tera.scan.widget.customrecyclerview;

public interface RefreshTrigger {
    void onComplete();

    void onMove(boolean z, boolean z2, int i2);

    void onRefresh();

    void onRelease();

    void onReset();

    void onStart(boolean z, int i2, int i3);
}
