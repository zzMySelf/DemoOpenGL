package fe.mmm.qw.tt.ad.ppp;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ResultPointCallback {
    public static final /* synthetic */ qw qw = new qw();

    private /* synthetic */ qw() {
    }

    public final void foundPossibleResultPoint(ResultPoint resultPoint) {
        fe.mmm.qw.i.qw.ad("DecodeHandler", "ResultPointCallback : " + resultPoint.toString());
    }
}
