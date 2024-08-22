package fe.when.ad.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class pf {
    public static InputStream ad(String str, ClassLoader classLoader) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        InputStream inputStream = null;
        if (classLoader != null && (inputStream = classLoader.getResourceAsStream(str)) != null) {
            return inputStream;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                inputStream = contextClassLoader.getResourceAsStream(str);
            }
        } catch (Throwable unused) {
        }
        if (inputStream == null) {
            inputStream = pf.class.getResourceAsStream("/" + str);
        }
        return inputStream == null ? ClassLoader.getSystemResourceAsStream(str) : inputStream;
    }

    public static byte[] de(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 1) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static InputStream qw(String str) {
        return ad(str, (ClassLoader) null);
    }
}
