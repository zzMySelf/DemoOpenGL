package com.baidu.browser.searchtalos.impl;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RNSearchHandleHttpState {
    public static final String KEY_PAGE_ID = "pageId";
    private static final String TAG = "RNSearchHandleHttpState";
    private static volatile RNSearchHandleHttpState instance;
    private ConcurrentHashMap<String, IRNSearchHandleHttpState> mStateObservers = new ConcurrentHashMap<>(8);

    public interface IRNSearchHandleHttpState {
        Map<String, Object> getPageData(String str);

        void onHandleDataState(JSONObject jSONObject);
    }

    private RNSearchHandleHttpState() {
    }

    public static RNSearchHandleHttpState getInstance() {
        if (instance == null) {
            synchronized (RNSearchHandleHttpState.class) {
                if (instance == null) {
                    instance = new RNSearchHandleHttpState();
                }
            }
        }
        return instance;
    }

    public void registerRNStateObserver(String pageId, IRNSearchHandleHttpState irnSearchHandleHttpStateCallBack) {
        if (this.mStateObservers != null && !TextUtils.isEmpty(pageId)) {
            this.mStateObservers.put(pageId, irnSearchHandleHttpStateCallBack);
        }
        if (AppConfig.isDebug()) {
            Log.v(TAG, "registerRNStateObserver pageId = " + pageId);
        }
    }

    public void unRegisterRNStateObserver(String pageId) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "unRegisterRNStateObserver pageId = " + pageId);
        }
        if (this.mStateObservers != null && !TextUtils.isEmpty(pageId)) {
            this.mStateObservers.remove(pageId);
        }
    }

    public boolean hasEventObserver() {
        ConcurrentHashMap<String, IRNSearchHandleHttpState> concurrentHashMap = this.mStateObservers;
        return concurrentHashMap != null && !concurrentHashMap.isEmpty();
    }

    public void onHandleDataState(String param) {
        IRNSearchHandleHttpState pageObserver;
        if (AppConfig.isDebug()) {
            Log.v(TAG, "onHandleDataState params = " + param);
        }
        try {
            JSONObject jsonObject = new JSONObject(param);
            String pageId = jsonObject.getString("pageId");
            if (AppConfig.isDebug()) {
                Log.v(TAG, "onHandleDataState pageId = " + pageId);
                Log.v(TAG, "onHandleDataState mStateObservers.containsKey(pageId) = " + this.mStateObservers.containsKey(pageId));
            }
            ConcurrentHashMap<String, IRNSearchHandleHttpState> concurrentHashMap = this.mStateObservers;
            if (concurrentHashMap != null && (pageObserver = concurrentHashMap.get(pageId)) != null) {
                pageObserver.onHandleDataState(jsonObject);
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public Map<String, Object> getPageData(String pageId) {
        IRNSearchHandleHttpState pageObserver;
        ConcurrentHashMap<String, IRNSearchHandleHttpState> concurrentHashMap = this.mStateObservers;
        if (concurrentHashMap == null || pageId == null || (pageObserver = concurrentHashMap.get(pageId)) == null) {
            return null;
        }
        if (AppConfig.isDebug()) {
            Log.v(TAG, "getPageData hasObserver pageId = " + pageId);
        }
        return pageObserver.getPageData(pageId);
    }
}
