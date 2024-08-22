package com.baidu.searchbox.plugins.kernels.webview;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.ng.browser.listener.IWebkitDownloadListener;
import java.util.List;

public class ZeusDownloadAdapter {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public BdSailorClient.IDownloadTaskListener mDownloadListener;
    /* access modifiers changed from: private */
    public String mDownloadUrl;
    /* access modifiers changed from: private */
    public Uri mUri;

    protected class ZeusDownloadTaskListener implements DownloadListener {
        public ZeusDownloadTaskListener() {
        }

        public void onChanged(DownloadBean pdb) {
            List<IWebkitDownloadListener> listeners = WebkitKernelPlugin.getInstance(ZeusDownloadAdapter.this.mContext).getWebkitDownloadListeners();
            if (pdb != null) {
                try {
                    switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[pdb.getDownloadState().ordinal()]) {
                        case 1:
                            if (ZeusDownloadAdapter.this.mDownloadListener != null) {
                                ZeusDownloadAdapter.this.mDownloadListener.onDownloading(ZeusDownloadAdapter.this.mDownloadUrl, pdb.getCurrentBytes(), pdb.getTotalBytes());
                                return;
                            }
                            return;
                        case 2:
                            if (ZeusDownloadAdapter.this.mDownloadListener != null) {
                                ZeusDownloadAdapter.this.mDownloadListener.onDownloadPause(ZeusDownloadAdapter.this.mDownloadUrl, pdb.getCurrentBytes(), pdb.getTotalBytes(), (String) null);
                                return;
                            }
                            return;
                        case 3:
                            if (listeners != null) {
                                for (IWebkitDownloadListener listener : listeners) {
                                    if (listener != null) {
                                        listener.onSuccess(pdb.getFilePath());
                                    }
                                }
                            }
                            if (ZeusDownloadAdapter.this.mDownloadListener != null) {
                                ZeusDownloadAdapter.this.mDownloadListener.onDownloadSuccess(ZeusDownloadAdapter.this.mDownloadUrl, (String) null, pdb.getTotalBytes());
                            }
                            WebkitKernelPlugin.getInstance(ZeusDownloadAdapter.this.mContext).getDownloadManager().unregisterObserver(ZeusDownloadAdapter.this.mContext, ZeusDownloadAdapter.this.mUri, this);
                            return;
                        default:
                            if (ZeusDownloadAdapter.this.mDownloadListener != null) {
                                ZeusDownloadAdapter.this.mDownloadListener.onDownloadFail(ZeusDownloadAdapter.this.mDownloadUrl, pdb.getCurrentBytes(), (String) null, "");
                            }
                            if (listeners != null) {
                                for (IWebkitDownloadListener listener2 : listeners) {
                                    if (listener2 != null) {
                                        listener2.onFail(new Exception("download fail uri=" + pdb.getUri()));
                                    }
                                }
                            }
                            WebkitKernelPlugin.getInstance(ZeusDownloadAdapter.this.mContext).getDownloadManager().unregisterObserver(ZeusDownloadAdapter.this.mContext, ZeusDownloadAdapter.this.mUri, this);
                            return;
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.baidu.searchbox.plugins.kernels.webview.ZeusDownloadAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$model$DownloadState;

        static {
            int[] iArr = new int[DownloadState.values().length];
            $SwitchMap$com$baidu$searchbox$download$model$DownloadState = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.NOT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public boolean startDownload(Context aContext, String url, String userAgent, String aPath, String aFileName, BdSailorClient.DownloadTaskType aType, BdSailorClient.IDownloadTaskListener aListener) {
        Context context = aContext;
        BdSailorClient.IDownloadTaskListener iDownloadTaskListener = aListener;
        if (context != null) {
            try {
                if (aType != BdSailorClient.DownloadTaskType.ZEUS || iDownloadTaskListener == null) {
                    String str = url;
                    return false;
                }
                try {
                    this.mDownloadListener = iDownloadTaskListener;
                    this.mContext = context;
                    DownloadManagerExt manager = WebkitKernelPlugin.getInstance(aContext).getDownloadManager();
                    Uri uri = manager.doDownload(url, aPath, aFileName, false, false, true, true, (ContentValues) null);
                    if (uri != null) {
                        this.mUri = uri;
                        try {
                            this.mDownloadUrl = url;
                            manager.registerObserver(aContext, uri, new ZeusDownloadTaskListener());
                            return true;
                        } catch (Throwable th2) {
                            t = th2;
                            t.printStackTrace();
                            return false;
                        }
                    } else {
                        String str2 = url;
                        return false;
                    }
                } catch (Throwable th3) {
                    t = th3;
                    String str3 = url;
                    t.printStackTrace();
                    return false;
                }
            } catch (Throwable th4) {
                t = th4;
                String str4 = url;
                BdSailorClient.DownloadTaskType downloadTaskType = aType;
                t.printStackTrace();
                return false;
            }
        } else {
            String str5 = url;
            BdSailorClient.DownloadTaskType downloadTaskType2 = aType;
            return false;
        }
    }
}
