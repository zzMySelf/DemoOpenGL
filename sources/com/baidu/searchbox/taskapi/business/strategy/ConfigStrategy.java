package com.baidu.searchbox.taskapi.business.strategy;

import android.view.ViewGroup;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;

public class ConfigStrategy {
    public static ViewGroup getRealParentView(TaskConfig mConfig) {
        if (mConfig == null) {
            return null;
        }
        ViewGroup parentView = null;
        TaskConfig.IGetParentViewListener viewListener = mConfig.getGetParentView();
        if (viewListener != null) {
            parentView = viewListener.getParentView();
        }
        if (parentView == null) {
            DefaultStrategy.getDefaultRootView(mConfig.getContext());
        }
        return parentView;
    }

    public static ViewGroup.LayoutParams getRealLayoutParams(TaskConfig mConfig) {
        if (mConfig == null) {
            return DefaultStrategy.createDefaultParams();
        }
        ViewGroup.LayoutParams params = DefaultStrategy.createDefaultParams();
        if (mConfig.getLayoutParams() != null) {
            return mConfig.getLayoutParams();
        }
        return params;
    }
}
