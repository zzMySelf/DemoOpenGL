package fe.p013if.ad.qw;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.util.SizeF;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.if.ad.qw.rg  reason: invalid package */
public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public int f4547ad;

    /* renamed from: de  reason: collision with root package name */
    public float f4548de;

    /* renamed from: fe  reason: collision with root package name */
    public float f4549fe;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f4550i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: o  reason: collision with root package name */
    public final int f4551o;
    public PDFView qw;

    /* renamed from: rg  reason: collision with root package name */
    public float f4552rg;

    /* renamed from: th  reason: collision with root package name */
    public float f4553th;

    /* renamed from: uk  reason: collision with root package name */
    public float f4554uk;

    /* renamed from: yj  reason: collision with root package name */
    public float f4555yj;

    /* renamed from: fe.if.ad.qw.rg$ad */
    public class ad {

        /* renamed from: ad  reason: collision with root package name */
        public int f4556ad;
        public int qw;

        public ad(rg rgVar) {
        }

        public String toString() {
            return "GridSize{rows=" + this.qw + ", cols=" + this.f4556ad + ExtendedMessageFormat.END_FE;
        }
    }

    /* renamed from: fe.if.ad.qw.rg$de */
    public class de {

        /* renamed from: ad  reason: collision with root package name */
        public int f4557ad;
        public int qw;

        public de(rg rgVar) {
        }

        public String toString() {
            return "Holder{row=" + this.qw + ", col=" + this.f4557ad + ExtendedMessageFormat.END_FE;
        }
    }

    /* renamed from: fe.if.ad.qw.rg$fe */
    public class fe {

        /* renamed from: ad  reason: collision with root package name */
        public ad f4558ad;

        /* renamed from: de  reason: collision with root package name */
        public de f4559de;

        /* renamed from: fe  reason: collision with root package name */
        public de f4560fe;
        public int qw = 0;

        public fe(rg rgVar) {
            this.f4558ad = new ad();
            this.f4559de = new de();
            this.f4560fe = new de();
        }

        public String toString() {
            return "RenderRange{page=" + this.qw + ", gridSize=" + this.f4558ad + ", leftTop=" + this.f4559de + ", rightBottom=" + this.f4560fe + ExtendedMessageFormat.END_FE;
        }
    }

    public rg(PDFView pDFView) {
        this.qw = pDFView;
        this.f4551o = fe.p013if.ad.qw.p015switch.fe.qw(pDFView.getContext(), 20);
    }

    public final void ad(ad adVar, int i2) {
        SizeF when = this.qw.pdfFile.when(i2);
        adVar.qw = fe.p013if.ad.qw.p015switch.ad.qw(1.0f / (((1.0f / when.getHeight()) * 256.0f) / this.qw.getZoom()));
        adVar.f4556ad = fe.p013if.ad.qw.p015switch.ad.qw(1.0f / (((1.0f / when.getWidth()) * 256.0f) / this.qw.getZoom()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<fe.p013if.ad.qw.rg.fe> de(float r20, float r21, float r22, float r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r2 = r20
            float r2 = fe.p013if.ad.qw.p015switch.ad.fe(r2, r1)
            float r2 = -r2
            r3 = r21
            float r3 = fe.p013if.ad.qw.p015switch.ad.fe(r3, r1)
            float r3 = -r3
            r4 = r22
            float r4 = fe.p013if.ad.qw.p015switch.ad.fe(r4, r1)
            float r4 = -r4
            r5 = r23
            float r5 = fe.p013if.ad.qw.p015switch.ad.fe(r5, r1)
            float r5 = -r5
            com.github.barteksc.pdfviewer.PDFView r6 = r0.qw
            boolean r6 = r6.isSwipeVertical()
            if (r6 == 0) goto L_0x0029
            r6 = r3
            goto L_0x002a
        L_0x0029:
            r6 = r2
        L_0x002a:
            com.github.barteksc.pdfviewer.PDFView r7 = r0.qw
            boolean r7 = r7.isSwipeVertical()
            if (r7 == 0) goto L_0x0034
            r7 = r5
            goto L_0x0035
        L_0x0034:
            r7 = r4
        L_0x0035:
            com.github.barteksc.pdfviewer.PDFView r8 = r0.qw
            fe.if.ad.qw.th r9 = r8.pdfFile
            float r8 = r8.getZoom()
            int r6 = r9.o(r6, r8)
            com.github.barteksc.pdfviewer.PDFView r8 = r0.qw
            fe.if.ad.qw.th r9 = r8.pdfFile
            float r8 = r8.getZoom()
            int r7 = r9.o(r7, r8)
            int r8 = r7 - r6
            r9 = 1
            int r8 = r8 + r9
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
            r11 = r6
        L_0x0057:
            if (r11 > r7) goto L_0x0200
            fe.if.ad.qw.rg$fe r12 = new fe.if.ad.qw.rg$fe
            r12.<init>(r0)
            r12.qw = r11
            if (r11 != r6) goto L_0x009f
            if (r8 != r9) goto L_0x006b
            r13 = r2
            r15 = r3
            r14 = r4
        L_0x0067:
            r16 = r5
            goto L_0x00f0
        L_0x006b:
            com.github.barteksc.pdfviewer.PDFView r13 = r0.qw
            fe.if.ad.qw.th r14 = r13.pdfFile
            float r13 = r13.getZoom()
            float r13 = r14.m292switch(r11, r13)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.qw
            fe.if.ad.qw.th r15 = r14.pdfFile
            float r14 = r14.getZoom()
            com.shockwave.pdfium.util.SizeF r14 = r15.vvv(r11, r14)
            com.github.barteksc.pdfviewer.PDFView r15 = r0.qw
            boolean r15 = r15.isSwipeVertical()
            if (r15 == 0) goto L_0x0093
            float r14 = r14.getHeight()
            float r13 = r13 + r14
            r14 = r13
            r13 = r4
            goto L_0x0099
        L_0x0093:
            float r14 = r14.getWidth()
            float r13 = r13 + r14
            r14 = r5
        L_0x0099:
            r15 = r3
            r16 = r14
            r14 = r13
            r13 = r2
            goto L_0x00f0
        L_0x009f:
            if (r11 != r7) goto L_0x00bd
            com.github.barteksc.pdfviewer.PDFView r13 = r0.qw
            fe.if.ad.qw.th r14 = r13.pdfFile
            float r13 = r13.getZoom()
            float r13 = r14.m292switch(r11, r13)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.qw
            boolean r14 = r14.isSwipeVertical()
            if (r14 == 0) goto L_0x00b8
            r14 = r13
            r13 = r2
            goto L_0x00b9
        L_0x00b8:
            r14 = r3
        L_0x00b9:
            r16 = r5
            r15 = r14
            goto L_0x00e6
        L_0x00bd:
            com.github.barteksc.pdfviewer.PDFView r13 = r0.qw
            fe.if.ad.qw.th r14 = r13.pdfFile
            float r13 = r13.getZoom()
            float r13 = r14.m292switch(r11, r13)
            com.github.barteksc.pdfviewer.PDFView r14 = r0.qw
            fe.if.ad.qw.th r15 = r14.pdfFile
            float r14 = r14.getZoom()
            com.shockwave.pdfium.util.SizeF r14 = r15.vvv(r11, r14)
            com.github.barteksc.pdfviewer.PDFView r15 = r0.qw
            boolean r15 = r15.isSwipeVertical()
            if (r15 == 0) goto L_0x00e8
            float r14 = r14.getHeight()
            float r14 = r14 + r13
            r15 = r13
            r16 = r14
            r13 = r2
        L_0x00e6:
            r14 = r4
            goto L_0x00f0
        L_0x00e8:
            float r14 = r14.getWidth()
            float r14 = r14 + r13
            r15 = r3
            goto L_0x0067
        L_0x00f0:
            fe.if.ad.qw.rg$ad r9 = r12.f4558ad
            int r1 = r12.qw
            r0.ad(r9, r1)
            com.github.barteksc.pdfviewer.PDFView r1 = r0.qw
            fe.if.ad.qw.th r9 = r1.pdfFile
            r17 = r2
            int r2 = r12.qw
            float r1 = r1.getZoom()
            com.shockwave.pdfium.util.SizeF r1 = r9.vvv(r2, r1)
            float r2 = r1.getHeight()
            fe.if.ad.qw.rg$ad r9 = r12.f4558ad
            int r9 = r9.qw
            float r9 = (float) r9
            float r2 = r2 / r9
            float r1 = r1.getWidth()
            fe.if.ad.qw.rg$ad r9 = r12.f4558ad
            int r9 = r9.f4556ad
            float r9 = (float) r9
            float r1 = r1 / r9
            com.github.barteksc.pdfviewer.PDFView r9 = r0.qw
            r21 = r3
            fe.if.ad.qw.th r3 = r9.pdfFile
            float r9 = r9.getZoom()
            float r3 = r3.xxx(r11, r9)
            com.github.barteksc.pdfviewer.PDFView r9 = r0.qw
            boolean r9 = r9.isSwipeVertical()
            if (r9 == 0) goto L_0x0190
            fe.if.ad.qw.rg$de r9 = r12.f4559de
            r22 = r4
            com.github.barteksc.pdfviewer.PDFView r4 = r0.qw
            r23 = r5
            fe.if.ad.qw.th r5 = r4.pdfFile
            r18 = r6
            int r6 = r12.qw
            float r4 = r4.getZoom()
            float r4 = r5.m292switch(r6, r4)
            float r15 = r15 - r4
            float r4 = java.lang.Math.abs(r15)
            float r4 = r4 / r2
            int r4 = fe.p013if.ad.qw.p015switch.ad.ad(r4)
            r9.qw = r4
            fe.if.ad.qw.rg$de r4 = r12.f4559de
            float r13 = r13 - r3
            r5 = 0
            float r6 = fe.p013if.ad.qw.p015switch.ad.rg(r13, r5)
            float r6 = r6 / r1
            int r5 = fe.p013if.ad.qw.p015switch.ad.ad(r6)
            r4.f4557ad = r5
            fe.if.ad.qw.rg$de r4 = r12.f4560fe
            com.github.barteksc.pdfviewer.PDFView r5 = r0.qw
            fe.if.ad.qw.th r6 = r5.pdfFile
            int r9 = r12.qw
            float r5 = r5.getZoom()
            float r5 = r6.m292switch(r9, r5)
            float r16 = r16 - r5
            float r5 = java.lang.Math.abs(r16)
            float r5 = r5 / r2
            int r2 = fe.p013if.ad.qw.p015switch.ad.qw(r5)
            r4.qw = r2
            fe.if.ad.qw.rg$de r2 = r12.f4560fe
            float r14 = r14 - r3
            r3 = 0
            float r4 = fe.p013if.ad.qw.p015switch.ad.rg(r14, r3)
            float r4 = r4 / r1
            int r1 = fe.p013if.ad.qw.p015switch.ad.ad(r4)
            r2.f4557ad = r1
            r4 = 0
            goto L_0x01ed
        L_0x0190:
            r22 = r4
            r23 = r5
            r18 = r6
            fe.if.ad.qw.rg$de r4 = r12.f4559de
            com.github.barteksc.pdfviewer.PDFView r5 = r0.qw
            fe.if.ad.qw.th r6 = r5.pdfFile
            int r9 = r12.qw
            float r5 = r5.getZoom()
            float r5 = r6.m292switch(r9, r5)
            float r13 = r13 - r5
            float r5 = java.lang.Math.abs(r13)
            float r5 = r5 / r1
            int r5 = fe.p013if.ad.qw.p015switch.ad.ad(r5)
            r4.f4557ad = r5
            fe.if.ad.qw.rg$de r4 = r12.f4559de
            float r15 = r15 - r3
            r5 = 0
            float r6 = fe.p013if.ad.qw.p015switch.ad.rg(r15, r5)
            float r6 = r6 / r2
            int r5 = fe.p013if.ad.qw.p015switch.ad.ad(r6)
            r4.qw = r5
            fe.if.ad.qw.rg$de r4 = r12.f4560fe
            com.github.barteksc.pdfviewer.PDFView r5 = r0.qw
            fe.if.ad.qw.th r6 = r5.pdfFile
            int r9 = r12.qw
            float r5 = r5.getZoom()
            float r5 = r6.m292switch(r9, r5)
            float r14 = r14 - r5
            float r5 = java.lang.Math.abs(r14)
            float r5 = r5 / r1
            int r1 = fe.p013if.ad.qw.p015switch.ad.ad(r5)
            r4.f4557ad = r1
            fe.if.ad.qw.rg$de r1 = r12.f4560fe
            float r3 = r16 - r3
            r4 = 0
            float r3 = fe.p013if.ad.qw.p015switch.ad.rg(r3, r4)
            float r3 = r3 / r2
            int r2 = fe.p013if.ad.qw.p015switch.ad.ad(r3)
            r1.qw = r2
        L_0x01ed:
            r10.add(r12)
            int r11 = r11 + 1
            r3 = r21
            r4 = r22
            r5 = r23
            r2 = r17
            r6 = r18
            r1 = 0
            r9 = 1
            goto L_0x0057
        L_0x0200:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.p013if.ad.qw.rg.de(float, float, float, float):java.util.List");
    }

    public final boolean fe(int i2, int i3, int i4, float f, float f2) {
        float f3 = ((float) i4) * f;
        float f4 = ((float) i3) * f2;
        float f5 = this.f4555yj;
        float f6 = this.f4554uk;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= 0.0f || f10 <= 0.0f) {
            return false;
        }
        if (!this.qw.cacheManager.pf(i2, rectF, this.f4547ad)) {
            PDFView pDFView = this.qw;
            pDFView.renderingHandler.ad(i2, f9, f10, rectF, false, this.f4547ad, pDFView.isBestQuality(), this.qw.isAnnotationRendering());
        }
        this.f4547ad++;
        return true;
    }

    public final void qw(ad adVar) {
        float f = 1.0f / ((float) adVar.f4556ad);
        this.f4552rg = f;
        float f2 = 1.0f / ((float) adVar.qw);
        this.f4553th = f2;
        this.f4555yj = 256.0f / f;
        this.f4554uk = 256.0f / f2;
    }

    public final int rg(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        while (i3 <= i4) {
            for (int i9 = i5; i9 <= i6; i9++) {
                if (fe(i2, i3, i9, this.f4552rg, this.f4553th)) {
                    i8++;
                }
                if (i8 >= i7) {
                    return i8;
                }
            }
            i3++;
        }
        return i8;
    }

    public void th() {
        this.f4547ad = 1;
        this.f4548de = -fe.p013if.ad.qw.p015switch.ad.fe(this.qw.getCurrentXOffset(), 0.0f);
        this.f4549fe = -fe.p013if.ad.qw.p015switch.ad.fe(this.qw.getCurrentYOffset(), 0.0f);
        uk();
    }

    public final void uk() {
        float f = (float) this.f4551o;
        float f2 = this.f4548de;
        float f3 = this.f4549fe;
        List<fe> de2 = de((-f2) + f, (-f3) + f, ((-f2) - ((float) this.qw.getWidth())) - f, ((-f3) - ((float) this.qw.getHeight())) - f);
        for (fe feVar : de2) {
            yj(feVar.qw);
        }
        int i2 = 0;
        for (fe next : de2) {
            qw(next.f4558ad);
            int i3 = next.qw;
            de deVar = next.f4559de;
            int i4 = deVar.qw;
            de deVar2 = next.f4560fe;
            i2 += rg(i3, i4, deVar2.qw, deVar.f4557ad, deVar2.f4557ad, 120 - i2);
            if (i2 >= 120) {
                return;
            }
        }
    }

    public final void yj(int i2) {
        SizeF when = this.qw.pdfFile.when(i2);
        float width = when.getWidth() * 0.3f;
        float height = when.getHeight() * 0.3f;
        if (!this.qw.cacheManager.fe(i2, this.f4550i)) {
            PDFView pDFView = this.qw;
            pDFView.renderingHandler.ad(i2, width, height, this.f4550i, true, 0, pDFView.isBestQuality(), this.qw.isAnnotationRendering());
        }
    }
}
