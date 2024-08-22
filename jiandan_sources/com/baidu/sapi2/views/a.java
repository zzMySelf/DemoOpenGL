package com.baidu.sapi2.views;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.sapi2.utils.Log;
import java.io.IOException;

public class a extends SurfaceView implements SurfaceHolder.Callback {
    public static final int f = 1001;
    public SurfaceHolder a;
    public Camera b;
    public b c;
    public Handler d = new C0041a();
    public Camera.PreviewCallback e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    public class C0041a extends Handler {
        public C0041a() {
        }

        public void handleMessage(Message message) {
            if (a.this.b != null && a.this.c != null) {
                a.this.c.a(a.this.d, 1001);
                a.this.b.autoFocus(a.this.c);
            }
        }
    }

    public static class b implements Camera.AutoFocusCallback {
        public static final String c = b.class.getSimpleName();
        public static final long d = 500;
        public Handler a;
        public int b;

        public void a(Handler handler, int i2) {
            this.a = handler;
            this.b = i2;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.a;
            if (handler != null) {
                this.a.sendMessageDelayed(handler.obtainMessage(this.b, Boolean.valueOf(z)), 500);
                this.a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.b = camera;
        SurfaceHolder holder = getHolder();
        this.a = holder;
        holder.addCallback(this);
        this.a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.e = previewCallback;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() != null) {
            try {
                this.b.stopPreview();
                this.b.setPreviewDisplay(this.a);
                if (this.e != null) {
                    this.b.setPreviewCallback(this.e);
                }
                this.b.startPreview();
                if (this.c == null) {
                    this.c = new b();
                }
                this.c.a(this.d, 1001);
                this.b.autoFocus(this.c);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("SurfaceView-callback", "surfaceCreated");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("SurfaceView-callback", "surfaceDestroyed");
        surfaceHolder.removeCallback(this);
    }

    public void a() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a((Handler) null, 0);
            this.c = null;
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.d = null;
        }
        this.a.removeCallback(this);
        this.a = null;
    }
}
