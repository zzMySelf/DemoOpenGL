package fe.vvv.qw.vvv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.aiscan.R;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.preview.CameraPreview;

public class ad extends CameraPreview<SurfaceView, SurfaceHolder> {

    /* renamed from: switch  reason: not valid java name */
    public static final CameraLogger f393switch = CameraLogger.qw(ad.class.getSimpleName());

    /* renamed from: if  reason: not valid java name */
    public View f394if;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f9105pf;

    public class qw implements SurfaceHolder.Callback {
        public qw() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ad.f393switch.de("callback:", "surfaceChanged", "w:", Integer.valueOf(i3), "h:", Integer.valueOf(i4), "dispatched:", Boolean.valueOf(ad.this.f9105pf));
            if (!ad.this.f9105pf) {
                ad.this.th(i3, i4);
                boolean unused = ad.this.f9105pf = true;
                return;
            }
            ad.this.uk(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ad.f393switch.de("callback:", "surfaceDestroyed");
            ad.this.yj();
            boolean unused = ad.this.f9105pf = false;
        }
    }

    public ad(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @NonNull
    /* renamed from: b */
    public SurfaceHolder i() {
        return ((SurfaceView) m717switch()).getHolder();
    }

    @NonNull
    /* renamed from: c */
    public SurfaceView ggg(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        SurfaceView surfaceView = (SurfaceView) inflate.findViewById(R.id.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new qw());
        this.f394if = inflate;
        return surfaceView;
    }

    @NonNull
    public Class<SurfaceHolder> o() {
        return SurfaceHolder.class;
    }

    @NonNull
    public View pf() {
        return this.f394if;
    }
}
