package com.baidu.poly.model;

import com.baidu.poly.util.Logger;
import com.baidu.searchbox.imagesearch.image.ImageSearchHelper;
import com.baidu.searchbox.wallet.data.WalletConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SearchBox */
public class QuerySignInfoModel {
    public String queryType;
    public String serviceType;
    public String signUserId;
    public int status;
    public List<PlatformSupportInfo> supportList;

    /* compiled from: SearchBox */
    public static class PlatformSupportInfo {
        public String groupId;
        public String logicGroupId;
        public String logicGroupName;
        public int openStatus;
        public String payChannel;
        public String payChannelName;
        public String serviceId;
        public String signUserId;
        public String signUserIdV1;
        public String signUserIdV2;
        public String subTitle;
        public String title;

        public static JSONObject parseToJSON(PlatformSupportInfo platformSupportInfo) {
            if (platformSupportInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("logicGroupId", platformSupportInfo.logicGroupId);
                jSONObject.put("logicGroupName", platformSupportInfo.logicGroupName);
                jSONObject.put("openStatus", platformSupportInfo.openStatus);
                jSONObject.put(WalletConstants.KEY_WALLET_PAY_CHANNEL, platformSupportInfo.payChannel);
                jSONObject.put("groupId", platformSupportInfo.groupId);
                jSONObject.put("title", platformSupportInfo.title);
                jSONObject.put("serviceId", platformSupportInfo.serviceId);
                jSONObject.put("payChannelName", platformSupportInfo.payChannelName);
                jSONObject.put("subTitle", platformSupportInfo.subTitle);
                jSONObject.put("signUserId", platformSupportInfo.signUserId);
            } catch (JSONException e2) {
                Logger.info("JSONException" + e2.getMessage());
            }
            return jSONObject;
        }

        public static PlatformSupportInfo parseToModel(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            PlatformSupportInfo platformSupportInfo = new PlatformSupportInfo();
            String str = "";
            platformSupportInfo.logicGroupId = jSONObject.isNull("logicGroupId") ? str : jSONObject.optString("logicGroupId");
            platformSupportInfo.logicGroupName = jSONObject.isNull("logicGroupName") ? str : jSONObject.optString("logicGroupName");
            platformSupportInfo.openStatus = jSONObject.optInt("openStatus", 0);
            platformSupportInfo.payChannel = jSONObject.isNull(WalletConstants.KEY_WALLET_PAY_CHANNEL) ? str : jSONObject.optString(WalletConstants.KEY_WALLET_PAY_CHANNEL);
            platformSupportInfo.groupId = jSONObject.isNull("groupId") ? str : jSONObject.optString("groupId");
            platformSupportInfo.title = jSONObject.isNull("title") ? str : jSONObject.optString("title");
            platformSupportInfo.serviceId = jSONObject.isNull("serviceId") ? str : jSONObject.optString("serviceId");
            platformSupportInfo.payChannelName = jSONObject.isNull("payChannelName") ? str : jSONObject.optString("payChannelName");
            platformSupportInfo.subTitle = jSONObject.isNull("subTitle") ? str : jSONObject.optString("subTitle");
            platformSupportInfo.signUserId = jSONObject.isNull("signUserId") ? str : jSONObject.optString("signUserId");
            platformSupportInfo.signUserIdV1 = jSONObject.isNull("signUserIdV1") ? str : jSONObject.optString("signUserIdV1");
            if (!jSONObject.isNull("signUserIdV2")) {
                str = jSONObject.optString("signUserIdV2");
            }
            platformSupportInfo.signUserIdV2 = str;
            return platformSupportInfo;
        }
    }

    public static JSONObject parseToJSON(QuerySignInfoModel querySignInfoModel) {
        if (querySignInfoModel == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", querySignInfoModel.status);
            jSONObject.put(ImageSearchHelper.KEY_QUERY_TYPE, querySignInfoModel.queryType);
            jSONObject.put("serviceType", querySignInfoModel.serviceType);
            jSONObject.put("signUserId", querySignInfoModel.signUserId);
            JSONArray jSONArray = new JSONArray();
            List<PlatformSupportInfo> list = querySignInfoModel.supportList;
            if (list != null && !list.isEmpty()) {
                for (PlatformSupportInfo next : querySignInfoModel.supportList) {
                    if (next != null) {
                        jSONArray.put(PlatformSupportInfo.parseToJSON(next));
                    }
                }
            }
            jSONObject.put("supportList", jSONArray);
        } catch (JSONException e2) {
            Logger.info("JSONException" + e2.getMessage());
        }
        return jSONObject;
    }

    public static QuerySignInfoModel parseToModel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        QuerySignInfoModel querySignInfoModel = new QuerySignInfoModel();
        querySignInfoModel.status = jSONObject.optInt("status", 0);
        String str = "";
        querySignInfoModel.queryType = jSONObject.isNull(ImageSearchHelper.KEY_QUERY_TYPE) ? str : jSONObject.optString(ImageSearchHelper.KEY_QUERY_TYPE);
        querySignInfoModel.serviceType = jSONObject.isNull("serviceType") ? str : jSONObject.optString("serviceType");
        if (!jSONObject.isNull("signUserId")) {
            str = jSONObject.optString("signUserId");
        }
        querySignInfoModel.signUserId = str;
        JSONArray optJSONArray = jSONObject.optJSONArray("supportList");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    arrayList.add(PlatformSupportInfo.parseToModel((JSONObject) optJSONArray.get(i2)));
                } catch (JSONException e2) {
                    Logger.info("JSONException" + e2.getMessage());
                }
            }
            querySignInfoModel.supportList = arrayList;
        }
        return querySignInfoModel;
    }
}
