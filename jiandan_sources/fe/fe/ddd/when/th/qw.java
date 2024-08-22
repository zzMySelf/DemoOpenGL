package fe.fe.ddd.when.th;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import fe.fe.ddd.when.qw.yj.i.de;
import fe.fe.ddd.when.qw.yj.yj;
import java.io.File;

public class qw extends fe.fe.ddd.when.qw.yj.qw {

    /* renamed from: fe.fe.ddd.when.th.qw$qw  reason: collision with other inner class name */
    public class C0095qw implements UploadUrlListener {
        public C0095qw(qw qwVar) {
        }

        public String qw() {
            return de.de().rg(UploadUrlListener.qw);
        }
    }

    public yj qw(@NonNull String str, @NonNull File file) {
        fe.fe.ddd.fe.qw.qw rg2 = fe.fe.ddd.fe.qw.de.de().rg("crash", str, file, new C0095qw(this));
        return new yj(rg2.de(), rg2.ad());
    }
}
