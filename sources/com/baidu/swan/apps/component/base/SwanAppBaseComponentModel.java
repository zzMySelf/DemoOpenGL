package com.baidu.swan.apps.component.base;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.component.base.interfaces.ISwanAppComponentModel;
import com.baidu.swan.apps.component.utils.SwanAppComponentUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.model.view.base.SwanAppRectPosition;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SwanAppBaseComponentModel implements ISwanAppComponentModel {
    protected static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    protected static final String DISABLE_DEFAULT = "0";
    private static final String ENABLE_DEFAULT = "1";
    public static final String KEY_CALLBACK = "cb";
    public static final String KEY_COMPONENT_ID = "componentId";
    protected static final String KEY_FIXED = "fixed";
    protected static final String KEY_FIXED_BOTTOM = "fixedBottom";
    protected static final String KEY_FIXED_LEFT = "fixedLeft";
    protected static final String KEY_FIXED_RIGHT = "fixedRight";
    protected static final String KEY_FIXED_TOP = "fixedTop";
    protected static final String KEY_GESTURE = "gesture";
    protected static final String KEY_HIDDEN = "hide";
    private static final String KEY_PARENT_ID = "parentId";
    private static final String KEY_POSITION = "position";
    private static final String KEY_POSITION_KEY_HEIGHT = "height";
    private static final String KEY_POSITION_KEY_LEFT = "left";
    private static final String KEY_POSITION_KEY_TOP = "top";
    private static final String KEY_POSITION_KEY_WIDTH = "width";
    public static final String KEY_SLAVE_ID = "slaveId";
    private static final String TAG = "Component-Model-Base";
    public String callback = "";
    public String componentId = "";
    public String componentType = "unknown";
    public boolean gesture = false;
    public boolean hidden = false;
    private String mComponentIdKey = "id";
    public String parentId = "";
    public SwanAppRectPosition position;
    public String slaveId = "";

    public SwanAppBaseComponentModel(String componentType2, String mComponentIdKey2) {
        if (!TextUtils.isEmpty(componentType2)) {
            this.componentType = componentType2;
        } else {
            SwanAppComponentUtils.logErrorWithThrow(TAG, "component type is empty");
        }
        if (!TextUtils.isEmpty(mComponentIdKey2)) {
            this.mComponentIdKey = mComponentIdKey2;
        } else {
            SwanAppComponentUtils.logErrorWithThrow(TAG, "component id key is empty");
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        SwanAppBaseComponentModel model = (SwanAppBaseComponentModel) super.clone();
        SwanAppRectPosition swanAppRectPosition = this.position;
        if (swanAppRectPosition != null) {
            model.position = (SwanAppRectPosition) swanAppRectPosition.clone();
        } else {
            model.position = null;
        }
        return model;
    }

    public void parseFromJson(JSONObject json) throws JSONException {
        if (json != null) {
            if (!TextUtils.equals(this.mComponentIdKey, "ARCameraId")) {
                String optString = json.optString("componentId");
                this.componentId = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.componentId = json.optString(this.mComponentIdKey);
                }
            } else {
                String optString2 = json.optString(this.mComponentIdKey);
                this.componentId = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.componentId = json.optString("componentId");
                }
            }
            if (TextUtils.isEmpty(this.componentId)) {
                SwanAppLog.e(TAG, this.componentType + " component componentId is empty");
            }
            String optString3 = json.optString("slaveId");
            this.slaveId = optString3;
            if (TextUtils.isEmpty(optString3)) {
                SwanAppLog.e(TAG, this.componentType + " component slaveId is empty");
            }
            this.parentId = json.optString(KEY_PARENT_ID);
            this.callback = json.optString("cb");
            this.hidden = json.optBoolean("hide", false);
            this.gesture = TextUtils.equals(json.optString("gesture"), "1");
            parsePosition(json);
        }
    }

    public final void parseFromJson(JSONObject json, SwanAppBaseComponentModel fallback) {
        if (json != null) {
            if (!TextUtils.equals(this.mComponentIdKey, "ARCameraId")) {
                String optString = json.optString("componentId");
                this.componentId = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.componentId = json.optString(this.mComponentIdKey, fallback.componentId);
                }
            } else {
                String optString2 = json.optString(this.mComponentIdKey);
                this.componentId = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.componentId = json.optString("componentId", fallback.componentId);
                }
            }
            if (TextUtils.isEmpty(this.componentId)) {
                SwanAppLog.e(TAG, this.componentType + " component componentId is empty");
            }
            String optString3 = json.optString("slaveId", fallback.slaveId);
            this.slaveId = optString3;
            if (TextUtils.isEmpty(optString3)) {
                SwanAppLog.e(TAG, this.componentType + " component slaveId is empty");
            }
            this.parentId = json.optString(KEY_PARENT_ID, fallback.parentId);
            this.callback = json.optString("cb", fallback.callback);
            this.hidden = json.optBoolean("hide", fallback.hidden);
            this.gesture = TextUtils.equals(json.optString("gesture", fallback.gesture ? "1" : "0"), "1");
            SwanAppRectPosition swanAppRectPosition = fallback.position;
            this.position = swanAppRectPosition;
            if (swanAppRectPosition == null) {
                this.position = new SwanAppRectPosition();
            }
            parsePosition(json);
        }
    }

    public void updateModel(JSONObject newModel) {
        String str;
        if (!TextUtils.equals(this.mComponentIdKey, "ARCameraId")) {
            String optString = newModel.optString("componentId");
            this.componentId = optString;
            if (TextUtils.isEmpty(optString)) {
                this.componentId = newModel.optString(this.mComponentIdKey, this.componentId);
            }
        } else {
            String optString2 = newModel.optString(this.mComponentIdKey);
            this.componentId = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.componentId = newModel.optString("componentId", this.componentId);
            }
        }
        if (TextUtils.isEmpty(this.componentId)) {
            SwanAppLog.e(TAG, this.componentType + " component componentId is empty");
        }
        String optString3 = newModel.optString("slaveId", this.slaveId);
        this.slaveId = optString3;
        if (TextUtils.isEmpty(optString3)) {
            SwanAppLog.e(TAG, this.componentType + " component slaveId is empty");
        }
        this.parentId = newModel.optString(KEY_PARENT_ID, this.parentId);
        this.callback = newModel.optString("cb", this.callback);
        this.hidden = newModel.optBoolean("hide", this.hidden);
        if (this.gesture) {
            str = "1";
        } else {
            str = "0";
        }
        this.gesture = TextUtils.equals(newModel.optString("gesture", str), "1");
        parsePosition(newModel);
    }

    public void parsePosition(JSONObject json) {
        JSONObject positionObj = json.optJSONObject("position");
        if (positionObj != null) {
            SwanAppRectPosition swanAppRectPosition = new SwanAppRectPosition();
            this.position = swanAppRectPosition;
            swanAppRectPosition.setLeft(SwanAppUIUtils.dp2px(getFloat(positionObj, "left", 0.0f)));
            this.position.setTop(SwanAppUIUtils.dp2px(getFloat(positionObj, "top", 0.0f)));
            this.position.setWidth(SwanAppUIUtils.dp2px(getFloat(positionObj, "width", 0.0f)));
            this.position.setHeight(SwanAppUIUtils.dp2px(getFloat(positionObj, "height", 0.0f)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r1.position;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r1 = this;
            java.lang.String r0 = r1.componentId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = r1.slaveId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001c
            com.baidu.swan.apps.model.view.base.SwanAppRectPosition r0 = r1.position
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.component.base.SwanAppBaseComponentModel.isValid():boolean");
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.componentType + '\'' + ", componentId='" + this.componentId + '\'' + ", slaveId='" + this.slaveId + '\'' + ", parentId='" + this.parentId + '\'' + ", callback='" + this.callback + '\'' + ", hidden=" + this.hidden + ", gesture=" + this.gesture + ", position=" + this.position + ", mComponentIdKey='" + this.mComponentIdKey + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public final String getName() {
        return "【" + this.componentType + "#" + (TextUtils.isEmpty(this.componentId) ? "" : this.componentId) + "】";
    }

    public final FrameLayout.LayoutParams generateLayoutParams() {
        SwanAppRectPosition swanAppRectPosition = this.position;
        int height = -1;
        int width = swanAppRectPosition != null ? swanAppRectPosition.getWidth() : -1;
        SwanAppRectPosition swanAppRectPosition2 = this.position;
        if (swanAppRectPosition2 != null) {
            height = swanAppRectPosition2.getHeight();
        }
        SwanAppRectPosition swanAppRectPosition3 = this.position;
        int marginLeft = swanAppRectPosition3 != null ? swanAppRectPosition3.getLeft() : 0;
        SwanAppRectPosition swanAppRectPosition4 = this.position;
        int marginTop = swanAppRectPosition4 != null ? swanAppRectPosition4.getTop() : 0;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
        params.setMargins(marginLeft, marginTop, 0, 0);
        return params;
    }

    /* access modifiers changed from: protected */
    public final float getFloat(JSONObject json, String name, float defaultValue) {
        if (json == null) {
            return defaultValue;
        }
        return (float) json.optDouble(name, (double) defaultValue);
    }
}
