package com.baidu.awareness.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.awareness.fence.AwarenessFence;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FenceRequestManager implements FenceRequestDataUpdateListener {
    private static Handler HANDLER = new Handler(Looper.getMainLooper());
    private static volatile FenceRequestManager mInstance;
    private HashMap<String, FenceRequest> allFencesMap = new LinkedHashMap();
    private Context mContext;

    private FenceRequestManager(Context context) {
        this.mContext = context;
        DataManager.get(this.mContext).setFenceRequestUpdateListener(this);
    }

    public static FenceRequestManager get(Context context) {
        if (mInstance == null) {
            synchronized (FenceRequestManager.class) {
                if (mInstance == null) {
                    mInstance = new FenceRequestManager(context);
                }
            }
        }
        return mInstance;
    }

    public FenceRequestManager addRequest(FenceRequest fenceRequest) {
        PreConditions.checkNotNull(fenceRequest);
        PreConditions.checkArgument((TextUtils.isEmpty(fenceRequest.fenceKey) || fenceRequest.fence == null || fenceRequest.resultCallback == null) ? false : true);
        if (!this.allFencesMap.containsKey(fenceRequest.fenceKey)) {
            synchronized (this) {
                this.allFencesMap.put(fenceRequest.fenceKey, fenceRequest);
            }
            DataManager.get(this.mContext).requestFenceData(fenceRequest.fenceKey, RequestFeatureExtractor.extractFrom((AwarenessFence) fenceRequest.fence));
            return this;
        }
        throw new IllegalArgumentException("注册名为" + fenceRequest.fenceKey + "的fence已经存在");
    }

    public boolean removeRequest(String fenceKey) {
        PreConditions.checkArgument(!TextUtils.isEmpty(fenceKey));
        synchronized (this) {
            if (this.allFencesMap.remove(fenceKey) == null) {
                return false;
            }
            DataManager.get(this.mContext).stopRequestFenceData(fenceKey);
            return true;
        }
    }

    public void clear() {
        synchronized (this) {
            Iterator<Map.Entry<String, FenceRequest>> iterator = this.allFencesMap.entrySet().iterator();
            while (iterator.hasNext()) {
                DataManager.get(this.mContext).stopRequestFenceData((String) iterator.next().getKey());
                iterator.remove();
            }
        }
    }

    public void onFenceDataUpdate(String key, SparseArray<BaseState> data) {
        if (data != null && data.size() > 0) {
            final FenceRequest fenceRequest = this.allFencesMap.get(key);
            if (fenceRequest.fence.isMatched(data)) {
                HANDLER.post(new Runnable() {
                    public void run() {
                        fenceRequest.resultCallback.onEnterFence();
                    }
                });
            }
        }
    }
}
