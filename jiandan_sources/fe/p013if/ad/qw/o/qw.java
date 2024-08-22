package fe.p013if.ad.qw.o;

import android.view.MotionEvent;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnEndTipShowListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

/* renamed from: fe.if.ad.qw.o.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public OnErrorListener f4526ad;

    /* renamed from: de  reason: collision with root package name */
    public OnPageErrorListener f4527de;

    /* renamed from: fe  reason: collision with root package name */
    public OnRenderListener f4528fe;

    /* renamed from: i  reason: collision with root package name */
    public OnTapListener f4529i;

    /* renamed from: if  reason: not valid java name */
    public OnEndTipShowListener f167if;

    /* renamed from: o  reason: collision with root package name */
    public OnLongPressListener f4530o;

    /* renamed from: pf  reason: collision with root package name */
    public LinkHandler f4531pf;
    public OnLoadCompleteListener qw;

    /* renamed from: rg  reason: collision with root package name */
    public OnPageChangeListener f4532rg;

    /* renamed from: th  reason: collision with root package name */
    public OnPageScrollListener f4533th;

    /* renamed from: uk  reason: collision with root package name */
    public OnDrawListener f4534uk;

    /* renamed from: yj  reason: collision with root package name */
    public OnDrawListener f4535yj;

    public void aaa(OnPageScrollListener onPageScrollListener) {
        this.f4533th = onPageScrollListener;
    }

    public void ad() {
        OnEndTipShowListener onEndTipShowListener = this.f167if;
        if (onEndTipShowListener != null) {
            onEndTipShowListener.onEndTipShow();
        }
    }

    public void ddd(OnLongPressListener onLongPressListener) {
        this.f4530o = onLongPressListener;
    }

    public void de(int i2) {
        OnLoadCompleteListener onLoadCompleteListener = this.qw;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.loadComplete(i2);
        }
    }

    public void eee(OnTapListener onTapListener) {
        this.f4529i = onTapListener;
    }

    public void fe(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener = this.f4530o;
        if (onLongPressListener != null) {
            onLongPressListener.onLongPress(motionEvent);
        }
    }

    public void ggg(OnEndTipShowListener onEndTipShowListener) {
        this.f167if = onEndTipShowListener;
    }

    public boolean i(MotionEvent motionEvent) {
        OnTapListener onTapListener = this.f4529i;
        return onTapListener != null && onTapListener.onTap(motionEvent);
    }

    /* renamed from: if  reason: not valid java name */
    public OnErrorListener m287if() {
        return this.f4526ad;
    }

    public void mmm(OnPageErrorListener onPageErrorListener) {
        this.f4527de = onPageErrorListener;
    }

    public void nn(OnPageChangeListener onPageChangeListener) {
        this.f4532rg = onPageChangeListener;
    }

    public OnDrawListener o() {
        return this.f4535yj;
    }

    public OnDrawListener pf() {
        return this.f4534uk;
    }

    public void ppp(OnDrawListener onDrawListener) {
        this.f4534uk = onDrawListener;
    }

    public void qqq(OnRenderListener onRenderListener) {
        this.f4528fe = onRenderListener;
    }

    public void qw(fe.p013if.ad.qw.pf.qw qwVar) {
        LinkHandler linkHandler = this.f4531pf;
        if (linkHandler != null) {
            linkHandler.qw(qwVar);
        }
    }

    public void rg(int i2, int i3) {
        OnPageChangeListener onPageChangeListener = this.f4532rg;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageChanged(i2, i3);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m288switch(LinkHandler linkHandler) {
        this.f4531pf = linkHandler;
    }

    public boolean th(int i2, Throwable th2) {
        OnPageErrorListener onPageErrorListener = this.f4527de;
        if (onPageErrorListener == null) {
            return false;
        }
        onPageErrorListener.qw(i2, th2);
        return true;
    }

    public void uk(int i2) {
        OnRenderListener onRenderListener = this.f4528fe;
        if (onRenderListener != null) {
            onRenderListener.onInitiallyRendered(i2);
        }
    }

    public void vvv(OnErrorListener onErrorListener) {
        this.f4526ad = onErrorListener;
    }

    public void when(OnDrawListener onDrawListener) {
        this.f4535yj = onDrawListener;
    }

    public void xxx(OnLoadCompleteListener onLoadCompleteListener) {
        this.qw = onLoadCompleteListener;
    }

    public void yj(int i2, float f) {
        OnPageScrollListener onPageScrollListener = this.f4533th;
        if (onPageScrollListener != null) {
            onPageScrollListener.qw(i2, f);
        }
    }
}
