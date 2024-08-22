package fe.pf.qw;

import android.content.Context;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.util.soloader.SoUtils;
import com.getkeepsafe.relinker.MissingLibraryException;
import com.getkeepsafe.relinker.ReLinker;
import fe.pf.qw.rg.rg;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public final ReLinker.LibraryLoader f4631ad;

    /* renamed from: de  reason: collision with root package name */
    public final ReLinker.LibraryInstaller f4632de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4633fe;
    public final Set<String> qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f4634rg;

    /* renamed from: th  reason: collision with root package name */
    public ReLinker.Logger f4635th;

    /* renamed from: fe.pf.qw.ad$ad  reason: collision with other inner class name */
    public class C0201ad implements FilenameFilter {
        public final /* synthetic */ String qw;

        public C0201ad(ad adVar, String str) {
            this.qw = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.qw);
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4636ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f4638th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ ReLinker.LoadListener f4639uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ String f4640yj;

        public qw(Context context, String str, String str2, ReLinker.LoadListener loadListener) {
            this.f4636ad = context;
            this.f4638th = str;
            this.f4640yj = str2;
            this.f4639uk = loadListener;
        }

        public void run() {
            try {
                ad.this.yj(this.f4636ad, this.f4638th, this.f4640yj);
                this.f4639uk.success();
            } catch (UnsatisfiedLinkError e) {
                this.f4639uk.qw(e);
            } catch (MissingLibraryException e2) {
                this.f4639uk.qw(e2);
            }
        }
    }

    public ad() {
        this(new de(), new qw());
    }

    public void ad(Context context, String str, String str2) {
        File de2 = de(context);
        File fe2 = fe(context, str, str2);
        File[] listFiles = de2.listFiles(new C0201ad(this, this.f4631ad.qw(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f4633fe || !file.getAbsolutePath().equals(fe2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    public File de(Context context) {
        return context.getDir(SoUtils.PRE, 0);
    }

    public File fe(Context context, String str, String str2) {
        String qw2 = this.f4631ad.qw(str);
        if (fe.qw(str2)) {
            return new File(de(context), qw2);
        }
        File de2 = de(context);
        return new File(de2, qw2 + IStringUtil.CURRENT_PATH + str2);
    }

    public void i(String str, Object... objArr) {
        uk(String.format(Locale.US, str, objArr));
    }

    public void rg(Context context, String str) {
        th(context, str, (String) null, (ReLinker.LoadListener) null);
    }

    public void th(Context context, String str, String str2, ReLinker.LoadListener loadListener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!fe.qw(str)) {
            i("Beginning load of %s...", str);
            if (loadListener == null) {
                yj(context, str, str2);
            } else {
                new Thread(new qw(context, str, str2, loadListener)).start();
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    public void uk(String str) {
        ReLinker.Logger logger = this.f4635th;
        if (logger != null) {
            logger.log(str);
        }
    }

    public final void yj(Context context, String str, String str2) {
        rg rgVar;
        rg rgVar2;
        if (!this.qw.contains(str) || this.f4633fe) {
            try {
                this.f4631ad.loadLibrary(str);
                this.qw.add(str);
                i("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e) {
                i("Loading the library normally failed: %s", Log.getStackTraceString(e));
                i("%s (%s) was not loaded normally, re-linking...", str, str2);
                File fe2 = fe(context, str, str2);
                if (!fe2.exists() || this.f4633fe) {
                    if (this.f4633fe) {
                        i("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    ad(context, str, str2);
                    this.f4632de.qw(context, this.f4631ad.de(), this.f4631ad.qw(str), fe2, this);
                }
                try {
                    if (this.f4634rg) {
                        rgVar = null;
                        rgVar2 = new rg(fe2);
                        List<String> fe3 = rgVar2.fe();
                        rgVar2.close();
                        for (String ad2 : fe3) {
                            rg(context, this.f4631ad.ad(ad2));
                        }
                    }
                } catch (IOException unused) {
                }
                this.f4631ad.fe(fe2.getAbsolutePath());
                this.qw.add(str);
                i("%s (%s) was re-linked!", str, str2);
            } catch (Throwable th2) {
                th = th2;
                rgVar = rgVar2;
                rgVar.close();
                throw th;
            }
        } else {
            i("%s already loaded previously!", str);
        }
    }

    public ad(ReLinker.LibraryLoader libraryLoader, ReLinker.LibraryInstaller libraryInstaller) {
        this.qw = new HashSet();
        if (libraryLoader == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (libraryInstaller != null) {
            this.f4631ad = libraryLoader;
            this.f4632de = libraryInstaller;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }
}
