package com.baidu.nadcore.charge;

import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.searchbox.ad.crius.model.CriusBaseModel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AdAreaInfo {
    public Map<String, String> mAreaChargeMap;
    public Map<String, String> mAreaCmdMap;
    public Map<String, String> mChargeMap;
    public JSONObject mCmdJson;
    public Map<String, String> mCmdMap;
    public Map<String, String> mDeferChargeMap;

    public static AdAreaInfo fromJson(JSONObject info) {
        AdAreaInfo adAreaInfo = new AdAreaInfo();
        JSONObject optJSONObject = info.optJSONObject(CriusBaseModel.KEY_CMD_MAP);
        adAreaInfo.mCmdJson = optJSONObject;
        adAreaInfo.mCmdMap = JSONUtils.json2Map(optJSONObject);
        adAreaInfo.mAreaCmdMap = JSONUtils.json2Map(info.optJSONObject("area_cmd"));
        adAreaInfo.mChargeMap = JSONUtils.json2Map(info.optJSONObject("charge_map"));
        adAreaInfo.mAreaChargeMap = JSONUtils.json2Map(info.optJSONObject("parallel_charge_urls"));
        adAreaInfo.mDeferChargeMap = JSONUtils.json2Map(info.optJSONObject("defer_charge_urls"));
        return adAreaInfo;
    }

    public static AdAreaInfo fromMap(HashMap<String, ?> info) {
        AdAreaInfo adAreaInfo = new AdAreaInfo();
        if (info.get(CriusBaseModel.KEY_CMD_MAP) instanceof String) {
            JSONObject newJSONObject = JSONUtils.newJSONObject((String) info.get(CriusBaseModel.KEY_CMD_MAP));
            adAreaInfo.mCmdJson = newJSONObject;
            adAreaInfo.mCmdMap = JSONUtils.json2Map(newJSONObject);
        }
        if (info.get("area_cmd") instanceof String) {
            adAreaInfo.mAreaCmdMap = JSONUtils.json2Map(JSONUtils.newJSONObject((String) info.get("area_cmd")));
        }
        if (info.get("charge_map") instanceof String) {
            adAreaInfo.mChargeMap = JSONUtils.json2Map(JSONUtils.newJSONObject((String) info.get("charge_map")));
        }
        if (info.get("parallel_charge_urls") instanceof JSONObject) {
            adAreaInfo.mAreaChargeMap = JSONUtils.json2Map((JSONObject) info.get("parallel_charge_urls"));
        }
        if (info.get("defer_charge_urls") instanceof JSONObject) {
            adAreaInfo.mDeferChargeMap = JSONUtils.json2Map((JSONObject) info.get("defer_charge_urls"));
        }
        return adAreaInfo;
    }

    public static void toJson(AdAreaInfo info, JSONObject oriJson) {
        if (info != null && oriJson != null) {
            try {
                JSONObject jSONObject = info.mCmdJson;
                if (jSONObject != null) {
                    oriJson.put(CriusBaseModel.KEY_CMD_MAP, jSONObject);
                }
                Map<String, String> map = info.mAreaCmdMap;
                if (map != null) {
                    oriJson.put("area_cmd", JSONUtils.map2Json(map));
                }
                Map<String, String> map2 = info.mChargeMap;
                if (map2 != null) {
                    oriJson.put("charge_map", JSONUtils.map2Json(map2));
                }
                Map<String, String> map3 = info.mAreaChargeMap;
                if (map3 != null) {
                    oriJson.put("parallel_charge_urls", JSONUtils.map2Json(map3));
                }
                Map<String, String> map4 = info.mDeferChargeMap;
                if (map4 != null) {
                    oriJson.put("defer_charge_urls", JSONUtils.map2Json(map4));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
