package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
import org.apache.commons.lang3.StringUtils;

public class GenerateMediaIdResponse extends AbstractBceResponse {
    public String mediaId;
    public String sourceBucket;
    public String sourceKey;

    public String getMediaId() {
        return this.mediaId;
    }

    public String getSourceBucket() {
        return this.sourceBucket;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setSourceBucket(String str) {
        this.sourceBucket = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public String toString() {
        return "GenerateMediaIdResponse { \n" + "  mediaId = " + this.mediaId + StringUtils.LF + "  sourceBucket = " + this.sourceBucket + StringUtils.LF + "  sourceKey = " + this.sourceKey + StringUtils.LF + "}\n";
    }
}
