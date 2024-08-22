package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* renamed from: fe.switch.qw.qqq  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qqq implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi qw;

    public /* synthetic */ qqq(Messages.NativeRouterApi nativeRouterApi) {
        this.qw = nativeRouterApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        j.de(this.qw, obj, reply);
    }
}
