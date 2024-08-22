package com.baidu.swan.apps.engine.console;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.ioc.SwanGameRuntime;
import com.baidu.swan.apps.statistic.SwanAppV8StabilityHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class V8JSExceptionLogcatImpl implements V8Engine.JavaScriptExceptionDelegate {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "V8Exception";
    private AiBaseV8Engine mEngine;
    private String mExceptionMsg = "";

    public V8JSExceptionLogcatImpl(AiBaseV8Engine engine) {
        this.mEngine = engine;
    }

    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo != null) {
            String exceptionTrace = "";
            String exceptionMsg = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? exceptionTrace : v8ExceptionInfo.exceptionMsg;
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                exceptionTrace = v8ExceptionInfo.exceptionTrace;
            }
            Log.e(TAG, this.mEngine.getLogTag() + "msg: " + exceptionMsg + " ,stack: " + exceptionTrace);
            this.mEngine.console().error(exceptionMsg);
            if ((!TextUtils.isEmpty(exceptionMsg) || !TextUtils.isEmpty(exceptionTrace)) && !this.mExceptionMsg.equals(exceptionMsg)) {
                this.mExceptionMsg = exceptionMsg;
                forwardToErrorCallback(exceptionMsg, exceptionTrace);
                SwanGameRuntime.getSwanGameErrorManager().recordJsError(exceptionMsg + ";" + exceptionTrace);
                SwanAppV8StabilityHelper.handleV8Error(v8ExceptionInfo);
                SwanGameRuntime.getSwanGameCoreManager().setSurfaceViewJSError(v8ExceptionInfo);
            }
        }
    }

    private void forwardToErrorCallback(String exceptionMsg, String exceptionTrace) {
        if (this.mEngine.getGlobalObject() != null) {
            this.mEngine.getGlobalObject().dispatchEvent(new ExceptionEventBuilder().msg(exceptionMsg + "\n" + exceptionTrace).stack("").build());
        }
    }

    public static class ExceptionEventBuilder {
        private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
        private static final String EVENT_TYPE = "error";
        private JSEvent mEvent = new JSEvent("error");
        private String mExceptionMsg;
        private String mExceptionStack;

        public ExceptionEventBuilder msg(String exceptionMsg) {
            this.mExceptionMsg = exceptionMsg;
            return this;
        }

        public ExceptionEventBuilder stack(String stack) {
            this.mExceptionStack = stack;
            return this;
        }

        public JSEvent build() {
            JSONObject object = new JSONObject();
            try {
                object.put("message", this.mExceptionMsg);
                object.put("stack", this.mExceptionStack);
            } catch (JSONException jsonEx) {
                if (DEBUG) {
                    Log.e(V8JSExceptionLogcatImpl.TAG, Log.getStackTraceString(jsonEx));
                }
            }
            if (object.length() > 0) {
                this.mEvent.data = object;
            }
            return this.mEvent;
        }
    }
}
