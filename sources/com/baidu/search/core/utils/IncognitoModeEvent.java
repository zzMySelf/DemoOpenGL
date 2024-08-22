package com.baidu.search.core.utils;

public class IncognitoModeEvent {
    private boolean mIsIncognito;

    public IncognitoModeEvent(boolean isIncognito) {
        this.mIsIncognito = isIncognito;
    }

    public boolean isIncognito() {
        return this.mIsIncognito;
    }
}
