package com.baidu.searchbox.libsimcard.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.interfere.NetworkInterfereHelper;
import com.baidu.searchbox.libsimcard.model.MobcomNetResult;
import com.baidu.searchbox.libsimcard.model.SimCardData;
import com.baidu.searchbox.libsimcard.model.SimCardNetResult;
import com.baidu.searchbox.libsimcard.model.TelecomNetResult;
import com.baidu.searchbox.libsimcard.service.MobcomNetService;
import com.baidu.searchbox.libsimcard.service.SimCardNetService;
import com.baidu.searchbox.libsimcard.service.TelecomNetService;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class SimCardHelper implements ISimCardHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String ISP_CMNET = "CMNET";
    public static final String ISP_TELECOM = "TELECOM";
    public static final String ISP_UNICOM = "UNICOM";
    private static final String PARAMVALUE_NEEDTIPS = "1";
    private static final String PARAMVALUE_NOTNEEDTIPS = "0";
    private static final String PARAM_BID = "bid";
    private static final String PARAM_NEEDTIPS = "need_tips";
    private static final String PARAM_OPENID = "openid";
    private static final String PARAM_PCID = "pcid";
    private static final String PARAM_PRODUCT = "product";
    private static final String PARAM_SIGN = "sign";
    private static final String PARAM_TRACK = "track";
    public static final String PREF_FREE_FLOW_SEARCH = "pref_key_free_search_flow";
    private static final String PREF_MOBCOM_SWITCH = "key_mobcom_switch";
    private static final String PREF_SIMCARD_SWITCH = "key_simcard_switch";
    private static final String PREF_TELECOM_SWITCH = "key_telecom_switch";
    public static final String PRODUCT_MOBCOMPKG = "9";
    public static final String PRODUCT_UNICOMBIG = "1";
    public static final String PRODUCT_UNICOMPKG = "6";
    public static final String PRODUCT_UNICOMSKY = "4";
    public static final String PRODUCT_UNICOMSKYPLUS = "5";
    public static final String PRODUCT_UNICOMSMALL = "2";
    public static final String PRODUCT_UNICOMSUPER = "3";
    public static final String PRODUCT_UNKNOWN = "0";
    private static final int QUERY_FINISHED = 2;
    private static final int QUERY_ING = 1;
    private static final int QUERY_NOTBEGIN = 0;
    private static final String SIGN_KEY = "smJsaHUdXaDwFrUe";
    private static final String TAG = SimCardHelper.class.getSimpleName();
    public static final String THREAD_NAME = "SimCard";
    public static final String TIPKEY_FREE = "1";
    public static final String TIPKEY_FREE_SEARCH = "5";
    public static final String TIPKEY_FREE_VIDEO = "4";
    public static final String TIPKEY_NOTSUPPORT = "3";
    public static final String TIPKEY_THIRDPART = "2";
    public static final String TOAST_FROM_COMIC = "comic";
    public static final String TOAST_FROM_FEED = "list";
    public static final String TOAST_FROM_NOVEL = "novel";
    public static final String TOAST_FROM_SEARCH = "search";
    public static final String TOAST_FROM_VIDEO = "video";
    private static final String TRACK_COLDBOOT = "1";
    private static final String TRACK_NETCHANGE = "3";
    private static final String TRACK_WARMBOOT = "2";
    private static final String UBC_EVENT_ID = "527";
    private static final String UBC_KEY_PAGE = "page";
    public static boolean isFirstStartValidate = true;
    private String mLocalip;
    private MobcomNetResult mMobcomNetResult;
    private MobcomNetService mMobcomNetService;
    private SimCardData mSimCardData;
    private SimCardNetService mSimCardNetService;
    private Vector<ISimCardObserver> mSimCardObservers;
    private TelecomNetResult mTelecomNetResult;
    private TelecomNetService mTelecomNetService;
    private Handler netChangeHandler;

    private SimCardHelper() {
        this.netChangeHandler = new NetChangeHandler(Looper.getMainLooper());
        this.mSimCardData = new SimCardData();
        this.mSimCardNetService = new SimCardNetService();
        this.mTelecomNetService = new TelecomNetService();
        this.mMobcomNetService = new MobcomNetService();
    }

    public void postNetChangeMsg() {
        this.netChangeHandler.removeMessages(100);
        if (NetworkInterfereHelper.isPeakTime()) {
            this.netChangeHandler.sendEmptyMessageDelayed(100, (long) (NetworkInterfereHelper.getDelayTime() * 1000));
        } else {
            this.netChangeHandler.sendEmptyMessageDelayed(100, 1000);
        }
    }

    public SimCardData validateByColdBoot() {
        Map<String, String> params = new HashMap<>();
        params.put("track", "1");
        return validate(params);
    }

    public SimCardData validateByNetChange() {
        Map<String, String> params = new HashMap<>();
        params.put("track", "3");
        return validate(params);
    }

    private SimCardData validate(Map<String, String> params) {
        if (params == null) {
            return new SimCardData();
        }
        TelecomNetResult validateWithTelecomNetSync = validateWithTelecomNetSync();
        this.mTelecomNetResult = validateWithTelecomNetSync;
        if (validateWithTelecomNetSync != null) {
            String telecomProduct = validateWithTelecomNetSync.getProduct();
            String telecomOpenId = this.mTelecomNetResult.getOpenId();
            String telecomBid = this.mTelecomNetResult.getBid();
            if (!TextUtils.isEmpty(telecomProduct)) {
                params.put("product", telecomProduct);
                params.put("sign", getSign(telecomProduct));
            }
            if (!TextUtils.isEmpty(telecomOpenId)) {
                params.put("openid", telecomOpenId);
            }
            if (!TextUtils.isEmpty(telecomBid)) {
                params.put(PARAM_BID, telecomBid);
            }
        }
        MobcomNetResult validateWithMobcomNetSync = validateWithMobcomNetSync();
        this.mMobcomNetResult = validateWithMobcomNetSync;
        if (validateWithMobcomNetSync != null) {
            String mobcomPcid = validateWithMobcomNetSync.getPCID();
            if (!TextUtils.isEmpty(mobcomPcid)) {
                params.put(PARAM_PCID, mobcomPcid);
            }
        }
        return validateWithNetSync(params);
    }

    public synchronized void register(ISimCardObserver observer) {
        if (observer != null) {
            if (this.mSimCardObservers == null) {
                this.mSimCardObservers = new Vector<>();
            }
            if (DEBUG) {
                Log.d(TAG, "register:" + observer.toString());
            }
            this.mSimCardObservers.add(observer);
        }
    }

    public synchronized void unregister(ISimCardObserver observer) {
        if (!(this.mSimCardObservers == null || observer == null)) {
            if (DEBUG) {
                Log.d(TAG, "unregister:" + observer.toString());
            }
            this.mSimCardObservers.remove(observer);
        }
    }

    public synchronized void notifyObservers(boolean isFreeFlowSimCard, SimCardData simCardData) {
        if (this.mSimCardObservers != null) {
            for (int index = 0; index < this.mSimCardObservers.size(); index++) {
                this.mSimCardObservers.get(index).updateSimCardData(isFreeFlowSimCard, simCardData);
                if (DEBUG) {
                    Log.d(TAG, "[ notifyObservers ] index:" + index + " isFreeFlowSimCard:" + isFreeFlowSimCard);
                }
            }
        }
    }

    public void notifySimCardObservers() {
        boolean z = true;
        if (!new SharedPrefsWrapper("").getBoolean(PREF_FREE_FLOW_SEARCH, true) || !isEnable() || !NetWorkUtils.isMobileNetworkConnected(AppRuntime.getAppContext()) || !isUnicomFreeCard(this.mSimCardData)) {
            z = false;
        }
        boolean result = z;
        if (DEBUG) {
            Log.d(TAG, "免流通知=" + result + "_simCard=" + this.mSimCardData.toString());
        }
        notifyObservers(result, this.mSimCardData);
    }

    public void notifySimCardObservers(SimCardData simCardData) {
        if (simCardData != null) {
            this.mSimCardData = simCardData;
        }
        notifySimCardObservers();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SimCardHelper SINGLE = new SimCardHelper();

        private SingletonHolder() {
        }
    }

    public static SimCardHelper getInstance() {
        return SingletonHolder.SINGLE;
    }

    private TelecomNetResult validateWithTelecomNetSync() {
        if (this.mTelecomNetService == null) {
            return null;
        }
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "validateWithTelecomNetSync");
        }
        if (!isEnable()) {
            if (z) {
                Log.d(TAG, "云端开关 为 close 状态");
            }
            return null;
        } else if (!isTelecomEnable()) {
            if (z) {
                Log.d(TAG, "云端电信开关 为 close 状态");
            }
            return null;
        } else if (!NetWorkUtils.isMobileNetworkConnected(AppRuntime.getAppContext())) {
            if (z) {
                Log.d(TAG, "非移动网络,返回 不是电信卡 的结果");
            }
            return null;
        } else if (isTelecomNetOrUnknown()) {
            return this.mTelecomNetService.queryTelecomAut();
        } else {
            if (z) {
                Log.d(TAG, "非电信网络,返回 不是电信卡 的结果");
            }
            return null;
        }
    }

    private MobcomNetResult validateWithMobcomNetSync() {
        if (this.mMobcomNetService == null) {
            return null;
        }
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "validateWithMobcomNetSync");
        }
        if (!isEnable()) {
            if (z) {
                Log.d(TAG, "云端开关 为 close 状态");
            }
            return null;
        } else if (!isMobcomEnable()) {
            if (z) {
                Log.d(TAG, "云端移动开关 为 close 状态");
            }
            return null;
        } else if (!NetWorkUtils.isMobileNetworkConnected(AppRuntime.getAppContext())) {
            if (z) {
                Log.d(TAG, "非移动网络,返回 不是电信卡 的结果");
            }
            return null;
        } else if (isMobcomNetOrUnknown()) {
            return this.mMobcomNetService.queryMobcomAut();
        } else {
            if (z) {
                Log.d(TAG, "非移动网络,返回 不是移动卡 的结果");
            }
            return null;
        }
    }

    private SimCardData validateWithNetSync(Map<String, String> extParams) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "[ validateWithNetSync ]");
        }
        if (!isEnable()) {
            if (z) {
                Log.d(TAG, "云端开关 为 close 状态");
            }
            return new SimCardData();
        } else if (!NetWorkUtils.isMobileNetworkConnected(AppRuntime.getAppContext())) {
            if (z) {
                Log.d(TAG, "非移动网络,返回 不是大圣卡 的结果");
            }
            return new SimCardData();
        } else if (!isUnicomFreeCard(this.mSimCardData) || !TextUtils.equals(this.mLocalip, this.mSimCardNetService.getLocalIp())) {
            boolean needTips = this.mSimCardData.getTipsconf() == null || this.mSimCardData.getTipsconf().size() <= 0;
            Map<String, String> postParams = new HashMap<>();
            if (extParams != null) {
                postParams.putAll(extParams);
            }
            postParams.put(PARAM_NEEDTIPS, needTips ? "1" : "0");
            SimCardNetResult currResult = this.mSimCardNetService.querySimCard(postParams);
            if (currResult.isSuccess()) {
                updateCacheAndIp(needTips, currResult);
            } else {
                if (!TextUtils.isEmpty(this.mLocalip) && !TextUtils.equals(this.mLocalip, currResult.getExtraInfo().getLocalip())) {
                    this.mSimCardData.resetWithoutTips();
                    this.mLocalip = currResult.getExtraInfo().getLocalip();
                }
                TelecomNetResult telecomNetResult = this.mTelecomNetResult;
                if (telecomNetResult != null) {
                    String product = telecomNetResult.getProduct();
                    if ("4".equals(product)) {
                        updateProductAndIsp(product, ISP_TELECOM);
                    }
                }
            }
            TelecomNetResult telecomNetResult2 = this.mTelecomNetResult;
            if (telecomNetResult2 != null) {
                telecomNetResult2.reset();
            }
            return this.mSimCardData;
        } else {
            if (z) {
                Log.d(TAG, "当前为大圣卡，且localip没变，不查询网络，返回缓存结果");
            }
            return this.mSimCardData;
        }
    }

    private void updateCacheAndIp(boolean needTips, SimCardNetResult currResult) {
        if (needTips) {
            this.mSimCardData = currResult.getCorrectResult();
        } else {
            Map<String, String> tipConf = this.mSimCardData.getTipsconf();
            SimCardData correctResult = currResult.getCorrectResult();
            this.mSimCardData = correctResult;
            correctResult.setTipsconf(tipConf);
        }
        this.mLocalip = currResult.getExtraInfo().getLocalip();
    }

    private void updateProductAndIsp(String product, String isp) {
        SimCardData simCardData = this.mSimCardData;
        if (simCardData != null) {
            simCardData.setProduct(product);
            this.mSimCardData.setIsp(isp);
            if (DEBUG) {
                Log.d(TAG, "update product and isp to memory：[product]:" + product + " [isp]:" + isp);
            }
        }
    }

    public SimCardData getSimCardCache() {
        if (!isEnable()) {
            return new SimCardData();
        }
        if (!NetWorkUtils.isMobileNetworkConnected(AppRuntime.getAppContext())) {
            return new SimCardData();
        }
        return this.mSimCardData;
    }

    public boolean isUnicomFreeCard(SimCardData simCardData) {
        return simCardData != null && !TextUtils.isEmpty(simCardData.getProduct()) && !"0".equals(simCardData.getProduct());
    }

    public boolean isFreeFlowCard() {
        return isUnicomFreeCard(getSimCardCache());
    }

    public boolean isMobcomFreeCard() {
        SimCardData simCardData = getSimCardCache();
        return simCardData != null && ISP_CMNET.equals(simCardData.getIsp());
    }

    private String getSign(String product) {
        return MD5Utils.toMd5((BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getUid() + (TextUtils.isEmpty(product) ? "" : product) + SIGN_KEY).getBytes(), false);
    }

    public String getConfTip(String tipConfKey) {
        SimCardData simCardData = this.mSimCardData;
        if (simCardData == null || simCardData.getTipsconf() == null) {
            return "";
        }
        return this.mSimCardData.getTipsconf().get(tipConfKey);
    }

    public boolean isEnable() {
        return new SharedPrefsWrapper("").getBoolean("key_simcard_switch", true);
    }

    private boolean isTelecomEnable() {
        return new SharedPrefsWrapper("").getBoolean("key_telecom_switch", true);
    }

    private boolean isMobcomEnable() {
        return new SharedPrefsWrapper("").getBoolean("key_mobcom_switch", true);
    }

    private boolean isTelecomNetOrUnknown() {
        String netTypeId = BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getCurrentNetTypeId();
        return TextUtils.isEmpty(netTypeId) || netTypeId.startsWith("5_") || netTypeId.startsWith("33_") || netTypeId.startsWith("43_");
    }

    private boolean isMobcomNetOrUnknown() {
        String netTypeId = BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getCurrentNetTypeId();
        return TextUtils.isEmpty(netTypeId) || netTypeId.startsWith("5_") || netTypeId.startsWith("31_") || netTypeId.startsWith("41_");
    }

    public void showToast(Context context, String toastContent, String from) {
        if (!TextUtils.isEmpty(toastContent)) {
            UniversalToast.makeText(context, (CharSequence) toastContent).showToast();
            logUbcEvent(from);
        }
    }

    private void logUbcEvent(String from) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("page", from);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d(TAG, e2.getMessage(), e2);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_EVENT_ID, jsonObject.toString());
    }
}
