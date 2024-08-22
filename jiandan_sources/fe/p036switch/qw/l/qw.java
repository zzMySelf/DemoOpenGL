package fe.p036switch.qw.l;

import com.idlefish.flutterboost.containers.FlutterViewContainer;
import java.util.function.Consumer;

/* renamed from: fe.switch.qw.l.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Consumer {
    public final /* synthetic */ StringBuilder qw;

    public /* synthetic */ qw(StringBuilder sb) {
        this.qw = sb;
    }

    public final void accept(Object obj) {
        this.qw.append(((FlutterViewContainer) obj).getUrl() + ',');
    }
}
