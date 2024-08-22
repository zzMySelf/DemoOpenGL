package fe.mmm.qw.th.qw.rg.fe.ad;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.widget.AutoScrollHelper;
import com.tera.scan.component.base.ui.widget.dragselectview.IDragSelectListener;
import com.tera.scan.component.base.ui.widget.dragselectview.IDragSelectView;
import fe.mmm.qw.i.qw;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public int f8345ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8346de;

    /* renamed from: fe  reason: collision with root package name */
    public int f8347fe = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f8348i;
    public int qw = -1;

    /* renamed from: rg  reason: collision with root package name */
    public IDragSelectView f8349rg;

    /* renamed from: th  reason: collision with root package name */
    public IDragSelectListener f8350th;

    /* renamed from: uk  reason: collision with root package name */
    public float f8351uk;

    /* renamed from: yj  reason: collision with root package name */
    public AutoScrollHelper f8352yj;

    public ad(IDragSelectView iDragSelectView) {
        this.f8349rg = iDragSelectView;
        this.f8352yj = iDragSelectView.initAutoScrollHelper();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ad(float r4, float r5) {
        /*
            r3 = this;
            com.tera.scan.component.base.ui.widget.dragselectview.IDragSelectView r0 = r3.f8349rg
            r1 = r0
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.view.View r4 = r0.findChildViewUnder(r1, r4, r5)
            r5 = 0
            r0 = -1
            if (r4 == 0) goto L_0x002d
            java.lang.Object r1 = r4.getTag()
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r4.getTag()
            boolean r2 = r1 instanceof fe.mmm.qw.th.qw.rg.fe.ad.qw
            if (r2 == 0) goto L_0x0021
            fe.mmm.qw.th.qw.rg.fe.ad.qw r1 = (fe.mmm.qw.th.qw.rg.fe.ad.qw) r1
            int r5 = r1.qw
            r1 = 1
            goto L_0x002f
        L_0x0021:
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x002d
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r5 = r1
            goto L_0x002e
        L_0x002d:
            r5 = -1
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r4 == 0) goto L_0x005a
            if (r5 == r0) goto L_0x005a
            int r4 = r3.qw
            if (r4 == r5) goto L_0x005a
            if (r1 == 0) goto L_0x004b
            int r4 = r3.f8347fe
            if (r5 >= r4) goto L_0x0041
            int r0 = r3.f8345ad
            if (r4 <= r0) goto L_0x0049
        L_0x0041:
            int r4 = r3.f8345ad
            if (r4 > r5) goto L_0x004b
            int r4 = r3.f8347fe
            if (r5 >= r4) goto L_0x004b
        L_0x0049:
            int r5 = r5 + 1
        L_0x004b:
            int r4 = r3.qw
            r3.f8347fe = r4
            r3.qw = r5
            com.tera.scan.component.base.ui.widget.dragselectview.IDragSelectListener r0 = r3.f8350th
            if (r0 == 0) goto L_0x005a
            int r0 = r3.f8345ad
            r3.fe(r0, r5, r4)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.th.qw.rg.fe.ad.ad.ad(float, float):void");
    }

    public void de() {
        ad(this.f8351uk, this.f8348i);
    }

    public void fe(int i2, int i3, int i4) {
        qw.ad("selectRange", "initSelection-->" + i2 + "  lastSelection-->" + i3 + "  oldLastSelection-->" + i4);
        if (i2 >= i3) {
            if (i4 < i3) {
                while (i4 < i3) {
                    this.f8350th.setDragSelected(i4, false);
                    i4++;
                }
            } else if (i4 > i3 && i4 <= i2) {
                for (int i5 = i4 - 1; i5 >= i3; i5 += -1) {
                    qw.ad("selectRange", "initSelection1-->" + i2 + "  lastSelection-->" + i3 + "  oldLastSelection-->" + i4);
                    this.f8350th.setDragSelected(i5, true);
                }
            } else if (i4 > i2) {
                for (int i6 = i4; i6 > i2; i6--) {
                    this.f8350th.setDragSelected(i6, false);
                }
                for (int i7 = i2; i7 >= i3; i7 += -1) {
                    qw.ad("selectRange", "initSelection2-->" + i2 + "  lastSelection-->" + i3 + "  oldLastSelection-->" + i4);
                    this.f8350th.setDragSelected(i7, true);
                }
            }
        } else if (i2 >= i3) {
        } else {
            if (i4 < i2) {
                for (int i8 = i4; i8 < i2; i8++) {
                    this.f8350th.setDragSelected(i8, false);
                }
                for (int i9 = i2; i9 <= i3; i9++) {
                    qw.ad("selectRange", "initSelection3-->" + i2 + "  lastSelection-->" + i3 + "  oldLastSelection-->" + i4);
                    this.f8350th.setDragSelected(i9, true);
                }
            } else if (i2 <= i4 && i4 < i3) {
                for (int i10 = i4 + 1; i10 <= i3; i10++) {
                    qw.ad("selectRange", "initSelection4-->" + i2 + "  lastSelection-->" + i3 + "  oldLastSelection-->" + i4);
                    this.f8350th.setDragSelected(i10, true);
                }
            } else if (i4 > i3) {
                while (i4 > i3) {
                    this.f8350th.setDragSelected(i4, false);
                    i4--;
                }
            }
        }
    }

    public boolean qw(MotionEvent motionEvent) {
        this.f8351uk = motionEvent.getX();
        this.f8348i = motionEvent.getY();
        if (this.f8346de) {
            this.f8352yj.onTouch((ViewGroup) this.f8349rg, motionEvent);
            if (motionEvent.getAction() == 1) {
                this.f8346de = false;
                this.f8350th.dragSelectEnd(this.f8345ad, this.qw);
                return true;
            } else if (motionEvent.getAction() == 2) {
                ViewGroup parentDragView = this.f8349rg.getParentDragView();
                if (parentDragView != null) {
                    parentDragView.requestDisallowInterceptTouchEvent(true);
                }
                ad(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        }
        return false;
    }

    public void rg(boolean z, int i2) {
        this.qw = -1;
        this.f8346de = z;
        this.f8345ad = i2;
        this.qw = i2;
    }

    public void th(IDragSelectListener iDragSelectListener) {
        this.f8350th = iDragSelectListener;
    }
}
