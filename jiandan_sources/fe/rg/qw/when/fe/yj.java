package fe.rg.qw.when.fe;

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
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import fe.rg.qw.ggg.uk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class yj<T extends View, Z> extends qw<Z> {
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public static Integer f5087pf;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5088i;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5089o;

    /* renamed from: th  reason: collision with root package name */
    public final T f5090th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public View.OnAttachStateChangeListener f5091uk;

    /* renamed from: yj  reason: collision with root package name */
    public final qw f5092yj;

    @VisibleForTesting
    public static final class qw {
        @VisibleForTesting
        @Nullable

        /* renamed from: rg  reason: collision with root package name */
        public static Integer f5093rg;

        /* renamed from: ad  reason: collision with root package name */
        public final List<SizeReadyCallback> f5094ad = new ArrayList();

        /* renamed from: de  reason: collision with root package name */
        public boolean f5095de;
        @Nullable

        /* renamed from: fe  reason: collision with root package name */
        public C0217qw f5096fe;
        public final View qw;

        /* renamed from: fe.rg.qw.when.fe.yj$qw$qw  reason: collision with other inner class name */
        public static final class C0217qw implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: ad  reason: collision with root package name */
            public final WeakReference<qw> f5097ad;

            public C0217qw(@NonNull qw qwVar) {
                this.f5097ad = new WeakReference<>(qwVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                qw qwVar = (qw) this.f5097ad.get();
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
            if (f5093rg == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                uk.fe(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5093rg = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5093rg.intValue();
        }

        public void ad() {
            ViewTreeObserver viewTreeObserver = this.qw.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5096fe);
            }
            this.f5096fe = null;
            this.f5094ad.clear();
        }

        public void fe(@NonNull SizeReadyCallback sizeReadyCallback) {
            int yj2 = yj();
            int th2 = th();
            if (i(yj2, th2)) {
                sizeReadyCallback.ad(yj2, th2);
                return;
            }
            if (!this.f5094ad.contains(sizeReadyCallback)) {
                this.f5094ad.add(sizeReadyCallback);
            }
            if (this.f5096fe == null) {
                ViewTreeObserver viewTreeObserver = this.qw.getViewTreeObserver();
                C0217qw qwVar = new C0217qw(this);
                this.f5096fe = qwVar;
                viewTreeObserver.addOnPreDrawListener(qwVar);
            }
        }

        public final boolean i(int i2, int i3) {
            return uk(i2) && uk(i3);
        }

        public final void o(int i2, int i3) {
            Iterator it = new ArrayList(this.f5094ad).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).ad(i2, i3);
            }
        }

        public void pf(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f5094ad.remove(sizeReadyCallback);
        }

        public void qw() {
            if (!this.f5094ad.isEmpty()) {
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
            if (this.f5095de && this.qw.isLayoutRequested()) {
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
        uk.fe(t);
        this.f5090th = (View) t;
        this.f5092yj = new qw(t);
    }

    @CallSuper
    public void ad(@Nullable Drawable drawable) {
        super.ad(drawable);
        this.f5092yj.ad();
        if (!this.f5088i) {
            o();
        }
    }

    @CallSuper
    public void fe(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f5092yj.pf(sizeReadyCallback);
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
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5091uk;
        if (onAttachStateChangeListener != null && !this.f5089o) {
            this.f5090th.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f5089o = true;
        }
    }

    public final void o() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5091uk;
        if (onAttachStateChangeListener != null && this.f5089o) {
            this.f5090th.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f5089o = false;
        }
    }

    public final void pf(@Nullable Object obj) {
        Integer num = f5087pf;
        if (num == null) {
            this.f5090th.setTag(obj);
        } else {
            this.f5090th.setTag(num.intValue(), obj);
        }
    }

    @CallSuper
    public void qw(@Nullable Drawable drawable) {
        super.qw(drawable);
        i();
    }

    public void th(@Nullable Request request) {
        pf(request);
    }

    public String toString() {
        return "Target for: " + this.f5090th;
    }

    @Nullable
    public final Object uk() {
        Integer num = f5087pf;
        if (num == null) {
            return this.f5090th.getTag();
        }
        return this.f5090th.getTag(num.intValue());
    }

    @CallSuper
    public void yj(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f5092yj.fe(sizeReadyCallback);
    }
}
