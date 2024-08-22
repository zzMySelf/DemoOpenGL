package com.baidu.searchbox.feed.newsflash.statistic;

import com.baidu.searchbox.discovery.picture.abtest.LightPictureABTestManagerKt;
import com.baidu.searchbox.feed.model.FeedBackData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.newsflash.log.OnLineLogs;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/feed/newsflash/statistic/DurationUtil;", "", "()V", "durationFlow", "Lcom/baidu/ubc/Flow;", "idSuffix", "", "<set-?>", "", "isStart", "()Z", "startModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "ubcService", "Lcom/baidu/ubc/UBCManager;", "getUbcService", "()Lcom/baidu/ubc/UBCManager;", "ubcService$delegate", "Lkotlin/Lazy;", "assembleInfo", "Lorg/json/JSONObject;", "model", "assembleOption", "endDurationStatistic", "", "endSlot", "startDurationStatistic", "startSlot", "lib-feed-news-flash_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DurationUtil.kt */
public final class DurationUtil {
    private Flow durationFlow;
    private int idSuffix = -1;
    private boolean isStart;
    private FeedBaseModel startModel;
    private final Lazy ubcService$delegate = LazyKt.lazy(DurationUtil$ubcService$2.INSTANCE);

    public final boolean isStart() {
        return this.isStart;
    }

    private final UBCManager getUbcService() {
        Object value = this.ubcService$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ubcService>(...)");
        return (UBCManager) value;
    }

    public final void startDurationStatistic(FeedBaseModel model) {
        this.startModel = model;
        this.isStart = true;
        this.durationFlow = getUbcService().beginFlow("346");
        OnLineLogs.refreshLog("DurationUtil", "UBC ID:346---beginFlow");
        startSlot(model);
    }

    public final void endDurationStatistic() {
        if (this.durationFlow == null) {
            this.isStart = false;
            return;
        }
        getUbcService().flowSetValueWithDuration(this.durationFlow, assembleOption().toString());
        endSlot();
        getUbcService().flowEnd(this.durationFlow);
        this.isStart = false;
        OnLineLogs.refreshLog("DurationUtil", "UBC ID:346---flowEnd---");
    }

    private final JSONObject assembleOption() {
        JSONObject ext;
        String it;
        JSONObject option = new JSONObject();
        JSONObject slog = new JSONObject();
        slog.put("from", "feed");
        slog.put("page", LightPictureABTestManagerKt.FEED_NEWS_LANDING);
        slog.put("source", "feed");
        slog.put("type", "na");
        try {
            Result.Companion companion = Result.Companion;
            FeedBaseModel feedBaseModel = this.startModel;
            if (feedBaseModel != null) {
                FeedBackData feedBackData = feedBaseModel.feedback;
                if (!(feedBackData == null || (it = feedBackData.ext) == null)) {
                    Intrinsics.checkNotNullExpressionValue(it, "ext");
                    ext = new JSONObject(it);
                    Result.m8971constructorimpl(slog.put("ext", ext));
                    option.put("slog", slog);
                    return option;
                }
            }
            ext = null;
            Result.m8971constructorimpl(slog.put("ext", ext));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        option.put("slog", slog);
        return option;
    }

    public final void startSlot(FeedBaseModel model) {
        if (this.durationFlow != null) {
            JSONObject info = assembleInfo(model);
            endSlot();
            this.idSuffix++;
            getUbcService().flowStartSlot(this.durationFlow, "feed_news_landing_" + this.idSuffix, info);
            OnLineLogs.refreshLog("DurationUtil", "UBC ID:346---startSlot---idSuffix:" + this.idSuffix);
        }
    }

    private final JSONObject assembleInfo(FeedBaseModel model) {
        FeedItemData feedItemData;
        JSONObject info = new JSONObject();
        info.put("netType", FeedUtil.getNetType());
        String str = null;
        info.put("vid", model != null ? model.id : null);
        info.put("refreshTimestampMs", model != null ? Long.valueOf(model.parseTime) : null);
        if (!(model == null || (feedItemData = model.data) == null)) {
            str = feedItemData.resourceType;
        }
        info.put("resourceType", str);
        return info;
    }

    private final void endSlot() {
        if (this.durationFlow != null) {
            getUbcService().flowEndSlot(this.durationFlow, "feed_news_landing_" + this.idSuffix);
            OnLineLogs.refreshLog("DurationUtil", "UBC ID:346---endSlot---idSuffix:" + this.idSuffix);
        }
    }
}
