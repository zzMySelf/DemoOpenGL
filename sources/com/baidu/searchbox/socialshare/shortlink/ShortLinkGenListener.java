package com.baidu.searchbox.socialshare.shortlink;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ShortLinkGenListener extends ResponseCallback<JSONObject> {
    private String mOriginURL = "";

    public abstract void onDelieverShortLink(String str, String str2, boolean z);

    public ShortLinkGenListener(String originalURL) {
        this.mOriginURL = originalURL;
    }

    public JSONObject parseResponse(Response var1, int var2) throws Exception {
        String result;
        if (var1 == null || !var1.isSuccessful() || var1.body() == null || (result = var1.body().string().trim()) == null || !result.startsWith("{")) {
            return null;
        }
        return new JSONObject(result);
    }

    public void onSuccess(JSONObject responseBody, int var2) {
        if (responseBody == null) {
            onDelieverShortLink(this.mOriginURL, "", false);
            return;
        }
        try {
            JSONObject data = responseBody.getJSONObject("data");
            if (data == null) {
                onDelieverShortLink(this.mOriginURL, "", false);
                return;
            }
            String shortURL = data.getString("https_url");
            if (TextUtils.isEmpty(shortURL)) {
                shortURL = this.mOriginURL;
            }
            String iconURL = data.optString("icon");
            if (TextUtils.isEmpty(iconURL)) {
                iconURL = "";
            }
            onDelieverShortLink(shortURL, iconURL, true);
        } catch (JSONException e2) {
            onDelieverShortLink(this.mOriginURL, "", false);
        }
    }

    public void onFail(Exception var1) {
        onDelieverShortLink(this.mOriginURL, "", false);
    }
}
