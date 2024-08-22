package com.baidu.searchbox.poimap.internal;

import com.baidu.searchbox.poimap.internal.IPoiSchemeMediator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/poimap/internal/IPoiSchemeMediator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPoiSchemeMediator.kt */
final class IPoiSchemeMediator$Companion$Impl$2 extends Lambda implements Function0<IPoiSchemeMediator> {
    public static final IPoiSchemeMediator$Companion$Impl$2 INSTANCE = new IPoiSchemeMediator$Companion$Impl$2();

    IPoiSchemeMediator$Companion$Impl$2() {
        super(0);
    }

    public final IPoiSchemeMediator invoke() {
        IPoiSchemeMediator mediator = PoiSchemeRuntime.getMediator();
        return mediator == null ? IPoiSchemeMediator.Companion.$$INSTANCE.getEmpty() : mediator;
    }
}
