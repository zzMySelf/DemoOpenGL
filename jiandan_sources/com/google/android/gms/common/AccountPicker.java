package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {

    public static class AccountChooserOptions {
        @Nullable
        public Account zze;
        @Nullable
        public ArrayList<Account> zzf;
        @Nullable
        public ArrayList<String> zzg;
        public boolean zzh;
        @Nullable
        public String zzi;
        @Nullable
        public Bundle zzj;
        public boolean zzk;
        public int zzl;
        @Nullable
        public String zzm;
        public boolean zzn;
        @Nullable
        public zza zzo;
        @Nullable
        public String zzp;

        public static class Builder {
            @Nullable
            public Account zze;
            @Nullable
            public ArrayList<Account> zzf;
            @Nullable
            public ArrayList<String> zzg;
            public boolean zzh = false;
            @Nullable
            public String zzi;
            @Nullable
            public Bundle zzj;
            public boolean zzk = false;
            public int zzl = 0;
            public boolean zzn = false;

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                ArrayList unused = accountChooserOptions.zzg = this.zzg;
                ArrayList unused2 = accountChooserOptions.zzf = this.zzf;
                boolean unused3 = accountChooserOptions.zzh = this.zzh;
                zza unused4 = accountChooserOptions.zzo = null;
                String unused5 = accountChooserOptions.zzm = null;
                Bundle unused6 = accountChooserOptions.zzj = this.zzj;
                Account unused7 = accountChooserOptions.zze = this.zze;
                boolean unused8 = accountChooserOptions.zzk = false;
                String unused9 = accountChooserOptions.zzp = null;
                int unused10 = accountChooserOptions.zzl = 0;
                String unused11 = accountChooserOptions.zzi = this.zzi;
                boolean unused12 = accountChooserOptions.zzn = false;
                return accountChooserOptions;
            }

            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                this.zzf = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                this.zzg = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzh = z;
                return this;
            }

            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.zzj = bundle;
                return this;
            }

            public Builder setSelectedAccount(@Nullable Account account) {
                this.zze = account;
                return this;
            }

            public Builder setTitleOverrideText(@Nullable String str) {
                this.zzi = str;
                return this;
            }
        }

        public static class zza {
        }
    }

    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        int i2 = 0;
        if (!accountChooserOptions.zzn) {
            Preconditions.checkArgument(accountChooserOptions.zzm == null, "We only support hostedDomain filter for account chip styled account picker");
            Preconditions.checkArgument(accountChooserOptions.zzo == null, "Consent is only valid for account chip styled account picker");
        }
        intent.setAction(accountChooserOptions.zzn ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.zzf);
        if (accountChooserOptions.zzg != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.zzg.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.zzj);
        intent.putExtra("selectedAccount", accountChooserOptions.zze);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.zzh);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.zzi);
        intent.putExtra("setGmsCoreAccount", accountChooserOptions.zzk);
        intent.putExtra("realClientPackage", accountChooserOptions.zzp);
        intent.putExtra("overrideTheme", accountChooserOptions.zzl);
        if (accountChooserOptions.zzn) {
            i2 = 2;
        }
        intent.putExtra("overrideCustomTheme", i2);
        intent.putExtra("hostedDomainFilter", accountChooserOptions.zzm);
        Bundle bundle = new Bundle();
        if (accountChooserOptions.zzn && !TextUtils.isEmpty(accountChooserOptions.zzi)) {
            bundle.putString("title", accountChooserOptions.zzi);
        }
        if (accountChooserOptions.zzo != null) {
            bundle.putBoolean("should_show_consent", true);
            bundle.putString("privacy_policy_url", (String) null);
            bundle.putString("terms_of_service_url", (String) null);
        }
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
