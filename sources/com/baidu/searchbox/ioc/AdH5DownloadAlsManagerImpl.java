package com.baidu.searchbox.ioc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.searchbox.ad.IAdH5DownloadCenter;
import com.baidu.searchbox.ad.INadDownloadInfoReservedProxy;
import com.baidu.searchbox.ad.download.AdDownloadObserver;
import com.baidu.searchbox.ad.download.data.AdDownloadEvent;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import com.baidu.searchbox.ad.download.data.AppStatusChanged;
import com.baidu.searchbox.ad.download.utils.AdDownloadUtils;
import com.baidu.searchbox.ad.exp.AdPolicyGlobal;
import com.baidu.searchbox.ad.util.AdLruCache;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.AdStatEvent;
import com.baidu.searchbox.download.constants.DownloadStat;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.INadDevInfoProvider;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class AdH5DownloadAlsManagerImpl implements IAdH5DownloadCenter {
    private static final String ACTION_DOWNLOAD_APP_COMPLETE = "com.baidu.searchbox.download.APP_COMPLETE";
    private static final boolean DEBUG = AppConfig.isDebug();
    /* access modifiers changed from: private */
    public final AdLruCache<String, String> mAdExtInfoMap = new AdLruCache<>(32);
    private BroadcastReceiver mAppDownloadReceiver = null;
    /* access modifiers changed from: private */
    public final AdLruCache<String, String> mDeeplinkArrayMap = new AdLruCache<>(32);

    public void putDeeplinkUrl(String pkgName, String deepLinkUrl) {
        this.mDeeplinkArrayMap.put(pkgName, deepLinkUrl);
    }

    public String findDeeplink(String pkgName) {
        return (String) this.mDeeplinkArrayMap.get(pkgName);
    }

    /* access modifiers changed from: private */
    public void sendAls(String daType, String extInfo, String packageName, boolean isFromMarket) {
        if (!TextUtils.isEmpty(extInfo)) {
            Als.Builder builder = new Als.Builder();
            builder.setType(daType);
            builder.setPage(isFromMarket ? Als.Page.THIRD_PARTY_PAGE : Als.Page.APP_DOWNLOAD_CENTER);
            builder.setExtraParam(extInfo);
            builder.setExt1(packageName);
            try {
                PackageInfo packageInfo = FeedRuntime.getAppContext().getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String versionName = packageInfo.versionName;
                    int versionCode = packageInfo.versionCode;
                    JSONObject obj = new JSONObject();
                    if (versionCode > 0) {
                        JSONUtils.put(obj, "version_code", versionCode);
                    }
                    if (!TextUtils.isEmpty(versionName)) {
                        JSONUtils.put(obj, "version_name", versionName);
                    }
                    builder.setExt5(obj.toString());
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            Als.postADRealTimeLog(builder);
        }
    }

    public void putAdExtInfo(String pkgName, String extInfo) {
        if (!TextUtils.isEmpty(pkgName)) {
            this.mAdExtInfoMap.put(pkgName, extInfo);
        }
    }

    public void unregisterAdH5AppDownloadListener(Context context) {
        try {
            BroadcastReceiver broadcastReceiver = this.mAppDownloadReceiver;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
                this.mAppDownloadReceiver = null;
            }
        } catch (IllegalArgumentException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        BdEventBus.Companion.getDefault().unregister(DownloadCenterListener.class);
        BdEventBus.Companion.getDefault().unregister(StatusChangedListener.class);
        AdUtil.sendAdDownloadEvent(AdDownloadEvent.UNREGISTER_EVENT);
    }

    public void registerAdH5AppDownloadListener(Context context) {
        BdEventBus.Companion.getDefault().lazyRegister(DownloadCenterListener.class, AdStatEvent.class, 1, new DownloadCenterListener());
        BdEventBus.Companion.getDefault().lazyRegister(StatusChangedListener.class, AppStatusChanged.class, 1, new StatusChangedListener());
        if (this.mAppDownloadReceiver == null) {
            this.mAppDownloadReceiver = new AppDownloadCompleteBroadcastReceiver();
            IntentFilter appFilter = new IntentFilter();
            appFilter.addAction("com.baidu.searchbox.download.APP_COMPLETE");
            appFilter.addDataScheme("downloadid");
            context.registerReceiver(this.mAppDownloadReceiver, appFilter);
        }
    }

    private class StatusChangedListener implements Action<AppStatusChanged> {
        private StatusChangedListener() {
        }

        public void call(AppStatusChanged changed) {
            AdDownloadExtra.STATUS status;
            AdDownloadObserver observer = AdDownloadObserver.findObserverByPackageName(changed.packageName);
            switch (changed.status) {
                case 1:
                    if (observer == null || observer.getDownloadBean() == null) {
                        AdH5DownloadAlsManagerImpl.this.sendAls(Als.LogType.INSTALL_COMPLETE.type, TextUtils.isEmpty(changed.extInfo) ? (String) AdH5DownloadAlsManagerImpl.this.mAdExtInfoMap.get(changed.packageName) : changed.extInfo, changed.packageName, TextUtils.isEmpty(changed.extInfo));
                    } else if (TextUtils.equals(observer.getDownloadBean().adDownload.packageName, changed.packageName)) {
                        try {
                            PackageInfo packageInfo = FeedRuntime.getAppContext().getPackageManager().getPackageInfo(changed.packageName, 0);
                            if (packageInfo != null) {
                                observer.getDownloadBean().versionName = packageInfo.versionName;
                                observer.getDownloadBean().versionCode = packageInfo.versionCode;
                            }
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                        AdDownloadUtils.sendAls(Als.LogType.INSTALL_COMPLETE.type, "APP_NOTIFICATION", observer.getDownloadBean());
                        AdH5DownloadAlsManagerImpl.this.openAfterInstall(changed.packageName);
                        observer.mExtra.status = AdDownloadExtra.STATUS.STATUS_INSTALL_SUCCESS;
                        INadDownloadInfoReservedProxy.Impl.get().saveDownloadInfo(observer.getDownloadBean());
                    }
                    if (!TextUtils.isEmpty((CharSequence) AdH5DownloadAlsManagerImpl.this.mDeeplinkArrayMap.get(changed.packageName))) {
                        AdUtil.handleDelayInvoke((String) AdH5DownloadAlsManagerImpl.this.mDeeplinkArrayMap.get(changed.packageName));
                        return;
                    }
                    return;
                case 2:
                    if (observer != null && observer.getDownloadBean() != null && TextUtils.equals(observer.getDownloadBean().adDownload.packageName, changed.packageName)) {
                        if (observer.mExtra.uri == null || observer.mExtra.getPercent() != 100) {
                            status = AdDownloadExtra.STATUS.STATUS_NONE;
                        } else {
                            status = AdDownloadExtra.STATUS.STATUS_SUCCESS;
                        }
                        observer.mExtra.status = status;
                        INadDownloadInfoReservedProxy.Impl.get().sendAppInfoAls(observer.getDownloadBean());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private String extractPackageName(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            return data.getEncodedSchemeSpecificPart();
        }
        return null;
    }

    public void postInstallCompleteEvent(Intent intent) {
        String pkgName = extractPackageName(intent);
        if (!TextUtils.isEmpty(pkgName) && !TextUtils.isEmpty((CharSequence) this.mAdExtInfoMap.get(pkgName))) {
            BdEventBus.Companion.getDefault().post(new AppStatusChanged(pkgName, 1, (String) this.mAdExtInfoMap.get(pkgName)));
        }
    }

    /* access modifiers changed from: private */
    public static void postDownloadCompleteEvent(Intent intent) {
        AdStatEvent event = new AdStatEvent();
        String extra = intent.getStringExtra("extra");
        if (!TextUtils.isEmpty(extra)) {
            try {
                event.data = new JSONObject(extra).optString("ext_info");
                event.status = DownloadStat.COMPLETE;
                BdEventBus.Companion.getDefault().post(event);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class AppDownloadCompleteBroadcastReceiver extends BroadcastReceiver {
        private AppDownloadCompleteBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && TextUtils.equals("com.baidu.searchbox.download.APP_COMPLETE", intent.getAction())) {
                AdH5DownloadAlsManagerImpl.postDownloadCompleteEvent(intent);
            }
        }
    }

    private class DownloadCenterListener implements Action<AdStatEvent> {
        DownloadCenterListener() {
        }

        public void call(AdStatEvent event) {
            if (event != null && !TextUtils.isEmpty(event.data)) {
                String wiseInfo = event.data;
                DownloadStat status = event.status;
                if (!TextUtils.isEmpty(wiseInfo)) {
                    String status2Type = status2Type(status);
                    String extInfo = AdDownloadUtils.parseExtLogFromInfo(wiseInfo);
                    if (!TextUtils.isEmpty(extInfo) && !TextUtils.isEmpty(event.pkgName)) {
                        AdH5DownloadAlsManagerImpl.this.mAdExtInfoMap.put(event.pkgName, extInfo);
                    }
                }
            }
        }

        private String status2Type(DownloadStat status) {
            switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$download$constants$DownloadStat[status.ordinal()]) {
                case 1:
                    return Als.LogType.DOWNLOAD_START.type;
                case 2:
                    return Als.LogType.DOWNLOAD_PAUSE.type;
                case 3:
                    return Als.LogType.DOWNLOAD_CONTINUE.type;
                case 4:
                    return Als.LogType.DOWNLOAD_COMPLETE.type;
                case 5:
                    return Als.LogType.DOWNLOAD_INSTALL.type;
                default:
                    return "";
            }
        }
    }

    /* renamed from: com.baidu.searchbox.ioc.AdH5DownloadAlsManagerImpl$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat;

        static {
            int[] iArr = new int[DownloadStat.values().length];
            $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat = iArr;
            try {
                iArr[DownloadStat.START.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat[DownloadStat.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat[DownloadStat.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat[DownloadStat.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$constants$DownloadStat[DownloadStat.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void openAfterInstall(final String pkgName) {
        if (!TextUtils.isEmpty(pkgName) && !this.mDeeplinkArrayMap.containsKey(pkgName)) {
            int openSwitch = AdPolicyGlobal.INSTANCE.getOpenAfterInstall();
            if (openSwitch == 1 || openSwitch == 2 || needOpenAfterInstall4HWApi()) {
                Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
                    public void call(Long aLong) {
                        AdDownloadUtils.openApp(AdRuntimeHolder.getAdRuntime().context(), pkgName, false);
                    }
                });
            }
        }
    }

    private boolean needOpenAfterInstall4HWApi() {
        return AdPolicyGlobal.INSTANCE.getOperateBtnHwCmdSwitch() == 2 && (TextUtils.equals("HUAWEI", INadDevInfoProvider.Impl.get().getBrand("native")) || TextUtils.equals("HONOR", INadDevInfoProvider.Impl.get().getBrand("native")));
    }
}
