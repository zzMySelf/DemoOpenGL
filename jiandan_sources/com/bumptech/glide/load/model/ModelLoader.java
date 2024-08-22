package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.ad;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class qw<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final List<Key> f3708ad;

        /* renamed from: de  reason: collision with root package name */
        public final DataFetcher<Data> f3709de;
        public final Key qw;

        public qw(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public qw(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            uk.fe(key);
            this.qw = key;
            uk.fe(list);
            this.f3708ad = list;
            uk.fe(dataFetcher);
            this.f3709de = dataFetcher;
        }
    }

    @Nullable
    qw<Data> ad(@NonNull Model model, int i2, int i3, @NonNull ad adVar);

    boolean qw(@NonNull Model model);
}
