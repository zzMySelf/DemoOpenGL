package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import fe.rg.qw.o.rg.i;
import fe.rg.qw.ppp.de;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    public final DataDecoder<Data> qw;

    public interface DataDecoder<Data> {
        void ad(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;

        Class<Data> qw();
    }

    public static final class ad<Model> implements ModelLoaderFactory<Model, InputStream> {
        public final DataDecoder<InputStream> qw = new qw(this);

        public class qw implements DataDecoder<InputStream> {
            public qw(ad adVar) {
            }

            /* renamed from: de */
            public void ad(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: fe */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }

            public Class<InputStream> qw() {
                return InputStream.class;
            }
        }

        @NonNull
        public ModelLoader<Model, InputStream> ad(@NonNull i iVar) {
            return new DataUrlLoader(this.qw);
        }
    }

    public static final class qw<Data> implements DataFetcher<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final String f3702ad;

        /* renamed from: th  reason: collision with root package name */
        public final DataDecoder<Data> f3703th;

        /* renamed from: yj  reason: collision with root package name */
        public Data f3704yj;

        public qw(String str, DataDecoder<Data> dataDecoder) {
            this.f3702ad = str;
            this.f3703th = dataDecoder;
        }

        public void ad() {
            try {
                this.f3703th.ad(this.f3704yj);
            } catch (IOException unused) {
            }
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<Data> qw() {
            return this.f3703th.qw();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data decode = this.f3703th.decode(this.f3702ad);
                this.f3704yj = decode;
                dataCallback.rg(decode);
            } catch (IllegalArgumentException e) {
                dataCallback.de(e);
            }
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.qw = dataDecoder;
    }

    public ModelLoader.qw<Data> ad(@NonNull Model model, int i2, int i3, @NonNull fe.rg.qw.o.ad adVar) {
        return new ModelLoader.qw<>(new de(model), new qw(model.toString(), this.qw));
    }

    public boolean qw(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
