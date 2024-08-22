package fe.p036switch.qw.l;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Field;

/* renamed from: fe.switch.qw.l.de  reason: invalid package */
public class de {

    /* renamed from: ad  reason: collision with root package name */
    public FlutterTextureView f8818ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8819de = false;
    public SurfaceTexture qw;

    /* renamed from: fe.switch.qw.l.de$qw */
    public class qw implements TextureView.SurfaceTextureListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ TextureView.SurfaceTextureListener f8820ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ FlutterTextureView f8821th;

        public qw(TextureView.SurfaceTextureListener surfaceTextureListener, FlutterTextureView flutterTextureView) {
            this.f8820ad = surfaceTextureListener;
            this.f8821th = flutterTextureView;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f8820ad.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                Class<?> cls = this.f8821th.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.f8821th, Boolean.FALSE);
                cls.getDeclaredField("isAttachedToFlutterRenderer").setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean unused = de.this.f8819de = true;
            return false;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f8820ad.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            this.f8820ad.onSurfaceTextureUpdated(surfaceTexture);
            SurfaceTexture unused = de.this.qw = surfaceTexture;
        }
    }

    public void de(FlutterTextureView flutterTextureView) {
        if (Build.VERSION.SDK_INT <= 23 && flutterTextureView != null) {
            TextureView.SurfaceTextureListener surfaceTextureListener = flutterTextureView.getSurfaceTextureListener();
            this.f8818ad = flutterTextureView;
            flutterTextureView.setSurfaceTextureListener(new qw(surfaceTextureListener, flutterTextureView));
        }
    }

    public void fe() {
        if (Build.VERSION.SDK_INT <= 23) {
            if (ad.yj().fe() == 1) {
                FlutterBoost.yj().rg().getRenderer().stopRenderingToSurface();
            }
            SurfaceTexture surfaceTexture = this.qw;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.qw = null;
            }
        }
    }

    public void rg() {
        FlutterTextureView flutterTextureView;
        if (Build.VERSION.SDK_INT <= 23 && this.qw != null && (flutterTextureView = this.f8818ad) != null && this.f8819de) {
            try {
                Class<?> cls = flutterTextureView.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.f8818ad, Boolean.TRUE);
                Field declaredField2 = cls.getDeclaredField("isAttachedToFlutterRenderer");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(this.f8818ad)) {
                    FlutterEngine rg2 = FlutterBoost.yj().rg();
                    if (rg2 != null) {
                        rg2.getRenderer().startRenderingToSurface(new Surface(this.qw));
                        this.f8818ad.setSurfaceTexture(this.qw);
                    }
                    this.qw = null;
                    this.f8819de = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
