package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.trusted.TrustedWebActivityIntent;
import java.util.List;

public class CustomTabActivityHelper implements ServiceConnectionCallback {
    public CustomTabsClient mClient;
    public CustomTabsServiceConnection mConnection;
    public ConnectionCallback mConnectionCallback;
    public CustomTabsCallback mCustomTabsCallback;
    public CustomTabsSession mCustomTabsSession;

    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    public static boolean isAvailable(Activity activity) {
        return CustomTabsHelper.getPackageNameToUse(activity) != null;
    }

    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri, int i2) {
        customTabsIntent.intent.setData(uri);
        activity.startActivityForResult(customTabsIntent.intent, i2);
    }

    public static void openCustomTab(Activity activity, TrustedWebActivityIntent trustedWebActivityIntent, Uri uri, int i2) {
        trustedWebActivityIntent.getIntent().setData(uri);
        activity.startActivityForResult(trustedWebActivityIntent.getIntent(), i2);
    }

    public void bindCustomTabsService(Activity activity) {
        String packageNameToUse;
        if (this.mClient == null && (packageNameToUse = CustomTabsHelper.getPackageNameToUse(activity)) != null) {
            ServiceConnection serviceConnection = new ServiceConnection(this);
            this.mConnection = serviceConnection;
            CustomTabsClient.bindCustomTabsService(activity, packageNameToUse, serviceConnection);
        }
    }

    public CustomTabsSession getSession() {
        CustomTabsSession newSession;
        CustomTabsClient customTabsClient = this.mClient;
        if (customTabsClient == null) {
            newSession = null;
        } else {
            if (this.mCustomTabsSession == null) {
                newSession = customTabsClient.newSession(this.mCustomTabsCallback);
            }
            return this.mCustomTabsSession;
        }
        this.mCustomTabsSession = newSession;
        return this.mCustomTabsSession;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        CustomTabsSession session;
        if (this.mClient == null || (session = getSession()) == null) {
            return false;
        }
        return session.mayLaunchUrl(uri, bundle, list);
    }

    public void onServiceConnected(CustomTabsClient customTabsClient) {
        this.mClient = customTabsClient;
        customTabsClient.warmup(0);
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsConnected();
        }
    }

    public void onServiceDisconnected() {
        this.mClient = null;
        this.mCustomTabsSession = null;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsDisconnected();
        }
    }

    public void setConnectionCallback(ConnectionCallback connectionCallback) {
        this.mConnectionCallback = connectionCallback;
    }

    public void setCustomTabsCallback(CustomTabsCallback customTabsCallback) {
        this.mCustomTabsCallback = customTabsCallback;
    }

    public void unbindCustomTabsService(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.mConnection;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.mClient = null;
            this.mCustomTabsSession = null;
            this.mConnection = null;
        }
    }
}
