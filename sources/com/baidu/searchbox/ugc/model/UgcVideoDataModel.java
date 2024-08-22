package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\bHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 ¨\u00065"}, d2 = {"Lcom/baidu/searchbox/ugc/model/UgcVideoDataModel;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "videoUrl", "location", "", "coverImgMap", "", "Lcom/baidu/searchbox/ugc/model/UgcVideCoverInfoModel;", "contentInfo", "Lcom/baidu/searchbox/ugc/model/UgcContentInfoModel;", "topicInfo", "Lcom/baidu/searchbox/ugc/model/TopicItem;", "activityList", "Lcom/baidu/searchbox/ugc/model/UgcActivityListItemModel;", "originRes", "Lcom/baidu/searchbox/ugc/model/UgcOriginResInfoModel;", "mountList", "taskOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Lcom/baidu/searchbox/ugc/model/UgcContentInfoModel;Ljava/util/List;Ljava/util/List;Lcom/baidu/searchbox/ugc/model/UgcOriginResInfoModel;Ljava/lang/Object;Ljava/lang/String;)V", "getActivityList", "()Ljava/util/List;", "getContentInfo", "()Lcom/baidu/searchbox/ugc/model/UgcContentInfoModel;", "getCoverImgMap", "getLocation", "()Ljava/lang/Object;", "getMountList", "getOriginRes", "()Lcom/baidu/searchbox/ugc/model/UgcOriginResInfoModel;", "getTaskOrigin", "()Ljava/lang/String;", "getTitle", "getTopicInfo", "getVideoUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcVideoArticleModel.kt */
public final class UgcVideoDataModel implements NoProGuard {
    @SerializedName("activity_list")
    private final List<UgcActivityListItemModel> activityList;
    @SerializedName("content")
    private final UgcContentInfoModel contentInfo;
    @SerializedName("cover_images")
    private final List<UgcVideCoverInfoModel> coverImgMap;
    @SerializedName("position_lat_lng")
    private final Object location;
    @SerializedName("mountList")
    private final Object mountList;
    @SerializedName("originRes")
    private final UgcOriginResInfoModel originRes;
    @SerializedName("task_origin")
    private final String taskOrigin;
    @SerializedName("title")
    private final String title;
    @SerializedName("bjhtopic_info")
    private final List<TopicItem> topicInfo;
    @SerializedName("url")
    private final String videoUrl;

    public static /* synthetic */ UgcVideoDataModel copy$default(UgcVideoDataModel ugcVideoDataModel, String str, String str2, Object obj, List list, UgcContentInfoModel ugcContentInfoModel, List list2, List list3, UgcOriginResInfoModel ugcOriginResInfoModel, Object obj2, String str3, int i2, Object obj3) {
        UgcVideoDataModel ugcVideoDataModel2 = ugcVideoDataModel;
        int i3 = i2;
        return ugcVideoDataModel.copy((i3 & 1) != 0 ? ugcVideoDataModel2.title : str, (i3 & 2) != 0 ? ugcVideoDataModel2.videoUrl : str2, (i3 & 4) != 0 ? ugcVideoDataModel2.location : obj, (i3 & 8) != 0 ? ugcVideoDataModel2.coverImgMap : list, (i3 & 16) != 0 ? ugcVideoDataModel2.contentInfo : ugcContentInfoModel, (i3 & 32) != 0 ? ugcVideoDataModel2.topicInfo : list2, (i3 & 64) != 0 ? ugcVideoDataModel2.activityList : list3, (i3 & 128) != 0 ? ugcVideoDataModel2.originRes : ugcOriginResInfoModel, (i3 & 256) != 0 ? ugcVideoDataModel2.mountList : obj2, (i3 & 512) != 0 ? ugcVideoDataModel2.taskOrigin : str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.taskOrigin;
    }

    public final String component2() {
        return this.videoUrl;
    }

    public final Object component3() {
        return this.location;
    }

    public final List<UgcVideCoverInfoModel> component4() {
        return this.coverImgMap;
    }

    public final UgcContentInfoModel component5() {
        return this.contentInfo;
    }

    public final List<TopicItem> component6() {
        return this.topicInfo;
    }

    public final List<UgcActivityListItemModel> component7() {
        return this.activityList;
    }

    public final UgcOriginResInfoModel component8() {
        return this.originRes;
    }

    public final Object component9() {
        return this.mountList;
    }

    public final UgcVideoDataModel copy(String str, String str2, Object obj, List<UgcVideCoverInfoModel> list, UgcContentInfoModel ugcContentInfoModel, List<TopicItem> list2, List<UgcActivityListItemModel> list3, UgcOriginResInfoModel ugcOriginResInfoModel, Object obj2, String str3) {
        return new UgcVideoDataModel(str, str2, obj, list, ugcContentInfoModel, list2, list3, ugcOriginResInfoModel, obj2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UgcVideoDataModel)) {
            return false;
        }
        UgcVideoDataModel ugcVideoDataModel = (UgcVideoDataModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) ugcVideoDataModel.title) && Intrinsics.areEqual((Object) this.videoUrl, (Object) ugcVideoDataModel.videoUrl) && Intrinsics.areEqual(this.location, ugcVideoDataModel.location) && Intrinsics.areEqual((Object) this.coverImgMap, (Object) ugcVideoDataModel.coverImgMap) && Intrinsics.areEqual((Object) this.contentInfo, (Object) ugcVideoDataModel.contentInfo) && Intrinsics.areEqual((Object) this.topicInfo, (Object) ugcVideoDataModel.topicInfo) && Intrinsics.areEqual((Object) this.activityList, (Object) ugcVideoDataModel.activityList) && Intrinsics.areEqual((Object) this.originRes, (Object) ugcVideoDataModel.originRes) && Intrinsics.areEqual(this.mountList, ugcVideoDataModel.mountList) && Intrinsics.areEqual((Object) this.taskOrigin, (Object) ugcVideoDataModel.taskOrigin);
    }

    public int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj = this.location;
        int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        List<UgcVideCoverInfoModel> list = this.coverImgMap;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        UgcContentInfoModel ugcContentInfoModel = this.contentInfo;
        int hashCode5 = (hashCode4 + (ugcContentInfoModel == null ? 0 : ugcContentInfoModel.hashCode())) * 31;
        List<TopicItem> list2 = this.topicInfo;
        int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<UgcActivityListItemModel> list3 = this.activityList;
        int hashCode7 = (hashCode6 + (list3 == null ? 0 : list3.hashCode())) * 31;
        UgcOriginResInfoModel ugcOriginResInfoModel = this.originRes;
        int hashCode8 = (hashCode7 + (ugcOriginResInfoModel == null ? 0 : ugcOriginResInfoModel.hashCode())) * 31;
        Object obj2 = this.mountList;
        int hashCode9 = (hashCode8 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        String str3 = this.taskOrigin;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode9 + i2;
    }

    public String toString() {
        return "UgcVideoDataModel(title=" + this.title + ", videoUrl=" + this.videoUrl + ", location=" + this.location + ", coverImgMap=" + this.coverImgMap + ", contentInfo=" + this.contentInfo + ", topicInfo=" + this.topicInfo + ", activityList=" + this.activityList + ", originRes=" + this.originRes + ", mountList=" + this.mountList + ", taskOrigin=" + this.taskOrigin + ')';
    }

    public UgcVideoDataModel(String title2, String videoUrl2, Object location2, List<UgcVideCoverInfoModel> coverImgMap2, UgcContentInfoModel contentInfo2, List<TopicItem> topicInfo2, List<UgcActivityListItemModel> activityList2, UgcOriginResInfoModel originRes2, Object mountList2, String taskOrigin2) {
        this.title = title2;
        this.videoUrl = videoUrl2;
        this.location = location2;
        this.coverImgMap = coverImgMap2;
        this.contentInfo = contentInfo2;
        this.topicInfo = topicInfo2;
        this.activityList = activityList2;
        this.originRes = originRes2;
        this.mountList = mountList2;
        this.taskOrigin = taskOrigin2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final Object getLocation() {
        return this.location;
    }

    public final List<UgcVideCoverInfoModel> getCoverImgMap() {
        return this.coverImgMap;
    }

    public final UgcContentInfoModel getContentInfo() {
        return this.contentInfo;
    }

    public final List<TopicItem> getTopicInfo() {
        return this.topicInfo;
    }

    public final List<UgcActivityListItemModel> getActivityList() {
        return this.activityList;
    }

    public final UgcOriginResInfoModel getOriginRes() {
        return this.originRes;
    }

    public final Object getMountList() {
        return this.mountList;
    }

    public final String getTaskOrigin() {
        return this.taskOrigin;
    }
}
