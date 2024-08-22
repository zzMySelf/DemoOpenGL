package fe.mmm.qw.xxx.p032if.th;

import android.os.Handler;
import android.os.Message;
import com.tera.scan.main.ui.view.ScanHomeBannerView;

/* renamed from: fe.mmm.qw.xxx.if.th.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Handler.Callback {
    public final /* synthetic */ ScanHomeBannerView qw;

    public /* synthetic */ qw(ScanHomeBannerView scanHomeBannerView) {
        this.qw = scanHomeBannerView;
    }

    public final boolean handleMessage(Message message) {
        return ScanHomeBannerView.m832viewHandler$lambda0(this.qw, message);
    }
}
