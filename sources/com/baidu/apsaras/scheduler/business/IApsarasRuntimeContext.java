package com.baidu.apsaras.scheduler.business;

import android.content.Context;

public interface IApsarasRuntimeContext {
    Context appContext();

    String getAbSwitch(String str, String str2);

    boolean isDebug();

    boolean isDefaultDispatcherSwitchOn();

    boolean isSwitchOn();
}
