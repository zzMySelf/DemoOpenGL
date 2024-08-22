package com.baidu.searchbox.follow.followaddrlist.data;

import com.baidu.netdisk.account.storage.AccountContract;
import org.json.JSONObject;

public class TopicModel {
    private String cmd;
    private Config config;
    private String dataSign;
    private String discussNum;
    private String id;
    private String intro;
    private boolean isDisplayed = false;
    private String isFollow;
    private String logoUrl;
    private String readNum;
    private String thirdId;
    private String title;
    private String totalTopicNum;
    private String type;

    public static class Config {
        public static final int VIEW_TYPE_FOOTER = 2;
        public static final int VIEW_TYPE_HEADER = 1;
        public static final int VIEW_TYPE_NORMAL = 0;
        public int viewType = 0;
    }

    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    public void setDisplayed(boolean displayed) {
        this.isDisplayed = displayed;
    }

    public String getTotalTopicNum() {
        return this.totalTopicNum;
    }

    public void setTotalTopicNum(String totalTopicNum2) {
        this.totalTopicNum = totalTopicNum2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getThirdId() {
        return this.thirdId;
    }

    public void setThirdId(String thirdId2) {
        this.thirdId = thirdId2;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String intro2) {
        this.intro = intro2;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl2) {
        this.logoUrl = logoUrl2;
    }

    public String getIsFollow() {
        return this.isFollow;
    }

    public void setIsFollow(String isFollow2) {
        this.isFollow = isFollow2;
    }

    public String getReadNum() {
        return this.readNum;
    }

    public void setReadNum(String readNum2) {
        this.readNum = readNum2;
    }

    public String getDiscussNum() {
        return this.discussNum;
    }

    public void setDiscussNum(String discussNum2) {
        this.discussNum = discussNum2;
    }

    public String getDataSign() {
        return this.dataSign;
    }

    public void setDataSign(String dataSign2) {
        this.dataSign = dataSign2;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String cmd2) {
        this.cmd = cmd2;
    }

    public Config getConfig() {
        return this.config;
    }

    public void setConfig(int viewType) {
        Config config2 = new Config();
        config2.viewType = viewType;
        this.config = config2;
    }

    public static TopicModel parseModelData(JSONObject json) {
        if (json == null) {
            return null;
        }
        TopicModel model = new TopicModel();
        model.setTitle(json.optString("title"));
        model.setType(json.optString("type"));
        model.setThirdId(json.optString("third_id"));
        model.setId(model.getType() + "_" + model.getThirdId());
        model.setIntro(json.optString(AccountContract.InfosColumns.CLOUD_INTRO));
        model.setCmd(json.optString("cmd"));
        model.setLogoUrl(json.optString("logo_url"));
        model.setIsFollow(json.optString("is_follow"));
        model.setReadNum(json.optString("read_num"));
        model.setDiscussNum(json.optString("discuss_num"));
        model.setDataSign(json.optString("data_sign"));
        return model;
    }
}
