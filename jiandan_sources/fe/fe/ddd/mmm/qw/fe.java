package fe.fe.ddd.mmm.qw;

import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.track.ui.ITraceFragmentCallback;

public class fe implements ITraceFragmentCallback {

    /* renamed from: ad  reason: collision with root package name */
    public th f1499ad;
    public rg qw;

    public fe() {
        if (DeviceUtil.OSInfo.hasOreo()) {
            this.qw = new rg();
        }
        try {
            if (Class.forName("androidx.fragment.app.FragmentActivity") != null) {
                this.f1499ad = new th();
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r1 = r2.qw;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ad(@androidx.annotation.Nullable android.app.Activity r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            fe.fe.ddd.mmm.qw.th r1 = r2.f1499ad
            if (r1 == 0) goto L_0x000c
            boolean r0 = r1.rg(r3)
        L_0x000c:
            if (r0 != 0) goto L_0x0016
            fe.fe.ddd.mmm.qw.rg r1 = r2.qw
            if (r1 == 0) goto L_0x0016
            boolean r0 = r1.rg(r3)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.mmm.qw.fe.ad(android.app.Activity):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r1 = r2.qw;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean qw(@androidx.annotation.Nullable android.app.Activity r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            fe.fe.ddd.mmm.qw.th r1 = r2.f1499ad
            if (r1 == 0) goto L_0x000c
            boolean r0 = r1.fe(r3)
        L_0x000c:
            if (r0 != 0) goto L_0x0016
            fe.fe.ddd.mmm.qw.rg r1 = r2.qw
            if (r1 == 0) goto L_0x0016
            boolean r0 = r1.fe(r3)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.mmm.qw.fe.qw(android.app.Activity):boolean");
    }
}
