package com.baidu.nadcore.download.basic;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.nadcore.cmd.SchemeRouter;
import com.baidu.nadcore.core.AdRuntime;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.model.AdDownloadBean;
import com.baidu.nadcore.download.model.NadDownloadFailedMessage;
import com.baidu.nadcore.download.presenter.IAdDownloadObserver;
import com.baidu.nadcore.download.proxy.DownloaderFactory;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.download.utils.AdDownloadUtil;
import com.baidu.nadcore.exp.AdExpRuntime;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.nadcore.safe.MapUtils;
import com.baidu.nadcore.stats.Als;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.toast.ToastRuntime;
import com.baidu.nadcore.uad.R;
import com.baidu.searchbox.drag.LaunchDragUBCManager;
import com.baidu.searchbox.feed.ad.AdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

public class AdDownloadManager {
    private static final String TAG = "AdDownloadManager";
    private final ReentrantReadWriteLock mLock;
    private final HashMap<String, List<IAdDownloadObserver>> mObservers;
    private final IAdDownloader mProxy;

    /* synthetic */ AdDownloadManager(AnonymousClass1 x0) {
        this();
    }

    private AdDownloadManager() {
        this.mObservers = new HashMap<>(32);
        this.mLock = new ReentrantReadWriteLock();
        this.mProxy = DownloaderFactory.getDownloadProxy();
    }

    private static class Inner {
        /* access modifiers changed from: private */
        public static final AdDownloadManager INSTANCE = new AdDownloadManager((AnonymousClass1) null);

        private Inner() {
        }
    }

    public static AdDownloadManager instance() {
        return Inner.INSTANCE;
    }

    public void register(String key, IAdDownloadObserver o) {
        if (!TextUtils.isEmpty(key) && o != null) {
            this.mLock.writeLock().lock();
            try {
                List<IAdDownloadObserver> observers = (List) MapUtils.get(this.mObservers, key);
                if (observers == null) {
                    observers = new ArrayList<>();
                    MapUtils.put(this.mObservers, key, observers);
                }
                CollectionUtils.add(observers, o);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    public void unregister(String key, IAdDownloadObserver o) {
        if (!TextUtils.isEmpty(key) && o != null) {
            this.mLock.writeLock().lock();
            try {
                List<IAdDownloadObserver> observers = (List) MapUtils.get(this.mObservers, key);
                if (observers != null) {
                    CollectionUtils.remove(observers, o);
                    this.mLock.writeLock().unlock();
                }
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    public void start(AdDownloadBean data) {
        notify(AdDownloadAction.PROGRESS_UPDATE, data);
        data.taskId = this.mProxy.startDownload(data, new AdDownloaderCallback(data));
        data.status = AdDownloadStatus.DOWNLOADING;
    }

    public void start(AdDownloadBean data, AdDownloaderCallback currentCallback) {
        notify(AdDownloadAction.PROGRESS_UPDATE, data);
        data.taskId = this.mProxy.startDownload(data, currentCallback);
        data.status = AdDownloadStatus.DOWNLOADING;
    }

    public void pause(AdDownloadBean data) {
        this.mProxy.pauseDownload(data);
    }

    public void resume(AdDownloadBean data) {
        notify(AdDownloadAction.PROGRESS_UPDATE, data);
        this.mProxy.resumeDownload(data, new AdDownloaderCallback(data));
    }

    public void resume(AdDownloadBean data, AdDownloaderCallback currentCallback) {
        notify(AdDownloadAction.PROGRESS_UPDATE, data);
        this.mProxy.resumeDownload(data, currentCallback);
    }

    public void cancel(AdDownloadBean data) {
        if (!data.invalid()) {
            this.mProxy.cancelDownload(data);
            data.status = AdDownloadStatus.NONE;
            NadDownloadFailedMessage failedMessage = new NadDownloadFailedMessage();
            failedMessage.mBuiltinErrorMsg = "install_failed";
            notify(AdDownloadAction.FAIL, data, failedMessage);
        }
    }

    public void notify(AdDownloadAction action, AdDownloadBean data) {
        notify(action, data, (NadDownloadFailedMessage) null);
    }

    public void notify(AdDownloadAction action, AdDownloadBean data, NadDownloadFailedMessage failedMessage) {
        log(action, data, failedMessage);
        this.mLock.readLock().lock();
        try {
            List<IAdDownloadObserver> observers = (List) MapUtils.get(this.mObservers, data.getKey());
            if (observers != null) {
                for (int i2 = 0; i2 != CollectionUtils.size(observers); i2++) {
                    IAdDownloadObserver o = (IAdDownloadObserver) CollectionUtils.get(observers, i2);
                    if (o != null) {
                        if (o.getData() != null) {
                            o.getData().syncStatus(data);
                            o.onAction(action, o.getData());
                        }
                    }
                }
                this.mLock.readLock().unlock();
                onSingleAction(action, data);
            }
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public static void invokeApp(AdDownloadBean data) {
        if (TextUtils.isEmpty(data.mt.deferCmd) || !SchemeRouter.invoke(data.mt.deferCmd)) {
            AdDownloadUtil.openApp(data.packageName);
            log(AdDownloadAction.OPEN, data);
        } else if (AdExpRuntime.plat().info().getGlobalConfInt("nad_als_open_to_click_switch", 0) == 1) {
            log(AdDownloadAction.OPEN, data);
        }
    }

    public static void log(AdDownloadAction action, AdDownloadBean data) {
        log(action, data, (NadDownloadFailedMessage) null);
    }

    public static void log(AdDownloadAction action, AdDownloadBean data, NadDownloadFailedMessage failedMessage) {
        ClogBuilder.LogType type;
        if (!TextUtils.isEmpty(data.mt.alsExt)) {
            String area = data.ct.actionArea;
            switch (AnonymousClass1.$SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[action.ordinal()]) {
                case 1:
                    type = ClogBuilder.LogType.DOWNLOAD_START;
                    break;
                case 2:
                    type = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                    break;
                case 3:
                    type = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                    break;
                case 4:
                    type = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                    break;
                case 5:
                    type = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                    break;
                case 6:
                    type = ClogBuilder.LogType.INSTALL_COMPLETE;
                    break;
                case 7:
                    if (AdExpRuntime.plat().info().getGlobalConfInt("nad_als_open_to_click_switch", 0) != 1) {
                        type = ClogBuilder.LogType.DEEP_LINK;
                        break;
                    } else {
                        type = ClogBuilder.LogType.CLICK;
                        area = ClogBuilder.Area.OPEN_BUTTON.type;
                        break;
                    }
                case 8:
                    type = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    break;
                case 9:
                    type = ClogBuilder.LogType.DOWNLOAD_RETRY;
                    break;
                default:
                    return;
            }
            if (TextUtils.isEmpty(area)) {
                area = ClogBuilder.Area.DOWNLOAD_BUTTON.type;
            }
            ClogBuilder builder = new ClogBuilder();
            builder.setType(type).setExtraParam(data.mt.alsExt).setPage(data.ct.page).setArea(area).setExt1(data.packageName).setExt2(data.ct.page).setExt3(data.ct.business).setExt4(data.downloadUrl);
            JSONObject obj = new JSONObject();
            JSONUtils.put(obj, "is_swallow", 1);
            if (!TextUtils.isEmpty(data.ct.contentType)) {
                JSONUtils.put(obj, AdUtil.KEY_AD_DOWNLOAD_CONTENT_TYPE, data.ct.contentType);
            }
            if (data.ct.contentLength > 0) {
                JSONUtils.put(obj, AdUtil.KEY_AD_DOWNLOAD_CONTENT_LENGTH, data.ct.contentLength);
            }
            if (data.versionCode > 0) {
                JSONUtils.put(obj, "version_code", data.versionCode);
            }
            if (!TextUtils.isEmpty(data.versionName)) {
                JSONUtils.put(obj, "version_name", data.versionName);
            }
            if (failedMessage != null) {
                if (failedMessage.mException != null) {
                    JSONUtils.put(obj, "failed_reason", failedMessage.mException.getClass().toString());
                }
                if (failedMessage.mBuiltinErrorMsg != null) {
                    JSONUtils.put(obj, "failed_reason", failedMessage.mBuiltinErrorMsg);
                }
            }
            if (obj.length() > 0) {
                builder.setExt5(obj.toString());
            }
            Als.send(builder);
        }
    }

    /* renamed from: com.baidu.nadcore.download.basic.AdDownloadManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction;

        static {
            int[] iArr = new int[AdDownloadAction.values().length];
            $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.FAIL_RETRY.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onSingleAction(com.baidu.nadcore.download.consts.AdDownloadAction r5, com.baidu.nadcore.download.model.AdDownloadBean r6) {
        /*
            r4 = this;
            int[] r0 = com.baidu.nadcore.download.basic.AdDownloadManager.AnonymousClass1.$SwitchMap$com$baidu$nadcore$download$consts$AdDownloadAction
            int r1 = r5.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0065
        L_0x000c:
            r0 = 0
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            java.lang.ref.WeakReference<android.content.Context> r1 = r1.contextRef
            if (r1 == 0) goto L_0x001e
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            java.lang.ref.WeakReference<android.content.Context> r1 = r1.contextRef
            java.lang.Object r1 = r1.get()
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
        L_0x001e:
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            java.lang.String r1 = r1.startCmd
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0031
            if (r0 == 0) goto L_0x0031
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            java.lang.String r1 = r1.startCmd
            com.baidu.nadcore.cmd.SchemeRouter.invoke(r1, r0)
        L_0x0031:
            com.baidu.nadcore.download.model.AdDownloadControl r1 = r6.ct
            boolean r1 = r1.showStartDownloadToast
            if (r1 == 0) goto L_0x0044
            com.baidu.nadcore.toast.IToast r1 = com.baidu.nadcore.toast.ToastRuntime.impl()
            android.content.Context r2 = com.baidu.nadcore.core.AdRuntime.applicationContext()
            int r3 = com.baidu.nadcore.uad.R.string.nad_apk_download_start_toast
            r1.showToast((android.content.Context) r2, (int) r3)
        L_0x0044:
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            com.baidu.nadcore.download.model.AdDownloadCopy r1 = r1.copy
            if (r1 == 0) goto L_0x0065
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            com.baidu.nadcore.download.model.AdDownloadCopy r1 = r1.copy
            java.lang.String r1 = r1.text
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0065
            com.baidu.nadcore.download.model.AdDownloadMt r1 = r6.mt
            com.baidu.nadcore.download.model.AdDownloadCopy r1 = r1.copy
            java.lang.String r1 = r1.text
            com.baidu.nadcore.download.model.AdDownloadMt r2 = r6.mt
            com.baidu.nadcore.download.model.AdDownloadCopy r2 = r2.copy
            java.lang.String r2 = r2.toast
            r4.copyInviteCode(r1, r2)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.download.basic.AdDownloadManager.onSingleAction(com.baidu.nadcore.download.consts.AdDownloadAction, com.baidu.nadcore.download.model.AdDownloadBean):void");
    }

    private void copyInviteCode(String inviteCode, String toast) {
        Context context = AdRuntime.applicationContext();
        Object o = context.getSystemService(LaunchDragUBCManager.TYPE_CLIPBOARD);
        if (o instanceof ClipboardManager) {
            ((ClipboardManager) o).setPrimaryClip(ClipData.newPlainText(context.getResources().getString(R.string.nad_invite_code_label), inviteCode));
            ToastRuntime.impl().showToast(context, toast);
        }
    }
}
