package fe.mmm.qw.qw.rg;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @SerializedName("uid")
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final String f8255ad;
    @SerializedName("headUrl")
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final String f8256de;
    @SerializedName("aRA")
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final Integer f8257fe;
    @SerializedName("regTimeSeconds")
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final Long f8258i;
    @SerializedName("sToken")
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public final String f344if;
    @SerializedName("region_domain_prefix")
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public final String f8259o;
    @SerializedName("aRg")
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public final String f8260pf;
    @SerializedName("aRz")
    @Nullable
    public final String qw;
    @SerializedName("displayName")
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final String f8261rg;
    @SerializedName("aRB")
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final String f8262th;
    @SerializedName("uk")
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public final Long f8263uk;
    @SerializedName("aRC")
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final String f8264yj;

    public qw() {
        this((String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public qw(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Long l, @Nullable Long l2, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        this.qw = str;
        this.f8255ad = str2;
        this.f8256de = str3;
        this.f8257fe = num;
        this.f8261rg = str4;
        this.f8262th = str5;
        this.f8264yj = str6;
        this.f8263uk = l;
        this.f8258i = l2;
        this.f8259o = str7;
        this.f8260pf = str8;
        this.f344if = str9;
    }

    public static /* synthetic */ qw ad(qw qwVar, String str, String str2, String str3, Integer num, String str4, String str5, String str6, Long l, Long l2, String str7, String str8, String str9, int i2, Object obj) {
        qw qwVar2 = qwVar;
        int i3 = i2;
        return qwVar.qw((i3 & 1) != 0 ? qwVar2.qw : str, (i3 & 2) != 0 ? qwVar2.f8255ad : str2, (i3 & 4) != 0 ? qwVar2.f8256de : str3, (i3 & 8) != 0 ? qwVar2.f8257fe : num, (i3 & 16) != 0 ? qwVar2.f8261rg : str4, (i3 & 32) != 0 ? qwVar2.f8262th : str5, (i3 & 64) != 0 ? qwVar2.f8264yj : str6, (i3 & 128) != 0 ? qwVar2.f8263uk : l, (i3 & 256) != 0 ? qwVar2.f8258i : l2, (i3 & 512) != 0 ? qwVar2.f8259o : str7, (i3 & 1024) != 0 ? qwVar2.f8260pf : str8, (i3 & 2048) != 0 ? qwVar2.f344if : str9);
    }

    @Nullable
    public final String de() {
        return this.f8261rg;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f8255ad, (Object) qwVar.f8255ad) && Intrinsics.areEqual((Object) this.f8256de, (Object) qwVar.f8256de) && Intrinsics.areEqual((Object) this.f8257fe, (Object) qwVar.f8257fe) && Intrinsics.areEqual((Object) this.f8261rg, (Object) qwVar.f8261rg) && Intrinsics.areEqual((Object) this.f8262th, (Object) qwVar.f8262th) && Intrinsics.areEqual((Object) this.f8264yj, (Object) qwVar.f8264yj) && Intrinsics.areEqual((Object) this.f8263uk, (Object) qwVar.f8263uk) && Intrinsics.areEqual((Object) this.f8258i, (Object) qwVar.f8258i) && Intrinsics.areEqual((Object) this.f8259o, (Object) qwVar.f8259o) && Intrinsics.areEqual((Object) this.f8260pf, (Object) qwVar.f8260pf) && Intrinsics.areEqual((Object) this.f344if, (Object) qwVar.f344if);
    }

    @Nullable
    public final String fe() {
        return this.f8256de;
    }

    public int hashCode() {
        String str = this.qw;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f8255ad;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8256de;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f8257fe;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.f8261rg;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f8262th;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f8264yj;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.f8263uk;
        int hashCode8 = (hashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.f8258i;
        int hashCode9 = (hashCode8 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str7 = this.f8259o;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f8260pf;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f344if;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode11 + i2;
    }

    @Nullable
    public final Long i() {
        return this.f8263uk;
    }

    @NotNull
    public final qw qw(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Long l, @Nullable Long l2, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        return new qw(str, str2, str3, num, str4, str5, str6, l, l2, str7, str8, str9);
    }

    @Nullable
    public final String rg() {
        return this.qw;
    }

    @Nullable
    public final String th() {
        return this.f8264yj;
    }

    @NotNull
    public String toString() {
        return "AccountInfo(nduss=" + this.qw + ", uid=" + this.f8255ad + ", headUrl=" + this.f8256de + ", loginType=" + this.f8257fe + ", displayName=" + this.f8261rg + ", curCountry=" + this.f8262th + ", regCountry=" + this.f8264yj + ", uk=" + this.f8263uk + ", regTimeSeconds=" + this.f8258i + ", regionDomainPrefix=" + this.f8259o + ", bindEmail=" + this.f8260pf + ", sToken=" + this.f344if + ')';
    }

    @Nullable
    public final String uk() {
        return this.f8255ad;
    }

    @Nullable
    public final String yj() {
        return this.f344if;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ qw(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Long r21, java.lang.Long r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.qw.rg.qw.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
