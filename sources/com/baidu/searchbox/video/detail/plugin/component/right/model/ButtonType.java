package com.baidu.searchbox.video.detail.plugin.component.right.model;

import com.baidu.searchbox.smartmenu.utils.ShareTypeKt;
import java.util.Locale;

public enum ButtonType {
    LIKE("like"),
    FEEDBACK("feedback"),
    WECHAT("wechat"),
    MOMENTS(ShareTypeKt.MOMENTS),
    REWARD("reward"),
    CUSTOM("custom");
    
    private String name;

    private ButtonType(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public static ButtonType getType(String name2) {
        for (ButtonType buttonType : values()) {
            if (buttonType.name.toUpperCase(Locale.getDefault()).equals(name2)) {
                return buttonType;
            }
        }
        return CUSTOM;
    }
}
