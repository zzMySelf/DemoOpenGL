package com.baidu.swan.apps.canvas.model;

import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.canvas.action.draw.AbsDrawAction;
import com.baidu.swan.apps.canvas.action.draw.DaArc;
import com.baidu.swan.apps.canvas.action.draw.DaBeginPath;
import com.baidu.swan.apps.canvas.action.draw.DaBezierCurveTo;
import com.baidu.swan.apps.canvas.action.draw.DaClearRect;
import com.baidu.swan.apps.canvas.action.draw.DaClip;
import com.baidu.swan.apps.canvas.action.draw.DaClosePath;
import com.baidu.swan.apps.canvas.action.draw.DaDrawImage;
import com.baidu.swan.apps.canvas.action.draw.DaFill;
import com.baidu.swan.apps.canvas.action.draw.DaFillRect;
import com.baidu.swan.apps.canvas.action.draw.DaFillText;
import com.baidu.swan.apps.canvas.action.draw.DaFont;
import com.baidu.swan.apps.canvas.action.draw.DaLineTo;
import com.baidu.swan.apps.canvas.action.draw.DaMoveTo;
import com.baidu.swan.apps.canvas.action.draw.DaQuadraticCurveTo;
import com.baidu.swan.apps.canvas.action.draw.DaRect;
import com.baidu.swan.apps.canvas.action.draw.DaRestore;
import com.baidu.swan.apps.canvas.action.draw.DaRotate;
import com.baidu.swan.apps.canvas.action.draw.DaSave;
import com.baidu.swan.apps.canvas.action.draw.DaScale;
import com.baidu.swan.apps.canvas.action.draw.DaSetFillStyle;
import com.baidu.swan.apps.canvas.action.draw.DaSetFontSize;
import com.baidu.swan.apps.canvas.action.draw.DaSetGlobalAlpha;
import com.baidu.swan.apps.canvas.action.draw.DaSetLineCap;
import com.baidu.swan.apps.canvas.action.draw.DaSetLineDash;
import com.baidu.swan.apps.canvas.action.draw.DaSetLineJoin;
import com.baidu.swan.apps.canvas.action.draw.DaSetLineWidth;
import com.baidu.swan.apps.canvas.action.draw.DaSetMiterLimit;
import com.baidu.swan.apps.canvas.action.draw.DaSetShadow;
import com.baidu.swan.apps.canvas.action.draw.DaSetStrokeStyle;
import com.baidu.swan.apps.canvas.action.draw.DaSetTextAlign;
import com.baidu.swan.apps.canvas.action.draw.DaSetTextBaseline;
import com.baidu.swan.apps.canvas.action.draw.DaSetTransform;
import com.baidu.swan.apps.canvas.action.draw.DaStroke;
import com.baidu.swan.apps.canvas.action.draw.DaStrokeRect;
import com.baidu.swan.apps.canvas.action.draw.DaStrokeStyle;
import com.baidu.swan.apps.canvas.action.draw.DaStrokeText;
import com.baidu.swan.apps.canvas.action.draw.DaTransform;
import com.baidu.swan.apps.canvas.action.draw.DaTranslate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CanvasDrawModel extends CanvasBasicModel {
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_DATA = "data";
    private static final String KEY_METHOD = "method";
    private static final String KEY_RESERVE = "reserve";
    private static Map<String, Class<? extends AbsDrawAction>> sDrawActionMap;
    private List<AbsDrawAction> mDrawActionList = new ArrayList();
    private boolean mIsReserve;

    static {
        HashMap hashMap = new HashMap();
        sDrawActionMap = hashMap;
        hashMap.put(DaSetFillStyle.ACTION_TYPE, DaSetFillStyle.class);
        sDrawActionMap.put(DaFillRect.ACTION_TYPE, DaFillRect.class);
        sDrawActionMap.put(DaSetStrokeStyle.ACTION_TYPE, DaSetStrokeStyle.class);
        sDrawActionMap.put(DaStrokeStyle.ACTION_TYPE, DaStrokeStyle.class);
        sDrawActionMap.put(DaSetLineCap.ACTION_TYPE, DaSetLineCap.class);
        sDrawActionMap.put(DaSetLineJoin.ACTION_TYPE, DaSetLineJoin.class);
        sDrawActionMap.put(DaSetLineWidth.ACTION_TYPE, DaSetLineWidth.class);
        sDrawActionMap.put(DaSetLineDash.ACTION_TYPE, DaSetLineDash.class);
        sDrawActionMap.put(DaSetMiterLimit.ACTION_TYPE, DaSetMiterLimit.class);
        sDrawActionMap.put(DaStrokeRect.ACTION_TYPE, DaStrokeRect.class);
        sDrawActionMap.put(DaMoveTo.ACTION_TYPE, DaMoveTo.class);
        sDrawActionMap.put(DaLineTo.ACTION_TYPE, DaLineTo.class);
        sDrawActionMap.put("stroke", DaStroke.class);
        sDrawActionMap.put("fill", DaFill.class);
        sDrawActionMap.put(DaBeginPath.ACTION_TYPE, DaBeginPath.class);
        sDrawActionMap.put(DaRect.ACTION_TYPE, DaRect.class);
        sDrawActionMap.put(DaClearRect.ACTION_TYPE, DaClearRect.class);
        sDrawActionMap.put(DaClosePath.ACTION_TYPE, DaClosePath.class);
        sDrawActionMap.put(DaArc.ACTION_TYPE, DaArc.class);
        sDrawActionMap.put(DaBezierCurveTo.ACTION_TYPE, DaBezierCurveTo.class);
        sDrawActionMap.put(DaQuadraticCurveTo.ACTION_TYPE, DaQuadraticCurveTo.class);
        sDrawActionMap.put("scale", DaScale.class);
        sDrawActionMap.put("rotate", DaRotate.class);
        sDrawActionMap.put("translate", DaTranslate.class);
        sDrawActionMap.put("transform", DaTransform.class);
        sDrawActionMap.put(DaSetTransform.ACTION_TYPE, DaSetTransform.class);
        sDrawActionMap.put("font", DaFont.class);
        sDrawActionMap.put(DaSetFontSize.ACTION_TYPE, DaSetFontSize.class);
        sDrawActionMap.put(DaSetTextAlign.ACTION_TYPE, DaSetTextAlign.class);
        sDrawActionMap.put(DaSetTextBaseline.ACTION_TYPE, DaSetTextBaseline.class);
        sDrawActionMap.put(DaFillText.ACTION_TYPE, DaFillText.class);
        sDrawActionMap.put(DaStrokeText.ACTION_TYPE, DaStrokeText.class);
        sDrawActionMap.put(DaClip.ACTION_TYPE, DaClip.class);
        sDrawActionMap.put(DaDrawImage.ACTION_TYPE, DaDrawImage.class);
        sDrawActionMap.put("save", DaSave.class);
        sDrawActionMap.put("restore", DaRestore.class);
        sDrawActionMap.put(DaSetShadow.ACTION_TYPE, DaSetShadow.class);
        sDrawActionMap.put(DaSetGlobalAlpha.ACTION_TYPE, DaSetGlobalAlpha.class);
    }

    public CanvasDrawModel(String paramsValue) {
        super(paramsValue);
        boolean z = false;
        this.mIsReserve = false;
        try {
            JSONObject jsonObject = new JSONObject(paramsValue);
            JSONArray drawActionArray = new JSONArray(jsonObject.optString("actions"));
            int actionsCount = drawActionArray.length();
            for (int i2 = 0; i2 < actionsCount; i2++) {
                JSONObject drawActionObject = drawActionArray.optJSONObject(i2);
                String method = drawActionObject.optString("method");
                JSONArray data = drawActionObject.optJSONArray("data");
                Class<? extends AbsDrawAction> drawActionClass = sDrawActionMap.get(method);
                if (drawActionClass != null) {
                    AbsDrawAction action = (AbsDrawAction) drawActionClass.newInstance();
                    action.parseJson(data);
                    this.mDrawActionList.add(action);
                }
            }
            this.mIsReserve = jsonObject.optInt(KEY_RESERVE) != 0 ? true : z;
        } catch (Exception e2) {
            if (SwanAppLibConfig.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public List<AbsDrawAction> getDrawActionList() {
        return this.mDrawActionList;
    }

    public boolean isReserve() {
        return this.mIsReserve;
    }

    public boolean isValid() {
        return super.isValid();
    }
}
