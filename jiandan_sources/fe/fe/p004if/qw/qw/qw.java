package fe.fe.p004if.qw.qw;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;

/* renamed from: fe.fe.if.qw.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: fe.fe.if.qw.qw.qw$ad */
    public static /* synthetic */ class ad {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$ActionType[] r0 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$ActionType r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.CONNECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.android.imsdk.upload.action.pb.IMPushPb$ActionType r1 = com.baidu.android.imsdk.upload.action.pb.IMPushPb.ActionType.REQUEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.qw.qw.ad.<clinit>():void");
        }
    }

    /* renamed from: fe.fe.if.qw.qw.qw$de */
    public static final class de {

        /* renamed from: ad  reason: collision with root package name */
        public Connection f1977ad;
        public Context qw;

        public de(Context context) {
            Connection connection = new Connection();
            this.f1977ad = connection;
            this.qw = context;
            connection.startTime = -1;
            connection.stopTime = -1;
            connection.reason = "";
            connection.retryTime = -1;
            connection.retryCount = -1;
            connection.ext = "";
            connection.aliasId = -1;
        }

        public void ad() {
            qw.ad(this.qw, IMPushPb.ActionType.CONNECTION, this.f1977ad);
        }

        public de de(String str) {
            this.f1977ad.ext = str;
            return this;
        }

        public de fe(String str) {
            this.f1977ad.reason = str;
            return this;
        }

        public de qw(long j) {
            this.f1977ad.aliasId = j;
            return this;
        }

        public de rg(long j) {
            this.f1977ad.retryCount = j;
            return this;
        }

        public de th(long j) {
            this.f1977ad.startTime = j;
            return this;
        }

        public de yj(long j) {
            this.f1977ad.stopTime = j;
            return this;
        }
    }

    /* renamed from: fe.fe.if.qw.qw.qw$fe */
    public static final class fe {

        /* renamed from: ad  reason: collision with root package name */
        public Request f1978ad;
        public Context qw;

        public fe(Context context) {
            Request request = new Request();
            this.f1978ad = request;
            this.qw = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1;
            request.responseTime = -1;
            request.errorCode = -1;
            request.ext = "";
            request.aliasId = -1;
        }

        public void ad() {
            qw.ad(this.qw, IMPushPb.ActionType.REQUEST, this.f1978ad);
        }

        public fe de(long j) {
            this.f1978ad.errorCode = j;
            return this;
        }

        public fe fe(String str) {
            this.f1978ad.ext = str;
            return this;
        }

        public fe qw(long j) {
            this.f1978ad.aliasId = j;
            return this;
        }

        public fe rg(String str) {
            this.f1978ad.method = str;
            return this;
        }

        public fe th(String str) {
            this.f1978ad.requestId = str;
            return this;
        }

        public fe uk(long j) {
            this.f1978ad.responseTime = j;
            return this;
        }

        public fe yj(long j) {
            this.f1978ad.timestamp = j;
            return this;
        }
    }

    /* renamed from: fe.fe.if.qw.qw.qw$qw  reason: collision with other inner class name */
    public class C0107qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ IMPushPb.ActionType f1979ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f1980th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f1981yj;

        public C0107qw(IMPushPb.ActionType actionType, Context context, Object obj) {
            this.f1979ad = actionType;
            this.f1980th = context;
            this.f1981yj = obj;
        }

        public void run() {
            int i2 = ad.qw[this.f1979ad.ordinal()];
            if (i2 == 1) {
                de.rg(this.f1980th, (Connection) this.f1981yj);
            } else if (i2 == 2) {
                de.th(this.f1980th, (Request) this.f1981yj);
            }
        }
    }

    public static void ad(Context context, IMPushPb.ActionType actionType, Object obj) {
        Context applicationContext = context.getApplicationContext();
        if (fe.o(applicationContext)) {
            fe.fe.p004if.qw.th.qw.qw(applicationContext).ad(new C0107qw(actionType, applicationContext, obj));
        }
    }
}
