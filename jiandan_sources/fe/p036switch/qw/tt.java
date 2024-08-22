package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* renamed from: fe.switch.qw.tt  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class tt implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi qw;

    public /* synthetic */ tt(Messages.NativeRouterApi nativeRouterApi) {
        this.qw = nativeRouterApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        j.fe(this.qw, obj, reply);
    }
}
