package com.baidu.searchbox.player.plugin;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.model.FloatRange;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a$\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\bH\u0007\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\t\u001a\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0003*\u0004\u0018\u00010\u0005H\u0002¨\u0006\u000b"}, d2 = {"parseSRConfig", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/player/plugin/SRConfig;", "Lkotlin/collections/ArrayList;", "srConfig", "", "isScaleValid", "", "", "(Ljava/lang/Float;)Z", "toClarityList", "framework_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SRConfig.kt */
public final class SRConfigKt {
    public static final ArrayList<SRConfig> parseSRConfig(String srConfig) {
        String $this$parseSRConfig_u24lambda_u2d0;
        String str = srConfig;
        if (str == null) {
            return null;
        }
        String $this$parseSRConfig_u24lambda_u2d02 = srConfig;
        try {
            JSONArray hostsJSONArray = new JSONArray(str);
            if (!BdPlayerUtils.isNullOrEmpty(hostsJSONArray)) {
                ArrayList srConfigList = new ArrayList();
                int length = hostsJSONArray.length();
                int index = 0;
                while (index < length) {
                    JSONObject optJSONObject = hostsJSONArray.optJSONObject(index);
                    if (optJSONObject == null) {
                        $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(optJSONObject, "hostsJSONArray.optJSONObject(index) ?: continue");
                        JSONObject hostObj = optJSONObject;
                        String from = hostObj.optString("from");
                        String page = hostObj.optString("page");
                        String source = hostObj.optString("source");
                        FloatRange score = BdPlayerUtils.toFloatRange(hostObj.optString("device_score"));
                        FloatRange clarityScore = BdPlayerUtils.toFloatRange(hostObj.optString("clarity_score"));
                        ArrayList clarityList = toClarityList(hostObj.optString("clarity"));
                        String optString = hostObj.optString("sr_scale");
                        Object fallback$iv = Float.valueOf(0.0f);
                        String $this$toValueSafe$iv = optString;
                        CharSequence charSequence = $this$toValueSafe$iv;
                        if (charSequence == null || charSequence.length() == 0) {
                            $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                        } else {
                            try {
                                if (fallback$iv instanceof Integer) {
                                    fallback$iv = (Float) Integer.valueOf(Integer.parseInt($this$toValueSafe$iv));
                                    $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                                } else if (fallback$iv instanceof Double) {
                                    fallback$iv = (Float) Double.valueOf(Double.parseDouble($this$toValueSafe$iv));
                                    $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                                } else if (fallback$iv instanceof Long) {
                                    fallback$iv = (Float) Long.valueOf(Long.parseLong($this$toValueSafe$iv));
                                    $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                                } else {
                                    fallback$iv = Float.valueOf(Float.parseFloat($this$toValueSafe$iv));
                                    $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                                }
                            } catch (NumberFormatException exception$iv) {
                                $this$parseSRConfig_u24lambda_u2d0 = $this$parseSRConfig_u24lambda_u2d02;
                                BdVideoLog.e("string to target value, catch exception:", (Throwable) exception$iv);
                            }
                        }
                        float scale = ((Number) fallback$iv).floatValue();
                        Intrinsics.checkNotNullExpressionValue(from, "from");
                        Intrinsics.checkNotNullExpressionValue(page, "page");
                        Intrinsics.checkNotNullExpressionValue(source, "source");
                        String str2 = page;
                        String str3 = from;
                        srConfigList.add(new SRConfig(from, page, source, score, clarityScore, clarityList, scale));
                    }
                    index++;
                    String str4 = srConfig;
                    $this$parseSRConfig_u24lambda_u2d02 = $this$parseSRConfig_u24lambda_u2d0;
                }
                return srConfigList;
            }
            String str5 = $this$parseSRConfig_u24lambda_u2d02;
            return null;
        } catch (Exception e2) {
            BdVideoLog.d("parseSRConfig", e2.getMessage());
            return null;
        }
    }

    private static final ArrayList<String> toClarityList(String $this$toClarityList) {
        CharSequence charSequence = $this$toClarityList;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        Iterable<String> $this$map$iv = StringsKt.split$default((CharSequence) $this$toClarityList, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String it : $this$map$iv) {
            destination$iv$iv.add(it);
        }
        return (ArrayList) ((List) destination$iv$iv);
    }

    @StableApi
    public static final boolean isScaleValid(Float $this$isScaleValid) {
        return Intrinsics.areEqual($this$isScaleValid, 1.0f) || Intrinsics.areEqual($this$isScaleValid, 1.5f) || Intrinsics.areEqual($this$isScaleValid, 2.0f);
    }
}
