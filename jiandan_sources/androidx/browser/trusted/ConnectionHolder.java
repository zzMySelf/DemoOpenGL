package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import de.qw.ad.qw;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHolder implements ServiceConnection {
    public static final int STATE_AWAITING_CONNECTION = 0;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_DISCONNECTED = 2;
    @Nullable
    public Exception mCancellationException;
    @NonNull
    public final Runnable mCloseRunnable;
    @NonNull
    public List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> mCompleters;
    @Nullable
    public TrustedWebActivityServiceConnection mService;
    public int mState;
    @NonNull
    public final WrapperFactory mWrapperFactory;

    public static class WrapperFactory {
        @NonNull
        public TrustedWebActivityServiceConnection create(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
        }
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable) {
        this(runnable, new WrapperFactory());
    }

    @MainThread
    public void cancel(@NonNull Exception exc) {
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> exception : this.mCompleters) {
            exception.setException(exc);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exc;
    }

    @MainThread
    @NonNull
    public ListenableFuture<TrustedWebActivityServiceConnection> getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture(new qw(this));
    }

    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.create(componentName, iBinder);
        for (CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection> completer : this.mCompleters) {
            completer.set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }

    public /* synthetic */ Object qw(CallbackToFutureAdapter.Completer completer) throws Exception {
        int i2 = this.mState;
        if (i2 == 0) {
            this.mCompleters.add(completer);
        } else if (i2 == 1) {
            TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = this.mService;
            if (trustedWebActivityServiceConnection != null) {
                completer.set(trustedWebActivityServiceConnection);
            } else {
                throw new IllegalStateException("ConnectionHolder state is incorrect.");
            }
        } else if (i2 == 2) {
            throw new IllegalStateException("Service has been disconnected.");
        } else if (i2 != 3) {
            throw new IllegalStateException("Connection state is invalid");
        } else {
            throw this.mCancellationException;
        }
        return "ConnectionHolder, state = " + this.mState;
    }

    @MainThread
    public ConnectionHolder(@NonNull Runnable runnable, @NonNull WrapperFactory wrapperFactory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = runnable;
        this.mWrapperFactory = wrapperFactory;
    }
}
