package com.baidu.swan.apps.adaptation.interfaces;

import android.content.Context;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

public interface ISwanAppBoxPrivateBehavior {
    boolean canPreDownloadSwan(String str);

    void clearIMUnReadMessageListCache();

    File cloneSwanAppToZip(Context context, String str);

    JSONObject getIMUnReadMessageList(Context context, String str);

    List<String> getPreDownloadList(String str);

    void sendBroadcast(String str, String str2);
}
