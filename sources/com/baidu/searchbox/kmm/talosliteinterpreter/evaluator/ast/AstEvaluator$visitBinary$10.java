package com.baidu.searchbox.kmm.talosliteinterpreter.evaluator.ast;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "left", "", "right", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AstEvaluator.kt */
final class AstEvaluator$visitBinary$10 extends Lambda implements Function2<Double, Double, Object> {
    final /* synthetic */ AstEvaluator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AstEvaluator$visitBinary$10(AstEvaluator astEvaluator) {
        super(2);
        this.this$0 = astEvaluator;
    }

    public final Object invoke(double left, double right) {
        return this.this$0.canConvertToInt(Double.valueOf(left * right));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke(((Number) p1).doubleValue(), ((Number) p2).doubleValue());
    }
}
