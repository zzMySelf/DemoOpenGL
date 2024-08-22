package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import org.json.JSONArray;

public class DaTranslate extends AbsDrawAction {
    public static final String ACTION_TYPE = "translate";
    private int mX;
    private int mY;

    public void parseJson(JSONArray jsonArray) {
        if (jsonArray.length() > 1) {
            this.mX = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(0));
            this.mY = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(1));
        }
    }

    public void draw(CanvasContext context, Canvas canvas) {
        if (context.GetMatrixOrigin() == 0) {
            context.SaveMatrixOrigin(canvas.save());
        }
        canvas.translate((float) this.mX, (float) this.mY);
    }
}
