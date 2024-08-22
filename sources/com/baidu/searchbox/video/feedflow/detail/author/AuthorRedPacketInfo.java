package com.baidu.searchbox.video.feedflow.detail.author;

import com.baidu.searchbox.flowvideo.detail.repos.ShowTimeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/author/AuthorRedPacketInfo;", "", "isRedPacket", "", "id", "", "ext", "source", "showTime", "", "Lcom/baidu/searchbox/flowvideo/detail/repos/ShowTimeModel;", "showTimeListFlag", "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getExt", "()Ljava/lang/String;", "getId", "()Z", "setRedPacket", "(Z)V", "getShowTime", "()Ljava/util/List;", "getShowTimeListFlag", "setShowTimeListFlag", "(Ljava/util/List;)V", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorModel.kt */
public final class AuthorRedPacketInfo {
    private final String ext;
    private final String id;
    private boolean isRedPacket;
    private final List<ShowTimeModel> showTime;
    private List<Boolean> showTimeListFlag;
    private final String source;

    public AuthorRedPacketInfo() {
        this(false, (String) null, (String) null, (String) null, (List) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AuthorRedPacketInfo copy$default(AuthorRedPacketInfo authorRedPacketInfo, boolean z, String str, String str2, String str3, List<ShowTimeModel> list, List<Boolean> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = authorRedPacketInfo.isRedPacket;
        }
        if ((i2 & 2) != 0) {
            str = authorRedPacketInfo.id;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = authorRedPacketInfo.ext;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = authorRedPacketInfo.source;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            list = authorRedPacketInfo.showTime;
        }
        List<ShowTimeModel> list3 = list;
        if ((i2 & 32) != 0) {
            list2 = authorRedPacketInfo.showTimeListFlag;
        }
        return authorRedPacketInfo.copy(z, str4, str5, str6, list3, list2);
    }

    public final boolean component1() {
        return this.isRedPacket;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.ext;
    }

    public final String component4() {
        return this.source;
    }

    public final List<ShowTimeModel> component5() {
        return this.showTime;
    }

    public final List<Boolean> component6() {
        return this.showTimeListFlag;
    }

    public final AuthorRedPacketInfo copy(boolean z, String str, String str2, String str3, List<ShowTimeModel> list, List<Boolean> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "ext");
        Intrinsics.checkNotNullParameter(str3, "source");
        return new AuthorRedPacketInfo(z, str, str2, str3, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthorRedPacketInfo)) {
            return false;
        }
        AuthorRedPacketInfo authorRedPacketInfo = (AuthorRedPacketInfo) obj;
        return this.isRedPacket == authorRedPacketInfo.isRedPacket && Intrinsics.areEqual((Object) this.id, (Object) authorRedPacketInfo.id) && Intrinsics.areEqual((Object) this.ext, (Object) authorRedPacketInfo.ext) && Intrinsics.areEqual((Object) this.source, (Object) authorRedPacketInfo.source) && Intrinsics.areEqual((Object) this.showTime, (Object) authorRedPacketInfo.showTime) && Intrinsics.areEqual((Object) this.showTimeListFlag, (Object) authorRedPacketInfo.showTimeListFlag);
    }

    public int hashCode() {
        boolean z = this.isRedPacket;
        if (z) {
            z = true;
        }
        int hashCode = (((((((z ? 1 : 0) * true) + this.id.hashCode()) * 31) + this.ext.hashCode()) * 31) + this.source.hashCode()) * 31;
        List<ShowTimeModel> list = this.showTime;
        int i2 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Boolean> list2 = this.showTimeListFlag;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "AuthorRedPacketInfo(isRedPacket=" + this.isRedPacket + ", id=" + this.id + ", ext=" + this.ext + ", source=" + this.source + ", showTime=" + this.showTime + ", showTimeListFlag=" + this.showTimeListFlag + ')';
    }

    public AuthorRedPacketInfo(boolean isRedPacket2, String id2, String ext2, String source2, List<ShowTimeModel> showTime2, List<Boolean> showTimeListFlag2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(ext2, "ext");
        Intrinsics.checkNotNullParameter(source2, "source");
        this.isRedPacket = isRedPacket2;
        this.id = id2;
        this.ext = ext2;
        this.source = source2;
        this.showTime = showTime2;
        this.showTimeListFlag = showTimeListFlag2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthorRedPacketInfo(boolean r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 0
        L_0x0005:
            r12 = r11 & 2
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x000d
            r12 = r0
            goto L_0x000e
        L_0x000d:
            r12 = r6
        L_0x000e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r0 = r8
        L_0x001b:
            r6 = r11 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0022
            r2 = r7
            goto L_0x0023
        L_0x0022:
            r2 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0029
            r3 = r7
            goto L_0x002a
        L_0x0029:
            r3 = r10
        L_0x002a:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r0
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.author.AuthorRedPacketInfo.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean isRedPacket() {
        return this.isRedPacket;
    }

    public final void setRedPacket(boolean z) {
        this.isRedPacket = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getSource() {
        return this.source;
    }

    public final List<ShowTimeModel> getShowTime() {
        return this.showTime;
    }

    public final List<Boolean> getShowTimeListFlag() {
        return this.showTimeListFlag;
    }

    public final void setShowTimeListFlag(List<Boolean> list) {
        this.showTimeListFlag = list;
    }
}
