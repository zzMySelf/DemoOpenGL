package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import com.baidu.mms.voicesearch.voice.utils.NetConfig;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.cloudsetting.CloudSettingSDK;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.IOException;
import java.util.HashMap;

public class SessionMonitorNetWorker implements INoProGuard, INetListener {
    private static final String LOG_TAG = "ZeusMonitorEngine";

    private String getUploadUrl() {
        return WebSettingsGlobalBlink.getSessionUploadUrl();
    }

    public void upload(String str, String str2, String str3) {
        upload(str, str2, str3, true);
    }

    public void uploadFromFile(String str, final byte[] bArr, final String str2) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
        } else {
            ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() {
                public final void run() {
                    byte[] bArr = bArr;
                    if (bArr != null && bArr.length != 0 && WebSettingsGlobalBlink.isSessionDataEnable() && CloudSettingSDK.isGzipSupportEnabled()) {
                        SessionMonitorNetWorker.this.sendStatisticsDataToServer(bArr, str2, true);
                    }
                }
            });
        }
    }

    public void upload(String str, final String str2, final String str3, final boolean z) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
            return;
        }
        AnonymousClass2 r1 = new Runnable() {
            public final void run() {
                if (!TextUtils.isEmpty(str2) && WebSettingsGlobalBlink.isSessionDataEnable()) {
                    Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + str2);
                    if (CloudSettingSDK.isGzipSupportEnabled()) {
                        try {
                            SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(RC4.kernelGzipCompress(str2.getBytes())), str3, z);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        SessionMonitorNetWorker.this.sendStatisticsDataToServer(RC4.kernelEncrypt(Base64.encode(str2.getBytes(), false)), str3, z);
                    }
                }
            }
        };
        if (z) {
            ZeusThreadPoolUtil.executeIgnoreZeus(r1);
        } else {
            r1.run();
        }
    }

    /* access modifiers changed from: private */
    public void sendStatisticsDataToServer(byte[] bArr, String str, boolean z) {
        String uploadUrl = getUploadUrl();
        if (!TextUtils.isEmpty(uploadUrl)) {
            String str2 = uploadUrl + str;
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        HashMap hashMap = new HashMap();
                        BdNet bdNet = new BdNet(WebKitFactory.getContext());
                        BdNetTask bdNetTask = new BdNetTask();
                        bdNetTask.setMethod(BdNet.HttpMethod.METHOD_POST);
                        bdNetTask.setNet(bdNet);
                        bdNetTask.setUrl(str2);
                        bdNetTask.setContent(bArr);
                        hashMap.put("Connection", "Keep-Alive");
                        hashMap.put("Cache-Control", NetConfig.NO_CACHE);
                        if (WebSettingsGlobalBlink.isSessionDataEnable() && CloudSettingSDK.isGzipSupportEnabled()) {
                            hashMap.put("Content-Type", "application/x-gzip");
                        }
                        if (WebKitFactory.getCurEngine() != 1) {
                            hashMap.put("Kernel-Status", "0");
                        }
                        bdNetTask.setHeaders(hashMap);
                        if (!z) {
                            bdNet.setEventListener(this);
                        }
                        bdNet.start(bdNetTask, false);
                        if (!z) {
                            synchronized (bdNetTask) {
                                bdNetTask.wait();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.d(LOG_TAG, "upload error ".concat(String.valueOf(e2)));
                }
            }
        }
    }

    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetTaskStart()");
    }

    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
    }

    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
    }

    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetUploadComplete()");
    }

    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
    }

    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        Log.i(LOG_TAG, "onNetReceiveData()");
    }

    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        Log.i(LOG_TAG, "onNetRedirect()");
        return false;
    }

    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Log.i(LOG_TAG, "onNetTaskComplete()");
        synchronized (bdNetTask) {
            bdNetTask.notify();
        }
    }

    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        Log.i(LOG_TAG, "onNetDownloadError()");
    }

    public void onNetDownloadComplete(BdNet bdNet) {
        Log.i(LOG_TAG, "onNetDownloadComplete()");
    }
}
