package com.baidu.swan.apps.component.components.canvas.utils;

import com.baidu.swan.apps.canvas.model.CanvasBasicModel;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.components.canvas.SwanAppCanvasComponent;
import com.baidu.swan.apps.component.container.SwanAppComponentFinder;
import com.baidu.swan.apps.console.SwanAppLog;

public class SwanAppCanvasComponentUtils {
    private static final String TAG = "Component-Canvas-Utils";

    public static CanvasView getCanvasViewByCanvasId(CanvasBasicModel model) {
        SwanAppCanvasComponent component = (SwanAppCanvasComponent) SwanAppComponentFinder.findComponent(model);
        if (component != null) {
            return component.canvasView;
        }
        SwanAppLog.e(TAG, "get canvas view fail: find a null component");
        return null;
    }
}
