package com.baidu.searchbox.widget.aiwidget.model;

import com.baidu.searchbox.widget.WidgetActionUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/widget/aiwidget/model/AIWidgetTempModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIWidgetTempModel.kt */
final class AIWidgetTempModel$Companion$PRESET_MODELS$2 extends Lambda implements Function0<List<? extends AIWidgetTempModel>> {
    public static final AIWidgetTempModel$Companion$PRESET_MODELS$2 INSTANCE = new AIWidgetTempModel$Companion$PRESET_MODELS$2();

    AIWidgetTempModel$Companion$PRESET_MODELS$2() {
        super(0);
    }

    public final List<AIWidgetTempModel> invoke() {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$invoke_u24lambda_u2d0 = jSONObject;
        $this$invoke_u24lambda_u2d0.put("id", AIWidgetTempModel.VIEW_ID_HOT_CONTENT);
        $this$invoke_u24lambda_u2d0.put("template", "1");
        $this$invoke_u24lambda_u2d0.put("order", 1);
        $this$invoke_u24lambda_u2d0.put("title", AIWidgetTempModel.TITLE_HOT_CONTENT);
        $this$invoke_u24lambda_u2d0.put("subtitle", AIWidgetTempModel.SUB_TITLE_HOT_CONTENT);
        $this$invoke_u24lambda_u2d0.put("scheme", WidgetActionUtils.GO_HOME_SCHEME);
        Unit unit = Unit.INSTANCE;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject $this$invoke_u24lambda_u2d1 = jSONObject2;
        $this$invoke_u24lambda_u2d1.put("id", AIWidgetTempModel.VIEW_ID_SEARCH);
        $this$invoke_u24lambda_u2d1.put("template", "1");
        $this$invoke_u24lambda_u2d1.put("order", 2);
        $this$invoke_u24lambda_u2d1.put("title", AIWidgetTempModel.TITLE_SEARCH);
        $this$invoke_u24lambda_u2d1.put("subtitle", AIWidgetTempModel.SUB_TITLE_SEARCH);
        $this$invoke_u24lambda_u2d1.put("scheme", WidgetActionUtils.GO_HISSUG_SCHEME);
        Unit unit2 = Unit.INSTANCE;
        return CollectionsKt.listOf(new AIWidgetTempModel(jSONObject), new AIWidgetTempModel(jSONObject2));
    }
}
