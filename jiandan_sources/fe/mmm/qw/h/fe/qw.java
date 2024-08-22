package fe.mmm.qw.h.fe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import th.de.rg;

public class qw {

    public class ad implements ObservableOnSubscribe<String> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f7850ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f7851de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f7852fe;
        public final /* synthetic */ String qw;

        public ad(String str, String str2, int i2, int i3) {
            this.qw = str;
            this.f7850ad = str2;
            this.f7851de = i2;
            this.f7852fe = i3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
            if (new java.io.File(r4.f7850ad).exists() != false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            r5.onNext(r4.f7850ad);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
            if (new java.io.File(r4.f7850ad).exists() != false) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void qw(io.reactivex.ObservableEmitter<java.lang.String> r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.qw     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = r4.f7850ad     // Catch:{ Exception -> 0x0023 }
                int r2 = r4.f7851de     // Catch:{ Exception -> 0x0023 }
                int r3 = r4.f7852fe     // Catch:{ Exception -> 0x0023 }
                fe.mmm.qw.h.fe.qw.de(r0, r1, r2, r3)     // Catch:{ Exception -> 0x0023 }
                java.lang.String r0 = r4.f7850ad
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0046
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r4.f7850ad
                r0.<init>(r1)
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x0046
                goto L_0x0040
            L_0x0021:
                r0 = move-exception
                goto L_0x004c
            L_0x0023:
                r0 = move-exception
                java.lang.String r1 = "compress_upload_compress"
                java.lang.String r2 = "compressImagesPath error "
                fe.mmm.qw.i.qw.th(r1, r2, r0)     // Catch:{ all -> 0x0021 }
                java.lang.String r0 = r4.f7850ad
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0046
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r4.f7850ad
                r0.<init>(r1)
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x0046
            L_0x0040:
                java.lang.String r0 = r4.f7850ad
                r5.onNext(r0)
                goto L_0x004b
            L_0x0046:
                java.lang.String r0 = r4.qw
                r5.onNext(r0)
            L_0x004b:
                return
            L_0x004c:
                java.lang.String r1 = r4.f7850ad
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0067
                java.io.File r1 = new java.io.File
                java.lang.String r2 = r4.f7850ad
                r1.<init>(r2)
                boolean r1 = r1.exists()
                if (r1 == 0) goto L_0x0067
                java.lang.String r1 = r4.f7850ad
                r5.onNext(r1)
                goto L_0x006c
            L_0x0067:
                java.lang.String r1 = r4.qw
                r5.onNext(r1)
            L_0x006c:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.h.fe.qw.ad.qw(io.reactivex.ObservableEmitter):void");
        }
    }

    public class de implements ObservableOnSubscribe<ArrayList<String>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ArrayList f7853ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f7854de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f7855fe;
        public final /* synthetic */ ArrayList qw;

        public de(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
            this.qw = arrayList;
            this.f7853ad = arrayList2;
            this.f7854de = i2;
            this.f7855fe = i3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
            if (r2.isEmpty() == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
            r9.onNext(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
            r9.onNext(r8.qw);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
            if (r2.isEmpty() != false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void qw(io.reactivex.ObservableEmitter<java.util.ArrayList<java.lang.String>> r9) {
            /*
                r8 = this;
                java.lang.String r0 = "compressImagesPath destPathList "
                java.lang.String r1 = "compress_upload_compress"
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                r3 = 0
            L_0x000a:
                java.util.ArrayList r4 = r8.qw     // Catch:{ Exception -> 0x006c }
                int r4 = r4.size()     // Catch:{ Exception -> 0x006c }
                if (r3 >= r4) goto L_0x0044
                java.util.ArrayList r4 = r8.qw     // Catch:{ Exception -> 0x006c }
                java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x006c }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x006c }
                java.util.ArrayList r5 = r8.f7853ad     // Catch:{ Exception -> 0x006c }
                java.lang.Object r5 = r5.get(r3)     // Catch:{ Exception -> 0x006c }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x006c }
                int r6 = r8.f7854de     // Catch:{ Exception -> 0x006c }
                int r7 = r8.f7855fe     // Catch:{ Exception -> 0x006c }
                fe.mmm.qw.h.fe.qw.de(r4, r5, r6, r7)     // Catch:{ Exception -> 0x006c }
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x006c }
                if (r6 != 0) goto L_0x003e
                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x006c }
                r6.<init>(r5)     // Catch:{ Exception -> 0x006c }
                boolean r6 = r6.exists()     // Catch:{ Exception -> 0x006c }
                if (r6 == 0) goto L_0x003e
                r2.add(r5)     // Catch:{ Exception -> 0x006c }
                goto L_0x0041
            L_0x003e:
                r2.add(r4)     // Catch:{ Exception -> 0x006c }
            L_0x0041:
                int r3 = r3 + 1
                goto L_0x000a
            L_0x0044:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                int r0 = r2.size()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                fe.mmm.qw.i.qw.ad(r1, r0)
                boolean r0 = r2.isEmpty()
                if (r0 != 0) goto L_0x0064
            L_0x0060:
                r9.onNext(r2)
                goto L_0x008f
            L_0x0064:
                java.util.ArrayList r0 = r8.qw
                r9.onNext(r0)
                goto L_0x008f
            L_0x006a:
                r3 = move-exception
                goto L_0x0090
            L_0x006c:
                r3 = move-exception
                java.lang.String r4 = "compressImagesPath error "
                fe.mmm.qw.i.qw.th(r1, r4, r3)     // Catch:{ all -> 0x006a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                int r0 = r2.size()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                fe.mmm.qw.i.qw.ad(r1, r0)
                boolean r0 = r2.isEmpty()
                if (r0 != 0) goto L_0x0064
                goto L_0x0060
            L_0x008f:
                return
            L_0x0090:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                int r0 = r2.size()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                fe.mmm.qw.i.qw.ad(r1, r0)
                boolean r0 = r2.isEmpty()
                if (r0 != 0) goto L_0x00b0
                r9.onNext(r2)
                goto L_0x00b5
            L_0x00b0:
                java.util.ArrayList r0 = r8.qw
                r9.onNext(r0)
            L_0x00b5:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.h.fe.qw.de.qw(io.reactivex.ObservableEmitter):void");
        }
    }

    /* renamed from: fe.mmm.qw.h.fe.qw$qw  reason: collision with other inner class name */
    public class C0282qw implements ObservableOnSubscribe<String> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7856ad;
        public final /* synthetic */ String qw;

        public C0282qw(String str, Bitmap bitmap) {
            this.qw = str;
            this.f7856ad = bitmap;
        }

        public void qw(ObservableEmitter<String> observableEmitter) {
            FileOutputStream fileOutputStream;
            Exception e;
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.qw);
                try {
                    this.f7856ad.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
                    fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        fe.mmm.qw.i.qw.rg("compress_upload_compress", e.getLocalizedMessage());
                        fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                        observableEmitter.onNext(this.qw);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        fe.mmm.qw.j.xxx.qw.qw(fileOutputStream2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                Exception exc = e3;
                fileOutputStream = null;
                e = exc;
                fe.mmm.qw.i.qw.rg("compress_upload_compress", e.getLocalizedMessage());
                fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                observableEmitter.onNext(this.qw);
            } catch (Throwable th3) {
                th = th3;
                fe.mmm.qw.j.xxx.qw.qw(fileOutputStream2);
                throw th;
            }
            observableEmitter.onNext(this.qw);
        }
    }

    public static void ad(Bitmap bitmap, String str, Observer<String> observer) {
        rg.create(new C0282qw(str, bitmap)).subscribeOn(th.de.vvv.qw.ad()).observeOn(th.de.uk.ad.qw.qw()).subscribe(observer);
    }

    public static void de(String str, String str2, int i2, int i3) {
        int i4;
        float f;
        String str3 = str;
        String str4 = str2;
        int i5 = i2;
        int i6 = i3;
        if (new File(str3).exists()) {
            int de2 = fe.mmm.qw.j.ddd.qw.de(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str3, options);
            if (de2 != 0 || options.outWidth > i5 || options.outHeight > i6) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                if (de2 == 90 || de2 == 270) {
                    i4 = Math.min(options.outWidth / i6, options.outHeight / i5);
                } else {
                    i4 = Math.min(options.outWidth / i5, options.outHeight / i6);
                }
                fe.mmm.qw.i.qw.ad("compress_upload_compress", "compressImagesPath options.outWidth " + options.outWidth + "options.outHeight " + options.outHeight);
                StringBuilder sb = new StringBuilder();
                sb.append("compressImagesPath sampleSize ");
                sb.append(i4);
                fe.mmm.qw.i.qw.ad("compress_upload_compress", sb.toString());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                options2.inSampleSize = Math.max(1, i4);
                Bitmap decodeFile = BitmapFactory.decodeFile(str3, options2);
                fe.mmm.qw.i.qw.ad("compress_upload_compress", "[decode file] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                if (decodeFile != null) {
                    if (de2 == 90 || de2 == 270) {
                        f = Math.min((((float) i6) * 1.0f) / ((float) options2.outWidth), (((float) i5) * 1.0f) / ((float) options2.outHeight));
                    } else {
                        f = Math.min((((float) i5) * 1.0f) / ((float) options2.outWidth), (((float) i6) * 1.0f) / ((float) options2.outHeight));
                    }
                    float min = Math.min(1.0f, f);
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", "compressImagesPath scale " + min);
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", "compressImagesPath sourceBitmap getWidth: " + decodeFile.getWidth() + " getHeight: " + decodeFile.getHeight());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("compressImagesPath rotate ");
                    sb2.append(de2);
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", sb2.toString());
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", "compressImagesPath destPathStr " + str4);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) de2);
                    matrix.postScale(min, min);
                    Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", "[create bitmap] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime2));
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    File file = new File(str4);
                    FileOutputStream fileOutputStream = null;
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            createBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream2);
                            fe.mmm.qw.j.xxx.qw.qw(fileOutputStream2);
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                fe.mmm.qw.i.qw.rg("compress_upload_compress", e.getLocalizedMessage());
                                fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                                fe.mmm.qw.i.qw.ad("compress_upload_compress", "[save jpeg] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime3));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fe.mmm.qw.i.qw.rg("compress_upload_compress", e.getLocalizedMessage());
                        fe.mmm.qw.j.xxx.qw.qw(fileOutputStream);
                        fe.mmm.qw.i.qw.ad("compress_upload_compress", "[save jpeg] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime3));
                        return;
                    }
                    fe.mmm.qw.i.qw.ad("compress_upload_compress", "[save jpeg] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime3));
                    return;
                }
                return;
            }
            long elapsedRealtime4 = SystemClock.elapsedRealtime();
            fe.mmm.qw.j.xxx.ad.ad(str, str2);
            fe.mmm.qw.i.qw.ad("compress_upload_compress", "[copy file] spent time " + (SystemClock.elapsedRealtime() - elapsedRealtime4));
        }
    }

    public static void fe(String str, String str2, int i2, int i3, Observer<String> observer) {
        if (TextUtils.isEmpty(str)) {
            observer.onError(new NullPointerException("originPath 为空"));
        } else {
            rg.create(new ad(str, str2, i2, i3)).subscribeOn(th.de.vvv.qw.ad()).observeOn(th.de.uk.ad.qw.qw()).subscribe(observer);
        }
    }

    public static void rg(@NotNull ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2, int i2, int i3, @NotNull Observer<ArrayList<String>> observer) {
        if (arrayList == null || arrayList.isEmpty()) {
            observer.onError(new NullPointerException("originPathList isEmpty"));
        } else if (arrayList2 == null || arrayList2.isEmpty()) {
            observer.onError(new NullPointerException("outPutPathList isEmpty"));
        } else if (arrayList2.size() < arrayList.size()) {
            observer.onError(new NullPointerException("pathList size error"));
        } else {
            rg.create(new de(arrayList, arrayList2, i2, i3)).subscribeOn(th.de.vvv.qw.ad()).observeOn(th.de.uk.ad.qw.qw()).subscribe(observer);
        }
    }
}
