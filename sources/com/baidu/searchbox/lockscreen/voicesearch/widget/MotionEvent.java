package com.baidu.searchbox.lockscreen.voicesearch.widget;

import android.util.SparseArray;

public class MotionEvent {
    public static final SparseArray<String> ActionMasked = new SparseArray<String>() {
        {
            put(0, "ACTION_DOWN");
            put(1, "ACTION_UP");
            put(2, "ACTION_MOVE");
            put(3, "ACTION_CANCEL");
            put(4, "ACTION_OUTSIDE");
            put(5, "ACTION_POINTER_DOWN");
            put(6, "ACTION_POINTER_UP");
            put(7, "ACTION_HOVER_MOVE");
            put(8, "ACTION_SCROLL");
            put(9, "ACTION_HOVER_ENTER");
            put(10, "ACTION_HOVER_EXIT");
            put(11, "ACTION_BUTTON_PRESS");
            put(12, "ACTION_BUTTON_RELEASE");
            put(255, "ACTION_MASK");
            put(261, "ACTION_POINTER_2_DOWN");
            put(262, "ACTION_POINTER_2_UP");
            put(517, "ACTION_POINTER_3_DOWN");
            put(518, "ACTION_POINTER_3_UP");
            put(65280, "ACTION_POINTER_ID_MASK");
            put(65280, "ACTION_POINTER_INDEX_MASK");
        }
    };
    public static final SparseArray<String> AxisGeneric = new SparseArray<String>() {
        {
            put(0, "AXIS_X");
            put(1, "AXIS_Y");
            put(2, "AXIS_PRESSURE");
            put(3, "AXIS_SIZE");
            put(4, "AXIS_TOUCH_MAJOR");
            put(5, "AXIS_TOUCH_MINOR");
            put(6, "AXIS_TOOL_MAJOR");
            put(7, "AXIS_TOOL_MINOR");
            put(8, "AXIS_ORIENTATION");
            put(9, "AXIS_VSCROLL");
            put(10, "AXIS_HSCROLL");
            put(11, "AXIS_Z");
            put(12, "AXIS_RX");
            put(13, "AXIS_RY");
            put(14, "AXIS_RZ");
            put(15, "AXIS_HAT_X");
            put(16, "AXIS_HAT_Y");
            put(17, "AXIS_LTRIGGER");
            put(18, "AXIS_RTRIGGER");
            put(19, "AXIS_THROTTLE");
            put(20, "AXIS_RUDDER");
            put(21, "AXIS_WHEEL");
            put(22, "AXIS_GAS");
            put(23, "AXIS_BRAKE");
            put(24, "AXIS_DISTANCE");
            put(25, "AXIS_TILT");
            put(32, "AXIS_GENERIC_1");
            put(33, "AXIS_GENERIC_2");
            put(34, "AXIS_GENERIC_3");
            put(35, "AXIS_GENERIC_4");
            put(36, "AXIS_GENERIC_5");
            put(37, "AXIS_GENERIC_6");
            put(38, "AXIS_GENERIC_7");
            put(39, "AXIS_GENERIC_8");
            put(40, "AXIS_GENERIC_9");
            put(41, "AXIS_GENERIC_10");
            put(42, "AXIS_GENERIC_11");
            put(43, "AXIS_GENERIC_12");
            put(44, "AXIS_GENERIC_13");
            put(45, "AXIS_GENERIC_14");
            put(46, "AXIS_GENERIC_15");
            put(47, "AXIS_GENERIC_16");
        }
    };
    public static final SparseArray<String> ToolType = new SparseArray<String>() {
        {
            put(0, "TOOL_TYPE_UNKNOWN");
            put(1, "TOOL_TYPE_FINGER");
            put(2, "TOOL_TYPE_STYLUS");
            put(3, "TOOL_TYPE_MOUSE");
            put(4, "TOOL_TYPE_ERASER");
        }
    };

    public static final String getactionMaskedStr(android.view.MotionEvent motionEvent) {
        return ActionMasked.get(motionEvent.getActionMasked());
    }
}
