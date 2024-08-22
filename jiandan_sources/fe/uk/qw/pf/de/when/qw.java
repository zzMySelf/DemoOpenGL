package fe.uk.qw.pf.de.when;

import java.io.File;

public class qw {
    public File ad(String str) {
        return new File(str);
    }

    public long de(File file) {
        return file.length();
    }

    public boolean qw(File file) {
        return file.exists();
    }
}
