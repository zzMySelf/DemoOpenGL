package fe.qw.qw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import androidx.multidex.MultiDexExtractor;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.parser.moshi.JsonReader;
import fe.qw.qw.ppp.nn;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f3245ad = {80, 75, 3, 4};
    public static final Map<String, uk<de>> qw = new HashMap();

    public class ad implements LottieListener<Throwable> {
        public final /* synthetic */ String qw;

        public ad(String str) {
            this.qw = str;
        }

        /* renamed from: qw */
        public void onResult(Throwable th2) {
            fe.qw.remove(this.qw);
        }
    }

    public class de implements Callable<yj<de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3246ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f3247th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f3248yj;

        public de(Context context, String str, String str2) {
            this.f3246ad = context;
            this.f3247th = str;
            this.f3248yj = str2;
        }

        /* renamed from: qw */
        public yj<de> call() {
            yj<de> de2 = ad.fe(this.f3246ad).de(this.f3247th, this.f3248yj);
            if (!(this.f3248yj == null || de2.ad() == null)) {
                fe.qw.qw.p009switch.rg.ad().de(this.f3248yj, de2.ad());
            }
            return de2;
        }
    }

    /* renamed from: fe.qw.qw.fe$fe  reason: collision with other inner class name */
    public class C0148fe implements Callable<yj<de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3249ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f3250th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f3251yj;

        public C0148fe(Context context, String str, String str2) {
            this.f3249ad = context;
            this.f3250th = str;
            this.f3251yj = str2;
        }

        /* renamed from: qw */
        public yj<de> call() {
            return fe.yj(this.f3249ad, this.f3250th, this.f3251yj);
        }
    }

    public class qw implements LottieListener<de> {
        public final /* synthetic */ String qw;

        public qw(String str) {
            this.qw = str;
        }

        /* renamed from: qw */
        public void onResult(de deVar) {
            fe.qw.remove(this.qw);
        }
    }

    public class rg implements Callable<yj<de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ WeakReference f3252ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f3253th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f3254uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f3255yj;

        public rg(WeakReference weakReference, Context context, int i2, String str) {
            this.f3252ad = weakReference;
            this.f3253th = context;
            this.f3255yj = i2;
            this.f3254uk = str;
        }

        /* renamed from: qw */
        public yj<de> call() {
            Context context = (Context) this.f3252ad.get();
            if (context == null) {
                context = this.f3253th;
            }
            return fe.ggg(context, this.f3255yj, this.f3254uk);
        }
    }

    public class th implements Callable<yj<de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ InputStream f3256ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f3257th;

        public th(InputStream inputStream, String str) {
            this.f3256ad = inputStream;
            this.f3257th = str;
        }

        /* renamed from: qw */
        public yj<de> call() {
            return fe.i(this.f3256ad, this.f3257th);
        }
    }

    public class yj implements Callable<yj<de>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ de f3258ad;

        public yj(de deVar) {
            this.f3258ad = deVar;
        }

        /* renamed from: qw */
        public yj<de> call() {
            return new yj<>(this.f3258ad);
        }
    }

    public static Boolean aaa(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b : f3245ad) {
                if (peek.readByte() != b) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            fe.qw.qw.ggg.fe.ad("Failed to check zip file header", e);
            return Boolean.FALSE;
        }
    }

    public static uk<de> ad(@Nullable String str, Callable<yj<de>> callable) {
        de qw2 = str == null ? null : fe.qw.qw.p009switch.rg.ad().qw(str);
        if (qw2 != null) {
            return new uk<>(new yj(qw2));
        }
        if (str != null && qw.containsKey(str)) {
            return qw.get(str);
        }
        uk<de> ukVar = new uk<>(callable);
        if (str != null) {
            ukVar.th(new qw(str));
            ukVar.rg(new ad(str));
            qw.put(str, ukVar);
        }
        return ukVar;
    }

    @WorkerThread
    public static yj<de> ddd(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return nn(zipInputStream, str);
        } finally {
            fe.qw.qw.ggg.yj.de(zipInputStream);
        }
    }

    @Nullable
    public static th de(de deVar, String str) {
        for (th next : deVar.i().values()) {
            if (next.ad().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static uk<de> fe(Context context, String str) {
        return rg(context, str, "asset_" + str);
    }

    @WorkerThread
    public static yj<de> ggg(Context context, @RawRes int i2, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i2)));
            if (aaa(buffer).booleanValue()) {
                return ddd(new ZipInputStream(buffer.inputStream()), str);
            }
            return i(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e) {
            return new yj<>((Throwable) e);
        }
    }

    @WorkerThread
    public static yj<de> i(InputStream inputStream, @Nullable String str) {
        return o(inputStream, str, true);
    }

    /* renamed from: if  reason: not valid java name */
    public static yj<de> m228if(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            de qw2 = nn.qw(jsonReader);
            if (str != null) {
                fe.qw.qw.p009switch.rg.ad().de(str, qw2);
            }
            yj<de> yjVar = new yj<>(qw2);
            if (z) {
                fe.qw.qw.ggg.yj.de(jsonReader);
            }
            return yjVar;
        } catch (Exception e) {
            yj<de> yjVar2 = new yj<>((Throwable) e);
            if (z) {
                fe.qw.qw.ggg.yj.de(jsonReader);
            }
            return yjVar2;
        } catch (Throwable th2) {
            if (z) {
                fe.qw.qw.ggg.yj.de(jsonReader);
            }
            throw th2;
        }
    }

    public static boolean mmm(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @WorkerThread
    public static yj<de> nn(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            de deVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    deVar = m228if(JsonReader.ggg(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).ad();
                } else {
                    if (!name.contains(BrowserServiceFileProvider.FILE_EXTENSION)) {
                        if (!name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (deVar == null) {
                return new yj<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                th de2 = de(deVar, (String) entry.getKey());
                if (de2 != null) {
                    de2.th(fe.qw.qw.ggg.yj.m232if((Bitmap) entry.getValue(), de2.rg(), de2.de()));
                }
            }
            for (Map.Entry next : deVar.i().entrySet()) {
                if (((th) next.getValue()).qw() == null) {
                    return new yj<>((Throwable) new IllegalStateException("There is no image for " + ((th) next.getValue()).ad()));
                }
            }
            if (str != null) {
                fe.qw.qw.p009switch.rg.ad().de(str, deVar);
            }
            return new yj<>(deVar);
        } catch (IOException e) {
            return new yj<>((Throwable) e);
        }
    }

    @WorkerThread
    public static yj<de> o(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return pf(JsonReader.ggg(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                fe.qw.qw.ggg.yj.de(inputStream);
            }
        }
    }

    @WorkerThread
    public static yj<de> pf(JsonReader jsonReader, @Nullable String str) {
        return m228if(jsonReader, str, true);
    }

    @WorkerThread
    public static yj<de> ppp(Context context, @RawRes int i2) {
        return ggg(context, i2, qqq(context, i2));
    }

    public static String qqq(Context context, @RawRes int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(mmm(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }

    public static uk<de> rg(Context context, String str, @Nullable String str2) {
        return ad(str2, new C0148fe(context.getApplicationContext(), str, str2));
    }

    /* renamed from: switch  reason: not valid java name */
    public static uk<de> m229switch(Context context, @RawRes int i2) {
        return when(context, i2, qqq(context, i2));
    }

    @WorkerThread
    public static yj<de> th(Context context, String str) {
        return yj(context, str, "asset_" + str);
    }

    public static uk<de> uk(InputStream inputStream, @Nullable String str) {
        return ad(str, new th(inputStream, str));
    }

    public static uk<de> vvv(Context context, String str) {
        return xxx(context, str, "url_" + str);
    }

    public static uk<de> when(Context context, @RawRes int i2, @Nullable String str) {
        return ad(str, new rg(new WeakReference(context), context.getApplicationContext(), i2, str));
    }

    public static uk<de> xxx(Context context, String str, @Nullable String str2) {
        return ad(str2, new de(context, str, str2));
    }

    @WorkerThread
    public static yj<de> yj(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(MultiDexExtractor.EXTRACTED_SUFFIX)) {
                if (!str.endsWith(".lottie")) {
                    return i(context.getAssets().open(str), str2);
                }
            }
            return ddd(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new yj<>((Throwable) e);
        }
    }
}
