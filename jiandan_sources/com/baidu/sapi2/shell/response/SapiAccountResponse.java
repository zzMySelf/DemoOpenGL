package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class SapiAccountResponse extends SapiResponse {
    public AccountType accountType = AccountType.UNKNOWN;
    public String actionType;
    public String app;
    public String authSid;
    public String bduss = "";
    public String displayname = "";
    public String email = "";
    public String extra;
    public FromType fromType = FromType.LOGIN;
    public String isGuestAccount = "";
    public String livingUname;
    public boolean newReg;
    public String openid;
    public String portraitSign;
    public String ptoken = "";
    public String socialNickname;
    public String socialPortraitUrl = "";
    public SocialType socialType = SocialType.UNKNOWN;
    public String stoken = "";
    public Map<String, String> tplStokenMap = new HashMap();
    public String uid = "";
    public String username = "";

    public String toString() {
        return "SapiAccountResponse{bduss='" + this.bduss + ExtendedMessageFormat.QUOTE + ", ptoken='" + this.ptoken + ExtendedMessageFormat.QUOTE + ", stoken='" + this.stoken + ExtendedMessageFormat.QUOTE + ", displayname='" + this.displayname + ExtendedMessageFormat.QUOTE + ", username='" + this.username + ExtendedMessageFormat.QUOTE + ", email='" + this.email + ExtendedMessageFormat.QUOTE + ", uid='" + this.uid + ExtendedMessageFormat.QUOTE + ", portraitSign='" + this.portraitSign + ExtendedMessageFormat.QUOTE + ", newReg=" + this.newReg + ", authSid='" + this.authSid + ExtendedMessageFormat.QUOTE + ", socialPortraitUrl='" + this.socialPortraitUrl + ExtendedMessageFormat.QUOTE + ", socialNickname='" + this.socialNickname + ExtendedMessageFormat.QUOTE + ", socialType=" + this.socialType + ", actionType='" + this.actionType + ExtendedMessageFormat.QUOTE + ", isGuestAccount='" + this.isGuestAccount + ExtendedMessageFormat.QUOTE + ", livingUname='" + this.livingUname + ExtendedMessageFormat.QUOTE + ", app='" + this.app + ExtendedMessageFormat.QUOTE + ", extra='" + this.extra + ExtendedMessageFormat.QUOTE + ", accountType=" + this.accountType + ", fromType=" + this.fromType + ", tplStokenMap=" + this.tplStokenMap + ExtendedMessageFormat.END_FE;
    }
}
