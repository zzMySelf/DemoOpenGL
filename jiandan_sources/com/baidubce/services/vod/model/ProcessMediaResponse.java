package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ProcessMediaResponse extends AbstractBceResponse {
    public String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String toString() {
        return "ProcessMediaResponse {" + "mediaId='" + this.mediaId + ExtendedMessageFormat.QUOTE + "}\n";
    }
}
