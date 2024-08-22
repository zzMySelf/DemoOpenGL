package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;

public class MediaMeta {
    private Long durationInSeconds;
    private Long sizeInBytes;
    private Long sourceSizeInBytes;

    public Long getSourceSizeInBytes() {
        return this.sourceSizeInBytes;
    }

    public void setSourceSizeInBytes(Long sourceSizeInBytes2) {
        this.sourceSizeInBytes = sourceSizeInBytes2;
    }

    public Long getSizeInBytes() {
        return this.sizeInBytes;
    }

    public void setSizeInBytes(Long sizeInBytes2) {
        this.sizeInBytes = sizeInBytes2;
    }

    public Long getDurationInSeconds() {
        return this.durationInSeconds;
    }

    public void setDurationInSeconds(Long durationInSeconds2) {
        this.durationInSeconds = durationInSeconds2;
    }

    public static MediaMeta formatFromJson(JSONObject json) throws JSONException {
        MediaMeta mediaMeta = new MediaMeta();
        mediaMeta.setSourceSizeInBytes(Long.valueOf(json.optLong("sourceSizeInBytes")));
        mediaMeta.setSizeInBytes(Long.valueOf(json.optLong("sizeInBytes")));
        mediaMeta.setDurationInSeconds(Long.valueOf(json.optLong("durationInSeconds")));
        return mediaMeta;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaMeta { \n");
        sb.append("      sizeInBytes = ").append(this.sizeInBytes).append("\n");
        sb.append("      durationInSeconds = ").append(this.durationInSeconds).append("\n");
        sb.append("    }");
        return sb.toString();
    }
}
