package fe.vvv.qw.ddd;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.wallet.utils.compress.e;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.DeviceEncoders;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.preview.RendererFrameCallback;
import com.otaliastudios.cameraview.video.VideoRecorder;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import fe.vvv.qw.ddd.fe.Cif;
import fe.vvv.qw.ddd.fe.Cswitch;
import fe.vvv.qw.rg;
import fe.vvv.qw.xxx.ad;

@RequiresApi(api = 18)
public class de extends VideoRecorder implements RendererFrameCallback, MediaEncoderEngine.Listener {
    public static final CameraLogger vvv = CameraLogger.qw(de.class.getSimpleName());
    public Filter ggg;

    /* renamed from: i  reason: collision with root package name */
    public RendererCameraPreview f8879i;

    /* renamed from: if  reason: not valid java name */
    public int f363if;

    /* renamed from: o  reason: collision with root package name */
    public int f8880o;

    /* renamed from: pf  reason: collision with root package name */
    public int f8881pf;
    public boolean ppp;

    /* renamed from: switch  reason: not valid java name */
    public Overlay f364switch;

    /* renamed from: uk  reason: collision with root package name */
    public final Object f8882uk = new Object();
    public fe.vvv.qw.ppp.qw when;

    /* renamed from: yj  reason: collision with root package name */
    public MediaEncoderEngine f8883yj;

    public static /* synthetic */ class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f8884ad;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                com.otaliastudios.cameraview.controls.AudioCodec[] r0 = com.otaliastudios.cameraview.controls.AudioCodec.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8884ad = r0
                r1 = 1
                com.otaliastudios.cameraview.controls.AudioCodec r2 = com.otaliastudios.cameraview.controls.AudioCodec.AAC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8884ad     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.controls.AudioCodec r3 = com.otaliastudios.cameraview.controls.AudioCodec.HE_AAC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8884ad     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.otaliastudios.cameraview.controls.AudioCodec r4 = com.otaliastudios.cameraview.controls.AudioCodec.AAC_ELD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f8884ad     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.otaliastudios.cameraview.controls.AudioCodec r4 = com.otaliastudios.cameraview.controls.AudioCodec.DEVICE_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.otaliastudios.cameraview.controls.VideoCodec[] r3 = com.otaliastudios.cameraview.controls.VideoCodec.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                qw = r3
                com.otaliastudios.cameraview.controls.VideoCodec r4 = com.otaliastudios.cameraview.controls.VideoCodec.H_263     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x004e }
                com.otaliastudios.cameraview.controls.VideoCodec r3 = com.otaliastudios.cameraview.controls.VideoCodec.H_264     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.otaliastudios.cameraview.controls.VideoCodec r1 = com.otaliastudios.cameraview.controls.VideoCodec.DEVICE_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.vvv.qw.ddd.de.qw.<clinit>():void");
        }
    }

    public de(@NonNull CameraEngine cameraEngine, @NonNull RendererCameraPreview rendererCameraPreview, @Nullable Overlay overlay) {
        super(cameraEngine);
        boolean z = true;
        this.f8880o = 1;
        this.f8881pf = 1;
        this.f363if = 0;
        this.f8879i = rendererCameraPreview;
        this.f364switch = overlay;
        this.ppp = (overlay == null || !overlay.drawsOn(Overlay.Target.VIDEO_SNAPSHOT)) ? false : z;
    }

    public static int ggg(@NonNull ad adVar, int i2) {
        return (int) (((float) adVar.rg()) * 0.07f * ((float) adVar.fe()) * ((float) i2));
    }

    public void ad() {
    }

    public void de(int i2, @Nullable Exception exc) {
        if (exc != null) {
            vvv.ad("Error onEncodingEnd", exc);
            this.qw = null;
            this.f6785de = exc;
        } else if (i2 == 1) {
            vvv.de("onEncodingEnd because of max duration.");
            this.qw.f391switch = 2;
        } else if (i2 == 2) {
            vvv.de("onEncodingEnd because of max size.");
            this.qw.f391switch = 1;
        } else {
            vvv.de("onEncodingEnd because of user.");
        }
        this.f8880o = 1;
        this.f8881pf = 1;
        this.f8879i.fe(this);
        this.f8879i = null;
        fe.vvv.qw.ppp.qw qwVar = this.when;
        if (qwVar != null) {
            qwVar.de();
            this.when = null;
        }
        synchronized (this.f8882uk) {
            this.f8883yj = null;
        }
        yj();
    }

    public void fe(int i2) {
        this.f363if = i2;
        if (this.ppp) {
            this.when = new fe.vvv.qw.ppp.qw(this.f364switch, this.qw.f9079fe);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m1028if() {
        this.f8879i.qw(this);
        this.f8881pf = 0;
        i();
    }

    public void qw(@NonNull SurfaceTexture surfaceTexture, int i2, float f, float f2) {
        int i3;
        ad adVar;
        int i4;
        int i5;
        int i6;
        fe.vvv.qw.ddd.fe.ad adVar2;
        if (this.f8880o == 1 && this.f8881pf == 0) {
            vvv.de("Starting the encoder engine.");
            rg.qw qwVar = this.qw;
            if (qwVar.ppp <= 0) {
                qwVar.ppp = 30;
            }
            rg.qw qwVar2 = this.qw;
            if (qwVar2.when <= 0) {
                qwVar2.when = ggg(qwVar2.f9079fe, qwVar2.ppp);
            }
            rg.qw qwVar3 = this.qw;
            if (qwVar3.ggg <= 0) {
                qwVar3.ggg = 64000;
            }
            String str = "";
            int i7 = qw.qw[this.qw.f9085uk.ordinal()];
            char c = 3;
            if (i7 == 1) {
                str = "video/3gpp";
            } else if (i7 == 2) {
                str = e.b;
            } else if (i7 == 3) {
                str = e.b;
            }
            String str2 = str;
            String str3 = "";
            int i8 = qw.f8884ad[this.qw.f9080i.ordinal()];
            char c2 = 4;
            if (i8 == 1 || i8 == 2 || i8 == 3) {
                str3 = "audio/mp4a-latm";
            } else if (i8 == 4) {
                str3 = "audio/mp4a-latm";
            }
            String str4 = str3;
            Cif ifVar = new Cif();
            fe.vvv.qw.ddd.fe.qw qwVar4 = new fe.vvv.qw.ddd.fe.qw();
            Audio audio = this.qw.f9081o;
            if (audio == Audio.ON) {
                i3 = qwVar4.f8921ad;
            } else if (audio == Audio.MONO) {
                i3 = 1;
            } else {
                i3 = audio == Audio.STEREO ? 2 : 0;
            }
            boolean z = i3 > 0;
            DeviceEncoders deviceEncoders = null;
            ad adVar3 = null;
            boolean z2 = false;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (!z2) {
                CameraLogger cameraLogger = vvv;
                Object[] objArr = new Object[5];
                objArr[0] = "Checking DeviceEncoders...";
                objArr[1] = "videoOffset:";
                objArr[2] = Integer.valueOf(i9);
                objArr[c] = "audioOffset:";
                objArr[c2] = Integer.valueOf(i10);
                cameraLogger.de(objArr);
                try {
                    new DeviceEncoders(0, str2, str4, i9, i10);
                    DeviceEncoders deviceEncoders2 = r13;
                    DeviceEncoders deviceEncoders3 = new DeviceEncoders(1, str2, str4, i9, i10);
                    try {
                        ad yj2 = deviceEncoders2.yj(this.qw.f9079fe);
                        try {
                            int rg2 = deviceEncoders2.rg(this.qw.when);
                            try {
                                int th2 = deviceEncoders2.th(yj2, this.qw.ppp);
                                try {
                                    deviceEncoders2.pf(str2, yj2, th2, rg2);
                                    if (z) {
                                        int fe2 = deviceEncoders2.fe(this.qw.ggg);
                                        try {
                                            deviceEncoders2.o(str4, fe2, qwVar4.f8924rg, i3);
                                            i12 = fe2;
                                        } catch (DeviceEncoders.VideoException e) {
                                            e = e;
                                            i12 = fe2;
                                            adVar3 = yj2;
                                            i11 = rg2;
                                            i13 = th2;
                                            vvv.de("Got VideoException:", e.getMessage());
                                            i9++;
                                            deviceEncoders = deviceEncoders2;
                                            c = 3;
                                            c2 = 4;
                                        } catch (DeviceEncoders.AudioException e2) {
                                            e = e2;
                                            i12 = fe2;
                                            adVar3 = yj2;
                                            i11 = rg2;
                                            i13 = th2;
                                            vvv.de("Got AudioException:", e.getMessage());
                                            i10++;
                                            deviceEncoders = deviceEncoders2;
                                            c = 3;
                                            c2 = 4;
                                        }
                                    }
                                    deviceEncoders = deviceEncoders2;
                                    adVar3 = yj2;
                                    i11 = rg2;
                                    i13 = th2;
                                    c = 3;
                                    c2 = 4;
                                    z2 = true;
                                } catch (DeviceEncoders.VideoException e3) {
                                    e = e3;
                                    adVar3 = yj2;
                                    i11 = rg2;
                                    i13 = th2;
                                    vvv.de("Got VideoException:", e.getMessage());
                                    i9++;
                                    deviceEncoders = deviceEncoders2;
                                    c = 3;
                                    c2 = 4;
                                } catch (DeviceEncoders.AudioException e4) {
                                    e = e4;
                                    adVar3 = yj2;
                                    i11 = rg2;
                                    i13 = th2;
                                    vvv.de("Got AudioException:", e.getMessage());
                                    i10++;
                                    deviceEncoders = deviceEncoders2;
                                    c = 3;
                                    c2 = 4;
                                }
                            } catch (DeviceEncoders.VideoException e5) {
                                e = e5;
                                adVar3 = yj2;
                                i11 = rg2;
                                vvv.de("Got VideoException:", e.getMessage());
                                i9++;
                                deviceEncoders = deviceEncoders2;
                                c = 3;
                                c2 = 4;
                            } catch (DeviceEncoders.AudioException e6) {
                                e = e6;
                                adVar3 = yj2;
                                i11 = rg2;
                                vvv.de("Got AudioException:", e.getMessage());
                                i10++;
                                deviceEncoders = deviceEncoders2;
                                c = 3;
                                c2 = 4;
                            }
                        } catch (DeviceEncoders.VideoException e7) {
                            e = e7;
                            adVar3 = yj2;
                            vvv.de("Got VideoException:", e.getMessage());
                            i9++;
                            deviceEncoders = deviceEncoders2;
                            c = 3;
                            c2 = 4;
                        } catch (DeviceEncoders.AudioException e8) {
                            e = e8;
                            adVar3 = yj2;
                            vvv.de("Got AudioException:", e.getMessage());
                            i10++;
                            deviceEncoders = deviceEncoders2;
                            c = 3;
                            c2 = 4;
                        }
                    } catch (DeviceEncoders.VideoException e9) {
                        e = e9;
                        vvv.de("Got VideoException:", e.getMessage());
                        i9++;
                        deviceEncoders = deviceEncoders2;
                        c = 3;
                        c2 = 4;
                    } catch (DeviceEncoders.AudioException e10) {
                        e = e10;
                        vvv.de("Got AudioException:", e.getMessage());
                        i10++;
                        deviceEncoders = deviceEncoders2;
                        c = 3;
                        c2 = 4;
                    }
                } catch (RuntimeException unused) {
                    vvv.i("Could not respect encoders parameters.", "Going on again without checking encoders, possibly failing.");
                    rg.qw qwVar5 = this.qw;
                    adVar = qwVar5.f9079fe;
                    i4 = qwVar5.when;
                    i6 = qwVar5.ppp;
                    i5 = qwVar5.ggg;
                }
            }
            adVar = adVar3;
            i4 = i11;
            i5 = i12;
            i6 = i13;
            rg.qw qwVar6 = this.qw;
            qwVar6.f9079fe = adVar;
            qwVar6.when = i4;
            qwVar6.ggg = i5;
            qwVar6.ppp = i6;
            ifVar.qw = adVar.rg();
            ifVar.f8935ad = this.qw.f9079fe.fe();
            rg.qw qwVar7 = this.qw;
            ifVar.f8936de = qwVar7.when;
            ifVar.f8937fe = qwVar7.ppp;
            ifVar.f8938rg = i2 + qwVar7.f9078de;
            ifVar.f8939th = str2;
            ifVar.f8940yj = deviceEncoders.uk();
            ifVar.f8918uk = this.f363if;
            ifVar.f367if = f;
            ifVar.f368switch = f2;
            ifVar.when = EGL14.eglGetCurrentContext();
            if (this.ppp) {
                ifVar.f8915i = Overlay.Target.VIDEO_SNAPSHOT;
                ifVar.f8916o = this.when;
                ifVar.f8917pf = this.qw.f9078de;
            }
            Cswitch switchR = new Cswitch(ifVar);
            rg.qw qwVar8 = this.qw;
            qwVar8.f9078de = 0;
            this.ggg.yj(qwVar8.f9079fe.rg(), this.qw.f9079fe.rg());
            if (z) {
                qwVar4.qw = this.qw.ggg;
                qwVar4.f8921ad = i3;
                qwVar4.f8922de = deviceEncoders.ad();
                adVar2 = new fe.vvv.qw.ddd.fe.ad(qwVar4);
            } else {
                adVar2 = null;
            }
            synchronized (this.f8882uk) {
                MediaEncoderEngine mediaEncoderEngine = new MediaEncoderEngine(this.qw.f9083rg, switchR, adVar2, this.qw.f390if, this.qw.f9082pf, this);
                this.f8883yj = mediaEncoderEngine;
                mediaEncoderEngine.vvv("filter", this.ggg);
                this.f8883yj.xxx();
            }
            this.f8880o = 0;
        }
        if (this.f8880o == 0) {
            vvv.de("scheduling frame.");
            synchronized (this.f8882uk) {
                if (this.f8883yj != null) {
                    vvv.de("dispatching frame.");
                    Cswitch.ad b = ((Cswitch) this.f8883yj.ggg()).b();
                    b.qw = surfaceTexture.getTimestamp();
                    b.f8926ad = System.currentTimeMillis();
                    surfaceTexture.getTransformMatrix(b.f8927de);
                    this.f8883yj.vvv("frame", b);
                }
            }
        }
        if (this.f8880o == 0 && this.f8881pf == 1) {
            vvv.de("Stopping the encoder engine.");
            this.f8880o = 1;
            synchronized (this.f8882uk) {
                if (this.f8883yj != null) {
                    this.f8883yj.ddd();
                    this.f8883yj = null;
                }
            }
        }
    }

    public void rg() {
        uk();
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1029switch(boolean z) {
        if (z) {
            vvv.de("Stopping the encoder engine from isCameraShutdown.");
            this.f8881pf = 1;
            this.f8880o = 1;
            synchronized (this.f8882uk) {
                if (this.f8883yj != null) {
                    this.f8883yj.ddd();
                    this.f8883yj = null;
                }
            }
            return;
        }
        this.f8881pf = 1;
    }

    public void th(@NonNull Filter filter) {
        Filter qw2 = filter.qw();
        this.ggg = qw2;
        qw2.yj(this.qw.f9079fe.rg(), this.qw.f9079fe.fe());
        synchronized (this.f8882uk) {
            if (this.f8883yj != null) {
                this.f8883yj.vvv("filter", this.ggg);
            }
        }
    }
}
