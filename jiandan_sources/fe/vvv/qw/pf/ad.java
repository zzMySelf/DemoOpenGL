package fe.vvv.qw.pf;

import android.os.Build;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureFinder;

public class ad extends GestureFinder {

    /* renamed from: fe  reason: collision with root package name */
    public ScaleGestureDetector f9054fe;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f9055rg;

    /* renamed from: th  reason: collision with root package name */
    public float f9056th = 0.0f;

    public class qw extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public qw() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            boolean unused = ad.this.f9055rg = true;
            float unused2 = ad.this.f9056th = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public ad(@NonNull GestureFinder.Controller controller) {
        super(controller, 2);
        o(Gesture.PINCH);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(controller.getContext(), new qw());
        this.f9054fe = scaleGestureDetector;
        if (Build.VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(false);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public float m1036switch() {
        return this.f9056th;
    }

    public float th(float f, float f2, float f3) {
        return f + (m1036switch() * (f3 - f2));
    }

    public boolean yj(@NonNull MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            this.f9055rg = false;
        }
        this.f9054fe.onTouchEvent(motionEvent);
        if (this.f9055rg) {
            fe(0).x = motionEvent.getX(0);
            fe(0).y = motionEvent.getY(0);
            z = true;
            if (motionEvent.getPointerCount() > 1) {
                fe(1).x = motionEvent.getX(1);
                fe(1).y = motionEvent.getY(1);
            }
        }
        return z;
    }
}
