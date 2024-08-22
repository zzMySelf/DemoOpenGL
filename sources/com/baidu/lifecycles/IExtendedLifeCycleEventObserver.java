package com.baidu.lifecycles;

import androidx.lifecycle.LifecycleOwner;

public interface IExtendedLifeCycleEventObserver extends ICommonLifecycleEventObserver {
    void onIdle(LifecycleOwner lifecycleOwner);

    void onRendered(LifecycleOwner lifecycleOwner);
}
