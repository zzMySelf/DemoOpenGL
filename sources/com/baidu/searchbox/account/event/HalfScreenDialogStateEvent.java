package com.baidu.searchbox.account.event;

import com.baidu.searchbox.NoProGuard;

public class HalfScreenDialogStateEvent implements NoProGuard {
    private boolean mState;

    public boolean isShowing() {
        return this.mState;
    }

    public void setShowState(boolean state) {
        this.mState = state;
    }
}
