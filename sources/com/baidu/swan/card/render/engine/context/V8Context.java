package com.baidu.swan.card.render.engine.context;

import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.JSExceptionType;

public interface V8Context {
    void addJavascriptInterface(Object obj, String str);

    void destroyContext();

    void evaluateJavascript(String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void requireJsFile(String str, String str2);

    void throwJSException(JSExceptionType jSExceptionType, String str);
}
