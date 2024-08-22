package com.baidubce;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.JoinerUtils;
import com.google.common.base.Ascii;
import java.net.InetAddress;

public class BceClientConfiguration {
    public static String DEFAULT_ACCPET_ENCODING = "identity";
    public static final int DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS = 30000;
    public static long DEFAULT_KEEPALIVE_DURATION = 30;
    public static final int DEFAULT_MAX_CONNECTIONS = 5;
    public static Protocol DEFAULT_PROTOCOL = Protocol.HTTP;
    public static Region DEFAULT_REGION = Region.CN_N1;
    public static final int DEFAULT_SOCKET_TIMEOUT_IN_MILLIS = 30000;
    public static final String DEFAULT_USER_AGENT;
    public String acceptEncoding = DEFAULT_ACCPET_ENCODING;
    public int connectionTimeoutInMillis = 30000;
    public BceCredentials credentials = null;
    public String endpoint = null;
    public long keepAliveDuration = DEFAULT_KEEPALIVE_DURATION;
    public InetAddress localAddress = null;
    public int maxConnections = 5;
    public Protocol protocol = Protocol.HTTP;
    public String proxyDomain = null;
    public String proxyHost = null;
    public String proxyPassword = null;
    public int proxyPort = -1;
    public boolean proxyPreemptiveAuthenticationEnabled;
    public String proxyUsername = null;
    public String proxyWorkstation = null;
    public Region region = DEFAULT_REGION;
    public RetryPolicy retryPolicy = RetryPolicy.DEFAULT_RETRY_POLICY;
    public int socketBufferSizeInBytes = 0;
    public int socketTimeoutInMillis = 30000;
    public String token = null;
    public long uploadSegmentPart = 2048;
    public String userAgent = DEFAULT_USER_AGENT;

    static {
        String property = System.getProperty("user.language");
        String str = "";
        if (property == null) {
            property = str;
        }
        String property2 = System.getProperty("user.region");
        if (property2 != null) {
            str = property2;
        }
        DEFAULT_USER_AGENT = JoinerUtils.on("/", "bce-sdk-android", "1.0.5", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("java.vm.name"), System.getProperty("java.vm.version"), System.getProperty("java.version"), property, str).replace(Ascii.CASE_MASK, '_');
    }

    public BceClientConfiguration() {
    }

    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public int getConnectionTimeoutInMillis() {
        return this.connectionTimeoutInMillis;
    }

    public BceCredentials getCredentials() {
        return this.credentials;
    }

    public String getEndpoint() {
        String str = this.endpoint;
        if (str == null || str.length() <= 0 || this.endpoint.indexOf("://") >= 0) {
            return str;
        }
        return this.protocol.toString().toLowerCase() + "://" + this.endpoint;
    }

    public long getKeepAliveDuration() {
        return this.keepAliveDuration;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public String getProxyDomain() {
        return this.proxyDomain;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public String getProxyWorkstation() {
        return this.proxyWorkstation;
    }

    public Region getRegion() {
        return this.region;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public int getSocketBufferSizeInBytes() {
        return this.socketBufferSizeInBytes;
    }

    public int getSocketTimeoutInMillis() {
        return this.socketTimeoutInMillis;
    }

    public long getUploadSegmentPart() {
        return this.uploadSegmentPart;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isProxyPreemptiveAuthenticationEnabled() {
        return this.proxyPreemptiveAuthenticationEnabled;
    }

    public void setAcceptEncoding(String str) {
        this.acceptEncoding = str;
    }

    public void setConnectionTimeoutInMillis(int i2) {
        CheckUtils.checkArgument(i2 >= 0, "connectionTimeoutInMillis should not be negative.");
        this.connectionTimeoutInMillis = i2;
    }

    public void setCredentials(BceCredentials bceCredentials) {
        CheckUtils.isNotNull(bceCredentials, "credentials should not be null.");
        this.credentials = bceCredentials;
    }

    public void setEndpoint(String str) {
        CheckUtils.isNotNull(str, "endpoint should not be null.");
        this.endpoint = str;
    }

    public void setKeepAliveDuration(long j) {
        this.keepAliveDuration = j;
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
    }

    public void setMaxConnections(int i2) {
        CheckUtils.checkArgument(i2 >= 0, "maxConnections should not be negative.");
        this.maxConnections = i2;
    }

    public void setProtocol(Protocol protocol2) {
        if (protocol2 == null) {
            protocol2 = DEFAULT_PROTOCOL;
        }
        this.protocol = protocol2;
    }

    public void setProxyDomain(String str) {
        this.proxyDomain = str;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setProxyPassword(String str) {
        this.proxyPassword = str;
    }

    public void setProxyPort(int i2) {
        this.proxyPort = i2;
    }

    public void setProxyPreemptiveAuthenticationEnabled(boolean z) {
        this.proxyPreemptiveAuthenticationEnabled = z;
    }

    public void setProxyUsername(String str) {
        this.proxyUsername = str;
    }

    public void setProxyWorkstation(String str) {
        this.proxyWorkstation = str;
    }

    public void setRegion(Region region2) {
        if (region2 == null) {
            region2 = DEFAULT_REGION;
        }
        this.region = region2;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy2) {
        if (retryPolicy2 == null) {
            retryPolicy2 = RetryPolicy.DEFAULT_RETRY_POLICY;
        }
        this.retryPolicy = retryPolicy2;
    }

    public void setSocketBufferSizeInBytes(int i2) {
        this.socketBufferSizeInBytes = i2;
    }

    public void setSocketTimeoutInMillis(int i2) {
        CheckUtils.checkArgument(i2 >= 0, "socketTimeoutInMillis should not be negative.");
        this.socketTimeoutInMillis = i2;
    }

    public void setUploadSegmentPart(long j) {
        if (j < 1 || j > 8192) {
            j = 2048;
        }
        this.uploadSegmentPart = j;
    }

    public void setUserAgent(String str) {
        if (str == null) {
            this.userAgent = DEFAULT_USER_AGENT;
        } else if (str.endsWith(DEFAULT_USER_AGENT)) {
            this.userAgent = str;
        } else {
            this.userAgent = str + StringUtil.ARRAY_ELEMENT_SEPARATOR + DEFAULT_USER_AGENT;
        }
    }

    public String toString() {
        return "BceClientConfiguration [ \n  userAgent=" + this.userAgent + ", \n  retryPolicy=" + this.retryPolicy + ", \n  localAddress=" + this.localAddress + ", \n  protocol=" + this.protocol + ", \n  proxyHost=" + this.proxyHost + ", \n  proxyPort=" + this.proxyPort + ", \n  proxyUsername=" + this.proxyUsername + ", \n  proxyPassword=" + this.proxyPassword + ", \n  proxyDomain=" + this.proxyDomain + ", \n  proxyWorkstation=" + this.proxyWorkstation + ", \n  proxyPreemptiveAuthenticationEnabled=" + this.proxyPreemptiveAuthenticationEnabled + ", \n  maxConnections=" + this.maxConnections + ", \n  socketTimeoutInMillis=" + this.socketTimeoutInMillis + ", \n  connectionTimeoutInMillis=" + this.connectionTimeoutInMillis + ", \n  socketBufferSizeInBytes=" + this.socketBufferSizeInBytes + ", \n  endpoint=" + this.endpoint + ", \n  region=" + this.region + ", \n  credentials=" + this.credentials + ", \n  uploadSegmentPart=" + this.uploadSegmentPart + ", \n  acceptEncoding=" + this.acceptEncoding + ", \n  keepAliveDuration=" + this.keepAliveDuration + "]\n";
    }

    public BceClientConfiguration withConnectionTimeoutInMillis(int i2) {
        setConnectionTimeoutInMillis(i2);
        return this;
    }

    public BceClientConfiguration withCredentials(BceCredentials bceCredentials) {
        setCredentials(bceCredentials);
        return this;
    }

    public BceClientConfiguration withEndpoint(String str) {
        setEndpoint(str);
        return this;
    }

    public BceClientConfiguration withLocalAddress(InetAddress inetAddress) {
        setLocalAddress(inetAddress);
        return this;
    }

    public BceClientConfiguration withMaxConnections(int i2) {
        setMaxConnections(i2);
        return this;
    }

    public BceClientConfiguration withProtocol(Protocol protocol2) {
        setProtocol(protocol2);
        return this;
    }

    public BceClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    public BceClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    public BceClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    public BceClientConfiguration withProxyPort(int i2) {
        setProxyPort(i2);
        return this;
    }

    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        setProxyPreemptiveAuthenticationEnabled(z);
        return this;
    }

    public BceClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    public BceClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    public BceClientConfiguration withRegion(Region region2) {
        setRegion(region2);
        return this;
    }

    public BceClientConfiguration withRetryPolicy(RetryPolicy retryPolicy2) {
        setRetryPolicy(retryPolicy2);
        return this;
    }

    public BceClientConfiguration withSocketBufferSizeInBytes(int i2) {
        setSocketBufferSizeInBytes(i2);
        return this;
    }

    public BceClientConfiguration withSocketTimeoutInMillis(int i2) {
        setSocketTimeoutInMillis(i2);
        return this;
    }

    public BceClientConfiguration withUploadSegmentPart(Long l) {
        setUploadSegmentPart(l.longValue());
        return this;
    }

    public BceClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }

    public BceClientConfiguration(BceClientConfiguration bceClientConfiguration) {
        this.connectionTimeoutInMillis = bceClientConfiguration.connectionTimeoutInMillis;
        this.maxConnections = bceClientConfiguration.maxConnections;
        this.retryPolicy = bceClientConfiguration.retryPolicy;
        this.localAddress = bceClientConfiguration.localAddress;
        this.protocol = bceClientConfiguration.protocol;
        this.proxyDomain = bceClientConfiguration.proxyDomain;
        this.proxyHost = bceClientConfiguration.proxyHost;
        this.proxyPassword = bceClientConfiguration.proxyPassword;
        this.proxyPort = bceClientConfiguration.proxyPort;
        this.proxyUsername = bceClientConfiguration.proxyUsername;
        this.proxyWorkstation = bceClientConfiguration.proxyWorkstation;
        this.proxyPreemptiveAuthenticationEnabled = bceClientConfiguration.proxyPreemptiveAuthenticationEnabled;
        this.socketTimeoutInMillis = bceClientConfiguration.socketTimeoutInMillis;
        this.userAgent = bceClientConfiguration.userAgent;
        this.socketBufferSizeInBytes = bceClientConfiguration.socketBufferSizeInBytes;
        this.endpoint = bceClientConfiguration.endpoint;
        this.region = bceClientConfiguration.region;
        this.credentials = bceClientConfiguration.credentials;
        this.token = bceClientConfiguration.token;
        this.uploadSegmentPart = bceClientConfiguration.uploadSegmentPart;
        this.acceptEncoding = bceClientConfiguration.acceptEncoding;
        this.keepAliveDuration = bceClientConfiguration.keepAliveDuration;
    }
}
