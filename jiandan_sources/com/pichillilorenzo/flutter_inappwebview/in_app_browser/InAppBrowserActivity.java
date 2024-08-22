package com.pichillilorenzo.flutter_inappwebview.in_app_browser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.SearchView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.internal.AssetHelper;
import com.alipay.sdk.m.x.d;
import com.baidu.aiscan.R;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshOptions;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview.types.UserScript;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InAppBrowserActivity extends AppCompatActivity implements InAppBrowserDelegate {
    public static final String LOG_TAG = "InAppBrowserActivity";
    @Nullable
    public ActionBar actionBar;
    public List<ActivityResultListener> activityResultListeners = new ArrayList();
    public MethodChannel channel;
    @Nullable
    public String fromActivity;
    public String id;
    public boolean isHidden = false;
    @Nullable
    public InAppBrowserManager manager;
    @Nullable
    public Menu menu;
    @Nullable
    public InAppWebViewMethodHandler methodCallDelegate;
    public InAppBrowserOptions options = new InAppBrowserOptions();
    @Nullable
    public ProgressBar progressBar;
    @Nullable
    public PullToRefreshLayout pullToRefreshLayout;
    @Nullable
    public SearchView searchView;
    @Nullable
    public InAppWebView webView;
    public Integer windowId;

    private void prepareView() {
        int i2;
        ProgressBar progressBar2;
        this.webView.prepare();
        if (this.options.hidden.booleanValue()) {
            hide();
        } else {
            show();
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        if (this.options.hideProgressBar.booleanValue()) {
            progressBar2 = this.progressBar;
            i2 = 0;
        } else {
            progressBar2 = this.progressBar;
            i2 = 100;
        }
        progressBar2.setMax(i2);
        ActionBar actionBar2 = this.actionBar;
        if (actionBar2 != null) {
            actionBar2.setDisplayShowTitleEnabled(!this.options.hideTitleBar.booleanValue());
            if (this.options.hideToolbarTop.booleanValue()) {
                this.actionBar.hide();
            }
            String str = this.options.toolbarTopBackgroundColor;
            if (str != null && !str.isEmpty()) {
                this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.options.toolbarTopBackgroundColor)));
            }
            String str2 = this.options.toolbarTopFixedTitle;
            if (str2 != null && !str2.isEmpty()) {
                this.actionBar.setTitle((CharSequence) this.options.toolbarTopFixedTitle);
            }
        }
    }

    public boolean canGoBack() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoBack();
        }
        return false;
    }

    public boolean canGoForward() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoForward();
        }
        return false;
    }

    public void close(MethodChannel.Result result) {
        this.channel.invokeMethod(d.r, new HashMap());
        dispose();
        if (result != null) {
            result.success(Boolean.TRUE);
        }
    }

    public void closeButtonClicked(MenuItem menuItem) {
        close((MethodChannel.Result) null);
    }

    public void didChangeProgress(int i2) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 24) {
                this.progressBar.setProgress(i2, true);
            } else {
                this.progressBar.setProgress(i2);
            }
            if (i2 == 100) {
                this.progressBar.setVisibility(8);
            }
        }
    }

    public void didChangeTitle(String str) {
        if (this.actionBar != null) {
            String str2 = this.options.toolbarTopFixedTitle;
            if (str2 == null || str2.isEmpty()) {
                this.actionBar.setTitle((CharSequence) str);
            }
        }
    }

    public void didFailNavigation(String str, int i2, String str2) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
    }

    public void didFinishNavigation(String str) {
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
    }

    public void didStartNavigation(String str) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
    }

    public void didUpdateVisitedHistory(String str) {
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
    }

    public void dispose() {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        ActivityPluginBinding activityPluginBinding;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.activityResultListeners.clear();
        InAppWebViewMethodHandler inAppWebViewMethodHandler = this.methodCallDelegate;
        if (inAppWebViewMethodHandler != null) {
            inAppWebViewMethodHandler.dispose();
            this.methodCallDelegate = null;
        }
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            InAppBrowserManager inAppBrowserManager = this.manager;
            if (!(inAppBrowserManager == null || (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) == null || (activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding) == null)) {
                activityPluginBinding.removeActivityResultListener(inAppWebView.inAppWebViewChromeClient);
            }
            ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.webView);
            }
            this.webView.setWebChromeClient(new WebChromeClient());
            this.webView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    InAppBrowserActivity.this.webView.dispose();
                    InAppBrowserActivity.this.webView.destroy();
                    InAppBrowserActivity inAppBrowserActivity = InAppBrowserActivity.this;
                    inAppBrowserActivity.webView = null;
                    inAppBrowserActivity.manager = null;
                }
            });
            this.webView.loadUrl("about:blank");
            finish();
        }
    }

    public Activity getActivity() {
        return this;
    }

    public List<ActivityResultListener> getActivityResultListeners() {
        return this.activityResultListeners;
    }

    public Map<String, Object> getOptions() {
        Map<String, Object> options2 = this.webView.getOptions();
        InAppBrowserOptions inAppBrowserOptions = this.options;
        if (inAppBrowserOptions == null || options2 == null) {
            return null;
        }
        Map<String, Object> realOptions = inAppBrowserOptions.getRealOptions(this);
        realOptions.putAll(options2);
        return realOptions;
    }

    public void goBack() {
        if (this.webView != null && canGoBack()) {
            this.webView.goBack();
        }
    }

    public void goBackButtonClicked(MenuItem menuItem) {
        goBack();
    }

    public void goForward() {
        if (this.webView != null && canGoForward()) {
            this.webView.goForward();
        }
    }

    public void goForwardButtonClicked(MenuItem menuItem) {
        goForward();
    }

    public void hide() {
        try {
            this.isHidden = true;
            Intent intent = new Intent(this, Class.forName(this.fromActivity));
            intent.setFlags(131072);
            startActivityIfNeeded(intent, 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        for (ActivityResultListener onActivityResult : this.activityResultListeners) {
            if (onActivityResult.onActivityResult(i2, i3, intent)) {
                return;
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onBrowserCreated() {
        this.channel.invokeMethod("onBrowserCreated", new HashMap());
    }

    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("id");
            InAppBrowserManager inAppBrowserManager = InAppBrowserManager.shared.get(extras.getString("managerId"));
            this.manager = inAppBrowserManager;
            if (inAppBrowserManager != null && (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) != null && inAppWebViewFlutterPlugin.messenger != null) {
                Map map = (Map) extras.getSerializable("options");
                this.options.parse(map);
                this.windowId = Integer.valueOf(extras.getInt("windowId"));
                this.channel = new MethodChannel(this.manager.plugin.messenger, "com.pichillilorenzo/flutter_inappbrowser_" + this.id);
                setContentView((int) R.layout.activity_web_view);
                MethodChannel methodChannel = new MethodChannel(this.manager.plugin.messenger, "com.pichillilorenzo/flutter_inappwebview_pull_to_refresh_" + this.id);
                PullToRefreshOptions pullToRefreshOptions = new PullToRefreshOptions();
                pullToRefreshOptions.parse((Map) extras.getSerializable("pullToRefreshInitialOptions"));
                PullToRefreshLayout pullToRefreshLayout2 = (PullToRefreshLayout) findViewById(R.id.pullToRefresh);
                this.pullToRefreshLayout = pullToRefreshLayout2;
                pullToRefreshLayout2.channel = methodChannel;
                pullToRefreshLayout2.options = pullToRefreshOptions;
                pullToRefreshLayout2.prepare();
                InAppWebView inAppWebView = (InAppWebView) findViewById(R.id.webView);
                this.webView = inAppWebView;
                inAppWebView.windowId = this.windowId;
                inAppWebView.inAppBrowserDelegate = this;
                inAppWebView.channel = this.channel;
                inAppWebView.plugin = this.manager.plugin;
                InAppWebViewMethodHandler inAppWebViewMethodHandler = new InAppWebViewMethodHandler(inAppWebView);
                this.methodCallDelegate = inAppWebViewMethodHandler;
                this.channel.setMethodCallHandler(inAppWebViewMethodHandler);
                this.fromActivity = extras.getString("fromActivity");
                List<Map> list = (List) extras.getSerializable("initialUserScripts");
                InAppWebViewOptions inAppWebViewOptions = new InAppWebViewOptions();
                inAppWebViewOptions.parse(map);
                InAppWebView inAppWebView2 = this.webView;
                inAppWebView2.options = inAppWebViewOptions;
                inAppWebView2.contextMenu = (Map) extras.getSerializable("contextMenu");
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (Map fromMap : list) {
                        arrayList.add(UserScript.fromMap(fromMap));
                    }
                }
                this.webView.userContentController.addUserOnlyScripts(arrayList);
                this.actionBar = getSupportActionBar();
                prepareView();
                if (this.windowId.intValue() != -1) {
                    Message message = InAppWebViewChromeClient.windowWebViewMessages.get(this.windowId);
                    if (message != null) {
                        ((WebView.WebViewTransport) message.obj).setWebView(this.webView);
                        message.sendToTarget();
                    }
                } else {
                    String string = extras.getString("initialFile");
                    Map map2 = (Map) extras.getSerializable("initialUrlRequest");
                    String string2 = extras.getString("initialData");
                    if (string != null) {
                        try {
                            this.webView.loadFile(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                            string + " asset file cannot be found!";
                            return;
                        }
                    } else if (string2 != null) {
                        this.webView.loadDataWithBaseURL(extras.getString("initialBaseUrl"), string2, extras.getString("initialMimeType"), extras.getString("initialEncoding"), extras.getString("initialHistoryUrl"));
                    } else if (map2 != null) {
                        this.webView.loadUrl(URLRequest.fromMap(map2));
                    }
                }
                onBrowserCreated();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        String str;
        this.menu = menu2;
        String str2 = "";
        if (this.actionBar != null && ((str = this.options.toolbarTopFixedTitle) == null || str.isEmpty())) {
            ActionBar actionBar2 = this.actionBar;
            InAppWebView inAppWebView = this.webView;
            actionBar2.setTitle((CharSequence) inAppWebView != null ? inAppWebView.getTitle() : str2);
        }
        if (this.menu == null) {
            return super.onCreateOptionsMenu(menu2);
        }
        getMenuInflater().inflate(R.menu.menu_main, this.menu);
        MenuItem findItem = this.menu.findItem(R.id.menu_search);
        if (findItem != null) {
            if (this.options.hideUrlBar.booleanValue()) {
                findItem.setVisible(false);
            }
            SearchView searchView2 = (SearchView) findItem.getActionView();
            this.searchView = searchView2;
            if (searchView2 != null) {
                searchView2.setFocusable(true);
                SearchView searchView3 = this.searchView;
                InAppWebView inAppWebView2 = this.webView;
                if (inAppWebView2 != null) {
                    str2 = inAppWebView2.getUrl();
                }
                searchView3.setQuery(str2, false);
                this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    public boolean onQueryTextChange(String str) {
                        return false;
                    }

                    public boolean onQueryTextSubmit(String str) {
                        if (str.isEmpty()) {
                            return false;
                        }
                        InAppWebView inAppWebView = InAppBrowserActivity.this.webView;
                        if (inAppWebView != null) {
                            inAppWebView.loadUrl(str);
                        }
                        SearchView searchView = InAppBrowserActivity.this.searchView;
                        if (searchView != null) {
                            searchView.setQuery("", false);
                            InAppBrowserActivity.this.searchView.setIconified(true);
                        }
                        return true;
                    }
                });
                this.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                    public boolean onClose() {
                        SearchView searchView = InAppBrowserActivity.this.searchView;
                        if (searchView != null && searchView.getQuery().toString().isEmpty()) {
                            InAppBrowserActivity inAppBrowserActivity = InAppBrowserActivity.this;
                            SearchView searchView2 = inAppBrowserActivity.searchView;
                            InAppWebView inAppWebView = inAppBrowserActivity.webView;
                            searchView2.setQuery(inAppWebView != null ? inAppWebView.getUrl() : "", false);
                        }
                        return false;
                    }
                });
                this.searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View view, boolean z) {
                        SearchView searchView;
                        if (!z && (searchView = InAppBrowserActivity.this.searchView) != null) {
                            searchView.setQuery("", false);
                            InAppBrowserActivity.this.searchView.setIconified(true);
                        }
                    }
                });
            }
        }
        return true;
    }

    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.options.shouldCloseOnBackButtonPressed.booleanValue()) {
                close((MethodChannel.Result) null);
                return true;
            } else if (this.options.allowGoBackWithBackButton.booleanValue()) {
                if (canGoBack()) {
                    goBack();
                } else if (this.options.closeOnCannotGoBack.booleanValue()) {
                    close((MethodChannel.Result) null);
                }
                return true;
            } else if (!this.options.shouldCloseOnBackButtonPressed.booleanValue()) {
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void reload() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.reload();
        }
    }

    public void reloadButtonClicked(MenuItem menuItem) {
        reload();
    }

    public void setOptions(InAppBrowserOptions inAppBrowserOptions, HashMap<String, Object> hashMap) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        InAppWebViewOptions inAppWebViewOptions = new InAppWebViewOptions();
        inAppWebViewOptions.parse((Map) hashMap);
        this.webView.setOptions(inAppWebViewOptions, hashMap);
        if (!(hashMap.get("hidden") == null || this.options.hidden == (bool5 = inAppBrowserOptions.hidden))) {
            if (bool5.booleanValue()) {
                hide();
            } else {
                show();
            }
        }
        if (!(hashMap.get("hideProgressBar") == null || this.options.hideProgressBar == (bool4 = inAppBrowserOptions.hideProgressBar) || this.progressBar == null)) {
            if (bool4.booleanValue()) {
                this.progressBar.setMax(0);
            } else {
                this.progressBar.setMax(100);
            }
        }
        if (!(this.actionBar == null || hashMap.get("hideTitleBar") == null || this.options.hideTitleBar == (bool3 = inAppBrowserOptions.hideTitleBar))) {
            this.actionBar.setDisplayShowTitleEnabled(!bool3.booleanValue());
        }
        if (!(this.actionBar == null || hashMap.get("hideToolbarTop") == null || this.options.hideToolbarTop == (bool2 = inAppBrowserOptions.hideToolbarTop))) {
            if (bool2.booleanValue()) {
                this.actionBar.hide();
            } else {
                this.actionBar.show();
            }
        }
        if (this.actionBar != null && hashMap.get("toolbarTopBackgroundColor") != null && !Util.objEquals(this.options.toolbarTopBackgroundColor, inAppBrowserOptions.toolbarTopBackgroundColor) && !inAppBrowserOptions.toolbarTopBackgroundColor.isEmpty()) {
            this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(inAppBrowserOptions.toolbarTopBackgroundColor)));
        }
        if (this.actionBar != null && hashMap.get("toolbarTopFixedTitle") != null && !Util.objEquals(this.options.toolbarTopFixedTitle, inAppBrowserOptions.toolbarTopFixedTitle) && !inAppBrowserOptions.toolbarTopFixedTitle.isEmpty()) {
            this.actionBar.setTitle((CharSequence) inAppBrowserOptions.toolbarTopFixedTitle);
        }
        if (!(hashMap.get("hideUrlBar") == null || this.options.hideUrlBar == (bool = inAppBrowserOptions.hideUrlBar))) {
            if (bool.booleanValue()) {
                this.menu.findItem(R.id.menu_search).setVisible(false);
            } else {
                this.menu.findItem(R.id.menu_search).setVisible(true);
            }
        }
        this.options = inAppBrowserOptions;
    }

    public void shareButtonClicked(MenuItem menuItem) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", this.webView.getUrl());
        startActivity(Intent.createChooser(intent, "Share"));
    }

    public void show() {
        this.isHidden = false;
        Intent intent = new Intent(this, InAppBrowserActivity.class);
        intent.setFlags(131072);
        startActivityIfNeeded(intent, 0);
    }
}
