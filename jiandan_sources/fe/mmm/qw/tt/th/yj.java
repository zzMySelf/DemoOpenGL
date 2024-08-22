package fe.mmm.qw.tt.th;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.tera.scan.scanner.zxing.ViewfinderView;

public final class yj implements ResultPointCallback {
    public final ViewfinderView qw;

    public yj(ViewfinderView viewfinderView) {
        this.qw = viewfinderView;
    }

    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.qw.addPossibleResultPoint(resultPoint);
    }
}
