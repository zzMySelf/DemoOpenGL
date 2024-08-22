package fe.mmm.qw.tt.ad.aaa;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final float f8372ad;

    /* renamed from: de  reason: collision with root package name */
    public final float f8373de;

    /* renamed from: fe  reason: collision with root package name */
    public final float f8374fe;

    /* renamed from: i  reason: collision with root package name */
    public final float f8375i;
    public final int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final float f8376rg;

    /* renamed from: th  reason: collision with root package name */
    public final int f8377th;

    /* renamed from: uk  reason: collision with root package name */
    public final float f8378uk;

    /* renamed from: yj  reason: collision with root package name */
    public final float f8379yj;

    public fe(@ColorInt int i2, float f, float f2, float f3, float f4, @ColorInt int i3, float f5, float f6, float f7) {
        this.qw = i2;
        this.f8372ad = f;
        this.f8373de = f2;
        this.f8374fe = f3;
        this.f8376rg = f4;
        this.f8377th = i3;
        this.f8379yj = f5;
        this.f8378uk = f6;
        this.f8375i = f7;
    }

    public static /* synthetic */ fe ad(fe feVar, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, int i4, Object obj) {
        fe feVar2 = feVar;
        int i5 = i4;
        return feVar.qw((i5 & 1) != 0 ? feVar2.qw : i2, (i5 & 2) != 0 ? feVar2.f8372ad : f, (i5 & 4) != 0 ? feVar2.f8373de : f2, (i5 & 8) != 0 ? feVar2.f8374fe : f3, (i5 & 16) != 0 ? feVar2.f8376rg : f4, (i5 & 32) != 0 ? feVar2.f8377th : i3, (i5 & 64) != 0 ? feVar2.f8379yj : f5, (i5 & 128) != 0 ? feVar2.f8378uk : f6, (i5 & 256) != 0 ? feVar2.f8375i : f7);
    }

    public final int de() {
        return this.qw;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        return this.qw == feVar.qw && Intrinsics.areEqual((Object) Float.valueOf(this.f8372ad), (Object) Float.valueOf(feVar.f8372ad)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8373de), (Object) Float.valueOf(feVar.f8373de)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8374fe), (Object) Float.valueOf(feVar.f8374fe)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8376rg), (Object) Float.valueOf(feVar.f8376rg)) && this.f8377th == feVar.f8377th && Intrinsics.areEqual((Object) Float.valueOf(this.f8379yj), (Object) Float.valueOf(feVar.f8379yj)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8378uk), (Object) Float.valueOf(feVar.f8378uk)) && Intrinsics.areEqual((Object) Float.valueOf(this.f8375i), (Object) Float.valueOf(feVar.f8375i));
    }

    public final int fe() {
        return this.f8377th;
    }

    public int hashCode() {
        return (((((((((((((((this.qw * 31) + Float.floatToIntBits(this.f8372ad)) * 31) + Float.floatToIntBits(this.f8373de)) * 31) + Float.floatToIntBits(this.f8374fe)) * 31) + Float.floatToIntBits(this.f8376rg)) * 31) + this.f8377th) * 31) + Float.floatToIntBits(this.f8379yj)) * 31) + Float.floatToIntBits(this.f8378uk)) * 31) + Float.floatToIntBits(this.f8375i);
    }

    public final float i() {
        return this.f8375i;
    }

    @NotNull
    public final fe qw(@ColorInt int i2, float f, float f2, float f3, float f4, @ColorInt int i3, float f5, float f6, float f7) {
        return new fe(i2, f, f2, f3, f4, i3, f5, f6, f7);
    }

    public final float rg() {
        return this.f8378uk;
    }

    public final float th() {
        return this.f8379yj;
    }

    @NotNull
    public String toString() {
        return "ScanRectStyle(backgroundColor=" + this.qw + ", marginTop=" + this.f8372ad + ", marginLeft=" + this.f8373de + ", marginRight=" + this.f8374fe + ", marginBottom=" + this.f8376rg + ", borderColor=" + this.f8377th + ", borderWidth=" + this.f8379yj + ", borderRadius=" + this.f8378uk + ", widthHeightRatio=" + this.f8375i + ')';
    }

    public final float uk() {
        return this.f8374fe;
    }

    public final float yj() {
        return this.f8373de;
    }
}
