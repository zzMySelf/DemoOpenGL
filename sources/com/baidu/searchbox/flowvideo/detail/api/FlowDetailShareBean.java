package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0002\u0010\u0018J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u001d\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003JÁ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0012HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001c¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/FlowDetailShareBean;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "content", "iconUrl", "linkUrl", "videoUrl", "downloadUrl", "categoryInfo", "shareNum", "shareTrigger", "addButton", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/flowvideo/detail/api/FlowDetailShareBtnBean;", "Lkotlin/collections/ArrayList;", "feedback", "hideSharePanelAnim", "", "enhanceButton", "Lcom/baidu/searchbox/flowvideo/detail/api/EnhanceButtonBean;", "type", "disable", "dtShareCmd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ILcom/baidu/searchbox/flowvideo/detail/api/EnhanceButtonBean;ILjava/lang/String;Ljava/lang/String;)V", "getAddButton", "()Ljava/util/ArrayList;", "getCategoryInfo", "()Ljava/lang/String;", "getContent", "getDisable", "getDownloadUrl", "getDtShareCmd", "getEnhanceButton", "()Lcom/baidu/searchbox/flowvideo/detail/api/EnhanceButtonBean;", "getFeedback", "getHideSharePanelAnim", "()I", "getIconUrl", "getLinkUrl", "getShareNum", "getShareTrigger", "getTitle", "getType", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class FlowDetailShareBean implements NoProGuard {
    private final ArrayList<FlowDetailShareBtnBean> addButton;
    private final String categoryInfo;
    private final String content;
    private final String disable;
    private final String downloadUrl;
    private final String dtShareCmd;
    private final EnhanceButtonBean enhanceButton;
    @SerializedName("interact_feedback")
    private final String feedback;
    private final int hideSharePanelAnim;
    private final String iconUrl;
    private final String linkUrl;
    private final String shareNum;
    private final String shareTrigger;
    private final String title;
    private final int type;
    private final String videoUrl;

    public FlowDetailShareBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, 0, (EnhanceButtonBean) null, 0, (String) null, (String) null, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailShareBean copy$default(FlowDetailShareBean flowDetailShareBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList, String str10, int i2, EnhanceButtonBean enhanceButtonBean, int i3, String str11, String str12, int i4, Object obj) {
        FlowDetailShareBean flowDetailShareBean2 = flowDetailShareBean;
        int i5 = i4;
        return flowDetailShareBean.copy((i5 & 1) != 0 ? flowDetailShareBean2.title : str, (i5 & 2) != 0 ? flowDetailShareBean2.content : str2, (i5 & 4) != 0 ? flowDetailShareBean2.iconUrl : str3, (i5 & 8) != 0 ? flowDetailShareBean2.linkUrl : str4, (i5 & 16) != 0 ? flowDetailShareBean2.videoUrl : str5, (i5 & 32) != 0 ? flowDetailShareBean2.downloadUrl : str6, (i5 & 64) != 0 ? flowDetailShareBean2.categoryInfo : str7, (i5 & 128) != 0 ? flowDetailShareBean2.shareNum : str8, (i5 & 256) != 0 ? flowDetailShareBean2.shareTrigger : str9, (i5 & 512) != 0 ? flowDetailShareBean2.addButton : arrayList, (i5 & 1024) != 0 ? flowDetailShareBean2.feedback : str10, (i5 & 2048) != 0 ? flowDetailShareBean2.hideSharePanelAnim : i2, (i5 & 4096) != 0 ? flowDetailShareBean2.enhanceButton : enhanceButtonBean, (i5 & 8192) != 0 ? flowDetailShareBean2.type : i3, (i5 & 16384) != 0 ? flowDetailShareBean2.disable : str11, (i5 & 32768) != 0 ? flowDetailShareBean2.dtShareCmd : str12);
    }

    public final String component1() {
        return this.title;
    }

    public final ArrayList<FlowDetailShareBtnBean> component10() {
        return this.addButton;
    }

    public final String component11() {
        return this.feedback;
    }

    public final int component12() {
        return this.hideSharePanelAnim;
    }

    public final EnhanceButtonBean component13() {
        return this.enhanceButton;
    }

    public final int component14() {
        return this.type;
    }

    public final String component15() {
        return this.disable;
    }

    public final String component16() {
        return this.dtShareCmd;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.linkUrl;
    }

    public final String component5() {
        return this.videoUrl;
    }

    public final String component6() {
        return this.downloadUrl;
    }

    public final String component7() {
        return this.categoryInfo;
    }

    public final String component8() {
        return this.shareNum;
    }

    public final String component9() {
        return this.shareTrigger;
    }

    public final FlowDetailShareBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<FlowDetailShareBtnBean> arrayList, String str10, int i2, EnhanceButtonBean enhanceButtonBean, int i3, String str11, String str12) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "iconUrl");
        Intrinsics.checkNotNullParameter(str4, "linkUrl");
        Intrinsics.checkNotNullParameter(str5, "videoUrl");
        Intrinsics.checkNotNullParameter(str6, "downloadUrl");
        Intrinsics.checkNotNullParameter(str8, "shareNum");
        Intrinsics.checkNotNullParameter(str9, "shareTrigger");
        Intrinsics.checkNotNullParameter(str10, "feedback");
        Intrinsics.checkNotNullParameter(str11, "disable");
        Intrinsics.checkNotNullParameter(str12, "dtShareCmd");
        return new FlowDetailShareBean(str13, str2, str3, str4, str5, str6, str7, str8, str9, arrayList, str10, i2, enhanceButtonBean, i3, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailShareBean)) {
            return false;
        }
        FlowDetailShareBean flowDetailShareBean = (FlowDetailShareBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) flowDetailShareBean.title) && Intrinsics.areEqual((Object) this.content, (Object) flowDetailShareBean.content) && Intrinsics.areEqual((Object) this.iconUrl, (Object) flowDetailShareBean.iconUrl) && Intrinsics.areEqual((Object) this.linkUrl, (Object) flowDetailShareBean.linkUrl) && Intrinsics.areEqual((Object) this.videoUrl, (Object) flowDetailShareBean.videoUrl) && Intrinsics.areEqual((Object) this.downloadUrl, (Object) flowDetailShareBean.downloadUrl) && Intrinsics.areEqual((Object) this.categoryInfo, (Object) flowDetailShareBean.categoryInfo) && Intrinsics.areEqual((Object) this.shareNum, (Object) flowDetailShareBean.shareNum) && Intrinsics.areEqual((Object) this.shareTrigger, (Object) flowDetailShareBean.shareTrigger) && Intrinsics.areEqual((Object) this.addButton, (Object) flowDetailShareBean.addButton) && Intrinsics.areEqual((Object) this.feedback, (Object) flowDetailShareBean.feedback) && this.hideSharePanelAnim == flowDetailShareBean.hideSharePanelAnim && Intrinsics.areEqual((Object) this.enhanceButton, (Object) flowDetailShareBean.enhanceButton) && this.type == flowDetailShareBean.type && Intrinsics.areEqual((Object) this.disable, (Object) flowDetailShareBean.disable) && Intrinsics.areEqual((Object) this.dtShareCmd, (Object) flowDetailShareBean.dtShareCmd);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.linkUrl.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.downloadUrl.hashCode()) * 31;
        String str = this.categoryInfo;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.shareNum.hashCode()) * 31) + this.shareTrigger.hashCode()) * 31;
        ArrayList<FlowDetailShareBtnBean> arrayList = this.addButton;
        int hashCode3 = (((((hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + this.feedback.hashCode()) * 31) + Integer.hashCode(this.hideSharePanelAnim)) * 31;
        EnhanceButtonBean enhanceButtonBean = this.enhanceButton;
        if (enhanceButtonBean != null) {
            i2 = enhanceButtonBean.hashCode();
        }
        return ((((((hashCode3 + i2) * 31) + Integer.hashCode(this.type)) * 31) + this.disable.hashCode()) * 31) + this.dtShareCmd.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowDetailShareBean(title=").append(this.title).append(", content=").append(this.content).append(", iconUrl=").append(this.iconUrl).append(", linkUrl=").append(this.linkUrl).append(", videoUrl=").append(this.videoUrl).append(", downloadUrl=").append(this.downloadUrl).append(", categoryInfo=").append(this.categoryInfo).append(", shareNum=").append(this.shareNum).append(", shareTrigger=").append(this.shareTrigger).append(", addButton=").append(this.addButton).append(", feedback=").append(this.feedback).append(", hideSharePanelAnim=");
        sb.append(this.hideSharePanelAnim).append(", enhanceButton=").append(this.enhanceButton).append(", type=").append(this.type).append(", disable=").append(this.disable).append(", dtShareCmd=").append(this.dtShareCmd).append(')');
        return sb.toString();
    }

    public FlowDetailShareBean(String title2, String content2, String iconUrl2, String linkUrl2, String videoUrl2, String downloadUrl2, String categoryInfo2, String shareNum2, String shareTrigger2, ArrayList<FlowDetailShareBtnBean> addButton2, String feedback2, int hideSharePanelAnim2, EnhanceButtonBean enhanceButton2, int type2, String disable2, String dtShareCmd2) {
        String str = title2;
        String str2 = content2;
        String str3 = iconUrl2;
        String str4 = linkUrl2;
        String str5 = videoUrl2;
        String str6 = downloadUrl2;
        String str7 = shareNum2;
        String str8 = shareTrigger2;
        String str9 = feedback2;
        String str10 = disable2;
        String str11 = dtShareCmd2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "iconUrl");
        Intrinsics.checkNotNullParameter(str4, "linkUrl");
        Intrinsics.checkNotNullParameter(str5, "videoUrl");
        Intrinsics.checkNotNullParameter(str6, "downloadUrl");
        Intrinsics.checkNotNullParameter(str7, "shareNum");
        Intrinsics.checkNotNullParameter(str8, "shareTrigger");
        Intrinsics.checkNotNullParameter(str9, "feedback");
        Intrinsics.checkNotNullParameter(str10, "disable");
        Intrinsics.checkNotNullParameter(str11, "dtShareCmd");
        this.title = str;
        this.content = str2;
        this.iconUrl = str3;
        this.linkUrl = str4;
        this.videoUrl = str5;
        this.downloadUrl = str6;
        this.categoryInfo = categoryInfo2;
        this.shareNum = str7;
        this.shareTrigger = str8;
        this.addButton = addButton2;
        this.feedback = str9;
        this.hideSharePanelAnim = hideSharePanelAnim2;
        this.enhanceButton = enhanceButton2;
        this.type = type2;
        this.disable = str10;
        this.dtShareCmd = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlowDetailShareBean(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.ArrayList r27, java.lang.String r28, int r29, com.baidu.searchbox.flowvideo.detail.api.EnhanceButtonBean r30, int r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r18
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r19
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r20
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r21
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r22
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r23
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = 0
            goto L_0x003c
        L_0x003a:
            r8 = r24
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r25
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r26
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = 0
            goto L_0x0054
        L_0x0052:
            r12 = r27
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r2
            goto L_0x005c
        L_0x005a:
            r13 = r28
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = 0
            goto L_0x0064
        L_0x0062:
            r14 = r29
        L_0x0064:
            r9 = r0 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x006a
            r9 = 0
            goto L_0x006c
        L_0x006a:
            r9 = r30
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = 0
            goto L_0x0074
        L_0x0072:
            r15 = r31
        L_0x0074:
            r35 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007d
            r2 = r35
            goto L_0x007f
        L_0x007d:
            r2 = r32
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0089
            r0 = r35
            goto L_0x008b
        L_0x0089:
            r0 = r33
        L_0x008b:
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r9
            r31 = r15
            r32 = r2
            r33 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.detail.api.FlowDetailShareBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, int, com.baidu.searchbox.flowvideo.detail.api.EnhanceButtonBean, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getCategoryInfo() {
        return this.categoryInfo;
    }

    public final String getShareNum() {
        return this.shareNum;
    }

    public final String getShareTrigger() {
        return this.shareTrigger;
    }

    public final ArrayList<FlowDetailShareBtnBean> getAddButton() {
        return this.addButton;
    }

    public final String getFeedback() {
        return this.feedback;
    }

    public final int getHideSharePanelAnim() {
        return this.hideSharePanelAnim;
    }

    public final EnhanceButtonBean getEnhanceButton() {
        return this.enhanceButton;
    }

    public final int getType() {
        return this.type;
    }

    public final String getDisable() {
        return this.disable;
    }

    public final String getDtShareCmd() {
        return this.dtShareCmd;
    }
}
