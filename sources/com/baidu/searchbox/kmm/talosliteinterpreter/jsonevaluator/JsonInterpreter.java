package com.baidu.searchbox.kmm.talosliteinterpreter.jsonevaluator;

import com.baidu.searchbox.kmm.talosliteinterpreter.InterpreterUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/kmm/talosliteinterpreter/jsonevaluator/JsonInterpreter;", "", "()V", "evaluateJson", "expression", "", "json", "com.baidu.searchbox.kmm.business.talosliteinterpreter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonInterpreter.kt */
public final class JsonInterpreter {
    public final Object evaluateJson(String expression, Object json) {
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(json, "json");
        if (InterpreterUtilsKt.isNull(json) || !InterpreterUtilsKt.isJsonStr(json.toString())) {
            return null;
        }
        JsonProgram program = new JsonParser(new JsonLexer(expression)).parse();
        if (program.getStatements().size() <= 0) {
            return null;
        }
        return new JsonEvaluator().evaluate(json, program);
    }
}
