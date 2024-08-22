package com.baidu.swan.apps.impl.share;

import android.text.TextUtils;
import com.baidu.swan.apps.impl.share.SwanAppShareLinkParams;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppUtils;
import java.io.File;

public class SwanAppScreenShareParams extends SwanAppShareLinkParams {
    public /* bridge */ /* synthetic */ boolean isAgent() {
        return super.isAgent();
    }

    public /* bridge */ /* synthetic */ boolean isOverMaxLengthLimit() {
        return super.isOverMaxLengthLimit();
    }

    public /* bridge */ /* synthetic */ String obtainDefaultShareLink() {
        return super.obtainDefaultShareLink();
    }

    public static SwanAppShareLinkParams createShareParams() {
        return createShareParams(Swan.get().getApp().getAppKey(), Swan.get().getAppId(), SwanAppSocialShareImpl.appendQueryHost(SwanAppPageParam.buildPageWithParams(SwanAppUtils.getCurSwanAppPageParam())), SwanAppUtils.isLingJingAgent());
    }

    public static SwanAppShareLinkParams createShareParams(String appKey, String appId, String path, boolean isAgent) {
        SwanAppShareLinkParams params = new SwanAppScreenShareParams();
        params.appKey = appKey;
        params.appId = appId;
        params.path = path;
        params.isAgent = isAgent;
        if (!TextUtils.isEmpty(params.path) && !params.path.startsWith(File.separator)) {
            params.path = File.separator + params.path;
        }
        return params;
    }

    public SwanAppShareLinkParams.ShareType getShareType() {
        return SwanAppShareLinkParams.ShareType.SCREEN_SHARE;
    }
}
