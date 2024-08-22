package fe.fe.p007switch.qw;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* renamed from: fe.fe.switch.qw.nn  reason: invalid package */
public class nn {

    /* renamed from: ad  reason: collision with root package name */
    public static nn f3043ad;
    public String qw;

    static {
        Pattern.compile("\\s*|\t|\r|\n");
    }

    public nn() {
        new ArrayList();
        new ArrayList();
    }

    public static synchronized nn qw() {
        nn nnVar;
        synchronized (nn.class) {
            if (f3043ad == null) {
                f3043ad = new nn();
            }
            nnVar = f3043ad;
        }
        return nnVar;
    }

    public void ad(String str) {
        this.qw = str;
    }

    public String de() {
        if (TextUtils.isEmpty(this.qw)) {
            return "";
        }
        return this.qw;
    }
}
