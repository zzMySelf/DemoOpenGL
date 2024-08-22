package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.video.feedflow.detail.shortplay.config.ShortPlayPushCard;
import com.baidu.searchbox.video.feedflow.detail.shortplay.config.ShortPlayPushCardConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"KEY_EXIT_DAY", "", "KEY_HISTORY_STORAGE_DAY", "KEY_NO_CLICK_TIME", "KEY_SHORT_PLAY_PUSH_CARD", "KEY_SHORT_PLAY_PUSH_CARD_CMD", "KEY_SHORT_PLAY_PUSH_CARD_COLL_ID", "KEY_SHORT_PLAY_PUSH_SHOW_CONFIG", "KEY_SHOW_TIMES", "KEY_STORAGE_VIDEO_NUM", "KEY_SWITCH", "PUSH_SUBSCRIBE_CLICK_CALLBACK", "PUSH_SUBSCRIBE_CLOSE_CALLBACK", "PUSH_SUBSCRIBE_DISMISS_CALLBACK", "PUSH_SUBSCRIBE_SHOW_CALLBACK", "TAG", "parseShortPlayCardConfig", "Lcom/baidu/searchbox/video/feedflow/detail/shortplay/config/ShortPlayPushCardConfig;", "updateValue", "parseShortPlayPushCard", "Lcom/baidu/searchbox/video/feedflow/detail/shortplay/config/ShortPlayPushCard;", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowPushDialogSwitcher.kt */
public final class FlowPushDialogSwitcherKt {
    private static final String KEY_EXIT_DAY = "exit_day";
    private static final String KEY_HISTORY_STORAGE_DAY = "history_storage_day";
    private static final String KEY_NO_CLICK_TIME = "no_click_time";
    private static final String KEY_SHORT_PLAY_PUSH_CARD = "shortplay_push_card";
    private static final String KEY_SHORT_PLAY_PUSH_CARD_CMD = "cmd";
    private static final String KEY_SHORT_PLAY_PUSH_CARD_COLL_ID = "collection_id";
    private static final String KEY_SHORT_PLAY_PUSH_SHOW_CONFIG = "shortplay_push_show_conf";
    private static final String KEY_SHOW_TIMES = "show_times";
    private static final String KEY_STORAGE_VIDEO_NUM = "storage_video_num";
    private static final String KEY_SWITCH = "switch";
    private static final String PUSH_SUBSCRIBE_CLICK_CALLBACK = "push_callback_value_click";
    private static final String PUSH_SUBSCRIBE_CLOSE_CALLBACK = "push_callback_value_close";
    private static final String PUSH_SUBSCRIBE_DISMISS_CALLBACK = "push_callback_value_dismiss";
    private static final String PUSH_SUBSCRIBE_SHOW_CALLBACK = "push_callback_value_show";
    private static final String TAG = "ShortPlay_FlowPushDialogSwitcher";

    /* access modifiers changed from: private */
    public static final ShortPlayPushCard parseShortPlayPushCard(String updateValue) {
        CharSequence charSequence = updateValue;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONObject config = new JSONObject(updateValue);
            String collId = config.optString("collection_id");
            String cmd = config.optString("cmd");
            Intrinsics.checkNotNullExpressionValue(cmd, "cmd");
            if (!StringsKt.isBlank(cmd)) {
                Intrinsics.checkNotNullExpressionValue(collId, "collId");
                ShortPlayPushCard shortPlayPushCard = new ShortPlayPushCard(collId, cmd);
                ShortPlayPushCard shortPlayPushCard2 = shortPlayPushCard;
                return shortPlayPushCard;
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public static final ShortPlayPushCardConfig parseShortPlayCardConfig(String updateValue) {
        CharSequence charSequence = updateValue;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            JSONObject config = new JSONObject(updateValue);
            boolean areEqual = Intrinsics.areEqual((Object) config.optString("switch"), (Object) "1");
            String storageVideoNum = config.optString(KEY_STORAGE_VIDEO_NUM);
            Intrinsics.checkNotNullExpressionValue(storageVideoNum, "config.optString(KEY_STORAGE_VIDEO_NUM)");
            String showTimes = config.optString("show_times");
            Intrinsics.checkNotNullExpressionValue(showTimes, "config.optString(KEY_SHOW_TIMES)");
            String noClickTime = config.optString(KEY_NO_CLICK_TIME);
            Intrinsics.checkNotNullExpressionValue(noClickTime, "config.optString(KEY_NO_CLICK_TIME)");
            String exitDay = config.optString(KEY_EXIT_DAY);
            Intrinsics.checkNotNullExpressionValue(exitDay, "config.optString(KEY_EXIT_DAY)");
            String historyStorageDay = config.optString(KEY_HISTORY_STORAGE_DAY);
            Intrinsics.checkNotNullExpressionValue(historyStorageDay, "config.optString(KEY_HISTORY_STORAGE_DAY)");
            ShortPlayPushCardConfig shortPlayPushCardConfig = new ShortPlayPushCardConfig(areEqual, storageVideoNum, showTimes, noClickTime, exitDay, historyStorageDay);
            ShortPlayPushCardConfig shortPlayPushCardConfig2 = shortPlayPushCardConfig;
            return shortPlayPushCardConfig;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }
}
