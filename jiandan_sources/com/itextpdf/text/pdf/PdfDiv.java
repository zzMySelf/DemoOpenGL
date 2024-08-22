package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import fe.when.ad.de;
import fe.when.ad.f.ggg;
import fe.when.ad.f.s0;
import fe.when.ad.f.y0;
import fe.when.ad.fe;
import fe.when.ad.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PdfDiv implements Element, Spaceable, IAccessibleElement {
    public PositionType aaa = PositionType.STATIC;

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<Element> f6545ad = new ArrayList<>();
    public float ddd = 0.0f;
    public qw e = new qw();
    public float eee;
    public de f = null;
    public float g;
    public int ggg = -1;

    /* renamed from: i  reason: collision with root package name */
    public Float f6546i = null;

    /* renamed from: if  reason: not valid java name */
    public Float f258if = null;
    public FloatType mmm = FloatType.NONE;
    public float nn = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public Float f6547o = null;

    /* renamed from: pf  reason: collision with root package name */
    public Float f6548pf = null;
    public float ppp = 0.0f;
    public ggg qqq = null;
    public s0 rrr = s0.B0;

    /* renamed from: switch  reason: not valid java name */
    public Float f259switch = null;

    /* renamed from: th  reason: collision with root package name */
    public Float f6549th = null;
    public HashMap<s0, y0> tt = null;

    /* renamed from: uk  reason: collision with root package name */
    public Float f6550uk = null;
    public float vvv = 0.0f;
    public float when = 0.0f;
    public float xxx = 0.0f;

    /* renamed from: yj  reason: collision with root package name */
    public Float f6551yj = null;

    public enum FloatType {
        NONE,
        LEFT,
        RIGHT
    }

    public enum PositionType {
        STATIC,
        ABSOLUTE,
        FIXED,
        RELATIVE
    }

    public float ad() {
        Float f2 = this.f6547o;
        return (f2 == null || f2.floatValue() < this.when) ? this.when : this.f6547o.floatValue();
    }

    public de de() {
        return this.f;
    }

    public ArrayList<Element> fe() {
        return this.f6545ad;
    }

    public y0 getAccessibleAttribute(s0 s0Var) {
        HashMap<s0, y0> hashMap = this.tt;
        if (hashMap != null) {
            return hashMap.get(s0Var);
        }
        return null;
    }

    public HashMap<s0, y0> getAccessibleAttributes() {
        return this.tt;
    }

    public List<fe> getChunks() {
        return new ArrayList();
    }

    public qw getId() {
        return this.e;
    }

    public s0 getRole() {
        return this.rrr;
    }

    public float getSpacingBefore() {
        return this.g;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.ad(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public float qw() {
        Float f2 = this.f6548pf;
        return (f2 == null || f2.floatValue() < this.ppp) ? this.ppp : this.f6548pf.floatValue();
    }

    public FloatType rg() {
        return this.mmm;
    }

    public void setAccessibleAttribute(s0 s0Var, y0 y0Var) {
        if (this.tt == null) {
            this.tt = new HashMap<>();
        }
        this.tt.put(s0Var, y0Var);
    }

    public void setId(qw qwVar) {
        this.e = qwVar;
    }

    public void setRole(s0 s0Var) {
        this.rrr = s0Var;
    }

    public int th() {
        return this.ggg;
    }

    public int type() {
        return 37;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int uk(fe.when.ad.f.q r21, boolean r22, boolean r23, float r24, float r25, float r26, float r27) throws com.itextpdf.text.DocumentException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            float r7 = java.lang.Math.min(r3, r5)
            float r8 = java.lang.Math.max(r4, r6)
            float r4 = java.lang.Math.min(r4, r6)
            float r3 = java.lang.Math.max(r3, r5)
            r0.eee = r8
            java.lang.Float r5 = r0.f6547o
            r6 = 2
            r9 = 0
            java.lang.Float r10 = java.lang.Float.valueOf(r9)
            if (r5 == 0) goto L_0x0050
            float r5 = r5.floatValue()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0050
            java.lang.Float r5 = r0.f6547o
            float r5 = r5.floatValue()
            float r11 = r3 - r7
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0045
            java.lang.Float r3 = r0.f6547o
            float r3 = r3.floatValue()
            goto L_0x005d
        L_0x0045:
            java.lang.Float r5 = r0.f6547o
            float r5 = r5.floatValue()
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x005e
            return r6
        L_0x0050:
            java.lang.Float r5 = r0.f259switch
            if (r5 == 0) goto L_0x005e
            float r3 = r3 - r7
            float r5 = r5.floatValue()
            float r3 = r3 * r5
            r0.when = r3
        L_0x005d:
            float r3 = r3 + r7
        L_0x005e:
            java.lang.Float r5 = r0.f6548pf
            r11 = 1
            r12 = 0
            if (r5 == 0) goto L_0x008d
            float r5 = r5.floatValue()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x008d
            java.lang.Float r5 = r0.f6548pf
            float r5 = r5.floatValue()
            float r13 = r8 - r4
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0082
            java.lang.Float r4 = r0.f6548pf
            float r4 = r4.floatValue()
            float r4 = r8 - r4
            r12 = 1
            goto L_0x00ab
        L_0x0082:
            java.lang.Float r5 = r0.f6548pf
            float r5 = r5.floatValue()
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ab
            return r6
        L_0x008d:
            java.lang.Float r5 = r0.f258if
            if (r5 == 0) goto L_0x00ab
            float r5 = r5.floatValue()
            double r5 = (double) r5
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x009d
            r12 = 1
        L_0x009d:
            float r4 = r8 - r4
            java.lang.Float r5 = r0.f258if
            float r5 = r5.floatValue()
            float r4 = r4 * r5
            r0.ppp = r4
            float r4 = r8 - r4
        L_0x00ab:
            if (r2 != 0) goto L_0x00f5
            com.itextpdf.text.pdf.PdfDiv$PositionType r5 = r0.aaa
            com.itextpdf.text.pdf.PdfDiv$PositionType r6 = com.itextpdf.text.pdf.PdfDiv.PositionType.RELATIVE
            if (r5 != r6) goto L_0x00f5
            java.lang.Float r5 = r0.f6549th
            if (r5 == 0) goto L_0x00b8
            goto L_0x00c7
        L_0x00b8:
            java.lang.Float r5 = r0.f6550uk
            if (r5 == 0) goto L_0x00c6
            float r5 = r5.floatValue()
            float r5 = -r5
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L_0x00c7
        L_0x00c6:
            r5 = r10
        L_0x00c7:
            java.lang.Float r6 = r0.f6551yj
            if (r6 == 0) goto L_0x00d5
            float r6 = r6.floatValue()
            float r6 = -r6
            java.lang.Float r10 = java.lang.Float.valueOf(r6)
            goto L_0x00da
        L_0x00d5:
            java.lang.Float r6 = r0.f6546i
            if (r6 == 0) goto L_0x00da
            r10 = r6
        L_0x00da:
            r21.d0()
            com.itextpdf.awt.geom.AffineTransform r6 = new com.itextpdf.awt.geom.AffineTransform
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
            r16 = 0
            r17 = 1065353216(0x3f800000, float:1.0)
            float r18 = r5.floatValue()
            float r19 = r10.floatValue()
            r13 = r6
            r13.<init>((float) r14, (float) r15, (float) r16, (float) r17, (float) r18, (float) r19)
            r1.X0(r6)
        L_0x00f5:
            if (r2 != 0) goto L_0x015e
            fe.when.ad.de r5 = r0.f
            if (r5 == 0) goto L_0x015e
            float r5 = r20.ad()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x015e
            float r5 = r20.qw()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x015e
            float r5 = r20.ad()
            float r6 = r20.qw()
            java.lang.Float r10 = r0.f6547o
            if (r10 == 0) goto L_0x0127
            float r5 = r10.floatValue()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0126
            java.lang.Float r5 = r0.f6547o
            float r5 = r5.floatValue()
            goto L_0x0127
        L_0x0126:
            r5 = 0
        L_0x0127:
            java.lang.Float r10 = r0.f6548pf
            if (r10 == 0) goto L_0x013b
            float r6 = r10.floatValue()
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x013a
            java.lang.Float r6 = r0.f6548pf
            float r6 = r6.floatValue()
            goto L_0x013b
        L_0x013a:
            r6 = 0
        L_0x013b:
            int r10 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x015e
            int r10 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x015e
            fe.when.ad.aaa r10 = new fe.when.ad.aaa
            float r6 = r8 - r6
            float r5 = r5 + r7
            r10.<init>(r7, r6, r5, r8)
            fe.when.ad.de r5 = r0.f
            r10.e(r5)
            com.itextpdf.text.pdf.PdfArtifact r5 = new com.itextpdf.text.pdf.PdfArtifact
            r5.<init>()
            r1.K(r5)
            r1.O(r10)
            r1.eee(r5)
        L_0x015e:
            java.lang.Float r5 = r0.f259switch
            if (r5 != 0) goto L_0x0164
            r0.when = r9
        L_0x0164:
            java.lang.Float r5 = r0.f258if
            if (r5 != 0) goto L_0x016a
            r0.ppp = r9
        L_0x016a:
            float r5 = r0.nn
            float r4 = r4 + r5
            float r5 = r0.vvv
            float r7 = r7 + r5
            float r5 = r0.xxx
            float r3 = r3 - r5
            float r5 = r0.eee
            float r6 = r0.ddd
            float r5 = r5 - r6
            r0.eee = r5
            java.util.ArrayList<com.itextpdf.text.Element> r5 = r0.f6545ad
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x01c4
            fe.when.ad.f.ggg r5 = r0.qqq
            if (r5 != 0) goto L_0x0196
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.ArrayList<com.itextpdf.text.Element> r6 = r0.f6545ad
            r5.<init>(r6)
            fe.when.ad.f.ggg r6 = new fe.when.ad.f.ggg
            r9 = r22
            r6.<init>(r5, r9)
            r0.qqq = r6
        L_0x0196:
            fe.when.ad.f.ggg r5 = r0.qqq
            float r6 = r0.eee
            r5.rg(r7, r4, r3, r6)
            fe.when.ad.f.ggg r3 = r0.qqq
            int r3 = r3.fe(r1, r2)
            fe.when.ad.f.ggg r4 = r0.qqq
            float r4 = r4.de()
            r0.eee = r4
            java.lang.Float r4 = r0.f259switch
            if (r4 != 0) goto L_0x01c5
            float r4 = r0.when
            fe.when.ad.f.ggg r5 = r0.qqq
            float r5 = r5.ad()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x01c5
            fe.when.ad.f.ggg r4 = r0.qqq
            float r4 = r4.ad()
            r0.when = r4
            goto L_0x01c5
        L_0x01c4:
            r3 = 1
        L_0x01c5:
            if (r2 != 0) goto L_0x01d0
            com.itextpdf.text.pdf.PdfDiv$PositionType r2 = r0.aaa
            com.itextpdf.text.pdf.PdfDiv$PositionType r4 = com.itextpdf.text.pdf.PdfDiv.PositionType.RELATIVE
            if (r2 != r4) goto L_0x01d0
            r21.Y()
        L_0x01d0:
            float r1 = r0.eee
            float r2 = r0.nn
            float r1 = r1 - r2
            r0.eee = r1
            java.lang.Float r2 = r0.f258if
            if (r2 != 0) goto L_0x01de
            float r8 = r8 - r1
            r0.ppp = r8
        L_0x01de:
            java.lang.Float r1 = r0.f259switch
            if (r1 != 0) goto L_0x01ec
            float r1 = r0.when
            float r2 = r0.vvv
            float r4 = r0.xxx
            float r2 = r2 + r4
            float r1 = r1 + r2
            r0.when = r1
        L_0x01ec:
            if (r12 == 0) goto L_0x01ef
            goto L_0x01f0
        L_0x01ef:
            r11 = r3
        L_0x01f0:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDiv.uk(fe.when.ad.f.q, boolean, boolean, float, float, float, float):int");
    }

    public float yj() {
        return this.eee;
    }
}
