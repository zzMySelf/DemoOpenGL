package com.baidu.userduration;

import android.text.TextUtils;
import com.baidu.userduration.interfaces.Constant;
import com.baidu.userduration.interfaces.ExtInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class UserDurationItem {
    public static final int STATUS_ENDED = 2;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_STARTED = 1;
    public static final int TYPE_BUSINESS = 0;
    public static final int TYPE_NO_BUSINESS = 1;
    long endtime;
    List<ExtInfo> exts;
    String ifrom;
    String page;
    String pageClass;
    long starttime;
    private int status = 0;
    String topic;
    int type;

    private UserDurationItem() {
    }

    public void updataStatus(int status2) {
        this.status = status2;
    }

    public int getStatus() {
        return this.status;
    }

    public void addExt(String extType, JSONObject info) {
        if (this.exts == null) {
            this.exts = new ArrayList();
        }
        this.exts.add(new ExtInfo(extType, info));
    }

    public void addExts(List<ExtInfo> infos) {
        if (infos != null && infos.size() > 0) {
            if (this.exts == null) {
                this.exts = new ArrayList();
            }
            this.exts.addAll(infos);
        }
    }

    public static UserDurationItem createNoBusinessItem(long starttime2, String pageClass2) {
        UserDurationItem item = new UserDurationItem();
        item.starttime = starttime2;
        item.pageClass = pageClass2;
        item.type = 1;
        return item;
    }

    public static UserDurationItem createBusinessItem(long starttime2, String topic2, String page2) {
        UserDurationItem item = new UserDurationItem();
        item.starttime = starttime2;
        item.topic = topic2;
        item.page = page2;
        item.type = 0;
        return item;
    }

    public static UserDurationItem createCustomBusinessItem(long starttime2, long endtime2, String topic2, String page2, String pageClass2, List<ExtInfo> exts2) {
        UserDurationItem item = new UserDurationItem();
        item.starttime = starttime2;
        item.endtime = endtime2;
        item.topic = topic2;
        item.page = page2;
        item.type = 0;
        item.pageClass = pageClass2;
        if (exts2 != null && exts2.size() > 0) {
            ArrayList arrayList = new ArrayList();
            item.exts = arrayList;
            arrayList.addAll(exts2);
        }
        return item;
    }

    public String toString() {
        return "UserDurationItem{starttime=" + this.starttime + ", endtime=" + this.endtime + ", pageClass='" + this.pageClass + '\'' + ", topic='" + this.topic + '\'' + ", page='" + this.page + '\'' + ", exts=" + this.exts + ", type=" + this.type + ", status=" + this.status + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJsonObject(int num) {
        JSONObject json = new JSONObject();
        try {
            json.put(Constant.ITEM_NO, num);
            json.put(Constant.ITEM_FROM, this.ifrom);
            float duration = ((float) (this.endtime - this.starttime)) / 1000.0f;
            if (duration < 0.0f) {
                duration = 0.0f;
            }
            json.put(Constant.ITEM_DURATION, String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(duration)}));
            json.put(Constant.ITEM_START_TIME, Long.toString(this.starttime));
            json.put(Constant.ITEM_END_TIME, Long.toString(this.endtime));
            json.put(Constant.ITEM_PAGE_CLASS, this.pageClass);
            if (TextUtils.isEmpty(this.page)) {
                json.put(Constant.ITEM_PAGE, this.pageClass);
            } else {
                json.put(Constant.ITEM_PAGE, this.page);
            }
            json.put("topic", this.topic);
            List<ExtInfo> list = this.exts;
            if (list != null && list.size() > 0) {
                JSONArray extsJson = new JSONArray();
                for (ExtInfo ext : this.exts) {
                    if (ext != null) {
                        JSONObject extJson = new JSONObject();
                        extJson.put(Constant.ITEM_EXT_TYPE, ext.getExtType());
                        extJson.put("info", ext.getExtInfo());
                        extsJson.put(extJson);
                    }
                }
                json.put("ext", extsJson);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }

    public String getPage() {
        if (TextUtils.isEmpty(this.page)) {
            return this.pageClass;
        }
        return this.page;
    }

    public boolean sameBusinessItem(String topic2, String page2) {
        return this.type == 0 && TextUtils.equals(topic2, this.topic) && TextUtils.equals(page2, this.page);
    }
}
