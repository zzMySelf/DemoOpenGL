package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import org.json.JSONArray;

public class DaSetLineDash extends AbsDrawAction {
    public static final String ACTION_TYPE = "setLineDash";
    private DashPathEffect mDashPathEffect;

    public void parseJson(JSONArray jsonArray) {
        JSONArray patternArray;
        float[] pattern = null;
        int offset = 0;
        if (jsonArray.length() > 0 && (patternArray = jsonArray.optJSONArray(0)) != null) {
            int length = patternArray.length();
            int length2 = length;
            if (length > 0) {
                pattern = new float[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    pattern[i2] = (float) SwanAppUIUtils.dp2px((float) patternArray.optDouble(i2));
                }
            }
        }
        if (jsonArray.length() > 1) {
            offset = SwanAppUIUtils.dp2px((float) jsonArray.optDouble(1));
        }
        if (pattern != null && offset >= 0) {
            this.mDashPathEffect = new DashPathEffect(pattern, (float) offset);
        }
    }

    public void draw(CanvasContext context, Canvas canvas) {
        if (this.mDashPathEffect != null) {
            context.mStrokePaint.setPathEffect(this.mDashPathEffect);
        }
    }
}
