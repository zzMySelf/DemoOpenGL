package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ubc.utils.LogIdUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UBCArrivalStatics {
    private static final boolean DEBUG = UBCHelper.isDebug();
    private static final String KEY_LOGID_RECORD_MAX = "max";
    private static final String KEY_LOGID_RECORD_MIN = "min";
    private static final String KEY_LOGID_SESSION = "s";
    private static final String TAG = "UBCArrivalStatics";
    public static final String UBC_ARRIVAL_ID = "2980";
    public static final int UPLOAD_DAY_RANGE = 7;
    private static volatile UBCArrivalStatics mInstance;
    private UBCDatabaseAdapter mDbAdapter;

    public static class UBCDateRecord {
        public Map<String, JSONObject> counts = new HashMap();
        public String date;
        public int total = 0;
    }

    static UBCArrivalStatics getInstance() {
        if (mInstance == null) {
            synchronized (UBCArrivalStatics.class) {
                if (mInstance == null) {
                    mInstance = new UBCArrivalStatics();
                }
            }
        }
        return mInstance;
    }

    private UBCArrivalStatics() {
    }

    public void setDbAdapter(UBCDatabaseAdapter dbAdapter) {
        this.mDbAdapter = dbAdapter;
    }

    public void addUBCRecord(String ubcId, boolean fromCallEntry) {
        addUBCRecord(ubcId, fromCallEntry, (String) null);
    }

    public void addUBCRecord(String ubcId, boolean fromCallEntry, String logId) {
        if (this.mDbAdapter == null || TextUtils.isEmpty(ubcId) || !TextUtils.isDigitsOnly(ubcId) || !canRecordArrivalDataAndLogId()) {
            return;
        }
        if (fromCallEntry || TextUtils.isEmpty(logId)) {
            this.mDbAdapter.addOrUpdateUBCRecord(ubcId, fromCallEntry);
        } else {
            this.mDbAdapter.addOrUpdateRecordWithLogID(ubcId, logId);
        }
    }

    public boolean fillArrivalData(UploadData uploadData) {
        if (uploadData == null || uploadData.hasError() || !canSendArrivalData()) {
            return false;
        }
        this.mDbAdapter.clearInvalidUBCRecords();
        Map<String, UBCDateRecord> arrivalDatas = this.mDbAdapter.getRecentUBCRecords(7);
        if (arrivalDatas == null || arrivalDatas.size() == 0) {
            return false;
        }
        boolean hasData = false;
        try {
            JSONObject content = new JSONObject();
            for (String key : arrivalDatas.keySet()) {
                UBCDateRecord dateRecord = arrivalDatas.get(key);
                if (dateRecord != null) {
                    if (!TextUtils.isEmpty(key)) {
                        JSONObject dateJson = new JSONObject();
                        JSONArray countArray = new JSONArray();
                        for (JSONObject jsonObject : dateRecord.counts.values()) {
                            countArray.put(jsonObject);
                        }
                        dateJson.put("total", dateRecord.total);
                        dateJson.put("data", countArray);
                        content.put(key.replace("-", ""), dateJson);
                        hasData = true;
                    }
                }
            }
            if (hasData) {
                EventData eventData = new EventData(UBC_ARRIVAL_ID);
                eventData.setJsonContent(content);
                eventData.setTime(System.currentTimeMillis());
                eventData.setUUID(UBCUtil.getLogUUID());
                BehaviorRuleManager behaviorRule = BehaviorRuleManager.getInstance();
                if (!(behaviorRule == null || behaviorRule.checkLocalCache(UBC_ARRIVAL_ID) == 0)) {
                    YalogHelper.saveUbcToYalog(eventData);
                }
                if (behaviorRule != null) {
                    eventData.setAppVersion(behaviorRule.getCurrentAppVersion());
                    eventData.setUbcSessionId(behaviorRule.getCurrentSessionId());
                }
                uploadData.addData(eventData, eventData.getDataSize());
                uploadData.addArrivalDate(arrivalDatas.keySet());
                return true;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void fillOneRecord(Map<String, UBCDateRecord> records, String ubcDate, String ubcId, int ubcCount, int ubcCallCount, String ubcLogId) {
        UBCDateRecord dateRecord;
        if (records != null) {
            if (records.containsKey(ubcDate)) {
                dateRecord = records.get(ubcDate);
            } else {
                dateRecord = new UBCDateRecord();
                dateRecord.date = ubcDate;
                records.put(ubcDate, dateRecord);
            }
            Map counts = dateRecord.counts;
            if (counts.containsKey(ubcId) && DEBUG) {
                Log.e(TAG, "*******duplicate ubc id record: " + ubcId);
            }
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", ubcId);
                jsonObject.put("c", ubcCount);
                jsonObject.put("cc", ubcCallCount);
                if (!TextUtils.isEmpty(ubcLogId)) {
                    jsonObject.put("logid", fillUploadLogIdRecord(ubcLogId));
                }
                dateRecord.total += ubcCount;
                counts.put(ubcId, jsonObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean canSendArrivalData() {
        BehaviorRuleManager behaviorRule = BehaviorRuleManager.getInstance();
        if (behaviorRule != null && !behaviorRule.checkRecord(UBC_ARRIVAL_ID, 32)) {
            return false;
        }
        if (behaviorRule == null || !behaviorRule.checkPassiveId(UBC_ARRIVAL_ID)) {
            return true;
        }
        return false;
    }

    public boolean canRecordArrivalDataAndLogId() {
        BehaviorRuleManager behaviorRule = BehaviorRuleManager.getInstance();
        if (behaviorRule != null && !behaviorRule.checkRecord(UBC_ARRIVAL_ID, 32)) {
            return false;
        }
        if (behaviorRule == null || !behaviorRule.checkPassiveId(UBC_ARRIVAL_ID)) {
            return true;
        }
        return false;
    }

    public String updateLogIdMaxRecord(String logIdRecord, String logId) {
        long session = LogIdUtils.getInstance().getSessionOfLogId(logId);
        long index = LogIdUtils.getInstance().getIndexOfLogId(logId);
        if (session == 0 || index == 0) {
            return logIdRecord;
        }
        try {
            JSONObject record = TextUtils.isEmpty(logIdRecord) ? new JSONObject() : new JSONObject(logIdRecord);
            String sessionKey = String.valueOf(session);
            JSONObject sessionObject = record.optJSONObject(sessionKey);
            if (sessionObject == null) {
                return generateSessionRecord(record, index, session);
            }
            sessionObject.putOpt("max", Long.valueOf(index));
            record.putOpt(sessionKey, sessionObject);
            return record.toString();
        } catch (JSONException e2) {
            return logIdRecord;
        }
    }

    public String generateLogIdRecord(String logId) {
        JSONObject logIdRecord = new JSONObject();
        long session = LogIdUtils.getInstance().getSessionOfLogId(logId);
        return generateSessionRecord(logIdRecord, LogIdUtils.getInstance().getIndexOfLogId(logId), session);
    }

    private String generateSessionRecord(JSONObject logIdRecord, long index, long session) {
        if (index == 0 || session == 0) {
            return "";
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOpt("max", Long.valueOf(index));
            jsonObject.putOpt(KEY_LOGID_RECORD_MIN, Long.valueOf(index));
            logIdRecord.putOpt(String.valueOf(session), jsonObject);
            return logIdRecord.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private String fillUploadLogIdRecord(String logIdRecord) {
        try {
            JSONArray logIdArray = new JSONArray();
            JSONObject jsonObject = new JSONObject(logIdRecord);
            Iterator<String> it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next();
                JSONObject jsonValue = jsonObject.optJSONObject(key);
                if (jsonValue != null) {
                    JSONObject logIdObject = new JSONObject();
                    logIdObject.putOpt("s", key);
                    logIdObject.putOpt(KEY_LOGID_RECORD_MIN, Long.valueOf(jsonValue.optLong(KEY_LOGID_RECORD_MIN)));
                    logIdObject.putOpt("max", Long.valueOf(jsonValue.optLong("max")));
                    logIdArray.put(logIdObject);
                }
            }
            if (logIdArray.length() > 0) {
                return logIdArray.toString();
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }
}
