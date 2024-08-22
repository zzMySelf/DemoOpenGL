package com.baidu.swan.apps.statistic;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.network.SwanGetNetworkQuality;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.data.SwanApiCostOpt;
import com.baidu.swan.apps.statistic.event.SwanAppRequestEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanReqStatisticManager {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String KEY_TYPE = "type";
    /* access modifiers changed from: private */
    public static final List<SwanReqStatisticEntity> REQUEST_LIST = new ArrayList();
    private static final String TAG = "SwanReqStatisticManager";
    public static final String TYPE_DOWNLOAD = "downloadFile";
    public static final String TYPE_REQUEST = "request";
    /* access modifiers changed from: private */
    public static volatile boolean sIsStarted = false;

    public static class SwanReqStatisticEntity {
        public int netStatus;
        public JSONObject requestCost;
        /* access modifiers changed from: private */
        public final SwanAppRequestEvent requestEvent;
        /* access modifiers changed from: private */
        public final long requestTime;
        /* access modifiers changed from: private */
        public final String type;

        public SwanReqStatisticEntity(SwanAppRequestEvent requestEvent2, String type2) {
            this.requestEvent = requestEvent2;
            this.type = type2;
            this.requestTime = requestEvent2.getRequestStartTimeMs();
            synchronized (SwanReqStatisticManager.REQUEST_LIST) {
                if (SwanReqStatisticManager.sIsStarted) {
                    SwanReqStatisticManager.REQUEST_LIST.add(this);
                }
            }
        }
    }

    public static void startRecordRequest() {
        List<SwanReqStatisticEntity> list = REQUEST_LIST;
        synchronized (list) {
            sIsStarted = true;
            list.clear();
        }
    }

    public static void appendRequestRecord(HybridUbcFlow flow) {
        UbcFlowEvent fmpEvent;
        if ("670".equals(flow.getUbcId())) {
            flow.putExt("networkStatus", String.valueOf(SwanGetNetworkQuality.getNetStatus()));
            if (!SwanApiCostOpt.disable670AppendRequest && (fmpEvent = flow.getEvent("na_first_meaningful_paint")) != null) {
                long time = fmpEvent.time();
                List<SwanReqStatisticEntity> list = REQUEST_LIST;
                synchronized (list) {
                    if (DEBUG) {
                        Log.d(TAG, "size=" + list.size());
                    }
                    sIsStarted = false;
                    JSONArray array = new JSONArray();
                    for (SwanReqStatisticEntity swanReqStatisticEntity : list) {
                        if (swanReqStatisticEntity.requestTime <= time) {
                            JSONObject item = new JSONObject();
                            try {
                                item.put("type", swanReqStatisticEntity.type);
                                if (swanReqStatisticEntity.requestEvent != null) {
                                    swanReqStatisticEntity.requestEvent.mergeRequestInfo(item);
                                }
                                if (swanReqStatisticEntity.requestCost != null) {
                                    Iterator<String> it = swanReqStatisticEntity.requestCost.keys();
                                    while (it.hasNext()) {
                                        String key = it.next();
                                        item.put(key, swanReqStatisticEntity.requestCost.get(key));
                                    }
                                }
                                array.put(item);
                            } catch (JSONException e2) {
                                if (DEBUG) {
                                    Log.e(TAG, "appendRequestRecord", e2);
                                }
                            }
                        }
                    }
                    if (array.length() > 0) {
                        flow.putExt("requests", array.toString());
                    }
                }
            }
        }
    }
}
