package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    public static final zzc zzbm = new zzc((zzc) null);
    @VisibleForTesting
    public static int zzbn = zzd.zzbq;

    public static class zzc implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        public zzc() {
        }

        @Nullable
        public final /* synthetic */ Object convert(Result result) {
            return ((GoogleSignInResult) result).getSignInAccount();
        }

        public /* synthetic */ zzc(zzc zzc) {
            this();
        }
    }

    /* 'enum' modifier removed */
    @VisibleForTesting
    public static final class zzd {
        public static final int zzbq = 1;
        public static final int zzbr = 2;
        public static final int zzbs = 3;
        public static final int zzbt = 4;
        public static final /* synthetic */ int[] zzbu = {1, 2, 3, 4};

        public static int[] zzh() {
            return (int[]) zzbu.clone();
        }
    }

    public GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int zzg() {
        if (zzbn == zzd.zzbq) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                zzbn = zzd.zzbt;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, (String) null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zzbn = zzd.zzbr;
            } else {
                zzbn = zzd.zzbs;
            }
        }
        return zzbn;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int i2 = zzc.zzbo[zzg() - 1];
        if (i2 == 1) {
            return zzg.zzd(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        if (i2 != 2) {
            return zzg.zze(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        return zzg.zzc(applicationContext, (GoogleSignInOptions) getApiOptions());
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zzg.zzd(asGoogleApiClient(), getApplicationContext(), zzg() == zzd.zzbs));
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zzg.zzc(asGoogleApiClient(), getApplicationContext(), zzg() == zzd.zzbs));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zzg.zzc(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), zzg() == zzd.zzbs), zzbm);
    }

    public GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
