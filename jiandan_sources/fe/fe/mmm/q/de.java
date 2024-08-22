package fe.fe.mmm.q;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;

public class de extends SharedPrefsWrapper {

    public static final class qw {
        public static final de qw = new de();
    }

    public de() {
        super(KVStorageFactory.getSharedPreferences("com.baidu.searchbox_ubc"));
    }

    public static de qw() {
        return qw.qw;
    }
}
