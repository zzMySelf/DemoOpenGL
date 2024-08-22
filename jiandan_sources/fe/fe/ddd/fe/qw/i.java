package fe.fe.ddd.fe.qw;

import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import fe.fe.yj.de.ad;

public class i {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile i f1408ad;
    public UploadUrlListener qw;

    public static i qw() {
        if (f1408ad == null) {
            synchronized (i.class) {
                if (f1408ad == null) {
                    f1408ad = new i();
                }
            }
        }
        return f1408ad;
    }

    public String ad() {
        UploadUrlListener uploadUrlListener = this.qw;
        if (uploadUrlListener != null) {
            return uploadUrlListener.qw();
        }
        return ad.th().uk(fe.qw());
    }

    public void de(UploadUrlListener uploadUrlListener) {
        this.qw = uploadUrlListener;
    }
}
