package com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/panelBgmAndAnim/BgmInfo;", "", "cardNid", "", "url", "from", "page", "cardTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardNid", "()Ljava/lang/String;", "setCardNid", "(Ljava/lang/String;)V", "getCardTitle", "setCardTitle", "getFrom", "getPage", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BgmInfo.kt */
public final class BgmInfo {
    private String cardNid;
    private String cardTitle;
    private final String from;
    private final String page;
    private String url;

    public static /* synthetic */ BgmInfo copy$default(BgmInfo bgmInfo, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bgmInfo.cardNid;
        }
        if ((i2 & 2) != 0) {
            str2 = bgmInfo.url;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = bgmInfo.from;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = bgmInfo.page;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = bgmInfo.cardTitle;
        }
        return bgmInfo.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.cardNid;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.from;
    }

    public final String component4() {
        return this.page;
    }

    public final String component5() {
        return this.cardTitle;
    }

    public final BgmInfo copy(String str, String str2, String str3, String str4, String str5) {
        return new BgmInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BgmInfo)) {
            return false;
        }
        BgmInfo bgmInfo = (BgmInfo) obj;
        return Intrinsics.areEqual((Object) this.cardNid, (Object) bgmInfo.cardNid) && Intrinsics.areEqual((Object) this.url, (Object) bgmInfo.url) && Intrinsics.areEqual((Object) this.from, (Object) bgmInfo.from) && Intrinsics.areEqual((Object) this.page, (Object) bgmInfo.page) && Intrinsics.areEqual((Object) this.cardTitle, (Object) bgmInfo.cardTitle);
    }

    public int hashCode() {
        String str = this.cardNid;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.from;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.page;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cardTitle;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "BgmInfo(cardNid=" + this.cardNid + ", url=" + this.url + ", from=" + this.from + ", page=" + this.page + ", cardTitle=" + this.cardTitle + ')';
    }

    public BgmInfo(String cardNid2, String url2, String from2, String page2, String cardTitle2) {
        this.cardNid = cardNid2;
        this.url = url2;
        this.from = from2;
        this.page = page2;
        this.cardTitle = cardTitle2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BgmInfo(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x0007
            r8 = 0
            r2 = r8
            goto L_0x0008
        L_0x0007:
            r2 = r8
        L_0x0008:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0010
            java.lang.String r9 = "flow_music"
            r3 = r9
            goto L_0x0011
        L_0x0010:
            r3 = r9
        L_0x0011:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0019
            java.lang.String r10 = "flow_music_card"
            r4 = r10
            goto L_0x001a
        L_0x0019:
            r4 = r10
        L_0x001a:
            r0 = r6
            r1 = r7
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.BgmInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCardNid() {
        return this.cardNid;
    }

    public final void setCardNid(String str) {
        this.cardNid = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final void setCardTitle(String str) {
        this.cardTitle = str;
    }
}
