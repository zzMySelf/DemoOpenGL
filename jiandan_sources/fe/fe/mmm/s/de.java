package fe.fe.mmm.s;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.baidu.ubc.inter.IUBCLogIdSpService;
import fe.fe.mmm.q.ad;
import java.util.Map;

public class de implements IUBCLogIdSpService {
    @SuppressLint({"ApplySharedPref"})
    public boolean clean() {
        SharedPreferences.Editor edit = ad.qw().edit();
        edit.clear();
        return edit.commit();
    }

    public Map<String, ?> getAll() {
        return ad.qw().getAll();
    }

    public void putLong(String str, long j) {
        ad.qw().putLong(str, j);
    }
}
