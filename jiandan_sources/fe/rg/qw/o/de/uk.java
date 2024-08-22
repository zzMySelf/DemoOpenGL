package fe.rg.qw.o.de;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import fe.rg.qw.ggg.fe;
import fe.rg.qw.o.rg.de;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class uk implements DataFetcher<InputStream> {
    @VisibleForTesting

    /* renamed from: pf  reason: collision with root package name */
    public static final ad f4745pf = new qw();

    /* renamed from: ad  reason: collision with root package name */
    public final de f4746ad;

    /* renamed from: i  reason: collision with root package name */
    public InputStream f4747i;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f4748o;

    /* renamed from: th  reason: collision with root package name */
    public final int f4749th;

    /* renamed from: uk  reason: collision with root package name */
    public HttpURLConnection f4750uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ad f4751yj;

    public interface ad {
        HttpURLConnection qw(URL url) throws IOException;
    }

    public static class qw implements ad {
        public HttpURLConnection qw(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public uk(de deVar, int i2) {
        this(deVar, i2, f4745pf);
    }

    public static boolean rg(int i2) {
        return i2 / 100 == 2;
    }

    public static boolean yj(int i2) {
        return i2 / 100 == 3;
    }

    public void ad() {
        InputStream inputStream = this.f4747i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4750uk;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4750uk = null;
    }

    public void cancel() {
        this.f4748o = true;
    }

    public final InputStream de(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f4747i = fe.rg.qw.ggg.ad.de(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
            }
            this.f4747i = httpURLConnection.getInputStream();
        }
        return this.f4747i;
    }

    @NonNull
    public DataSource fe() {
        return DataSource.REMOTE;
    }

    @NonNull
    public Class<InputStream> qw() {
        return InputStream.class;
    }

    public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long ad2 = fe.ad();
        try {
            dataCallback.rg(uk(this.f4746ad.uk(), 0, (URL) null, this.f4746ad.rg()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(fe.qw(ad2));
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
                "Finished http url fetcher fetch in " + fe.qw(ad2);
            }
            throw th2;
        }
    }

    public final InputStream uk(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f4750uk = this.f4751yj.qw(url);
            for (Map.Entry next : map.entrySet()) {
                this.f4750uk.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f4750uk.setConnectTimeout(this.f4749th);
            this.f4750uk.setReadTimeout(this.f4749th);
            this.f4750uk.setUseCaches(false);
            this.f4750uk.setDoInput(true);
            this.f4750uk.setInstanceFollowRedirects(false);
            this.f4750uk.connect();
            this.f4747i = this.f4750uk.getInputStream();
            if (this.f4748o) {
                return null;
            }
            int responseCode = this.f4750uk.getResponseCode();
            if (rg(responseCode)) {
                return de(this.f4750uk);
            }
            if (yj(responseCode)) {
                String headerField = this.f4750uk.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    ad();
                    return uk(url3, i2 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f4750uk.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @VisibleForTesting
    public uk(de deVar, int i2, ad adVar) {
        this.f4746ad = deVar;
        this.f4749th = i2;
        this.f4751yj = adVar;
    }
}
