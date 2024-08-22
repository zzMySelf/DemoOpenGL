package com.baidu.searchbox.feed.biserialdetail.ubc;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"onSearchViewClickedUBC", "", "searchInfo", "Lorg/json/JSONObject;", "lib-feed-biserial-detail_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchViewStatHelper.kt */
public final class SearchViewStatHelperKt {
    public static final void onSearchViewClickedUBC(JSONObject searchInfo) {
        Object obj;
        UBCManager ubc;
        if (searchInfo != null) {
            JSONObject info = searchInfo;
            try {
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                JSONObject $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1 = jSONObject;
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("from", info.optString("from"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("type", "click");
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("page", info.optString("page"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("source", info.optString("source"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("value", info.optString("value"));
                JSONObject ext = new JSONObject();
                JSONObject $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = ext;
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("nid", info.optString("nid"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("cate1", info.optString("category_v4"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("cate2", info.optString("sub_category_v4"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("title", info.optString("title"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("query", info.optString("query"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("query_type", info.optString("query_type"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.put("sa", info.optString("sa"));
                $this$onSearchViewClickedUBC_u24lambda_u2d2_u24lambda_u2d1.put("ext", ext);
                obj = Result.m8971constructorimpl(jSONObject);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject ubcObj = (JSONObject) obj;
            if (ubcObj != null && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                ubc.onEvent(UBCManifestKt.UBC_ID_7054, ubcObj);
            }
        }
    }
}
