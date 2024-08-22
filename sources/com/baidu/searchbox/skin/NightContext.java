package com.baidu.searchbox.skin;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.oem.bridge.OemRuntime;
import com.baidu.searchbox.skin.SkinManager;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.INightContext;
import com.baidu.searchbox.skin.ioc.SkinRuntime;
import com.baidu.searchbox.skin.util.SkinNightModeUtilKt;
import com.baidu.searchbox.skin.util.SkinSpHelper;
import com.baidu.searchbox.uarm.UARInterface;
import java.util.TimeZone;
import org.json.JSONObject;

public class NightContext implements INightContext {
    private static final int DAY_HOURS_END = 72000;
    private static final int DAY_HOURS_START = 21600;
    private static final int DAY_SECOND = 86400;
    private static final int SECOND_MS = 1000;

    public void setNightModeSwitcherState(boolean enable) {
        if (OemRuntime.getOemContext() != null && OemRuntime.getOemContext().getOemSwitchDeleteNight() == 1) {
            return;
        }
        if (SkinNightModeUtilKt.isSupportNightMode() || !enable) {
            UARInterface uarInterface = (UARInterface) ServiceManager.getService(UARInterface.Companion.getReference());
            String str = null;
            if (uarInterface != null) {
                uarInterface.operateNightMode((JSONObject) null);
            }
            SkinSpHelper.setNightModeState(enable);
            SkinManager instance = SkinManager.getInstance();
            if (enable) {
                str = SkinRuntime.getSkinContext().getNightPackageName();
            }
            instance.changeSkin(str);
            SkinRuntime.getSkinContext().notifyNightModeState(AppRuntime.getAppContext(), enable, false);
        }
    }

    public boolean getNightModeSwitcherState() {
        return SkinSpHelper.getNightModeState();
    }

    public void forceSyncNightModeState(boolean enable) {
        if (SkinNightModeUtilKt.isSupportNightMode() || !enable) {
            SkinManager.getInstance().changeSkin(enable ? SkinRuntime.getSkinContext().getNightPackageName() : null, true);
            SkinRuntime.getSkinContext().notifyNightModeState(AppRuntime.getAppContext(), enable, true);
        }
    }

    public boolean shouldShowNightModeBubble() {
        if (getNightModeSwitcherState()) {
            return false;
        }
        long curOffset = ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 1000) % 86400;
        if (21600 >= curOffset || curOffset >= 72000) {
            return true;
        }
        return false;
    }

    public void subscribeNightModeChangeEvent(Object tag, final NightModeChangeListener nightModeChangeListener) {
        BdEventBus.Companion.getDefault().lazyRegister(tag, SkinManager.EventNightModeChanged.class, 1, new Action<SkinManager.EventNightModeChanged>() {
            public void call(SkinManager.EventNightModeChanged eventNightModeChanged) {
                NightModeChangeListener nightModeChangeListener = nightModeChangeListener;
                if (nightModeChangeListener != null) {
                    nightModeChangeListener.onNightModeChanged(eventNightModeChanged.isNightMode);
                }
            }
        });
    }

    public void unsubscribeNightModeChangedEvent(Object tag) {
        BdEventBus.Companion.getDefault().unregister(tag);
    }

    public void checkNightModeForYouthMode() {
        SkinManager.getInstance().checkForNotSupportMode();
    }
}
