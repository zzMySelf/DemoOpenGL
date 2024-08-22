package com.a.a.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f1470a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1471b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f1472c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f1473d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f1474e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f1475f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f1476g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f1477h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f1478i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f1479j = 999.0f;
    private float k = 0.0f;
    private float l = -1.0f;
    private int m = 1;

    public void a() {
        this.f1472c = System.currentTimeMillis();
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f1470a;
        if (j2 == 0) {
            this.f1470a = currentTimeMillis;
        } else if (currentTimeMillis - j2 > 1000) {
            int i2 = this.f1471b;
            float f2 = (((float) i2) * 1000.0f) / ((float) (currentTimeMillis - j2));
            this.f1475f = f2;
            if (this.k < f2) {
                this.k = f2;
            }
            if (this.f1479j > f2) {
                this.f1479j = f2;
            }
            float f3 = this.l;
            if (f3 < 0.0f) {
                this.l = f2;
            } else {
                int i3 = this.m;
                this.l = f3 + ((f2 - f3) / ((float) i3));
                int i4 = i3 + 1;
                this.m = i4;
                if (i4 >= 60000) {
                    this.m = 1;
                }
            }
            if (i2 > 0) {
                this.f1476g = (((float) this.f1473d) * 1.0f) / ((float) i2);
            }
            this.f1477h = (float) this.f1474e;
            this.f1471b = 0;
            this.f1470a = currentTimeMillis;
            this.f1473d = 0;
            this.f1474e = 0;
        }
        this.f1471b++;
        long j3 = currentTimeMillis - this.f1472c;
        this.f1473d += j3;
        if (j3 > this.f1474e) {
            this.f1474e = j3;
        }
        float f4 = this.f1478i;
        if (f4 != 0.0f) {
            float f5 = (float) j3;
            if (f5 < f4) {
                try {
                    Thread.sleep((long) (f4 - f5));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
