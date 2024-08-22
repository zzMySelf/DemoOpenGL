package fe.vvv.qw.vvv;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.preview.CameraPreview;
import java.util.concurrent.ExecutionException;

public class de extends CameraPreview<TextureView, SurfaceTexture> {

    /* renamed from: pf  reason: collision with root package name */
    public View f9107pf;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CameraPreview.CropCallback f9108ad;

        public ad(CameraPreview.CropCallback cropCallback) {
            this.f9108ad = cropCallback;
        }

        public void run() {
            int i2;
            int i3;
            float f;
            de deVar = de.this;
            if (deVar.f6777uk == 0 || deVar.f6778yj == 0 || (i2 = deVar.f6776th) == 0 || (i3 = deVar.f6775rg) == 0) {
                CameraPreview.CropCallback cropCallback = this.f9108ad;
                if (cropCallback != null) {
                    cropCallback.qw();
                    return;
                }
                return;
            }
            fe.vvv.qw.xxx.qw th2 = fe.vvv.qw.xxx.qw.th(i3, i2);
            de deVar2 = de.this;
            fe.vvv.qw.xxx.qw th3 = fe.vvv.qw.xxx.qw.th(deVar2.f6778yj, deVar2.f6777uk);
            float f2 = 1.0f;
            if (th2.o() >= th3.o()) {
                f = th2.o() / th3.o();
            } else {
                f2 = th3.o() / th2.o();
                f = 1.0f;
            }
            ((TextureView) de.this.m717switch()).setScaleX(f2);
            ((TextureView) de.this.m717switch()).setScaleY(f);
            de.this.f6773fe = f2 > 1.02f || f > 1.02f;
            CameraPreview.f6770o.de("crop:", "applied scaleX=", Float.valueOf(f2));
            CameraPreview.f6770o.de("crop:", "applied scaleY=", Float.valueOf(f));
            CameraPreview.CropCallback cropCallback2 = this.f9108ad;
            if (cropCallback2 != null) {
                cropCallback2.qw();
            }
        }
    }

    /* renamed from: fe.vvv.qw.vvv.de$de  reason: collision with other inner class name */
    public class C0313de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f9110ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f9111th;

        public C0313de(int i2, TaskCompletionSource taskCompletionSource) {
            this.f9110ad = i2;
            this.f9111th = taskCompletionSource;
        }

        public void run() {
            Matrix matrix = new Matrix();
            de deVar = de.this;
            float f = ((float) deVar.f6775rg) / 2.0f;
            float f2 = ((float) deVar.f6776th) / 2.0f;
            if (this.f9110ad % 180 != 0) {
                de deVar2 = de.this;
                float f3 = ((float) deVar2.f6776th) / ((float) deVar2.f6775rg);
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate((float) this.f9110ad, f, f2);
            ((TextureView) de.this.m717switch()).setTransform(matrix);
            this.f9111th.setResult(null);
        }
    }

    public class qw implements TextureView.SurfaceTextureListener {
        public qw() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            de.this.th(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            de.this.yj();
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            de.this.uk(i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public de(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public boolean eee() {
        return true;
    }

    public void mmm(int i2) {
        super.mmm(i2);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) m717switch()).post(new C0313de(i2, taskCompletionSource));
        try {
            Tasks.await(taskCompletionSource.getTask());
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @NonNull
    public Class<SurfaceTexture> o() {
        return SurfaceTexture.class;
    }

    @NonNull
    public View pf() {
        return this.f9107pf;
    }

    public void rg(@Nullable CameraPreview.CropCallback cropCallback) {
        ((TextureView) m717switch()).post(new ad(cropCallback));
    }

    @NonNull
    /* renamed from: rrr */
    public SurfaceTexture i() {
        return ((TextureView) m717switch()).getSurfaceTexture();
    }

    @NonNull
    /* renamed from: tt */
    public TextureView ggg(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(R.id.texture_view);
        textureView.setSurfaceTextureListener(new qw());
        this.f9107pf = inflate;
        return textureView;
    }
}
