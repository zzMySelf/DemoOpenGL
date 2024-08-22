package com.baidu.swan.apps.impl.map.action;

import android.content.Context;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.map.MapViewManager;
import com.baidu.swan.apps.map.MapResultHandler;
import com.baidu.swan.apps.map.model.MapModel;
import com.baidu.swan.apps.runtime.SwanApp;
import org.json.JSONObject;

public class MapUpdateAction extends AbsMapBaseAction<MapModel> {
    public static MapUpdateAction get() {
        return new MapUpdateAction();
    }

    private boolean updateMap(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp) {
        SwanAppLog.i("map", "MapUpdateAction start");
        boolean isOk = MapViewManager.get().update(context, model);
        SwanAppLog.i("map", "MapUpdateAction end");
        return isOk;
    }

    /* access modifiers changed from: protected */
    public boolean doAction(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp, JSONObject result) {
        return updateMap(context, model, handler, swanApp);
    }
}
