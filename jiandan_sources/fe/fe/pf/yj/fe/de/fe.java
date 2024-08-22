package fe.fe.pf.yj.fe.de;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class fe {
    public static String ad(InputStream inputStream, String str) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        char[] cArr = new char[8192];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read <= 0) {
                return charArrayWriter.toString();
            }
            charArrayWriter.write(cArr, 0, read);
        }
    }

    public static void qw(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
