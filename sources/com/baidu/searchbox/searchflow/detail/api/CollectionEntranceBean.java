package com.baidu.searchbox.searchflow.detail.api;

import com.baidu.browser.core.data.BdDXXmlParser;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.flowvideo.flow.api.PoliciesBean;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00105\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/searchflow/detail/api/CollectionEntranceBean;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "subTitle", "hejiId", "hasNext", "hasPre", "collectionCount", "", "rn", "pn", "hasTab", "anchorIndex", "hejiPoster", "items", "isAuthorColl", "", "policies", "Lcom/baidu/searchbox/flowvideo/flow/api/PoliciesBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;ZLcom/baidu/searchbox/flowvideo/flow/api/PoliciesBean;)V", "getAnchorIndex", "()I", "getCollectionCount", "getHasNext", "()Ljava/lang/String;", "getHasPre", "getHasTab", "getHejiId", "getHejiPoster", "()Z", "getItems", "getPn", "getPolicies", "()Lcom/baidu/searchbox/flowvideo/flow/api/PoliciesBean;", "getRn", "getSubTitle", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotablyAreaBean.kt */
public final class CollectionEntranceBean implements NoProGuard {
    private final int anchorIndex;
    @SerializedName("hejiSum")
    private final int collectionCount;
    private final String hasNext;
    @SerializedName(alternate = {"hasPrev"}, value = "hasPre")
    private final String hasPre;
    private final int hasTab;
    private final String hejiId;
    private final String hejiPoster;
    private final boolean isAuthorColl;
    private final String items;
    private final int pn;
    private final PoliciesBean policies;
    private final int rn;
    @SerializedName(alternate = {"subtitle"}, value = "subTitle")
    private final String subTitle;
    private final String title;

    public CollectionEntranceBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, 0, 0, (String) null, (String) null, false, (PoliciesBean) null, BdDXXmlParser.BYTE_2_PROPERTY, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CollectionEntranceBean copy$default(CollectionEntranceBean collectionEntranceBean, String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5, int i6, String str6, String str7, boolean z, PoliciesBean policiesBean, int i7, Object obj) {
        CollectionEntranceBean collectionEntranceBean2 = collectionEntranceBean;
        int i8 = i7;
        return collectionEntranceBean.copy((i8 & 1) != 0 ? collectionEntranceBean2.title : str, (i8 & 2) != 0 ? collectionEntranceBean2.subTitle : str2, (i8 & 4) != 0 ? collectionEntranceBean2.hejiId : str3, (i8 & 8) != 0 ? collectionEntranceBean2.hasNext : str4, (i8 & 16) != 0 ? collectionEntranceBean2.hasPre : str5, (i8 & 32) != 0 ? collectionEntranceBean2.collectionCount : i2, (i8 & 64) != 0 ? collectionEntranceBean2.rn : i3, (i8 & 128) != 0 ? collectionEntranceBean2.pn : i4, (i8 & 256) != 0 ? collectionEntranceBean2.hasTab : i5, (i8 & 512) != 0 ? collectionEntranceBean2.anchorIndex : i6, (i8 & 1024) != 0 ? collectionEntranceBean2.hejiPoster : str6, (i8 & 2048) != 0 ? collectionEntranceBean2.items : str7, (i8 & 4096) != 0 ? collectionEntranceBean2.isAuthorColl : z, (i8 & 8192) != 0 ? collectionEntranceBean2.policies : policiesBean);
    }

    public final String component1() {
        return this.title;
    }

    public final int component10() {
        return this.anchorIndex;
    }

    public final String component11() {
        return this.hejiPoster;
    }

    public final String component12() {
        return this.items;
    }

    public final boolean component13() {
        return this.isAuthorColl;
    }

    public final PoliciesBean component14() {
        return this.policies;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.hejiId;
    }

    public final String component4() {
        return this.hasNext;
    }

    public final String component5() {
        return this.hasPre;
    }

    public final int component6() {
        return this.collectionCount;
    }

    public final int component7() {
        return this.rn;
    }

    public final int component8() {
        return this.pn;
    }

    public final int component9() {
        return this.hasTab;
    }

    public final CollectionEntranceBean copy(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5, int i6, String str6, String str7, boolean z, PoliciesBean policiesBean) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(str3, IntentData.KEY_COLLECTION_ID);
        Intrinsics.checkNotNullParameter(str4, "hasNext");
        Intrinsics.checkNotNullParameter(str5, "hasPre");
        Intrinsics.checkNotNullParameter(str6, "hejiPoster");
        Intrinsics.checkNotNullParameter(str7, "items");
        return new CollectionEntranceBean(str, str2, str3, str4, str5, i2, i3, i4, i5, i6, str6, str7, z, policiesBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionEntranceBean)) {
            return false;
        }
        CollectionEntranceBean collectionEntranceBean = (CollectionEntranceBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) collectionEntranceBean.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) collectionEntranceBean.subTitle) && Intrinsics.areEqual((Object) this.hejiId, (Object) collectionEntranceBean.hejiId) && Intrinsics.areEqual((Object) this.hasNext, (Object) collectionEntranceBean.hasNext) && Intrinsics.areEqual((Object) this.hasPre, (Object) collectionEntranceBean.hasPre) && this.collectionCount == collectionEntranceBean.collectionCount && this.rn == collectionEntranceBean.rn && this.pn == collectionEntranceBean.pn && this.hasTab == collectionEntranceBean.hasTab && this.anchorIndex == collectionEntranceBean.anchorIndex && Intrinsics.areEqual((Object) this.hejiPoster, (Object) collectionEntranceBean.hejiPoster) && Intrinsics.areEqual((Object) this.items, (Object) collectionEntranceBean.items) && this.isAuthorColl == collectionEntranceBean.isAuthorColl && Intrinsics.areEqual((Object) this.policies, (Object) collectionEntranceBean.policies);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.hejiId.hashCode()) * 31) + this.hasNext.hashCode()) * 31) + this.hasPre.hashCode()) * 31) + Integer.hashCode(this.collectionCount)) * 31) + Integer.hashCode(this.rn)) * 31) + Integer.hashCode(this.pn)) * 31) + Integer.hashCode(this.hasTab)) * 31) + Integer.hashCode(this.anchorIndex)) * 31) + this.hejiPoster.hashCode()) * 31) + this.items.hashCode()) * 31;
        boolean z = this.isAuthorColl;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        PoliciesBean policiesBean = this.policies;
        return i2 + (policiesBean == null ? 0 : policiesBean.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CollectionEntranceBean(title=").append(this.title).append(", subTitle=").append(this.subTitle).append(", hejiId=").append(this.hejiId).append(", hasNext=").append(this.hasNext).append(", hasPre=").append(this.hasPre).append(", collectionCount=").append(this.collectionCount).append(", rn=").append(this.rn).append(", pn=").append(this.pn).append(", hasTab=").append(this.hasTab).append(", anchorIndex=").append(this.anchorIndex).append(", hejiPoster=").append(this.hejiPoster).append(", items=");
        sb.append(this.items).append(", isAuthorColl=").append(this.isAuthorColl).append(", policies=").append(this.policies).append(')');
        return sb.toString();
    }

    public CollectionEntranceBean(String title2, String subTitle2, String hejiId2, String hasNext2, String hasPre2, int collectionCount2, int rn2, int pn2, int hasTab2, int anchorIndex2, String hejiPoster2, String items2, boolean isAuthorColl2, PoliciesBean policies2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(subTitle2, "subTitle");
        Intrinsics.checkNotNullParameter(hejiId2, IntentData.KEY_COLLECTION_ID);
        Intrinsics.checkNotNullParameter(hasNext2, "hasNext");
        Intrinsics.checkNotNullParameter(hasPre2, "hasPre");
        Intrinsics.checkNotNullParameter(hejiPoster2, "hejiPoster");
        Intrinsics.checkNotNullParameter(items2, "items");
        this.title = title2;
        this.subTitle = subTitle2;
        this.hejiId = hejiId2;
        this.hasNext = hasNext2;
        this.hasPre = hasPre2;
        this.collectionCount = collectionCount2;
        this.rn = rn2;
        this.pn = pn2;
        this.hasTab = hasTab2;
        this.anchorIndex = anchorIndex2;
        this.hejiPoster = hejiPoster2;
        this.items = items2;
        this.isAuthorColl = isAuthorColl2;
        this.policies = policies2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CollectionEntranceBean(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, int r23, int r24, int r25, java.lang.String r26, java.lang.String r27, boolean r28, com.baidu.searchbox.flowvideo.flow.api.PoliciesBean r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r16
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r17
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r18
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r19
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r20
        L_0x002c:
            r7 = r0 & 32
            r8 = -1
            if (r7 == 0) goto L_0x0033
            r7 = r8
            goto L_0x0035
        L_0x0033:
            r7 = r21
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = r8
            goto L_0x003d
        L_0x003b:
            r9 = r22
        L_0x003d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            r10 = r8
            goto L_0x0045
        L_0x0043:
            r10 = r23
        L_0x0045:
            r11 = r0 & 256(0x100, float:3.59E-43)
            r12 = 0
            if (r11 == 0) goto L_0x004c
            r11 = r12
            goto L_0x004e
        L_0x004c:
            r11 = r24
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r8 = r25
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005b
            r13 = r2
            goto L_0x005d
        L_0x005b:
            r13 = r26
        L_0x005d:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r2 = r27
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r12 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0071
            r0 = 0
            goto L_0x0073
        L_0x0071:
            r0 = r29
        L_0x0073:
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r8
            r26 = r13
            r27 = r2
            r28 = r12
            r29 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.searchflow.detail.api.CollectionEntranceBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int, java.lang.String, java.lang.String, boolean, com.baidu.searchbox.flowvideo.flow.api.PoliciesBean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getHejiId() {
        return this.hejiId;
    }

    public final String getHasNext() {
        return this.hasNext;
    }

    public final String getHasPre() {
        return this.hasPre;
    }

    public final int getCollectionCount() {
        return this.collectionCount;
    }

    public final int getRn() {
        return this.rn;
    }

    public final int getPn() {
        return this.pn;
    }

    public final int getHasTab() {
        return this.hasTab;
    }

    public final int getAnchorIndex() {
        return this.anchorIndex;
    }

    public final String getHejiPoster() {
        return this.hejiPoster;
    }

    public final String getItems() {
        return this.items;
    }

    public final boolean isAuthorColl() {
        return this.isAuthorColl;
    }

    public final PoliciesBean getPolicies() {
        return this.policies;
    }
}
