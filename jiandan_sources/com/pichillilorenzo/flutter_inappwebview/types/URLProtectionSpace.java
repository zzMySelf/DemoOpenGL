package com.pichillilorenzo.flutter_inappwebview.types;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class URLProtectionSpace {
    public String host;
    @Nullable
    public Long id;
    public int port;
    public String protocol;
    @Nullable
    public String realm;
    @Nullable
    public SslCertificate sslCertificate;
    @Nullable
    public SslError sslError;

    public URLProtectionSpace(@Nullable Long l, String str, String str2, @Nullable String str3, int i2) {
        this.id = l;
        this.host = str;
        this.protocol = str2;
        this.realm = str3;
        this.port = i2;
    }

    public URLProtectionSpace(String str, String str2, @Nullable String str3, int i2, @Nullable SslCertificate sslCertificate2, @Nullable SslError sslError2) {
        this.host = str;
        this.protocol = str2;
        this.realm = str3;
        this.port = i2;
        this.sslCertificate = sslCertificate2;
        this.sslError = sslError2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || URLProtectionSpace.class != obj.getClass()) {
            return false;
        }
        URLProtectionSpace uRLProtectionSpace = (URLProtectionSpace) obj;
        if (this.port != uRLProtectionSpace.port || !this.host.equals(uRLProtectionSpace.host) || !this.protocol.equals(uRLProtectionSpace.protocol)) {
            return false;
        }
        String str = this.realm;
        if (str == null ? uRLProtectionSpace.realm != null : !str.equals(uRLProtectionSpace.realm)) {
            return false;
        }
        SslCertificate sslCertificate2 = this.sslCertificate;
        if (sslCertificate2 == null ? uRLProtectionSpace.sslCertificate != null : !sslCertificate2.equals(uRLProtectionSpace.sslCertificate)) {
            return false;
        }
        SslError sslError2 = this.sslError;
        SslError sslError3 = uRLProtectionSpace.sslError;
        return sslError2 != null ? sslError2.equals(sslError3) : sslError3 == null;
    }

    public String getHost() {
        return this.host;
    }

    @Nullable
    public Long getId() {
        return this.id;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    @Nullable
    public String getRealm() {
        return this.realm;
    }

    @Nullable
    public SslCertificate getSslCertificate() {
        return this.sslCertificate;
    }

    @Nullable
    public SslError getSslError() {
        return this.sslError;
    }

    public int hashCode() {
        int hashCode = ((this.host.hashCode() * 31) + this.protocol.hashCode()) * 31;
        String str = this.realm;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.port) * 31;
        SslCertificate sslCertificate2 = this.sslCertificate;
        int hashCode3 = (hashCode2 + (sslCertificate2 != null ? sslCertificate2.hashCode() : 0)) * 31;
        SslError sslError2 = this.sslError;
        if (sslError2 != null) {
            i2 = sslError2.hashCode();
        }
        return hashCode3 + i2;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(@Nullable Long l) {
        this.id = l;
    }

    public void setPort(int i2) {
        this.port = i2;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setRealm(@Nullable String str) {
        this.realm = str;
    }

    public void setSslCertificate(@Nullable SslCertificate sslCertificate2) {
        this.sslCertificate = sslCertificate2;
    }

    public void setSslError(@Nullable SslError sslError2) {
        this.sslError = sslError2;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("host", this.host);
        hashMap.put("protocol", this.protocol);
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, this.realm);
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, Integer.valueOf(this.port));
        hashMap.put("sslCertificate", SslCertificateExt.toMap(this.sslCertificate));
        hashMap.put("sslError", SslErrorExt.toMap(this.sslError));
        return hashMap;
    }

    public String toString() {
        return "URLProtectionSpace{host='" + this.host + ExtendedMessageFormat.QUOTE + ", protocol='" + this.protocol + ExtendedMessageFormat.QUOTE + ", realm='" + this.realm + ExtendedMessageFormat.QUOTE + ", port=" + this.port + ", sslCertificate=" + this.sslCertificate + ", sslError=" + this.sslError + ExtendedMessageFormat.END_FE;
    }
}
