package com.baidu.searchbox.video.feedflow.ad.util;

import com.baidu.nadcore.utils.FixedCapacityFifoQueue;
import com.baidu.searchbox.feed.ad.AdUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/nadcore/utils/FixedCapacityFifoQueue;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DupStrategy.kt */
final class DupStrategy$recentNidQueueOfGlobal$2 extends Lambda implements Function0<FixedCapacityFifoQueue<String>> {
    public static final DupStrategy$recentNidQueueOfGlobal$2 INSTANCE = new DupStrategy$recentNidQueueOfGlobal$2();

    DupStrategy$recentNidQueueOfGlobal$2() {
        super(0);
    }

    public final FixedCapacityFifoQueue<String> invoke() {
        return new FixedCapacityFifoQueue<>(AdUtil.eShowDupSwitch2AdCount());
    }
}
