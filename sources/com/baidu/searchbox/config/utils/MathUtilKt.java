package com.baidu.searchbox.config.utils;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b¨\u0006\u0004"}, d2 = {"roundByPolicy", "", "", "roundPolicy", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MathUtil.kt */
public final class MathUtilKt {
    @StableApi
    public static final int roundByPolicy(float $this$roundByPolicy, int roundPolicy) {
        switch (roundPolicy) {
            case 0:
                return (int) ((float) Math.ceil((double) $this$roundByPolicy));
            case 1:
                return (int) ((float) Math.floor((double) $this$roundByPolicy));
            case 2:
                return MathKt.roundToInt($this$roundByPolicy);
            default:
                return MathKt.roundToInt($this$roundByPolicy);
        }
    }
}
