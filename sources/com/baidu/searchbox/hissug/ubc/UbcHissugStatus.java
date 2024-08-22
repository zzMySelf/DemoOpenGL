package com.baidu.searchbox.hissug.ubc;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.hissug.util.HisSugConstants;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UbcHissugStatus {
    public static final String ACTION_SUCC = "1";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String HIS_LOCAL = "0";
    public static final String HIS_NET = "1";
    private HissugStatus hisLocalStatus;
    private HissugStatus hisNetStatus;
    private final CopyOnWriteArrayList<HissugStatus> sugList;
    private final Object sugListLock;
    private final CopyOnWriteArrayList<UbcSugNetTime> sugTimeList;
    private final Object sugTimeLock;

    private UbcHissugStatus() {
        this.sugList = new CopyOnWriteArrayList<>();
        this.sugListLock = new Object();
        this.hisNetStatus = null;
        this.hisLocalStatus = null;
        this.sugTimeList = new CopyOnWriteArrayList<>();
        this.sugTimeLock = new Object();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final UbcHissugStatus INSTANCE = new UbcHissugStatus();

        private SingletonHolder() {
        }
    }

    public static UbcHissugStatus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public HissugStatus getNetHisStatus() {
        if (this.hisNetStatus == null) {
            HissugStatus hissugStatus = new HissugStatus();
            this.hisNetStatus = hissugStatus;
            hissugStatus.setSource("1");
        }
        return this.hisNetStatus;
    }

    public HissugStatus getLocalHisStatus() {
        if (this.hisLocalStatus == null) {
            HissugStatus hissugStatus = new HissugStatus();
            this.hisLocalStatus = hissugStatus;
            hissugStatus.setSource("0");
        }
        return this.hisLocalStatus;
    }

    public void setHisShow(boolean localData) {
        if (localData) {
            HissugStatus hissugStatus = this.hisLocalStatus;
            if (hissugStatus != null) {
                hissugStatus.setDrawView("1");
                return;
            }
            return;
        }
        HissugStatus hissugStatus2 = this.hisNetStatus;
        if (hissugStatus2 != null) {
            hissugStatus2.setDrawView("1");
        }
    }

    public JSONArray getHisLog() {
        JSONArray array = new JSONArray();
        HissugStatus hissugStatus = this.hisLocalStatus;
        if (hissugStatus != null) {
            JSONObject obj = hissugStatus.toJson(false);
            if (obj != null) {
                array.put(obj);
            }
            this.hisLocalStatus = null;
        }
        HissugStatus hissugStatus2 = this.hisNetStatus;
        if (hissugStatus2 != null) {
            JSONObject obj2 = hissugStatus2.toJson(false);
            if (obj2 != null) {
                array.put(obj2);
            }
            this.hisNetStatus = null;
        }
        if (array.length() == 0) {
            return null;
        }
        return array;
    }

    public void addSugLog(HissugStatus hissugStatus) {
        if (hissugStatus != null) {
            synchronized (this.sugListLock) {
                this.sugList.add(hissugStatus);
            }
        }
    }

    public void setViewShow(String query) {
        synchronized (this.sugListLock) {
            int i2 = this.sugList.size() - 1;
            while (true) {
                if (i2 >= 0) {
                    HissugStatus status = this.sugList.get(i2);
                    if (status != null && TextUtils.equals(query, status.query)) {
                        status.setDrawView("1");
                        break;
                    }
                    i2--;
                } else {
                    break;
                }
            }
        }
    }

    public JSONArray getSugLog() {
        synchronized (this.sugListLock) {
            CopyOnWriteArrayList<HissugStatus> list = new CopyOnWriteArrayList<>(this.sugList);
            this.sugList.clear();
            int len = list.size();
            if (len > 0) {
                JSONArray array = new JSONArray();
                for (int i2 = 0; i2 < len; i2++) {
                    HissugStatus status = list.get(i2);
                    if (status != null) {
                        JSONObject obj = status.toJson(true);
                        if (obj != null) {
                            array.put(obj);
                        }
                    }
                }
                list.clear();
                if (array.length() > 0) {
                    return array;
                }
            }
            return null;
        }
    }

    public void recordSugTimeLog(UbcSugNetTime sugTimeLog) {
        if (sugTimeLog != null) {
            synchronized (this.sugTimeLock) {
                this.sugTimeList.add(sugTimeLog);
            }
        }
    }

    public JSONArray getSugTimeLog() {
        synchronized (this.sugTimeLock) {
            CopyOnWriteArrayList<UbcSugNetTime> list = new CopyOnWriteArrayList<>(this.sugTimeList);
            this.sugTimeList.clear();
            int len = list.size();
            if (len > 0) {
                JSONArray array = new JSONArray();
                for (int i2 = 0; i2 < len; i2++) {
                    UbcSugNetTime sugTime = list.get(i2);
                    if (sugTime != null) {
                        JSONObject obj = sugTime.toJson();
                        if (obj != null) {
                            array.put(obj);
                        }
                    }
                }
                list.clear();
                if (array.length() > 0) {
                    return array;
                }
            }
            return null;
        }
    }

    public class HissugStatus {
        private int bottomDataCount = 0;
        private String dataCount = "0";
        private String drawView = "0";
        private String failMsg = "";
        /* access modifiers changed from: private */
        public String query;
        private String req = "0";
        private String reqId;
        private long reqTime = 0;
        private String rsp = "0";
        private String source = "0";
        private String sugMode = "";
        private long sugSwanHisTime = 0;

        public HissugStatus() {
        }

        public void setQuery(String query2) {
            this.query = query2;
        }

        public void setReq(String req2) {
            this.req = req2;
        }

        public void setReqId(String reqId2) {
            this.reqId = reqId2;
        }

        public void setRsp(String rsp2) {
            this.rsp = rsp2;
        }

        public void setDataCount(String count) {
            this.dataCount = count;
        }

        public void setFailMsg(String failMsg2) {
            this.failMsg = failMsg2;
        }

        public void setDrawView(String drawView2) {
            this.drawView = drawView2;
        }

        public void setSource(String source2) {
            this.source = source2;
        }

        public void setReqTime(long reqTime2) {
            this.reqTime = reqTime2;
        }

        public void setBottomDataCount(int bottomDataCount2) {
            this.bottomDataCount = bottomDataCount2;
        }

        public int getBottomDataCount() {
            return this.bottomDataCount;
        }

        public void setSugMode(String sugMode2) {
            this.sugMode = sugMode2;
        }

        public JSONObject toJson(boolean isSug) {
            try {
                JSONObject obj = new JSONObject();
                obj.put("query", this.query);
                obj.put(UploadConstant.REQ, this.req);
                obj.put("reqId", this.reqId);
                obj.put("reqTime", String.valueOf(this.reqTime));
                obj.put("rsp", this.rsp);
                obj.put("dataCount", this.dataCount);
                obj.put("failMsg", this.failMsg);
                obj.put("drawView", this.drawView);
                if (!isSug) {
                    obj.put("source", this.source);
                } else {
                    int i2 = this.bottomDataCount;
                    if (i2 > 0) {
                        obj.put("bottomDataCount", String.valueOf(i2));
                    }
                    if (!TextUtils.isEmpty(this.sugMode)) {
                        obj.put(HisSugConstants.SUG_MODE, this.sugMode);
                    }
                }
                return obj;
            } catch (JSONException e2) {
                if (!UbcHissugStatus.DEBUG) {
                    return null;
                }
                e2.printStackTrace();
                return null;
            }
        }
    }
}
