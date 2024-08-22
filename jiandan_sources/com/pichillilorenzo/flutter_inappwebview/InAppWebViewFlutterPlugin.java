package com.pichillilorenzo.flutter_inappwebview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ChromeSafariBrowserManager;
import com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabaseHandler;
import com.pichillilorenzo.flutter_inappwebview.headless_in_app_webview.HeadlessInAppWebViewManager;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterView;

public class InAppWebViewFlutterPlugin implements FlutterPlugin, ActivityAware {
    public static final String LOG_TAG = "InAppWebViewFlutterPL";
    public static ValueCallback<Uri[]> filePathCallback;
    public static ValueCallback<Uri> filePathCallbackLegacy;
    @Nullable
    public Activity activity;
    @Nullable
    public ActivityPluginBinding activityPluginBinding;
    public Context applicationContext;
    public ChromeSafariBrowserManager chromeSafariBrowserManager;
    public CredentialDatabaseHandler credentialDatabaseHandler;
    public FlutterPlugin.FlutterAssets flutterAssets;
    public FlutterView flutterView;
    public FlutterWebViewFactory flutterWebViewFactory;
    public HeadlessInAppWebViewManager headlessInAppWebViewManager;
    public InAppBrowserManager inAppBrowserManager;
    public InAppWebViewStatic inAppWebViewStatic;
    public BinaryMessenger messenger;
    public MyCookieManager myCookieManager;
    public MyWebStorage myWebStorage;
    public PlatformUtil platformUtil;
    public PluginRegistry.Registrar registrar;
    public ServiceWorkerManager serviceWorkerManager;
    public WebViewFeatureManager webViewFeatureManager;

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger, Activity activity2, PlatformViewRegistry platformViewRegistry, FlutterView flutterView2) {
        this.applicationContext = context;
        this.activity = activity2;
        this.messenger = binaryMessenger;
        this.flutterView = flutterView2;
        this.inAppBrowserManager = new InAppBrowserManager(this);
        this.headlessInAppWebViewManager = new HeadlessInAppWebViewManager(this);
        this.chromeSafariBrowserManager = new ChromeSafariBrowserManager(this);
        FlutterWebViewFactory flutterWebViewFactory2 = new FlutterWebViewFactory(this);
        this.flutterWebViewFactory = flutterWebViewFactory2;
        platformViewRegistry.registerViewFactory("com.pichillilorenzo/flutter_inappwebview", flutterWebViewFactory2);
        this.platformUtil = new PlatformUtil(this);
        this.inAppWebViewStatic = new InAppWebViewStatic(this);
        this.myCookieManager = new MyCookieManager(this);
        this.myWebStorage = new MyWebStorage(this);
        if (Build.VERSION.SDK_INT >= 24) {
            this.serviceWorkerManager = new ServiceWorkerManager(this);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.credentialDatabaseHandler = new CredentialDatabaseHandler(this);
        }
        this.webViewFeatureManager = new WebViewFeatureManager(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar2) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = new InAppWebViewFlutterPlugin();
        inAppWebViewFlutterPlugin.registrar = registrar2;
        inAppWebViewFlutterPlugin.onAttachedToEngine(registrar2.context(), registrar2.messenger(), registrar2.activity(), registrar2.platformViewRegistry(), registrar2.view());
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding2) {
        this.activityPluginBinding = activityPluginBinding2;
        this.activity = activityPluginBinding2.getActivity();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterAssets = flutterPluginBinding.getFlutterAssets();
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), this.activity, flutterPluginBinding.getPlatformViewRegistry(), (FlutterView) null);
    }

    public void onDetachedFromActivity() {
        this.activityPluginBinding = null;
        this.activity = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.activityPluginBinding = null;
        this.activity = null;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        PlatformUtil platformUtil2 = this.platformUtil;
        if (platformUtil2 != null) {
            platformUtil2.dispose();
            this.platformUtil = null;
        }
        InAppBrowserManager inAppBrowserManager2 = this.inAppBrowserManager;
        if (inAppBrowserManager2 != null) {
            inAppBrowserManager2.dispose();
            this.inAppBrowserManager = null;
        }
        HeadlessInAppWebViewManager headlessInAppWebViewManager2 = this.headlessInAppWebViewManager;
        if (headlessInAppWebViewManager2 != null) {
            headlessInAppWebViewManager2.dispose();
            this.headlessInAppWebViewManager = null;
        }
        ChromeSafariBrowserManager chromeSafariBrowserManager2 = this.chromeSafariBrowserManager;
        if (chromeSafariBrowserManager2 != null) {
            chromeSafariBrowserManager2.dispose();
            this.chromeSafariBrowserManager = null;
        }
        MyCookieManager myCookieManager2 = this.myCookieManager;
        if (myCookieManager2 != null) {
            myCookieManager2.dispose();
            this.myCookieManager = null;
        }
        MyWebStorage myWebStorage2 = this.myWebStorage;
        if (myWebStorage2 != null) {
            myWebStorage2.dispose();
            this.myWebStorage = null;
        }
        CredentialDatabaseHandler credentialDatabaseHandler2 = this.credentialDatabaseHandler;
        if (credentialDatabaseHandler2 != null && Build.VERSION.SDK_INT >= 26) {
            credentialDatabaseHandler2.dispose();
            this.credentialDatabaseHandler = null;
        }
        InAppWebViewStatic inAppWebViewStatic2 = this.inAppWebViewStatic;
        if (inAppWebViewStatic2 != null) {
            inAppWebViewStatic2.dispose();
            this.inAppWebViewStatic = null;
        }
        ServiceWorkerManager serviceWorkerManager2 = this.serviceWorkerManager;
        if (serviceWorkerManager2 != null && Build.VERSION.SDK_INT >= 24) {
            serviceWorkerManager2.dispose();
            this.serviceWorkerManager = null;
        }
        WebViewFeatureManager webViewFeatureManager2 = this.webViewFeatureManager;
        if (webViewFeatureManager2 != null) {
            webViewFeatureManager2.dispose();
            this.webViewFeatureManager = null;
        }
        filePathCallbackLegacy = null;
        filePathCallback = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding2) {
        this.activityPluginBinding = activityPluginBinding2;
        this.activity = activityPluginBinding2.getActivity();
    }
}
