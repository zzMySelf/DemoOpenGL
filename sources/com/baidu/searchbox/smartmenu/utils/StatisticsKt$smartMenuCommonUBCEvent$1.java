package com.baidu.searchbox.smartmenu.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Statistics.kt */
final class StatisticsKt$smartMenuCommonUBCEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $ext;
    final /* synthetic */ String $page;
    final /* synthetic */ String $source;
    final /* synthetic */ String $type;
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StatisticsKt$smartMenuCommonUBCEvent$1(String str, String str2, String str3, String str4, String str5) {
        super(0);
        this.$type = str;
        this.$page = str2;
        this.$source = str3;
        this.$value = str4;
        this.$ext = str5;
    }

    public final void invoke() {
        JSONObject jSONObject = new JSONObject();
        String str = this.$type;
        String str2 = this.$page;
        String str3 = this.$source;
        String str4 = this.$value;
        String str5 = this.$ext;
        JSONObject $this$invoke_u24lambda_u2d1 = jSONObject;
        $this$invoke_u24lambda_u2d1.put("from", "smartmenu");
        $this$invoke_u24lambda_u2d1.put("type", str);
        $this$invoke_u24lambda_u2d1.put("page", str2);
        $this$invoke_u24lambda_u2d1.put("source", str3);
        $this$invoke_u24lambda_u2d1.put("value", str4);
        if (str5 != null) {
            String str6 = str5;
            $this$invoke_u24lambda_u2d1.put("ext", str5);
        }
        StatisticsKt.smartMenuCommonUBCEvent(jSONObject);
    }
}
