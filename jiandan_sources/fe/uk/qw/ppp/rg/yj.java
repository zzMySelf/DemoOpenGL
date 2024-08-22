package fe.uk.qw.ppp.rg;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.target.SizeReadyCallback;
import fe.uk.qw.vvv.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class yj<T extends View, Z> extends qw<Z> {

    /* renamed from: o  reason: collision with root package name */
    public static int f6028o = 2131362505;

    /* renamed from: ad  reason: collision with root package name */
    public final T f6029ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6030i;

    /* renamed from: th  reason: collision with root package name */
    public final qw f6031th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f6032uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public View.OnAttachStateChangeListener f6033yj;

    @VisibleForTesting
    public static final class qw {
        @VisibleForTesting
        @Nullable

        /* renamed from: rg  reason: collision with root package name */
        public static Integer f6034rg;

        /* renamed from: ad  reason: collision with root package name */
        public final List<SizeReadyCallback> f6035ad = new ArrayList();

        /* renamed from: de  reason: collision with root package name */
        public boolean f6036de;
        @Nullable

        /* renamed from: fe  reason: collision with root package name */
        public C0246qw f6037fe;
        public final View qw;

        /* renamed from: fe.uk.qw.ppp.rg.yj$qw$qw  reason: collision with other inner class name */
        public static final class C0246qw implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: ad  reason: collision with root package name */
            public final WeakReference<qw> f6038ad;

            public C0246qw(@NonNull qw qwVar) {
                this.f6038ad = new WeakReference<>(qwVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                qw qwVar = (qw) this.f6038ad.get();
                if (qwVar == null) {
                    return true;
                }
                qwVar.qw();
                return true;
            }
        }

        public qw(@NonNull View view) {
            this.qw = view;
        }

        public static int de(@NonNull Context context) {
            if (f6034rg == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                i.fe(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6034rg = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6034rg.intValue();
        }

        public void ad() {
            ViewTreeObserver viewTreeObserver = this.qw.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6037fe);
            }
            this.f6037fe = null;
            this.f6035ad.clear();
        }

        public void fe(@NonNull SizeReadyCallback sizeReadyCallback) {
            int yj2 = yj();
            int th2 = th();
            if (i(yj2, th2)) {
                sizeReadyCallback.ad(yj2, th2);
                return;
            }
            if (!this.f6035ad.contains(sizeReadyCallback)) {
                this.f6035ad.add(sizeReadyCallback);
            }
            if (this.f6037fe == null) {
                ViewTreeObserver viewTreeObserver = this.qw.getViewTreeObserver();
                C0246qw qwVar = new C0246qw(this);
                this.f6037fe = qwVar;
                viewTreeObserver.addOnPreDrawListener(qwVar);
            }
        }

        public final boolean i(int i2, int i3) {
            return uk(i2) && uk(i3);
        }

        public final void o(int i2, int i3) {
            Iterator it = new ArrayList(this.f6035ad).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).ad(i2, i3);
            }
        }

        public void pf(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f6035ad.remove(sizeReadyCallback);
        }

        public void qw() {
            if (!this.f6035ad.isEmpty()) {
                int yj2 = yj();
                int th2 = th();
                if (i(yj2, th2)) {
                    o(yj2, th2);
                    ad();
                }
            }
        }

        public final int rg(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6036de && this.qw.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.qw.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            boolean isLoggable = Log.isLoggable("ViewTarget", 4);
            return de(this.qw.getContext());
        }

        public final int th() {
            int paddingTop = this.qw.getPaddingTop() + this.qw.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.qw.getLayoutParams();
            return rg(this.qw.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final boolean uk(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        public final int yj() {
            int paddingLeft = this.qw.getPaddingLeft() + this.qw.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.qw.getLayoutParams();
            return rg(this.qw.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }
    }

    public yj(@NonNull T t) {
        i.fe(t);
        this.f6029ad = (View) t;
        this.f6031th = new qw(t);
    }

    @CallSuper
    public void ad(@Nullable Drawable drawable) {
        super.ad(drawable);
        this.f6031th.ad();
        if (!this.f6032uk) {
            o();
        }
    }

    @Nullable
    public Request getRequest() {
        Object uk2 = uk();
        if (uk2 == null) {
            return null;
        }
        if (uk2 instanceof Request) {
            return (Request) uk2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public final void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6033yj;
        if (onAttachStateChangeListener != null && !this.f6030i) {
            this.f6029ad.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6030i = true;
        }
    }

    public final void o() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6033yj;
        if (onAttachStateChangeListener != null && this.f6030i) {
            this.f6029ad.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6030i = false;
        }
    }

    public final void pf(@Nullable Object obj) {
        this.f6029ad.setTag(f6028o, obj);
    }

    @CallSuper
    public void qw(@Nullable Drawable drawable) {
        super.qw(drawable);
        i();
    }

    @CallSuper
    public void rg(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6031th.pf(sizeReadyCallback);
    }

    @CallSuper
    public void th(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6031th.fe(sizeReadyCallback);
    }

    public String toString() {
        return "Target for: " + this.f6029ad;
    }

    @Nullable
    public final Object uk() {
        return this.f6029ad.getTag(f6028o);
    }

    public void yj(@Nullable Request request) {
        pf(request);
    }
}
