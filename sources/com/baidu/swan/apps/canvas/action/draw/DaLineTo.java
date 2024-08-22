package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import org.json.JSONArray;

public class DaLineTo extends AbsDrawAction {
    public static final String ACTION_TYPE = "lineTo";
    private int mX = Integer.MAX_VALUE;
    private int mY = Integer.MAX_VALUE;

    public void parseJson(JSONArray jsonArray) {
        if (jsonArray.length() > 1) {
            this.mX = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(0));
            this.mY = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(1));
        }
    }

    public void draw(CanvasContext context, Canvas canvas) {
        if (this.mX != Integer.MAX_VALUE && this.mY != Integer.MAX_VALUE) {
            context.mPath.lineTo((float) this.mX, (float) this.mY);
        }
    }
}
