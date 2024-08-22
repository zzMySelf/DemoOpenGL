package fe.vvv.qw.pf;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureFinder;

public class fe extends GestureFinder {

    /* renamed from: fe  reason: collision with root package name */
    public GestureDetector f9064fe;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9065rg;

    public class qw extends GestureDetector.SimpleOnGestureListener {
        public qw() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            boolean unused = fe.this.f9065rg = true;
            fe.this.o(Gesture.LONG_TAP);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean unused = fe.this.f9065rg = true;
            fe.this.o(Gesture.TAP);
            return true;
        }
    }

    public fe(@NonNull GestureFinder.Controller controller) {
        super(controller, 1);
        GestureDetector gestureDetector = new GestureDetector(controller.getContext(), new qw());
        this.f9064fe = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    public float th(float f, float f2, float f3) {
        return 0.0f;
    }

    public boolean yj(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f9065rg = false;
        }
        this.f9064fe.onTouchEvent(motionEvent);
        if (!this.f9065rg) {
            return false;
        }
        fe(0).x = motionEvent.getX();
        fe(0).y = motionEvent.getY();
        return true;
    }
}
