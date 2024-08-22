package com.baidu.searchbox.kmm.talosliteinterpreter.evaluator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0004\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/kmm/talosliteinterpreter/evaluator/DefaultFunctions$FLOOR$1", "Lcom/baidu/searchbox/kmm/talosliteinterpreter/evaluator/OneNumberArgumentFunction;", "invokeInternal", "", "arg", "", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Function.kt */
public final class DefaultFunctions$FLOOR$1 extends OneNumberArgumentFunction {
    DefaultFunctions$FLOOR$1() {
        super("floor", 1);
    }

    public double invokeInternal(Number arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        return Math.floor(arg.doubleValue());
    }
}
