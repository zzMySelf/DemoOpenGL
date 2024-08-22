package com.baidu.appsearch.lite;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appsearch.R;
import com.baidu.searchbox.common.security.ComLogger;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import java.io.File;

public class InstallAppsearchActivity extends BaseActivity {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "InstallAppsearchActivity";
    private String mFilePath;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            ComLogger.log(TAG, (String) null);
            if (DEBUG) {
                Log.i(TAG, "onCreate");
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.mFilePath = intent.getStringExtra("apk_path");
            }
            MigrateStatisticUtils.invoke("016004", MigrateStatisticUtils.build(""));
            boolean isInstallAppsearch = false;
            try {
                PackageInfo app = getPackageManager().getPackageInfo("com.baidu.appsearch", 64);
                if (app != null && app.packageName.equals("com.baidu.appsearch")) {
                    isInstallAppsearch = true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (isInstallAppsearch) {
                AppsearchUtils.openApp(getApplicationContext(), "com.baidu.appsearch", true);
                AppsearchUtils.deleteAppsearchShortCut(getApplicationContext());
            } else if (TextUtils.isEmpty(this.mFilePath) || !AppsearchUtils.isAPKFileValid(this.mFilePath, getApplicationContext())) {
                UniversalToast.makeText(getApplicationContext(), (CharSequence) getString(R.string.apk_not_found)).showToast();
                AppsearchUtils.deleteAppsearchShortCut(getApplicationContext());
            } else {
                AppsearchUtils.startSystemInstallUI(this, new File(this.mFilePath));
            }
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (DEBUG) {
            Log.i(TAG, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        if (DEBUG) {
            Log.i(TAG, PluginInvokerConstants.METHOD_ACTIVITY_ONRESTART);
        }
        super.onRestart();
        finish();
    }
}
