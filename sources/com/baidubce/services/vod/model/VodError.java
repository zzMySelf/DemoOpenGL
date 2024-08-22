package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;

public class VodError {
    private String code = null;
    private String message = null;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code2) {
        this.code = code2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }

    public static VodError formatFromJson(JSONObject json) throws JSONException {
        VodError vodError = new VodError();
        vodError.setCode(json.getString("code"));
        vodError.setMessage(json.optString("message"));
        return vodError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VodError {\n");
        sb.append("    code: ").append(this.code).append("\n");
        sb.append("    message: ").append(this.message).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
