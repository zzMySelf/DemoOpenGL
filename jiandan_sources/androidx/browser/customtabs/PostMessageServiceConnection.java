package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {
    public static final String TAG = "PostMessageServConn";
    public final Object mLock = new Object();
    public boolean mMessageChannelCreated;
    @Nullable
    public String mPackageName;
    @Nullable
    public IPostMessageService mService;
    public final ICustomTabsCallback mSessionBinder;

    public PostMessageServiceConnection(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        IBinder callbackBinder = customTabsSessionToken.getCallbackBinder();
        if (callbackBinder != null) {
            this.mSessionBinder = ICustomTabsCallback.Stub.asInterface(callbackBinder);
            return;
        }
        throw new IllegalArgumentException("Provided session must have binder.");
    }

    private boolean isBoundToService() {
        return this.mService != null;
    }

    private boolean notifyMessageChannelReadyInternal(@Nullable Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                this.mService.onMessageChannelReady(this.mSessionBinder, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    public boolean bindSessionToPostMessageService(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        return context.bindService(intent, this, 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void cleanup(@NonNull Context context) {
        if (isBoundToService()) {
            unbindFromContext(context);
        }
    }

    public final boolean notifyMessageChannelReady(@Nullable Bundle bundle) {
        this.mMessageChannelCreated = true;
        return notifyMessageChannelReadyInternal(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onDisconnectChannel(@NonNull Context context) {
        unbindFromContext(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onNotifyMessageChannelReady(@Nullable Bundle bundle) {
        return notifyMessageChannelReady(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
        return postMessage(str, bundle);
    }

    public void onPostMessageServiceConnected() {
        if (this.mMessageChannelCreated) {
            notifyMessageChannelReadyInternal((Bundle) null);
        }
    }

    public void onPostMessageServiceDisconnected() {
    }

    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.mService = IPostMessageService.Stub.asInterface(iBinder);
        onPostMessageServiceConnected();
    }

    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.mService = null;
        onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(@NonNull String str, @Nullable Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        synchronized (this.mLock) {
            try {
                this.mService.onPostMessage(this.mSessionBinder, str, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPackageName(@NonNull String str) {
        this.mPackageName = str;
    }

    public void unbindFromContext(@NonNull Context context) {
        if (isBoundToService()) {
            context.unbindService(this);
            this.mService = null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean bindSessionToPostMessageService(@NonNull Context context) {
        String str = this.mPackageName;
        if (str != null) {
            return bindSessionToPostMessageService(context, str);
        }
        throw new IllegalStateException("setPackageName must be called before bindSessionToPostMessageService.");
    }
}
