package fe.nn.qw.th;

import com.tekartik.sqflite.operation.OperationResult;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class rg extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f8794ad;
    public final MethodCall qw;

    public class qw implements OperationResult {
        public final MethodChannel.Result qw;

        public qw(rg rgVar, MethodChannel.Result result) {
            this.qw = result;
        }

        public void error(String str, String str2, Object obj) {
            this.qw.error(str, str2, obj);
        }

        public void success(Object obj) {
            this.qw.success(obj);
        }
    }

    public rg(MethodCall methodCall, MethodChannel.Result result) {
        this.qw = methodCall;
        this.f8794ad = new qw(this, result);
    }

    public OperationResult i() {
        return this.f8794ad;
    }

    public <T> T qw(String str) {
        return this.qw.argument(str);
    }
}
