package com.baidu.searchbox.account.event;

import com.baidu.searchbox.NoProGuard;

public class ImageResultEvent implements NoProGuard {
    private boolean mIsDynamicAvatar;
    private int mState;

    public int getState() {
        return this.mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public void setDynamicAvatar(boolean isDynamic) {
        this.mIsDynamicAvatar = isDynamic;
    }

    public boolean getDynamicAvatar() {
        return this.mIsDynamicAvatar;
    }
}
