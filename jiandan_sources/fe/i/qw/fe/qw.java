package fe.i.qw.fe;

import android.content.Context;
import com.baidu.apollon.imagemanager.a;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.FileCopyUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final String f4486ad;

    /* renamed from: de  reason: collision with root package name */
    public File f4487de;

    /* renamed from: fe  reason: collision with root package name */
    public long f4488fe;
    public final C0196qw qw;

    /* renamed from: fe.i.qw.fe.qw$qw  reason: collision with other inner class name */
    public interface C0196qw {
        List<File> a(File file);
    }

    public qw(Context context, String str, C0196qw qwVar) {
        this(context, str, "", qwVar);
    }

    public static synchronized void de(File file) {
        synchronized (qw.class) {
            if (file != null) {
                if (!file.isDirectory()) {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.mkdirs();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        LogUtil.e("FileStorage", e.getMessage(), e);
                    }
                }
            } else {
                return;
            }
        }
        return;
    }

    public static void rg(byte[] bArr, File file) {
        try {
            FileCopyUtils.copy(bArr, file);
        } catch (IOException e) {
            LogUtil.e("FileStorage", e.getMessage(), e);
        }
    }

    public final void ad() {
        if (this.f4488fe < 0) {
            this.f4488fe = a.a - th();
        }
    }

    public void fe(String str, byte[] bArr) {
        C0196qw qwVar;
        List<File> a;
        File qw2 = qw(str);
        de(qw2.getParentFile());
        rg(bArr, qw2);
        ad();
        long length = this.f4488fe - qw(str).length();
        if (!(length >= 0 || (qwVar = this.qw) == null || (a = qwVar.a(this.f4487de)) == null)) {
            for (File next : a) {
                length += next.length();
                next.delete();
            }
        }
        this.f4488fe = length;
    }

    public File qw(String str) {
        File file = new File(this.f4487de, yj(str));
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        return file;
    }

    public final long th() {
        File[] listFiles = this.f4487de.listFiles();
        long j = 0;
        if (listFiles != null && listFiles.length > 0) {
            for (File length : listFiles) {
                j += length.length();
            }
        }
        return j;
    }

    public final String yj(String str) {
        return String.valueOf(str.hashCode()) + this.f4486ad;
    }

    public qw(Context context, String str, String str2, C0196qw qwVar) {
        this.f4488fe = Long.MIN_VALUE;
        this.f4486ad = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                this.f4487de = new File(externalFilesDir, str);
            } else {
                this.f4487de = new File(context.getCacheDir(), str);
            }
        } else {
            this.f4487de = new File(context.getCacheDir(), str);
        }
        if (!this.f4487de.exists()) {
            this.f4487de.mkdirs();
        }
        this.qw = qwVar;
    }
}
