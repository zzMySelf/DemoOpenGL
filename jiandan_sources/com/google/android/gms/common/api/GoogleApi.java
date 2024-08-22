package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.common.api.internal.zabn;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    public final Api<O> mApi;
    public final Context mContext;
    public final int mId;
    public final O zabj;
    public final ApiKey<O> zabk;
    public final Looper zabl;
    public final GoogleApiClient zabm;
    public final StatusExceptionMapper zabn;
    public final GoogleApiManager zabo;

    @KeepForSdk
    public static class Settings {
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zabp;
        public final Looper zabq;

        @KeepForSdk
        public static class Builder {
            public Looper zabl;
            public StatusExceptionMapper zabn;

            @KeepForSdk
            public Settings build() {
                if (this.zabn == null) {
                    this.zabn = new ApiExceptionMapper();
                }
                if (this.zabl == null) {
                    this.zabl = Looper.getMainLooper();
                }
                return new Settings(this.zabn, this.zabl);
            }

            @KeepForSdk
            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zabl = looper;
                return this;
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zabn = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        public Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zabp = statusExceptionMapper;
            this.zabq = looper;
        }
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, Api<O> api, Looper looper) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zabj = null;
        this.zabl = looper;
        this.zabk = ApiKey.getUniqueApiKey(api);
        this.zabm = new zabn(this);
        GoogleApiManager zab = GoogleApiManager.zab(this.mContext);
        this.zabo = zab;
        this.mId = zab.zabb();
        this.zabn = new ApiExceptionMapper();
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int i2, @NonNull T t) {
        t.zar();
        this.zabo.zaa(this, i2, (BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>) t);
        return t;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zabm;
    }

    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o2 = this.zabj;
        if (!(o2 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o2).getGoogleSignInAccount()) == null) {
            O o3 = this.zabj;
            account = o3 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o3).getAccount() : null;
        } else {
            account = googleSignInAccount2.getAccount();
        }
        ClientSettings.Builder account2 = builder.setAccount(account);
        O o4 = this.zabj;
        if (!(o4 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o4).getGoogleSignInAccount()) == null) {
            set = Collections.emptySet();
        } else {
            set = googleSignInAccount.getRequestedScopes();
        }
        return account2.addAllRequiredScopes(set).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
    }

    @KeepForSdk
    public Task<Boolean> disconnectService() {
        return this.zabo.zac((GoogleApi<?>) this);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@NonNull T t) {
        return zaa(2, t);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@NonNull T t) {
        return zaa(0, t);
    }

    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@NonNull T t, U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(t.getListenerKey().equals(u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zabo.zaa(this, (RegisterListenerMethod<Api.AnyClient, ?>) t, (UnregisterListenerMethod<Api.AnyClient, ?>) u);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> listenerKey) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zabo.zaa(this, listenerKey);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@NonNull T t) {
        return zaa(1, t);
    }

    public final Api<O> getApi() {
        return this.mApi;
    }

    public ApiKey<O> getApiKey() {
        return this.zabk;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.zabj;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zabl;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@NonNull L l, String str) {
        return ListenerHolders.createListenerHolder(l, this.zabl, str);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(2, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(0, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(1, taskApiCall);
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int i2, @NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zabo.zaa(this, i2, taskApiCall, taskCompletionSource, this.zabn);
        return taskCompletionSource.getTask();
    }

    @WorkerThread
    public Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaa) {
        return this.mApi.zai().buildClient(this.mContext, looper, createClientSettingsBuilder().build(), this.zabj, (GoogleApiClient.ConnectionCallbacks) zaa, (GoogleApiClient.OnConnectionFailedListener) zaa);
    }

    public zace zaa(Context context, Handler handler) {
        return new zace(context, handler, createClientSettingsBuilder().build());
    }

    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@NonNull RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.zaka.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zakb.getListenerKey(), "Listener has already been released.");
        return this.zabo.zaa(this, (RegisterListenerMethod<Api.AnyClient, ?>) registrationMethods.zaka, (UnregisterListenerMethod<Api.AnyClient, ?>) registrationMethods.zakb);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, @Nullable O o2, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o2, new Settings.Builder().setLooper(looper).setMapper(statusExceptionMapper).build());
    }

    @MainThread
    @KeepForSdk
    public GoogleApi(@NonNull Activity activity, Api<O> api, @Nullable O o2, Settings settings) {
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.mApi = api;
        this.zabj = o2;
        this.zabl = settings.zabq;
        this.zabk = ApiKey.getSharedApiKey(api, o2);
        this.zabm = new zabn(this);
        GoogleApiManager zab = GoogleApiManager.zab(this.mContext);
        this.zabo = zab;
        this.mId = zab.zabb();
        this.zabn = settings.zabp;
        if (!(activity instanceof GoogleApiActivity)) {
            zaad.zaa(activity, this.zabo, this.zabk);
        }
        this.zabo.zaa((GoogleApi<?>) this);
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, Api<O> api, @Nullable O o2, Settings settings) {
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zabj = o2;
        this.zabl = settings.zabq;
        this.zabk = ApiKey.getSharedApiKey(api, o2);
        this.zabm = new zabn(this);
        GoogleApiManager zab = GoogleApiManager.zab(this.mContext);
        this.zabo = zab;
        this.mId = zab.zabb();
        this.zabn = settings.zabp;
        this.zabo.zaa((GoogleApi<?>) this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Activity activity, Api<O> api, @Nullable O o2, StatusExceptionMapper statusExceptionMapper) {
        this(activity, api, o2, new Settings.Builder().setMapper(statusExceptionMapper).setLooper(activity.getMainLooper()).build());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, @Nullable O o2, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o2, new Settings.Builder().setMapper(statusExceptionMapper).build());
    }
}
