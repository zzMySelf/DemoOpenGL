package com.baidu.searchbox.launch.restore.interfaces;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/launch/restore/interfaces/IColdLaunchRestoreSetting;", "", "getLaunchRestoreSwitcherState", "", "getLaunchRestoreSwitcherText", "", "isNeedShowSwitchItem", "setLaunchRestoreSwitcherState", "", "enable", "lib-app-launch-restore-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IColdLaunchRestoreSetting.kt */
public interface IColdLaunchRestoreSetting {
    boolean getLaunchRestoreSwitcherState();

    String getLaunchRestoreSwitcherText();

    boolean isNeedShowSwitchItem();

    void setLaunchRestoreSwitcherState(boolean z);
}
