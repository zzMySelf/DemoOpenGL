package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.baidu.aiscan.R;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.CustomTabActivityHelper;
import com.pichillilorenzo.flutter_inappwebview.types.CustomTabsActionButton;
import com.pichillilorenzo.flutter_inappwebview.types.CustomTabsMenuItem;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChromeCustomTabsActivity extends Activity implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "CustomTabsActivity";
    public final int CHROME_CUSTOM_TAB_REQUEST_CODE = 100;
    @Nullable
    public CustomTabsActionButton actionButton;
    public CustomTabsIntent.Builder builder;
    public MethodChannel channel;
    public CustomTabActivityHelper customTabActivityHelper = new CustomTabActivityHelper();
    @Nullable
    public CustomTabsSession customTabsSession;
    public String id;
    public String initialUrl;
    @Nullable
    public ChromeSafariBrowserManager manager;
    public List<CustomTabsMenuItem> menuItems = new ArrayList();
    public boolean onChromeSafariBrowserCompletedInitialLoad = false;
    public boolean onChromeSafariBrowserOpened = false;
    public ChromeCustomTabsOptions options;

    private PendingIntent createPendingIntent(int i2) {
        Intent intent = new Intent(this, ActionBroadcastReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putInt(ActionBroadcastReceiver.KEY_ACTION_ID, i2);
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.id);
        bundle.putString(ActionBroadcastReceiver.CHROME_MANAGER_ID, this.manager.id);
        intent.putExtras(bundle);
        return PendingIntent.getBroadcast(this, i2, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
    }

    private void prepareCustomTabs() {
        ChromeCustomTabsOptions chromeCustomTabsOptions = this.options;
        Boolean bool = chromeCustomTabsOptions.addDefaultShareMenuItem;
        if (bool != null) {
            this.builder.setShareState(bool.booleanValue() ? 1 : 2);
        } else {
            this.builder.setShareState(chromeCustomTabsOptions.shareState.intValue());
        }
        String str = this.options.toolbarBackgroundColor;
        if (str != null && !str.isEmpty()) {
            this.builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(Color.parseColor(this.options.toolbarBackgroundColor)).build());
        }
        this.builder.setShowTitle(this.options.showTitle.booleanValue());
        this.builder.setUrlBarHidingEnabled(this.options.enableUrlBarHiding.booleanValue());
        this.builder.setInstantAppsEnabled(this.options.instantAppsEnabled.booleanValue());
        for (CustomTabsMenuItem next : this.menuItems) {
            this.builder.addMenuItem(next.getLabel(), createPendingIntent(next.getId()));
        }
        CustomTabsActionButton customTabsActionButton = this.actionButton;
        if (customTabsActionButton != null) {
            byte[] icon = customTabsActionButton.getIcon();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inMutable = true;
            this.builder.setActionButton(BitmapFactory.decodeByteArray(icon, 0, icon.length, options2), this.actionButton.getDescription(), createPendingIntent(this.actionButton.getId()), this.actionButton.isShouldTint());
        }
    }

    private void prepareCustomTabsIntent(CustomTabsIntent customTabsIntent) {
        String str = this.options.packageName;
        if (str != null) {
            customTabsIntent.intent.setPackage(str);
        } else {
            customTabsIntent.intent.setPackage(CustomTabsHelper.getPackageNameToUse(this));
        }
        if (this.options.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent);
        }
    }

    public void close() {
        this.customTabsSession = null;
        finish();
        this.channel.invokeMethod("onChromeSafariBrowserClosed", new HashMap());
    }

    public void customTabsConnected() {
        this.customTabsSession = this.customTabActivityHelper.getSession();
        Uri parse = Uri.parse(this.initialUrl);
        this.customTabActivityHelper.mayLaunchUrl(parse, (Bundle) null, (List<Bundle>) null);
        this.builder = new CustomTabsIntent.Builder(this.customTabsSession);
        prepareCustomTabs();
        CustomTabsIntent build = this.builder.build();
        prepareCustomTabsIntent(build);
        CustomTabActivityHelper.openCustomTab((Activity) this, build, parse, 100);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.manager = null;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 100) {
            close();
            dispose();
        }
    }

    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        BinaryMessenger binaryMessenger;
        super.onCreate(bundle);
        setContentView(R.layout.chrome_custom_tabs_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.id = extras.getString("id");
            ChromeSafariBrowserManager chromeSafariBrowserManager = ChromeSafariBrowserManager.shared.get(extras.getString("managerId"));
            this.manager = chromeSafariBrowserManager;
            if (chromeSafariBrowserManager != null && (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) != null && (binaryMessenger = inAppWebViewFlutterPlugin.messenger) != null) {
                MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_chromesafaribrowser_" + this.id);
                this.channel = methodChannel;
                methodChannel.setMethodCallHandler(this);
                this.initialUrl = extras.getString("url");
                ChromeCustomTabsOptions chromeCustomTabsOptions = new ChromeCustomTabsOptions();
                this.options = chromeCustomTabsOptions;
                chromeCustomTabsOptions.parse((Map) extras.getSerializable("options"));
                this.actionButton = CustomTabsActionButton.fromMap((Map) extras.getSerializable("actionButton"));
                for (Map fromMap : (List) extras.getSerializable("menuItemList")) {
                    this.menuItems.add(CustomTabsMenuItem.fromMap(fromMap));
                }
                this.customTabActivityHelper.setConnectionCallback(new CustomTabActivityHelper.ConnectionCallback() {
                    public void onCustomTabsConnected() {
                        ChromeCustomTabsActivity.this.customTabsConnected();
                    }

                    public void onCustomTabsDisconnected() {
                        this.close();
                        ChromeCustomTabsActivity.this.dispose();
                    }
                });
                this.customTabActivityHelper.setCustomTabsCallback(new CustomTabsCallback() {
                    public void extraCallback(String str, Bundle bundle) {
                    }

                    public void onMessageChannelReady(Bundle bundle) {
                    }

                    public void onNavigationEvent(int i2, Bundle bundle) {
                        if (i2 == 5) {
                            ChromeCustomTabsActivity chromeCustomTabsActivity = ChromeCustomTabsActivity.this;
                            if (!chromeCustomTabsActivity.onChromeSafariBrowserOpened) {
                                chromeCustomTabsActivity.onChromeSafariBrowserOpened = true;
                                ChromeCustomTabsActivity.this.channel.invokeMethod("onChromeSafariBrowserOpened", new HashMap());
                            }
                        }
                        if (i2 == 2) {
                            ChromeCustomTabsActivity chromeCustomTabsActivity2 = ChromeCustomTabsActivity.this;
                            if (!chromeCustomTabsActivity2.onChromeSafariBrowserCompletedInitialLoad) {
                                chromeCustomTabsActivity2.onChromeSafariBrowserCompletedInitialLoad = true;
                                ChromeCustomTabsActivity.this.channel.invokeMethod("onChromeSafariBrowserCompletedInitialLoad", new HashMap());
                            }
                        }
                    }

                    public void onPostMessage(String str, Bundle bundle) {
                    }

                    public void onRelationshipValidationResult(int i2, Uri uri, boolean z, Bundle bundle) {
                    }
                });
            }
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        String str = methodCall.method;
        if (((str.hashCode() == 94756344 && str.equals("close")) ? (char) 0 : 65535) != 0) {
            result.notImplemented();
            return;
        }
        onStop();
        onDestroy();
        close();
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (!(chromeSafariBrowserManager == null || (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) == null || inAppWebViewFlutterPlugin.activity == null)) {
            Activity activity = this.manager.plugin.activity;
            Intent intent = new Intent(activity, activity.getClass());
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            this.manager.plugin.activity.startActivity(intent);
        }
        dispose();
        result.success(Boolean.TRUE);
    }

    public void onStart() {
        super.onStart();
        this.customTabActivityHelper.bindCustomTabsService(this);
    }

    public void onStop() {
        super.onStop();
        this.customTabActivityHelper.unbindCustomTabsService(this);
    }
}
