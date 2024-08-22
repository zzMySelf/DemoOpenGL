package com.baidu.searchbox.search.webvideo.utils;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.tab.utils.SearchVideoPreferenceUtils;
import com.baidu.searchbox.search.webvideo.model.SnifferPanelShieldConfig;
import com.baidu.searchbox.search.webvideo.model.SnifferPanelShieldLocalRecord;
import com.google.gson.Gson;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0003J\b\u0010\u0010\u001a\u00020\u0006H\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/utils/SnifferPanelShieldManager;", "", "()V", "configData", "Lcom/baidu/searchbox/search/webvideo/model/SnifferPanelShieldConfig;", "localRecord", "Lcom/baidu/searchbox/search/webvideo/model/SnifferPanelShieldLocalRecord;", "canAutoShow", "", "day2Millis", "", "days", "", "getInterval", "time", "initConfigData", "initLocalRecord", "onConsume", "", "onPanelAutoShow", "saveLocalData", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferPanelShieldManager.kt */
public final class SnifferPanelShieldManager {
    public static final SnifferPanelShieldManager INSTANCE;
    private static final SnifferPanelShieldConfig configData;
    private static final SnifferPanelShieldLocalRecord localRecord;

    private SnifferPanelShieldManager() {
    }

    static {
        SnifferPanelShieldManager snifferPanelShieldManager = new SnifferPanelShieldManager();
        INSTANCE = snifferPanelShieldManager;
        SnifferPanelShieldConfig initConfigData = snifferPanelShieldManager.initConfigData();
        configData = initConfigData;
        localRecord = snifferPanelShieldManager.initLocalRecord();
        if (AppConfig.isDebug()) {
            Log.d("SnifferPanelSh", "当前配置：" + initConfigData);
        }
    }

    private final SnifferPanelShieldConfig initConfigData() {
        String configDataStr = SearchVideoPreferenceUtils.Companion.getInstance().getString(SnifferPanelShieldManagerKt.KEY_SP_SHIELD_CONFIG, "");
        CharSequence charSequence = configDataStr;
        if (charSequence == null || charSequence.length() == 0) {
            return new SnifferPanelShieldConfig(0, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
        }
        try {
            Object fromJson = new Gson().fromJson(configDataStr, SnifferPanelShieldConfig.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n            Gson().fro…ig::class.java)\n        }");
            return (SnifferPanelShieldConfig) fromJson;
        } catch (Exception e2) {
            return new SnifferPanelShieldConfig(0, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
        }
    }

    private final SnifferPanelShieldLocalRecord initLocalRecord() {
        String localRecordStr = SearchVideoPreferenceUtils.Companion.getInstance().getString(SnifferPanelShieldManagerKt.KEY_SP_SHIELD_LOCAL_DATA, "");
        CharSequence charSequence = localRecordStr;
        if (charSequence == null || charSequence.length() == 0) {
            return new SnifferPanelShieldLocalRecord(0, 0, false, (Queue) null, 15, (DefaultConstructorMarker) null);
        }
        try {
            Object fromJson = new Gson().fromJson(localRecordStr, SnifferPanelShieldLocalRecord.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n            Gson().fro…rd::class.java)\n        }");
            return (SnifferPanelShieldLocalRecord) fromJson;
        } catch (Exception e2) {
            return new SnifferPanelShieldLocalRecord(0, 0, false, (Queue) null, 15, (DefaultConstructorMarker) null);
        }
    }

    public final void onPanelAutoShow() {
        SnifferPanelShieldLocalRecord snifferPanelShieldLocalRecord = localRecord;
        snifferPanelShieldLocalRecord.setContinuousDisplayTimes(snifferPanelShieldLocalRecord.getContinuousDisplayTimes() + 1);
        if (snifferPanelShieldLocalRecord.getContinuousDisplayTimes() >= configData.getContinuousIgnoreShieldThreshold()) {
            snifferPanelShieldLocalRecord.setLatestDisplayTime(System.currentTimeMillis());
        }
        saveLocalData();
    }

    public final boolean canAutoShow() {
        SnifferPanelShieldLocalRecord snifferPanelShieldLocalRecord = localRecord;
        int size = snifferPanelShieldLocalRecord.getLatestSeveralConsumeTime().size();
        SnifferPanelShieldConfig snifferPanelShieldConfig = configData;
        if (size >= snifferPanelShieldConfig.getExemptConsumeTimesRequire()) {
            Long peek = snifferPanelShieldLocalRecord.getLatestSeveralConsumeTime().peek();
            if (getInterval(peek != null ? peek.longValue() : 0) < day2Millis(snifferPanelShieldConfig.getExemptPeriodRequire())) {
                if (AppConfig.isDebug()) {
                    Log.d("SnifferPanelSh", "canAutoShow:豁免");
                }
                return true;
            }
        }
        if (snifferPanelShieldLocalRecord.getContinuousDisplayTimes() < snifferPanelShieldConfig.getContinuousIgnoreShieldThreshold()) {
            if (AppConfig.isDebug()) {
                Log.d("SnifferPanelSh", "canAutoShow:true");
            }
            return true;
        } else if (!snifferPanelShieldLocalRecord.getHadResumedBefore() && getInterval(snifferPanelShieldLocalRecord.getLatestDisplayTime()) > day2Millis(snifferPanelShieldConfig.getResumeDisplayShieldInterval())) {
            snifferPanelShieldLocalRecord.setHadResumedBefore(true);
            if (AppConfig.isDebug()) {
                Log.d("SnifferPanelSh", "canAutoShow: 第一次复活 " + snifferPanelShieldLocalRecord);
            }
            return true;
        } else if (snifferPanelShieldLocalRecord.getHadResumedBefore() && getInterval(snifferPanelShieldLocalRecord.getLatestDisplayTime()) > day2Millis(snifferPanelShieldConfig.getResumeDisplayShieldIntervalNext())) {
            if (AppConfig.isDebug()) {
                Log.d("SnifferPanelSh", "canAutoShow: 第二次及之后复活 " + snifferPanelShieldLocalRecord);
            }
            return true;
        } else if (!AppConfig.isDebug()) {
            return false;
        } else {
            Log.d("SnifferPanelSh", "canAutoShow: 连续展示次数 >= 阈值， 屏蔽  " + snifferPanelShieldLocalRecord);
            return false;
        }
    }

    private final void saveLocalData() {
        SearchVideoPreferenceUtils instance = SearchVideoPreferenceUtils.Companion.getInstance();
        Gson gson = new Gson();
        SnifferPanelShieldLocalRecord snifferPanelShieldLocalRecord = localRecord;
        instance.putString(SnifferPanelShieldManagerKt.KEY_SP_SHIELD_LOCAL_DATA, gson.toJson((Object) snifferPanelShieldLocalRecord));
        if (AppConfig.isDebug()) {
            Log.d("SnifferPanelSh", snifferPanelShieldLocalRecord.toString());
        }
    }

    public final void onConsume() {
        SnifferPanelShieldLocalRecord snifferPanelShieldLocalRecord = localRecord;
        snifferPanelShieldLocalRecord.setContinuousDisplayTimes(0);
        snifferPanelShieldLocalRecord.setHadResumedBefore(false);
        snifferPanelShieldLocalRecord.getLatestSeveralConsumeTime().offer(Long.valueOf(System.currentTimeMillis()));
        while (true) {
            SnifferPanelShieldLocalRecord snifferPanelShieldLocalRecord2 = localRecord;
            if (snifferPanelShieldLocalRecord2.getLatestSeveralConsumeTime().size() <= configData.getExemptConsumeTimesRequire() || !(!snifferPanelShieldLocalRecord2.getLatestSeveralConsumeTime().isEmpty())) {
                saveLocalData();
            } else {
                snifferPanelShieldLocalRecord2.getLatestSeveralConsumeTime().poll();
            }
        }
        saveLocalData();
        if (AppConfig.isDebug()) {
            Log.d("SnifferPanelSh", "用户消费（点击、滑动等）,记录清0");
        }
    }

    private final long day2Millis(int days) {
        return ((long) days) * 86400000;
    }

    private final long getInterval(long time) {
        return System.currentTimeMillis() - time;
    }
}
