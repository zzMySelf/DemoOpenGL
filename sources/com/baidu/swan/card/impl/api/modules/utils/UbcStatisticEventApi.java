package com.baidu.swan.card.impl.api.modules.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.card.api.base.CardApiResult;
import com.baidu.swan.card.api.base.ICardApiContext;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.launch.model.SwanCardLaunchInfo;
import com.baidu.swan.card.ubc.SwanAppStatsUtils;
import com.baidu.swan.card.utils.SwanAppJSONUtils;
import com.baidu.swan.card.utils.SwanCardLog;
import org.json.JSONObject;

public class UbcStatisticEventApi extends AbsPrivateUtilApi {
    private static final String ACTION_NAME = "ubcStatisticEvent";
    public static final String DATA_EXT_ERR_INFO_KEY_MESSAGE = "message";
    public static final String DATA_EXT_KEY_ERR_INFO = "errInfo";
    public static final String DATA_KEY_EXT = "ext";
    private static final String DATA_KEY_SOURCE = "source";
    public static final String DATA_KEY_TYPE = "type";
    private static final String EXT_KEY_LAUNCH_ID = "launchId";
    private static final String EXT_KEY_PACKAGE_VERSION = "packageVersion";
    private static final String EXT_KEY_SCHEME = "scheme";
    public static final String PARAM_DATA = "data";
    private static final String PARAM_UBC_ID = "ubcId";
    private static final String STABILITY_LOG_PREFIX = "671 event=";
    private static final String TAG = "UbcStatisticEventApi";
    private static final String WHITELIST_NAME = "swanAPI/ubcStatisticEvent";

    public UbcStatisticEventApi(ICardApiContext cardApiContext) {
        super(cardApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    public CardApiResult ubcStatisticEvent(String params) {
        Pair<CardApiResult, JSONObject> pairResult = parseJson(params);
        CardApiResult parseResult = (CardApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        JSONObject joParams = (JSONObject) pairResult.second;
        SwanCard swanCard = getCardOrNull(joParams);
        if (swanCard == null) {
            return CardApiResult.cardIsNull();
        }
        final String ubcId = joParams.optString("ubcId");
        final JSONObject data = joParams.optJSONObject("data");
        if (TextUtils.isEmpty(ubcId) || data == null) {
            return new CardApiResult(202);
        }
        SwanAppJSONUtils.setValue(data, "source", swanCard.getInfo().getLaunchFrom());
        JSONObject ext = data.optJSONObject("ext");
        if (ext == null) {
            ext = new JSONObject();
            SwanAppJSONUtils.setValue(data, "ext", ext);
        }
        addStatisticCommonParamsToExt(swanCard, ext);
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                SwanCardRuntime.getSwanCardContext().checkIsJsErrorAndNeedReport(data);
                if (TextUtils.equals(ubcId, "671")) {
                    SwanCardLog.logToFile(UbcStatisticEventApi.ACTION_NAME, UbcStatisticEventApi.STABILITY_LOG_PREFIX + data.toString());
                }
                SwanCardRuntime.getSwanCardContext().getStatRouter().recordUbcEvent(ubcId, data);
            }
        }, TAG, 2);
        return CardApiResult.ok();
    }

    public static void addStatisticCommonParamsToExt(SwanCard swanCard, JSONObject ext) {
        if (ext != null) {
            SwanCardLaunchInfo.Impl launchInfo = swanCard.getInfo();
            SwanAppJSONUtils.setValue(ext, "launchId", launchInfo.getLaunchId());
            SwanAppJSONUtils.setValue(ext, "scheme", launchInfo.getLaunchScheme());
            SwanAppJSONUtils.setValue(ext, EXT_KEY_PACKAGE_VERSION, launchInfo.getVersion());
            SwanAppStatsUtils.addUbcStatisticCommonParams(swanCard.getCardId(), ext);
        }
    }
}
