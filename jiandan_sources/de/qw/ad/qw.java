package de.qw.ad;

import androidx.browser.trusted.ConnectionHolder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: lambda */
public final /* synthetic */ class qw implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ConnectionHolder qw;

    public /* synthetic */ qw(ConnectionHolder connectionHolder) {
        this.qw = connectionHolder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.qw.qw(completer);
    }
}
