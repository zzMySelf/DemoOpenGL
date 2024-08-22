package fe.vvv.qw.pf;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureFinder;

public class de extends GestureFinder {

    /* renamed from: yj  reason: collision with root package name */
    public static final CameraLogger f9058yj = CameraLogger.qw(de.class.getSimpleName());

    /* renamed from: fe  reason: collision with root package name */
    public GestureDetector f9059fe;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9060rg;

    /* renamed from: th  reason: collision with root package name */
    public float f9061th;

    public class qw extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ GestureFinder.Controller f9062ad;

        public qw(GestureFinder.Controller controller) {
            this.f9062ad = controller;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3;
            CameraLogger pf2 = de.f9058yj;
            boolean z = false;
            pf2.de("onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() != de.this.fe(0).x || motionEvent.getY() != de.this.fe(0).y) {
                boolean z2 = Math.abs(f) >= Math.abs(f2);
                de.this.o(z2 ? Gesture.SCROLL_HORIZONTAL : Gesture.SCROLL_VERTICAL);
                de.this.fe(0).set(motionEvent.getX(), motionEvent.getY());
                z = z2;
            } else if (de.this.de() == Gesture.SCROLL_HORIZONTAL) {
                z = true;
            }
            de.this.fe(1).set(motionEvent2.getX(), motionEvent2.getY());
            de deVar = de.this;
            if (z) {
                f3 = f / ((float) this.f9062ad.getWidth());
            } else {
                f3 = f2 / ((float) this.f9062ad.getHeight());
            }
            float unused = deVar.f9061th = f3;
            de deVar2 = de.this;
            float f4 = deVar2.f9061th;
            if (z) {
                f4 = -f4;
            }
            float unused2 = deVar2.f9061th = f4;
            boolean unused3 = de.this.f9060rg = true;
            return true;
        }
    }

    public de(@NonNull GestureFinder.Controller controller) {
        super(controller, 2);
        GestureDetector gestureDetector = new GestureDetector(controller.getContext(), new qw(controller));
        this.f9059fe = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    public float ppp() {
        return this.f9061th;
    }

    public float th(float f, float f2, float f3) {
        return f + (ppp() * (f3 - f2) * 2.0f);
    }

    public boolean yj(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f9060rg = false;
        }
        this.f9059fe.onTouchEvent(motionEvent);
        if (this.f9060rg) {
            f9058yj.de("Notifying a gesture of type", de().name());
        }
        return this.f9060rg;
    }
}
