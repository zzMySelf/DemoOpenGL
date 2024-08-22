package com.baidu.nadcore.unifiedtool.infoboard;

import com.baidu.browser.core.data.BdDXXmlParser;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/baidu/nadcore/unifiedtool/infoboard/AlsLogItemData;", "", "request", "", "response", "cMatch", "page", "mt", "area", "ideaId", "type", "daExt1", "daExt2", "daExt3", "daExt4", "daExt5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()Ljava/lang/String;", "getCMatch", "getDaExt1", "getDaExt2", "getDaExt3", "getDaExt4", "getDaExt5", "getIdeaId", "getMt", "getPage", "getRequest", "getResponse", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "nadcore-lib-debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InfoBoard.kt */
public final class AlsLogItemData {
    private final String area;
    private final String cMatch;
    private final String daExt1;
    private final String daExt2;
    private final String daExt3;
    private final String daExt4;
    private final String daExt5;
    private final String ideaId;
    private final String mt;
    private final String page;
    private final String request;
    private final String response;
    private final String type;

    public AlsLogItemData() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, BdDXXmlParser.BYTE_1_PROPERTY, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AlsLogItemData copy$default(AlsLogItemData alsLogItemData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, Object obj) {
        AlsLogItemData alsLogItemData2 = alsLogItemData;
        int i3 = i2;
        return alsLogItemData.copy((i3 & 1) != 0 ? alsLogItemData2.request : str, (i3 & 2) != 0 ? alsLogItemData2.response : str2, (i3 & 4) != 0 ? alsLogItemData2.cMatch : str3, (i3 & 8) != 0 ? alsLogItemData2.page : str4, (i3 & 16) != 0 ? alsLogItemData2.mt : str5, (i3 & 32) != 0 ? alsLogItemData2.area : str6, (i3 & 64) != 0 ? alsLogItemData2.ideaId : str7, (i3 & 128) != 0 ? alsLogItemData2.type : str8, (i3 & 256) != 0 ? alsLogItemData2.daExt1 : str9, (i3 & 512) != 0 ? alsLogItemData2.daExt2 : str10, (i3 & 1024) != 0 ? alsLogItemData2.daExt3 : str11, (i3 & 2048) != 0 ? alsLogItemData2.daExt4 : str12, (i3 & 4096) != 0 ? alsLogItemData2.daExt5 : str13);
    }

    public final String component1() {
        return this.request;
    }

    public final String component10() {
        return this.daExt2;
    }

    public final String component11() {
        return this.daExt3;
    }

    public final String component12() {
        return this.daExt4;
    }

    public final String component13() {
        return this.daExt5;
    }

    public final String component2() {
        return this.response;
    }

    public final String component3() {
        return this.cMatch;
    }

    public final String component4() {
        return this.page;
    }

    public final String component5() {
        return this.mt;
    }

    public final String component6() {
        return this.area;
    }

    public final String component7() {
        return this.ideaId;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.daExt1;
    }

    public final AlsLogItemData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        Intrinsics.checkNotNullParameter(str, "request");
        Intrinsics.checkNotNullParameter(str2, "response");
        Intrinsics.checkNotNullParameter(str3, "cMatch");
        Intrinsics.checkNotNullParameter(str4, "page");
        Intrinsics.checkNotNullParameter(str5, "mt");
        Intrinsics.checkNotNullParameter(str6, MessageManifest.Advert.Key.AREA);
        Intrinsics.checkNotNullParameter(str7, "ideaId");
        Intrinsics.checkNotNullParameter(str8, "type");
        Intrinsics.checkNotNullParameter(str9, "daExt1");
        Intrinsics.checkNotNullParameter(str10, "daExt2");
        Intrinsics.checkNotNullParameter(str11, "daExt3");
        Intrinsics.checkNotNullParameter(str12, "daExt4");
        Intrinsics.checkNotNullParameter(str13, "daExt5");
        return new AlsLogItemData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlsLogItemData)) {
            return false;
        }
        AlsLogItemData alsLogItemData = (AlsLogItemData) obj;
        return Intrinsics.areEqual((Object) this.request, (Object) alsLogItemData.request) && Intrinsics.areEqual((Object) this.response, (Object) alsLogItemData.response) && Intrinsics.areEqual((Object) this.cMatch, (Object) alsLogItemData.cMatch) && Intrinsics.areEqual((Object) this.page, (Object) alsLogItemData.page) && Intrinsics.areEqual((Object) this.mt, (Object) alsLogItemData.mt) && Intrinsics.areEqual((Object) this.area, (Object) alsLogItemData.area) && Intrinsics.areEqual((Object) this.ideaId, (Object) alsLogItemData.ideaId) && Intrinsics.areEqual((Object) this.type, (Object) alsLogItemData.type) && Intrinsics.areEqual((Object) this.daExt1, (Object) alsLogItemData.daExt1) && Intrinsics.areEqual((Object) this.daExt2, (Object) alsLogItemData.daExt2) && Intrinsics.areEqual((Object) this.daExt3, (Object) alsLogItemData.daExt3) && Intrinsics.areEqual((Object) this.daExt4, (Object) alsLogItemData.daExt4) && Intrinsics.areEqual((Object) this.daExt5, (Object) alsLogItemData.daExt5);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.request.hashCode() * 31) + this.response.hashCode()) * 31) + this.cMatch.hashCode()) * 31) + this.page.hashCode()) * 31) + this.mt.hashCode()) * 31) + this.area.hashCode()) * 31) + this.ideaId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.daExt1.hashCode()) * 31) + this.daExt2.hashCode()) * 31) + this.daExt3.hashCode()) * 31) + this.daExt4.hashCode()) * 31) + this.daExt5.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlsLogItemData(request=").append(this.request).append(", response=").append(this.response).append(", cMatch=").append(this.cMatch).append(", page=").append(this.page).append(", mt=").append(this.mt).append(", area=").append(this.area).append(", ideaId=").append(this.ideaId).append(", type=").append(this.type).append(", daExt1=").append(this.daExt1).append(", daExt2=").append(this.daExt2).append(", daExt3=").append(this.daExt3).append(", daExt4=");
        sb.append(this.daExt4).append(", daExt5=").append(this.daExt5).append(')');
        return sb.toString();
    }

    public AlsLogItemData(String request2, String response2, String cMatch2, String page2, String mt2, String area2, String ideaId2, String type2, String daExt12, String daExt22, String daExt32, String daExt42, String daExt52) {
        Intrinsics.checkNotNullParameter(request2, "request");
        Intrinsics.checkNotNullParameter(response2, "response");
        Intrinsics.checkNotNullParameter(cMatch2, "cMatch");
        Intrinsics.checkNotNullParameter(page2, "page");
        Intrinsics.checkNotNullParameter(mt2, "mt");
        Intrinsics.checkNotNullParameter(area2, MessageManifest.Advert.Key.AREA);
        Intrinsics.checkNotNullParameter(ideaId2, "ideaId");
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(daExt12, "daExt1");
        Intrinsics.checkNotNullParameter(daExt22, "daExt2");
        Intrinsics.checkNotNullParameter(daExt32, "daExt3");
        Intrinsics.checkNotNullParameter(daExt42, "daExt4");
        Intrinsics.checkNotNullParameter(daExt52, "daExt5");
        this.request = request2;
        this.response = response2;
        this.cMatch = cMatch2;
        this.page = page2;
        this.mt = mt2;
        this.area = area2;
        this.ideaId = ideaId2;
        this.type = type2;
        this.daExt1 = daExt12;
        this.daExt2 = daExt22;
        this.daExt3 = daExt32;
        this.daExt4 = daExt42;
        this.daExt5 = daExt52;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AlsLogItemData(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            java.lang.String r2 = "服务异常"
            if (r1 == 0) goto L_0x000b
            r1 = r2
            goto L_0x000c
        L_0x000b:
            r1 = r15
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = r16
        L_0x0013:
            r3 = r0 & 4
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001b
            r3 = r4
            goto L_0x001d
        L_0x001b:
            r3 = r17
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0023
            r5 = r4
            goto L_0x0025
        L_0x0023:
            r5 = r18
        L_0x0025:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002b
            r6 = r4
            goto L_0x002d
        L_0x002b:
            r6 = r19
        L_0x002d:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0033
            r7 = r4
            goto L_0x0035
        L_0x0033:
            r7 = r20
        L_0x0035:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003b
            r8 = r4
            goto L_0x003d
        L_0x003b:
            r8 = r21
        L_0x003d:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0043
            r9 = r4
            goto L_0x0045
        L_0x0043:
            r9 = r22
        L_0x0045:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            r10 = r4
            goto L_0x004d
        L_0x004b:
            r10 = r23
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0053
            r11 = r4
            goto L_0x0055
        L_0x0053:
            r11 = r24
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005b
            r12 = r4
            goto L_0x005d
        L_0x005b:
            r12 = r25
        L_0x005d:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0063
            r13 = r4
            goto L_0x0065
        L_0x0063:
            r13 = r26
        L_0x0065:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r4 = r27
        L_0x006c:
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r13
            r27 = r4
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.unifiedtool.infoboard.AlsLogItemData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getRequest() {
        return this.request;
    }

    public final String getResponse() {
        return this.response;
    }

    public final String getCMatch() {
        return this.cMatch;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getMt() {
        return this.mt;
    }

    public final String getArea() {
        return this.area;
    }

    public final String getIdeaId() {
        return this.ideaId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDaExt1() {
        return this.daExt1;
    }

    public final String getDaExt2() {
        return this.daExt2;
    }

    public final String getDaExt3() {
        return this.daExt3;
    }

    public final String getDaExt4() {
        return this.daExt4;
    }

    public final String getDaExt5() {
        return this.daExt5;
    }
}
