package com.baidu.searchbox.feed.hot.search.processor;

import com.baidu.searchbox.card.util.CardConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/hot/search/processor/HotRefreshData;", "", "refreshCount", "", "refreshInterval", "", "(IJ)V", "getRefreshCount", "()I", "getRefreshInterval", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "lib-hotsearch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotRealtimeAutoFetchProcessor.kt */
public final class HotRefreshData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int refreshCount;
    private final long refreshInterval;

    public static /* synthetic */ HotRefreshData copy$default(HotRefreshData hotRefreshData, int i2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = hotRefreshData.refreshCount;
        }
        if ((i3 & 2) != 0) {
            j2 = hotRefreshData.refreshInterval;
        }
        return hotRefreshData.copy(i2, j2);
    }

    public final int component1() {
        return this.refreshCount;
    }

    public final long component2() {
        return this.refreshInterval;
    }

    public final HotRefreshData copy(int i2, long j2) {
        return new HotRefreshData(i2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotRefreshData)) {
            return false;
        }
        HotRefreshData hotRefreshData = (HotRefreshData) obj;
        return this.refreshCount == hotRefreshData.refreshCount && this.refreshInterval == hotRefreshData.refreshInterval;
    }

    public int hashCode() {
        return (Integer.hashCode(this.refreshCount) * 31) + Long.hashCode(this.refreshInterval);
    }

    public String toString() {
        return "HotRefreshData(refreshCount=" + this.refreshCount + ", refreshInterval=" + this.refreshInterval + ')';
    }

    public HotRefreshData(int refreshCount2, long refreshInterval2) {
        this.refreshCount = refreshCount2;
        this.refreshInterval = refreshInterval2;
    }

    public final int getRefreshCount() {
        return this.refreshCount;
    }

    public final long getRefreshInterval() {
        return this.refreshInterval;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/hot/search/processor/HotRefreshData$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/hot/search/processor/HotRefreshData;", "json", "Lorg/json/JSONObject;", "lib-hotsearch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HotRealtimeAutoFetchProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HotRefreshData fromJson(JSONObject json) {
            Object obj;
            HotRefreshData hotRefreshData = null;
            if (json == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.m8971constructorimpl(new HotRefreshData(json.optInt("refresh_count", -1), json.optLong(CardConstants.COLUMN_CARD_REFRESH_INTERVAL, -1)));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m8977isFailureimpl(obj)) {
                hotRefreshData = obj;
            }
            return hotRefreshData;
        }
    }
}
