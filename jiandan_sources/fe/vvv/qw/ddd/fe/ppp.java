package fe.vvv.qw.ddd.fe;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import fe.vvv.qw.ddd.fe.when;
import java.io.IOException;

@RequiresApi(api = 18)
public abstract class ppp<C extends when> extends i {
    public static final CameraLogger aaa = CameraLogger.qw(ppp.class.getSimpleName());
    public Surface ddd;
    public boolean mmm = false;
    public int nn = -1;
    public C xxx;

    public ppp(@NonNull C c) {
        super("VideoEncoder");
        this.xxx = c;
    }

    public boolean a(long j) {
        if (j == 0 || this.nn < 0 || pf()) {
            return false;
        }
        this.nn++;
        return true;
    }

    public void ddd() {
        aaa.de("onStop", "setting mFrameNumber to 1 and signaling the end of input stream.");
        this.nn = -1;
        this.f8897de.signalEndOfInputStream();
        th(true);
    }

    public void mmm(@NonNull pf pfVar, @NonNull o oVar) {
        if (!this.mmm) {
            aaa.i("onWriteOutput:", "sync frame not found yet. Checking.");
            if ((oVar.qw.flags & 1) == 1) {
                aaa.i("onWriteOutput:", "SYNC FRAME FOUND!");
                this.mmm = true;
                super.mmm(pfVar, oVar);
                return;
            }
            aaa.i("onWriteOutput:", "DROPPING FRAME and requesting a sync frame soon.");
            if (Build.VERSION.SDK_INT >= 19) {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.f8897de.setParameters(bundle);
            }
            pfVar.th(oVar);
            return;
        }
        super.mmm(pfVar, oVar);
    }

    public int uk() {
        return this.xxx.f8936de;
    }

    public void vvv(@NonNull MediaEncoderEngine.qw qwVar, long j) {
        C c = this.xxx;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(c.f8939th, c.qw, c.f8935ad);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.xxx.f8936de);
        createVideoFormat.setInteger("frame-rate", this.xxx.f8937fe);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("rotation-degrees", this.xxx.f8938rg);
        try {
            if (this.xxx.f8940yj != null) {
                this.f8897de = MediaCodec.createByCodecName(this.xxx.f8940yj);
            } else {
                this.f8897de = MediaCodec.createEncoderByType(this.xxx.f8939th);
            }
            this.f8897de.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.ddd = this.f8897de.createInputSurface();
            this.f8897de.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void xxx() {
        this.nn = 0;
    }
}
