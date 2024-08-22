package com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js;

import com.pichillilorenzo.flutter_inappwebview.types.ContentWorld;
import com.pichillilorenzo.flutter_inappwebview.types.PluginScript;
import com.pichillilorenzo.flutter_inappwebview.types.UserScriptInjectionTime;

public class OnWindowFocusEventJS {
    public static final PluginScript ON_WINDOW_FOCUS_EVENT_JS_PLUGIN_SCRIPT = new PluginScript(ON_WINDOW_FOCUS_EVENT_JS_PLUGIN_SCRIPT_GROUP_NAME, ON_WINDOW_FOCUS_EVENT_JS_SOURCE, UserScriptInjectionTime.AT_DOCUMENT_START, (ContentWorld) null, false);
    public static final String ON_WINDOW_FOCUS_EVENT_JS_PLUGIN_SCRIPT_GROUP_NAME = "IN_APP_WEBVIEW_ON_WINDOW_FOCUS_EVENT_JS_PLUGIN_SCRIPT";
    public static final String ON_WINDOW_FOCUS_EVENT_JS_SOURCE = "(function(){  window.addEventListener('focus', function(e) {    window.flutter_inappwebview.callHandler('onWindowFocus');  });})();";
}
