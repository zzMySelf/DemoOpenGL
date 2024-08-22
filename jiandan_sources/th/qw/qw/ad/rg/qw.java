package th.qw.qw.ad.rg;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

/* compiled from: lambda */
public final /* synthetic */ class qw implements BasicMessageChannel.Reply {
    public final /* synthetic */ KeyEventChannel.EventResponseHandler qw;

    public /* synthetic */ qw(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.qw = eventResponseHandler;
    }

    public final void reply(Object obj) {
        KeyEventChannel.qw(this.qw, obj);
    }
}
