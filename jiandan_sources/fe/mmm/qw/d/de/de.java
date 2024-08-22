package fe.mmm.qw.d.de;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import com.baidu.apollon.utils.ResUtils;
import com.tera.scan.themeskin.listener.ISkinCustomDrawableLoader;
import com.tera.scan.themeskin.listener.ISkinLoader;
import com.tera.scan.themeskin.listener.ISkinUpdate;
import com.tera.scan.themeskin.listener.SkinLoaderListener;
import fe.mmm.qw.d.fe.i;
import fe.mmm.qw.d.fe.rg;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class de implements ISkinLoader {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: yj  reason: collision with root package name */
    public static volatile de f7689yj;

    /* renamed from: ad  reason: collision with root package name */
    public Context f7690ad;

    /* renamed from: de  reason: collision with root package name */
    public Resources f7691de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7692fe = false;
    public List<ISkinUpdate> qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f7693rg;

    /* renamed from: th  reason: collision with root package name */
    public ISkinCustomDrawableLoader f7694th;

    public class ad extends AsyncTask<String, Void, Resources> {
        public final /* synthetic */ SkinLoaderListener qw;

        public ad(SkinLoaderListener skinLoaderListener) {
            this.qw = skinLoaderListener;
        }

        /* renamed from: ad */
        public void onPostExecute(Resources resources) {
            if (resources != null) {
                Resources unused = de.this.f7691de = resources;
                de.this.mmm();
                SkinLoaderListener skinLoaderListener = this.qw;
                if (skinLoaderListener != null) {
                    skinLoaderListener.onSuccess();
                }
            } else {
                boolean unused2 = de.this.f7692fe = true;
                SkinLoaderListener skinLoaderListener2 = this.qw;
                if (skinLoaderListener2 != null) {
                    skinLoaderListener2.qw("没有获取到资源");
                }
            }
            if (de.this.f7691de == null && de.this.f7690ad != null) {
                de deVar = de.this;
                Resources unused3 = deVar.f7691de = deVar.f7690ad.getResources();
            }
        }

        public void onPreExecute() {
            SkinLoaderListener skinLoaderListener = this.qw;
            if (skinLoaderListener != null) {
                skinLoaderListener.onStart();
            }
        }

        /* renamed from: qw */
        public Resources doInBackground(String... strArr) {
            try {
                if (strArr.length != 1) {
                    return null;
                }
                String str = rg.rg(de.this.f7690ad) + File.separator + strArr[0];
                fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinManager", "skinPackagePath:", str);
                if (!new File(str).exists()) {
                    return null;
                }
                String unused = de.this.f7693rg = de.this.f7690ad.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
                AssetManager newInstance = AssetManager.class.newInstance();
                newInstance.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(newInstance, new Object[]{str});
                Resources resources = de.this.f7690ad.getResources();
                Resources qw2 = fe.mmm.qw.d.fe.de.qw(newInstance, resources.getDisplayMetrics(), resources.getConfiguration());
                fe.mmm.qw.d.qw.uk(de.this.f7690ad, strArr[0]);
                boolean unused2 = de.this.f7692fe = false;
                return qw2;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class qw implements SkinLoaderListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f7696ad;
        public final /* synthetic */ SkinLoaderListener qw;

        public qw(SkinLoaderListener skinLoaderListener, String str) {
            this.qw = skinLoaderListener;
            this.f7696ad = str;
        }

        public void onStart() {
            SkinLoaderListener skinLoaderListener = this.qw;
            if (skinLoaderListener != null) {
                skinLoaderListener.onStart();
            }
        }

        public void onSuccess() {
            SkinLoaderListener skinLoaderListener = this.qw;
            if (skinLoaderListener != null) {
                skinLoaderListener.onSuccess();
            }
        }

        public void qw(String str) {
            de.this.nn(this.f7696ad, this.qw);
        }
    }

    public static de when() {
        if (f7689yj == null) {
            synchronized (de.class) {
                if (f7689yj == null) {
                    f7689yj = new de();
                }
            }
        }
        return f7689yj;
    }

    public final void aaa(Context context) {
        try {
            for (String str : context.getAssets().list("skin")) {
                File file = new File(rg.rg(context), str);
                if (file.exists()) {
                    file.delete();
                }
                rg.ad(context, str, rg.rg(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ddd(String str, SkinLoaderListener skinLoaderListener) {
        String ppp = ppp(str);
        if (!TextUtils.isEmpty(ppp)) {
            nn(ppp, new qw(skinLoaderListener, str));
        } else {
            nn(str, skinLoaderListener);
        }
    }

    public Resources ggg() {
        return this.f7691de;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        r5 = r4.f7691de.getIdentifier(r4.f7690ad.getResources().getResourceEntryName(r5), com.baidu.apollon.utils.ResUtils.f, r4.f7693rg);
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(int r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.f7690ad
            if (r0 == 0) goto L_0x0030
            android.content.res.Resources r1 = r4.f7691de
            if (r1 != 0) goto L_0x0009
            goto L_0x0030
        L_0x0009:
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r5)
            boolean r1 = r4.f7692fe
            if (r1 == 0) goto L_0x0012
            return r0
        L_0x0012:
            android.content.Context r1 = r4.f7690ad
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r5 = r1.getResourceEntryName(r5)
            android.content.res.Resources r1 = r4.f7691de
            java.lang.String r2 = r4.f7693rg
            java.lang.String r3 = "color"
            int r5 = r1.getIdentifier(r5, r3, r2)
            if (r5 != 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            android.content.res.Resources r0 = r4.f7691de
            int r0 = r0.getColor(r5)
        L_0x002f:
            return r0
        L_0x0030:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.d.de.de.i(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r5 = r4.f7691de.getIdentifier(r4.f7690ad.getResources().getResourceEntryName(r5), com.baidu.apollon.utils.ResUtils.f719i, r4.f7693rg);
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m964if(int r5) {
        /*
            r4 = this;
            android.content.Context r0 = r4.f7690ad
            android.content.res.Resources r0 = r0.getResources()
            float r0 = r0.getDimension(r5)
            int r0 = (int) r0
            boolean r1 = r4.f7692fe
            if (r1 == 0) goto L_0x0010
            return r0
        L_0x0010:
            android.content.Context r1 = r4.f7690ad
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r5 = r1.getResourceEntryName(r5)
            android.content.res.Resources r1 = r4.f7691de
            java.lang.String r2 = r4.f7693rg
            java.lang.String r3 = "dimen"
            int r5 = r1.getIdentifier(r5, r3, r2)
            if (r5 != 0) goto L_0x0027
            goto L_0x002d
        L_0x0027:
            android.content.res.Resources r0 = r4.f7691de
            int r0 = r0.getDimensionPixelSize(r5)
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.d.de.de.m964if(int):int");
    }

    public void mmm() {
        List<ISkinUpdate> list = this.qw;
        if (list != null) {
            for (ISkinUpdate onThemeUpdate : list) {
                onThemeUpdate.onThemeUpdate();
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    public final void nn(String str, SkinLoaderListener skinLoaderListener) {
        new ad(skinLoaderListener).execute(new String[]{str});
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList o(int i2) {
        try {
            boolean z = !this.f7692fe;
            String resourceEntryName = this.f7690ad.getResources().getResourceEntryName(i2);
            fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinManager", "getColorStateList resName = ", resourceEntryName);
            if (!z) {
                return ContextCompat.getColorStateList(this.f7690ad, i2);
            }
            int identifier = this.f7691de.getIdentifier(resourceEntryName, ResUtils.e, this.f7693rg);
            if (identifier == 0) {
                identifier = this.f7691de.getIdentifier(resourceEntryName, ResUtils.f, this.f7693rg);
            }
            if (identifier == 0) {
                return ContextCompat.getColorStateList(this.f7690ad, i2);
            }
            return this.f7691de.getColorStateList(identifier);
        } catch (Exception unused) {
            return ContextCompat.getColorStateList(this.f7690ad, i2);
        }
    }

    public String pf() {
        return this.f7693rg;
    }

    public final String ppp(String str) {
        File file = null;
        if (!fe.mmm.qw.d.qw.yj(this.f7690ad)) {
            return null;
        }
        String de2 = rg.de(this.f7690ad);
        if (TextUtils.isEmpty(de2)) {
            return null;
        }
        File file2 = new File(rg.fe(this.f7690ad), "skin");
        fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinManager", "skin cache dirs = " + file2.listFiles().length);
        if (file2.exists() && file2.listFiles() != null && file2.listFiles().length > 2) {
            for (File file3 : file2.listFiles()) {
                if (file3.getName().endsWith("dark_skin_download.skin")) {
                    String substring = file3.getName().substring(0, file3.getName().length() - 23);
                    fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinManager", "skin name = ", substring);
                    if (rg.qw(substring, de2)) {
                        file = file3;
                        de2 = substring;
                    }
                }
            }
        }
        return file != null ? file.getName() : str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: switch  reason: not valid java name */
    public Drawable m965switch(int i2) {
        ISkinCustomDrawableLoader iSkinCustomDrawableLoader = this.f7694th;
        Drawable qw2 = iSkinCustomDrawableLoader != null ? iSkinCustomDrawableLoader.qw(i2) : null;
        if (qw2 != null) {
            return qw2;
        }
        Drawable drawable = ContextCompat.getDrawable(this.f7690ad, i2);
        if (fe.mmm.qw.d.qw.rg(this.f7690ad)) {
            return drawable;
        }
        String resourceEntryName = this.f7690ad.getResources().getResourceEntryName(i2);
        int identifier = this.f7691de.getIdentifier(resourceEntryName, ResUtils.e, this.f7693rg);
        if (identifier == 0) {
            identifier = this.f7691de.getIdentifier(resourceEntryName, "mipmap", this.f7693rg);
        }
        if (identifier == 0) {
            return drawable;
        }
        if (Build.VERSION.SDK_INT < 22) {
            return this.f7691de.getDrawable(identifier);
        }
        try {
            return this.f7691de.getDrawable(identifier, (Resources.Theme) null);
        } catch (Resources.NotFoundException | Exception unused) {
            return drawable;
        }
    }

    public void uk(ISkinUpdate iSkinUpdate) {
        List<ISkinUpdate> list = this.qw;
        if (list != null && list.contains(iSkinUpdate)) {
            this.qw.remove(iSkinUpdate);
        }
    }

    public void vvv(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f7690ad = applicationContext;
        this.f7691de = applicationContext.getResources();
        i.qw = i.qw(this.f7690ad);
        aaa(this.f7690ad);
        String ad2 = fe.mmm.qw.d.qw.ad(this.f7690ad);
        if (!fe.mmm.qw.d.qw.rg(this.f7690ad)) {
            ddd(ad2, (SkinLoaderListener) null);
        }
    }

    public boolean xxx() {
        return !this.f7692fe && this.f7691de != null;
    }

    public void yj(ISkinUpdate iSkinUpdate) {
        if (this.qw == null) {
            this.qw = new ArrayList();
        }
        if (!this.qw.contains(iSkinUpdate)) {
            this.qw.add(iSkinUpdate);
        }
    }
}
