package com.baidu.searchbox.feed.list.controller.duplicate;

import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedSimpleKVFilePersister;
import com.baidu.searchbox.feed.list.cache.StrategyDataManager;
import com.baidu.searchbox.feed.list.controller.ListControllerFactory;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import com.baidu.searchbox.feed.model.ReportInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DupDataMemCache {
    private static final String DUP_FILE = "_list_dup_data.json";
    private static final String TAG = "DupDataMemCache";
    private ConcurrentHashMap<String, DupDataInfo> mDupDatas;
    private boolean mNeedSave;
    private final String mTabId;

    DupDataMemCache(String tabId) {
        if (TextUtils.isEmpty(tabId)) {
            this.mTabId = "1";
        } else {
            this.mTabId = tabId;
        }
    }

    private void initDataIfNeed() {
        if (this.mDupDatas == null) {
            initData();
        }
    }

    private void initData() {
        this.mDupDatas = new ConcurrentHashMap<>();
        recovery();
        if (!hasData()) {
            for (FeedBaseModel model : ListControllerFactory.getController(this.mTabId, (StrategyDataManager) null).obtainDataManager().getDisplayCacheList()) {
                DupDataInfo info = new DupDataInfo();
                FeedRuntimeStatus runtimeStatus = model.runtimeStatus;
                ReportInfo reportInfo = runtimeStatus.reportInfo;
                info.nid = model.id;
                info.isDisplay = runtimeStatus.hasDisplayed;
                info.isRead = runtimeStatus.isRead;
                info.displayTime = reportInfo.displayTime;
                info.readTime = runtimeStatus.reportInfo.clickTime;
                long j2 = 0;
                if (reportInfo.showDur > 0) {
                    j2 = reportInfo.showDur;
                }
                info.showDur = j2;
                info.showHt = reportInfo.showHt;
                info.attachTime = reportInfo.attachTime;
                info.viewHeight = reportInfo.viewHeight;
                if (TextUtils.equals(runtimeStatus.dataFrom, FeedRuntimeStatus.DATA_FROM_READ_INSERT)) {
                    info.isAfterInsert = "0";
                }
                if (!TextUtils.isEmpty(info.nid)) {
                    this.mDupDatas.put(info.nid, info);
                }
            }
            this.mNeedSave = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void put(FeedBaseModel model) {
        if (model != null && model.id != null) {
            initDataIfNeed();
            this.mNeedSave = true;
            DupDataInfo info = this.mDupDatas.get(model.id);
            FeedRuntimeStatus runtimeStatus = model.runtimeStatus;
            ReportInfo reportInfo = runtimeStatus.reportInfo;
            long j2 = 0;
            if (info != null) {
                info.isDisplay = runtimeStatus.hasDisplayed;
                info.isRead = runtimeStatus.isRead;
                info.displayTime = reportInfo.displayTime;
                info.readTime = reportInfo.clickTime;
                if (info.isDisplay && info.displayTime <= 0) {
                    info.displayTime = System.currentTimeMillis();
                }
                if (info.isRead && info.readTime <= 0) {
                    info.readTime = System.currentTimeMillis();
                }
                if (reportInfo.showDur > 0) {
                    j2 = reportInfo.showDur;
                }
                info.showDur = j2;
                info.showHt = reportInfo.showHt;
                info.attachTime = reportInfo.attachTime;
                info.viewHeight = reportInfo.viewHeight;
                return;
            }
            DupDataInfo newInfo = new DupDataInfo();
            newInfo.nid = model.id;
            newInfo.isDisplay = runtimeStatus.hasDisplayed;
            newInfo.isRead = runtimeStatus.isRead;
            newInfo.displayTime = reportInfo.displayTime;
            newInfo.readTime = reportInfo.clickTime;
            if (newInfo.isDisplay && newInfo.displayTime <= 0) {
                newInfo.displayTime = System.currentTimeMillis();
            }
            if (newInfo.isRead && newInfo.readTime <= 0) {
                newInfo.readTime = System.currentTimeMillis();
            }
            if (reportInfo.showDur > 0) {
                j2 = reportInfo.showDur;
            }
            newInfo.showDur = j2;
            newInfo.showHt = reportInfo.showHt;
            newInfo.attachTime = reportInfo.attachTime;
            newInfo.viewHeight = reportInfo.viewHeight;
            if (TextUtils.equals(runtimeStatus.dataFrom, FeedRuntimeStatus.DATA_FROM_READ_INSERT)) {
                newInfo.isAfterInsert = "0";
            }
            this.mDupDatas.put(newInfo.nid, newInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void putAll(List<FeedBaseModel> models) {
        for (FeedBaseModel model : models) {
            put(model);
        }
    }

    public void updateInsertFeedList(List<FeedBaseModel> list) {
        if (list != null && this.mDupDatas != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DupDataInfo info = this.mDupDatas.get(list.get(i2).id);
                if (info != null) {
                    info.isAfterInsert = "1";
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Collection<DupDataInfo> getDupDatas() {
        initDataIfNeed();
        return this.mDupDatas.values();
    }

    public void clear(long lastRefreshTime) {
        initDataIfNeed();
        this.mNeedSave = true;
        Iterator<Map.Entry<String, DupDataInfo>> it = this.mDupDatas.entrySet().iterator();
        while (it.hasNext()) {
            DupDataInfo cache = it.next().getValue();
            if (cache.displayTime < lastRefreshTime && cache.readTime < lastRefreshTime) {
                it.remove();
            }
        }
    }

    public void storage() {
        if (this.mNeedSave) {
            initDataIfNeed();
            JSONArray jsonArray = new JSONArray();
            for (String id : this.mDupDatas.keySet()) {
                DupDataInfo info = this.mDupDatas.get(id);
                if (info != null) {
                    jsonArray.put(info.toJson());
                }
            }
            this.mNeedSave = false;
            FeedSimpleKVFilePersister.getPersister().putStringToFileAsyncMayDelay(this.mTabId + DUP_FILE, jsonArray.toString());
        }
    }

    private void recovery() {
        String data = FeedSimpleKVFilePersister.getPersister().getStringFromFileSync(this.mTabId + DUP_FILE);
        if (!TextUtils.isEmpty(data)) {
            try {
                JSONArray jsonArray = new JSONArray(data);
                int size = jsonArray.length();
                for (int i2 = 0; i2 < size; i2++) {
                    DupDataInfo info = DupDataInfo.fromJson(jsonArray.getJSONObject(i2));
                    if (info != null && info.isValidate()) {
                        info.attachTime = 0;
                        this.mDupDatas.put(info.nid, info);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean hasData() {
        return this.mDupDatas.size() > 0;
    }

    public static final class DupDataInfo {
        private static final String ATTACH_TIME = "attachTime";
        private static final String DISPLAY_TIME = "displayTime";
        private static final String IS_AFTER_INSERT = "isAfterInsert";
        private static final String IS_AUTO_PLAY = "isAutoPlay";
        private static final String IS_DISPLAY = "isDisplay";
        private static final String IS_READ = "isRead";
        private static final String KEY_NID = "nid";
        private static final String READ_TIME = "readTime";
        private static final String SHOW_DUR = "showDur";
        private static final String SHOW_HT = "showHt";
        private static final String VIEW_HEIGHT = "viewHeight";
        public long attachTime;
        public long displayTime;
        public String isAfterInsert;
        public boolean isAutoPlay;
        public boolean isDisplay;
        public boolean isRead;
        public String nid;
        public long readTime;
        public String refreshCount;
        public long showDur;
        public int showHt;
        public int viewHeight;

        public JSONObject toJson() {
            JSONObject json = new JSONObject();
            try {
                json.put("nid", this.nid);
                json.put(IS_DISPLAY, this.isDisplay);
                json.put(IS_READ, this.isRead);
                json.put(DISPLAY_TIME, this.displayTime);
                json.put(READ_TIME, this.readTime);
                json.put(SHOW_DUR, this.showDur);
                json.put(SHOW_HT, this.showHt);
                json.put(ATTACH_TIME, this.attachTime);
                json.put(VIEW_HEIGHT, this.viewHeight);
                json.put(IS_AUTO_PLAY, this.isAutoPlay);
                json.put(IS_AFTER_INSERT, this.isAfterInsert);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json;
        }

        public static DupDataInfo fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            DupDataInfo info = new DupDataInfo();
            info.nid = json.optString("nid");
            info.isDisplay = json.optBoolean(IS_DISPLAY);
            info.isRead = json.optBoolean(IS_READ);
            info.displayTime = json.optLong(DISPLAY_TIME);
            info.readTime = json.optLong(READ_TIME);
            info.showDur = json.optLong(SHOW_DUR);
            info.showHt = json.optInt(SHOW_HT);
            info.attachTime = json.optLong(ATTACH_TIME);
            info.viewHeight = json.optInt(VIEW_HEIGHT);
            info.isAutoPlay = json.optBoolean(IS_AUTO_PLAY);
            info.isAfterInsert = json.optString(IS_AFTER_INSERT);
            return info;
        }

        public boolean isValidate() {
            return !TextUtils.isEmpty(this.nid);
        }
    }
}
