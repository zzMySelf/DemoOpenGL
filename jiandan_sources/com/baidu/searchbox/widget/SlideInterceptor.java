package com.baidu.searchbox.widget;

import android.view.MotionEvent;

public interface SlideInterceptor {
    boolean isSlidable(MotionEvent motionEvent);
}
