package fe.mmm.qw.tt.ad.aaa;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class th {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8381ad;

    /* renamed from: de  reason: collision with root package name */
    public final float f8382de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f8383fe;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final float f8384rg;

    /* renamed from: th  reason: collision with root package name */
    public final float f8385th;

    /* renamed from: uk  reason: collision with root package name */
    public final float f8386uk;

    /* renamed from: yj  reason: collision with root package name */
    public final float f8387yj;

    public th(int i2, @ColorInt int i3, float f, boolean z, float f2, float f3, float f4, float f5) {
        this.qw = i2;
        this.f8381ad = i3;
        this.f8382de = f;
        this.f8383fe = z;
        this.f8384rg = f2;
        this.f8385th = f3;
        this.f8387yj = f4;
        this.f8386uk = f5;
    }

    public final int ad() {
        return this.f8381ad;
    }

    public final float de() {
        return this.f8382de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof th)) {
            return false;
        }
        th thVar = (th) obj;
        return this.qw == thVar.qw && this.f8381ad == thVar.f8381ad && Intrinsics.areEqual((Object) Float.valueOf(this.f8382de), (Object) Float.valueOf(thVar.f8382de)) && this.f8383fe == thVar.f8383fe && Intrinsics.areEqual((Object) Float.valueOf(this.f8384rg), (Object) Float.valueOf(thVar.f8384rg)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8385th), (Object) Float.valueOf(thVar.f8385th)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8387yj), (Object) Float.valueOf(thVar.f8387yj)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8386uk), (Object) Float.valueOf(thVar.f8386uk));
    }

    public final float fe() {
        return this.f8386uk;
    }

    public int hashCode() {
        int floatToIntBits = ((((this.qw * 31) + this.f8381ad) * 31) + Float.floatToIntBits(this.f8382de)) * 31;
        boolean z = this.f8383fe;
        if (z) {
            z = true;
        }
        return ((((((((floatToIntBits + (z ? 1 : 0)) * 31) + Float.floatToIntBits(this.f8384rg)) * 31) + Float.floatToIntBits(this.f8385th)) * 31) + Float.floatToIntBits(this.f8387yj)) * 31) + Float.floatToIntBits(this.f8386uk);
    }

    public final int qw() {
        return this.qw;
    }

    public final float rg() {
        return this.f8384rg;
    }

    public final float th() {
        return this.f8387yj;
    }

    @NotNull
    public String toString() {
        return "TextDecorationStyle(align=" + this.qw + ", fontColor=" + this.f8381ad + ", fontSize=" + this.f8382de + ", isBold=" + this.f8383fe + ", marginLeft=" + this.f8384rg + ", marginTop=" + this.f8385th + ", marginRight=" + this.f8387yj + ", marginBottom=" + this.f8386uk + ')';
    }

    public final boolean uk() {
        return this.f8383fe;
    }

    public final float yj() {
        return this.f8385th;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ th(int r12, int r13, float r14, boolean r15, float r16, float r17, float r18, float r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0009
            r1 = 1
            r6 = 1
            goto L_0x000a
        L_0x0009:
            r6 = r15
        L_0x000a:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0011
            r7 = 0
            goto L_0x0013
        L_0x0011:
            r7 = r16
        L_0x0013:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0019
            r8 = 0
            goto L_0x001b
        L_0x0019:
            r8 = r17
        L_0x001b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0021
            r9 = 0
            goto L_0x0023
        L_0x0021:
            r9 = r18
        L_0x0023:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0029
            r10 = 0
            goto L_0x002b
        L_0x0029:
            r10 = r19
        L_0x002b:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.tt.ad.aaa.th.<init>(int, int, float, boolean, float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
