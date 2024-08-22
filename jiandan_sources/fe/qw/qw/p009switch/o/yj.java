package fe.qw.qw.p009switch.o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.p009switch.i.i;
import fe.qw.qw.p009switch.uk.pf;
import fe.qw.qw.pf.de.Cswitch;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.rg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* renamed from: fe.qw.qw.switch.o.yj  reason: invalid package */
public class yj extends qw {
    public final RectF a = new RectF();
    public final Matrix b = new Matrix();
    public final Paint c = new qw(this, 1);
    public final Paint d = new ad(this, 1);
    public final Map<fe.qw.qw.p009switch.de, List<fe.qw.qw.pf.ad.de>> e = new HashMap();
    public final LongSparseArray<String> f = new LongSparseArray<>();
    public final Cswitch g;
    public final rg h;
    public final fe.qw.qw.de j;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> k;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> l;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> m;
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> n;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> p;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> q;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> r;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> s;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> t;
    public final StringBuilder tt = new StringBuilder(2);
    @Nullable
    public BaseKeyframeAnimation<Float, Float> u;

    /* renamed from: fe.qw.qw.switch.o.yj$ad */
    public class ad extends Paint {
        public ad(yj yjVar, int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* renamed from: fe.qw.qw.switch.o.yj$de */
    public static /* synthetic */ class de {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.model.DocumentData$Justification[] r0 = com.airbnb.lottie.model.DocumentData.Justification.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.p009switch.o.yj.de.<clinit>():void");
        }
    }

    /* renamed from: fe.qw.qw.switch.o.yj$qw */
    public class qw extends Paint {
        public qw(yj yjVar, int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    public yj(rg rgVar, Layer layer) {
        super(rgVar, layer);
        fe.qw.qw.p009switch.uk.ad adVar;
        fe.qw.qw.p009switch.uk.ad adVar2;
        fe.qw.qw.p009switch.uk.qw qwVar;
        fe.qw.qw.p009switch.uk.qw qwVar2;
        this.h = rgVar;
        this.j = layer.qw();
        Cswitch fe2 = layer.vvv().qw();
        this.g = fe2;
        fe2.qw(this);
        i(this.g);
        pf xxx = layer.xxx();
        if (!(xxx == null || (qwVar2 = xxx.qw) == null)) {
            BaseKeyframeAnimation<Integer, Integer> qw2 = qwVar2.qw();
            this.k = qw2;
            qw2.qw(this);
            i(this.k);
        }
        if (!(xxx == null || (qwVar = xxx.f3508ad) == null)) {
            BaseKeyframeAnimation<Integer, Integer> qw3 = qwVar.qw();
            this.m = qw3;
            qw3.qw(this);
            i(this.m);
        }
        if (!(xxx == null || (adVar2 = xxx.f3509de) == null)) {
            BaseKeyframeAnimation<Float, Float> qw4 = adVar2.qw();
            this.p = qw4;
            qw4.qw(this);
            i(this.p);
        }
        if (xxx != null && (adVar = xxx.f3510fe) != null) {
            BaseKeyframeAnimation<Float, Float> qw5 = adVar.qw();
            this.r = qw5;
            qw5.qw(this);
            i(this.r);
        }
    }

    public <T> void de(T t2, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        super.de(t2, deVar);
        if (t2 == LottieProperty.qw) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.l;
            if (baseKeyframeAnimation != null) {
                c(baseKeyframeAnimation);
            }
            if (deVar == null) {
                this.l = null;
                return;
            }
            ppp ppp = new ppp(deVar);
            this.l = ppp;
            ppp.qw(this);
            i(this.l);
        } else if (t2 == LottieProperty.f554ad) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.n;
            if (baseKeyframeAnimation2 != null) {
                c(baseKeyframeAnimation2);
            }
            if (deVar == null) {
                this.n = null;
                return;
            }
            ppp ppp2 = new ppp(deVar);
            this.n = ppp2;
            ppp2.qw(this);
            i(this.n);
        } else if (t2 == LottieProperty.ppp) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.q;
            if (baseKeyframeAnimation3 != null) {
                c(baseKeyframeAnimation3);
            }
            if (deVar == null) {
                this.q = null;
                return;
            }
            ppp ppp3 = new ppp(deVar);
            this.q = ppp3;
            ppp3.qw(this);
            i(this.q);
        } else if (t2 == LottieProperty.ggg) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.s;
            if (baseKeyframeAnimation4 != null) {
                c(baseKeyframeAnimation4);
            }
            if (deVar == null) {
                this.s = null;
                return;
            }
            ppp ppp4 = new ppp(deVar);
            this.s = ppp4;
            ppp4.qw(this);
            i(this.s);
        } else if (t2 == LottieProperty.b) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.u;
            if (baseKeyframeAnimation5 != null) {
                c(baseKeyframeAnimation5);
            }
            if (deVar == null) {
                this.u = null;
                return;
            }
            ppp ppp5 = new ppp(deVar);
            this.u = ppp5;
            ppp5.qw(this);
            i(this.u);
        }
    }

    public final void l(DocumentData.Justification justification, Canvas canvas, float f2) {
        int i2 = de.qw[justification.ordinal()];
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 == 3) {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    public final String m(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!z(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = (long) codePointAt;
        if (this.f.containsKey(j2)) {
            return this.f.get(j2);
        }
        this.tt.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.tt.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.tt.toString();
        this.f.put(j2, sb);
        return sb;
    }

    public final void n(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    public void nn(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.h.c0()) {
            canvas.concat(matrix);
        }
        DocumentData documentData = (DocumentData) this.g.uk();
        fe.qw.qw.p009switch.ad adVar = this.j.yj().get(documentData.f577ad);
        if (adVar == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.l;
        if (baseKeyframeAnimation != null) {
            this.c.setColor(baseKeyframeAnimation.uk().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.k;
            if (baseKeyframeAnimation2 != null) {
                this.c.setColor(baseKeyframeAnimation2.uk().intValue());
            } else {
                this.c.setColor(documentData.f585uk);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            this.d.setColor(baseKeyframeAnimation3.uk().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.m;
            if (baseKeyframeAnimation4 != null) {
                this.d.setColor(baseKeyframeAnimation4.uk().intValue());
            } else {
                this.d.setColor(documentData.f580i);
            }
        }
        int intValue = ((this.aaa.uk() == null ? 100 : this.aaa.uk().uk().intValue()) * 255) / 100;
        this.c.setAlpha(intValue);
        this.d.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.q;
        if (baseKeyframeAnimation5 != null) {
            this.d.setStrokeWidth(baseKeyframeAnimation5.uk().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.p;
            if (baseKeyframeAnimation6 != null) {
                this.d.setStrokeWidth(baseKeyframeAnimation6.uk().floatValue());
            } else {
                this.d.setStrokeWidth(documentData.f581o * fe.qw.qw.ggg.yj.rg() * fe.qw.qw.ggg.yj.yj(matrix));
            }
        }
        if (this.h.c0()) {
            u(documentData, matrix, adVar, canvas);
        } else {
            v(documentData, adVar, matrix, canvas);
        }
        canvas.restore();
    }

    public final void p(fe.qw.qw.p009switch.de deVar, Matrix matrix, float f2, DocumentData documentData, Canvas canvas) {
        List<fe.qw.qw.pf.ad.de> w = w(deVar);
        for (int i2 = 0; i2 < w.size(); i2++) {
            Path path = w.get(i2).getPath();
            path.computeBounds(this.a, false);
            this.b.set(matrix);
            this.b.preTranslate(0.0f, (-documentData.f586yj) * fe.qw.qw.ggg.yj.rg());
            this.b.preScale(f2, f2);
            path.transform(this.b);
            if (documentData.f582pf) {
                s(path, this.c, canvas);
                s(path, this.d, canvas);
            } else {
                s(path, this.d, canvas);
                s(path, this.c, canvas);
            }
        }
    }

    public final void q(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f582pf) {
            n(str, this.c, canvas);
            n(str, this.d, canvas);
            return;
        }
        n(str, this.d, canvas);
        n(str, this.c, canvas);
    }

    public final void r(String str, DocumentData documentData, Canvas canvas, float f2) {
        int i2 = 0;
        while (i2 < str.length()) {
            String m2 = m(str, i2);
            i2 += m2.length();
            q(m2, documentData, canvas);
            canvas.translate(this.c.measureText(m2) + f2, 0.0f);
        }
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        super.rg(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, (float) this.j.ad().width(), (float) this.j.ad().height());
    }

    public final void s(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    public final void t(String str, DocumentData documentData, Matrix matrix, fe.qw.qw.p009switch.ad adVar, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            fe.qw.qw.p009switch.de deVar = this.j.de().get(fe.qw.qw.p009switch.de.de(str.charAt(i2), adVar.qw(), adVar.de()));
            if (deVar != null) {
                p(deVar, matrix, f3, documentData, canvas);
                float ad2 = ((float) deVar.ad()) * f3 * fe.qw.qw.ggg.yj.rg() * f2;
                float f4 = ((float) documentData.f583rg) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.s;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.uk().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.r;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.uk().floatValue();
                    }
                    canvas.translate(ad2 + (f4 * f2), 0.0f);
                }
                f4 += floatValue;
                canvas.translate(ad2 + (f4 * f2), 0.0f);
            }
        }
    }

    public final void u(DocumentData documentData, Matrix matrix, fe.qw.qw.p009switch.ad adVar, Canvas canvas) {
        float f2;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.u;
        if (baseKeyframeAnimation != null) {
            f2 = baseKeyframeAnimation.uk().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.t;
            if (baseKeyframeAnimation2 != null) {
                f2 = baseKeyframeAnimation2.uk().floatValue();
            } else {
                f2 = documentData2.f578de;
            }
        }
        float f3 = f2 / 100.0f;
        float yj2 = fe.qw.qw.ggg.yj.yj(matrix);
        String str = documentData2.qw;
        float rg2 = documentData2.f584th * fe.qw.qw.ggg.yj.rg();
        List<String> y = y(str);
        int size = y.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = y.get(i2);
            float x = x(str2, adVar, f3, yj2);
            canvas.save();
            l(documentData2.f579fe, canvas2, x);
            canvas2.translate(0.0f, (((float) i2) * rg2) - ((((float) (size - 1)) * rg2) / 2.0f));
            t(str2, documentData, matrix, adVar, canvas, yj2, f3);
            canvas.restore();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a7 A[LOOP:0: B:20:0x00a5->B:21:0x00a7, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(com.airbnb.lottie.model.DocumentData r7, fe.qw.qw.p009switch.ad r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            fe.qw.qw.ggg.yj.yj(r9)
            fe.qw.qw.rg r9 = r6.h
            java.lang.String r0 = r8.qw()
            java.lang.String r8 = r8.de()
            android.graphics.Typeface r8 = r9.h(r0, r8)
            if (r8 != 0) goto L_0x0014
            return
        L_0x0014:
            java.lang.String r9 = r7.qw
            fe.qw.qw.rg r0 = r6.h
            fe.qw.qw.o r0 = r0.g()
            if (r0 != 0) goto L_0x00df
            android.graphics.Paint r0 = r6.c
            r0.setTypeface(r8)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.u
            if (r8 == 0) goto L_0x0032
            java.lang.Object r8 = r8.uk()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L_0x0043
        L_0x0032:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.t
            if (r8 == 0) goto L_0x0041
            java.lang.Object r8 = r8.uk()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L_0x0043
        L_0x0041:
            float r8 = r7.f578de
        L_0x0043:
            android.graphics.Paint r0 = r6.c
            float r1 = fe.qw.qw.ggg.yj.rg()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.d
            android.graphics.Paint r1 = r6.c
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.d
            android.graphics.Paint r1 = r6.c
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f584th
            float r1 = fe.qw.qw.ggg.yj.rg()
            float r0 = r0 * r1
            int r1 = r7.f583rg
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.s
            if (r2 == 0) goto L_0x0082
            java.lang.Object r2 = r2.uk()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L_0x0080:
            float r1 = r1 + r2
            goto L_0x0091
        L_0x0082:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.r
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r2.uk()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L_0x0080
        L_0x0091:
            float r2 = fe.qw.qw.ggg.yj.rg()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.y(r9)
            int r9 = r8.size()
            r2 = 0
        L_0x00a5:
            if (r2 >= r9) goto L_0x00de
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.d
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + -1
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.model.DocumentData$Justification r5 = r7.f579fe
            r6.l(r5, r10, r4)
            int r4 = r9 + -1
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.r(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto L_0x00a5
        L_0x00de:
            return
        L_0x00df:
            r0.qw(r9)
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.p009switch.o.yj.v(com.airbnb.lottie.model.DocumentData, fe.qw.qw.switch.ad, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    public final List<fe.qw.qw.pf.ad.de> w(fe.qw.qw.p009switch.de deVar) {
        if (this.e.containsKey(deVar)) {
            return this.e.get(deVar);
        }
        List<i> qw2 = deVar.qw();
        int size = qw2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new fe.qw.qw.pf.ad.de(this.h, this, qw2.get(i2)));
        }
        this.e.put(deVar, arrayList);
        return arrayList;
    }

    public final float x(String str, fe.qw.qw.p009switch.ad adVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            fe.qw.qw.p009switch.de deVar = this.j.de().get(fe.qw.qw.p009switch.de.de(str.charAt(i2), adVar.qw(), adVar.de()));
            if (deVar != null) {
                f4 = (float) (((double) f4) + (deVar.ad() * ((double) f2) * ((double) fe.qw.qw.ggg.yj.rg()) * ((double) f3)));
            }
        }
        return f4;
    }

    public final List<String> y(String str) {
        return Arrays.asList(str.replaceAll("\r\n", StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
    }

    public final boolean z(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }
}
