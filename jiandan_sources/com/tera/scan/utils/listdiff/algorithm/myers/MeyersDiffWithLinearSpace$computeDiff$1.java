package com.tera.scan.utils.listdiff.algorithm.myers;

import com.tera.scan.utils.listdiff.algorithm.DiffAlgorithmListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "idx", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MeyersDiffWithLinearSpace$computeDiff$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ int $maxIdx;
    public final /* synthetic */ DiffAlgorithmListener $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeyersDiffWithLinearSpace$computeDiff$1(DiffAlgorithmListener diffAlgorithmListener, int i2) {
        super(1);
        this.$progress = diffAlgorithmListener;
        this.$maxIdx = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        DiffAlgorithmListener diffAlgorithmListener = this.$progress;
        if (diffAlgorithmListener != null) {
            diffAlgorithmListener.ad(i2, this.$maxIdx);
        }
    }
}
