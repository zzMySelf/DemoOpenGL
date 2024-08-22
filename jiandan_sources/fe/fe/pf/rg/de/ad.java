package fe.fe.pf.rg.de;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import androidx.biometric.BiometricPrompt;
import com.baidu.sapi2.SapiAccount;
import com.dlife.ctaccountapi.w;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.rg.qw;
import java.io.OutputStream;
import org.json.JSONObject;

public class ad extends fe.fe.pf.rg.qw {

    /* renamed from: th  reason: collision with root package name */
    public qw.C0142qw f2826th;

    /* renamed from: yj  reason: collision with root package name */
    public C0133ad f2827yj = new C0133ad();

    /* renamed from: fe.fe.pf.rg.de.ad$ad  reason: collision with other inner class name */
    public class C0133ad {

        /* renamed from: ad  reason: collision with root package name */
        public String f2828ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f2829de;
        public long qw;

        public C0133ad() {
        }

        public void ad(long j) {
            if (this.qw != j) {
                this.qw = j;
                this.f2829de = true;
            }
        }

        public void de(String str) {
            if (!str.equals(this.f2828ad)) {
                this.f2828ad = str;
                this.f2829de = true;
            }
        }

        public boolean fe() {
            return rg(ad.this.f2826th.yj("pub.dat", true));
        }

        public String qw() {
            return this.f2828ad;
        }

        public final boolean rg(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.qw = jSONObject.getLong("pub_lst_ts");
                    this.f2828ad = jSONObject.getString("pub_id");
                    jSONObject.getInt("d_form_ver");
                    this.f2829de = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean th() {
            if (this.f2829de) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f2828ad);
                    jSONObject.put("pub_lst_ts", this.qw);
                    jSONObject.put("d_form_ver", 1);
                    ad.this.f2826th.i("pub.dat", jSONObject.toString(), true);
                    this.f2829de = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public class de extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f2831fe;

        /* renamed from: rg  reason: collision with root package name */
        public long f2832rg;

        /* renamed from: th  reason: collision with root package name */
        public long f2833th;

        /* renamed from: yj  reason: collision with root package name */
        public String f2834yj;

        public de(ad adVar, String str) {
            super(adVar.f2826th, str);
        }

        public void de(JSONObject jSONObject) {
            this.f2831fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f2832rg = jSONObject.getLong("last_fe_ts");
            this.f2834yj = jSONObject.getString("id");
            this.f2833th = jSONObject.getLong("tar_pkg_lst_up_ts");
            jSONObject.getInt("d_form_ver");
        }

        public String i() {
            return this.f2834yj;
        }

        /* renamed from: if  reason: not valid java name */
        public long m194if() {
            return this.f2833th;
        }

        public boolean o(long j) {
            if (this.f2833th == j) {
                return false;
            }
            this.f2833th = j;
            qw(true);
            return true;
        }

        public boolean pf(String str) {
            if (str.equals(this.f2834yj)) {
                return false;
            }
            this.f2834yj = str;
            qw(true);
            return true;
        }

        public void rg(JSONObject jSONObject) {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f2831fe);
            jSONObject.put("last_fe_ts", this.f2832rg);
            jSONObject.put("id", this.f2834yj);
            jSONObject.put("tar_pkg_lst_up_ts", this.f2833th);
            jSONObject.put("d_form_ver", 1);
        }

        public String th() {
            return this.f2831fe;
        }

        public boolean uk(String str) {
            if (str.equals(this.f2831fe)) {
                return false;
            }
            this.f2831fe = str;
            qw(true);
            return true;
        }

        public boolean yj(long j) {
            if (this.f2832rg == j) {
                return false;
            }
            this.f2832rg = j;
            qw(true);
            return true;
        }
    }

    public static class qw {
        public String qw;

        public static qw fe(String str) {
            JSONObject jSONObject = new JSONObject(new String(new fe.fe.pf.yj.de.ad().qw(Base64.decode(str, 3))));
            qw qwVar = new qw();
            qwVar.de(jSONObject.getString("id"));
            qwVar.ad(jSONObject.getInt("d_form_ver"));
            return qwVar;
        }

        public void ad(int i2) {
        }

        public void de(String str) {
            this.qw = str;
        }

        public String qw() {
            return this.qw;
        }

        public String rg() {
            if (this.qw == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            fe.fe.pf.yj.de.ad adVar = new fe.fe.pf.yj.de.ad();
            jSONObject.put("id", this.qw);
            jSONObject.put("d_form_ver", 1);
            return Base64.encodeToString(adVar.ad(jSONObject.toString().getBytes()), 3);
        }
    }

    public ad() {
        super("esc-ms", 7500000);
    }

    public qw.uk ad(String str, qw.yj yjVar) {
        PackageInfo packageInfo;
        de deVar;
        int i2;
        if (Build.VERSION.SDK_INT < 29) {
            i2 = -101;
        } else {
            Context context = this.qw.qw;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                i2 = -1;
            } else {
                if (yjVar.qw) {
                    deVar = new de(this, str);
                    deVar.fe();
                    if (str.equals(deVar.th()) && packageInfo.lastUpdateTime == deVar.m194if()) {
                        String i3 = deVar.i();
                        if (!TextUtils.isEmpty(i3)) {
                            return qw.uk.th(i3);
                        }
                    }
                } else {
                    deVar = null;
                }
                if (!(context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0)) {
                    i2 = -100;
                } else {
                    try {
                        Cursor query = context.getContentResolver().query(MediaStore.setIncludePending(MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new String[]{"_id", BiometricPrompt.KEY_DESCRIPTION}, "owner_package_name = ? AND relative_path = ?", new String[]{str, "Pictures/" + str + "/helios/"}, "_id DESC");
                        if (query != null) {
                            while (query.moveToNext()) {
                                String string = query.getString(query.getColumnIndexOrThrow(BiometricPrompt.KEY_DESCRIPTION));
                                if (string != null) {
                                    try {
                                        String qw2 = qw.fe(string).qw();
                                        if (!TextUtils.isEmpty(qw2)) {
                                            if (yjVar.qw && deVar != null) {
                                                deVar.pf(qw2);
                                                deVar.yj(System.currentTimeMillis());
                                                deVar.o(packageInfo.lastUpdateTime);
                                                deVar.uk(str);
                                            }
                                            qw.uk th2 = qw.uk.th(qw2);
                                            fe.fe.pf.yj.fe.de.de.qw(query);
                                            if (yjVar.qw && deVar != null) {
                                                deVar.ad();
                                            }
                                            return th2;
                                        }
                                    } catch (Exception unused2) {
                                        continue;
                                    }
                                }
                            }
                        }
                        fe.fe.pf.yj.fe.de.de.qw(query);
                        if (yjVar.qw && deVar != null) {
                            deVar.ad();
                        }
                        i2 = -2;
                    } catch (Exception e) {
                        qw.uk fe2 = qw.uk.fe(e);
                        fe.fe.pf.yj.fe.de.de.qw((Cursor) null);
                        if (yjVar.qw && deVar != null) {
                            deVar.ad();
                        }
                        return fe2;
                    } catch (Throwable th3) {
                        fe.fe.pf.yj.fe.de.de.qw((Cursor) null);
                        if (yjVar.qw && deVar != null) {
                            deVar.ad();
                        }
                        throw th3;
                    }
                }
            }
        }
        return qw.uk.ad(i2);
    }

    public final qw.th i(qw.rg rgVar) {
        Context context = this.qw.qw;
        String packageName = context.getPackageName();
        ContentResolver contentResolver = this.qw.qw.getContentResolver();
        String de2 = this.qw.f2863de.qw("aid").de();
        String qw2 = this.f2827yj.qw();
        if (qw2 != null && TextUtils.equals(qw2, de2)) {
            return qw.th.fe();
        }
        if (Build.VERSION.SDK_INT < 29) {
            return qw.th.qw();
        }
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = null;
        try {
            qw qwVar = new qw();
            qwVar.de(de2);
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream(contentResolver.openFileDescriptor(uk(packageName, contentResolver, qwVar.rg()), w.a, (CancellationSignal) null));
            try {
                o(autoCloseOutputStream2, context);
                this.f2827yj.de(de2);
                this.f2827yj.ad(System.currentTimeMillis());
                qw.th fe2 = qw.th.fe();
                fe.fe.pf.yj.fe.de.de.ad(autoCloseOutputStream2);
                return fe2;
            } catch (Exception e) {
                e = e;
                autoCloseOutputStream = autoCloseOutputStream2;
                try {
                    qw.th de3 = qw.th.de(e);
                    fe.fe.pf.yj.fe.de.de.ad(autoCloseOutputStream);
                    return de3;
                } catch (Throwable th2) {
                    th = th2;
                    fe.fe.pf.yj.fe.de.de.ad(autoCloseOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                autoCloseOutputStream = autoCloseOutputStream2;
                fe.fe.pf.yj.fe.de.de.ad(autoCloseOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            qw.th de32 = qw.th.de(e);
            fe.fe.pf.yj.fe.de.de.ad(autoCloseOutputStream);
            return de32;
        }
    }

    public final void o(OutputStream outputStream, Context context) {
        float f;
        Drawable loadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        int intrinsicWidth = loadIcon.getIntrinsicWidth();
        int intrinsicHeight = loadIcon.getIntrinsicHeight();
        Matrix matrix = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        if (intrinsicWidth > 96 || intrinsicHeight > 96) {
            float f2 = (float) 96;
            f = Math.min(f2 / ((float) intrinsicWidth), f2 / ((float) intrinsicHeight));
        } else {
            f = 1.0f;
        }
        float f3 = (float) 96;
        matrix.setScale(f, f);
        matrix.postTranslate((float) Math.round((f3 - (((float) intrinsicWidth) * f)) * 0.5f), (float) Math.round((f3 - (((float) intrinsicHeight) * f)) * 0.5f));
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(matrix);
        loadIcon.setBounds(0, 0, loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight());
        loadIcon.draw(canvas);
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
        createBitmap.recycle();
    }

    public void rg(qw.fe feVar) {
        this.f2826th = this.f2859ad.th("esc-ms");
    }

    public qw.th th(qw.rg rgVar) {
        if (Build.VERSION.SDK_INT < 29) {
            return qw.th.qw();
        }
        this.f2827yj.fe();
        try {
            return i(rgVar);
        } finally {
            this.f2827yj.th();
        }
    }

    public final Uri uk(String str, ContentResolver contentResolver, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", 1);
        int i2 = 0;
        contentValues.put("relative_path", String.format("Pictures/%s/helios", new Object[]{str}));
        contentValues.put(BiometricPrompt.KEY_DESCRIPTION, str2);
        while (true) {
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert != null) {
                    return insert;
                }
                throw new IllegalStateException("file path maybe duplicated");
            } catch (IllegalStateException e) {
                i2++;
                if (i2 <= 5) {
                    contentValues.put("_display_name", "helios-icon-" + i2 + ".JPG");
                } else {
                    throw new IllegalStateException("insert file retry count exceed", e);
                }
            }
        }
    }
}
