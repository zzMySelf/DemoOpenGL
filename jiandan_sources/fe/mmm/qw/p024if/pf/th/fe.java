package fe.mmm.qw.p024if.pf.th;

import io.flutter.plugin.common.EventChannel;
import java.util.Map;

/* renamed from: fe.mmm.qw.if.pf.th.fe  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class fe implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ EventChannel.EventSink f7921ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Map f7922th;

    public /* synthetic */ fe(EventChannel.EventSink eventSink, Map map) {
        this.f7921ad = eventSink;
        this.f7922th = map;
    }

    public final void run() {
        ggg.ggg(this.f7921ad, this.f7922th);
    }
}
