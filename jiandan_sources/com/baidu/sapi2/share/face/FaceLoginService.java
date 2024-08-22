package com.baidu.sapi2.share.face;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import fe.fe.ppp.ad.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceLoginService {
    public static final int FACE_SHARE_V2_MAX_ACCOUNT_SIZE = 10;
    public static final String KEY_FACE_LOGIN_LIVINGUNAMES = "livingunames";
    public static final String KEY_SHARE_FACE_LOGIN_V2 = "face_login_model_v2";
    public static final String TAG = "FaceLoginService";
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    private String buildV2FaceUidString(Map<String, Long> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_FACE_LOGIN_LIVINGUNAMES, SapiUtils.map2JsonArray(map, "livinguname", "time"));
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private Map<String, Long> getLinkedHashMap(List<FaceLoginModel> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            Collections.sort(list);
            for (FaceLoginModel next : list) {
                if (!linkedHashMap.containsKey(next.livingUname)) {
                    linkedHashMap.put(next.livingUname, Long.valueOf(next.time));
                }
            }
            if (linkedHashMap.size() > 10) {
                Iterator it = linkedHashMap.entrySet().iterator();
                int size = linkedHashMap.size() - 10;
                int i2 = 0;
                while (it.hasNext() && i2 < size) {
                    it.next();
                    it.remove();
                    i2++;
                }
            }
        }
        return linkedHashMap;
    }

    private List<FaceLoginModel> getUidsFromV2ShareStorage() {
        ArrayList arrayList = new ArrayList();
        if (!SapiContext.getInstance().shareLivingunameEnable()) {
            return arrayList;
        }
        List<String> installedApps = ShareUtils.getInstalledApps(this.context);
        if (installedApps.isEmpty()) {
            return arrayList;
        }
        ShareStorage shareStorage = new ShareStorage();
        for (String sp : installedApps) {
            arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(sp, KEY_SHARE_FACE_LOGIN_V2)));
        }
        arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(ad.rg(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false))));
        return arrayList;
    }

    private List<FaceLoginModel> getUidsMapFromV2PriStrage() {
        return str2ShareModelV2List(SapiContext.getInstance().getV2FaceLivingUnames());
    }

    private void setV2ShareFaceUids(String str) {
        if (!SapiContext.getInstance().getShareCommonStorageEnabel() || TextUtils.isEmpty(str) || !SapiContext.getInstance().shareLivingunameEnable()) {
            Log.i(TAG, "setV2ShareFaceUids false");
            return;
        }
        ShareStorage shareStorage = new ShareStorage();
        shareStorage.setSp(KEY_SHARE_FACE_LOGIN_V2, str);
        shareStorage.setSd(ad.rg(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false), str);
    }

    public boolean isSupFaceLogin() {
        JSONObject v2FaceLoginCheckResults = SapiContext.getInstance().getV2FaceLoginCheckResults();
        return v2FaceLoginCheckResults != null && v2FaceLoginCheckResults.has("list") && v2FaceLoginCheckResults.optJSONArray("list").length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
    }

    public List<FaceLoginModel> str2ShareModelV2List(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_FACE_LOGIN_LIVINGUNAMES);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("livinguname");
                    long optLong = optJSONObject.optLong("time", 0);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(new FaceLoginModel(optString, optLong));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void syncFaceLoginUID(Context context2, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new FaceLoginModel(str, System.currentTimeMillis()));
        }
        syncFaceLoginUidList(context2, arrayList);
    }

    public void syncFaceLoginUidList(Context context2, List<FaceLoginModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.addAll(getUidsMapFromV2PriStrage());
        arrayList.addAll(getUidsFromV2ShareStorage());
        Map<String, Long> linkedHashMap = getLinkedHashMap(arrayList);
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (String next : linkedHashMap.keySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("livinguname", next);
                jSONObject2.put("time", linkedHashMap.get(next));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException e) {
            Log.i(e);
        }
        String buildV2FaceUidString = buildV2FaceUidString(linkedHashMap);
        setV2ShareFaceUids(buildV2FaceUidString);
        SapiContext.getInstance().setV2FaceLivingunames(buildV2FaceUidString);
        SapiContext.getInstance().setV2FaceLoginCheckResults(jSONObject.toString());
    }
}
