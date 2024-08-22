package com.baidu.searchbox.qrcode.config;

public enum UIType {
    UI_QRCODE(0),
    UI_BARCODE(1),
    UI_RESULT(2),
    UI_IMAGEEDIT(3),
    UI_TAKE_PICTURE(4),
    UI_CROP_PICTURE(5),
    UI_CATEGORY_QRCODE(6);
    
    private int value;

    private UIType(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public static UIType convert(int value2) {
        UIType bt = UI_QRCODE;
        for (UIType t : values()) {
            if (t.value == value2) {
                return t;
            }
        }
        return bt;
    }
}
