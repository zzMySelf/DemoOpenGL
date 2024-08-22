package com.baidu.searchbox.gamecore.web;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.base.utils.UiThreadUtil;
import com.baidu.searchbox.gamecore.base.tab.IGameViewPagerCallback;
import com.baidu.searchbox.lightbrowser.jsbridge.BaseJavaScriptInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class GameWebJavaScriptInterface extends BaseJavaScriptInterface {
    public static final String JS_INTERFACE_NAME = "Bdbox_android_gamecenter";
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_METHOD = "method";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_TAB_SWITCH_STATUS = "tabSwitchStatus";
    private static final String METHOD_SET_TAB_CHANGE_CALLBACK = "setTabChangeCallback";
    private static final String METHOD_SET_TAB_SWITCH_STATUS = "setTabSwitchStatus";
    private String mTabChangeJsCallback;
    private IGameViewPagerCallback mViewPagerCallback;

    public GameWebJavaScriptInterface(Context context) {
        super(context);
    }

    @JavascriptInterface
    public void onGameInvoke(String jsonParams) {
        try {
            JSONObject jsonObj = new JSONObject(jsonParams);
            String method = jsonObj.optString("method", "");
            String callback = jsonObj.optString("callback", "");
            JSONObject params = jsonObj.optJSONObject("params");
            if (method.equalsIgnoreCase(METHOD_SET_TAB_CHANGE_CALLBACK)) {
                setTabChangeCallback(params);
            } else if (method.equalsIgnoreCase(METHOD_SET_TAB_SWITCH_STATUS)) {
                setTabSwitchStatus(params);
            }
            jsCallback(callback, "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void jsCallback(final String callback, final String params) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                String str;
                if (!TextUtils.isEmpty(callback) && (str = params) != null) {
                    GameWebJavaScriptInterface.this.executeJavaScript(callback, str);
                }
            }
        });
    }

    public void setViewPagerCallback(IGameViewPagerCallback viewPagerCallback) {
        this.mViewPagerCallback = viewPagerCallback;
    }

    public void onWebViewVisible(boolean visible) {
        jsCallback(this.mTabChangeJsCallback, visible ? "1" : "0");
    }

    private void setTabChangeCallback(JSONObject params) {
        if (params != null) {
            this.mTabChangeJsCallback = params.optString("callback");
        }
    }

    public void setTabSwitchStatus(JSONObject params) {
        if (params != null) {
            boolean tabSwitchStatus = params.optBoolean(KEY_TAB_SWITCH_STATUS, true);
            IGameViewPagerCallback iGameViewPagerCallback = this.mViewPagerCallback;
            if (iGameViewPagerCallback != null) {
                iGameViewPagerCallback.setTabSwitchStatus(tabSwitchStatus);
            }
        }
    }
}
