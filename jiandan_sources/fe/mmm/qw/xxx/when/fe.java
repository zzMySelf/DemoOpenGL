package fe.mmm.qw.xxx.when;

import java.io.File;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class fe implements Comparator<File> {
    public fe() {
        Collator.getInstance(Locale.CHINA);
    }

    /* renamed from: qw */
    public int compare(File file, File file2) {
        int i2 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? -1 : 1;
    }
}
