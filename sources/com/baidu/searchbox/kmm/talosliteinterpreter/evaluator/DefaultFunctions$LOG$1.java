package com.baidu.searchbox.kmm.talosliteinterpreter.evaluator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/kmm/talosliteinterpreter/evaluator/DefaultFunctions$LOG$1", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/Function;", "invoke", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Function.kt */
public final class DefaultFunctions$LOG$1 extends Function {
    DefaultFunctions$LOG$1() {
        super("log", 2);
    }

    public Object invoke(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return Double.valueOf(MathKt.log(FunctionKt.getAsNumber(args, 0, new DefaultFunctions$LOG$1$invoke$operand$1(this)).doubleValue(), FunctionKt.getAsNumber(args, 1, new DefaultFunctions$LOG$1$invoke$base$1(this)).doubleValue()));
    }
}
