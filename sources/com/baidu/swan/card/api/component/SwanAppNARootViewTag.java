package com.baidu.swan.card.api.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwanAppNARootViewTag {
    public static final int DEFAULT_FLAG = 0;
    public static final int FLAG_FIXED = 1;
    private int mFlags = 0;
    private int mOriginLeft;
    private int mOriginTop;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public SwanAppNARootViewTag addFlags(int flags) {
        this.mFlags |= flags;
        return this;
    }

    public void removeFlags(int flags) {
        this.mFlags &= ~flags;
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int getOriginLeft() {
        return this.mOriginLeft;
    }

    public void setOriginLeft(int originLeft) {
        this.mOriginLeft = originLeft;
    }

    public int getOriginTop() {
        return this.mOriginTop;
    }

    public void setOriginTop(int originTop) {
        this.mOriginTop = originTop;
    }
}
