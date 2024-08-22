package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {

    /* renamed from: ad  reason: collision with root package name */
    public final String f577ad;

    /* renamed from: de  reason: collision with root package name */
    public final float f578de;

    /* renamed from: fe  reason: collision with root package name */
    public final Justification f579fe;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f580i;

    /* renamed from: o  reason: collision with root package name */
    public final float f581o;

    /* renamed from: pf  reason: collision with root package name */
    public final boolean f582pf;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f583rg;

    /* renamed from: th  reason: collision with root package name */
    public final float f584th;
    @ColorInt

    /* renamed from: uk  reason: collision with root package name */
    public final int f585uk;

    /* renamed from: yj  reason: collision with root package name */
    public final float f586yj;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i2, float f2, float f3, @ColorInt int i3, @ColorInt int i4, float f4, boolean z) {
        this.qw = str;
        this.f577ad = str2;
        this.f578de = f;
        this.f579fe = justification;
        this.f583rg = i2;
        this.f584th = f2;
        this.f586yj = f3;
        this.f585uk = i3;
        this.f580i = i4;
        this.f581o = f4;
        this.f582pf = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.qw.hashCode() * 31) + this.f577ad.hashCode()) * 31)) + this.f578de)) * 31) + this.f579fe.ordinal()) * 31) + this.f583rg;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f584th);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f585uk;
    }
}
