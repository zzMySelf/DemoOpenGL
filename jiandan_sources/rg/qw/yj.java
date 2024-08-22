package rg.qw;

import android.content.SharedPreferences;
import java.util.concurrent.Future;
import rg.qw.uk;

public class yj extends uk<Boolean> {

    public class qw implements uk.qw<Boolean> {
        /* renamed from: de */
        public Boolean qw() {
            return Boolean.TRUE;
        }

        /* renamed from: fe */
        public Boolean load(String str) {
            return Boolean.FALSE;
        }

        /* renamed from: rg */
        public String ad(Boolean bool) {
            return String.valueOf(true);
        }
    }

    public yj(Future<SharedPreferences> future) {
        super(future, "first_start", new qw());
    }
}
