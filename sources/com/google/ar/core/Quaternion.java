package com.google.ar.core;

class Quaternion {

    /* renamed from: a  reason: collision with root package name */
    public static final Quaternion f4540a = new Quaternion();
    private float w = 1.0f;
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public Quaternion() {
        a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private final void a(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
    }

    public final float b() {
        return this.y;
    }

    public final float c() {
        return this.z;
    }

    public final float d() {
        return this.w;
    }

    public final Quaternion e() {
        return new Quaternion(-this.x, -this.y, -this.z, this.w);
    }

    public String toString() {
        return String.format("[%.3f, %.3f, %.3f, %.3f]", new Object[]{Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z), Float.valueOf(this.w)});
    }

    public final float a() {
        return this.x;
    }

    public final void a(float[] fArr, int i2) {
        fArr[i2] = this.x;
        fArr[i2 + 1] = this.y;
        fArr[i2 + 2] = this.z;
        fArr[i2 + 3] = this.w;
    }

    private Quaternion(Quaternion quaternion) {
        a(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public final Quaternion a(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        float f2 = this.x;
        float f3 = quaternion.w;
        float f4 = this.y;
        float f5 = quaternion.z;
        float f6 = this.z;
        float f7 = quaternion.y;
        float f8 = this.w;
        quaternion2.x = (((f2 * f3) + (f4 * f5)) - (f6 * f7)) + (quaternion.x * f8);
        float f9 = this.x;
        float f10 = -f9;
        float f11 = (f10 * f5) + (f4 * f3);
        float f12 = quaternion.x;
        quaternion2.y = f11 + (f6 * f12) + (f7 * f8);
        float f13 = quaternion.y;
        float f14 = this.y;
        quaternion2.z = ((f9 * f13) - (f14 * f12)) + (f6 * f3) + (f5 * f8);
        quaternion2.w = (((f10 * f12) - (f14 * f13)) - (this.z * quaternion.z)) + (f8 * f3);
        return quaternion2;
    }

    public Quaternion(float f2, float f3, float f4, float f5) {
        a(f2, f3, f4, f5);
    }

    public static Quaternion a(Quaternion quaternion, Quaternion quaternion2, float f2) {
        float f3;
        Quaternion quaternion3 = new Quaternion();
        float f4 = (quaternion.x * quaternion2.x) + (quaternion.y * quaternion2.y) + (quaternion.z * quaternion2.z) + (quaternion.w * quaternion2.w);
        if (f4 < 0.0f) {
            Quaternion quaternion4 = new Quaternion(quaternion2);
            f4 = -f4;
            quaternion4.x = -quaternion4.x;
            quaternion4.y = -quaternion4.y;
            quaternion4.z = -quaternion4.z;
            quaternion4.w = -quaternion4.w;
            quaternion2 = quaternion4;
        }
        float acos = (float) Math.acos((double) f4);
        float sqrt = (float) Math.sqrt((double) (1.0f - (f4 * f4)));
        if (((double) Math.abs(sqrt)) > 0.001d) {
            float f5 = 1.0f / sqrt;
            f3 = ((float) Math.sin((double) ((1.0f - f2) * acos))) * f5;
            f2 = ((float) Math.sin((double) (f2 * acos))) * f5;
        } else {
            f3 = 1.0f - f2;
        }
        float f6 = (quaternion.x * f3) + (quaternion2.x * f2);
        quaternion3.x = f6;
        float f7 = (quaternion.y * f3) + (quaternion2.y * f2);
        quaternion3.y = f7;
        float f8 = (quaternion.z * f3) + (quaternion2.z * f2);
        quaternion3.z = f8;
        float f9 = (f3 * quaternion.w) + (f2 * quaternion2.w);
        quaternion3.w = f9;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((((f6 * f6) + (f7 * f7)) + (f8 * f8)) + (f9 * f9))));
        quaternion3.x *= sqrt2;
        quaternion3.y *= sqrt2;
        quaternion3.z *= sqrt2;
        quaternion3.w *= sqrt2;
        return quaternion3;
    }

    public final void a(float[] fArr, int i2, int i3) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.z;
        float f5 = this.w;
        float f6 = (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5);
        float f7 = 0.0f;
        if (f6 > 0.0f) {
            f7 = 2.0f / f6;
        }
        float f8 = f2 * f7;
        float f9 = f3 * f7;
        float f10 = f7 * f4;
        float f11 = f5 * f8;
        float f12 = f5 * f9;
        float f13 = f5 * f10;
        float f14 = f8 * f2;
        float f15 = f2 * f9;
        float f16 = f2 * f10;
        float f17 = f9 * f3;
        float f18 = f3 * f10;
        float f19 = f4 * f10;
        fArr[i2] = 1.0f - (f17 + f19);
        fArr[i2 + 4] = f15 - f13;
        fArr[i2 + 8] = f16 + f12;
        int i4 = i2 + 1;
        fArr[i4] = f15 + f13;
        fArr[i4 + 4] = 1.0f - (f19 + f14);
        fArr[i4 + 8] = f18 - f11;
        int i5 = i2 + 2;
        fArr[i5] = f16 - f12;
        fArr[i5 + 4] = f18 + f11;
        fArr[i5 + 8] = 1.0f - (f14 + f17);
    }

    public static void a(Quaternion quaternion, float[] fArr, int i2, float[] fArr2, int i3) {
        float f2 = fArr[i2];
        float f3 = fArr[i2 + 1];
        float f4 = fArr[i2 + 2];
        float f5 = quaternion.x;
        float f6 = quaternion.y;
        float f7 = quaternion.z;
        float f8 = quaternion.w;
        float f9 = ((f8 * f2) + (f6 * f4)) - (f7 * f3);
        float f10 = ((f8 * f3) + (f7 * f2)) - (f5 * f4);
        float f11 = ((f8 * f4) + (f5 * f3)) - (f6 * f2);
        float f12 = -f5;
        float f13 = ((f2 * f12) - (f3 * f6)) - (f4 * f7);
        float f14 = -f7;
        float f15 = -f6;
        fArr2[i3] = (((f9 * f8) + (f13 * f12)) + (f10 * f14)) - (f11 * f15);
        fArr2[i3 + 1] = (((f10 * f8) + (f13 * f15)) + (f11 * f12)) - (f9 * f14);
        fArr2[i3 + 2] = (((f11 * f8) + (f13 * f14)) + (f9 * f15)) - (f10 * f12);
    }
}
