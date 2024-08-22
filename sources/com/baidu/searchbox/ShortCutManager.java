package com.baidu.searchbox;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.android.common.logging.Log;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.database.OEMConfiguartion;
import com.baidu.searchbox.deprecation.R;
import com.baidu.searchbox.shortcut.CloudShortcutSpUtil;
import com.baidu.searchbox.speed.box.speedtask.LaunchTaskExecutor;
import com.baidu.searchbox.util.ShortcutUtils;
import com.baidu.searchbox.util.Utility;

public class ShortCutManager {
    private static final boolean DEBUG = SearchBox.GLOBAL_DEBUG;
    private static final String KEY_CREATE_SHORTCUT = "KEY_CREATE_SHORTCUT_3";
    private static final String KEY_DELETE_SHORTCUTS = "KEY_DELETE_SHORTCUTS_4";
    private static final int MAX_CREATE_SHORTCUT_TIMES = 10;
    public static final String SP_APP_SHORTCUT = "app_shortcut";
    private static final String TAG = "ShortCutManager";
    public static Runnable mCreateShortCutRunnable = new Runnable() {
        public void run() {
            if (ShortCutManager.sCreateShortcutsTimes > 0 && !ShortCutManager.addShortcutIfNeed(AppRuntime.getAppContext(), false)) {
                ShortCutManager.access$010();
                UiThreadUtil.runOnUiThread(ShortCutManager.mCreateShortCutRunnable, 5000);
            }
        }
    };
    /* access modifiers changed from: private */
    public static int sCreateShortcutsTimes = 10;

    static /* synthetic */ int access$010() {
        int i2 = sCreateShortcutsTimes;
        sCreateShortcutsTimes = i2 - 1;
        return i2;
    }

    public static boolean hasCreatedShortcut(Activity activity, String key) {
        int value = activity.getPreferences(0).getInt(key, 0);
        SharedPreferences pref = SearchBox.getAppContext().getSharedPreferences("app_shortcut", 0);
        if (pref.getInt(key, 0) == 0 && value == 1) {
            pref.edit().putInt(key, value).commit();
            return true;
        } else if (pref.getInt(key, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void setHasCreatedShortcut(String key, boolean hasCreated) {
        SearchBox.getAppContext().getSharedPreferences("app_shortcut", 0).edit().putInt(key, (int) hasCreated).commit();
    }

    public static void askForShortcuts(final Activity activity, boolean showDialog) {
        LaunchTaskExecutor.execute(new Runnable() {
            public void run() {
                Context ctx = AppRuntime.getAppContext();
                if (OEMConfiguartion.getInstance(ctx).isCreateVideoShortcut()) {
                    CloudShortcutSpUtil.parseDeskIconProtocol(ctx, CloudShortcutSpUtil.ShortCutType.FILM, CloudShortcutSpUtil.ShortCutStrategy.APP_CREATE);
                }
                if (OEMConfiguartion.getInstance(ctx).isCreateNovelShortcut()) {
                    CloudShortcutSpUtil.parseDeskIconProtocol(ctx, CloudShortcutSpUtil.ShortCutType.NOVEL, CloudShortcutSpUtil.ShortCutStrategy.APP_CREATE);
                }
                if (OEMConfiguartion.getInstance(ctx).isCreateBarcodeShortcut()) {
                    CloudShortcutSpUtil.parseDeskIconProtocol(ctx, CloudShortcutSpUtil.ShortCutType.CAMERA, CloudShortcutSpUtil.ShortCutStrategy.APP_CREATE);
                }
                if (OEMConfiguartion.getInstance(ctx).isCreateSpeechShortcut()) {
                    CloudShortcutSpUtil.parseDeskIconProtocol(ctx, CloudShortcutSpUtil.ShortCutType.SPEECH, CloudShortcutSpUtil.ShortCutStrategy.APP_CREATE);
                }
                if (!ShortCutManager.hasCreatedShortcut(activity, ShortCutManager.KEY_CREATE_SHORTCUT) && OEMConfiguartion.getInstance(AppRuntime.getAppContext()).isNeedCreateShortcut()) {
                    ShortCutManager.setHasCreatedShortcut(ShortCutManager.KEY_CREATE_SHORTCUT, true);
                    UiThreadUtil.runOnUiThread(ShortCutManager.mCreateShortCutRunnable);
                }
            }
        }, "AddShortCutToLauncher");
    }

    public static boolean addShortcutIfNeed(Context context, boolean showDialog) {
        if (ShortcutUtils.hasShortcut(context)) {
            return false;
        }
        if (showDialog) {
            new BoxAlertDialog.Builder(context).setTitle(R.string.shortcut_add_dialog_title).setPositiveButton(R.string.shortcut_add_dialog_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    ShortCutManager.addShortcut();
                }
            }).setNegativeButton(R.string.shortcut_add_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            }).show(true);
        } else {
            addShortcut();
        }
        return true;
    }

    public static void addShortcut() {
        if (!Utility.isSpecialVersion()) {
            Context context = AppRuntime.getAppContext();
            if (OEMConfiguartion.getInstance(context).isCreateBdShortcut()) {
                ShortcutUtils.addShortcut(context, R.string.app_name, com.baidu.android.common.ui.style.R.drawable.icon, "android.intent.action.MAIN", "android.intent.category.LAUNCHER", SplashActivity.class.getName(), (Bundle) null, (Uri) null, 2097152);
            }
            if (DEBUG) {
                Log.i(TAG, "create the main shortcut (Baidu).");
            }
        }
    }

    public static void deleteOldNameShortcuts(Context context) {
        if (!QuickPersistConfig.getInstance().getBoolean(KEY_DELETE_SHORTCUTS, false)) {
            QuickPersistConfig.getInstance().putBoolean(KEY_DELETE_SHORTCUTS, true);
            String[] oldAppNames = context.getResources().getStringArray(R.array.old_app_names);
            String[] classNames = {MainActivity.class.getName(), SplashActivity.class.getName()};
            for (String oldName : oldAppNames) {
                for (String className : classNames) {
                    ShortcutUtils.deleteShortcutByName(context, context.getPackageName(), className, oldName);
                }
            }
        }
    }
}
