package com.baidu.searchbox.video.feedflow.detail.favor;

import com.baidu.searchbox.flowvideo.detail.repos.FavorType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b4\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0002\u0010\u0013J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0010HÆ\u0003J{\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010HÆ\u0001J\u0013\u0010@\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010*\"\u0004\b-\u0010,R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001b¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/favor/DoFavorModel;", "", "nid", "", "favorData", "favorNum", "", "favorUrl", "ext", "Lorg/json/JSONObject;", "source", "favorType", "Lcom/baidu/searchbox/flowvideo/detail/repos/FavorType;", "favorToastType", "Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorToastType;", "needUseOutSource", "", "isFromLongClick", "isSingleClickFavorCollection", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/FavorType;Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorToastType;ZZZ)V", "getExt", "()Lorg/json/JSONObject;", "setExt", "(Lorg/json/JSONObject;)V", "getFavorData", "()Ljava/lang/String;", "setFavorData", "(Ljava/lang/String;)V", "getFavorNum", "()I", "setFavorNum", "(I)V", "getFavorToastType", "()Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorToastType;", "setFavorToastType", "(Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorToastType;)V", "getFavorType", "()Lcom/baidu/searchbox/flowvideo/detail/repos/FavorType;", "setFavorType", "(Lcom/baidu/searchbox/flowvideo/detail/repos/FavorType;)V", "getFavorUrl", "setFavorUrl", "()Z", "setFromLongClick", "(Z)V", "setSingleClickFavorCollection", "getNeedUseOutSource", "setNeedUseOutSource", "getNid", "setNid", "getSource", "setSource", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorModel.kt */
public final class DoFavorModel {
    private JSONObject ext;
    private String favorData;
    private int favorNum;
    private FavorToastType favorToastType;
    private FavorType favorType;
    private String favorUrl;
    private boolean isFromLongClick;
    private boolean isSingleClickFavorCollection;
    private boolean needUseOutSource;
    private String nid;
    private String source;

    public static /* synthetic */ DoFavorModel copy$default(DoFavorModel doFavorModel, String str, String str2, int i2, String str3, JSONObject jSONObject, String str4, FavorType favorType2, FavorToastType favorToastType2, boolean z, boolean z2, boolean z3, int i3, Object obj) {
        DoFavorModel doFavorModel2 = doFavorModel;
        int i4 = i3;
        return doFavorModel.copy((i4 & 1) != 0 ? doFavorModel2.nid : str, (i4 & 2) != 0 ? doFavorModel2.favorData : str2, (i4 & 4) != 0 ? doFavorModel2.favorNum : i2, (i4 & 8) != 0 ? doFavorModel2.favorUrl : str3, (i4 & 16) != 0 ? doFavorModel2.ext : jSONObject, (i4 & 32) != 0 ? doFavorModel2.source : str4, (i4 & 64) != 0 ? doFavorModel2.favorType : favorType2, (i4 & 128) != 0 ? doFavorModel2.favorToastType : favorToastType2, (i4 & 256) != 0 ? doFavorModel2.needUseOutSource : z, (i4 & 512) != 0 ? doFavorModel2.isFromLongClick : z2, (i4 & 1024) != 0 ? doFavorModel2.isSingleClickFavorCollection : z3);
    }

    public final String component1() {
        return this.nid;
    }

    public final boolean component10() {
        return this.isFromLongClick;
    }

    public final boolean component11() {
        return this.isSingleClickFavorCollection;
    }

    public final String component2() {
        return this.favorData;
    }

    public final int component3() {
        return this.favorNum;
    }

    public final String component4() {
        return this.favorUrl;
    }

    public final JSONObject component5() {
        return this.ext;
    }

    public final String component6() {
        return this.source;
    }

    public final FavorType component7() {
        return this.favorType;
    }

    public final FavorToastType component8() {
        return this.favorToastType;
    }

    public final boolean component9() {
        return this.needUseOutSource;
    }

    public final DoFavorModel copy(String str, String str2, int i2, String str3, JSONObject jSONObject, String str4, FavorType favorType2, FavorToastType favorToastType2, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "nid");
        Intrinsics.checkNotNullParameter(str2, "favorData");
        Intrinsics.checkNotNullParameter(str3, "favorUrl");
        Intrinsics.checkNotNullParameter(favorType2, "favorType");
        Intrinsics.checkNotNullParameter(favorToastType2, "favorToastType");
        return new DoFavorModel(str, str2, i2, str3, jSONObject, str4, favorType2, favorToastType2, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoFavorModel)) {
            return false;
        }
        DoFavorModel doFavorModel = (DoFavorModel) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) doFavorModel.nid) && Intrinsics.areEqual((Object) this.favorData, (Object) doFavorModel.favorData) && this.favorNum == doFavorModel.favorNum && Intrinsics.areEqual((Object) this.favorUrl, (Object) doFavorModel.favorUrl) && Intrinsics.areEqual((Object) this.ext, (Object) doFavorModel.ext) && Intrinsics.areEqual((Object) this.source, (Object) doFavorModel.source) && Intrinsics.areEqual((Object) this.favorType, (Object) doFavorModel.favorType) && this.favorToastType == doFavorModel.favorToastType && this.needUseOutSource == doFavorModel.needUseOutSource && this.isFromLongClick == doFavorModel.isFromLongClick && this.isSingleClickFavorCollection == doFavorModel.isSingleClickFavorCollection;
    }

    public int hashCode() {
        int hashCode = ((((((this.nid.hashCode() * 31) + this.favorData.hashCode()) * 31) + Integer.hashCode(this.favorNum)) * 31) + this.favorUrl.hashCode()) * 31;
        JSONObject jSONObject = this.ext;
        int i2 = 0;
        int hashCode2 = (hashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str = this.source;
        if (str != null) {
            i2 = str.hashCode();
        }
        int hashCode3 = (((((hashCode2 + i2) * 31) + this.favorType.hashCode()) * 31) + this.favorToastType.hashCode()) * 31;
        boolean z = this.needUseOutSource;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isFromLongClick;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isSingleClickFavorCollection;
        if (!z4) {
            z2 = z4;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoFavorModel(nid=").append(this.nid).append(", favorData=").append(this.favorData).append(", favorNum=").append(this.favorNum).append(", favorUrl=").append(this.favorUrl).append(", ext=").append(this.ext).append(", source=").append(this.source).append(", favorType=").append(this.favorType).append(", favorToastType=").append(this.favorToastType).append(", needUseOutSource=").append(this.needUseOutSource).append(", isFromLongClick=").append(this.isFromLongClick).append(", isSingleClickFavorCollection=").append(this.isSingleClickFavorCollection).append(')');
        return sb.toString();
    }

    public DoFavorModel(String nid2, String favorData2, int favorNum2, String favorUrl2, JSONObject ext2, String source2, FavorType favorType2, FavorToastType favorToastType2, boolean needUseOutSource2, boolean isFromLongClick2, boolean isSingleClickFavorCollection2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(favorData2, "favorData");
        Intrinsics.checkNotNullParameter(favorUrl2, "favorUrl");
        Intrinsics.checkNotNullParameter(favorType2, "favorType");
        Intrinsics.checkNotNullParameter(favorToastType2, "favorToastType");
        this.nid = nid2;
        this.favorData = favorData2;
        this.favorNum = favorNum2;
        this.favorUrl = favorUrl2;
        this.ext = ext2;
        this.source = source2;
        this.favorType = favorType2;
        this.favorToastType = favorToastType2;
        this.needUseOutSource = needUseOutSource2;
        this.isFromLongClick = isFromLongClick2;
        this.isSingleClickFavorCollection = isSingleClickFavorCollection2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DoFavorModel(java.lang.String r15, java.lang.String r16, int r17, java.lang.String r18, org.json.JSONObject r19, java.lang.String r20, com.baidu.searchbox.flowvideo.detail.repos.FavorType r21, com.baidu.searchbox.video.feedflow.detail.favor.FavorToastType r22, boolean r23, boolean r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 8
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = ""
            r6 = r1
            goto L_0x000c
        L_0x000a:
            r6 = r18
        L_0x000c:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r7 = r2
            goto L_0x0015
        L_0x0013:
            r7 = r19
        L_0x0015:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001b
            r8 = r2
            goto L_0x001d
        L_0x001b:
            r8 = r20
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0027
            com.baidu.searchbox.flowvideo.detail.repos.FavorType$SingleVideoFavor r1 = com.baidu.searchbox.flowvideo.detail.repos.FavorType.SingleVideoFavor.INSTANCE
            com.baidu.searchbox.flowvideo.detail.repos.FavorType r1 = (com.baidu.searchbox.flowvideo.detail.repos.FavorType) r1
            r9 = r1
            goto L_0x0029
        L_0x0027:
            r9 = r21
        L_0x0029:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            com.baidu.searchbox.video.feedflow.detail.favor.FavorToastType r1 = com.baidu.searchbox.video.feedflow.detail.favor.FavorToastType.DEFAULT_TOAST
            r10 = r1
            goto L_0x0033
        L_0x0031:
            r10 = r22
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x003a
            r11 = r2
            goto L_0x003c
        L_0x003a:
            r11 = r23
        L_0x003c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0042
            r12 = r2
            goto L_0x0044
        L_0x0042:
            r12 = r24
        L_0x0044:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x004a
            r13 = r2
            goto L_0x004c
        L_0x004a:
            r13 = r25
        L_0x004c:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.favor.DoFavorModel.<init>(java.lang.String, java.lang.String, int, java.lang.String, org.json.JSONObject, java.lang.String, com.baidu.searchbox.flowvideo.detail.repos.FavorType, com.baidu.searchbox.video.feedflow.detail.favor.FavorToastType, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nid = str;
    }

    public final String getFavorData() {
        return this.favorData;
    }

    public final void setFavorData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.favorData = str;
    }

    public final int getFavorNum() {
        return this.favorNum;
    }

    public final void setFavorNum(int i2) {
        this.favorNum = i2;
    }

    public final String getFavorUrl() {
        return this.favorUrl;
    }

    public final void setFavorUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.favorUrl = str;
    }

    public final JSONObject getExt() {
        return this.ext;
    }

    public final void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final FavorType getFavorType() {
        return this.favorType;
    }

    public final void setFavorType(FavorType favorType2) {
        Intrinsics.checkNotNullParameter(favorType2, "<set-?>");
        this.favorType = favorType2;
    }

    public final FavorToastType getFavorToastType() {
        return this.favorToastType;
    }

    public final void setFavorToastType(FavorToastType favorToastType2) {
        Intrinsics.checkNotNullParameter(favorToastType2, "<set-?>");
        this.favorToastType = favorToastType2;
    }

    public final boolean getNeedUseOutSource() {
        return this.needUseOutSource;
    }

    public final void setNeedUseOutSource(boolean z) {
        this.needUseOutSource = z;
    }

    public final boolean isFromLongClick() {
        return this.isFromLongClick;
    }

    public final void setFromLongClick(boolean z) {
        this.isFromLongClick = z;
    }

    public final boolean isSingleClickFavorCollection() {
        return this.isSingleClickFavorCollection;
    }

    public final void setSingleClickFavorCollection(boolean z) {
        this.isSingleClickFavorCollection = z;
    }
}
