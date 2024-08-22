package com.baidu.platform.comapi.walknavi.fsm;

public abstract class RGState {
    public static final String CLASS_PREFIX;
    public static final String METHOD_NAME_ENTER = "enter";
    public static final String METHOD_NAME_EXCUTE = "excute";
    public static final String METHOD_NAME_EXIT = "exit";
    public static final String PACKAGE_NAME;

    static {
        Class<RGState> cls = RGState.class;
        PACKAGE_NAME = cls.getPackage().getName();
        CLASS_PREFIX = cls.getSimpleName();
    }

    public void enter() {
    }

    public void excute() {
        onActionUI();
        onActionNaviEngine();
        onActionLayers();
        onActionMapStatus();
    }

    public void exit() {
    }

    /* access modifiers changed from: protected */
    public abstract void onActionLayers();

    /* access modifiers changed from: protected */
    public abstract void onActionMapStatus();

    /* access modifiers changed from: protected */
    public abstract void onActionNaviEngine();

    /* access modifiers changed from: protected */
    public abstract void onActionUI();
}
