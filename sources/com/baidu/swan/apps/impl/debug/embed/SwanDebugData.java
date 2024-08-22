package com.baidu.swan.apps.impl.debug.embed;

public class SwanDebugData {
    public static final int SWAN_APP = 0;
    public static final int SWAN_GAME = 1;
    private String mAppId;
    private int mCategory;
    private String mName;

    public SwanDebugData(int category, String name, String appId) {
        this.mCategory = category;
        this.mName = name;
        this.mAppId = appId;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public String getName() {
        return this.mName;
    }

    public String getAppId() {
        return this.mAppId;
    }
}
