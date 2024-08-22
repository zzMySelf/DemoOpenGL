package a.a.a.a.a;

import a.a.a.a.c.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.baidu.location.provider.NetworkDataProvider;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class a implements a.a.a.a.c.a {

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f1165c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1166d = false;

    /* renamed from: e  reason: collision with root package name */
    public Deque<String> f1167e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public Deque<String> f1168f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public Deque<String> f1169g = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public int f1170h = 5;

    /* renamed from: i  reason: collision with root package name */
    public int f1171i = 5;

    /* renamed from: j  reason: collision with root package name */
    public int f1172j = 1;
    public int k = 1;

    /* renamed from: a.a.a.a.a.a$a  reason: collision with other inner class name */
    public static class C0000a {

        /* renamed from: a  reason: collision with root package name */
        public static a f1173a = new a();
    }

    public static a b() {
        return C0000a.f1173a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r5 = this;
            int r0 = r5.k
            r1 = 1
            java.lang.String r2 = ""
            if (r0 != r1) goto L_0x0027
            java.util.Deque<java.lang.String> r0 = r5.f1169g
            java.lang.String r0 = r5.b(r0)
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "&ll_pre="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            goto L_0x0028
        L_0x0027:
            r0 = r2
        L_0x0028:
            int r3 = r5.f1172j
            if (r3 != r1) goto L_0x0072
            java.util.Deque<java.lang.String> r1 = r5.f1167e
            java.lang.String r1 = r5.a((java.util.Deque<java.lang.String>) r1)
            boolean r3 = r2.equals(r1)
            if (r3 != 0) goto L_0x004f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = "&cl_pre="
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x004f:
            java.util.Deque<java.lang.String> r1 = r5.f1168f
            java.lang.String r1 = r5.a((java.util.Deque<java.lang.String>) r1)
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0072
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = "&wf_pre="
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0072:
            boolean r1 = a.a.a.a.c.a.f1201a
            if (r1 == 0) goto L_0x0094
            boolean r1 = a.a.a.a.c.a.f1202b
            if (r1 == 0) goto L_0x0094
            com.baidu.location.provider.KeyEventListener r1 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ContinuousLocManager getCacheData: cacheData = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.setLog(r2)
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.a():java.lang.String");
    }

    public final String a(Deque<String> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String peekFirst = deque.peekFirst();
        if (peekFirst != null) {
            String[] split = peekFirst.split(",");
            int i2 = 0;
            for (String next : deque) {
                if (split.length != 3) {
                    break;
                }
                String[] split2 = next.split(",");
                if (i2 == 0) {
                    sb.append(peekFirst);
                } else if (split2.length != 3) {
                    i2++;
                } else {
                    try {
                        sb.append((int) ((Double.parseDouble(split[0]) - Double.parseDouble(split2[0])) * Math.pow(10.0d, 6.0d))).append(",").append((int) (Math.pow(10.0d, 6.0d) * (Double.parseDouble(split[1]) - Double.parseDouble(split2[1])))).append(",").append(Long.parseLong(split[2]) - Long.parseLong(split2[2]));
                    } catch (Exception e2) {
                        if (a.a.a.a.c.a.f1201a) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (i2 != deque.size() - 1) {
                    sb.append("|");
                }
                i2++;
            }
        }
        if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
            NetworkDataProvider.getListener().setLog("ContinuousLocManager format2Log: format data: " + sb.toString());
        }
        return sb.toString();
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f1172j = i2;
        this.k = i3;
        this.f1170h = i4;
        this.f1171i = i5;
    }

    public void a(Context context) {
        if (this.f1165c == null) {
            this.f1165c = b.a().a(context);
        }
        SharedPreferences sharedPreferences = this.f1165c;
        if (sharedPreferences != null && !this.f1166d) {
            try {
                String string = sharedPreferences.getString("cl_pre", "");
                String string2 = this.f1165c.getString("wf_pre", "");
                String string3 = this.f1165c.getString("ll_pre", "");
                b(string, this.f1167e);
                b(string2, this.f1168f);
                a(string3, this.f1169g);
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog("ContinuousLocManager queue has init");
                }
            } catch (Exception e2) {
                if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                    NetworkDataProvider.getListener().setLog("ContinuousLocManagerget data from SharedPreferences error.");
                }
            }
            this.f1166d = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01ad, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01b2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.baidu.location.provider.NetworkDataProvider.FormatLocation r10, java.lang.String r11, android.location.Location r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r10 == 0) goto L_0x01b1
            java.lang.String r0 = "gcj02"
            boolean r11 = r0.equals(r11)     // Catch:{ all -> 0x01ae }
            if (r11 != 0) goto L_0x000d
            goto L_0x01b1
        L_0x000d:
            java.lang.String r11 = r10.getNetworkLocationType()     // Catch:{ all -> 0x01ae }
            int r0 = r10.getLocType()     // Catch:{ all -> 0x01ae }
            r1 = 61
            if (r0 == r1) goto L_0x001f
            r2 = 161(0xa1, float:2.26E-43)
            if (r0 == r2) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            if (r11 != 0) goto L_0x0024
            java.lang.String r11 = "null"
        L_0x0024:
            java.lang.String r2 = "wf"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x015c }
            r3 = 1
            if (r2 == 0) goto L_0x0072
            int r2 = r9.f1172j     // Catch:{ Exception -> 0x015c }
            if (r2 != r3) goto L_0x0072
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r11.<init>()     // Catch:{ Exception -> 0x015c }
            double r0 = r10.getLongitude()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            double r0 = r10.getLatitude()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.getTime()     // Catch:{ Exception -> 0x015c }
            long r0 = a.a.a.a.c.c.b((java.lang.String) r10)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r10 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r11 = r9.f1168f     // Catch:{ Exception -> 0x015c }
            r11.offerFirst(r10)     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r10 = r9.f1168f     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = "wf"
        L_0x006d:
            r9.a((java.util.Deque<java.lang.String>) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x015c }
            goto L_0x0164
        L_0x0072:
            java.lang.String r2 = "cl"
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x015c }
            if (r11 == 0) goto L_0x00b9
            int r11 = r9.f1172j     // Catch:{ Exception -> 0x015c }
            if (r11 != r3) goto L_0x00b9
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r11.<init>()     // Catch:{ Exception -> 0x015c }
            double r0 = r10.getLongitude()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            double r0 = r10.getLatitude()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.getTime()     // Catch:{ Exception -> 0x015c }
            long r0 = a.a.a.a.c.c.b((java.lang.String) r10)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r10 = r11.append(r0)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r11 = r9.f1167e     // Catch:{ Exception -> 0x015c }
            r11.offerFirst(r10)     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r10 = r9.f1167e     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = "cl"
            goto L_0x006d
        L_0x00b9:
            if (r0 != r1) goto L_0x0164
            int r11 = r9.k     // Catch:{ Exception -> 0x015c }
            if (r11 != r3) goto L_0x0164
            if (r12 == 0) goto L_0x0164
            float r11 = r10.getRadius()     // Catch:{ Exception -> 0x015c }
            int r11 = (int) r11     // Catch:{ Exception -> 0x015c }
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x015c }
            java.lang.String r1 = "0.00"
            r0.<init>(r1)     // Catch:{ Exception -> 0x015c }
            java.text.DecimalFormat r1 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x015c }
            java.lang.String r2 = "0.0"
            r1.<init>(r2)     // Catch:{ Exception -> 0x015c }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x015c }
            java.lang.String r3 = "0.000000"
            r2.<init>(r3)     // Catch:{ Exception -> 0x015c }
            double r3 = r12.getLongitude()     // Catch:{ Exception -> 0x015c }
            double r5 = r12.getLatitude()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015c }
            r12.<init>()     // Catch:{ Exception -> 0x015c }
            int r7 = r10.getSatelliteNumber()     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r12 = r12.append(r7)     // Catch:{ Exception -> 0x015c }
            java.lang.String r7 = ","
            java.lang.StringBuilder r12 = r12.append(r7)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r12.append(r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            double r7 = r10.getAltitude()     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = r0.format(r7)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = r10.getTime()     // Catch:{ Exception -> 0x015c }
            long r7 = a.a.a.a.c.c.b((java.lang.String) r12)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r11 = r11.append(r7)     // Catch:{ Exception -> 0x015c }
            java.lang.String r12 = ","
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x015c }
            float r10 = r10.getSpeed()     // Catch:{ Exception -> 0x015c }
            double r7 = (double) r10     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r1.format(r7)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = ","
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = r2.format(r3)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = ","
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r11 = r2.format(r5)     // Catch:{ Exception -> 0x015c }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Exception -> 0x015c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r11 = r9.f1169g     // Catch:{ Exception -> 0x015c }
            r11.offerFirst(r10)     // Catch:{ Exception -> 0x015c }
            java.util.Deque<java.lang.String> r10 = r9.f1169g     // Catch:{ Exception -> 0x015c }
            r9.c(r10)     // Catch:{ Exception -> 0x015c }
            goto L_0x0164
        L_0x015c:
            r10 = move-exception
            boolean r11 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x01ae }
            if (r11 == 0) goto L_0x0164
            r10.printStackTrace()     // Catch:{ all -> 0x01ae }
        L_0x0164:
            boolean r10 = a.a.a.a.c.a.f1201a     // Catch:{ all -> 0x01ae }
            if (r10 == 0) goto L_0x01ac
            boolean r10 = a.a.a.a.c.a.f1202b     // Catch:{ all -> 0x01ae }
            if (r10 == 0) goto L_0x01ac
            com.baidu.location.provider.KeyEventListener r10 = com.baidu.location.provider.NetworkDataProvider.getListener()     // Catch:{ all -> 0x01ae }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ae }
            r11.<init>()     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = "ContinuousLocManager set cache data:\nwf_pre: "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.util.Deque<java.lang.String> r12 = r9.f1168f     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01ae }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = "\ncl_pre: "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.util.Deque<java.lang.String> r12 = r9.f1167e     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01ae }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = "\nll_pre: "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.util.Deque<java.lang.String> r12 = r9.f1169g     // Catch:{ all -> 0x01ae }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01ae }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x01ae }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01ae }
            r10.setLog(r11)     // Catch:{ all -> 0x01ae }
        L_0x01ac:
            monitor-exit(r9)
            return
        L_0x01ae:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x01b1:
            monitor-exit(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.a(com.baidu.location.provider.NetworkDataProvider$FormatLocation, java.lang.String, android.location.Location):void");
    }

    public final void a(String str, Deque<String> deque) {
        if (str != null && !"".equals(str)) {
            String str2 = new String(Base64.decode(str.getBytes(), 0));
            deque.addAll(Arrays.asList(str2.split("\\|")));
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("ContinuousLocManager updateGpsQueue\nlocation string: " + str2);
            }
        }
    }

    public final void a(Deque<String> deque, String str) {
        if (deque != null && !deque.isEmpty()) {
            while (deque.size() > this.f1170h) {
                deque.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String append : deque) {
                sb.append(append);
                if (i2 != deque.size() - 1) {
                    sb.append("|");
                }
                i2++;
            }
            try {
                String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
                SharedPreferences.Editor edit = this.f1165c.edit();
                edit.putString(str + "_pre", str2);
                edit.commit();
            } catch (Exception e2) {
                if (a.a.a.a.c.a.f1201a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0123 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.util.Deque<java.lang.String> r19) {
        /*
            r18 = this;
            if (r19 == 0) goto L_0x0153
            boolean r0 = r19.isEmpty()
            if (r0 == 0) goto L_0x000a
            goto L_0x0153
        L_0x000a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Object r0 = r19.peekFirst()
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0128
            java.lang.String r3 = ","
            java.lang.String[] r4 = r2.split(r3)
            java.util.Iterator r5 = r19.iterator()
            r6 = 0
            r7 = r6
        L_0x0024:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0128
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            int r8 = r4.length
            r9 = 7
            if (r8 == r9) goto L_0x0036
            goto L_0x0128
        L_0x0036:
            java.lang.String[] r0 = r0.split(r3)
            r8 = 1
            if (r7 != 0) goto L_0x0043
            r1.append(r2)
            r15 = r7
            goto L_0x0115
        L_0x0043:
            int r10 = r0.length
            if (r10 == r9) goto L_0x0049
            r6 = r7
            goto L_0x0123
        L_0x0049:
            r9 = r4[r6]     // Catch:{ Exception -> 0x010c }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x010c }
            r10 = r0[r6]     // Catch:{ Exception -> 0x010c }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x010c }
            int r9 = r9 - r10
            java.lang.StringBuilder r9 = r1.append(r9)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r3)     // Catch:{ Exception -> 0x010c }
            r10 = r4[r8]     // Catch:{ Exception -> 0x010c }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x010c }
            r11 = r0[r8]     // Catch:{ Exception -> 0x010c }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x010c }
            int r10 = r10 - r11
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r3)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r11 = 2
            r12 = r4[r11]     // Catch:{ Exception -> 0x010c }
            r10.<init>(r12)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r12 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r11 = r0[r11]     // Catch:{ Exception -> 0x010c }
            r12.<init>(r11)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r10 = r10.subtract(r12)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r3)     // Catch:{ Exception -> 0x010c }
            r10 = 3
            r11 = r4[r10]     // Catch:{ Exception -> 0x010c }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x010c }
            r10 = r0[r10]     // Catch:{ Exception -> 0x010c }
            long r13 = java.lang.Long.parseLong(r10)     // Catch:{ Exception -> 0x010c }
            long r11 = r11 - r13
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r3)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r11 = 4
            r12 = r4[r11]     // Catch:{ Exception -> 0x010c }
            r10.<init>(r12)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r12 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r11 = r0[r11]     // Catch:{ Exception -> 0x010c }
            r12.<init>(r11)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r10 = r10.subtract(r12)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x010c }
            r9.append(r3)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r9 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r10 = 5
            r11 = r4[r10]     // Catch:{ Exception -> 0x010c }
            r9.<init>(r11)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r11 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r10 = r0[r10]     // Catch:{ Exception -> 0x010c }
            r11.<init>(r10)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r9 = r9.subtract(r11)     // Catch:{ Exception -> 0x010c }
            double r9 = r9.doubleValue()     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r11 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r12 = 6
            r13 = r4[r12]     // Catch:{ Exception -> 0x010c }
            r11.<init>(r13)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r13 = new java.math.BigDecimal     // Catch:{ Exception -> 0x010c }
            r0 = r0[r12]     // Catch:{ Exception -> 0x010c }
            r13.<init>(r0)     // Catch:{ Exception -> 0x010c }
            java.math.BigDecimal r0 = r11.subtract(r13)     // Catch:{ Exception -> 0x010c }
            double r11 = r0.doubleValue()     // Catch:{ Exception -> 0x010c }
            r13 = 4618441417868443648(0x4018000000000000, double:6.0)
            r15 = r7
            r6 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r16 = java.lang.Math.pow(r6, r13)     // Catch:{ Exception -> 0x010a }
            double r9 = r9 * r16
            int r0 = (int) r9     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ Exception -> 0x010a }
            double r6 = java.lang.Math.pow(r6, r13)     // Catch:{ Exception -> 0x010a }
            double r11 = r11 * r6
            int r6 = (int) r11     // Catch:{ Exception -> 0x010a }
            r0.append(r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x0115
        L_0x010a:
            r0 = move-exception
            goto L_0x010e
        L_0x010c:
            r0 = move-exception
            r15 = r7
        L_0x010e:
            boolean r6 = a.a.a.a.c.a.f1201a
            if (r6 == 0) goto L_0x0115
            r0.printStackTrace()
        L_0x0115:
            int r0 = r19.size()
            int r0 = r0 - r8
            r6 = r15
            if (r6 == r0) goto L_0x0123
            java.lang.String r0 = "|"
            r1.append(r0)
        L_0x0123:
            int r7 = r6 + 1
            r6 = 0
            goto L_0x0024
        L_0x0128:
            boolean r0 = a.a.a.a.c.a.f1201a
            if (r0 == 0) goto L_0x014e
            boolean r0 = a.a.a.a.c.a.f1202b
            if (r0 == 0) goto L_0x014e
            com.baidu.location.provider.KeyEventListener r0 = com.baidu.location.provider.NetworkDataProvider.getListener()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ContinuousLocManager formatGps2Log: format data = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.setLog(r2)
        L_0x014e:
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0153:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.b(java.util.Deque):java.lang.String");
    }

    public final void b(String str, Deque<String> deque) {
        if (str != null && !"".equals(str)) {
            String str2 = new String(Base64.decode(str.getBytes(), 0));
            deque.addAll(Arrays.asList(str2.split("\\|")));
            if (a.a.a.a.c.a.f1201a && a.a.a.a.c.a.f1202b) {
                NetworkDataProvider.getListener().setLog("ContinuousLocManager update Queue\nlocation string: " + str2);
            }
        }
    }

    public final void c(Deque<String> deque) {
        if (deque != null && !deque.isEmpty()) {
            while (deque.size() > this.f1171i) {
                deque.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String append : deque) {
                sb.append(append);
                if (i2 != deque.size() - 1) {
                    sb.append("|");
                }
                i2++;
            }
            try {
                String str = new String(Base64.encode(sb.toString().getBytes(), 0));
                SharedPreferences.Editor edit = this.f1165c.edit();
                edit.putString("ll_pre", str);
                edit.commit();
            } catch (Exception e2) {
                if (a.a.a.a.c.a.f1201a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
