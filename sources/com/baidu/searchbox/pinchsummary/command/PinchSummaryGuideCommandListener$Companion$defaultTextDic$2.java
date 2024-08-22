package com.baidu.searchbox.pinchsummary.command;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryGuideCommandListener.kt */
final class PinchSummaryGuideCommandListener$Companion$defaultTextDic$2 extends Lambda implements Function0<HashMap<String, String>> {
    public static final PinchSummaryGuideCommandListener$Companion$defaultTextDic$2 INSTANCE = new PinchSummaryGuideCommandListener$Companion$defaultTextDic$2();

    PinchSummaryGuideCommandListener$Companion$defaultTextDic$2() {
        super(0);
    }

    public final HashMap<String, String> invoke() {
        Object obj;
        String degradeTextDicStr = new SharedPrefsWrapper(PinchSummaryCommandConstantKt.PINCH_SUMMARY_SP_FILE).getString("default_text_dic", "{}");
        HashMap hashMap = new HashMap();
        HashMap $this$invoke_u24lambda_u2d3 = hashMap;
        try {
            Result.Companion companion = Result.Companion;
            if (degradeTextDicStr != null) {
                JSONObject json = new JSONObject(degradeTextDicStr);
                Iterator<String> keys = json.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
                while (keys.hasNext()) {
                    String key = keys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    String string = json.getString(key);
                    Intrinsics.checkNotNullExpressionValue(string, "json.getString(key)");
                    $this$invoke_u24lambda_u2d3.put(key, string);
                }
                obj = Result.m8971constructorimpl(Unit.INSTANCE);
                Throwable it = Result.m8974exceptionOrNullimpl(obj);
                if (it != null) {
                    it.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        return hashMap;
    }
}
