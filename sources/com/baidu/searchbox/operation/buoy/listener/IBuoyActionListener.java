package com.baidu.searchbox.operation.buoy.listener;

public interface IBuoyActionListener {
    public static final String BUOY_ACTION_CLOSE = "close";
    public static final String BUOY_ACTION_JUMP_CLOSE = "jump_close";
    public static final String BUOY_ACTION_MOVEIN = "moveIn";
    public static final String BUOY_ACTION_MOVEOUT = "moveOut";

    void buoyActionChange(String str);
}
