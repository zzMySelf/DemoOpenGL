package com.baidu.searchbox.sport.olympic.base.model;

import com.baidu.searchbox.download.center.ui.fusion.manager.decoder.ParseJsonKey;
import com.baidu.searchbox.sport.model.MedalInfo;
import com.baidu.searchbox.sport.model.OlympicBgColorInfo;
import com.baidu.searchbox.sport.model.RankInfo;
import com.baidu.searchbox.sport.model.ShareInfo;
import com.baidu.searchbox.sport.model.TabBgColorInfo;
import com.baidu.searchbox.sport.model.TabInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\b\b\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u00109\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\nHÖ\u0001J\t\u0010<\u001a\u00020\bHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001e¨\u0006="}, d2 = {"Lcom/baidu/searchbox/sport/olympic/base/model/OlympicPageCommonModel;", "", "isRefresh", "", "tabList", "", "Lcom/baidu/searchbox/sport/model/TabInfo;", "shareLogo", "", "bgColor", "", "medalInfoDesc", "medalInfo", "Lcom/baidu/searchbox/sport/model/MedalInfo;", "rankInfo", "Lcom/baidu/searchbox/sport/model/RankInfo;", "topBgColorInfo", "Lcom/baidu/searchbox/sport/model/OlympicBgColorInfo;", "topBgImage", "tabBgColorInfo", "Lcom/baidu/searchbox/sport/model/TabBgColorInfo;", "shareInfo", "Lcom/baidu/searchbox/sport/model/ShareInfo;", "(ZLjava/util/List;Ljava/lang/String;ILjava/lang/String;Lcom/baidu/searchbox/sport/model/MedalInfo;Lcom/baidu/searchbox/sport/model/RankInfo;Lcom/baidu/searchbox/sport/model/OlympicBgColorInfo;Ljava/lang/String;Lcom/baidu/searchbox/sport/model/TabBgColorInfo;Lcom/baidu/searchbox/sport/model/ShareInfo;)V", "getBgColor", "()I", "()Z", "getMedalInfo", "()Lcom/baidu/searchbox/sport/model/MedalInfo;", "getMedalInfoDesc", "()Ljava/lang/String;", "getRankInfo", "()Lcom/baidu/searchbox/sport/model/RankInfo;", "getShareInfo", "()Lcom/baidu/searchbox/sport/model/ShareInfo;", "setShareInfo", "(Lcom/baidu/searchbox/sport/model/ShareInfo;)V", "getShareLogo", "getTabBgColorInfo", "()Lcom/baidu/searchbox/sport/model/TabBgColorInfo;", "getTabList", "()Ljava/util/List;", "getTopBgColorInfo", "()Lcom/baidu/searchbox/sport/model/OlympicBgColorInfo;", "getTopBgImage", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicPageCommonModel.kt */
public final class OlympicPageCommonModel {
    private final int bgColor;
    private final boolean isRefresh;
    private final MedalInfo medalInfo;
    private final String medalInfoDesc;
    private final RankInfo rankInfo;
    private ShareInfo shareInfo;
    private final String shareLogo;
    private final TabBgColorInfo tabBgColorInfo;
    private final List<TabInfo> tabList;
    private final OlympicBgColorInfo topBgColorInfo;
    private final String topBgImage;

    public static /* synthetic */ OlympicPageCommonModel copy$default(OlympicPageCommonModel olympicPageCommonModel, boolean z, List list, String str, int i2, String str2, MedalInfo medalInfo2, RankInfo rankInfo2, OlympicBgColorInfo olympicBgColorInfo, String str3, TabBgColorInfo tabBgColorInfo2, ShareInfo shareInfo2, int i3, Object obj) {
        OlympicPageCommonModel olympicPageCommonModel2 = olympicPageCommonModel;
        int i4 = i3;
        return olympicPageCommonModel.copy((i4 & 1) != 0 ? olympicPageCommonModel2.isRefresh : z, (i4 & 2) != 0 ? olympicPageCommonModel2.tabList : list, (i4 & 4) != 0 ? olympicPageCommonModel2.shareLogo : str, (i4 & 8) != 0 ? olympicPageCommonModel2.bgColor : i2, (i4 & 16) != 0 ? olympicPageCommonModel2.medalInfoDesc : str2, (i4 & 32) != 0 ? olympicPageCommonModel2.medalInfo : medalInfo2, (i4 & 64) != 0 ? olympicPageCommonModel2.rankInfo : rankInfo2, (i4 & 128) != 0 ? olympicPageCommonModel2.topBgColorInfo : olympicBgColorInfo, (i4 & 256) != 0 ? olympicPageCommonModel2.topBgImage : str3, (i4 & 512) != 0 ? olympicPageCommonModel2.tabBgColorInfo : tabBgColorInfo2, (i4 & 1024) != 0 ? olympicPageCommonModel2.shareInfo : shareInfo2);
    }

    public final boolean component1() {
        return this.isRefresh;
    }

    public final TabBgColorInfo component10() {
        return this.tabBgColorInfo;
    }

    public final ShareInfo component11() {
        return this.shareInfo;
    }

    public final List<TabInfo> component2() {
        return this.tabList;
    }

    public final String component3() {
        return this.shareLogo;
    }

    public final int component4() {
        return this.bgColor;
    }

    public final String component5() {
        return this.medalInfoDesc;
    }

    public final MedalInfo component6() {
        return this.medalInfo;
    }

    public final RankInfo component7() {
        return this.rankInfo;
    }

    public final OlympicBgColorInfo component8() {
        return this.topBgColorInfo;
    }

    public final String component9() {
        return this.topBgImage;
    }

    public final OlympicPageCommonModel copy(boolean z, List<? extends TabInfo> list, String str, int i2, String str2, MedalInfo medalInfo2, RankInfo rankInfo2, OlympicBgColorInfo olympicBgColorInfo, String str3, TabBgColorInfo tabBgColorInfo2, ShareInfo shareInfo2) {
        Intrinsics.checkNotNullParameter(list, ParseJsonKey.GROUP_TAB_LIST);
        Intrinsics.checkNotNullParameter(str, "shareLogo");
        return new OlympicPageCommonModel(z, list, str, i2, str2, medalInfo2, rankInfo2, olympicBgColorInfo, str3, tabBgColorInfo2, shareInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OlympicPageCommonModel)) {
            return false;
        }
        OlympicPageCommonModel olympicPageCommonModel = (OlympicPageCommonModel) obj;
        return this.isRefresh == olympicPageCommonModel.isRefresh && Intrinsics.areEqual((Object) this.tabList, (Object) olympicPageCommonModel.tabList) && Intrinsics.areEqual((Object) this.shareLogo, (Object) olympicPageCommonModel.shareLogo) && this.bgColor == olympicPageCommonModel.bgColor && Intrinsics.areEqual((Object) this.medalInfoDesc, (Object) olympicPageCommonModel.medalInfoDesc) && Intrinsics.areEqual((Object) this.medalInfo, (Object) olympicPageCommonModel.medalInfo) && Intrinsics.areEqual((Object) this.rankInfo, (Object) olympicPageCommonModel.rankInfo) && Intrinsics.areEqual((Object) this.topBgColorInfo, (Object) olympicPageCommonModel.topBgColorInfo) && Intrinsics.areEqual((Object) this.topBgImage, (Object) olympicPageCommonModel.topBgImage) && Intrinsics.areEqual((Object) this.tabBgColorInfo, (Object) olympicPageCommonModel.tabBgColorInfo) && Intrinsics.areEqual((Object) this.shareInfo, (Object) olympicPageCommonModel.shareInfo);
    }

    public int hashCode() {
        boolean z = this.isRefresh;
        if (z) {
            z = true;
        }
        int hashCode = (((((((z ? 1 : 0) * true) + this.tabList.hashCode()) * 31) + this.shareLogo.hashCode()) * 31) + Integer.hashCode(this.bgColor)) * 31;
        String str = this.medalInfoDesc;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        MedalInfo medalInfo2 = this.medalInfo;
        int hashCode3 = (hashCode2 + (medalInfo2 == null ? 0 : medalInfo2.hashCode())) * 31;
        RankInfo rankInfo2 = this.rankInfo;
        int hashCode4 = (hashCode3 + (rankInfo2 == null ? 0 : rankInfo2.hashCode())) * 31;
        OlympicBgColorInfo olympicBgColorInfo = this.topBgColorInfo;
        int hashCode5 = (hashCode4 + (olympicBgColorInfo == null ? 0 : olympicBgColorInfo.hashCode())) * 31;
        String str2 = this.topBgImage;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        TabBgColorInfo tabBgColorInfo2 = this.tabBgColorInfo;
        int hashCode7 = (hashCode6 + (tabBgColorInfo2 == null ? 0 : tabBgColorInfo2.hashCode())) * 31;
        ShareInfo shareInfo2 = this.shareInfo;
        if (shareInfo2 != null) {
            i2 = shareInfo2.hashCode();
        }
        return hashCode7 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OlympicPageCommonModel(isRefresh=").append(this.isRefresh).append(", tabList=").append(this.tabList).append(", shareLogo=").append(this.shareLogo).append(", bgColor=").append(this.bgColor).append(", medalInfoDesc=").append(this.medalInfoDesc).append(", medalInfo=").append(this.medalInfo).append(", rankInfo=").append(this.rankInfo).append(", topBgColorInfo=").append(this.topBgColorInfo).append(", topBgImage=").append(this.topBgImage).append(", tabBgColorInfo=").append(this.tabBgColorInfo).append(", shareInfo=").append(this.shareInfo).append(')');
        return sb.toString();
    }

    public OlympicPageCommonModel(boolean isRefresh2, List<? extends TabInfo> tabList2, String shareLogo2, int bgColor2, String medalInfoDesc2, MedalInfo medalInfo2, RankInfo rankInfo2, OlympicBgColorInfo topBgColorInfo2, String topBgImage2, TabBgColorInfo tabBgColorInfo2, ShareInfo shareInfo2) {
        Intrinsics.checkNotNullParameter(tabList2, ParseJsonKey.GROUP_TAB_LIST);
        Intrinsics.checkNotNullParameter(shareLogo2, "shareLogo");
        this.isRefresh = isRefresh2;
        this.tabList = tabList2;
        this.shareLogo = shareLogo2;
        this.bgColor = bgColor2;
        this.medalInfoDesc = medalInfoDesc2;
        this.medalInfo = medalInfo2;
        this.rankInfo = rankInfo2;
        this.topBgColorInfo = topBgColorInfo2;
        this.topBgImage = topBgImage2;
        this.tabBgColorInfo = tabBgColorInfo2;
        this.shareInfo = shareInfo2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OlympicPageCommonModel(boolean r16, java.util.List r17, java.lang.String r18, int r19, java.lang.String r20, com.baidu.searchbox.sport.model.MedalInfo r21, com.baidu.searchbox.sport.model.RankInfo r22, com.baidu.searchbox.sport.model.OlympicBgColorInfo r23, java.lang.String r24, com.baidu.searchbox.sport.model.TabBgColorInfo r25, com.baidu.searchbox.sport.model.ShareInfo r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 16
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r8 = r2
            goto L_0x000c
        L_0x000a:
            r8 = r20
        L_0x000c:
            r1 = r0 & 32
            r3 = 0
            if (r1 == 0) goto L_0x0013
            r9 = r3
            goto L_0x0015
        L_0x0013:
            r9 = r21
        L_0x0015:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001b
            r10 = r3
            goto L_0x001d
        L_0x001b:
            r10 = r22
        L_0x001d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0023
            r11 = r3
            goto L_0x0025
        L_0x0023:
            r11 = r23
        L_0x0025:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002b
            r12 = r2
            goto L_0x002d
        L_0x002b:
            r12 = r24
        L_0x002d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0033
            r13 = r3
            goto L_0x0035
        L_0x0033:
            r13 = r25
        L_0x0035:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x003b
            r14 = r3
            goto L_0x003d
        L_0x003b:
            r14 = r26
        L_0x003d:
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.olympic.base.model.OlympicPageCommonModel.<init>(boolean, java.util.List, java.lang.String, int, java.lang.String, com.baidu.searchbox.sport.model.MedalInfo, com.baidu.searchbox.sport.model.RankInfo, com.baidu.searchbox.sport.model.OlympicBgColorInfo, java.lang.String, com.baidu.searchbox.sport.model.TabBgColorInfo, com.baidu.searchbox.sport.model.ShareInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final List<TabInfo> getTabList() {
        return this.tabList;
    }

    public final String getShareLogo() {
        return this.shareLogo;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final String getMedalInfoDesc() {
        return this.medalInfoDesc;
    }

    public final MedalInfo getMedalInfo() {
        return this.medalInfo;
    }

    public final RankInfo getRankInfo() {
        return this.rankInfo;
    }

    public final OlympicBgColorInfo getTopBgColorInfo() {
        return this.topBgColorInfo;
    }

    public final String getTopBgImage() {
        return this.topBgImage;
    }

    public final TabBgColorInfo getTabBgColorInfo() {
        return this.tabBgColorInfo;
    }

    public final ShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public final void setShareInfo(ShareInfo shareInfo2) {
        this.shareInfo = shareInfo2;
    }
}
