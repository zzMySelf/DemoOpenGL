package com.baidu.searchbox.download.center.clearcache.view.funison.fileScan;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.app.account.dispatcher.UnitedSchemeAccountInfoDispatcher;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.center.clearcache.view.ubc.ClearCacheUbcConstant;
import com.baidu.searchbox.download.util.DownloadHelper;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u0000 W2\u00020\u0001:\u0004WXYZB¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0002\u0010\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0012HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J©\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0012HÆ\u0001J\u0013\u0010L\u001a\u00020\u000b2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\u0006\u0010O\u001a\u00020\u0003J\u0006\u0010P\u001a\u00020\u000bJ\b\u0010Q\u001a\u0004\u0018\u00010\u0003J\t\u0010R\u001a\u00020\u0012HÖ\u0001J\u0006\u0010S\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020T2\u0006\u0010U\u001a\u00020\u0005J\t\u0010V\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010)\"\u0004\b,\u0010+R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u0010+R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001e¨\u0006["}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "Ljava/io/Serializable;", "displayName", "", "id", "", "type", "size", "mimeType", "path", "isSelected", "", "isLocal", "videoIcon", "date", "datetoken", "onlyTime", "childNum", "", "childSize", "month", "position", "(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;JZILjava/lang/String;Ljava/lang/String;I)V", "getChildNum", "()I", "setChildNum", "(I)V", "getChildSize", "()Ljava/lang/String;", "setChildSize", "(Ljava/lang/String;)V", "getDate", "setDate", "getDatetoken", "()J", "setDatetoken", "(J)V", "getDisplayName", "setDisplayName", "getId", "setId", "()Z", "setLocal", "(Z)V", "setSelected", "getMimeType", "setMimeType", "getMonth", "setMonth", "getOnlyTime", "setOnlyTime", "getPath", "setPath", "getPosition", "setPosition", "getSize", "getType", "getVideoIcon", "setVideoIcon", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getFileSource", "getIfCanPlay", "getImageUriFromDownloadPath", "hashCode", "isValid", "", "timeStamp", "toString", "Companion", "DataType", "MonthListBean", "ScanLiveDataBean", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scanbean.kt */
public final class ScanBean implements Serializable {
    public static final String BAIDU_DOWNLOAD_PATH = "/baidu/searchbox/downloads/";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 1637042781003L;
    /* access modifiers changed from: private */
    public static final HashMap<Long, String> typeToUbcValueMap = MapsKt.hashMapOf(TuplesKt.to(2L, "image"), TuplesKt.to(0L, "video"), TuplesKt.to(4L, "document"), TuplesKt.to(3L, "package"), TuplesKt.to(1L, "music"), TuplesKt.to(8L, ClearCacheUbcConstant.UBC_VALUE_TOOL_COMPRESSFILE), TuplesKt.to(11L, "page"), TuplesKt.to(5L, "other"));
    private int childNum;
    private String childSize;
    private String date;
    private long datetoken;
    private String displayName;
    private long id;
    private boolean isLocal;
    private boolean isSelected;
    private String mimeType;
    private String month;
    private boolean onlyTime;
    private String path;
    private int position;
    private final long size;
    private final long type;
    private String videoIcon;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean$DataType;", "", "(Ljava/lang/String;I)V", "DEFAULT", "TIME", "ITEM", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Scanbean.kt */
    public enum DataType {
        DEFAULT,
        TIME,
        ITEM
    }

    public ScanBean() {
        this((String) null, 0, 0, 0, (String) null, (String) null, false, false, (String) null, (String) null, 0, false, 0, (String) null, (String) null, 0, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ScanBean copy$default(ScanBean scanBean, String str, long j2, long j3, long j4, String str2, String str3, boolean z, boolean z2, String str4, String str5, long j5, boolean z3, int i2, String str6, String str7, int i3, int i4, Object obj) {
        ScanBean scanBean2 = scanBean;
        int i5 = i4;
        return scanBean.copy((i5 & 1) != 0 ? scanBean2.displayName : str, (i5 & 2) != 0 ? scanBean2.id : j2, (i5 & 4) != 0 ? scanBean2.type : j3, (i5 & 8) != 0 ? scanBean2.size : j4, (i5 & 16) != 0 ? scanBean2.mimeType : str2, (i5 & 32) != 0 ? scanBean2.path : str3, (i5 & 64) != 0 ? scanBean2.isSelected : z, (i5 & 128) != 0 ? scanBean2.isLocal : z2, (i5 & 256) != 0 ? scanBean2.videoIcon : str4, (i5 & 512) != 0 ? scanBean2.date : str5, (i5 & 1024) != 0 ? scanBean2.datetoken : j5, (i5 & 2048) != 0 ? scanBean2.onlyTime : z3, (i5 & 4096) != 0 ? scanBean2.childNum : i2, (i5 & 8192) != 0 ? scanBean2.childSize : str6, (i5 & 16384) != 0 ? scanBean2.month : str7, (i5 & 32768) != 0 ? scanBean2.position : i3);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component10() {
        return this.date;
    }

    public final long component11() {
        return this.datetoken;
    }

    public final boolean component12() {
        return this.onlyTime;
    }

    public final int component13() {
        return this.childNum;
    }

    public final String component14() {
        return this.childSize;
    }

    public final String component15() {
        return this.month;
    }

    public final int component16() {
        return this.position;
    }

    public final long component2() {
        return this.id;
    }

    public final long component3() {
        return this.type;
    }

    public final long component4() {
        return this.size;
    }

    public final String component5() {
        return this.mimeType;
    }

    public final String component6() {
        return this.path;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final boolean component8() {
        return this.isLocal;
    }

    public final String component9() {
        return this.videoIcon;
    }

    public final ScanBean copy(String str, long j2, long j3, long j4, String str2, String str3, boolean z, boolean z2, String str4, String str5, long j5, boolean z3, int i2, String str6, String str7, int i3) {
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Intrinsics.checkNotNullParameter(str3, "path");
        Intrinsics.checkNotNullParameter(str4, "videoIcon");
        Intrinsics.checkNotNullParameter(str5, "date");
        Intrinsics.checkNotNullParameter(str6, "childSize");
        Intrinsics.checkNotNullParameter(str7, "month");
        return new ScanBean(str8, j2, j3, j4, str2, str3, z, z2, str4, str5, j5, z3, i2, str6, str7, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanBean)) {
            return false;
        }
        ScanBean scanBean = (ScanBean) obj;
        return Intrinsics.areEqual((Object) this.displayName, (Object) scanBean.displayName) && this.id == scanBean.id && this.type == scanBean.type && this.size == scanBean.size && Intrinsics.areEqual((Object) this.mimeType, (Object) scanBean.mimeType) && Intrinsics.areEqual((Object) this.path, (Object) scanBean.path) && this.isSelected == scanBean.isSelected && this.isLocal == scanBean.isLocal && Intrinsics.areEqual((Object) this.videoIcon, (Object) scanBean.videoIcon) && Intrinsics.areEqual((Object) this.date, (Object) scanBean.date) && this.datetoken == scanBean.datetoken && this.onlyTime == scanBean.onlyTime && this.childNum == scanBean.childNum && Intrinsics.areEqual((Object) this.childSize, (Object) scanBean.childSize) && Intrinsics.areEqual((Object) this.month, (Object) scanBean.month) && this.position == scanBean.position;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.displayName.hashCode() * 31) + Long.hashCode(this.id)) * 31) + Long.hashCode(this.type)) * 31) + Long.hashCode(this.size)) * 31) + this.mimeType.hashCode()) * 31) + this.path.hashCode()) * 31;
        boolean z = this.isSelected;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isLocal;
        if (z3) {
            z3 = true;
        }
        int hashCode2 = (((((((i2 + (z3 ? 1 : 0)) * 31) + this.videoIcon.hashCode()) * 31) + this.date.hashCode()) * 31) + Long.hashCode(this.datetoken)) * 31;
        boolean z4 = this.onlyTime;
        if (!z4) {
            z2 = z4;
        }
        return ((((((((hashCode2 + (z2 ? 1 : 0)) * 31) + Integer.hashCode(this.childNum)) * 31) + this.childSize.hashCode()) * 31) + this.month.hashCode()) * 31) + Integer.hashCode(this.position);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScanBean(displayName=").append(this.displayName).append(", id=").append(this.id).append(", type=").append(this.type).append(", size=").append(this.size).append(", mimeType=").append(this.mimeType).append(", path=").append(this.path).append(", isSelected=").append(this.isSelected).append(", isLocal=").append(this.isLocal).append(", videoIcon=").append(this.videoIcon).append(", date=").append(this.date).append(", datetoken=").append(this.datetoken).append(", onlyTime=");
        sb.append(this.onlyTime).append(", childNum=").append(this.childNum).append(", childSize=").append(this.childSize).append(", month=").append(this.month).append(", position=").append(this.position).append(')');
        return sb.toString();
    }

    public ScanBean(String displayName2, long id2, long type2, long size2, String mimeType2, String path2, boolean isSelected2, boolean isLocal2, String videoIcon2, String date2, long datetoken2, boolean onlyTime2, int childNum2, String childSize2, String month2, int position2) {
        String str = displayName2;
        String str2 = mimeType2;
        String str3 = path2;
        String str4 = videoIcon2;
        String str5 = date2;
        String str6 = childSize2;
        String str7 = month2;
        Intrinsics.checkNotNullParameter(str, UnitedSchemeAccountInfoDispatcher.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Intrinsics.checkNotNullParameter(str3, "path");
        Intrinsics.checkNotNullParameter(str4, "videoIcon");
        Intrinsics.checkNotNullParameter(str5, "date");
        Intrinsics.checkNotNullParameter(str6, "childSize");
        Intrinsics.checkNotNullParameter(str7, "month");
        this.displayName = str;
        this.id = id2;
        this.type = type2;
        this.size = size2;
        this.mimeType = str2;
        this.path = str3;
        this.isSelected = isSelected2;
        this.isLocal = isLocal2;
        this.videoIcon = str4;
        this.date = str5;
        this.datetoken = datetoken2;
        this.onlyTime = onlyTime2;
        this.childNum = childNum2;
        this.childSize = str6;
        this.month = str7;
        this.position = position2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ScanBean(java.lang.String r20, long r21, long r23, long r25, java.lang.String r27, java.lang.String r28, boolean r29, boolean r30, java.lang.String r31, java.lang.String r32, long r33, boolean r35, int r36, java.lang.String r37, java.lang.String r38, int r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r19 = this;
            r0 = r40
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r20
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0013
            r6 = 0
            goto L_0x0015
        L_0x0013:
            r6 = r21
        L_0x0015:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001c
            r8 = -1
            goto L_0x001e
        L_0x001c:
            r8 = r23
        L_0x001e:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0025
            r10 = 0
            goto L_0x0027
        L_0x0025:
            r10 = r25
        L_0x0027:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x002d
            r3 = r2
            goto L_0x002f
        L_0x002d:
            r3 = r27
        L_0x002f:
            r12 = r0 & 32
            if (r12 == 0) goto L_0x0035
            r12 = r2
            goto L_0x0037
        L_0x0035:
            r12 = r28
        L_0x0037:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x003d
            r13 = 0
            goto L_0x003f
        L_0x003d:
            r13 = r29
        L_0x003f:
            r15 = r0 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x0045
            r15 = 1
            goto L_0x0047
        L_0x0045:
            r15 = r30
        L_0x0047:
            r4 = r0 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x004d
            r4 = r2
            goto L_0x004f
        L_0x004d:
            r4 = r31
        L_0x004f:
            r5 = r0 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0055
            r5 = r2
            goto L_0x0057
        L_0x0055:
            r5 = r32
        L_0x0057:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005e
            r16 = 0
            goto L_0x0060
        L_0x005e:
            r16 = r33
        L_0x0060:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0066
            r14 = 0
            goto L_0x0068
        L_0x0066:
            r14 = r35
        L_0x0068:
            r41 = r2
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r36
        L_0x0072:
            r36 = r2
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x007b
            r2 = r41
            goto L_0x007d
        L_0x007b:
            r2 = r37
        L_0x007d:
            r37 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0086
            r2 = r41
            goto L_0x0088
        L_0x0086:
            r2 = r38
        L_0x0088:
            r18 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0091
            r0 = 0
            goto L_0x0093
        L_0x0091:
            r0 = r39
        L_0x0093:
            r20 = r1
            r21 = r6
            r23 = r8
            r25 = r10
            r27 = r3
            r28 = r12
            r29 = r13
            r30 = r15
            r31 = r4
            r32 = r5
            r33 = r16
            r35 = r14
            r38 = r2
            r39 = r0
            r19.<init>(r20, r21, r23, r25, r27, r28, r29, r30, r31, r32, r33, r35, r36, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean.<init>(java.lang.String, long, long, long, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, long, boolean, int, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayName = str;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j2) {
        this.id = j2;
    }

    public final long getType() {
        return this.type;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mimeType = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final void setLocal(boolean z) {
        this.isLocal = z;
    }

    public final String getVideoIcon() {
        return this.videoIcon;
    }

    public final void setVideoIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoIcon = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final long getDatetoken() {
        return this.datetoken;
    }

    public final void setDatetoken(long j2) {
        this.datetoken = j2;
    }

    public final boolean getOnlyTime() {
        return this.onlyTime;
    }

    public final void setOnlyTime(boolean z) {
        this.onlyTime = z;
    }

    public final int getChildNum() {
        return this.childNum;
    }

    public final void setChildNum(int i2) {
        this.childNum = i2;
    }

    public final String getChildSize() {
        return this.childSize;
    }

    public final void setChildSize(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.childSize = str;
    }

    public final String getMonth() {
        return this.month;
    }

    public final void setMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean$Companion;", "", "()V", "BAIDU_DOWNLOAD_PATH", "", "serialVersionUID", "", "typeToUbcValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getTypeToUbcValueMap", "()Ljava/util/HashMap;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Scanbean.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashMap<Long, String> getTypeToUbcValueMap() {
            return ScanBean.typeToUbcValueMap;
        }
    }

    public final void setDate(long timeStamp) {
        String str;
        this.datetoken = timeStamp;
        try {
            str = ScanbeanKt.getDateFormat().format(Long.valueOf(timeStamp));
            Intrinsics.checkNotNullExpressionValue(str, "{\n            dateFormat…rmat(timeStamp)\n        }");
        } catch (Throwable e2) {
            e2.printStackTrace();
            if (!AppConfig.isDebug()) {
                str = "";
            } else {
                throw new DebugException("ScanBean时间戳转换错误");
            }
        }
        this.date = str;
    }

    public final boolean getIfCanPlay() {
        long j2 = this.type;
        if (((int) j2) == 0 || ((int) j2) == 1 || ((int) j2) == 2 || ((int) j2) == 4) {
            return true;
        }
        return false;
    }

    public final boolean isValid() {
        CharSequence charSequence = this.path;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            File file = new File(this.path);
            return file.exists() && file.isFile();
        }
    }

    public final String getFileSource() {
        if (StringsKt.contains$default((CharSequence) this.path, (CharSequence) "DCIM/", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.path, (CharSequence) "Pictures", false, 2, (Object) null)) {
            return "相册";
        }
        if (StringsKt.contains$default((CharSequence) this.path, (CharSequence) BAIDU_DOWNLOAD_PATH, false, 2, (Object) null) || DownloadHelper.isStoragePrivatePath(this.path)) {
            return "百度";
        }
        return "未知来源";
    }

    public final String getImageUriFromDownloadPath() {
        Uri uri;
        String parsedPath;
        try {
            if (TextUtils.isEmpty(this.path)) {
                return null;
            }
            if (!StringsKt.startsWith$default(this.path, "file://", false, 2, (Object) null)) {
                uri = Uri.parse(Uri.decode("file://" + this.path));
            } else {
                uri = Uri.parse(Uri.decode(this.path));
            }
            if (uri == null) {
                return null;
            }
            String uriStr = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uriStr, "uri.toString()");
            if (StringsKt.contains$default((CharSequence) uriStr, (CharSequence) "%", false, 2, (Object) null)) {
                parsedPath = StringsKt.replace$default(uriStr, "%", "%25", false, 4, (Object) null);
            } else {
                parsedPath = uri.toString();
            }
            return parsedPath;
        } catch (Exception exception) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            exception.printStackTrace();
            return null;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003JU\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean$MonthListBean;", "", "month", "", "num", "", "size", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "isSelected", "", "position", "headRealPosition", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;ZII)V", "getHeadRealPosition", "()I", "setHeadRealPosition", "(I)V", "()Z", "setSelected", "(Z)V", "getList", "()Ljava/util/List;", "getMonth", "()Ljava/lang/String;", "getNum", "setNum", "getPosition", "setPosition", "getSize", "setSize", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Scanbean.kt */
    public static final class MonthListBean {
        private int headRealPosition;
        private boolean isSelected;
        private final List<ScanBean> list;
        private final String month;
        private int num;
        private int position;
        private String size;

        public static /* synthetic */ MonthListBean copy$default(MonthListBean monthListBean, String str, int i2, String str2, List<ScanBean> list2, boolean z, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = monthListBean.month;
            }
            if ((i5 & 2) != 0) {
                i2 = monthListBean.num;
            }
            int i6 = i2;
            if ((i5 & 4) != 0) {
                str2 = monthListBean.size;
            }
            String str3 = str2;
            if ((i5 & 8) != 0) {
                list2 = monthListBean.list;
            }
            List<ScanBean> list3 = list2;
            if ((i5 & 16) != 0) {
                z = monthListBean.isSelected;
            }
            boolean z2 = z;
            if ((i5 & 32) != 0) {
                i3 = monthListBean.position;
            }
            int i7 = i3;
            if ((i5 & 64) != 0) {
                i4 = monthListBean.headRealPosition;
            }
            return monthListBean.copy(str, i6, str3, list3, z2, i7, i4);
        }

        public final String component1() {
            return this.month;
        }

        public final int component2() {
            return this.num;
        }

        public final String component3() {
            return this.size;
        }

        public final List<ScanBean> component4() {
            return this.list;
        }

        public final boolean component5() {
            return this.isSelected;
        }

        public final int component6() {
            return this.position;
        }

        public final int component7() {
            return this.headRealPosition;
        }

        public final MonthListBean copy(String str, int i2, String str2, List<ScanBean> list2, boolean z, int i3, int i4) {
            String str3 = str;
            Intrinsics.checkNotNullParameter(str, "month");
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str2, "size");
            Intrinsics.checkNotNullParameter(list2, "list");
            return new MonthListBean(str, i2, str2, list2, z, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MonthListBean)) {
                return false;
            }
            MonthListBean monthListBean = (MonthListBean) obj;
            return Intrinsics.areEqual((Object) this.month, (Object) monthListBean.month) && this.num == monthListBean.num && Intrinsics.areEqual((Object) this.size, (Object) monthListBean.size) && Intrinsics.areEqual((Object) this.list, (Object) monthListBean.list) && this.isSelected == monthListBean.isSelected && this.position == monthListBean.position && this.headRealPosition == monthListBean.headRealPosition;
        }

        public int hashCode() {
            int hashCode = ((((((this.month.hashCode() * 31) + Integer.hashCode(this.num)) * 31) + this.size.hashCode()) * 31) + this.list.hashCode()) * 31;
            boolean z = this.isSelected;
            if (z) {
                z = true;
            }
            return ((((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.headRealPosition);
        }

        public String toString() {
            return "MonthListBean(month=" + this.month + ", num=" + this.num + ", size=" + this.size + ", list=" + this.list + ", isSelected=" + this.isSelected + ", position=" + this.position + ", headRealPosition=" + this.headRealPosition + ')';
        }

        public MonthListBean(String month2, int num2, String size2, List<ScanBean> list2, boolean isSelected2, int position2, int headRealPosition2) {
            Intrinsics.checkNotNullParameter(month2, "month");
            Intrinsics.checkNotNullParameter(size2, "size");
            Intrinsics.checkNotNullParameter(list2, "list");
            this.month = month2;
            this.num = num2;
            this.size = size2;
            this.list = list2;
            this.isSelected = isSelected2;
            this.position = position2;
            this.headRealPosition = headRealPosition2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MonthListBean(java.lang.String r11, int r12, java.lang.String r13, java.util.List r14, boolean r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
            /*
                r10 = this;
                r0 = r18 & 16
                r1 = 0
                if (r0 == 0) goto L_0x0007
                r7 = r1
                goto L_0x0008
            L_0x0007:
                r7 = r15
            L_0x0008:
                r0 = r18 & 32
                if (r0 == 0) goto L_0x000e
                r8 = r1
                goto L_0x0010
            L_0x000e:
                r8 = r16
            L_0x0010:
                r0 = r18 & 64
                if (r0 == 0) goto L_0x0016
                r9 = r1
                goto L_0x0018
            L_0x0016:
                r9 = r17
            L_0x0018:
                r2 = r10
                r3 = r11
                r4 = r12
                r5 = r13
                r6 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean.MonthListBean.<init>(java.lang.String, int, java.lang.String, java.util.List, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final List<ScanBean> getList() {
            return this.list;
        }

        public final String getMonth() {
            return this.month;
        }

        public final int getNum() {
            return this.num;
        }

        public final String getSize() {
            return this.size;
        }

        public final void setNum(int i2) {
            this.num = i2;
        }

        public final void setSize(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.size = str;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }

        public final int getPosition() {
            return this.position;
        }

        public final void setPosition(int i2) {
            this.position = i2;
        }

        public final int getHeadRealPosition() {
            return this.headRealPosition;
        }

        public final void setHeadRealPosition(int i2) {
            this.headRealPosition = i2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean$ScanLiveDataBean;", "", "type", "", "list", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getType", "()I", "setType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Scanbean.kt */
    public static final class ScanLiveDataBean {
        private final ArrayList<ScanBean> list;
        private int type;

        public static /* synthetic */ ScanLiveDataBean copy$default(ScanLiveDataBean scanLiveDataBean, int i2, ArrayList<ScanBean> arrayList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = scanLiveDataBean.type;
            }
            if ((i3 & 2) != 0) {
                arrayList = scanLiveDataBean.list;
            }
            return scanLiveDataBean.copy(i2, arrayList);
        }

        public final int component1() {
            return this.type;
        }

        public final ArrayList<ScanBean> component2() {
            return this.list;
        }

        public final ScanLiveDataBean copy(int i2, ArrayList<ScanBean> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "list");
            return new ScanLiveDataBean(i2, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScanLiveDataBean)) {
                return false;
            }
            ScanLiveDataBean scanLiveDataBean = (ScanLiveDataBean) obj;
            return this.type == scanLiveDataBean.type && Intrinsics.areEqual((Object) this.list, (Object) scanLiveDataBean.list);
        }

        public int hashCode() {
            return (Integer.hashCode(this.type) * 31) + this.list.hashCode();
        }

        public String toString() {
            return "ScanLiveDataBean(type=" + this.type + ", list=" + this.list + ')';
        }

        public ScanLiveDataBean(int type2, ArrayList<ScanBean> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.type = type2;
            this.list = list2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ScanLiveDataBean(int i2, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i2, arrayList);
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }

        public final ArrayList<ScanBean> getList() {
            return this.list;
        }
    }
}
