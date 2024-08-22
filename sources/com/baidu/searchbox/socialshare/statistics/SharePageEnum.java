package com.baidu.searchbox.socialshare.statistics;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;

public enum SharePageEnum {
    SWAN("swan"),
    BROWSER("browser"),
    LIGHT("light"),
    OTHER("other"),
    NA("NA");
    
    private static final boolean DEBUG = false;
    private static final HashMap<String, SharePageEnum> sharePageItemMap = null;
    private String mPageType;

    static {
        DEBUG = AppConfig.isDebug();
        sharePageItemMap = createSharePageMap();
    }

    private SharePageEnum(String pageType) {
        this.mPageType = pageType;
    }

    public String getPageType() {
        return this.mPageType;
    }

    private static HashMap<String, SharePageEnum> createSharePageMap() {
        HashMap<String, SharePageEnum> map = new HashMap<>();
        for (SharePageEnum f2 : values()) {
            map.put(f2.mPageType, f2);
        }
        return map;
    }

    public static SharePageEnum fromString(String type) {
        if (TextUtils.isEmpty(type)) {
            return OTHER;
        }
        HashMap<String, SharePageEnum> hashMap = sharePageItemMap;
        if (hashMap.containsKey(type)) {
            return hashMap.get(type);
        }
        if (!DEBUG) {
            return OTHER;
        }
        throw new IllegalArgumentException("mediaType invalid");
    }

    public static SharePageEnum getSharePageEnum(com.baidu.searchbox.boxshare.constants.SharePageEnum pageEnum) {
        if (pageEnum == null) {
            return OTHER;
        }
        return fromString(pageEnum.getPageType());
    }
}
