package th.qw.qw.qw;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

/* compiled from: lambda */
public final /* synthetic */ class qw implements KeyEventChannel.EventResponseHandler {
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback qw;

    public /* synthetic */ qw(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.qw = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z) {
        this.qw.onKeyEventHandled(Boolean.valueOf(z));
    }
}
