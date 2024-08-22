package fe.fe.ddd.fe.qw.pf;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import fe.fe.ddd.fe.qw.de;
import fe.fe.yj.de.ad;
import java.io.File;

public class qw extends ad {

    /* renamed from: fe.fe.ddd.fe.qw.pf.qw$qw  reason: collision with other inner class name */
    public class C0079qw implements UploadUrlListener {
        public C0079qw(qw qwVar) {
        }

        public String qw() {
            return ad.th().uk(UploadUrlListener.qw);
        }
    }

    public fe qw(@NonNull String str, @NonNull File file) {
        fe.fe.ddd.fe.qw.qw rg2 = de.de().rg("performance-anr", str, file, new C0079qw(this));
        return new fe(rg2.de(), rg2.ad());
    }
}
