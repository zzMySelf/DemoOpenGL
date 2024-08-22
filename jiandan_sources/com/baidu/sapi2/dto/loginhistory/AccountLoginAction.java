package com.baidu.sapi2.dto.loginhistory;

import com.baidu.sapi2.SapiAccount;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountLoginAction {
    public long loginTimeSecond;
    public SapiAccount sapiAccount;

    public AccountLoginAction() {
    }

    public static JSONObject convertAction2Json(AccountLoginAction accountLoginAction) {
        if (accountLoginAction == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("loginTimeSecond", accountLoginAction.loginTimeSecond);
            jSONObject.put("sapiAccount", accountLoginAction.sapiAccount.toJSONObject());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertActionList2Json(List<AccountLoginAction> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            JSONObject convertAction2Json = convertAction2Json(list.get(i2));
            if (convertAction2Json != null) {
                jSONArray.put(convertAction2Json);
            }
        }
        return jSONArray.toString();
    }

    public static AccountLoginAction convertJson2Action(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("loginTimeSecond");
        SapiAccount fromJSONObject = SapiAccount.fromJSONObject(jSONObject.optJSONObject("sapiAccount"));
        if (fromJSONObject != null) {
            return new AccountLoginAction(optLong, fromJSONObject);
        }
        return null;
    }

    public static List<AccountLoginAction> convertJson2ActionList(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            AccountLoginAction accountLoginAction = null;
            try {
                accountLoginAction = convertJson2Action(jSONArray.getJSONObject(i2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (accountLoginAction != null) {
                arrayList.add(accountLoginAction);
            }
        }
        return arrayList;
    }

    public AccountLoginAction(long j, SapiAccount sapiAccount2) {
        this.loginTimeSecond = j;
        this.sapiAccount = sapiAccount2;
    }
}
