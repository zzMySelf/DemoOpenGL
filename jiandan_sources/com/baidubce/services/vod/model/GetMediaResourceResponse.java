package com.baidubce.services.vod.model;

import com.alipay.sdk.m.u.h;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.model.AbstractBceResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetMediaResourceResponse extends AbstractBceResponse {
    public Attributes attributes;
    public String createTime;
    public VodError error;
    public String mediaId;
    public MediaMeta meta;
    public List<PlayableUrl> playableUrlList = new ArrayList();
    public String publishTime;
    public String source;
    public String status;
    public List<String> thumbnailList = new ArrayList();
    public String transcodingPresetGroupName;

    public static void formatJsonToObject(JSONObject jSONObject, GetMediaResourceResponse getMediaResourceResponse) {
        try {
            getMediaResourceResponse.setMediaId(jSONObject.getString("mediaId"));
            getMediaResourceResponse.setStatus(jSONObject.getString("status"));
            getMediaResourceResponse.setAttributes(Attributes.formatFromJson(jSONObject.getJSONObject("attributes")));
            getMediaResourceResponse.setMeta(MediaMeta.formatFromJson(jSONObject.getJSONObject("meta")));
            if (getMediaResourceResponse.getStatus().equalsIgnoreCase(h.f684i)) {
                getMediaResourceResponse.setError(VodError.formatFromJson(jSONObject.getJSONObject(SapiUtils.KEY_QR_LOGIN_ERROR)));
            }
            getMediaResourceResponse.setPublishTime(jSONObject.optString("publishTime"));
            getMediaResourceResponse.setCreateTime(jSONObject.getString("createTime"));
            getMediaResourceResponse.setTranscodingPresetGroupName(jSONObject.getString("transcodingPresetGroupName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("playableUrlList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(PlayableUrl.formatFromJson(optJSONArray.getJSONObject(i2)));
                }
                getMediaResourceResponse.setPlayableUrlList(arrayList);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("thumbnailList");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    arrayList2.add(optJSONArray2.getString(i3));
                }
                getMediaResourceResponse.setThumbnailList(arrayList2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public VodError getError() {
        return this.error;
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

    public void setError(VodError vodError) {
        this.error = vodError;
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
        StringBuilder sb = new StringBuilder("GetMediaResourceResponse { \n");
        sb.append("  mediaId = ");
        sb.append(this.mediaId);
        sb.append(StringUtils.LF);
        sb.append("  status = ");
        sb.append(this.status);
        sb.append(StringUtils.LF);
        sb.append("  attributes = ");
        sb.append(this.attributes);
        sb.append(StringUtils.LF);
        sb.append("  meta = ");
        sb.append(this.meta);
        sb.append(StringUtils.LF);
        sb.append("  createTime = ");
        sb.append(this.createTime);
        sb.append(StringUtils.LF);
        sb.append("  publishTime = ");
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
        VodError vodError = this.error;
        if (vodError != null) {
            sb.append(vodError);
            sb.append(StringUtils.LF);
        }
        sb.append("}\n");
        return sb.toString();
    }
}
