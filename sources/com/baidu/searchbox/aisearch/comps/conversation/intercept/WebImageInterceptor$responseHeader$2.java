package com.baidu.searchbox.aisearch.comps.conversation.intercept;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebImageInterceptor.kt */
final class WebImageInterceptor$responseHeader$2 extends Lambda implements Function0<HashMap<String, String>> {
    public static final WebImageInterceptor$responseHeader$2 INSTANCE = new WebImageInterceptor$responseHeader$2();

    WebImageInterceptor$responseHeader$2() {
        super(0);
    }

    public final HashMap<String, String> invoke() {
        return MapsKt.hashMapOf(TuplesKt.to("Access-Control-Allow-Origin", "*"), TuplesKt.to("Access-Control-Allow-Headers", "*"));
    }
}
