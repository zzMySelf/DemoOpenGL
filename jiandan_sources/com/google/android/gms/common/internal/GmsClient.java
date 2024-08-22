package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, GmsClientEventManager.GmsClientEventState {
    public final Set<Scope> mScopes;
    public final ClientSettings zafa;
    public final Account zax;

    @KeepForSdk
    @VisibleForTesting
    public GmsClient(Context context, Handler handler, int i2, ClientSettings clientSettings) {
        this(context, handler, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i2, clientSettings, (GoogleApiClient.ConnectionCallbacks) null, (GoogleApiClient.OnConnectionFailedListener) null);
    }

    private final Set<Scope> zaa(@NonNull Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope contains : validateScopes) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zax;
    }

    @KeepForSdk
    public final ClientSettings getClientSettings() {
        return this.zafa;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @KeepForSdk
    public final Set<Scope> getScopes() {
        return this.mScopes;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.mScopes : Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }

    @KeepForSdk
    public GmsClient(Context context, Looper looper, int i2, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i2, clientSettings, (ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    @Nullable
    public static BaseGmsClient.BaseConnectionCallbacks zaa(ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zaf(connectionCallbacks);
    }

    @Nullable
    public static BaseGmsClient.BaseOnConnectionFailedListener zaa(OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zag(onConnectionFailedListener);
    }

    @KeepForSdk
    @Deprecated
    public GmsClient(Context context, Looper looper, int i2, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i2, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    @KeepForSdk
    public GmsClient(Context context, Looper looper, int i2, ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i2, clientSettings, (GoogleApiClient.ConnectionCallbacks) null, (GoogleApiClient.OnConnectionFailedListener) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i2, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i2, zaa(connectionCallbacks), zaa(onConnectionFailedListener), clientSettings.getRealClientClassName());
        this.zafa = clientSettings;
        this.zax = clientSettings.getAccount();
        this.mScopes = zaa(clientSettings.getAllRequestedScopes());
    }

    @VisibleForTesting
    public GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i2, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, gmsClientSupervisor, googleApiAvailability, i2, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public GmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i2, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, handler, gmsClientSupervisor, googleApiAvailability, i2, zaa(connectionCallbacks), zaa(onConnectionFailedListener));
        this.zafa = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        this.zax = clientSettings.getAccount();
        this.mScopes = zaa(clientSettings.getAllRequestedScopes());
    }

    @Deprecated
    @VisibleForTesting
    public GmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i2, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, handler, gmsClientSupervisor, googleApiAvailability, i2, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }
}
