package com.baidu.searchbox.lockscreen.provider;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.lockscreen.controller.LockScreenManager;
import com.baidu.searchbox.lockscreen.guide.LockScreenSwitch;
import com.baidu.searchbox.lockscreen.util.LockScreenCommonUtils;
import com.baidu.searchbox.lockscreen.util.LockScreenPreferenceUtils;
import com.baidu.searchbox.lockscreen.util.LockScreenUiUtils;
import com.baidu.searchbox.lockscreen.util.NotificationUtil;
import com.baidu.searchbox.lockscreen.util.TestFileUtil;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.ArrayList;
import java.util.List;

public class LockScreenOperationProvider extends DebugDataGroupProvider {
    private CompoundButton.OnCheckedChangeListener mCloseLockScreenListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ((CheckBox) LockScreenOperationProvider.this.mOpenLockscreenItem.getView()).setChecked(false);
                if (LockScreenCommonUtils.GLOBAL_DEBUG) {
                    TestFileUtil.appendRecord("DebugFeturesTab addLockScreenSwitcher closeLockScreen service");
                }
                LockScreenManager.closeLockScreen(LockScreenOperationProvider.this.mContext);
            }
        }
    };
    /* access modifiers changed from: private */
    public CheckItemInfo mCloseLockscreenItem;
    /* access modifiers changed from: private */
    public Context mContext = AppRuntime.getAppContext();
    private CheckItemInfo mHideCardItem;
    private CompoundButton.OnCheckedChangeListener mHideCardListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int cardHide = 0;
            if (isChecked) {
                cardHide = 1;
                LockScreenPreferenceUtils.putBoolean(LockScreenPreferenceUtils.KEY_LOCKSCREEN_SHOW_NEWS, true);
            }
            LockScreenPreferenceUtils.putInt(LockScreenUiUtils.HIDE_TYPE_SWITCH, cardHide);
        }
    };
    private CompoundButton.OnCheckedChangeListener mOpenLockScreenListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            public void run() {
                                ((CheckBox) LockScreenOperationProvider.this.mCloseLockscreenItem.getView()).setChecked(false);
                                LockScreenManager.openLockScreen(LockScreenOperationProvider.this.mContext);
                                Toast.makeText(LockScreenOperationProvider.this.mContext, "Dangerous:涉及锁屏多进程访问SharePreference操作,\n请使用LockScreenPreferenceUtils.getMultiPreference", 0).show();
                            }
                        });
                    }
                }, "LockScreenConflict", 1);
            }
        }
    };
    /* access modifiers changed from: private */
    public CheckItemInfo mOpenLockscreenItem;

    public List<DebugItemInfo> getChildItemList() {
        return getLockScreenOperationInfo();
    }

    public String getGroupName() {
        return "锁屏阅读切换方式";
    }

    private List<DebugItemInfo> getLockScreenOperationInfo() {
        List<DebugItemInfo> itemInfos = new ArrayList<>();
        boolean flag = LockScreenPreferenceUtils.isActivated(this.mContext);
        this.mOpenLockscreenItem = new CheckItemInfo("打开锁屏阅读", this.mOpenLockScreenListener, Boolean.valueOf(flag));
        this.mCloseLockscreenItem = new CheckItemInfo("关闭锁屏阅读", this.mCloseLockScreenListener, Boolean.valueOf(!flag));
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mHideCardListener;
        boolean z = false;
        if (LockScreenPreferenceUtils.getInt(LockScreenUiUtils.HIDE_TYPE_SWITCH, 0) == 1) {
            z = true;
        }
        this.mHideCardItem = new CheckItemInfo("卡片可以隐藏", onCheckedChangeListener, Boolean.valueOf(z));
        itemInfos.add(this.mOpenLockscreenItem);
        itemInfos.add(this.mCloseLockscreenItem);
        itemInfos.add(this.mHideCardItem);
        itemInfos.add(new TextItemInfo((String) null, "打开锁屏引导", new View.OnClickListener() {
            public void onClick(View v) {
                LockScreenSwitch lockScreenSwitch = new LockScreenSwitch();
                lockScreenSwitch.way = "guide";
                lockScreenSwitch.callFrom = WebViewFactoryProvider.SETTING_DEBUG;
                LockScreenCommonUtils.startLockScreenGuideActivity(LockScreenOperationProvider.this.mContext, false, lockScreenSwitch);
            }
        }));
        itemInfos.add(new TextItemInfo((String) null, "发送锁屏引导通知", new View.OnClickListener() {
            public void onClick(View v) {
                NotificationUtil.showGuideNotification();
            }
        }));
        return itemInfos;
    }
}
