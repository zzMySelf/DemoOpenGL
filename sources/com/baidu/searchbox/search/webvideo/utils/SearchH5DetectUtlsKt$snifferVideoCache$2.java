package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.search.webvideo.model.SnifferVideoInfo;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001aZ\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0003*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004 \u0003*,\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0003*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "Lcom/baidu/searchbox/search/webvideo/model/SnifferVideoInfo;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5DetectUtls.kt */
final class SearchH5DetectUtlsKt$snifferVideoCache$2 extends Lambda implements Function0<Map<String, List<? extends SnifferVideoInfo>>> {
    public static final SearchH5DetectUtlsKt$snifferVideoCache$2 INSTANCE = new SearchH5DetectUtlsKt$snifferVideoCache$2();

    SearchH5DetectUtlsKt$snifferVideoCache$2() {
        super(0);
    }

    public final Map<String, List<SnifferVideoInfo>> invoke() {
        return Collections.synchronizedMap(new LinkedHashMap());
    }
}
