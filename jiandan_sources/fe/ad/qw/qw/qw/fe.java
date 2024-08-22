package fe.ad.qw.qw.qw;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static Map<String, RouteMeta> f1211ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public static Map<Class, IProvider> f1212de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public static Map<String, RouteMeta> f1213fe = new HashMap();
    public static Map<String, Class<? extends IRouteGroup>> qw = new HashMap();

    /* renamed from: rg  reason: collision with root package name */
    public static Map<Integer, Class<? extends IInterceptor>> f1214rg = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");

    /* renamed from: th  reason: collision with root package name */
    public static List<IInterceptor> f1215th = new ArrayList();
}
