package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.feed.config.NewsConstant;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.video.feedflow.detail.player.player.layer.FillRule;
import com.baidu.searchbox.video.feedflow.detail.player.player.layer.IntelFullScreenConfig;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowSpHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u001a\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u001a\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u0016\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"FLOW_SP_KEY_FILL_IS_USER_SELECTED", "", "FLOW_SP_KEY_FILL_RULES", "FLOW_SP_KEY_FILL_USER_SELECTED_STATUS", "OBJ_KEY_FILL_RULES", "handleIntelFullScreenSwitch", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "parseFillRules", "", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FillRule;", "jArray", "Lorg/json/JSONArray;", "parseFillScreenConfig", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/IntelFullScreenConfig;", "jsonStr", "parseFractionToDecimal", "", "fraction", "(Ljava/lang/String;)Ljava/lang/Float;", "parseRange", "Lkotlin/Pair;", "config", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowIntelFullScreenSwitcher.kt */
public final class FlowIntelFullScreenSwitcherKt {
    public static final String FLOW_SP_KEY_FILL_IS_USER_SELECTED = "flow_sp_key_fill_is_user_selected";
    public static final String FLOW_SP_KEY_FILL_RULES = "flow_sp_key_fill_rules";
    public static final String FLOW_SP_KEY_FILL_USER_SELECTED_STATUS = "flow_sp_key_fill_user_selected_status";
    private static final String OBJ_KEY_FILL_RULES = "flow_video_fill_rules";

    public static final void handleIntelFullScreenSwitch(ActionData<JSONObject> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            JSONObject fillRulesConfigJObj = ((JSONObject) value.data).optJSONObject(OBJ_KEY_FILL_RULES);
            VideoFlowSpHelper.INSTANCE.putString(FLOW_SP_KEY_FILL_RULES, fillRulesConfigJObj != null ? fillRulesConfigJObj.toString() : null);
        } catch (Exception e2) {
        }
    }

    public static final IntelFullScreenConfig parseFillScreenConfig(String jsonStr) {
        String str = jsonStr;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        try {
            JSONObject $this$parseFillScreenConfig_u24lambda_u2d0 = new JSONObject(str);
            boolean z = 1 == $this$parseFillScreenConfig_u24lambda_u2d0.optInt("switch");
            boolean cloudStatus = 1 == $this$parseFillScreenConfig_u24lambda_u2d0.optInt(NewsConstant.NEWS_AB_DEFAULT_VALUE);
            JSONObject configsJObj = $this$parseFillScreenConfig_u24lambda_u2d0.optJSONObject("configs");
            JSONObject portraitJObj = configsJObj != null ? configsJObj.optJSONObject("portrait") : null;
            JSONObject landscapeJObj = configsJObj != null ? configsJObj.optJSONObject("landscape") : null;
            return new IntelFullScreenConfig(z, cloudStatus, (Boolean) null, parseFillRules(portraitJObj != null ? portraitJObj.optJSONArray("h") : null), parseFillRules(portraitJObj != null ? portraitJObj.optJSONArray("v") : null), parseFillRules(landscapeJObj != null ? landscapeJObj.optJSONArray("h") : null), 4, (DefaultConstructorMarker) null);
        } catch (Exception e2) {
            IntelFullScreenConfig intelFullScreenConfig = null;
            return null;
        }
    }

    private static final List<FillRule> parseFillRules(JSONArray jArray) {
        if (jArray == null || jArray.length() <= 0) {
            return null;
        }
        List fillRules = new ArrayList();
        int i2 = 0;
        int length = jArray.length();
        if (0 <= length) {
            while (true) {
                JSONObject jObj = jArray.optJSONObject(i2);
                if (jObj != null) {
                    String rangeStr = jObj.optString("ratio_range");
                    String $this$parseFillRules_u24lambda_u2d1 = jObj.optString("fill_ratio");
                    Intrinsics.checkNotNullExpressionValue($this$parseFillRules_u24lambda_u2d1, "this");
                    Float fillRatio = parseFractionToDecimal($this$parseFillRules_u24lambda_u2d1);
                    Intrinsics.checkNotNullExpressionValue(rangeStr, "rangeStr");
                    Pair parseRange = parseRange(rangeStr);
                    fillRules.add(new FillRule(parseRange != null ? parseRange.getFirst() : null, parseRange != null ? parseRange.getSecond() : null, fillRatio));
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return fillRules;
    }

    private static final Pair<Float, Float> parseRange(String config) {
        int index = StringsKt.indexOf$default((CharSequence) config, "_", 0, false, 6, (Object) null);
        if (index <= -1) {
            return null;
        }
        Float min = null;
        Float max = null;
        if (index == 0) {
            try {
                String $this$parseRange_u24lambda_u2d2 = config.substring(index + 1);
                Intrinsics.checkNotNullExpressionValue($this$parseRange_u24lambda_u2d2, "this as java.lang.String).substring(startIndex)");
                max = parseFractionToDecimal($this$parseRange_u24lambda_u2d2);
            } catch (Exception e2) {
                if (BDPlayerConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        } else if (index == config.length() - 1) {
            String $this$parseRange_u24lambda_u2d3 = config.substring(0, index);
            Intrinsics.checkNotNullExpressionValue($this$parseRange_u24lambda_u2d3, "this as java.lang.String…ing(startIndex, endIndex)");
            min = parseFractionToDecimal($this$parseRange_u24lambda_u2d3);
        } else {
            String $this$parseRange_u24lambda_u2d4 = config.substring(0, index);
            Intrinsics.checkNotNullExpressionValue($this$parseRange_u24lambda_u2d4, "this as java.lang.String…ing(startIndex, endIndex)");
            min = parseFractionToDecimal($this$parseRange_u24lambda_u2d4);
            String $this$parseRange_u24lambda_u2d5 = config.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue($this$parseRange_u24lambda_u2d5, "this as java.lang.String).substring(startIndex)");
            max = parseFractionToDecimal($this$parseRange_u24lambda_u2d5);
            float f2 = 0.0f;
            float floatValue = min != null ? min.floatValue() : 0.0f;
            if (max != null) {
                f2 = max.floatValue();
            }
            if (floatValue > f2) {
                Float tempMin = min;
                min = max;
                max = tempMin;
            }
        }
        return new Pair<>(min, max);
    }

    private static final Float parseFractionToDecimal(String fraction) {
        int index = StringsKt.indexOf$default((CharSequence) fraction, "/", 0, false, 6, (Object) null);
        if (index == -1) {
            try {
                return Float.valueOf(Float.parseFloat(fraction));
            } catch (Exception e2) {
                if (!BDPlayerConfig.isDebug()) {
                    return null;
                }
                e2.printStackTrace();
                return null;
            }
        } else if (index <= 0) {
            return null;
        } else {
            boolean z = true;
            if (index >= fraction.length() - 1) {
                return null;
            }
            String substring = fraction.substring(0, index);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            float first = Float.parseFloat(substring);
            String substring2 = fraction.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            float second = Float.parseFloat(substring2);
            if (second != 0.0f) {
                z = false;
            }
            if (!z) {
                return Float.valueOf(first / second);
            }
            return null;
        }
    }
}
