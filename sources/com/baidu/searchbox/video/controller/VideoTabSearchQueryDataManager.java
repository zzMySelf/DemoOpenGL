package com.baidu.searchbox.video.controller;

import android.text.TextUtils;
import com.baidu.searchbox.video.detail.utils.VideoSharedPrefsUtils;
import com.baidu.searchbox.video.model.VideoTabSearchQuery4Hint;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u001b\u001a\u00020\u0004H\u0007J\u001a\u0010\u001c\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0007J\n\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010$\u001a\u00020\u0004H\u0007J\u001c\u0010%\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010'\u001a\u00020\u0007H\u0007J\b\u0010(\u001a\u00020)H\u0007J\u0012\u0010*\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010,\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001c\u0010.\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010/\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u0007H\u0007J\u0012\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00105\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u000107H\u0007J\u0012\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010:\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010=H\u0007J\u0012\u0010>\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010?\u001a\u00020\u001f2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/video/controller/VideoTabSearchQueryDataManager;", "", "()V", "ATN", "", "BOX", "BOX_CANNOT_SHOW", "", "BOX_CAN_SHOW", "BOX_IS_SHOW", "DATA", "DEFAULT_VERSION", "PD", "SA", "TN", "UPDATE_INTERVAL", "VIDEO_TAB_QUERY", "VIDEO_TAB_QUERY_VERSION", "mDefaultUpdateInterval", "mLocalDefaultBox", "getMLocalDefaultBox", "()Ljava/lang/String;", "mLocalDefaultBox$delegate", "Lkotlin/Lazy;", "convertKey", "key", "getATn", "getDefaultBox", "getInt", "defaultValue", "getPd", "", "getQueryListData", "", "Lcom/baidu/searchbox/video/model/VideoTabSearchQuery4Hint;", "getSa", "getSearchQueryVersion", "getString", "getTn", "getUpdateInterval", "isBoxShowing", "", "optInt", "optString", "putInt", "value", "putString", "setATn", "atn", "setBoxStatus", "boxIsShow", "setPd", "pd", "setQueryListData", "queryJsonList", "Lorg/json/JSONArray;", "setSa", "sa", "setSearchQueryData", "version", "data", "Lorg/json/JSONObject;", "setSearchQueryVersion", "setTn", "tn", "setUpdateInterval", "updateInterval", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabSearchQueryDataManager.kt */
public final class VideoTabSearchQueryDataManager {
    private static final String ATN = "atn";
    private static final String BOX = "box";
    private static final int BOX_CANNOT_SHOW = 0;
    private static final int BOX_CAN_SHOW = 1;
    private static final String BOX_IS_SHOW = "box_is_show";
    private static final String DATA = "data";
    private static final String DEFAULT_VERSION = "0";
    public static final VideoTabSearchQueryDataManager INSTANCE = new VideoTabSearchQueryDataManager();
    private static final String PD = "pd";
    private static final String SA = "sa";
    private static final String TN = "tn";
    private static final String UPDATE_INTERVAL = "update_interval";
    private static final String VIDEO_TAB_QUERY = "videotab_query";
    private static final String VIDEO_TAB_QUERY_VERSION = "version";
    private static final int mDefaultUpdateInterval = 60;
    private static final Lazy mLocalDefaultBox$delegate = LazyKt.lazy(VideoTabSearchQueryDataManager$mLocalDefaultBox$2.INSTANCE);

    private VideoTabSearchQueryDataManager() {
    }

    private final String getMLocalDefaultBox() {
        return (String) mLocalDefaultBox$delegate.getValue();
    }

    @JvmStatic
    public static final void setSearchQueryData(String version, JSONObject data) {
        if (!TextUtils.isEmpty(version) && data != null) {
            setSearchQueryVersion(version);
            setUpdateInterval(data.optInt(UPDATE_INTERVAL));
            setBoxStatus(data.optInt(BOX_IS_SHOW));
            JSONObject boxObj = data.optJSONObject("box");
            if (boxObj != null) {
                setPd(boxObj.optString("pd"));
                setSa(boxObj.optString("sa"));
                setTn(boxObj.optString("tn"));
                setATn(boxObj.optString("atn"));
                setQueryListData(boxObj.optJSONArray("data"));
            }
        }
    }

    @JvmStatic
    public static final String getDefaultBox() {
        return INSTANCE.getMLocalDefaultBox();
    }

    @JvmStatic
    public static final void setSearchQueryVersion(String version) {
        String v = version;
        if (TextUtils.isEmpty(version)) {
            v = "0";
        }
        INSTANCE.putString("version", v);
    }

    @JvmStatic
    public static final String getSearchQueryVersion() {
        return INSTANCE.getString("version", "0");
    }

    @JvmStatic
    public static final void setUpdateInterval(int updateInterval) {
        INSTANCE.putInt(UPDATE_INTERVAL, updateInterval);
    }

    @JvmStatic
    public static final int getUpdateInterval() {
        return INSTANCE.getInt(UPDATE_INTERVAL, mDefaultUpdateInterval);
    }

    @JvmStatic
    public static final void setBoxStatus(int boxIsShow) {
        INSTANCE.putInt(BOX_IS_SHOW, boxIsShow);
    }

    @JvmStatic
    public static final boolean isBoxShowing() {
        return INSTANCE.getInt(BOX_IS_SHOW, 0) == 1;
    }

    @JvmStatic
    public static final void setPd(String pd) {
        INSTANCE.putString("pd", pd);
    }

    @JvmStatic
    public static final void getPd() {
        INSTANCE.optString("pd");
    }

    @JvmStatic
    public static final void setSa(String sa) {
        INSTANCE.putString("sa", sa);
    }

    @JvmStatic
    public static final String getSa() {
        return INSTANCE.optString("sa");
    }

    @JvmStatic
    public static final void setTn(String tn) {
        INSTANCE.putString("tn", tn);
    }

    @JvmStatic
    public static final String getTn() {
        return INSTANCE.optString("tn");
    }

    @JvmStatic
    public static final void setATn(String atn) {
        INSTANCE.putString("atn", atn);
    }

    @JvmStatic
    public static final String getATn() {
        return INSTANCE.optString("atn");
    }

    @JvmStatic
    public static final void setQueryListData(JSONArray queryJsonList) {
        if (queryJsonList != null) {
            INSTANCE.putString("data", queryJsonList.toString());
        }
    }

    @JvmStatic
    public static final List<VideoTabSearchQuery4Hint> getQueryListData() {
        String dataArray = INSTANCE.optString("data");
        if (dataArray == null) {
            return null;
        }
        return VideoTabSearchQuery4Hint.Companion.parse2ModelList(dataArray);
    }

    private final void putInt(String key, int value) {
        String realKey = convertKey(key);
        if (realKey != null) {
            VideoSharedPrefsUtils.putInt(realKey, value);
        }
    }

    private final int optInt(String key) {
        return getInt(key, 0);
    }

    private final int getInt(String key, int defaultValue) {
        String realKey = convertKey(key);
        if (realKey == null) {
            return defaultValue;
        }
        return VideoSharedPrefsUtils.getInt(realKey, defaultValue);
    }

    private final void putString(String key, String value) {
        String realValue = value == null ? "" : value;
        String realKey = convertKey(key);
        if (realKey != null) {
            VideoSharedPrefsUtils.putString(realKey, realValue);
        }
    }

    private final String optString(String key) {
        return getString(key, "");
    }

    private final String getString(String key, String defaultValue) {
        String realDefaultValue = defaultValue == null ? "" : defaultValue;
        String realKey = convertKey(key);
        if (realKey == null) {
            return realDefaultValue;
        }
        String string = VideoSharedPrefsUtils.getString(realKey, realDefaultValue);
        Intrinsics.checkNotNullExpressionValue(string, "getString(realKey, realDefaultValue)");
        return string;
    }

    private final String convertKey(String key) {
        if (!TextUtils.isEmpty(key)) {
            return "videotab_query_" + key;
        }
        String str = null;
        return null;
    }
}
