package fe.fe.pf;

import android.content.Context;
import android.os.Looper;
import com.baidu.helios.OnGetIdResultCallback;
import fe.fe.pf.uk.ad;
import fe.fe.pf.uk.qw;
import java.util.List;

public final class de {
    public static de qw;

    public static de ad() {
        if (qw == null) {
            synchronized (de.class) {
                if (qw == null) {
                    qw = new de();
                }
            }
        }
        return qw;
    }

    public void de(Context context, OnGetIdResultCallback<qw> onGetIdResultCallback) {
        fe(context, onGetIdResultCallback, Looper.getMainLooper());
    }

    public void fe(Context context, OnGetIdResultCallback<qw> onGetIdResultCallback, Looper looper) {
        ad.th(context).m182if(onGetIdResultCallback, looper);
    }

    public String qw() {
        return "0.8.36";
    }

    public void rg(Context context, OnGetIdResultCallback<List<ad>> onGetIdResultCallback) {
        th(context, onGetIdResultCallback, Looper.getMainLooper());
    }

    public void th(Context context, OnGetIdResultCallback<List<ad>> onGetIdResultCallback, Looper looper) {
        ad.th(context).vvv(onGetIdResultCallback, looper);
    }
}
