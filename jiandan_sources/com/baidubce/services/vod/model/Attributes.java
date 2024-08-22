package com.baidubce.services.vod.model;

import androidx.biometric.BiometricPrompt;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Attributes {
    public String description;
    public String sourceExtension;
    public String title;

    public static Attributes formatFromJson(JSONObject jSONObject) throws JSONException {
        Attributes attributes = new Attributes();
        attributes.setTitle(jSONObject.optString("title"));
        attributes.setDescription(jSONObject.optString(BiometricPrompt.KEY_DESCRIPTION));
        return attributes;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Attributes { \n" + "      title = " + this.title + StringUtils.LF + "      description = " + this.description + StringUtils.LF + "      sourceExtension = " + this.sourceExtension + StringUtils.LF + "    }";
    }
}
