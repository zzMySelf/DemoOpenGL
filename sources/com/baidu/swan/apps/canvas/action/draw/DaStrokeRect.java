package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import org.json.JSONArray;

public class DaStrokeRect extends AbsDrawAction {
    public static final String ACTION_TYPE = "strokeRect";
    private Path mPath;

    public void parseJson(JSONArray jsonArray) {
        try {
            if (jsonArray.length() == 4) {
                int x = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(0));
                int y = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(1));
                int width = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(2));
                int height = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(3));
                Path path = new Path();
                this.mPath = path;
                path.addRect(new RectF((float) x, (float) y, (float) (x + width), (float) (y + height)), Path.Direction.CW);
            }
        } catch (Exception e2) {
            if (SwanAppLibConfig.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void draw(CanvasContext context, Canvas canvas) {
        if (this.mPath != null) {
            int alpha = context.mStrokePaint.getAlpha();
            context.applyGlobal(context.mStrokePaint);
            canvas.drawPath(this.mPath, context.mStrokePaint);
            context.mStrokePaint.setAlpha(alpha);
        }
    }
}
