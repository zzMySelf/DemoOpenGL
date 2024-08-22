package fe.th.de.rrr.uk;

import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http.UnrepeatableRequestBody;
import com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException;
import com.google.common.net.HttpHeaders;
import fe.th.de.Cif;
import fe.th.de.ddd;
import fe.th.de.eee;
import fe.th.de.fe;
import fe.th.de.ggg;
import fe.th.de.mmm;
import fe.th.de.nn;
import fe.th.de.qqq;
import fe.th.de.qw;
import fe.th.de.rrr.yj.th;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class i implements Interceptor {

    /* renamed from: rg  reason: collision with root package name */
    public static String f5470rg = "RetryAndFollowUpInterceptor";

    /* renamed from: ad  reason: collision with root package name */
    public volatile th f5471ad;

    /* renamed from: de  reason: collision with root package name */
    public Object f5472de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile boolean f5473fe;
    public final ggg qw;

    public i(ggg ggg, boolean z) {
        this.qw = ggg;
    }

    public static void th(String str, ddd ddd, String str2) {
        eee.qw(str, ddd, str2, f5470rg);
    }

    public final qw ad(Cif ifVar) {
        fe feVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (ifVar.m339switch()) {
            SSLSocketFactory e = this.qw.e();
            hostnameVerifier = this.qw.ppp();
            sSLSocketFactory = e;
            feVar = this.qw.fe();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            feVar = null;
        }
        return new qw(ifVar.m338if(), ifVar.qqq(), this.qw.o(), this.qw.d(), sSLSocketFactory, hostnameVerifier, feVar, this.qw.tt(), this.qw.rrr(), this.qw.eee(), this.qw.yj(), this.qw.a());
    }

    public final ddd de(mmm mmm, qqq qqq) throws IOException {
        String yj2;
        Cif a;
        if (mmm != null) {
            int rg2 = mmm.rg();
            String th2 = mmm.nn().th();
            th("followUpRequest method:: " + th2 + "  responseCode" + rg2, mmm.nn(), "followUpRequest");
            nn nnVar = null;
            if (rg2 == 307 || rg2 == 308) {
                if (!th2.equals(ShareTarget.METHOD_GET) && !th2.equals("HEAD")) {
                    return null;
                }
            } else if (rg2 == 401) {
                return this.qw.ad().qw(qqq, mmm);
            } else {
                if (rg2 != 503) {
                    if (rg2 != 407) {
                        if (rg2 != 408) {
                            switch (rg2) {
                                case 300:
                                case 301:
                                case 302:
                                case BindVerifyActivity.D:
                                    break;
                                default:
                                    return null;
                            }
                        } else if (!this.qw.c() || (mmm.nn().qw() instanceof UnrepeatableRequestBody)) {
                            return null;
                        } else {
                            if ((mmm.vvv() == null || mmm.vvv().rg() != 408) && i(mmm, 0) <= 0) {
                                return mmm.nn();
                            }
                            return null;
                        }
                    } else if (qqq.ad().type() == Proxy.Type.HTTP) {
                        return this.qw.tt().qw(qqq, mmm);
                    } else {
                        th("followUpRequest ProtocolException:: Received HTTP_PROXY_AUTH (407) code while not using proxy", mmm.nn(), "followUpRequest");
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                } else if ((mmm.vvv() == null || mmm.vvv().rg() != 503) && i(mmm, Integer.MAX_VALUE) == 0) {
                    return mmm.nn();
                } else {
                    return null;
                }
            }
            if (!this.qw.m333if() || (yj2 = mmm.yj("Location")) == null || (a = mmm.nn().uk().a(yj2)) == null) {
                return null;
            }
            if (!a.b().equals(mmm.nn().uk().b()) && !this.qw.m334switch()) {
                return null;
            }
            ddd.qw yj3 = mmm.nn().yj();
            if (rg.ad(th2)) {
                boolean fe2 = rg.fe(th2);
                if (rg.de(th2)) {
                    yj3.rg(ShareTarget.METHOD_GET, (nn) null);
                } else {
                    if (fe2) {
                        nnVar = mmm.nn().qw();
                    }
                    yj3.rg(th2, nnVar);
                }
                if (!fe2) {
                    yj3.th("Transfer-Encoding");
                    yj3.th("Content-Length");
                    yj3.th("Content-Type");
                }
            }
            if (!o(mmm, a)) {
                yj3.th("Authorization");
            }
            yj3.yj(a);
            return yj3.ad();
        }
        throw new IllegalStateException();
    }

    public boolean fe() {
        return this.f5473fe;
    }

    public final int i(mmm mmm, int i2) {
        String yj2 = mmm.yj(HttpHeaders.RETRY_AFTER);
        StringBuilder sb = new StringBuilder();
        sb.append("retryAfter header:: ");
        sb.append(yj2 == null ? null : yj2);
        th(sb.toString(), mmm.nn(), "retryAfter");
        if (yj2 == null) {
            return i2;
        }
        if (yj2.matches("\\d+")) {
            return Integer.valueOf(yj2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [com.duxiaoman.okhttp3.internal.http.HttpCodec, fe.th.de.aaa, fe.th.de.rrr.yj.de] */
    /* JADX WARNING: type inference failed for: r13v2 */
    public mmm intercept(Interceptor.Chain chain) throws IOException {
        StringBuilder sb;
        int i2;
        ddd request = chain.request();
        th thVar = (th) chain;
        Call ad2 = thVar.ad();
        EventListener de2 = thVar.de();
        th thVar2 = new th(this.qw.th(), ad(request.uk()), ad2, de2, this.f5472de);
        this.f5471ad = thVar2;
        ? r13 = 0;
        ddd ddd = request;
        mmm mmm = null;
        int i3 = 0;
        while (!this.f5473fe) {
            boolean z = true;
            try {
                th("get response", ddd, "intercept");
                mmm rg2 = thVar.rg(ddd, thVar2, r13, r13);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("response is null: ");
                sb2.append(rg2 == null);
                th(sb2.toString(), ddd, "intercept");
                th("get response finally:: " + false, ddd, "intercept");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("priorResponse is null : ");
                sb3.append(mmm == null);
                th(sb3.toString(), ddd, "intercept");
                if (mmm != null) {
                    mmm.qw ggg = rg2.ggg();
                    mmm.qw ggg2 = mmm.ggg();
                    ggg2.ad(r13);
                    ggg.m344switch(ggg2.de());
                    rg2 = ggg.de();
                }
                try {
                    ddd de3 = de(rg2, thVar2.nn());
                    th("followUpRequest", ddd, "intercept");
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("followUp is null: ");
                    if (de3 != null) {
                        z = false;
                    }
                    sb4.append(z);
                    th(sb4.toString(), ddd, "intercept");
                    if (de3 == null) {
                        thVar2.ggg();
                        return rg2;
                    }
                    fe.th.de.rrr.fe.yj(rg2.qw());
                    th("followUpCount:: " + i3, ddd, "intercept");
                    int i4 = i3 + 1;
                    if (i4 <= 20) {
                        th("followUp.body:: ", ddd, "intercept");
                        if (!(de3.qw() instanceof UnrepeatableRequestBody)) {
                            th("sameConnection:: ", ddd, "intercept");
                            if (!o(rg2, de3.uk())) {
                                thVar2.ggg();
                                i2 = i4;
                                thVar2 = new th(this.qw.th(), ad(de3.uk()), ad2, de2, this.f5472de);
                                this.f5471ad = thVar2;
                            } else {
                                i2 = i4;
                                if (thVar2.de() != null) {
                                    th("sameConnection IllegalStateException:: Closing the body of  didn't close its backing stream. Bad interceptor?", ddd, "intercept");
                                    throw new IllegalStateException("Closing the body of " + rg2 + " didn't close its backing stream. Bad interceptor?");
                                }
                            }
                            mmm = rg2;
                            i3 = i2;
                            ddd = de3;
                            r13 = 0;
                        } else {
                            th("followUp.body HttpRetryException:: Cannot retry streamed HTTP body: " + rg2.rg(), ddd, "intercept");
                            thVar2.ggg();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", rg2.rg());
                        }
                    } else {
                        int i5 = i4;
                        th("followUpCount ProtocolException:: Too many follow-up requests: " + i5, ddd, "intercept");
                        thVar2.ggg();
                        throw new ProtocolException("Too many follow-up requests: " + i5);
                    }
                } catch (IOException e) {
                    th("followUp IOException:: " + e.toString(), ddd, "intercept");
                    thVar2.ggg();
                    throw e;
                }
            } catch (RouteException e2) {
                if (yj(e2.getLastConnectException(), thVar2, false, ddd)) {
                    th("response RouteException:: continue retry", ddd, "intercept");
                    sb = new StringBuilder();
                    sb.append("get response finally:: ");
                    sb.append(false);
                    th(sb.toString(), ddd, "intercept");
                    r13 = 0;
                } else {
                    th("response RouteException:: " + e2.toString(), ddd, "intercept");
                    throw e2.getFirstConnectException();
                }
            } catch (IOException e3) {
                if (yj(e3, thVar2, !(e3 instanceof ConnectionShutdownException), ddd)) {
                    th("response IOException:: continue retry", ddd, "intercept");
                    sb = new StringBuilder();
                    sb.append("get response finally:: ");
                    sb.append(false);
                    th(sb.toString(), ddd, "intercept");
                    r13 = 0;
                } else {
                    th("response IOException:: " + e3.toString(), ddd, "intercept");
                    throw e3;
                }
            } catch (Throwable th2) {
                th("get response finally:: " + true, ddd, "intercept");
                thVar2.aaa((IOException) null);
                thVar2.ggg();
                throw th2;
            }
        }
        thVar2.ggg();
        th("canceled", ddd, "intercept");
        throw new IOException("Canceled");
    }

    public final boolean o(mmm mmm, Cif ifVar) {
        Cif uk2 = mmm.nn().uk();
        return uk2.m338if().equals(ifVar.m338if()) && uk2.qqq() == ifVar.qqq() && uk2.b().equals(ifVar.b());
    }

    public void pf(Object obj) {
        this.f5472de = obj;
    }

    public void qw() {
        this.f5473fe = true;
        th thVar = this.f5471ad;
        if (thVar != null) {
            thVar.ad();
        }
    }

    public final boolean rg(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean uk(IOException iOException, ddd ddd) {
        return (ddd.qw() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException);
    }

    public final boolean yj(IOException iOException, th thVar, boolean z, ddd ddd) {
        thVar.aaa(iOException);
        th("recover IOException client.retryOnConnectionFailure:: ", ddd, "recover");
        if (!this.qw.c()) {
            return false;
        }
        th("recover IOException requestSendStarted && requestIsUnrepeatable:: " + z + "  ", ddd, "recover");
        if (z && uk(iOException, ddd)) {
            return false;
        }
        th("recover IOException isRecoverable:: ", ddd, "recover");
        if (!rg(iOException, z)) {
            return false;
        }
        th("recover IOException streamAllocation.hasMoreRoutes:: ", ddd, "recover");
        if (!thVar.o()) {
            return false;
        }
        return true;
    }
}
