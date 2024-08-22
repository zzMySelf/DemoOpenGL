package com.baidu.searchbox.safemode.impl.upgrade;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.perf.safemode.SafeModeAlertDialog;
import com.baidu.perf.safemode.StatisticContext;
import com.baidu.perf.safemode.upgrade.IUpgrade;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.safemode.impl.R;

public class UpgradeImpl implements IUpgrade {
    private static final String TAG = "UpgradeImpl";

    public void upgrade(Activity context) {
        checkNewVersion(context);
    }

    private void checkNewVersion(final Activity context) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "checkNewVersion");
        }
        new Thread("check_app_version") {
            public void run() {
                super.run();
                UpgradeInfo upgradeInfo = UpgradeHttp.checkNewVersion(context);
                if (upgradeInfo != null) {
                    if (AppConfig.isDebug()) {
                        Log.d(UpgradeImpl.TAG, "upgradeData is do upgrade, " + upgradeInfo.mVersionName + "," + upgradeInfo.mVersionCode);
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode < upgradeInfo.mVersionCode) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    if (!context.isFinishing()) {
                                        UpgradeImpl.this.showDialogUpgrade(context);
                                    }
                                }
                            });
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void showDialogUpgrade(Activity context) {
        SafeModeAlertDialog.Builder builder = new SafeModeAlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.safemode_version_title));
        builder.setMessage(context.getResources().getString(R.string.safemode_version_info));
        builder.setNegativeButton(context.getResources().getString(R.string.safemode_version_quit), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                new Thread("safemode_upgrade_statistic") {
                    public void run() {
                        StatisticContext.getStatistic().onStatistic(2, 3, (String) null);
                    }
                }.start();
            }
        });
        Dialog dialogUpgrade = builder.create();
        dialogUpgrade.setCanceledOnTouchOutside(true);
        dialogUpgrade.show();
    }

    public static final class UpgradeInfo {
        public int mVersionCode;
        public String mVersionName;

        public UpgradeInfo(String versionName, int versionCode) {
            this.mVersionName = versionName;
            this.mVersionCode = versionCode;
        }
    }
}
