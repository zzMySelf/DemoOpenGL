package fe.vvv.qw.ddd.fe;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.internal.Pool;

@RequiresApi(18)
public class pf extends Pool<o> {

    public class qw implements Pool.Factory<o> {
        public final /* synthetic */ int qw;

        public qw(int i2) {
            this.qw = i2;
        }

        /* renamed from: ad */
        public o qw() {
            o oVar = new o();
            oVar.f8919ad = this.qw;
            oVar.qw = new MediaCodec.BufferInfo();
            return oVar;
        }
    }

    public pf(int i2) {
        super(Integer.MAX_VALUE, new qw(i2));
    }
}
