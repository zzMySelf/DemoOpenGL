package com.dxmbumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.i;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class qw<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final List<Key> f3878ad;

        /* renamed from: de  reason: collision with root package name */
        public final DataFetcher<Data> f3879de;
        public final Key qw;

        public qw(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public qw(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            i.fe(key);
            this.qw = key;
            i.fe(list);
            this.f3878ad = list;
            i.fe(dataFetcher);
            this.f3879de = dataFetcher;
        }
    }

    @Nullable
    qw<Data> ad(@NonNull Model model, int i2, int i3, @NonNull ad adVar);

    boolean qw(@NonNull Model model);
}
