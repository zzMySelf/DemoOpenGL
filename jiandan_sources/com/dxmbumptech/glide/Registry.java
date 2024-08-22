package com.dxmbumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.Encoder;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.ResourceEncoder;
import com.dxmbumptech.glide.load.data.DataRewinder;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.model.ModelLoader;
import com.dxmbumptech.glide.load.model.ModelLoaderFactory;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.dxmbumptech.glide.util.pool.FactoryPools;
import fe.uk.qw.pf.de.fe;
import fe.uk.qw.pf.fe.ppp;
import fe.uk.qw.pf.rg.yj;
import fe.uk.qw.when.ad;
import fe.uk.qw.when.de;
import fe.uk.qw.when.qw;
import fe.uk.qw.when.rg;
import fe.uk.qw.when.th;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f3824ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f3825de;

    /* renamed from: fe  reason: collision with root package name */
    public final th f3826fe;

    /* renamed from: i  reason: collision with root package name */
    public final de f3827i = new de();

    /* renamed from: o  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f3828o;
    public final yj qw;

    /* renamed from: rg  reason: collision with root package name */
    public final fe f3829rg;

    /* renamed from: th  reason: collision with root package name */
    public final fe.uk.qw.pf.th.i.rg f3830th;

    /* renamed from: uk  reason: collision with root package name */
    public final fe.uk.qw.when.fe f3831uk = new fe.uk.qw.when.fe();

    /* renamed from: yj  reason: collision with root package name */
    public final ad f3832yj;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m, @NonNull List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> rg2 = FactoryPools.rg();
        this.f3828o = rg2;
        this.qw = new yj(rg2);
        this.f3824ad = new qw();
        this.f3825de = new rg();
        this.f3826fe = new th();
        this.f3829rg = new fe();
        this.f3830th = new fe.uk.qw.pf.th.i.rg();
        this.f3832yj = new ad();
        xxx(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    @NonNull
    public <TResource> Registry ad(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f3826fe.qw(cls, resourceEncoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry de(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        rg("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    @NonNull
    public <Model, Data> Registry fe(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        this.qw.qw(cls, cls2, modelLoaderFactory);
        return this;
    }

    @NonNull
    public Registry ggg(@NonNull DataRewinder.Factory<?> factory) {
        this.f3829rg.ad(factory);
        return this;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> i(@NonNull Model model) {
        return this.qw.fe(model);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public <X> DataRewinder<X> m259if(@NonNull X x) {
        return this.f3829rg.qw(x);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> o(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> qw2 = this.f3831uk.qw(cls, cls2, cls3);
        if (qw2 == null) {
            qw2 = new ArrayList<>();
            for (Class<?> fe2 : this.qw.de(cls)) {
                for (Class next : this.f3825de.fe(fe2, cls2)) {
                    if (!this.f3830th.ad(next, cls3).isEmpty() && !qw2.contains(next)) {
                        qw2.add(next);
                    }
                }
            }
            this.f3831uk.ad(cls, cls2, cls3, Collections.unmodifiableList(qw2));
        }
        return qw2;
    }

    @NonNull
    public <X> ResourceEncoder<X> pf(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> ad2 = this.f3826fe.ad(resource.ad());
        if (ad2 != null) {
            return ad2;
        }
        throw new NoResultEncoderAvailableException(resource.ad());
    }

    @NonNull
    public Registry ppp(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f3832yj.qw(imageHeaderParser);
        return this;
    }

    @NonNull
    public <Data> Registry qw(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f3824ad.qw(cls, encoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry rg(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f3825de.qw(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public <X> Encoder<X> m260switch(@NonNull X x) throws NoSourceEncoderAvailableException {
        Encoder<X> ad2 = this.f3824ad.ad(x.getClass());
        if (ad2 != null) {
            return ad2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    @NonNull
    public final <Data, TResource, Transcode> List<fe.uk.qw.pf.fe.th<Data, TResource, Transcode>> th(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f3825de.fe(cls, cls2)) {
            for (Class next2 : this.f3830th.ad(next, cls3)) {
                arrayList.add(new fe.uk.qw.pf.fe.th(cls, next, next2, this.f3825de.ad(cls, next), this.f3830th.qw(next, next2), this.f3828o));
            }
        }
        return arrayList;
    }

    @Nullable
    public <Data, TResource, Transcode> ppp<Data, TResource, Transcode> uk(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ppp<Data, TResource, Transcode> qw2 = this.f3827i.qw(cls, cls2, cls3);
        if (this.f3827i.de(qw2)) {
            return null;
        }
        if (qw2 == null) {
            List<fe.uk.qw.pf.fe.th<Data, TResource, Transcode>> th2 = th(cls, cls2, cls3);
            if (th2.isEmpty()) {
                qw2 = null;
            } else {
                qw2 = new ppp<>(cls, cls2, cls3, th2, this.f3828o);
            }
            this.f3827i.fe(cls, cls2, cls3, qw2);
        }
        return qw2;
    }

    @NonNull
    public <TResource, Transcode> Registry vvv(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f3830th.de(cls, cls2, resourceTranscoder);
        return this;
    }

    public boolean when(@NonNull Resource<?> resource) {
        return this.f3826fe.ad(resource.ad()) != null;
    }

    @NonNull
    public final Registry xxx(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        for (String add : list) {
            arrayList.add(add);
        }
        arrayList.add("legacy_append");
        this.f3825de.rg(arrayList);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> yj() {
        List<ImageHeaderParser> ad2 = this.f3832yj.ad();
        if (!ad2.isEmpty()) {
            return ad2;
        }
        throw new NoImageHeaderParserException();
    }
}
