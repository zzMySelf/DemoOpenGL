package com.baidu.wallet.personal.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;

public class BannerList extends BannerBaseItemInfo {

    /* renamed from: android  reason: collision with root package name */
    public int f3642android;
    public String banner_no;
    public String image_url;
    public String link_url;

    public String getBanner_no() {
        return this.banner_no;
    }

    public String getLinkAddr() {
        int i2 = this.f3642android;
        return i2 != 0 ? String.valueOf(i2) : !TextUtils.isEmpty(this.link_url) ? this.link_url : "";
    }

    public String getName() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bannerid", (Object) this.banner_no);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getPicAddr() {
        return this.image_url;
    }

    public boolean getPrevlogin() {
        return false;
    }

    public String getType() {
        return this.f3642android != 0 ? "3" : !TextUtils.isEmpty(this.link_url) ? "1" : "";
    }
}
