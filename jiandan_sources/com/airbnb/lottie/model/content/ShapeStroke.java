package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.pf.ad.ppp;
import fe.qw.qw.rg;
import java.util.List;

public class ShapeStroke implements ContentModel {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public final ad f601ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<ad> f602de;

    /* renamed from: fe  reason: collision with root package name */
    public final fe.qw.qw.p009switch.uk.qw f603fe;

    /* renamed from: i  reason: collision with root package name */
    public final float f604i;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f605o;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final fe f606rg;

    /* renamed from: th  reason: collision with root package name */
    public final ad f607th;

    /* renamed from: uk  reason: collision with root package name */
    public final LineJoinType f608uk;

    /* renamed from: yj  reason: collision with root package name */
    public final LineCapType f609yj;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i2 = qw.qw[ordinal()];
            if (i2 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i2 = qw.f610ad[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public static /* synthetic */ class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f610ad;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f610ad = r0
                r1 = 1
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f610ad     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.MITER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f610ad     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                qw = r3
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.BUTT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.ROUND     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x004d }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r1 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.ShapeStroke.qw.<clinit>():void");
        }
    }

    public ShapeStroke(String str, @Nullable ad adVar, List<ad> list, fe.qw.qw.p009switch.uk.qw qwVar, fe feVar, ad adVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.qw = str;
        this.f601ad = adVar;
        this.f602de = list;
        this.f603fe = qwVar;
        this.f606rg = feVar;
        this.f607th = adVar2;
        this.f609yj = lineCapType;
        this.f608uk = lineJoinType;
        this.f604i = f;
        this.f605o = z;
    }

    public LineCapType ad() {
        return this.f609yj;
    }

    public fe.qw.qw.p009switch.uk.qw de() {
        return this.f603fe;
    }

    public ad fe() {
        return this.f601ad;
    }

    public fe i() {
        return this.f606rg;
    }

    public ad o() {
        return this.f607th;
    }

    public boolean pf() {
        return this.f605o;
    }

    public Content qw(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar) {
        return new ppp(rgVar, qwVar, this);
    }

    public LineJoinType rg() {
        return this.f608uk;
    }

    public List<ad> th() {
        return this.f602de;
    }

    public String uk() {
        return this.qw;
    }

    public float yj() {
        return this.f604i;
    }
}
