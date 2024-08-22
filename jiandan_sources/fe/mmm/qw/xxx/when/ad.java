package fe.mmm.qw.xxx.when;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    public final boolean ad(File file) {
        if (file != null && file.isDirectory()) {
            for (String file2 : file.list()) {
                if (!ad(new File(file, file2))) {
                    return false;
                }
            }
        }
        Intrinsics.checkNotNull(file);
        return file.delete();
    }

    public final long de(@Nullable File file) throws Exception {
        long j;
        long j2 = 0;
        try {
            Intrinsics.checkNotNull(file);
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (listFiles[i2].isDirectory()) {
                    j = de(listFiles[i2]);
                } else {
                    j = listFiles[i2].length();
                }
                j2 += j;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j2;
    }

    public final String fe(double d) {
        double d2 = (double) 1024;
        double d3 = d / d2;
        if (d3 < 1.0d) {
            return d + "Byte";
        }
        double d4 = d3 / d2;
        if (d4 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d3));
            return bigDecimal.setScale(2, 4).toPlainString() + "KB";
        }
        double d5 = d4 / d2;
        if (d5 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d4));
            return bigDecimal2.setScale(2, 4).toPlainString() + "MB";
        }
        double d6 = d5 / d2;
        if (d6 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d5));
            return bigDecimal3.setScale(2, 4).toPlainString() + "GB";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d6);
        return bigDecimal4.setScale(2, 4).toPlainString() + "TB";
    }

    public final void qw(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            for (String file : list) {
                ad(new File(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public final String rg(@NotNull List<String> list) throws Exception {
        Intrinsics.checkNotNullParameter(list, "list");
        long j = 0;
        for (String file : list) {
            j += de(new File(file));
        }
        return fe((double) j);
    }
}
