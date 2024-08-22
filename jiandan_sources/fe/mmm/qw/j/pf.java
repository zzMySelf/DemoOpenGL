package fe.mmm.qw.j;

import android.util.Xml;
import fe.mmm.qw.j.xxx.qw;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class pf {
    public static String ad(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
            qw.qw(inputStream);
        }
        return sb.toString();
    }

    public static String qw(InputStream inputStream) {
        return ad(inputStream, Xml.Encoding.UTF_8.toString());
    }
}
