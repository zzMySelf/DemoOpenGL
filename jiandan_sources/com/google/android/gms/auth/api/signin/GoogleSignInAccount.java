package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    @VisibleForTesting
    public static Clock zaf = DefaultClock.getInstance();
    @SafeParcelable.Field(getter = "getId", id = 2)
    public String mId;
    @SafeParcelable.VersionField(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(getter = "getIdToken", id = 3)
    public String zag;
    @SafeParcelable.Field(getter = "getEmail", id = 4)
    public String zah;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    public String zai;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)
    public Uri zaj;
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 7)
    public String zak;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 8)
    public long zal;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", id = 9)
    public String zam;
    @SafeParcelable.Field(id = 10)
    public List<Scope> zan;
    @SafeParcelable.Field(getter = "getGivenName", id = 11)
    public String zao;
    @SafeParcelable.Field(getter = "getFamilyName", id = 12)
    public String zap;
    public Set<Scope> zaq = new HashSet();

    @SafeParcelable.Constructor
    public GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) String str7, @SafeParcelable.Param(id = 12) String str8) {
        this.versionCode = i2;
        this.mId = str;
        this.zag = str2;
        this.zah = str3;
        this.zai = str4;
        this.zaj = uri;
        this.zak = str5;
        this.zal = j;
        this.zam = str6;
        this.zan = list;
        this.zao = str7;
        this.zap = str8;
    }

    @KeepForSdk
    public static GoogleSignInAccount createDefault() {
        Account account = new Account("<<default account>>", "com.google");
        return zaa((String) null, (String) null, account.name, (String) null, (String) null, (String) null, (Uri) null, 0L, account.name, new HashSet());
    }

    @Nullable
    public static GoogleSignInAccount zaa(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount zaa = zaa(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), jSONObject.optString("givenName", (String) null), jSONObject.optString("familyName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        zaa.zak = jSONObject.optString("serverAuthCode", (String) null);
        return zaa;
    }

    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zal);
            jSONObject.put("obfuscatedIdentifier", this.zam);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zan.toArray(new Scope[this.zan.size()]);
            Arrays.sort(scopeArr, zaa.zae);
            for (Scope scopeUri : scopeArr) {
                jSONArray.put(scopeUri.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.zam.equals(this.zam) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
    }

    @Nullable
    public Account getAccount() {
        if (this.zah == null) {
            return null;
        }
        return new Account(this.zah, "com.google");
    }

    @Nullable
    public String getDisplayName() {
        return this.zai;
    }

    @Nullable
    public String getEmail() {
        return this.zah;
    }

    @Nullable
    public String getFamilyName() {
        return this.zap;
    }

    @Nullable
    public String getGivenName() {
        return this.zao;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zan);
    }

    @Nullable
    public String getId() {
        return this.mId;
    }

    @Nullable
    public String getIdToken() {
        return this.zag;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zaj;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zan);
        hashSet.addAll(this.zaq);
        return hashSet;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.zak;
    }

    public int hashCode() {
        return ((this.zam.hashCode() + PayBeanFactory.BEAN_ID_WIDTHDRAW) * 31) + getRequestedScopes().hashCode();
    }

    @KeepForSdk
    public boolean isExpired() {
        return zaf.currentTimeMillis() / 1000 >= this.zal - 300;
    }

    @KeepForSdk
    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zaq, scopeArr);
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i2, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.zal);
        SafeParcelWriter.writeString(parcel, 9, this.zam, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zan, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zab() {
        return this.zam;
    }

    public final String zac() {
        JSONObject zad = zad();
        zad.remove("serverAuthCode");
        return zad.toString();
    }

    public static GoogleSignInAccount zaa(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, (l == null ? Long.valueOf(zaf.currentTimeMillis() / 1000) : l).longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }
}
