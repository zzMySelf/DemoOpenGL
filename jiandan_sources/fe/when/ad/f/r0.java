package fe.when.ad.f;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import java.io.IOException;

public class r0 extends x {
    public r0(String str, c0 c0Var, String str2) throws IOException {
        h(s0.K5, new s0("MediaClip"));
        h(s0.D4, new s0("MCD"));
        s0 s0Var = s0.b3;
        h(s0Var, new w1("Media clip for " + str));
        h(new s0(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC), new w1(str2));
        x xVar = new x();
        xVar.h(new s0("TF"), new w1("TEMPACCESS"));
        h(new s0("P"), xVar);
        h(s0.k0, c0Var.q());
    }
}
