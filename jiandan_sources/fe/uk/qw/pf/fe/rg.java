package fe.uk.qw.pf.fe;

import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.Registry;
import com.dxmbumptech.glide.load.Encoder;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.ResourceEncoder;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.DecodeJob;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import com.dxmbumptech.glide.load.model.ModelLoader;
import fe.uk.qw.fe;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.th.de;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class rg<Transcode> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Key> f5833ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public fe f5834de;

    /* renamed from: fe  reason: collision with root package name */
    public Object f5835fe;
    public yj ggg;

    /* renamed from: i  reason: collision with root package name */
    public ad f5836i;

    /* renamed from: if  reason: not valid java name */
    public boolean f238if;

    /* renamed from: o  reason: collision with root package name */
    public Map<Class<?>, Transformation<?>> f5837o;

    /* renamed from: pf  reason: collision with root package name */
    public Class<Transcode> f5838pf;
    public Priority ppp;
    public final List<ModelLoader.qw<?>> qw = new ArrayList();

    /* renamed from: rg  reason: collision with root package name */
    public int f5839rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f239switch;

    /* renamed from: th  reason: collision with root package name */
    public int f5840th;

    /* renamed from: uk  reason: collision with root package name */
    public DecodeJob.rg f5841uk;
    public boolean vvv;
    public Key when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public Class<?> f5842yj;

    public boolean aaa(Resource<?> resource) {
        return this.f5834de.i().when(resource);
    }

    public ArrayPool ad() {
        return this.f5834de.ad();
    }

    public int ddd() {
        return this.f5839rg;
    }

    public List<Key> de() {
        if (!this.f239switch) {
            this.f239switch = true;
            this.f5833ad.clear();
            List<ModelLoader.qw<?>> yj2 = yj();
            int size = yj2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.qw qwVar = yj2.get(i2);
                if (!this.f5833ad.contains(qwVar.qw)) {
                    this.f5833ad.add(qwVar.qw);
                }
                for (int i3 = 0; i3 < qwVar.f3878ad.size(); i3++) {
                    if (!this.f5833ad.contains(qwVar.f3878ad.get(i3))) {
                        this.f5833ad.add(qwVar.f3878ad.get(i3));
                    }
                }
            }
        }
        return this.f5833ad;
    }

    public boolean eee(Key key) {
        List<ModelLoader.qw<?>> yj2 = yj();
        int size = yj2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (yj2.get(i2).qw.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public DiskCache fe() {
        return this.f5841uk.qw();
    }

    public <X> Encoder<X> ggg(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f5834de.i().m260switch(x);
    }

    public Class<?> i() {
        return this.f5835fe.getClass();
    }

    /* renamed from: if  reason: not valid java name */
    public Priority m379if() {
        return this.ppp;
    }

    public <R> void mmm(fe feVar, Object obj, Key key, int i2, int i3, yj yjVar, Class<?> cls, Class<R> cls2, Priority priority, ad adVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, DecodeJob.rg rgVar) {
        this.f5834de = feVar;
        this.f5835fe = obj;
        this.when = key;
        this.f5839rg = i2;
        this.f5840th = i3;
        this.ggg = yjVar;
        this.f5842yj = cls;
        this.f5841uk = rgVar;
        this.f5838pf = cls2;
        this.ppp = priority;
        this.f5836i = adVar;
        this.f5837o = map;
        this.vvv = z;
        this.xxx = z2;
    }

    public boolean nn(Class<?> cls) {
        return uk(cls) != null;
    }

    public List<ModelLoader<File, ?>> o(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f5834de.i().i(file);
    }

    public ad pf() {
        return this.f5836i;
    }

    public Key ppp() {
        return this.when;
    }

    public boolean qqq() {
        return this.xxx;
    }

    public void qw() {
        this.f5834de = null;
        this.f5835fe = null;
        this.when = null;
        this.f5842yj = null;
        this.f5838pf = null;
        this.f5836i = null;
        this.ppp = null;
        this.f5837o = null;
        this.ggg = null;
        this.qw.clear();
        this.f238if = false;
        this.f5833ad.clear();
        this.f239switch = false;
    }

    public yj rg() {
        return this.ggg;
    }

    /* renamed from: switch  reason: not valid java name */
    public List<Class<?>> m380switch() {
        return this.f5834de.i().o(this.f5835fe.getClass(), this.f5842yj, this.f5838pf);
    }

    public int th() {
        return this.f5840th;
    }

    public <Data> ppp<Data, ?, Transcode> uk(Class<Data> cls) {
        return this.f5834de.i().uk(cls, this.f5842yj, this.f5838pf);
    }

    public Class<?> vvv() {
        return this.f5838pf;
    }

    public <Z> ResourceEncoder<Z> when(Resource<Z> resource) {
        return this.f5834de.i().pf(resource);
    }

    public <Z> Transformation<Z> xxx(Class<Z> cls) {
        Transformation<Z> transformation = this.f5837o.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f5837o.entrySet().iterator();
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
        if (!this.f5837o.isEmpty() || !this.vvv) {
            return de.de();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public List<ModelLoader.qw<?>> yj() {
        if (!this.f238if) {
            this.f238if = true;
            this.qw.clear();
            List i2 = this.f5834de.i().i(this.f5835fe);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                ModelLoader.qw ad2 = ((ModelLoader) i2.get(i3)).ad(this.f5835fe, this.f5839rg, this.f5840th, this.f5836i);
                if (ad2 != null) {
                    this.qw.add(ad2);
                }
            }
        }
        return this.qw;
    }
}
