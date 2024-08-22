package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import org.apache.commons.lang3.StringUtils;

public class GetMediaResourceRequest extends VodBceRequest {
    public String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String toJsonString() {
        return "";
    }

    public String toString() {
        return "GetMediaResourceRequest { \n" + "  mediaId = " + this.mediaId + StringUtils.LF + "}\n";
    }

    public GetMediaResourceRequest withMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
