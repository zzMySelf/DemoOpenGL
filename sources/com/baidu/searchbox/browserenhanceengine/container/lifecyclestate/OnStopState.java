package com.baidu.searchbox.browserenhanceengine.container.lifecyclestate;

import com.baidu.searchbox.browserenhanceengine.container.ContainerLifeCycleOwner;

public class OnStopState extends BaseContainerState {
    public boolean enter(ContainerLifeCycleOwner owner, Object... params) {
        if (owner == null) {
            return true;
        }
        owner.onStop();
        return true;
    }

    public int onMessage(ContainerLifeCycleOwner owner, int status) {
        switch (status) {
            case 4114:
            case ContainerState.STATE_DESTROY:
                return 1;
            case 4115:
            case 4116:
                return 4114;
            default:
                return -1;
        }
    }

    public int getState() {
        return 4118;
    }
}
