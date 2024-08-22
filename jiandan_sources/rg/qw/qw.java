package rg.qw;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import dxm.sasdk.DbAdapter;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import dxm.sasdk.exceptions.DebugModeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final Map<Context, qw> f10446fe = new HashMap();

    /* renamed from: ad  reason: collision with root package name */
    public final Context f10447ad;

    /* renamed from: de  reason: collision with root package name */
    public final DbAdapter f10448de;
    public final C0333qw qw = new C0333qw();

    /* renamed from: rg.qw.qw$qw  reason: collision with other inner class name */
    public class C0333qw {

        /* renamed from: ad  reason: collision with root package name */
        public Handler f10449ad;
        public final Object qw = new Object();

        /* renamed from: rg.qw.qw$qw$qw  reason: collision with other inner class name */
        public class C0334qw extends Handler {
            public C0334qw(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                try {
                    if (message.what == 3) {
                        qw.this.rg();
                        return;
                    }
                    pf.ad("SA.AnalyticsMessages", "Unexpected message received by SensorsData worker: " + message);
                } catch (RuntimeException e) {
                    pf.de("SA.AnalyticsMessages", "Worker threw an unhandled exception", e);
                }
            }
        }

        public C0333qw() {
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.f10449ad = new C0334qw(handlerThread.getLooper());
        }

        public void ad(Message message, long j) {
            synchronized (this.qw) {
                if (this.f10449ad == null) {
                    pf.ad("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                } else if (!this.f10449ad.hasMessages(message.what)) {
                    this.f10449ad.sendMessageDelayed(message, j);
                }
            }
        }

        public void qw(Message message) {
            synchronized (this.qw) {
                if (this.f10449ad == null) {
                    pf.ad("SA.AnalyticsMessages", "Dead worker dropping a message: " + message.what);
                } else {
                    this.f10449ad.sendMessage(message);
                }
            }
        }
    }

    public qw(Context context, String str) {
        this.f10447ad = context;
        this.f10448de = new DbAdapter(this.f10447ad, str);
    }

    public static qw fe(Context context, String str) {
        qw qwVar;
        synchronized (f10446fe) {
            Context applicationContext = context.getApplicationContext();
            if (!f10446fe.containsKey(applicationContext)) {
                qwVar = new qw(applicationContext, str);
                f10446fe.put(applicationContext, qwVar);
            } else {
                qwVar = f10446fe.get(applicationContext);
            }
        }
        return qwVar;
    }

    public static byte[] th(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void ad(String str, JSONObject jSONObject) {
        try {
            synchronized (this.f10448de) {
                int de2 = this.f10448de.de(jSONObject, DbAdapter.Table.EVENTS);
                if (de2 < 0) {
                    String str2 = "Failed to enqueue the event: " + jSONObject;
                    if (!DxmSdkSensorsDataAPI.j(this.f10447ad).rrr()) {
                        pf.ad("SA.AnalyticsMessages", str2);
                    } else {
                        throw new DebugModeException(str2);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 3;
                if (!DxmSdkSensorsDataAPI.j(this.f10447ad).rrr()) {
                    if (de2 != -2) {
                        if (!str.equals("track_signup")) {
                            if (de2 <= DxmSdkSensorsDataAPI.j(this.f10447ad).ddd()) {
                                this.qw.ad(obtain, (long) DxmSdkSensorsDataAPI.j(this.f10447ad).nn());
                            }
                        }
                        this.qw.qw(obtain);
                    }
                }
                this.qw.qw(obtain);
            }
        } catch (Exception e) {
            pf.ad("SA.AnalyticsMessages", "enqueueEventMessage error:" + e);
        }
    }

    public void de() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.qw.qw(obtain);
    }

    public final String qw(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.getBytes().length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new String(rg.qw.vvv.qw.qw(byteArray));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:207:0x034d, code lost:
        if (r6 != null) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03b6, code lost:
        if (r6 != null) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03b8, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x03bb, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        r5 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r7 = r6.getErrorStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01bc, code lost:
        if (r6 != null) goto L_0x03b8;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0117 */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x02cd A[SYNTHETIC, Splitter:B:173:0x02cd] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02d4 A[SYNTHETIC, Splitter:B:177:0x02d4] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02db A[SYNTHETIC, Splitter:B:181:0x02db] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x033a A[SYNTHETIC, Splitter:B:196:0x033a] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0341 A[SYNTHETIC, Splitter:B:200:0x0341] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0348 A[SYNTHETIC, Splitter:B:204:0x0348] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03a3 A[SYNTHETIC, Splitter:B:218:0x03a3] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03aa A[SYNTHETIC, Splitter:B:222:0x03aa] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03b1 A[SYNTHETIC, Splitter:B:226:0x03b1] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03f7 A[SYNTHETIC, Splitter:B:242:0x03f7] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x03fe A[SYNTHETIC, Splitter:B:246:0x03fe] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0405 A[SYNTHETIC, Splitter:B:250:0x0405] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0450 A[SYNTHETIC, Splitter:B:265:0x0450] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0457 A[SYNTHETIC, Splitter:B:269:0x0457] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x045e A[SYNTHETIC, Splitter:B:273:0x045e] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0033 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0033 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:79:0x01c0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rg() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f10447ad     // Catch:{ Exception -> 0x002d }
            dxm.sasdk.DxmSdkSensorsDataAPI r0 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String r0 = r0.qqq()     // Catch:{ Exception -> 0x002d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0011
            return
        L_0x0011:
            android.content.Context r0 = r14.f10447ad     // Catch:{ Exception -> 0x002d }
            boolean r0 = dxm.sasdk.util.SensorsDataUtils.th(r0)     // Catch:{ Exception -> 0x002d }
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            android.content.Context r0 = r14.f10447ad     // Catch:{ Exception -> 0x002d }
            java.lang.String r0 = dxm.sasdk.util.SensorsDataUtils.i(r0)     // Catch:{ Exception -> 0x002d }
            android.content.Context r1 = r14.f10447ad     // Catch:{ Exception -> 0x002d }
            dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r1)     // Catch:{ Exception -> 0x002d }
            boolean r0 = r1.b(r0)     // Catch:{ Exception -> 0x002d }
            if (r0 != 0) goto L_0x0031
            return
        L_0x002d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0031:
            r0 = 100
        L_0x0033:
            if (r0 <= 0) goto L_0x046c
            dxm.sasdk.DbAdapter r0 = r14.f10448de
            monitor-enter(r0)
            android.content.Context r1 = r14.f10447ad     // Catch:{ all -> 0x0469 }
            dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r1)     // Catch:{ all -> 0x0469 }
            boolean r1 = r1.rrr()     // Catch:{ all -> 0x0469 }
            r2 = 1
            if (r1 == 0) goto L_0x004e
            dxm.sasdk.DbAdapter r1 = r14.f10448de     // Catch:{ all -> 0x0469 }
            dxm.sasdk.DbAdapter$Table r3 = dxm.sasdk.DbAdapter.Table.EVENTS     // Catch:{ all -> 0x0469 }
            java.lang.String[] r1 = r1.rg(r3, r2)     // Catch:{ all -> 0x0469 }
            goto L_0x0058
        L_0x004e:
            dxm.sasdk.DbAdapter r1 = r14.f10448de     // Catch:{ all -> 0x0469 }
            dxm.sasdk.DbAdapter$Table r3 = dxm.sasdk.DbAdapter.Table.EVENTS     // Catch:{ all -> 0x0469 }
            r4 = 50
            java.lang.String[] r1 = r1.rg(r3, r4)     // Catch:{ all -> 0x0469 }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0469 }
            if (r1 != 0) goto L_0x005c
            return
        L_0x005c:
            r0 = 0
            r3 = r1[r0]
            r1 = r1[r2]
            r4 = 0
            java.lang.String r5 = r14.qw(r1)     // Catch:{ IOException -> 0x0290 }
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0243 }
            android.content.Context r7 = r14.f10447ad     // Catch:{ IOException -> 0x0243 }
            dxm.sasdk.DxmSdkSensorsDataAPI r7 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r7)     // Catch:{ IOException -> 0x0243 }
            java.lang.String r7 = r7.qqq()     // Catch:{ IOException -> 0x0243 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0243 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ IOException -> 0x0243 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0243 }
            android.content.Context r7 = r14.f10447ad     // Catch:{ Exception -> 0x0094, all -> 0x008f }
            java.lang.String r7 = dxm.sasdk.util.SensorsDataUtils.rg(r7)     // Catch:{ Exception -> 0x0094, all -> 0x008f }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0094, all -> 0x008f }
            if (r8 == 0) goto L_0x0089
            java.lang.String r7 = "SensorsAnalytics Android SDK"
        L_0x0089:
            java.lang.String r8 = "User-Agent"
            r6.addRequestProperty(r8, r7)     // Catch:{ Exception -> 0x0094, all -> 0x008f }
            goto L_0x0098
        L_0x008f:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x0271
        L_0x0094:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x0098:
            android.content.Context r7 = r14.f10447ad     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            dxm.sasdk.DxmSdkSensorsDataAPI r7 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r7)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            boolean r7 = r7.rrr()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            if (r7 == 0) goto L_0x00b7
            android.content.Context r7 = r14.f10447ad     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            dxm.sasdk.DxmSdkSensorsDataAPI r7 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r7)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            boolean r7 = r7.tt()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            if (r7 != 0) goto L_0x00b7
            java.lang.String r7 = "Dry-Run"
            java.lang.String r8 = "true"
            r6.addRequestProperty(r7, r8)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x00b7:
            android.net.Uri$Builder r7 = new android.net.Uri$Builder     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r7.<init>()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r8 = "data_list"
            r7.appendQueryParameter(r8, r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r8 = "gzip"
            java.lang.String r9 = "1"
            r7.appendQueryParameter(r8, r9)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            if (r8 != 0) goto L_0x00db
            java.lang.String r8 = "crc"
            int r5 = r5.hashCode()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r7.appendQueryParameter(r8, r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x00db:
            android.net.Uri r5 = r7.build()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r5 = r5.getEncodedQuery()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            byte[] r7 = r5.getBytes()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            int r7 = r7.length     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r6.setFixedLengthStreamingMode(r7)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r6.setDoOutput(r2)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r7 = "POST"
            r6.setRequestMethod(r7)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0226, ConnectErrorException -> 0x0221, InvalidDataException -> 0x021c, ResponseErrorException -> 0x0217, Exception -> 0x0212, all -> 0x020d }
            r8.<init>(r7)     // Catch:{ IOException -> 0x0226, ConnectErrorException -> 0x0221, InvalidDataException -> 0x021c, ResponseErrorException -> 0x0217, Exception -> 0x0212, all -> 0x020d }
            java.lang.String r9 = "UTF-8"
            byte[] r5 = r5.getBytes(r9)     // Catch:{ IOException -> 0x0208, ConnectErrorException -> 0x0204, InvalidDataException -> 0x0200, ResponseErrorException -> 0x01fc, Exception -> 0x01f8, all -> 0x01f4 }
            r8.write(r5)     // Catch:{ IOException -> 0x0208, ConnectErrorException -> 0x0204, InvalidDataException -> 0x0200, ResponseErrorException -> 0x01fc, Exception -> 0x01f8, all -> 0x01f4 }
            r8.flush()     // Catch:{ IOException -> 0x0208, ConnectErrorException -> 0x0204, InvalidDataException -> 0x0200, ResponseErrorException -> 0x01fc, Exception -> 0x01f8, all -> 0x01f4 }
            r8.close()     // Catch:{ IOException -> 0x0208, ConnectErrorException -> 0x0204, InvalidDataException -> 0x0200, ResponseErrorException -> 0x01fc, Exception -> 0x01f8, all -> 0x01f4 }
            r7.close()     // Catch:{ IOException -> 0x0226, ConnectErrorException -> 0x0221, InvalidDataException -> 0x021c, ResponseErrorException -> 0x0217, Exception -> 0x0212, all -> 0x020d }
            int r5 = r6.getResponseCode()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ FileNotFoundException -> 0x0117 }
            goto L_0x011b
        L_0x0117:
            java.io.InputStream r7 = r6.getErrorStream()     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x011b:
            byte[] r8 = th(r7)     // Catch:{ IOException -> 0x01ef, ConnectErrorException -> 0x01e9, InvalidDataException -> 0x01e3, ResponseErrorException -> 0x01dd, Exception -> 0x01d7, all -> 0x01d0 }
            r7.close()     // Catch:{ IOException -> 0x01ef, ConnectErrorException -> 0x01e9, InvalidDataException -> 0x01e3, ResponseErrorException -> 0x01dd, Exception -> 0x01d7, all -> 0x01d0 }
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r9 = "UTF-8"
            r7.<init>(r8, r9)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r8 = 200(0xc8, float:2.8E-43)
            if (r5 != r8) goto L_0x0141
            java.lang.String r9 = "SA.AnalyticsMessages"
            java.lang.String r10 = "valid message: \n%s"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = rg.qw.vvv.ad.ad(r1)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r11[r0] = r1     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            rg.qw.pf.ad(r9, r1)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            goto L_0x017a
        L_0x0141:
            java.lang.String r9 = "SA.AnalyticsMessages"
            java.lang.String r10 = "invalid message: \n%s"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = rg.qw.vvv.ad.ad(r1)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r11[r0] = r1     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = java.lang.String.format(r10, r11)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            rg.qw.pf.ad(r9, r1)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = "SA.AnalyticsMessages"
            java.util.Locale r9 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r10 = "ret_code: %d"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r11[r0] = r12     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r9 = java.lang.String.format(r9, r10, r11)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            rg.qw.pf.ad(r1, r9)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r1 = "SA.AnalyticsMessages"
            java.util.Locale r9 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r10 = "ret_content: %s"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r11[r0] = r7     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r9 = java.lang.String.format(r9, r10, r11)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            rg.qw.pf.ad(r1, r9)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x017a:
            if (r5 < r8) goto L_0x01c0
            r1 = 300(0x12c, float:4.2E-43)
            if (r5 >= r1) goto L_0x01c0
            android.content.Context r1 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r1)
            boolean r1 = r1.rrr()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x019f
            if (r1 != 0) goto L_0x019a
            java.lang.Boolean r1 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x019f
        L_0x019a:
            java.lang.String r1 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r1, r4)
        L_0x019f:
            dxm.sasdk.DbAdapter r1 = r14.f10448de
            dxm.sasdk.DbAdapter$Table r4 = dxm.sasdk.DbAdapter.Table.EVENTS
            int r1 = r1.fe(r3, r4)
            java.lang.String r3 = "SA.AnalyticsMessages"
            java.util.Locale r4 = java.util.Locale.CHINA
            java.lang.String r5 = "Events flushed. [left = %d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            r2[r0] = r7
            java.lang.String r0 = java.lang.String.format(r4, r5, r2)
            rg.qw.pf.ad(r3, r0)
            if (r6 == 0) goto L_0x03bb
            goto L_0x03b8
        L_0x01c0:
            dxm.sasdk.exceptions.ResponseErrorException r1 = new dxm.sasdk.exceptions.ResponseErrorException     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r5 = "flush failure with response '%s'"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r8[r0] = r7     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            java.lang.String r5 = java.lang.String.format(r5, r8)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            r1.<init>((java.lang.String) r5)     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
            throw r1     // Catch:{ IOException -> 0x023f, ConnectErrorException -> 0x023a, InvalidDataException -> 0x0235, ResponseErrorException -> 0x0230, Exception -> 0x022b, all -> 0x008f }
        L_0x01d0:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r9 = 1
            r7 = r8
            goto L_0x0410
        L_0x01d7:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r7 = r8
            goto L_0x0297
        L_0x01dd:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r7 = r8
            goto L_0x02e7
        L_0x01e3:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r7 = r8
            goto L_0x0350
        L_0x01e9:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r7 = r8
            goto L_0x03c1
        L_0x01ef:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x0248
        L_0x01f4:
            r1 = move-exception
            r5 = r4
            goto L_0x0272
        L_0x01f8:
            r1 = move-exception
            r5 = r4
            goto L_0x0297
        L_0x01fc:
            r1 = move-exception
            r5 = r4
            goto L_0x02e7
        L_0x0200:
            r1 = move-exception
            r5 = r4
            goto L_0x0350
        L_0x0204:
            r1 = move-exception
            r5 = r4
            goto L_0x03c1
        L_0x0208:
            r1 = move-exception
            r5 = r7
            r7 = r4
            goto L_0x0248
        L_0x020d:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x0272
        L_0x0212:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x0297
        L_0x0217:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x02e7
        L_0x021c:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x0350
        L_0x0221:
            r1 = move-exception
            r5 = r4
            r8 = r5
            goto L_0x03c1
        L_0x0226:
            r1 = move-exception
            r8 = r4
            r5 = r7
            r7 = r8
            goto L_0x0248
        L_0x022b:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x0279
        L_0x0230:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x027f
        L_0x0235:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x0286
        L_0x023a:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x028d
        L_0x023f:
            r1 = move-exception
            r5 = r4
            r7 = r5
            goto L_0x0247
        L_0x0243:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x0247:
            r8 = r7
        L_0x0248:
            dxm.sasdk.exceptions.ConnectErrorException r9 = new dxm.sasdk.exceptions.ConnectErrorException     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0261, ResponseErrorException -> 0x025b, Exception -> 0x0255, all -> 0x024e }
            r9.<init>((java.lang.Throwable) r1)     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0261, ResponseErrorException -> 0x025b, Exception -> 0x0255, all -> 0x024e }
            throw r9     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0261, ResponseErrorException -> 0x025b, Exception -> 0x0255, all -> 0x024e }
        L_0x024e:
            r1 = move-exception
            r9 = 1
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x0410
        L_0x0255:
            r1 = move-exception
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x0297
        L_0x025b:
            r1 = move-exception
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x02e7
        L_0x0261:
            r1 = move-exception
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x0350
        L_0x0267:
            r1 = move-exception
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x03c1
        L_0x026d:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x0271:
            r8 = r7
        L_0x0272:
            r9 = 1
            goto L_0x0410
        L_0x0275:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x0279:
            r8 = r7
            goto L_0x0297
        L_0x027b:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x027f:
            r8 = r7
            goto L_0x02e7
        L_0x0282:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x0286:
            r8 = r7
            goto L_0x0350
        L_0x0289:
            r1 = move-exception
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x028d:
            r8 = r7
            goto L_0x03c1
        L_0x0290:
            r1 = move-exception
            dxm.sasdk.exceptions.InvalidDataException r5 = new dxm.sasdk.exceptions.InvalidDataException     // Catch:{ ConnectErrorException -> 0x0289, InvalidDataException -> 0x0282, ResponseErrorException -> 0x027b, Exception -> 0x0275, all -> 0x026d }
            r5.<init>((java.lang.Throwable) r1)     // Catch:{ ConnectErrorException -> 0x0289, InvalidDataException -> 0x0282, ResponseErrorException -> 0x027b, Exception -> 0x0275, all -> 0x026d }
            throw r5     // Catch:{ ConnectErrorException -> 0x0289, InvalidDataException -> 0x0282, ResponseErrorException -> 0x027b, Exception -> 0x0275, all -> 0x026d }
        L_0x0297:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x040e }
            r9.<init>()     // Catch:{ all -> 0x040e }
            java.lang.String r10 = "Exception: "
            r9.append(r10)     // Catch:{ all -> 0x040e }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x040e }
            r9.append(r1)     // Catch:{ all -> 0x040e }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x040e }
            android.content.Context r2 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r2 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r2)
            boolean r2 = r2.rrr()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x02cb
            if (r2 != 0) goto L_0x02c6
            java.lang.Boolean r2 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x02cb
        L_0x02c6:
            java.lang.String r2 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r2, r1)
        L_0x02cb:
            if (r8 == 0) goto L_0x02d2
            r8.close()     // Catch:{ IOException -> 0x02d1 }
            goto L_0x02d2
        L_0x02d1:
        L_0x02d2:
            if (r7 == 0) goto L_0x02d9
            r7.close()     // Catch:{ IOException -> 0x02d8 }
            goto L_0x02d9
        L_0x02d8:
        L_0x02d9:
            if (r5 == 0) goto L_0x02e0
            r5.close()     // Catch:{ IOException -> 0x02df }
            goto L_0x02e0
        L_0x02df:
        L_0x02e0:
            if (r6 == 0) goto L_0x0033
        L_0x02e2:
            r6.disconnect()
            goto L_0x0033
        L_0x02e7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x03be }
            r9.<init>()     // Catch:{ all -> 0x03be }
            java.lang.String r10 = "ResponseErrorException: "
            r9.append(r10)     // Catch:{ all -> 0x03be }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x03be }
            r9.append(r1)     // Catch:{ all -> 0x03be }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x03be }
            android.content.Context r4 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r4 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r4)
            boolean r4 = r4.rrr()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x031b
            if (r4 != 0) goto L_0x0316
            java.lang.Boolean r4 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x031b
        L_0x0316:
            java.lang.String r4 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r4, r1)
        L_0x031b:
            dxm.sasdk.DbAdapter r1 = r14.f10448de
            dxm.sasdk.DbAdapter$Table r4 = dxm.sasdk.DbAdapter.Table.EVENTS
            int r1 = r1.fe(r3, r4)
            java.lang.String r3 = "SA.AnalyticsMessages"
            java.util.Locale r4 = java.util.Locale.CHINA
            java.lang.String r9 = "Events flushed. [left = %d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r2[r0] = r10
            java.lang.String r0 = java.lang.String.format(r4, r9, r2)
            rg.qw.pf.ad(r3, r0)
            if (r8 == 0) goto L_0x033f
            r8.close()     // Catch:{ IOException -> 0x033e }
            goto L_0x033f
        L_0x033e:
        L_0x033f:
            if (r7 == 0) goto L_0x0346
            r7.close()     // Catch:{ IOException -> 0x0345 }
            goto L_0x0346
        L_0x0345:
        L_0x0346:
            if (r5 == 0) goto L_0x034d
            r5.close()     // Catch:{ IOException -> 0x034c }
            goto L_0x034d
        L_0x034c:
        L_0x034d:
            if (r6 == 0) goto L_0x03bb
            goto L_0x03b8
        L_0x0350:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x03be }
            r9.<init>()     // Catch:{ all -> 0x03be }
            java.lang.String r10 = "Invalid data: "
            r9.append(r10)     // Catch:{ all -> 0x03be }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x03be }
            r9.append(r1)     // Catch:{ all -> 0x03be }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x03be }
            android.content.Context r4 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r4 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r4)
            boolean r4 = r4.rrr()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x0384
            if (r4 != 0) goto L_0x037f
            java.lang.Boolean r4 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0384
        L_0x037f:
            java.lang.String r4 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r4, r1)
        L_0x0384:
            dxm.sasdk.DbAdapter r1 = r14.f10448de
            dxm.sasdk.DbAdapter$Table r4 = dxm.sasdk.DbAdapter.Table.EVENTS
            int r1 = r1.fe(r3, r4)
            java.lang.String r3 = "SA.AnalyticsMessages"
            java.util.Locale r4 = java.util.Locale.CHINA
            java.lang.String r9 = "Events flushed. [left = %d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r2[r0] = r10
            java.lang.String r0 = java.lang.String.format(r4, r9, r2)
            rg.qw.pf.ad(r3, r0)
            if (r8 == 0) goto L_0x03a8
            r8.close()     // Catch:{ IOException -> 0x03a7 }
            goto L_0x03a8
        L_0x03a7:
        L_0x03a8:
            if (r7 == 0) goto L_0x03af
            r7.close()     // Catch:{ IOException -> 0x03ae }
            goto L_0x03af
        L_0x03ae:
        L_0x03af:
            if (r5 == 0) goto L_0x03b6
            r5.close()     // Catch:{ IOException -> 0x03b5 }
            goto L_0x03b6
        L_0x03b5:
        L_0x03b6:
            if (r6 == 0) goto L_0x03bb
        L_0x03b8:
            r6.disconnect()
        L_0x03bb:
            r0 = r1
            goto L_0x0033
        L_0x03be:
            r1 = move-exception
            goto L_0x0272
        L_0x03c1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x040e }
            r9.<init>()     // Catch:{ all -> 0x040e }
            java.lang.String r10 = "Connection error: "
            r9.append(r10)     // Catch:{ all -> 0x040e }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x040e }
            r9.append(r1)     // Catch:{ all -> 0x040e }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x040e }
            android.content.Context r2 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r2 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r2)
            boolean r2 = r2.rrr()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x03f5
            if (r2 != 0) goto L_0x03f0
            java.lang.Boolean r2 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x03f5
        L_0x03f0:
            java.lang.String r2 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r2, r1)
        L_0x03f5:
            if (r8 == 0) goto L_0x03fc
            r8.close()     // Catch:{ IOException -> 0x03fb }
            goto L_0x03fc
        L_0x03fb:
        L_0x03fc:
            if (r7 == 0) goto L_0x0403
            r7.close()     // Catch:{ IOException -> 0x0402 }
            goto L_0x0403
        L_0x0402:
        L_0x0403:
            if (r5 == 0) goto L_0x040a
            r5.close()     // Catch:{ IOException -> 0x0409 }
            goto L_0x040a
        L_0x0409:
        L_0x040a:
            if (r6 == 0) goto L_0x0033
            goto L_0x02e2
        L_0x040e:
            r1 = move-exception
            r9 = 0
        L_0x0410:
            android.content.Context r10 = r14.f10447ad
            dxm.sasdk.DxmSdkSensorsDataAPI r10 = dxm.sasdk.DxmSdkSensorsDataAPI.j(r10)
            boolean r10 = r10.rrr()
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 != 0) goto L_0x042f
            if (r10 != 0) goto L_0x042a
            java.lang.Boolean r10 = dxm.sasdk.DxmSdkSensorsDataAPI.xxx
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x042f
        L_0x042a:
            java.lang.String r10 = "SA.AnalyticsMessages"
            rg.qw.pf.ad(r10, r4)
        L_0x042f:
            if (r9 == 0) goto L_0x044e
            dxm.sasdk.DbAdapter r4 = r14.f10448de
            dxm.sasdk.DbAdapter$Table r9 = dxm.sasdk.DbAdapter.Table.EVENTS
            int r3 = r4.fe(r3, r9)
            java.lang.String r4 = "SA.AnalyticsMessages"
            java.util.Locale r9 = java.util.Locale.CHINA
            java.lang.String r10 = "Events flushed. [left = %d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = java.lang.String.format(r9, r10, r2)
            rg.qw.pf.ad(r4, r0)
        L_0x044e:
            if (r8 == 0) goto L_0x0455
            r8.close()     // Catch:{ IOException -> 0x0454 }
            goto L_0x0455
        L_0x0454:
        L_0x0455:
            if (r7 == 0) goto L_0x045c
            r7.close()     // Catch:{ IOException -> 0x045b }
            goto L_0x045c
        L_0x045b:
        L_0x045c:
            if (r5 == 0) goto L_0x0463
            r5.close()     // Catch:{ IOException -> 0x0462 }
            goto L_0x0463
        L_0x0462:
        L_0x0463:
            if (r6 == 0) goto L_0x0468
            r6.disconnect()
        L_0x0468:
            throw r1
        L_0x0469:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0469 }
            throw r1
        L_0x046c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rg.qw.qw.rg():void");
    }
}
