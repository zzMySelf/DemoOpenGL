package com.baidu.searchbox.video.feedflow.detail.thirdParty.statistic;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/Random;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartyStatisticMiddleware.kt */
final class ThirdPartyStatisticMiddleware$random$2 extends Lambda implements Function0<Random> {
    public static final ThirdPartyStatisticMiddleware$random$2 INSTANCE = new ThirdPartyStatisticMiddleware$random$2();

    ThirdPartyStatisticMiddleware$random$2() {
        super(0);
    }

    public final Random invoke() {
        return new Random();
    }
}
