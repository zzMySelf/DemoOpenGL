package fe.p036switch.qw;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

/* renamed from: fe.switch.qw.xxx  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class xxx implements BasicMessageChannel.Reply {
    public final /* synthetic */ Messages.FlutterRouterApi.Reply qw;

    public /* synthetic */ xxx(Messages.FlutterRouterApi.Reply reply) {
        this.qw = reply;
    }

    public final void reply(Object obj) {
        this.qw.reply(null);
    }
}
