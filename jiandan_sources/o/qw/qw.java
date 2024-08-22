package o.qw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class qw implements MethodChannel.MethodCallHandler {
    @Deprecated

    /* renamed from: ad  reason: collision with root package name */
    public PluginRegistry.Registrar f6485ad;

    /* renamed from: i  reason: collision with root package name */
    public GPUImage f6486i;

    /* renamed from: o  reason: collision with root package name */
    public Bitmap f6487o;

    /* renamed from: pf  reason: collision with root package name */
    public long f6488pf = 0;

    /* renamed from: th  reason: collision with root package name */
    public FlutterPlugin.FlutterPluginBinding f6489th;

    /* renamed from: uk  reason: collision with root package name */
    public yj.qw.qw.qw.qw.de.ad f6490uk;

    /* renamed from: yj  reason: collision with root package name */
    public final MethodChannel f6491yj;

    public class ad implements Observer<Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6492ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f6493th;

        public ad(qw qwVar, MethodChannel.Result result, MethodCall methodCall) {
            this.f6492ad = result;
            this.f6493th = methodCall;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            th2.getMessage();
            MethodChannel.Result result = this.f6492ad;
            result.error(this.f6493th.method + " failed", (String) null, th2);
        }

        public void onSubscribe(Disposable disposable) {
        }

        /* renamed from: qw */
        public void onNext(Boolean bool) {
            this.f6492ad.success((Object) null);
        }
    }

    public class de implements Function<String, Boolean> {
        public de() {
        }

        /* renamed from: qw */
        public Boolean apply(String str) throws Exception {
            InputStream inputStream;
            InputStream inputStream2 = null;
            try {
                if (qw.this.f6485ad != null) {
                    inputStream = qw.this.f6485ad.context().getAssets().open(qw.this.f6485ad.lookupKeyForAsset(str));
                } else {
                    inputStream = qw.this.f6489th.getApplicationContext().getAssets().open(qw.this.f6489th.getFlutterAssets().getAssetFilePathByName(str));
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (qw.ggg(inputStream.available(), qw.this.f6487o)) {
                        options.inBitmap = qw.this.f6487o;
                    } else {
                        qw.this.ppp();
                    }
                    Bitmap unused = qw.this.f6487o = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    qw.this.when();
                    Boolean bool = Boolean.TRUE;
                    qw.m670if(inputStream);
                    return bool;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    inputStream2 = inputStream;
                    th = th3;
                    qw.m670if(inputStream2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                qw.m670if(inputStream2);
                throw th;
            }
        }
    }

    public class fe implements Observer<Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6495ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f6496th;

        public fe(qw qwVar, MethodChannel.Result result, MethodCall methodCall) {
            this.f6495ad = result;
            this.f6496th = methodCall;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            th2.getMessage();
            MethodChannel.Result result = this.f6495ad;
            result.error(this.f6496th.method + " failed", (String) null, th2);
        }

        public void onSubscribe(Disposable disposable) {
        }

        /* renamed from: qw */
        public void onNext(Boolean bool) {
            this.f6495ad.success((Object) null);
        }
    }

    public class i implements Function<Pair<Long, Bitmap>, ByteArrayOutputStream> {
        public i() {
        }

        /* renamed from: qw */
        public ByteArrayOutputStream apply(Pair<Long, Bitmap> pair) throws Exception {
            Long l = (Long) pair.first;
            Bitmap bitmap = (Bitmap) pair.second;
            "exportData observe bitmap version : " + l;
            if (qw.this.f6488pf != l.longValue()) {
                return null;
            }
            qw.this.f6486i.xxx(qw.this.f6490uk);
            if (bitmap == null) {
                return null;
            }
            qw.this.f6486i.mmm(bitmap);
            Bitmap o2 = qw.this.f6486i.o();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            o2.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream);
            return byteArrayOutputStream;
        }
    }

    public class o implements Observer<Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6498ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f6499th;

        public o(qw qwVar, MethodChannel.Result result, MethodCall methodCall) {
            this.f6498ad = result;
            this.f6499th = methodCall;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            MethodChannel.Result result = this.f6498ad;
            result.error(this.f6499th.method + " failed", (String) null, th2);
        }

        public void onSubscribe(Disposable disposable) {
        }

        /* renamed from: qw */
        public void onNext(Boolean bool) {
            this.f6498ad.success((Object) null);
        }
    }

    /* renamed from: o.qw.qw$qw  reason: collision with other inner class name */
    public class C0254qw implements Function<Pair<Long, Bitmap>, Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f6500ad;

        public C0254qw(String str) {
            this.f6500ad = str;
        }

        /* renamed from: qw */
        public Boolean apply(Pair<Long, Bitmap> pair) throws Exception {
            Long l = (Long) pair.first;
            Bitmap bitmap = (Bitmap) pair.second;
            "exportImage observe bitmap version : " + l;
            long i2 = qw.this.f6488pf;
            long longValue = l.longValue();
            FileOutputStream fileOutputStream = null;
            if (i2 != longValue) {
                return null;
            }
            qw.this.f6486i.xxx(qw.this.f6490uk);
            if (bitmap == null) {
                return null;
            }
            qw.this.f6486i.mmm(bitmap);
            Bitmap o2 = qw.this.f6486i.o();
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f6500ad);
                try {
                    if (this.f6500ad.endsWith(BrowserServiceFileProvider.FILE_EXTENSION)) {
                        o2.compress(Bitmap.CompressFormat.PNG, 95, fileOutputStream2);
                    } else {
                        o2.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream2);
                    }
                    Boolean bool = Boolean.TRUE;
                    qw.m670if(fileOutputStream2);
                    return bool;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    qw.m670if(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                qw.m670if(fileOutputStream);
                throw th;
            }
        }
    }

    public class rg implements Function<String, Boolean> {
        public rg() {
        }

        /* renamed from: qw */
        public Boolean apply(String str) throws Exception {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (qw.ggg(fileInputStream2.available(), qw.this.f6487o)) {
                        options.inBitmap = qw.this.f6487o;
                    } else {
                        qw.this.ppp();
                    }
                    Bitmap unused = qw.this.f6487o = BitmapFactory.decodeStream(fileInputStream2, (Rect) null, options);
                    qw.this.when();
                    Boolean bool = Boolean.TRUE;
                    qw.m670if(fileInputStream2);
                    return bool;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    qw.m670if(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                qw.m670if(fileInputStream);
                throw th;
            }
        }
    }

    public class th implements Observer<Boolean> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6503ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f6504th;

        public th(qw qwVar, MethodChannel.Result result, MethodCall methodCall) {
            this.f6503ad = result;
            this.f6504th = methodCall;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            th2.getMessage();
            MethodChannel.Result result = this.f6503ad;
            result.error(this.f6504th.method + " failed", (String) null, th2);
        }

        public void onSubscribe(Disposable disposable) {
        }

        /* renamed from: qw */
        public void onNext(Boolean bool) {
            this.f6503ad.success((Object) null);
        }
    }

    public class uk implements Observer<ByteArrayOutputStream> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f6505ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ MethodCall f6506th;

        public uk(qw qwVar, MethodChannel.Result result, MethodCall methodCall) {
            this.f6505ad = result;
            this.f6506th = methodCall;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            MethodChannel.Result result = this.f6505ad;
            result.error(this.f6506th.method + " failed", (String) null, th2);
        }

        public void onSubscribe(Disposable disposable) {
        }

        /* renamed from: qw */
        public void onNext(ByteArrayOutputStream byteArrayOutputStream) {
            if (byteArrayOutputStream != null) {
                this.f6505ad.success(byteArrayOutputStream.toByteArray());
            }
        }
    }

    public class yj implements Function<ByteArrayInputStream, Boolean> {
        public yj() {
        }

        /* renamed from: qw */
        public Boolean apply(ByteArrayInputStream byteArrayInputStream) throws Exception {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (qw.ggg(byteArrayInputStream.available(), qw.this.f6487o)) {
                    options.inBitmap = qw.this.f6487o;
                } else {
                    qw.this.ppp();
                }
                Bitmap unused = qw.this.f6487o = BitmapFactory.decodeStream(byteArrayInputStream, (Rect) null, options);
                qw.this.when();
                return Boolean.TRUE;
            } finally {
                qw.m670if(byteArrayInputStream);
            }
        }
    }

    public qw(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, int i2) {
        this.f6489th = flutterPluginBinding;
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "GPUImageFilter-" + i2);
        this.f6491yj = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.f6486i = new GPUImage(flutterPluginBinding.getApplicationContext());
    }

    public static boolean ggg(int i2, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable() || Build.VERSION.SDK_INT < 19 || i2 > bitmap.getAllocationByteCount()) {
            return false;
        }
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m670if(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r14, io.flutter.plugin.common.MethodChannel.Result r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onMethodCall() called with: method = ["
            r0.append(r1)
            java.lang.String r1 = r14.method
            r0.append(r1)
            java.lang.String r1 = "]"
            r0.append(r1)
            r0.toString()
            java.lang.String r0 = r14.method
            java.lang.String r1 = "addFilter"
            boolean r0 = r0.equals(r1)
            java.lang.String r1 = " failed"
            r2 = 0
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r14.arguments     // Catch:{ Exception -> 0x0066 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0066 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            r3.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "jp.co.cyberagent.android.gpuimage.filter."
            r3.append(r4)     // Catch:{ Exception -> 0x0066 }
            r3.append(r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0066 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0066 }
            yj.qw.qw.qw.qw.de.qw r0 = (yj.qw.qw.qw.qw.de.qw) r0     // Catch:{ Exception -> 0x0066 }
            yj.qw.qw.qw.qw.de.ad r3 = r13.f6490uk     // Catch:{ Exception -> 0x0066 }
            if (r3 != 0) goto L_0x004e
            yj.qw.qw.qw.qw.de.ad r3 = new yj.qw.qw.qw.qw.de.ad     // Catch:{ Exception -> 0x0066 }
            r3.<init>()     // Catch:{ Exception -> 0x0066 }
            r13.f6490uk = r3     // Catch:{ Exception -> 0x0066 }
        L_0x004e:
            yj.qw.qw.qw.qw.de.ad r3 = r13.f6490uk     // Catch:{ Exception -> 0x0066 }
            java.util.List r3 = r3.ppp()     // Catch:{ Exception -> 0x0066 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0066 }
            yj.qw.qw.qw.qw.de.ad r4 = r13.f6490uk     // Catch:{ Exception -> 0x0066 }
            r4.m2359switch(r0)     // Catch:{ Exception -> 0x0066 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0066 }
            r15.success(r0)     // Catch:{ Exception -> 0x0066 }
            goto L_0x03b4
        L_0x0066:
            r0 = move-exception
            java.lang.String r3 = r14.method
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = r14.method
            r3.append(r14)
            r3.append(r1)
            java.lang.String r14 = r3.toString()
            r15.error(r14, r2, r0)
            goto L_0x03b4
        L_0x007f:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "removeFilter"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00be
            java.lang.Object r0 = r14.arguments     // Catch:{ Exception -> 0x00a5 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x00a5 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x00a5 }
            yj.qw.qw.qw.qw.de.ad r3 = r13.f6490uk     // Catch:{ Exception -> 0x00a5 }
            java.util.List r3 = r3.ppp()     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r0 = r3.remove(r0)     // Catch:{ Exception -> 0x00a5 }
            yj.qw.qw.qw.qw.de.qw r0 = (yj.qw.qw.qw.qw.de.qw) r0     // Catch:{ Exception -> 0x00a5 }
            r0.qw()     // Catch:{ Exception -> 0x00a5 }
            r15.success(r2)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x03b4
        L_0x00a5:
            r0 = move-exception
            java.lang.String r3 = r14.method
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = r14.method
            r3.append(r14)
            r3.append(r1)
            java.lang.String r14 = r3.toString()
            r15.error(r14, r2, r0)
            goto L_0x03b4
        L_0x00be:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "getFilter"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0102
            java.lang.Object r0 = r14.arguments     // Catch:{ Exception -> 0x00e9 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x00e9 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x00e9 }
            yj.qw.qw.qw.qw.de.ad r3 = r13.f6490uk     // Catch:{ Exception -> 0x00e9 }
            java.util.List r3 = r3.ppp()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00e9 }
            yj.qw.qw.qw.qw.de.qw r0 = (yj.qw.qw.qw.qw.de.qw) r0     // Catch:{ Exception -> 0x00e9 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x00e9 }
            r15.success(r0)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x03b4
        L_0x00e9:
            r0 = move-exception
            java.lang.String r3 = r14.method
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = r14.method
            r3.append(r14)
            r3.append(r1)
            java.lang.String r14 = r3.toString()
            r15.error(r14, r2, r0)
            goto L_0x03b4
        L_0x0102:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "getFiltersCount"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0138
            yj.qw.qw.qw.qw.de.ad r0 = r13.f6490uk     // Catch:{ Exception -> 0x011f }
            java.util.List r0 = r0.ppp()     // Catch:{ Exception -> 0x011f }
            int r0 = r0.size()     // Catch:{ Exception -> 0x011f }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x011f }
            r15.success(r0)     // Catch:{ Exception -> 0x011f }
            goto L_0x03b4
        L_0x011f:
            r0 = move-exception
            java.lang.String r3 = r14.method
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = r14.method
            r3.append(r14)
            r3.append(r1)
            java.lang.String r14 = r3.toString()
            r15.error(r14, r2, r0)
            goto L_0x03b4
        L_0x0138:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "setImageAssetSource"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x016d
            java.lang.Object r0 = r14.arguments
            java.lang.String r0 = (java.lang.String) r0
            th.de.rg r0 = th.de.rg.just(r0)
            th.de.th r1 = th.de.vvv.qw.de()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$de r1 = new o.qw.qw$de
            r1.<init>()
            th.de.rg r0 = r0.map(r1)
            th.de.th r1 = th.de.uk.ad.qw.qw()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$ad r1 = new o.qw.qw$ad
            r1.<init>(r13, r15, r14)
            r0.subscribe(r1)
            goto L_0x03b4
        L_0x016d:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "setImageFileSource"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01a2
            java.lang.Object r0 = r14.arguments
            java.lang.String r0 = (java.lang.String) r0
            th.de.rg r0 = th.de.rg.just(r0)
            th.de.th r1 = th.de.vvv.qw.de()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$rg r1 = new o.qw.qw$rg
            r1.<init>()
            th.de.rg r0 = r0.map(r1)
            th.de.th r1 = th.de.uk.ad.qw.qw()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$fe r1 = new o.qw.qw$fe
            r1.<init>(r13, r15, r14)
            r0.subscribe(r1)
            goto L_0x03b4
        L_0x01a2:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "setImageDataSource"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01dc
            java.lang.Object r0 = r14.arguments
            byte[] r0 = (byte[]) r0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r0)
            th.de.rg r0 = th.de.rg.just(r1)
            th.de.th r1 = th.de.vvv.qw.de()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$yj r1 = new o.qw.qw$yj
            r1.<init>()
            th.de.rg r0 = r0.map(r1)
            th.de.th r1 = th.de.uk.ad.qw.qw()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$th r1 = new o.qw.qw$th
            r1.<init>(r13, r15, r14)
            r0.subscribe(r1)
            goto L_0x03b4
        L_0x01dc:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "exportData"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x022c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exportData bitmap version : "
            r0.append(r1)
            long r1 = r13.f6488pf
            r0.append(r1)
            r0.toString()
            android.util.Pair r0 = new android.util.Pair
            long r1 = r13.f6488pf
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            android.graphics.Bitmap r2 = r13.f6487o
            r0.<init>(r1, r2)
            th.de.rg r0 = th.de.rg.just(r0)
            th.de.th r1 = th.de.vvv.qw.de()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$i r1 = new o.qw.qw$i
            r1.<init>()
            th.de.rg r0 = r0.map(r1)
            th.de.th r1 = th.de.uk.ad.qw.qw()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$uk r1 = new o.qw.qw$uk
            r1.<init>(r13, r15, r14)
            r0.subscribe(r1)
            goto L_0x03b4
        L_0x022c:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "exportImage"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0290
            java.lang.Object r0 = r14.arguments
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "exportImage output path "
            r1.append(r2)
            r1.append(r0)
            r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "exportImage bitmap version : "
            r1.append(r2)
            long r2 = r13.f6488pf
            r1.append(r2)
            r1.toString()
            android.util.Pair r1 = new android.util.Pair
            long r2 = r13.f6488pf
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            android.graphics.Bitmap r3 = r13.f6487o
            r1.<init>(r2, r3)
            th.de.rg r1 = th.de.rg.just(r1)
            th.de.th r2 = th.de.vvv.qw.de()
            th.de.rg r1 = r1.observeOn(r2)
            o.qw.qw$qw r2 = new o.qw.qw$qw
            r2.<init>(r0)
            th.de.rg r0 = r1.map(r2)
            th.de.th r1 = th.de.uk.ad.qw.qw()
            th.de.rg r0 = r0.observeOn(r1)
            o.qw.qw$o r1 = new o.qw.qw$o
            r1.<init>(r13, r15, r14)
            r0.subscribe(r1)
            goto L_0x03b4
        L_0x0290:
            java.lang.String r0 = r14.method
            java.lang.String r3 = "setValue"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L_0x03b1
            java.lang.Object r0 = r14.arguments     // Catch:{ Exception -> 0x0399 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x0399 }
            r3 = 0
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Exception -> 0x0399 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0399 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0399 }
            r5 = 1
            java.lang.Object r6 = r0.get(r5)     // Catch:{ Exception -> 0x0399 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0399 }
            r7 = 2
            java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x0399 }
            yj.qw.qw.qw.qw.de.ad r8 = r13.f6490uk     // Catch:{ Exception -> 0x0399 }
            java.util.List r8 = r8.ppp()     // Catch:{ Exception -> 0x0399 }
            java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x0399 }
            yj.qw.qw.qw.qw.de.qw r4 = (yj.qw.qw.qw.qw.de.qw) r4     // Catch:{ Exception -> 0x0399 }
            java.lang.Class r8 = r4.getClass()     // Catch:{ Exception -> 0x0399 }
            java.lang.reflect.Method[] r8 = r8.getDeclaredMethods()     // Catch:{ Exception -> 0x0399 }
            int r9 = r8.length     // Catch:{ Exception -> 0x0399 }
            r10 = 0
        L_0x02cb:
            if (r10 >= r9) goto L_0x02dd
            r11 = r8[r10]     // Catch:{ Exception -> 0x0399 }
            java.lang.String r12 = r11.getName()     // Catch:{ Exception -> 0x0399 }
            boolean r12 = r6.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0399 }
            if (r12 == 0) goto L_0x02da
            goto L_0x02de
        L_0x02da:
            int r10 = r10 + 1
            goto L_0x02cb
        L_0x02dd:
            r11 = r2
        L_0x02de:
            java.lang.Class[] r6 = r11.getParameterTypes()     // Catch:{ Exception -> 0x0399 }
            r6 = r6[r3]     // Catch:{ Exception -> 0x0399 }
            java.lang.Class r8 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x0399 }
            if (r6 != r8) goto L_0x02fa
            r8 = r0
            java.lang.Double r8 = (java.lang.Double) r8     // Catch:{ Exception -> 0x0399 }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0399 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Exception -> 0x0399 }
            r9[r3] = r8     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r9)     // Catch:{ Exception -> 0x0399 }
        L_0x02fa:
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0399 }
            if (r6 != r8) goto L_0x0310
            r8 = r0
            java.lang.Double r8 = (java.lang.Double) r8     // Catch:{ Exception -> 0x0399 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0399 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0399 }
            r9[r3] = r8     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r9)     // Catch:{ Exception -> 0x0399 }
        L_0x0310:
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0399 }
            if (r6 != r8) goto L_0x0326
            r8 = r0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ Exception -> 0x0399 }
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x0399 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x0399 }
            r9[r3] = r8     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r9)     // Catch:{ Exception -> 0x0399 }
        L_0x0326:
            java.lang.Class<float[]> r8 = float[].class
            if (r6 != r8) goto L_0x0346
            r8 = r0
            java.lang.Double[] r8 = (java.lang.Double[]) r8     // Catch:{ Exception -> 0x0399 }
            int r9 = r8.length     // Catch:{ Exception -> 0x0399 }
            float[] r9 = new float[r9]     // Catch:{ Exception -> 0x0399 }
            r10 = 0
        L_0x0331:
            int r12 = r8.length     // Catch:{ Exception -> 0x0399 }
            if (r10 >= r12) goto L_0x033f
            r12 = r8[r10]     // Catch:{ Exception -> 0x0399 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0399 }
            r9[r10] = r12     // Catch:{ Exception -> 0x0399 }
            int r10 = r10 + 1
            goto L_0x0331
        L_0x033f:
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r8)     // Catch:{ Exception -> 0x0399 }
        L_0x0346:
            java.lang.Class<android.graphics.PointF> r8 = android.graphics.PointF.class
            if (r6 != r8) goto L_0x0365
            r8 = r0
            java.lang.Double[] r8 = (java.lang.Double[]) r8     // Catch:{ Exception -> 0x0399 }
            android.graphics.PointF r9 = new android.graphics.PointF     // Catch:{ Exception -> 0x0399 }
            r10 = r8[r3]     // Catch:{ Exception -> 0x0399 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0399 }
            r8 = r8[r5]     // Catch:{ Exception -> 0x0399 }
            float r8 = r8.floatValue()     // Catch:{ Exception -> 0x0399 }
            r9.<init>(r10, r8)     // Catch:{ Exception -> 0x0399 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r8)     // Catch:{ Exception -> 0x0399 }
        L_0x0365:
            java.lang.Class<android.graphics.PointF[]> r8 = android.graphics.PointF[].class
            if (r6 != r8) goto L_0x0395
            java.lang.Double[] r0 = (java.lang.Double[]) r0     // Catch:{ Exception -> 0x0399 }
            int r6 = r0.length     // Catch:{ Exception -> 0x0399 }
            int r6 = r6 / r7
            android.graphics.PointF[] r6 = new android.graphics.PointF[r6]     // Catch:{ Exception -> 0x0399 }
            r7 = 0
            r8 = 0
        L_0x0371:
            int r9 = r0.length     // Catch:{ Exception -> 0x0399 }
            if (r7 >= r9) goto L_0x038e
            android.graphics.PointF r9 = new android.graphics.PointF     // Catch:{ Exception -> 0x0399 }
            r10 = r0[r7]     // Catch:{ Exception -> 0x0399 }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x0399 }
            int r12 = r7 + 1
            r12 = r0[r12]     // Catch:{ Exception -> 0x0399 }
            float r12 = r12.floatValue()     // Catch:{ Exception -> 0x0399 }
            r9.<init>(r10, r12)     // Catch:{ Exception -> 0x0399 }
            r6[r8] = r9     // Catch:{ Exception -> 0x0399 }
            int r7 = r7 + 2
            int r8 = r8 + 1
            goto L_0x0371
        L_0x038e:
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0399 }
            r0[r3] = r6     // Catch:{ Exception -> 0x0399 }
            r11.invoke(r4, r0)     // Catch:{ Exception -> 0x0399 }
        L_0x0395:
            r15.success(r2)     // Catch:{ Exception -> 0x0399 }
            goto L_0x03b4
        L_0x0399:
            r0 = move-exception
            java.lang.String r3 = r14.method
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = r14.method
            r3.append(r14)
            r3.append(r1)
            java.lang.String r14 = r3.toString()
            r15.error(r14, r2, r0)
            goto L_0x03b4
        L_0x03b1:
            r15.notImplemented()
        L_0x03b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o.qw.qw.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void ppp() {
        Bitmap bitmap = this.f6487o;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f6487o.recycle();
            this.f6487o = null;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m671switch() {
        yj.qw.qw.qw.qw.de.ad adVar = this.f6490uk;
        if (adVar != null) {
            adVar.qw();
            this.f6490uk = null;
        }
        GPUImage gPUImage = this.f6486i;
        if (gPUImage != null) {
            gPUImage.i();
        }
        ppp();
    }

    public final void when() {
        long j = this.f6488pf;
        if (j == Long.MAX_VALUE) {
            this.f6488pf = 0;
        } else {
            this.f6488pf = j + 1;
        }
    }

    @Deprecated
    public qw(PluginRegistry.Registrar registrar, int i2) {
        this.f6485ad = registrar;
        BinaryMessenger messenger = registrar.messenger();
        MethodChannel methodChannel = new MethodChannel(messenger, "GPUImageFilter-" + i2);
        this.f6491yj = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.f6486i = new GPUImage(this.f6489th.getApplicationContext());
    }
}
