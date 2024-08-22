package fe.rg.qw.o.fe;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.fe;
import fe.rg.qw.o.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class rg<Transcode> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Key> f4859ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public fe f4860de;

    /* renamed from: fe  reason: collision with root package name */
    public Object f4861fe;
    public yj ggg;

    /* renamed from: i  reason: collision with root package name */
    public ad f4862i;

    /* renamed from: if  reason: not valid java name */
    public boolean f184if;

    /* renamed from: o  reason: collision with root package name */
    public Map<Class<?>, Transformation<?>> f4863o;

    /* renamed from: pf  reason: collision with root package name */
    public Class<Transcode> f4864pf;
    public Priority ppp;
    public final List<ModelLoader.qw<?>> qw = new ArrayList();

    /* renamed from: rg  reason: collision with root package name */
    public int f4865rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f185switch;

    /* renamed from: th  reason: collision with root package name */
    public int f4866th;

    /* renamed from: uk  reason: collision with root package name */
    public DecodeJob.rg f4867uk;
    public boolean vvv;
    public Key when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public Class<?> f4868yj;

    public boolean aaa() {
        return this.xxx;
    }

    public ArrayPool ad() {
        return this.f4860de.ad();
    }

    public boolean ddd(Class<?> cls) {
        return uk(cls) != null;
    }

    public List<Key> de() {
        if (!this.f185switch) {
            this.f185switch = true;
            this.f4859ad.clear();
            List<ModelLoader.qw<?>> yj2 = yj();
            int size = yj2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.qw qwVar = yj2.get(i2);
                if (!this.f4859ad.contains(qwVar.qw)) {
                    this.f4859ad.add(qwVar.qw);
                }
                for (int i3 = 0; i3 < qwVar.f3708ad.size(); i3++) {
                    if (!this.f4859ad.contains(qwVar.f3708ad.get(i3))) {
                        this.f4859ad.add(qwVar.f3708ad.get(i3));
                    }
                }
            }
        }
        return this.f4859ad;
    }

    public DiskCache fe() {
        return this.f4867uk.qw();
    }

    public Class<?> ggg() {
        return this.f4864pf;
    }

    public List<ModelLoader<File, ?>> i(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f4860de.yj().i(file);
    }

    /* renamed from: if  reason: not valid java name */
    public List<Class<?>> m311if() {
        return this.f4860de.yj().o(this.f4861fe.getClass(), this.f4868yj, this.f4864pf);
    }

    public boolean mmm(Resource<?> resource) {
        return this.f4860de.yj().when(resource);
    }

    public <R> void nn(fe feVar, Object obj, Key key, int i2, int i3, yj yjVar, Class<?> cls, Class<R> cls2, Priority priority, ad adVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.rg rgVar) {
        this.f4860de = feVar;
        this.f4861fe = obj;
        this.when = key;
        this.f4865rg = i2;
        this.f4866th = i3;
        this.ggg = yjVar;
        this.f4868yj = cls;
        this.f4867uk = rgVar;
        this.f4864pf = cls2;
        this.ppp = priority;
        this.f4862i = adVar;
        this.f4863o = map;
        this.vvv = z;
        this.xxx = z2;
    }

    public ad o() {
        return this.f4862i;
    }

    public Priority pf() {
        return this.ppp;
    }

    public <X> Encoder<X> ppp(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f4860de.yj().m246switch(x);
    }

    public boolean qqq(Key key) {
        List<ModelLoader.qw<?>> yj2 = yj();
        int size = yj2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (yj2.get(i2).qw.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void qw() {
        this.f4860de = null;
        this.f4861fe = null;
        this.when = null;
        this.f4868yj = null;
        this.f4864pf = null;
        this.f4862i = null;
        this.ppp = null;
        this.f4863o = null;
        this.ggg = null;
        this.qw.clear();
        this.f184if = false;
        this.f4859ad.clear();
        this.f185switch = false;
    }

    public yj rg() {
        return this.ggg;
    }

    /* renamed from: switch  reason: not valid java name */
    public <Z> ResourceEncoder<Z> m312switch(Resource<Z> resource) {
        return this.f4860de.yj().pf(resource);
    }

    public int th() {
        return this.f4866th;
    }

    public <Data> ppp<Data, ?, Transcode> uk(Class<Data> cls) {
        return this.f4860de.yj().uk(cls, this.f4868yj, this.f4864pf);
    }

    public <Z> Transformation<Z> vvv(Class<Z> cls) {
        Transformation<Z> transformation = this.f4863o.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f4863o.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.f4863o.isEmpty() || !this.vvv) {
            return fe.rg.qw.o.th.ad.de();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public Key when() {
        return this.when;
    }

    public int xxx() {
        return this.f4865rg;
    }

    public List<ModelLoader.qw<?>> yj() {
        if (!this.f184if) {
            this.f184if = true;
            this.qw.clear();
            List i2 = this.f4860de.yj().i(this.f4861fe);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.qw ad2 = ((ModelLoader) i2.get(i3)).ad(this.f4861fe, this.f4865rg, this.f4866th, this.f4862i);
                if (ad2 != null) {
                    this.qw.add(ad2);
                }
            }
        }
        return this.qw;
    }
}
