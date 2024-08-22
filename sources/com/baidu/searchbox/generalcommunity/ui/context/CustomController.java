package com.baidu.searchbox.generalcommunity.ui.context;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class CustomController implements IController {
    private final LifecycleOwner mLifecycleOwner;
    private final ViewModelStore mViewModelStore;

    public CustomController(ViewModelStore viewModelStore, LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModelStore = viewModelStore;
    }

    public Application getApplication() {
        return AppRuntime.getApplication();
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleOwner.getLifecycle();
    }

    public ViewModelStore getViewModelStore() {
        return this.mViewModelStore;
    }
}
