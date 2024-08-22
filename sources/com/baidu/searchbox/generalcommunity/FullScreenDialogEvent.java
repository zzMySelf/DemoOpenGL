package com.baidu.searchbox.generalcommunity;

public class FullScreenDialogEvent {
    public static final int DIALOG_CLOSE = 1;
    public static final int DIALOG_SHOW = 0;
    public int status = 0;

    public FullScreenDialogEvent(int status2) {
        this.status = status2;
    }
}
