package com.baidu.searchbox.feed.widget.guide.taskslide;

import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.widget.browseonly.FeedBrowseOnlyGuideListener;
import com.baidu.searchbox.view.MiniVideoAdFormPopupView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/widget/guide/taskslide/FeedTaskSlideGuideModel;", "", "()V", "parseData", "", "obj", "Lorg/json/JSONObject;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTaskUpSlipGuideModel.kt */
public final class FeedTaskSlideGuideModel {
    public static final FeedTaskSlideGuideModel INSTANCE = new FeedTaskSlideGuideModel();

    private FeedTaskSlideGuideModel() {
    }

    public final void parseData(JSONObject obj) {
        if (obj != null) {
            try {
                Result.Companion companion = Result.Companion;
                FeedTaskSlideGuideModel feedTaskSlideGuideModel = this;
                JSONObject json = obj.optJSONObject("up_slip_guide_task");
                if (json != null) {
                    Intrinsics.checkNotNullExpressionValue(json, "obj.optJSONObject(\"up_slip_guide_task\") ?: return");
                    String version = json.optString("version");
                    if (!Intrinsics.areEqual((Object) version, (Object) FeedPreferenceUtils.getQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_VERSION, ""))) {
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_VERSION, version);
                        FeedPreferenceUtils.putQuickInt(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_DISPLAYED_TIMES, 0);
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_SWITCH, json.optString("switch"));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_ICON_URL, json.optString("icon"));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_REFRESH_TEXT, json.optString("refresh_text"));
                        FeedPreferenceUtils.putQuickInt(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_MAX_DISPLAY_TIMES, json.optInt(FeedBrowseOnlyGuideListener.KEY_MAX_DISPLAY_TIMES));
                        FeedPreferenceUtils.putQuickInt(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_MAX_DISPLAY_ALL, json.optInt("max_display_all"));
                        FeedPreferenceUtils.putQuickLong(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_DISPLAY_MS, json.optLong("display_ms"));
                        FeedPreferenceUtils.putQuickLong(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_INTERVAL_MS, json.optLong("interval_ms"));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_BG_COLOR, json.optString(MiniVideoAdFormPopupView.BG_COLOR));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_BG_NIGHT_COLOR, json.optString("bg_night_color"));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_REFRESH_TEXT_COLOR, json.optString("refresh_text_color"));
                        FeedPreferenceUtils.putQuickString(FeedTaskUpSlipGuideModelKt.TASK_SLIDE_GUIDE_REFRESH_TEXT_NIGHT_COLOR, json.optString("refresh_text_night_color"));
                    }
                    Result.m8971constructorimpl(Unit.INSTANCE);
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }
}
