package fe.uk.qw.pf.de;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.HttpException;
import com.dxmbumptech.glide.load.data.DataFetcher;
import fe.uk.qw.pf.rg.de;
import fe.uk.qw.vvv.rg;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class uk implements DataFetcher<InputStream> {
    @VisibleForTesting

    /* renamed from: pf  reason: collision with root package name */
    public static final ad f5702pf = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final de f5703ad;

    /* renamed from: i  reason: collision with root package name */
    public InputStream f5704i;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f5705o;

    /* renamed from: th  reason: collision with root package name */
    public final int f5706th;

    /* renamed from: uk  reason: collision with root package name */
    public HttpURLConnection f5707uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ad f5708yj;

    public interface ad {
        HttpURLConnection qw(URL url) throws IOException;
    }

    public static class qw implements ad {
        public HttpURLConnection qw(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public uk(de deVar, int i2) {
        this(deVar, i2, f5702pf);
    }

    public static boolean i(int i2) {
        return i2 / 100 == 3;
    }

    public static int rg(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("HttpUrlFetcher", 3);
            return -1;
        }
    }

    public static boolean uk(int i2) {
        return i2 / 100 == 2;
    }

    public void ad() {
        InputStream inputStream = this.f5704i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f5707uk;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f5707uk = null;
    }

    public void cancel() {
        this.f5705o = true;
    }

    public final HttpURLConnection de(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection qw2 = this.f5708yj.qw(url);
            for (Map.Entry next : map.entrySet()) {
                qw2.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            qw2.setConnectTimeout(this.f5706th);
            qw2.setReadTimeout(this.f5706th);
            qw2.setUseCaches(false);
            qw2.setDoInput(true);
            qw2.setInstanceFollowRedirects(false);
            return qw2;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    @NonNull
    public DataSource fe() {
        return DataSource.REMOTE;
    }

    public final InputStream o(URL url, int i2, URL url2, Map<String, String> map) throws HttpException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection de2 = de(url, map);
            this.f5707uk = de2;
            try {
                de2.connect();
                this.f5704i = this.f5707uk.getInputStream();
                if (this.f5705o) {
                    return null;
                }
                int rg2 = rg(this.f5707uk);
                if (uk(rg2)) {
                    return yj(this.f5707uk);
                }
                if (i(rg2)) {
                    String headerField = this.f5707uk.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            ad();
                            return o(url3, i2 + 1, url, map);
                        } catch (MalformedURLException e) {
                            throw new HttpException("Bad redirect url: " + headerField, rg2, e);
                        }
                    } else {
                        throw new HttpException("Received empty or null redirect url", rg2);
                    }
                } else if (rg2 == -1) {
                    throw new HttpException(rg2);
                } else {
                    try {
                        throw new HttpException(this.f5707uk.getResponseMessage(), rg2);
                    } catch (IOException e2) {
                        throw new HttpException("Failed to get a response message", rg2, e2);
                    }
                }
            } catch (IOException e3) {
                throw new HttpException("Failed to connect or obtain data", rg(this.f5707uk), e3);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
    }

    @NonNull
    public Class<InputStream> qw() {
        return InputStream.class;
    }

    public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long ad2 = rg.ad();
        try {
            dataCallback.rg(o(this.f5703ad.uk(), 0, (URL) null, this.f5703ad.rg()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(rg.qw(ad2));
                sb.toString();
            }
        } catch (IOException e) {
            boolean isLoggable = Log.isLoggable("HttpUrlFetcher", 3);
            dataCallback.de(e);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                "Finished http url fetcher fetch in " + rg.qw(ad2);
            }
            throw th2;
        }
    }

    public final InputStream yj(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f5704i = fe.uk.qw.vvv.ad.de(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
                }
                this.f5704i = httpURLConnection.getInputStream();
            }
            return this.f5704i;
        } catch (IOException e) {
            throw new HttpException("Failed to obtain InputStream", rg(httpURLConnection), e);
        }
    }

    @VisibleForTesting
    public uk(de deVar, int i2, ad adVar) {
        this.f5703ad = deVar;
        this.f5706th = i2;
        this.f5708yj = adVar;
    }
}
