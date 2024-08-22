package com.baidu.swan.apps.impl.map.action;

import android.content.Context;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.impl.map.MapViewManager;
import com.baidu.swan.apps.impl.map.item.SwanAppMapComponent;
import com.baidu.swan.apps.impl.map.utils.MapStyleResUtils;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.map.MapResultHandler;
import com.baidu.swan.apps.map.model.MapModel;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.io.File;
import org.json.JSONObject;

public class MapCreateAction extends AbsMapBaseAction<MapModel> {
    public static final int ANALYZE_FAIL = 20001;
    private static final String DOT_JSON = ".json";
    public static final int MAP_NO_FAIL = 20003;
    public static final int MAP_RENDER_FAIL = 20004;
    public static final int SUB_KEY_CHECK_FAIL = 20002;
    public static final int SUB_KEY_CHECK_SUCCESS = 20005;

    public static MapCreateAction get() {
        return new MapCreateAction();
    }

    /* access modifiers changed from: protected */
    public boolean doAction(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp, JSONObject result) {
        return createMap(context, model, handler, swanApp);
    }

    private boolean createMap(Context context, MapModel model, MapResultHandler handler, SwanApp swanApp) {
        SwanAppMapComponent mapComponent;
        SwanAppLog.i("map", "MapCreateAction start");
        boolean isOk = MapViewManager.get().create(context, model);
        SwanAppLog.i("map", "MapCreateAction end");
        ISwanAppWebViewManager manager = SwanAppController.getInstance().getWebViewManager(model.slaveId);
        if ((manager instanceof ISwanAppSlaveManager) && (mapComponent = MapViewManager.get().getMapViewHelper((ISwanAppSlaveManager) manager).find(model.componentId)) != null) {
            getMapStyleJson(context, model, swanApp, mapComponent.mapView, handler);
        }
        return isOk;
    }

    private void getMapStyleJson(Context context, MapModel model, SwanApp swanApp, TextureMapView textureMapView, MapResultHandler callbackHandler) {
        final Context context2 = context;
        final MapModel mapModel = model;
        final MapResultHandler mapResultHandler = callbackHandler;
        final TextureMapView textureMapView2 = textureMapView;
        swanApp.getSetting().checkAuthorize("mapp_i_map_custom_style", new TypedCallback<ScopeInfo>() {
            public void onCallback(ScopeInfo scopeInfo) {
                if (MapStyleResUtils.isPermitGetMapStyle(context2, scopeInfo, mapModel, mapResultHandler)) {
                    MapStyleResUtils.request(mapModel.layerStyle, new MapStyleResUtils.DownloadCallback() {
                        public void onSuccess() {
                            File file = new File(MapStyleResUtils.getUnzipDir(), mapModel.layerStyle + ".json");
                            if (!file.exists() || textureMapView2 == null) {
                                mapResultHandler.onAsyncError(mapModel.callback, 20004, context2.getResources().getString(R.string.map_render_fail_text));
                                return;
                            }
                            textureMapView2.setMapCustomStylePath(file.getAbsolutePath());
                            textureMapView2.setMapCustomStyleEnable(true);
                            mapResultHandler.onAsyncSuccess(mapModel.callback, (JSONObject) null);
                        }

                        public void onFail() {
                            mapResultHandler.onAsyncError(mapModel.callback, 20004, context2.getResources().getString(R.string.map_render_fail_text));
                        }
                    });
                }
            }
        });
    }
}
