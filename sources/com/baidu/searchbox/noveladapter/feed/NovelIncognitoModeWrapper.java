package com.baidu.searchbox.noveladapter.feed;

import android.content.Context;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.utils.IncognitoModeInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.settings.extend.ISettingsFun;

public class NovelIncognitoModeWrapper implements NoProGuard {
    public boolean isIncognitoSwitchOn() {
        IncognitoModeInterface incognitoModeInterface = (IncognitoModeInterface) ServiceManager.getService(IncognitoModeInterface.SERVICE_REFERENCE);
        if (incognitoModeInterface != null) {
            return incognitoModeInterface.isIncognitoSwitchOn();
        }
        return false;
    }

    public void setIncognitoSwitch(boolean isIncognito) {
        IncognitoModeInterface incognitoModeInterface = (IncognitoModeInterface) ServiceManager.getService(IncognitoModeInterface.SERVICE_REFERENCE);
        if (incognitoModeInterface != null) {
            incognitoModeInterface.setIncognitoSwitch(isIncognito);
        }
    }

    public String getIncognitoTitle() {
        ISettingsFun settingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        if (settingsFun != null) {
            return settingsFun.getSugestionTitle();
        }
        return null;
    }

    public String getIncognitoDes() {
        ISettingsFun settingsFun = (ISettingsFun) ServiceManager.getService(ISettingsFun.Companion.getSERVICE_REFERENCE());
        if (settingsFun != null) {
            return settingsFun.getSugestionDesc();
        }
        return null;
    }

    public void showToast(String msg) {
        final String str = msg;
        PopupExclusionManagerMap.getInstance().display(PopupExclusionManagerMap.SCENE_HISSUG, new PopupExclusionManagerMap.Operation(ExclusionType.HISSUG_INCOGNITO_MODE_TOAST, 3.0f, true, true) {
            public void onShow(final ShowStatusCallback callback) {
                UiThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        UniversalToast toast = UniversalToast.makeText((Context) BdBoxActivityManager.getRealTopActivity(), (CharSequence) str);
                        toast.show();
                        toast.setOnDismissListener(new UniversalToast.OnDismissListener() {
                            public void onDismiss() {
                                PopupExclusionManagerMap.getInstance().unDisplay(PopupExclusionManagerMap.SCENE_HISSUG, ExclusionType.HISSUG_INCOGNITO_MODE_TOAST);
                            }
                        });
                        callback.callback(ShowStatus.REAL_SHOW);
                    }
                });
            }
        });
    }
}
