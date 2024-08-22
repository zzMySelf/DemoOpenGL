package fe.qw.qw.when;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import fe.qw.qw.de;
import fe.qw.qw.yj;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class fe {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public final LottieNetworkFetcher f3535ad;
    @NonNull
    public final de qw;

    public fe(@NonNull de deVar, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.qw = deVar;
        this.f3535ad = lottieNetworkFetcher;
    }

    @WorkerThread
    @NonNull
    public final yj<de> ad(@NonNull String str, @Nullable String str2) {
        fe.qw.qw.ggg.fe.qw("Fetching " + str);
        LottieFetchResult lottieFetchResult = null;
        try {
            lottieFetchResult = this.f3535ad.qw(str);
            if (lottieFetchResult.isSuccessful()) {
                yj<de> fe2 = fe(str, lottieFetchResult.o(), lottieFetchResult.i(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(fe2.ad() != null);
                fe.qw.qw.ggg.fe.qw(sb.toString());
                if (lottieFetchResult != null) {
                    try {
                        lottieFetchResult.close();
                    } catch (IOException e) {
                        fe.qw.qw.ggg.fe.fe("LottieFetchResult close failed ", e);
                    }
                }
                return fe2;
            }
            yj<de> yjVar = new yj<>((Throwable) new IllegalArgumentException(lottieFetchResult.ad()));
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e2) {
                    fe.qw.qw.ggg.fe.fe("LottieFetchResult close failed ", e2);
                }
            }
            return yjVar;
        } catch (Exception e3) {
            yj<de> yjVar2 = new yj<>((Throwable) e3);
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e4) {
                    fe.qw.qw.ggg.fe.fe("LottieFetchResult close failed ", e4);
                }
            }
            return yjVar2;
        } catch (Throwable th2) {
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e5) {
                    fe.qw.qw.ggg.fe.fe("LottieFetchResult close failed ", e5);
                }
            }
            throw th2;
        }
    }

    @WorkerThread
    @NonNull
    public yj<de> de(@NonNull String str, @Nullable String str2) {
        de qw2 = qw(str, str2);
        if (qw2 != null) {
            return new yj<>(qw2);
        }
        fe.qw.qw.ggg.fe.qw("Animation for " + str + " not found in cache. Fetching from network.");
        return ad(str, str2);
    }

    @NonNull
    public final yj<de> fe(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        yj<de> yjVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            fe.qw.qw.ggg.fe.qw("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            yjVar = th(str, inputStream, str3);
        } else {
            fe.qw.qw.ggg.fe.qw("Received json response.");
            fileExtension = FileExtension.JSON;
            yjVar = rg(str, inputStream, str3);
        }
        if (!(str3 == null || yjVar.ad() == null)) {
            this.qw.rg(str, fileExtension);
        }
        return yjVar;
    }

    @WorkerThread
    @Nullable
    public final de qw(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> qw2;
        yj<de> yjVar;
        if (str2 == null || (qw2 = this.qw.qw(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) qw2.first;
        InputStream inputStream = (InputStream) qw2.second;
        if (fileExtension == FileExtension.ZIP) {
            yjVar = fe.qw.qw.fe.ddd(new ZipInputStream(inputStream), str);
        } else {
            yjVar = fe.qw.qw.fe.i(inputStream, str);
        }
        if (yjVar.ad() != null) {
            return yjVar.ad();
        }
        return null;
    }

    @NonNull
    public final yj<de> rg(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return fe.qw.qw.fe.i(inputStream, (String) null);
        }
        return fe.qw.qw.fe.i(new FileInputStream(new File(this.qw.th(str, inputStream, FileExtension.JSON).getAbsolutePath())), str);
    }

    @NonNull
    public final yj<de> th(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return fe.qw.qw.fe.ddd(new ZipInputStream(inputStream), (String) null);
        }
        return fe.qw.qw.fe.ddd(new ZipInputStream(new FileInputStream(this.qw.th(str, inputStream, FileExtension.ZIP))), str);
    }
}
