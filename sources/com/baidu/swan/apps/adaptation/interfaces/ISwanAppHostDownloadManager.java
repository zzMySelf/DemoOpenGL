package com.baidu.swan.apps.adaptation.interfaces;

import android.app.Activity;
import com.baidu.swan.apps.api.module.file.IDownloadCallBack;
import org.json.JSONObject;

public interface ISwanAppHostDownloadManager {
    void downloadToHost(String str, String str2, JSONObject jSONObject, IDownloadCallBack iDownloadCallBack);

    void openFile(Activity activity, String str, IDownloadCallBack iDownloadCallBack);

    void openHostDownloadCenter();

    void queryFileInfo(String str, IDownloadCallBack iDownloadCallBack);

    String queryFilePath(String str);
}
