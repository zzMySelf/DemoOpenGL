package com.baidu.swan.card.res.widget.dialog;

public class AlertDialogEvent {
    public static final String ACTION_HIDE = "hide";
    public static final String ACTION_SHOW = "show";
    private String action;

    public AlertDialogEvent(String action2) {
        this.action = action2;
    }

    public String getAction() {
        return this.action;
    }
}
