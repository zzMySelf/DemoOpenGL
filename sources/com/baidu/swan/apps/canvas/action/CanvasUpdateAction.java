package com.baidu.swan.apps.canvas.action;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.canvas.model.CanvasBasicModel;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.base.SwanAppComponentResult;
import com.baidu.swan.apps.component.components.canvas.SwanAppCanvasComponent;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.model.view.base.SwanAppRectPosition;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import org.json.JSONObject;

@Deprecated
public class CanvasUpdateAction extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swanAPI/canvas/update";

    public /* bridge */ /* synthetic */ void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.callback(unitedSchemeEntity, callbackHandler, z);
    }

    public /* bridge */ /* synthetic */ View getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.getBdWebViewBySlaveId(unitedSchemeEntity, str);
    }

    public /* bridge */ /* synthetic */ CanvasBasicModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        return super.parseMsgToModel(unitedSchemeEntity);
    }

    public /* bridge */ /* synthetic */ JSONObject resultCode(int i2) {
        return super.resultCode(i2);
    }

    public CanvasUpdateAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, ACTION_TYPE);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        CanvasBasicModel model = parseMsgToModel(entity);
        boolean z = false;
        if (model == null) {
            entity.result = resultCode(201);
            SwanAppLog.e("SwanAppCanvas", "update action parse model is null");
            return false;
        }
        String canvasId = model.componentId;
        SwanAppRectPosition position = model.position;
        if (TextUtils.isEmpty(canvasId) || position == null || !position.isValid()) {
            SwanAppLog.e("SwanAppCanvas", "some params invalid");
            entity.result = resultCode(202);
            return false;
        }
        SwanAppCanvasComponent component = (SwanAppCanvasComponent) SwanAppComponentFinder.findComponent(model);
        if (component == null) {
            SwanAppLog.e("SwanAppCanvas", "update canvas fail: fina a null component");
            entity.result = resultCode(1001);
            return false;
        }
        CanvasView canvasView = component.canvasView;
        if (!model.gesture && model.disableScroll) {
            z = true;
        }
        canvasView.setInterceptTouchEvent(z);
        SwanAppComponentResult result = component.update(model);
        boolean isSuccess = result.isSuccess();
        if (!isSuccess) {
            SwanAppLog.e("SwanAppCanvas", "update canvas fail: " + result.msg);
        }
        callback(entity, handler, isSuccess);
        return isSuccess;
    }
}
