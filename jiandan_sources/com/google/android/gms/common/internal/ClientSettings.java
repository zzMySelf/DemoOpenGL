package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    public final Account account;
    public final Set<Scope> zaof;
    public final Set<Scope> zaog;
    public final Map<Api<?>, OptionalApiSettings> zaoh;
    public final int zaoi;
    public final View zaoj;
    public final String zaok;
    public final String zaol;
    public final SignInOptions zaom;
    public final boolean zaon;
    public Integer zaoo;

    @KeepForSdk
    public static final class Builder {
        public Account account;
        public Map<Api<?>, OptionalApiSettings> zaoh;
        public int zaoi = 0;
        public View zaoj;
        public String zaok;
        public String zaol;
        public SignInOptions zaom = SignInOptions.DEFAULT;
        public ArraySet<Scope> zaop;
        public boolean zaoq;

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            if (this.zaop == null) {
                this.zaop = new ArraySet<>();
            }
            this.zaop.addAll(collection);
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            if (this.zaop == null) {
                this.zaop = new ArraySet<>();
            }
            this.zaop.add(scope);
            return this;
        }

        @KeepForSdk
        public final ClientSettings build() {
            return new ClientSettings(this.account, this.zaop, this.zaoh, this.zaoi, this.zaoj, this.zaok, this.zaol, this.zaom, this.zaoq);
        }

        public final Builder enableSignInClientDisconnectFix() {
            this.zaoq = true;
            return this;
        }

        public final Builder setAccount(Account account2) {
            this.account = account2;
            return this;
        }

        public final Builder setGravityForPopups(int i2) {
            this.zaoi = i2;
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.zaoh = map;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.zaol = str;
            return this;
        }

        @KeepForSdk
        public final Builder setRealClientPackageName(String str) {
            this.zaok = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.zaom = signInOptions;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.zaoj = view;
            return this;
        }
    }

    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
        }
    }

    @KeepForSdk
    public ClientSettings(Account account2, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i2, View view, String str, String str2, SignInOptions signInOptions) {
        this(account2, set, map, i2, view, str, str2, signInOptions, false);
    }

    @KeepForSdk
    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    @KeepForSdk
    public final Account getAccount() {
        return this.account;
    }

    @KeepForSdk
    @Deprecated
    public final String getAccountName() {
        Account account2 = this.account;
        if (account2 != null) {
            return account2.name;
        }
        return null;
    }

    @KeepForSdk
    public final Account getAccountOrDefault() {
        Account account2 = this.account;
        if (account2 != null) {
            return account2;
        }
        return new Account("<<default account>>", "com.google");
    }

    @KeepForSdk
    public final Set<Scope> getAllRequestedScopes() {
        return this.zaog;
    }

    @KeepForSdk
    public final Set<Scope> getApplicableScopes(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.zaoh.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            return this.zaof;
        }
        HashSet hashSet = new HashSet(this.zaof);
        hashSet.addAll(optionalApiSettings.mScopes);
        return hashSet;
    }

    public final Integer getClientSessionId() {
        return this.zaoo;
    }

    @KeepForSdk
    public final int getGravityForPopups() {
        return this.zaoi;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.zaoh;
    }

    public final String getRealClientClassName() {
        return this.zaol;
    }

    @KeepForSdk
    public final String getRealClientPackageName() {
        return this.zaok;
    }

    @KeepForSdk
    public final Set<Scope> getRequiredScopes() {
        return this.zaof;
    }

    public final SignInOptions getSignInOptions() {
        return this.zaom;
    }

    @KeepForSdk
    public final View getViewForPopups() {
        return this.zaoj;
    }

    public final boolean isSignInClientDisconnectFixEnabled() {
        return this.zaon;
    }

    public final void setClientSessionId(Integer num) {
        this.zaoo = num;
    }

    public ClientSettings(Account account2, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i2, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.account = account2;
        this.zaof = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zaoh = map == null ? Collections.emptyMap() : map;
        this.zaoj = view;
        this.zaoi = i2;
        this.zaok = str;
        this.zaol = str2;
        this.zaom = signInOptions;
        this.zaon = z;
        HashSet hashSet = new HashSet(this.zaof);
        for (OptionalApiSettings optionalApiSettings : this.zaoh.values()) {
            hashSet.addAll(optionalApiSettings.mScopes);
        }
        this.zaog = Collections.unmodifiableSet(hashSet);
    }
}
