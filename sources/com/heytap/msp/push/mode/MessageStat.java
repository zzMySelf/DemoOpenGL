package com.heytap.msp.push.mode;

import android.text.TextUtils;
import com.heytap.mcssdk.utils.LogUtil;
import org.json.JSONObject;

public class MessageStat {
    private static final String APP_PACKAGE = "appPackage";
    private static final String DATA_EXTRA = "data_extra";
    private static final String EVENT_ID = "eventID";
    private static final String EVENT_TIME = "eventTime";
    private static final String GLOBAL_ID = "globalID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String PROPERTY = "property";
    private static final String STATISTICS_EXTRA = "statistics_extra";
    private static final String TASK_ID = "taskID";
    private String mAppPackage;
    private String mDataExtra;
    private String mEventId;
    private long mEventTime;
    private String mGlobalId;
    private String mProperty;
    private String mStatisticsExtra;
    private String mTaskID;
    private int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    public MessageStat(String pkg, String eventId) {
        this(4096, pkg, (String) null, (String) null, eventId, "");
    }

    public MessageStat(String pkg, String eventId, String property) {
        this(4096, pkg, (String) null, (String) null, eventId, property);
    }

    public MessageStat(int type, String pkg, String eventId, String property) {
        this(type, pkg, (String) null, (String) null, eventId, property);
    }

    public MessageStat(int type, String pkg, String globalId, String taskId, String eventId, String property) {
        this(type, pkg, globalId, taskId, eventId, property, "", "");
    }

    public MessageStat(int type, String pkg, String globalId, String taskId, String eventId, String property, String statisticsExtra, String dataExtra) {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(type);
        setAppPackage(pkg);
        setGlobalId(globalId);
        setTaskID(taskId);
        setEventId(eventId);
        setProperty(property);
        setStatisticsExtra(statisticsExtra);
        setDataExtra(dataExtra);
    }

    public String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public void setStatisticsExtra(String mStatisticsExtra2) {
        this.mStatisticsExtra = mStatisticsExtra2;
    }

    public String getDataExtra() {
        return this.mDataExtra;
    }

    public void setDataExtra(String mDataExtra2) {
        this.mDataExtra = mDataExtra2;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public void setTaskID(String taskID) {
        this.mTaskID = taskID;
    }

    public void setTaskID(int taskID) {
        this.mTaskID = taskID + "";
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public void setAppPackage(String appPackage) {
        this.mAppPackage = appPackage;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public void setGlobalId(String globalId) {
        this.mGlobalId = globalId;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public void setEventId(String eventId) {
        this.mEventId = eventId;
    }

    public String getProperty() {
        return this.mProperty;
    }

    public void setProperty(String property) {
        this.mProperty = property;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public void setEventTime(long eventTime) {
        this.mEventTime = eventTime;
    }

    public String toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.putOpt(MESSAGE_TYPE, Integer.valueOf(this.mType));
            json.putOpt(EVENT_ID, this.mEventId);
            json.putOpt("appPackage", this.mAppPackage);
            json.putOpt(EVENT_TIME, Long.valueOf(this.mEventTime));
            if (!TextUtils.isEmpty(this.mGlobalId)) {
                json.putOpt("globalID", this.mGlobalId);
            }
            if (!TextUtils.isEmpty(this.mTaskID)) {
                json.putOpt("taskID", this.mTaskID);
            }
            if (!TextUtils.isEmpty(this.mProperty)) {
                json.putOpt("property", this.mProperty);
            }
            if (!TextUtils.isEmpty(this.mStatisticsExtra)) {
                json.putOpt("statistics_extra", this.mStatisticsExtra);
            }
            if (!TextUtils.isEmpty(this.mDataExtra)) {
                json.putOpt("data_extra", this.mDataExtra);
            }
        } catch (Exception e2) {
            LogUtil.e(e2.getLocalizedMessage());
        }
        return json.toString();
    }

    public static MessageStat parse(String content) {
        MessageStat stat = new MessageStat();
        try {
            JSONObject json = new JSONObject(content);
            stat.setType(json.optInt(MESSAGE_TYPE, 0));
            stat.setAppPackage(json.optString("appPackage"));
            stat.setEventId(json.optString(EVENT_ID));
            stat.setGlobalId(json.optString("globalID", ""));
            stat.setTaskID(json.optString("taskID", ""));
            stat.setProperty(json.optString("property", ""));
            stat.setEventTime(json.optLong(EVENT_TIME, System.currentTimeMillis()));
            stat.setStatisticsExtra(json.optString("statistics_extra"));
            stat.setDataExtra(json.optString("data_extra"));
            return stat;
        } catch (Exception e2) {
            LogUtil.e(e2.getLocalizedMessage());
            return null;
        }
    }
}
