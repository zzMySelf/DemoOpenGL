package fe.mmm.qw.f.de.de.fe;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public float f7779ad;

    /* renamed from: de  reason: collision with root package name */
    public int f7780de;

    /* renamed from: fe  reason: collision with root package name */
    public int f7781fe;
    public ViewPager qw;

    /* renamed from: fe.mmm.qw.f.de.de.fe.ad$ad  reason: collision with other inner class name */
    public static class C0277ad {

        /* renamed from: ad  reason: collision with root package name */
        public float f7782ad;

        /* renamed from: de  reason: collision with root package name */
        public int f7783de;

        /* renamed from: fe  reason: collision with root package name */
        public int f7784fe;
        public ViewPager qw;

        public C0277ad(@NonNull ViewPager viewPager) {
            this.qw = viewPager;
        }

        public C0277ad ad(float f) {
            this.f7782ad = f;
            return this;
        }

        public C0277ad de(int i2) {
            this.f7783de = i2;
            return this;
        }

        public C0277ad fe(int i2) {
            this.f7784fe = i2;
            return this;
        }

        public ad qw() {
            return new ad(this.qw, this.f7782ad, this.f7783de, this.f7784fe);
        }
    }

    public float ad() {
        return this.f7779ad;
    }

    public int de() {
        return this.f7780de;
    }

    public int fe() {
        return this.f7781fe;
    }

    public void qw(int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            int i4 = this.f7780de;
            int i5 = this.f7781fe;
            int i6 = i2 - (i4 * 2);
            int i7 = i3 - (i5 * 2);
            float f = this.f7779ad;
            if (f > 0.0f && i7 > 0 && i6 > 0) {
                float f2 = (float) i7;
                float f3 = (float) i6;
                if (f >= f2 / f3) {
                    i4 = (int) (((float) i4) + (((float) (i6 - ((int) (f2 / f)))) * 0.5f));
                } else {
                    i5 = (int) (((float) i5) + (((float) (i7 - ((int) (f3 * f)))) * 0.5f));
                }
            }
            if (this.qw.getPaddingLeft() != i4 || this.qw.getPaddingRight() != i4 || this.qw.getPaddingTop() != i5 || this.qw.getPaddingBottom() != i5) {
                this.qw.setClipToPadding(false);
                this.qw.setPadding(i4, i5, i4, i5);
            }
        }
    }

    public void rg(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.f7779ad != f) {
            this.f7779ad = f;
            this.qw.requestLayout();
        }
    }

    public void th(int i2) {
        if (this.f7780de != i2) {
            this.f7780de = i2;
            this.qw.requestLayout();
        }
    }

    public void yj(int i2) {
        if (this.f7781fe != i2) {
            this.f7781fe = i2;
            this.qw.requestLayout();
        }
    }

    public ad(ViewPager viewPager, float f, int i2, int i3) {
        this.qw = viewPager;
        this.f7779ad = f;
        this.f7780de = i2;
        this.f7781fe = i3;
    }
}
