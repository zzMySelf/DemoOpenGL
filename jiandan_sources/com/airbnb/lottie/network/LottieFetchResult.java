package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public interface LottieFetchResult extends Closeable {
    @Nullable
    String ad();

    @Nullable
    String i();

    boolean isSuccessful();

    @NonNull
    InputStream o() throws IOException;
}
