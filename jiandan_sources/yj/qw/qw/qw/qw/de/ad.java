package yj.qw.qw.qw.qw.de;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.util.Rotation;
import yj.qw.qw.qw.qw.qw;

public class ad extends qw {

    /* renamed from: i  reason: collision with root package name */
    public List<qw> f11095i;

    /* renamed from: if  reason: not valid java name */
    public int[] f523if;

    /* renamed from: o  reason: collision with root package name */
    public List<qw> f11096o;

    /* renamed from: pf  reason: collision with root package name */
    public int[] f11097pf;
    public final FloatBuffer ppp;

    /* renamed from: switch  reason: not valid java name */
    public final FloatBuffer f524switch;
    public final FloatBuffer when;

    public ad() {
        this((List<qw>) null);
    }

    public List<qw> ggg() {
        return this.f11096o;
    }

    public void i() {
        super.i();
        for (qw de2 : this.f11095i) {
            de2.de();
        }
    }

    public void pf(int i2, int i3) {
        super.pf(i2, i3);
        if (this.f11097pf != null) {
            when();
        }
        int size = this.f11095i.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f11095i.get(i4).pf(i2, i3);
        }
        int i5 = i2;
        int i6 = i3;
        List<qw> list = this.f11096o;
        if (list != null && list.size() > 0) {
            int i7 = 1;
            int size2 = this.f11096o.size() - 1;
            this.f11097pf = new int[size2];
            this.f523if = new int[size2];
            int i8 = 0;
            while (i8 < size2) {
                GLES20.glGenFramebuffers(i7, this.f11097pf, i8);
                GLES20.glGenTextures(i7, this.f523if, i8);
                GLES20.glBindTexture(3553, this.f523if[i8]);
                GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f11097pf[i8]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f523if[i8], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i8++;
                i7 = 1;
            }
        }
    }

    public List<qw> ppp() {
        return this.f11095i;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m2359switch(qw qwVar) {
        if (qwVar != null) {
            this.f11095i.add(qwVar);
            vvv();
        }
    }

    public void th() {
        when();
        for (qw qw : this.f11095i) {
            qw.qw();
        }
        super.th();
    }

    public void vvv() {
        if (this.f11095i != null) {
            List<qw> list = this.f11096o;
            if (list == null) {
                this.f11096o = new ArrayList();
            } else {
                list.clear();
            }
            for (qw next : this.f11095i) {
                if (next instanceof ad) {
                    ad adVar = (ad) next;
                    adVar.vvv();
                    List<qw> ggg = adVar.ggg();
                    if (ggg != null && !ggg.isEmpty()) {
                        this.f11096o.addAll(ggg);
                    }
                } else {
                    this.f11096o.add(next);
                }
            }
        }
    }

    public final void when() {
        int[] iArr = this.f523if;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.f523if = null;
        }
        int[] iArr2 = this.f11097pf;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f11097pf = null;
        }
    }

    @SuppressLint({"WrongCall"})
    public void yj(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<qw> list;
        m2360if();
        if (rg() && this.f11097pf != null && this.f523if != null && (list = this.f11096o) != null) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                qw qwVar = this.f11096o.get(i3);
                int i4 = size - 1;
                boolean z = i3 < i4;
                if (z) {
                    GLES20.glBindFramebuffer(36160, this.f11097pf[i3]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i3 == 0) {
                    qwVar.yj(i2, floatBuffer, floatBuffer2);
                } else if (i3 == i4) {
                    qwVar.yj(i2, this.f524switch, size % 2 == 0 ? this.ppp : this.when);
                } else {
                    qwVar.yj(i2, this.f524switch, this.when);
                }
                if (z) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i2 = this.f523if[i3];
                }
                i3++;
            }
        }
    }

    public ad(List<qw> list) {
        this.f11095i = list;
        if (list == null) {
            this.f11095i = new ArrayList();
        } else {
            vvv();
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(qw.tt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f524switch = asFloatBuffer;
        asFloatBuffer.put(qw.tt).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(yj.qw.qw.qw.qw.fe.ad.qw.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.when = asFloatBuffer2;
        asFloatBuffer2.put(yj.qw.qw.qw.qw.fe.ad.qw).position(0);
        float[] ad2 = yj.qw.qw.qw.qw.fe.ad.ad(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(ad2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.ppp = asFloatBuffer3;
        asFloatBuffer3.put(ad2).position(0);
    }
}
