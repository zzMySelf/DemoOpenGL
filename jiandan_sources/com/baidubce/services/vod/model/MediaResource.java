package com.baidubce.services.vod.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class MediaResource {
    public Attributes attributes;
    public String createTime;
    public String mediaId;
    public MediaMeta meta;
    public List<PlayableUrl> playableUrlList = new ArrayList();
    public String publishTime;
    public String source;
    public String status;
    public List<String> thumbnailList = new ArrayList();
    public String transcodingPresetGroupName;

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public MediaMeta getMeta() {
        return this.meta;
    }

    public List<PlayableUrl> getPlayableUrlList() {
        return this.playableUrlList;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public List<String> getThumbnailList() {
        return this.thumbnailList;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setAttributes(Attributes attributes2) {
        this.attributes = attributes2;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMeta(MediaMeta mediaMeta) {
        this.meta = mediaMeta;
    }

    public void setPlayableUrlList(List<PlayableUrl> list) {
        this.playableUrlList = list;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setThumbnailList(List<String> list) {
        this.thumbnailList = list;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  MediaResource { \n");
        sb.append("    mediaId = ");
        sb.append(this.mediaId);
        sb.append(StringUtils.LF);
        sb.append("    status = ");
        sb.append(this.status);
        sb.append(StringUtils.LF);
        sb.append("    attributes = ");
        sb.append(this.attributes);
        sb.append(StringUtils.LF);
        sb.append("    meta = ");
        sb.append(this.meta);
        sb.append(StringUtils.LF);
        sb.append("    createTime = ");
        sb.append(this.createTime);
        sb.append(StringUtils.LF);
        sb.append("    publishTime = ");
        sb.append(this.publishTime);
        sb.append(StringUtils.LF);
        sb.append("  transcodingPresetGroupName = ");
        sb.append(this.transcodingPresetGroupName);
        sb.append(StringUtils.LF);
        sb.append("  source = ");
        sb.append(this.source);
        sb.append(StringUtils.LF);
        sb.append("  playableUrlList = [");
        sb.append(StringUtils.LF);
        for (PlayableUrl playableUrl : this.playableUrlList) {
            sb.append(playableUrl.toString());
            sb.append(StringUtils.LF);
        }
        sb.append("] \n");
        sb.append("  thumbnailList = [");
        sb.append(StringUtils.LF);
        for (String append : this.thumbnailList) {
            sb.append("    thumbnail =");
            sb.append(append);
            sb.append(StringUtils.LF);
        }
        sb.append("  }\n");
        return sb.toString();
    }
}
