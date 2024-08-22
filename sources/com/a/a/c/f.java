package com.a.a.c;

import android.content.Context;
import android.graphics.RectF;
import com.a.a.a.c;
import com.a.a.f.c.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private float f1564a;

    /* renamed from: b  reason: collision with root package name */
    private float f1565b;

    /* renamed from: c  reason: collision with root package name */
    private c f1566c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f1567d;

    /* renamed from: e  reason: collision with root package name */
    private a.c f1568e;

    private f(a.c cVar, RectF rectF, c cVar2) {
        this.f1566c = c.HORIZONTAL;
        this.f1568e = cVar;
        this.f1567d = rectF;
        this.f1566c = cVar2;
    }

    public f(a.c cVar, c cVar2) {
        this(cVar, new RectF(0.0f, 0.0f, 1.0f, 1.0f), cVar2);
    }

    private void a(a aVar, c cVar) {
        a aVar2 = aVar;
        c cVar2 = cVar;
        int f2 = f();
        int g2 = g();
        float[] d2 = d();
        short s = 0;
        float[] a2 = a(cVar2, 0);
        float[] a3 = a(cVar2, 1);
        int e2 = e() * 6;
        short[] sArr = new short[e2];
        int i2 = g2 + 1;
        short s2 = 0;
        int i3 = 0;
        while (s2 < f2) {
            short s3 = s;
            while (s3 < g2) {
                int i4 = s2 * i2;
                int i5 = s3 + 1;
                short s4 = (short) (i4 + i5);
                int i6 = (s2 + 1) * i2;
                short s5 = (short) (i6 + s3);
                int i7 = i3 + 1;
                sArr[i3] = s4;
                int i8 = i7 + 1;
                sArr[i7] = s5;
                int i9 = i8 + 1;
                sArr[i8] = (short) (i4 + s3);
                int i10 = i9 + 1;
                sArr[i9] = s4;
                int i11 = i10 + 1;
                sArr[i10] = (short) (i6 + i5);
                i3 = i11 + 1;
                sArr[i11] = s5;
                s3 = (short) i5;
            }
            s2 = (short) (s2 + 1);
            s = 0;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(d2);
        asFloatBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(a2.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(a2);
        asFloatBuffer2.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(a3.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(a3);
        asFloatBuffer3.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(e2 * 2);
        allocateDirect4.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect4.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        aVar2.a(asShortBuffer);
        aVar2.b(0, asFloatBuffer2);
        aVar2.b(1, asFloatBuffer3);
        aVar2.a(0, asFloatBuffer);
        aVar2.a(1, asFloatBuffer);
        aVar2.a(e2);
    }

    private float[] a(c cVar, int i2) {
        int i3 = i2;
        float[] fArr = new float[(e() * 2)];
        int f2 = f();
        int g2 = g();
        float f3 = 1.0f / ((float) f2);
        float f4 = 1.0f / ((float) g2);
        int i4 = 0;
        for (short s = 0; s < f2 + 1; s = (short) (s + 1)) {
            for (short s2 = 0; s2 < g2 + 1; s2 = (short) (s2 + 1)) {
                if (c.VERTICAL == cVar) {
                    int i5 = i4 + 1;
                    fArr[i4] = ((float) s2) * f4;
                    i4 = i5 + 1;
                    fArr[i5] = ((1.0f - (((float) s) * f3)) / 2.0f) + (((float) i3) * 0.5f);
                } else {
                    int i6 = i4 + 1;
                    fArr[i4] = ((((float) s2) * f4) / 2.0f) + (((float) i3) * 0.5f);
                    i4 = i6 + 1;
                    fArr[i6] = 1.0f - (((float) s) * f3);
                }
            }
            c cVar2 = cVar;
        }
        return fArr;
    }

    private float[] d() {
        this.f1568e.c();
        this.f1564a = this.f1568e.a();
        this.f1565b = this.f1568e.b();
        float f2 = this.f1568e.f() * this.f1567d.width();
        float g2 = this.f1568e.g() * this.f1567d.height();
        float[] fArr = new float[(e() * 3)];
        int f3 = f();
        int g3 = g();
        float f4 = 1.0f / ((float) f3);
        float f5 = 1.0f / ((float) g3);
        int i2 = 0;
        for (short s = 0; s < f3 + 1; s = (short) (s + 1)) {
            short s2 = 0;
            while (s2 < g3 + 1) {
                int i3 = i2 + 1;
                fArr[i2] = ((((float) s2) * f5) - 0.5f) * f2;
                int i4 = i3 + 1;
                fArr[i3] = ((((float) s) * f4) - 0.5f) * g2;
                fArr[i4] = (float) 0;
                s2 = (short) (s2 + 1);
                i2 = i4 + 1;
            }
        }
        return fArr;
    }

    private int e() {
        return (f() + 1) * (g() + 1);
    }

    private int f() {
        return 1;
    }

    private int g() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        a((a) this, this.f1566c);
    }

    public void a(com.a.a.c cVar, int i2) {
        if (super.b(i2) != null) {
            if (i2 == 0 && this.f1568e.a(this.f1565b, this.f1564a)) {
                float[] d2 = d();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d2.length * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                asFloatBuffer.put(d2);
                asFloatBuffer.position(0);
                a(0, asFloatBuffer);
                a(1, asFloatBuffer);
            }
            super.a(cVar, i2);
        }
    }
}
