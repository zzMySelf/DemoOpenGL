package fe.nn.qw.th;

import com.tekartik.sqflite.operation.Operation;
import fe.nn.qw.fe;
import java.util.List;

public abstract class ad implements Operation {
    public Boolean ad() {
        return rg("inTransaction");
    }

    public fe de() {
        return new fe(yj(), uk());
    }

    public boolean fe() {
        return Boolean.TRUE.equals(qw("noResult"));
    }

    public final Boolean rg(String str) {
        Object qw = qw(str);
        if (qw instanceof Boolean) {
            return (Boolean) qw;
        }
        return null;
    }

    public boolean th() {
        return Boolean.TRUE.equals(qw("continueOnError"));
    }

    public final List<Object> uk() {
        return (List) qw("arguments");
    }

    public final String yj() {
        return (String) qw("sql");
    }
}
