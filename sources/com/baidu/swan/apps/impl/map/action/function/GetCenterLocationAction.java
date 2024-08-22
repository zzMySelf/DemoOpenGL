package com.baidu.swan.apps.impl.map.action.function;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.map.MapViewManager;
import com.baidu.swan.apps.impl.map.action.AbsMapBaseAction;
import com.baidu.swan.apps.impl.map.item.SwanAppMapComponent;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.map.MapResultHandler;
import com.baidu.swan.apps.map.model.MapModel;
import com.baidu.swan.apps.map.model.element.CoordinateModel;
import com.baidu.swan.apps.runtime.SwanApp;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCenterLocationAction extends AbsMapBaseAction<MapModel> {
    public static GetCenterLocationAction get() {
        return new GetCenterLocationAction();
    }

    private boolean getCenterLocation(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp, JSONObject result) {
        SwanAppLog.i("map", "GetCenterLcationAction start");
        ISwanAppWebViewManager manager = SwanAppController.getInstance().getWebViewManager(model.slaveId);
        if (!(manager instanceof ISwanAppSlaveManager)) {
            SwanAppLog.e("map", "WebViewManager is null");
            return false;
        }
        SwanAppMapComponent appMapComponent = MapViewManager.get().getMapViewHelper((ISwanAppSlaveManager) manager).find(model.componentId);
        if (appMapComponent == null) {
            SwanAppLog.e("map", "can not find map by id " + model.componentId);
            return false;
        }
        MapStatus mapStatus = appMapComponent.mapView.getMap().getMapStatus();
        CoordinateModel coordinate = new CoordinateModel();
        coordinate.latitude = mapStatus.target.latitude;
        coordinate.longitude = mapStatus.target.longitude;
        try {
            result.put("latitude", coordinate.latitude);
            result.put("longitude", coordinate.longitude);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SwanAppLog.i("map", "GetCenterLocationAction end");
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean doAction(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp, JSONObject result) {
        return getCenterLocation(context, model, handler, swanApp, result);
    }
}
