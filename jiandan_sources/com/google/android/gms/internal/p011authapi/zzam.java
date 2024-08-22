package com.google.android.gms.internal.p011authapi;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api.zzam  reason: invalid package */
public final class zzam {
    public static final Feature zzcw = new Feature("auth_api_credentials_begin_sign_in", 2);
    public static final Feature zzcx = new Feature("auth_api_credentials_sign_out", 2);
    public static final Feature zzcy = new Feature("auth_api_credentials_authorize", 1);
    public static final Feature zzcz = new Feature("auth_api_credentials_revoke_access", 1);
    public static final Feature zzda = new Feature("auth_api_credentials_save_password", 2);
    public static final Feature zzdb = new Feature("auth_api_credentials_get_sign_in_intent", 2);
    public static final Feature zzdc;
    public static final Feature[] zzdd;

    static {
        Feature feature = new Feature("auth_api_credentials_save_account_linking_token", 1);
        zzdc = feature;
        zzdd = new Feature[]{zzcw, zzcx, zzcy, zzcz, zzda, zzdb, feature};
    }
}
