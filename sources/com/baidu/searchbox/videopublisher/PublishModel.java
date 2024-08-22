package com.baidu.searchbox.videopublisher;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ugc.model.MvpTask;
import com.baidu.searchbox.ugc.model.ProgressBarConfigModel;
import com.baidu.searchbox.ugc.model.TiaoZhanInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bT\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¢\u0002\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\u00182\b\u0010q\u001a\u0004\u0018\u00010rHÖ\u0003J\t\u0010s\u001a\u00020tHÖ\u0001J\t\u0010u\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b\u0017\u00107\"\u0004\b8\u00109R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010\"R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010 \"\u0004\bV\u0010\"¨\u0006v"}, d2 = {"Lcom/baidu/searchbox/videopublisher/PublishModel;", "Lcom/baidu/searchbox/NoProGuard;", "videoPath", "", "coverPath", "videoMedia", "coverUrl", "title", "position", "goodsList", "groupInfo", "campaignInfo", "topicInfo", "activityList", "announceOriginal", "progressBarConfigModel", "Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;", "mountList", "taskOrigin", "tiaozhanInfo", "Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "aiStyleId", "businessId", "isFromAiCard", "", "cardType", "cardId", "uniqueId", "mvpTask", "Lcom/baidu/searchbox/ugc/model/MvpTask;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/MvpTask;)V", "getActivityList", "()Ljava/lang/String;", "setActivityList", "(Ljava/lang/String;)V", "getAiStyleId", "setAiStyleId", "getAnnounceOriginal", "setAnnounceOriginal", "getBusinessId", "setBusinessId", "getCampaignInfo", "setCampaignInfo", "getCardId", "setCardId", "getCardType", "setCardType", "getCoverPath", "setCoverPath", "getCoverUrl", "setCoverUrl", "getGoodsList", "setGoodsList", "getGroupInfo", "setGroupInfo", "()Ljava/lang/Boolean;", "setFromAiCard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMountList", "setMountList", "getMvpTask", "()Lcom/baidu/searchbox/ugc/model/MvpTask;", "setMvpTask", "(Lcom/baidu/searchbox/ugc/model/MvpTask;)V", "getPosition", "setPosition", "getProgressBarConfigModel", "()Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;", "setProgressBarConfigModel", "(Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;)V", "getTaskOrigin", "setTaskOrigin", "getTiaozhanInfo", "()Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "setTiaozhanInfo", "(Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;)V", "getTitle", "setTitle", "getTopicInfo", "setTopicInfo", "getUniqueId", "setUniqueId", "getVideoMedia", "setVideoMedia", "getVideoPath", "setVideoPath", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/ProgressBarConfigModel;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/MvpTask;)Lcom/baidu/searchbox/videopublisher/PublishModel;", "equals", "other", "", "hashCode", "", "toString", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPublishStore.kt */
public final class PublishModel implements NoProGuard {
    private String activityList;
    private String aiStyleId;
    private String announceOriginal;
    private String businessId;
    private String campaignInfo;
    private String cardId;
    private String cardType;
    private String coverPath;
    private String coverUrl;
    private String goodsList;
    private String groupInfo;
    private Boolean isFromAiCard;
    private String mountList;
    private MvpTask mvpTask;
    private String position;
    private ProgressBarConfigModel progressBarConfigModel;
    private String taskOrigin;
    private TiaoZhanInfo tiaozhanInfo;
    private String title;
    private String topicInfo;
    private String uniqueId;
    private String videoMedia;
    private String videoPath;

    public PublishModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ProgressBarConfigModel) null, (String) null, (String) null, (TiaoZhanInfo) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (MvpTask) null, 8388607, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PublishModel copy$default(PublishModel publishModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ProgressBarConfigModel progressBarConfigModel2, String str13, String str14, TiaoZhanInfo tiaoZhanInfo, String str15, String str16, Boolean bool, String str17, String str18, String str19, MvpTask mvpTask2, int i2, Object obj) {
        PublishModel publishModel2 = publishModel;
        int i3 = i2;
        return publishModel.copy((i3 & 1) != 0 ? publishModel2.videoPath : str, (i3 & 2) != 0 ? publishModel2.coverPath : str2, (i3 & 4) != 0 ? publishModel2.videoMedia : str3, (i3 & 8) != 0 ? publishModel2.coverUrl : str4, (i3 & 16) != 0 ? publishModel2.title : str5, (i3 & 32) != 0 ? publishModel2.position : str6, (i3 & 64) != 0 ? publishModel2.goodsList : str7, (i3 & 128) != 0 ? publishModel2.groupInfo : str8, (i3 & 256) != 0 ? publishModel2.campaignInfo : str9, (i3 & 512) != 0 ? publishModel2.topicInfo : str10, (i3 & 1024) != 0 ? publishModel2.activityList : str11, (i3 & 2048) != 0 ? publishModel2.announceOriginal : str12, (i3 & 4096) != 0 ? publishModel2.progressBarConfigModel : progressBarConfigModel2, (i3 & 8192) != 0 ? publishModel2.mountList : str13, (i3 & 16384) != 0 ? publishModel2.taskOrigin : str14, (i3 & 32768) != 0 ? publishModel2.tiaozhanInfo : tiaoZhanInfo, (i3 & 65536) != 0 ? publishModel2.aiStyleId : str15, (i3 & 131072) != 0 ? publishModel2.businessId : str16, (i3 & 262144) != 0 ? publishModel2.isFromAiCard : bool, (i3 & 524288) != 0 ? publishModel2.cardType : str17, (i3 & 1048576) != 0 ? publishModel2.cardId : str18, (i3 & 2097152) != 0 ? publishModel2.uniqueId : str19, (i3 & 4194304) != 0 ? publishModel2.mvpTask : mvpTask2);
    }

    public final String component1() {
        return this.videoPath;
    }

    public final String component10() {
        return this.topicInfo;
    }

    public final String component11() {
        return this.activityList;
    }

    public final String component12() {
        return this.announceOriginal;
    }

    public final ProgressBarConfigModel component13() {
        return this.progressBarConfigModel;
    }

    public final String component14() {
        return this.mountList;
    }

    public final String component15() {
        return this.taskOrigin;
    }

    public final TiaoZhanInfo component16() {
        return this.tiaozhanInfo;
    }

    public final String component17() {
        return this.aiStyleId;
    }

    public final String component18() {
        return this.businessId;
    }

    public final Boolean component19() {
        return this.isFromAiCard;
    }

    public final String component2() {
        return this.coverPath;
    }

    public final String component20() {
        return this.cardType;
    }

    public final String component21() {
        return this.cardId;
    }

    public final String component22() {
        return this.uniqueId;
    }

    public final MvpTask component23() {
        return this.mvpTask;
    }

    public final String component3() {
        return this.videoMedia;
    }

    public final String component4() {
        return this.coverUrl;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.position;
    }

    public final String component7() {
        return this.goodsList;
    }

    public final String component8() {
        return this.groupInfo;
    }

    public final String component9() {
        return this.campaignInfo;
    }

    public final PublishModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ProgressBarConfigModel progressBarConfigModel2, String str13, String str14, TiaoZhanInfo tiaoZhanInfo, String str15, String str16, Boolean bool, String str17, String str18, String str19, MvpTask mvpTask2) {
        return new PublishModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, progressBarConfigModel2, str13, str14, tiaoZhanInfo, str15, str16, bool, str17, str18, str19, mvpTask2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishModel)) {
            return false;
        }
        PublishModel publishModel = (PublishModel) obj;
        return Intrinsics.areEqual((Object) this.videoPath, (Object) publishModel.videoPath) && Intrinsics.areEqual((Object) this.coverPath, (Object) publishModel.coverPath) && Intrinsics.areEqual((Object) this.videoMedia, (Object) publishModel.videoMedia) && Intrinsics.areEqual((Object) this.coverUrl, (Object) publishModel.coverUrl) && Intrinsics.areEqual((Object) this.title, (Object) publishModel.title) && Intrinsics.areEqual((Object) this.position, (Object) publishModel.position) && Intrinsics.areEqual((Object) this.goodsList, (Object) publishModel.goodsList) && Intrinsics.areEqual((Object) this.groupInfo, (Object) publishModel.groupInfo) && Intrinsics.areEqual((Object) this.campaignInfo, (Object) publishModel.campaignInfo) && Intrinsics.areEqual((Object) this.topicInfo, (Object) publishModel.topicInfo) && Intrinsics.areEqual((Object) this.activityList, (Object) publishModel.activityList) && Intrinsics.areEqual((Object) this.announceOriginal, (Object) publishModel.announceOriginal) && Intrinsics.areEqual((Object) this.progressBarConfigModel, (Object) publishModel.progressBarConfigModel) && Intrinsics.areEqual((Object) this.mountList, (Object) publishModel.mountList) && Intrinsics.areEqual((Object) this.taskOrigin, (Object) publishModel.taskOrigin) && Intrinsics.areEqual((Object) this.tiaozhanInfo, (Object) publishModel.tiaozhanInfo) && Intrinsics.areEqual((Object) this.aiStyleId, (Object) publishModel.aiStyleId) && Intrinsics.areEqual((Object) this.businessId, (Object) publishModel.businessId) && Intrinsics.areEqual((Object) this.isFromAiCard, (Object) publishModel.isFromAiCard) && Intrinsics.areEqual((Object) this.cardType, (Object) publishModel.cardType) && Intrinsics.areEqual((Object) this.cardId, (Object) publishModel.cardId) && Intrinsics.areEqual((Object) this.uniqueId, (Object) publishModel.uniqueId) && Intrinsics.areEqual((Object) this.mvpTask, (Object) publishModel.mvpTask);
    }

    public int hashCode() {
        String str = this.videoPath;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coverPath;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoMedia;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.coverUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.position;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.goodsList;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.groupInfo;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.campaignInfo;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.topicInfo;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.activityList;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.announceOriginal;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        ProgressBarConfigModel progressBarConfigModel2 = this.progressBarConfigModel;
        int hashCode13 = (hashCode12 + (progressBarConfigModel2 == null ? 0 : progressBarConfigModel2.hashCode())) * 31;
        String str13 = this.mountList;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.taskOrigin;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        TiaoZhanInfo tiaoZhanInfo = this.tiaozhanInfo;
        int hashCode16 = (hashCode15 + (tiaoZhanInfo == null ? 0 : tiaoZhanInfo.hashCode())) * 31;
        String str15 = this.aiStyleId;
        int hashCode17 = (hashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.businessId;
        int hashCode18 = (hashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Boolean bool = this.isFromAiCard;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str17 = this.cardType;
        int hashCode20 = (hashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.cardId;
        int hashCode21 = (hashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.uniqueId;
        int hashCode22 = (hashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        MvpTask mvpTask2 = this.mvpTask;
        if (mvpTask2 != null) {
            i2 = mvpTask2.hashCode();
        }
        return hashCode22 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublishModel(videoPath=").append(this.videoPath).append(", coverPath=").append(this.coverPath).append(", videoMedia=").append(this.videoMedia).append(", coverUrl=").append(this.coverUrl).append(", title=").append(this.title).append(", position=").append(this.position).append(", goodsList=").append(this.goodsList).append(", groupInfo=").append(this.groupInfo).append(", campaignInfo=").append(this.campaignInfo).append(", topicInfo=").append(this.topicInfo).append(", activityList=").append(this.activityList).append(", announceOriginal=");
        sb.append(this.announceOriginal).append(", progressBarConfigModel=").append(this.progressBarConfigModel).append(", mountList=").append(this.mountList).append(", taskOrigin=").append(this.taskOrigin).append(", tiaozhanInfo=").append(this.tiaozhanInfo).append(", aiStyleId=").append(this.aiStyleId).append(", businessId=").append(this.businessId).append(", isFromAiCard=").append(this.isFromAiCard).append(", cardType=").append(this.cardType).append(", cardId=").append(this.cardId).append(", uniqueId=").append(this.uniqueId).append(", mvpTask=").append(this.mvpTask);
        sb.append(')');
        return sb.toString();
    }

    public PublishModel(String videoPath2, String coverPath2, String videoMedia2, String coverUrl2, String title2, String position2, String goodsList2, String groupInfo2, String campaignInfo2, String topicInfo2, String activityList2, String announceOriginal2, ProgressBarConfigModel progressBarConfigModel2, String mountList2, String taskOrigin2, TiaoZhanInfo tiaozhanInfo2, String aiStyleId2, String businessId2, Boolean isFromAiCard2, String cardType2, String cardId2, String uniqueId2, MvpTask mvpTask2) {
        this.videoPath = videoPath2;
        this.coverPath = coverPath2;
        this.videoMedia = videoMedia2;
        this.coverUrl = coverUrl2;
        this.title = title2;
        this.position = position2;
        this.goodsList = goodsList2;
        this.groupInfo = groupInfo2;
        this.campaignInfo = campaignInfo2;
        this.topicInfo = topicInfo2;
        this.activityList = activityList2;
        this.announceOriginal = announceOriginal2;
        this.progressBarConfigModel = progressBarConfigModel2;
        this.mountList = mountList2;
        this.taskOrigin = taskOrigin2;
        this.tiaozhanInfo = tiaozhanInfo2;
        this.aiStyleId = aiStyleId2;
        this.businessId = businessId2;
        this.isFromAiCard = isFromAiCard2;
        this.cardType = cardType2;
        this.cardId = cardId2;
        this.uniqueId = uniqueId2;
        this.mvpTask = mvpTask2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublishModel(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, com.baidu.searchbox.ugc.model.ProgressBarConfigModel r37, java.lang.String r38, java.lang.String r39, com.baidu.searchbox.ugc.model.TiaoZhanInfo r40, java.lang.String r41, java.lang.String r42, java.lang.Boolean r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, com.baidu.searchbox.ugc.model.MvpTask r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r25
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r26
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r27
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r28
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r29
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r30
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r31
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r32
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r33
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r34
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r35
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r36
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r37
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r38
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r39
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r40
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r41
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r42
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a9
            r19 = 0
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r19)
            goto L_0x00ab
        L_0x00a9:
            r19 = r43
        L_0x00ab:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b4
            r20 = 0
            goto L_0x00b6
        L_0x00b4:
            r20 = r44
        L_0x00b6:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bf
            r21 = 0
            goto L_0x00c1
        L_0x00bf:
            r21 = r45
        L_0x00c1:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00ca
            r22 = 0
            goto L_0x00cc
        L_0x00ca:
            r22 = r46
        L_0x00cc:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00d4
            r0 = 0
            goto L_0x00d6
        L_0x00d4:
            r0 = r47
        L_0x00d6:
            r25 = r1
            r26 = r3
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r8
            r32 = r9
            r33 = r10
            r34 = r11
            r35 = r12
            r36 = r13
            r37 = r14
            r38 = r15
            r39 = r2
            r40 = r16
            r41 = r17
            r42 = r18
            r43 = r19
            r44 = r20
            r45 = r21
            r46 = r22
            r47 = r0
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.videopublisher.PublishModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.ugc.model.ProgressBarConfigModel, java.lang.String, java.lang.String, com.baidu.searchbox.ugc.model.TiaoZhanInfo, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, com.baidu.searchbox.ugc.model.MvpTask, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

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

    public final String getVideoMedia() {
        return this.videoMedia;
    }

    public final void setVideoMedia(String str) {
        this.videoMedia = str;
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

    public final String getPosition() {
        return this.position;
    }

    public final void setPosition(String str) {
        this.position = str;
    }

    public final String getGoodsList() {
        return this.goodsList;
    }

    public final void setGoodsList(String str) {
        this.goodsList = str;
    }

    public final String getGroupInfo() {
        return this.groupInfo;
    }

    public final void setGroupInfo(String str) {
        this.groupInfo = str;
    }

    public final String getCampaignInfo() {
        return this.campaignInfo;
    }

    public final void setCampaignInfo(String str) {
        this.campaignInfo = str;
    }

    public final String getTopicInfo() {
        return this.topicInfo;
    }

    public final void setTopicInfo(String str) {
        this.topicInfo = str;
    }

    public final String getActivityList() {
        return this.activityList;
    }

    public final void setActivityList(String str) {
        this.activityList = str;
    }

    public final String getAnnounceOriginal() {
        return this.announceOriginal;
    }

    public final void setAnnounceOriginal(String str) {
        this.announceOriginal = str;
    }

    public final ProgressBarConfigModel getProgressBarConfigModel() {
        return this.progressBarConfigModel;
    }

    public final void setProgressBarConfigModel(ProgressBarConfigModel progressBarConfigModel2) {
        this.progressBarConfigModel = progressBarConfigModel2;
    }

    public final String getMountList() {
        return this.mountList;
    }

    public final void setMountList(String str) {
        this.mountList = str;
    }

    public final String getTaskOrigin() {
        return this.taskOrigin;
    }

    public final void setTaskOrigin(String str) {
        this.taskOrigin = str;
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

    public final String getBusinessId() {
        return this.businessId;
    }

    public final void setBusinessId(String str) {
        this.businessId = str;
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

    public final MvpTask getMvpTask() {
        return this.mvpTask;
    }

    public final void setMvpTask(MvpTask mvpTask2) {
        this.mvpTask = mvpTask2;
    }
}
