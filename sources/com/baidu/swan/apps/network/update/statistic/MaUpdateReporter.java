package com.baidu.swan.apps.network.update.statistic;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class MaUpdateReporter implements TypedCallback<HybridUbcFlow> {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "MaUpdateReporter";

    public MaUpdateReporter() {
        MaUpdateRecorder.get().reset();
        if (DEBUG) {
            Log.d(TAG, "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public void onCallback(HybridUbcFlow msg) {
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "report: flow=" + msg);
        }
        if (msg != null) {
            final UbcFlowEvent start = msg.getEvent("naStart");
            final UbcFlowEvent end = msg.getEvent("na_first_meaningful_paint");
            if (start == null || end == null) {
                if (z) {
                    if (start == null) {
                        Log.w(TAG, "MaUpdateReporter: na_start = null !!!");
                    } else {
                        Log.w(TAG, "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                    }
                }
                MaUpdateRecorder.get().done();
                return;
            }
            MaUpdateRecorder.get().setFilter(new IFilter() {
                public boolean pick(Model model) {
                    if (model == null) {
                        return false;
                    }
                    return MaUpdateReporter.this.needPick(model, start, end);
                }
            });
            MaUpdateRecorder.get().appendInfo(msg);
            if (z) {
                Log.d(TAG, "na_start ts - " + start.time());
                Log.d(TAG, "fmp_end ts - " + end.time());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean needPick(Model model, UbcFlowEvent start, UbcFlowEvent end) {
        long recordTs = model.beginTime();
        return recordTs >= start.time() && recordTs <= end.time();
    }
}
