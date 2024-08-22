package com.baidu.searchbox.video.collectiondetail.duration;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/ubc/UBCManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DurationPlugin.kt */
final class DurationPlugin$ubcService$2 extends Lambda implements Function0<UBCManager> {
    public static final DurationPlugin$ubcService$2 INSTANCE = new DurationPlugin$ubcService$2();

    DurationPlugin$ubcService$2() {
        super(0);
    }

    public final UBCManager invoke() {
        return (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }
}
