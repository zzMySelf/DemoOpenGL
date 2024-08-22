package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0006\u0010>\u001a\u00020\u000fJ\u0006\u0010?\u001a\u00020\u000fJ\u0006\u0010@\u001a\u00020\u000fJ\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"¨\u0006B"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/VideoSummaryItemModel;", "Lcom/baidu/searchbox/NoProGuard;", "summaryModelItemType", "", "summaryTitle", "summaryTime", "", "summaryEndTime", "summaryPoster", "summaryInfo", "summaryIndex", "shortStart", "shortEnd", "version", "isReportShow", "", "totalSize", "link", "Lcom/baidu/searchbox/flowvideo/detail/repos/VideoSummaryLinkModel;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;ZILcom/baidu/searchbox/flowvideo/detail/repos/VideoSummaryLinkModel;)V", "()Z", "setReportShow", "(Z)V", "getLink", "()Lcom/baidu/searchbox/flowvideo/detail/repos/VideoSummaryLinkModel;", "getShortEnd", "()I", "getShortStart", "getSummaryEndTime", "setSummaryEndTime", "(I)V", "getSummaryIndex", "setSummaryIndex", "getSummaryInfo", "()Ljava/lang/String;", "getSummaryModelItemType", "setSummaryModelItemType", "(Ljava/lang/String;)V", "getSummaryPoster", "getSummaryTime", "getSummaryTitle", "getTotalSize", "setTotalSize", "getVersion", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "isLinkText", "isShortKeyText", "isSpecialText", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class VideoSummaryItemModel implements NoProGuard {
    private boolean isReportShow;
    private final VideoSummaryLinkModel link;
    private final int shortEnd;
    private final int shortStart;
    private int summaryEndTime;
    private int summaryIndex;
    private final String summaryInfo;
    private String summaryModelItemType;
    private final String summaryPoster;
    private final int summaryTime;
    private final String summaryTitle;
    private int totalSize;
    private final String version;

    public static /* synthetic */ VideoSummaryItemModel copy$default(VideoSummaryItemModel videoSummaryItemModel, String str, String str2, int i2, int i3, String str3, String str4, int i4, int i5, int i6, String str5, boolean z, int i7, VideoSummaryLinkModel videoSummaryLinkModel, int i8, Object obj) {
        VideoSummaryItemModel videoSummaryItemModel2 = videoSummaryItemModel;
        int i9 = i8;
        return videoSummaryItemModel.copy((i9 & 1) != 0 ? videoSummaryItemModel2.summaryModelItemType : str, (i9 & 2) != 0 ? videoSummaryItemModel2.summaryTitle : str2, (i9 & 4) != 0 ? videoSummaryItemModel2.summaryTime : i2, (i9 & 8) != 0 ? videoSummaryItemModel2.summaryEndTime : i3, (i9 & 16) != 0 ? videoSummaryItemModel2.summaryPoster : str3, (i9 & 32) != 0 ? videoSummaryItemModel2.summaryInfo : str4, (i9 & 64) != 0 ? videoSummaryItemModel2.summaryIndex : i4, (i9 & 128) != 0 ? videoSummaryItemModel2.shortStart : i5, (i9 & 256) != 0 ? videoSummaryItemModel2.shortEnd : i6, (i9 & 512) != 0 ? videoSummaryItemModel2.version : str5, (i9 & 1024) != 0 ? videoSummaryItemModel2.isReportShow : z, (i9 & 2048) != 0 ? videoSummaryItemModel2.totalSize : i7, (i9 & 4096) != 0 ? videoSummaryItemModel2.link : videoSummaryLinkModel);
    }

    public final String component1() {
        return this.summaryModelItemType;
    }

    public final String component10() {
        return this.version;
    }

    public final boolean component11() {
        return this.isReportShow;
    }

    public final int component12() {
        return this.totalSize;
    }

    public final VideoSummaryLinkModel component13() {
        return this.link;
    }

    public final String component2() {
        return this.summaryTitle;
    }

    public final int component3() {
        return this.summaryTime;
    }

    public final int component4() {
        return this.summaryEndTime;
    }

    public final String component5() {
        return this.summaryPoster;
    }

    public final String component6() {
        return this.summaryInfo;
    }

    public final int component7() {
        return this.summaryIndex;
    }

    public final int component8() {
        return this.shortStart;
    }

    public final int component9() {
        return this.shortEnd;
    }

    public final VideoSummaryItemModel copy(String str, String str2, int i2, int i3, String str3, String str4, int i4, int i5, int i6, String str5, boolean z, int i7, VideoSummaryLinkModel videoSummaryLinkModel) {
        Intrinsics.checkNotNullParameter(str, "summaryModelItemType");
        Intrinsics.checkNotNullParameter(str2, IntentData.SUMMARY_TITLE);
        Intrinsics.checkNotNullParameter(str3, "summaryPoster");
        Intrinsics.checkNotNullParameter(str4, "summaryInfo");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, "version");
        return new VideoSummaryItemModel(str, str2, i2, i3, str3, str4, i4, i5, i6, str6, z, i7, videoSummaryLinkModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSummaryItemModel)) {
            return false;
        }
        VideoSummaryItemModel videoSummaryItemModel = (VideoSummaryItemModel) obj;
        return Intrinsics.areEqual((Object) this.summaryModelItemType, (Object) videoSummaryItemModel.summaryModelItemType) && Intrinsics.areEqual((Object) this.summaryTitle, (Object) videoSummaryItemModel.summaryTitle) && this.summaryTime == videoSummaryItemModel.summaryTime && this.summaryEndTime == videoSummaryItemModel.summaryEndTime && Intrinsics.areEqual((Object) this.summaryPoster, (Object) videoSummaryItemModel.summaryPoster) && Intrinsics.areEqual((Object) this.summaryInfo, (Object) videoSummaryItemModel.summaryInfo) && this.summaryIndex == videoSummaryItemModel.summaryIndex && this.shortStart == videoSummaryItemModel.shortStart && this.shortEnd == videoSummaryItemModel.shortEnd && Intrinsics.areEqual((Object) this.version, (Object) videoSummaryItemModel.version) && this.isReportShow == videoSummaryItemModel.isReportShow && this.totalSize == videoSummaryItemModel.totalSize && Intrinsics.areEqual((Object) this.link, (Object) videoSummaryItemModel.link);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.summaryModelItemType.hashCode() * 31) + this.summaryTitle.hashCode()) * 31) + Integer.hashCode(this.summaryTime)) * 31) + Integer.hashCode(this.summaryEndTime)) * 31) + this.summaryPoster.hashCode()) * 31) + this.summaryInfo.hashCode()) * 31) + Integer.hashCode(this.summaryIndex)) * 31) + Integer.hashCode(this.shortStart)) * 31) + Integer.hashCode(this.shortEnd)) * 31) + this.version.hashCode()) * 31;
        boolean z = this.isReportShow;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.totalSize)) * 31;
        VideoSummaryLinkModel videoSummaryLinkModel = this.link;
        return hashCode2 + (videoSummaryLinkModel == null ? 0 : videoSummaryLinkModel.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoSummaryItemModel(summaryModelItemType=").append(this.summaryModelItemType).append(", summaryTitle=").append(this.summaryTitle).append(", summaryTime=").append(this.summaryTime).append(", summaryEndTime=").append(this.summaryEndTime).append(", summaryPoster=").append(this.summaryPoster).append(", summaryInfo=").append(this.summaryInfo).append(", summaryIndex=").append(this.summaryIndex).append(", shortStart=").append(this.shortStart).append(", shortEnd=").append(this.shortEnd).append(", version=").append(this.version).append(", isReportShow=").append(this.isReportShow).append(", totalSize=");
        sb.append(this.totalSize).append(", link=").append(this.link).append(')');
        return sb.toString();
    }

    public VideoSummaryItemModel(String summaryModelItemType2, String summaryTitle2, int summaryTime2, int summaryEndTime2, String summaryPoster2, String summaryInfo2, int summaryIndex2, int shortStart2, int shortEnd2, String version2, boolean isReportShow2, int totalSize2, VideoSummaryLinkModel link2) {
        Intrinsics.checkNotNullParameter(summaryModelItemType2, "summaryModelItemType");
        Intrinsics.checkNotNullParameter(summaryTitle2, IntentData.SUMMARY_TITLE);
        Intrinsics.checkNotNullParameter(summaryPoster2, "summaryPoster");
        Intrinsics.checkNotNullParameter(summaryInfo2, "summaryInfo");
        Intrinsics.checkNotNullParameter(version2, "version");
        this.summaryModelItemType = summaryModelItemType2;
        this.summaryTitle = summaryTitle2;
        this.summaryTime = summaryTime2;
        this.summaryEndTime = summaryEndTime2;
        this.summaryPoster = summaryPoster2;
        this.summaryInfo = summaryInfo2;
        this.summaryIndex = summaryIndex2;
        this.shortStart = shortStart2;
        this.shortEnd = shortEnd2;
        this.version = version2;
        this.isReportShow = isReportShow2;
        this.totalSize = totalSize2;
        this.link = link2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VideoSummaryItemModel(java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, java.lang.String r22, int r23, int r24, int r25, java.lang.String r26, boolean r27, int r28, com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryLinkModel r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = "video_summary_video_summary_model"
            r3 = r1
            goto L_0x000d
        L_0x000b:
            r3 = r17
        L_0x000d:
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0015
            r4 = r2
            goto L_0x0017
        L_0x0015:
            r4 = r18
        L_0x0017:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0020
            r1 = 2147483647(0x7fffffff, float:NaN)
            r6 = r1
            goto L_0x0022
        L_0x0020:
            r6 = r20
        L_0x0022:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0028
            r7 = r2
            goto L_0x002a
        L_0x0028:
            r7 = r21
        L_0x002a:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0030
            r8 = r2
            goto L_0x0032
        L_0x0030:
            r8 = r22
        L_0x0032:
            r1 = r0 & 64
            r5 = 0
            if (r1 == 0) goto L_0x0039
            r9 = r5
            goto L_0x003b
        L_0x0039:
            r9 = r23
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r10 = r5
            goto L_0x0043
        L_0x0041:
            r10 = r24
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r11 = r5
            goto L_0x004b
        L_0x0049:
            r11 = r25
        L_0x004b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0051
            r12 = r2
            goto L_0x0053
        L_0x0051:
            r12 = r26
        L_0x0053:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0059
            r13 = r5
            goto L_0x005b
        L_0x0059:
            r13 = r27
        L_0x005b:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0062
            r0 = 0
            r15 = r0
            goto L_0x0064
        L_0x0062:
            r15 = r29
        L_0x0064:
            r2 = r16
            r5 = r19
            r14 = r28
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryItemModel.<init>(java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, int, java.lang.String, boolean, int, com.baidu.searchbox.flowvideo.detail.repos.VideoSummaryLinkModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSummaryModelItemType() {
        return this.summaryModelItemType;
    }

    public final void setSummaryModelItemType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.summaryModelItemType = str;
    }

    public final String getSummaryTitle() {
        return this.summaryTitle;
    }

    public final int getSummaryTime() {
        return this.summaryTime;
    }

    public final int getSummaryEndTime() {
        return this.summaryEndTime;
    }

    public final void setSummaryEndTime(int i2) {
        this.summaryEndTime = i2;
    }

    public final String getSummaryPoster() {
        return this.summaryPoster;
    }

    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    public final int getSummaryIndex() {
        return this.summaryIndex;
    }

    public final void setSummaryIndex(int i2) {
        this.summaryIndex = i2;
    }

    public final int getShortStart() {
        return this.shortStart;
    }

    public final int getShortEnd() {
        return this.shortEnd;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean isReportShow() {
        return this.isReportShow;
    }

    public final void setReportShow(boolean z) {
        this.isReportShow = z;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }

    public final void setTotalSize(int i2) {
        this.totalSize = i2;
    }

    public final VideoSummaryLinkModel getLink() {
        return this.link;
    }

    public final boolean isShortKeyText() {
        return FlowDetailModelKt.isKeyFrameValid(this.shortStart, this.shortEnd);
    }

    public final boolean isLinkText() {
        VideoSummaryLinkModel videoSummaryLinkModel = this.link;
        return videoSummaryLinkModel != null && (videoSummaryLinkModel.getLinkStart().isEmpty() ^ true);
    }

    public final boolean isSpecialText() {
        return isShortKeyText() || isLinkText();
    }
}
