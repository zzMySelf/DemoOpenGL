package com.dxmbumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.data.DataFetcher;
import com.dxmbumptech.glide.load.model.ModelLoader;
import fe.uk.qw.pf.rg.i;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    public final Converter<Data> qw;

    public interface Converter<Data> {
        Data ad(byte[] bArr);

        Class<Data> qw();
    }

    public static class ad<Data> implements DataFetcher<Data> {

        /* renamed from: ad  reason: collision with root package name */
        public final byte[] f3870ad;

        /* renamed from: th  reason: collision with root package name */
        public final Converter<Data> f3871th;

        public ad(byte[] bArr, Converter<Data> converter) {
            this.f3870ad = bArr;
            this.f3871th = converter;
        }

        public void ad() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource fe() {
            return DataSource.LOCAL;
        }

        @NonNull
        public Class<Data> qw() {
            return this.f3871th.qw();
        }

        public void th(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.rg(this.f3871th.ad(this.f3870ad));
        }
    }

    public static class de implements ModelLoaderFactory<byte[], InputStream> {

        public class qw implements Converter<InputStream> {
            public qw(de deVar) {
            }

            /* renamed from: de */
            public InputStream ad(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            public Class<InputStream> qw() {
                return InputStream.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], InputStream> ad(@NonNull i iVar) {
            return new ByteArrayLoader(new qw(this));
        }
    }

    public static class qw implements ModelLoaderFactory<byte[], ByteBuffer> {

        /* renamed from: com.dxmbumptech.glide.load.model.ByteArrayLoader$qw$qw  reason: collision with other inner class name */
        public class C0179qw implements Converter<ByteBuffer> {
            public C0179qw(qw qwVar) {
            }

            /* renamed from: de */
            public ByteBuffer ad(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            public Class<ByteBuffer> qw() {
                return ByteBuffer.class;
            }
        }

        @NonNull
        public ModelLoader<byte[], ByteBuffer> ad(@NonNull i iVar) {
            return new ByteArrayLoader(new C0179qw(this));
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.qw = converter;
    }

    /* renamed from: de */
    public ModelLoader.qw<Data> ad(@NonNull byte[] bArr, int i2, int i3, @NonNull fe.uk.qw.pf.ad adVar) {
        return new ModelLoader.qw<>(new fe.uk.qw.ggg.ad(bArr), new ad(bArr, this.qw));
    }

    /* renamed from: fe */
    public boolean qw(@NonNull byte[] bArr) {
        return true;
    }
}
