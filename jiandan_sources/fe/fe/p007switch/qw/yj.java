package fe.fe.p007switch.qw;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.mobstat.dxmpay.SendStrategyEnum;
import com.baidu.mobstat.dxmpay.h;
import com.baidu.mobstat.dxmpay.q;
import com.baidu.sapi2.views.SmsLoginView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fe.fe.switch.qw.yj  reason: invalid package */
public class yj {

    /* renamed from: yj  reason: collision with root package name */
    public static yj f3062yj = new yj();

    /* renamed from: ad  reason: collision with root package name */
    public int f3063ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public int f3064de = 1;

    /* renamed from: fe  reason: collision with root package name */
    public SendStrategyEnum f3065fe = SendStrategyEnum.APP_START;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public Timer f3066rg;

    /* renamed from: th  reason: collision with root package name */
    public Handler f3067th;

    /* renamed from: fe.fe.switch.qw.yj$ad */
    public class ad extends TimerTask {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3068ad;

        public ad(Context context) {
            this.f3068ad = context;
        }

        public void run() {
            yj.this.yj(this.f3068ad);
        }
    }

    /* renamed from: fe.fe.switch.qw.yj$de */
    public class de implements FilenameFilter {
        public final /* synthetic */ String qw;

        public de(yj yjVar, String str) {
            this.qw = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.qw);
        }
    }

    /* renamed from: fe.fe.switch.qw.yj$fe */
    public class fe implements Comparator<String> {
        public fe(yj yjVar) {
        }

        /* renamed from: qw */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* renamed from: fe.fe.switch.qw.yj$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3070ad;

        /* renamed from: fe.fe.switch.qw.yj$qw$qw  reason: collision with other inner class name */
        public class C0146qw implements Runnable {
            public C0146qw() {
            }

            public void run() {
                qw qwVar = qw.this;
                yj.this.yj(qwVar.f3070ad);
            }
        }

        public qw(Context context) {
            this.f3070ad = context;
        }

        public void run() {
            if (yj.this.f3066rg != null) {
                yj.this.f3066rg.cancel();
                Timer unused = yj.this.f3066rg = null;
            }
            SendStrategyEnum unused2 = yj.this.f3065fe = SendStrategyEnum.values()[q.i().m31if(this.f3070ad)];
            int unused3 = yj.this.f3064de = q.i().ppp(this.f3070ad);
            boolean unused4 = yj.this.qw = q.i().vvv(this.f3070ad);
            if (yj.this.f3065fe.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                yj.this.eee(this.f3070ad);
            } else if (yj.this.f3065fe.equals(SendStrategyEnum.ONCE_A_DAY)) {
                yj.this.eee(this.f3070ad);
            }
            yj.this.f3067th.postDelayed(new C0146qw(), (long) (yj.this.f3063ad * 1000));
        }
    }

    /* renamed from: fe.fe.switch.qw.yj$rg */
    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3073ad;

        public rg(Context context) {
            this.f3073ad = context;
        }

        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(yj.this.de(this.f3073ad, Config.f883de));
                arrayList.addAll(yj.this.de(this.f3073ad, Config.f882ad));
                Iterator it = arrayList.iterator();
                while (true) {
                    int i2 = 0;
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String qw = ppp.qw(this.f3073ad, str);
                        if (TextUtils.isEmpty(qw)) {
                            ppp.rg(this.f3073ad, str);
                        } else {
                            if (yj.this.pf(this.f3073ad, qw, str.contains(Config.f882ad))) {
                                ppp.rg(this.f3073ad, str);
                            } else {
                                yj.ppp(this.f3073ad, str, qw);
                                i2++;
                                if (i2 >= 5) {
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: fe.fe.switch.qw.yj$th */
    public class th implements Callable<Object> {

        /* renamed from: ad  reason: collision with root package name */
        public Context f3075ad;

        /* renamed from: th  reason: collision with root package name */
        public String f3077th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f3078uk;

        /* renamed from: yj  reason: collision with root package name */
        public String f3079yj;

        public th(Context context, String str, String str2, boolean z) {
            this.f3075ad = context;
            this.f3079yj = str;
            this.f3077th = str2;
            this.f3078uk = z;
        }

        public Object call() {
            boolean z;
            if (yj.this.pf(this.f3075ad, this.f3077th, this.f3078uk)) {
                ppp.rg(this.f3075ad, this.f3079yj);
                z = true;
            } else {
                yj.ppp(this.f3075ad, this.f3079yj, this.f3077th);
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public yj() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f3067th = new Handler(handlerThread.getLooper());
    }

    public static yj mmm() {
        return f3062yj;
    }

    public static void ppp(Context context, String str, String str2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("trace");
                jSONObject2.put("failed_cnt", jSONObject2.getLong("failed_cnt") + 1);
            } catch (Exception unused2) {
            }
            ppp.de(context, str, jSONObject.toString(), false);
        }
    }

    public void aaa(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context != null) {
            this.f3067th.post(new qw(context));
        }
    }

    public final String ddd(Context context, String str, String str2) throws IOException {
        HttpURLConnection yj2 = ppp.yj(context, str);
        yj2.setDoOutput(true);
        yj2.setInstanceFollowRedirects(false);
        yj2.setUseCaches(false);
        yj2.setRequestProperty("Content-Type", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject("he");
            yj2.setRequestProperty("mtj_appkey", jSONObject.getString("k"));
            yj2.setRequestProperty("mtj_appversion", jSONObject.getString(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION));
            yj2.setRequestProperty("mtj_os", jSONObject.getString("o"));
            yj2.setRequestProperty("mtj_pn", jSONObject.getString("pn"));
            yj2.setRequestProperty("mtj_tg", jSONObject.getString("tg"));
            yj2.setRequestProperty("mtj_ii", jSONObject.getString("ii"));
            yj2.setRequestProperty("from", jSONObject.getString("from"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        yj2.connect();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(yj2.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(yj2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = yj2.getContentLength();
            if (yj2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + yj2.getResponseCode() + "; contentResponse = " + sb);
        } finally {
            yj2.disconnect();
        }
    }

    public final ArrayList<String> de(Context context, String str) {
        File filesDir;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!(context == null || (filesDir = context.getFilesDir()) == null || !filesDir.exists())) {
            de deVar = new de(this, str);
            String[] strArr = null;
            try {
                strArr = filesDir.list(deVar);
            } catch (Exception unused) {
            }
            if (!(strArr == null || strArr.length == 0)) {
                try {
                    Arrays.sort(strArr, new fe(this));
                } catch (Exception unused2) {
                }
                for (String add : strArr) {
                    arrayList.add(add);
                }
            }
        }
        return arrayList;
    }

    public void eee(Context context) {
        Context applicationContext = context.getApplicationContext();
        long j = (long) (this.f3064de * 3600000);
        try {
            Timer timer = new Timer();
            this.f3066rg = timer;
            timer.schedule(new ad(applicationContext), j, j);
        } catch (Exception unused) {
        }
    }

    public final String nn(Context context, String str, String str2) throws Exception {
        HttpURLConnection yj2 = ppp.yj(context, str);
        yj2.setDoOutput(true);
        yj2.setInstanceFollowRedirects(false);
        yj2.setUseCaches(false);
        yj2.setRequestProperty("Content-Type", "gzip");
        byte[] qw2 = Cif.qw();
        byte[] de2 = Cif.de();
        yj2.setRequestProperty("key", aaa.qw(qw2));
        yj2.setRequestProperty("iv", aaa.qw(de2));
        byte[] ad2 = Cif.ad(qw2, de2, str2.getBytes(a.h));
        yj2.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(yj2.getOutputStream());
            gZIPOutputStream.write(ad2);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(yj2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = yj2.getContentLength();
            if (yj2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + yj2.getResponseCode() + "; contentResponse = " + sb);
        } finally {
            yj2.disconnect();
        }
    }

    public final boolean pf(Context context, String str, boolean z) {
        if (!z) {
            h.o().de("Start send log \n" + str);
        }
        boolean z2 = false;
        if (!this.qw || qqq.qqq(context)) {
            String str2 = Config.qw;
            if (z) {
                str2 = "https://hmma.baidu.com/auto.gif";
            }
            try {
                vvv(context, str2, str);
                z2 = true;
            } catch (Exception e) {
                h.o().fe(e);
            }
            if (!z) {
                String str3 = z2 ? SmsLoginView.f.k : com.alipay.sdk.m.u.h.f684i;
                h.o().de("Send log " + str3);
            }
            return z2;
        }
        h.o().de("[WARNING] wifi not available, log will be cached, next time will try to resend");
        return false;
    }

    public void qqq(Context context, String str, boolean z) {
        String str2 = z ? Config.f882ad : Config.f883de;
        ppp.de(context, str2 + System.currentTimeMillis(), str, false);
        if (z) {
            uk(context, 10485760, Config.f882ad);
        }
    }

    public void rrr(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(de(context, Config.f883de));
        int size = arrayList.size();
        if (size != 0) {
            if (size > 20) {
                size = 20;
            }
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(size);
            ArrayList<Future> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                Context context2 = context;
                arrayList2.add(newFixedThreadPool.submit(new th(context2, (String) arrayList.get(i2), ppp.qw(context, (String) arrayList.get(i2)), ((String) arrayList.get(i2)).contains(Config.f882ad))));
            }
            newFixedThreadPool.shutdown();
            for (Future future : arrayList2) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r4 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r4 != null) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003c A[LOOP:1: B:22:0x003a->B:23:0x003c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uk(android.content.Context r8, long r9, java.lang.String r11) {
        /*
            r7 = this;
            java.util.ArrayList r11 = r7.de(r8, r11)
            int r0 = r11.size()
            int r0 = r0 + -1
            r1 = 0
            r2 = 0
            r4 = r1
        L_0x000e:
            if (r0 < 0) goto L_0x0039
            java.lang.Object r5 = r11.get(r0)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            java.io.FileInputStream r4 = r8.openFileInput(r5)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            int r5 = r4.available()     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            long r5 = (long) r5
            long r2 = r2 + r5
            if (r4 == 0) goto L_0x0031
            goto L_0x002d
        L_0x0023:
            r8 = move-exception
            if (r4 == 0) goto L_0x0029
            r4.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r8
        L_0x002a:
            if (r4 == 0) goto L_0x0031
        L_0x002d:
            r4.close()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            r4 = r1
        L_0x0031:
            int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            int r0 = r0 + -1
            goto L_0x000e
        L_0x0039:
            r9 = 0
        L_0x003a:
            if (r9 > r0) goto L_0x0048
            java.lang.Object r10 = r11.get(r9)
            java.lang.String r10 = (java.lang.String) r10
            fe.fe.p007switch.qw.ppp.rg(r8, r10)
            int r9 = r9 + 1
            goto L_0x003a
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.yj.uk(android.content.Context, long, java.lang.String):void");
    }

    public final String vvv(Context context, String str, String str2) throws Exception {
        if (!str.startsWith("https://")) {
            return nn(context, str, str2);
        }
        return ddd(context, str, str2);
    }

    public final void yj(Context context) {
        if (!this.qw || qqq.qqq(context)) {
            this.f3067th.post(new rg(context));
        }
    }
}
