package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.wallet.paysdk.datamodel.Bank;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class SocialResponse extends SapiAccountResponse {
    public boolean accountCenterFlag = false;
    public String baiduUname = "";
    public boolean bindConflict;
    public boolean bindGuide = false;
    public boolean isBinded = false;
    public String message;
    public String nextUrl;
    public boolean offlineNotice = false;
    public String socialUname = "";
    public String userInfoXmlContent;

    public static SocialResponse fromJSONObject(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        SocialResponse socialResponse = new SocialResponse();
        socialResponse.errorCode = jSONObject.optInt("errno");
        socialResponse.errorMsg = jSONObject.optString("errmsg");
        socialResponse.message = jSONObject.optString("message");
        socialResponse.livingUname = jSONObject.optString("livinguname");
        socialResponse.socialType = SocialType.getSocialType(jSONObject.optInt("os_type"));
        socialResponse.bduss = jSONObject.optString("bduss");
        socialResponse.socialPortraitUrl = jSONObject.optString("os_headurl");
        socialResponse.openid = jSONObject.optString("os_openid");
        socialResponse.socialNickname = jSONObject.optString("os_name");
        String optString = jSONObject.optString("incomplete_user");
        if ("0".equals(optString)) {
            socialResponse.accountType = AccountType.NORMAL;
        } else if ("1".equals(optString)) {
            socialResponse.accountType = AccountType.INCOMPLETE_USER;
        } else {
            socialResponse.accountType = AccountType.UNKNOWN;
        }
        socialResponse.uid = jSONObject.optString("bduid");
        socialResponse.isBinded = jSONObject.optBoolean("is_binded");
        socialResponse.displayname = jSONObject.optString("display_name");
        socialResponse.username = jSONObject.optString("passport_uname");
        socialResponse.ptoken = jSONObject.optString("ptoken");
        socialResponse.stoken = jSONObject.optString("stoken");
        JSONObject optJSONObject = jSONObject.optJSONObject("stoken_list");
        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("stoken")) == null)) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String[] split = optJSONArray.optString(i2).split(Bank.HOT_BANK_LETTER);
                if (split != null && split.length > 1) {
                    socialResponse.tplStokenMap.put(split[0], split[1]);
                }
            }
        }
        socialResponse.isGuestAccount = jSONObject.optString("guest_account");
        socialResponse.nextUrl = jSONObject.optString("next_url");
        socialResponse.userInfoXmlContent = jSONObject.optString("userInfoXmlContent");
        return socialResponse;
    }

    public String toString() {
        return "SocialResponse{isBinded=" + this.isBinded + ", baiduUname='" + this.baiduUname + ExtendedMessageFormat.QUOTE + ", socialUname='" + this.socialUname + ExtendedMessageFormat.QUOTE + ", bindGuide=" + this.bindGuide + ", offlineNotice=" + this.offlineNotice + ", bindConflict=" + this.bindConflict + ", accountCenterFlag=" + this.accountCenterFlag + ", nextUrl='" + this.nextUrl + ExtendedMessageFormat.QUOTE + ", userInfoXmlContent='" + this.userInfoXmlContent + ExtendedMessageFormat.QUOTE + ", bduss='" + this.bduss + ExtendedMessageFormat.QUOTE + ", ptoken='" + this.ptoken + ExtendedMessageFormat.QUOTE + ", stoken='" + this.stoken + ExtendedMessageFormat.QUOTE + ", displayname='" + this.displayname + ExtendedMessageFormat.QUOTE + ", username='" + this.username + ExtendedMessageFormat.QUOTE + ", email='" + this.email + ExtendedMessageFormat.QUOTE + ", uid='" + this.uid + ExtendedMessageFormat.QUOTE + ", portraitSign='" + this.portraitSign + ExtendedMessageFormat.QUOTE + ", newReg=" + this.newReg + ", authSid='" + this.authSid + ExtendedMessageFormat.QUOTE + ", socialPortraitUrl='" + this.socialPortraitUrl + ExtendedMessageFormat.QUOTE + ", socialType=" + this.socialType + ", actionType='" + this.actionType + ExtendedMessageFormat.QUOTE + ", isGuestAccount='" + this.isGuestAccount + ExtendedMessageFormat.QUOTE + ", livingUname='" + this.livingUname + ExtendedMessageFormat.QUOTE + ", app='" + this.app + ExtendedMessageFormat.QUOTE + ", extra='" + this.extra + ExtendedMessageFormat.QUOTE + ", accountType=" + this.accountType + ", fromType=" + this.fromType + ", tplStokenMap=" + this.tplStokenMap + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
