package com.itextpdf.text;

import com.itextpdf.text.pdf.draw.DrawInterface;

public class TabStop {

    /* renamed from: ad  reason: collision with root package name */
    public Alignment f6533ad;

    /* renamed from: de  reason: collision with root package name */
    public DrawInterface f6534de;

    /* renamed from: fe  reason: collision with root package name */
    public char f6535fe;
    public float qw;

    public enum Alignment {
        LEFT,
        RIGHT,
        CENTER,
        ANCHOR
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.TabStop$Alignment[] r0 = com.itextpdf.text.TabStop.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.ANCHOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.TabStop.qw.<clinit>():void");
        }
    }

    public TabStop(float f) {
        this(f, Alignment.LEFT);
    }

    public static TabStop th(float f, float f2) {
        float round = ((float) Math.round(f * 1000.0f)) / 1000.0f;
        float round2 = ((float) Math.round(f2 * 1000.0f)) / 1000.0f;
        return new TabStop((round + round2) - (round % round2));
    }

    public char ad() {
        return this.f6535fe;
    }

    public DrawInterface de() {
        return this.f6534de;
    }

    public float fe() {
        return this.qw;
    }

    public Alignment qw() {
        return this.f6533ad;
    }

    public float rg(float f, float f2, float f3) {
        float f4;
        float f5 = this.qw;
        float f6 = f2 - f;
        int i2 = qw.qw[this.f6533ad.ordinal()];
        if (i2 == 1) {
            f4 = this.qw;
            if (f + f6 >= f4) {
                return f;
            }
        } else if (i2 == 2) {
            f6 /= 2.0f;
            f4 = this.qw;
            if (f + f6 >= f4) {
                return f;
            }
        } else if (i2 != 3) {
            return f5;
        } else {
            if (!Float.isNaN(f3)) {
                float f7 = this.qw;
                if (f3 < f7) {
                    return f7 - (f3 - f);
                }
                return f;
            }
            f4 = this.qw;
            if (f + f6 >= f4) {
                return f;
            }
        }
        return f4 - f6;
    }

    public void yj(float f) {
        this.qw = f;
    }

    public TabStop(float f, Alignment alignment) {
        this(f, (DrawInterface) null, alignment);
    }

    public TabStop(float f, DrawInterface drawInterface, Alignment alignment) {
        this(f, drawInterface, alignment, '.');
    }

    public TabStop(float f, DrawInterface drawInterface, Alignment alignment, char c) {
        this.f6533ad = Alignment.LEFT;
        this.f6535fe = '.';
        this.qw = f;
        this.f6534de = drawInterface;
        this.f6533ad = alignment;
        this.f6535fe = c;
    }

    public TabStop(TabStop tabStop) {
        this(tabStop.fe(), tabStop.de(), tabStop.qw(), tabStop.ad());
    }
}
