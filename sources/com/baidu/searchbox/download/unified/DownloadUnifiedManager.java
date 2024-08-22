package com.baidu.searchbox.download.unified;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.download.DownloadStatisticsUBC;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.containers.nps.netdisk.face.INetdiskPluginFace;
import com.baidu.searchbox.containers.nps.netdisk.face.data.NetDiskRapidDownloadLinkInfo;
import com.baidu.searchbox.containers.nps.netdisk.face.data.NetDiskRapidEnableQueryInfo;
import com.baidu.searchbox.download.P2pNetDiskRapidDownloadCallback;
import com.baidu.searchbox.download.business.util.P2pNetDiskDownloadUtilsKt;
import com.baidu.searchbox.download.callback.FileDownloadListener;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.P2pNetDiskDownloadInfo;
import com.baidu.searchbox.download.unified.EventActionForResume;
import com.baidu.searchbox.download.unified.EventActionForStart;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.db.DBHelper;
import com.baidu.searchbox.download.util.DebugUtilsKt;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.downloads.DownloadMessageSender;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

public class DownloadUnifiedManager {
    private static DownloadUnifiedManager mInstance;

    private DownloadUnifiedManager() {
    }

    public static DownloadUnifiedManager getInstance() {
        if (mInstance == null) {
            synchronized (DownloadUnifiedManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadUnifiedManager();
                }
            }
        }
        return mInstance;
    }

    public void startDownloadWithoutInDownloadPage(Context context, String source, DownloadParams downloadParams, IDownloadListener downloadListener) {
        DownloadParams downloadParams2 = downloadParams;
        DownloadStatisticsUBC.downloadButtonClick(source);
        downloadParams2.setVisibleInDownloadsUI(false);
        downloadParams2.setShowStartDownloadToast(false);
        downloadParams2.setVisibleInNotification(2);
        if (checkParamsForStart(source, downloadParams, (EventControlInfoForStart) null, downloadListener, (EventCallback) null)) {
            EventControlInfoForStart eventControlInfoForStart = new EventControlInfoForStart(false, false, false);
            List<EventActionForStart> eventActions = new ArrayList<>();
            eventActions.add(new EventActionForStart.CheckNetEvent(context, source, downloadParams, downloadListener, eventControlInfoForStart, (EventCallback) null));
            Context context2 = context;
            String str = source;
            DownloadParams downloadParams3 = downloadParams;
            IDownloadListener iDownloadListener = downloadListener;
            EventControlInfoForStart eventControlInfoForStart2 = eventControlInfoForStart;
            eventActions.add(new EventActionForStart.CheckExternalStoragePermission(context2, str, downloadParams3, iDownloadListener, eventControlInfoForStart2, (EventCallback) null));
            eventActions.add(new EventActionForStart.CheckDuplicateEvent(context2, str, downloadParams3, iDownloadListener, eventControlInfoForStart2, (EventCallback) null));
            doEventActinosForStart(eventActions);
        }
    }

    public void startDownload(Context context, String source, DownloadParams downloadParams, IDownloadListener downloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
        DownloadStatisticsUBC.downloadButtonClick(source);
        if (checkParamsForStart(source, downloadParams, eventControlInfoForStart, downloadListener, eventCallback)) {
            if (eventControlInfoForStart == null) {
                eventControlInfoForStart = new EventControlInfoForStart(true, true, true);
            }
            List<EventActionForStart> eventActions = new ArrayList<>();
            Context context2 = context;
            String str = source;
            DownloadParams downloadParams2 = downloadParams;
            IDownloadListener iDownloadListener = downloadListener;
            EventControlInfoForStart eventControlInfoForStart2 = eventControlInfoForStart;
            EventCallback eventCallback2 = eventCallback;
            eventActions.add(new EventActionForStart.CheckNetEvent(context2, str, downloadParams2, iDownloadListener, eventControlInfoForStart2, eventCallback2));
            eventActions.add(new EventActionForStart.CheckExternalStoragePermission(context2, str, downloadParams2, iDownloadListener, eventControlInfoForStart2, eventCallback2));
            eventActions.add(new EventActionForStart.CheckDuplicateEvent(context2, str, downloadParams2, iDownloadListener, eventControlInfoForStart2, eventCallback2));
            doEventActinosForStart(eventActions);
        }
    }

    @Deprecated
    public void resumeDownload(Context context, String source, Uri downloadUri, IDownloadListener downloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        resumeDownload(context, new ResumeParams(source, false), downloadUri, downloadListener, eventControlInfoForResume, eventCallback);
    }

    public void resumeDownload(Context context, ResumeParams resumeParams, Uri downloadUri, IDownloadListener downloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        if (checkParamsForResume(resumeParams, downloadUri, downloadListener, eventControlInfoForResume, eventCallback)) {
            if (eventControlInfoForResume == null) {
                eventControlInfoForResume = new EventControlInfoForResume(true, true);
            }
            List<EventActionForResume> eventActions = new ArrayList<>();
            Context context2 = context;
            ResumeParams resumeParams2 = resumeParams;
            Uri uri = downloadUri;
            IDownloadListener iDownloadListener = downloadListener;
            EventControlInfoForResume eventControlInfoForResume2 = eventControlInfoForResume;
            EventCallback eventCallback2 = eventCallback;
            eventActions.add(new EventActionForResume.CheckNetEvent(context2, resumeParams2, uri, iDownloadListener, eventControlInfoForResume2, eventCallback2));
            eventActions.add(new EventActionForResume.CheckExternalStoragePermission(context2, resumeParams2, uri, iDownloadListener, eventControlInfoForResume2, eventCallback2));
            doEventActionsForResume(eventActions);
        }
    }

    public void pauseDownload(Uri uri) {
        DownloadManagerExt.getInstance().pauseDownload(uri);
    }

    public void pauseDownloadAsync(final Uri uri) {
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                DownloadUnifiedManager.this.pauseDownload(uri);
            }
        }, "pauseDownloadAsync");
    }

    public void deleteDownload(Uri uri) {
        DownloadManagerExt.getInstance().cancelDownload(uri);
        DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
    }

    public void deleteDownloadAsync(final Uri uri) {
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                DownloadUnifiedManager.this.deleteDownload(uri);
            }
        }, "deleteDownloadAsync");
    }

    public DownloadInfoData queryDownloadInfoData(Uri uri) {
        return DBHelper.queryDownloadInfoData(uri);
    }

    public void queryDownloadInfoDataAsync(final Uri uri, final DownloadInfoDatasCallback callback) {
        if (uri != null && callback != null) {
            ExecutorUtilsExt.postOnSerial(new Runnable() {
                public void run() {
                    DownloadInfoData data = DownloadUnifiedManager.this.queryDownloadInfoData(uri);
                    final List<DownloadInfoData> datas = new ArrayList<>();
                    if (data != null) {
                        datas.add(data);
                    }
                    UiThreadUtils.getMainHandler().post(new Runnable() {
                        public void run() {
                            callback.callback(datas);
                        }
                    });
                }
            }, "queryDownloadInfoDataAsync");
        }
    }

    public void queryDownloadInfoDataAsync(final String url, final DownloadInfoDatasCallback callback) {
        if (url != null && callback != null) {
            ExecutorUtilsExt.postOnSerial(new Runnable() {
                public void run() {
                    final List<DownloadInfoData> datas = DBHelper.queryDownloadInfoWithUrl(url);
                    UiThreadUtils.getMainHandler().post(new Runnable() {
                        public void run() {
                            callback.callback(datas);
                        }
                    });
                }
            }, "queryDownloadInfoDataAsync");
        }
    }

    /* access modifiers changed from: private */
    public void doEventActinosForStart(final List<EventActionForStart> eventActions) {
        if (eventActions.size() > 0) {
            eventActions.remove(0).action(new IContinue<EventActionForStart>() {
                public void continueCall(boolean yes, final EventActionForStart eventAction) {
                    if (!yes) {
                        return;
                    }
                    if (eventActions.size() > 0) {
                        DownloadUnifiedManager.this.doEventActinosForStart(eventActions);
                    } else {
                        ExecutorUtilsExt.postOnSerial(new Runnable() {
                            public void run() {
                                final String source = eventAction.getSource();
                                final DownloadParams downloadParams = eventAction.getDownloadParams();
                                final Uri uri = DBHelper.doDownload(source, downloadParams);
                                UiThreadUtils.getMainHandler().post(new Runnable() {
                                    public void run() {
                                        IDownloadListener listener = eventAction.getDownloadListener();
                                        EventCallback eventCallback = eventAction.getEventCallback();
                                        if (uri != null) {
                                            if (listener != null) {
                                                DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), uri, new FileDownloadListener(AppRuntime.getAppContext(), listener));
                                            }
                                            if (eventCallback != null) {
                                                eventCallback.callBack(1, new EventCallback.EventBackInfo(uri));
                                            }
                                            DownloadMessageSender.sendBeginMessage(source, downloadParams);
                                            P2pNetDiskDownloadUtilsKt.checkAndSaveP2pNetDiskDownloadInfoToDb(uri, downloadParams.getP2pNetDiskDownloadInfo());
                                        } else if (eventCallback != null) {
                                            eventCallback.callBack(2, new EventCallback.EventBackInfo(111));
                                        }
                                    }
                                });
                            }
                        }, "doDownload");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doEventActionsForResume(final List<EventActionForResume> eventActions) {
        if (eventActions.size() > 0) {
            eventActions.remove(0).action(new IContinue<EventActionForResume>() {
                public void continueCall(boolean yes, final EventActionForResume eventActionForResume) {
                    if (!yes) {
                        return;
                    }
                    if (eventActions.size() > 0) {
                        DownloadUnifiedManager.this.doEventActionsForResume(eventActions);
                    } else {
                        ExecutorUtilsExt.postOnSerial(new Runnable() {
                            public void run() {
                                final Uri uri = eventActionForResume.getDownloadUri();
                                final ResumeParams resumeParams = eventActionForResume.resumeParams;
                                final DownloadInfoData downloadInfo = DBHelper.doResumeDownloadForUri(uri);
                                UiThreadUtils.getMainHandler().post(new Runnable() {
                                    public void run() {
                                        IDownloadListener listener = eventActionForResume.getDownloadListener();
                                        EventCallback eventCallback = eventActionForResume.getEventCallback();
                                        if (downloadInfo != null) {
                                            if (listener != null) {
                                                FileDownloadListener fileDownloadListener = new FileDownloadListener(AppRuntime.getAppContext(), listener);
                                                DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
                                                DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), uri, fileDownloadListener);
                                            }
                                            if (eventCallback != null) {
                                                eventCallback.callBack(1, (EventCallback.EventBackInfo) null);
                                            }
                                            DownloadMessageSender.sendResumeMessage(resumeParams, downloadInfo.getFileName(), downloadInfo.getExtraInfo());
                                        } else if (eventCallback != null) {
                                            eventCallback.callBack(2, new EventCallback.EventBackInfo(112));
                                        }
                                    }
                                });
                            }
                        }, "doResume");
                    }
                }
            });
        }
    }

    private boolean checkParamsForStart(String source, DownloadParams downloadParams, EventControlInfoForStart eventControlInfo, IDownloadListener downloadListener, EventCallback eventCallback) {
        if (TextUtils.isEmpty(source) || source.length() > 30) {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(101));
            }
            return false;
        } else if (downloadParams == null) {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(102));
            }
            return false;
        } else if (!TextUtils.isEmpty(downloadParams.getUrl())) {
            return true;
        } else {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(103));
            }
            return false;
        }
    }

    private boolean checkParamsForResume(ResumeParams resumeParams, Uri downloadUri, IDownloadListener downloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        if (resumeParams == null) {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(102));
            }
            return false;
        }
        String source = resumeParams.getSource();
        if (TextUtils.isEmpty(source) || source.length() > 30) {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(101));
            }
            return false;
        } else if (downloadUri != null) {
            return true;
        } else {
            if (eventCallback != null) {
                eventCallback.callBack(2, new EventCallback.EventBackInfo(104));
            }
            return false;
        }
    }

    public void startP2pDownload(Context context, String source, DownloadParams downloadParams, IP2pDownloadListener p2pDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda0());
        if (checkParamsForStart(source, downloadParams, eventControlInfoForStart, p2pDownloadListener, eventCallback)) {
            if (eventControlInfoForStart == null) {
                eventControlInfoForStart = new EventControlInfoForStart(true, true, true);
            }
            List<EventActionForStart> eventActions = new ArrayList<>();
            Context context2 = context;
            String str = source;
            DownloadParams downloadParams2 = downloadParams;
            IP2pDownloadListener iP2pDownloadListener = p2pDownloadListener;
            EventControlInfoForStart eventControlInfoForStart2 = eventControlInfoForStart;
            EventCallback eventCallback2 = eventCallback;
            eventActions.add(new EventActionForStart.CheckNetEvent(context2, str, downloadParams2, iP2pDownloadListener, eventControlInfoForStart2, eventCallback2));
            eventActions.add(new EventActionForStart.CheckExternalStoragePermission(context2, str, downloadParams2, iP2pDownloadListener, eventControlInfoForStart2, eventCallback2));
            eventActions.add(new EventActionForStart.CheckDuplicateEvent(context2, str, downloadParams2, iP2pDownloadListener, eventControlInfoForStart2, eventCallback2));
            doEventActionsForP2pStart(context, eventActions);
        }
    }

    static /* synthetic */ String lambda$startP2pDownload$0() {
        return "DownloadUnifiedManager.startP2pDownload: -------------------------------------------------------";
    }

    public void transferP2pDownload(final Context context, final Uri uri, final IP2pDownloadListener downloadListener) {
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda8());
        long id = DownloadHelper.getIdFromUri(uri);
        if (context == null || id == -1) {
            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda9());
            if (downloadListener != null) {
                downloadListener.onError(-1);
                return;
            }
            return;
        }
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda10(uri));
        queryDownloadInfoDataAsync(uri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
            public void callback(final List<DownloadInfoData> datas) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        List list = datas;
                        if (list != null && list.size() > 0) {
                            final DownloadInfoData downloadInfoData = (DownloadInfoData) datas.get(0);
                            if (downloadInfoData.getStatus() == 2 || downloadInfoData.getStatus() == 4) {
                                final INetdiskPluginFace iNetDiskPluginFace = P2pNetDiskDownloadUtilsKt.getINetDiskPluginFace();
                                if (iNetDiskPluginFace == null) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$$ExternalSyntheticLambda1());
                                    if (downloadListener != null) {
                                        downloadListener.onError(-1);
                                    }
                                } else if (!iNetDiskPluginFace.isNetDiskPluginAvailable()) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$$ExternalSyntheticLambda2());
                                    if (downloadListener != null) {
                                        downloadListener.onError(-1);
                                    }
                                    iNetDiskPluginFace.prefetchNetDiskPluginOnBackground(context, new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            return null;
                                        }
                                    });
                                } else {
                                    iNetDiskPluginFace.isP2pDownloadEnable(new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            if (!aBoolean.booleanValue()) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$$ExternalSyntheticLambda0());
                                                if (downloadListener != null) {
                                                    downloadListener.onError(-1);
                                                }
                                                return null;
                                            }
                                            try {
                                                String p2pInfoJson = new JSONObject(downloadInfoData.getExtraInfo()).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO, "");
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$$ExternalSyntheticLambda1(p2pInfoJson));
                                                if (TextUtils.isEmpty(p2pInfoJson)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$$ExternalSyntheticLambda2());
                                                    if (downloadListener != null) {
                                                        downloadListener.onError(-1);
                                                    }
                                                    return null;
                                                }
                                                JSONObject p2pInfoJsonObject = new JSONObject(p2pInfoJson);
                                                if (!p2pInfoJsonObject.optBoolean(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_ENABLE, false)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$$ExternalSyntheticLambda3());
                                                    if (downloadListener != null) {
                                                        downloadListener.onError(-1);
                                                    }
                                                    return null;
                                                }
                                                P2pNetDiskDownloadInfo p2pNetDiskDownloadInfo = new P2pNetDiskDownloadInfo(true, p2pInfoJsonObject.optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_URL, ""), p2pInfoJsonObject.optLong(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_CONTENT_LENGTH, 0), p2pInfoJsonObject.optLong(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_LAST_MODIFY, 0), p2pInfoJsonObject.optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_M3U8_HIGH_RES_MD5, ""));
                                                iNetDiskPluginFace.getUrlP2pDownloadFastDlink(context, new NetDiskRapidEnableQueryInfo(1, p2pNetDiskDownloadInfo.getUrl(), Long.valueOf(p2pNetDiskDownloadInfo.getContentLength()), Long.valueOf(p2pNetDiskDownloadInfo.getLastModified()), p2pNetDiskDownloadInfo.getM3u8HighResMd5()), new Function3<Integer, String, NetDiskRapidDownloadLinkInfo, Unit>() {
                                                    public Unit invoke(Integer errorCode, String s, NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                                        String localPath;
                                                        NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo2 = netDiskRapidDownloadLinkInfo;
                                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$1$$ExternalSyntheticLambda0(errorCode, netDiskRapidDownloadLinkInfo2));
                                                        if (netDiskRapidDownloadLinkInfo2 == null || netDiskRapidDownloadLinkInfo.getRapidDownload() != 1 || TextUtils.isEmpty(netDiskRapidDownloadLinkInfo.getDlink())) {
                                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$1$$ExternalSyntheticLambda1());
                                                            if (downloadListener != null) {
                                                                downloadListener.onError(-1);
                                                            }
                                                            return null;
                                                        }
                                                        DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
                                                        String createId = "downloads_" + String.valueOf(System.currentTimeMillis());
                                                        String dlink = netDiskRapidDownloadLinkInfo.getDlink();
                                                        long fileSize = netDiskRapidDownloadLinkInfo.getFileSize().longValue();
                                                        String originLocalPath = downloadInfoData.getFilePath();
                                                        if (TextUtils.isEmpty(originLocalPath) || !originLocalPath.endsWith(".m3u8")) {
                                                            localPath = originLocalPath;
                                                        } else {
                                                            localPath = originLocalPath.substring(0, originLocalPath.lastIndexOf(".")) + ".mp4";
                                                        }
                                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$1$$ExternalSyntheticLambda2(createId));
                                                        INetdiskPluginFace iNetdiskPluginFace = iNetDiskPluginFace;
                                                        Context context = context;
                                                        P2pNetDiskRapidDownloadCallback p2pNetDiskRapidDownloadCallback = new P2pNetDiskRapidDownloadCallback(createId, iNetDiskPluginFace, (String) null, (DownloadParams) null, (ResumeParams) null, downloadInfoData, originLocalPath, downloadListener, true, false);
                                                        final String str = createId;
                                                        Context context2 = context;
                                                        final String str2 = localPath;
                                                        final long j2 = fileSize;
                                                        String createId2 = createId;
                                                        final String createId3 = dlink;
                                                        iNetdiskPluginFace.addP2pDownloadCallback(context2, createId2, (Long) null, p2pNetDiskRapidDownloadCallback, new Function0<Unit>() {
                                                            public Unit invoke() {
                                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$1$1$$ExternalSyntheticLambda0(str, str2, j2, createId3));
                                                                iNetDiskPluginFace.createP2pDownloadTask(context, str, str2, createId3, j2, (Function2<? super Integer, ? super String, Unit>) null);
                                                                return null;
                                                            }

                                                            static /* synthetic */ String lambda$invoke$0(String createId, String localPath, long fileSize, String dlink) {
                                                                return "DownloadUnifiedManager.transferP2pDownload: createP2pDownloadTask createId " + createId + " localPath " + localPath + " fileSize " + fileSize + " dlink " + dlink;
                                                            }
                                                        }, (Function2<? super Integer, ? super String, Unit>) null);
                                                        return null;
                                                    }

                                                    static /* synthetic */ String lambda$invoke$0(Integer errorCode, NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                                        return "DownloadUnifiedManager.transferP2pDownload: errorCode " + errorCode + " netDiskRapidDownloadLinkInfo " + netDiskRapidDownloadLinkInfo;
                                                    }

                                                    static /* synthetic */ String lambda$invoke$1() {
                                                        return "DownloadUnifiedManager.transferP2pDownload: 网盘p2p dlink获取失败，return";
                                                    }

                                                    static /* synthetic */ String lambda$invoke$2(String createId) {
                                                        return "DownloadUnifiedManager.transferP2pDownload: addP2pDownloadCallback createId " + createId;
                                                    }
                                                }, (Function2<? super Integer, ? super String, Unit>) null);
                                                return null;
                                            } catch (Exception e2) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$2$$ExternalSyntheticLambda4());
                                                if (downloadListener != null) {
                                                    downloadListener.onError(-1);
                                                }
                                            }
                                        }

                                        static /* synthetic */ String lambda$invoke$0() {
                                            return "DownloadUnifiedManager.transferP2pDownload: p2p能力暂不可用，return";
                                        }

                                        static /* synthetic */ String lambda$invoke$1(String p2pInfoJson) {
                                            return "DownloadUnifiedManager.transferP2pDownload: p2pInfo " + p2pInfoJson;
                                        }

                                        static /* synthetic */ String lambda$invoke$2() {
                                            return "DownloadUnifiedManager.transferP2pDownload: 普通下载任务无极速下载信息，return";
                                        }

                                        static /* synthetic */ String lambda$invoke$3() {
                                            return "DownloadUnifiedManager.transferP2pDownload: 普通下载任务不支持极速下载，return";
                                        }

                                        static /* synthetic */ String lambda$invoke$4() {
                                            return "DownloadUnifiedManager.transferP2pDownload: catch exception, return";
                                        }
                                    });
                                }
                            } else {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$7$1$$ExternalSyntheticLambda0());
                                if (downloadListener != null) {
                                    downloadListener.onError(-1);
                                }
                            }
                        }
                    }

                    static /* synthetic */ String lambda$run$0() {
                        return "DownloadUnifiedManager.transferP2pDownload: 普通下载任务处在非下载/暂停状态，return";
                    }

                    static /* synthetic */ String lambda$run$1() {
                        return "DownloadUnifiedManager.transferP2pDownload: 无法获取网盘插件接口层实例，return";
                    }

                    static /* synthetic */ String lambda$run$2() {
                        return "DownloadUnifiedManager.transferP2pDownload: 网盘插件不可用，return";
                    }
                }, "transferP2pDownload");
            }
        });
    }

    static /* synthetic */ String lambda$transferP2pDownload$1() {
        return "DownloadUnifiedManager.transferP2pDownload: -------------------------------------------------------";
    }

    static /* synthetic */ String lambda$transferP2pDownload$2() {
        return "DownloadUnifiedManager.transferP2pDownload: id = -1, return";
    }

    static /* synthetic */ String lambda$transferP2pDownload$3(Uri uri) {
        return "DownloadUnifiedManager.transferP2pDownload: uri = " + uri;
    }

    public void pauseP2pDownload(final Context context, Uri uri) {
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda11());
        long id = DownloadHelper.getIdFromUri(uri);
        if (context == null || id == -1) {
            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda12());
            return;
        }
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda13(uri));
        queryDownloadInfoDataAsync(uri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
            public void callback(final List<DownloadInfoData> datas) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        List list = datas;
                        if (list != null && list.size() > 0) {
                            final DownloadInfoData downloadInfoData = (DownloadInfoData) datas.get(0);
                            if (downloadInfoData.getStatus() == 200) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$$ExternalSyntheticLambda0());
                            } else if (downloadInfoData.getBusinessType() != 2) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$$ExternalSyntheticLambda1());
                            } else {
                                final INetdiskPluginFace iNetDiskPluginFace = P2pNetDiskDownloadUtilsKt.getINetDiskPluginFace();
                                if (iNetDiskPluginFace == null) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$$ExternalSyntheticLambda2());
                                } else if (!iNetDiskPluginFace.isNetDiskPluginAvailable()) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$$ExternalSyntheticLambda3());
                                    iNetDiskPluginFace.prefetchNetDiskPluginOnBackground(context, new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            return null;
                                        }
                                    });
                                } else {
                                    iNetDiskPluginFace.isP2pDownloadEnable(new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            String str;
                                            if (!aBoolean.booleanValue()) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda0());
                                                return null;
                                            }
                                            try {
                                                String p2pInfoJson = new JSONObject(downloadInfoData.getExtraInfo()).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO, "");
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda1(p2pInfoJson));
                                                if (TextUtils.isEmpty(p2pInfoJson)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda2());
                                                    return null;
                                                }
                                                final String createId = new JSONObject(p2pInfoJson).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_CREATE_ID, "");
                                                if (TextUtils.isEmpty(createId)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda3());
                                                    return null;
                                                }
                                                long taskId = Long.parseLong(downloadInfoData.getBusinessId());
                                                String localPath = downloadInfoData.getFilePath();
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda4(createId, taskId));
                                                INetdiskPluginFace iNetdiskPluginFace = iNetDiskPluginFace;
                                                Context context = context;
                                                Long valueOf = Long.valueOf(taskId);
                                                Context context2 = context;
                                                INetdiskPluginFace iNetdiskPluginFace2 = iNetdiskPluginFace;
                                                str = "p2pDownload";
                                                final long taskId2 = taskId;
                                                try {
                                                    P2pNetDiskRapidDownloadCallback p2pNetDiskRapidDownloadCallback = new P2pNetDiskRapidDownloadCallback(createId, iNetDiskPluginFace, (String) null, (DownloadParams) null, (ResumeParams) null, downloadInfoData, localPath, (IP2pDownloadListener) null, false, false);
                                                    iNetdiskPluginFace2.addP2pDownloadCallback(context2, createId, valueOf, p2pNetDiskRapidDownloadCallback, new Function0<Unit>() {
                                                        public Unit invoke() {
                                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$8$1$2$1$$ExternalSyntheticLambda0(createId, taskId2));
                                                            iNetDiskPluginFace.stopP2pDownloadTask(context, taskId2, (Function2<? super Integer, ? super String, Unit>) null);
                                                            return null;
                                                        }

                                                        static /* synthetic */ String lambda$invoke$0(String createId, long taskId) {
                                                            return "DownloadUnifiedManager.pauseP2pDownload: stopP2pDownloadTask createId " + createId + " taskId " + taskId;
                                                        }
                                                    }, (Function2<? super Integer, ? super String, Unit>) null);
                                                    return null;
                                                } catch (Exception e2) {
                                                }
                                            } catch (Exception e3) {
                                                str = "p2pDownload";
                                                DebugUtilsKt.printLog(str, new DownloadUnifiedManager$8$1$2$$ExternalSyntheticLambda5());
                                                return null;
                                            }
                                        }

                                        static /* synthetic */ String lambda$invoke$0() {
                                            return "DownloadUnifiedManager.pauseP2pDownload: p2p能力暂不可用，return";
                                        }

                                        static /* synthetic */ String lambda$invoke$1(String p2pInfoJson) {
                                            return "DownloadUnifiedManager.pauseP2pDownload: p2pInfo " + p2pInfoJson;
                                        }

                                        static /* synthetic */ String lambda$invoke$2() {
                                            return "DownloadUnifiedManager.pauseP2pDownload: 未获取到极速下载信息, return";
                                        }

                                        static /* synthetic */ String lambda$invoke$3() {
                                            return "DownloadUnifiedManager.pauseP2pDownload: createId获取失败, return";
                                        }

                                        static /* synthetic */ String lambda$invoke$4(String createId, long taskId) {
                                            return "DownloadUnifiedManager.pauseP2pDownload: addP2pDownloadCallback createId " + createId + " taskId " + taskId;
                                        }

                                        static /* synthetic */ String lambda$invoke$5() {
                                            return "DownloadUnifiedManager.pauseP2pDownload: catch exception, return";
                                        }
                                    });
                                }
                            }
                        }
                    }

                    static /* synthetic */ String lambda$run$0() {
                        return "DownloadUnifiedManager.pauseP2pDownload: 任务处于下载完成状态, return";
                    }

                    static /* synthetic */ String lambda$run$1() {
                        return "DownloadUnifiedManager.pauseP2pDownload: 非p2p下载任务, return";
                    }

                    static /* synthetic */ String lambda$run$2() {
                        return "DownloadUnifiedManager.pauseP2pDownload: 无法获取网盘插件接口层实例, return";
                    }

                    static /* synthetic */ String lambda$run$3() {
                        return "DownloadUnifiedManager.pauseP2pDownload: 网盘插件不可用，return";
                    }
                }, "pauseP2pDownload");
            }
        });
    }

    static /* synthetic */ String lambda$pauseP2pDownload$4() {
        return "DownloadUnifiedManager.pauseP2pDownload: -------------------------------------------------------";
    }

    static /* synthetic */ String lambda$pauseP2pDownload$5() {
        return "DownloadUnifiedManager.pauseP2pDownload: id = -1, return";
    }

    static /* synthetic */ String lambda$pauseP2pDownload$6(Uri uri) {
        return "DownloadUnifiedManager.pauseP2pDownload: uri = " + uri;
    }

    public void deleteP2pDownload(final Context context, Uri uri) {
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda5());
        long id = DownloadHelper.getIdFromUri(uri);
        if (context == null || id == -1) {
            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda6());
            return;
        }
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda7(uri));
        queryDownloadInfoDataAsync(uri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
            public void callback(final List<DownloadInfoData> datas) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        List list = datas;
                        if (list != null && list.size() > 0) {
                            final DownloadInfoData downloadInfoData = (DownloadInfoData) datas.get(0);
                            if (downloadInfoData.getBusinessType() != 2) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$$ExternalSyntheticLambda0());
                                return;
                            }
                            final INetdiskPluginFace iNetDiskPluginFace = P2pNetDiskDownloadUtilsKt.getINetDiskPluginFace();
                            if (iNetDiskPluginFace == null) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$$ExternalSyntheticLambda1());
                            } else if (!iNetDiskPluginFace.isNetDiskPluginAvailable()) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$$ExternalSyntheticLambda2());
                                iNetDiskPluginFace.prefetchNetDiskPluginOnBackground(context, new Function1<Boolean, Unit>() {
                                    public Unit invoke(Boolean aBoolean) {
                                        return null;
                                    }
                                });
                            } else {
                                iNetDiskPluginFace.isP2pDownloadEnable(new Function1<Boolean, Unit>() {
                                    public Unit invoke(Boolean aBoolean) {
                                        String str;
                                        if (!aBoolean.booleanValue()) {
                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda0());
                                            return null;
                                        }
                                        try {
                                            String p2pInfoJson = new JSONObject(downloadInfoData.getExtraInfo()).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO, "");
                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda1(p2pInfoJson));
                                            if (TextUtils.isEmpty(p2pInfoJson)) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda2());
                                                return null;
                                            }
                                            final String createId = new JSONObject(p2pInfoJson).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_CREATE_ID, "");
                                            if (TextUtils.isEmpty(createId)) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda3());
                                                return null;
                                            }
                                            long taskId = Long.parseLong(downloadInfoData.getBusinessId());
                                            String localPath = downloadInfoData.getFilePath();
                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda4(createId, taskId));
                                            INetdiskPluginFace iNetdiskPluginFace = iNetDiskPluginFace;
                                            Context context = context;
                                            Long valueOf = Long.valueOf(taskId);
                                            Context context2 = context;
                                            INetdiskPluginFace iNetdiskPluginFace2 = iNetdiskPluginFace;
                                            str = "p2pDownload";
                                            final long taskId2 = taskId;
                                            try {
                                                P2pNetDiskRapidDownloadCallback p2pNetDiskRapidDownloadCallback = new P2pNetDiskRapidDownloadCallback(createId, iNetDiskPluginFace, (String) null, (DownloadParams) null, (ResumeParams) null, downloadInfoData, localPath, (IP2pDownloadListener) null, false, false);
                                                iNetdiskPluginFace2.addP2pDownloadCallback(context2, createId, valueOf, p2pNetDiskRapidDownloadCallback, new Function0<Unit>() {
                                                    public Unit invoke() {
                                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$9$1$2$1$$ExternalSyntheticLambda0(createId, taskId2));
                                                        iNetDiskPluginFace.deleteP2pDownloadTask(context, taskId2, (Function2<? super Integer, ? super String, Unit>) null);
                                                        return null;
                                                    }

                                                    static /* synthetic */ String lambda$invoke$0(String createId, long taskId) {
                                                        return "DownloadUnifiedManager.deleteP2pDownload: deleteP2pDownloadTask createId " + createId + " taskId " + taskId;
                                                    }
                                                }, (Function2<? super Integer, ? super String, Unit>) null);
                                                return null;
                                            } catch (Exception e2) {
                                            }
                                        } catch (Exception e3) {
                                            str = "p2pDownload";
                                            DebugUtilsKt.printLog(str, new DownloadUnifiedManager$9$1$2$$ExternalSyntheticLambda5());
                                            return null;
                                        }
                                    }

                                    static /* synthetic */ String lambda$invoke$0() {
                                        return "DownloadUnifiedManager.deleteP2pDownload: p2p能力暂不可用，return";
                                    }

                                    static /* synthetic */ String lambda$invoke$1(String p2pInfoJson) {
                                        return "DownloadUnifiedManager.deleteP2pDownload: p2pInfo " + p2pInfoJson;
                                    }

                                    static /* synthetic */ String lambda$invoke$2() {
                                        return "DownloadUnifiedManager.deleteP2pDownload: 未获取到极速下载信息, return";
                                    }

                                    static /* synthetic */ String lambda$invoke$3() {
                                        return "DownloadUnifiedManager.deleteP2pDownload: createId获取失败, return";
                                    }

                                    static /* synthetic */ String lambda$invoke$4(String createId, long taskId) {
                                        return "DownloadUnifiedManager.deleteP2pDownload: addP2pDownloadCallback createId " + createId + " taskId " + taskId;
                                    }

                                    static /* synthetic */ String lambda$invoke$5() {
                                        return "DownloadUnifiedManager.deleteP2pDownload: catch exception, return";
                                    }
                                });
                            }
                        }
                    }

                    static /* synthetic */ String lambda$run$0() {
                        return "DownloadUnifiedManager.deleteP2pDownload: 非p2p下载任务, return";
                    }

                    static /* synthetic */ String lambda$run$1() {
                        return "DownloadUnifiedManager.deleteP2pDownload: 无法获取网盘插件接口层实例, return";
                    }

                    static /* synthetic */ String lambda$run$2() {
                        return "DownloadUnifiedManager.deleteP2pDownload: 网盘插件不可用，return";
                    }
                }, "deleteP2pDownload");
            }
        });
    }

    static /* synthetic */ String lambda$deleteP2pDownload$7() {
        return "DownloadUnifiedManager.deleteP2pDownload: -------------------------------------------------------";
    }

    static /* synthetic */ String lambda$deleteP2pDownload$8() {
        return "DownloadUnifiedManager.deleteP2pDownload: id = -1, return";
    }

    static /* synthetic */ String lambda$deleteP2pDownload$9(Uri uri) {
        return "DownloadUnifiedManager.deleteP2pDownload: uri = " + uri;
    }

    public void resumeP2pDownload(Context context, ResumeParams resumeParams, Uri downloadUri, IP2pDownloadListener downloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda3());
        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda4(downloadUri));
        if (checkParamsForResume(resumeParams, downloadUri, downloadListener, eventControlInfoForResume, eventCallback)) {
            if (eventControlInfoForResume == null) {
                eventControlInfoForResume = new EventControlInfoForResume(true, true);
            }
            List<EventActionForResume> eventActions = new ArrayList<>();
            Context context2 = context;
            ResumeParams resumeParams2 = resumeParams;
            Uri uri = downloadUri;
            IP2pDownloadListener iP2pDownloadListener = downloadListener;
            EventControlInfoForResume eventControlInfoForResume2 = eventControlInfoForResume;
            EventCallback eventCallback2 = eventCallback;
            eventActions.add(new EventActionForResume.CheckNetEvent(context2, resumeParams2, uri, iP2pDownloadListener, eventControlInfoForResume2, eventCallback2));
            eventActions.add(new EventActionForResume.CheckExternalStoragePermission(context2, resumeParams2, uri, iP2pDownloadListener, eventControlInfoForResume2, eventCallback2));
            doEventActionsForP2pResume(context, eventActions);
        }
    }

    static /* synthetic */ String lambda$resumeP2pDownload$10() {
        return "DownloadUnifiedManager.resumeP2pDownload: -------------------------------------------------------";
    }

    static /* synthetic */ String lambda$resumeP2pDownload$11(Uri downloadUri) {
        return "DownloadUnifiedManager.resumeP2pDownload: uri " + downloadUri;
    }

    /* access modifiers changed from: private */
    public void doEventActionsForP2pResume(final Context context, final List<EventActionForResume> eventActions) {
        if (eventActions.size() > 0) {
            eventActions.remove(0).action(new IContinue<EventActionForResume>() {
                public void continueCall(boolean yes, final EventActionForResume eventActionForResume) {
                    if (!yes) {
                        return;
                    }
                    if (eventActions.size() > 0) {
                        DownloadUnifiedManager.this.doEventActionsForP2pResume(context, eventActions);
                    } else {
                        ExecutorUtilsExt.postOnSerial(new Runnable() {
                            public void run() {
                                Uri uri = eventActionForResume.getDownloadUri();
                                DownloadUnifiedManager.this.doP2pResume(context, eventActionForResume.resumeParams, uri, (IP2pDownloadListener) eventActionForResume.getDownloadListener());
                            }
                        }, "doP2pResume");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doP2pResume(Context context, ResumeParams resumeParams, Uri uri, IP2pDownloadListener downloadListener) {
        final IP2pDownloadListener iP2pDownloadListener = downloadListener;
        final Context context2 = context;
        final Uri uri2 = uri;
        final ResumeParams resumeParams2 = resumeParams;
        getInstance().queryDownloadInfoDataAsync(uri, (DownloadInfoDatasCallback) new DownloadInfoDatasCallback() {
            public void callback(final List<DownloadInfoData> datas) {
                ExecutorUtilsExt.postOnSerial(new Runnable() {
                    public void run() {
                        List list = datas;
                        if (list != null && list.size() > 0) {
                            final DownloadInfoData downloadInfoData = (DownloadInfoData) datas.get(0);
                            if (downloadInfoData.getStatus() == 200) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$$ExternalSyntheticLambda0());
                                if (iP2pDownloadListener != null) {
                                    iP2pDownloadListener.onError(-1);
                                }
                            } else if (downloadInfoData.getBusinessType() != 2) {
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$$ExternalSyntheticLambda1());
                                if (iP2pDownloadListener != null) {
                                    iP2pDownloadListener.onError(-1);
                                }
                            } else {
                                final INetdiskPluginFace iNetDiskPluginFace = P2pNetDiskDownloadUtilsKt.getINetDiskPluginFace();
                                if (iNetDiskPluginFace == null) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$$ExternalSyntheticLambda2());
                                    if (iP2pDownloadListener != null) {
                                        iP2pDownloadListener.onError(-1);
                                    }
                                } else if (!iNetDiskPluginFace.isNetDiskPluginAvailable()) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$$ExternalSyntheticLambda3());
                                    if (iP2pDownloadListener != null) {
                                        iP2pDownloadListener.onError(-1);
                                    }
                                    iNetDiskPluginFace.prefetchNetDiskPluginOnBackground(context2, new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            return null;
                                        }
                                    });
                                } else {
                                    iNetDiskPluginFace.isP2pDownloadEnable(new Function1<Boolean, Unit>() {
                                        public Unit invoke(Boolean aBoolean) {
                                            if (!aBoolean.booleanValue()) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$$ExternalSyntheticLambda0());
                                                if (iP2pDownloadListener != null) {
                                                    iP2pDownloadListener.onError(-1);
                                                }
                                                return null;
                                            }
                                            try {
                                                String p2pInfoJson = new JSONObject(downloadInfoData.getExtraInfo()).optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO, "");
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$$ExternalSyntheticLambda1(p2pInfoJson));
                                                if (TextUtils.isEmpty(p2pInfoJson)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$$ExternalSyntheticLambda2());
                                                    if (iP2pDownloadListener != null) {
                                                        iP2pDownloadListener.onError(-1);
                                                    }
                                                    return null;
                                                }
                                                final JSONObject p2pInfoJsonObject = new JSONObject(p2pInfoJson);
                                                if (!p2pInfoJsonObject.optBoolean(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_ENABLE, false)) {
                                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$$ExternalSyntheticLambda3());
                                                    if (iP2pDownloadListener != null) {
                                                        iP2pDownloadListener.onError(-1);
                                                    }
                                                    return null;
                                                }
                                                P2pNetDiskDownloadInfo p2pNetDiskDownloadInfo = new P2pNetDiskDownloadInfo(true, p2pInfoJsonObject.optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_URL, ""), p2pInfoJsonObject.optLong(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_CONTENT_LENGTH, 0), p2pInfoJsonObject.optLong(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_LAST_MODIFY, 0), p2pInfoJsonObject.optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_REQUEST_M3U8_HIGH_RES_MD5, ""));
                                                iNetDiskPluginFace.getUrlP2pDownloadFastDlink(context2, new NetDiskRapidEnableQueryInfo(1, p2pNetDiskDownloadInfo.getUrl(), Long.valueOf(p2pNetDiskDownloadInfo.getContentLength()), Long.valueOf(p2pNetDiskDownloadInfo.getLastModified()), p2pNetDiskDownloadInfo.getM3u8HighResMd5()), new Function3<Integer, String, NetDiskRapidDownloadLinkInfo, Unit>() {
                                                    public Unit invoke(Integer errorCode, String s, final NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$$ExternalSyntheticLambda0(errorCode, netDiskRapidDownloadLinkInfo));
                                                        if (netDiskRapidDownloadLinkInfo == null || netDiskRapidDownloadLinkInfo.getRapidDownload() != 1 || TextUtils.isEmpty(netDiskRapidDownloadLinkInfo.getDlink())) {
                                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$$ExternalSyntheticLambda1());
                                                            if (iP2pDownloadListener != null) {
                                                                iP2pDownloadListener.onError(-1);
                                                            }
                                                            return null;
                                                        }
                                                        final String createId = p2pInfoJsonObject.optString(Downloads.Impl.COLUMN_EXTRA_INFO_P2P_INFO_CREATE_ID, "");
                                                        if (TextUtils.isEmpty(createId)) {
                                                            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$$ExternalSyntheticLambda2());
                                                            if (iP2pDownloadListener != null) {
                                                                iP2pDownloadListener.onError(-1);
                                                            }
                                                            return null;
                                                        }
                                                        iNetDiskPluginFace.removeP2pDownloadCallback(context2, createId, new Function0<Unit>() {
                                                            public Unit invoke() {
                                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$1$$ExternalSyntheticLambda0(createId));
                                                                DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri2);
                                                                String dlink = netDiskRapidDownloadLinkInfo.getDlink();
                                                                long fileSize = netDiskRapidDownloadLinkInfo.getFileSize().longValue();
                                                                String localPath = downloadInfoData.getFilePath();
                                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$1$$ExternalSyntheticLambda1(createId));
                                                                INetdiskPluginFace iNetdiskPluginFace = iNetDiskPluginFace;
                                                                Context context = context2;
                                                                String str = createId;
                                                                P2pNetDiskRapidDownloadCallback p2pNetDiskRapidDownloadCallback = new P2pNetDiskRapidDownloadCallback(createId, iNetDiskPluginFace, resumeParams2.getSource(), (DownloadParams) null, resumeParams2, downloadInfoData, localPath, iP2pDownloadListener, false, true);
                                                                final String str2 = localPath;
                                                                String str3 = str;
                                                                final String str4 = dlink;
                                                                final long j2 = fileSize;
                                                                iNetdiskPluginFace.addP2pDownloadCallback(context, str3, (Long) null, p2pNetDiskRapidDownloadCallback, new Function0<Unit>() {
                                                                    public Unit invoke() {
                                                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$1$1$1$$ExternalSyntheticLambda0(createId));
                                                                        iNetDiskPluginFace.createP2pDownloadTask(context2, createId, str2, str4, j2, (Function2<? super Integer, ? super String, Unit>) null);
                                                                        return null;
                                                                    }

                                                                    static /* synthetic */ String lambda$invoke$0(String createId) {
                                                                        return "DownloadUnifiedManager.resumeP2pDownload: createP2pDownloadTask createId " + createId;
                                                                    }
                                                                }, (Function2<? super Integer, ? super String, Unit>) null);
                                                                return null;
                                                            }

                                                            static /* synthetic */ String lambda$invoke$0(String createId) {
                                                                return "DownloadUnifiedManager.resumeP2pDownload: removeP2pDownloadCallback createId " + createId;
                                                            }

                                                            static /* synthetic */ String lambda$invoke$1(String createId) {
                                                                return "DownloadUnifiedManager.resumeP2pDownload: addP2pDownloadCallback createId " + createId;
                                                            }
                                                        }, (Function2<? super Integer, ? super String, Unit>) null);
                                                        return null;
                                                    }

                                                    static /* synthetic */ String lambda$invoke$0(Integer errorCode, NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                                        return "DownloadUnifiedManager.resumeP2pDownload: errorCode " + errorCode + " netDiskRapidDownloadLinkInfo " + netDiskRapidDownloadLinkInfo;
                                                    }

                                                    static /* synthetic */ String lambda$invoke$1() {
                                                        return "DownloadUnifiedManager.resumeP2pDownload: 网盘p2p dlink获取失败, return";
                                                    }

                                                    static /* synthetic */ String lambda$invoke$2() {
                                                        return "DownloadUnifiedManager.resumeP2pDownload: createId获取失败, return";
                                                    }
                                                }, (Function2<? super Integer, ? super String, Unit>) null);
                                                return null;
                                            } catch (Exception e2) {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$11$1$2$$ExternalSyntheticLambda4());
                                                if (iP2pDownloadListener != null) {
                                                    iP2pDownloadListener.onError(-1);
                                                }
                                            }
                                        }

                                        static /* synthetic */ String lambda$invoke$0() {
                                            return "DownloadUnifiedManager.resumeP2pDownload: p2p能力暂不可用，return";
                                        }

                                        static /* synthetic */ String lambda$invoke$1(String p2pInfoJson) {
                                            return "DownloadUnifiedManager.resumeP2pDownload: p2pInfo " + p2pInfoJson;
                                        }

                                        static /* synthetic */ String lambda$invoke$2() {
                                            return "DownloadUnifiedManager.resumeP2pDownload: 未获取到极速下载信息, return";
                                        }

                                        static /* synthetic */ String lambda$invoke$3() {
                                            return "DownloadUnifiedManager.resumeP2pDownload: 普通下载任务不支持极速下载, return";
                                        }

                                        static /* synthetic */ String lambda$invoke$4() {
                                            return "DownloadUnifiedManager.resumeP2pDownload: catch exception, return";
                                        }
                                    });
                                }
                            }
                        }
                    }

                    static /* synthetic */ String lambda$run$0() {
                        return "DownloadUnifiedManager.resumeP2pDownload: 任务处于下载完成状态, return";
                    }

                    static /* synthetic */ String lambda$run$1() {
                        return "DownloadUnifiedManager.resumeP2pDownload: 非p2p下载任务, return";
                    }

                    static /* synthetic */ String lambda$run$2() {
                        return "DownloadUnifiedManager.resumeP2pDownload: 无法获取网盘插件接口层实例, return";
                    }

                    static /* synthetic */ String lambda$run$3() {
                        return "DownloadUnifiedManager.resumeP2pDownload: 网盘插件不可用，return";
                    }
                }, "pauseP2pDownload");
            }
        });
    }

    /* access modifiers changed from: private */
    public void doEventActionsForP2pStart(final Context context, final List<EventActionForStart> eventActions) {
        if (eventActions.size() > 0) {
            eventActions.remove(0).action(new IContinue<EventActionForStart>() {
                public void continueCall(boolean yes, final EventActionForStart eventAction) {
                    if (!yes) {
                        return;
                    }
                    if (eventActions.size() > 0) {
                        DownloadUnifiedManager.this.doEventActionsForP2pStart(context, eventActions);
                    } else {
                        ExecutorUtilsExt.postOnSerial(new Runnable() {
                            public void run() {
                                DownloadUnifiedManager.this.doP2pDownload(context, eventAction.getSource(), eventAction.getDownloadParams(), (IP2pDownloadListener) eventAction.getDownloadListener());
                            }
                        }, "doP2pDownload");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doP2pDownload(Context context, String source, DownloadParams downloadParams, IP2pDownloadListener downloadListener) {
        INetdiskPluginFace iNetDiskPluginFace = P2pNetDiskDownloadUtilsKt.getINetDiskPluginFace();
        if (iNetDiskPluginFace == null) {
            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda1());
            if (downloadListener != null) {
                downloadListener.onError(-1);
            }
        } else if (!iNetDiskPluginFace.isNetDiskPluginAvailable()) {
            DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$$ExternalSyntheticLambda2());
            if (downloadListener != null) {
                downloadListener.onError(-1);
            }
            iNetDiskPluginFace.prefetchNetDiskPluginOnBackground(context, new Function1<Boolean, Unit>() {
                public Unit invoke(Boolean aBoolean) {
                    return null;
                }
            });
        } else {
            final IP2pDownloadListener iP2pDownloadListener = downloadListener;
            final DownloadParams downloadParams2 = downloadParams;
            final INetdiskPluginFace iNetdiskPluginFace = iNetDiskPluginFace;
            final Context context2 = context;
            final String str = source;
            iNetDiskPluginFace.isP2pDownloadEnable(new Function1<Boolean, Unit>() {
                public Unit invoke(Boolean aBoolean) {
                    if (!aBoolean.booleanValue()) {
                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$$ExternalSyntheticLambda0());
                        IP2pDownloadListener iP2pDownloadListener = iP2pDownloadListener;
                        if (iP2pDownloadListener != null) {
                            iP2pDownloadListener.onError(-1);
                        }
                        return null;
                    }
                    P2pNetDiskDownloadInfo p2pInfo = downloadParams2.getP2pNetDiskDownloadInfo();
                    if (p2pInfo == null) {
                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$$ExternalSyntheticLambda1());
                        IP2pDownloadListener iP2pDownloadListener2 = iP2pDownloadListener;
                        if (iP2pDownloadListener2 != null) {
                            iP2pDownloadListener2.onError(-1);
                        }
                        return null;
                    } else if (!p2pInfo.getEnable()) {
                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$$ExternalSyntheticLambda2());
                        IP2pDownloadListener iP2pDownloadListener3 = iP2pDownloadListener;
                        if (iP2pDownloadListener3 != null) {
                            iP2pDownloadListener3.onError(-1);
                        }
                        return null;
                    } else {
                        iNetdiskPluginFace.getUrlP2pDownloadFastDlink(context2, new NetDiskRapidEnableQueryInfo(1, p2pInfo.getUrl(), Long.valueOf(p2pInfo.getContentLength()), Long.valueOf(p2pInfo.getLastModified()), p2pInfo.getM3u8HighResMd5()), new Function3<Integer, String, NetDiskRapidDownloadLinkInfo, Unit>() {
                            public Unit invoke(Integer errorCode, String s, NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo2 = netDiskRapidDownloadLinkInfo;
                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$$ExternalSyntheticLambda0(errorCode, netDiskRapidDownloadLinkInfo2));
                                if (netDiskRapidDownloadLinkInfo2 == null || netDiskRapidDownloadLinkInfo.getRapidDownload() != 1 || TextUtils.isEmpty(netDiskRapidDownloadLinkInfo.getDlink())) {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$$ExternalSyntheticLambda1());
                                    if (iP2pDownloadListener != null) {
                                        iP2pDownloadListener.onError(-1);
                                    }
                                    return null;
                                } else if (downloadParams2.getDestination() != 4 || (!TextUtils.isEmpty(downloadParams2.getFilePathHint()) && downloadParams2.getFilePathHint().startsWith("file://"))) {
                                    try {
                                        String localPath = DownloadHelper.generateSaveFile(context2, downloadParams2.getUrl(), downloadParams2.getUrl(), downloadParams2.getFilePathHint(), downloadParams2.getContentDisposition(), downloadParams2.getContentLocation(), downloadParams2.getMimeType(), downloadParams2.getDestination(), downloadParams2.getContentLength(), false);
                                        String createId = "downloads_" + String.valueOf(System.currentTimeMillis());
                                        final String dlink = netDiskRapidDownloadLinkInfo.getDlink();
                                        final long fileSize = netDiskRapidDownloadLinkInfo.getFileSize().longValue();
                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$$ExternalSyntheticLambda3(createId));
                                        final String str = createId;
                                        final String str2 = localPath;
                                        iNetdiskPluginFace.addP2pDownloadCallback(context2, createId, (Long) null, new P2pNetDiskRapidDownloadCallback(createId, iNetdiskPluginFace, str, downloadParams2, (ResumeParams) null, (DownloadInfoData) null, localPath, iP2pDownloadListener, false, false), new Function0<Unit>() {
                                            public Unit invoke() {
                                                DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$1$$ExternalSyntheticLambda0(str, str2, fileSize, dlink));
                                                iNetdiskPluginFace.createP2pDownloadTask(context2, str, str2, dlink, fileSize, (Function2<? super Integer, ? super String, Unit>) null);
                                                return null;
                                            }

                                            static /* synthetic */ String lambda$invoke$0(String createId, String localPath, long fileSize, String dlink) {
                                                return "DownloadUnifiedManager.startP2pDownload: createP2pDownloadTask createId " + createId + " localPath " + localPath + " fileSize " + fileSize + " dlink " + dlink;
                                            }
                                        }, (Function2<? super Integer, ? super String, Unit>) null);
                                        return null;
                                    } catch (DownloadHelper.GenerateSaveFileError e2) {
                                        DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$$ExternalSyntheticLambda4());
                                        if (iP2pDownloadListener != null) {
                                            iP2pDownloadListener.onError(-1);
                                        }
                                        return null;
                                    }
                                } else {
                                    DebugUtilsKt.printLog("p2pDownload", new DownloadUnifiedManager$14$1$$ExternalSyntheticLambda2());
                                    if (iP2pDownloadListener != null) {
                                        iP2pDownloadListener.onError(-1);
                                    }
                                    return null;
                                }
                            }

                            static /* synthetic */ String lambda$invoke$0(Integer errorCode, NetDiskRapidDownloadLinkInfo netDiskRapidDownloadLinkInfo) {
                                return "DownloadUnifiedManager.startP2pDownload: errorCode " + errorCode + " netDiskRapidDownloadLinkInfo " + netDiskRapidDownloadLinkInfo;
                            }

                            static /* synthetic */ String lambda$invoke$1() {
                                return "DownloadUnifiedManager.startP2pDownload: 网盘p2p dlink获取失败，return";
                            }

                            static /* synthetic */ String lambda$invoke$2() {
                                return "DownloadUnifiedManager.startP2pDownload: 自定义文件保存路径无效，return";
                            }

                            static /* synthetic */ String lambda$invoke$3(String createId) {
                                return "DownloadUnifiedManager.startP2pDownload: addP2pDownloadCallback createId " + createId;
                            }

                            static /* synthetic */ String lambda$invoke$4() {
                                return "DownloadUnifiedManager.startP2pDownload: 生成文件保存路径失败，return";
                            }
                        }, (Function2<? super Integer, ? super String, Unit>) null);
                        return null;
                    }
                }

                static /* synthetic */ String lambda$invoke$0() {
                    return "DownloadUnifiedManager.startP2pDownload: p2p能力暂不可用，return";
                }

                static /* synthetic */ String lambda$invoke$1() {
                    return "DownloadUnifiedManager.startP2pDownload: 新建任务无极速下载信息，return";
                }

                static /* synthetic */ String lambda$invoke$2() {
                    return "DownloadUnifiedManager.startP2pDownload: 新建任务不支持极速下载，return";
                }
            });
        }
    }

    static /* synthetic */ String lambda$doP2pDownload$12() {
        return "DownloadUnifiedManager.startP2pDownload: 无法获取网盘插件接口层实例，return";
    }

    static /* synthetic */ String lambda$doP2pDownload$13() {
        return "DownloadUnifiedManager.startP2pDownload: 网盘插件不可用，return";
    }
}
