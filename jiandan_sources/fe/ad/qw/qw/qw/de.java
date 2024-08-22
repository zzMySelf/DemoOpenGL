package fe.ad.qw.qw.qw;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import fe.ad.qw.qw.fe.rg;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadPoolExecutor;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static ThreadPoolExecutor f1209ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f1210de;
    public static Context qw;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.qw.de.qw.<clinit>():void");
        }
    }

    public static Postcard ad(String str) {
        RouteMeta routeMeta = fe.f1213fe.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0079, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0099, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("ARouter::Fatal exception when loading group meta. [" + r12.getMessage() + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x017e, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        fe.ad.qw.qw.ad.qw.f1186de.error(com.alibaba.android.arouter.facade.template.ILogger.defaultTag, "Init provider failed!", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x018f, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("Init provider failed!");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0022, B:39:0x0165] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void de(com.alibaba.android.arouter.facade.Postcard r12) {
        /*
            java.lang.Class<fe.ad.qw.qw.qw.de> r0 = fe.ad.qw.qw.qw.de.class
            monitor-enter(r0)
            if (r12 == 0) goto L_0x019a
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r1 = fe.ad.qw.qw.qw.fe.f1211ad     // Catch:{ all -> 0x0198 }
            java.lang.String r2 = r12.getPath()     // Catch:{ all -> 0x0198 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0198 }
            com.alibaba.android.arouter.facade.model.RouteMeta r1 = (com.alibaba.android.arouter.facade.model.RouteMeta) r1     // Catch:{ all -> 0x0198 }
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 != 0) goto L_0x00c6
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r1 = fe.ad.qw.qw.qw.fe.qw     // Catch:{ all -> 0x0198 }
            java.lang.String r5 = r12.getGroup()     // Catch:{ all -> 0x0198 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0198 }
            if (r1 == 0) goto L_0x009a
            boolean r1 = fe.ad.qw.qw.ad.qw.ad()     // Catch:{ Exception -> 0x0079 }
            if (r1 == 0) goto L_0x0047
            com.alibaba.android.arouter.facade.template.ILogger r1 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x0079 }
            java.lang.String r5 = "ARouter::"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r7 = "The group [%s] starts loading, trigger by [%s]"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0079 }
            java.lang.String r9 = r12.getGroup()     // Catch:{ Exception -> 0x0079 }
            r8[r4] = r9     // Catch:{ Exception -> 0x0079 }
            java.lang.String r9 = r12.getPath()     // Catch:{ Exception -> 0x0079 }
            r8[r2] = r9     // Catch:{ Exception -> 0x0079 }
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch:{ Exception -> 0x0079 }
            r1.debug(r5, r6)     // Catch:{ Exception -> 0x0079 }
        L_0x0047:
            java.lang.String r1 = r12.getGroup()     // Catch:{ Exception -> 0x0079 }
            r5 = 0
            qw(r1, r5)     // Catch:{ Exception -> 0x0079 }
            boolean r1 = fe.ad.qw.qw.ad.qw.ad()     // Catch:{ Exception -> 0x0079 }
            if (r1 == 0) goto L_0x0074
            com.alibaba.android.arouter.facade.template.ILogger r1 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x0079 }
            java.lang.String r5 = "ARouter::"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r7 = "The group [%s] has already been loaded, trigger by [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0079 }
            java.lang.String r8 = r12.getGroup()     // Catch:{ Exception -> 0x0079 }
            r3[r4] = r8     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = r12.getPath()     // Catch:{ Exception -> 0x0079 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0079 }
            java.lang.String r2 = java.lang.String.format(r6, r7, r3)     // Catch:{ Exception -> 0x0079 }
            r1.debug(r5, r2)     // Catch:{ Exception -> 0x0079 }
        L_0x0074:
            de(r12)     // Catch:{ all -> 0x0198 }
            goto L_0x0196
        L_0x0079:
            r12 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x0198 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r2.<init>()     // Catch:{ all -> 0x0198 }
            java.lang.String r3 = "ARouter::Fatal exception when loading group meta. ["
            r2.append(r3)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0198 }
            r2.append(r12)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0198 }
            r1.<init>(r12)     // Catch:{ all -> 0x0198 }
            throw r1     // Catch:{ all -> 0x0198 }
        L_0x009a:
            com.alibaba.android.arouter.exception.NoRouteFoundException r1 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x0198 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r2.<init>()     // Catch:{ all -> 0x0198 }
            java.lang.String r3 = "ARouter::There is no route match the path ["
            r2.append(r3)     // Catch:{ all -> 0x0198 }
            java.lang.String r3 = r12.getPath()     // Catch:{ all -> 0x0198 }
            r2.append(r3)     // Catch:{ all -> 0x0198 }
            java.lang.String r3 = "], in group ["
            r2.append(r3)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = r12.getGroup()     // Catch:{ all -> 0x0198 }
            r2.append(r12)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x0198 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0198 }
            r1.<init>(r12)     // Catch:{ all -> 0x0198 }
            throw r1     // Catch:{ all -> 0x0198 }
        L_0x00c6:
            java.lang.Class r5 = r1.getDestination()     // Catch:{ all -> 0x0198 }
            r12.setDestination(r5)     // Catch:{ all -> 0x0198 }
            com.alibaba.android.arouter.facade.enums.RouteType r5 = r1.getType()     // Catch:{ all -> 0x0198 }
            r12.setType(r5)     // Catch:{ all -> 0x0198 }
            int r5 = r1.getPriority()     // Catch:{ all -> 0x0198 }
            r12.setPriority(r5)     // Catch:{ all -> 0x0198 }
            int r5 = r1.getExtra()     // Catch:{ all -> 0x0198 }
            r12.setExtra(r5)     // Catch:{ all -> 0x0198 }
            android.net.Uri r5 = r12.getUri()     // Catch:{ all -> 0x0198 }
            if (r5 == 0) goto L_0x0142
            java.util.Map r6 = fe.ad.qw.qw.fe.rg.de(r5)     // Catch:{ all -> 0x0198 }
            java.util.Map r7 = r1.getParamsType()     // Catch:{ all -> 0x0198 }
            boolean r8 = fe.ad.qw.qw.fe.de.ad(r7)     // Catch:{ all -> 0x0198 }
            if (r8 == 0) goto L_0x0139
            java.util.Set r8 = r7.entrySet()     // Catch:{ all -> 0x0198 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0198 }
        L_0x00fe:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0198 }
            if (r9 == 0) goto L_0x0124
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0198 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x0198 }
            java.lang.Object r10 = r9.getValue()     // Catch:{ all -> 0x0198 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0198 }
            java.lang.Object r11 = r9.getKey()     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0198 }
            java.lang.Object r9 = r9.getKey()     // Catch:{ all -> 0x0198 }
            java.lang.Object r9 = r6.get(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0198 }
            th(r12, r10, r11, r9)     // Catch:{ all -> 0x0198 }
            goto L_0x00fe
        L_0x0124:
            android.os.Bundle r6 = r12.getExtras()     // Catch:{ all -> 0x0198 }
            java.lang.String r8 = "wmHzgD4lOj5o4241"
            java.util.Set r7 = r7.keySet()     // Catch:{ all -> 0x0198 }
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x0198 }
            java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x0198 }
            r6.putStringArray(r8, r7)     // Catch:{ all -> 0x0198 }
        L_0x0139:
            java.lang.String r6 = "NTeRQWvye18AkPd6G"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0198 }
            r12.withString(r6, r5)     // Catch:{ all -> 0x0198 }
        L_0x0142:
            int[] r5 = fe.ad.qw.qw.qw.de.qw.qw     // Catch:{ all -> 0x0198 }
            com.alibaba.android.arouter.facade.enums.RouteType r6 = r1.getType()     // Catch:{ all -> 0x0198 }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x0198 }
            r5 = r5[r6]     // Catch:{ all -> 0x0198 }
            if (r5 == r2) goto L_0x0157
            if (r5 == r3) goto L_0x0153
            goto L_0x0196
        L_0x0153:
            r12.greenChannel()     // Catch:{ all -> 0x0198 }
            goto L_0x0196
        L_0x0157:
            java.lang.Class r1 = r1.getDestination()     // Catch:{ all -> 0x0198 }
            java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r2 = fe.ad.qw.qw.qw.fe.f1212de     // Catch:{ all -> 0x0198 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0198 }
            com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ all -> 0x0198 }
            if (r2 != 0) goto L_0x0190
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x017e }
            java.lang.reflect.Constructor r2 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x017e }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x017e }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x017e }
            com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ Exception -> 0x017e }
            android.content.Context r3 = qw     // Catch:{ Exception -> 0x017e }
            r2.init(r3)     // Catch:{ Exception -> 0x017e }
            java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r3 = fe.ad.qw.qw.qw.fe.f1212de     // Catch:{ Exception -> 0x017e }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x017e }
            goto L_0x0190
        L_0x017e:
            r12 = move-exception
            com.alibaba.android.arouter.facade.template.ILogger r1 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ all -> 0x0198 }
            java.lang.String r2 = "ARouter::"
            java.lang.String r3 = "Init provider failed!"
            r1.error(r2, r3, r12)     // Catch:{ all -> 0x0198 }
            com.alibaba.android.arouter.exception.HandlerException r12 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x0198 }
            java.lang.String r1 = "Init provider failed!"
            r12.<init>(r1)     // Catch:{ all -> 0x0198 }
            throw r12     // Catch:{ all -> 0x0198 }
        L_0x0190:
            r12.setProvider(r2)     // Catch:{ all -> 0x0198 }
            r12.greenChannel()     // Catch:{ all -> 0x0198 }
        L_0x0196:
            monitor-exit(r0)
            return
        L_0x0198:
            r12 = move-exception
            goto L_0x01a2
        L_0x019a:
            com.alibaba.android.arouter.exception.NoRouteFoundException r12 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x0198 }
            java.lang.String r1 = "ARouter::No postcard!"
            r12.<init>(r1)     // Catch:{ all -> 0x0198 }
            throw r12     // Catch:{ all -> 0x0198 }
        L_0x01a2:
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.qw.de.de(com.alibaba.android.arouter.facade.Postcard):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b4 A[Catch:{ Exception -> 0x018f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void fe(android.content.Context r8, java.util.concurrent.ThreadPoolExecutor r9) throws com.alibaba.android.arouter.exception.HandlerException {
        /*
            java.lang.Class<fe.ad.qw.qw.qw.de> r0 = fe.ad.qw.qw.qw.de.class
            monitor-enter(r0)
            qw = r8     // Catch:{ all -> 0x01b0 }
            f1209ad = r9     // Catch:{ all -> 0x01b0 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x018f }
            rg()     // Catch:{ Exception -> 0x018f }
            boolean r9 = f1210de     // Catch:{ Exception -> 0x018f }
            r3 = 0
            if (r9 == 0) goto L_0x001e
            com.alibaba.android.arouter.facade.template.ILogger r8 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r9 = "ARouter::"
            java.lang.String r4 = "Load router map by arouter-auto-register plugin."
            r8.info(r9, r4)     // Catch:{ Exception -> 0x018f }
            goto L_0x011a
        L_0x001e:
            boolean r9 = fe.ad.qw.qw.ad.qw.ad()     // Catch:{ Exception -> 0x018f }
            if (r9 != 0) goto L_0x004b
            boolean r9 = fe.ad.qw.qw.fe.fe.ad(r8)     // Catch:{ Exception -> 0x018f }
            if (r9 == 0) goto L_0x002b
            goto L_0x004b
        L_0x002b:
            com.alibaba.android.arouter.facade.template.ILogger r9 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Load router map from cache."
            r9.info(r4, r5)     // Catch:{ Exception -> 0x018f }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "SP_AROUTER_CACHE"
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "ROUTER_MAP"
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ Exception -> 0x018f }
            r5.<init>()     // Catch:{ Exception -> 0x018f }
            java.util.Set r8 = r8.getStringSet(r4, r5)     // Catch:{ Exception -> 0x018f }
            r9.<init>(r8)     // Catch:{ Exception -> 0x018f }
            goto L_0x0078
        L_0x004b:
            com.alibaba.android.arouter.facade.template.ILogger r9 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Run with debug mode or new install, rebuild router map."
            r9.info(r4, r5)     // Catch:{ Exception -> 0x018f }
            android.content.Context r9 = qw     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "com.alibaba.android.arouter.routes"
            java.util.Set r9 = fe.ad.qw.qw.fe.qw.qw(r9, r4)     // Catch:{ Exception -> 0x018f }
            boolean r4 = r9.isEmpty()     // Catch:{ Exception -> 0x018f }
            if (r4 != 0) goto L_0x0075
            java.lang.String r4 = "SP_AROUTER_CACHE"
            android.content.SharedPreferences r4 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x018f }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x018f }
            java.lang.String r5 = "ROUTER_MAP"
            android.content.SharedPreferences$Editor r4 = r4.putStringSet(r5, r9)     // Catch:{ Exception -> 0x018f }
            r4.apply()     // Catch:{ Exception -> 0x018f }
        L_0x0075:
            fe.ad.qw.qw.fe.fe.de(r8)     // Catch:{ Exception -> 0x018f }
        L_0x0078:
            com.alibaba.android.arouter.facade.template.ILogger r8 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "ARouter::"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018f }
            r5.<init>()     // Catch:{ Exception -> 0x018f }
            java.lang.String r6 = "Find router map finished, map size = "
            r5.append(r6)     // Catch:{ Exception -> 0x018f }
            int r6 = r9.size()     // Catch:{ Exception -> 0x018f }
            r5.append(r6)     // Catch:{ Exception -> 0x018f }
            java.lang.String r6 = ", cost "
            r5.append(r6)     // Catch:{ Exception -> 0x018f }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x018f }
            long r6 = r6 - r1
            r5.append(r6)     // Catch:{ Exception -> 0x018f }
            java.lang.String r1 = " ms."
            r5.append(r1)     // Catch:{ Exception -> 0x018f }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x018f }
            r8.info(r4, r1)     // Catch:{ Exception -> 0x018f }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x018f }
            java.util.Iterator r8 = r9.iterator()     // Catch:{ Exception -> 0x018f }
        L_0x00ae:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x018f }
            if (r9 == 0) goto L_0x011a
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x018f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x018f }
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Root"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x018f }
            if (r4 == 0) goto L_0x00da
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x018f }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x018f }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x018f }
            com.alibaba.android.arouter.facade.template.IRouteRoot r9 = (com.alibaba.android.arouter.facade.template.IRouteRoot) r9     // Catch:{ Exception -> 0x018f }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r4 = fe.ad.qw.qw.qw.fe.qw     // Catch:{ Exception -> 0x018f }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x018f }
            goto L_0x00ae
        L_0x00da:
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Interceptors"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x018f }
            if (r4 == 0) goto L_0x00fa
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x018f }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x018f }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x018f }
            com.alibaba.android.arouter.facade.template.IInterceptorGroup r9 = (com.alibaba.android.arouter.facade.template.IInterceptorGroup) r9     // Catch:{ Exception -> 0x018f }
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r4 = fe.ad.qw.qw.qw.fe.f1214rg     // Catch:{ Exception -> 0x018f }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x018f }
            goto L_0x00ae
        L_0x00fa:
            java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Providers"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x018f }
            if (r4 == 0) goto L_0x00ae
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x018f }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x018f }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x018f }
            java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x018f }
            com.alibaba.android.arouter.facade.template.IProviderGroup r9 = (com.alibaba.android.arouter.facade.template.IProviderGroup) r9     // Catch:{ Exception -> 0x018f }
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r4 = fe.ad.qw.qw.qw.fe.f1213fe     // Catch:{ Exception -> 0x018f }
            r9.loadInto(r4)     // Catch:{ Exception -> 0x018f }
            goto L_0x00ae
        L_0x011a:
            com.alibaba.android.arouter.facade.template.ILogger r8 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r9 = "ARouter::"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018f }
            r4.<init>()     // Catch:{ Exception -> 0x018f }
            java.lang.String r5 = "Load root element finished, cost "
            r4.append(r5)     // Catch:{ Exception -> 0x018f }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x018f }
            long r5 = r5 - r1
            r4.append(r5)     // Catch:{ Exception -> 0x018f }
            java.lang.String r1 = " ms."
            r4.append(r1)     // Catch:{ Exception -> 0x018f }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x018f }
            r8.info(r9, r1)     // Catch:{ Exception -> 0x018f }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r8 = fe.ad.qw.qw.qw.fe.qw     // Catch:{ Exception -> 0x018f }
            int r8 = r8.size()     // Catch:{ Exception -> 0x018f }
            if (r8 != 0) goto L_0x014d
            com.alibaba.android.arouter.facade.template.ILogger r8 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r9 = "ARouter::"
            java.lang.String r1 = "No mapping files were found, check your configuration please!"
            r8.error(r9, r1)     // Catch:{ Exception -> 0x018f }
        L_0x014d:
            boolean r8 = fe.ad.qw.qw.ad.qw.ad()     // Catch:{ Exception -> 0x018f }
            if (r8 == 0) goto L_0x018d
            com.alibaba.android.arouter.facade.template.ILogger r8 = fe.ad.qw.qw.ad.qw.f1186de     // Catch:{ Exception -> 0x018f }
            java.lang.String r9 = "ARouter::"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x018f }
            java.lang.String r2 = "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x018f }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r5 = fe.ad.qw.qw.qw.fe.qw     // Catch:{ Exception -> 0x018f }
            int r5 = r5.size()     // Catch:{ Exception -> 0x018f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x018f }
            r4[r3] = r5     // Catch:{ Exception -> 0x018f }
            r3 = 1
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r5 = fe.ad.qw.qw.qw.fe.f1214rg     // Catch:{ Exception -> 0x018f }
            int r5 = r5.size()     // Catch:{ Exception -> 0x018f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x018f }
            r4[r3] = r5     // Catch:{ Exception -> 0x018f }
            r3 = 2
            java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r5 = fe.ad.qw.qw.qw.fe.f1213fe     // Catch:{ Exception -> 0x018f }
            int r5 = r5.size()     // Catch:{ Exception -> 0x018f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x018f }
            r4[r3] = r5     // Catch:{ Exception -> 0x018f }
            java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x018f }
            r8.debug(r9, r1)     // Catch:{ Exception -> 0x018f }
        L_0x018d:
            monitor-exit(r0)
            return
        L_0x018f:
            r8 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r9 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r1.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r2 = "ARouter::ARouter init logistics center exception! ["
            r1.append(r2)     // Catch:{ all -> 0x01b0 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x01b0 }
            r1.append(r8)     // Catch:{ all -> 0x01b0 }
            java.lang.String r8 = "]"
            r1.append(r8)     // Catch:{ all -> 0x01b0 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x01b0 }
            r9.<init>(r8)     // Catch:{ all -> 0x01b0 }
            throw r9     // Catch:{ all -> 0x01b0 }
        L_0x01b0:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.qw.de.fe(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    public static synchronized void qw(String str, IRouteGroup iRouteGroup) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        synchronized (de.class) {
            if (fe.qw.containsKey(str)) {
                ((IRouteGroup) fe.qw.get(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(fe.f1211ad);
                fe.qw.remove(str);
            }
            if (iRouteGroup != null) {
                iRouteGroup.loadInto(fe.f1211ad);
            }
        }
    }

    public static void rg() {
        f1210de = false;
    }

    public static void th(Postcard postcard, Integer num, String str, String str2) {
        if (!rg.ad(str) && !rg.ad(str2)) {
            if (num != null) {
                try {
                    if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                        postcard.withBoolean(str, Boolean.parseBoolean(str2));
                    } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                        postcard.withByte(str, Byte.parseByte(str2));
                    } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                        postcard.withShort(str, Short.parseShort(str2));
                    } else if (num.intValue() == TypeKind.INT.ordinal()) {
                        postcard.withInt(str, Integer.parseInt(str2));
                    } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                        postcard.withLong(str, Long.parseLong(str2));
                    } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                        postcard.withFloat(str, Float.parseFloat(str2));
                    } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                        postcard.withDouble(str, Double.parseDouble(str2));
                    } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                        postcard.withString(str, str2);
                    } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                        if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                            postcard.withString(str, str2);
                        } else {
                            postcard.withString(str, str2);
                        }
                    }
                } catch (Throwable th2) {
                    ILogger iLogger = fe.ad.qw.qw.ad.qw.f1186de;
                    iLogger.warning(ILogger.defaultTag, "LogisticsCenter setValue failed! " + th2.getMessage());
                }
            } else {
                postcard.withString(str, str2);
            }
        }
    }
}
