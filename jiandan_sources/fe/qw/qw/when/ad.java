package fe.qw.qw.when;

import androidx.annotation.NonNull;
import androidx.browser.trusted.sharing.ShareTarget;
import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ad implements LottieNetworkFetcher {
    @NonNull
    public LottieFetchResult qw(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        httpURLConnection.connect();
        return new qw(httpURLConnection);
    }
}
