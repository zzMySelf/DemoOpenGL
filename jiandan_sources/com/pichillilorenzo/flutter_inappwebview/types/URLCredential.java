package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class URLCredential {
    @Nullable
    public Long id;
    @Nullable
    public String password;
    @Nullable
    public Long protectionSpaceId;
    @Nullable
    public String username;

    public URLCredential(@Nullable Long l, @NonNull String str, @NonNull String str2, @Nullable Long l2) {
        this.id = l;
        this.username = str;
        this.password = str2;
        this.protectionSpaceId = l2;
    }

    public URLCredential(@Nullable String str, @Nullable String str2) {
        this.username = str;
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || URLCredential.class != obj.getClass()) {
            return false;
        }
        URLCredential uRLCredential = (URLCredential) obj;
        String str = this.username;
        if (str == null ? uRLCredential.username != null : !str.equals(uRLCredential.username)) {
            return false;
        }
        String str2 = this.password;
        String str3 = uRLCredential.password;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    @Nullable
    public Long getId() {
        return this.id;
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    @Nullable
    public Long getProtectionSpaceId() {
        return this.protectionSpaceId;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void setId(@Nullable Long l) {
        this.id = l;
    }

    public void setPassword(@Nullable String str) {
        this.password = str;
    }

    public void setProtectionSpaceId(@Nullable Long l) {
        this.protectionSpaceId = l;
    }

    public void setUsername(@Nullable String str) {
        this.username = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("username", this.username);
        hashMap.put("password", this.password);
        return hashMap;
    }

    public String toString() {
        return "URLCredential{username='" + this.username + ExtendedMessageFormat.QUOTE + ", password='" + this.password + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
