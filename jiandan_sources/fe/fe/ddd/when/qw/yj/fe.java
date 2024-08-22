package fe.fe.ddd.when.qw.yj;

import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import fe.fe.ddd.when.yj.ad;
import fe.fe.ddd.when.yj.de;
import fe.fe.ddd.when.yj.qw;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class fe {
    public static final boolean qw = ad.qw;

    public static void ad(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (file != null && jsonWriter != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) fileInputStream);
                        Closeables.closeSafely((Closeable) byteArrayOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) fileInputStream);
                        Closeables.closeSafely((Closeable) byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) byteArrayOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    int round = Math.round(76800.0f);
                    int i2 = 0;
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1 || i2 >= round) {
                            byteArrayOutputStream.flush();
                            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                            i2 += read;
                        }
                    }
                    byteArrayOutputStream.flush();
                    String encodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 11);
                    if (qw) {
                        qw.qw("mini-bdmp : " + encodeToString2);
                    }
                    jsonWriter.name("stacktrace_crashpad_bdmp").value(encodeToString2);
                    Closeables.closeSafely((Closeable) fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) byteArrayOutputStream);
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely((Closeable) fileInputStream);
                    Closeables.closeSafely((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) byteArrayOutputStream);
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                Closeables.closeSafely((Closeable) fileInputStream);
                Closeables.closeSafely((Closeable) byteArrayOutputStream);
                throw th;
            }
            Closeables.closeSafely((Closeable) byteArrayOutputStream);
        }
    }

    public static void qw(@NonNull File file, @NonNull JsonWriter jsonWriter) {
        if (file != null && file.exists() && jsonWriter != null) {
            try {
                Pair<String, Boolean> ddd = de.ddd(file, 20480);
                if (ddd != null && !TextUtils.isEmpty((CharSequence) ddd.first)) {
                    if (qw) {
                        qw.qw("json-extra : " + ((String) ddd.first));
                        "json-extra.size = " + ((String) ddd.first).length();
                    }
                    jsonWriter.name("crash_envir").value((String) ddd.first);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
