package fe.fe.ddd.ddd.th;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONObject;

public class i {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f1342ad = AppConfig.rg();

    /* renamed from: de  reason: collision with root package name */
    public static volatile i f1343de;
    public ThreadPoolExecutor qw = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ uk f1344ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ IUploadListener f1345th;

        /* renamed from: fe.fe.ddd.ddd.th.i$qw$qw  reason: collision with other inner class name */
        public class C0071qw extends fe.fe.ddd.p001switch.rg.qw<JSONObject> {
            public C0071qw() {
            }

            /* renamed from: fe */
            public void ad(JSONObject jSONObject, int i2) {
                IUploadListener iUploadListener;
                if (jSONObject == null) {
                    return;
                }
                if (TextUtils.equals("0", jSONObject.optString("errno"))) {
                    yj ad2 = rg.ad(jSONObject.optJSONObject("data"));
                    if (ad2 != null && (iUploadListener = qw.this.f1345th) != null) {
                        iUploadListener.qw(ad2);
                        return;
                    }
                    return;
                }
                IUploadListener iUploadListener2 = qw.this.f1345th;
                if (iUploadListener2 != null) {
                    iUploadListener2.onFailure();
                }
            }

            public void qw(Exception exc) {
                if (i.f1342ad) {
                    "onFail: " + exc.getMessage();
                }
                IUploadListener iUploadListener = qw.this.f1345th;
                if (iUploadListener != null) {
                    iUploadListener.onFailure();
                }
            }

            /* renamed from: rg */
            public JSONObject de(Response response, int i2) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (i.f1342ad) {
                    "statusCode:" + i2 + ", response=" + string;
                }
                if (!TextUtils.isEmpty(string)) {
                    return new JSONObject(string);
                }
                return null;
            }
        }

        public qw(i iVar, uk ukVar, IUploadListener iUploadListener) {
            this.f1344ad = ukVar;
            this.f1345th = iUploadListener;
        }

        public void run() {
            JSONObject qw = rg.qw(this.f1344ad);
            if (qw != null) {
                Cif.qw().ad("0", qw.toString(), (Map<String, String>) null, new C0071qw());
            }
        }
    }

    public static i qw() {
        if (f1343de == null) {
            synchronized (i.class) {
                if (f1343de == null) {
                    f1343de = new i();
                }
            }
        }
        return f1343de;
    }

    public void ad(@NonNull uk ukVar) {
        de(ukVar, (IUploadListener) null);
    }

    public void de(@NonNull uk ukVar, IUploadListener iUploadListener) {
        this.qw.execute(new qw(this, ukVar, iUploadListener));
    }
}
