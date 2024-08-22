package com.baidu.growthsystem.wealth.turningpoint.util;

import com.baidu.growthsystem.wealth.common.util.WealthVideoPreferenceUtil;
import com.baidu.growthsystem.wealth.turningpoint.model.WealthTurningPointIncentiveUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DEFAULT_VALUE_DIALOG_DISPLAY_COUNT", "", "DEFAULT_VALUE_HAS_DISPLAYED_DIALOG_TODAY", "", "DEFAULT_VALUE_LATEST_WATCH_VIDEO_TIME", "", "DEFAULT_VALUE_WATCH_VIDEO_COUNT", "SP_KEY_DIALOG_DISPLAY_COUNT", "", "SP_KEY_HAS_DISPLAYED_DIALOG_TODAY", "SP_KEY_LATEST_WATCH_VIDEO_TIME", "SP_KEY_WATCH_VIDEO_COUNT", "getSpKeyWithPrefix", "key", "readWealthTurningPointIncentiveUserModelFromSp", "Lcom/baidu/growthsystem/wealth/turningpoint/model/WealthTurningPointIncentiveUserModel;", "writeWealthTurningPointIncentiveUserModelToSp", "", "model", "wealth-task-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTurningPointIncentiveUserModelParser.kt */
public final class WealthTurningPointIncentiveUserModelParserKt {
    private static final int DEFAULT_VALUE_DIALOG_DISPLAY_COUNT = 0;
    private static final boolean DEFAULT_VALUE_HAS_DISPLAYED_DIALOG_TODAY = false;
    private static final long DEFAULT_VALUE_LATEST_WATCH_VIDEO_TIME = 0;
    private static final int DEFAULT_VALUE_WATCH_VIDEO_COUNT = 0;
    private static final String SP_KEY_DIALOG_DISPLAY_COUNT = "dialog_display_count";
    private static final String SP_KEY_HAS_DISPLAYED_DIALOG_TODAY = "has_displayed_dialog_today";
    private static final String SP_KEY_LATEST_WATCH_VIDEO_TIME = "latest_watch_video_time";
    private static final String SP_KEY_WATCH_VIDEO_COUNT = "watch_video_count";

    public static final WealthTurningPointIncentiveUserModel readWealthTurningPointIncentiveUserModelFromSp() {
        int watchVideoCount = WealthVideoPreferenceUtil.INSTANCE.getInt(getSpKeyWithPrefix(SP_KEY_WATCH_VIDEO_COUNT), 0);
        long latestWatchVideoTimeMillis = WealthVideoPreferenceUtil.INSTANCE.getLong(getSpKeyWithPrefix(SP_KEY_LATEST_WATCH_VIDEO_TIME), 0);
        boolean hasDisplayedDialogToday = WealthVideoPreferenceUtil.INSTANCE.getBoolean(getSpKeyWithPrefix(SP_KEY_HAS_DISPLAYED_DIALOG_TODAY), false);
        return new WealthTurningPointIncentiveUserModel.Builder().setWatchVideoCount(watchVideoCount).setLatestWatchVideoTimeMillis(latestWatchVideoTimeMillis).setHasDisplayedDialogToday(hasDisplayedDialogToday).setDialogDisplayCount(WealthVideoPreferenceUtil.INSTANCE.getInt(getSpKeyWithPrefix(SP_KEY_DIALOG_DISPLAY_COUNT), 0)).build();
    }

    public static final void writeWealthTurningPointIncentiveUserModelToSp(WealthTurningPointIncentiveUserModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        WealthVideoPreferenceUtil.INSTANCE.putInt(getSpKeyWithPrefix(SP_KEY_WATCH_VIDEO_COUNT), model.getWatchVideoCount());
        WealthVideoPreferenceUtil.INSTANCE.putLong(getSpKeyWithPrefix(SP_KEY_LATEST_WATCH_VIDEO_TIME), model.getLatestWatchVideoTimeMillis());
        WealthVideoPreferenceUtil.INSTANCE.putBoolean(getSpKeyWithPrefix(SP_KEY_HAS_DISPLAYED_DIALOG_TODAY), model.getHasDisplayedDialogToday());
        WealthVideoPreferenceUtil.INSTANCE.putInt(getSpKeyWithPrefix(SP_KEY_DIALOG_DISPLAY_COUNT), model.getDialogDisplayCount());
    }

    private static final String getSpKeyWithPrefix(String key) {
        return "wealth_turning_point_incentive_" + key;
    }
}
