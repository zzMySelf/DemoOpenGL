package fe.rg.qw;

import android.app.Activity;
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
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.Target;
import fe.rg.qw.o.de.i;
import fe.rg.qw.o.fe.eee.qw;
import fe.rg.qw.o.fe.uk;
import fe.rg.qw.o.rg.Cif;
import fe.rg.qw.o.rg.Cswitch;
import fe.rg.qw.o.rg.ad;
import fe.rg.qw.o.rg.o;
import fe.rg.qw.o.rg.pf;
import fe.rg.qw.o.rg.ppp.ad;
import fe.rg.qw.o.rg.ppp.de;
import fe.rg.qw.o.rg.ppp.fe;
import fe.rg.qw.o.rg.ppp.qw;
import fe.rg.qw.o.rg.ppp.rg;
import fe.rg.qw.o.rg.rg;
import fe.rg.qw.o.rg.when;
import fe.rg.qw.o.th.de.Cif;
import fe.rg.qw.o.th.de.ddd;
import fe.rg.qw.o.th.de.de;
import fe.rg.qw.o.th.de.ggg;
import fe.rg.qw.o.th.de.i;
import fe.rg.qw.o.th.de.nn;
import fe.rg.qw.o.th.de.th;
import fe.rg.qw.o.th.de.vvv;
import fe.rg.qw.o.th.fe.qw;
import fe.rg.qw.o.th.rg.fe;
import fe.rg.qw.o.th.yj.yj;
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

public class ad implements ComponentCallbacks2 {

    /* renamed from: switch  reason: not valid java name */
    public static volatile ad f172switch;
    public static volatile boolean when;

    /* renamed from: ad  reason: collision with root package name */
    public final BitmapPool f4645ad;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayPool f4646i;

    /* renamed from: if  reason: not valid java name */
    public final List<th> f173if = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final RequestManagerRetriever f4647o;

    /* renamed from: pf  reason: collision with root package name */
    public final ConnectivityMonitorFactory f4648pf;

    /* renamed from: th  reason: collision with root package name */
    public final MemoryCache f4649th;

    /* renamed from: uk  reason: collision with root package name */
    public final Registry f4650uk;

    /* renamed from: yj  reason: collision with root package name */
    public final fe f4651yj;

    public ad(@NonNull Context context, @NonNull uk ukVar, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i2, @NonNull fe.rg.qw.when.ad adVar, @NonNull Map<Class<?>, yj<?, ?>> map) {
        Context context2 = context;
        MemoryCache memoryCache2 = memoryCache;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        Class<GifDecoder> cls = GifDecoder.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        MemoryCategory memoryCategory = MemoryCategory.NORMAL;
        this.f4645ad = bitmapPool2;
        this.f4646i = arrayPool2;
        this.f4649th = memoryCache2;
        this.f4647o = requestManagerRetriever;
        this.f4648pf = connectivityMonitorFactory;
        new qw(memoryCache2, bitmapPool2, (DecodeFormat) adVar.xxx().de(Downsampler.f3719th));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f4650uk = registry;
        if (Build.VERSION.SDK_INT >= 27) {
            registry.ppp(new Cif());
        }
        this.f4650uk.ppp(new i());
        Downsampler downsampler = new Downsampler(this.f4650uk.yj(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        fe.rg.qw.o.th.yj.qw qwVar = new fe.rg.qw.o.th.yj.qw(context2, this.f4650uk.yj(), bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> yj2 = nn.yj(bitmapPool);
        th thVar = new th(downsampler);
        vvv vvv = new vvv(downsampler, arrayPool2);
        fe feVar = new fe(context2);
        o.de deVar = new o.de(resources);
        o.fe feVar2 = new o.fe(resources);
        Class<byte[]> cls5 = cls4;
        o.ad adVar2 = new o.ad(resources);
        o.qw qwVar2 = new o.qw(resources);
        Class<String> cls6 = cls2;
        de deVar2 = new de(arrayPool2);
        o.qw qwVar3 = qwVar2;
        fe.rg.qw.o.th.uk.qw qwVar4 = new fe.rg.qw.o.th.uk.qw();
        fe.rg.qw.o.th.uk.fe feVar3 = new fe.rg.qw.o.th.uk.fe();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry2 = this.f4650uk;
        Class<Integer> cls7 = cls3;
        registry2.qw(ByteBuffer.class, new fe.rg.qw.o.rg.qw());
        registry2.qw(InputStream.class, new pf(arrayPool2));
        registry2.rg("Bitmap", ByteBuffer.class, Bitmap.class, thVar);
        registry2.rg("Bitmap", InputStream.class, Bitmap.class, vvv);
        registry2.rg("Bitmap", ParcelFileDescriptor.class, Bitmap.class, yj2);
        registry2.rg("Bitmap", AssetFileDescriptor.class, Bitmap.class, nn.de(bitmapPool));
        registry2.fe(Bitmap.class, Bitmap.class, Cswitch.qw.qw());
        registry2.rg("Bitmap", Bitmap.class, Bitmap.class, new ddd());
        registry2.ad(Bitmap.class, deVar2);
        registry2.rg("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new fe.rg.qw.o.th.de.qw(resources, thVar));
        registry2.rg("BitmapDrawable", InputStream.class, BitmapDrawable.class, new fe.rg.qw.o.th.de.qw(resources, vvv));
        registry2.rg("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new fe.rg.qw.o.th.de.qw(resources, yj2));
        registry2.ad(BitmapDrawable.class, new fe.rg.qw.o.th.de.ad(bitmapPool2, deVar2));
        registry2.rg("Gif", InputStream.class, fe.rg.qw.o.th.yj.de.class, new fe.rg.qw.o.th.yj.i(this.f4650uk.yj(), qwVar, arrayPool2));
        registry2.rg("Gif", ByteBuffer.class, fe.rg.qw.o.th.yj.de.class, qwVar);
        registry2.ad(fe.rg.qw.o.th.yj.de.class, new fe.rg.qw.o.th.yj.fe());
        registry2.fe(cls, cls, Cswitch.qw.qw());
        registry2.rg("Bitmap", cls, Bitmap.class, new yj(bitmapPool2));
        registry2.de(Uri.class, Drawable.class, feVar);
        registry2.de(Uri.class, Bitmap.class, new ggg(feVar, bitmapPool2));
        registry2.ggg(new qw.C0213qw());
        registry2.fe(File.class, ByteBuffer.class, new ad.C0210ad());
        registry2.fe(File.class, InputStream.class, new FileLoader.fe());
        registry2.de(File.class, File.class, new fe.rg.qw.o.th.th.qw());
        registry2.fe(File.class, ParcelFileDescriptor.class, new FileLoader.ad());
        registry2.fe(File.class, File.class, Cswitch.qw.qw());
        registry2.ggg(new i.qw(arrayPool2));
        o.de deVar3 = deVar;
        registry2.fe(Integer.TYPE, InputStream.class, deVar3);
        o.ad adVar3 = adVar2;
        registry2.fe(Integer.TYPE, ParcelFileDescriptor.class, adVar3);
        Class<Integer> cls8 = cls7;
        registry2.fe(cls8, InputStream.class, deVar3);
        registry2.fe(cls8, ParcelFileDescriptor.class, adVar3);
        o.fe feVar4 = feVar2;
        registry2.fe(cls8, Uri.class, feVar4);
        o.qw qwVar5 = qwVar3;
        registry2.fe(Integer.TYPE, AssetFileDescriptor.class, qwVar5);
        registry2.fe(cls8, AssetFileDescriptor.class, qwVar5);
        registry2.fe(Integer.TYPE, Uri.class, feVar4);
        Class<String> cls9 = cls6;
        registry2.fe(cls9, InputStream.class, new DataUrlLoader.ad());
        registry2.fe(Uri.class, InputStream.class, new DataUrlLoader.ad());
        registry2.fe(cls9, InputStream.class, new Cif.de());
        registry2.fe(cls9, ParcelFileDescriptor.class, new Cif.ad());
        registry2.fe(cls9, AssetFileDescriptor.class, new Cif.qw());
        registry2.fe(Uri.class, InputStream.class, new ad.qw());
        registry2.fe(Uri.class, InputStream.class, new AssetUriLoader.ad(context.getAssets()));
        registry2.fe(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.qw(context.getAssets()));
        Context context3 = context;
        registry2.fe(Uri.class, InputStream.class, new de.qw(context3));
        registry2.fe(Uri.class, InputStream.class, new fe.qw(context3));
        ContentResolver contentResolver2 = contentResolver;
        registry2.fe(Uri.class, InputStream.class, new UriLoader.de(contentResolver2));
        registry2.fe(Uri.class, ParcelFileDescriptor.class, new UriLoader.ad(contentResolver2));
        registry2.fe(Uri.class, AssetFileDescriptor.class, new UriLoader.qw(contentResolver2));
        registry2.fe(Uri.class, InputStream.class, new when.qw());
        registry2.fe(URL.class, InputStream.class, new rg.qw());
        registry2.fe(Uri.class, File.class, new rg.qw(context3));
        registry2.fe(fe.rg.qw.o.rg.de.class, InputStream.class, new qw.C0211qw());
        Class<byte[]> cls10 = cls5;
        registry2.fe(cls10, ByteBuffer.class, new ByteArrayLoader.qw());
        registry2.fe(cls10, InputStream.class, new ByteArrayLoader.de());
        registry2.fe(Uri.class, Uri.class, Cswitch.qw.qw());
        registry2.fe(Drawable.class, Drawable.class, Cswitch.qw.qw());
        registry2.de(Drawable.class, Drawable.class, new fe.rg.qw.o.th.rg.rg());
        registry2.vvv(Bitmap.class, BitmapDrawable.class, new fe.rg.qw.o.th.uk.ad(resources));
        fe.rg.qw.o.th.uk.qw qwVar6 = qwVar4;
        registry2.vvv(Bitmap.class, cls10, qwVar6);
        fe.rg.qw.o.th.uk.fe feVar5 = feVar3;
        registry2.vvv(Drawable.class, cls10, new fe.rg.qw.o.th.uk.de(bitmapPool2, qwVar6, feVar5));
        registry2.vvv(fe.rg.qw.o.th.yj.de.class, cls10, feVar5);
        this.f4651yj = new fe(context, arrayPool, this.f4650uk, new fe.rg.qw.when.fe.rg(), adVar, map, ukVar, i2);
    }

    @NonNull
    public static th aaa(@NonNull View view) {
        return m295if(view.getContext()).m253if(view);
    }

    @NonNull
    public static ad de(@NonNull Context context) {
        if (f172switch == null) {
            synchronized (ad.class) {
                if (f172switch == null) {
                    qw(context);
                }
            }
        }
        return f172switch;
    }

    @Nullable
    public static GeneratedAppGlideModule fe() {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
    public static RequestManagerRetriever m295if(@Nullable Context context) {
        fe.rg.qw.ggg.uk.rg(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return de(context).pf();
    }

    @NonNull
    public static th mmm(@NonNull Context context) {
        return m295if(context).pf(context);
    }

    @NonNull
    public static th nn(@NonNull Activity activity) {
        return m295if(activity).i(activity);
    }

    @NonNull
    public static th qqq(@NonNull FragmentActivity fragmentActivity) {
        return m295if(fragmentActivity).when(fragmentActivity);
    }

    public static void qw(@NonNull Context context) {
        if (!when) {
            when = true;
            m296switch(context);
            when = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m296switch(@NonNull Context context) {
        when(context, new de());
    }

    public static void vvv(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static void when(@NonNull Context context, @NonNull de deVar) {
        Context applicationContext = context.getApplicationContext();
        GeneratedAppGlideModule fe2 = fe();
        List<GlideModule> emptyList = Collections.emptyList();
        if (fe2 == null || fe2.de()) {
            emptyList = new fe.rg.qw.p016if.fe(applicationContext).qw();
        }
        if (fe2 != null && !fe2.fe().isEmpty()) {
            Set<Class<?>> fe3 = fe2.fe();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (fe3.contains(next.getClass())) {
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
        deVar.ad(fe2 != null ? fe2.rg() : null);
        for (GlideModule qw : emptyList) {
            qw.qw(applicationContext, deVar);
        }
        if (fe2 != null) {
            fe2.qw(applicationContext, deVar);
        }
        ad qw2 = deVar.qw(applicationContext);
        for (GlideModule ad2 : emptyList) {
            ad2.ad(applicationContext, qw2, qw2.f4650uk);
        }
        if (fe2 != null) {
            fe2.ad(applicationContext, qw2, qw2.f4650uk);
        }
        applicationContext.registerComponentCallbacks(qw2);
        f172switch = qw2;
    }

    public void ad() {
        fe.rg.qw.ggg.i.qw();
        this.f4649th.ad();
        this.f4645ad.ad();
        this.f4646i.ad();
    }

    public void ddd(th thVar) {
        synchronized (this.f173if) {
            if (this.f173if.contains(thVar)) {
                this.f173if.remove(thVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public boolean ggg(@NonNull Target<?> target) {
        synchronized (this.f173if) {
            for (th aaa : this.f173if) {
                if (aaa.aaa(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public fe i() {
        return this.f4651yj;
    }

    @NonNull
    public Registry o() {
        return this.f4650uk;
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
        return this.f4647o;
    }

    public void ppp(th thVar) {
        synchronized (this.f173if) {
            if (!this.f173if.contains(thVar)) {
                this.f173if.add(thVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @NonNull
    public ArrayPool rg() {
        return this.f4646i;
    }

    @NonNull
    public BitmapPool th() {
        return this.f4645ad;
    }

    @NonNull
    public Context uk() {
        return this.f4651yj.getBaseContext();
    }

    public void xxx(int i2) {
        fe.rg.qw.ggg.i.qw();
        this.f4649th.qw(i2);
        this.f4645ad.qw(i2);
        this.f4646i.qw(i2);
    }

    public ConnectivityMonitorFactory yj() {
        return this.f4648pf;
    }
}
