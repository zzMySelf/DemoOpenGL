package fe.vvv.qw.ddd;

import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.net.MailTo;
import com.baidu.wallet.utils.compress.e;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.internal.DeviceEncoders;
import com.otaliastudios.cameraview.video.VideoRecorder;
import fe.vvv.qw.rg;
import java.io.File;
import java.io.FileDescriptor;

public abstract class ad extends VideoRecorder {

    /* renamed from: o  reason: collision with root package name */
    public static final CameraLogger f8875o = CameraLogger.qw(ad.class.getSimpleName());

    /* renamed from: i  reason: collision with root package name */
    public boolean f8876i;

    /* renamed from: uk  reason: collision with root package name */
    public CamcorderProfile f8877uk;

    /* renamed from: yj  reason: collision with root package name */
    public MediaRecorder f8878yj;

    /* renamed from: fe.vvv.qw.ddd.ad$ad  reason: collision with other inner class name */
    public class C0306ad implements MediaRecorder.OnErrorListener {
        public C0306ad() {
        }

        public void onError(MediaRecorder mediaRecorder, int i2, int i3) {
            ad.f8875o.ad("OnErrorListener: got error", Integer.valueOf(i2), Integer.valueOf(i3), ". Stopping.");
            ad adVar = ad.this;
            adVar.qw = null;
            adVar.f6785de = new RuntimeException("MediaRecorder error: " + i2 + " " + i3);
            ad.f8875o.de("OnErrorListener:", "Stopping");
            ad.this.ppp(false);
        }
    }

    public class qw implements MediaRecorder.OnInfoListener {
        public qw() {
        }

        public void onInfo(MediaRecorder mediaRecorder, int i2, int i3) {
            boolean z;
            ad.f8875o.de("OnInfoListener:", "Received info", Integer.valueOf(i2), Integer.valueOf(i3), "Thread: ", Thread.currentThread());
            switch (i2) {
                case 800:
                    ad.this.qw.f391switch = 2;
                    break;
                case 801:
                case 802:
                    ad.this.qw.f391switch = 1;
                    break;
                default:
                    z = false;
                    break;
            }
            z = true;
            if (z) {
                ad.f8875o.de("OnInfoListener:", "Stopping");
                ad.this.ppp(false);
            }
        }
    }

    public ad(@Nullable VideoRecorder.VideoResultListener videoResultListener) {
        super(videoResultListener);
    }

    public final boolean ddd(@NonNull rg.qw qwVar, boolean z) {
        int i2;
        rg.qw qwVar2 = qwVar;
        char c = 2;
        f8875o.de("prepareMediaRecorder:", "Preparing on thread", Thread.currentThread());
        this.f8878yj = new MediaRecorder();
        this.f8877uk = vvv(qwVar);
        ggg(qwVar2, this.f8878yj);
        Audio audio = qwVar2.f9081o;
        if (audio == Audio.ON) {
            i2 = this.f8877uk.audioChannels;
        } else if (audio == Audio.MONO) {
            i2 = 1;
        } else {
            i2 = audio == Audio.STEREO ? 2 : 0;
        }
        boolean z2 = i2 > 0;
        if (z2) {
            this.f8878yj.setAudioSource(0);
        }
        VideoCodec videoCodec = qwVar2.f9085uk;
        if (videoCodec == VideoCodec.H_264) {
            CamcorderProfile camcorderProfile = this.f8877uk;
            camcorderProfile.videoCodec = 2;
            camcorderProfile.fileFormat = 2;
        } else if (videoCodec == VideoCodec.H_263) {
            CamcorderProfile camcorderProfile2 = this.f8877uk;
            camcorderProfile2.videoCodec = 1;
            camcorderProfile2.fileFormat = 2;
        }
        AudioCodec audioCodec = qwVar2.f9080i;
        char c2 = 4;
        if (audioCodec == AudioCodec.AAC) {
            this.f8877uk.audioCodec = 3;
        } else if (Build.VERSION.SDK_INT >= 16 && audioCodec == AudioCodec.HE_AAC) {
            this.f8877uk.audioCodec = 4;
        } else if (Build.VERSION.SDK_INT >= 16 && qwVar2.f9080i == AudioCodec.AAC_ELD) {
            this.f8877uk.audioCodec = 5;
        }
        this.f8878yj.setOutputFormat(this.f8877uk.fileFormat);
        if (qwVar2.ppp <= 0) {
            qwVar2.ppp = this.f8877uk.videoFrameRate;
        }
        if (qwVar2.when <= 0) {
            qwVar2.when = this.f8877uk.videoBitRate;
        }
        if (qwVar2.ggg <= 0 && z2) {
            qwVar2.ggg = this.f8877uk.audioBitRate;
        }
        if (z) {
            String str = "audio/3gpp";
            switch (this.f8877uk.audioCodec) {
                case 2:
                    str = "audio/amr-wb";
                    break;
                case 3:
                case 4:
                case 5:
                    str = "audio/mp4a-latm";
                    break;
                case 6:
                    str = "audio/vorbis";
                    break;
            }
            int i3 = this.f8877uk.videoCodec;
            String str2 = e.b;
            if (i3 == 1) {
                str2 = "video/3gpp";
            } else if (i3 != 2) {
                if (i3 == 3) {
                    str2 = "video/mp4v-es";
                } else if (i3 == 4) {
                    str2 = "video/x-vnd.on2.vp8";
                } else if (i3 == 5) {
                    str2 = "video/hevc";
                }
            }
            String str3 = str2;
            boolean z3 = qwVar2.f9078de % 180 != 0;
            if (z3) {
                qwVar2.f9079fe = qwVar2.f9079fe.ad();
            }
            int i4 = 0;
            fe.vvv.qw.xxx.ad adVar = null;
            boolean z4 = false;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (!z4) {
                CameraLogger cameraLogger = f8875o;
                Object[] objArr = new Object[6];
                objArr[0] = "prepareMediaRecorder:";
                objArr[1] = "Checking DeviceEncoders...";
                objArr[c] = "videoOffset:";
                objArr[3] = Integer.valueOf(i7);
                objArr[c2] = "audioOffset:";
                objArr[5] = Integer.valueOf(i8);
                cameraLogger.de(objArr);
                try {
                    fe.vvv.qw.xxx.ad adVar2 = adVar;
                    String str4 = str3;
                    DeviceEncoders deviceEncoders = new DeviceEncoders(0, str4, str, i7, i8);
                    try {
                        adVar = deviceEncoders.yj(qwVar2.f9079fe);
                        try {
                            i4 = deviceEncoders.rg(qwVar2.when);
                            int th2 = deviceEncoders.th(adVar, qwVar2.ppp);
                            str3 = str4;
                            try {
                                deviceEncoders.pf(str3, adVar, th2, i4);
                                if (z2) {
                                    int fe2 = deviceEncoders.fe(qwVar2.ggg);
                                    try {
                                        deviceEncoders.o(str, fe2, this.f8877uk.audioSampleRate, i2);
                                        i5 = fe2;
                                    } catch (DeviceEncoders.VideoException e) {
                                        e = e;
                                        i6 = th2;
                                        i5 = fe2;
                                        f8875o.de("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                                        i7++;
                                        c = 2;
                                        c2 = 4;
                                    } catch (DeviceEncoders.AudioException e2) {
                                        e = e2;
                                        i6 = th2;
                                        i5 = fe2;
                                        f8875o.de("prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                                        i8++;
                                        c = 2;
                                        c2 = 4;
                                    }
                                }
                                i6 = th2;
                                z4 = true;
                            } catch (DeviceEncoders.VideoException e3) {
                                e = e3;
                                i6 = th2;
                                f8875o.de("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                                i7++;
                                c = 2;
                                c2 = 4;
                            } catch (DeviceEncoders.AudioException e4) {
                                e = e4;
                                i6 = th2;
                                f8875o.de("prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                                i8++;
                                c = 2;
                                c2 = 4;
                            }
                        } catch (DeviceEncoders.VideoException e5) {
                            e = e5;
                            str3 = str4;
                            f8875o.de("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                            i7++;
                            c = 2;
                            c2 = 4;
                        } catch (DeviceEncoders.AudioException e6) {
                            e = e6;
                            str3 = str4;
                            f8875o.de("prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                            i8++;
                            c = 2;
                            c2 = 4;
                        }
                    } catch (DeviceEncoders.VideoException e7) {
                        e = e7;
                        str3 = str4;
                        adVar = adVar2;
                        f8875o.de("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                        i7++;
                        c = 2;
                        c2 = 4;
                    } catch (DeviceEncoders.AudioException e8) {
                        e = e8;
                        str3 = str4;
                        adVar = adVar2;
                        f8875o.de("prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                        i8++;
                        c = 2;
                        c2 = 4;
                    }
                    c = 2;
                    c2 = 4;
                } catch (RuntimeException unused) {
                    f8875o.i("prepareMediaRecorder:", "Could not respect encoders parameters.", "Trying again without checking encoders.");
                    return ddd(qwVar2, false);
                }
            }
            fe.vvv.qw.xxx.ad adVar3 = adVar;
            qwVar2.f9079fe = adVar3;
            qwVar2.when = i4;
            qwVar2.ggg = i5;
            qwVar2.ppp = i6;
            if (z3) {
                qwVar2.f9079fe = adVar3.ad();
            }
        }
        boolean z5 = qwVar2.f9078de % 180 != 0;
        MediaRecorder mediaRecorder = this.f8878yj;
        fe.vvv.qw.xxx.ad adVar4 = qwVar2.f9079fe;
        mediaRecorder.setVideoSize(z5 ? adVar4.fe() : adVar4.rg(), z5 ? qwVar2.f9079fe.rg() : qwVar2.f9079fe.fe());
        this.f8878yj.setVideoFrameRate(qwVar2.ppp);
        this.f8878yj.setVideoEncoder(this.f8877uk.videoCodec);
        this.f8878yj.setVideoEncodingBitRate(qwVar2.when);
        if (z2) {
            this.f8878yj.setAudioChannels(i2);
            this.f8878yj.setAudioSamplingRate(this.f8877uk.audioSampleRate);
            this.f8878yj.setAudioEncoder(this.f8877uk.audioCodec);
            this.f8878yj.setAudioEncodingBitRate(qwVar2.ggg);
        }
        Location location = qwVar2.f9077ad;
        if (location != null) {
            this.f8878yj.setLocation((float) location.getLatitude(), (float) qwVar2.f9077ad.getLongitude());
        }
        File file = qwVar2.f9083rg;
        if (file != null) {
            this.f8878yj.setOutputFile(file.getAbsolutePath());
        } else {
            FileDescriptor fileDescriptor = qwVar2.f9084th;
            if (fileDescriptor != null) {
                this.f8878yj.setOutputFile(fileDescriptor);
            } else {
                throw new IllegalStateException("file and fileDescriptor are both null.");
            }
        }
        this.f8878yj.setOrientationHint(qwVar2.f9078de);
        MediaRecorder mediaRecorder2 = this.f8878yj;
        long j = qwVar2.f9082pf;
        if (j > 0) {
            j = Math.round(((double) j) / 0.9d);
        }
        mediaRecorder2.setMaxFileSize(j);
        f8875o.de("prepareMediaRecorder:", "Increased max size from", Long.valueOf(qwVar2.f9082pf), MailTo.TO, Long.valueOf(Math.round(((double) qwVar2.f9082pf) / 0.9d)));
        this.f8878yj.setMaxDuration(qwVar2.f390if);
        this.f8878yj.setOnInfoListener(new qw());
        this.f8878yj.setOnErrorListener(new C0306ad());
        try {
            this.f8878yj.prepare();
            this.f8876i = true;
            this.f6785de = null;
            return true;
        } catch (Exception e9) {
            f8875o.i("prepareMediaRecorder:", "Error while preparing media recorder.", e9);
            this.f8876i = false;
            this.f6785de = e9;
            return false;
        }
    }

    public abstract void ggg(@NonNull rg.qw qwVar, @NonNull MediaRecorder mediaRecorder);

    /* renamed from: if  reason: not valid java name */
    public void m1026if() {
        if (!xxx(this.qw)) {
            this.qw = null;
            ppp(false);
            return;
        }
        try {
            this.f8878yj.start();
            i();
        } catch (Exception e) {
            f8875o.i("start:", "Error while starting media recorder.", e);
            this.qw = null;
            this.f6785de = e;
            ppp(false);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1027switch(boolean z) {
        if (this.f8878yj != null) {
            uk();
            try {
                f8875o.de("stop:", "Stopping MediaRecorder...");
                this.f8878yj.stop();
                f8875o.de("stop:", "Stopped MediaRecorder.");
            } catch (Exception e) {
                this.qw = null;
                if (this.f6785de == null) {
                    f8875o.i("stop:", "Error while closing media recorder.", e);
                    this.f6785de = e;
                }
            }
            try {
                f8875o.de("stop:", "Releasing MediaRecorder...");
                this.f8878yj.release();
                f8875o.de("stop:", "Released MediaRecorder.");
            } catch (Exception e2) {
                this.qw = null;
                if (this.f6785de == null) {
                    f8875o.i("stop:", "Error while releasing media recorder.", e2);
                    this.f6785de = e2;
                }
            }
        }
        this.f8877uk = null;
        this.f8878yj = null;
        this.f8876i = false;
        yj();
    }

    @NonNull
    public abstract CamcorderProfile vvv(@NonNull rg.qw qwVar);

    public final boolean xxx(@NonNull rg.qw qwVar) {
        if (this.f8876i) {
            return true;
        }
        return ddd(qwVar, true);
    }
}
