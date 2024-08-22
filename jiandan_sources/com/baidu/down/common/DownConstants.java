package com.baidu.down.common;

import androidx.recyclerview.widget.ItemTouchHelper;

public interface DownConstants {
    public static final long[] qw = {0, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS, 8000, 64000, 512000};
}
