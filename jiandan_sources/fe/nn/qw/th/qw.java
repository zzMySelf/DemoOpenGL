package fe.nn.qw.th;

import com.tekartik.sqflite.operation.OperationResult;

public abstract class qw extends ad {
    public void error(String str, String str2, Object obj) {
        i().error(str, str2, obj);
    }

    public abstract OperationResult i();

    public void success(Object obj) {
        i().success(obj);
    }
}
