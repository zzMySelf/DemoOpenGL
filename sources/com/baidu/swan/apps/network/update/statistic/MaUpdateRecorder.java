package com.baidu.swan.apps.network.update.statistic;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

public class MaUpdateRecorder {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EXT_MA_UPDATE_RECORDER_KEY = "ma_update_recorder";
    private static final String TAG = "MaUpdateRecorder";
    private static final MaUpdateRecorder sInstance = new MaUpdateRecorder();
    private final Map<String, Model> mCache = new HashMap();
    private boolean mDone = false;
    private IFilter mFilter;
    private final List<Model> mModels = new ArrayList();

    private MaUpdateRecorder() {
    }

    public static MaUpdateRecorder get() {
        return sInstance;
    }

    public void reset() {
        this.mDone = false;
        synchronized (this.mModels) {
            this.mModels.clear();
            this.mCache.clear();
        }
        if (DEBUG) {
            Log.d(TAG, "reset");
        }
    }

    public void done() {
        this.mDone = true;
        synchronized (this.mModels) {
            this.mModels.clear();
            this.mCache.clear();
        }
        if (DEBUG) {
            Log.d(TAG, "done");
        }
    }

    public void setFilter(IFilter filter) {
        this.mFilter = filter;
    }

    public String begin(String scopeId) {
        if (this.mDone) {
            return null;
        }
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "begin update scope id - " + scopeId);
        }
        if (TextUtils.isEmpty(scopeId)) {
            return null;
        }
        long beginTs = System.currentTimeMillis();
        String uniTag = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        Model model = new Model(scopeId);
        model.begin(beginTs);
        synchronized (this.mModels) {
            this.mCache.put(uniTag, model);
        }
        if (z) {
            Log.d(TAG, "begin update uni tag - " + uniTag);
            Log.d(TAG, "begin update ts - " + beginTs);
        }
        return uniTag;
    }

    public void end(String uniTag) {
        if (!this.mDone) {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "end update uni tag - " + uniTag);
            }
            if (!TextUtils.isEmpty(uniTag)) {
                long endTs = System.currentTimeMillis();
                synchronized (this.mModels) {
                    Model model = this.mCache.get(uniTag);
                    if (model != null) {
                        model.end(endTs);
                        this.mModels.add(model);
                        this.mCache.remove(uniTag);
                    }
                }
                if (z) {
                    Log.d(TAG, "end update ts - " + endTs);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void appendInfo(HybridUbcFlow msg) {
        if (msg != null) {
            JSONArray array = format();
            if (array != null && array.length() > 0) {
                msg.putExt(EXT_MA_UPDATE_RECORDER_KEY, array.toString());
            }
            done();
        }
    }

    private JSONArray format() {
        JSONArray array = new JSONArray();
        synchronized (this.mModels) {
            try {
                for (Model model : this.mModels) {
                    if (model != null) {
                        IFilter iFilter = this.mFilter;
                        if (iFilter == null || iFilter.pick(model)) {
                            array.put(model.toJson());
                        }
                    }
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, array.toString());
        }
        return array;
    }
}
