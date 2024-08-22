package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.IOException;

public interface LottieNetworkFetcher {
    @WorkerThread
    @NonNull
    LottieFetchResult qw(@NonNull String str) throws IOException;
}
