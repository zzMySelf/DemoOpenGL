package com.baidu.browser.explore.network;

import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/browser/explore/network/NaResponseProtoDiskCache;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NaRequestManager.kt */
final class NaRequestManager$diskCache$2 extends Lambda implements Function0<NaResponseProtoDiskCache> {
    public static final NaRequestManager$diskCache$2 INSTANCE = new NaRequestManager$diskCache$2();

    NaRequestManager$diskCache$2() {
        super(0);
    }

    public final NaResponseProtoDiskCache invoke() {
        if (SearchABTestUtils.enableSearchNaProtoDiskCache()) {
            return new NaResponseProtoDiskCache(AppRuntime.getAppContext().getCacheDir().getAbsolutePath());
        }
        NaResponseProtoDiskCache naResponseProtoDiskCache = null;
        return null;
    }
}
