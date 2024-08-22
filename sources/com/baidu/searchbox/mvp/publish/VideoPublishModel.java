package com.baidu.searchbox.mvp.publish;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ugc.model.MvpTask;
import com.baidu.searchbox.ugc.model.TiaoZhanInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\b¨\u00066"}, d2 = {"Lcom/baidu/searchbox/mvp/publish/VideoPublishModel;", "Lcom/baidu/searchbox/NoProGuard;", "()V", "aiStyleId", "", "getAiStyleId", "()Ljava/lang/String;", "setAiStyleId", "(Ljava/lang/String;)V", "campaignInfo", "getCampaignInfo", "setCampaignInfo", "cardId", "getCardId", "setCardId", "cardType", "getCardType", "setCardType", "coverPath", "getCoverPath", "setCoverPath", "coverUrl", "getCoverUrl", "setCoverUrl", "isFromAiCard", "", "()Ljava/lang/Boolean;", "setFromAiCard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mvpTask", "Lcom/baidu/searchbox/ugc/model/MvpTask;", "getMvpTask", "()Lcom/baidu/searchbox/ugc/model/MvpTask;", "setMvpTask", "(Lcom/baidu/searchbox/ugc/model/MvpTask;)V", "tiaozhanInfo", "Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "getTiaozhanInfo", "()Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "setTiaozhanInfo", "(Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;)V", "title", "getTitle", "setTitle", "topicInfo", "getTopicInfo", "setTopicInfo", "uniqueId", "getUniqueId", "setUniqueId", "videoPath", "getVideoPath", "setVideoPath", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPublishModel.kt */
public final class VideoPublishModel implements NoProGuard {
    private String aiStyleId;
    private String campaignInfo;
    private String cardId;
    private String cardType;
    private String coverPath;
    private String coverUrl;
    private Boolean isFromAiCard = false;
    private MvpTask mvpTask;
    private TiaoZhanInfo tiaozhanInfo;
    private String title;
    private String topicInfo;
    private String uniqueId;
    private String videoPath;

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final void setVideoPath(String str) {
        this.videoPath = str;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        this.coverPath = str;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getTopicInfo() {
        return this.topicInfo;
    }

    public final void setTopicInfo(String str) {
        this.topicInfo = str;
    }

    public final TiaoZhanInfo getTiaozhanInfo() {
        return this.tiaozhanInfo;
    }

    public final void setTiaozhanInfo(TiaoZhanInfo tiaoZhanInfo) {
        this.tiaozhanInfo = tiaoZhanInfo;
    }

    public final String getAiStyleId() {
        return this.aiStyleId;
    }

    public final void setAiStyleId(String str) {
        this.aiStyleId = str;
    }

    public final Boolean isFromAiCard() {
        return this.isFromAiCard;
    }

    public final void setFromAiCard(Boolean bool) {
        this.isFromAiCard = bool;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        this.cardId = str;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public final String getCampaignInfo() {
        return this.campaignInfo;
    }

    public final void setCampaignInfo(String str) {
        this.campaignInfo = str;
    }

    public final MvpTask getMvpTask() {
        return this.mvpTask;
    }

    public final void setMvpTask(MvpTask mvpTask2) {
        this.mvpTask = mvpTask2;
    }
}
