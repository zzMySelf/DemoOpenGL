package fe.fe.mmm.q;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;

public class ad extends SharedPrefsWrapper {

    public static final class qw {
        public static final ad qw = new ad();
    }

    public ad() {
        super(KVStorageFactory.getSharedPreferences("com.baidu.searchbox_ubclogid"));
    }

    public static ad qw() {
        return qw.qw;
    }
}
