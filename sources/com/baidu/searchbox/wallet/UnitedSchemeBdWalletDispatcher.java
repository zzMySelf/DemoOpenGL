package com.baidu.searchbox.wallet;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class UnitedSchemeBdWalletDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String MODULE_BDWALLET = "bdwallet";
    private static final String PARAMS_KEY = "params";
    private static final String PARAMS_URL_KEY = "url";
    private static final String SUBMODULE_OPEN_WALLET_HOMEPAGE = "openWalletHomePage";
    private static final String SUBMODULE_START_LIGHT_APP = "startLightApp";
    private static final int WALLET_HOMEPAGE_ID = 16384;

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        String action = entity.getPath(false);
        if (TextUtils.isEmpty(action)) {
            if (!entity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(entity.getUri(), "no action");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (entity.isOnlyVerify()) {
            return true;
        } else {
            if (TextUtils.equals(action, SUBMODULE_START_LIGHT_APP)) {
                return handleStartLightApp(context, entity, handler);
            }
            if (TextUtils.equals(action, SUBMODULE_OPEN_WALLET_HOMEPAGE)) {
                return openWalletHomePage(context, entity, handler);
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    private boolean openWalletHomePage(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        entity.result = UnitedSchemeUtility.callCallback(handler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
        try {
            WalletManager.getInstance(context).accessWalletService(16384, (String) null);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean handleStartLightApp(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        try {
            String url = new JSONObject(entity.getParam("params")).optString("url");
            if (!TextUtils.isEmpty(url)) {
                WalletManager.getInstance(AppRuntime.getAppContext()).startLightApp(context, url);
                entity.result = UnitedSchemeUtility.callCallback(handler, entity, 0);
                return true;
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String getDispatcherName() {
        return MODULE_BDWALLET;
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return null;
    }
}
