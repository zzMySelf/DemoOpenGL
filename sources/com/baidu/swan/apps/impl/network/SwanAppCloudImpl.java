package com.baidu.swan.apps.impl.network;

import android.content.Context;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppCloudRequest;
import com.baidu.swan.apps.ai.AiRequestUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import org.json.JSONArray;

public class SwanAppCloudImpl implements ISwanAppCloudRequest {
    public void getCloudUrl(Context context, String cloudUrl, TypedCallback<String> callBack) {
        AiRequestUtils.getCloudUrl(cloudUrl, callBack);
    }

    public void getCloudUrlList(Context context, JSONArray cloudUrls, TypedCallback<String> callBack) {
        AiRequestUtils.getCloudUrlList(cloudUrls, callBack);
    }

    public long getServiceTime(Context context) {
        return AntiReplayToken.create().serverTime;
    }
}
