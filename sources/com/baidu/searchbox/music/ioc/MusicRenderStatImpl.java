package com.baidu.searchbox.music.ioc;

import com.baidu.searchbox.browserenhanceengine.utils.BeeRenderMonitor;
import com.baidu.searchbox.music.runtime.IMusicRenderStat;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/music/ioc/MusicRenderStatImpl;", "Lcom/baidu/searchbox/music/runtime/IMusicRenderStat;", "()V", "changeStatus", "", "page", "", "status", "getStartTime", "", "getStatistic", "key", "getTime", "setStartTime", "time", "statInvokeStatus", "entity", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "statusCode", "", "updateStatistic", "action", "value", "uploadStatistic", "lib-music-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicRenderStatImpl.kt */
public final class MusicRenderStatImpl implements IMusicRenderStat {
    public void setStartTime(String page, long time) {
        BeeRenderMonitor.getInstance().setStartTime(page, time);
    }

    public long getTime() {
        return BeeRenderMonitor.getTime();
    }

    public long getStartTime(String page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return BeeRenderMonitor.getInstance().getStartTime(page);
    }

    public void updateStatistic(String page, String action) {
        BeeRenderMonitor.getInstance().updateStatistic(page, action);
    }

    public void updateStatistic(String page, String key, String value) {
        BeeRenderMonitor.getInstance().updateStatistic(page, key, value);
    }

    public String getStatistic(String page, String key) {
        return BeeRenderMonitor.getInstance().getStatistic(page, key);
    }

    public void changeStatus(String page, String status) {
        BeeRenderMonitor.getInstance().changeStatus(page, status);
    }

    public void uploadStatistic(String page) {
        BeeRenderMonitor.getInstance().uploadStatistic(page);
    }

    public void statInvokeStatus(String page, UnitedSchemeEntity entity, int statusCode) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(entity, "entity");
        BeeRenderMonitor.InvokeHelper.statInvokeStatus(page, entity, statusCode);
    }
}
