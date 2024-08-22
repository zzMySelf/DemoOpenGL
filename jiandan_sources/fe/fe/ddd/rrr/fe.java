package fe.fe.ddd.rrr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

public class fe {
    public static final Interpolator qqq = new qw();
    public final Runnable aaa = new ad();

    /* renamed from: ad  reason: collision with root package name */
    public int f1571ad;
    public View ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f1572de = -1;

    /* renamed from: fe  reason: collision with root package name */
    public float[] f1573fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1574i;

    /* renamed from: if  reason: not valid java name */
    public VelocityTracker f30if;
    public final ViewGroup mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public int[] f1575o;

    /* renamed from: pf  reason: collision with root package name */
    public int f1576pf;
    public int ppp;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public float[] f1577rg;

    /* renamed from: switch  reason: not valid java name */
    public float f31switch;

    /* renamed from: th  reason: collision with root package name */
    public float[] f1578th;

    /* renamed from: uk  reason: collision with root package name */
    public int[] f1579uk;
    public ScrollerCompat vvv;
    public float when;
    public final de xxx;

    /* renamed from: yj  reason: collision with root package name */
    public float[] f1580yj;

    public class ad implements Runnable {
        public ad() {
        }

        public void run() {
            fe.this.g(0);
        }
    }

    public static abstract class de {
        public int ad(View view, int i2, int i3) {
            return 0;
        }

        public int de(int i2) {
            return i2;
        }

        public abstract int fe(View view);

        public void i(int i2, int i3) {
        }

        /* renamed from: if  reason: not valid java name */
        public abstract void m78if(View view, int i2, int i3, int i4, int i5);

        public abstract void o(View view, int i2);

        public abstract void pf(int i2);

        public abstract int qw(View view, int i2, int i3);

        public int rg(View view) {
            return 0;
        }

        /* renamed from: switch  reason: not valid java name */
        public abstract void m79switch(View view, float f, float f2);

        public abstract boolean th();

        public boolean uk(int i2) {
            return false;
        }

        public abstract boolean when(View view, int i2);

        public abstract void yj(int i2, int i3);
    }

    public static class qw implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public fe(Context context, ViewGroup viewGroup, de deVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (deVar != null) {
            this.mmm = viewGroup;
            this.xxx = deVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.ppp = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1571ad = viewConfiguration.getScaledTouchSlop();
            this.f31switch = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.when = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.vvv = ScrollerCompat.create(context, qqq);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static fe m76switch(ViewGroup viewGroup, float f, de deVar) {
        fe when2 = when(viewGroup, deVar);
        when2.f1571ad = (int) (((float) when2.f1571ad) * (1.0f / f));
        return when2;
    }

    public static fe when(ViewGroup viewGroup, de deVar) {
        return new fe(viewGroup.getContext(), viewGroup, deVar);
    }

    public boolean a(View view, int i2, int i3) {
        if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final float aaa(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getX(motionEvent, findPointerIndex);
    }

    public void ad() {
        this.f1572de = -1;
        uk();
        VelocityTracker velocityTracker = this.f30if;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f30if = null;
        }
    }

    public void b(MotionEvent motionEvent) {
        int i2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            ad();
        }
        if (this.f30if == null) {
            this.f30if = VelocityTracker.obtain();
        }
        this.f30if.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View ddd2 = ddd((int) x, (int) y);
            e(x, y, pointerId);
            n(ddd2, pointerId);
            int i4 = this.f1579uk[pointerId];
            int i5 = this.ggg;
            if ((i4 & i5) != 0) {
                this.xxx.i(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.qw == 1) {
                c();
            }
            ad();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.qw == 1) {
                    ppp(0.0f, 0.0f);
                }
                ad();
            } else if (actionMasked == 5) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float aaa2 = aaa(motionEvent, actionIndex);
                float qqq2 = qqq(motionEvent, actionIndex);
                if (aaa2 != -1.0f && qqq2 != -1.0f) {
                    e(aaa2, qqq2, pointerId2);
                    if (this.qw == 0) {
                        n(ddd((int) aaa2, (int) qqq2), pointerId2);
                        int i6 = this.f1579uk[pointerId2];
                        int i7 = this.ggg;
                        if ((i6 & i7) != 0) {
                            this.xxx.i(i6 & i7, pointerId2);
                        }
                    } else if (tt((int) aaa2, (int) qqq2)) {
                        n(this.ddd, pointerId2);
                    }
                }
            } else if (actionMasked == 6) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.qw == 1 && pointerId3 == this.f1572de) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, i3);
                        if (pointerId4 != this.f1572de) {
                            float aaa3 = aaa(motionEvent, i3);
                            float qqq3 = qqq(motionEvent, i3);
                            if (aaa3 != -1.0f && qqq3 != -1.0f) {
                                View ddd3 = ddd((int) aaa3, (int) qqq3);
                                View view = this.ddd;
                                if (ddd3 == view && n(view, pointerId4)) {
                                    i2 = this.f1572de;
                                    break;
                                }
                            } else {
                                return;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        c();
                    }
                }
                i(pointerId3);
            }
        } else if (this.qw == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1572de);
            float aaa4 = aaa(motionEvent, findPointerIndex);
            float qqq4 = qqq(motionEvent, findPointerIndex);
            if (aaa4 != -1.0f && qqq4 != -1.0f) {
                float[] fArr = this.f1578th;
                int i8 = this.f1572de;
                int i9 = (int) (aaa4 - fArr[i8]);
                int i10 = (int) (qqq4 - this.f1580yj[i8]);
                vvv(this.ddd.getLeft() + i9, this.ddd.getTop() + i10, i9, i10);
                f(motionEvent);
            }
        } else {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (i3 < pointerCount2) {
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                float aaa5 = aaa(motionEvent, i3);
                float qqq5 = qqq(motionEvent, i3);
                if (aaa5 != -1.0f && qqq5 != -1.0f) {
                    float f = aaa5 - this.f1573fe[pointerId5];
                    float f2 = qqq5 - this.f1577rg[pointerId5];
                    d(f, f2, pointerId5);
                    if (this.qw != 1) {
                        View ddd4 = ddd((int) aaa5, (int) qqq5);
                        if (rg(ddd4, f, f2) && n(ddd4, pointerId5)) {
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                } else {
                    return;
                }
            }
            f(motionEvent);
        }
    }

    public final void c() {
        this.f30if.computeCurrentVelocity(1000, this.f31switch);
        ppp(th(VelocityTrackerCompat.getXVelocity(this.f30if, this.f1572de), this.when, this.f31switch), th(VelocityTrackerCompat.getYVelocity(this.f30if, this.f1572de), this.when, this.f31switch));
    }

    public final void d(float f, float f2, int i2) {
        int i3 = 1;
        if (!fe(f, f2, i2, 1)) {
            i3 = 0;
        }
        if (fe(f2, f, i2, 4)) {
            i3 |= 4;
        }
        if (fe(f, f2, i2, 2)) {
            i3 |= 2;
        }
        if (fe(f2, f, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f1574i;
            iArr[i2] = iArr[i2] | i3;
            this.xxx.yj(i3, i2);
        }
    }

    public View ddd(int i2, int i3) {
        for (int childCount = this.mmm.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.mmm;
            this.xxx.de(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void de(View view, int i2) {
        if (view.getParent() == this.mmm) {
            this.ddd = view;
            this.f1572de = i2;
            this.xxx.o(view, i2);
            g(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mmm + ")");
    }

    public final void e(float f, float f2, int i2) {
        xxx(i2);
        float[] fArr = this.f1573fe;
        this.f1578th[i2] = f;
        fArr[i2] = f;
        float[] fArr2 = this.f1577rg;
        this.f1580yj[i2] = f2;
        fArr2[i2] = f2;
        this.f1579uk[i2] = mmm((int) f, (int) f2);
        this.f1576pf |= 1 << i2;
    }

    public int eee() {
        return this.f1571ad;
    }

    public final void f(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        int i2 = 0;
        while (i2 < pointerCount) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            float aaa2 = aaa(motionEvent, i2);
            float qqq2 = qqq(motionEvent, i2);
            if (aaa2 != -1.0f && qqq2 != -1.0f) {
                this.f1578th[pointerId] = aaa2;
                this.f1580yj[pointerId] = qqq2;
                i2++;
            } else {
                return;
            }
        }
    }

    public final boolean fe(float f, float f2, int i2, int i3) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1579uk[i2] & i3) != i3 || (this.ggg & i3) == 0 || (this.f1575o[i2] & i3) == i3 || (this.f1574i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f1571ad;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.xxx.uk(i3)) {
            int[] iArr = this.f1575o;
            iArr[i2] = iArr[i2] | i3;
            return false;
        } else if ((this.f1574i[i2] & i3) != 0 || abs <= ((float) this.f1571ad)) {
            return false;
        } else {
            return true;
        }
    }

    public void g(int i2) {
        if (this.qw != i2) {
            this.qw = i2;
            this.xxx.pf(i2);
            if (this.qw == 0) {
                this.ddd = null;
            }
        }
    }

    public final float ggg(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void h(int i2) {
        this.ggg = i2;
    }

    public final void i(int i2) {
        float[] fArr = this.f1573fe;
        if (fArr != null) {
            fArr[i2] = 0.0f;
            this.f1577rg[i2] = 0.0f;
            this.f1578th[i2] = 0.0f;
            this.f1580yj[i2] = 0.0f;
            this.f1579uk[i2] = 0;
            this.f1574i[i2] = 0;
            this.f1575o[i2] = 0;
            this.f1576pf = (~(1 << i2)) & this.f1576pf;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m77if(boolean z) {
        if (this.qw == 2) {
            boolean computeScrollOffset = this.vvv.computeScrollOffset();
            int currX = this.vvv.getCurrX();
            int currY = this.vvv.getCurrY();
            int left = currX - this.ddd.getLeft();
            int top = currY - this.ddd.getTop();
            if (left != 0) {
                this.ddd.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.ddd.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.xxx.m78if(this.ddd, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.vvv.getFinalX() && currY == this.vvv.getFinalY()) {
                this.vvv.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.mmm.post(this.aaa);
                } else {
                    g(0);
                }
            }
        }
        if (this.qw == 2) {
            return true;
        }
        return false;
    }

    public void j(float f) {
        this.when = f;
    }

    public boolean k(int i2, int i3) {
        if (this.nn) {
            return nn(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.f30if, this.f1572de), (int) VelocityTrackerCompat.getYVelocity(this.f30if, this.f1572de));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        if (r13 != r12) goto L_0x00ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = androidx.core.view.MotionEventCompat.getActionMasked(r17)
            int r3 = androidx.core.view.MotionEventCompat.getActionIndex(r17)
            if (r2 != 0) goto L_0x0011
            r16.ad()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f30if
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f30if = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f30if
            r4.addMovement(r1)
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x010f
            if (r2 == r5) goto L_0x010a
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r4) goto L_0x007f
            r8 = 3
            if (r2 == r8) goto L_0x010a
            r8 = 5
            if (r2 == r8) goto L_0x003f
            r4 = 6
            if (r2 == r4) goto L_0x0036
            goto L_0x0140
        L_0x0036:
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r1, r3)
            r0.i(r1)
            goto L_0x0140
        L_0x003f:
            int r2 = androidx.core.view.MotionEventCompat.getPointerId(r1, r3)
            float r8 = r0.aaa(r1, r3)
            float r1 = r0.qqq(r1, r3)
            int r3 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0050
            return r6
        L_0x0050:
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0055
            return r6
        L_0x0055:
            r0.e(r8, r1, r2)
            int r3 = r0.qw
            if (r3 != 0) goto L_0x006e
            int[] r1 = r0.f1579uk
            r1 = r1[r2]
            int r3 = r0.ggg
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0140
            fe.fe.ddd.rrr.fe$de r4 = r0.xxx
            r1 = r1 & r3
            r4.i(r1, r2)
            goto L_0x0140
        L_0x006e:
            if (r3 != r4) goto L_0x0140
            int r3 = (int) r8
            int r1 = (int) r1
            android.view.View r1 = r0.ddd(r3, r1)
            android.view.View r3 = r0.ddd
            if (r1 != r3) goto L_0x0140
            r0.n(r1, r2)
            goto L_0x0140
        L_0x007f:
            int r2 = androidx.core.view.MotionEventCompat.getPointerCount(r17)
            r3 = 0
        L_0x0084:
            if (r3 >= r2) goto L_0x0106
            int r4 = androidx.core.view.MotionEventCompat.getPointerId(r1, r3)
            float r8 = r0.aaa(r1, r3)
            float r9 = r0.qqq(r1, r3)
            int r10 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x0097
            return r6
        L_0x0097:
            int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r10 != 0) goto L_0x009c
            return r6
        L_0x009c:
            float[] r10 = r0.f1573fe
            r10 = r10[r4]
            float r10 = r8 - r10
            float[] r11 = r0.f1577rg
            r11 = r11[r4]
            float r11 = r9 - r11
            int r8 = (int) r8
            int r9 = (int) r9
            android.view.View r8 = r0.ddd(r8, r9)
            if (r8 == 0) goto L_0x00b8
            boolean r9 = r0.rg(r8, r10, r11)
            if (r9 == 0) goto L_0x00b8
            r9 = 1
            goto L_0x00b9
        L_0x00b8:
            r9 = 0
        L_0x00b9:
            if (r9 == 0) goto L_0x00ee
            int r12 = r8.getLeft()
            int r13 = (int) r10
            int r14 = r12 + r13
            fe.fe.ddd.rrr.fe$de r15 = r0.xxx
            int r13 = r15.qw(r8, r14, r13)
            int r14 = r8.getTop()
            int r15 = (int) r11
            int r7 = r14 + r15
            fe.fe.ddd.rrr.fe$de r6 = r0.xxx
            int r6 = r6.ad(r8, r7, r15)
            fe.fe.ddd.rrr.fe$de r7 = r0.xxx
            int r7 = r7.fe(r8)
            fe.fe.ddd.rrr.fe$de r15 = r0.xxx
            int r15 = r15.rg(r8)
            if (r7 == 0) goto L_0x00e7
            if (r7 <= 0) goto L_0x00ee
            if (r13 != r12) goto L_0x00ee
        L_0x00e7:
            if (r15 == 0) goto L_0x0106
            if (r15 <= 0) goto L_0x00ee
            if (r6 != r14) goto L_0x00ee
            goto L_0x0106
        L_0x00ee:
            r0.d(r10, r11, r4)
            int r6 = r0.qw
            if (r6 != r5) goto L_0x00f6
            goto L_0x0106
        L_0x00f6:
            if (r9 == 0) goto L_0x00ff
            boolean r4 = r0.n(r8, r4)
            if (r4 == 0) goto L_0x00ff
            goto L_0x0106
        L_0x00ff:
            int r3 = r3 + 1
            r6 = 0
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0084
        L_0x0106:
            r16.f(r17)
            goto L_0x010d
        L_0x010a:
            r16.ad()
        L_0x010d:
            r6 = 0
            goto L_0x0140
        L_0x010f:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r6 = 0
            int r1 = androidx.core.view.MotionEventCompat.getPointerId(r1, r6)
            r0.e(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.ddd(r2, r3)
            android.view.View r3 = r0.ddd
            if (r2 != r3) goto L_0x0130
            int r3 = r0.qw
            if (r3 != r4) goto L_0x0130
            r0.n(r2, r1)
        L_0x0130:
            int[] r2 = r0.f1579uk
            r2 = r2[r1]
            int r3 = r0.ggg
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0140
            fe.fe.ddd.rrr.fe$de r4 = r0.xxx
            r2 = r2 & r3
            r4.i(r2, r1)
        L_0x0140:
            int r1 = r0.qw
            if (r1 != r5) goto L_0x0145
            goto L_0x0146
        L_0x0145:
            r5 = 0
        L_0x0146:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.rrr.fe.l(android.view.MotionEvent):boolean");
    }

    public boolean m(View view, int i2, int i3) {
        this.ddd = view;
        this.f1572de = -1;
        boolean nn2 = nn(i2, i3, 0, 0);
        if (!nn2 && this.qw == 0 && this.ddd != null) {
            this.ddd = null;
        }
        return nn2;
    }

    public final int mmm(int i2, int i3) {
        int i4 = i2 < this.mmm.getLeft() + this.ppp ? 1 : 0;
        if (i3 < this.mmm.getTop() + this.ppp) {
            i4 |= 4;
        }
        if (i2 > this.mmm.getRight() - this.ppp) {
            i4 |= 2;
        }
        return i3 > this.mmm.getBottom() - this.ppp ? i4 | 8 : i4;
    }

    public boolean n(View view, int i2) {
        if (view == this.ddd && this.f1572de == i2) {
            return true;
        }
        if (view == null || !this.xxx.when(view, i2)) {
            return false;
        }
        this.f1572de = i2;
        de(view, i2);
        return true;
    }

    public final boolean nn(int i2, int i3, int i4, int i5) {
        int left = this.ddd.getLeft();
        int top = this.ddd.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.vvv.abortAnimation();
            g(0);
            return false;
        }
        this.vvv.startScroll(left, top, i6, i7, pf(this.ddd, i6, i7, i4, i5));
        g(2);
        return true;
    }

    public final int o(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.mmm.getWidth();
        float f = (float) (width / 2);
        float ggg2 = f + (ggg(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(ggg2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    public final int pf(View view, int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        float f3;
        float f4;
        int yj2 = yj(i4, (int) this.when, (int) this.f31switch);
        int yj3 = yj(i5, (int) this.when, (int) this.f31switch);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(yj2);
        int abs4 = Math.abs(yj3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (yj2 != 0) {
            f2 = (float) abs3;
            f = (float) i6;
        } else {
            f2 = (float) abs;
            f = (float) i7;
        }
        float f5 = f2 / f;
        if (yj3 != 0) {
            f4 = (float) abs4;
            f3 = (float) i6;
        } else {
            f4 = (float) abs2;
            f3 = (float) i7;
        }
        float f6 = f4 / f3;
        return (int) ((((float) o(i2, yj2, this.xxx.fe(view))) * f5) + (((float) o(i3, yj3, this.xxx.rg(view))) * f6));
    }

    public final void ppp(float f, float f2) {
        this.nn = true;
        this.xxx.m79switch(this.ddd, f, f2);
        this.nn = false;
        if (this.qw == 1) {
            g(0);
        }
    }

    public final float qqq(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    public void qw() {
        ad();
        if (this.qw == 2) {
            int currX = this.vvv.getCurrX();
            int currY = this.vvv.getCurrY();
            this.vvv.abortAnimation();
            int currX2 = this.vvv.getCurrX();
            int currY2 = this.vvv.getCurrY();
            this.xxx.m78if(this.ddd, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        g(0);
    }

    public final boolean rg(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.xxx.fe(view) > 0;
        boolean z2 = this.xxx.rg(view) > 0;
        if (z && z2) {
            int i2 = this.f1571ad;
            if ((f * f) + (f2 * f2) > ((float) (i2 * i2))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f1571ad)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f1571ad)) {
            return false;
        } else {
            return true;
        }
    }

    public int rrr() {
        return this.qw;
    }

    public final float th(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    public boolean tt(int i2, int i3) {
        return a(this.ddd, i2, i3);
    }

    public final void uk() {
        float[] fArr = this.f1573fe;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1577rg, 0.0f);
            Arrays.fill(this.f1578th, 0.0f);
            Arrays.fill(this.f1580yj, 0.0f);
            Arrays.fill(this.f1579uk, 0);
            Arrays.fill(this.f1574i, 0);
            Arrays.fill(this.f1575o, 0);
            this.f1576pf = 0;
        }
    }

    public final void vvv(int i2, int i3, int i4, int i5) {
        int left = this.ddd.getLeft();
        int top = this.ddd.getTop();
        if (i4 != 0) {
            i2 = this.xxx.qw(this.ddd, i2, i4);
            if (this.xxx.th()) {
                this.ddd.offsetLeftAndRight(i2 - left);
            }
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.xxx.ad(this.ddd, i3, i5);
            this.ddd.offsetTopAndBottom(i3 - top);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            int i8 = i6 - left;
            int i9 = i7 - top;
            if (this.xxx.th()) {
                this.xxx.m78if(this.ddd, i6, i7, i8, i9);
            }
        }
    }

    public final void xxx(int i2) {
        float[] fArr = this.f1573fe;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            float[] fArr6 = this.f1573fe;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1577rg;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f1578th;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f1580yj;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f1579uk;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1574i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1575o;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1573fe = fArr2;
            this.f1577rg = fArr3;
            this.f1578th = fArr4;
            this.f1580yj = fArr5;
            this.f1579uk = iArr;
            this.f1574i = iArr2;
            this.f1575o = iArr3;
        }
    }

    public final int yj(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }
}
