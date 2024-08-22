package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import androidx.browser.trusted.TrustedWebActivityIntent;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import java.util.List;

public class TrustedWebActivity extends ChromeCustomTabsActivity {
    public static final String LOG_TAG = "TrustedWebActivity";
    public TrustedWebActivityIntentBuilder builder;

    private void prepareCustomTabs() {
        String str = this.options.toolbarBackgroundColor;
        if (str != null && !str.isEmpty()) {
            this.builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(Color.parseColor(this.options.toolbarBackgroundColor)).build());
        }
        List<String> list = this.options.additionalTrustedOrigins;
        if (list != null && !list.isEmpty()) {
            this.builder.setAdditionalTrustedOrigins(this.options.additionalTrustedOrigins);
        }
        TrustedWebActivityDisplayMode trustedWebActivityDisplayMode = this.options.displayMode;
        if (trustedWebActivityDisplayMode != null) {
            this.builder.setDisplayMode(trustedWebActivityDisplayMode);
        }
        this.builder.setScreenOrientation(this.options.screenOrientation.intValue());
    }

    private void prepareCustomTabsIntent(TrustedWebActivityIntent trustedWebActivityIntent) {
        Intent intent = trustedWebActivityIntent.getIntent();
        String str = this.options.packageName;
        if (str == null) {
            str = CustomTabsHelper.getPackageNameToUse(this);
        }
        intent.setPackage(str);
        if (this.options.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, intent);
        }
    }

    public void customTabsConnected() {
        this.customTabsSession = this.customTabActivityHelper.getSession();
        Uri parse = Uri.parse(this.initialUrl);
        this.customTabActivityHelper.mayLaunchUrl(parse, (Bundle) null, (List<Bundle>) null);
        this.builder = new TrustedWebActivityIntentBuilder(parse);
        prepareCustomTabs();
        TrustedWebActivityIntent build = this.builder.build(this.customTabsSession);
        prepareCustomTabsIntent(build);
        CustomTabActivityHelper.openCustomTab((Activity) this, build, parse, 100);
    }
}
