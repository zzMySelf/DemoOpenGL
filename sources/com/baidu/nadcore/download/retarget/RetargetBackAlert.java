package com.baidu.nadcore.download.retarget;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.ioc.UadRuntime;
import com.baidu.nadcore.download.model.AdDownloadBean;
import com.baidu.nadcore.download.utils.AdDownloadUtil;
import com.baidu.nadcore.download.view.AdBackAlertDialog;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.sp.SpUtils;
import com.baidu.nadcore.stats.Als;
import com.baidu.nadcore.stats.request.ClogBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RetargetBackAlert {
    private static final long BACK_ALERT_DIALOG_INTERVAL = 600000;
    private static final String DIALOG_ALERT_UNINSTALL = "1";
    private static final String DIALOG_ALERT_UNOPEN = "2";
    private static final String KEY_LAST_ALERT_DIALOG_SHOW_TIME = "key_last_alert_dialog_show_time";
    public static final String REMINDED_TYPE_NONE = "reminded_type_none";
    public static final String REMINDED_TYPE_UNINSTALL = "reminded_type_uninstall";
    public static final String REMINDED_TYPE_UNOPEN = "reminded_type_unopen";
    private static final String TAG = "RetargetBackAlert";
    private static int mBackPressRecord;
    private static int mDialogShowRecord;
    private static long mLastBackAlertDialogShowTime;
    private final List<AdDownloadBean> mBackAlertDataCache;

    static /* synthetic */ int access$208() {
        int i2 = mBackPressRecord;
        mBackPressRecord = i2 + 1;
        return i2;
    }

    private RetargetBackAlert() {
        this.mBackAlertDataCache = new ArrayList();
    }

    public static RetargetBackAlert instance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RetargetBackAlert INSTANCE = new RetargetBackAlert();

        private InstanceHolder() {
        }
    }

    public void updateBackAlertDataCache(AdDownloadBean bean) {
        if (bean != null && bean.targetFile != null && bean.targetFile.exists()) {
            String appName = bean.mt.appName;
            String path = bean.targetFile.getAbsolutePath();
            if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(path)) {
                bean.ct.backAlertRemindType = REMINDED_TYPE_NONE;
                CollectionUtils.add(this.mBackAlertDataCache, bean);
            }
        }
    }

    public void showAdBackAlertDialog(final Activity activity, final BackProcessCallback backProcessCallback) {
        if (UadRuntime.instance().isMainActivity(activity) && backProcessCallback != null) {
            if (mLastBackAlertDialogShowTime == 0) {
                mLastBackAlertDialogShowTime = getLastAlertTime();
            }
            if (System.currentTimeMillis() - mLastBackAlertDialogShowTime < 600000) {
                backProcessCallback.backProcess();
                return;
            }
            final AdDownloadBean backAlertData = getBackAlertDownloadData();
            if (backAlertData == null) {
                backProcessCallback.backProcess();
                return;
            }
            new AdBackAlertDialog(activity).builder().setCancelable(false).setCanceledOnTouchOutside(false).setMsg(backAlertData).setPositiveButton(new View.OnClickListener() {
                public void onClick(View v) {
                    RetargetBackAlert.this.updateAlertShowTime();
                    UadRuntime.instance().setBackAlertDialogShowing(false);
                    RetargetBackAlert.this.reportAlsLog(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_POSITIVE, backAlertData);
                    if (TextUtils.equals(backAlertData.ct.backAlertRemindType, RetargetBackAlert.REMINDED_TYPE_UNOPEN)) {
                        AdDownloadUtil.openApp(backAlertData.packageName);
                        return;
                    }
                    AdDownloadUtil.installApk(backAlertData.targetFile, backAlertData.canLaunchInvoke());
                }
            }).setNegativeButton(new View.OnClickListener() {
                public void onClick(View v) {
                    RetargetBackAlert.this.updateAlertShowTime();
                    UadRuntime.instance().setBackAlertDialogShowing(false);
                    backProcessCallback.backProcess();
                    RetargetBackAlert.this.reportAlsLog(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_NEGATIVE, backAlertData);
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    RetargetBackAlert.access$208();
                    RetargetBackAlert.this.updateAlertShowTime();
                    RetargetBackAlert.this.reportAlsLog(ClogBuilder.LogType.FREE_CLICK, ClogBuilder.Area.DIALOG_KEYBACK, backAlertData);
                    if (UadRuntime.instance().isBack(activity)) {
                        UadRuntime.instance().updatePrevPressedTime(activity, System.currentTimeMillis());
                        backProcessCallback.backProcess();
                        return true;
                    }
                    backProcessCallback.exitProcess();
                    return true;
                }
            }).show();
            mDialogShowRecord++;
            UadRuntime.instance().setBackAlertDialogShowing(true);
            reportAlsLog(ClogBuilder.LogType.FREE_SHOW, ClogBuilder.Area.DIALOG, backAlertData);
        }
    }

    private AdDownloadBean getBackAlertDownloadData() {
        if (CollectionUtils.isNullOrEmpty(this.mBackAlertDataCache)) {
            return null;
        }
        List<AdDownloadBean> tempList = new ArrayList<>();
        AdDownloadBean alertOpenBean = null;
        AdDownloadBean alertInstallBean = null;
        int i2 = CollectionUtils.size(this.mBackAlertDataCache) - 1;
        while (true) {
            if (i2 < 0) {
                break;
            }
            AdDownloadBean bean = (AdDownloadBean) CollectionUtils.get(this.mBackAlertDataCache, i2);
            if (bean != null) {
                String packageName = bean.packageName;
                boolean hasInstalled = AdDownloadUtil.hasInstalled(packageName);
                boolean hasOpened = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + packageName).exists();
                if (hasInstalled) {
                    if (!hasOpened) {
                        bean.ct.backAlertRemindType = REMINDED_TYPE_UNOPEN;
                        alertOpenBean = bean;
                        CollectionUtils.add(tempList, bean);
                        break;
                    }
                    CollectionUtils.add(tempList, bean);
                } else if (AdDownloadUtil.isValidApk(bean.targetFile) && bean.status != AdDownloadStatus.NONE && TextUtils.equals(bean.ct.backAlertRemindType, REMINDED_TYPE_NONE) && alertInstallBean == null) {
                    bean.ct.backAlertRemindType = REMINDED_TYPE_UNINSTALL;
                    alertInstallBean = bean;
                }
            }
            i2--;
        }
        CollectionUtils.removeAll(this.mBackAlertDataCache, tempList);
        if (alertOpenBean != null) {
            return alertOpenBean;
        }
        return alertInstallBean;
    }

    /* access modifiers changed from: private */
    public void updateAlertShowTime() {
        long currentTimeMillis = System.currentTimeMillis();
        mLastBackAlertDialogShowTime = currentTimeMillis;
        saveLastAlertTime(currentTimeMillis);
    }

    public void updateBackPressRecord() {
        mBackPressRecord++;
    }

    private static void saveLastAlertTime(long time) {
        SpUtils.getInstance().getSp(SpUtils.SP_FILE_STARTUP).putLong(KEY_LAST_ALERT_DIALOG_SHOW_TIME, time);
    }

    private static long getLastAlertTime() {
        return SpUtils.getInstance().getSp(SpUtils.SP_FILE_STARTUP).getLong(KEY_LAST_ALERT_DIALOG_SHOW_TIME, 0);
    }

    /* access modifiers changed from: private */
    public void reportAlsLog(ClogBuilder.LogType logType, ClogBuilder.Area area, AdDownloadBean bean) {
        if (bean != null) {
            ClogBuilder builder = new ClogBuilder();
            builder.setPage(ClogBuilder.Page.POPUP);
            if (logType != null) {
                builder.setType(logType);
            }
            if (area != null) {
                builder.setArea(area);
            }
            if (!TextUtils.isEmpty(bean.mt.alsExt)) {
                builder.setExtraParam(bean.mt.alsExt);
            }
            builder.setExt1(String.valueOf(mBackPressRecord));
            builder.setExt2(String.valueOf(mDialogShowRecord));
            builder.setExt3(TextUtils.equals(bean.ct.backAlertRemindType, REMINDED_TYPE_UNINSTALL) ? "1" : "2");
            Als.send(builder);
        }
    }
}
