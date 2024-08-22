package com.baidu.searchbox.generalcommunity.ui.context;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;

public class FragmentController implements IController {
    private final Fragment mFragment;

    public FragmentController(Fragment fragment) {
        this.mFragment = fragment;
    }

    public Application getApplication() {
        Fragment fragment = this.mFragment;
        if (fragment == null || fragment.getActivity() == null) {
            return null;
        }
        return this.mFragment.getActivity().getApplication();
    }

    public Lifecycle getLifecycle() {
        return this.mFragment.getLifecycle();
    }

    public ViewModelStore getViewModelStore() {
        return this.mFragment.getViewModelStore();
    }
}
