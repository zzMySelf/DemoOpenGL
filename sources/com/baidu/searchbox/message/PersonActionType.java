package com.baidu.searchbox.message;

public enum PersonActionType {
    UNKNOWN(0),
    SEND_MESSAGE(1),
    SHOW_TOAST(2);
    
    private final int value;

    private PersonActionType(int value2) {
        this.value = value2;
    }

    public int getValue() {
        return this.value;
    }
}
