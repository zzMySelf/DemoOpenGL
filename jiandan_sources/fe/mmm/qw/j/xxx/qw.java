package fe.mmm.qw.j.xxx;

import java.io.Closeable;
import java.io.IOException;

public class qw {
    public static void qw(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }
}
