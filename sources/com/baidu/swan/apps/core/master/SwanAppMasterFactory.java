package com.baidu.swan.apps.core.master;

import android.content.Context;

public class SwanAppMasterFactory implements ISwanAppMasterFactory<SwanAppMasterContainer> {
    public SwanAppMasterContainer createMaster(Context context, int type) {
        switch (type) {
            case 0:
                return new SwanAppMasterManager(context);
            case 1:
                return new V8MasterAdapter(context);
            default:
                return new SwanAppMasterManager(context);
        }
    }
}
