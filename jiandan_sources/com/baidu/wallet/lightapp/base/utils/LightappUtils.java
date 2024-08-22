package com.baidu.wallet.lightapp.base.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.utils.UUIDGenerator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class LightappUtils {
    public static String assembleFailResult(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", Base64Utils.encodeToString(str.getBytes()));
        return assembleResult((Map<String, Object>) hashMap, false);
    }

    public static String assembleFailResultWithErrCode(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", str);
        hashMap.put("des", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("data", hashMap.toString());
        return assembleResult((Map<String, Object>) hashMap2, false);
    }

    public static String assembleResult(Map<String, Object> map, boolean z) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("cnt", new JSONObject(map));
        } catch (JSONException e) {
            LogUtil.e("LightappUtils", SapiUtils.KEY_QR_LOGIN_ERROR, e);
        }
        return jSONObject.toString();
    }

    public static void executeJsFunction(LightappBrowserWebView lightappBrowserWebView, String str, String str2) {
        if (lightappBrowserWebView != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    lightappBrowserWebView.evaluateJavascript(sb.toString(), (ValueCallback) null);
                } else {
                    lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
                }
                com.baidu.apollon.utils.LogUtil.d("LightappUtils", "executeJsFunction，fun：" + sb);
            } catch (Throwable th2) {
                com.baidu.apollon.utils.LogUtil.d("LightappUtils", "executeJsFunction, error:" + th2.getMessage());
            }
        }
    }

    public static String formatJSONForWebViewCallback(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(IStringUtil.WINDOWS_FOLDER_SEPARATOR)) {
                str = str.replaceAll("\\\\", "\\\\\\\\");
            }
            if (str.contains("'")) {
                str = str.replaceAll("'", "\\\\'");
            }
            if (str.contains("\"")) {
                str = str.replaceAll("\"", "\\\\\"");
            }
            if (str.contains("\r\n")) {
                str = str.replaceAll("\r\n", "\\u000d\\u000a");
            }
            if (str.contains(StringUtils.LF)) {
                str = str.replaceAll(StringUtils.LF, "\\u000a");
            }
            com.baidu.apollon.utils.LogUtil.d(str);
        }
        return str;
    }

    public static void insertAppSessionIdJs(WebView webView) {
        if ("walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) && "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID) && webView != null) {
            String str = "javascript:window.appSessionId = " + "'" + UUIDGenerator.getCurrentUUID() + "'";
            com.baidu.apollon.utils.LogUtil.d("LightappUtils", "挂载JS = " + str);
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript(str, new ValueCallback<String>() {
                    /* renamed from: a */
                    public void onReceiveValue(String str) {
                        com.baidu.apollon.utils.LogUtil.d("LightappUtils", "挂载JS 结果 value = " + str);
                    }
                });
            } else {
                webView.loadUrl(str);
            }
        }
    }

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, String str4) {
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", str2);
            hashMap.put("des", str3);
            iLightappInvokerCallback.onResult(1, assembleResult((Map<String, Object>) hashMap, false));
        }
    }

    public static int parseJsonInt(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(new JSONObject(str).getString(str2));
            } catch (JSONException e) {
                com.baidu.apollon.utils.LogUtil.d("LightappUtils", e.getMessage());
            } catch (Throwable th2) {
                com.baidu.apollon.utils.LogUtil.d("LightappUtils", th2.getMessage());
            }
        }
        return -1;
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }

    public static void onError(ILightappInvokerCallback iLightappInvokerCallback, String str, String str2, String str3, Collection<String> collection) {
        if (iLightappInvokerCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", str);
            hashMap.put("des", str2);
            iLightappInvokerCallback.onResult(1, assembleResult((Map<String, Object>) hashMap, false));
        }
    }

    public static String assembleResult(int i2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", i2);
            jSONObject2.put("cnt", jSONObject);
        } catch (JSONException e) {
            LogUtil.e("LightappUtils", SapiUtils.KEY_QR_LOGIN_ERROR, e);
        }
        return jSONObject2.toString();
    }
}
