package com.baidu.searchbox.videopublisher.location;

import com.baidu.ugc.position.ILocationSelectInterface;
import com.baidu.ugc.position.LocationSelectManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/ugc/position/ILocationSelectInterface;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocRecommendPlugin.kt */
final class LocRecommendPlugin$locSelectInterface$2 extends Lambda implements Function0<ILocationSelectInterface> {
    public static final LocRecommendPlugin$locSelectInterface$2 INSTANCE = new LocRecommendPlugin$locSelectInterface$2();

    LocRecommendPlugin$locSelectInterface$2() {
        super(0);
    }

    public final ILocationSelectInterface invoke() {
        return LocationSelectManager.getLocationSelectProvider();
    }
}
