package fe.vvv.qw.ggg;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.fe;
import fe.vvv.qw.p037if.yj;
import fe.vvv.qw.yj.fe.de;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(21)
public class ad extends de implements ImageReader.OnImageAvailableListener {

    /* renamed from: i  reason: collision with root package name */
    public final ActionHolder f8967i;

    /* renamed from: if  reason: not valid java name */
    public final CaptureRequest.Builder f371if;

    /* renamed from: o  reason: collision with root package name */
    public final Action f8968o = new qw();

    /* renamed from: pf  reason: collision with root package name */
    public final ImageReader f8969pf;

    /* renamed from: switch  reason: not valid java name */
    public DngCreator f372switch;

    /* renamed from: fe.vvv.qw.ggg.ad$ad  reason: collision with other inner class name */
    public static /* synthetic */ class C0309ad {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.otaliastudios.cameraview.controls.PictureFormat[] r0 = com.otaliastudios.cameraview.controls.PictureFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.controls.PictureFormat r1 = com.otaliastudios.cameraview.controls.PictureFormat.JPEG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.PictureFormat r1 = com.otaliastudios.cameraview.controls.PictureFormat.DNG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.ggg.ad.C0309ad.<clinit>():void");
        }
    }

    public class qw extends de {
        public qw() {
        }

        public void ad(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.ad(actionHolder, captureRequest, totalCaptureResult);
            ad adVar = ad.this;
            if (adVar.f6767ad.f8966yj == PictureFormat.DNG) {
                DngCreator unused = adVar.f372switch = new DngCreator(actionHolder.uk(this), totalCaptureResult);
                ad.this.f372switch.setOrientation(fe.vvv.qw.p037if.de.qw(ad.this.f6767ad.f8962de));
                ad adVar2 = ad.this;
                if (adVar2.f6767ad.f8961ad != null) {
                    adVar2.f372switch.setLocation(ad.this.f6767ad.f8961ad);
                }
            }
        }

        public void de(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            super.de(actionHolder, captureRequest);
            if (captureRequest.getTag() == 2) {
                de.f8971uk.de("onCaptureStarted:", "Dispatching picture shutter.");
                ad.this.qw(false);
                ppp(Integer.MAX_VALUE);
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public void m1032switch(@NonNull ActionHolder actionHolder) {
            super.m1047switch(actionHolder);
            ad.this.f371if.addTarget(ad.this.f8969pf.getSurface());
            ad adVar = ad.this;
            if (adVar.f6767ad.f8966yj == PictureFormat.JPEG) {
                adVar.f371if.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(ad.this.f6767ad.f8962de));
            }
            ad.this.f371if.setTag(2);
            try {
                actionHolder.o(this, ad.this.f371if);
            } catch (CameraAccessException e) {
                ad adVar2 = ad.this;
                adVar2.f6767ad = null;
                adVar2.f6769yj = e;
                adVar2.ad();
                ppp(Integer.MAX_VALUE);
            }
        }
    }

    public ad(@NonNull fe.qw qwVar, @NonNull fe.vvv.qw.yj.ad adVar, @NonNull CaptureRequest.Builder builder, @NonNull ImageReader imageReader) {
        super(qwVar, adVar);
        this.f8967i = adVar;
        this.f371if = builder;
        this.f8969pf = imageReader;
        imageReader.setOnImageAvailableListener(this, yj.de().th());
    }

    public void de() {
        this.f8968o.yj(this.f8967i);
    }

    public final void i(@NonNull Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.f372switch.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.f6767ad.f8965th = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.f372switch.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onImageAvailable(android.media.ImageReader r7) {
        /*
            r6 = this;
            com.otaliastudios.cameraview.CameraLogger r0 = fe.vvv.qw.ggg.de.f8971uk
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "onImageAvailable started."
            r4 = 0
            r2[r4] = r3
            r0.de(r2)
            r0 = 0
            android.media.Image r7 = r7.acquireNextImage()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            int[] r2 = fe.vvv.qw.ggg.ad.C0309ad.qw     // Catch:{ Exception -> 0x005b }
            fe.vvv.qw.fe$qw r3 = r6.f6767ad     // Catch:{ Exception -> 0x005b }
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.f8966yj     // Catch:{ Exception -> 0x005b }
            int r3 = r3.ordinal()     // Catch:{ Exception -> 0x005b }
            r2 = r2[r3]     // Catch:{ Exception -> 0x005b }
            if (r2 == r1) goto L_0x0042
            r3 = 2
            if (r2 != r3) goto L_0x0027
            r6.i(r7)     // Catch:{ Exception -> 0x005b }
            goto L_0x0045
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r2.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "Unknown format: "
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            fe.vvv.qw.fe$qw r3 = r6.f6767ad     // Catch:{ Exception -> 0x005b }
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.f8966yj     // Catch:{ Exception -> 0x005b }
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005b }
            throw r1     // Catch:{ Exception -> 0x005b }
        L_0x0042:
            r6.uk(r7)     // Catch:{ Exception -> 0x005b }
        L_0x0045:
            if (r7 == 0) goto L_0x004a
            r7.close()
        L_0x004a:
            com.otaliastudios.cameraview.CameraLogger r7 = fe.vvv.qw.ggg.de.f8971uk
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "onImageAvailable ended."
            r0[r4] = r1
            r7.de(r0)
            r6.ad()
            return
        L_0x0059:
            r0 = move-exception
            goto L_0x0071
        L_0x005b:
            r1 = move-exception
            goto L_0x0064
        L_0x005d:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x0071
        L_0x0062:
            r1 = move-exception
            r7 = r0
        L_0x0064:
            r6.f6767ad = r0     // Catch:{ all -> 0x0059 }
            r6.f6769yj = r1     // Catch:{ all -> 0x0059 }
            r6.ad()     // Catch:{ all -> 0x0059 }
            if (r7 == 0) goto L_0x0070
            r7.close()
        L_0x0070:
            return
        L_0x0071:
            if (r7 == 0) goto L_0x0076
            r7.close()
        L_0x0076:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.ggg.ad.onImageAvailable(android.media.ImageReader):void");
    }

    public final void uk(@NonNull Image image) {
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        fe.qw qwVar = this.f6767ad;
        qwVar.f8965th = bArr;
        qwVar.f8962de = 0;
        try {
            int attributeInt = new ExifInterface((InputStream) new ByteArrayInputStream(this.f6767ad.f8965th)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            this.f6767ad.f8962de = fe.vvv.qw.p037if.de.ad(attributeInt);
        } catch (IOException unused) {
        }
    }
}
