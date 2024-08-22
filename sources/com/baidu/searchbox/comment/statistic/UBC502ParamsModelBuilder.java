package com.baidu.searchbox.comment.statistic;

public class UBC502ParamsModelBuilder {
    private String commentId;
    private String fans;
    private String friendTag;
    private String from;
    private boolean hasAt;
    private String imgRedDot;
    private String inputPlaceHolder;
    private boolean isAiImage;
    private boolean isCommentSubject;
    private String isEasterEgg;
    private boolean isVideoComment;
    private String logId;
    private String mcExt;
    private String minivideoRefreshTime;
    private String mountExt;
    private String nid;
    private String page;
    private String parentCommentId;
    private String requestId;
    private String source;
    private String topicId;
    private String type;
    private String value;
    private int videoType;

    public UBC502ParamsModelBuilder setPage(String page2) {
        this.page = page2;
        return this;
    }

    public UBC502ParamsModelBuilder setSource(String source2) {
        this.source = source2;
        return this;
    }

    public UBC502ParamsModelBuilder setValue(String value2) {
        this.value = value2;
        return this;
    }

    public UBC502ParamsModelBuilder setType(String type2) {
        this.type = type2;
        return this;
    }

    public UBC502ParamsModelBuilder setTopicId(String topicId2) {
        this.topicId = topicId2;
        return this;
    }

    public UBC502ParamsModelBuilder setLogId(String logId2) {
        this.logId = logId2;
        return this;
    }

    public UBC502ParamsModelBuilder setNid(String nid2) {
        this.nid = nid2;
        return this;
    }

    public UBC502ParamsModelBuilder setCommentId(String commentId2) {
        this.commentId = commentId2;
        return this;
    }

    public UBC502ParamsModelBuilder setRequestId(String requestId2) {
        this.requestId = requestId2;
        return this;
    }

    public UBC502ParamsModelBuilder setFans(String fans2) {
        this.fans = fans2;
        return this;
    }

    public UBC502ParamsModelBuilder setParentCommentId(String parentCommentId2) {
        this.parentCommentId = parentCommentId2;
        return this;
    }

    public UBC502ParamsModelBuilder setFriendTag(String friendTag2) {
        this.friendTag = friendTag2;
        return this;
    }

    public UBC502ParamsModelBuilder setMountExt(String mountExt2) {
        this.mountExt = mountExt2;
        return this;
    }

    public UBC502ParamsModelBuilder setMcExt(String mcExt2) {
        this.mcExt = mcExt2;
        return this;
    }

    public UBC502ParamsModelBuilder setMinivideoRefreshTime(String minivideoRefreshTime2) {
        this.minivideoRefreshTime = minivideoRefreshTime2;
        return this;
    }

    public UBC502ParamsModelBuilder setHasAt(boolean hasAt2) {
        this.hasAt = hasAt2;
        return this;
    }

    public UBC502ParamsModelBuilder setVideoComment(boolean isVideoComment2) {
        this.isVideoComment = isVideoComment2;
        return this;
    }

    public UBC502ParamsModelBuilder setVideoType(int videoType2) {
        this.videoType = videoType2;
        return this;
    }

    public UBC502ParamsModelBuilder setCommentSubject(boolean isCommentSubject2) {
        this.isCommentSubject = isCommentSubject2;
        return this;
    }

    public UBC502ParamsModelBuilder setAiImage(boolean isAiImage2) {
        this.isAiImage = isAiImage2;
        return this;
    }

    public UBC502ParamsModelBuilder setEasterEgg(String isEasterEgg2) {
        this.isEasterEgg = isEasterEgg2;
        return this;
    }

    public UBC502ParamsModelBuilder setInputPlaceHolder(String text) {
        this.inputPlaceHolder = text;
        return this;
    }

    public UBC502ParamsModelBuilder setImgRedDot(String reddot) {
        this.imgRedDot = reddot;
        return this;
    }

    public UBC502ParamsModel build() {
        UBC502ParamsModel paramsModel = new UBC502ParamsModel();
        paramsModel.setPage(this.page);
        paramsModel.setSource(this.source);
        paramsModel.setType(this.type);
        paramsModel.setValue(this.value);
        paramsModel.setTopicId(this.topicId);
        paramsModel.setLogId(this.logId);
        paramsModel.setNid(this.nid);
        paramsModel.setCommentId(this.commentId);
        paramsModel.setRequestId(this.requestId);
        paramsModel.setMcExt(this.mcExt);
        paramsModel.setMinivideoRefreshTime(this.minivideoRefreshTime);
        paramsModel.setFriendTag(this.friendTag);
        paramsModel.setParentCommentId(this.parentCommentId);
        paramsModel.setFans(this.fans);
        paramsModel.setMountExt(this.mountExt);
        paramsModel.setHasAt(this.hasAt);
        paramsModel.setCommentSubject(this.isCommentSubject);
        paramsModel.setEasterEgg(this.isEasterEgg);
        paramsModel.setVideoComment(this.isVideoComment);
        paramsModel.setAiImage(this.isAiImage);
        paramsModel.setInputPlaceHolder(this.inputPlaceHolder);
        paramsModel.setImgRedDot(this.imgRedDot);
        paramsModel.setVideoType(this.videoType);
        return paramsModel;
    }
}
