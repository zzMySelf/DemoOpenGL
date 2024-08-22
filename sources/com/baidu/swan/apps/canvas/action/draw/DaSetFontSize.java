package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import org.json.JSONArray;

public class DaSetFontSize extends AbsDrawAction {
    public static final String ACTION_TYPE = "setFontSize";
    private int mFontSize;

    public void parseJson(JSONArray jsonArray) {
        try {
            if (jsonArray.length() > 0) {
                this.mFontSize = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(0));
            }
        } catch (Exception e2) {
            if (SwanAppLibConfig.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void draw(CanvasContext context, Canvas canvas) {
        if (this.mFontSize > 0) {
            context.mFontPaint.setTextSize((float) this.mFontSize);
        }
    }
}
