package com.baidu.searchbox.plugins;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.OpenDownloadReceiver;
import com.baidu.searchbox.download.callback.DownloadListener;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.plugins.state.PluginState;
import com.baidu.searchbox.plugins.utils.PluginStatistic;

public final class PluginDownloadListener implements DownloadListener {
    private Context mContext;
    private Plugin mPlugin;

    public PluginDownloadListener(Context context, Plugin plugin) {
        this.mPlugin = plugin;
        this.mContext = context.getApplicationContext();
    }

    public void onChanged(DownloadBean pdb) {
        if (Plugin.DEBUG) {
            Log.d("Plugin", "PluginDownloadListener.onChanged(" + pdb + ")");
        }
        if (pdb != null) {
            switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[pdb.getDownloadState().ordinal()]) {
                case 1:
                    if (PluginState.DOWNLOADING != this.mPlugin.getState()) {
                        this.mPlugin.setState(PluginState.DOWNLOADING);
                        return;
                    }
                    return;
                case 2:
                    if (PluginState.DOWNLOAD_PAUSED != this.mPlugin.getState()) {
                        this.mPlugin.setState(PluginState.DOWNLOAD_PAUSED);
                        return;
                    }
                    return;
                case 3:
                    this.mPlugin.getDownloadManager().unregisterObserver(this.mContext, this.mPlugin.getUri(), this);
                    if (Plugin.DEBUG) {
                        Log.d("SilentDownload", "detect downloaded state,call install");
                    }
                    OpenDownloadReceiver.checkPluginDownloaded(this.mContext, this.mPlugin.getUri(), this.mPlugin.getDownloadFile());
                    PluginStatistic.sendDownloadGMVLog("0", this.mPlugin.getId(), this.mPlugin.getVersion(), "");
                    return;
                default:
                    this.mPlugin.getDownloadManager().unregisterObserver(this.mContext, this.mPlugin.getUri(), this);
                    this.mPlugin.setState(PluginState.NOT_DOWNLOAD);
                    return;
            }
        }
    }

    /* renamed from: com.baidu.searchbox.plugins.PluginDownloadListener$1  reason: invalid class name */
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
}
