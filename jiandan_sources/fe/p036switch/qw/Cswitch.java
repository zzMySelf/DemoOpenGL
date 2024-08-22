package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* renamed from: fe.switch.qw.switch  reason: invalid class name and invalid package */
/* compiled from: lambda */
public final /* synthetic */ class Cswitch implements BasicMessageChannel.Reply {
    public final /* synthetic */ Messages.FlutterRouterApi.Reply qw;

    public /* synthetic */ Cswitch(Messages.FlutterRouterApi.Reply reply) {
        this.qw = reply;
    }

    public final void reply(Object obj) {
        this.qw.reply(null);
    }
}
