package fe.qw.qw.when;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.network.LottieFetchResult;
import fe.qw.qw.ggg.fe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.apache.commons.lang3.StringUtils;

public class qw implements LottieFetchResult {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public final HttpURLConnection f3536ad;

    public qw(@NonNull HttpURLConnection httpURLConnection) {
        this.f3536ad = httpURLConnection;
    }

    @Nullable
    public String ad() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f3536ad.getURL() + ". Failed with " + this.f3536ad.getResponseCode() + StringUtils.LF + qw(this.f3536ad);
        } catch (IOException e) {
            fe.fe("get error failed ", e);
            return e.getMessage();
        }
    }

    public void close() {
        this.f3536ad.disconnect();
    }

    @Nullable
    public String i() {
        return this.f3536ad.getContentType();
    }

    public boolean isSuccessful() {
        try {
            return this.f3536ad.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @NonNull
    public InputStream o() throws IOException {
        return this.f3536ad.getInputStream();
    }

    public final String qw(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th2;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
