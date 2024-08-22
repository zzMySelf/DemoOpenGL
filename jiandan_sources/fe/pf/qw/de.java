package fe.pf.qw;

import android.os.Build;
import com.baidu.android.util.soloader.SoUtils;
import com.getkeepsafe.relinker.ReLinker;

public final class de implements ReLinker.LibraryLoader {
    public String ad(String str) {
        return str.substring(3, str.length() - 3);
    }

    public String[] de() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        if (!fe.qw(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }

    public void fe(String str) {
        System.load(str);
    }

    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    public String qw(String str) {
        if (!str.startsWith(SoUtils.PRE) || !str.endsWith(SoUtils.EXT)) {
            return System.mapLibraryName(str);
        }
        return str;
    }
}
