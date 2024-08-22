package p041if.uk;

import com.google.common.reflect.ClassPath;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: if.uk.th  reason: invalid package */
public class th {

    /* renamed from: th  reason: collision with root package name */
    public static final th f11354th = new th();

    /* renamed from: yj  reason: collision with root package name */
    public static final ad f11355yj = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<fe> f11356ad = new AtomicReference<>();

    /* renamed from: de  reason: collision with root package name */
    public final AtomicReference<Object> f11357de = new AtomicReference<>();

    /* renamed from: fe  reason: collision with root package name */
    public final AtomicReference<qw> f11358fe = new AtomicReference<>();
    public final AtomicReference<ad> qw = new AtomicReference<>();

    /* renamed from: rg  reason: collision with root package name */
    public final AtomicReference<yj> f11359rg = new AtomicReference<>();

    /* renamed from: if.uk.th$ad */
    public class ad extends qw {
        public ad(th thVar) {
        }
    }

    /* renamed from: if.uk.th$qw */
    public static class qw extends ad {
    }

    @Deprecated
    public static th de() {
        return f11354th;
    }

    public static Object rg(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION) && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 != null) {
                        property = property2;
                    } else {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e);
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e2);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e4);
        }
    }

    public ad ad() {
        if (this.qw.get() == null) {
            Object rg2 = rg(ad.class, System.getProperties());
            if (rg2 == null) {
                this.qw.compareAndSet((Object) null, f11355yj);
            } else {
                this.qw.compareAndSet((Object) null, (ad) rg2);
            }
        }
        return this.qw.get();
    }

    public fe fe() {
        if (this.f11356ad.get() == null) {
            Object rg2 = rg(fe.class, System.getProperties());
            if (rg2 == null) {
                this.f11356ad.compareAndSet((Object) null, rg.th());
            } else {
                this.f11356ad.compareAndSet((Object) null, (fe) rg2);
            }
        }
        return this.f11356ad.get();
    }

    public qw qw() {
        if (this.f11358fe.get() == null) {
            Object rg2 = rg(qw.class, System.getProperties());
            if (rg2 == null) {
                this.f11358fe.compareAndSet((Object) null, new ad(this));
            } else {
                this.f11358fe.compareAndSet((Object) null, (qw) rg2);
            }
        }
        return this.f11358fe.get();
    }

    public yj th() {
        if (this.f11359rg.get() == null) {
            Object rg2 = rg(yj.class, System.getProperties());
            if (rg2 == null) {
                this.f11359rg.compareAndSet((Object) null, yj.uk());
            } else {
                this.f11359rg.compareAndSet((Object) null, (yj) rg2);
            }
        }
        return this.f11359rg.get();
    }
}
