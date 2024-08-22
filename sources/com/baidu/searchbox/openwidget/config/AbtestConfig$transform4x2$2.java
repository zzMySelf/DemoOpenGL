package com.baidu.searchbox.openwidget.config;

import com.baidu.searchbox.openwidget.transform.OpenWidgetTransform;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/openwidget/transform/OpenWidgetTransform;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbtestConfig.kt */
final class AbtestConfig$transform4x2$2 extends Lambda implements Function0<OpenWidgetTransform> {
    public static final AbtestConfig$transform4x2$2 INSTANCE = new AbtestConfig$transform4x2$2();

    AbtestConfig$transform4x2$2() {
        super(0);
    }

    public final OpenWidgetTransform invoke() {
        OpenWidgetTransform.Companion companion = OpenWidgetTransform.Companion;
        JSONObject access$getTransformJson = AbtestConfig.INSTANCE.getTransformJson();
        return companion.fromJson(access$getTransformJson != null ? access$getTransformJson.optJSONObject(TransformConfigListenerKt.NODE_TRANSFORM_4x2) : null);
    }
}
