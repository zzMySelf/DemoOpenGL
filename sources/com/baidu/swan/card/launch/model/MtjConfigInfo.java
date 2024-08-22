package com.baidu.swan.card.launch.model;

import android.util.Log;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.utils.SwanAppLibConfig;

public class MtjConfigInfo {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String KEY_DISABLE_FRAME_MTJ = "disableFrameMtj";
    private static final String TAG = "MtjConfigInfo";
    public static final String VALUE_DISABLE_FRAME_MTJ_OFF = "0";
    public static final String VALUE_DISABLE_FRAME_MTJ_ON = "1";

    public static String getDisableFrameMtjValue(String cardId) {
        String value;
        SwanCard swanCard = SwanCardManager.get().getCardOrNull(cardId);
        if (SwanCardRuntime.getSwanCardContext().isMtjDisableForFrame(swanCard != null ? swanCard.getInfo().getPmsAppInfo() : null)) {
            value = "1";
        } else {
            value = "0";
        }
        if (DEBUG) {
            Log.d(TAG, "disableFrameMtj:" + value);
        }
        return value;
    }
}
