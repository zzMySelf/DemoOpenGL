package com.baidu.lcp.sdk.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import fe.fe.p004if.qw.rg.qw;
import fe.fe.p004if.qw.yj.ad;
import fe.fe.p004if.qw.yj.de;
import fe.fe.p004if.qw.yj.fe;
import fe.fe.p004if.qw.yj.rg;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetTokenRequest extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public TokenResponseListener f878ad;

    public interface TokenResponseListener {
        void onFailure(int i2, String str);

        void qw(String str);
    }

    public GetTokenRequest(Context context, TokenResponseListener tokenResponseListener) {
        this.qw = context;
        this.f878ad = tokenResponseListener;
    }

    public String ad() {
        int qw = de.qw(this.qw);
        if (qw == 1) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/" + "rest/5.0/generate_lcm_token";
        } else if (qw == 2) {
            return "http://sz-shaheenv-al-b.bcc-szwg.baidu.com:8911/" + "rest/5.0/generate_lcm_token";
        } else if (de.ad(this.qw)) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/" + "rest/5.0/generate_lcm_token";
        } else {
            return "https://pim.baidu.com/" + "rest/5.0/generate_lcm_token";
        }
    }

    public void de(byte[] bArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            fe.qw("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
            int optInt = jSONObject2.optInt(WXLoginActivity.y, -1);
            String optString = jSONObject2.optString("error_msg", "");
            if (optInt == 0) {
                rg.xxx(this.qw, jSONObject2.optBoolean("bddns_enable", false));
                String optString2 = jSONObject2.optString("token");
                JSONArray jSONArray = jSONObject2.getJSONArray("protocols");
                if (!TextUtils.isEmpty(optString2) && jSONArray != null) {
                    if (jSONArray.length() >= 1) {
                        rg.aaa(this.qw, jSONArray.length());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                            rg.mmm(this.qw, jSONObject3.optString("protocol") + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT), i2);
                        }
                        rg.nn(this.qw, jSONObject2.optInt("ipv6_strategy", 3));
                        this.f878ad.qw(optString2);
                        rg.eee(this.qw, optString2);
                        try {
                            String optString3 = jSONObject2.optString("client_log_config", "");
                            if (!TextUtils.isEmpty(optString3)) {
                                JSONObject jSONObject4 = new JSONObject(optString3);
                                fe.fe.p004if.qw.qw.fe.ddd(this.qw, jSONObject4.optInt("client_upload_log_switch", 0));
                                JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                                if (jSONArray2 == null) {
                                    return;
                                }
                                if (jSONArray2.length() > 0) {
                                    int i3 = 0;
                                    while (i3 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i3)) != null) {
                                        fe.fe.p004if.qw.qw.fe.ggg(this.qw, jSONObject.optInt("id", 0), jSONObject.optInt("switch", 0));
                                        i3++;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            fe.ad("GetTokenRequest", "Json Exception");
                            return;
                        }
                    }
                }
                this.f878ad.onFailure(10002, "token or protocol is empty");
                return;
            }
            this.f878ad.onFailure(optInt, optString);
        } catch (JSONException e) {
            TokenResponseListener tokenResponseListener = this.f878ad;
            tokenResponseListener.onFailure(10001, "parse response exception ：" + e);
        }
    }

    public byte[] fe() {
        try {
            JSONObject jSONObject = (JSONObject) ad.de(this.qw, true);
            return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public String getMediaType() {
        return "application/json";
    }

    public void onFailure(int i2, String str) {
        this.f878ad.onFailure(i2, str);
    }

    public Map<String, String> qw() {
        return null;
    }
}
