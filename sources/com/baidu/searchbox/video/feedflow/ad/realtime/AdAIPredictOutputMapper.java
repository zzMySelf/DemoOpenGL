package com.baidu.searchbox.video.feedflow.ad.realtime;

import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ4\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/realtime/AdAIPredictOutputMapper;", "", "()V", "mapV1", "Lcom/baidu/searchbox/video/feedflow/ad/realtime/AdAIPredictOutModelV1;", "outputJson", "Lorg/json/JSONObject;", "output", "", "mapV2", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdAIPredictOutputMapper.kt */
public final class AdAIPredictOutputMapper {
    public final AdAIPredictOutModelV1 mapV1(JSONObject outputJson, float[] output) {
        Intrinsics.checkNotNullParameter(outputJson, "outputJson");
        String outputStr = outputJson.optString(String.valueOf(output != null ? Integer.valueOf(AdAIPredictOutputMapperKt.maxValueIndex(output)) : null));
        CharSequence charSequence = outputStr;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        JSONObject json = JSONUtils.newJSONObject(outputStr);
        Intrinsics.checkNotNullExpressionValue(json, "newJSONObject(outputStr)");
        return new AdAIPredictOutModelV1(json.optInt(AdAIPredictOutputMapperKt.BUTTON_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.BUTTON_ENHANCE_DELAY_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.MOUNT_TAG_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.POP_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.STRUCT_TAG_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.CAROUSEL_TILE_SHOW_TIME_KEY, -1));
    }

    public final AdAIPredictOutModelV1 mapV2(JSONObject outputJson, HashMap<Integer, Float> output) {
        Intrinsics.checkNotNullParameter(outputJson, "outputJson");
        Intrinsics.checkNotNullParameter(output, BindingXConstants.KEY_INTERPOLATER_OUTPUT);
        String outputStr = outputJson.optString(String.valueOf(AdAIPredictOutputMapperKt.maxValueIndex(output)));
        CharSequence charSequence = outputStr;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        JSONObject json = JSONUtils.newJSONObject(outputStr);
        Intrinsics.checkNotNullExpressionValue(json, "newJSONObject(outputStr)");
        return new AdAIPredictOutModelV1(json.optInt(AdAIPredictOutputMapperKt.BUTTON_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.BUTTON_ENHANCE_DELAY_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.MOUNT_TAG_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.POP_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.STRUCT_TAG_SHOW_TIME_KEY, -1), json.optInt(AdAIPredictOutputMapperKt.CAROUSEL_TILE_SHOW_TIME_KEY, -1));
    }
}
