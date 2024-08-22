package com.baidu.searchbox.feed.payment;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.nps.PluginImplCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/nps/PluginImplCache;", "Lcom/baidu/searchbox/feed/payment/SpColumn;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: column.kt */
final class FeedPayManagerEx$spColumnCache$2 extends Lambda implements Function0<PluginImplCache<SpColumn>> {
    public static final FeedPayManagerEx$spColumnCache$2 INSTANCE = new FeedPayManagerEx$spColumnCache$2();

    FeedPayManagerEx$spColumnCache$2() {
        super(0);
    }

    public final PluginImplCache<SpColumn> invoke() {
        return new PluginImplCache(ConstantsKt.PLUGIN_PKG_NAME, SpColumn.class, "com.baidu.searchbox.feed.payment", ConstantsKt.SPCOLUMN_SERVICE_NAME, (ServiceReference) null, (String) null, 0, (Object) null, 240, (DefaultConstructorMarker) null);
    }
}
