package com.baidubce.services.vod.model;

import androidx.biometric.BiometricPrompt;
import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class ProcessMediaRequest extends VodBceRequest {
    public String description;
    public String mediaId;
    public String sourceExtension;
    public String title;
    public String transcodingPresetGroupName;

    public String getDescription() {
        return this.description;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mediaId", this.mediaId);
            jSONObject.put("title", this.title);
            jSONObject.put(BiometricPrompt.KEY_DESCRIPTION, this.description);
            jSONObject.put("sourceExtension", this.sourceExtension);
            jSONObject.put("transcodingPresetGroupName", this.transcodingPresetGroupName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ProcessMediaRequest { \n" + "  mediaId = " + this.mediaId + StringUtils.LF + "  title = " + this.title + StringUtils.LF + "  description = " + this.description + StringUtils.LF + "  sourceExtension = " + this.sourceExtension + StringUtils.LF + "}\n";
    }

    public ProcessMediaRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ProcessMediaRequest withMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public ProcessMediaRequest withSourceExtension(String str) {
        this.sourceExtension = str;
        return this;
    }

    public ProcessMediaRequest withTitle(String str) {
        this.title = str;
        return this;
    }

    public ProcessMediaRequest withTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
        return this;
    }
}
