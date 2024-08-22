package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import com.baidu.swan.apps.action.address.ChooseAddressListener;
import com.baidu.swan.apps.adaptation.interfaces.ISwanAppChooseAddress;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginUrlConstants;
import com.baidu.swan.apps.alliance.login.choose.address.SwanChooseAddressHelper;
import com.baidu.swan.apps.config.URLConfig;
import com.baidu.swan.apps.core.fragment.SwanAppWebViewFragment;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.utils.SwanAppUrlUtils;

public class DefaultSwanAppChooseAddressImpl implements ISwanAppChooseAddress {
    private static final String APP_KEY = "app_key";
    private static final String HOST_NAME_KEY = "host_name";

    public void chooseAddress(Context context, String appId, String appKey, ChooseAddressListener listener) {
        String chooseAddressUrl = URLConfig.processCommonParams(SwanAppUrlUtils.addParam(SwanAppUrlUtils.addParam(SwanAppAllianceLoginUrlConstants.ALLIANCE_CHOOSE_ADDRESS_URL, "host_name", SwanAppRuntime.getConfig().getHostName()), "app_key", appKey));
        SwanAppPageParam pageParam = SwanAppPageParam.createObject(chooseAddressUrl, chooseAddressUrl);
        SwanChooseAddressHelper.getInstance().setChooseAddressListener(listener);
        SwanAppWebViewFragment.open(ISwanPageManager.ALLIANCE_CHOOSE_ADDRESS, pageParam);
    }
}
