package com.dxmbumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.engine.cache.MemoryCache;
import com.dxmbumptech.glide.load.model.AssetUriLoader;
import com.dxmbumptech.glide.load.model.ByteArrayLoader;
import com.dxmbumptech.glide.load.model.DataUrlLoader;
import com.dxmbumptech.glide.load.model.FileLoader;
import com.dxmbumptech.glide.load.model.UriLoader;
import com.dxmbumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.dxmbumptech.glide.load.resource.bitmap.Downsampler;
import com.dxmbumptech.glide.load.resource.bitmap.VideoDecoder;
import com.dxmbumptech.glide.load.resource.gif.GifDrawable;
import com.dxmbumptech.glide.manager.ConnectivityMonitorFactory;
import com.dxmbumptech.glide.manager.RequestManagerRetriever;
import com.dxmbumptech.glide.module.GlideModule;
import com.dxmbumptech.glide.request.RequestListener;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.de;
import fe.uk.qw.fe;
import fe.uk.qw.pf.de.i;
import fe.uk.qw.pf.de.pf;
import fe.uk.qw.pf.fe.uk;
import fe.uk.qw.pf.rg.Cif;
import fe.uk.qw.pf.rg.Cswitch;
import fe.uk.qw.pf.rg.ad;
import fe.uk.qw.pf.rg.o;
import fe.uk.qw.pf.rg.pf;
import fe.uk.qw.pf.rg.ppp.ad;
import fe.uk.qw.pf.rg.ppp.de;
import fe.uk.qw.pf.rg.ppp.fe;
import fe.uk.qw.pf.rg.ppp.qw;
import fe.uk.qw.pf.rg.ppp.rg;
import fe.uk.qw.pf.rg.rg;
import fe.uk.qw.pf.rg.when;
import fe.uk.qw.pf.th.fe.Cswitch;
import fe.uk.qw.pf.th.fe.ad;
import fe.uk.qw.pf.th.fe.ddd;
import fe.uk.qw.pf.th.fe.mmm;
import fe.uk.qw.pf.th.fe.nn;
import fe.uk.qw.pf.th.fe.qqq;
import fe.uk.qw.pf.th.fe.vvv;
import fe.uk.qw.pf.th.rg.qw;
import fe.uk.qw.pf.th.uk.qw;
import fe.uk.qw.pf.th.uk.th;
import fe.uk.qw.ppp.de;
import fe.uk.qw.rg;
import fe.uk.qw.yj;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    @GuardedBy("Glide.class")

    /* renamed from: switch  reason: not valid java name */
    public static volatile Glide f143switch;
    public static volatile boolean when;

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f3814ad;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayPool f3815i;
    @GuardedBy("managers")

    /* renamed from: if  reason: not valid java name */
    public final List<yj> f144if = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final RequestManagerRetriever f3816o;

    /* renamed from: pf  reason: collision with root package name */
    public final ConnectivityMonitorFactory f3817pf;

    /* renamed from: th  reason: collision with root package name */
    public final MemoryCache f3818th;

    /* renamed from: uk  reason: collision with root package name */
    public final Registry f3819uk;

    /* renamed from: yj  reason: collision with root package name */
    public final fe f3820yj;

    public interface RequestOptionsFactory {
        @NonNull
        de build();
    }

    public Glide(@NonNull Context context, @NonNull uk ukVar, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i2, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, fe.uk.qw.uk<?, ?>> map, @NonNull List<RequestListener<Object>> list, rg rgVar) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Class<GifDecoder> cls;
        Context context2 = context;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        Class<GifDecoder> cls2 = GifDecoder.class;
        Class<String> cls3 = String.class;
        Class<Integer> cls4 = Integer.class;
        Class<byte[]> cls5 = byte[].class;
        MemoryCategory memoryCategory = MemoryCategory.NORMAL;
        this.f3814ad = bitmapPool2;
        this.f3815i = arrayPool2;
        this.f3818th = memoryCache;
        this.f3816o = requestManagerRetriever;
        this.f3817pf = connectivityMonitorFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f3819uk = registry;
        registry.ppp(new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f3819uk.ppp(new Cswitch());
        }
        List<ImageHeaderParser> yj2 = this.f3819uk.yj();
        qw qwVar = new qw(context2, yj2, bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> uk2 = VideoDecoder.uk(bitmapPool);
        Downsampler downsampler = new Downsampler(this.f3819uk.yj(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        if (!rgVar.qw(de.ad.class) || Build.VERSION.SDK_INT < 28) {
            resourceDecoder = new fe.uk.qw.pf.th.fe.yj(downsampler);
            resourceDecoder2 = new mmm(downsampler, arrayPool2);
        } else {
            resourceDecoder2 = new vvv();
            resourceDecoder = new fe.uk.qw.pf.th.fe.uk();
        }
        fe.uk.qw.pf.th.th.fe feVar = new fe.uk.qw.pf.th.th.fe(context2);
        Class<byte[]> cls6 = cls5;
        o.de deVar = new o.de(resources);
        o.fe feVar2 = new o.fe(resources);
        Class<String> cls7 = cls3;
        o.ad adVar = new o.ad(resources);
        o.fe feVar3 = feVar2;
        o.qw qwVar2 = new o.qw(resources);
        fe.uk.qw.pf.th.fe.de deVar2 = new fe.uk.qw.pf.th.fe.de(arrayPool2);
        Class<Integer> cls8 = cls4;
        fe.uk.qw.pf.th.i.qw qwVar3 = new fe.uk.qw.pf.th.i.qw();
        fe.uk.qw.pf.th.i.fe feVar4 = new fe.uk.qw.pf.th.i.fe();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry2 = this.f3819uk;
        o.ad adVar2 = adVar;
        o.de deVar3 = deVar;
        registry2.qw(ByteBuffer.class, new fe.uk.qw.pf.rg.qw());
        registry2.qw(InputStream.class, new pf(arrayPool2));
        fe.uk.qw.pf.th.th.fe feVar5 = feVar;
        registry2.rg("Bitmap", ByteBuffer.class, Bitmap.class, resourceDecoder);
        registry2.rg("Bitmap", InputStream.class, Bitmap.class, resourceDecoder2);
        if (fe.uk.qw.pf.de.pf.de()) {
            cls = cls2;
            this.f3819uk.rg("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new ddd(downsampler));
        } else {
            cls = cls2;
        }
        Registry registry3 = this.f3819uk;
        registry3.rg("Bitmap", ParcelFileDescriptor.class, Bitmap.class, uk2);
        registry3.rg("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.de(bitmapPool));
        registry3.fe(Bitmap.class, Bitmap.class, Cswitch.qw.qw());
        registry3.rg("Bitmap", Bitmap.class, Bitmap.class, new qqq());
        registry3.ad(Bitmap.class, deVar2);
        registry3.rg("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new fe.uk.qw.pf.th.fe.qw(resources, resourceDecoder));
        registry3.rg("BitmapDrawable", InputStream.class, BitmapDrawable.class, new fe.uk.qw.pf.th.fe.qw(resources, resourceDecoder2));
        registry3.rg("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new fe.uk.qw.pf.th.fe.qw(resources, uk2));
        registry3.ad(BitmapDrawable.class, new ad(bitmapPool2, deVar2));
        registry3.rg("Gif", InputStream.class, GifDrawable.class, new fe.uk.qw.pf.th.uk.uk(yj2, qwVar, arrayPool2));
        registry3.rg("Gif", ByteBuffer.class, GifDrawable.class, qwVar);
        registry3.ad(GifDrawable.class, new fe.uk.qw.pf.th.uk.de());
        Class<GifDecoder> cls9 = cls;
        registry3.fe(cls9, cls9, Cswitch.qw.qw());
        registry3.rg("Bitmap", cls9, Bitmap.class, new th(bitmapPool2));
        fe.uk.qw.pf.th.th.fe feVar6 = feVar5;
        registry3.de(Uri.class, Drawable.class, feVar6);
        registry3.de(Uri.class, Bitmap.class, new nn(feVar6, bitmapPool2));
        registry3.ggg(new qw.C0244qw());
        registry3.fe(File.class, ByteBuffer.class, new ad.C0238ad());
        registry3.fe(File.class, InputStream.class, new FileLoader.fe());
        registry3.de(File.class, File.class, new fe.uk.qw.pf.th.yj.qw());
        registry3.fe(File.class, ParcelFileDescriptor.class, new FileLoader.ad());
        registry3.fe(File.class, File.class, Cswitch.qw.qw());
        registry3.ggg(new i.qw(arrayPool2));
        if (fe.uk.qw.pf.de.pf.de()) {
            this.f3819uk.ggg(new pf.qw());
        }
        Registry registry4 = this.f3819uk;
        o.de deVar4 = deVar3;
        registry4.fe(Integer.TYPE, InputStream.class, deVar4);
        o.ad adVar3 = adVar2;
        registry4.fe(Integer.TYPE, ParcelFileDescriptor.class, adVar3);
        Class<Integer> cls10 = cls8;
        registry4.fe(cls10, InputStream.class, deVar4);
        registry4.fe(cls10, ParcelFileDescriptor.class, adVar3);
        o.fe feVar7 = feVar3;
        registry4.fe(cls10, Uri.class, feVar7);
        o.qw qwVar4 = qwVar2;
        registry4.fe(Integer.TYPE, AssetFileDescriptor.class, qwVar4);
        registry4.fe(cls10, AssetFileDescriptor.class, qwVar4);
        registry4.fe(Integer.TYPE, Uri.class, feVar7);
        Class<String> cls11 = cls7;
        registry4.fe(cls11, InputStream.class, new DataUrlLoader.ad());
        registry4.fe(Uri.class, InputStream.class, new DataUrlLoader.ad());
        registry4.fe(cls11, InputStream.class, new Cif.de());
        registry4.fe(cls11, ParcelFileDescriptor.class, new Cif.ad());
        registry4.fe(cls11, AssetFileDescriptor.class, new Cif.qw());
        registry4.fe(Uri.class, InputStream.class, new AssetUriLoader.ad(context.getAssets()));
        registry4.fe(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.qw(context.getAssets()));
        Context context3 = context;
        registry4.fe(Uri.class, InputStream.class, new ad.qw(context3));
        registry4.fe(Uri.class, InputStream.class, new de.qw(context3));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3819uk.fe(Uri.class, InputStream.class, new fe.de(context3));
            this.f3819uk.fe(Uri.class, ParcelFileDescriptor.class, new fe.ad(context3));
        }
        Registry registry5 = this.f3819uk;
        ContentResolver contentResolver2 = contentResolver;
        registry5.fe(Uri.class, InputStream.class, new UriLoader.de(contentResolver2));
        registry5.fe(Uri.class, ParcelFileDescriptor.class, new UriLoader.ad(contentResolver2));
        registry5.fe(Uri.class, AssetFileDescriptor.class, new UriLoader.qw(contentResolver2));
        registry5.fe(Uri.class, InputStream.class, new when.qw());
        registry5.fe(URL.class, InputStream.class, new rg.qw());
        registry5.fe(Uri.class, File.class, new rg.qw(context3));
        registry5.fe(fe.uk.qw.pf.rg.de.class, InputStream.class, new qw.C0240qw());
        Class<byte[]> cls12 = cls6;
        registry5.fe(cls12, ByteBuffer.class, new ByteArrayLoader.qw());
        registry5.fe(cls12, InputStream.class, new ByteArrayLoader.de());
        registry5.fe(Uri.class, Uri.class, Cswitch.qw.qw());
        registry5.fe(Drawable.class, Drawable.class, Cswitch.qw.qw());
        registry5.de(Drawable.class, Drawable.class, new fe.uk.qw.pf.th.th.rg());
        registry5.vvv(Bitmap.class, BitmapDrawable.class, new fe.uk.qw.pf.th.i.ad(resources));
        fe.uk.qw.pf.th.i.qw qwVar5 = qwVar3;
        registry5.vvv(Bitmap.class, cls12, qwVar5);
        fe.uk.qw.pf.th.i.fe feVar8 = feVar4;
        registry5.vvv(Drawable.class, cls12, new fe.uk.qw.pf.th.i.de(bitmapPool2, qwVar5, feVar8));
        registry5.vvv(GifDrawable.class, cls12, feVar8);
        if (Build.VERSION.SDK_INT >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> fe2 = VideoDecoder.fe(bitmapPool);
            this.f3819uk.de(ByteBuffer.class, Bitmap.class, fe2);
            this.f3819uk.de(ByteBuffer.class, BitmapDrawable.class, new fe.uk.qw.pf.th.fe.qw(resources, fe2));
        }
        Context context4 = context;
        ArrayPool arrayPool3 = arrayPool;
        this.f3820yj = new fe.uk.qw.fe(context4, arrayPool3, this.f3819uk, new fe.uk.qw.ppp.rg.th(), requestOptionsFactory, map, list, ukVar, rgVar, i2);
    }

    @NonNull
    public static Glide de(@NonNull Context context) {
        if (f143switch == null) {
            fe.uk.qw.qw fe2 = fe(context.getApplicationContext());
            synchronized (Glide.class) {
                if (f143switch == null) {
                    qw(context, fe2);
                }
            }
        }
        return f143switch;
    }

    @Nullable
    public static fe.uk.qw.qw fe(Context context) {
        try {
            return (fe.uk.qw.qw) Class.forName("com.dxmbumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            boolean isLoggable = Log.isLoggable(BaiduWalletDelegate.b, 5);
            return null;
        } catch (InstantiationException e) {
            vvv(e);
            throw null;
        } catch (IllegalAccessException e2) {
            vvv(e2);
            throw null;
        } catch (NoSuchMethodException e3) {
            vvv(e3);
            throw null;
        } catch (InvocationTargetException e4) {
            vvv(e4);
            throw null;
        }
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public static RequestManagerRetriever m257if(@Nullable Context context) {
        fe.uk.qw.vvv.i.rg(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return de(context).pf();
    }

    @NonNull
    public static yj nn(@NonNull Context context) {
        return m257if(context).th(context);
    }

    @GuardedBy("Glide.class")
    public static void qw(@NonNull Context context, @Nullable fe.uk.qw.qw qwVar) {
        if (!when) {
            when = true;
            m258switch(context, qwVar);
            when = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @GuardedBy("Glide.class")
    /* renamed from: switch  reason: not valid java name */
    public static void m258switch(@NonNull Context context, @Nullable fe.uk.qw.qw qwVar) {
        when(context, new fe.uk.qw.de(), qwVar);
    }

    public static void vvv(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @GuardedBy("Glide.class")
    public static void when(@NonNull Context context, @NonNull fe.uk.qw.de deVar, @Nullable fe.uk.qw.qw qwVar) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (qwVar == null || qwVar.de()) {
            emptyList = new fe.uk.qw.p022switch.fe(applicationContext).qw();
        }
        if (qwVar != null && !qwVar.fe().isEmpty()) {
            Set<Class<?>> fe2 = qwVar.fe();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (fe2.contains(next.getClass())) {
                    if (Log.isLoggable(BaiduWalletDelegate.b, 3)) {
                        "AppGlideModule excludes manifest GlideModule: " + next;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(BaiduWalletDelegate.b, 3)) {
            for (GlideModule glideModule : emptyList) {
                "Discovered GlideModule from manifest: " + glideModule.getClass();
            }
        }
        deVar.ad(qwVar != null ? qwVar.rg() : null);
        for (GlideModule ad2 : emptyList) {
            ad2.ad(applicationContext, deVar);
        }
        if (qwVar != null) {
            qwVar.ad(applicationContext, deVar);
        }
        Glide qw = deVar.qw(applicationContext);
        for (GlideModule next2 : emptyList) {
            try {
                next2.qw(applicationContext, qw, qw.f3819uk);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e);
            }
        }
        if (qwVar != null) {
            qwVar.qw(applicationContext, qw, qw.f3819uk);
        }
        applicationContext.registerComponentCallbacks(qw);
        f143switch = qw;
    }

    public void ad() {
        fe.uk.qw.vvv.o.qw();
        this.f3818th.ad();
        this.f3814ad.ad();
        this.f3815i.ad();
    }

    public void ddd(yj yjVar) {
        synchronized (this.f144if) {
            if (this.f144if.contains(yjVar)) {
                this.f144if.remove(yjVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public boolean ggg(@NonNull Target<?> target) {
        synchronized (this.f144if) {
            for (yj aaa : this.f144if) {
                if (aaa.aaa(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public fe.uk.qw.fe i() {
        return this.f3820yj;
    }

    @NonNull
    public Registry o() {
        return this.f3819uk;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        ad();
    }

    public void onTrimMemory(int i2) {
        xxx(i2);
    }

    @NonNull
    public RequestManagerRetriever pf() {
        return this.f3816o;
    }

    public void ppp(yj yjVar) {
        synchronized (this.f144if) {
            if (!this.f144if.contains(yjVar)) {
                this.f144if.add(yjVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @NonNull
    public ArrayPool rg() {
        return this.f3815i;
    }

    @NonNull
    public BitmapPool th() {
        return this.f3814ad;
    }

    @NonNull
    public Context uk() {
        return this.f3820yj.getBaseContext();
    }

    public void xxx(int i2) {
        fe.uk.qw.vvv.o.qw();
        synchronized (this.f144if) {
            for (yj onTrimMemory : this.f144if) {
                onTrimMemory.onTrimMemory(i2);
            }
        }
        this.f3818th.qw(i2);
        this.f3814ad.qw(i2);
        this.f3815i.qw(i2);
    }

    public ConnectivityMonitorFactory yj() {
        return this.f3817pf;
    }
}
