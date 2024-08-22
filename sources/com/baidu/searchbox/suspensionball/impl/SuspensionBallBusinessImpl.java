package com.baidu.searchbox.suspensionball.impl;

import android.app.Activity;
import com.baidu.searchbox.MainActivity;
import com.baidu.searchbox.ManageSpaceActivity;
import com.baidu.searchbox.SplashActivity;
import com.baidu.searchbox.push.systemnotify.MessageNotifyDispatcherActivity;
import com.baidu.searchbox.suspensionball.business.ioc.ISuspensionBallBusinessIoc;

public class SuspensionBallBusinessImpl implements ISuspensionBallBusinessIoc {
    public boolean enableInitSuspensionData(Activity activity) {
        if (activity != null && !(activity instanceof MainActivity) && !(activity instanceof SplashActivity) && !(activity instanceof MessageNotifyDispatcherActivity) && !(activity instanceof ManageSpaceActivity)) {
            return true;
        }
        return false;
    }
}
