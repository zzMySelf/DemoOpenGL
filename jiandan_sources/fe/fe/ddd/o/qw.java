package fe.fe.ddd.o;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;

public class qw extends SharedPrefsWrapper {

    public static final class ad {
        public static final qw qw = new qw();
    }

    public static qw qw() {
        return ad.qw;
    }

    public qw() {
        super(KVStorageFactory.getSharedPreferences("app_quick_config"));
    }
}
