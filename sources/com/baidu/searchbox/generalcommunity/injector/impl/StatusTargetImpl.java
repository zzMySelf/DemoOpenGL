package com.baidu.searchbox.generalcommunity.injector.impl;

import android.content.Context;
import com.baidu.searchbox.generalcommunity.injector.StatusTargetFactory;

public class StatusTargetImpl implements StatusTargetFactory {
    public StatusTargetFactory.StatusTarget provideTargetWhenDeleteAllItem(Context context) {
        return null;
    }

    public boolean showCustomErrorView(boolean isShow) {
        return false;
    }

    public boolean showCustomShimmerView(boolean isShow) {
        return false;
    }

    public boolean showCustomNoResultView() {
        return false;
    }
}
