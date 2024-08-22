package com.baidu.share.core.bean;

import android.text.TextUtils;
import com.baidu.share.widget.ShareRuntime;
import java.util.HashMap;

public enum Theme {
    LIGHT("light"),
    DARK("dark"),
    NIGHT("night"),
    SINGLE_LINE("single_line");
    
    private static final boolean DEBUG = false;
    private static final HashMap<String, Theme> themeItemMap = null;
    private String type;

    static {
        DEBUG = ShareRuntime.isDebug();
        themeItemMap = createThemeItemMap();
    }

    private Theme(String type2) {
        this.type = type2;
    }

    private static HashMap<String, Theme> createThemeItemMap() {
        HashMap<String, Theme> map = new HashMap<>();
        for (Theme f2 : values()) {
            map.put(f2.type, f2);
        }
        return map;
    }

    public static Theme fromString(String type2) {
        if (TextUtils.isEmpty(type2)) {
            return LIGHT;
        }
        HashMap<String, Theme> hashMap = themeItemMap;
        if (hashMap.containsKey(type2)) {
            return hashMap.get(type2);
        }
        if (!DEBUG) {
            return LIGHT;
        }
        throw new IllegalArgumentException("theme invalid");
    }

    public String getType() {
        return this.type;
    }
}
