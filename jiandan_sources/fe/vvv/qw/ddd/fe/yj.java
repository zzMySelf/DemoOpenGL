package fe.vvv.qw.ddd.fe;

import com.otaliastudios.cameraview.internal.Pool;

public class yj extends Pool<th> {

    public class qw implements Pool.Factory<th> {
        /* renamed from: ad */
        public th qw() {
            return new th();
        }
    }

    public yj() {
        super(Integer.MAX_VALUE, new qw());
    }
}
