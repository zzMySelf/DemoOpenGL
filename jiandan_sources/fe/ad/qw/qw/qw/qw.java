package fe.ad.qw.qw.qw;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/arouter/service/autowired")
public class qw implements AutowiredService {

    /* renamed from: ad  reason: collision with root package name */
    public List<String> f1216ad;
    public LruCache<String, ISyringe> qw;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.alibaba.android.arouter.facade.template.ISyringe} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.alibaba.android.arouter.facade.template.ISyringe ad(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getName()
            java.util.List<java.lang.String> r1 = r3.f1216ad     // Catch:{ Exception -> 0x0045 }
            boolean r1 = r1.contains(r0)     // Catch:{ Exception -> 0x0045 }
            if (r1 != 0) goto L_0x004a
            android.util.LruCache<java.lang.String, com.alibaba.android.arouter.facade.template.ISyringe> r1 = r3.qw     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0045 }
            com.alibaba.android.arouter.facade.template.ISyringe r1 = (com.alibaba.android.arouter.facade.template.ISyringe) r1     // Catch:{ Exception -> 0x0045 }
            if (r1 != 0) goto L_0x003f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0045 }
            r1.<init>()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0045 }
            r1.append(r4)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r4 = "$$ARouter$$Autowired"
            r1.append(r4)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0045 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x0045 }
            r1 = 0
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0045 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r4 = r4.newInstance(r1)     // Catch:{ Exception -> 0x0045 }
            r1 = r4
            com.alibaba.android.arouter.facade.template.ISyringe r1 = (com.alibaba.android.arouter.facade.template.ISyringe) r1     // Catch:{ Exception -> 0x0045 }
        L_0x003f:
            android.util.LruCache<java.lang.String, com.alibaba.android.arouter.facade.template.ISyringe> r4 = r3.qw     // Catch:{ Exception -> 0x0045 }
            r4.put(r0, r1)     // Catch:{ Exception -> 0x0045 }
            return r1
        L_0x0045:
            java.util.List<java.lang.String> r4 = r3.f1216ad
            r4.add(r0)
        L_0x004a:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.qw.qw.ad(java.lang.Class):com.alibaba.android.arouter.facade.template.ISyringe");
    }

    public void autowire(Object obj) {
        qw(obj, (Class<?>) null);
    }

    public void init(Context context) {
        this.qw = new LruCache<>(50);
        this.f1216ad = new ArrayList();
    }

    public final void qw(Object obj, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        ISyringe ad2 = ad(cls);
        if (ad2 != null) {
            ad2.inject(obj);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && !superclass.getName().startsWith(SapiDeviceInfo.OS_TYPE)) {
            qw(obj, superclass);
        }
    }
}
