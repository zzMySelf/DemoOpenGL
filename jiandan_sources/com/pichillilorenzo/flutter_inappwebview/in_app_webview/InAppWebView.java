package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebViewCompat;
import com.alipay.sdk.m.u.i;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidubce.services.vod.VodClient;
import com.dlife.ctaccountapi.x;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.JavaScriptBridgeInterface;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker;
import com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerAction;
import com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler;
import com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTrigger;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.InterceptAjaxRequestJS;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.InterceptFetchRequestJS;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.OnLoadResourceJS;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.PluginScriptsUtil;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview.types.ContentWorld;
import com.pichillilorenzo.flutter_inappwebview.types.DownloadStartRequest;
import com.pichillilorenzo.flutter_inappwebview.types.HitTestResult;
import com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview.types.PluginScript;
import com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview.types.UserContentController;
import com.pichillilorenzo.flutter_inappwebview.types.UserScript;
import com.pichillilorenzo.flutter_inappwebview.types.WebMessage;
import com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel;
import com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public final class InAppWebView extends InputAwareWebView implements InAppWebViewInterface {
    public static final String LOG_TAG = "InAppWebView";
    public static Handler mHandler = new Handler();
    public Map<String, ValueCallback<String>> callAsyncJavaScriptCallbacks = new HashMap();
    public MethodChannel channel;
    public Runnable checkContextMenuShouldBeClosedTask;
    public Runnable checkScrollStoppedTask;
    public ContentBlockerHandler contentBlockerHandler = new ContentBlockerHandler();
    @Nullable
    public Map<String, Object> contextMenu = null;
    public Point contextMenuPoint = new Point(0, 0);
    public Map<String, ValueCallback<String>> evaluateJavaScriptContentWorldCallbacks = new HashMap();
    @Nullable
    public LinearLayout floatingContextMenu = null;
    @Nullable
    public GestureDetector gestureDetector = null;
    public OkHttpClient httpClient;
    public Object id;
    @Nullable
    public InAppBrowserDelegate inAppBrowserDelegate;
    public InAppWebViewChromeClient inAppWebViewChromeClient;
    public InAppWebViewClient inAppWebViewClient;
    @Nullable
    public InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient;
    public int initialPositionScrollStoppedTask;
    public boolean isLoading = false;
    public JavaScriptBridgeInterface javaScriptBridgeInterface;
    public Point lastTouch = new Point(0, 0);
    public Handler mainLooperHandler = new Handler(getWebViewLooper());
    public int newCheckContextMenuShouldBeClosedTaskTask = 100;
    public int newCheckScrollStoppedTask = 100;
    public int okHttpClientCacheSize = 10485760;
    public InAppWebViewOptions options;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;
    public Pattern regexToCancelSubFramesLoadingCompiled;
    public UserContentController userContentController = new UserContentController();
    public Map<String, WebMessageChannel> webMessageChannels = new HashMap();
    public List<WebMessageListener> webMessageListeners = new ArrayList();
    @Nullable
    public Integer windowId;
    public float zoomScale = 1.0f;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$19  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass19 {
        public static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$PreferredContentModeOptionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType[] r0 = com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$PreferredContentModeOptionType = r0
                com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType r1 = com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType.DESKTOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$PreferredContentModeOptionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType r1 = com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType.MOBILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$PreferredContentModeOptionType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType r1 = com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType.RECOMMENDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView.AnonymousClass19.<clinit>():void");
        }
    }

    public class DownloadStartListener implements DownloadListener {
        public DownloadStartListener() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            InAppWebView.this.channel.invokeMethod("onDownloadStartRequest", new DownloadStartRequest(str, str2, str3, str4, j, URLUtil.guessFileName(str, str3, str4), (String) null).toMap());
        }
    }

    public InAppWebView(Context context) {
        super(context);
    }

    public InAppWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InAppWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public InAppWebView(Context context, InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, MethodChannel methodChannel, Object obj, @Nullable Integer num, InAppWebViewOptions inAppWebViewOptions, @Nullable Map<String, Object> map, View view, List<UserScript> list) {
        super(context, view, inAppWebViewOptions.useHybridComposition);
        Activity activity;
        this.plugin = inAppWebViewFlutterPlugin;
        this.channel = methodChannel;
        this.id = obj;
        this.windowId = num;
        this.options = inAppWebViewOptions;
        this.contextMenu = map;
        this.userContentController.addUserOnlyScripts(list);
        if (inAppWebViewFlutterPlugin != null && (activity = inAppWebViewFlutterPlugin.activity) != null) {
            activity.registerForContextMenu(this);
        }
    }

    private void clearCookies() {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(new ValueCallback<Boolean>() {
                public void onReceiveValue(Boolean bool) {
                }
            });
        } else {
            CookieManager.getInstance().removeAllCookie();
        }
    }

    private void sendOnCreateContextMenuEvent() {
        this.channel.invokeMethod("onCreateContextMenu", HitTestResult.fromWebViewHitTestResult(getHitTestResult()).toMap());
    }

    public void addWebMessageListener(@NonNull WebMessageListener webMessageListener) {
        WebViewCompat.addWebMessageListener(this, webMessageListener.jsObjectName, webMessageListener.allowedOriginRules, webMessageListener.listener);
        this.webMessageListeners.add(webMessageListener);
    }

    @RequiresApi(api = 19)
    public void adjustFloatingContextMenuPosition() {
        evaluateJavascript("(function(){  var selection = window.getSelection();  var rangeY = null;  if (selection != null && selection.rangeCount > 0) {    var range = selection.getRangeAt(0);    var clientRect = range.getClientRects();    if (clientRect.length > 0) {      rangeY = clientRect[0].y;    } else if (document.activeElement != null && document.activeElement.tagName.toLowerCase() !== 'iframe') {      var boundingClientRect = document.activeElement.getBoundingClientRect();      rangeY = boundingClientRect.y;    }  }  return rangeY;})();", new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                if (InAppWebView.this.floatingContextMenu == null) {
                    return;
                }
                if (str == null || str.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                    InAppWebView.this.floatingContextMenu.setVisibility(0);
                    InAppWebView.this.floatingContextMenu.animate().alpha(1.0f).setDuration(100).setListener((Animator.AnimatorListener) null);
                    InAppWebView inAppWebView = InAppWebView.this;
                    inAppWebView.onFloatingActionGlobalLayout(inAppWebView.contextMenuPoint.x, InAppWebView.this.contextMenuPoint.y);
                    return;
                }
                int i2 = InAppWebView.this.contextMenuPoint.x;
                int parseFloat = (int) (((double) (Float.parseFloat(str) * Util.getPixelDensity(InAppWebView.this.getContext()))) + (((double) InAppWebView.this.floatingContextMenu.getHeight()) / 3.5d));
                InAppWebView.this.contextMenuPoint.y = parseFloat;
                InAppWebView.this.onFloatingActionGlobalLayout(i2, parseFloat);
            }
        });
    }

    @RequiresApi(api = 21)
    public void callAsyncJavaScript(String str, Map<String, Object> map, @Nullable ContentWorld contentWorld, @Nullable ValueCallback<String> valueCallback) {
        String uuid = UUID.randomUUID().toString();
        if (valueCallback != null) {
            this.callAsyncJavaScriptCallbacks.put(uuid, valueCallback);
        }
        Iterator<String> keys = new JSONObject(map).keys();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (keys.hasNext()) {
            String next = keys.next();
            arrayList.add(next);
            arrayList2.add("obj." + next);
        }
        String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, arrayList);
        String join2 = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, arrayList2);
        evaluateJavascript(this.userContentController.generateCodeForScriptEvaluation(PluginScriptsUtil.CALL_ASYNC_JAVA_SCRIPT_WRAPPER_JS_SOURCE.replace(PluginScriptsUtil.VAR_FUNCTION_ARGUMENT_NAMES, join).replace(PluginScriptsUtil.VAR_FUNCTION_ARGUMENT_VALUES, join2).replace(PluginScriptsUtil.VAR_FUNCTION_ARGUMENTS_OBJ, Util.JSONStringify(map)).replace(PluginScriptsUtil.VAR_FUNCTION_BODY, str).replace(PluginScriptsUtil.VAR_RESULT_UUID, uuid).replace(PluginScriptsUtil.VAR_RESULT_UUID, uuid), contentWorld), (ValueCallback) null);
    }

    public boolean canScrollHorizontally() {
        return computeHorizontalScrollRange() > computeHorizontalScrollExtent();
    }

    public boolean canScrollVertically() {
        return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }

    public void clearAllCache() {
        clearCache(true);
        clearCookies();
        clearFormData();
        WebStorage.getInstance().deleteAllData();
    }

    public WebMessageChannel createCompatWebMessageChannel() {
        String uuid = UUID.randomUUID().toString();
        WebMessageChannel webMessageChannel = new WebMessageChannel(uuid, this);
        this.webMessageChannels.put(uuid, webMessageChannel);
        return webMessageChannel;
    }

    public WebMessageChannel createWebMessageChannel(ValueCallback<WebMessageChannel> valueCallback) {
        WebMessageChannel createCompatWebMessageChannel = createCompatWebMessageChannel();
        valueCallback.onReceiveValue(createCompatWebMessageChannel);
        return createCompatWebMessageChannel;
    }

    public void destroy() {
        super.destroy();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void dispose() {
        Integer num = this.windowId;
        if (num != null) {
            InAppWebViewChromeClient.windowWebViewMessages.remove(num);
        }
        this.mainLooperHandler.removeCallbacksAndMessages((Object) null);
        mHandler.removeCallbacksAndMessages((Object) null);
        disposeWebMessageChannels();
        disposeWebMessageListeners();
        removeAllViews();
        Runnable runnable = this.checkContextMenuShouldBeClosedTask;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.checkScrollStoppedTask;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.callAsyncJavaScriptCallbacks.clear();
        this.evaluateJavaScriptContentWorldCallbacks.clear();
        this.inAppBrowserDelegate = null;
        this.inAppWebViewChromeClient = null;
        this.inAppWebViewClient = null;
        this.javaScriptBridgeInterface = null;
        this.inAppWebViewRenderProcessClient = null;
        this.plugin = null;
        super.dispose();
    }

    public void disposeWebMessageChannels() {
        for (WebMessageChannel dispose : this.webMessageChannels.values()) {
            dispose.dispose();
        }
        this.webMessageChannels.clear();
    }

    public void disposeWebMessageListeners() {
        for (WebMessageListener dispose : this.webMessageListeners) {
            dispose.dispose();
        }
        this.webMessageListeners.clear();
    }

    public void enablePluginScriptAtRuntime(final String str, final boolean z, final PluginScript pluginScript) {
        evaluateJavascript("window." + str, (ContentWorld) null, new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                if (str != null && !str.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                    InAppWebView.this.evaluateJavascript("window." + str + " = " + z + i.b, (ContentWorld) null, (ValueCallback<String>) null);
                    if (!z) {
                        InAppWebView.this.userContentController.removePluginScript(pluginScript);
                    }
                } else if (z) {
                    InAppWebView.this.evaluateJavascript(pluginScript.getSource(), (ContentWorld) null, (ValueCallback<String>) null);
                    InAppWebView.this.userContentController.addPluginScript(pluginScript);
                }
            }
        });
    }

    public void evaluateJavascript(String str, @Nullable ContentWorld contentWorld, @Nullable ValueCallback<String> valueCallback) {
        injectDeferredObject(str, contentWorld, (String) null, valueCallback);
    }

    public void getContentHeight(ValueCallback<Integer> valueCallback) {
        valueCallback.onReceiveValue(Integer.valueOf(getContentHeight()));
    }

    @Nullable
    public Map<String, Object> getContextMenu() {
        return this.contextMenu;
    }

    public HashMap<String, Object> getCopyBackForwardList() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        int size = copyBackForwardList.getSize();
        int currentIndex = copyBackForwardList.getCurrentIndex();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i2);
            HashMap hashMap = new HashMap();
            hashMap.put("originalUrl", itemAtIndex.getOriginalUrl());
            hashMap.put("title", itemAtIndex.getTitle());
            hashMap.put("url", itemAtIndex.getUrl());
            arrayList.add(hashMap);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("history", arrayList);
        hashMap2.put("currentIndex", Integer.valueOf(currentIndex));
        return hashMap2;
    }

    public void getHitTestResult(ValueCallback<HitTestResult> valueCallback) {
        valueCallback.onReceiveValue(HitTestResult.fromWebViewHitTestResult(getHitTestResult()));
    }

    @Nullable
    public InAppBrowserDelegate getInAppBrowserDelegate() {
        return this.inAppBrowserDelegate;
    }

    public Map<String, Object> getOptions() {
        InAppWebViewOptions inAppWebViewOptions = this.options;
        if (inAppWebViewOptions != null) {
            return inAppWebViewOptions.getRealOptions((InAppWebViewInterface) this);
        }
        return null;
    }

    @Nullable
    public InAppWebViewFlutterPlugin getPlugin() {
        return this.plugin;
    }

    @RequiresApi(api = 19)
    public void getSelectedText(final ValueCallback<String> valueCallback) {
        evaluateJavascript(PluginScriptsUtil.GET_SELECTED_TEXT_JS_SOURCE, new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                valueCallback.onReceiveValue((str == null || str.equalsIgnoreCase(StringUtil.NULL_STRING)) ? null : str.substring(1, str.length() - 1));
            }
        });
    }

    public UserContentController getUserContentController() {
        return this.userContentController;
    }

    public Map<String, WebMessageChannel> getWebMessageChannels() {
        return this.webMessageChannels;
    }

    public Looper getWebViewLooper() {
        return Build.VERSION.SDK_INT >= 28 ? super.getWebViewLooper() : Looper.getMainLooper();
    }

    public float getZoomScale() {
        return this.zoomScale;
    }

    public void getZoomScale(ValueCallback<Float> valueCallback) {
        valueCallback.onReceiveValue(Float.valueOf(this.zoomScale));
    }

    public void hideContextMenu() {
        removeView(this.floatingContextMenu);
        this.floatingContextMenu = null;
        onHideContextMenu();
    }

    public void injectCSSCode(String str) {
        injectDeferredObject(str, (ContentWorld) null, "(function(d) { var style = d.createElement('style'); style.innerHTML = %s; if (d.head != null) { d.head.appendChild(style); } })(document);", (ValueCallback<String>) null);
    }

    public void injectCSSFileFromUrl(String str, @Nullable Map<String, Object> map) {
        String str2;
        String str3;
        String str4 = "";
        if (map != null) {
            String str5 = (String) map.get("id");
            if (str5 != null) {
                str3 = str4 + " link.id = '" + str5.replaceAll("'", "\\\\'") + "'; ";
            } else {
                str3 = str4;
            }
            String str6 = (String) map.get(VodClient.PATH_MEDIA);
            if (str6 != null) {
                str3 = str3 + " link.media = '" + str6.replaceAll("'", "\\\\'") + "'; ";
            }
            String str7 = (String) map.get("crossOrigin");
            if (str7 != null) {
                str3 = str3 + " link.crossOrigin = '" + str7.replaceAll("'", "\\\\'") + "'; ";
            }
            String str8 = (String) map.get("integrity");
            if (str8 != null) {
                str3 = str3 + " link.integrity = '" + str8.replaceAll("'", "\\\\'") + "'; ";
            }
            String str9 = (String) map.get("referrerPolicy");
            if (str9 != null) {
                str3 = str3 + " link.referrerPolicy = '" + str9.replaceAll("'", "\\\\'") + "'; ";
            }
            Boolean bool = (Boolean) map.get("disabled");
            if (bool != null && bool.booleanValue()) {
                str3 = str3 + " link.disabled = true; ";
            }
            Boolean bool2 = (Boolean) map.get("alternate");
            if (bool2 != null && bool2.booleanValue()) {
                str4 = "alternate ";
            }
            String str10 = (String) map.get("title");
            if (str10 != null) {
                str2 = str3 + " link.title = '" + str10.replaceAll("'", "\\\\'") + "'; ";
            } else {
                str2 = str3;
            }
        } else {
            str2 = str4;
        }
        injectDeferredObject(str, (ContentWorld) null, "(function(d) { var link = d.createElement('link'); link.rel='" + str4 + "stylesheet'; link.type='text/css'; " + str2 + " link.href = %s; if (d.head != null) { d.head.appendChild(link); } })(document);", (ValueCallback<String>) null);
    }

    public void injectDeferredObject(String str, @Nullable ContentWorld contentWorld, String str2, @Nullable ValueCallback<String> valueCallback) {
        String str3;
        final String str4;
        final String uuid = (contentWorld == null || contentWorld.equals(ContentWorld.PAGE)) ? null : UUID.randomUUID().toString();
        if (str2 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            String jSONArray2 = jSONArray.toString();
            str3 = String.format(str2, new Object[]{jSONArray2.substring(1, jSONArray2.length() - 1)});
        } else {
            str3 = str;
        }
        if (uuid == null || valueCallback == null) {
            str4 = str3;
        } else {
            this.evaluateJavaScriptContentWorldCallbacks.put(uuid, valueCallback);
            str4 = Util.replaceAll(PluginScriptsUtil.EVALUATE_JAVASCRIPT_WITH_CONTENT_WORLD_WRAPPER_JS_SOURCE, PluginScriptsUtil.VAR_RANDOM_NAME, "_flutter_inappwebview_" + Math.round(Math.random() * 1000000.0d)).replace(PluginScriptsUtil.VAR_PLACEHOLDER_VALUE, UserContentController.escapeCode(str)).replace(PluginScriptsUtil.VAR_RESULT_UUID, uuid);
        }
        final ContentWorld contentWorld2 = contentWorld;
        final ValueCallback<String> valueCallback2 = valueCallback;
        this.mainLooperHandler.post(new Runnable() {
            public void run() {
                ValueCallback valueCallback;
                String generateCodeForScriptEvaluation = InAppWebView.this.userContentController.generateCodeForScriptEvaluation(str4, contentWorld2);
                if (Build.VERSION.SDK_INT < 19) {
                    InAppWebView inAppWebView = InAppWebView.this;
                    inAppWebView.loadUrl("javascript:" + generateCodeForScriptEvaluation.replaceAll("[\r\n]+", ""));
                    if (contentWorld2 != null && (valueCallback = valueCallback2) != null) {
                        valueCallback.onReceiveValue("");
                        return;
                    }
                    return;
                }
                InAppWebView.this.evaluateJavascript(generateCodeForScriptEvaluation, new ValueCallback<String>() {
                    public void onReceiveValue(String str) {
                        ValueCallback valueCallback;
                        AnonymousClass10 r0 = AnonymousClass10.this;
                        if (uuid == null && (valueCallback = valueCallback2) != null) {
                            valueCallback.onReceiveValue(str);
                        }
                    }
                });
            }
        });
    }

    public void injectJavascriptFileFromUrl(String str, @Nullable Map<String, Object> map) {
        String str2 = "";
        if (map != null) {
            String str3 = (String) map.get("type");
            if (str3 != null) {
                str2 = str2 + " script.type = '" + str3.replaceAll("'", "\\\\'") + "'; ";
            }
            String str4 = (String) map.get("id");
            if (str4 != null) {
                String replaceAll = str4.replaceAll("'", "\\\\'");
                str2 = ((str2 + " script.id = '" + replaceAll + "'; ") + " script.onload = function() {  if (window.flutter_inappwebview != null) {    window.flutter_inappwebview.callHandler('onInjectedScriptLoaded', '" + replaceAll + "');  }};") + " script.onerror = function() {  if (window.flutter_inappwebview != null) {    window.flutter_inappwebview.callHandler('onInjectedScriptError', '" + replaceAll + "');  }};";
            }
            Boolean bool = (Boolean) map.get("async");
            if (bool != null && bool.booleanValue()) {
                str2 = str2 + " script.async = true; ";
            }
            Boolean bool2 = (Boolean) map.get("defer");
            if (bool2 != null && bool2.booleanValue()) {
                str2 = str2 + " script.defer = true; ";
            }
            String str5 = (String) map.get("crossOrigin");
            if (str5 != null) {
                str2 = str2 + " script.crossOrigin = '" + str5.replaceAll("'", "\\\\'") + "'; ";
            }
            String str6 = (String) map.get("integrity");
            if (str6 != null) {
                str2 = str2 + " script.integrity = '" + str6.replaceAll("'", "\\\\'") + "'; ";
            }
            Boolean bool3 = (Boolean) map.get("noModule");
            if (bool3 != null && bool3.booleanValue()) {
                str2 = str2 + " script.noModule = true; ";
            }
            String str7 = (String) map.get("nonce");
            if (str7 != null) {
                str2 = str2 + " script.nonce = '" + str7.replaceAll("'", "\\\\'") + "'; ";
            }
            String str8 = (String) map.get("referrerPolicy");
            if (str8 != null) {
                str2 = str2 + " script.referrerPolicy = '" + str8.replaceAll("'", "\\\\'") + "'; ";
            }
        }
        injectDeferredObject(str, (ContentWorld) null, "(function(d) { var script = d.createElement('script'); " + str2 + " script.src = %s; if (d.body != null) { d.body.appendChild(script); } })(document);", (ValueCallback<String>) null);
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    @TargetApi(21)
    public void isSecureContext(final ValueCallback<Boolean> valueCallback) {
        evaluateJavascript("window.isSecureContext", new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                ValueCallback valueCallback;
                Boolean bool;
                if (str == null || str.isEmpty() || str.equalsIgnoreCase(StringUtil.NULL_STRING) || str.equalsIgnoreCase("false")) {
                    valueCallback = valueCallback;
                    bool = Boolean.FALSE;
                } else {
                    valueCallback = valueCallback;
                    bool = Boolean.TRUE;
                }
                valueCallback.onReceiveValue(bool);
            }
        });
    }

    public void loadFile(String str) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            loadUrl(Util.getUrlAsset(inAppWebViewFlutterPlugin, str));
        }
    }

    public void loadUrl(URLRequest uRLRequest) {
        String url = uRLRequest.getUrl();
        String method = uRLRequest.getMethod();
        if (method == null || !method.equals("POST")) {
            Map<String, String> headers = uRLRequest.getHeaders();
            if (headers != null) {
                loadUrl(url, headers);
            } else {
                loadUrl(url);
            }
        } else {
            postUrl(url, uRLRequest.getBody());
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu2) {
        super.onCreateContextMenu(contextMenu2);
        sendOnCreateContextMenuEvent();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        View view;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null && !this.options.useHybridComposition.booleanValue() && (view = this.containerView) != null) {
            view.getHandler().postDelayed(new Runnable() {
                public void run() {
                    InputMethodManager inputMethodManager = (InputMethodManager) InAppWebView.this.getContext().getSystemService("input_method");
                    if (InAppWebView.this.containerView != null && inputMethodManager != null && !inputMethodManager.isAcceptingText()) {
                        inputMethodManager.hideSoftInputFromWindow(InAppWebView.this.containerView.getWindowToken(), 2);
                    }
                }
            }, 128);
        }
        return onCreateInputConnection;
    }

    public void onFloatingActionGlobalLayout(int i2, int i3) {
        int width = getWidth();
        getHeight();
        int width2 = this.floatingContextMenu.getWidth();
        int height = this.floatingContextMenu.getHeight();
        int i4 = i2 - (width2 / 2);
        if (i4 < 0) {
            i4 = 0;
        } else if (i4 + width2 > width) {
            i4 = width - width2;
        }
        float f = ((float) i3) - (((float) height) * 1.5f);
        if (f < 0.0f) {
            f = (float) (i3 + height);
        }
        updateViewLayout(this.floatingContextMenu, new AbsoluteLayout.LayoutParams(-2, -2, i4, ((int) f) + getScrollY()));
        this.mainLooperHandler.post(new Runnable() {
            public void run() {
                LinearLayout linearLayout = InAppWebView.this.floatingContextMenu;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    InAppWebView.this.floatingContextMenu.animate().alpha(1.0f).setDuration(100).setListener((Animator.AnimatorListener) null);
                }
            }
        });
    }

    public void onHideContextMenu() {
        this.channel.invokeMethod("onHideContextMenu", new HashMap());
    }

    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
        boolean z3 = true;
        boolean z4 = canScrollHorizontally() && z;
        if (!canScrollVertically() || !z2) {
            z3 = false;
        }
        ViewParent parent = getParent();
        if ((parent instanceof PullToRefreshLayout) && z3 && i3 <= 10) {
            PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) parent;
            setOverScrollMode(2);
            pullToRefreshLayout.setEnabled(pullToRefreshLayout.options.enabled.booleanValue());
            setOverScrollMode(this.options.overScrollMode.intValue());
        }
        if (z4 || z3) {
            HashMap hashMap = new HashMap();
            hashMap.put(x.a, Integer.valueOf(i2));
            hashMap.put("y", Integer.valueOf(i3));
            hashMap.put("clampedX", Boolean.valueOf(z4));
            hashMap.put("clampedY", Boolean.valueOf(z3));
            this.channel.invokeMethod("onOverScrolled", hashMap);
        }
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        LinearLayout linearLayout = this.floatingContextMenu;
        if (linearLayout != null) {
            linearLayout.setAlpha(0.0f);
            this.floatingContextMenu.setVisibility(8);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(x.a, Integer.valueOf(i2));
        hashMap.put("y", Integer.valueOf(i3));
        this.channel.invokeMethod("onScrollChanged", hashMap);
    }

    public void onScrollStopped() {
        if (this.floatingContextMenu != null && Build.VERSION.SDK_INT >= 19) {
            adjustFloatingContextMenuPosition();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.lastTouch = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        ViewParent parent = getParent();
        if (parent instanceof PullToRefreshLayout) {
            PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) parent;
            if (motionEvent.getActionMasked() == 0) {
                pullToRefreshLayout.setEnabled(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void postWebMessage(WebMessage webMessage, Uri uri, ValueCallback<String> valueCallback) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0533 A[LOOP:0: B:159:0x052d->B:161:0x0533, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x033a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepare() {
        /*
            r7 = this;
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.newBuilder()
            okhttp3.OkHttpClient r0 = r0.build()
            r7.httpClient = r0
            com.pichillilorenzo.flutter_inappwebview.JavaScriptBridgeInterface r0 = new com.pichillilorenzo.flutter_inappwebview.JavaScriptBridgeInterface
            r0.<init>(r7)
            r7.javaScriptBridgeInterface = r0
            java.lang.String r1 = "flutter_inappwebview"
            r7.addJavascriptInterface(r0, r1)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient
            com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin r1 = r7.plugin
            io.flutter.plugin.common.MethodChannel r2 = r7.channel
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r3 = r7.inAppBrowserDelegate
            r0.<init>(r1, r2, r3)
            r7.inAppWebViewChromeClient = r0
            r7.setWebChromeClient(r0)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient
            io.flutter.plugin.common.MethodChannel r1 = r7.channel
            com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate r2 = r7.inAppBrowserDelegate
            r0.<init>(r1, r2)
            r7.inAppWebViewClient = r0
            r7.setWebViewClient(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0053
            java.lang.String r0 = "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"
            boolean r0 = androidx.webkit.WebViewFeature.isFeatureSupported(r0)
            if (r0 == 0) goto L_0x0053
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewRenderProcessClient r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewRenderProcessClient
            io.flutter.plugin.common.MethodChannel r2 = r7.channel
            r0.<init>(r2)
            r7.inAppWebViewRenderProcessClient = r0
            androidx.webkit.WebViewCompat.setWebViewRenderProcessClient(r7, r0)
        L_0x0053:
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.PromisePolyfillJS.PROMISE_POLYFILL_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS.JAVASCRIPT_BRIDGE_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.ConsoleLogJS.CONSOLE_LOG_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.PrintJS.PRINT_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.OnWindowBlurEventJS.ON_WINDOW_BLUR_EVENT_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.OnWindowFocusEventJS.ON_WINDOW_FOCUS_EVENT_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useShouldInterceptAjaxRequest
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008e
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.InterceptAjaxRequestJS.INTERCEPT_AJAX_REQUEST_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
        L_0x008e:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useShouldInterceptFetchRequest
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x009f
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.InterceptFetchRequestJS.INTERCEPT_FETCH_REQUEST_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
        L_0x009f:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useOnLoadResource
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00b0
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.OnLoadResourceJS.ON_LOAD_RESOURCE_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
        L_0x00b0:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useHybridComposition
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00c1
            com.pichillilorenzo.flutter_inappwebview.types.UserContentController r0 = r7.userContentController
            com.pichillilorenzo.flutter_inappwebview.types.PluginScript r2 = com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.PluginScriptsUtil.CHECK_GLOBAL_KEY_DOWN_EVENT_TO_HIDE_CONTEXT_MENU_JS_PLUGIN_SCRIPT
            r0.addPluginScript(r2)
        L_0x00c1:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useOnDownloadStart
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00d3
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$DownloadStartListener r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$DownloadStartListener
            r0.<init>()
            r7.setDownloadListener(r0)
        L_0x00d3:
            android.webkit.WebSettings r0 = r7.getSettings()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.javaScriptEnabled
            boolean r2 = r2.booleanValue()
            r0.setJavaScriptEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.javaScriptCanOpenWindowsAutomatically
            boolean r2 = r2.booleanValue()
            r0.setJavaScriptCanOpenWindowsAutomatically(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.builtInZoomControls
            boolean r2 = r2.booleanValue()
            r0.setBuiltInZoomControls(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.displayZoomControls
            boolean r2 = r2.booleanValue()
            r0.setDisplayZoomControls(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.supportMultipleWindows
            boolean r2 = r2.booleanValue()
            r0.setSupportMultipleWindows(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x011f
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.safeBrowsingEnabled
            boolean r2 = r2.booleanValue()
            r0.setSafeBrowsingEnabled(r2)
        L_0x011f:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.mediaPlaybackRequiresUserGesture
            boolean r2 = r2.booleanValue()
            r0.setMediaPlaybackRequiresUserGesture(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.databaseEnabled
            boolean r2 = r2.booleanValue()
            r0.setDatabaseEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.domStorageEnabled
            boolean r2 = r2.booleanValue()
            r0.setDomStorageEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.userAgent
            r4 = 17
            if (r2 == 0) goto L_0x0153
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0153
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.userAgent
            goto L_0x015f
        L_0x0153:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r4) goto L_0x0162
            android.content.Context r2 = r7.getContext()
            java.lang.String r2 = android.webkit.WebSettings.getDefaultUserAgent(r2)
        L_0x015f:
            r0.setUserAgentString(r2)
        L_0x0162:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.applicationNameForUserAgent
            if (r2 == 0) goto L_0x01a6
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x01a6
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r4) goto L_0x01a6
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.userAgent
            if (r2 == 0) goto L_0x0183
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0183
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.userAgent
            goto L_0x018b
        L_0x0183:
            android.content.Context r2 = r7.getContext()
            java.lang.String r2 = android.webkit.WebSettings.getDefaultUserAgent(r2)
        L_0x018b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = " "
            r4.append(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.applicationNameForUserAgent
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.setUserAgentString(r2)
        L_0x01a6:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.clearCache
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x01b4
            r7.clearAllCache()
            goto L_0x01c5
        L_0x01b4:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.clearSessionCache
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x01c5
            android.webkit.CookieManager r2 = android.webkit.CookieManager.getInstance()
            r2.removeSessionCookie()
        L_0x01c5:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r2 < r4) goto L_0x01da
            android.webkit.CookieManager r2 = android.webkit.CookieManager.getInstance()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r5 = r7.options
            java.lang.Boolean r5 = r5.thirdPartyCookiesEnabled
            boolean r5 = r5.booleanValue()
            r2.setAcceptThirdPartyCookies(r7, r5)
        L_0x01da:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.loadWithOverviewMode
            boolean r2 = r2.booleanValue()
            r0.setLoadWithOverviewMode(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.useWideViewPort
            boolean r2 = r2.booleanValue()
            r0.setUseWideViewPort(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.supportZoom
            boolean r2 = r2.booleanValue()
            r0.setSupportZoom(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.textZoom
            int r2 = r2.intValue()
            r0.setTextZoom(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.disableVerticalScroll
            boolean r2 = r2.booleanValue()
            r5 = 0
            r6 = 1
            if (r2 != 0) goto L_0x021e
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.verticalScrollBarEnabled
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x021e
            r2 = 1
            goto L_0x021f
        L_0x021e:
            r2 = 0
        L_0x021f:
            r7.setVerticalScrollBarEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.disableHorizontalScroll
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0238
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.horizontalScrollBarEnabled
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0238
            r2 = 1
            goto L_0x0239
        L_0x0238:
            r2 = 0
        L_0x0239:
            r7.setHorizontalScrollBarEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.transparentBackground
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0249
            r7.setBackgroundColor(r5)
        L_0x0249:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r4) goto L_0x025a
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.mixedContentMode
            if (r2 == 0) goto L_0x025a
            int r2 = r2.intValue()
            r0.setMixedContentMode(r2)
        L_0x025a:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.allowContentAccess
            boolean r2 = r2.booleanValue()
            r0.setAllowContentAccess(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.allowFileAccess
            boolean r2 = r2.booleanValue()
            r0.setAllowFileAccess(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.allowFileAccessFromFileURLs
            boolean r2 = r2.booleanValue()
            r0.setAllowFileAccessFromFileURLs(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.allowUniversalAccessFromFileURLs
            boolean r2 = r2.booleanValue()
            r0.setAllowUniversalAccessFromFileURLs(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.cacheEnabled
            boolean r2 = r2.booleanValue()
            r7.setCacheEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.appCachePath
            if (r2 == 0) goto L_0x02ae
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02ae
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.cacheEnabled
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x02ae
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.appCachePath
            r0.setAppCachePath(r2)
        L_0x02ae:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.blockNetworkImage
            boolean r2 = r2.booleanValue()
            r0.setBlockNetworkImage(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.blockNetworkLoads
            boolean r2 = r2.booleanValue()
            r0.setBlockNetworkLoads(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.cacheMode
            if (r2 == 0) goto L_0x02d1
            int r2 = r2.intValue()
            r0.setCacheMode(r2)
        L_0x02d1:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.cursiveFontFamily
            r0.setCursiveFontFamily(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.defaultFixedFontSize
            int r2 = r2.intValue()
            r0.setDefaultFixedFontSize(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.defaultFontSize
            int r2 = r2.intValue()
            r0.setDefaultFontSize(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.defaultTextEncodingName
            r0.setDefaultTextEncodingName(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r2 < r4) goto L_0x0308
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.disabledActionModeMenuItems
            if (r2 == 0) goto L_0x0308
            int r2 = r2.intValue()
            r0.setDisabledActionModeMenuItems(r2)
        L_0x0308:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.fantasyFontFamily
            r0.setFantasyFontFamily(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.fixedFontFamily
            r0.setFixedFontFamily(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x0327
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.forceDark
            if (r2 == 0) goto L_0x0327
            int r2 = r2.intValue()
            r0.setForceDark(r2)
        L_0x0327:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.geolocationEnabled
            boolean r2 = r2.booleanValue()
            r0.setGeolocationEnabled(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            android.webkit.WebSettings$LayoutAlgorithm r2 = r2.layoutAlgorithm
            r4 = 19
            if (r2 == 0) goto L_0x034a
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r4) goto L_0x0343
            android.webkit.WebSettings$LayoutAlgorithm r5 = android.webkit.WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
            r2.equals(r5)
        L_0x0343:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            android.webkit.WebSettings$LayoutAlgorithm r2 = r2.layoutAlgorithm
            r0.setLayoutAlgorithm(r2)
        L_0x034a:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.loadsImagesAutomatically
            boolean r2 = r2.booleanValue()
            r0.setLoadsImagesAutomatically(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.minimumFontSize
            int r2 = r2.intValue()
            r0.setMinimumFontSize(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.minimumLogicalFontSize
            int r2 = r2.intValue()
            r0.setMinimumLogicalFontSize(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.initialScale
            int r2 = r2.intValue()
            r7.setInitialScale(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.needInitialFocus
            boolean r2 = r2.booleanValue()
            r0.setNeedInitialFocus(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r2 < r5) goto L_0x0392
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.offscreenPreRaster
            boolean r2 = r2.booleanValue()
            r0.setOffscreenPreRaster(r2)
        L_0x0392:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.sansSerifFontFamily
            r0.setSansSerifFontFamily(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.serifFontFamily
            r0.setSerifFontFamily(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.String r2 = r2.standardFontFamily
            r0.setStandardFontFamily(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Integer r2 = r2.preferredContentMode
            if (r2 == 0) goto L_0x03bc
            int r2 = r2.intValue()
            com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType r5 = com.pichillilorenzo.flutter_inappwebview.types.PreferredContentModeOptionType.DESKTOP
            int r5 = r5.toValue()
            if (r2 != r5) goto L_0x03bc
            r7.setDesktopMode(r6)
        L_0x03bc:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.lang.Boolean r2 = r2.saveFormData
            boolean r2 = r2.booleanValue()
            r0.setSaveFormData(r2)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.incognito
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x03d4
            r7.setIncognito(r6)
        L_0x03d4:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.hardwareAcceleration
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L_0x03e4
            r0 = 2
            r7.setLayerType(r0, r2)
            goto L_0x03e7
        L_0x03e4:
            r7.setLayerType(r6, r2)
        L_0x03e7:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.String r0 = r0.regexToCancelSubFramesLoading
            if (r0 == 0) goto L_0x03f3
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r7.regexToCancelSubFramesLoadingCompiled = r0
        L_0x03f3:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Integer r0 = r0.scrollBarStyle
            int r0 = r0.intValue()
            r7.setScrollBarStyle(r0)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Integer r2 = r0.scrollBarDefaultDelayBeforeFade
            if (r2 == 0) goto L_0x040c
            int r0 = r2.intValue()
            r7.setScrollBarDefaultDelayBeforeFade(r0)
            goto L_0x0416
        L_0x040c:
            int r2 = r7.getScrollBarDefaultDelayBeforeFade()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.scrollBarDefaultDelayBeforeFade = r2
        L_0x0416:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.scrollbarFadingEnabled
            boolean r0 = r0.booleanValue()
            r7.setScrollbarFadingEnabled(r0)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Integer r2 = r0.scrollBarFadeDuration
            if (r2 == 0) goto L_0x042f
            int r0 = r2.intValue()
            r7.setScrollBarFadeDuration(r0)
            goto L_0x0439
        L_0x042f:
            int r2 = r7.getScrollBarFadeDuration()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.scrollBarFadeDuration = r2
        L_0x0439:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Integer r0 = r0.verticalScrollbarPosition
            int r0 = r0.intValue()
            r7.setVerticalScrollbarPosition(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x04a0
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.String r0 = r0.verticalScrollbarThumbColor
            if (r0 == 0) goto L_0x045e
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r1 = r7.options
            java.lang.String r1 = r1.verticalScrollbarThumbColor
            int r1 = android.graphics.Color.parseColor(r1)
            r0.<init>(r1)
            r7.setVerticalScrollbarThumbDrawable(r0)
        L_0x045e:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.String r0 = r0.verticalScrollbarTrackColor
            if (r0 == 0) goto L_0x0474
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r1 = r7.options
            java.lang.String r1 = r1.verticalScrollbarTrackColor
            int r1 = android.graphics.Color.parseColor(r1)
            r0.<init>(r1)
            r7.setVerticalScrollbarTrackDrawable(r0)
        L_0x0474:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.String r0 = r0.horizontalScrollbarThumbColor
            if (r0 == 0) goto L_0x048a
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r1 = r7.options
            java.lang.String r1 = r1.horizontalScrollbarThumbColor
            int r1 = android.graphics.Color.parseColor(r1)
            r0.<init>(r1)
            r7.setHorizontalScrollbarThumbDrawable(r0)
        L_0x048a:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.String r0 = r0.horizontalScrollbarTrackColor
            if (r0 == 0) goto L_0x04a0
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r1 = r7.options
            java.lang.String r1 = r1.horizontalScrollbarTrackColor
            int r1 = android.graphics.Color.parseColor(r1)
            r0.<init>(r1)
            r7.setHorizontalScrollbarTrackDrawable(r0)
        L_0x04a0:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Integer r0 = r0.overScrollMode
            int r0 = r0.intValue()
            r7.setOverScrollMode(r0)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.networkAvailable
            if (r0 == 0) goto L_0x04b8
            boolean r0 = r0.booleanValue()
            r7.setNetworkAvailable(r0)
        L_0x04b8:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.rendererPriorityPolicy
            java.lang.String r1 = "waivedWhenNotVisible"
            java.lang.String r2 = "rendererRequestedPriority"
            if (r0 == 0) goto L_0x04ec
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x04ec
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x04ec
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.rendererPriorityPolicy
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r2 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.rendererPriorityPolicy
            java.lang.Object r1 = r2.get(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r7.setRendererPriorityPolicy(r0, r1)
            goto L_0x051c
        L_0x04ec:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.rendererPriorityPolicy
            if (r0 == 0) goto L_0x04fa
            if (r0 == 0) goto L_0x051c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x051c
        L_0x04fa:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x051c
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.rendererPriorityPolicy
            int r3 = r7.getRendererRequestedPriority()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r2, r3)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.rendererPriorityPolicy
            boolean r2 = r7.getRendererPriorityWaivedWhenNotVisible()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.put(r1, r2)
        L_0x051c:
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler r0 = r7.contentBlockerHandler
            java.util.List r0 = r0.getRuleList()
            r0.clear()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.util.List<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r0 = r0.contentBlockers
            java.util.Iterator r0 = r0.iterator()
        L_0x052d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0560
            java.lang.Object r1 = r0.next()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "trigger"
            java.lang.Object r2 = r1.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTrigger r2 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerTrigger.fromMap(r2)
            java.lang.String r3 = "action"
            java.lang.Object r1 = r1.get(r3)
            java.util.Map r1 = (java.util.Map) r1
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerAction r1 = com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerAction.fromMap(r1)
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlockerHandler r3 = r7.contentBlockerHandler
            java.util.List r3 = r3.getRuleList()
            com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker r5 = new com.pichillilorenzo.flutter_inappwebview.content_blocker.ContentBlocker
            r5.<init>(r2, r1)
            r3.add(r5)
            goto L_0x052d
        L_0x0560:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$1 r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$1
            r0.<init>()
            r7.setFindListener(r0)
            android.view.GestureDetector r0 = new android.view.GestureDetector
            android.content.Context r1 = r7.getContext()
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$2 r2 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$2
            r2.<init>()
            r0.<init>(r1, r2)
            r7.gestureDetector = r0
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$3 r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$3
            r0.<init>()
            r7.checkScrollStoppedTask = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0594
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r7.options
            java.lang.Boolean r0 = r0.useHybridComposition
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0594
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$4 r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$4
            r0.<init>()
            r7.checkContextMenuShouldBeClosedTask = r0
        L_0x0594:
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$5 r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$5
            r0.<init>()
            r7.setOnTouchListener(r0)
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$6 r0 = new com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView$6
            r0.<init>()
            r7.setOnLongClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView.prepare():void");
    }

    @RequiresApi(api = 21)
    public void printCurrentPage() {
        Activity activity;
        PrintManager printManager;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null && (activity = inAppWebViewFlutterPlugin.activity) != null && (printManager = (PrintManager) activity.getSystemService("print")) != null) {
            String str = getTitle() + " Document";
            printManager.print(str, createPrintDocumentAdapter(str), new PrintAttributes.Builder().build());
        }
    }

    public ActionMode rebuildActionMode(ActionMode actionMode, ActionMode.Callback callback) {
        boolean z;
        View view;
        ActionMode actionMode2 = actionMode;
        if (!this.options.useHybridComposition.booleanValue() && (view = this.containerView) != null) {
            onWindowFocusChanged(view.isFocused());
        }
        boolean z2 = false;
        if (this.floatingContextMenu != null) {
            hideContextMenu();
            z = true;
        } else {
            z = false;
        }
        if (actionMode2 == null) {
            return null;
        }
        Menu menu = actionMode.getMenu();
        if (Build.VERSION.SDK_INT >= 23) {
            actionMode2.hide(3000);
        }
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        menu.clear();
        actionMode.finish();
        if (this.options.disableContextMenu.booleanValue()) {
            return actionMode2;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.floating_action_mode, this, false);
        this.floatingContextMenu = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) ((HorizontalScrollView) linearLayout.getChildAt(0)).getChildAt(0);
        List arrayList2 = new ArrayList();
        ContextMenuOptions contextMenuOptions = new ContextMenuOptions();
        Map<String, Object> map = this.contextMenu;
        if (map != null) {
            arrayList2 = (List) map.get("menuItems");
            Map map2 = (Map) this.contextMenu.get("options");
            if (map2 != null) {
                contextMenuOptions.parse(map2);
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        List<Map> list = arrayList2;
        Boolean bool = contextMenuOptions.hideDefaultSystemContextMenuItems;
        if (bool == null || !bool.booleanValue()) {
            for (final MenuItem menuItem : arrayList) {
                final int itemId = menuItem.getItemId();
                final String charSequence = menuItem.getTitle().toString();
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.floating_action_mode_item, this, z2);
                textView.setText(charSequence);
                final ActionMode.Callback callback2 = callback;
                AnonymousClass12 r9 = r0;
                final ActionMode actionMode3 = actionMode;
                AnonymousClass12 r0 = new View.OnClickListener() {
                    public void onClick(View view) {
                        InAppWebView.this.hideContextMenu();
                        callback2.onActionItemClicked(actionMode3, menuItem);
                        HashMap hashMap = new HashMap();
                        hashMap.put("androidId", Integer.valueOf(itemId));
                        hashMap.put("iosId", (Object) null);
                        hashMap.put("title", charSequence);
                        InAppWebView.this.channel.invokeMethod("onContextMenuActionItemClicked", hashMap);
                    }
                };
                textView.setOnClickListener(r9);
                if (this.floatingContextMenu != null) {
                    linearLayout2.addView(textView);
                }
                z2 = false;
            }
        }
        for (Map map3 : list) {
            final int intValue = ((Integer) map3.get("androidId")).intValue();
            final String str = (String) map3.get("title");
            TextView textView2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.floating_action_mode_item, this, false);
            textView2.setText(str);
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    InAppWebView.this.hideContextMenu();
                    HashMap hashMap = new HashMap();
                    hashMap.put("androidId", Integer.valueOf(intValue));
                    hashMap.put("iosId", (Object) null);
                    hashMap.put("title", str);
                    InAppWebView.this.channel.invokeMethod("onContextMenuActionItemClicked", hashMap);
                }
            });
            if (this.floatingContextMenu != null) {
                linearLayout2.addView(textView2);
            }
        }
        Point point = this.lastTouch;
        final int i3 = point != null ? point.x : 0;
        Point point2 = this.lastTouch;
        final int i4 = point2 != null ? point2.y : 0;
        this.contextMenuPoint = new Point(i3, i4);
        LinearLayout linearLayout3 = this.floatingContextMenu;
        if (linearLayout3 != null) {
            linearLayout3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LinearLayout linearLayout = InAppWebView.this.floatingContextMenu;
                    if (linearLayout != null) {
                        linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (InAppWebView.this.getSettings().getJavaScriptEnabled()) {
                            InAppWebView.this.onScrollStopped();
                        } else {
                            InAppWebView.this.onFloatingActionGlobalLayout(i3, i4);
                        }
                    }
                }
            });
            addView(this.floatingContextMenu, new AbsoluteLayout.LayoutParams(-2, -2, i3, i4));
            if (z) {
                sendOnCreateContextMenuEvent();
            }
            Runnable runnable = this.checkContextMenuShouldBeClosedTask;
            if (runnable != null) {
                runnable.run();
            }
        }
        return actionMode2;
    }

    public Map<String, Object> requestFocusNodeHref() {
        Message obtainMessage = mHandler.obtainMessage();
        requestFocusNodeHref(obtainMessage);
        Bundle peekData = obtainMessage.peekData();
        HashMap hashMap = new HashMap();
        hashMap.put("src", peekData.getString("src"));
        hashMap.put("url", peekData.getString("url"));
        hashMap.put("title", peekData.getString("title"));
        return hashMap;
    }

    public Map<String, Object> requestImageRef() {
        Message obtainMessage = mHandler.obtainMessage();
        requestImageRef(obtainMessage);
        Bundle peekData = obtainMessage.peekData();
        HashMap hashMap = new HashMap();
        hashMap.put("url", peekData.getString("url"));
        return hashMap;
    }

    public void scrollBy(Integer num, Integer num2, Boolean bool) {
        if (bool.booleanValue()) {
            ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("scrollX", new int[]{getScrollX() + num.intValue()}), PropertyValuesHolder.ofInt("scrollY", new int[]{getScrollY() + num2.intValue()})}).setDuration(300).start();
            return;
        }
        scrollBy(num.intValue(), num2.intValue());
    }

    public void scrollTo(Integer num, Integer num2, Boolean bool) {
        if (bool.booleanValue()) {
            ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("scrollX", new int[]{num.intValue()}), PropertyValuesHolder.ofInt("scrollY", new int[]{num2.intValue()})}).setDuration(300).start();
            return;
        }
        scrollTo(num.intValue(), num2.intValue());
    }

    public void setCacheEnabled(boolean z) {
        boolean z2;
        WebSettings settings = getSettings();
        if (z) {
            Context context = getContext();
            if (context != null) {
                settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                settings.setCacheMode(-1);
                z2 = true;
            } else {
                return;
            }
        } else {
            settings.setCacheMode(2);
            z2 = false;
        }
        settings.setAppCacheEnabled(z2);
    }

    public void setContextMenu(@Nullable Map<String, Object> map) {
        this.contextMenu = map;
    }

    public void setDesktopMode(boolean z) {
        WebSettings settings = getSettings();
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(z ? userAgentString.replace("Mobile", "eliboM").replace("Android", "diordnA") : userAgentString.replace("eliboM", "Mobile").replace("diordnA", "Android"));
        settings.setUseWideViewPort(z);
        settings.setLoadWithOverviewMode(z);
        settings.setSupportZoom(z);
        settings.setBuiltInZoomControls(z);
    }

    public void setInAppBrowserDelegate(@Nullable InAppBrowserDelegate inAppBrowserDelegate2) {
        this.inAppBrowserDelegate = inAppBrowserDelegate2;
    }

    public void setIncognito(boolean z) {
        WebSettings settings = getSettings();
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().removeAllCookies((ValueCallback) null);
            } else {
                CookieManager.getInstance().removeAllCookie();
            }
            settings.setCacheMode(2);
            settings.setAppCacheEnabled(false);
            clearHistory();
            clearCache(true);
            clearFormData();
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            return;
        }
        settings.setCacheMode(-1);
        settings.setAppCacheEnabled(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
    }

    public void setOptions(InAppWebViewOptions inAppWebViewOptions, HashMap<String, Object> hashMap) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Integer num;
        Integer num2;
        String str;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        WebSettings.LayoutAlgorithm layoutAlgorithm;
        Boolean bool11;
        Integer num3;
        Boolean bool12;
        Boolean bool13;
        String str2;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        Boolean bool17;
        Boolean bool18;
        Boolean bool19;
        Boolean bool20;
        Integer num4;
        Boolean bool21;
        Boolean bool22;
        Boolean bool23;
        Boolean bool24;
        Boolean bool25;
        Boolean bool26;
        Boolean bool27;
        Boolean bool28;
        Boolean bool29;
        Boolean bool30;
        Boolean bool31;
        Boolean bool32;
        Boolean bool33;
        Boolean bool34;
        Boolean bool35;
        Boolean bool36;
        WebSettings settings = getSettings();
        if (!(hashMap.get("javaScriptEnabled") == null || this.options.javaScriptEnabled == (bool36 = inAppWebViewOptions.javaScriptEnabled))) {
            settings.setJavaScriptEnabled(bool36.booleanValue());
        }
        if (!(hashMap.get("useShouldInterceptAjaxRequest") == null || this.options.useShouldInterceptAjaxRequest == (bool35 = inAppWebViewOptions.useShouldInterceptAjaxRequest))) {
            enablePluginScriptAtRuntime(InterceptAjaxRequestJS.FLAG_VARIABLE_FOR_SHOULD_INTERCEPT_AJAX_REQUEST_JS_SOURCE, bool35.booleanValue(), InterceptAjaxRequestJS.INTERCEPT_AJAX_REQUEST_JS_PLUGIN_SCRIPT);
        }
        if (!(hashMap.get("useShouldInterceptFetchRequest") == null || this.options.useShouldInterceptFetchRequest == (bool34 = inAppWebViewOptions.useShouldInterceptFetchRequest))) {
            enablePluginScriptAtRuntime(InterceptFetchRequestJS.FLAG_VARIABLE_FOR_SHOULD_INTERCEPT_FETCH_REQUEST_JS_SOURCE, bool34.booleanValue(), InterceptFetchRequestJS.INTERCEPT_FETCH_REQUEST_JS_PLUGIN_SCRIPT);
        }
        if (!(hashMap.get("useOnLoadResource") == null || this.options.useOnLoadResource == (bool33 = inAppWebViewOptions.useOnLoadResource))) {
            enablePluginScriptAtRuntime(OnLoadResourceJS.FLAG_VARIABLE_FOR_ON_LOAD_RESOURCE_JS_SOURCE, bool33.booleanValue(), OnLoadResourceJS.ON_LOAD_RESOURCE_JS_PLUGIN_SCRIPT);
        }
        if (!(hashMap.get("javaScriptCanOpenWindowsAutomatically") == null || this.options.javaScriptCanOpenWindowsAutomatically == (bool32 = inAppWebViewOptions.javaScriptCanOpenWindowsAutomatically))) {
            settings.setJavaScriptCanOpenWindowsAutomatically(bool32.booleanValue());
        }
        if (!(hashMap.get("builtInZoomControls") == null || this.options.builtInZoomControls == (bool31 = inAppWebViewOptions.builtInZoomControls))) {
            settings.setBuiltInZoomControls(bool31.booleanValue());
        }
        if (!(hashMap.get("displayZoomControls") == null || this.options.displayZoomControls == (bool30 = inAppWebViewOptions.displayZoomControls))) {
            settings.setDisplayZoomControls(bool30.booleanValue());
        }
        if (!(hashMap.get("safeBrowsingEnabled") == null || this.options.safeBrowsingEnabled == (bool29 = inAppWebViewOptions.safeBrowsingEnabled) || Build.VERSION.SDK_INT < 26)) {
            settings.setSafeBrowsingEnabled(bool29.booleanValue());
        }
        if (!(hashMap.get("mediaPlaybackRequiresUserGesture") == null || this.options.mediaPlaybackRequiresUserGesture == (bool28 = inAppWebViewOptions.mediaPlaybackRequiresUserGesture))) {
            settings.setMediaPlaybackRequiresUserGesture(bool28.booleanValue());
        }
        if (!(hashMap.get("databaseEnabled") == null || this.options.databaseEnabled == (bool27 = inAppWebViewOptions.databaseEnabled))) {
            settings.setDatabaseEnabled(bool27.booleanValue());
        }
        if (!(hashMap.get("domStorageEnabled") == null || this.options.domStorageEnabled == (bool26 = inAppWebViewOptions.domStorageEnabled))) {
            settings.setDomStorageEnabled(bool26.booleanValue());
        }
        if (hashMap.get("userAgent") != null && !this.options.userAgent.equals(inAppWebViewOptions.userAgent) && !inAppWebViewOptions.userAgent.isEmpty()) {
            settings.setUserAgentString(inAppWebViewOptions.userAgent);
        }
        if (hashMap.get("applicationNameForUserAgent") != null && !this.options.applicationNameForUserAgent.equals(inAppWebViewOptions.applicationNameForUserAgent) && !inAppWebViewOptions.applicationNameForUserAgent.isEmpty() && Build.VERSION.SDK_INT >= 17) {
            String str3 = inAppWebViewOptions.userAgent;
            String defaultUserAgent = (str3 == null || str3.isEmpty()) ? WebSettings.getDefaultUserAgent(getContext()) : inAppWebViewOptions.userAgent;
            settings.setUserAgentString(defaultUserAgent + " " + this.options.applicationNameForUserAgent);
        }
        if (hashMap.get("clearCache") != null && inAppWebViewOptions.clearCache.booleanValue()) {
            clearAllCache();
        } else if (hashMap.get("clearSessionCache") != null && inAppWebViewOptions.clearSessionCache.booleanValue()) {
            CookieManager.getInstance().removeSessionCookie();
        }
        if (!(hashMap.get("thirdPartyCookiesEnabled") == null || this.options.thirdPartyCookiesEnabled == inAppWebViewOptions.thirdPartyCookiesEnabled || Build.VERSION.SDK_INT < 21)) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, inAppWebViewOptions.thirdPartyCookiesEnabled.booleanValue());
        }
        if (!(hashMap.get("useWideViewPort") == null || this.options.useWideViewPort == (bool25 = inAppWebViewOptions.useWideViewPort))) {
            settings.setUseWideViewPort(bool25.booleanValue());
        }
        if (!(hashMap.get("supportZoom") == null || this.options.supportZoom == (bool24 = inAppWebViewOptions.supportZoom))) {
            settings.setSupportZoom(bool24.booleanValue());
        }
        if (hashMap.get("textZoom") != null && !this.options.textZoom.equals(inAppWebViewOptions.textZoom)) {
            settings.setTextZoom(inAppWebViewOptions.textZoom.intValue());
        }
        if (!(hashMap.get("verticalScrollBarEnabled") == null || this.options.verticalScrollBarEnabled == (bool23 = inAppWebViewOptions.verticalScrollBarEnabled))) {
            setVerticalScrollBarEnabled(bool23.booleanValue());
        }
        if (!(hashMap.get("horizontalScrollBarEnabled") == null || this.options.horizontalScrollBarEnabled == (bool22 = inAppWebViewOptions.horizontalScrollBarEnabled))) {
            setHorizontalScrollBarEnabled(bool22.booleanValue());
        }
        boolean z = false;
        if (!(hashMap.get("transparentBackground") == null || this.options.transparentBackground == (bool21 = inAppWebViewOptions.transparentBackground))) {
            if (bool21.booleanValue()) {
                setBackgroundColor(0);
            } else {
                setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && hashMap.get("mixedContentMode") != null && ((num4 = this.options.mixedContentMode) == null || !num4.equals(inAppWebViewOptions.mixedContentMode))) {
            settings.setMixedContentMode(inAppWebViewOptions.mixedContentMode.intValue());
        }
        if (!(hashMap.get("supportMultipleWindows") == null || this.options.supportMultipleWindows == (bool20 = inAppWebViewOptions.supportMultipleWindows))) {
            settings.setSupportMultipleWindows(bool20.booleanValue());
        }
        if (!(hashMap.get("useOnDownloadStart") == null || this.options.useOnDownloadStart == (bool19 = inAppWebViewOptions.useOnDownloadStart))) {
            if (bool19.booleanValue()) {
                setDownloadListener(new DownloadStartListener());
            } else {
                setDownloadListener((DownloadListener) null);
            }
        }
        if (!(hashMap.get("allowContentAccess") == null || this.options.allowContentAccess == (bool18 = inAppWebViewOptions.allowContentAccess))) {
            settings.setAllowContentAccess(bool18.booleanValue());
        }
        if (!(hashMap.get("allowFileAccess") == null || this.options.allowFileAccess == (bool17 = inAppWebViewOptions.allowFileAccess))) {
            settings.setAllowFileAccess(bool17.booleanValue());
        }
        if (!(hashMap.get("allowFileAccessFromFileURLs") == null || this.options.allowFileAccessFromFileURLs == (bool16 = inAppWebViewOptions.allowFileAccessFromFileURLs))) {
            settings.setAllowFileAccessFromFileURLs(bool16.booleanValue());
        }
        if (!(hashMap.get("allowUniversalAccessFromFileURLs") == null || this.options.allowUniversalAccessFromFileURLs == (bool15 = inAppWebViewOptions.allowUniversalAccessFromFileURLs))) {
            settings.setAllowUniversalAccessFromFileURLs(bool15.booleanValue());
        }
        if (!(hashMap.get("cacheEnabled") == null || this.options.cacheEnabled == (bool14 = inAppWebViewOptions.cacheEnabled))) {
            setCacheEnabled(bool14.booleanValue());
        }
        if (hashMap.get("appCachePath") != null && ((str2 = this.options.appCachePath) == null || !str2.equals(inAppWebViewOptions.appCachePath))) {
            settings.setAppCachePath(inAppWebViewOptions.appCachePath);
        }
        if (!(hashMap.get("blockNetworkImage") == null || this.options.blockNetworkImage == (bool13 = inAppWebViewOptions.blockNetworkImage))) {
            settings.setBlockNetworkImage(bool13.booleanValue());
        }
        if (!(hashMap.get("blockNetworkLoads") == null || this.options.blockNetworkLoads == (bool12 = inAppWebViewOptions.blockNetworkLoads))) {
            settings.setBlockNetworkLoads(bool12.booleanValue());
        }
        if (hashMap.get("cacheMode") != null && !this.options.cacheMode.equals(inAppWebViewOptions.cacheMode)) {
            settings.setCacheMode(inAppWebViewOptions.cacheMode.intValue());
        }
        if (hashMap.get("cursiveFontFamily") != null && !this.options.cursiveFontFamily.equals(inAppWebViewOptions.cursiveFontFamily)) {
            settings.setCursiveFontFamily(inAppWebViewOptions.cursiveFontFamily);
        }
        if (hashMap.get("defaultFixedFontSize") != null && !this.options.defaultFixedFontSize.equals(inAppWebViewOptions.defaultFixedFontSize)) {
            settings.setDefaultFixedFontSize(inAppWebViewOptions.defaultFixedFontSize.intValue());
        }
        if (hashMap.get("defaultFontSize") != null && !this.options.defaultFontSize.equals(inAppWebViewOptions.defaultFontSize)) {
            settings.setDefaultFontSize(inAppWebViewOptions.defaultFontSize.intValue());
        }
        if (hashMap.get("defaultTextEncodingName") != null && !this.options.defaultTextEncodingName.equals(inAppWebViewOptions.defaultTextEncodingName)) {
            settings.setDefaultTextEncodingName(inAppWebViewOptions.defaultTextEncodingName);
        }
        if (Build.VERSION.SDK_INT >= 24 && hashMap.get("disabledActionModeMenuItems") != null && ((num3 = this.options.disabledActionModeMenuItems) == null || !num3.equals(inAppWebViewOptions.disabledActionModeMenuItems))) {
            settings.setDisabledActionModeMenuItems(inAppWebViewOptions.disabledActionModeMenuItems.intValue());
        }
        if (hashMap.get("fantasyFontFamily") != null && !this.options.fantasyFontFamily.equals(inAppWebViewOptions.fantasyFontFamily)) {
            settings.setFantasyFontFamily(inAppWebViewOptions.fantasyFontFamily);
        }
        if (hashMap.get("fixedFontFamily") != null && !this.options.fixedFontFamily.equals(inAppWebViewOptions.fixedFontFamily)) {
            settings.setFixedFontFamily(inAppWebViewOptions.fixedFontFamily);
        }
        if (hashMap.get("forceDark") != null && !this.options.forceDark.equals(inAppWebViewOptions.forceDark) && Build.VERSION.SDK_INT >= 29) {
            settings.setForceDark(inAppWebViewOptions.forceDark.intValue());
        }
        if (!(hashMap.get("geolocationEnabled") == null || this.options.geolocationEnabled == (bool11 = inAppWebViewOptions.geolocationEnabled))) {
            settings.setGeolocationEnabled(bool11.booleanValue());
        }
        if (!(hashMap.get("layoutAlgorithm") == null || this.options.layoutAlgorithm == (layoutAlgorithm = inAppWebViewOptions.layoutAlgorithm))) {
            if (Build.VERSION.SDK_INT >= 19) {
                layoutAlgorithm.equals(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
            }
            settings.setLayoutAlgorithm(inAppWebViewOptions.layoutAlgorithm);
        }
        if (!(hashMap.get("loadWithOverviewMode") == null || this.options.loadWithOverviewMode == (bool10 = inAppWebViewOptions.loadWithOverviewMode))) {
            settings.setLoadWithOverviewMode(bool10.booleanValue());
        }
        if (!(hashMap.get("loadsImagesAutomatically") == null || this.options.loadsImagesAutomatically == (bool9 = inAppWebViewOptions.loadsImagesAutomatically))) {
            settings.setLoadsImagesAutomatically(bool9.booleanValue());
        }
        if (hashMap.get("minimumFontSize") != null && !this.options.minimumFontSize.equals(inAppWebViewOptions.minimumFontSize)) {
            settings.setMinimumFontSize(inAppWebViewOptions.minimumFontSize.intValue());
        }
        if (hashMap.get("minimumLogicalFontSize") != null && !this.options.minimumLogicalFontSize.equals(inAppWebViewOptions.minimumLogicalFontSize)) {
            settings.setMinimumLogicalFontSize(inAppWebViewOptions.minimumLogicalFontSize.intValue());
        }
        if (hashMap.get("initialScale") != null && !this.options.initialScale.equals(inAppWebViewOptions.initialScale)) {
            setInitialScale(inAppWebViewOptions.initialScale.intValue());
        }
        if (!(hashMap.get("needInitialFocus") == null || this.options.needInitialFocus == (bool8 = inAppWebViewOptions.needInitialFocus))) {
            settings.setNeedInitialFocus(bool8.booleanValue());
        }
        if (!(hashMap.get("offscreenPreRaster") == null || this.options.offscreenPreRaster == (bool7 = inAppWebViewOptions.offscreenPreRaster) || Build.VERSION.SDK_INT < 23)) {
            settings.setOffscreenPreRaster(bool7.booleanValue());
        }
        if (hashMap.get("sansSerifFontFamily") != null && !this.options.sansSerifFontFamily.equals(inAppWebViewOptions.sansSerifFontFamily)) {
            settings.setSansSerifFontFamily(inAppWebViewOptions.sansSerifFontFamily);
        }
        if (hashMap.get("serifFontFamily") != null && !this.options.serifFontFamily.equals(inAppWebViewOptions.serifFontFamily)) {
            settings.setSerifFontFamily(inAppWebViewOptions.serifFontFamily);
        }
        if (hashMap.get("standardFontFamily") != null && !this.options.standardFontFamily.equals(inAppWebViewOptions.standardFontFamily)) {
            settings.setStandardFontFamily(inAppWebViewOptions.standardFontFamily);
        }
        if (hashMap.get("preferredContentMode") != null && !this.options.preferredContentMode.equals(inAppWebViewOptions.preferredContentMode)) {
            int i2 = AnonymousClass19.$SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$PreferredContentModeOptionType[PreferredContentModeOptionType.fromValue(inAppWebViewOptions.preferredContentMode.intValue()).ordinal()];
            if (i2 == 1) {
                setDesktopMode(true);
            } else if (i2 == 2 || i2 == 3) {
                setDesktopMode(false);
            }
        }
        if (!(hashMap.get("saveFormData") == null || this.options.saveFormData == (bool6 = inAppWebViewOptions.saveFormData))) {
            settings.setSaveFormData(bool6.booleanValue());
        }
        if (!(hashMap.get("incognito") == null || this.options.incognito == (bool5 = inAppWebViewOptions.incognito))) {
            setIncognito(bool5.booleanValue());
        }
        if (!(hashMap.get("hardwareAcceleration") == null || this.options.hardwareAcceleration == (bool4 = inAppWebViewOptions.hardwareAcceleration))) {
            if (bool4.booleanValue()) {
                setLayerType(2, (Paint) null);
            } else {
                setLayerType(1, (Paint) null);
            }
        }
        if (hashMap.get("regexToCancelSubFramesLoading") != null && ((str = this.options.regexToCancelSubFramesLoading) == null || !str.equals(inAppWebViewOptions.regexToCancelSubFramesLoading))) {
            if (inAppWebViewOptions.regexToCancelSubFramesLoading == null) {
                this.regexToCancelSubFramesLoadingCompiled = null;
            } else {
                this.regexToCancelSubFramesLoadingCompiled = Pattern.compile(this.options.regexToCancelSubFramesLoading);
            }
        }
        if (inAppWebViewOptions.contentBlockers != null) {
            this.contentBlockerHandler.getRuleList().clear();
            for (Map next : inAppWebViewOptions.contentBlockers) {
                this.contentBlockerHandler.getRuleList().add(new ContentBlocker(ContentBlockerTrigger.fromMap((Map) next.get("trigger")), ContentBlockerAction.fromMap((Map) next.get("action"))));
            }
        }
        if (hashMap.get("scrollBarStyle") != null && !this.options.scrollBarStyle.equals(inAppWebViewOptions.scrollBarStyle)) {
            setScrollBarStyle(inAppWebViewOptions.scrollBarStyle.intValue());
        }
        if (hashMap.get("scrollBarDefaultDelayBeforeFade") != null && ((num2 = this.options.scrollBarDefaultDelayBeforeFade) == null || !num2.equals(inAppWebViewOptions.scrollBarDefaultDelayBeforeFade))) {
            setScrollBarDefaultDelayBeforeFade(inAppWebViewOptions.scrollBarDefaultDelayBeforeFade.intValue());
        }
        if (hashMap.get("scrollbarFadingEnabled") != null && !this.options.scrollbarFadingEnabled.equals(inAppWebViewOptions.scrollbarFadingEnabled)) {
            setScrollbarFadingEnabled(inAppWebViewOptions.scrollbarFadingEnabled.booleanValue());
        }
        if (hashMap.get("scrollBarFadeDuration") != null && ((num = this.options.scrollBarFadeDuration) == null || !num.equals(inAppWebViewOptions.scrollBarFadeDuration))) {
            setScrollBarFadeDuration(inAppWebViewOptions.scrollBarFadeDuration.intValue());
        }
        if (hashMap.get("verticalScrollbarPosition") != null && !this.options.verticalScrollbarPosition.equals(inAppWebViewOptions.verticalScrollbarPosition)) {
            setVerticalScrollbarPosition(inAppWebViewOptions.verticalScrollbarPosition.intValue());
        }
        if (!(hashMap.get("disableVerticalScroll") == null || this.options.disableVerticalScroll == (bool3 = inAppWebViewOptions.disableVerticalScroll))) {
            setVerticalScrollBarEnabled(!bool3.booleanValue() && inAppWebViewOptions.verticalScrollBarEnabled.booleanValue());
        }
        if (!(hashMap.get("disableHorizontalScroll") == null || this.options.disableHorizontalScroll == (bool2 = inAppWebViewOptions.disableHorizontalScroll))) {
            if (!bool2.booleanValue() && inAppWebViewOptions.horizontalScrollBarEnabled.booleanValue()) {
                z = true;
            }
            setHorizontalScrollBarEnabled(z);
        }
        if (hashMap.get("overScrollMode") != null && !this.options.overScrollMode.equals(inAppWebViewOptions.overScrollMode)) {
            setOverScrollMode(inAppWebViewOptions.overScrollMode.intValue());
        }
        if (!(hashMap.get("networkAvailable") == null || this.options.networkAvailable == (bool = inAppWebViewOptions.networkAvailable))) {
            setNetworkAvailable(bool.booleanValue());
        }
        if (hashMap.get("rendererPriorityPolicy") != null && (!(this.options.rendererPriorityPolicy.get("rendererRequestedPriority") == inAppWebViewOptions.rendererPriorityPolicy.get("rendererRequestedPriority") && this.options.rendererPriorityPolicy.get("waivedWhenNotVisible") == inAppWebViewOptions.rendererPriorityPolicy.get("waivedWhenNotVisible")) && Build.VERSION.SDK_INT >= 26)) {
            setRendererPriorityPolicy(((Integer) inAppWebViewOptions.rendererPriorityPolicy.get("rendererRequestedPriority")).intValue(), ((Boolean) inAppWebViewOptions.rendererPriorityPolicy.get("waivedWhenNotVisible")).booleanValue());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (hashMap.get("verticalScrollbarThumbColor") != null && !Util.objEquals(this.options.verticalScrollbarThumbColor, inAppWebViewOptions.verticalScrollbarThumbColor)) {
                setVerticalScrollbarThumbDrawable(new ColorDrawable(Color.parseColor(inAppWebViewOptions.verticalScrollbarThumbColor)));
            }
            if (hashMap.get("verticalScrollbarTrackColor") != null && !Util.objEquals(this.options.verticalScrollbarTrackColor, inAppWebViewOptions.verticalScrollbarTrackColor)) {
                setVerticalScrollbarTrackDrawable(new ColorDrawable(Color.parseColor(inAppWebViewOptions.verticalScrollbarTrackColor)));
            }
            if (hashMap.get("horizontalScrollbarThumbColor") != null && !Util.objEquals(this.options.horizontalScrollbarThumbColor, inAppWebViewOptions.horizontalScrollbarThumbColor)) {
                setHorizontalScrollbarThumbDrawable(new ColorDrawable(Color.parseColor(inAppWebViewOptions.horizontalScrollbarThumbColor)));
            }
            if (hashMap.get("horizontalScrollbarTrackColor") != null && !Util.objEquals(this.options.horizontalScrollbarTrackColor, inAppWebViewOptions.horizontalScrollbarTrackColor)) {
                setHorizontalScrollbarTrackDrawable(new ColorDrawable(Color.parseColor(inAppWebViewOptions.horizontalScrollbarTrackColor)));
            }
        }
        this.options = inAppWebViewOptions;
    }

    public void setPlugin(@Nullable InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public void setUserContentController(UserContentController userContentController2) {
        this.userContentController = userContentController2;
    }

    public void setWebMessageChannels(Map<String, WebMessageChannel> map) {
        this.webMessageChannels = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r1.contextMenu;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback r2) {
        /*
            r1 = this;
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r1.options
            java.lang.Boolean r0 = r0.useHybridComposition
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0027
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r1.options
            java.lang.Boolean r0 = r0.disableContextMenu
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0027
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.contextMenu
            if (r0 == 0) goto L_0x0022
            java.util.Set r0 = r0.keySet()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0027
        L_0x0022:
            android.view.ActionMode r2 = super.startActionMode(r2)
            return r2
        L_0x0027:
            android.view.ActionMode r0 = super.startActionMode(r2)
            android.view.ActionMode r2 = r1.rebuildActionMode(r0, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView.startActionMode(android.view.ActionMode$Callback):android.view.ActionMode");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r1.contextMenu;
     */
    @androidx.annotation.RequiresApi(api = 23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback r2, int r3) {
        /*
            r1 = this;
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r1.options
            java.lang.Boolean r0 = r0.useHybridComposition
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0027
            com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions r0 = r1.options
            java.lang.Boolean r0 = r0.disableContextMenu
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0027
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.contextMenu
            if (r0 == 0) goto L_0x0022
            java.util.Set r0 = r0.keySet()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0027
        L_0x0022:
            android.view.ActionMode r2 = super.startActionMode(r2, r3)
            return r2
        L_0x0027:
            android.view.ActionMode r3 = super.startActionMode(r2, r3)
            android.view.ActionMode r2 = r1.rebuildActionMode(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView.startActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }

    public void takeScreenshot(@Nullable final Map<String, Object> map, final MethodChannel.Result result) {
        final float pixelDensity = Util.getPixelDensity(getContext());
        this.mainLooperHandler.post(new Runnable() {
            public void run() {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(InAppWebView.this.getMeasuredWidth(), InAppWebView.this.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.translate((float) (-InAppWebView.this.getScrollX()), (float) (-InAppWebView.this.getScrollY()));
                    InAppWebView.this.draw(canvas);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                    int i2 = 100;
                    if (map != null) {
                        Map map = (Map) map.get("rect");
                        if (map != null) {
                            createBitmap = Bitmap.createBitmap(createBitmap, (int) Math.floor((((Double) map.get(x.a)).doubleValue() * ((double) pixelDensity)) + 0.5d), (int) Math.floor((((Double) map.get("y")).doubleValue() * ((double) pixelDensity)) + 0.5d), Math.min(createBitmap.getWidth(), (int) Math.floor((((Double) map.get("width")).doubleValue() * ((double) pixelDensity)) + 0.5d)), Math.min(createBitmap.getHeight(), (int) Math.floor((((Double) map.get("height")).doubleValue() * ((double) pixelDensity)) + 0.5d)));
                        }
                        Double d = (Double) map.get("snapshotWidth");
                        if (d != null) {
                            int floor = (int) Math.floor((d.doubleValue() * ((double) pixelDensity)) + 0.5d);
                            createBitmap = Bitmap.createScaledBitmap(createBitmap, floor, (int) (((float) floor) / (((float) createBitmap.getWidth()) / ((float) createBitmap.getHeight()))), true);
                        }
                        try {
                            compressFormat = Bitmap.CompressFormat.valueOf((String) map.get("compressFormat"));
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        i2 = ((Integer) map.get("quality")).intValue();
                    }
                    createBitmap.compress(compressFormat, i2, byteArrayOutputStream);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    createBitmap.recycle();
                    result.success(byteArrayOutputStream.toByteArray());
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    result.success((Object) null);
                }
            }
        });
    }
}
