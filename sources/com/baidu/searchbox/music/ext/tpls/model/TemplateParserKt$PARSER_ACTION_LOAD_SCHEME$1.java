package com.baidu.searchbox.music.ext.tpls.model;

import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/ext/tpls/model/LoadSchemeAction;", "json", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemplateParser.kt */
final class TemplateParserKt$PARSER_ACTION_LOAD_SCHEME$1 extends Lambda implements Function1<JSONObject, LoadSchemeAction> {
    public static final TemplateParserKt$PARSER_ACTION_LOAD_SCHEME$1 INSTANCE = new TemplateParserKt$PARSER_ACTION_LOAD_SCHEME$1();

    TemplateParserKt$PARSER_ACTION_LOAD_SCHEME$1() {
        super(1);
    }

    public final LoadSchemeAction invoke(JSONObject json) {
        String optStringIgnoreNulls;
        Intrinsics.checkNotNullParameter(json, "json");
        LoadSchemeAction loadSchemeAction = new LoadSchemeAction();
        LoadSchemeAction $this$invoke_u24lambda_u2d0 = loadSchemeAction;
        TemplateParserKt.parseCommonAction($this$invoke_u24lambda_u2d0, json);
        JSONObject optJSONObject = json.optJSONObject("data");
        String str = "";
        if (!(optJSONObject == null || (optStringIgnoreNulls = JSONExtKt.optStringIgnoreNulls(optJSONObject, "scheme", str)) == null)) {
            str = optStringIgnoreNulls;
        }
        $this$invoke_u24lambda_u2d0.setScheme(str);
        return loadSchemeAction;
    }
}
