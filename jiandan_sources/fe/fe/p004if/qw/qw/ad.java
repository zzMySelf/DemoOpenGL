package fe.fe.p004if.qw.qw;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import java.util.Map;

/* renamed from: fe.fe.if.qw.qw.ad  reason: invalid package */
public class ad {
    public static int qw;

    /* renamed from: fe.fe.if.qw.qw.ad$ad  reason: collision with other inner class name */
    public class C0106ad implements IMPushUploadResponseListener {
        public final /* synthetic */ Context qw;

        public C0106ad(Context context) {
            this.qw = context;
        }

        public void uploadResponse(int i2, String str) {
            fe.fe.p004if.qw.yj.fe.qw("LcpTrackManager", "uploadIMData response :" + i2 + ", msg :" + str);
            fe.xxx(this.qw);
            if (i2 == 0) {
                ad.yj(this.qw);
                int unused = ad.qw = 0;
                return;
            }
            int i3 = 1;
            if (ad.qw < 1) {
                ad.i(this.qw);
                ad.rg();
                return;
            }
            int unused2 = ad.qw = 0;
            int uk2 = fe.uk(this.qw);
            if (uk2 >= 3) {
                ad.yj(this.qw);
            } else {
                i3 = 1 + uk2;
            }
            fe.vvv(this.qw, i3);
        }
    }

    /* renamed from: fe.fe.if.qw.qw.ad$de */
    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1967ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.Action f1968th;

        public de(Context context, IMPushPb.Action action) {
            this.f1967ad = context;
            this.f1968th = action;
        }

        public void run() {
            ad.uk(this.f1967ad, this.f1968th);
        }
    }

    /* renamed from: fe.fe.if.qw.qw.ad$fe */
    public class fe implements IMPushUploadResponseListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ byte[] f1969ad;
        public final /* synthetic */ Context qw;

        public fe(Context context, byte[] bArr) {
            this.qw = context;
            this.f1969ad = bArr;
        }

        public void uploadResponse(int i2, String str) {
            fe.fe.p004if.qw.yj.fe.qw("LcpTrackManager", "uploadInitData response :" + i2 + ", msg :" + str);
            if (i2 != 0) {
                IMPushUploadManager.getInstance(this.qw).requestUpload((Map<String, String>) null, this.f1969ad, "", (IMPushUploadResponseListener) null);
            }
        }
    }

    /* renamed from: fe.fe.if.qw.qw.ad$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1970ad;

        public qw(Context context) {
            this.f1970ad = context;
        }

        public void run() {
            ad.i(this.f1970ad);
        }
    }

    public static void i(Context context) {
        byte[] de2 = new de().de(context);
        StringBuilder sb = new StringBuilder();
        sb.append("RequestUpload payload.length = ");
        int i2 = 0;
        sb.append(de2 != null ? de2.length : 0);
        fe.fe.p004if.qw.yj.fe.qw("LcpTrackManager", sb.toString());
        if (de2 == null || de2.length >= 307200 || de2.length <= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RequestUpload payload.length = ");
            if (de2 != null) {
                i2 = de2.length;
            }
            sb2.append(i2);
            sb2.append(", clear datas and no upload.");
            fe.fe.p004if.qw.yj.fe.qw("LcpTrackManager", sb2.toString());
            yj(context);
            return;
        }
        fe.fe.p004if.qw.yj.fe.qw("LcpTrackManager", "requestUpload begin");
        IMPushUploadManager.getInstance(context).requestUpload((Map<String, String>) null, de2, "", new C0106ad(context));
    }

    public static void o(Context context, @NonNull IMPushPb.Action action) {
        if (context != null && RequsetNetworkUtils.isConnected(context)) {
            fe.fe.p004if.qw.th.qw.qw(context).ad(new de(context, action));
        }
    }

    public static void pf(Context context) {
        if (context == null || !RequsetNetworkUtils.isConnected(context) || !fe.pf(context) || !fe.o(context)) {
            fe.fe.p004if.qw.yj.fe.ad("LcpTrackManager", "uploadTrackActionData return");
        } else {
            fe.fe.p004if.qw.th.qw.qw(context).ad(new qw(context));
        }
    }

    public static /* synthetic */ int rg() {
        int i2 = qw;
        qw = i2 + 1;
        return i2;
    }

    public static void uk(Context context, @NonNull IMPushPb.Action action) {
        byte[] qw2 = new de().qw(context, action);
        if (qw2 != null && qw2.length < 307200) {
            IMPushUploadManager.getInstance(context).requestUpload((Map<String, String>) null, qw2, "", new fe(context, qw2));
        }
    }

    public static void yj(Context context) {
        fe.ad(context);
        qw = 0;
    }
}
