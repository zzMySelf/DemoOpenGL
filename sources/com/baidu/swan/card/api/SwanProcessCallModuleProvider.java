package com.baidu.swan.card.api;

import com.baidu.swan.card.api.modules.utils.CommonSysInfoApi;
import com.baidu.swan.card.utils.ipc.delegation.SwanAppSharedPrefsGetDelegation;
import com.baidu.swan.card.utils.ipc.delegation.SwanAppSharedPrefsPutDelegation;
import java.util.HashMap;

public class SwanProcessCallModuleProvider {
    public static HashMap<Class, Object> getModules() {
        HashMap<Class, Object> map = new HashMap<>();
        map.put(CommonSysInfoApi.GetCommonInfoDelegation.class, new CommonSysInfoApi.GetCommonInfoDelegation());
        map.put(SwanAppSharedPrefsPutDelegation.class, new SwanAppSharedPrefsPutDelegation());
        map.put(SwanAppSharedPrefsGetDelegation.class, new SwanAppSharedPrefsGetDelegation());
        return map;
    }
}
