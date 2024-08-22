package com.baidu.browser.explore.rec;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.search.tcstatistic.TcStatisticConstantKt;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\u001a.\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"RESULT_PAGE_REC_AFTER_CLICK_SHOW_LOG", "", "convertRecAfterClickDataToTalos", "data", "Lorg/json/JSONArray;", "covertRecAfterClickDataToVideoModel", "Lorg/json/JSONObject;", "position", "", "srcid", "getRecAfterClickLog", "amount", "order", "immerse", "", "tplname", "parseToRecAfterClickDataList", "Ljava/util/ArrayList;", "Lcom/baidu/browser/explore/rec/RecAfterClickData;", "Lkotlin/collections/ArrayList;", "saveRecAfterClickData", "", "cache", "Lcom/baidu/browser/explore/rec/RecAfterClickDataCache;", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecAfterClickConstant.kt */
public final class RecAfterClickConstantKt {
    public static final String RESULT_PAGE_REC_AFTER_CLICK_SHOW_LOG = "javascript:(function(){if(window.page&&window.page.log&&window.page.log.send){window.page.log.send({ct:36,cst:1,clk_extra:'%s'});}})();";

    public static final String convertRecAfterClickDataToTalos(JSONArray data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String jSONObject = new JSONObject().put("layout", "search_a_recommend_after_click").put("data", data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return jSONObject;
    }

    public static final String covertRecAfterClickDataToVideoModel(JSONObject data, int position, String srcid) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(srcid, "srcid");
        String jSONObject = new JSONObject().put("scheme", new JSONObject().put("data", data.put("position", position).put("srcid", srcid)).put("layout", "search_a_recommend_after_click")).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return jSONObject;
    }

    public static final void saveRecAfterClickData(JSONArray data, RecAfterClickDataCache cache) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cache, "cache");
        if (UiThreadUtils.isOnUiThread()) {
            ExecutorUtilsExt.postOnElastic(new RecAfterClickConstantKt$$ExternalSyntheticLambda0(data, cache), "parseToRecAfterClickDataList", 2);
        } else {
            UiThreadUtils.runOnUiThread(new RecAfterClickConstantKt$$ExternalSyntheticLambda1(cache, parseToRecAfterClickDataList(data)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: saveRecAfterClickData$lambda-1  reason: not valid java name */
    public static final void m12939saveRecAfterClickData$lambda1(JSONArray $data, RecAfterClickDataCache $cache) {
        Intrinsics.checkNotNullParameter($data, "$data");
        Intrinsics.checkNotNullParameter($cache, "$cache");
        UiThreadUtils.runOnUiThread(new RecAfterClickConstantKt$$ExternalSyntheticLambda2($cache, parseToRecAfterClickDataList($data)));
    }

    /* access modifiers changed from: private */
    /* renamed from: saveRecAfterClickData$lambda-1$lambda-0  reason: not valid java name */
    public static final void m12940saveRecAfterClickData$lambda1$lambda0(RecAfterClickDataCache $cache, ArrayList $list) {
        Intrinsics.checkNotNullParameter($cache, "$cache");
        Intrinsics.checkNotNullParameter($list, "$list");
        $cache.setData($list);
    }

    /* access modifiers changed from: private */
    /* renamed from: saveRecAfterClickData$lambda-2  reason: not valid java name */
    public static final void m12941saveRecAfterClickData$lambda2(RecAfterClickDataCache $cache, ArrayList $list) {
        Intrinsics.checkNotNullParameter($cache, "$cache");
        Intrinsics.checkNotNullParameter($list, "$list");
        $cache.setData($list);
    }

    private static final ArrayList<RecAfterClickData> parseToRecAfterClickDataList(JSONArray data) {
        ArrayList dataList = new ArrayList();
        try {
            int dataLength = data.length();
            for (int index = 0; index < dataLength; index++) {
                JSONObject $this$parseToRecAfterClickDataList_u24lambda_u2d4 = data.optJSONObject(index);
                if ($this$parseToRecAfterClickDataList_u24lambda_u2d4 != null) {
                    int order = $this$parseToRecAfterClickDataList_u24lambda_u2d4.optInt("order");
                    int amount = 0;
                    JSONObject $this$parseToRecAfterClickDataList_u24lambda_u2d4_u24lambda_u2d3 = $this$parseToRecAfterClickDataList_u24lambda_u2d4.optJSONObject("list");
                    if ($this$parseToRecAfterClickDataList_u24lambda_u2d4_u24lambda_u2d3 != null) {
                        Intrinsics.checkNotNullExpressionValue($this$parseToRecAfterClickDataList_u24lambda_u2d4_u24lambda_u2d3, "optJSONObject(\"list\")");
                        JSONArray optJSONArray = $this$parseToRecAfterClickDataList_u24lambda_u2d4_u24lambda_u2d3.optJSONArray("up");
                        int i2 = 0;
                        int length = optJSONArray != null ? optJSONArray.length() : 0;
                        JSONArray optJSONArray2 = $this$parseToRecAfterClickDataList_u24lambda_u2d4_u24lambda_u2d3.optJSONArray("down");
                        if (optJSONArray2 != null) {
                            i2 = optJSONArray2.length();
                        }
                        amount = length + i2;
                    }
                    dataList.add(new RecAfterClickData(order, amount, $this$parseToRecAfterClickDataList_u24lambda_u2d4));
                }
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return dataList;
    }

    public static final String getRecAfterClickLog(int amount, int order, boolean immerse, String tplname, String srcid) {
        Intrinsics.checkNotNullParameter(tplname, "tplname");
        Intrinsics.checkNotNullParameter(srcid, "srcid");
        JSONObject logObject = new JSONObject().put("tplname", tplname).put("amount", amount).put("immerse", immerse).put(TcStatisticConstantKt.KEY_EXTRA_IS_NA, 1).put("srcid", srcid).put("order", order);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(RESULT_PAGE_REC_AFTER_CLICK_SHOW_LOG, Arrays.copyOf(new Object[]{logObject.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
