package com.baidu.swan.apps.engine.context;

import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;

public class V8MainContext implements V8Context {
    private V8Engine mV8Engine;

    public V8MainContext(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void requireJsFile(String basePath, String jsFile) {
        this.mV8Engine.requireJSFile(basePath, jsFile);
    }

    public void destroyContext() {
        this.mV8Engine.destroyEngine((V8ExecuteCallback) null);
    }

    public void evaluateJavascript(String js) {
        evaluateJavascript(js, (ValueCallback<String>) null);
    }

    public void evaluateJavascript(String js, ValueCallback<String> resultCallback) {
        this.mV8Engine.evaluateJavascript(js, resultCallback, "mainContextEvaluate");
    }

    public void addJavascriptInterface(Object object, String name) {
        this.mV8Engine.addJavascriptInterface(object, name);
    }

    public void throwJSException(JSExceptionType type, String msg) {
        this.mV8Engine.throwJSException(type, msg);
    }
}
