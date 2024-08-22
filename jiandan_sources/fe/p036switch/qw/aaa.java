package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.Map;

/* renamed from: fe.switch.qw.aaa  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class aaa implements Messages.Result {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ BasicMessageChannel.Reply f8796ad;
    public final /* synthetic */ Map qw;

    public /* synthetic */ aaa(Map map, BasicMessageChannel.Reply reply) {
        this.qw = map;
        this.f8796ad = reply;
    }

    public final void success(Object obj) {
        j.qw(this.qw, this.f8796ad, (Void) obj);
    }
}
