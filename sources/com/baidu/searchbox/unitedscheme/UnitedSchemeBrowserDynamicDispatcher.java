package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class UnitedSchemeBrowserDynamicDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_TYPE_CLOSE_WINDOW = "closeWindow";
    private static final String ACTION_TYPE_IMAGE_SEARCH_TIP = "imagesearchtip";
    private static final String ACTION_TYPE_TCSTATISTIC = "setTcStatisticData";
    private static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    private static final String JS_NATIVE_LOG_TAG = "jsnative";
    private static final String KEY_CALLBACK = "callback";
    public static final String MODULE_BROWSER = "browser";
    private static final String PARAMS_KEY = "params";
    private static final String TAG = UnitedSchemeBrowserDynamicDispatcher.class.getSimpleName();
    private CloseWindowCallback callBack;
    private ImageSearchTipCallback mImageSearchTipCallback;
    private UnitedSchemeBrowserAdapter mUnitedSchemeBrowserAdapter = null;

    public interface CloseWindowCallback {
        void onClose();
    }

    public interface ImageSearchTipCallback {
        boolean canShowImageSearchTip();

        Point getImageSearchLocation();

        void syncImageSearchTipState(String str);
    }

    public UnitedSchemeBrowserDynamicDispatcher(CloseWindowCallback callBack2) {
        this.callBack = callBack2;
    }

    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        if (DEBUG) {
            try {
                Log.i(JS_NATIVE_LOG_TAG, "action " + entity.getPath(false));
                Log.i(JS_NATIVE_LOG_TAG, "uri " + entity.getUri());
                Log.i(JS_NATIVE_LOG_TAG, "param " + entity.getParams().toString());
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
        String action = entity.getPath(false);
        if (entity.isOnlyVerify()) {
            return true;
        }
        if (TextUtils.equals("closeWindow", action)) {
            handleCloseWindow();
            entity.result = UnitedSchemeUtility.callCallback(handler, entity, 0);
            return true;
        } else if (TextUtils.equals(ACTION_TYPE_IMAGE_SEARCH_TIP, action)) {
            return handleImageSearchTip(context, entity, handler);
        } else {
            if (TextUtils.equals(ACTION_TYPE_TCSTATISTIC, action)) {
                return handleTcStatistic(context, entity, handler);
            }
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "unkown action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is unkown");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return null;
    }

    private boolean handleCloseWindow() {
        CloseWindowCallback closeWindowCallback = this.callBack;
        if (closeWindowCallback != null) {
            closeWindowCallback.onClose();
            return true;
        } else if (!DEBUG) {
            return false;
        } else {
            Log.w(TAG, "Uri action is no handler");
            return false;
        }
    }

    public void setImageSearchTipCallback(ImageSearchTipCallback listener) {
        this.mImageSearchTipCallback = listener;
    }

    public void setUnitedSchemeBrowserAdapter(UnitedSchemeBrowserAdapter unitedSchemeBrowserAdapter) {
        this.mUnitedSchemeBrowserAdapter = unitedSchemeBrowserAdapter;
    }

    private boolean handleTcStatistic(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        boolean handled = false;
        if (this.mUnitedSchemeBrowserAdapter == null) {
            return false;
        }
        HashMap<String, String> params = entity.getParams();
        if (params != null) {
            handled = this.mUnitedSchemeBrowserAdapter.handleTcStatisticData(params.get("params"));
        }
        if (handled) {
            UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 0));
            entity.result = UnitedSchemeUtility.wrapCallbackParams(0);
            return true;
        }
        UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 101));
        return false;
    }

    private boolean handleImageSearchTip(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        ImageSearchTipCallback imageSearchTipCallback;
        ImageSearchTipCallback imageSearchTipCallback2;
        if (entity.isOnlyVerify()) {
            return true;
        }
        if (TextUtils.isEmpty(entity.getParam("callback")) || (imageSearchTipCallback2 = this.mImageSearchTipCallback) == null) {
            String params = entity.getParam("params");
            if (TextUtils.isEmpty(params) || (imageSearchTipCallback = this.mImageSearchTipCallback) == null) {
                entity.result = UnitedSchemeUtility.callCallback(handler, entity, 201);
                return false;
            }
            imageSearchTipCallback.syncImageSearchTipState(params);
            entity.result = UnitedSchemeUtility.callCallback(handler, entity, 0);
            return true;
        }
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(wrapCallbackData(this.mImageSearchTipCallback.canShowImageSearchTip(), imageSearchTipCallback2.getImageSearchLocation()), 0));
        return true;
    }

    private JSONObject wrapCallbackData(boolean show, Point point) {
        JSONObject result = new JSONObject();
        try {
            result.put("show", show ? 1 : 0);
            if (point != null) {
                result.put("x", point.x);
                result.put("y", point.y);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return result;
    }
}
