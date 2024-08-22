package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.pool.FactoryPools;
import fe.rg.qw.o.de.fe;
import fe.rg.qw.o.fe.ppp;
import fe.rg.qw.o.rg.yj;
import fe.rg.qw.p018switch.ad;
import fe.rg.qw.p018switch.de;
import fe.rg.qw.p018switch.qw;
import fe.rg.qw.p018switch.rg;
import fe.rg.qw.p018switch.th;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f3659ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f3660de;

    /* renamed from: fe  reason: collision with root package name */
    public final th f3661fe;

    /* renamed from: i  reason: collision with root package name */
    public final de f3662i = new de();

    /* renamed from: o  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f3663o;
    public final yj qw;

    /* renamed from: rg  reason: collision with root package name */
    public final fe f3664rg;

    /* renamed from: th  reason: collision with root package name */
    public final fe.rg.qw.o.th.uk.rg f3665th;

    /* renamed from: uk  reason: collision with root package name */
    public final fe.rg.qw.p018switch.fe f3666uk = new fe.rg.qw.p018switch.fe();

    /* renamed from: yj  reason: collision with root package name */
    public final ad f3667yj;

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
            super("Failed to find any ModelLoaders for model: " + obj);
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
        Pools.Pool<List<Throwable>> th2 = FactoryPools.th();
        this.f3663o = th2;
        this.qw = new yj(th2);
        this.f3659ad = new qw();
        this.f3660de = new rg();
        this.f3661fe = new th();
        this.f3664rg = new fe();
        this.f3665th = new fe.rg.qw.o.th.uk.rg();
        this.f3667yj = new ad();
        xxx(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    @NonNull
    public <TResource> Registry ad(@NonNull Class<TResource> cls, @NonNull ResourceEncoder<TResource> resourceEncoder) {
        this.f3661fe.qw(cls, resourceEncoder);
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
        this.f3664rg.ad(factory);
        return this;
    }

    @NonNull
    public <Model> List<ModelLoader<Model, ?>> i(@NonNull Model model) {
        List<ModelLoader<Model, ?>> fe2 = this.qw.fe(model);
        if (!fe2.isEmpty()) {
            return fe2;
        }
        throw new NoModelLoaderAvailableException(model);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public <X> DataRewinder<X> m245if(@NonNull X x) {
        return this.f3664rg.qw(x);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> o(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> qw2 = this.f3666uk.qw(cls, cls2);
        if (qw2 == null) {
            qw2 = new ArrayList<>();
            for (Class<?> fe2 : this.qw.de(cls)) {
                for (Class next : this.f3660de.fe(fe2, cls2)) {
                    if (!this.f3665th.ad(next, cls3).isEmpty() && !qw2.contains(next)) {
                        qw2.add(next);
                    }
                }
            }
            this.f3666uk.ad(cls, cls2, Collections.unmodifiableList(qw2));
        }
        return qw2;
    }

    @NonNull
    public <X> ResourceEncoder<X> pf(@NonNull Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> ad2 = this.f3661fe.ad(resource.ad());
        if (ad2 != null) {
            return ad2;
        }
        throw new NoResultEncoderAvailableException(resource.ad());
    }

    @NonNull
    public Registry ppp(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f3667yj.qw(imageHeaderParser);
        return this;
    }

    @NonNull
    public <Data> Registry qw(@NonNull Class<Data> cls, @NonNull Encoder<Data> encoder) {
        this.f3659ad.qw(cls, encoder);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry rg(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ResourceDecoder<Data, TResource> resourceDecoder) {
        this.f3660de.qw(str, resourceDecoder, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: switch  reason: not valid java name */
    public <X> Encoder<X> m246switch(@NonNull X x) throws NoSourceEncoderAvailableException {
        Encoder<X> ad2 = this.f3659ad.ad(x.getClass());
        if (ad2 != null) {
            return ad2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    @NonNull
    public final <Data, TResource, Transcode> List<fe.rg.qw.o.fe.th<Data, TResource, Transcode>> th(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f3660de.fe(cls, cls2)) {
            for (Class next2 : this.f3665th.ad(next, cls3)) {
                arrayList.add(new fe.rg.qw.o.fe.th(cls, next, next2, this.f3660de.ad(cls, next), this.f3665th.qw(next, next2), this.f3663o));
            }
        }
        return arrayList;
    }

    @Nullable
    public <Data, TResource, Transcode> ppp<Data, TResource, Transcode> uk(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ppp<Data, TResource, Transcode> qw2 = this.f3662i.qw(cls, cls2, cls3);
        if (this.f3662i.de(qw2)) {
            return null;
        }
        if (qw2 == null) {
            List<fe.rg.qw.o.fe.th<Data, TResource, Transcode>> th2 = th(cls, cls2, cls3);
            if (th2.isEmpty()) {
                qw2 = null;
            } else {
                qw2 = new ppp<>(cls, cls2, cls3, th2, this.f3663o);
            }
            this.f3662i.fe(cls, cls2, cls3, qw2);
        }
        return qw2;
    }

    @NonNull
    public <TResource, Transcode> Registry vvv(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        this.f3665th.de(cls, cls2, resourceTranscoder);
        return this;
    }

    public boolean when(@NonNull Resource<?> resource) {
        return this.f3661fe.ad(resource.ad()) != null;
    }

    @NonNull
    public final Registry xxx(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f3660de.rg(arrayList);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> yj() {
        List<ImageHeaderParser> ad2 = this.f3667yj.ad();
        if (!ad2.isEmpty()) {
            return ad2;
        }
        throw new NoImageHeaderParserException();
    }
}
