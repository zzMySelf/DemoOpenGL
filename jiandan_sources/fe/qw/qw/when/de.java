package fe.qw.qw.when;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.baidu.android.common.others.IStringUtil;
import fe.qw.qw.ggg.fe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class de {
    @NonNull
    public final LottieNetworkCacheProvider qw;

    public de(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.qw = lottieNetworkCacheProvider;
    }

    public static String ad(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    @Nullable
    public final File de(String str) throws FileNotFoundException {
        File file = new File(fe(), ad(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(fe(), ad(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public final File fe() {
        File qw2 = this.qw.qw();
        if (qw2.isFile()) {
            qw2.delete();
        }
        if (!qw2.exists()) {
            qw2.mkdirs();
        }
        return qw2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> qw(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = r5.de(r6)     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x001c
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.ZIP
            goto L_0x001e
        L_0x001c:
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.JSON
        L_0x001e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cache hit for "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = " at "
            r3.append(r6)
            java.lang.String r6 = r1.getAbsolutePath()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            fe.qw.qw.ggg.fe.qw(r6)
            android.util.Pair r6 = new android.util.Pair
            r6.<init>(r0, r2)
            return r6
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.when.de.qw(java.lang.String):android.util.Pair");
    }

    public void rg(String str, FileExtension fileExtension) {
        File file = new File(fe(), ad(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        fe.qw("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            fe.de("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + IStringUtil.CURRENT_PATH);
        }
    }

    public File th(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(fe(), ad(str, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
