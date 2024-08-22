package fe.mmm.qw.o.qw.ad.qw;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tera.scan.doc.preview.office.tiny.ITinyConverterCallback;
import com.tera.scan.doc.preview.office.tiny.TinyConverterWrapper;
import fe.mmm.qw.a.uk.rg;
import fe.mmm.qw.j.xxx.ad;
import java.io.File;
import org.json.JSONObject;

public class qw extends rg {
    public static String rrr;
    public static boolean tt;
    public boolean aaa;
    public String ddd;
    public Handler eee = new Handler(Looper.getMainLooper());
    public String mmm;
    public ITinyConverterCallback nn;
    public long qqq;
    public String xxx;

    /* renamed from: fe.mmm.qw.o.qw.ad.qw.qw$qw  reason: collision with other inner class name */
    public class C0289qw implements Runnable {
        public C0289qw() {
        }

        public void run() {
            if (qw.this.nn != null && !qw.this.m957switch()) {
                if (!qw.this.aaa || !ad.ppp(new File(qw.this.mmm))) {
                    qw.this.nn.onError(qw.this.qqq);
                } else {
                    qw.this.nn.onSucceed(qw.this.mmm);
                }
            }
        }
    }

    public qw(String str, String str2, ITinyConverterCallback iTinyConverterCallback) {
        super("TinyConverter");
        this.xxx = str;
        this.ddd = str2;
        this.nn = iTinyConverterCallback;
    }

    public static synchronized void a() {
        synchronized (qw.class) {
            if (!tt) {
                System.loadLibrary("tinyConverter");
                System.loadLibrary("OfficeConverter");
                System.loadLibrary("scanconvertwrapper");
                rrr = "/android_asset/tiny_converter/output";
                tt = true;
            }
        }
    }

    public final void b() {
        this.eee.post(new C0289qw());
    }

    public String tt(String str, String str2) {
        a();
        if (tt) {
            try {
                return new TinyConverterWrapper().nativeDispatchCommand(str, str2);
            } catch (Throwable th2) {
                fe.mmm.qw.i.qw.th("TinyConverter", th2.getMessage(), th2);
            }
        }
        return null;
    }

    public void when() throws Exception {
        try {
            this.qqq = 0;
            fe.mmm.qw.o.qw.ad.ad.ad.qw(".doc");
            this.mmm = fe.mmm.qw.o.qw.ad.ad.ad.fe(".doc");
            this.qqq = 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("file", this.xxx);
            jSONObject.put("password", this.ddd);
            jSONObject.put("outputPath", this.mmm);
            jSONObject.put("workType", "tts");
            String tt2 = tt("S_OpenFile", jSONObject.toString());
            if (!TextUtils.isEmpty(tt2)) {
                this.qqq = Long.parseLong(new JSONObject(tt2).getString("result"));
            } else {
                this.qqq = -1;
            }
            fe.mmm.qw.i.qw.ad("TinyConverter", "S_OpenFile " + tt2);
            this.aaa = this.qqq == 0;
        } finally {
            fe.mmm.qw.i.qw.ad("TinyConverter", "S_OpenFile err code " + this.qqq);
            b();
        }
    }
}
