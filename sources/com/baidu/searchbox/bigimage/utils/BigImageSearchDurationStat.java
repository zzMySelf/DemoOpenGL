package com.baidu.searchbox.bigimage.utils;

import com.baidu.search.basic.utils.SearchUtils;
import com.baidu.search.duration.pyramid.ISearchDurationStat;
import com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JT\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011J8\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011J\u0006\u0010\u0012\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/bigimage/utils/BigImageSearchDurationStat;", "", "source", "", "(Ljava/lang/String;)V", "searchDurationStat", "Lcom/baidu/search/duration/pyramid/ISearchDurationStat;", "onStatEnd", "", "extraMap", "", "detailfr", "extraParams", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams;", "refer", "pageDuration", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onStatStart", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageSearchDurationStat.kt */
public final class BigImageSearchDurationStat {
    private ISearchDurationStat searchDurationStat;
    private final String source;

    public BigImageSearchDurationStat(String source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.getSearchNoH5StatInstance(r2.source);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onStatStart() {
        /*
            r2 = this;
            com.baidu.search.duration.pyramid.ISearchDuration$Companion r0 = com.baidu.search.duration.pyramid.ISearchDuration.Companion
            com.baidu.pyramid.runtime.service.ServiceReference r0 = r0.getSERVICE_REFERENCE()
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.search.duration.pyramid.ISearchDuration r0 = (com.baidu.search.duration.pyramid.ISearchDuration) r0
            if (r0 == 0) goto L_0x001e
            java.lang.String r1 = r2.source
            com.baidu.search.duration.pyramid.ISearchDurationStat r0 = r0.getSearchNoH5StatInstance(r1)
            if (r0 == 0) goto L_0x001e
            com.baidu.search.duration.pyramid.ISearchDurationStat r0 = r0.startLogDuration()
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            r2.searchDurationStat = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.utils.BigImageSearchDurationStat.onStatStart():void");
    }

    public final void onStatEnd(Map<String, String> extraMap, String detailfr, SSBigImageBrowserExtraParams extraParams, String refer, ArrayList<String> pageDuration) {
        String str = detailfr;
        Intrinsics.checkNotNullParameter(str, BigImageTcUtilsKt.BIG_IMAGE_EXTRA_DETAILFR);
        ISearchDurationStat $this$onStatEnd_u24lambda_u2d2 = this.searchDurationStat;
        if ($this$onStatEnd_u24lambda_u2d2 != null) {
            Collection collection = pageDuration;
            if (!(collection == null || collection.isEmpty())) {
                JSONArray destination$iv = new JSONArray();
                for (String it : pageDuration) {
                    if (it != null) {
                        destination$iv.put(it);
                    }
                }
                $this$onStatEnd_u24lambda_u2d2.setExtraValue(BigImageStatistic.UBC_NID_INFO, destination$iv);
            }
            HashMap map = new HashMap();
            if (extraMap != null) {
                map.putAll(extraMap);
            }
            $this$onStatEnd_u24lambda_u2d2.setUrl(BigImageStatistic.INSTANCE.getUrl($this$onStatEnd_u24lambda_u2d2.getStartTime(), str, extraParams)).setRefer(SearchUtils.excludeBDUSSParam(refer)).setExtraValue((Map<String, ? extends Object>) map).endLogDuration();
        } else {
            SSBigImageBrowserExtraParams sSBigImageBrowserExtraParams = extraParams;
        }
        this.searchDurationStat = null;
    }

    public final void onStatEnd(Map<String, String> extraMap, ArrayList<String> pageDuration) {
        ISearchDurationStat $this$onStatEnd_u24lambda_u2d5 = this.searchDurationStat;
        if ($this$onStatEnd_u24lambda_u2d5 != null) {
            HashMap map = new HashMap();
            if (extraMap != null) {
                map.putAll(extraMap);
            }
            Collection collection = pageDuration;
            if (!(collection == null || collection.isEmpty())) {
                JSONArray destination$iv = new JSONArray();
                for (String it : pageDuration) {
                    if (it != null) {
                        destination$iv.put(it);
                    }
                }
                $this$onStatEnd_u24lambda_u2d5.setExtraValue(BigImageStatistic.UBC_NID_INFO, destination$iv);
            }
            $this$onStatEnd_u24lambda_u2d5.setExtraValue((Map<String, ? extends Object>) map).endLogDuration();
        }
        this.searchDurationStat = null;
    }
}
