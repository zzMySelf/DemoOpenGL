package fe.th.de.rrr.pf;

import fe.th.de.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public abstract class ad extends HttpsURLConnection {
    public final HttpURLConnection qw;

    public ad(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.qw = httpURLConnection;
    }

    public void addRequestProperty(String str, String str2) {
        this.qw.addRequestProperty(str, str2);
    }

    public void connect() throws IOException {
        this.connected = true;
        this.qw.connect();
    }

    public void disconnect() {
        this.qw.disconnect();
    }

    public boolean getAllowUserInteraction() {
        return this.qw.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        o qw2 = qw();
        if (qw2 != null) {
            return qw2.qw().fe();
        }
        return null;
    }

    public int getConnectTimeout() {
        return this.qw.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        return this.qw.getContent();
    }

    public String getContentEncoding() {
        return this.qw.getContentEncoding();
    }

    public int getContentLength() {
        return this.qw.getContentLength();
    }

    @IgnoreJRERequirement
    public long getContentLengthLong() {
        return this.qw.getContentLengthLong();
    }

    public String getContentType() {
        return this.qw.getContentType();
    }

    public long getDate() {
        return this.qw.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.qw.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.qw.getDoInput();
    }

    public boolean getDoOutput() {
        return this.qw.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.qw.getErrorStream();
    }

    public long getExpiration() {
        return this.qw.getExpiration();
    }

    public String getHeaderField(int i2) {
        return this.qw.getHeaderField(i2);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.qw.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i2) {
        return this.qw.getHeaderFieldInt(str, i2);
    }

    public String getHeaderFieldKey(int i2) {
        return this.qw.getHeaderFieldKey(i2);
    }

    @IgnoreJRERequirement
    public long getHeaderFieldLong(String str, long j) {
        return this.qw.getHeaderFieldLong(str, j);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.qw.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.qw.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.qw.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.qw.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.qw.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        o qw2 = qw();
        if (qw2 == null) {
            return null;
        }
        List<Certificate> de2 = qw2.de();
        if (!de2.isEmpty()) {
            return (Certificate[]) de2.toArray(new Certificate[de2.size()]);
        }
        return null;
    }

    public Principal getLocalPrincipal() {
        o qw2 = qw();
        if (qw2 != null) {
            return qw2.fe();
        }
        return null;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.qw.getOutputStream();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        o qw2 = qw();
        if (qw2 != null) {
            return qw2.th();
        }
        return null;
    }

    public Permission getPermission() throws IOException {
        return this.qw.getPermission();
    }

    public int getReadTimeout() {
        return this.qw.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.qw.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.qw.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.qw.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        return this.qw.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.qw.getResponseMessage();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        o qw2 = qw();
        if (qw2 == null) {
            return null;
        }
        List<Certificate> rg2 = qw2.rg();
        if (!rg2.isEmpty()) {
            return (Certificate[]) rg2.toArray(new Certificate[rg2.size()]);
        }
        return null;
    }

    public URL getURL() {
        return this.qw.getURL();
    }

    public boolean getUseCaches() {
        return this.qw.getUseCaches();
    }

    public abstract o qw();

    public void setAllowUserInteraction(boolean z) {
        this.qw.setAllowUserInteraction(z);
    }

    public void setChunkedStreamingMode(int i2) {
        this.qw.setChunkedStreamingMode(i2);
    }

    public void setConnectTimeout(int i2) {
        this.qw.setConnectTimeout(i2);
    }

    public void setDefaultUseCaches(boolean z) {
        this.qw.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.qw.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.qw.setDoOutput(z);
    }

    @IgnoreJRERequirement
    public void setFixedLengthStreamingMode(long j) {
        this.qw.setFixedLengthStreamingMode(j);
    }

    public void setIfModifiedSince(long j) {
        this.qw.setIfModifiedSince(j);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.qw.setInstanceFollowRedirects(z);
    }

    public void setReadTimeout(int i2) {
        this.qw.setReadTimeout(i2);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.qw.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        this.qw.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.qw.setUseCaches(z);
    }

    public String toString() {
        return this.qw.toString();
    }

    public boolean usingProxy() {
        return this.qw.usingProxy();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.qw.getContent(clsArr);
    }

    public String getHeaderField(String str) {
        return this.qw.getHeaderField(str);
    }

    public void setFixedLengthStreamingMode(int i2) {
        this.qw.setFixedLengthStreamingMode(i2);
    }
}
