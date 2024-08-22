package com.baidu.searchbox.sport.ioc;

import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0017"}, d2 = {"com/baidu/searchbox/sport/ioc/ISportRenderStat$Companion$Empty$1", "Lcom/baidu/searchbox/sport/ioc/ISportRenderStat;", "changeStatus", "", "page", "", "status", "getStartTime", "", "getStatistic", "key", "getTime", "setStartTime", "time", "statInvokeStatus", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "statusCode", "", "updateStatistic", "action", "value", "uploadStatistic", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISportRenderStat.kt */
public final class ISportRenderStat$Companion$Empty$1 implements ISportRenderStat {
    ISportRenderStat$Companion$Empty$1() {
    }

    public void setStartTime(String page, long time) {
    }

    public long getStartTime(String page) {
        return -1;
    }

    public void updateStatistic(String page, String action) {
    }

    public void updateStatistic(String page, String key, String value) {
    }

    public String getStatistic(String page, String key) {
        return null;
    }

    public void changeStatus(String page, String status) {
    }

    public void uploadStatistic(String page) {
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public void statInvokeStatus(String page, UnitedSchemeEntity entity, int statusCode) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(entity, "entity");
    }
}
