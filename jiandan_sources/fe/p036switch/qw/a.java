package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* renamed from: fe.switch.qw.a  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi qw;

    public /* synthetic */ a(Messages.NativeRouterApi nativeRouterApi) {
        this.qw = nativeRouterApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        j.ad(this.qw, obj, reply);
    }
}
