package fe.mmm.qw.nn.qw.qw;

import com.alipay.sdk.m.p.e;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class yj {
    @SerializedName("method")
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public String f8137ad;
    @SerializedName("host")
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public String f8138de;
    @SerializedName("path")
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public String f8139fe;
    @SerializedName("readTime")
    public long ggg;
    @SerializedName("isHttpDNS")

    /* renamed from: i  reason: collision with root package name */
    public boolean f8140i;
    @SerializedName("localDNSTime")

    /* renamed from: if  reason: not valid java name */
    public long f340if;
    @SerializedName("isFallbackHttpDisable")

    /* renamed from: o  reason: collision with root package name */
    public boolean f8141o;
    @SerializedName("totalTime")

    /* renamed from: pf  reason: collision with root package name */
    public long f8142pf;
    @SerializedName("writeTime")
    public long ppp;
    @SerializedName("from")
    @NotNull
    public String qw;
    @SerializedName("ip")
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public String f8143rg;
    @SerializedName("HttpDNSTime")

    /* renamed from: switch  reason: not valid java name */
    public long f341switch;
    @SerializedName("httpCode")

    /* renamed from: th  reason: collision with root package name */
    public int f8144th;
    @SerializedName("isHttps")

    /* renamed from: uk  reason: collision with root package name */
    public boolean f8145uk;
    @SerializedName("parseTime")
    public long vvv;
    @SerializedName("connectTime")
    public long when;
    @SerializedName("errorMsg")
    @NotNull
    public String xxx;
    @SerializedName("retryTime")

    /* renamed from: yj  reason: collision with root package name */
    public int f8146yj;

    public yj() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, false, false, false, 0, 0, 0, 0, 0, 0, 0, (String) null, 262143, (DefaultConstructorMarker) null);
    }

    public yj(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, int i3, boolean z, boolean z2, boolean z3, long j, long j2, long j3, long j4, long j5, long j6, long j7, @NotNull String str6) {
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, e.s);
        Intrinsics.checkNotNullParameter(str3, "host");
        Intrinsics.checkNotNullParameter(str4, "path");
        Intrinsics.checkNotNullParameter(str5, "ip");
        Intrinsics.checkNotNullParameter(str7, "errorMsg");
        this.qw = str;
        this.f8137ad = str2;
        this.f8138de = str3;
        this.f8139fe = str4;
        this.f8143rg = str5;
        this.f8144th = i2;
        this.f8146yj = i3;
        this.f8145uk = z;
        this.f8140i = z2;
        this.f8141o = z3;
        this.f8142pf = j;
        this.f340if = j2;
        this.f341switch = j3;
        this.when = j4;
        this.ppp = j5;
        this.ggg = j6;
        this.vvv = j7;
        this.xxx = str7;
    }

    public final void ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.xxx = str;
    }

    public final void de(boolean z) {
        this.f8141o = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yj)) {
            return false;
        }
        yj yjVar = (yj) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) yjVar.qw) && Intrinsics.areEqual((Object) this.f8137ad, (Object) yjVar.f8137ad) && Intrinsics.areEqual((Object) this.f8138de, (Object) yjVar.f8138de) && Intrinsics.areEqual((Object) this.f8139fe, (Object) yjVar.f8139fe) && Intrinsics.areEqual((Object) this.f8143rg, (Object) yjVar.f8143rg) && this.f8144th == yjVar.f8144th && this.f8146yj == yjVar.f8146yj && this.f8145uk == yjVar.f8145uk && this.f8140i == yjVar.f8140i && this.f8141o == yjVar.f8141o && this.f8142pf == yjVar.f8142pf && this.f340if == yjVar.f340if && this.f341switch == yjVar.f341switch && this.when == yjVar.when && this.ppp == yjVar.ppp && this.ggg == yjVar.ggg && this.vvv == yjVar.vvv && Intrinsics.areEqual((Object) this.xxx, (Object) yjVar.xxx);
    }

    public final void fe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8138de = str;
    }

    public final void ggg(long j) {
        this.ppp = j;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.qw.hashCode() * 31) + this.f8137ad.hashCode()) * 31) + this.f8138de.hashCode()) * 31) + this.f8139fe.hashCode()) * 31) + this.f8143rg.hashCode()) * 31) + this.f8144th) * 31) + this.f8146yj) * 31;
        boolean z = this.f8145uk;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.f8140i;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.f8141o;
        if (!z4) {
            z2 = z4;
        }
        return ((((((((((((((((i3 + (z2 ? 1 : 0)) * 31) + qw.qw(this.f8142pf)) * 31) + qw.qw(this.f340if)) * 31) + qw.qw(this.f341switch)) * 31) + qw.qw(this.when)) * 31) + qw.qw(this.ppp)) * 31) + qw.qw(this.ggg)) * 31) + qw.qw(this.vvv)) * 31) + this.xxx.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8143rg = str;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m994if(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8139fe = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f8137ad = str;
    }

    public final void pf(long j) {
        this.vvv = j;
    }

    public final void ppp(long j) {
        this.f8142pf = j;
    }

    public final void qw(long j) {
        this.when = j;
    }

    public final void rg(int i2) {
        this.f8144th = i2;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m995switch(long j) {
        this.ggg = j;
    }

    public final void th(boolean z) {
        this.f8140i = z;
    }

    @NotNull
    public String toString() {
        return "NetworkStatInfo(from=" + this.qw + ", method=" + this.f8137ad + ", host=" + this.f8138de + ", path=" + this.f8139fe + ", ip=" + this.f8143rg + ", httpCode=" + this.f8144th + ", retryTime=" + this.f8146yj + ", isHttps=" + this.f8145uk + ", isHttpDNS=" + this.f8140i + ", isFallbackHttpDisable=" + this.f8141o + ", totalTime=" + this.f8142pf + ", localDNSTime=" + this.f340if + ", httpDNSTime=" + this.f341switch + ", connectTime=" + this.when + ", writeTime=" + this.ppp + ", readTime=" + this.ggg + ", parseTime=" + this.vvv + ", errorMsg=" + this.xxx + ')';
    }

    public final void uk(boolean z) {
        this.f8145uk = z;
    }

    public final void when(int i2) {
        this.f8146yj = i2;
    }

    public final void yj(long j) {
        this.f341switch = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ yj(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, int r34, boolean r35, boolean r36, boolean r37, long r38, long r40, long r42, long r44, long r46, long r48, long r50, java.lang.String r52, int r53, kotlin.jvm.internal.DefaultConstructorMarker r54) {
        /*
            r27 = this;
            r0 = r53
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "HttpURLConnection"
            goto L_0x000b
        L_0x0009:
            r1 = r28
        L_0x000b:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0013
            r2 = r3
            goto L_0x0015
        L_0x0013:
            r2 = r29
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            r4 = r3
            goto L_0x001d
        L_0x001b:
            r4 = r30
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0023
            r5 = r3
            goto L_0x0025
        L_0x0023:
            r5 = r31
        L_0x0025:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002b
            r6 = r3
            goto L_0x002d
        L_0x002b:
            r6 = r32
        L_0x002d:
            r7 = r0 & 32
            r8 = 0
            if (r7 == 0) goto L_0x0034
            r7 = 0
            goto L_0x0036
        L_0x0034:
            r7 = r33
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            r9 = 0
            goto L_0x003e
        L_0x003c:
            r9 = r34
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0044
            r10 = 0
            goto L_0x0046
        L_0x0044:
            r10 = r35
        L_0x0046:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004c
            r11 = 0
            goto L_0x004e
        L_0x004c:
            r11 = r36
        L_0x004e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r8 = r37
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            r13 = 0
            if (r12 == 0) goto L_0x005d
            r15 = r13
            goto L_0x005f
        L_0x005d:
            r15 = r38
        L_0x005f:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0066
            r17 = r13
            goto L_0x0068
        L_0x0066:
            r17 = r40
        L_0x0068:
            r12 = r0 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x006f
            r19 = r13
            goto L_0x0071
        L_0x006f:
            r19 = r42
        L_0x0071:
            r12 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x0078
            r21 = r13
            goto L_0x007a
        L_0x0078:
            r21 = r44
        L_0x007a:
            r12 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x0081
            r23 = r13
            goto L_0x0083
        L_0x0081:
            r23 = r46
        L_0x0083:
            r12 = 32768(0x8000, float:4.5918E-41)
            r12 = r12 & r0
            if (r12 == 0) goto L_0x008c
            r25 = r13
            goto L_0x008e
        L_0x008c:
            r25 = r48
        L_0x008e:
            r12 = 65536(0x10000, float:9.18355E-41)
            r12 = r12 & r0
            if (r12 == 0) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            r13 = r50
        L_0x0096:
            r12 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r12
            if (r0 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r3 = r52
        L_0x009e:
            r28 = r27
            r29 = r1
            r30 = r2
            r31 = r4
            r32 = r5
            r33 = r6
            r34 = r7
            r35 = r9
            r36 = r10
            r37 = r11
            r38 = r8
            r39 = r15
            r41 = r17
            r43 = r19
            r45 = r21
            r47 = r23
            r49 = r25
            r51 = r13
            r53 = r3
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r43, r45, r47, r49, r51, r53)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.qw.qw.yj.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, boolean, boolean, boolean, long, long, long, long, long, long, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
