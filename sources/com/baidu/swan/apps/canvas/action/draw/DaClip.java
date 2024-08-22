package com.baidu.swan.apps.canvas.action.draw;

import android.graphics.Canvas;
import android.graphics.Region;
import org.json.JSONArray;

public class DaClip extends AbsDrawAction {
    public static final String ACTION_TYPE = "clip";

    public void parseJson(JSONArray jsonArray) {
    }

    public void draw(CanvasContext context, Canvas canvas) {
        context.mIsClip = true;
        canvas.clipPath(context.mPath, Region.Op.INTERSECT);
    }
}
