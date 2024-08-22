package com.baidu.ar.recorder;

class a {

    /* renamed from: a  reason: collision with root package name */
    private int f10216a = 100;

    /* renamed from: b  reason: collision with root package name */
    private long f10217b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f10218c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10219d = false;

    public a(long j2) {
        this.f10217b = j2;
    }

    public int a(long j2) {
        long j3 = this.f10217b;
        if (j3 == 0) {
            return 0;
        }
        long j4 = this.f10218c;
        if (j4 == 0) {
            return 0;
        }
        return (int) ((((double) (j2 - j4)) * ((double) this.f10216a)) / ((double) j3));
    }

    public boolean a() {
        return this.f10219d;
    }

    public void b(long j2) {
        this.f10218c = j2;
        this.f10219d = true;
    }
}
