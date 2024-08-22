package rg.qw;

import android.content.SharedPreferences;
import java.util.UUID;
import java.util.concurrent.Future;
import rg.qw.uk;

public class rg extends uk<String> {

    public class qw implements uk.qw<String> {
        public /* bridge */ /* synthetic */ String ad(Object obj) {
            String str = (String) obj;
            rg(str);
            return str;
        }

        /* renamed from: de */
        public String qw() {
            return UUID.randomUUID().toString();
        }

        public String fe(String str) {
            return str;
        }

        public /* bridge */ /* synthetic */ Object load(String str) {
            fe(str);
            return str;
        }

        public String rg(String str) {
            return str;
        }
    }

    public rg(Future<SharedPreferences> future) {
        super(future, "events_distinct_id", new qw());
    }
}
