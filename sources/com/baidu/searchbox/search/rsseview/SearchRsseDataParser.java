package com.baidu.searchbox.search.rsseview;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.rsseview.SearchRsseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DATA", "", "EXT_LOG", "HIGHLIGHT_INFOS_JC", "HREF", "ITEM_LIST", "ORIGIN", "PAGE_CONFIG", "Q", "REPLACE", "RSSE_RESULT", "SE_TYPE", "TYPE", "WORD", "parseRsseData", "Lcom/baidu/searchbox/search/rsseview/SearchRsseModel;", "result", "lib_search_ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchRsseDataParser.kt */
public final class SearchRsseDataParser {
    private static final String DATA = "data";
    private static final String EXT_LOG = "ext_log";
    private static final String HIGHLIGHT_INFOS_JC = "highlight_infos_jc";
    private static final String HREF = "href";
    private static final String ITEM_LIST = "itemlist";
    private static final String ORIGIN = "origin";
    private static final String PAGE_CONFIG = "pageConfig";
    private static final String Q = "q";
    private static final String REPLACE = "replace";
    private static final String RSSE_RESULT = "rsseResult";
    private static final String SE_TYPE = "se_type";
    private static final String TYPE = "type";
    private static final String WORD = "word";

    @StableApi
    public static final SearchRsseModel parseRsseData(String result) {
        int listSize;
        String str = result;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Intrinsics.checkNotNull(result);
            JSONObject resultObject = new JSONObject(str);
            JSONObject rootObject = resultObject.optJSONObject("data");
            JSONObject itemListObject = rootObject != null ? rootObject.optJSONObject("itemlist") : null;
            JSONObject pageConfigObject = itemListObject != null ? itemListObject.optJSONObject("pageConfig") : null;
            JSONObject rsseResultObject = pageConfigObject != null ? pageConfigObject.optJSONObject("rsseResult") : null;
            JSONObject rsseDataObject = rsseResultObject != null ? rsseResultObject.optJSONObject("data") : null;
            SearchRsseModel searchRsseModel = null;
            if (rsseDataObject != null) {
                JSONObject $this$parseRsseData_u24lambda_u2d3 = rsseDataObject;
                searchRsseModel = new SearchRsseModel();
                String optString = $this$parseRsseData_u24lambda_u2d3.optString(SE_TYPE);
                Intrinsics.checkNotNullExpressionValue(optString, "optString(SE_TYPE)");
                searchRsseModel.setSeType(optString);
                String optString2 = $this$parseRsseData_u24lambda_u2d3.optString("ext_log");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(EXT_LOG)");
                searchRsseModel.setExtLog(optString2);
                JSONObject originObjects = $this$parseRsseData_u24lambda_u2d3.optJSONObject("origin");
                if (originObjects != null) {
                    Intrinsics.checkNotNullExpressionValue(originObjects, "originObjects");
                    JSONObject $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d0 = originObjects;
                    JSONObject jSONObject = rsseDataObject;
                    String originQuery = $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d0.optString("q");
                    Intrinsics.checkNotNullExpressionValue(originQuery, "originQuery");
                    JSONObject jSONObject2 = resultObject;
                    String herf = $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d0.optString("href");
                    Intrinsics.checkNotNullExpressionValue(herf, "herf");
                    searchRsseModel.setOrigin(new SearchRsseModel.OriginBean(originQuery, herf));
                } else {
                    JSONObject jSONObject3 = resultObject;
                }
                SearchRsseModel.ReplaceBean replaceObject = new SearchRsseModel.ReplaceBean();
                List valHighList = new ArrayList();
                JSONObject $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2 = $this$parseRsseData_u24lambda_u2d3.optJSONObject("replace");
                if ($this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2 != null) {
                    Intrinsics.checkNotNullExpressionValue($this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2, "optJSONObject(REPLACE)");
                    JSONArray optJSONArray = $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2.optJSONArray(HIGHLIGHT_INFOS_JC);
                    if (optJSONArray != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(HIGHLIGHT_INFOS_JC)");
                        JSONArray hInfoList = optJSONArray;
                        valHighList.clear();
                        int listSize2 = hInfoList.length();
                        JSONObject jSONObject4 = rootObject;
                        int i2 = 0;
                        while (true) {
                            JSONObject itemListObject2 = itemListObject;
                            listSize = listSize2;
                            if (i2 >= listSize) {
                                break;
                            }
                            listSize2 = listSize;
                            JSONObject pageConfigObject2 = pageConfigObject;
                            String wold = hInfoList.getJSONObject(i2).optString("word");
                            String type = hInfoList.getJSONObject(i2).optString("type");
                            Intrinsics.checkNotNullExpressionValue(wold, "wold");
                            Intrinsics.checkNotNullExpressionValue(type, "type");
                            valHighList.add(new SearchRsseModel.ReplaceBean.HighlightInfosJcBean(wold, type));
                            i2++;
                            itemListObject = itemListObject2;
                            pageConfigObject = pageConfigObject2;
                            hInfoList = hInfoList;
                            rsseResultObject = rsseResultObject;
                        }
                        int i3 = listSize;
                        JSONObject jSONObject5 = pageConfigObject;
                        JSONObject jSONObject6 = rsseResultObject;
                    } else {
                        JSONObject jSONObject7 = rootObject;
                        JSONObject jSONObject8 = itemListObject;
                        JSONObject jSONObject9 = pageConfigObject;
                        JSONObject jSONObject10 = rsseResultObject;
                    }
                    replaceObject.setHighlightInfosJc(valHighList);
                    String optString3 = $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2.optString("q");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(Q)");
                    replaceObject.setQ(optString3);
                    String optString4 = $this$parseRsseData_u24lambda_u2d3_u24lambda_u2d2.optString("href");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(HREF)");
                    replaceObject.setHref(optString4);
                } else {
                    JSONObject jSONObject11 = itemListObject;
                    JSONObject jSONObject12 = pageConfigObject;
                    JSONObject jSONObject13 = rsseResultObject;
                }
                searchRsseModel.setReplace(replaceObject);
            } else {
                JSONObject jSONObject14 = resultObject;
                JSONObject jSONObject15 = rootObject;
                JSONObject jSONObject16 = itemListObject;
                JSONObject jSONObject17 = pageConfigObject;
                JSONObject jSONObject18 = rsseResultObject;
            }
            return searchRsseModel;
        } catch (Exception e2) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }
}
