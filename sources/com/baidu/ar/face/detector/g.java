package com.baidu.ar.face.detector;

import com.baidu.ar.face.algo.FaceAlgoData;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private int[] f9452a = {3, 10, 10, 10, 10};

    /* renamed from: b  reason: collision with root package name */
    private int f9453b = 4;

    /* renamed from: c  reason: collision with root package name */
    private int f9454c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f9455d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9456e = false;

    public void a(int i2) {
        this.f9454c = i2;
    }

    public void a(int[] iArr) {
        this.f9452a = iArr;
    }

    public boolean a() {
        int i2 = this.f9455d;
        if (i2 == 0) {
            this.f9455d = i2 + 1;
            return true;
        } else if (this.f9456e) {
            return false;
        } else {
            int i3 = i2 + 1;
            this.f9455d = i3;
            int i4 = i3 - 1;
            int[] iArr = this.f9452a;
            int i5 = this.f9454c;
            int i6 = this.f9453b;
            if (i5 > i6) {
                i5 = i6;
            }
            if (i4 <= iArr[i5]) {
                return false;
            }
            this.f9455d = 0;
            return true;
        }
    }

    public boolean a(f fVar) {
        FaceAlgoData faceAlgoData = fVar.f9436a;
        if (faceAlgoData == null || faceAlgoData.getFaceFrame() == null || fVar.f9436a.getFaceFrame().getProcessResult() == 200 || b() > 0) {
            return false;
        }
        a(0);
        return true;
    }

    public int b() {
        return this.f9454c;
    }

    public void b(int i2) {
        this.f9453b = i2;
    }

    public int c() {
        return this.f9453b;
    }

    public void d() {
        this.f9456e = true;
    }

    public void e() {
        this.f9456e = false;
    }
}
