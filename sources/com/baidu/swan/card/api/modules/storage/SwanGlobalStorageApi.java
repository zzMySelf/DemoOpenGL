package com.baidu.swan.card.api.modules.storage;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.card.api.base.CardApiResult;
import com.baidu.swan.card.api.base.ICardApiContext;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.pkg.SwanCardBundleHelper;
import com.baidu.swan.card.storage.swankv.SwanCardKVImpl;
import com.baidu.swan.utils.ISwanSharedPrefs;
import com.baidu.swan.utils.SwanDefaultSharedPrefsImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanGlobalStorageApi extends StorageApi {
    private static final String ACTION_CLEAR_STORAGE = "clearGlobalStorage";
    private static final String ACTION_CLEAR_STORAGE_SYNC = "clearGlobalStorageSync";
    private static final String ACTION_GET_STORAGE = "getGlobalStorage";
    private static final String ACTION_GET_STORAGE_INFO = "getGlobalStorageInfo";
    private static final String ACTION_GET_STORAGE_INFO_SYNC = "getGlobalStorageInfoSync";
    private static final String ACTION_GET_STORAGE_SYNC = "getGlobalStorageSync";
    private static final String ACTION_REMOVE_STORAGE = "removeGlobalStorage";
    private static final String ACTION_REMOVE_STORAGE_SYNC = "removeGlobalStorageSync";
    private static final String ACTION_SET_STORAGE = "setGlobalStorage";
    private static final String ACTION_SET_STORAGE_SYNC = "setGlobalStorageSync";
    private static final String GLOBAL_STORAGE_FILE_NAME = "swan_js_global_storage";
    private static final String TAG = "SwanGlobalStorageApi";
    /* access modifiers changed from: private */
    public static long sCurrentSize = 0;
    /* access modifiers changed from: private */
    public static volatile ISwanSharedPrefs sGlobalStorage;

    public static synchronized void init() {
        synchronized (SwanGlobalStorageApi.class) {
            if (sGlobalStorage == null) {
                try {
                    sGlobalStorage = new SwanCardKVImpl(GLOBAL_STORAGE_FILE_NAME, 2, SwanCardBundleHelper.getBundleBaseFolder().getAbsolutePath());
                } catch (NoClassDefFoundError | UnsatisfiedLinkError e2) {
                    sGlobalStorage = new SwanDefaultSharedPrefsImpl(GLOBAL_STORAGE_FILE_NAME);
                }
                queryContentSize();
            }
        }
    }

    public SwanGlobalStorageApi(ICardApiContext cardApiContext) {
        super(cardApiContext);
        synchronized (SwanGlobalStorageApi.class) {
            if (sGlobalStorage == null) {
                init();
            }
        }
    }

    public String getLogTag() {
        return TAG;
    }

    public CardApiResult setStorageSync(String params) {
        logInfo("#setStorageSync", false);
        return super.setStorageSync(params);
    }

    public CardApiResult setStorage(String params) {
        logInfo("#setStorage", false);
        return super.setStorage(params);
    }

    public CardApiResult clearStorageSync(String params) {
        logInfo("#clearStorageSync", false);
        return super.clearStorageSync(params);
    }

    public CardApiResult clearStorage(String params) {
        logInfo("#clearStorage", false);
        return super.clearStorage(params);
    }

    public CardApiResult removeStorageSync(String params) {
        logInfo("#removeStorageSync", false);
        return super.removeStorageSync(params);
    }

    public CardApiResult removeStorage(String params) {
        logInfo("#removeStorage", false);
        return super.removeStorage(params);
    }

    public CardApiResult getStorageSync(String params) {
        logInfo("#getStorageSync", false);
        return super.getStorageSync(params);
    }

    public CardApiResult getStorage(String params) {
        logInfo("#getStorage", false);
        return super.getStorage(params);
    }

    public CardApiResult getStorageInfo(String params) {
        logInfo("#getStorageInfo", false);
        JSONObject joData = new JSONObject();
        try {
            joData.put("keys", new JSONArray(sGlobalStorage.keySets()));
            joData.put("currentSize", sCurrentSize / 1024);
            joData.put("limitSize", 10240);
            return new CardApiResult(0, joData);
        } catch (JSONException e2) {
            return new CardApiResult(202, "JSONException");
        }
    }

    public CardApiResult getStorageInfoSync(String params) {
        logInfo("#getStorageInfoSync", false);
        return getStorageInfo(params);
    }

    /* access modifiers changed from: protected */
    public boolean isDependentOnSwanApp() {
        return false;
    }

    /* access modifiers changed from: protected */
    public ISwanSharedPrefs getStorageImpl(SwanCard app) {
        return sGlobalStorage;
    }

    /* access modifiers changed from: protected */
    public boolean isOverLimit(SwanCard swanApp, String key, String value) {
        return (sCurrentSize - ((long) sGlobalStorage.getString(key, "").length())) + ((long) value.length()) > 10485760;
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        queryContentSize();
    }

    public static void queryContentSize() {
        if (sGlobalStorage != null) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    long unused = SwanGlobalStorageApi.sCurrentSize = SwanGlobalStorageApi.sGlobalStorage.getContentSize();
                }
            }, TAG, 2);
        }
    }
}
