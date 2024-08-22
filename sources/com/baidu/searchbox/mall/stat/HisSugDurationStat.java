package com.baidu.searchbox.mall.stat;

import com.baidu.search.basic.statistic.SSTPST;
import com.baidu.search.duration.pyramid.ISearchDurationStat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/mall/stat/HisSugDurationStat;", "", "()V", "searchDurationStat", "Lcom/baidu/search/duration/pyramid/ISearchDurationStat;", "sstPst", "Lcom/baidu/search/basic/statistic/SSTPST;", "finish", "", "start", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HisSugDurationStat.kt */
public final class HisSugDurationStat {
    private ISearchDurationStat searchDurationStat;
    private final SSTPST sstPst = new SSTPST("2", "4", "5", "1", String.valueOf(System.currentTimeMillis()), "0", "0");

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.getSearchBoxStatInstance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        /*
            r1 = this;
            com.baidu.search.duration.pyramid.ISearchDuration$Companion r0 = com.baidu.search.duration.pyramid.ISearchDuration.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r0 = r0.getSERVICE_REFERENCE()
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.search.duration.pyramid.ISearchDuration r0 = (com.baidu.search.duration.pyramid.ISearchDuration) r0
            if (r0 == 0) goto L_0x001c
            com.baidu.search.duration.pyramid.ISearchDurationStat r0 = r0.getSearchBoxStatInstance()
            if (r0 == 0) goto L_0x001c
            com.baidu.search.duration.pyramid.ISearchDurationStat r0 = r0.startLogDuration()
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r1.searchDurationStat = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mall.stat.HisSugDurationStat.start():void");
    }

    public final void finish() {
        ISearchDurationStat iSearchDurationStat = this.searchDurationStat;
        if (iSearchDurationStat != null) {
            String str62 = this.sstPst.getStr62();
            if (str62 == null) {
                str62 = "";
            }
            ISearchDurationStat extraValue = iSearchDurationStat.setExtraValue("sst", str62);
            if (extraValue != null) {
                extraValue.endLogDuration();
            }
        }
    }
}
