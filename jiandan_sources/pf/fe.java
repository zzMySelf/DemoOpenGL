package pf;

import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: lambda */
public final /* synthetic */ class fe implements EventListener.Factory {
    public final /* synthetic */ EventListener qw;

    public /* synthetic */ fe(EventListener eventListener) {
        this.qw = eventListener;
    }

    public final EventListener create(Call call) {
        return EventListener.qw(this.qw, call);
    }
}
