package fe.nn.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.apollon.webmanager.a;
import com.google.android.gms.actions.SearchIntents;
import com.tekartik.sqflite.operation.Operation;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sqlite.database.sqlite.SQLiteDatabaseConfiguration;

public class de implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static Handler ggg;

    /* renamed from: i  reason: collision with root package name */
    public static int f8730i = 0;

    /* renamed from: if  reason: not valid java name */
    public static final Object f351if = new Object();

    /* renamed from: o  reason: collision with root package name */
    public static int f8731o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public static final Object f8732pf = new Object();
    public static HandlerThread ppp;

    /* renamed from: switch  reason: not valid java name */
    public static String f352switch;

    /* renamed from: uk  reason: collision with root package name */
    public static boolean f8733uk = false;
    @SuppressLint({"UseSparseArrays"})
    public static final Map<Integer, qw> vvv = new HashMap();
    public static int when = 0;

    /* renamed from: yj  reason: collision with root package name */
    public static final Map<String, Integer> f8734yj = new HashMap();

    /* renamed from: ad  reason: collision with root package name */
    public Context f8735ad;

    /* renamed from: th  reason: collision with root package name */
    public MethodChannel f8736th;

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8737ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ i f8738th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ qw f8740yj;

        public ad(MethodCall methodCall, i iVar, qw qwVar) {
            this.f8737ad = methodCall;
            this.f8738th = iVar;
            this.f8740yj = qwVar;
        }

        public void run() {
            fe.nn.qw.th.rg rgVar = new fe.nn.qw.th.rg(this.f8737ad, this.f8738th);
            boolean fe2 = rgVar.fe();
            boolean th2 = rgVar.th();
            ArrayList arrayList = new ArrayList();
            for (Map deVar : (List) this.f8737ad.argument("operations")) {
                fe.nn.qw.th.de deVar2 = new fe.nn.qw.th.de(deVar, fe2);
                String o2 = deVar2.o();
                char c = 65535;
                switch (o2.hashCode()) {
                    case -1319569547:
                        if (o2.equals("execute")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1183792455:
                        if (o2.equals("insert")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -838846263:
                        if (o2.equals("update")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 107944136:
                        if (o2.equals(SearchIntents.EXTRA_QUERY)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                i iVar = this.f8738th;
                                iVar.error("bad_param", "Batch method '" + o2 + "' not supported", (Object) null);
                                return;
                            } else if (de.this.q(this.f8740yj, deVar2)) {
                                deVar2.ppp(arrayList);
                            } else if (th2) {
                                deVar2.when(arrayList);
                            } else {
                                deVar2.m1017switch(this.f8738th);
                                return;
                            }
                        } else if (de.this.n(this.f8740yj, deVar2)) {
                            deVar2.ppp(arrayList);
                        } else if (th2) {
                            deVar2.when(arrayList);
                        } else {
                            deVar2.m1017switch(this.f8738th);
                            return;
                        }
                    } else if (de.this.qqq(this.f8740yj, deVar2)) {
                        deVar2.ppp(arrayList);
                    } else if (th2) {
                        deVar2.when(arrayList);
                    } else {
                        deVar2.m1017switch(this.f8738th);
                        return;
                    }
                } else if (de.this.ppp(this.f8740yj, deVar2)) {
                    deVar2.ppp(arrayList);
                } else if (th2) {
                    deVar2.when(arrayList);
                } else {
                    deVar2.m1017switch(this.f8738th);
                    return;
                }
            }
            if (fe2) {
                this.f8738th.success((Object) null);
            } else {
                this.f8738th.success(arrayList);
            }
        }
    }

    /* renamed from: fe.nn.qw.de$de  reason: collision with other inner class name */
    public class C0301de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8741ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ i f8742th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ qw f8744yj;

        public C0301de(MethodCall methodCall, i iVar, qw qwVar) {
            this.f8741ad = methodCall;
            this.f8742th = iVar;
            this.f8744yj = qwVar;
        }

        public void run() {
            boolean unused = de.this.qqq(this.f8744yj, new fe.nn.qw.th.rg(this.f8741ad, this.f8742th));
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ qw f8745ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8746th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ i f8748yj;

        public fe(qw qwVar, MethodCall methodCall, i iVar) {
            this.f8745ad = qwVar;
            this.f8746th = methodCall;
            this.f8748yj = iVar;
        }

        public void run() {
            if (de.this.ggg(this.f8745ad, this.f8746th, this.f8748yj) != null) {
                this.f8748yj.success((Object) null);
            }
        }
    }

    public class i implements MethodChannel.Result {

        /* renamed from: ad  reason: collision with root package name */
        public final MethodChannel.Result f8749ad;
        public final Handler qw;

        public class ad implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ String f8750ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ String f8751th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ Object f8753yj;

            public ad(String str, String str2, Object obj) {
                this.f8750ad = str;
                this.f8751th = str2;
                this.f8753yj = obj;
            }

            public void run() {
                i.this.f8749ad.error(this.f8750ad, this.f8751th, this.f8753yj);
            }
        }

        /* renamed from: fe.nn.qw.de$i$de  reason: collision with other inner class name */
        public class C0302de implements Runnable {
            public C0302de() {
            }

            public void run() {
                i.this.f8749ad.notImplemented();
            }
        }

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ Object f8755ad;

            public qw(Object obj) {
                this.f8755ad = obj;
            }

            public void run() {
                i.this.f8749ad.success(this.f8755ad);
            }
        }

        public /* synthetic */ i(de deVar, MethodChannel.Result result, qw qwVar) {
            this(deVar, result);
        }

        public void error(String str, String str2, Object obj) {
            this.qw.post(new ad(str, str2, obj));
        }

        public void notImplemented() {
            this.qw.post(new C0302de());
        }

        public void success(Object obj) {
            this.qw.post(new qw(obj));
        }

        public i(de deVar, MethodChannel.Result result) {
            this.qw = new Handler(Looper.getMainLooper());
            this.f8749ad = result;
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8757ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ i f8758th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ qw f8760yj;

        public qw(MethodCall methodCall, i iVar, qw qwVar) {
            this.f8757ad = methodCall;
            this.f8758th = iVar;
            this.f8760yj = qwVar;
        }

        public void run() {
            boolean unused = de.this.n(this.f8760yj, new fe.nn.qw.th.rg(this.f8757ad, this.f8758th));
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8761ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ i f8762th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ qw f8764yj;

        public rg(MethodCall methodCall, i iVar, qw qwVar) {
            this.f8761ad = methodCall;
            this.f8762th = iVar;
            this.f8764yj = qwVar;
        }

        public void run() {
            boolean unused = de.this.q(this.f8764yj, new fe.nn.qw.th.rg(this.f8761ad, this.f8762th));
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f8765ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ qw f8766i;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ int f353if;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ MethodCall f8767o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ boolean f8768pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f8769th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ Boolean f8770uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ i f8771yj;

        public th(boolean z, String str, i iVar, Boolean bool, qw qwVar, MethodCall methodCall, boolean z2, int i2) {
            this.f8765ad = z;
            this.f8769th = str;
            this.f8771yj = iVar;
            this.f8770uk = bool;
            this.f8766i = qwVar;
            this.f8767o = methodCall;
            this.f8768pf = z2;
            this.f353if = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
            r5.f8771yj.success(fe.nn.qw.de.rrr(r5.f353if, false, false));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
            fe.nn.qw.de.uk(r5.f354switch, r1, new fe.nn.qw.th.rg(r5.f8767o, r5.f8771yj), r5.f8766i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d3, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                java.lang.Object r0 = fe.nn.qw.de.f351if
                monitor-enter(r0)
                boolean r1 = r5.f8765ad     // Catch:{ all -> 0x00d4 }
                if (r1 != 0) goto L_0x0048
                java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = r5.f8769th     // Catch:{ all -> 0x00d4 }
                r1.<init>(r2)     // Catch:{ all -> 0x00d4 }
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d4 }
                java.lang.String r1 = r1.getParent()     // Catch:{ all -> 0x00d4 }
                r2.<init>(r1)     // Catch:{ all -> 0x00d4 }
                boolean r1 = r2.exists()     // Catch:{ all -> 0x00d4 }
                if (r1 != 0) goto L_0x0048
                boolean r1 = r2.mkdirs()     // Catch:{ all -> 0x00d4 }
                if (r1 != 0) goto L_0x0048
                boolean r1 = r2.exists()     // Catch:{ all -> 0x00d4 }
                if (r1 != 0) goto L_0x0048
                fe.nn.qw.de$i r1 = r5.f8771yj     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = "sqlite_error"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
                r3.<init>()     // Catch:{ all -> 0x00d4 }
                java.lang.String r4 = "open_failed "
                r3.append(r4)     // Catch:{ all -> 0x00d4 }
                java.lang.String r4 = r5.f8769th     // Catch:{ all -> 0x00d4 }
                r3.append(r4)     // Catch:{ all -> 0x00d4 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d4 }
                r4 = 0
                r1.error(r2, r3, r4)     // Catch:{ all -> 0x00d4 }
                monitor-exit(r0)     // Catch:{ all -> 0x00d4 }
                return
            L_0x0048:
                java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00c1 }
                java.lang.Boolean r2 = r5.f8770uk     // Catch:{ Exception -> 0x00c1 }
                boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00c1 }
                if (r1 == 0) goto L_0x0058
                fe.nn.qw.qw r1 = r5.f8766i     // Catch:{ Exception -> 0x00c1 }
                r1.uk()     // Catch:{ Exception -> 0x00c1 }
                goto L_0x005d
            L_0x0058:
                fe.nn.qw.qw r1 = r5.f8766i     // Catch:{ Exception -> 0x00c1 }
                r1.yj()     // Catch:{ Exception -> 0x00c1 }
            L_0x005d:
                java.lang.Object r1 = fe.nn.qw.de.f8732pf     // Catch:{ all -> 0x00d4 }
                monitor-enter(r1)     // Catch:{ all -> 0x00d4 }
                boolean r2 = r5.f8768pf     // Catch:{ all -> 0x00be }
                if (r2 == 0) goto L_0x0073
                java.util.Map<java.lang.String, java.lang.Integer> r2 = fe.nn.qw.de.f8734yj     // Catch:{ all -> 0x00be }
                java.lang.String r3 = r5.f8769th     // Catch:{ all -> 0x00be }
                int r4 = r5.f353if     // Catch:{ all -> 0x00be }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00be }
                r2.put(r3, r4)     // Catch:{ all -> 0x00be }
            L_0x0073:
                java.util.Map<java.lang.Integer, fe.nn.qw.qw> r2 = fe.nn.qw.de.vvv     // Catch:{ all -> 0x00be }
                int r3 = r5.f353if     // Catch:{ all -> 0x00be }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00be }
                fe.nn.qw.qw r4 = r5.f8766i     // Catch:{ all -> 0x00be }
                r2.put(r3, r4)     // Catch:{ all -> 0x00be }
                monitor-exit(r1)     // Catch:{ all -> 0x00be }
                fe.nn.qw.qw r1 = r5.f8766i     // Catch:{ all -> 0x00d4 }
                int r1 = r1.f8782fe     // Catch:{ all -> 0x00d4 }
                boolean r1 = fe.nn.qw.ad.ad(r1)     // Catch:{ all -> 0x00d4 }
                if (r1 == 0) goto L_0x00b0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
                r1.<init>()     // Catch:{ all -> 0x00d4 }
                fe.nn.qw.qw r2 = r5.f8766i     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = r2.fe()     // Catch:{ all -> 0x00d4 }
                r1.append(r2)     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = "opened "
                r1.append(r2)     // Catch:{ all -> 0x00d4 }
                int r2 = r5.f353if     // Catch:{ all -> 0x00d4 }
                r1.append(r2)     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = " "
                r1.append(r2)     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = r5.f8769th     // Catch:{ all -> 0x00d4 }
                r1.append(r2)     // Catch:{ all -> 0x00d4 }
                r1.toString()     // Catch:{ all -> 0x00d4 }
            L_0x00b0:
                monitor-exit(r0)     // Catch:{ all -> 0x00d4 }
                fe.nn.qw.de$i r0 = r5.f8771yj
                int r1 = r5.f353if
                r2 = 0
                java.util.Map r1 = fe.nn.qw.de.rrr(r1, r2, r2)
                r0.success(r1)
                return
            L_0x00be:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00be }
                throw r2     // Catch:{ all -> 0x00d4 }
            L_0x00c1:
                r1 = move-exception
                fe.nn.qw.th.rg r2 = new fe.nn.qw.th.rg     // Catch:{ all -> 0x00d4 }
                io.flutter.plugin.common.MethodCall r3 = r5.f8767o     // Catch:{ all -> 0x00d4 }
                fe.nn.qw.de$i r4 = r5.f8771yj     // Catch:{ all -> 0x00d4 }
                r2.<init>(r3, r4)     // Catch:{ all -> 0x00d4 }
                fe.nn.qw.de r3 = fe.nn.qw.de.this     // Catch:{ all -> 0x00d4 }
                fe.nn.qw.qw r4 = r5.f8766i     // Catch:{ all -> 0x00d4 }
                r3.aaa(r1, r2, r4)     // Catch:{ all -> 0x00d4 }
                monitor-exit(r0)     // Catch:{ all -> 0x00d4 }
                return
            L_0x00d4:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00d4 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.nn.qw.de.th.run():void");
        }
    }

    public class uk implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ qw f8772ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f8773th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ i f8775yj;

        public uk(qw qwVar, String str, i iVar) {
            this.f8772ad = qwVar;
            this.f8773th = str;
            this.f8775yj = iVar;
        }

        public void run() {
            synchronized (de.f351if) {
                if (this.f8772ad != null) {
                    de.this.pf(this.f8772ad);
                }
                try {
                    if (ad.de(de.f8731o)) {
                        "delete database " + this.f8773th;
                    }
                    qw.ad(this.f8773th);
                } catch (Exception e) {
                    "error " + e + " while closing database " + de.when;
                }
            }
            this.f8775yj.success((Object) null);
        }
    }

    public class yj implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ qw f8776ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ i f8777th;

        public yj(qw qwVar, i iVar) {
            this.f8776ad = qwVar;
            this.f8777th = iVar;
        }

        public void run() {
            synchronized (de.f351if) {
                de.this.pf(this.f8776ad);
            }
            this.f8777th.success((Object) null);
        }
    }

    public static boolean eee(String str) {
        return str == null || str.equals(SQLiteDatabaseConfiguration.MEMORY_DB_PATH);
    }

    /* renamed from: if  reason: not valid java name */
    public static List<Object> m1014if(Cursor cursor, int i2) {
        String str;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            Object when2 = when(cursor, i3);
            if (fe.nn.qw.rg.qw.f8786de) {
                String str2 = null;
                if (when2 != null) {
                    if (when2.getClass().isArray()) {
                        str2 = "array(" + when2.getClass().getComponentType().getName() + ")";
                    } else {
                        str2 = when2.getClass().getName();
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i3);
                sb.append(" ");
                sb.append(cursor.getType(i3));
                sb.append(": ");
                sb.append(when2);
                if (str2 == null) {
                    str = "";
                } else {
                    str = " (" + str2 + ")";
                }
                sb.append(str);
                sb.toString();
            }
            arrayList.add(when2);
        }
        return arrayList;
    }

    public static String p(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return xxx((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    public static Map rrr(int i2, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i2));
        if (z) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z2) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    /* renamed from: switch  reason: not valid java name */
    public static Map<String, Object> m1015switch(Cursor cursor) {
        HashMap hashMap = new HashMap();
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (fe.nn.qw.rg.qw.f8786de) {
                "column " + i2 + " " + cursor.getType(i2);
            }
            int type = cursor.getType(i2);
            if (type == 0) {
                hashMap.put(columnNames[i2], (Object) null);
            } else if (type == 1) {
                hashMap.put(columnNames[i2], Long.valueOf(cursor.getLong(i2)));
            } else if (type == 2) {
                hashMap.put(columnNames[i2], Double.valueOf(cursor.getDouble(i2)));
            } else if (type == 3) {
                hashMap.put(columnNames[i2], cursor.getString(i2));
            } else if (type == 4) {
                hashMap.put(columnNames[i2], cursor.getBlob(i2));
            }
        }
        return hashMap;
    }

    public static Object when(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i2);
    }

    public static Map<String, Object> xxx(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = xxx((Map) value);
            } else {
                obj = p(value);
            }
            hashMap.put(p(next.getKey()), obj);
        }
        return hashMap;
    }

    public final void a(MethodCall methodCall, MethodChannel.Result result) {
        qw nn = nn(methodCall, result);
        if (nn != null) {
            ggg.post(new ad(methodCall, new i(this, result, (qw) null), nn));
        }
    }

    public final void aaa(Exception exc, Operation operation, qw qwVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            operation.error("sqlite_error", "open_failed " + qwVar.f8780ad, (Object) null);
        } else if (exc instanceof SQLException) {
            operation.error("sqlite_error", exc.getMessage(), fe.nn.qw.th.th.qw(operation));
        } else {
            operation.error("sqlite_error", exc.getMessage(), fe.nn.qw.th.th.qw(operation));
        }
    }

    public final void b(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        qw nn = nn(methodCall, result);
        if (nn != null) {
            if (ad.ad(nn.f8782fe)) {
                nn.fe() + "closing " + intValue + " " + nn.f8780ad;
            }
            String str = nn.f8780ad;
            synchronized (f8732pf) {
                vvv.remove(Integer.valueOf(intValue));
                if (nn.qw) {
                    f8734yj.remove(str);
                }
            }
            ggg.post(new yj(nn, new i(this, result, (qw) null)));
        }
    }

    public final void c(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument("cmd"))) {
            int i2 = f8731o;
            if (i2 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i2));
            }
            if (!vvv.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : vvv.entrySet()) {
                    qw qwVar = (qw) next.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", qwVar.f8780ad);
                    hashMap3.put("singleInstance", Boolean.valueOf(qwVar.qw));
                    int i3 = qwVar.f8782fe;
                    if (i3 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i3));
                    }
                    hashMap2.put(((Integer) next.getKey()).toString(), hashMap3);
                }
                hashMap.put(a.d, hashMap2);
            }
        }
        result.success(hashMap);
    }

    public final void d(MethodCall methodCall, MethodChannel.Result result) {
        fe.nn.qw.rg.qw.qw = Boolean.TRUE.equals(methodCall.arguments());
        fe.nn.qw.rg.qw.f8786de = fe.nn.qw.rg.qw.f8785ad && fe.nn.qw.rg.qw.qw;
        if (!fe.nn.qw.rg.qw.qw) {
            f8731o = 0;
        } else if (fe.nn.qw.rg.qw.f8786de) {
            f8731o = 2;
        } else if (fe.nn.qw.rg.qw.qw) {
            f8731o = 1;
        }
        result.success((Object) null);
    }

    public final qw ddd(int i2) {
        return vvv.get(Integer.valueOf(i2));
    }

    public final void e(MethodCall methodCall, MethodChannel.Result result) {
        qw qwVar;
        String str = (String) methodCall.argument("path");
        synchronized (f8732pf) {
            if (ad.de(f8731o)) {
                "Look for " + str + " in " + f8734yj.keySet();
            }
            Integer num = f8734yj.get(str);
            if (num == null || (qwVar = vvv.get(num)) == null || !qwVar.f8783rg.isOpen()) {
                qwVar = null;
            } else {
                if (ad.de(f8731o)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(qwVar.fe());
                    sb.append("found single instance ");
                    sb.append(qwVar.f8784th ? "(in transaction) " : "");
                    sb.append(num);
                    sb.append(" ");
                    sb.append(str);
                    sb.toString();
                }
                vvv.remove(num);
                f8734yj.remove(str);
            }
        }
        uk ukVar = new uk(qwVar, str, new i(this, result, (qw) null));
        Handler handler = ggg;
        if (handler != null) {
            handler.post(ukVar);
        } else {
            ukVar.run();
        }
    }

    public final void f(MethodCall methodCall, MethodChannel.Result result) {
        qw nn = nn(methodCall, result);
        if (nn != null) {
            ggg.post(new fe(nn, methodCall, new i(this, result, (qw) null)));
        }
    }

    public void g(MethodCall methodCall, MethodChannel.Result result) {
        if (f352switch == null) {
            f352switch = this.f8735ad.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f352switch);
    }

    public final qw ggg(qw qwVar, MethodCall methodCall, MethodChannel.Result result) {
        if (vvv(qwVar, new fe.nn.qw.th.fe(result, mmm(methodCall), (Boolean) methodCall.argument("inTransaction")))) {
            return qwVar;
        }
        return null;
    }

    public final void h(MethodCall methodCall, MethodChannel.Result result) {
        qw nn = nn(methodCall, result);
        if (nn != null) {
            ggg.post(new C0301de(methodCall, new i(this, result, (qw) null), nn));
        }
    }

    public final void j(MethodCall methodCall, MethodChannel.Result result) {
        int i2;
        qw qwVar;
        String str = (String) methodCall.argument("path");
        Boolean bool = (Boolean) methodCall.argument("readOnly");
        boolean eee = eee(str);
        boolean z = !Boolean.FALSE.equals(methodCall.argument("singleInstance")) && !eee;
        if (z) {
            synchronized (f8732pf) {
                if (ad.de(f8731o)) {
                    "Look for " + str + " in " + f8734yj.keySet();
                }
                Integer num = f8734yj.get(str);
                if (!(num == null || (qwVar = vvv.get(num)) == null)) {
                    if (qwVar.f8783rg.isOpen()) {
                        if (ad.de(f8731o)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(qwVar.fe());
                            sb.append("re-opened single instance ");
                            sb.append(qwVar.f8784th ? "(in transaction) " : "");
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            sb.toString();
                        }
                        result.success(rrr(num.intValue(), true, qwVar.f8784th));
                        return;
                    } else if (ad.de(f8731o)) {
                        qwVar.fe() + "single instance database of " + str + " not opened";
                    }
                }
            }
        }
        synchronized (f8732pf) {
            i2 = when + 1;
            when = i2;
        }
        qw qwVar2 = new qw(str, i2, z, f8731o);
        i iVar = new i(this, result, (qw) null);
        synchronized (f8732pf) {
            if (ggg == null) {
                HandlerThread handlerThread = new HandlerThread("Sqflite", f8730i);
                ppp = handlerThread;
                handlerThread.start();
                ggg = new Handler(ppp.getLooper());
                if (ad.ad(qwVar2.f8782fe)) {
                    qwVar2.fe() + "starting thread" + ppp + " priority " + f8730i;
                }
            }
            if (ad.ad(qwVar2.f8782fe)) {
                qwVar2.fe() + "opened " + i2 + " " + str;
            }
            ggg.post(new th(eee, str, iVar, bool, qwVar2, methodCall, z, i2));
        }
    }

    public void k(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("queryAsMapList");
        if (argument != null) {
            f8733uk = Boolean.TRUE.equals(argument);
        }
        Object argument2 = methodCall.argument("androidThreadPriority");
        if (argument2 != null) {
            f8730i = ((Integer) argument2).intValue();
        }
        Integer qw2 = ad.qw(methodCall);
        if (qw2 != null) {
            f8731o = qw2.intValue();
        }
        result.success((Object) null);
    }

    public final void l(MethodCall methodCall, MethodChannel.Result result) {
        qw nn = nn(methodCall, result);
        if (nn != null) {
            ggg.post(new qw(methodCall, new i(this, result, (qw) null), nn));
        }
    }

    public final void m(MethodCall methodCall, MethodChannel.Result result) {
        qw nn = nn(methodCall, result);
        if (nn != null) {
            ggg.post(new rg(methodCall, new i(this, result, (qw) null), nn));
        }
    }

    public final fe mmm(MethodCall methodCall) {
        return new fe((String) methodCall.argument("sql"), (List) methodCall.argument("arguments"));
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.util.Map, java.util.HashMap] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r4 != null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        r4 = new java.util.ArrayList();
        r5 = new java.util.HashMap();
        r6 = r0.getColumnCount();
        r5.put("columns", java.util.Arrays.asList(r0.getColumnNames()));
        r5.put("rows", r4);
        r10 = r5;
        r5 = r4;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0090, code lost:
        r5.add(m1014if(r0, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        if (r4 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a0, code lost:
        r4 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a5, code lost:
        r13.success(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x003d, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean n(fe.nn.qw.qw r12, com.tekartik.sqflite.operation.Operation r13) {
        /*
            r11 = this;
            fe.nn.qw.fe r0 = r13.de()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r12.f8782fe
            boolean r2 = fe.nn.qw.ad.ad(r2)
            if (r2 == 0) goto L_0x0023
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r12.fe()
            r2.append(r3)
            r2.append(r0)
            r2.toString()
        L_0x0023:
            boolean r2 = f8733uk
            r3 = 0
            r4 = 0
            fe.nn.qw.fe r0 = r0.i()     // Catch:{ Exception -> 0x00b7 }
            android.database.sqlite.SQLiteDatabase r5 = r12.de()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = r0.rg()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String[] r0 = r0.ad()     // Catch:{ Exception -> 0x00b7 }
            android.database.Cursor r0 = r5.rawQuery(r6, r0)     // Catch:{ Exception -> 0x00b7 }
            r5 = r4
            r6 = 0
        L_0x003d:
            boolean r7 = r0.moveToNext()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r7 == 0) goto L_0x0098
            if (r2 == 0) goto L_0x006b
            java.util.Map r7 = m1015switch(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            int r8 = r12.f8782fe     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            boolean r8 = fe.nn.qw.ad.ad(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r8 == 0) goto L_0x0067
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r8.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r9 = r12.fe()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r8.append(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r9 = p(r7)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r8.append(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r8.toString()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
        L_0x0067:
            r1.add(r7)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            goto L_0x003d
        L_0x006b:
            if (r4 != 0) goto L_0x0090
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            int r6 = r0.getColumnCount()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r7 = "columns"
            java.lang.String[] r8 = r0.getColumnNames()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.put(r7, r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r7 = "rows"
            r5.put(r7, r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r10 = r5
            r5 = r4
            r4 = r10
        L_0x0090:
            java.util.List r7 = m1014if(r0, r6)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5.add(r7)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            goto L_0x003d
        L_0x0098:
            if (r2 == 0) goto L_0x009e
            r13.success(r1)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            goto L_0x00a8
        L_0x009e:
            if (r4 != 0) goto L_0x00a5
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
        L_0x00a5:
            r13.success(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
        L_0x00a8:
            r12 = 1
            if (r0 == 0) goto L_0x00ae
            r0.close()
        L_0x00ae:
            return r12
        L_0x00af:
            r12 = move-exception
            r4 = r0
            goto L_0x00c1
        L_0x00b2:
            r1 = move-exception
            r4 = r0
            goto L_0x00b8
        L_0x00b5:
            r12 = move-exception
            goto L_0x00c1
        L_0x00b7:
            r1 = move-exception
        L_0x00b8:
            r11.aaa(r1, r13, r12)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x00c0
            r4.close()
        L_0x00c0:
            return r3
        L_0x00c1:
            if (r4 == 0) goto L_0x00c6
            r4.close()
        L_0x00c6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.nn.qw.de.n(fe.nn.qw.qw, com.tekartik.sqflite.operation.Operation):boolean");
    }

    public final qw nn(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        qw ddd = ddd(intValue);
        if (ddd != null) {
            return ddd;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        tt(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f8735ad = null;
        this.f8736th.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f8736th = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r3, io.flutter.plugin.common.MethodChannel.Result r4) {
        /*
            r2 = this;
            java.lang.String r0 = r3.method
            int r1 = r0.hashCode()
            switch(r1) {
                case -1319569547: goto L_0x008b;
                case -1253581933: goto L_0x0081;
                case -1249474914: goto L_0x0076;
                case -1183792455: goto L_0x006c;
                case -838846263: goto L_0x0062;
                case -263511994: goto L_0x0057;
                case -198450538: goto L_0x004c;
                case -17190427: goto L_0x0042;
                case 93509434: goto L_0x0038;
                case 95458899: goto L_0x002d;
                case 107944136: goto L_0x0022;
                case 1385449135: goto L_0x0017;
                case 1863829223: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0095
        L_0x000b:
            java.lang.String r1 = "getDatabasesPath"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 9
            goto L_0x0096
        L_0x0017:
            java.lang.String r1 = "getPlatformVersion"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 0
            goto L_0x0096
        L_0x0022:
            java.lang.String r1 = "query"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 2
            goto L_0x0096
        L_0x002d:
            java.lang.String r1 = "debug"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 11
            goto L_0x0096
        L_0x0038:
            java.lang.String r1 = "batch"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 7
            goto L_0x0096
        L_0x0042:
            java.lang.String r1 = "openDatabase"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 6
            goto L_0x0096
        L_0x004c:
            java.lang.String r1 = "debugMode"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 12
            goto L_0x0096
        L_0x0057:
            java.lang.String r1 = "deleteDatabase"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 10
            goto L_0x0096
        L_0x0062:
            java.lang.String r1 = "update"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 4
            goto L_0x0096
        L_0x006c:
            java.lang.String r1 = "insert"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 3
            goto L_0x0096
        L_0x0076:
            java.lang.String r1 = "options"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 8
            goto L_0x0096
        L_0x0081:
            java.lang.String r1 = "closeDatabase"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 1
            goto L_0x0096
        L_0x008b:
            java.lang.String r1 = "execute"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0095
            r0 = 5
            goto L_0x0096
        L_0x0095:
            r0 = -1
        L_0x0096:
            switch(r0) {
                case 0: goto L_0x00cd;
                case 1: goto L_0x00c9;
                case 2: goto L_0x00c5;
                case 3: goto L_0x00c1;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00b9;
                case 6: goto L_0x00b5;
                case 7: goto L_0x00b1;
                case 8: goto L_0x00ad;
                case 9: goto L_0x00a9;
                case 10: goto L_0x00a5;
                case 11: goto L_0x00a1;
                case 12: goto L_0x009d;
                default: goto L_0x0099;
            }
        L_0x0099:
            r4.notImplemented()
            goto L_0x00e3
        L_0x009d:
            r2.d(r3, r4)
            goto L_0x00e3
        L_0x00a1:
            r2.c(r3, r4)
            goto L_0x00e3
        L_0x00a5:
            r2.e(r3, r4)
            goto L_0x00e3
        L_0x00a9:
            r2.g(r3, r4)
            goto L_0x00e3
        L_0x00ad:
            r2.k(r3, r4)
            goto L_0x00e3
        L_0x00b1:
            r2.a(r3, r4)
            goto L_0x00e3
        L_0x00b5:
            r2.j(r3, r4)
            goto L_0x00e3
        L_0x00b9:
            r2.f(r3, r4)
            goto L_0x00e3
        L_0x00bd:
            r2.m(r3, r4)
            goto L_0x00e3
        L_0x00c1:
            r2.h(r3, r4)
            goto L_0x00e3
        L_0x00c5:
            r2.l(r3, r4)
            goto L_0x00e3
        L_0x00c9:
            r2.b(r3, r4)
            goto L_0x00e3
        L_0x00cd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Android "
            r3.append(r0)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r4.success(r3)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.nn.qw.de.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void pf(qw qwVar) {
        try {
            if (ad.ad(qwVar.f8782fe)) {
                qwVar.fe() + "closing database " + ppp;
            }
            qwVar.qw();
        } catch (Exception e) {
            "error " + e + " while closing database " + when;
        }
        synchronized (f8732pf) {
            if (vvv.isEmpty() && ggg != null) {
                if (ad.ad(qwVar.f8782fe)) {
                    qwVar.fe() + "stopping thread" + ppp;
                }
                ppp.quit();
                ppp = null;
                ggg = null;
            }
        }
    }

    public final boolean ppp(qw qwVar, Operation operation) {
        if (!vvv(qwVar, operation)) {
            return false;
        }
        operation.success((Object) null);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean q(fe.nn.qw.qw r7, com.tekartik.sqflite.operation.Operation r8) {
        /*
            r6 = this;
            boolean r0 = r6.vvv(r7, r8)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r8.fe()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r8.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r7.th()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r4 = "SELECT changes()"
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x0081 }
            if (r0 == 0) goto L_0x0062
            int r4 = r0.getCount()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r4 <= 0) goto L_0x0062
            boolean r4 = r0.moveToFirst()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r4 == 0) goto L_0x0062
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            int r4 = r7.f8782fe     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            boolean r4 = fe.nn.qw.ad.ad(r4)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r4 == 0) goto L_0x004f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.<init>()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.lang.String r5 = r7.fe()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.append(r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.lang.String r5 = "changed "
            r4.append(r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.append(r3)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.toString()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
        L_0x004f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r8.success(r3)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r0 == 0) goto L_0x005b
            r0.close()
        L_0x005b:
            return r2
        L_0x005c:
            r7 = move-exception
            r3 = r0
            goto L_0x008b
        L_0x005f:
            r2 = move-exception
            r3 = r0
            goto L_0x0082
        L_0x0062:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.<init>()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.lang.String r5 = r7.fe()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.append(r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.lang.String r5 = "fail to read changes for Update/Delete"
            r4.append(r5)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r4.toString()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r8.success(r3)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r0 == 0) goto L_0x007e
            r0.close()
        L_0x007e:
            return r2
        L_0x007f:
            r7 = move-exception
            goto L_0x008b
        L_0x0081:
            r2 = move-exception
        L_0x0082:
            r6.aaa(r2, r8, r7)     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x008a
            r3.close()
        L_0x008a:
            return r1
        L_0x008b:
            if (r3 == 0) goto L_0x0090
            r3.close()
        L_0x0090:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.nn.qw.de.q(fe.nn.qw.qw, com.tekartik.sqflite.operation.Operation):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean qqq(fe.nn.qw.qw r9, com.tekartik.sqflite.operation.Operation r10) {
        /*
            r8 = this;
            boolean r0 = r8.vvv(r9, r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r10.fe()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r10.success(r2)
            return r3
        L_0x0014:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.th()     // Catch:{ Exception -> 0x00b4, all -> 0x00b2 }
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch:{ Exception -> 0x00b4, all -> 0x00b2 }
            if (r0 == 0) goto L_0x0095
            int r4 = r0.getCount()     // Catch:{ Exception -> 0x0093 }
            if (r4 <= 0) goto L_0x0095
            boolean r4 = r0.moveToFirst()     // Catch:{ Exception -> 0x0093 }
            if (r4 == 0) goto L_0x0095
            int r4 = r0.getInt(r1)     // Catch:{ Exception -> 0x0093 }
            if (r4 != 0) goto L_0x0063
            int r4 = r9.f8782fe     // Catch:{ Exception -> 0x0093 }
            boolean r4 = fe.nn.qw.ad.ad(r4)     // Catch:{ Exception -> 0x0093 }
            if (r4 == 0) goto L_0x005a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093 }
            r4.<init>()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r5 = r9.fe()     // Catch:{ Exception -> 0x0093 }
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r5 = "no changes (id was "
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x0093 }
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            r4.toString()     // Catch:{ Exception -> 0x0093 }
        L_0x005a:
            r10.success(r2)     // Catch:{ Exception -> 0x0093 }
            if (r0 == 0) goto L_0x0062
            r0.close()
        L_0x0062:
            return r3
        L_0x0063:
            long r4 = r0.getLong(r3)     // Catch:{ Exception -> 0x0093 }
            int r2 = r9.f8782fe     // Catch:{ Exception -> 0x0093 }
            boolean r2 = fe.nn.qw.ad.ad(r2)     // Catch:{ Exception -> 0x0093 }
            if (r2 == 0) goto L_0x0086
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093 }
            r2.<init>()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r6 = r9.fe()     // Catch:{ Exception -> 0x0093 }
            r2.append(r6)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r6 = "inserted "
            r2.append(r6)     // Catch:{ Exception -> 0x0093 }
            r2.append(r4)     // Catch:{ Exception -> 0x0093 }
            r2.toString()     // Catch:{ Exception -> 0x0093 }
        L_0x0086:
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0093 }
            r10.success(r2)     // Catch:{ Exception -> 0x0093 }
            if (r0 == 0) goto L_0x0092
            r0.close()
        L_0x0092:
            return r3
        L_0x0093:
            r2 = move-exception
            goto L_0x00b8
        L_0x0095:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093 }
            r4.<init>()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r5 = r9.fe()     // Catch:{ Exception -> 0x0093 }
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r5 = "fail to read changes for Insert"
            r4.append(r5)     // Catch:{ Exception -> 0x0093 }
            r4.toString()     // Catch:{ Exception -> 0x0093 }
            r10.success(r2)     // Catch:{ Exception -> 0x0093 }
            if (r0 == 0) goto L_0x00b1
            r0.close()
        L_0x00b1:
            return r3
        L_0x00b2:
            r9 = move-exception
            goto L_0x00c3
        L_0x00b4:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
        L_0x00b8:
            r8.aaa(r2, r10, r9)     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00c0
            r0.close()
        L_0x00c0:
            return r1
        L_0x00c1:
            r9 = move-exception
            r2 = r0
        L_0x00c3:
            if (r2 == 0) goto L_0x00c8
            r2.close()
        L_0x00c8:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.nn.qw.de.qqq(fe.nn.qw.qw, com.tekartik.sqflite.operation.Operation):boolean");
    }

    public final void tt(Context context, BinaryMessenger binaryMessenger) {
        this.f8735ad = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite");
        this.f8736th = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final boolean vvv(qw qwVar, Operation operation) {
        fe de2 = operation.de();
        if (ad.ad(qwVar.f8782fe)) {
            qwVar.fe() + de2;
        }
        Boolean ad2 = operation.ad();
        try {
            qwVar.th().execSQL(de2.rg(), de2.th());
            if (Boolean.TRUE.equals(ad2)) {
                qwVar.f8784th = true;
            }
            if (Boolean.FALSE.equals(ad2)) {
                qwVar.f8784th = false;
            }
            return true;
        } catch (Exception e) {
            aaa(e, operation, qwVar);
            if (Boolean.FALSE.equals(ad2)) {
                qwVar.f8784th = false;
            }
            return false;
        } catch (Throwable th2) {
            if (Boolean.FALSE.equals(ad2)) {
                qwVar.f8784th = false;
            }
            throw th2;
        }
    }
}
