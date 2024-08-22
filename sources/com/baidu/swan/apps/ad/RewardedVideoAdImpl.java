package com.baidu.swan.apps.ad;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.game.ad.interfaces.IAdView;
import com.baidu.swan.game.ad.reward.IRewardAdEventListener;
import com.baidu.swan.game.ad.reward.RewardAdProxy;
import com.baidu.swan.game.ad.statistics.AdStatisticsManager;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class RewardedVideoAdImpl implements IRewardedVideoAd {
    private static final String AD_UNITID = "adUnitId";
    private static final String APPSID = "appSid";
    public String adUnitId = "";
    private IRewardAdEventListener mAdEventListener = new IRewardAdEventListener() {
        public void onLoad(boolean success, String code) {
            if (success) {
                RewardedVideoAdImpl.this.mEventCallback.handleLoadCallback();
                RewardedVideoAdImpl.this.mLoadAdCallback.handleActionCallback(0);
                for (IRewardedVideoActionCallback observerListener : RewardedVideoAdImpl.this.mCallbacks) {
                    observerListener.handleActionCallback(0);
                    if (RewardedVideoAdImpl.this.mCallbacks.contains(observerListener)) {
                        RewardedVideoAdImpl.this.mCallbacks.remove(observerListener);
                    }
                }
                return;
            }
            RewardedVideoAdImpl.this.mLoadAdCallback.handleActionCallback(1001);
            for (IRewardedVideoActionCallback observerListener2 : RewardedVideoAdImpl.this.mCallbacks) {
                observerListener2.handleActionCallback(1001);
                if (RewardedVideoAdImpl.this.mCallbacks.contains(observerListener2)) {
                    RewardedVideoAdImpl.this.mCallbacks.remove(observerListener2);
                }
            }
        }

        public void onShow(boolean success, String code) {
            if (success) {
                RewardedVideoAdImpl.this.mShowAdCallback.handleActionCallback(0);
            } else {
                RewardedVideoAdImpl.this.mShowAdCallback.handleActionCallback(1001);
            }
        }

        public void onError(String code) {
            RewardedVideoAdImpl.this.mEventCallback.handleErrorCallback(RewardedVideoAdEventParams.genErrorMsg(code));
            AdStatisticsManager.sendMonitorErrorLog(RewardedVideoAdImpl.this.mLogMap, code);
        }

        public void onClose(boolean state, int duration) {
            RewardedVideoAdImpl.this.mEventCallback.handleCloseCallback(RewardedVideoAdEventParams.genCloseAdMsg(state));
        }

        public void onClick(int progress) {
        }
    };
    private String mAppSid;
    /* access modifiers changed from: private */
    public List<IRewardedVideoActionCallback> mCallbacks;
    /* access modifiers changed from: private */
    public IRewardedVideoEventCallback mEventCallback;
    private RewardAdProxy mHandleAd;
    /* access modifiers changed from: private */
    public IRewardedVideoActionCallback mLoadAdCallback;
    /* access modifiers changed from: private */
    public Map<String, String> mLogMap = new TreeMap();
    /* access modifiers changed from: private */
    public IRewardedVideoActionCallback mShowAdCallback;
    private IAdView mSwanAdUIManager;

    public RewardedVideoAdImpl(JSONObject params, IRewardedVideoEventCallback eventCb, IRewardedVideoActionCallback actionCb) {
        if (params == null || TextUtils.isEmpty(params.optString(AD_UNITID)) || TextUtils.isEmpty(params.optString(APPSID))) {
            actionCb.handleActionCallback(202);
            return;
        }
        this.adUnitId = params.optString(AD_UNITID);
        String optString = params.optString(APPSID);
        this.mAppSid = optString;
        this.mLogMap = AdStatisticsManager.genMonitorMap("video", "app", optString, this.adUnitId, false);
        this.mSwanAdUIManager = new SwanAdViewManager();
        RewardAdProxy rewardAdProxy = new RewardAdProxy(Swan.get().getActivity(), this.mAppSid, this.adUnitId, false, this.mAdEventListener, this.mSwanAdUIManager);
        this.mHandleAd = rewardAdProxy;
        rewardAdProxy.setLogMap(this.mLogMap);
        this.mCallbacks = new CopyOnWriteArrayList();
        loadAd(params, actionCb, eventCb);
    }

    public synchronized void loadAd(JSONObject params, IRewardedVideoActionCallback callback, IRewardedVideoEventCallback eventCallback) {
        this.mEventCallback = eventCallback;
        if (this.mHandleAd != null) {
            this.mLoadAdCallback = callback;
            if (callback != null && !this.mCallbacks.contains(callback)) {
                this.mCallbacks.add(callback);
            }
            this.mHandleAd.load();
        }
    }

    public synchronized void showAd(JSONObject params, IRewardedVideoActionCallback callback) {
        RewardAdProxy rewardAdProxy = this.mHandleAd;
        if (rewardAdProxy != null) {
            this.mShowAdCallback = callback;
            rewardAdProxy.show();
        }
    }
}
